/* exported
    dragstartx dragstarty newx newy mainitem s_cont index nitem itemsHTML countindex
    nitem formProp
 */

// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
var dragstartx,dragstarty,newx,newy,mainitem;
var s_cont;
var index;          //indice corrente del mainitem  nell'Array  itemsHTML
var index_pgl=0;    //indice corrente   nell'Array   pageletprop
var nitem=0;        //numero item crescente
var pageletProp=[]; //array contenente tutti gli oggetti fissi della pagelet
var formProp=pageletProp[index_pgl];
var itemsHTML=[];   //array contenente tutti gli oggetti item  inseriti nella pagelet
var countindex=0;   //contatore indice array
if(typeof(ZTPageletObjects)=='undefined'){
  var ZTPageletObjects=new function(){
    /* funzioni che permettono l'estensione di tipo nelle prop */

    this.findProp= function (propID, container){
      for( var j=0; j< container.length; j++){
        if( container[j].propID == propID ){
          return j;
          break;
        }
      }
      return -1;
    }

    this.extend = function( objA, objB){
      /*
       * La posizione della properties � definita dall'oggetto esteso
      */
      var propsA = objA['newProperties'],
        propsB = objB['newProperties'];
      for( var prop in propsA ){
        for( var i=0; i< propsA[prop].length; i++ ){
          if( typeof(propsB[prop]) == 'undefined' ){
            propsB[prop] = propsA[prop];
            break;
          }
          var iB = this.findProp(propsA[prop][i].propID, propsB[prop]);
          if( iB == -1 ){
            propsB[prop].splice(i, 0, propsA[prop][i]);
          }
        }
      }
    }



    this.pageletObjClass={
      newProperties:{
        generic:[
          {name:'Columns', propID:'cols_n', type:'select[12,20]', tooltip: 'Set columns number'},
          {name:'Steps', propID:'steps',			type:'str', tooltip:'steps', disabled:'true' },
          {name:'Layout steps',			propID:'layout_step',	buttons:'plus,edit,del',
            actions:"addLayoutStep(),editLayoutStep(),delLayoutStep()",
            type:'steps_layout', tooltip:'Different layout settings for dimensions'
          },
          {name:'rows' ,       propID:'rows_n',    type:'int',disabled:true},
          {name:'width',       propID:'width',     type:'str', disabled:true},
          {name:'height',      propID:'height',    type:'str', disabled:true},
          {name:'css',         propID:'css',       type:'str'},
          {name:'css class',   propID:'css_Class', type:'css_class'},
          {name:'sp skin',     propID:'sp_theme',  type:'checkbox'},
          {name:'bg. color',   propID:'color',       type:'color'},
          {name:'description', propID:'description', type:'description'},
          {name:'template',    propID:'template',	   type:'str', disabled: 'true'},
          {name:'',            propID:'css_code',    type:'str', disabled:'true'}
        ],
        advanced:[
          {name:'cache time',propID:'cache_time', type:'str'},
          {name:'security',propID:'security', type:'select[none,logged,pagelet,profiled]',
            hide_list:{'none,public,logged,pagelet,administrator':['advanced.roles']},
            show_list:{'profiled':['advanced.roles']}
          },
          {name:'roles',propID:'roles', type:'str'},
          {name:'offline',propID:'offline',	type:'checkbox',
             hide_list:{'unchecked':['advanced.manifest','advanced.shared_manifest']},
             show_list:{'checked':['advanced.manifest','advanced.shared_manifest']}
          },
          {name:'manifest',propID:'manifest',	type:'str', noteditable:true},
          {name:'Shared manifest',		propID:'shared_manifest',		type:'checkbox'},
          {name:'on security failure',propID:'on_security_failure', type:'select[login,empty,default page]'}
        ]
      },
      events: ['Loaded','StepChanged(#cStep)'],
      functions: [
        ['getPagelet()', 'getPagelet()', 'Ritorna la pagelet che include la pagelet corrente se presente, null altrimenti']
      ]
      // functions: ['ShowPageletItem(#cId#,#cPosition#)', 'HidePageletItem(#cId#,#cPosition#)']
    }


    this.stdObjClass = {
      newProperties:{
        generic:[
          {name:'name',			     propID:'name',		              type:'str'},
          {name:'column',        propID:'col',                  type:'int',  noteditable:true,  section: 'positions', extraClass: 'col-3', steppable:true, disabled:true},
          {name:'row',           propID:'row',                  type:'int',  noteditable:true,  section: 'positions', extraClass: 'col-3', steppable:true, disabled:true},
          {name:'width',         propID:'width',                type:'int',  noteditable:true,  section: 'size',      extraClass: 'col-3', steppable:true, disabled:true},
          {name:'height',        propID:'height',               type:'int',  noteditable:true,  section: 'size',      extraClass: 'col-3', steppable:true, disabled:true},
          {name:'zone visibility', propID:'behavior',             type:'select[show,hide,popup]', steppable:true,
            tooltip: '<ul>Set the zone visibility in current step'+
            '<li>show: zone is visible</li>'+
            '<li>hide: zone is hidden</li>'+
            '<li>popup: zone is hidden but can be shown in overlay</li>'+
            '</ul>'
          },
          {name:'stretch height to 100%',propID:'stretch',              type:'checkbox', tooltip: 'Set zone stretch height '},
          {name:'',              propID:'stretchBehavior',      type:'str',  disabled:'true'},
          {name:'titled',        propID:'titled',               type:'select[no title:false,titled:true,titled when collapsed:titled_w_c]',
            hide_list:{'false':['generic.title','advanced.caption']},
            show_list:{'true,titled_w_c':['generic.title','advanced.caption']},
            tooltip: '<ul>Set the zone title mode'+
            '<li>no title</li>'+
            '<li>titled</li>'+
            '<li>title when collapsed: title is shown only when the zone is collapsed</li>'+
            '</ul>'
          },
          {name:'portlet as title',propID:'title', type:'str', tooltip: 'Set the portlet as title(defalut: default_title)'},
          {name:'open',propID:'open', type:'checkbox'},
          {name:'',             propID:'popupItems',           type:'str', disabled:'true'}, //Tiene i valori multipli
          {name:'',             propID:'layout_steps_values',  type:'str', disabled:'true'},
          {name:'',             propID:'areaContainer',        type:'str', disabled:'true'}
        ],
        advanced:[
          {name:'Css class',		propID:'css_Class',            type:'css_class', tooltip: 'Set css class for zone container'}
        ]
      }
    }

    this.staticObjClass={
      newProperties:{
        generic:[
          {name:'src',propID:'src',type:'srcpagelet'},
          {name:'parameters',propID:'parameters', type:'parameters', tooltip: 'Set zone parameters '},
        ],
        advanced:[
          {name:'caption',propID:'caption', type:'str', tooltip: 'Set zone title caption'},
          {name:'condition',propID:'condition', type:'str', tooltip:'Set zone visibility condition'},
          {name:'in iframe',propID:'in_iframe', type:'select[false,true,iframe fixed height:true-fixed]',
            hide_list:{'false,true':['advanced.iframe_height']},
            show_list:{'true-fixed':['advanced.iframe_height']},
            tooltip: '<ul>Set zone iframe'+
            '<li>false: zone in current window</li>'+
            '<li>true: zone generated in iframe</li>'+
            '<li>iframe fixed height: zone coneined in iframe with fixed height</li>'+
            '</ul>'
          },
          {name:'iframe height',propID:'iframe_height', type:'str', tooltip:'Set iframe height'},
          {name:'draggable',propID:'draggable',	type:'checkbox'}
        ]
      },
      events: [],
      functions: ['hideItem()', 'showItem()', 'isHidden()',
        ['SetDimension', 'setDimension(#nCol#,#nRow#)','set new dimension(column,row)'],
        ['GetResource','getResource()','return the object in this item or null if it si empty'],
        'isEmpty()'
      ],
      notifications:function(obj){
        obj.notifications=[];
        if(Empty(obj.src)){
          obj.notifications.push({'message':'Select a src of the static resource.','tab':'generic','prop':'src'});
          return;
        }
      }
    }
    this.extend( this.stdObjClass, this.staticObjClass );

    this.groupObjClass={
      newProperties:{
        generic:[],
        advanced:[
          {name:'caption',propID:'caption', type:'str', tooltip: 'Set zone title caption'},
          {name:'items css class',propID:'items_css_class',type:'str', tooltip:'Set css class for every item\'s container of group'},
          {name:'layout',propID:'layout', type:'select[row:false,single tabstrip:multiple,multiple tabstrip:single,'+
            'wizard tabstip :wizard,combo single:combo single,combo multiple:combo multiple,'+
            'flex row wrap:row wrap,flex row nowrap:row nowrap,flex column wrap:column wrap,'+
            'flex column nowrap: column nowrap]',
            tooltip: '<ul>Set zone layout'+
            '<li>row: default layout</li>'+
            '<li>single tabstrip: one tabstrip with many items</li>'+
            '<li>multiple tabstrip: one tabstrip for every item</li>'+
            '<li>wizard: single tabstrip in wizard mode</li>'+
            '<li>single combo: one combobox with many items</li>'+
            '<li>multiple combo: one combobox for every item</li>'+
            '<li>flex row nowrap: flex layout in row direction, no newline flow</li>'+
            '<li>flex row wrap: flex layout in row direction, newline flow</li>'+
            '<li>flex column nowrap: flex layout in column direction, no newline flow</li>'+
            '<li>flex column wrap: flex layout in column direction, newline flow</li>'+
            '</ul>'
          },
          {name:'tabstrip class',propID:'tabstrip_class',type:'str', tooltip: 'Set css class for tabstrip'},
          {name:'content',propID:'content',type:'str', disabled:'true'},
          {name:'tabs content pre loaded',propID:'pre_loaded',	type:'checkbox', tooltip: 'Set tabstrip content preloaded at start'},
          {name:'tabs target',propID:'tabs_target',	type:'str', tooltip: 'Set group as target for link'},
          {name:'draggable',propID:'draggable',	type:'checkbox'}
        ]
      },
      events: [],
      functions: [
        'hideItem()',
        'showItem()',
        'isHidden()',
        ['SetDimension', 'setDimension(#nCol#,#nRow#)', 'set new dimension(column,row)'],
        ['Next() If tabs, next tab', 'Next()'],
        ['Prev() If tabs, prev tab', 'Prev()'],
        ['GetResourcesName()','getResourcesName()','return array with name of resources'],
        ['GetResource(#cResurceName#)','getResource(#cResurceName#)','return the object in this item or null if it si empty'],
        ['GetResources()','getResources()','Return an object that has the name as a key, and the object as the value'],
        'isEmpty()'
      ]
    }
    this.extend( this.stdObjClass, this.groupObjClass );

    this.resourceObjClass={
      newProperties:{
        generic:[
          {name:'in iframe',propID:'in_iframe', type:'select[false,true,true-fixed]',
            hide_list:{'false,true':['advanced.iframe_height']},
            show_list:{'true-fixed':['advanced.iframe_height']},
            tooltip: '<ul>Set zone iframe'+
            '<li>false: zone in current window</li>'+
            '<li>true: zone generated in iframe</li>'+
            '<li>iframe fixed height: zone coneined in iframe with fixed height</li>'+
            '</ul>'},
        ],
        advanced:[
          {name:'iframe height',propID:'iframe_height', type:'str', tooltip:'Set iframe height' },
          {name:'draggable',propID:'draggable',	type:'checkbox'}
        ]
      },
      events: [ 'beforeSetSrc' ],
      functions: ['hideItem()', 'showItem()', 'isHidden()',
        ['SetDimension', 'setDimension(#nCol#,#nRow#)', 'set new dimension(column,row)'],
        ['GetResource()', 'getResource()', 'return the object in this item or null if it si empty']
      ]
    }
    this.extend( this.stdObjClass, this.resourceObjClass );

    this.areaObjClass={
      newProperties:{
        generic:[
          {name:'z-index',propID:'z',type:'int', tooltip: 'Set area z-index to move element in front or back of other areas'},
          {name:'area_type',propID:'area_type',type:'select[normal,fixed]', 'disabled': 'true'}
        ],
        advanced:[
          {name:'caption',propID:'caption', type:'str', tooltip: 'Set zone title caption'},
          {name:'layout',propID:'layout', type:'select[row:false,single tabstrip:multiple,multiple tabstrip:single,wizard tabstip :wizard,combo single:combo single,combo multiple:combo multiple,flex row wrap:row wrap,flex row nowrap:row nowrap,flex column wrap:column wrap,flex column nowrap: column nowrap]'},
          // {name:'flex box', propID:'flex', type:'select[false,row wrap,row nowrap,column wrap, column nowrap]'},
          {name:'min width',propID:'minWidth',type:'int'},
          {name:'width %',propID:'width_perc',type:'int'},
          {name:'max width',propID:'maxWidth',type:'int'},
          {name:'bool open/close routine',propID:'o_c_routune',type:'str'},
          {name:'routine parms',propID:'routineParms',type:'str'},
          {name:'droppable',propID:'droppable',	type:'checkbox'}
        ]
      },
      functions: ['hideItem()', 'showItem()', 'isHidden()', ['SetDimension', 'setDimension(#nCol#,#nRow#)', 'set new dimension(column,row)']]
    }
    this.extend( this.stdObjClass, this.areaObjClass );

    // OGGETTI-------------------------------------

    this.pageletObj=function() {
      this.objClass = ZTPageletObjects.pageletObjClass
      this.id='pagelet';
      this.name='pagelet';
      this.type="pagelet";
      this.template=0;
      this.cols_n=12;
      this.rows_n=1;
      this.width='960px';
      this.height='100%';
      this.css='';
      this.css_Class='';
      this.color='';
      this.security='none';
      this.on_security_failure='login';
      this.roles="";
      this.cache_time=0;
      this.sp_theme=' ';
      this.offline='false';
      this.shared_manifest='false';
      this.manifest='Custom manifest';
      this.action_code='';
      this.description='';
      this.steps='';
      this.layout_step='';
      this.is960='true';
      this.steppable_prop=[];
    }

    this.staticObj=function(id,name,src) {
      this.objClass = ZTPageletObjects.staticObjClass;
      this.id=id;
      this.type="static";
      this.name=name;
      this.src=src;
      this.parameters='';
      this.titled='false';
      this.title='';
      this.open='true';
      this.in_iframe='false';
      this.iframe_height=' '
      this.condition='';
      this.row=0;
      this.col=0;
      this.height=1;
      this.width=1;
      this.prefx=0;
      this.suffx=0;
      this.inserted='false';
      this.behavior='show';
      this.layout_steps_values={};
      this.steppable_prop=['row','col','width','height','behavior','popupItems','prefx','suffx','renderWidth'];
      this.popupItems=[];
      this.stretch = 'false';
      this.caption = "";
      this.draggable = false;
    }

    this.resourceObj=function(id,name,container) {
      this.objClass = ZTPageletObjects.resourceObjClass;
      this.id=id;
      this.type="resource";
      this.name=name;
      this.titled='false';
      this.title='';
      this.open='true';
      this.in_iframe='false';
      this.iframe_height='';
      this.container=container;
      this.row=0;
      this.col=0;
      this.height=1;
      this.width=1;
      this.prefx=0;
      this.suffx=0;
      this.inserted='false';
      this.behavior='show';
      this.layout_steps_values={};
      this.steppable_prop=['row','col','width','height','behavior','popupItems','prefx','suffx','renderWidth'];
      this.popupItems=[];
      this.stretch = 'false';
      this.draggable = false;
    }

    this.groupObj=function(id,name) {
      this.objClass = ZTPageletObjects.groupObjClass;
      this.id=id;
      this.type="group";
      this.name=name;
      this.titled='false';
      this.title='';
      this.open='true';
      this.layout='false';
      this.row=0;
      this.col=0;
      this.height=1;
      this.width=1;
      this.prefx=0;
      this.suffx=0;
      this.inserted='false';
      this.content='';
      this.pre_loaded='false';
      this.behavior='show';
      this.layout_steps_values={};
      this.steppable_prop=['row','col','width','height','behavior','popupItems','prefx','suffx','renderWidth'];
      this.popupItems=[];
      this.stretch = 'false';
      this.caption = "";
      this.draggable = false;
    }

    this.areaObj=function(id,name){
      this.objClass = ZTPageletObjects.areaObjClass
      this.id=id;
      this.name=name;
      this.type="area";
      this.titled='false';
      this.title='';
      this.open='true';
      this.row=0;
      this.col=0;
      this.height=1;
      this.width=1;
      this.prefx=0;
      this.suffx=0;
      this.inserted='false';
      this.items=[];
      this.z=0;
      this.layout= 'false';
      this.area_type='normal';
      this.minWidth='';
      this.maxWidth='';
      this.width_perc='';
      this.hidden=false;
      this.behavior='show';
      this.layout_steps_values={};
      this.steppable_prop=['row','col','width','height','behavior','layoutClass','width_perc','minWidth','maxWidth','popupItems','prefx','suffx','renderWidth'];
      this.popupItems=[];
      this.stretch = 'false';
      this.o_c_routune = '';
      this.routineParms = '';
      this.caption = "";
      this.droppable = false;
    }
    this.PSToolbarItem=[
      { 'id': 'resoure_ctrl'
        , 'class_name': 'btn'
        , 'action':{'func':'addItem','par':'resource'}
        , 'image': '../portalstudio/images/icon/bot_resource.png'
        , 'title': 'Add plan Resource'
        , 'draggable': true
      },
      { 'id': 'group_ctrl'
        , 'class_name': 'btn'
        , 'action':{'func':'addItem','par':'group'}
        , 'image': '../portalstudio/images/icon/bot_group_resource.png'
        , 'title': 'Add plan Group'
        , 'draggable': true
      },
      { 'id': 'static_ctrl'
        , 'class_name': 'btn'
        , 'action':{'func':'addItem','par':'static'}
        , 'image': '../portalstudio/images/icon/bot_portlet.png'
        , 'title': 'Add static resource'
        , 'draggable': true
      },
      { 'id': 'area_ctrl'
        , 'class_name': 'btn'
        , 'action':{'func':'addItem','par':'area'}
        , 'image': '../portalstudio/images/icon/bot_area.png'
        , 'title': 'Add area container'
        , 'draggable': true
      }
    ]
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
  };
}
