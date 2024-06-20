/* exported mergeObject */
function mergeObject(newObj,objConfig,editor){
  var objMerge={}
  var el, i;
  for (el in objConfig){
    if (el!='fields')
      objMerge[el]=objConfig[el]
  }
  for (el in newObj){ // serve nel caso in cui la configurazione non sia completa
    if (el!='fields' && !objMerge[el])
      objMerge[el]=newObj[el]
  }
  objMerge.fields=[];
  objMerge.onOkResource=newObj.onOkResource;
  objMerge.onOkAction=newObj.onOkAction;
  if (objConfig.fields){
    var find;
    for (i=0; i<objConfig.fields.length; i++){
      find=false;
      for (var j=0; j<newObj.fields.length; j++){
        if (newObj.fields[j].fieldName==objConfig.fields[i].fieldName){
          objMerge.fields.push(objConfig.fields[i])
          newObj.fields.splice(j,1);
          j=newObj.fields.length;
          find=true;
        }
      }
      if (!find && (!objConfig.fields[i].isFilter || objConfig.fields[i].itemType=='label' || objConfig.fields[i].itemType=='button' || editor=='report' ))
        objMerge.fields.push(objConfig.fields[i])
    }
  }
  if (newObj.fields){
    for (i=0; i<newObj.fields.length; i++){
      if (newObj.fields[i].isFilter || objConfig.fields[i].itemType=='label' || objConfig.fields[i].itemType=='button' || editor=='report' )
        objMerge.fields.push(newObj.fields[i]);
    }
  }
  objMerge.mode=objConfig.mode;
  return objMerge;
}
