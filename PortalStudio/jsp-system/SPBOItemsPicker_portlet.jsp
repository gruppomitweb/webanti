<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var jItems;\nvar isMicrozones = false;\nvar itemsData = [],zonesData = [], orderedData = [];\nvar zonesStructured = []; \u002f\u002f Array di zone [nomeZona:[items json],childs[..]]\nvar existingBaseline = 0;\nfunction fillDataItems(){\n  if(!Empty(this.selectedBO.Value())){\n    \u002f\u002fLeggo gli items dal BO\n    this.callBO.Servlet(this.selectedBO.Value());\n    this.callBO.Link();\n  }\n}\n\nfunction callBO_Result(JsonItems){\n  JsonItems=Strtran(JsonItems,'\\u0080','\\u20AC');\n  JsonItems = Strtran(JsonItems, '$\\\\u003e', '%\\\\u003e');\n  JsonItems = Strtran(JsonItems, '\\\\u003c%', '\\\\u003c%');\n  jItems = JSON.parse(JsonItems);\n  jItems.shift(); \u002f\u002f Levo il Form\n  itemsData = [];\n  \u002f\u002fordino gli items per  page e per y\n  jItems.sort( (a,b) =\u003e {\n    if(a.page\u003eb.page){\n      return 1;\n    }\n    if(a.page\u003cb.page){\n      return -1;\n    }\n    if( parseInt(a.y) \u003e parseInt(b.y)){\n      return 1;\n    }else{\n      return -1;\n    }\n  });\n  \u002f\u002fRiempio il Dataprovider\n  for(let i in jItems){\n    if(jItems[i].type!='Form'){\n      var name = (!Empty(jItems[i].value) ? jItems[i].value : jItems[i].name);\n      itemsData.push([jItems[i].type,name,jItems[i].spuid,jItems[i].comment,jItems[i].page,0]);\n    }\n  } \n  this.get_zones_btn_Click();\n  \u002f\u002fthis.StaticDataProvider6.FillData(itemsData); \n}\n\nfunction callBO_Error(cCause){\n  console.log(cCause);\n}\n\nfunction bopick_icon_Click(){\n  var offlinemode = false;\n  var the_property = 'selectedBO';\n  var portletId = this.formid;\n  window.layerOpenForeground(\"..\u002fjsp-system\u002fSPVQREditorSelectBO_portlet.jsp?hideLinkedTables=true&offlinemode=\"+offlinemode+'&propRef='+the_property+\"&isForm=false&portletId=\"+portletId,\"BO_Picker\",'',500,500,false,1);\n  \u002f\u002fopenSPModalLayer(\"..\u002fjsp-system\u002fSPVQREditorSelectBO_portlet.jsp?hideLinkedTables=true&offlinemode=\"+offlinemode+'&propRef='+the_property+'&isForm=false', 100, 200, 500, 500, false, 1, false,false);\n}\n\nfunction selectedBO_onChange(){\n  GetOpener().formProp['altInterfaceFor'] = this.selectedBO.Value();\n  if(Empty(GetOpener().formProp['selectZone'])){\n    GetOpener().formProp['selectZone'] = 'true';\n  }\n  GetOpener().FormProperties();\n  this.fillDataItems();\n}\nfunction this_EnablePage2(){\n  return !Empty(this.selectedBO.Value());\n}\nfunction this_AfterPageChange(n,oldn){\n  if(n==2 && jItems==null){\n    this.fillDataItems();\n  }\n}\n\nfunction this_Loaded(){\n  if(!Empty(this.selectedBO.Value())){\n    this.ZtTabs.Select('page2')\n  }\n}\n\nfunction get_items_btn_Click(){\n  isMicrozones = false;\n  this.Grid7.ExtendGrid();\n  this.StaticDataProvider6.FillData(itemsData); \n  this.Grid7.initMemCurs();\n  orderedData = [];\n  this.StaticDataProvider7.Data=[];\n  this.StaticDataProvider7.FillData([]);\n}\n\nfunction get_zones_btn_Click(){\n  isMicrozones = true;\n  this.Grid7.ReduceGrid();\n  this.findMicroZones();\n  this.Grid7.initMemCurs();\n  orderedData = [];\n  this.StaticDataProvider7.Data=[];\n  this.StaticDataProvider7.FillData([]);\n}\n\nfunction findMicroZones(){\n  seq =0;\n  var jItemsZones = [];\n  jItemsZones = jItems.slice(0);\n  var zones = []; \u002f\u002f Array di zone [nomeZona:[items json]]\n  var portletZones = []; \u002f\u002fZone presenti nel portlet\n  var currentpage = parseInt(GetOpener().formProp.page);\n  \u002f\u002frecupero le zone giÃ  presenti nel portlet\n  GetOpener().itemsHTML.forEach(item =\u003e {\n    if(!Empty(item.zone)){\n      let f = portletZones.find(z =\u003e {\n        return item.zone == z;\n      })\n      if(!f){\n        portletZones.push(item.zone);\n      }\n    }\n  })\n  \u002f\u002fcalcolo la baseline massima della page corrente gia presente nel disegnatore\n  if( GetOpener().itemsHTML.length \u003e 0 ){\n    existingBaseline = Math.max.apply(Math, GetOpener().itemsHTML.reduce( (acc,o) =\u003e { \n      if( parseInt(o.page) == currentpage ){\n        acc.push(parseInt(o.y)+parseInt(o.h));\n      }\n      return acc; \n    }, [0]));\n  }\n  zones = jItemsZones.reduce( (a,i) =\u003e {\n    let x = a.find( j =\u003e  {\n      return i.zone === j.name;\n    } );\n  \tif( !x ) {\n      a.push({\n      \t\"name\": i.zone,\n        \"items\": [i],\n        \u002f\u002f\"description\": '[ \u003cspan style=\"font-weight:bold\"\u003e' + (Right(i.name,1)=='_'?i.name.substring(0,i.name.lastIndexOf('_'))+':':i.name) + '\u003c\u002fspan\u003e ]'\n        \"description\": '',\n        \"page\": i.page,\n        \"childs\":[]\n      })\n    } else {\n    \tx.items.push(i);\n      \u002f\u002fx.description.push('[ \u003cspan style=\"font-weight:bold\"\u003e' + (Right(i.name,1) == '_'? i.value  : i.name )  + '\u003c\u002fspan\u003e ]';\n    }\n    return a;\n  }, []);\n  \u002f\u002fOrdina le zone per y\n  \u002f\u002f   zones.sort( (a,b) =\u003e {\n\t\u002f\u002f   \treturn ( (parseInt(a.items[0].page) \u003e parseInt(b.items[0].page) && parseInt(a.items[0].y) \u003e parseInt(b.items[0].y)) ? 1 : ((parseInt(a.items[0].page) \u003c parseInt(b.items[0].page) && parseInt(a.items[0].y) \u003c parseInt(b.items[0].y)) ? -1 : 0) );\n\t\u002f\u002f   }); \n  \n  \u002f\u002fOrdina gli itmes per x inversa di modo che nell'Array sono nell ordine di visualizzazione\n  zones.forEach( z =\u003e { \n   z.items.sort( (a,b) =\u003e { return ( parseInt(a.x) \u003e parseInt(b.x)) ? 1 : ( parseInt(a.x) \u003c parseInt(b.x))?-1:0 } )\n  });\n  \n  \u002f\u002fcreo le descrizioni delle zone\n  zones.forEach( z =\u003e { \n    z.items.forEach(zz=\u003e{\n \t\t\tz.description += '[ \u003cspan style=\"font-weight:bold\"\u003e' + (Right(zz.name,1) == '_'? zz.value  : zz.name )  + '\u003c\u002fspan\u003e ]';\n   \t});\n  });\n  \n  \u002f\u002f creo una struttura con le zone nei box\n  zonesStructured = zones.slice(0);\n  buildZonesChilds(zonesStructured,jItemsZones);\n  \u002f\u002fOrdina gli itmes per x inversa di modo che nell'Array sono nell ordine di visualizzazione\n  \n  \n  \u002f\u002fRiempio l'elenco delle microzone nello statidataprovider\n  zonesData = [];\n  for(var i in zones){\n    let checkZone;\n  \tif(!Empty(zones[i].name)){\n      \u002f\u002fNascondo la riga della zona gia presente\n      checkZone = portletZones.find(k =\u003e{\n        return zones[i].name == k;\n      })\n      if(!checkZone){\n        zonesData.push(['Micro zone', zones[i].name, zones[i].name, zones[i].description, zones[i].page, (checkZone ? 1 : 0), zones[i].virtual_name ?? zones[i].name]);\n      }\n    \t\n    }\n  }\n  isMicrozones = true;\n  this.StaticDataProvider6.FillData(zonesData); \n}\n\nfunction buildZonesChilds(zones,jItemsZones){\n  let i = 0;\n  let j = 0;\n  for(i=0;i \u003c zones.length;i++){\n    let zona = zones[i];\n  \u002f\u002fzones.forEach( (zona, i, zs) =\u003e {\n    let zone_id_ = zona.name.substring(0,zona.name.lastIndexOf(\"_\"));\n    let box_container = jItemsZones.find( item =\u003e {\n      return item.spuid === zone_id_;\n    }) \n    if(box_container){\n      let zone_box_container = zones.find( z =\u003e {\n        return z.name === box_container.zone; \u002f\u002f trovo la zona del box contenitore\n      });\n      \n      if( zone_box_container ) {\n        zona.virtual_name = zone_box_container.name + zona.name.substring(zona.name.lastIndexOf(\"_\"));\n      \tvar child_zone = zones.splice(i,1)[0];\n        i--;\n      \tzone_box_container.childs.push( child_zone );\n      \tbuildZonesChilds(zone_box_container.childs,jItemsZones);\n      }\n    }\n    \u002f\u002freturn zona\n   }\n}\n\nvar seq =0 ;\nfunction Grid7_SelectionChange(state){\n  if(state){\n\u002f\u002f     this.Grid7.EnableField('sequence');\n\u002f\u002f     this.Grid7.OpenRow();\n\u002f\u002f     this.Grid7.EditValue('sequence',++seq);\n\u002f\u002f     this.Grid7.CloseRow();\n\u002f\u002f     this.Grid7.DisableField('sequence');\n    this.updateOrderData(this.Grid7.datasource.rs,true)\n  }else{\n\u002f\u002f\t\t seq--;\n    this.updateOrderData(this.Grid7.datasource.rs,false)\n  }\n}\n\nfunction updateOrderData(rs,add){\n\tif(add){\n    \u002f\u002ftype,name,spuid,comment,page,sequence,disabled\n    orderedData.push([rs.type,rs.name,rs.spuid,rs.comment,rs.page,0,rs.virtual_name]);\n    \u002f\u002fthis.StaticDataProvider7.FillData(orderedData);\n    this.StaticDataProvider7.FillExtData('type,name,spuid,comment,page,sequence,virtual_name'.split(','), orderedData);\n  }else{\n  \tlet ind = orderedData.findIndex(k =\u003e k[1] == rs.name);\n    orderedData.splice(ind,1);\n    this.StaticDataProvider7.FillExtData('type,name,spuid,comment,page,sequence,virtual_name'.split(','), orderedData);\n  }\n}\n\nfunction Grid8_Drop(val_obj,drop_obj){\n  \u002f\u002fconsole.log(\"Drop \"+val_obj.value.name + \"in \"+this.Grid8.RowValue('name'))\n  \u002f\u002fSposto gli elementi nell'Array\n  let fromIdx = orderedData.findIndex(k =\u003e k[6] == val_obj.value.virtual_name );\n  let toIdx = orderedData.findIndex(k =\u003e k[6] == this.Grid8.RowValue('virtual_name'));\n  let element = orderedData[fromIdx];\n  orderedData.splice(fromIdx, 1);\n  orderedData.splice(toIdx, 0, element);\n  this.StaticDataProvider7.FillExtData('type,name,spuid,comment,page,sequence,virtual_name'.split(','), orderedData);\n}\n\u002f*\nfunction setDragHTML(){\n  var dragIcon = document.createElement('div');\n  dragIcon.innerHTML='Move this zone';\n  dragIcon.style.textAlign='center';\n  dragIcon.style.width = '150px';\n  dragIcon.style.height = '100px';\n  dragIcon.style.backgroundColor = '#F00';\n  dragIcon.style.fontFamily = \"Open Sans\";\n  dragIcon.style.lineHeight = \"60px\";\n  dragIcon.style.padding = \"10px\";\n  dragIcon.style.opacity = 1;\n  return dragIcon;\n}*\u002f\n\nfunction isZoneInBox(zones,name,isChild,selectedItems){\n  let i , find = false;\n  for(i=0;i\u003czones.length;i++){\n    if(isChild && zones[i].name == name){\n      \u002f\u002fse il container box è presente tra i selezionati\n      \u002f\u002fif(selectedItems.Data.find(s =\u003e{return s[0] == zones[i].name})){\n      return true;\n      \u002f\u002f}\n    }\n    if(!find && zones[i].childs.length\u003e0){\n    \tfind = isZoneInBox(zones[i].childs,name,true,selectedItems);\n    }\n  }\n  return find;\n}\n\nfunction import_sel_Click(){\n  var jSelectedItems = [];\n  \u002f\u002fvar selectedItems = this.Grid7.GetSelectedData();\n  var selectedItems = orderedData;\n  var currentpage = GetOpener().formProp.page;\n  if(isMicrozones){\n    var baseline = 20 + existingBaseline;\n    var curPage = 1;\n    var oldPage = 1;\n    let delta = 0;\n    for(let ii in orderedData){\n      let zoney1=100000,zoney2=0;\n      let isBox = false,isInBox = false;\n      \u002f\u002fCeco il limite massimo(zoney2) e minimo(zoney1) della zona\n      for(var i in jItems){\n        var y,h;\n        if(jItems[i].type!='Form' && jItems[i].zone == orderedData[ii][1]){\n          curPage = parseInt(jItems[i].page);\n          y = parseInt(jItems[i].y);\n          h = parseInt(jItems[i].h);\n          if(y \u003c= zoney1){\n            zoney1 = y;\n          }\n          if(y + h \u003e= zoney2){\n            zoney2 = y + h;\n          }\n        }\n      }\n      if(this.Grid7.AllChecked() && oldPage!=curPage ){\n      \tbaseline = 20;\n         oldPage=curPage;\n      }\n      \u002f\u002fCerco la zona nell'array strutturato per vedere se Ã¨ contenuto in un box\n      isInBox = isZoneInBox(zonesStructured,orderedData[ii][1],false,orderedData);\n      if(!isInBox){\n        delta = zoney1 - baseline;\n        baseline = baseline + (zoney2 - zoney1) + 20;\n      }\n      \n      for(let i in jItems){\n        if(jItems[i].type != 'Form' && jItems[i].zone == orderedData[ii][1]){\n          jItems[i].y = parseInt(jItems[i].y) - delta;\n          \u002f\u002fInserisco gli item nella pagina corrente del disegnatore ma se c'è selectAll \n          if(!this.Grid7.AllChecked()){\n            jItems[i].page = currentpage;\n          }\n          jSelectedItems.push(jItems[i]);\n        }\n      }\n    }\n  }else{\n    for(let ii in orderedData){\n      for( let i in jItems){\n        if(jItems[i].type != 'Form' && jItems[i].spuid == orderedData[ii][2]){\n          jSelectedItems.push(jItems[i]);\n        }\n      }\n    }  \n  }\n  GetOpener().b_reload = true;\n  \u002f\u002fSe è un nuovo portlet imposto le dimensioni del Form\n  if(GetOpener().itemsHTML.length==0){\n    \u002f\u002fcalcolo l'area max degli elementi selezionati da dare al form\n    let maxRight = Math.max.apply(Math, jSelectedItems.reduce( (acc,o) =\u003e {\n          if( o.page == 1 ){\n            acc.push( parseInt(o.x) + parseInt(o.w) );\n          }\n          return acc; \n        },[]));\n    let maxBottom = Math.max.apply(Math, jSelectedItems.reduce( (acc,o) =\u003e {\n          if( o.page == 1 ){\n            acc.push( parseInt(o.y) + parseInt(o.h) );\n          }\n          return acc; \n        },[]));\n    jSelectedItems.unshift({\"type\":\"Form\", \"w\":maxRight+20, \"h\":maxBottom+20});\n  }\n  GetOpener().reload_(jSelectedItems,true,true);\n  window.close();\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":2,\"specific_states_value\":{\"normal\":{\"cursor\":\"move\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"dragColumn\",\"selector\":\".dragColumn\",\"id\":\"form\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"{{ @Label12 }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ import_sel_Copy }}{{ @get_zones_btn }}{{ @get_zones_btn }}{{ get_zones_btn_Copy }}{{ @get_items_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid7_Copy }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid7_Copy }}{{ @Label4 }}{{ @Grid7 }}{{ @import_sel }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label12 }}{{ @import_sel }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label12 }}{{ @import_sel }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label12 }}{{ @import_sel }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label12 }}{{ @import_sel }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label12 }}{{ @import_sel }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label12 }}{{ @import_sel }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label12 }}{{ @import_sel }}{{ @Grid8 }}{{ @Label4 }}{{ @Grid7 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Grid8 }}{{ @Label12 }}{{ @import_sel }}{{ @Label4 }}{{ @Grid8 }}{{ @import_sel }}{{ @Grid7 }}{{ @Label12 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid8 }}{{ @import_sel }}{{ @Grid7 }}{{ @Label12 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid8 }}{{ @import_sel }}{{ @Grid7 }}{{ @Label12 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}{{ @Label4 }}{{ @Grid8 }}{{ @import_sel }}{{ @Grid7 }}{{ @Label12 }}{{ @selectedBO }}{{ @Label17 }}{{ @bopick_icon }}{{ @get_zones_btn }}{{ @get_items_btn }}","grapesCss":"","h":"580,580,580","hsl":"","htmlcode":"{{ @Label12 }}\n{{ @import_sel }}\n{{ @Grid8 }}\n\n\n\n{{ @Label4 }}\n{{ @Grid7 }}\n\n{{ @selectedBO }}\n{{ @Label17 }}\n{{ @bopick_icon }}\n{{ @get_zones_btn }}\n{{ @get_items_btn }}\n{{ get_items_btn }}\n{{ get_zones_btn }}\n{{ callBO }}\n{{ Label4 }}\n{{ StaticDataProvider6 }}\n{{ Grid7 }}\n{{ import_sel }}\n{{ selectedBO }}\n{{ Label17 }}\n{{ bopick_icon }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":",,","pages":"1,2","pagesProp":"[{\"title\":\"Select the BO\",\"layer\":\"\",\"h\":\"580\",\"w\":\"780\",\"layout_steps_values\":{}},{\"title\":\"Select the items\",\"layer\":\"\",\"h\":\"580\",\"w\":\"1100\",\"layout_steps_values\":{}},{\"title\":\"Sort Items\",\"layer\":\"\",\"h\":\"580\",\"w\":\"780\",\"layout_steps_values\":{}}]","pages_names":"Select the BO,Select the items,Sort Items","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"780,1100,780","wizard":"true"},{"allowedentities":"","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"function","name":"callBO","offline":"false","page":"2","parms":"m_cAction=createportlet","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"1","servlet":"","target":"","type":"SPLinker","w":"120","x":"552","y":"-47"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label TitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label4","nowrap":"false","page":"2","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Items","w":"159","wireframe_props":"align,value,n_col","x":"38","y":"31","zindex":"2","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"virtual_name\",\"title\":\"name\u002fcaption\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"dragColumn\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":true,\"droppable_name\":\"bbb\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"name\",\"title\":\"name\u002fcaption\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"dragColumn\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"20%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":true,\"droppable_name\":\"bbb\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"comment\",\"title\":\"description\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"dragColumn\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"60%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":true,\"droppable_name\":\"bbb\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"type\",\"title\":\"type\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"10%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":true,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"page\",\"title\":\"page\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"5%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":true,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"spuid\",\"title\":\"spuid\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"5%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":true,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"StaticDataProvider7","disabled_fld":"","draggable_name":"bbb","draggable_row":"true","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"487","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid8","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"SQLDataobj13","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","print_totals":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"1000","scroll_bars":"infinite_scroll","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"525","wireframe_props":"colProperties,checkbox,rows","x":"553","y":"76","zindex":"5","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"import_sel","page":"2","sequence":"3","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Import items","w":"125","wireframe_props":"value","x":"945","y":"31","zindex":"1","zone":""},{"alias":"type,name,spuid,comment,page,disabled,virtual_name","auto_exec":"true","dataproviders":"","fieldsType":"C,C,C,C,C,N,C","h":"20","man_query":"","name":"StaticDataProvider6","page":"2","parms":"","parms_source":"","sequence":"4","type":"StaticDataProvider","w":"120","x":"678","y":"-45"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true-selectAllOfPage","checkbox_fields":"spuid","colProperties":"[{\"field\":\"name\",\"title\":\"name\u002fcaption\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"20%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"virtual_name\",\"title\":\"name\u002fcaption\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"comment\",\"title\":\"description\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"60%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"type\",\"title\":\"type\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"10%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":true,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"page\",\"title\":\"page\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"5%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":true,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"spuid\",\"title\":\"spuid\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"5%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":true,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"StaticDataProvider6","disabled_fld":"disabled","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"487","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid7","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"SQLDataobj13","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","print_totals":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"1000","scroll_bars":"infinite_scroll","sequence":"5","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"500","wireframe_props":"colProperties,checkbox,rows","x":"34","y":"76","zindex":"5","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label TitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"33","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label12","nowrap":"false","page":"2","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Sort items by dragging up or down","w":"365","wireframe_props":"align,value,n_col","x":"563","y":"32","zindex":"8","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"selectedBO","page":"1","password":"","picker":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"179","wireframe_props":"name","x":"66","y":"95","zerofilling":"false","zindex":"6","zone":"","zoom":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label17","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select BO","w":"200","wireframe_props":"align,value,n_col","x":"68","y":"62","zindex":"7","zone":""},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"26","help_tips":"Pick a BO","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"bopick_icon","page":"1","path_type":"","sequence":"9","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"26","wireframe_props":"","x":"249","y":"92","zindex":"2","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"Show Micro Zones","hide":"true","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"get_zones_btn","page":"2","sequence":"10","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Show Micro Zones","w":"125","wireframe_props":"value","x":"342","y":"31","zindex":"1","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"Show Items","hide":"true","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"get_items_btn","page":"2","sequence":"11","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Show Items","w":"125","wireframe_props":"value","x":"204","y":"31","zindex":"1","zone":""},{"alias":"type,name,spuid,comment,page,virtual_name","auto_exec":"true","dataproviders":"","fieldsType":"C,C,C,C,C,C","h":"20","man_query":"","name":"StaticDataProvider7","page":"2","parms":"","parms_source":"","sequence":"12","type":"StaticDataProvider","w":"120","x":"815","y":"-43"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:selectedBO*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));
if(sp.getParameter("SpStaticCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/javascript");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
window.SPBOItemsPicker_Static=function(){
if(typeof fillDataItems !='undefined')this.fillDataItems=fillDataItems;
if(typeof callBO_Result !='undefined')this.callBO_Result=callBO_Result;
if(typeof callBO_Error !='undefined')this.callBO_Error=callBO_Error;
if(typeof bopick_icon_Click !='undefined')this.bopick_icon_Click=bopick_icon_Click;
if(typeof selectedBO_onChange !='undefined')this.selectedBO_onChange=selectedBO_onChange;
if(typeof this_EnablePage2 !='undefined')this.this_EnablePage2=this_EnablePage2;
if(typeof this_AfterPageChange !='undefined')this.this_AfterPageChange=this_AfterPageChange;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof get_items_btn_Click !='undefined')this.get_items_btn_Click=get_items_btn_Click;
if(typeof get_zones_btn_Click !='undefined')this.get_zones_btn_Click=get_zones_btn_Click;
if(typeof findMicroZones !='undefined')this.findMicroZones=findMicroZones;
if(typeof buildZonesChilds !='undefined')this.buildZonesChilds=buildZonesChilds;
if(typeof Grid7_SelectionChange !='undefined')this.Grid7_SelectionChange=Grid7_SelectionChange;
if(typeof updateOrderData !='undefined')this.updateOrderData=updateOrderData;
if(typeof Grid8_Drop !='undefined')this.Grid8_Drop=Grid8_Drop;
if(typeof setDragHTML !='undefined')this.setDragHTML=setDragHTML;
if(typeof isZoneInBox !='undefined')this.isZoneInBox=isZoneInBox;
if(typeof import_sel_Click !='undefined')this.import_sel_Click=import_sel_Click;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.StaticDataProvider7.addRowConsumer(this.Grid8);
this.StaticDataProvider6.addRowConsumer(this.Grid7);
var jItems;
var isMicrozones = false;
var itemsData = [],zonesData = [], orderedData = [];
var zonesStructured = []; // Array di zone [nomeZona:[items json],childs[..]]
var existingBaseline = 0;
function fillDataItems(){
  if(!Empty(this.selectedBO.Value())){
    //Leggo gli items dal BO
    this.callBO.Servlet(this.selectedBO.Value());
    this.callBO.Link();
  }
}
function callBO_Result(JsonItems){
  JsonItems=Strtran(JsonItems,'\u0080','\u20AC');
  JsonItems = Strtran(JsonItems, '$\\u003e', '%\\u003e');
  JsonItems = Strtran(JsonItems, '\\u003c%', '\\u003c%');
  jItems = JSON.parse(JsonItems);
  jItems.shift(); // Levo il Form
  itemsData = [];
  //ordino gli items per  page e per y
  jItems.sort( (a,b) => {
    if(a.page>b.page){
      return 1;
    }
    if(a.page<b.page){
      return -1;
    }
    if( parseInt(a.y) > parseInt(b.y)){
      return 1;
    }else{
      return -1;
    }
  });
  //Riempio il Dataprovider
  for(let i in jItems){
    if(jItems[i].type!='Form'){
      var name = (!Empty(jItems[i].value) ? jItems[i].value : jItems[i].name);
      itemsData.push([jItems[i].type,name,jItems[i].spuid,jItems[i].comment,jItems[i].page,0]);
    }
  } 
  this.get_zones_btn_Click();
  //this.StaticDataProvider6.FillData(itemsData); 
}
function callBO_Error(cCause){
  console.log(cCause);
}
function bopick_icon_Click(){
  var offlinemode = false;
  var the_property = 'selectedBO';
  var portletId = this.formid;
  window.layerOpenForeground("../jsp-system/SPVQREditorSelectBO_portlet.jsp?hideLinkedTables=true&offlinemode="+offlinemode+'&propRef='+the_property+"&isForm=false&portletId="+portletId,"BO_Picker",'',500,500,false,1);
  //openSPModalLayer("../jsp-system/SPVQREditorSelectBO_portlet.jsp?hideLinkedTables=true&offlinemode="+offlinemode+'&propRef='+the_property+'&isForm=false', 100, 200, 500, 500, false, 1, false,false);
}
function selectedBO_onChange(){
  GetOpener().formProp['altInterfaceFor'] = this.selectedBO.Value();
  if(Empty(GetOpener().formProp['selectZone'])){
    GetOpener().formProp['selectZone'] = 'true';
  }
  GetOpener().FormProperties();
  this.fillDataItems();
}
function this_EnablePage2(){
  return !Empty(this.selectedBO.Value());
}
function this_AfterPageChange(n,oldn){
  if(n==2 && jItems==null){
    this.fillDataItems();
  }
}
function this_Loaded(){
  if(!Empty(this.selectedBO.Value())){
    this.ZtTabs.Select('page2')
  }
}
function get_items_btn_Click(){
  isMicrozones = false;
  this.Grid7.ExtendGrid();
  this.StaticDataProvider6.FillData(itemsData); 
  this.Grid7.initMemCurs();
  orderedData = [];
  this.StaticDataProvider7.Data=[];
  this.StaticDataProvider7.FillData([]);
}
function get_zones_btn_Click(){
  isMicrozones = true;
  this.Grid7.ReduceGrid();
  this.findMicroZones();
  this.Grid7.initMemCurs();
  orderedData = [];
  this.StaticDataProvider7.Data=[];
  this.StaticDataProvider7.FillData([]);
}
function findMicroZones(){
  seq =0;
  var jItemsZones = [];
  jItemsZones = jItems.slice(0);
  var zones = []; // Array di zone [nomeZona:[items json]]
  var portletZones = []; //Zone presenti nel portlet
  var currentpage = parseInt(GetOpener().formProp.page);
  //recupero le zone giÃ  presenti nel portlet
  GetOpener().itemsHTML.forEach(item => {
    if(!Empty(item.zone)){
      let f = portletZones.find(z => {
        return item.zone == z;
      })
      if(!f){
        portletZones.push(item.zone);
      }
    }
  })
  //calcolo la baseline massima della page corrente gia presente nel disegnatore
  if( GetOpener().itemsHTML.length > 0 ){
    existingBaseline = Math.max.apply(Math, GetOpener().itemsHTML.reduce( (acc,o) => { 
      if( parseInt(o.page) == currentpage ){
        acc.push(parseInt(o.y)+parseInt(o.h));
      }
      return acc; 
    }, [0]));
  }
  zones = jItemsZones.reduce( (a,i) => {
    let x = a.find( j =>  {
      return i.zone === j.name;
    } );
  	if( !x ) {
      a.push({
      	"name": i.zone,
        "items": [i],
        //"description": '[ <span style="font-weight:bold">' + (Right(i.name,1)=='_'?i.name.substring(0,i.name.lastIndexOf('_'))+':':i.name) + '</span> ]'
        "description": '',
        "page": i.page,
        "childs":[]
      })
    } else {
    	x.items.push(i);
      //x.description.push('[ <span style="font-weight:bold">' + (Right(i.name,1) == '_'? i.value  : i.name )  + '</span> ]';
    }
    return a;
  }, []);
  //Ordina le zone per y
  //   zones.sort( (a,b) => {
	//   	return ( (parseInt(a.items[0].page) > parseInt(b.items[0].page) && parseInt(a.items[0].y) > parseInt(b.items[0].y)) ? 1 : ((parseInt(a.items[0].page) < parseInt(b.items[0].page) && parseInt(a.items[0].y) < parseInt(b.items[0].y)) ? -1 : 0) );
	//   }); 
  
  //Ordina gli itmes per x inversa di modo che nell'Array sono nell ordine di visualizzazione
  zones.forEach( z => { 
   z.items.sort( (a,b) => { return ( parseInt(a.x) > parseInt(b.x)) ? 1 : ( parseInt(a.x) < parseInt(b.x))?-1:0 } )
  });
  
  //creo le descrizioni delle zone
  zones.forEach( z => { 
    z.items.forEach(zz=>{
 			z.description += '[ <span style="font-weight:bold">' + (Right(zz.name,1) == '_'? zz.value  : zz.name )  + '</span> ]';
   	});
  });
  
  // creo una struttura con le zone nei box
  zonesStructured = zones.slice(0);
  buildZonesChilds(zonesStructured,jItemsZones);
  //Ordina gli itmes per x inversa di modo che nell'Array sono nell ordine di visualizzazione
  
  
  //Riempio l'elenco delle microzone nello statidataprovider
  zonesData = [];
  for(var i in zones){
    let checkZone;
  	if(!Empty(zones[i].name)){
      //Nascondo la riga della zona gia presente
      checkZone = portletZones.find(k =>{
        return zones[i].name == k;
      })
      if(!checkZone){
        zonesData.push(['Micro zone', zones[i].name, zones[i].name, zones[i].description, zones[i].page, (checkZone ? 1 : 0), zones[i].virtual_name ?? zones[i].name]);
      }
    	
    }
  }
  isMicrozones = true;
  this.StaticDataProvider6.FillData(zonesData); 
}
function buildZonesChilds(zones,jItemsZones){
  let i = 0;
  let j = 0;
  for(i=0;i < zones.length;i++){
    let zona = zones[i];
  //zones.forEach( (zona, i, zs) => {
    let zone_id_ = zona.name.substring(0,zona.name.lastIndexOf("_"));
    let box_container = jItemsZones.find( item => {
      return item.spuid === zone_id_;
    }) 
    if(box_container){
      let zone_box_container = zones.find( z => {
        return z.name === box_container.zone; // trovo la zona del box contenitore
      });
      
      if( zone_box_container ) {
        zona.virtual_name = zone_box_container.name + zona.name.substring(zona.name.lastIndexOf("_"));
      	var child_zone = zones.splice(i,1)[0];
        i--;
      	zone_box_container.childs.push( child_zone );
      	buildZonesChilds(zone_box_container.childs,jItemsZones);
      }
    }
    //return zona
   }
}
var seq =0 ;
function Grid7_SelectionChange(state){
  if(state){
//     this.Grid7.EnableField('sequence');
//     this.Grid7.OpenRow();
//     this.Grid7.EditValue('sequence',++seq);
//     this.Grid7.CloseRow();
//     this.Grid7.DisableField('sequence');
    this.updateOrderData(this.Grid7.datasource.rs,true)
  }else{
//		 seq--;
    this.updateOrderData(this.Grid7.datasource.rs,false)
  }
}
function updateOrderData(rs,add){
	if(add){
    //type,name,spuid,comment,page,sequence,disabled
    orderedData.push([rs.type,rs.name,rs.spuid,rs.comment,rs.page,0,rs.virtual_name]);
    //this.StaticDataProvider7.FillData(orderedData);
    this.StaticDataProvider7.FillExtData('type,name,spuid,comment,page,sequence,virtual_name'.split(','), orderedData);
  }else{
  	let ind = orderedData.findIndex(k => k[1] == rs.name);
    orderedData.splice(ind,1);
    this.StaticDataProvider7.FillExtData('type,name,spuid,comment,page,sequence,virtual_name'.split(','), orderedData);
  }
}
function Grid8_Drop(val_obj,drop_obj){
  //console.log("Drop "+val_obj.value.name + "in "+this.Grid8.RowValue('name'))
  //Sposto gli elementi nell'Array
  let fromIdx = orderedData.findIndex(k => k[6] == val_obj.value.virtual_name );
  let toIdx = orderedData.findIndex(k => k[6] == this.Grid8.RowValue('virtual_name'));
  let element = orderedData[fromIdx];
  orderedData.splice(fromIdx, 1);
  orderedData.splice(toIdx, 0, element);
  this.StaticDataProvider7.FillExtData('type,name,spuid,comment,page,sequence,virtual_name'.split(','), orderedData);
}
function isZoneInBox(zones,name,isChild,selectedItems){
  let i , find = false;
  for(i=0;i<zones.length;i++){
    if(isChild && zones[i].name == name){
      //se il container box è presente tra i selezionati
      //if(selectedItems.Data.find(s =>{return s[0] == zones[i].name})){
      return true;
      //}
    }
    if(!find && zones[i].childs.length>0){
    	find = isZoneInBox(zones[i].childs,name,true,selectedItems);
    }
  }
  return find;
}
function import_sel_Click(){
  var jSelectedItems = [];
  //var selectedItems = this.Grid7.GetSelectedData();
  var selectedItems = orderedData;
  var currentpage = GetOpener().formProp.page;
  if(isMicrozones){
    var baseline = 20 + existingBaseline;
    var curPage = 1;
    var oldPage = 1;
    let delta = 0;
    for(let ii in orderedData){
      let zoney1=100000,zoney2=0;
      let isBox = false,isInBox = false;
      //Ceco il limite massimo(zoney2) e minimo(zoney1) della zona
      for(var i in jItems){
        var y,h;
        if(jItems[i].type!='Form' && jItems[i].zone == orderedData[ii][1]){
          curPage = parseInt(jItems[i].page);
          y = parseInt(jItems[i].y);
          h = parseInt(jItems[i].h);
          if(y <= zoney1){
            zoney1 = y;
          }
          if(y + h >= zoney2){
            zoney2 = y + h;
          }
        }
      }
      if(this.Grid7.AllChecked() && oldPage!=curPage ){
      	baseline = 20;
         oldPage=curPage;
      }
      //Cerco la zona nell'array strutturato per vedere se Ã¨ contenuto in un box
      isInBox = isZoneInBox(zonesStructured,orderedData[ii][1],false,orderedData);
      if(!isInBox){
        delta = zoney1 - baseline;
        baseline = baseline + (zoney2 - zoney1) + 20;
      }
      
      for(let i in jItems){
        if(jItems[i].type != 'Form' && jItems[i].zone == orderedData[ii][1]){
          jItems[i].y = parseInt(jItems[i].y) - delta;
          //Inserisco gli item nella pagina corrente del disegnatore ma se c'è selectAll 
          if(!this.Grid7.AllChecked()){
            jItems[i].page = currentpage;
          }
          jSelectedItems.push(jItems[i]);
        }
      }
    }
  }else{
    for(let ii in orderedData){
      for( let i in jItems){
        if(jItems[i].type != 'Form' && jItems[i].spuid == orderedData[ii][2]){
          jSelectedItems.push(jItems[i]);
        }
      }
    }  
  }
  GetOpener().b_reload = true;
  //Se è un nuovo portlet imposto le dimensioni del Form
  if(GetOpener().itemsHTML.length==0){
    //calcolo l'area max degli elementi selezionati da dare al form
    let maxRight = Math.max.apply(Math, jSelectedItems.reduce( (acc,o) => {
          if( o.page == 1 ){
            acc.push( parseInt(o.x) + parseInt(o.w) );
          }
          return acc; 
        },[]));
    let maxBottom = Math.max.apply(Math, jSelectedItems.reduce( (acc,o) => {
          if( o.page == 1 ){
            acc.push( parseInt(o.y) + parseInt(o.h) );
          }
          return acc; 
        },[]));
    jSelectedItems.unshift({"type":"Form", "w":maxRight+20, "h":maxBottom+20});
  }
  GetOpener().reload_(jSelectedItems,true,true);
  window.close();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.SPBOItemsPicker_container .dragColumn{  cursor: move;
}
.SPBOItemsPicker_container {
}
.SPBOItemsPicker_portlet{
  position:relative;
  min-width:780px;
  height:580px;
  background-color:#F3F3F3;
}
.SPBOItemsPicker_portlet[Data-page="1"]{
  height:580px;
  width:780px;
}
.SPBOItemsPicker_portlet[Data-page="2"]{
  height:580px;
  width:1100px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label4_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:31px;
  left:38px;
  width:159px;
  height:auto;
  min-height:25px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label4_ctrl {
  height:auto;
  min-height:25px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label4_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Grid8_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:76px;
  left:553px;
  width:525px;
  height:487px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .import_sel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:31px;
  left:945px;
  width:125px;
  height:28px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .import_sel_ctrl {
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Grid7_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:76px;
  left:34px;
  width:500px;
  height:487px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label12_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:32px;
  left:563px;
  width:365px;
  height:auto;
  min-height:33px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label12_ctrl {
  height:auto;
  min-height:33px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label12_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .selectedBO_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:95px;
  left:66px;
  width:179px;
  height:20px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .selectedBO_ctrl {
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .selectedBO_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label17_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:62px;
  left:68px;
  width:200px;
  height:auto;
  min-height:20px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label17_ctrl {
  height:auto;
  min-height:20px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .Label17_ctrl {
  overflow:hidden;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .bopick_icon_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:92px;
  left:249px;
  width:26px;
  height:26px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .bopick_icon_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:26px;
  font-size:26px;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .get_zones_btn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:31px;
  left:342px;
  width:125px;
  height:25px;
  display:none;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .get_zones_btn_ctrl {
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .get_items_btn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:31px;
  left:204px;
  width:125px;
  height:25px;
  display:none;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .get_items_btn_ctrl {
}
<%}else if(sp.getParameter("SpWireframe","").equals("true")){
String containerId=sp.getParameter("containerID",idPortlet);
Library.SetMimeType(response,"text/html");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
PrintWireFrame(containerId,out);
%>
<%!
void PrintWireFrame(String containerId, java.io.Writer out) throws java.lang.Throwable {
 String def="[{\"h\":\"580,580,580\",\"layout_steps_values\":{},\"pages_names\":\"Select the BO,Select the items,Sort Items\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"780,1100,780\",\"wizard\":\"true\"},{\"h\":\"20\",\"page\":\"2\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"552\",\"y\":\"-47\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Select Items\",\"w\":\"159\",\"x\":\"38\",\"y\":\"31\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"name\\u002fcaption\"},{\"title\":\"name\\u002fcaption\"},{\"title\":\"description\"},{\"title\":\"type\"},{\"title\":\"page\"},{\"title\":\"spuid\"}],\"h\":\"487\",\"layout_steps_values\":{},\"page\":\"2\",\"rows\":\"1000\",\"type\":\"Grid\",\"w\":\"525\",\"x\":\"553\",\"y\":\"76\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Button\",\"value\":\"Import items\",\"w\":\"125\",\"x\":\"945\",\"y\":\"31\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"678\",\"y\":\"-45\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true-selectAllOfPage\",\"colProperties\":[{\"title\":\"name\\u002fcaption\"},{\"title\":\"name\\u002fcaption\"},{\"title\":\"description\"},{\"title\":\"type\"},{\"title\":\"page\"},{\"title\":\"spuid\"}],\"h\":\"487\",\"layout_steps_values\":{},\"page\":\"2\",\"rows\":\"1000\",\"type\":\"Grid\",\"w\":\"500\",\"x\":\"34\",\"y\":\"76\",\"zindex\":\"5\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"33\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Sort items by dragging up or down\",\"w\":\"365\",\"x\":\"563\",\"y\":\"32\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"selectedBO\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"179\",\"x\":\"66\",\"y\":\"95\",\"zindex\":\"6\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label17\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Select BO\",\"w\":\"200\",\"x\":\"68\",\"y\":\"62\",\"zindex\":\"7\"},{\"anchor\":\"top-left\",\"h\":\"26\",\"layout_steps_values\":{},\"name\":\"bopick_icon\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"26\",\"x\":\"249\",\"y\":\"92\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"get_zones_btn\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"Show Micro Zones\",\"w\":\"125\",\"x\":\"342\",\"y\":\"31\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"get_items_btn\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"Show Items\",\"w\":\"125\",\"x\":\"204\",\"y\":\"31\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"StaticDataProvider7\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"815\",\"y\":\"-43\"}]";
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("stdFunctions.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("portalstudio/renderDef.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("visualweb/itemsObj.js")+"'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../visualweb/itemsObj.css'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../portalstudio/renderDef.css'></script>\n");
 out.write("<div id="+JSPLib.ToHTMLValue(containerId)+"></div>\n");
 out.write("<script> /*JS_MARKER_START*/\n");
 out.write("new renderDef({\n");
 out.write("def: "+def+",\n");
 out.write("container: '"+JSPLib.ToJSValue(containerId)+"',\n");
 out.write("replaceContainer: true\n");
 out.write("})\n");
 out.write("/*JS_MARKER_END*/ </script>\n");
}/**/%>
<%}else{
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPBOItemsPicker","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPBOItemsPicker_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
ZtVWeb.RequireLibrary('<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>');
<%String variantTabstrip=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantTabstrip != null) { %> ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');<%}%>
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<% sp.WritePortalStudioCSS(request, out); 
if(Library.IsMobile(request)){%><%}%>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .get_zones_btn_ctrl {
  display:none;
}
.SPBOItemsPicker_portlet > .SPBOItemsPicker_page > .get_items_btn_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPBOItemsPicker','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label4= "Select Items";
if(request.getAttribute("SPBOItemsPicker_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%if(request.getAttribute("SPBOItemsPicker_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
String Label12= "Sort items by dragging up or down";
String selectedBO=JSPLib.translateXSS(sp.getParameter("selectedBO",""));
if(request.getAttribute("SPBOItemsPicker_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label17= "Select BO";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPBOItemsPicker_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPBOItemsPicker_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPBOItemsPicker','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPBOItemsPicker_page' style='display:block'>
<span class='textbox-container'id='<%=idPortlet%>_selectedBO_wrp'><input id='<%=idPortlet%>_selectedBO' name='selectedBO' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='selectedBO' /></span>
<span id='<%=idPortlet%>_Label17'  formid='<%=idPortlet%>' ps-name='Label17'    class='label Label17_ctrl'><div id='<%=idPortlet%>_Label17tbl' style='width:100%;'><%=JSPLib.ToHTML("Select BO")%></div></span>
<a id='<%=idPortlet%>_bopick_icon' class='image-default bopick_icon_ctrl'  href='javascript:void(0)' target='_self'>&#xe9fb;</a>
</div>
<div id='<%=idPortlet%>_page_2' class='SPBOItemsPicker_page' style='display:none'>
<span id='<%=idPortlet%>_Label4'  formid='<%=idPortlet%>' ps-name='Label4'    class='label TitleLabel Label4_ctrl'><div id='<%=idPortlet%>_Label4tbl' style='width:100%;'><%=JSPLib.ToHTML("Select Items")%></div></span>
<div id='<%=idPortlet%>_Grid8' formid='<%=idPortlet%>' ps-name='Grid8'  data-transfer='bbb' class='grid' style=''>&nbsp;</div>
<input id='<%=idPortlet%>_import_sel' type='button' class='button import_sel_ctrl'/>
<div id='<%=idPortlet%>_Grid7' formid='<%=idPortlet%>' ps-name='Grid7'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_Label12'  formid='<%=idPortlet%>' ps-name='Label12'    class='label TitleLabel Label12_ctrl'><div id='<%=idPortlet%>_Label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Sort items by dragging up or down")%></div></span>
<input id='<%=idPortlet%>_get_zones_btn' type='button' class='button get_zones_btn_ctrl'/>
<input id='<%=idPortlet%>_get_items_btn' type='button' class='button get_items_btn_ctrl'/>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPBOItemsPicker');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPBOItemsPicker_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:true, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Select the BO"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Select the items"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPBOItemsPicker',["780","1100","780"],["580","580","580"],'portlet',<%=sp.isOfflineInstallation()%>,true,m_cSPPageletId,'', '','','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"780","h":"580","title":"Select the BO","layer":""},{"layout_steps_values":{},"w":"1100","h":"580","title":"Select the items","layer":""},{"layout_steps_values":{},"w":"780","h":"580","title":"Sort Items","layer":""}]);
this.callBO=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_callBO","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"callBO","offline":false,"page":2,"parms":"m_cAction=createportlet","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":120,"x":552,"y":-47});
this.callBO.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.Label4=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_Label4","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label4","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label4,false,true)%>","type":"Label","w":159,"x":38,"y":31,"zindex":"2"});
this.Grid8=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid8","dataobj":"StaticDataProvider7","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":487,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid8","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"SQLDataobj13","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":525,"x":553,"y":76,"zindex":"5"});
this.Grid8.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"true","hide_default_titles":false,"rows":1000,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"dragColumn","font_size":"","link":"","fixedwidth":"","title":"name\u002fcaption","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":true,"bg_color":"","field":"virtual_name","droppable_name":"bbb","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"dragColumn","font_size":"","link":"","fixedwidth":"20%","title":"name\u002fcaption","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":true,"bg_color":"","field":"name","droppable_name":"bbb","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"dragColumn","font_size":"","link":"","fixedwidth":"60%","title":"description","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":true,"bg_color":"","field":"comment","droppable_name":"bbb","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"10%","title":"type","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":true,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"type","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"5%","title":"page","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":true,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"page","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"5%","title":"spuid","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":true,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"spuid","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.import_sel=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button import_sel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_import_sel","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"import_sel","page":2,"spuid":"","tabindex":"","text":"Import items","type":"Button","type_submit":"false","type_wizard":"","w":125,"x":945,"y":31,"zindex":"1"});
this.StaticDataProvider6=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataProvider6","dataproviders":"","fieldsString":"type,name,spuid,comment,page,disabled,virtual_name","fieldstypeString":"C,C,C,C,C,N,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataProvider6","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":678,"y":-45});
this.Grid7=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true-selectAllOfPage","checkbox_fields":"spuid","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid7","dataobj":"StaticDataProvider6","disabled_fld":"disabled","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":487,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid7","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"SQLDataobj13","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":500,"x":34,"y":76,"zindex":"5"});
this.Grid7.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":1000,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"20%","title":"name\u002fcaption","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"name","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"name\u002fcaption","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"virtual_name","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"60%","title":"description","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"comment","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"10%","title":"type","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":true,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"type","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"5%","title":"page","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":true,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"page","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"5%","title":"spuid","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":true,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"spuid","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Label12=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_Label12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":33,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label12","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label12,false,true)%>","type":"Label","w":365,"x":563,"y":32,"zindex":"8"});
this.selectedBO=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectedBO","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"selectedBO","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(selectedBO,false,true)%>","w":179,"x":66,"y":95,"zerofilling":false,"zindex":"6","zoom":""});
this.Label17=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label17","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label17","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label17,false,true)%>","type":"Label","w":200,"x":68,"y":62,"zindex":"7"});
this.bopick_icon=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default bopick_icon_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_bopick_icon","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":26,"help_tips":"<%=JSPLib.ToJSValue("Pick a BO",false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"bopick_icon","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":26,"x":249,"y":92,"zindex":"2"});
 ZtVWeb.RequireFont("icons8_win10","");
this.get_zones_btn=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button get_zones_btn_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_get_zones_btn","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"Show Micro Zones","hide":"true","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"get_zones_btn","page":2,"spuid":"","tabindex":"","text":"Show Micro Zones","type":"Button","type_submit":"false","type_wizard":"","w":125,"x":342,"y":31,"zindex":"1"});
this.get_items_btn=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button get_items_btn_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_get_items_btn","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"Show Items","hide":"true","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"get_items_btn","page":2,"spuid":"","tabindex":"","text":"Show Items","type":"Button","type_submit":"false","type_wizard":"","w":125,"x":204,"y":31,"zindex":"1"});
this.StaticDataProvider7=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataProvider7","dataproviders":"","fieldsString":"type,name,spuid,comment,page,virtual_name","fieldstypeString":"C,C,C,C,C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataProvider7","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":815,"y":-43});
<%if(!Library.Empty(PageletId) ){%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
<%}%>

}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
<%=idPortlet%>_tabstrip.Select('page1');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPBOItemsPicker_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPBOItemsPicker_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPBOItemsPicker_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.bopick_icon.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','SPBOItemsPicker',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPBOItemsPicker');
/*JS_MARKER_END*/
</script>
<%if(!included){%>
</body>
<%}
}finally{
}%>
<%if(!included){%>
</html>
<%}
sp.endPage("SPBOItemsPicker");
}%>
<%! public String getJSPUID() { return "2138502151"; } %>