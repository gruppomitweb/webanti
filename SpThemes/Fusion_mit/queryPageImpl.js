var qp_bBorder=false;

function Body_BeginHtml(h,bordercolor,borderwidth,positioning,tableRules){
  qp_bBorder=(borderwidth>0);
  if(positioning!='T'){
    if(window.name!='menu' && !qp_bBorder && typeof(SPTheme)!='undefined' && typeof(SPTheme['pageBeginDetailHtml'])!='undefined'){
      document.writeln(SPTheme['pageBeginDetailHtml']);
    }
    document.writeln("<DIV style='position:relative'>");
    if(qp_bBorder)
      document.writeln("<DIV id=bodyBegin style='position:relative;border:"+bordercolor+" solid "+borderwidth+"px;width:100%;height:100%;' >");
    else
      document.writeln("<DIV id=bodyBegin style='width:100%;height:100%;'>");
  }
  else{
    if(qp_bBorder){
      if(tableRules=='plain')
        document.writeln("<TABLE id=bodyBegin class='QueryPageTable' width='80%' align='center' cellspacing='"+borderwidth+"' cellpadding='2' style='background-color:"+bordercolor+"'>");
      else
        document.writeln("<TABLE id=bodyBegin class='QueryPageTable' width='80%' align='center' cellspacing='0' cellpadding='2' rules='"+tableRules+"' style='border-color:"+bordercolor+";border-width:"+borderwidth+"px'>");
    }
    else
      document.writeln("<TABLE id=bodyBegin class='QueryPageTable' width='80%' align='center' cellspacing='0' cellpadding='2'>");
  }
}
function Body_EndHtml(positioning){
  //Se la pagina e' nel frame menu bisogna cambiarne le impostazioni(Linee che separano Header/Body/Footer)
  if(positioning!='T'){
    document.writeln("</DIV>");
    if(window.name!='menu' && !qp_bBorder && typeof(SPTheme)!='undefined' && typeof(SPTheme['pageEndDetailHtml'])!='undefined'){
      document.writeln(SPTheme['pageEndDetailHtml']);
    }
    document.writeln("</DIV>");
  }
  else{
    document.writeln("</TABLE>");
  }
}
function AddColGroups(nCols) {
  for(var i=0;i<nCols;i++) {
    document.writeln("<COLGROUP>");
  }
}
function Row_BeginHtml(document,rowcnt,id,positioning,rowcolor,w){
  if(rowcolor==null) rowcolor=true;
  if(w==null) w=-1;

  if(positioning!='T'){
    var s='position:relative;';
    if(w==-1) {
      if (document.compatMode!='BackCompat') {
        s=s+'width:100%;';
      }
    } else {
      s=s+'width:'+w+'px;float:left;';
    }
    if(rowcolor && window.name!='menu'){
      document.writeln("<DIV class='"+((rowcnt%2)==0 ? "EvenRow" : "OddRow")+"' id="+id+" style='"+s+"'>");
    }
    else{
      document.writeln("<DIV id="+id+" style='"+s+"'>");
    }
  }
  else{
    if(rowcolor && window.name!='menu'){
      document.writeln("<TBODY class='"+((rowcnt%2)==0 ? "EvenRow" : "OddRow")+"'>");
    }
    else{
      document.writeln("<TBODY class='PageBg'>");
    }
  }
}
function Row_EndHtml(document,rowcnt,id,positioning){
  if (positioning!='T') {
    document.writeln("</DIV>");
  }
  else {
    document.writeln("</TBODY>");
  }
}
/* actually unused*/
function AddRow_BeginHtml(rowcnt){
  document.writeln("<TR>");
}
/* actually unused*/
function AddRow_EndHtml(rowcnt){
  document.writeln("</TR>");
}
function GroupColor(deep){
  var colorClass;
  switch(deep%4){
    case 1:
      colorClass='Group1';
      break;
    case 2:
      colorClass='Group2';
      break;
    case 3:
      colorClass='Group3';
      break;
    case 0:
      colorClass='Group4';
      break;
  }
  return colorClass;
}
function GroupHeader_BeginHtml(document,deep,id,positioning,groupcolor,columned_detail){
  if(groupcolor==null) groupcolor=true;
  if(columned_detail==null) columned_detail=false;

  if(positioning!='T'){
    var s="position:relative";
    if(columned_detail){
      s+=";float:left;clear:both;width:100%";
    }
    if(groupcolor)
      document.writeln("<DIV class='"+GroupColor(deep)+"' id="+id+" style='"+s+"'>");
    else
      document.writeln("<DIV id="+id+" style='"+s+"'>");
  }
  else{
    if(groupcolor)
      document.writeln("<TBODY class='"+GroupColor(deep)+"'>");
    else
      document.writeln("<TBODY>");
  }
}
function GroupHeader_EndHtml(document,deep,id,positioning){
  if(positioning!='T'){
    document.writeln("</DIV>");
  }
  else{
    document.writeln("</TBODY>");
  }
}
function GroupFooter_BeginHtml(document,deep,id,positioning,groupcolor,columned_detail) {
  if(groupcolor==null) groupcolor=true;
  if(columned_detail==null) columned_detail=false;

  if(positioning!='T'){
    var s="position:relative";
    if(columned_detail){
      s+=";float:left;clear:both;width:100%";
    }
    if (groupcolor)
      document.writeln("<DIV class='"+GroupColor(deep)+"' id="+id+" style='"+s+"'>");
    else
      document.writeln("<DIV id="+id+" style='"+s+"'>");
  }
  else{
    if(groupcolor)
      document.writeln("<TBODY class='"+GroupColor(deep)+"'>");
    else
      document.writeln("<TBODY>");
  }
}
function GroupFooter_EndHtml(document,deep,id,positioning){
  if(positioning!='T'){
    document.writeln("</DIV>");
  }
  else {
    document.writeln("</TBODY>");
  }
}
/* actually unused*/
function AddGroupRow_BeginHtml(deep){
  document.writeln("<TR>");
}
/* actually unused*/
function AddGroupRow_EndHtml(){
  document.writeln("</TR>");
}
function Body_Buttons(prev,next,positioning){
  if (!prev && !next) return;

  if(positioning=='T')
    document.writeln("<TR><TD>");

  document.writeln("<TABLE cellspacing='0' cellpadding='0' border='0'>");
  document.writeln("<TR><TD>");
  if (prev) {
    document.writeln("<BUTTON type='button' style='background-color:Transparent;margin:0;border-width:0;padding:0' onclick='DoPrevious()'>");
    document.writeln("<IMG border=0 src='../"+m_cThemePath+"/page/page_back.gif' alt='"+Translate("MSG_PREV_PAGE")+"'></button>");
  }
  document.writeln("</TD><TD>");
  if (next) {
    document.writeln("<BUTTON type='button' style='background-color:Transparent;margin:0;border-width:0;padding:0' onclick='DoNext()'>");
    document.writeln("<IMG border=0 src='../"+m_cThemePath+"/page/page_forward.gif' alt='"+Translate("MSG_NEXT_PAGE")+"'></button>");
  }
  document.writeln("</TD></TR>");
  document.writeln("</TABLE>");

  if(positioning=='T')
    document.writeln("</TD></TR>");
}
function Update_Button(name,caption,image,align,title,style,disabled,positioning){
  if (m_cDecoration=='none') return
  var htmlAlign = 'LEFT';
  switch (align) {
    case 'C':
      htmlAlign = 'CENTER';
      break;
    case 'R':
      htmlAlign = 'RIGHT';
      break;
  }
  if (positioning!='T')
    document.writeln("<TABLE id=TblUpdateBtn width='100%'>");
  document.writeln("<TR>");
  document.writeln("<TD align='"+htmlAlign+"' colspan='100'>");
  AddUpdateButton(name,caption,image,title,style,disabled);
  document.writeln("</TD>");
  document.writeln("</TR>");
  if (positioning!='T')
    document.writeln("</TABLE>");
}
function UpdateRow_Button(name,caption,image,align,title,style,disabled,rownum,positioning){
  if (m_cDecoration=='none') return
  var htmlAlign='LEFT';
  switch(align){
    case 'C':
      htmlAlign='CENTER';
      break;
    case 'R':
      htmlAlign='RIGHT';
      break;
  }
  if(positioning!='T')
    document.writeln("<TABLE width='100%' cellspacing='0' cellpadding='0'>");
  AddRow_BeginHtml(rownum);
  document.writeln("<TD align='"+htmlAlign+"' colspan='100'>");
  AddUpdateButton(name,caption,image,title,style,disabled,rownum);
  document.writeln("</TD>");
  AddRow_EndHtml(rownum);
  if (positioning!='T')
    document.writeln("</TABLE>");
}
function AddUpdateButton(name,caption,image,title,style,disabled,rownum){
  var focus='';
  if (image!=''){
    if(rownum!=null){
      focus="ChangeRow("+rownum+");";
    }
    document.writeln("<A href='javascript:"+focus+"Update()'><IMG "+style+" id='"+name+"' src='"+image+"' border='0' title="+ToHTMLValue(title)+"></IMG></A>");
  }
  else{
    if(rownum!=null){
      focus=" onfocus=ChangeRow("+rownum+") ";
    }
    document.writeln("<INPUT "+style+" name='"+name+disabled+"' type='button' value="+ToHTMLValue(caption)+" onclick='Update()' title="+ToHTMLValue(title)+" "+focus+">");
  }
}
function ColumnedDetailEnd_BeginHtml(){
  document.writeln("<DIV style='float:left;clear:both'>");
}
function ColumnedDetailEnd_EndHtml(){
  document.writeln("</DIV>");
}
