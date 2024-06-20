<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
%><!DOCTYPE html>
<html lang="en">
<head>
  <title>Select a Table</title>
  <link type="text/css" rel="stylesheet" href="portalzoom.css">
  <link type="text/css" rel="stylesheet" href="../portalstudio/nanoScrollerMT.css">
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
  <script type="text/javascript">
  <%
    boolean offlinemode = sp.getParameter("offlinemode",false);
  %>
  var CSV_SEP="#!$";
  var allTables=new Array();
  var pos_list = -1;
  var visibleItems = [];
  var offlinemode= <%=offlinemode%>;
  var frontendport = "<%=sp.getParameter("frontendport",0)%>";
  var SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
  function getOpener() {
    return (window.opener?window.opener:(window.caller?window.caller:window.parent));
  }
  function ReloadTables() {
    GetTables(); //Richiede la lista delle tabelle al server e li salva nell'array "allTables"
    document.id("dictUl").empty();
    for (var i=0; i<allTables.length; i++){
      DrawDictLi(allTables[i][1], allTables[i][0], allTables[i][5], i);
    }

    var lines=$$('.file-item');
    lines.each(function(el){
      el.addEvents({
        'mouseenter':function(){
          this.setStyle('background','#f3f3f3');
        },
        'mouseleave':function(){
          this.setStyle('background','#FFFFFF');
        },
        'click':function(){
            $$('.selected-file').each(function(elm){
                elm.removeClass('selected-file');
            });
            el.addClass('selected-file');
            pos_list = visibleItems.indexOf(el)
        },
        'dblclick': selectZoom
      });
      visibleItems.push(el);
    });
  }
  function DoLoad(){
    ReloadTables();
    var searchContainer = document.id('search');
    var search = document.id('search-file');
    visibleItems = $$('.file-item');
    searchContainer.makeDraggable({
      handle:document.id('search-handler'),
      limit: {x:[0],y:[0]},
      onStart: function(el){
        el.setStyles({
          'opacity':0.5
        });
      },
      onComplete: function(el) {
        el.setStyles({
          'opacity':1
        });
      }
    });
    document.id('search-title').addEvent('click',function(){
      document.id('search-description').removeClass('tabrightactive');
      this.addClass('tabrightactive');
      wheretofind = 'name';
      $$('.description').each(function(el){
          el.innerHTML = el.get('text');
      });
      searchP();
    });
    document.id('search-description').addEvent('click',function(){
      document.id('search-title').removeClass('tabrightactive');
      this.addClass('tabrightactive');
      wheretofind = 'description';
      $$('.name').each(function(el){
          el.innerHTML = el.get('text');
      });
      searchP();
    });
    document.id('clear').addEvent('click',function(){
      search.value = "";
      search.fireEvent('keyup');
    });
    document.id('open').addEvent('click',function(evt){
      selectZoom(evt,document.id("dictUl").getElement(".selected-file"));
    });
    document.id('cancel').addEvent('click',function(){
      if(!Empty(SPModalLayerId))
        getOpener().closeSPModalLayer();
      else
        window.close();
    });
    search.value = '';
    search.focus();
    var searchTimer = null;
    currValue = "";
    found = false;
    wheretofind = 'name';
    search.addEvents({
      'keyup':function(){
        if(currValue != search.value){
          clearTimeout(searchTimer);
          if(search.value.length>2 || search.value.length==0)
            searchTimer = searchP.delay(500);
          found = false;
        }
      } ,
      'keydown':function(e){
         if(e.key=='down'){
          e.stopPropagation();
          e.preventDefault()
          slideList('down')
        }
        if(e.key=='up'){
          e.stopPropagation();
          e.preventDefault()
          slideList('up')
        }
        if(e.key =='enter'){
          e.stopPropagation();
          e.preventDefault()
           if(visibleItems[pos_list] != undefined)
              visibleItems[pos_list].fireEvent('dblclick')
        }
      }
    });
    document.id('offline').getElements('div').each(function(el){
      el.addEvent('click',function(){
        document.id('offline').getElements('.active').removeClass('active');
        this.addClass('active');
        if(this.textContent.toLowerCase() == 'offline'){
          offlinemode=true;
        }else
          offlinemode=false;
        ReloadTables();
      })
    });
    document.body.addEvent('keydown',function(e){
       if(e.key=='down'){
        e.stopPropagation();
        e.preventDefault()
        slideList('down')
      }
      if(e.key=='up'){
        e.stopPropagation();
        e.preventDefault()
        slideList('up')
      }
      if(e.key =='enter'){
        e.stopPropagation();
        e.preventDefault()
         if( pos_list != -1 && visibleItems[pos_list] != undefined)
            visibleItems[pos_list].fireEvent('dblclick')
      }
    })
    resizePage();
  }

  function slideList(move){
    switch(move){
      case 'down':
        pos_list = (pos_list+1)<visibleItems.length ? (pos_list+1) : 0
        break;
      case 'up':
        pos_list = (pos_list-1)>=0 ? (pos_list -1) : (visibleItems.length -1)
        break;
      case 'first':
        pos_list = 0;
        break;
      case 'last':
        pos_list = (visibleItems.length -1) >= 0 ? (visibleItems.length -1) : 0
        break;
    }
  //Controllo che l'item sia selezionato sia visibile altrimenti scrollo l'elenco fino a portare l'item in centro
   if(visibleItems[pos_list] != undefined){
    // alert(visibleItems[pos_list].getPosition().y)
    // alert(visibleItems[pos_list].getScroll().y)
    // alert($('list').getScrollSize().y)
    // alert($('list').getSize().y)
      var list = document.id('dictContainer')
      var itm = visibleItems[pos_list]
      if((itm.getPosition().y+list.getScroll().y) > (list.getScroll().y+list.getSize().y)) {
         list.scrollTo(0, ((itm.getPosition().y+list.getScroll().y)- list.getSize().y/2 ) )
      }
      if(((itm.getPosition().y+list.getScroll().y)-50)  < (list.getScroll().y)){
        list.scrollTo(0, (((itm.getPosition().y+list.getScroll().y)-itm.getSize().y) - list.getSize().y/2 ) )
      }
      visibleItems[pos_list].fireEvent('click')
    }
  }

  function GetTables(){
    var oTable;
    tablesCSV = new JSURL("../servlet/SPXDCProxy?action=tables&offlinemode="+offlinemode+"&tmptbl=true", true);
    tablesCSV = tablesCSV.Response();
    allTables=[];
    //Se mancano le librerie sul server
    if (At("ACCESS DENIED", tablesCSV)>0){
      alert("Access Denied.");
    }
    else if (At("ClassNotFoundException: SPXDCProxy", tablesCSV)>0){
      alert("Installation incomplete.");
    } else {
      oTables = tablesCSV.split(CSV_SEP);
      if (oTables[0]=="* --- Visual Query Tables 1.0 ---*") {
        for (var i=1; i<oTables.length; i++){
          if (!Empty(oTables[i])){
            oTable = oTables[i].split("|");
            allTables[i-1] = new Array(oTable[0], oTable[1], null, null, oTable[2], oTable[3].replace(/\.offline/gi, ''));
          }
        }
        allTables.sort(TablesSortFunc);
      }
      else {
        alert("Server Error:\n\n"+tablesCSV);
      }
    }
  }

  function DrawDictLi(tDesc, tName, tModule, index){
    var dictUl = document.id("dictUl");
    var dictLi = new Element('li',{'class':'itemListLeft'}).inject(dictUl)
    var dictDiv = new Element('div',{'class':'file-item', 'index':index}).inject(dictLi)
    var name = new Element('p',{'text':tName,'class':'name'}).inject(dictDiv)
    var desc = new Element('p',{'text':tDesc + ' - ' + tModule,'class':'description'}).inject(dictDiv)
  }
  function TablesSortFunc(a, b){
    var aa = a[5].toLowerCase();
    var bb = b[5].toLowerCase();
    if (aa > bb) return 1;
    if (aa < bb) return -1;
    aa = a[1].toLowerCase();
    bb = b[1].toLowerCase();
    if (aa > bb) return 1;
    if (aa < bb) return -1;
    return 0;
  }
  function selectZoom(evt,el){
    el=el||this;
    if (el.getElement('.name') != ""){
      var tableName=el.getElement('.name').innerText||el.getElement('.name').textContent;
      getOpener().newCurrentObj("["+tableName+"]",'portalzoom',{offlinemode:offlinemode,frontendport:frontendport});
      if(!Empty(SPModalLayerId))
        getOpener().closeSPModalLayer();
      else
        window.close();
    }
  }
  function searchP(){
    var search = document.id('search-file');
    var txtToSearch = (search.value.trim()).toLowerCase();
    currValue = txtToSearch;
    if(txtToSearch != "") visibleItems = [];
    var lines=$$('.file-item');
    lines.each(function(el,index){
      if(!el.retrieve('origStored')){
        var targetName = el.getElement('.name');
        var targetDescr = el.getElement('.description');
        targetName.store('origText',targetName.get('text'));
        if(targetDescr){
          targetDescr.store('origText',targetDescr.get('text'));
        }
        el.store('origStored',true);
      }
      if(txtToSearch != ""){
        var target = el.getElement('.'+wheretofind)
        var txt = (target) ? (target.get('text')).toLowerCase() : '';
        // el.setStyle('display','none')
        el.hide();
        el.removeClass('filtered');
        if(txt != "" && txt.indexOf(txtToSearch) != -1){
          found = true;
          var re = new RegExp(txtToSearch,"g");
          var nTxt = txt.replace(re,"<span style='color:#454545;font-weight:bold;background:#D8DFEA;'>"+txtToSearch+"</span>")
          target.innerHTML = nTxt;
          el.show();
          el.addClass('filtered')
          visibleItems.push(el)
        }
      }else{
        var targetName = el.getElement('.name');
        var targetDescr = el.getElement('.description');
        // el.setStyle('display','block');
        el.show();
        if(targetDescr){
          targetDescr.innerHTML = targetDescr.retrieve('origText');
        }
        targetName.innerHTML = targetName.retrieve('origText');
        visibleItems.push(el)
      }
    });
    slideList('first')
  }
  function resizePage(){
    document.id('dictContainer').setStyles({'height': document.body.getSize().y  - document.id('dictCaption').getSize().y- document.id('offline').getSize().y - document.id('confirm_cancel').getSize().y})
    document.id('dictContainer').nanoScrollerMT();
  }

  </script>
</head>
<body onload="DoLoad()" onResize="resizePage()">
  <div>
    <div id="dictCaption">
       <b>Select a Table</b>
    </div>
     <div id="offline">
      <div class="offline-tab<%=(offlinemode?"":" active")%>">OnLine</div>
      <div class="offline-tab<%=(offlinemode?" active":"")%>">OffLine</div>
    </div>
    <div id="dictTable">
      <div id="dictTablesDiv">
        <div id="dictContainer" class="tableBackgroundDiv">
          <div style="display: inline-block; width:100%;" id="list">
            <ul id="dictUl" style="overflow:hidden;">
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!--tr style="height:18px" id="FindInputTr">
      <td class="contornointerno" colspan='2' align='center'>
        <table id="dictTablesTitles" style="width:100%" onselectstart="return false" border="" cellspacing="0">
         <tr><td>
            <label  class="label" onselectstart="return false">Find description:</label>
            <input id="tableDesc" type="text" style="width:165px" maxlength="100">
          </td><td>
            <label class="label"  onselectstart="return false">Find name:</label>
            <input id="tableName" type="text" style="width:165px" maxlength="100">
         </td></tr>
         </table>

      </td>
    </tr-->
    <!--tr style="height:18px" id="FindButtonTr">
      <td class="contornointerno" colspan='2' align='center'>
          <!--input type="button" value="Find" class="bottoni" onclick="Find();">
          <input type="button" value="Find Next" class="bottoni" onclick="Find(true);"> &nbsp; &nbsp;>
          <input type="button" value="Select" class="bottoni" onclick="SelectTable()">
          <input type="button" value="Cancel" class="bottoni" onclick="window.close();">
      </td>
    </tr-->
  </div>
  <div id='confirm_cancel' >
    <input type='button' id='open' value='OPEN' />
    <input type='button' id='cancel' value='CANCEL' />
  </div>
  <div id="search">
    <div id="search-container">
      <div id="search-handler">
      <div id="search-title" class="tabright tabrightactive">
          Title
        </div><div id="search-description"class="tabright">
          Description
        </div>

        <p><label for="search-file">Search:</label></p>
      </div>
      <div id="clear"></div>
      <input id="search-file" type="text" value="" />
    </div>
  </div>
</body>
</html>
