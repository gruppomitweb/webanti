/* exported
    VQRSelectableList
  */

var VQRSelectableList=new Class({
  Implements: [Events, Options],
  container:null,
  lists:[],
  nEl:0,
  selected:-1,
  currentOrder:[],
  options:{
    classCSS:[{
      width:null,
      list:null,
      itemList:null,
      container:null,
      selectedItem:null
    }],
    doubleClickFunc:null,
    clickFunc:null,
    nList:1,
    scroll:false
  },
  keyboard:null,
  listElements:[],
  stringElementList:[],
  initialize:function(container,options){
    this.setOptions(options);
    this.container=document.id(container);
    if (Browser.ie && Browser.version<9)
      this.container.style.overflow='auto';
    if (this.options.nList>1){
      for (var i=0; i<this.options.nList; i++){
        this.stringElementList[i]="";
        var divList=new Element('div',{
          styles:{
            'overflow':'hidden',
            'display':'inline-block'
          }
        }).inject(this.container);
        if (Browser.ie && Browser.version<9){
          divList.style.height=this.container.offsetHeight+'px';
          divList.style.overflow='';
        }
        if (this.options.classCSS[i].width)
          divList.setStyle('width',this.options.classCSS[i].width)
        this.lists[i]=new Element('ul',{
          styles:{
            'overflow':'hidden'
          }
        }).inject(divList);
        this.listElements[i]=[];
       if (this.options.classCSS[i]){
          if (this.options.classCSS[i].container)
            divList.addClass(this.options.classCSS[i].container)
          if (this.options.classCSS[i].list)
            this.lists[i].addClass(this.options.classCSS[i].list)
        }
        this.lists[i].addEvent('click',function(el){
          this.setSelectedRow(parseInt(el.target.get("index"),10));
          this.keyboard.activate();
        }.bind(this));
        if (this.options.doubleClickFunc) {
          this.lists[i].addEvent('dblclick',function(){
            this.options.doubleClickFunc();
          }.bind(this))
        }
      }
    }
    else { // lista unica
      this.lists[0]=new Element('ul',{
        styles:{
          'overflow':'hidden'
        }
      }).inject(container);
      this.listElements[0]=[];
      this.stringElementList[0]=[];
      if (this.options.classCSS[0]){
        if(this.options.classCSS[0].container)
          this.lists[0].addClass(this.options.classCSS[0].container)
        if (this.options.classCSS[0].list)
          this.lists[0].addClass(this.options.classCSS[0].list)
      }
      this.lists[0].addEvent('click',function(el){
        this.setSelectedRow(parseInt(el.target.get("index"),10));
        this.keyboard.activate();
      }.bind(this));
      if (this.options.doubleClickFunc) {
        this.lists[0].addEvent('dblclick',function(){
          this.options.doubleClickFunc();
        }.bind(this))
      }
    }
    this.keyboard=new Keyboard({activate:true});
    var selectRow=function(e,idx){
      if (e){
        e.preventDefault();
        e.stopPropagation()
      }
      this.setSelectRow2(idx);
    }.bind(this)

   	this.keyboard.addEvents({
      'keydown:up': function(e){selectRow(e,-1); },
      'keydown:down': function(e){selectRow(e,1)}
    });
    if (! (Browser.ie && Browser.version<9))
      if (this.options.scroll)
        this.container.nanoScrollerMT();
  },

  addRow:function(itemList,refresh){
    this.nEl++;
    var index=this.nEl-1;
    for (var i=0; i<this.options.nList; i++){
      var title='',tmpTitle=itemList[i];
      if (itemList[i]!='' && itemList[i].length>40){
        while (tmpTitle!=''){
          title+=tmpTitle.substring(0,40)+'\n';
          tmpTitle=tmpTitle.substring(40);
        }
      }
      else title=itemList[i];
      var li=new Element('li',{
        html:itemList[i]||'&nbsp;',
        title:title,
        index:index,
        styles:{
          'MozUserSelect':'none',
          'width':'100%',
          'text-overflow':'ellipsis',
          '-o-text-overflow':'ellipsis',
          'white-space':'nowrap',
          'overflow':'hidden'
        }
      }).inject(this.lists[i]);
      this.listElements[i].push(li);
      if (this.options.classCSS[i])
        li.addClass(this.options.classCSS[i].itemList)
    }
    if (this.currentOrder.length==index)
      this.currentOrder[index]=index;
    if (refresh)
      this.refresh();
  },

  addStringRow:function(itemList/*,refresh*/){ // prepara una stringa contenente gli elementi ul per poi fare un innerhtml alla fine
    this.nEl++;
    var index=this.nEl-1;
    for (var i=0; i<this.options.nList; i++){
      var title='',tmpTitle=itemList[i];
      if (itemList[i]!='' && itemList[i].length>40){
        while (tmpTitle!=''){
          title+=tmpTitle.substring(0,40)+'\n';
          tmpTitle=tmpTitle.substring(40);
        }
      }
      else title=itemList[i];
      if (this.options.classCSS[i])
        this.stringElementList[i]+="<li title='"+title+"' style='MozUserSelect:none; width:100%; text-overflow:ellipsis; -o-text-overflow:ellipsis; white-space:nowrap; overflow:hidden;' class='"+this.options.classCSS[i].itemList+"' index="+index+">"+(itemList[i]||'&nbsp;')+"</li>";
      else this.stringElementList[i]+="<li title='"+title+"' style='MozUserSelect:none; width:100%; text-overflow:ellipsis; -o-text-overflow:ellipsis; white-space:nowrap; overflow:hidden;' index="+index+">"+(itemList[i]||'&nbsp;')+"</li>";
    }
    if (this.currentOrder.length==index)
      this.currentOrder[index]=index;
  },

  addRows:function(){ //fa l'innerHTML delle stringhe preparate in precedenza
    for (var i=0; i<this.options.nList; i++){
      this.lists[i].innerHTML=this.stringElementList[i];
      this.stringElementList[i]='';
      this.listElements[i]=this.lists[i].getChildren();
    }
    this.refresh();
  },

  setSelectedRow:function(index){
    var childList0=this.listElements[0];
    if (index>=0 && index<childList0.length){
      for (var i=0; i<this.lists.length; i++){
        var childList=this.listElements[i];
        if (this.selected>-1){
          if (this.options.classCSS[i].selectedItem)
            childList[this.selected].removeClass(this.options.classCSS[i].selectedItem)
        }
        if (this.options.classCSS[i].selectedItem)
          childList[index].addClass(this.options.classCSS[i].selectedItem)
      }
      this.selected=index;
        if ((childList0[index].getPosition().y+childList0[index].getSize().y) > (this.container.getPosition().y+this.container.getSize().y))
         new Fx.Scroll(this.container).toElement(childList0[index],'y')
        else if ((childList0[index].getPosition().y) < (this.container.getPosition().y))
          new Fx.Scroll(this.container).toElement(childList0[index],'y')
      if (this.options.clickFunc)
        this.options.clickFunc();
    }
    this.keyboard.activate()
  },

  setSelectRow2:function(idx){
    var index=this.currentOrder.indexOf(this.selected);
    if (index!=-1){
      if (((index+idx)>=0) && ((index+idx)<this.currentOrder.length))
        this.setSelectedRow(this.currentOrder[index+idx])
    }
  },
  getSelectedRow:function(){
    return this.selected;
  },
  getSelectedRowHtml:function(i){
    return this.listElements[i][this.selected];
  },
  deleteAllItem:function(){
    for (var i=0; i<this.lists.length; i++){
      var itemList=this.listElements[i];
      if (itemList){
        for (var j=0; j<itemList.length; j++){
          itemList[j].destroy();
        }
        this.listElements[i]=[];
      }
    }
    this.nEl=0;
    this.selected=-1;
  },
  getItem:function(index){
    var item=[];
    for (var i=0; i<this.lists.length; i++){
      item.push=this.listElements[i][index]
    }
    return item;
  },
  refresh:function(){
    if (! (Browser.ie && Browser.version<9))
      if (this.options.scroll)
        this.container.nanoScrollerMT();
  },
  sort:function(index){ // gli elementi della lista devono avere altezza fissa altrimenti IE9 sballa
    if (this.listElements[0].length<1000 || confirm("The requested operation could take some time. Continue?")){
      if (index<this.options.nList){
       function sortfunc(a, b){
          a=a.get('text').toUpperCase();
          b=b.get('text').toUpperCase();
          if (a > b)
             return 1
          if (a < b)
             return -1
          return 0;
        }
        var listOrdered=this.lists[index].getChildren();
        listOrdered.sort(sortfunc);
        var list=this.listElements[index];
        var order=[];
        listOrdered.each(function(el,i){
          order[i]=list.indexOf(el);
        });
        this.currentOrder=order;
        for (var i=0; i<this.options.nList; i++){
          var sort=new Fx.Sort(this.listElements[i], {
            duration: 0
          });
          sort.sort(this.currentOrder);
        }
      }
    }
  },
  deactivateKeyboard:function(){
    if (this.keyboard)
      this.keyboard.deactivate();
  }

})
