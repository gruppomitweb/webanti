function doLinkZoom() {
var pagelet = this.pagelet||this;
function DoOnKeyDown(e) {
  var keyCode = GetKeyCode( e ? e : window.event),
      zoom = ( (pagelet["SPPortalZoomBase"+(window.SPOfflineLib ? "OL" : "")+"_portlet"] ) || (pagelet.ZoomGrid) || (pagelet.zoom) ).getResource(),
      newRec,
      changeRow = false;
  var ctrl = GetEventSrcElement(e);
  if (ctrl.tagName.toLowerCase()=='input' && ctrl.type.toLowerCase()=='text') return; //se sono in un input non devo fare nulla
  if (!zoom.formid) { //array
    for (var i=0;i<zoom.length;i++){
      if (zoom[i].Ctrl.ownerDocument==window.document) {
        zoom=zoom[i];
        break;
      }
    }
  }
  var oldRec = zoom.dataobj.curRec,
      curPage = zoom.Grid.GetCurPage();
  switch ( keyCode ) {
    case 27: // ESC
      WindowClose();
    break;
    case 37: // left
      if ( !zoom.GetRS_EOF() && zoom.Grid.scroll_bars!='infinite_scroll')
        zoom.Grid.PrevPage();
        DoOnKeyDown.CancelEvent(e);
    break;
    case 38: // up
      newRec = oldRec-1;
      changeRow = true;
      DoOnKeyDown.CancelEvent(e);
    break;
    case 39: // right
      if ( !zoom.GetRS_EOF() && zoom.Grid.scroll_bars!='infinite_scroll')
        zoom.Grid.NextPage();
      DoOnKeyDown.CancelEvent(e);
    break;
    case 40: // down
      newRec = oldRec+1;
      changeRow = true;
      DoOnKeyDown.CancelEvent(e);
    break;
    case 13: // enter
      if ( !zoom.GetRS_EOF() && !zoom.Grid.filterByExampleMask_IsVisible() ) {
        document.getElementById(zoom.Grid.ctrlid+"_link_"+(oldRec-1)).onclick();
      DoOnKeyDown.CancelEvent(e);
      }
    break;
    case 120: // F9
      zoom.AddNewRecord();
      DoOnKeyDown.CancelEvent(e);
    break;
  }
  if ( changeRow && !zoom.GetRS_EOF() ) {
    if ( newRec<1 && curPage>1 ) {
      zoom.Grid.PrevRecord();
    } else if ( newRec>zoom.dataobj.getRecCount() ) {
      zoom.Grid.NextRecord();
    } else {
      if(newRec<1) newRec=1;
      zoom.Grid.SetCurRec(newRec, true);
      if (document.getElementById(zoom.Grid.ctrlid + '_row' + (newRec-1))) {
        document.getElementById(zoom.Grid.ctrlid + '_row' + (newRec-1)).scrollIntoView(true);
      }
    }
  }
};
DoOnKeyDown.CancelEvent=function(e){
 e.cancelBubble=true
 if(e.stopPropagation) e.stopPropagation();
 if(e.preventDefault) e.preventDefault(true);
 e.returnValue=false
}
if ( document.addEventListener ) {
  document.addEventListener("keydown", DoOnKeyDown, false);
} else {
  document.attachEvent("onkeydown", DoOnKeyDown);
}
}
