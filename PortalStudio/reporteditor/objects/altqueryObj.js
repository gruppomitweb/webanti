ZTObjects.altqueryObjClass = {
  helper : {
    description : 'Define an alternative datasource and space of objects to insert in the document, as a sub-report',
    usage :  'Fill the Query field, specifying the alternative query to execute. Indicate the options for the query execution'
  },
  newProperties:{
    generic:[
      {name:'query',			propID:'query',			type:'str',					validFunc:'validQueryIndex',			tooltip:'Alternative Query',			defaultValue:''},
      {name:'re execute',		propID:'reexecute',		type:ZTObjects.reexecute_select,					validFunc:'validBarProperty',			defaultValue:'false'
        ,hide_list:{'true':['this.generic_exp'],'false':['this.generic_value_params','this.generic_value_expr','this.generic_execcond']}
        ,show_list:{'true':['this.generic_value_params','this.generic_value_expr','this.generic_execcond'],'false':['this.generic_exp']}
        ,tooltip:'Re excecute query<ul><li>"Execute Query at start (merge-join)" : Query will be executed once, the Expression field will be evaluated for each record. As long as it will be valid (true), the alternative query will be process.</li><li>"Execute Query each time (sub-report)" : Query will be executed each time using the results of Parameters and Values fiels evaluation</li></ul>'
      },
      {name:'expression',			propID:'exp',			type:'exp',			validFunc:'validBarProperty',			tooltip:'Expression to alternate over.<br>As example "reportQuery.c_field = alterQuery.c_field"',			defaultValue:''},
      {name:'parameters',			propID:'value_params',			type:'str',			buttons:'edit',			actions:'LoadQP()',			validFunc:'validBarProperty'
        ,tooltip:'List of query parameters',			defaultValue:''},
      {name:'values',			propID:'value_expr',			type:'str',			buttons:'edit',			actions:'LoadQP()',			validFunc:'validBarProperty'
        ,tooltip:'List of query parameters value',			defaultValue:''},
      {name:'re execute under condition',			propID:'execcond',			type:'exp',			validFunc:'validBarProperty',			tooltip:'Expression to check before query execution',	defaultValue:''}
    ],
    layout:[]
  }
};

ZTObjects.extend( ZTObjects.stdObjLayoutBarClass, ZTObjects.altqueryObjClass );
ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.altqueryObjClass );
ZTObjects.extend( ZTObjects.stdObjOptBarPrintClass, ZTObjects.altqueryObjClass );
ZTObjects.extend( ZTObjects.stdObjOutBarNameClass, ZTObjects.altqueryObjClass, true );

ZTObjects.altqueryObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.altqueryObjClass;
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
  this.page = 1;
  this.value_params = "";
  this.value_expr = "";

  //Non visibili
  this.x = x;
  this.isBand = true;
  this.child = -1;
  this.bcolor = "#606060";
  this.title = "AltQuery detail";
  this.scale = 100;
  this.show = true;
  if ( type.indexOf("_down") >= 0) {
    this.show = false;
  }
  this.hidden = true;
  this.level = 1;
};

ZTObjects.altqueryObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.altqueryObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.altqueryObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.altqueryObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};

ZTObjects.altqueryObj.prototype.getQPKeys = function() {
  return this.value_params;
};

ZTObjects.altqueryObj.prototype.getQPValues = function() {
  return this.value_expr;
};
