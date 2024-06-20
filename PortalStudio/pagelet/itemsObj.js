/* exported index dragstartx newx newy mainitem s_cont dragstarty currentname
    nitem formProp itemsHTML countindex
  */

// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
var dragstartx,dragstarty,newx,newy,mainitem;
var s_cont;
var index;          //indice corrente del mainitem  nell'Array  itemsHTML
var index_pgl=0;    //indice corrente   nell'Array   pageletprop
var currentname=""; //nome del portlet corrente
var nitem=0;        //numero item crescente
var pageletProp=[]; //array contenente tutti gli oggetti fissi della pagelet
var formProp=pageletProp[index_pgl];
var itemsHTML=[];   //array contenente tutti gli oggetti item  inseriti nella pagelet
var countindex=0;   //contatore indice array
if(typeof(ZTPageletObjects)=='undefined'){
  var ZTPageletObjects=new function(){
    // oggetto generico della pagelet
    this.pageletObjClass={
      newProperties:{
        Generic:[
          {name:'width',propID:'width',type:'str'},
          {name:'height',propID:'height',type:'str'},
          {name:'css',propID:'css',	type:'str'},
          {name:'css class',propID:'css_class',	type:'str'},
          {name:'sp skin',propID:'sp_theme',	type:'checkbox'},
          {name:'bg. color',propID:'color',	type:'color'},
          {name:'align',propID:'align',	type:'select[left,center,right]'},
          {name:'description',			propID:'description',				type:'description'}
        ],
        advanced:[
          {name:'cache time',propID:'cache_time',	type:'str',tooltip:'Set cache time with unit (s=seconds, m=minutes, h=hours)\nexample: 10m\ndefault is seconds'},
          {name:'server cache time',propID:'server_cache_time',	type:'str',tooltip:'Set cache time with unit (s=seconds, m=minutes, h=hours)\nexample: 10m\ndefault is seconds'},
          {name:'security',propID:'security',	type:'select[none,logged,pagelet,profiled]',
            hide_list:{'none,public,logged,pagelet,administrator':['advanced.roles']},
            show_list:{'profiled':['advanced.roles']}
          },
          {name:'roles',propID:'roles',	type:'str'},
          {name:'on security failure',propID:'on_security_failure',	type:'select[login,empty,default page]'},
          {name:'offline',propID:'offline',	type:'checkbox',
             hide_list:{'unchecked':['advanced.manifest','advanced.shared_manifest']},
             show_list:{'checked':['advanced.manifest','advanced.shared_manifest']}
          },
          {name:'manifest',propID:'manifest',	type:'str', noteditable:true},
          {name:'Shared manifest',		propID:'shared_manifest',		type:'checkbox'}
        ]
      },
      functions: [
        ['getPagelet()', 'getPagelet()', 'Ritorna la pagelet che include la pagelet corrente se presente, null altrimenti']
      ] //proprietà da far vedere nella properties bar
      //properties:[     'width','height','css','sp_theme'          ,'color'   ,'cache_time','security'                          ,'on_security_failure'             ,'css_class','align'],  //proprietà da far vedere nella properties bar
      //propertyTypes:[  'str'  ,'str'   ,'str','checkbox'          ,'color'   ,'str'       ,'select[none,public,pagelet,logged,profiled]','select[login,empty,default page]','str'      ,'select[left,center,right]']
    }

    this.columnObjClass={
      newProperties:{
        Generic:[
          {name:'width',propID:'width',type:'str'},
          {name:'height',propID:'height',type:'str'},
          {name:'css class',propID:'css_class',	type:'str'},
          {name:'bg. color',propID:'color',	type:'color'},
          {name:'align',propID:'align',	type:'select[left,center,right]'},
          {name:'valign',propID:'valign',	type:'select[top,middle,bottom]'},
          {name:'padding',propID:'padding',	type:'str'}
        ],
        advanced:[
          {name:'collapsable',propID:'collapsable',	type:'select[false,true open,true close,over open,over close]'},
          {name:'portlet collapser',propID:'collapser',	type:'str'},
          {name:'width close',propID:'width_close',type:'str'},
          {name:'droppable',propID:'droppable',	type:'checkbox'}
        ]
      }
      //propertiesNames:['css class','width','width close','height','bg color','align'                    ,'valign'                   ,'padding','collapsable'                         ,'portlet collapser' ,'droppable'],
      //properties:[     'css_class','width','width_close','height','color'   ,'align'                    ,'valign'                   ,'padding','collapsable'                       ,'collapser'      ,'droppable'],
      //propertyTypes:[  'str'      ,'str'  ,'str'        ,'str'   ,'color'   ,'select[left,center,right]','select[top,middle,bottom]','str'    ,'select[false,true open,true close,over open,over close]' ,'str'          ,'checkbox']
    }

    this.portletObjClass={
      newProperties:{
        Generic:[
          {name:'name',propID:'name',type:'str'},
          {name:'margin bottom',propID:'margin_bottom',type:'str'},
          {name:'parameters',propID:'parameters',	type:'str'},
          {name:'titled',propID:'titled', type:'select[no title:false,titled:true,titled when collapsed:titled_w_c]',
            hide_list:{'false':['generic.title']},
            show_list:{'true,titled_w_c':['generic.title']},
          },
          {name:'portlet as title',propID:'title',	type:'str'},
          {name:'open',propID:'open',	type:'checkbox'},
          {name:'in iframe',propID:'in_iframe',	type:'select[false,true,true-fixed]'}
        ],
        advanced:[
          {name:'condition',propID:'condition',	type:'str'},
          {name:'draggable',propID:'draggable',	type:'checkbox'},
          {name:'substitute resource',propID:'toremove',	type:'str'},
          {name:'iframe height',propID:'iframe_height',	type:'str'},
          {name:'Css Class',propID:'css_class',	type:'str'}
        ]
      }
      //propertiesNames:['name','margin bottom','parameters','titled'            ,'draggable'         ,'portlet as title','open'              ,'condition','substitute resource','in iframe'                    ,'iframe height'],
      //properties:[     'name','margin_bottom','parameters','titled'            ,'draggable'         ,'title'           ,'open'              ,'condition','toremove'           ,'in_iframe'                    ,'iframe_height'],
      //propertyTypes:[  'str' ,'str'          ,'str'       ,'checkbox'          ,'checkbox'          ,'str'             ,'checkbox'          ,'str'      ,'str'                ,'select[false,true,true-fixed]','str']
    }

    this.groupObjClass={
      newProperties:{
        Generic:[
          {name:'name',propID:'name',type:'str'},
          {name:'margin bottom',propID:'margin_bottom',type:'str'},
          {name:'titled',propID:'titled', type:'select[no title:false,titled:true,titled when collapsed:titled_w_c]',
            hide_list:{'false':['generic.title']},
            show_list:{'true,titled_w_c':['generic.title']},
          },
          {name:'portlet as title',propID:'title', type:'str'},
          {name:'open',propID:'open',	type:'checkbox'},
          {name:'tabs',propID:'tabs',	type:'select[none,multiple,single,combo single,combo multiple,wizard]'}
        ],
        advanced:[
          {name:'draggable',propID:'draggable',	type:'checkbox'},
          {name:'tabs content pre loaded',propID:'pre_loaded',	type:'checkbox'},
          {name:'Css Class',propID:'css_class',	type:'str'},
          {name:'Tabstrip class',propID:'tabstrip_class',	type:'str'}
        ]
      }
      //propertiesNames:['name','margin bottom','titled'            ,'draggable'         ,'portlet as title','open'              ,'tabs'],
      //properties:[     'name','margin_bottom','titled'            ,'draggable'         ,'title'           ,'open'              ,'tabs'],
      //propertyTypes:[  'str' ,'str'          ,'checkbox'          ,'checkbox'          ,'str'             ,'checkbox'          ,'select[none,multiple,single,combo single,combo multiple]']
    }
    this.zoneObjClass={
      newProperties:{
        Generic:[
          {name:'name',propID:'name',type:'str'},
          {name:'margin bottom',propID:'margin_bottom',type:'str'},
          {name:'titled',propID:'titled', type:'select[no title:false,titled:true,titled when collapsed:titled_w_c]',
            hide_list:{'false':['generic.title']},
            show_list:{'true,titled_w_c':['generic.title']},
          },
          {name:'portlet as title',propID:'title',	type:'str'},
          {name:'open',propID:'open',	type:'checkbox'},
          {name:'in iframe',propID:'in_iframe',	type:'select[false,true,true-fixed]'}
        ],
        advanced:[
          {name:'draggable',propID:'draggable',	type:'checkbox'},
          {name:'iframe height',propID:'iframe_height',	type:'str'},
          {name:'Css Class',propID:'css_class',	type:'str'}
        ]
      }
      //propertiesNames:['name','margin bottom','titled'            ,'draggable'         ,'portlet as title','open'              ,'in iframe'                    ,'iframe height'],
      //properties:[     'name','margin_bottom','titled'            ,'draggable'         ,'title'           ,'open'              ,'in_iframe'                    ,'iframe_height'],
      //propertyTypes:[  'str' ,'str'          ,'checkbox'          ,'checkbox'          ,'str'             ,'checkbox'          ,'select[false,true,true-fixed]','str']
    }

    // OGGETTI-------------------------------------
    this.pageletObj=function() {
      this.objClass = ZTPageletObjects.pageletObjClass
      this.id='pagelet'
      this.name='pagelet'
      this.type="pagelet"
      this.template=0
      this.width='100%'
      this.height=' '
      this.css=' '
      this.css_class=' '
      this.color=' '
      this.align='left'
      this.security='none'
      this.on_security_failure='login'
      this.offline='false'
      this.shared_manifest='false'
      this.manifest='Custom manifest'
      this.description=' ';
    }

    this.columnObj=function(id,name) {
      this.objClass = ZTPageletObjects.columnObjClass
      this.id=id
      this.name=name
      this.type="column"
      this.width=' '
      this.color=' '
      this.align='left'
      this.valign='top'
      this.css_class=' '
      this.height=' '
      this.padding=' '
      this.collapsable='false'
    }

    this.portletObj=function(id,name,container,position) {
      this.objClass = ZTPageletObjects.portletObjClass
      this.id=id
      this.type="portlet"
      this.name=name
      this.parameters=' '
      this.titled='false'
      this.title=' '
      this.open='false'
      this.in_iframe='false'
      this.iframe_height=' '
      this.condition=' '
      this.toremove=' '
      this.container=container
      this.position=position
      this.margin_bottom='10px'
      this.draggable='false'
      this.css_class=' '
    }

    this.zoneObj=function(id,name,container,position) {
      this.objClass = ZTPageletObjects.zoneObjClass
      this.id=id
      this.type="zone"
      this.name=name
      this.titled='false'
      this.title=' '
      this.open='false'
      this.in_iframe='false'
      this.iframe_height=' '
      this.container=container
      this.position=position
      this.margin_bottom='10px'
      this.draggable='false'
      this.css_class=' '
    }

    this.groupObj=function(id,name,container,position) {
      this.objClass = ZTPageletObjects.groupObjClass
      this.id=id
      this.type="group"
      this.name=name
      this.titled='false'
      this.title=' '
      this.open='false'
      this.tabs='none'
      this.container=container
      this.position=position
      this.margin_bottom='10px'
      this.draggable='false'
      this.pre_loaded='false'
      this.css_class=' ';
      this.tabstrip_class=' ';
    }

    this.PSToolbarAction=[
      { 'id': 'btn_preview'
        , 'class_name': 'btn'
        , 'action': function(){ togglePreview()}
        , 'image': '../portalstudio/images/icon/btn_preview.png'
        , 'title': 'Open preview page'
      },{ 'id': 'save_template'
        , 'class_name': 'btn'
        , 'action': function(){ save() }
        , 'image': '../portalstudio/images/icon/btn_save.png'
        , 'title': 'Save layout'
      },{ 'id': 'action_code'
        , 'class_name': 'btn'
        , 'action': function(){ editItemEvent() }
        , 'image': '../portalstudio/images/icon/btn_acode.png'
        , 'title': 'Edit action code'
      }
    ];
  }
}
