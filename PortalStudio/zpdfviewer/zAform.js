
/*
Implementazione metodi calcolo semplice di Acrobat
Riferimento Aform.js
*/

/*  exported AFSimple_Calculate
*/
/*
    global zZoneNames milSep decSep

*/

function AFSimple_Calculate(funcName, objArray) {
	function _AFPRD(v1, v2){
		return v1*v2;
	}

	function _AFSUM(v1, v2){
		return v1 + v2;
	}

	function _AFMIN(v1, v2){
		return Math.min(v1, v2);
	}

	function _AFMAX(v1, v2){
		return Math.max(v1, v2);
	}

	var ret = AFMakeNumber(getField(objArray[0]).value);
	for(var i=1; i<objArray.length; i++){
		var v = AFMakeNumber(getField(objArray[i]).value);
		if( funcName == "PRD"){
			ret = _AFPRD(ret, v);
		}
		if( funcName == "SUM" || funcName == "AVG"){
			ret = _AFSUM(ret, v);
		}
		if( funcName == "MIN"){
			ret = _AFMIN(ret, v);
		}
		if( funcName == "MAX"){
			ret = _AFMAX(ret, v);
		}
	}
	if( objArray.length > 1 && funcName == "AVG" )
		ret = ret / objArray.length;
	return ret;
}

function AFMakeNumber(obj) {
	try{
		if(!obj)
			return 0;
		if(Empty(obj))
			return 0;
		var sNum = obj.replace(milSep, "");
		sNum = sNum.replace(decSep, ".");
		return parseFloat(sNum);
	}
	catch(e){
	}
	return 0;
}

function getField(fieldName) {
	var ret = {};
	ret.value = "";
	try{
		if(zZoneNames!=null && zZoneNames[fieldName] != null ){
			var obj = zZoneNames[fieldName];
			ret.value =  obj.defaultvalue;
		}
	}
	catch(e){
		ret.value = "";
	}
	return ret;
}