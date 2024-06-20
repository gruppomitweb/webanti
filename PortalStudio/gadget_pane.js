/* exported create_gadget_pane */
function create_gadget_pane(){
  var gadget_pane_items = $$('#gadgets_pane .gadgets_pane_item');
  var gadget_title = $$('.gadgetlistTitle')
  var g_pane = $('gadgets_pane');
  gadget_pane_items.each(function(item){
    var content_id = null; /*id del contenuto del gadgets_pane_item */
    if(item.getFirst() && item.getFirst().hasClass('small') && item.getFirst().hasClass('nano'))
      content_id = item.getFirst().getFirst('.content').id
    else
      content_id = item.getFirst().id
    var toggler = null; /*bottone di chiusura e apertura del gadget*/
    gadget_title.each(function(gt){
      if(gt.getProperty('for') == content_id)
        toggler = gt.querySelector('.gadgets_pane_toggler');
    })
    if(toggler){
      item.store('opened',true);
      item.set('morph');
      toggler.setStyles({'background-position':'bottom left'})
      if(!toggler.hasClass('opened')) toggler.addClass('opened');
      /*definisco l'altezza iniziale*/
      var h = item.getSize().y
      item.store('old_height',h);
      toggler.addEventListener(  /*apertura e chiusura dei gadget con relarivo ridimensionamento*/
        'click', function(/*e*/){
          if(item.retrieve('opened')){
            item.store('opened',false);
            item.store('old_height',item.getSize().y);
            item.get('morph').start({'height':0,'opacity':0}).chain(function(){
              resizeGadgetsPane();
            });
            toggler.removeClass("opened");
          }else{
            item.store('opened',true);
            var old_h =item.retrieve('old_height');
            item.get('morph').start({'height':old_h,'opacity':1}).chain(function(){
              resizeGadgetsPane();
            });
            toggler.addClass("opened");
          }
          if(window.togglerGadget) window.togglerGadget(toggler);
        }
      )
    }
  })

  var togglePane = function(first){
    first = ( typeof(first) == 'boolean' ? first : false) ;
    var timeOut = '300';
    if(window.myGadgetPaneTimeOut) { //settare timeout //uso in smartreport
      timeOut = window.myGadgetPaneTimeOut;
    }
    var morphEl= new Fx.Morph($('gadgets_pane'),{ 'duration':timeOut, link:'cancel',transition:Fx.Transitions.Bounce.easeOut});
    var morphTlb= new Fx.Morph($('toolbar'),{ 'duration':timeOut, link:'cancel',transition:Fx.Transitions.Bounce.easeOut});
    var g_pane_w = g_pane.getSize().x,
      b_canvas = $('backcanvas');
    $$('#gadgets_pane .gadgets_pane_item').set('morp');
    if( g_pane.opened ){
      morphEl.start({'left': - g_pane_w}).chain(function(){
        $$('#gadgets_pane .gadgets_pane_item').each(function(el){
          el.get('morph').start({'opacity':0}).chain(function(){
            el.setStyle('display','none');
          });
        });
      });
      if($('toolbar')){
        if(first)
            $('toolbar').setStyles({'left': 18,'width': ( $('toolbar').getSize().x - 18 ) + g_pane_w});
        else
          morphTlb.start({'left': 18,'width':$('toolbar').getSize().x+g_pane_w});
      }
      g_pane.opened = false;
      $('gadgets_openclose').setStyle('background-position','center right') ;
      b_canvas.setStyles({'left':b_canvas.offsetLeft-g_pane_w,'width':b_canvas.offsetWidth+g_pane_w > 0 ? b_canvas.offsetWidth+g_pane_w : b_canvas.offsetWidth});
      if($('backcanvasBorder'))
        $('backcanvasBorder').setStyle('left',$('backcanvasBorder').offsetLeft-g_pane_w);
      if($('v_ruler'))
        $('v_ruler').setStyle('left',$('v_ruler').offsetLeft-g_pane_w);
      if($('h_ruler'))
        $('h_ruler').setStyle('left',$('h_ruler').offsetLeft-g_pane_w);
      if($('layoutSteps'))
        $('layoutSteps').setStyle('left', $('layoutSteps').offsetLeft - g_pane_w);
      window.dispatchEvent(new CustomEvent('gadget-pane-close', { detail: { size: g_pane_w } }))
    }else{
      if($('toolbar')){
        if(first)
           $('toolbar').setStyles({'left': g_pane_w +15,'width':$('toolbar').getSize().x - (g_pane_w + 18 )})
        else
          morphTlb.start({'left': g_pane_w +15,'width':$('toolbar').getSize().x-g_pane_w})
      }
      morphEl.start({'left': 0}).chain(function(){
        $$('#gadgets_pane .gadgets_pane_item').setStyle('display','block');
        $$('#gadgets_pane .gadgets_pane_item').fade(1);
        resizeGadgetsPane();
      });
      g_pane.opened = true;
      $('gadgets_openclose').setStyle('background-position','center left') ;
      b_canvas.setStyles({'left':b_canvas.offsetLeft+g_pane_w,'width': b_canvas.offsetWidth-g_pane_w > 0 ? b_canvas.offsetWidth-g_pane_w :  b_canvas.offsetWidth});
      if($('backcanvasBorder'))
        $('backcanvasBorder').setStyle('left',$('backcanvasBorder').offsetLeft+g_pane_w);
      if($('v_ruler'))
        $('v_ruler').setStyle('left',$('v_ruler').offsetLeft+g_pane_w);
      if($('h_ruler'))
        $('h_ruler').setStyle('left',$('h_ruler').offsetLeft+g_pane_w);
      if($('layoutSteps'))
        $('layoutSteps').setStyle('left', $('layoutSteps').offsetLeft + g_pane_w);
      window.dispatchEvent(new CustomEvent('gadget-pane-open', { detail: { size: g_pane_w } }))
    }
    // if(!Empty(clVRRulersLib))
      // clVRRulersLib.DrawVertical(document.id('backcanvas').getSize().y);
    // if(!Empty(clHRRulersLib))
      // clHRRulersLib.DrawHorizontal(document.id('backcanvas').getSize().x);
    if(writeHTML)writeHTML();
  }
  document.getElementById('gadgets_panerightbar').addEventListener('click', togglePane);
  /*all'inizio è aperta*/
  g_pane.opened = g_pane.opened ? g_pane.opened : false;
  g_pane.setStyle('display','block');
  if(!g_pane.opened)togglePane(true);
}

var resizeGadgetsPane = function(recalc){
  var gadget_pane_items = $$('#gadgets_pane .gadgets_pane_item');
  var gadget_title_h = $$('.gadgetlistTitle')[0].getSize().y;
  gadget_pane_items.each(function(item){
    var gadget_opened = item.retrieve('opened')
    if(gadget_opened){
      var old_h = item.retrieve('old_height');
      item.setStyle('height','auto');
      if(item.getScrollSize().y > old_h || recalc){
        var gadgets_h = 0;
        gadget_pane_items.each(function(i){
          if(i != item)
            gadgets_h += i.getSize().y;
        });
        var h = Math.min(item.getScrollSize().y,document.id('gadgets_pane').getSize().y - ((gadget_title_h * gadget_pane_items.length) + gadgets_h));
        if (h >= 0) {
          item.setStyles({'height':h});
          item.store('old_height',h)
        }
      }else{
        item.setStyle('height',old_h);
      }
      recalc=true;
    }
  })
}
