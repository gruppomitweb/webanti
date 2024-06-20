ZTObjects.groupObjClass = {
  helper : {
    description : 'Define a grouping for separate the data into groups in order to make it easily understood',
    usage : 'Fill the "Group break expression" field. The expression will be evaluated at each record. The group break will be executed if the expression value changes'
  },
  newProperties:{
    generic:[
      {name:'group break expression',	propID:'exp',					type:'exp'		,validFunc:'validBarProperty',		tooltip:'Grouping expression',	defaultValue:''}
    ],
    layout:[],
    print_options:[],
    functional:[
      {name:'start each group on new page',							propID:'start_each_on_page',	type:'checkbox'			,validFunc:'validGroupOptions'
        ,tooltip:'Begin a new page for each new data group'
        ,hide_list:{'unchecked':['this.functional_as_page_header'],'checked':[]}
        ,show_list:{'unchecked':['this.functional_reprint_header'],'checked':['this.functional_as_page_header']}
        ,defaultValue:false
      },
      {name:'reprint header on each page',				propID:'reprint_header',		type:'checkbox'			,validFunc:'validGroupOptions'
        ,tooltip:'Reprint group header on new page'
        ,hide_list:{'checked':['this.functional_as_page_header'],'unchecked':[]}
        ,show_list:{'checked':[],'unchecked':['this.functional_as_page_header']}
        ,defaultValue:false, section:"group header"
      },
      {name:'use group header as page header',			propID:'as_page_header',		type:'checkbox'			,validFunc:'validGroupOptions'
        ,tooltip:'Omit page header when group starts on a new page'
        ,hide_list:{'checked':['this.functional_reprint_header'],'unchecked':[]}
        ,show_list:{'checked':[],'unchecked':['this.functional_reprint_header']}
        ,defaultValue:false, section:"group header"
      },
      {name:'print group footer at end of page',							propID:'print_group_footer',	type:'checkbox'			,validFunc:'validGroupOptions'
        ,tooltip:'Align group footer at end of page'
        ,hide_list:{'unchecked':['this.functional_as_page_footer'],'checked':[]}
        ,show_list:{'unchecked':['this.functional_reprint_footer'],'checked':['this.functional_as_page_footer']}
        ,defaultValue:false, section:"group footer"
      },
      {name:'reprint footer on each page',				propID:'reprint_footer',		type:'checkbox'			,validFunc:'validGroupOptions'
        ,tooltip:'Reprint group footer on new page'
        ,hide_list:{'checked':['this.functional_as_page_footer'],'unchecked':[]}
        ,show_list:{'checked':[],'unchecked':['this.functional_as_page_footer']}
        ,defaultValue:false, section:"group footer"
      },
      {name:'use group footer as page footer',			propID:'as_page_footer',		type:'checkbox'			,validFunc:'validGroupOptions'
        ,tooltip:'Omit page footer when this group ends at end of page'
        ,hide_list:{'checked':['this.functional_reprint_footer'],'unchecked':[]}
        ,show_list:{'checked':[],'unchecked':['this.functional_reprint_footer']}
        ,defaultValue:false, section:"group footer"
      }
    ],
    advanced:[
      {name:'rows',										propID:'rows',					type:'int',			validFunc:'validBarProperty'
        ,tooltip:'The number of rows that always will be printed for this group',			defaultValue:0},
      {name:'reset page number',							propID:'reset_page_number',		type:'checkbox',			validFunc:'validBarProperty'
        ,tooltip:'Restart page counter for each group',		defaultValue:false},
      {name:'reset page number expression',				propID:'numpage_expr',			type:'exp',			validFunc:'validBarProperty'
        ,tooltip:'The page number from which reset for each group',			defaultValue:''},
      {name:'expression at group begin',					propID:'ingroup_expr',			type:'exp',			validFunc:'validBarProperty'
        ,tooltip:'Expression called at the start of a new group istance',		defaultValue:''},
      {name:'expression at group end',					propID:'outgroup_expr',			type:'exp',			validFunc:'validBarProperty'
        ,tooltip:'Expression called at the end of a group istance',			defaultValue:''}
    ]
  }
};

ZTObjects.extend( ZTObjects.stdObjLayoutBarClass, ZTObjects.groupObjClass );
ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.groupObjClass );
ZTObjects.extend( ZTObjects.stdObjBlockClass, ZTObjects.groupObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutBarNameClass, ZTObjects.groupObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOptBarPrintClass, ZTObjects.groupObjClass );

ZTObjects.groupObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.groupObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.html = "";
  this.value = value;
  this.shadow = shadow;

 //Generic
  this.comment = name;
  this.name = name;
  this.y = y;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  //this.bb_sequence = nBarItems;
  this.page = 1;

 //Non visibili
  this.x = x;
  this.scale = 100;
  this.isBand = true;
  this.child = -1;
  this.bcolor = "#18B5F7";
  this.title = "Group";
  this.show = true;
  if ( type.indexOf("_down") >= 0) {
    this.show = false;
  }
  this.hidden = true;
  this.level = 1;
};

ZTObjects.groupObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.groupObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.groupObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.groupObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};
