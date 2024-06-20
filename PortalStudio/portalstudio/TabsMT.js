/* exported timeout TabsMT */
/* Al costruttore è necessario passare il contenitore dei titoli (un ul con la lista dei titoli) e il contenitore dei contenuti*/
var timeout;
var divContainerList;
var TabsMT=new Class({
  Implements: [Events, Options],

  titleContainer:'',
  contentsContainer:'',
  currentTab:null,
  timeout:null,
  options:{
    close:false, //possibilità di chiusura delle opzioni
    move:false, // frecciette per muoversi da un tab all'altro
    clickFunc:null // funzione da chiamare al momento della selezione di un tab
  },

  widthTitle:0,

  initialize:function(titleContainer,contentsContainer,options){

    this.setOptions(options);
    this.titleContainer=document.id(titleContainer);
    this.titleContainer.addClass('listTitle')

    this.contentsContainer=document.id(contentsContainer);

    var title=this.titleContainer.getChildren();
    var contents=this.contentsContainer.getChildren();

    title.each(function(el,index){
      this.addTabs(title[index],contents[index])
    }.bind(this));
    if (contents[0])
      this.showTab(title[0],contents[0]);
    window.addEvent('resize',this.refresh2.bind(this));
      divContainerList=new Element('div',{
        'class':'divContainerList',
        'styles':{
          'width':this.titleContainer.getParent().getSize().x
        }
      });
      divContainerList.replaces(this.titleContainer);
      divContainerList.adopt(this.titleContainer);
      this.titleContainer.setStyle('position','relative')
  },
  refresh2:function(){
    if (!this.timeout)
      this.timeout=setTimeout(this.refresh.bind(this),10);
  },
  refresh:function(){
    clearTimeout(this.timeout)
    this.timeout=null;
    var containerList=this.titleContainer.getParent().getParent();
    var divContainerList=containerList.getElement('.divContainerList')
    if (this.options.move){
      if (divContainerList){
        divContainerList.setStyle('width',containerList.getSize().x-48)
        divContainerList.setStyle('position','relative')
        divContainerList.setStyle('left','22')

      }
       this.createSlider(containerList);
       this.slideTab();
       this.destroySlider(containerList);
    }
    else if (divContainerList) divContainerList.setStyle('width',containerList.getSize().x);
  },

  destroySlider:function(containerList){
    if (this.widthTitle<containerList.getSize().x){
      var list=this.titleContainer.getElements('.tabs');
      //elimino frecciette di spostamento
      if (containerList.getElement('.moveSx'))
        containerList.getElement('.moveSx').getParent().destroy();
      if (containerList.getElement('.moveDx'))
        containerList.getElement('.moveDx').getParent().destroy();
      while (list[0].retrieve('hidden')){
        this.slideSx(false);
      }
      this.titleContainer.getParent().setStyle('left',0)
    }

  },
  addTabs:function(title,contents){
    title.set('class','tabs')
    title.addEvents({
      'click':function(){
        this.showTab(title,contents);
      }.bind(this)
    });
    title.store('hidden',false)

    if (this.options.close){
      var close=new Element('div',{
        'class':'closeTab'
      }).inject(title);
      close.addEvents({
        'click':function(){
          this.fireEvent('beforeClose', [title, contents]);
          this.closeTabs(title,contents);
        }.bind(this)
      })
    }
    if (this.options.move){
      this.widthTitle+=title.getSize().x+2; //larghezza + bordo

      this.createSlider(this.titleContainer.getParent().getParent());
    }
    this.showTab(title,contents,true);
  },

  createSlider:function(containerList){
    if (this.widthTitle>containerList.getSize().x){
      this.titleContainer.setStyle('position','relative')
      containerList.getElement('.divContainerList').setStyle('width',containerList.getSize().x-44);
      if (!containerList.getElement('.moveSx')){
        var divMoveSx=new Element ('div',{
          'class':'tabs tabUnselected move'
        }).inject(containerList,'top');
        new Element ('div',{
          'class':'moveSx',
          'html':'&nbsp;'
        }).inject(divMoveSx);
        divMoveSx.addEvents({
          'mousedown':function(){
            this.slideSx(true);
          }.bind(this)
        })
        containerList.getElement('.divContainerList').setStyle('left',22);
         this.titleContainer.setStyle('left',0)
      }
      if (!containerList.getElement('.moveDx')){
       var divMoveDx=new Element ('div',{
          'class':'tabs tabUnselected move',
          'styles':{right:0,top:0}
        }).inject(containerList,'bottom');
        new Element ('div',{
          'class':'moveDx',
          'html':'&nbsp;'
        }).inject(divMoveDx);
        divMoveDx.addEvents({
          'mousedown':function(){
            //cerco l'indice del primo campo visibile
            this.slideDx(true);
          }.bind(this)
        })
      }
    }
  },


  slideDx:function(morph){
    var list=this.titleContainer.getElements('.tabs');
    for (var i=0; i<list.length; i++){
      if (!list[i].retrieve('hidden') && i<list.length-1){
        if (morph){
          this.titleContainer.set('morph',{duration:300})
          this.titleContainer.morph({'left':this.titleContainer.getPosition(this.titleContainer.getParent()).x-list[i].getSize().x})
        }
        else this.titleContainer.setStyle('left',this.titleContainer.getPosition(this.titleContainer.getParent()).x-list[i].getSize().x)
        list[i].store('hidden',true);
        i=list.length;
      }
    }

  },

  slideSx:function(morph){

    var list=this.titleContainer.getElements('.tabs');
    //cerco l'indice del primo campo visibile
    for (var i=0; i<list.length; i++){
      if (!list[i].retrieve('hidden') && i>0){
        if (morph){
          this.titleContainer.set('morph',{duration:300})
          this.titleContainer.morph({'left':this.titleContainer.getPosition(this.titleContainer.getParent()).x+(list[i-1].getSize().x)})
        }
        else
          this.titleContainer.setStyle('left',this.titleContainer.getPosition(this.titleContainer.getParent()).x+(list[i-1].getSize().x))
        list[i-1].store('hidden',false);
        i=list.length;
      }
      else if (!list[i].retrieve('hidden') && i==0)
        i=list.length;
      else if (i==list.length-1){
        if (morph){
          this.titleContainer.set('morph',{duration:300})
          this.titleContainer.morph({'left':this.titleContainer.getPosition(this.titleContainer.getParent()).x+(list[i-1].getSize().x)})
        }
        else this.titleContainer.setStyle('left',this.titleContainer.getPosition(this.titleContainer.getParent()).x+(list[i-1].getSize().x))
        list[i].store('hidden',false);
      }
    }

  },

  slideTab:function(){
    var hiddenTab=(this.currentTab.title.getPosition().x+this.currentTab.title.getSize().x)>(this.titleContainer.getParent().getPosition().x+this.titleContainer.getParent().getSize().x)
    while (hiddenTab){
      this.slideDx(false);
      hiddenTab=(this.currentTab.title.getPosition().x+this.currentTab.title.getSize().x)>(this.titleContainer.getParent().getPosition().x+this.titleContainer.getParent().getSize().x)
    }
    hiddenTab=(this.currentTab.title.getPosition().x<this.titleContainer.getParent().getPosition().x)
    while (hiddenTab){
      this.slideSx(false);
       hiddenTab=(this.currentTab.title.getPosition().x<this.titleContainer.getParent().getPosition().x)
    }
  },

  showTab:function(title,contents,disableClick){
    if (this.currentTab){
      this.currentTab.contents.setStyle('display','none');
      this.currentTab.title.removeClass('tabSelected');
      this.currentTab.title.addClass('tabUnselected');
    }
    else this.currentTab={};
    this.currentTab.title=title;
    this.currentTab.contents=contents;

    this.currentTab.contents.setStyle('display','');
    this.currentTab.title.addClass('tabSelected');
    this.currentTab.title.removeClass('tabUnselected');
    if (this.options.move)
      this.slideTab();
    if (this.options.clickFunc && !disableClick)
      this.options.clickFunc(this.getSelectedTab());
  },

  closeTabs:function(title,contents){
    if (!title.getParent().hasClass('listTitle')){
      var container=title.getParent();
      if (container.getNext())
        this.showTab(container.getNext().getFirst(),contents.getNext())
      else if (container.getPrevious())
        this.showTab(container.getPrevious().getFirst(),contents.getPrevious())
      else
        this.currentTab=null;
      if (this.options.move){
        this.widthTitle-=(title.getSize().x+2);

        this.destroySlider(this.titleContainer.getParent().getParent())
      }
      container.destroy();
    }
    else {
      if (title.getNext())
        this.showTab(title.getNext(),contents.getNext())
      else if (title.getPrevious())
        this.showTab(title.getPrevious(),contents.getPrevious())
      else
        this.currentTab=null;
      title.destroy();

    }
    contents.destroy();
  },

  setSelectedTab:function(index){
    if (index<this.titleContainer.getElements('.tabs').length)
      this.showTab(this.titleContainer.getElements('.tabs')[index],this.contentsContainer.getChildren()[index])
  },

  getSelectedTab:function(){
    return this.titleContainer.getElements('.tabs').indexOf(this.currentTab.title);
  },

  getTabsContainer:function(){
    return divContainerList;
  },

  reset:function(){
    var tit = this.titleContainer.getChildren();
    var cont = this.contentsContainer.getChildren();
    cont.each(function(el,index){
      this.closeTabs(tit[index],cont[index])
    }.bind(this));
  }
});
