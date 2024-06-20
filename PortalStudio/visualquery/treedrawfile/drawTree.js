/*
N.B. Classe legata agli elementi della JSP
Dipende da:
albertoMisto
alberoVerticale
alberoClassico

Descrizione:
La classe definisce alcune costanti e poi fornisce delle funzionalita' per disegnare la tipologia di albero selezionato.

Metodi:
dimensioneCanvas <---- senza this.
init
crea <---- senza this.
ridisegnaAlbero

Membri:
_lunghezzaNodoStandard,
_altezzaNodoStandard,
_spazioStandard,
_JSONOriginale,
_creatorGraphicalObject,
_modalitaDisegnata,
_tipoDisegno;
 */

/* exported CreaAlbero _drawTree */
function CreaAlbero () {
	var _lunghezzaNodoStandard = 130,
	_altezzaNodoStandard = 94,
	_spazioStandard = 15,
	_JSONOriginale,
	_treeObj=[],
	_creatorGraphicalObject,
	_tipoDisegno,
	_raphaelZPDAdapter,
	_indexHiddenAncestors=[];
	_drawTree=this;
	_indexHiddenAncestors[0]=0;

	//per calcolare dimensione che il canvas dovra' avere, usata solo se browser supporta SVG
	var dimensioneCanvas = function (obj) {
		var dimCanvasX = 0,
		dimCanvasY = 0;

		if(window.innerWidth && window.innerHeight) {
			dimCanvasX = window.innerWidth+125;
			dimCanvasY = window.innerHeight;
		}
		if(obj.offsetParent) {
			do {
				dimCanvasX -= obj.offsetLeft+105;
				dimCanvasY -= obj.offsetTop;
				obj = obj.offsetParent;
			} while (obj); //l'elemento e' contenuto in un altro
		}
		else {
			alert("Non posso calcolare offset");
		}


		return [dimCanvasX-33, dimCanvasY-30];
	}

	//questo costruttore inizializza il JSON
	this.init = function (JSon) {
		if(JSon.nome && !_JSONOriginale) { //inizializzo il JSON se e solo se il parametro e' corretto e non e' gia' inizializzato
			_JSONOriginale = JSon;
		}
	}

	this.hideSubTree=function(index){
		_treeObj[index].hiddenChild=!_treeObj[index].hiddenChild;
		if(document.implementation.hasFeature("http://www.w3.org/TR/SVG11/feature#BasicStructure", "1.1")) {
			var matrix=_raphaelZPDAdapter.getCTM();
			_this.ridisegnaAlbero('choiceMenu','spazioPerGrafico',false)
			_raphaelZPDAdapter.setCTM(matrix,true);
			_raphaelZPDAdapter.createScrollbar();
		}
		else _this.ridisegnaAlbero('choiceMenu','spazioPerGrafico',false)
	}

	this.hideAncestors=function(index){
		var indexOf=_indexHiddenAncestors.indexOf(index)
		if (indexOf==-1) // non c'è -> lo inserisco
			_indexHiddenAncestors[_indexHiddenAncestors.length]=index;
		else _indexHiddenAncestors.splice(indexOf,1);


		if(document.implementation.hasFeature("http://www.w3.org/TR/SVG11/feature#BasicStructure", "1.1")) {
			var matrix=_raphaelZPDAdapter.getCTM();
			_this.ridisegnaAlbero('choiceMenu','spazioPerGrafico',false)
			_raphaelZPDAdapter.setCTM(matrix,true);
			_raphaelZPDAdapter.createScrollbar();
		}
		else _this.ridisegnaAlbero('choiceMenu','spazioPerGrafico',false)
	}

	this.createArrayTree=function(Json){

		var color = Json.color;

		if(color=='green') this.green+=1;
		else if(color=='yellow') this.yellow+=1;
		else if(color=='red') this.red+=1;
		else if(color=='blue') this.blue+=1;
		else if(color=='pink') this.pink+=1;
		else this.gray+=1;

		var node={},
		index=_treeObj.length;
		node.hiddenChild=false; //non ha figli nascosti
		node.hidden=false; // il nodo non è nascosto (utile quando si nascondono gli antenati)
		if (Json.figli){
			node.allChild=Json.figli.length; //figli diretti + nipoti.. ecc
			_treeObj[index]=node;
			for (var i=0;i<Json.figli.length;i++){
				_treeObj[index].allChild+=this.createArrayTree(Json.figli[i]);
			}
			return _treeObj[index].allChild;
		}
		else {
			node.allChild=0;
			_treeObj[index]=node;
			return 0;
		}
	}


	function searchJson(firstIndex){
		var json=_JSONOriginale,indexArray=0;

		while(firstIndex!=indexArray){
			var find=false;
			var numFigli=0;
			if (json.figli)
				numFigli=json.figli.length;
			for (var i=0; i<numFigli && firstIndex!=indexArray && !find;i++){

				//trovo l'indice del figlio i-esimo
				if (i==0)
					indexArray=indexArray+1;
				else
					indexArray+=_treeObj[indexArray].allChild+1;
				if (!find && _treeObj[indexArray].allChild+indexArray>=firstIndex){ //indexArray??
					json=json.figli[i];
					find=true;
					index++;
				}
				else
					index+=_treeObj[indexArray].allChild+2;
			}
		}
		return json;
	}


	//disegna l'albero della modalita'  scelta.
	var crea = function(choice) {
		if (!_indexHiddenAncestors || _indexHiddenAncestors.length==0){
			_indexHiddenAncestors=[];
			_indexHiddenAncestors[0]=0;
		}
		switch(choice) {
		case "Misto":
			_tipoDisegno = new albertoMisto();
			_tipoDisegno.creaRadice(searchJson(_indexHiddenAncestors[_indexHiddenAncestors.length-1]), _creatorGraphicalObject, _lunghezzaNodoStandard, _altezzaNodoStandard, _spazioStandard,_treeObj,_indexHiddenAncestors[_indexHiddenAncestors.length-1]);
			break;

		case "Verticale":
			_tipoDisegno = new alberoVerticale();
			_tipoDisegno.creaRadice(searchJson(_indexHiddenAncestors[_indexHiddenAncestors.length-1]), _creatorGraphicalObject, _lunghezzaNodoStandard, _altezzaNodoStandard, _spazioStandard,_treeObj,_indexHiddenAncestors[_indexHiddenAncestors.length-1]);
			break;

		case "Classico":
			_tipoDisegno = new alberoClassico();

			_tipoDisegno.creaRadice(searchJson(_indexHiddenAncestors[_indexHiddenAncestors.length-1]), _creatorGraphicalObject, _lunghezzaNodoStandard, _altezzaNodoStandard, _spazioStandard,_treeObj,_indexHiddenAncestors[_indexHiddenAncestors.length-1]);

			break;
		}

	}

	//cancella e richiama crea con la modalita' scelta


	var _this=this;
	this.ridisegnaAlbero = function(idMenu, nomeId, createArray) {

		if (createArray){
			// costruisco l'array corrispondente all'albero dell'oggetto Json
			_treeObj=[];
			this.createArrayTree(_JSONOriginale);
			//this.printColors();
			_treeObj[0].hidden=true;
			_indexHiddenAncestors=[];
			_indexHiddenAncestors[0]=0;
		}

		var scrollY=document.getElementById('scrollbarVertical');
		scrollY.style.height=0;
		var dim;
		var indiceElementoScelto = document.getElementById(idMenu).selectedIndex;
		var modalitaScelta = document.getElementById(idMenu).options[indiceElementoScelto].value;

		if(_creatorGraphicalObject && _tipoDisegno) {

			_tipoDisegno.cancellaAlbero();
			_creatorGraphicalObject.ripulisci();
			_creatorGraphicalObject = null;
		}
		if(!_creatorGraphicalObject) {
			_creatorGraphicalObject = new RaphaelAdapter();
			_creatorGraphicalObject.createCanvas(nomeId);
			if(document.implementation.hasFeature("http://www.w3.org/TR/SVG11/feature#BasicStructure", "1.1")) {
				dim = dimensioneCanvas(document.getElementById(nomeId));

				_creatorGraphicalObject.resizeCanvas(dim[0], dim[1]);
				window.onresize = function() {
					_this.ridisegnaAlbero('choiceMenu','spazioPerGrafico',false)
				}
				// se non è IE8 allora funziona il pan
				var corpo = document.getElementsByTagName("body");
				corpo[0].style.overflow = "hidden";
				if (_raphaelZPDAdapter)
					_raphaelZPDAdapter.deleteScrollbar();
				_raphaelZPDAdapter=new RaphaelZPDAdapter();
				_raphaelZPDAdapter.init(_creatorGraphicalObject.getCanvas(),nomeId, true, true, true); // paper, id, zoom, pan, scrollbar

				dim = dimensioneCanvas(document.getElementById(nomeId));

				var grafico=document.getElementById(nomeId);
				grafico.style.width=dim[0]+'px';
				grafico.style.height=dim[1]+'px';
				_creatorGraphicalObject.resizeCanvas(dim[0], dim[1]);
			}

		}
		crea(modalitaScelta);
		if(document.implementation.hasFeature("http://www.w3.org/TR/SVG11/feature#BasicStructure", "1.1")) {
			var size=_tipoDisegno.getSize();
			_raphaelZPDAdapter.setSizeTree(size,dim);
		}
	}
	this.zoomTree=function(value){
		var stub;
		if (!window.innerWidth) {
			stub = {target : {ownerDocument : document},
					clientX : document.width / 2,
					clientY : document.height / 2,
					detail : value
			};
		}
		else {
			stub = {target : {ownerDocument : document},
					clientX : window.innerWidth / 2,
					clientY : window.innerHeight / 2,
					detail : value
			};
		}
		_raphaelZPDAdapter.handleMouseWheel(stub);
	}

	this.moveTree=function(x,y){
		_raphaelZPDAdapter.movePaper(x,y);
	}

	this.getGreen = function(){
		var g = this._green;
		return g;
	}

	this.green = 0;
	this.yellow = 0;
	this.red = 0;
	this.blue = 0;
	this.pink = 0;
	this.gray = 0;

}

var _drawTree;
