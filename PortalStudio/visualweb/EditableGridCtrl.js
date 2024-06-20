// http://laurens.vd.oever.nl/weblog/items2005/closures/
Function.prototype.closure = function(obj){
  // Init object storage.
  if (!window.__objs){
    window.__objs = [];
    window.__funs = [];
  }
  // For symmetry and clarity.
  var fun = this;
  // Make sure the object has an id and is stored in the object store.
  var objId = obj.__objId;
  if (!objId) __objs[objId = obj.__objId = __objs.length] = obj;
  // Make sure the function has an id and is stored in the function store.
  var funId = fun.__funId;
  if (!funId) __funs[funId = fun.__funId = __funs.length] = fun;
  // Init closure storage.
  if (!obj.__closures) obj.__closures = [];
  // See if we previously created a closure for this object/function pair.
  var closure = obj.__closures[funId];
  if (closure) return closure;
  // Clear references to keep them out of the closure scope.
  obj = null;
  fun = null;
  // Create the closure, store in cache and return result.
  return __objs[objId].__closures[funId] = function(){
    return __funs[funId].apply(__objs[objId], arguments);
  };
};

Z.EditableGrid=Base.extend({
	configuration: {
		clrHilight: 'internobianco', // class used for hilighting a selected row
		clrRowEven: 'internobianco', // class used for the even rows
		clrRowOdd: 'internobianco', // class used for the odd rows
		blnPointToSelect: true, // Set this to false if you want 'click to select' and 'doubleclick to Edit' mode
		strNoImage: "noSort.gif", // Full path of the image used to indicate that the row is not sorted.
		strUpImage: "up.gif", // Full path of the up image used on sort asc
		strDownImage: "down.gif", // Full path of the up image used on sort desc
		intImgWidth: 8, // The width of the images used to indicate the asc/des sort
		intImgHeight: 10 // The height of the images used to indicate the asc/des sort
	},
	data:{},
	constructor:function(configuration, data){
		this.configuration=Z.Merge(this.configuration, configuration||{});
		this.data=Z.Merge({}, data||{} );
	},

	//globals
	objLastClick: -1,
	blnReverse: false, // Stores the flag used by sort
	blnMouseOver: false, // Stores the flag used by capturemouse
	objDivToMove: null, // Stores the div being moved
	intColCount: 0, // Stores the number of coloumns
	objRowSelected: null, // Stores the row element currently selected
	clrRowSelected: '', // Store the original color of the selected row
	objTable: null, //THE element which holds the table...

	//functions
	buildTable: function (){
		var tbl=document.createElement("TABLE");
		tbl.style.width='100%';
		this.objTable=tbl;
		tbl.id=this.data.id;
		var thead=tbl.createTHead();
		var trow=thead.insertRow(0);
		for(var i=0, title,cell; title=this.data.titles[i++];){ // eslint-disable-line no-cond-assign
			cell=trow.insertCell(trow.cells.length);
			cell.innerHTML=title;
      cell.className="titoli"
		}
		if(tbl.tBodies.length==0)
			tbl.appendChild(document.createElement('TBODY'));
		var datarow;
		for(var dataref in this.data.rows.Keys()){
			datarow=this.data.rows[dataref];
			this.addRow(datarow).setAttribute('datarow',dataref);
		}
		return tbl;
	},
	addRow: function(datarow){
		if(!datarow)
			datarow=[].concat(this.data.blank);
		var row=document.createElement("TR");
		for(var i=0, l=datarow.length, cell, cellTxt; i<l; i++){
  	  cellTxt = datarow[i];
			cell = document.createElement("TD");
			cell.innerHTML = cellTxt=='' ? '&nbsp;' : ToHTML(cellTxt);
			cell.setAttribute("TCType",this.data.options[i].type);
      if(!Empty(this.data.options[i].callFunc))
        cell.setAttribute("callFunc",this.data.options[i].callFunc);
      cell.setAttribute("btnEdit",'false');
      if(this.data.options[i].btnEdit==null && i==0)
        cell.setAttribute("btnEdit",'true');
			if(this.data.options[i].btnEdit!=null)
        cell.setAttribute("btnEdit",this.data.options[i].btnEdit);
      cell.setAttribute("dataoptions",i);
      cell.setAttribute("class","internobianco")
      cell.style.padding='2px';
			row.appendChild(cell);
		}
		var objTBody = this.objTable.tBodies[0];
		objTBody.appendChild(row);
		var cfg=this.configuration;
		row.className = objTBody.rows.length%2 ? cfg.clrRowOdd : cfg.clrRowEven;    // \
		return row;
		//resizeDivs ();
	},
	init: function(){
		this.objTable=Ctrl(this.data.id);
		if(this.objTable==null)
			return alert("Error: Not able to get table element ");
		if (this.objTable.tagName!='TABLE')
			return alert("Error: Not able to control element " + this.objTable.tagName);

		this.removeTextNodes(this.objTable.tBodies[0]);//+Stefano

		if (this.blnPointToSelect){
      LibJavascript.Events.addEvent(this.objTable, 'mouseover',  this.selectRow_evt.closure(this));
      LibJavascript.Events.addEvent(this.objTable, 'click',  this.onClickCell.closure(this));
		}else{
      LibJavascript.Events.addEvent(this.objTable, 'click',  this.selectRow_evt.closure(this));
      LibJavascript.Events.addEvent(this.objTable, 'dblclick',  this.onClickCell.closure(this));
		}
		this.objTable.focus();
	},
	removeTextNodes: function(t){
		for (var i=0, child; child=t.childNodes[i++];){ // eslint-disable-line no-cond-assign
			if (!child.tagName)
				child.parentNode.removeChild(child);
			else
				for (var j=0, child2; child2=child.childNodes[j++];) // eslint-disable-line no-cond-assign
					if (!child2.tagName)
						child2.parentNode.removeChild(child2);
		}
	},
	initRowColours: function(){
		var cfg=this.configuration;
		for (var i=0, row, objTBody=this.objTable.tBodies[0]; row=objTBody.rows[i]; i++) // eslint-disable-line no-cond-assign
			row.className = i%2 ? cfg.clrRowEven : cfg.clrRowOdd;
	},
	selectRow_evt: function(e){
		this.selectRow(this.getEventRow(e).rowIndex);
	},
	selectRow: function(rowNum){
		var srcElem = this.objTable.rows[rowNum];
		if(!srcElem || srcElem.tagName != "TR") return;
    var selectedInput=null;
    if(this.objRowSelected){
      var ele=this.objRowSelected.cells[0];
      while(ele.firstChild){
        ele=ele.firstChild;
        if(ele.tagName=='INPUT' || ele.tagName=='SELECT'){selectedInput=ele;break;}
      }
    }
		if(this.objRowSelected && this.objRowSelected != srcElem && this.objRowSelected.cells[0] && selectedInput!=null &&
			 (selectedInput.tagName=='INPUT' || selectedInput.tagName=='SELECT'))
			this.saveRow(this.objRowSelected,true);
		if(this.objRowSelected){
			this.objRowSelected.className = this.clrRowSelected;
			this.objRowSelected = null;
		}
		if(srcElem.rowIndex > 0){
			this.clrRowSelected = srcElem.className;
			srcElem.className = this.configuration.clrHilight;
			this.objRowSelected = srcElem;
		}
	},
	getEventRow: function(e){
		var srcElem = GetEventSrcElement(e);
		while (srcElem.tagName != "TR" && srcElem.tagName != "TABLE"){
			srcElem = srcElem.parentNode;
		}
		return srcElem;
	},
	onClickCell: function(e){
		var srcElem = this.getEventRow(e);
		if(srcElem.tagName != "TR") return;
		/*Stefano
		if(srcElem.rowIndex == 0) sort ();
		*/
		if(srcElem.rowIndex == 0) return;
		else
			this.onEdit(srcElem, this.getEventCell(e));
	},
	onEdit: function(row, srcCell){
		var objInput;
		for(var i=0, cells=row.cells, cell, input; cell=cells[i++];){ // eslint-disable-line no-cond-assign
			input = this.inputizeCell(cell);
			if(i==1 || cell==srcCell)
				objInput=input;
		}
		if(objInput)
			objInput.focus();
	},
	getEventCell: function(e){
		var srcElem = GetEventSrcElement(e);
		while (srcElem.tagName != "TD" && srcElem.tagName != "TABLE"){
			srcElem = srcElem.parentNode;
		}
		return srcElem;
	},
	inputizeCell: function(srcElem){
		var objInput_container = document.createElement ("DIV");
		var objInput = document.createElement ("INPUT");
    var objInputEdit = document.createElement ("INPUT");
		var datarow;
		if(srcElem.parentNode.getAttribute('datarow') in this.data.rows)
			datarow = this.data.rows[srcElem.parentNode.getAttribute('datarow')];
		else{
			datarow = [].concat(this.data.blank);
			srcElem.parentNode.setAttribute('datarow',this.data.rows.Add(datarow));
		}
		var optIdx=srcElem.getAttribute("dataoptions");
		var txtOld = datarow[optIdx];
		srcElem.innerHTML = "";
    var type=srcElem.getAttribute("TCType");
    var callFunc=srcElem.getAttribute("callFunc");
		switch (type){
			case 'combobox':
				objInput = document.createElement('SELECT');
				var selIdx=0;
				for(var i=0, opt, opts=this.data.options[optIdx].values, l=opts.length; i<l; i++ ){
					opt=opts[i];
					if(opt==txtOld)
						selIdx=objInput.options.length;
					objInput.options[objInput.options.length] = new Option(opt,opt);
				}
				objInput.selectedIndex=selIdx;
				break;
			case 'textbox':
			default:
				objInput.setAttribute ("id","input_"+optIdx);
				objInput.setAttribute ("type", "TEXT");
				objInput.setAttribute ("value" , txtOld);
        objInputEdit.setAttribute ("type", "BUTTON");
				objInputEdit.setAttribute ("value" , "?");
        if(typeof(callFunc)!='undefined' && !Empty(callFunc))
          LibJavascript.Events.addEvent(objInputEdit, 'click',  new Function("",callFunc+"('"+"input_"+optIdx+"')"));
				break;
		}
    LibJavascript.Events.addEvent(objInput, 'keydown',  this.checkForEnterEsc.closure(this))
		objInput.style.width = "100%";
    objInput.style.boxSizing='border-box';
    objInput.style.MozBoxSizing='border-box';
    objInput.style.webkitBoxSizing='border-box';
		objInput_container.appendChild(objInput);
		srcElem.appendChild(objInput_container);


    if(window.SelectParameter && this.data.id=='parameters' && srcElem.getAttribute("btnEdit")=='true'){
      objInput.style.width = "90%";
      objInputEdit.style.width = "7%";
      objInput_container.appendChild(objInputEdit);
    }
		return objInput;
	},
	checkForEnterEsc: function(e){
		switch(GetKeyCode(e)){
			case 13: //Enter
				this.saveRow(this.getEventRow(e), true);
				break;
			case 27: case 0: //Esc (FF 1.5.0.2 e.which risulta 0)
				this.saveRow(this.getEventRow(e), false);
				break;
		}
	},
	saveRow: function(row,setFromValue){
		var datarow=this.data.rows[row.getAttribute('datarow')];
    if(!Empty(datarow))
      for(var i=0, cell,objSrcElm, cells=row.cells; cell=cells[i]; i++){ // eslint-disable-line no-cond-assign
        var ele=cell;
        while(ele.firstChild){
          ele=ele.firstChild;
          if(ele.tagName=='INPUT' || ele.tagName=='SELECT'){objSrcElm=ele;break;}
        }
        if(objSrcElm!=null)
          if(setFromValue && ('value' in objSrcElm)){
            var txtNew = datarow[i] = objSrcElm.value;
            switch (this.data.options[i].type){
              case "combobox":
              case "textbox":
			  case "checkbox":
              default:
                objSrcElm.parentNode.innerHTML =  ToHTML(txtNew);
                break;
            }
          }else{
            objSrcElm.parentNode.innerHTML = datarow[i]==''?'&nbsp;':ToHTML(datarow[i]);
          }
      }
	},
	captureKeys: function(e){
		if (!this.objRowSelected) return;
		var srcElem = GetEventSrcElement(e);
		if (srcElem.tagName == "INPUT") return;
		switch (GetKeyCode(e)){
			case 38: //38 - Up
				this.objRowSelected.className = this.clrRowSelected;
				if(this.getNextRow(this.objRowSelected))
					this.objRowSelected = this.getNextRow(this.objRowSelected);
				this.clrRowSelected = this.objRowSelected.className;
				this.objRowSelected.className = this.configuration.clrHilight;
				break;
			case 40: //40 - Down
				this.objRowSelected.className = this.clrRowSelected;
				if(this.getPrevRow(this.objRowSelected))
					this.objRowSelected = this.getPrevRow(this.objRowSelected);
				this.clrRowSelected = this.objRowSelected.className;
				this.objRowSelected.className = this.configuration.clrHilight;
				break;
			case 46: //46 - Delete
				var oldRow = this.objRowSelected;
				if(this.getNextRow(oldRow))
					this.objRowSelected = this.getNextRow(oldRow);
				else if(this.getPrevRow(oldRow))
					this.objRowSelected = this.getPrevRow(oldRow);
				else
					this.objRowSelected = null;
				if (this.objRowSelected != null)
					this.objRowSelected.className = this.configuration.clrHilight;
				this.deleteRow(oldRow.rowIndex - 1);
				break;
			case 13: //13 - Enter
				if(this.objRowSelected)
					this.onEdit(this.objRowSelected);
					return false
				break;
		}
	},
	getNextRow: function(elm){
		if (elm.rowIndex > 1) return elm.parentNode.childNodes[elm.rowIndex - 2];
		else return null;
	},
	getPrevRow: function(elm){
		return elm.parentNode.childNodes[elm.rowIndex];
	},
	deleteRow: function(rowNum){
		var tbody = this.objTable.tBodies[0];
		if(!rowNum && this.objRowSelected)
			rowNum=this.objRowSelected.rowIndex-1;
		if(!tbody || rowNum < 0 || this.objRowSelected==null) return;

		this.removeTextNodes(tbody);

		var remNode;
		if(remNode=tbody.removeChild(tbody.childNodes[rowNum])){ // eslint-disable-line no-cond-assign
			this.data.rows.Remove(remNode.getAttribute('datarow'));
		}
		this.initRowColours();	//So that similar colored rows dont end up together after delete.
		this.clrRowSelected = this.objRowSelected.className;	//Save the color only after repainting all the rows
		if(rowNum!=0)
			if(tbody.rows.length==rowNum)
				this.selectRow(rowNum);
			else
				this.selectRow(rowNum+1);
		else if(tbody.rows.length>0)
			this.selectRow(rowNum+1);
	},
	selectLastRow: function(){
		var idx=this.objTable.tBodies[0].rows.length;
		this.selectRow(idx)
	},
	editSelectedRow: function(){
		if(this.objRowSelected && this.objRowSelected.parentNode)
			this.onEdit(this.objRowSelected);
	}
});
