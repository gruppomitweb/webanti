/* exported xmlDoc xmlDOMModel loadDocumentXML getNode getTagValue getNodesXML */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var xmlDoc="";
var xmlDOMModel="";

function loadDocumentXML(doc) {
  var xhttp;
    if (window.XMLHttpRequest)
    {
        xhttp=new XMLHttpRequest();
        xmlDOMModel="";
    }
    else // for IE 5/6
    {
        xhttp=new ActiveXObject("Microsoft.XMLHTTP");
        xmlDOMModel="IE";
    }
    xhttp.open("GET",doc,false);
    xhttp.send();
    xmlDoc=xhttp.responseXML;

/*
    if (window.DOMParser)
    {
        parser=new DOMParser();
        xmlDoc=parser.parseFromString(doc,"text/xml");
        xmlDOMModel="";
    }
    else // Internet Explorer
    {
        try {
            xmlDoc = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlDoc = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {}
        }
*/
//xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//xmlDoc.async="false";
//        xmlDoc.loadXML(doc);
//        xmlDOMModel="IE";
//    }
}

function getNode(mainNode,path) {
    var tags = path.split('/');
    var node = new Array();
    node[0] = mainNode;

    for (var i=0;i<tags.length;i++) {
        node = getNodes(node[0],tags[i]);
    }
    return node;
}
function getNodes(node,element) {
    // if (this.xmlDOMModel=='IE') {
    var childrens = node.childNodes;
    // } else {
    //    childrens = node.getChildren();
    // }

    var nodes = new Array();
    var idx=0
    for (var i=0;i<childrens.length;i++) {
        if (childrens[i].nodeName==element)
            nodes[idx++]= childrens[i];
    }
    return nodes;
}


function getTagValue(node,tag) {
    var elements = getNodes(node,tag);
    if (elements==null) {
        alert("Element: "+ tag + " is null from path: "+node);
    }

    if (elements.length==1) {
        return getValueXML(elements[0]);
    } else {
        var str = new Array();
        for (var i=0;i<elements.length;i++) {
            str[i] = getValueXML(elements[i]);
        }
        return str;
    }
}

function getValueXML(element) {
    var val = element.text;
    if (val==undefined)
        val = element.textContent;
    return val;
    /*
    if (this.xmlDOMModel=='IE')
        return element.text;
    else
        return element.textContent;
        */
}

function getNodesXML(node,element) {
    return node.getElementsByTagName(element);
}
