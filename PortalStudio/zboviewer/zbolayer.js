var opt_width_pref, opt_height_pref;

/* exported getOpener getY mylayerOpenCover */
function getOpener() {
  return (window.opener?window.opener:(window.caller?window.caller:window.parent));
}

function getY( oElement ){
	var iReturnValue = 0;
	while( oElement != null ) {
		iReturnValue += oElement.offsetTop;
		oElement = oElement.offsetParent;
	}
return iReturnValue;
}

function zlayerOpenForeground(url, name, args, opt_top_pref, opt_left_pref, opt_margin_pref, opt_resizable_pref, force, pname, pindex, title) {
  /*
  force==1 --> sempre layer
  force==2 --> sempre popup
  forse=altro --> default (Controlla variabile di Skin..)
  pindex=indice portlet nel jsp
  */
  if (!url || zlayerOpenForeground.linkOpened(name)) {
   return
  }
  var navigablePopups = false;
  var overlaingPopups = true;
  var isMobile = IsMobile()
    , hide_close_btn = window.SPTheme && (navigablePopups || overlaingPopups) ? true : null
    , prepare_iframe = window.SPTheme && (SPTheme['activateModalPopup']||false)
    , modal = (prepare_iframe || (window.SPTheme && SPTheme['activateModalZoom']))
    , border_width = 1//(!window.SPTheme || SPTheme.navigablePopups || SPTheme.overlaingPopups) ? 0 : SPTheme.modalZoomBorderWidth
    ;
  modal =(force==1 || isMobile || (modal && !navigator.userAgent.match(/MSIE [4-7]\./) && (!window.top.modalLayerOpened || modal))) && force!=2;
  if ( modal ) {
    var p_d_b, currentpath
      , prnt = window
      , lib = (prnt.LibJavascript ? prnt.LibJavascript : null)
      , modalLayer = prnt.spModalLayer
      ;

    p_d_b=prnt.document.body;
    var objModal = {}
    objModal.modalLayerPopup = false;
    if (window.SPTheme && (navigablePopups || overlaingPopups) ) {
      opt_width_pref = prnt.GetWindowSize().w;
      opt_height_pref = prnt.GetWindowSize().h;
	  if(opt_top_pref) opt_height_pref -= opt_top_pref;
	  if(opt_margin_pref) {
			opt_height_pref -= opt_margin_pref;
			opt_width_pref -= 2*opt_margin_pref;
	  }
    }
    modal = isMobile || modal ||(opt_width_pref<(p_d_b.clientWidth>0 ? p_d_b.clientWidth : p_d_b.offsetWidth) &&
                                 opt_height_pref<(p_d_b.clientHeight>0 ? p_d_b.clientHeight : p_d_b.offsetHeight));
    if ( modal ) {
      if (!modalLayer) {
        lib.RequireLibrary((typeof(SPWebRootURL)!='undefined'?SPWebRootURL+'/':'../')+'spModalLayer.js',true);
        modalLayer = prnt.spModalLayer;
      }
      if (modalLayer && !objModal.modalLayerPopup) {
        currentpath = window.location.pathname
        currentpath = currentpath.substring(0,currentpath.lastIndexOf('/')+1);
        if (Left(url,3)=='../' || url.match(/^[^\/]+\?/) ) { url = currentpath + url; }

		var zoomid;

		if(pname && window.getPagelet){
			var zp = window.getPagelet()[pname];
			if(zp.length && zp.length>pindex)
				zoomid = zp[pindex].formid;
			else
				zoomid = zp.formid;
		}

		if(zoomid){
			if(url.indexOf("?")<0)
				url += "?zoomid="+zoomid;
			else
				url += "&zoomid="+zoomid;
		}
		url += "&Caption="+URLenc(title);

        var mx = new modalLayer(url,{'in_iframe':true,
			'ancestor':prnt,
			'border_color':SPTheme.modalZoomBorderColor,
			'border_width':border_width,
			'close_on_click_mask':SPTheme.modalMaskClickClose,
			'draggable':SPTheme.modalZoomDrag,
			'height':opt_height_pref,
			'hide_close_btn':hide_close_btn,
			'iframe_name':name,
			'iframe_padding':SPTheme.modalMaskIframePadding,
			'mask_color':SPTheme.modalMaskBgColor,
			'mask_opacity':(SPTheme.modalMaskOpacity/100),
			'multiple_instances':prnt.modalLayerOpened,
			'opener':window,
			'prepare_iframe':false,
			'resizable':(typeof(opt_resizable_pref)!='undefined'? opt_resizable_pref : SPTheme.modalZoomResize ),
			'show_scrollbars':SPTheme.modalMaskScrollbars,
			'width':opt_width_pref,
			//'top':opt_top_pref,
			'left':opt_left_pref
        });

		prnt.onresize = function(/*event*/){
			var h = prnt.GetWindowSize().h;
			var w = prnt.GetWindowSize().w;
			if(opt_top_pref) h -= opt_top_pref;
			if(opt_margin_pref) {
				h -= opt_margin_pref;
				w -= 2*opt_margin_pref;
			}
			mx.resizeModal(h,w,true);
		}
		mx.open();
        if(prepare_iframe)
        return prnt
        else
        return
      }
    }
  }
  delete zlayerOpenForeground.names[name]
  SPTheme['activateModalPopup']=false
  try {
  zlayerOpenForeground.lo=0
  var r=windowOpenForeground(url, name, args)
  if (prepare_iframe)
   return r
  }finally{
  SPTheme['activateModalPopup']=prepare_iframe
  }
}
zlayerOpenForeground.linkOpened=function(name){
 zlayerOpenForeground.names=zlayerOpenForeground.names||{}
 zlayerOpenForeground.lo=zlayerOpenForeground.lo||0
 zlayerOpenForeground.ln=zlayerOpenForeground.ln||''
 name=name||''
 var now=new Date().getTime()
 if (zlayerOpenForeground.ln.match(/^linkview_/) && (now - zlayerOpenForeground.lo) < 500)
  return true
 if(name.match(/^linkview_/) && (name in zlayerOpenForeground.names) && (now - zlayerOpenForeground.names[name]) < 500)
  return true
 zlayerOpenForeground.ln=name
 zlayerOpenForeground.lo=now
 zlayerOpenForeground.names[name]=zlayerOpenForeground.lo
 return false
}

function mylayerOpenCover(url, pname, pindex, title) {
	if (!url) return;
	var iframe_parent_div = window.frameElement ? window.frameElement.parentNode : null;

	if(iframe_parent_div){
		var left = iframe_parent_div.offsetLeft;
		zlayerOpenForeground(url, "zboviewer", '', 0, left, 5, false, 1, pname, pindex, title);
	}
	else{
		zlayerOpenForeground(url, "zboviewer", '',null, null, 5, false, 1, pname, pindex, title);
	}
}
