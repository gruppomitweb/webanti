  "use strict";
  /* exported renderDef */
  var renderDef = function(options){

    this.steps = [];
    this.form;
    this.currentStep;

    this.options = {
      def: '',
      container: null,
      replaceContainer: false
      // refreshRate: 200
    };

    this.init= function(opt){
      this.steps = [];
      this.setOptions(opt);
      this.parseDef();
      var _this =this;;
      if( this.options.container == '' ){
        LibJavascript.Events.addEvent(window,'load', function(){
          _this.options.container = document.body
          _this.refresh();
          LibJavascript.Events.addEvent(_this.options.container,'resizeWireFrameContainer', function(){_this.refresh();});
        });
      }else {
        if( typeof(this.options.container) == 'string')
          this.options.container = document.getElementById(this.options.container);
        this.renderStep();
        LibJavascript.Events.addEvent(this.options.container,'resizeWireFrameContainer', function(){_this.refresh();});
      }
      LibJavascript.Events.addEvent(window,'resize', function(){
        _this.refresh();
      });
    }
    // var to;
    // var from =  new Date().getTime();
    // var iii = 0;

    this.refresh= function(){
      // to = setTimeout( this.bindFunction(this),this.options.refreshRate );
      this.renderStep();
      this.options.container.dispatchEvent(new CustomEvent("wireFrameRendered",{type:'UIEvent'}));
    }

    // this.bindFunction= function(_this){
    //   // if( to )
    //   //   window.clearTimeout(to);
    //   _this.renderStep();
    // };

    this.getHTML= function(){
      return this.form.outerHTML;
    }

    this.renderStep= function(){
      var find = this.findStepIndex();
      if( this.currentStep == find )
        return;
      this.currentStep = find;
      var currentObj = this.steps[find];
      this.form = document.createElement('div');
      this.form.style.width= currentObj.form.w + (currentObj.form.w.indexOf("%")>-1?"":"px");
      this.form.style.minWidth= currentObj.step+"px";
      this.form.style.height= currentObj.form.h+'px';
      if( currentObj.form.page > 1){
        this.renderTab(currentObj.form.page, currentObj.form.wizard);
        this.form.classList.add("form_ctrl_tab");
      }
      this.form.classList.add("form_ctrl");
      if( currentObj.form.titled ){
        this.renderTitle();
        this.form.classList.add("form_ctrl_titled");
      }
      for(var i=0; i<currentObj.childs.length; i++){
        var child = currentObj.childs[i]
        var div = document.createElement("div");
        div.className = "Ctrl Ctrl-default";
        div.innerHTML = child.html ? child.html : '';
        div.style.zIndex= child.z;
        if( child.anchor ){
          if (child.anchor.indexOf('top')!=-1) div.style.top=child.y+'px';
          if (child.anchor.indexOf('left')!=-1) div.style.left=child.x+'px';
          if (child.anchor.indexOf('left(%)')!=-1) div.style.left=(child.x*100/currentObj.step)+'%';
          if (child.anchor.indexOf('right')!=-1) div.style.right=(currentObj.step - child.x-child.w)+'px';
          if (child.anchor.indexOf('right(%)')!=-1) div.style.right=((currentObj.step-child.x-child.w)*100/currentObj.step)+'%';
          if (child.anchor.indexOf('bottom')!=-1){
            div.style.bottom=(currentObj.form.h-child.y-child.h)+'px';
          }
          if (child.w!=null && (child.anchor.indexOf('right')==-1 || child.anchor.indexOf('left')==-1)) div.style.width=child.w+((""+child.w).indexOf("%")>-1?'':'px');
          if (child.h!=null && (child.anchor.indexOf('top')==-1 || child.anchor.indexOf('bottom')==-1)) div.style.height=child.h+'px';
        }
        this.form.appendChild(div);
      }

      if( this.options.container.firstChild ){
        this.options.container.replaceChild(this.form,this.options.container.firstChild);
      }else{
        if( this.options.replaceContainer && this.options.container.parentElement ){
          this.options.container.parentElement.replaceChild(this.form,this.options.container);
          this.options.container = this.form.parentElement;
        } else {
          this.options.container.appendChild(this.form);
        }
      }
      this.options.container.style.height = Math.max( currentObj.form.h+(currentObj.form.page > 1 ? document.querySelectorAll(".form_ctrl_tab div.tabstrip")[0].offsetHeight : 0 ), this.options.container.offsetHeight)+'px';
    }

    this.renderTab= function(n,wizard){
      var tabC = document.createElement('div');
      tabC.className = "tabstrip"+(wizard?" wizard": "");
      for( var i=0; i<n; i++){
        var tab = document.createElement('div');
        tab.className = "tab";
        tabC.appendChild(tab);
      }
      this.form.appendChild(tabC);
    }

    this.renderTitle= function(){
      var title = document.createElement('div');
      title.className = "form_titled"
      title.innerHTML = "Portlet Title";
      this.form.appendChild(title);
    }

    this.findStepIndex= function(){
      for( var i=0; i< this.steps.length; i++)
        if( this.steps[i].step > this.options.container.offsetWidth )
          return i-1 > 0 ? i-1 : 0;
      return this.steps.length-1;
    }

    /*
     * Crea una struttura dati per poter gestire
     * più efficientemente gli step
     * vincolo che il form sia il primo elemento del def
    */

    this.parseDef= function(){
      for(var i=0; i<this.options.def.length; i++){
        var item = this.options.def[i];
        if( item.type == 'Form'){
          var iTsteps = typeof(item.steps) != 'undefined' && item.steps != '' ? item.steps : "0"
          var formSteps = iTsteps.split(',');
          formSteps.sort( function(a,b){
            return parseInt(a)>parseInt(b);
          });
          for(var s=0; s<formSteps.length; s++ ){

            /*
             * Create step
            */
            this.steps.push({
              step: (typeof(item.steps) != 'undefined' && item.steps != '') ? parseInt(formSteps[s]) : (item.v_line != "" ? parseInt(item.v_line) : parseInt(item.w)),
              form: {
                h: parseInt(item.h),
                w: item.w,
                page: item.pages_names.split(',').length,
                wizard: item.wizard == 'true',
                titled: item.title != 'none' && item.title != '' ? true : false
              },
              childs: []
            });

            /*
             * add children
            */

            for(var ii=0; ii<this.options.def.length; ii++){ /* Ciclo i rimanenti elementi */
              if( ii == i )
                continue;
              else{
                var child = this.options.def[ii];
                if( this.filterType(child.type) && parseInt(child.page) == 1){
                  var obj={};
                  if(child.layout_steps_values &&
                     typeof(child.layout_steps_values) == 'object' && (Object.keys(child.layout_steps_values).indexOf(formSteps[s]) >-1)){
                    var itemSteps = child.layout_steps_values;
                    var itemObj = itemSteps[formSteps[s]];
                    if( itemObj )
                      obj = {
                        x: parseInt(itemObj.x),
                        y: parseInt(itemObj.y),
                        w: parseInt(itemObj.w),
                        h: parseInt(itemObj.h),
                        anchor: typeof(itemObj.anchor) != 'undefined' && itemObj.anchor != "" ? itemObj.anchor : "top-left",
                      }
                  } else { /* render with standard value */
                    obj = {
                      x: parseInt(child.x),
                      y: parseInt(child.y),
                      w: parseInt(child.w),
                      h: parseInt(child.h),
                      anchor: typeof(child.anchor) != 'undefined' && child.anchor != "" ? child.anchor : "top-left",
                    }
                  }
                  obj.z= typeof(child.zindex) != 'undefined' ? child.zindex : 0;
                  obj.type= child.type;
                  /*
                   * cerco il tipo passando per l'oggetto
                  */
                  var o;
                  if( ZTObjects[child.type+"Obj"] ){ // ctrl standard
                    o = new ZTObjects[child.type+"Obj"]();
                    if( typeof(o.objClass.wireframe) == 'function')
                      obj.html= o.objClass.wireframe(child);
                  } else if (ZTObjects[child.type]) {
                    o = new ZTObjects[child.type]();
                    if (typeof (o.objClass.wireframe) == 'function')
                      obj.html = o.objClass.wireframe(child);
                  } else {
                    /* global getobj_def */
                    if (getobj_def(child.type+'.edtdef', child.type+'Def.js', "../visualweb/")){
                      o = new ZTObjects[child.type]();
                      if( o && typeof(o.objClass.wireframe) == 'function')
                        obj.html=o.objClass.wireframe(child);
                    }
                  }
                  this.steps[s].childs.push( obj );
                }
              }
            }
          }
        }
        break;
      }
    }

    this.setOptions=function(opt){

      for( var o in this.options ){
        this.options[o] = opt[o];
      }

    }

    this.filterType= function(type){
      if( type == 'SPLinker' ||
        type == 'Variable' ||
        type == 'Note' ||
        type.indexOf('Dataobj')>-1 ||
        type.indexOf('Event')>-1
      )
        return false;
      return true;
    }

    this.init(options);
  }
