/*
PluginDetect v0.8.1
www.pinlady.net/PluginDetect/license/
[ getVersion isMinVersion hasMimeType onWindowLoaded onDetectionDone getInfo beforeInstantiate ]
[ AdobeReader PDF.js PDFreader(OTF & NOTF) ]
*/
var PluginDetect={version:"0.8.1",name:"PluginDetect",openTag:"<",isDefined:function(b){return typeof b!="undefined"
},isArray:function(b){return(/array/i).test(Object.prototype.toString.call(b))
},isFunc:function(b){return typeof b=="function"
},isString:function(b){return typeof b=="string"
},isNum:function(b){return typeof b=="number"
},isStrNum:function(b){return(typeof b=="string"&&(/\d/).test(b))
},getNumRegx:/[\d][\d\.\_,\-]*/,splitNumRegx:/[\.\_,\-]/g,getNum:function(b,c){var d=this,a=d.isStrNum(b)?(d.isDefined(c)?new RegExp(c):d.getNumRegx).exec(b):null;
return a?a[0]:null
},compareNums:function(h,f,d){var e=this,c,b,a,g=parseInt;
if(e.isStrNum(h)&&e.isStrNum(f)){if(e.isDefined(d)&&d.compareNums){return d.compareNums(h,f)
}c=h.split(e.splitNumRegx);
b=f.split(e.splitNumRegx);
for(a=0;
a<Math.min(c.length,b.length);
a++){if(g(c[a],10)>g(b[a],10)){return 1
}if(g(c[a],10)<g(b[a],10)){return -1
}}}return 0
},formatNum:function(b,c){var d=this,a,e;
if(!d.isStrNum(b)){return null
}if(!d.isNum(c)){c=4
}c--;
e=b.replace(/\s/g,"").split(d.splitNumRegx).concat(["0","0","0","0"]);
for(a=0;
a<4;
a++){if(/^(0+)(.+)$/.test(e[a])){e[a]=RegExp.$2
}if(a>c||!(/\d/).test(e[a])){e[a]="0"
}}return e.slice(0,4).join(",")
},getPROP:function(d,b,a){var c;
try{if(d){a=d[b]
}}catch(c){}return a
},findNavPlugin:function(l,e,c){var j=this,h=new RegExp(l,"i"),d=(!j.isDefined(e)||e)?/\d/:0,k=c?new RegExp(c,"i"):0,a=navigator.plugins,g="",f,b,m;
for(f=0;
f<a.length;
f++){m=a[f].description||g;
b=a[f].name||g;
if((h.test(m)&&(!d||d.test(RegExp.leftContext+RegExp.rightContext)))||(h.test(b)&&(!d||d.test(RegExp.leftContext+RegExp.rightContext)))){if(!k||!(k.test(m)||k.test(b))){return a[f]
}}}return null
},getMimeEnabledPlugin:function(k,m,c){var e=this,f,b=new RegExp(m,"i"),h="",g=c?new RegExp(c,"i"):0,a,l,d,j=e.isString(k)?[k]:k;
for(d=0;
d<j.length;
d++){if((f=e.hasMimeType(j[d]))&&(f=f.enabledPlugin)){l=f.description||h;
a=f.name||h;
if(b.test(l)||b.test(a)){if(!g||!(g.test(l)||g.test(a))){return f
}}}}return 0
},getVersionDelimiter:",",findPlugin:function(d){var c=this,b,d,a={status:-3,plugin:0};
if(!c.isString(d)){
return a
}if(d.length==1){c.getVersionDelimiter=d;
return a
}d=d.toLowerCase().replace(/\s/g,"");
b=c.Plugins[d];
if(!b||!b.getVersion){
return a
}a.plugin=b;
a.status=1;
return a
},getPluginFileVersion:function(f,b){var h=this,e,d,g,a,c=-1;
if(h.OS>2||!f||!f.version||!(e=h.getNum(f.version))){return b
}if(!b){return e
}e=h.formatNum(e);
b=h.formatNum(b);
d=b.split(h.splitNumRegx);
g=e.split(h.splitNumRegx);
for(a=0;
a<d.length;
a++){if(c>-1&&a>c&&d[a]!="0"){return b
}if(g[a]!=d[a]){if(c==-1){c=a
}if(d[a]!="0"){return b
}}}return e
},AXO:window.ActiveXObject,getAXO:function(a){var d=null,c,b=this;
try{d=new b.AXO(a)
}catch(c){};
return d
},INIT:function(){this.init.library(this)
},init:{$:1,hasRun:0,objProperties:function(d,e,b){var a,c={};
if(e&&b){if(e[b[0]]===1&&!d.isArray(e)&&!d.isFunc(e)&&!d.isString(e)&&!d.isNum(e)){for(a=0;
a<b.length;
a=a+2){
e[b[a]]=b[a+1];
c[b[a]]=1
}}for(a in e){if(!c[a]&&e[a]&&e[a][b[0]]===1){this.objProperties(d,e[a],b)
}}}},publicMethods:function(c,f){var g=this,b=g.$,a,d;
if(c&&f){for(a in c){try{if(b.isFunc(c[a])){f[a]=c[a](f)
}}catch(d){}}}},plugin:function(a,c){var d=this,b=d.$;
if(a){d.objProperties(b,a,["$",b,"$$",a]);
if(!b.isDefined(a.getVersionDone)){a.installed=null;
a.version=null;
a.version0=null;
a.getVersionDone=null;
a.pluginName=c
}}},detectIE:function(){var init=this,$=init.$,doc=document,e,x,userAgent=navigator.userAgent||"",progid,progid1,progid2;
$.isIE=eval("/*@cc_on!@*/!1");
$.verIE=$.isIE?((/MSIE\s*(\d+\.?\d*)/i).test(userAgent)?parseFloat(RegExp.$1,10):7):null;
$.ActiveXEnabled=!1;
$.ActiveXFilteringEnabled=!1;
if($.isIE){try{$.ActiveXFilteringEnabled=window.external.msActiveXFilteringEnabled()
}catch(e){}progid1=["Msxml2.XMLHTTP","Msxml2.DOMDocument","Microsoft.XMLDOM","TDCCtl.TDCCtl","Shell.UIHelper","HtmlDlgSafeHelper.HtmlDlgSafeHelper","Scripting.Dictionary"];
progid2=["WMPlayer.OCX","ShockwaveFlash.ShockwaveFlash","AgControl.AgControl",];
progid=progid1.concat(progid2);
for(x=0;
x<progid.length;
x++){if($.getAXO(progid[x])){$.ActiveXEnabled=!0;
if(!$.dbug){break
}}}if($.ActiveXEnabled&&$.ActiveXFilteringEnabled){for(x=0;
x<progid2.length;
x++){if($.getAXO(progid2[x])){$.ActiveXFilteringEnabled=!1;
break
}}}}},detectNonIE:function(){var e=this,c=this.$,d=navigator,b=c.isIE?"":d.userAgent||"",f=d.vendor||"",a=d.product||"";
c.isGecko=(/Gecko/i).test(a)&&(/Gecko\s*\/\s*\d/i).test(b);
c.verGecko=c.isGecko?c.formatNum((/rv\s*\:\s*([\.\,\d]+)/i).test(b)?RegExp.$1:"0.9"):null;
c.isChrome=(/(Chrome|CriOS)\s*\/\s*(\d[\d\.]*)/i).test(b);
c.verChrome=c.isChrome?c.formatNum(RegExp.$2):null;
c.isSafari=!c.isChrome&&((/Apple/i).test(f)||!f)&&(/Safari\s*\/\s*(\d[\d\.]*)/i).test(b);
c.verSafari=c.isSafari&&(/Version\s*\/\s*(\d[\d\.]*)/i).test(b)?c.formatNum(RegExp.$1):null;
c.isOpera=(/Opera\s*[\/]?\s*(\d+\.?\d*)/i).test(b);
c.verOpera=c.isOpera&&((/Version\s*\/\s*(\d+\.?\d*)/i).test(b)||1)?parseFloat(RegExp.$1,10):null},detectPlatform:function(){var e=this,d=e.$,b,a=navigator.platform||"";
d.OS=100;
if(a){var c=["Win",1,"Mac",2,"Linux",3,"FreeBSD",4,"iPhone",21.1,"iPod",21.2,"iPad",21.3,"Win.*CE",22.1,"Win.*Mobile",22.2,"Pocket\\s*PC",22.3,"",100];
for(b=c.length-2;
b>=0;
b=b-2){if(c[b]&&new RegExp(c[b],"i").test(a)){d.OS=c[b+1];
break
}}}},library:function(c){var e=this,d=document,b,a;
c.init.objProperties(c,c,["$",c]);
for(a in c.Plugins){c.init.plugin(c.Plugins[a],a)
}e.publicMethods(c.PUBLIC,c);

c.win.init();
c.head=d.getElementsByTagName("head")[0]||d.getElementsByTagName("body")[0]||d.body||null;
e.detectPlatform();
e.detectIE();
e.detectNonIE();
c.init.hasRun=1}},handler:function(c,b,a){return function(){c(b,a)
}
},fPush:function(b,a){var c=this;
if(c.isArray(a)&&(c.isFunc(b)||(c.isArray(b)&&b.length>0&&c.isFunc(b[0])))){a.push(b)
}},callArray:function(b){var c=this,a,d;
if(c.isArray(b)){d=[].concat(b);
for(a=0;
a<d.length;
a++){c.call(d[a]);
b.splice(0,1)
}}},call:function(c){var b=this,a=b.isArray(c)?c.length:-1;
if(a>0&&b.isFunc(c[0])){
c[0](b,a>1?c[1]:0,a>2?c[2]:0,a>3?c[3]:0)
}else{if(b.isFunc(c)){
c(b)
}}},PUBLIC:{isMinVersion:function(a){return function(h,g,d,c){var e=a.findPlugin(h),f,b=-1;
if(e.status<0){return e.status
}f=e.plugin;
g=a.formatNum(a.isNum(g)?g.toString():(a.isStrNum(g)?a.getNum(g):"0"));
if(f.getVersionDone!=1){f.getVersion(g,d,c);
if(f.getVersionDone===null){f.getVersionDone=1
}}if(f.installed!==null){b=f.installed<=0.5?f.installed:(f.installed==0.7?1:(f.version===null?0:(a.compareNums(f.version,g,f)>=0?1:-0.1)))
};
return b
}
},getVersion:function(a){return function(g,d,c){var e=a.findPlugin(g),f,b;
if(e.status<0){return null
};
f=e.plugin;
if(f.getVersionDone!=1){f.getVersion(null,d,c);
if(f.getVersionDone===null){f.getVersionDone=1
}}b=(f.version||f.version0);
b=b?b.replace(a.splitNumRegx,a.getVersionDelimiter):b;
return b
}
},getInfo:function(a){return function(g,d,c){var b={},e=a.findPlugin(g),f;
if(e.status<0){return b
};
f=e.plugin;
if(f.getInfo){if(f.getVersionDone===null){a.getVersion?a.getVersion(g,d,c):a.isMinVersion(g,"0",d,c)
}b=f.getInfo()
};
return b
}
},beforeInstantiate:function(a){return function(e,d){var b=a.findPlugin(e),c=b.plugin;
if(b.status==-3){return
};
if(!a.isArray(c.BIfuncs)){c.BIfuncs=[]
}a.fPush(d,c.BIfuncs)
}
},onDetectionDone:function(a){return function(h,g,c,b){var d=a.findPlugin(h),j,e;
if(d.status==-3){return -1
}e=d.plugin;
if(!a.isArray(e.funcs)){e.funcs=[]};
if(e.getVersionDone!=1){j=a.getVersion?a.getVersion(h,c,b):a.isMinVersion(h,"0",c,b)
}if(e.installed!=-0.5&&e.installed!=0.5){
a.call(g);
return 1
}if(e.NOTF){a.fPush(g,e.funcs);
return 0
}return 1
}
},onWindowLoaded:function(a){return function(b){
if(a.win.loaded){
a.call(b)}else{a.fPush(b,a.win.funcs)
}}
},hasMimeType:function(a){return function(c){if(!a.isIE&&c&&navigator&&navigator.mimeTypes){var f,e,b,d=a.isArray(c)?c:(a.isString(c)?[c]:[]);
for(b=0;
b<d.length;
b++){if(a.isString(d[b])&&/[^\s]/.test(d[b])){f=navigator.mimeTypes[d[b]];
e=f?f.enabledPlugin:0;
if(e&&(e.name||e.description)){return f
}}}}return null
}
},z:0},win:{$:1,loaded:false,hasRun:0,init:function(){var b=this,a=b.$;
if(!b.hasRun){b.hasRun=1;
b.addEvent("load",a.handler(b.runFuncs,a));
b.addEvent("unload",a.handler(b.cleanup,a))
}},addEvent:function(c,b){var e=this,d=e.$,a=window;
if(d.isFunc(b)){if(a.addEventListener){a.addEventListener(c,b,false)
}else{if(a.attachEvent){a.attachEvent("on"+c,b)
}else{a["on"+c]=e.concatFn(b,a["on"+c])
}}}},concatFn:function(d,c){return function(){d();
if(typeof c=="function"){c()
}}
},funcs0:[],funcs:[],cleanup:function(b){for(var a in b){b[a]=0
}b=0
},runFuncs:function(a){a.win.loaded=true;
a.callArray(a.win.funcs0);
a.callArray(a.win.funcs);
if(a.DOM){a.DOM.onDoneEmptyDiv()
}},z:0},DOM:{$:1,isEnabled:{$:1,objectTag:function(){var a=this.$;
return a.isIE?a.ActiveXEnabled:1
},objectProperty:function(){var a=this.$;
return a.isIE&&a.verIE>=7?1:0
}},div:null,divID:"plugindetect",divWidth:50,pluginSize:1,altHTML:"&nbsp;&nbsp;&nbsp;&nbsp;",emptyNode:function(c){var b=this,d=b.$,a,f;
if(c&&c.childNodes){for(a=c.childNodes.length-1;
a>=0;
a--){
if(d.isIE){b.setStyle(c.childNodes[a],["display","none"])
}c.removeChild(c.childNodes[a])
}}},LASTfuncs:[],onDoneEmptyDiv:function(){var f=this,g=f.$,b,d,c,a,h;
if(!g.win.loaded||g.win.funcs0.length||g.win.funcs.length){return
}for(b in g.Plugins){d=g.Plugins[b];
if(d){if(d.OTF==3||(d.funcs&&d.funcs.length)){return
}}}g.callArray(f.LASTfuncs);
if(f.div&&f.div.childNodes){for(b=f.div.childNodes.length-1;
b>=0;
b--){c=f.div.childNodes[b];
f.emptyNode(c)}try{f.div.innerHTML=""
}catch(h){}}if(!f.div){a=document.getElementById(f.divID);
if(a){f.div=a
}}if(f.div&&f.div.parentNode){
try{f.div.parentNode.removeChild(f.div)
}catch(h){}f.div=null
}},width:function(){var g=this,e=g.DOM,f=e.$,d=g.span,b,c,a=-1;
b=d&&f.isNum(d.scrollWidth)?d.scrollWidth:a;
c=d&&f.isNum(d.offsetWidth)?d.offsetWidth:a;
return c>0?c:(b>0?b:Math.max(c,b))
},obj:function(b){var g=this,d=g.DOM,c=g.span,f,a=c&&c.firstChild?c.firstChild:null;
try{if(a&&b){d.div.focus()
}}catch(f){}return a
},rs:function(){var b=this,a=b.DOM.$;
return a.isIE?a.getPROP(b.obj(),"readyState"):b.undefined
},getTagStatus:function(a,m,r,p,d,g){var f=/clsid\s*\:/i,o=r&&f.test(r.outerHTML||"")?r:(p&&f.test(p.outerHTML||"")?p:0),h=r&&!f.test(r.outerHTML||"")?r:(p&&!f.test(p.outerHTML||"")?p:0),l=a&&f.test(a.outerHTML||"")?o:h;
if(!a||!a.span||!m||!m.span||!l||!l.span){return -2
}var s=this,c=s.$,q,k=a.width(),j=l.width(),n=m.width(),b=a.readyState(),t=l.readyState();
if(k<0||j<0||n<=s.pluginSize){return 0
}if(s.isEnabled.objectProperty()){var i=c.getPROP(a.obj(),"object");
if(i){return 1.5
}if(g&&!a.pi&&c.isDefined(i)&&c.isIE&&a.tagName==l.tagName&&a.time<=l.time){if(k===j&&b===0&&t!==0){a.pi=1
}}}if(j<n){return a.pi?-0.1:0
}if(k>=n){if(!a.winLoaded&&c.win.loaded){return a.pi?-0.5:-1
}if(c.isNum(d)){if(!c.isNum(a.count2)){a.count2=d
}if(d-a.count2>0){return a.pi?-0.5:-1
}}}try{if(k==s.pluginSize&&(!c.isIE||b===4)){if(!a.winLoaded&&c.win.loaded){return 1
}if(a.winLoaded&&c.isNum(d)){if(!c.isNum(a.count)){a.count=d
}if(d-a.count>=5){return 1
}}}}catch(q){}return a.pi?-0.1:0
},setStyle:function(b,h){var c=this,d=c.$,g=b.style,a,f;
if(g&&h){for(a=0;
a<h.length;
a=a+2){try{g[h[a]]=h[a+1]
}catch(f){}}}},insertDivInBody:function(a,h){var j=this,d=j.$,g,b="pd33993399",c=null,i=h?window.top.document:window.document,f=i.getElementsByTagName("body")[0]||i.body;
if(!f){try{i.write('<div id="'+b+'">.'+d.openTag+"/div>");
c=i.getElementById(b)
}catch(g){}}f=i.getElementsByTagName("body")[0]||i.body;
if(f){f.insertBefore(a,f.firstChild);
if(c){f.removeChild(c)
}}},insert:function(f,b,g,a,l,k){var q=this,i=q.$,m,n=document,s,r,p=n.createElement("span"),o,h,c=["outlineStyle","none","borderStyle","none","padding","0px","margin","0px","visibility","visible"],j="outline-style:none;border-style:none;padding:0px;margin:0px;visibility:"+(k?"hidden;":"visible;")+"display:inline;";
if(!i.isDefined(a)){a=""
}if(i.isString(f)&&(/[^\s]/).test(f)){f=f.toLowerCase().replace(/\s/g,"");
s=i.openTag+f+' width="'+q.pluginSize+'" height="'+q.pluginSize+'" ';
s+='style="'+j+'" ';
for(o=0;
o<b.length;
o=o+2){if(/[^\s]/.test(b[o+1])){s+=b[o]+'="'+b[o+1]+'" '
}}s+=">";
for(o=0;
o<g.length;
o=o+2){if(/[^\s]/.test(g[o+1])){s+=i.openTag+'param name="'+g[o]+'" value="'+g[o+1]+'" />'
}}s+=a+i.openTag+"/"+f+">"
}else{f="";
s=a
}if(!q.div){h=n.getElementById(q.divID);
if(h){q.div=h
}else{q.div=n.createElement("div");
q.div.id=q.divID
}q.setStyle(q.div,c.concat(["width",q.divWidth+"px","height",(q.pluginSize+3)+"px","fontSize",(q.pluginSize+3)+"px","lineHeight",(q.pluginSize+3)+"px","verticalAlign","baseline","display","block"]));
if(!h){q.setStyle(q.div,["position","absolute","right","0px","top","0px"]);
q.insertDivInBody(q.div)
}}r={span:null,winLoaded:i.win.loaded,tagName:f,outerHTML:s,DOM:q,time:new Date().getTime(),width:q.width,obj:q.obj,readyState:q.rs};
if(q.div&&q.div.parentNode){
if(l&&l.BIfuncs&&l.BIfuncs.length){
i.callArray(l.BIfuncs)}
q.setStyle(p,c.concat(["fontSize",(q.pluginSize+3)+"px","lineHeight",(q.pluginSize+3)+"px","verticalAlign","baseline","display","inline"]));
q.div.appendChild(p);
try{p.innerHTML=s
}catch(m){};
r.span=p;
r.winLoaded=i.win.loaded
}return r
}},file:{$:1,any:"fileStorageAny999",valid:"fileStorageValid999",save:function(d,f,c){var b=this,e=b.$,a;
if(d&&e.isDefined(c)){if(!d[b.any]){d[b.any]=[]
}if(!d[b.valid]){d[b.valid]=[]
}d[b.any].push(c);
a=b.split(f,c);
if(a){d[b.valid].push(a)
}}},getValidLength:function(a){return a&&a[this.valid]?a[this.valid].length:0
},getAnyLength:function(a){return a&&a[this.any]?a[this.any].length:0
},getValid:function(c,a){var b=this;
return c&&c[b.valid]?b.get(c[b.valid],a):null
},getAny:function(c,a){var b=this;
return c&&c[b.any]?b.get(c[b.any],a):null
},get:function(d,a){var c=d.length-1,b=this.$.isNum(a)?a:c;
return(b<0||b>c)?null:d[b]
},split:function(g,c){var b=this,e=b.$,f=null,a,d;
g=g?g.replace(".","\\."):"";
d=new RegExp("^(.*[^\\/])("+g+"\\s*)$");
if(e.isString(c)&&d.test(c)){a=(RegExp.$1).split("/");
f={name:a[a.length-1],ext:RegExp.$2,full:c};
a[a.length-1]="";
f.path=a.join("/")
}return f
},z:0},Plugins:{adobereader:{$:1,setPluginStatus:function(){var d=this,b=d.$,a=d.navPlugin.detected,e=d.navPlugin.version,g=d.axo.detected,c=d.axo.version,i=d.doc.detected,h=d.doc.version,f=e||c||h||null;
d.installed=f?1:(a>0||g>0||i>0?0:(i==-0.5?-0.15:(b.isIE&&(!b.ActiveXEnabled||b.ActiveXFilteringEnabled)?-1.5:-1)));
d.version=b.formatNum(f)},getVersion:function(c,e){var a=this,d=a.$,b=0;
if((!b||d.dbug)&&a.navPlugin.query().detected>0){b=1
}if((!b||d.dbug)&&a.axo.query().detected>0){b=1
}if((!b||d.dbug)&&(a.doc.query().detected>0||a.doc.detected==-0.5)){b=1
}a.setPluginStatus()
},navPlugin:{$:1,detected:0,version:null,mimeType:"application/pdf",isDisabled:function(){var c=this,b=c.$,a=c.$$;
return b.isIE||c.detected||!b.hasMimeType(c.mimeType)?1:0
},attempt3:function(){var c=this,b=c.$,a=null;
if(b.OS==1){if(b.hasMimeType("application/vnd.adobe.pdfxml")){a="9"
}else{if(b.hasMimeType("application/vnd.adobe.x-mars")){a="8"
}else{if(b.hasMimeType("application/vnd.adobe.xfdf")){a="6"
}}}}return a
},query:function(){var d=this,c=d.$,a=d.$$,f,e,b=null;
if(d.isDisabled()){return d
};
f="Adobe.*PDF.*Plug-?in|Adobe.*Acrobat.*Plug-?in|Adobe.*Reader.*Plug-?in";
e=c.findNavPlugin(f,0);
d.detected=e?1:-1;
if(e){b=c.getNum(e.description)||c.getNum(e.name);
b=c.getPluginFileVersion(e,b);
if(!b){b=d.attempt3()
}}if(b){d.version=b
};
return d
}},pluginQuery:function(j){var f=this,d=f.$,b="",h=null,g,a,i,c;
try{if(j){b=j.GetVersions()}}catch(g){}if(b&&d.isString(b)){a=/=\s*([\d\.]+)/g;
for(i=0;
i<30;
i++){if(a.test(b)){c=d.formatNum(RegExp.$1);
if(!h||d.compareNums(c>h)>0){h=c
}}else{break
}}}return h
},axo:{$:1,detected:0,version:null,progID:["AcroPDF.PDF","AcroPDF.PDF.1","PDF.PdfCtrl","PDF.PdfCtrl.5","PDF.PdfCtrl.1"],isDisabled:function(){var b=this,c=b.$,a=b.$$;
return c.isIE&&!b.detected?0:1
},query:function(){var d=this,e=d.$,b=d.$$,f=0,c=null,a;
if(d.isDisabled()){return d
};
for(a=0;
a<d.progID.length;
a++){f=e.getAXO(d.progID[a]);
if(f){d.detected=1;
c=b.pluginQuery(f);
if(!e.dbug&&c){break
}}}d.version=c?c:null;
if(d.detected===0){d.detected=-1
};
return d
}},doc:{$:1,detected:0,version:null,classID:"clsid:CA8A9780-280D-11CF-A24D-444553540000",classID_dummy:"clsid:CA8A9780-280D-11CF-A24D-BA9876543210",DummySpanTagHTML:0,HTML:0,DummyObjTagHTML1:0,DummyObjTagHTML2:0,isDisabled:function(){var c=this,b=c.$,a=0;
if(c.detected){a=1
}else{if(b.dbug){}else{if(!b.isIE||!b.DOM.isEnabled.objectTag()){a=1
}}}return a
},query:function(){var i=this,d=i.$,f=i.$$,h=null,a=d.DOM.altHTML,g=null,c=1,e=1,b;
if(i.isDisabled()){return i
};
if(!i.DummySpanTagHTML){i.DummySpanTagHTML=d.DOM.insert("",[],[],a,f,e)
}if(!i.HTML){i.HTML=d.DOM.insert("object",["classid",i.classID],[],a,f,e)
}if(!i.DummyObjTagHTML2){i.DummyObjTagHTML2=d.DOM.insert("object",["classid",i.classID_dummy],[],a,f,e)
}b=d.DOM.getTagStatus(i.HTML,i.DummySpanTagHTML,i.DummyObjTagHTML1,i.DummyObjTagHTML2,g,c);
h=f.pluginQuery(i.HTML.obj());
i.detected=b>0||h?1:(b==-0.1||b==-0.5?-0.5:-1);
i.version=h?h:null;
return i
}}},pdfreader:{$:1,OTF:null,detectIE3P:0,setPluginStatus:function(){var a=this,e=a.$,f=a.doc.result,d=a.mime.result,c=a.axo.result,b=a.OTF;
a.version=null;
if(b==3){a.installed=-0.5
}else{a.installed=f>0||d>0||c>0?0:(f==-0.5?-0.15:(e.isIE&&(!e.ActiveXEnabled||e.ActiveXFilteringEnabled||!a.detectIE3P)?-1.5:-1))
}if(a.verify&&a.verify.isEnabled()){a.getVersionDone=0
}else{if(a.getVersionDone!=1){a.getVersionDone=!a.doc.isDisabled()&&a.installed<=-1?0:1
}}},getVersion:function(k,d,m){var f=this,b=f.$,h=false,c,a,i,g=f.NOTF,l=f.doc,j=f.verify;
if(b.isDefined(m)){f.detectIE3P=m?1:0
}if(f.getVersionDone===null){f.OTF=0;
if(j){j.begin()
}}b.file.save(f,".pdf",d);
if(f.getVersionDone===0){if(l.insertHTMLQuery()>0){h=true
}f.setPluginStatus();
return
}if((!h||b.dbug)&&f.mime.query()>0){h=true
}if((!h||b.dbug)&&f.axo.query()>0){h=true
}if((!h||b.dbug)&&l.insertHTMLQuery()>0){h=true
}f.setPluginStatus()
},mime:{$:1,mimeType:"application/pdf",result:0,isDisabled:function(){var a=this.$;
return a.isIE?1:0
},query:function(){var c=this,b=c.$,a=c.$$;
if(!c.isDisabled()&&!c.result){
c.result=b.hasMimeType(c.mimeType)?1:-1}return c.result
}},axo:{$:1,result:0,progID:["AcroPDF.PDF","AcroPDF.PDF.1","PDF.PdfCtrl","PDF.PdfCtrl.5","PDF.PdfCtrl.1"],prodID3rd:["NitroPDF.IE.ActiveDoc","PDFXCviewIEPlugin.CoPDFXCviewIEPlugin","PDFXCviewIEPlugin.CoPDFXCviewIEPlugin.1","FoxitReader.FoxitReaderCtl","FoxitReader.FoxitReaderCtl.1","FOXITREADEROCX.FoxitReaderOCXCtrl","FOXITREADEROCX.FoxitReaderOCXCtrl.1"],isDisabled:function(){var a=this.$;
return a.isIE?0:1
},query:function(){var c=this,d=c.$,b=c.$$,a;
if(!c.isDisabled()&&!c.result){
c.result=-1;
for(a=0;
a<c.progID.length;
a++){if(d.getAXO(c.progID[a])){c.result=1;
if(!d.dbug){break
}}}if((c.result<0&&b.detectIE3P)||d.dbug){for(a=0;
a<c.prodID3rd.length;
a++){if(d.getAXO(c.prodID3rd[a])){c.result=1;
if(!d.dbug){break
}}}}}return c.result
}},doc:{$:1,result:0,classID:"clsid:CA8A9780-280D-11CF-A24D-444553540000",classID_dummy:"clsid:CA8A9780-280D-11CF-A24D-BA9876543210",mimeType:"application/pdf",mimeType_dummy:"application/dummymimepdf",DummySpanTagHTML:0,HTML:0,DummyObjTagHTML1:0,isDisabled:function(){var d=this,c=d.$,a=d.$$,b=0;
if(a.OTF>=2){b=1
}else{if(c.dbug){}else{if(!c.DOM.isEnabled.objectTag()||(c.isGecko&&c.compareNums(c.verGecko,"2,0,0,0")<=0&&c.OS<=4)||(c.isOpera&&c.verOpera<=11&&c.OS<=4)||(c.isChrome&&c.compareNums(c.verChrome,"10,0,0,0")<0&&c.OS<=4)){b=1
}}}return b
},queryObject:function(c){var f=this,e=f.$,b=f.$$,a=0,d=1;
a=e.DOM.getTagStatus(f.HTML,f.DummySpanTagHTML,f.DummyObjTagHTML1,0,c,d);
f.result=a;
return a
},insertHTMLQuery:function(){var g=this,f=g.$,a=g.$$,b=a.pdf,d=f.file.getValid(a),e=1,c=f.DOM.altHTML;
if(!d||!d.full||g.isDisabled()){return g.result
}if(a.OTF<2){a.OTF=2
};
d=d.full;
if(!g.DummySpanTagHTML){g.DummySpanTagHTML=f.DOM.insert("",[],[],c,a,e)
}if(!g.HTML){g.HTML=f.DOM.insert("object",(f.isIE&&!a.detectIE3P?["classid",g.classID]:["type",g.mimeType]).concat(["data",d]),["src",d],c,a,e)
}if(!g.DummyObjTagHTML1){g.DummyObjTagHTML1=f.DOM.insert("object",(f.isIE&&!a.detectIE3P?["classid",g.classID_dummy]:["type",g.mimeType_dummy]),[],c,a,e)
}g.queryObject();
if(f.isIE&&g.result===0){g.HTML.span.innerHTML=g.HTML.outerHTML;
g.DummyObjTagHTML1.span.innerHTML=g.DummyObjTagHTML1.outerHTML;
g.queryObject()
}if((g.result>0||g.result<-0.1)&&!f.dbug){return g.result
}var h=a.NOTF;
if(a.OTF<3&&g.HTML&&h){a.OTF=3;
h.onIntervalQuery=f.handler(h.$$onIntervalQuery,h);
if(!f.win.loaded){f.win.funcs0.push([h.winOnLoadQuery,h])
}setTimeout(h.onIntervalQuery,h.intervalLength)}return g.result
}},NOTF:{$:1,count:0,countMax:25,intervalLength:250,$$onIntervalQuery:function(d){var b=d.$,a=d.$$,c=a.doc;
if(a.OTF==3){c.queryObject(d.count);
if(c.result||(b.win.loaded&&d.count>d.countMax)){d.queryCompleted()
}}d.count++;
if(a.OTF==3){setTimeout(d.onIntervalQuery,d.intervalLength)
}},winOnLoadQuery:function(b,d){var a=d.$$,c=a.doc;
if(a.OTF==3){c.queryObject(d.count);
d.queryCompleted()
}},queryCompleted:function(){var d=this,b=d.$,a=d.$$,c=a.doc;
if(a.OTF==4){return
}a.OTF=4;
a.setPluginStatus();
if(a.funcs){
b.callArray(a.funcs)}if(b.DOM){b.DOM.onDoneEmptyDiv()
}}},getInfo:function(){var b=this,c=b.$,a={OTF:(b.OTF<3?0:(b.OTF==3?1:2)),DummyPDFused:(b.doc.result>0?true:false)};
return a
},zz:0},pdfjs:{$:1,OTF:null,setPluginStatus:function(){var b=this,c=b.$,d=b.doc.result,a=b.OTF;
b.version=null;
if(a==3){b.installed=-0.5
}else{b.installed=d>0?0:-1
}},getVersion:function(j,f){var d=this,b=d.$,h=false,c,a,i,g=d.NOTF,k=d.doc;
if(d.getVersionDone===null){d.OTF=0
}b.file.save(d,".pdf",f);
if((!h||b.dbug)&&k.insertHTMLQuery()>0){h=true
}d.setPluginStatus()
},doc:{$:1,result:0,mimeType:"application/pdf",mimeType_dummy:"application/dummymimepdf",DummySpanTagHTML:0,HTML:0,DummyObjTagHTML1:0,isDisabled:function(){var d=this,c=d.$,b=d.$$,a=0;
if(b.OTF>=2){a=1
}else{if(c.dbug){}else{if(!c.DOM.isEnabled.objectTag()||!c.isGecko){a=1
}}}return a
},queryObject:function(b){var j=this,g=j.$,h=j.$$,i,f=j.HTML?j.HTML.obj():0,d=0,c=0,a=g.dbug&&!g.win.loaded?0:1;
try{if(f&&f.contentDocument){d=1
}}catch(i){}if(d&&a){j.result=1
};
if(!d||g.dbug){c=g.DOM.getTagStatus(j.HTML,j.DummySpanTagHTML,j.DummyObjTagHTML1,0,b);
if(c<0&&a){j.result=-1
}};
return j.result
},insertHTMLQuery:function(){var g=this,f=g.$,d=g.$$,a=d.pdf,c=f.file.getValid(d),e=1,b=f.DOM.altHTML;
if(!c||!c.full||g.isDisabled()){return g.result
}if(d.OTF<2){d.OTF=2
}c=c.full;
if(!g.DummySpanTagHTML){g.DummySpanTagHTML=f.DOM.insert("",[],[],b,d,e)
}if(!g.HTML){g.HTML=f.DOM.insert("object",["type",g.mimeType,"data",c],["src",c],b,d,e)
}if(!g.DummyObjTagHTML1){g.DummyObjTagHTML1=f.DOM.insert("object",["type",g.mimeType_dummy],[],b,d,e)
}g.queryObject();
if((g.result>0||g.result<0)&&!f.dbug){return g.result
}var h=d.NOTF;
if(d.OTF<3&&g.HTML&&h){d.OTF=3;
h.onIntervalQuery=f.handler(h.$$onIntervalQuery,h);
if(!f.win.loaded){f.win.funcs0.push([h.winOnLoadQuery,h])
}setTimeout(h.onIntervalQuery,h.intervalLength)
}return g.result
}},NOTF:{$:1,count:0,countMax:25,intervalLength:250,$$onIntervalQuery:function(d){var b=d.$,a=d.$$,c=a.doc;
if(a.OTF==3){c.queryObject(d.count);
if(c.result||(b.win.loaded&&d.count>d.countMax)){d.queryCompleted()
}}d.count++;
if(a.OTF==3){setTimeout(d.onIntervalQuery,d.intervalLength)
}},winOnLoadQuery:function(b,d){var a=d.$$,c=a.doc;
if(a.OTF==3){c.queryObject(d.count);
d.queryCompleted()
}},queryCompleted:function(){var d=this,b=d.$,a=d.$$,c=a.doc;
if(a.OTF==4){return
}a.OTF=4;
a.setPluginStatus();
if(a.funcs){b.callArray(a.funcs)
}if(b.DOM){b.DOM.onDoneEmptyDiv()
}}},zz:0},zz:0}};
PluginDetect.INIT();
