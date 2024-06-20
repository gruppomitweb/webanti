var oQRCode;
function setPreview(w,h,display,btn){
  var i_preview=document.id('i_preview');
  var i_preview_container=document.id('i_preview_container');
  var i_preview_qrcode=document.id('i_preview_qrcode');
  // LibJavascript.CssClassNameUtils.removeClass(i_preview,"iphone_v");
  // LibJavascript.CssClassNameUtils.removeClass(i_preview,"ipad_v");
  // LibJavascript.CssClassNameUtils.removeClass(i_preview,"iphone_o");
  // LibJavascript.CssClassNameUtils.removeClass(i_preview,"ipad_o");
  LibJavascript.CssClassNameUtils.removeClass(i_preview_container,"iphone");
  LibJavascript.CssClassNameUtils.removeClass(i_preview_container,"ipad");
  LibJavascript.CssClassNameUtils.removeClass(i_preview_container,"vertical");
  LibJavascript.CssClassNameUtils.removeClass(i_preview_container,"horizontal");
  LibJavascript.CssClassNameUtils.removeClass(i_preview_container,"desktop");
  if(btn){
    for(var i=0;i<btn.parentNode.childNodes.length;i++){
      LibJavascript.CssClassNameUtils.removeClass(btn.parentNode.childNodes[i],"steps_preview_active");
    }
    LibJavascript.CssClassNameUtils.addClass(btn,"steps_preview_active");
  }
  //LibJavascript.CssClassNameUtils.removeClass(btn,"steps_preview_active");
  i_preview.style.display='block';
  i_preview_qrcode.style.display='none';
  if(w==-1){
    i_preview.setStyles({
      'height': window.getSize().y-parseInt(LibJavascript.DOM.getComputedStyle(i_preview, 'margin-top')),
      'width' : window.getSize().x-(window.getWrapperLeft?window.getWrapperLeft():0)
    });
    i_preview.setAttribute("fixed-height",false);
    if(display=='desktop'){
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"desktop");
      showPreviewSteps(btn);
    }
    if(display=='qrcode'){
      i_preview.style.display='none';
      i_preview_qrcode.style.display='block';
      if(oQRCode)
        oQRCode.clear(); // Clear the QRCode.
      else{
          oQRCode = new QRCode("i_preview_qrcode", {
          text : (i_preview.src.indexOf('?')>-1? i_preview.src.substring(0,i_preview.src.indexOf('?')):i_preview.src),
          // text : "ciao",
           width : 700,
           height : 700
        });
      }
      hidePreviewSteps(display);
    }
  }else{
    //nascondo gli step Desktop
    hidePreviewSteps(display);

    if(display=="iphone_v"){
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"iphone");
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"vertical");
    }
    if(display=="iphone_o"){
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"iphone");
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"horizontal");
    }
    if(display=="ipad_v"){
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"ipad");
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"vertical");
    }
    if(display=="ipad_o"){
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"ipad");
      LibJavascript.CssClassNameUtils.addClass(i_preview_container,"horizontal");
    }
    i_preview.style.height=h+'px';
    //i_preview.setAttribute("scrolling","no");
    //i_preview.style.width=(w+getScrollbarWidth())+'px';
    i_preview.style.width=(w+4)+'px';//4 px me risolvere il problema in presenza di scrollbars
    i_preview.setAttribute("fixed-height",true);
    //setTimeout(function(){document.id('i_preview').setAttribute("scrolling","yes");document.id('i_preview').scrolling='yes';},400);//Dopo la transition css
  }
}
function hidePreviewSteps(display){
  var steps_preview_container=document.getElementById("steps_preview_container");
  if(steps_preview_container && !Empty(display)){
    if(steps_preview_container.style.display=='block')
      steps_preview_container.style.display='none';
  }
}
/* exported getScrollbarWidth */
function getScrollbarWidth() {
  var outer = document.createElement("div");
  LibJavascript.CssClassNameUtils.addClass(outer,'myscroll');
  outer.style.visibility = "hidden";
  outer.style.width = 0;
  document.body.appendChild(outer);
  outer.style.overflow = "scroll";
  //outer.setAttribute("scrolling","yes");
  var WithScroll = outer.scrollWidth;
  outer.parentNode.removeChild(outer);
  return WithScroll*(-1) ;
}
/* exported selectFromComboStep */
function selectFromComboStep(step,li){
  var i_preview=document.id('i_preview');
  setPreview(step,(window.getSize().y-parseInt(LibJavascript.DOM.getComputedStyle(i_preview, 'margin-top'))));
  if(li){
    for(var i=0;i<li.parentNode.childNodes.length;i++){
      LibJavascript.CssClassNameUtils.removeClass(li.parentNode.childNodes[i],"steps_preview_container_selected");
    }
    LibJavascript.CssClassNameUtils.addClass(li,"steps_preview_container_selected");
  }
}
function showPreviewSteps(/*btn*/){
  var steps_preview_container, i;
  if (!Empty(formProp.layout_step)) {
    //var i_preview=document.id('i_preview');
    var steps = formProp.steps.split(',');
    steps=steps.sort(function(a,b){return parseInt(a)>parseInt(b);});
    var steps_preview=document.getElementById("steps_preview");
    steps_preview_container=document.getElementById("steps_preview_container");
    if(steps_preview_container){
        for(i=0;i<steps_preview_container.childNodes.length;i++){
         LibJavascript.CssClassNameUtils.removeClass(steps_preview_container.childNodes[i],"steps_preview_container_selected");
        }
        steps_preview_container.style.display='block';
      return;
    }
    steps_preview_container=new Element('ul', { 'id': "steps_preview_container", 'class' :'steps_preview_container'}).inject(steps_preview);
    steps_preview_container.setStyles({'display':'block','position':'absolute'});
    new Element('li', {'id':'step_preview_title','html' :'Steps' }).inject(steps_preview_container);
    for (i = 0; i < steps.length; i++) {
      if(parseInt(steps[i])!=0){
        var steps_li=new Element('li', {'id':'step_preview_'+steps[i],'html' :steps[i] }).inject(steps_preview_container);
        steps_li.onclick=new Function('window["selectFromComboStep"]('+steps[i]+',this);');
      }
    }
  }
}
