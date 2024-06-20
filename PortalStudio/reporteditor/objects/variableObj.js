ZTObjects.variableObjClass={
  newProperties:{
    generic:[
      {name:'comment',					propID:'comment',			type:'str',					validFunc:'validVariableComment',												tooltip:'Comment',							defaultValue:''},
      {name:'variable type',		propID:'type_value',	type:ZTObjects.type_select,				tooltip:'Variable type'
        ,hide_list:{'character':['generic.dec'],'logic':['generic.dec'],'date':['generic.dec'],'datetime':['generic.dec'],'memo':['generic.dec'],'numeric':[]}
        ,show_list:{'character':[],'logic':[],'date':[],'datetime':[],'memo':[],'numeric':['generic.dec']}
        ,defaultValue:'character'},
      {name:'value',						propID:'value',				type:'exp',												tooltip:'Initial value',		defaultValue:''},
      {name:'length',						propID:'len',					type:'int',												tooltip:'Variable type length',							defaultValue:'10'},
      {name:'decimal digits',		propID:'dec',					type:'int',												tooltip:'Decimal digits of the Variable type',							defaultValue:''},
      {name:'name',							propID:'name',				type:'str',					validFunc:'validVariableName',							tooltip:'Unique identifier for the Variable in the current report'}      
    ]
  }
};

ZTObjects.variableObj = function(id, name, type){
  this.objClass = ZTObjects.variableObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.name = name;
  this.type = type;
  this.updateHTML = false;
  this.show = true;
  this.hidden = true;
  this.allPages = true;
};

ZTObjects.variableObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.variableObj.prototype.readDef = function (def) {
  readStandardDef(def, reportVariables);
};

ZTObjects.variableObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def, reportVariables);
};