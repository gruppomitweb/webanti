// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
/* exported dragstartx dragstarty newx newy mainitem index infindex nitem itemsHTML */
var dragstartx,dragstarty,newx,newy,mainitem
var index  // indice corrente del mainitem  nell'Array
var infindex
var nitem=0     // numero item crescente
var itemsHTML=new Array();

if(typeof(ZTObjects)=='undefined'){
	var ZTObjects=new function(){
		this.formObjClass={
			newProperties:{
			}
		};

		this.formObj=function() {
			this.objClass = ZTObjects.formObjClass;
			this.h=600;
			this.w=600;
		};
	}
}
