/* exported
    index itemsHTML m_bUpdated formProp last_index
  */
var index = null; // indice corrente del mainitem  nell'Array
var itemsHTML = new Array()   //array contenente tutti gli oggetti item  con id, HTML,shadow,ecc
var m_bUpdated = false;
var formProp = null;
var last_index;

if(typeof(ZTObjects)=='undefined'){
  var ZTObjects=new function(){
    this.PSToolbarAction = [
      { 'id': 'new'
        , 'class_name': 'btn'
        , 'action': function(){ reset(); }
        , 'image': '../portalstudio/images/icon/btn_new.png'
        , 'title': 'New'
      }
      // ,{ 'id': 'open'
        // , 'class_name': 'btn'
        // , 'action': function(){ openVMN(); }
        // , 'image': '../portalstudio/images/icon/btn_open.png'
        // , 'title': 'Open'
      // }
      ,{ 'id': 'save'
        , 'class_name': 'btn'
        , 'action': function(){ save(); }
        , 'image': '../portalstudio/images/icon/btn_save.png'
        , 'title': 'Save'
      },{ 'id': 'saveas'
        , 'class_name': 'btn'
        , 'action': function(){ saveAs('true') }
        , 'image': '../portalstudio/images/icon/btn_saveAs.png'
        , 'title': 'Save As'
      },{
        'isSeparator': true
      },{ 'id': 'addMenu'
        , 'class_name': 'btn'
        , 'action': function(){ addItem('menu'); }
        , 'image': '../portalstudio/images/icon/btn_addMenu.png'
        , 'title': 'Add Menu'
      },{ 'id': 'addSubmenu'
        , 'class_name': 'btn'
        , 'action': function(){ addItem('submenu'); }
        , 'image': '../portalstudio/images/icon/btn_addSubmenu.png'
        , 'title': 'Add Submenu'
      },{ 'id': 'addSeparator'
        , 'class_name': 'btn'
        , 'action': function(){ addItem('separator'); }
        , 'image': '../portalstudio/images/icon/btn_addSeparator.png'
        , 'title': 'Add Separator'
      },{
        'isSeparator': true
      },{ 'id': 'addSource'
        , 'class_name': 'btn'
        , 'action': function(){ addSource(); }
        , 'image': '../portalstudio/images/icon/btn_vmn.png'
        , 'title': 'Add Source VMN'
      }
    ]

    this.formObjClass={
      newProperties:{
        Generic:[
          {name:'author', propID:'author',type:'str' },
          {name:'version', propID:'version', type:'str' },
          {name:'created', propID:'created', type:'str', buttons:'date', actions:"selectDate()"},
          {name:'revision', propID:'revision', type:'str', buttons:'date',  actions:"selectDate({'time':'true'})"},
          {name:'comment', propID:'comment', type:'description'},
          {name:'global note', propID:'note', type:'description'}
        ],
        Customization:[
          {name:'Save in custom dir', propID:'custom', type:'checkbox',	extraClass:"col-3"},
          {name:'Indexed in search', propID:'inSearch', type:'checkbox',	extraClass:"col-3"},
          {name:'Menu for user or group', propID:'user_group', type: 'select[,User,Group]',
            hide_list:{'':['this.Customization_user','this.Customization_group'],'User':['this.Customization_group'],'Group':['this.Customization_user']},
            show_list:{'User':['this.Customization_user'],'Group':['this.Customization_group']}
          },
          {name:'Group',propID:'group',type:'str',validFunc:'IsNumericInput'},
          {name:'User',propID:'user',type:'str',validFunc:'IsNumericInput'},
          {name:'Company',propID:'company',type:'select['+companies+']'}
        ]
      }
    }
    this.searchObjClass={
      newProperties:{
        search:[
          {name:'Find',									propID:'sfind',				type:'str',				buttons:'search',			actions:'KeyFind()'},
          {name:'whole word',						propID:'cwword',			type:'checkbox',	extraClass:"col-3"},
          {name:'Case sensitive',				propID:'ccsensitive',	type:'checkbox',	extraClass:"col-3"}
        ],
        results:[]
      }
    };
    this.menuObjClass={
      newProperties:{
        Generic:[
          {name:'name', propID:'name', type:'str'},
          {name:'extended name', propID:'extended_name', type:'str'},
          {name:'tooltip', propID:'tooltip', type:'str'},
          {name:'procedure', propID:'link', type:'str'},
          {name:'type', propID:'type', type:'select[Master,Detail,Master/Detail,Dialog Window,Routine,Page,Report,SmartReport]'},
          {name:'image settings', propID:'img_type', type:'select[default,font icon]',
            show_list:{
              'default': ['Generic.bitmap'],
              'font icon': ['Generic.font_image', 'Generic.font_name']
            },
            hide_list:{
              'default': ['Generic.font_image', 'Generic.font_name'],
              'font icon': ['Generic.bitmap']
            }
          },
          {name:'image', propID:'bitmap', type:'image'},
  				{name:'font name', propID:'font_name', type:'str'},
          {name:'font char', propID:'font_image', type:'str',buttons:'pick', actions:'SelectIcons()'},
          {name:'sequence', propID:'sequence', type:'str'},
          {name:'hidden', propID:'disabled', type:'checkbox'},
          {name:'in ext menu', propID:'inExt', type:'checkbox'},
          {name:'remove', propID:'remove', type:'checkbox',
              show_list:{'checked' : ['Generic.path']},
              hide_list:{'unchecked' : ['Generic.path']}
          },
          {name:'path', propID:'path', type:'str'}
        ],
        notes:[
          {name:'user notes',    propID:'usernotes',	type:'str',  buttons:'edit', actions: 'editDesc()'},
          {name:'tecnical notes',propID:'technotes',	type:'str',  buttons:'edit', actions: 'editDesc()'}
        ]
      }
    }


    this.submenuObjClass={
      newProperties:{
        Generic:[
          {name:'name',          propID:'name',       type:'str'},
          {name:'procedure',     propID:'link',       type:'str'},
          {name:'type',          propID:'type',       type:'select[,Master,Detail,Master/Detail,Dialog Window,Routine,Page,Report]'},
          {name:'image settings', propID:'img_type', type:'select[default,font icon]',
            show_list:{
              'default': ['Generic.bitmap', 'Generic.bitmapOpen'],
              'font icon': ['Generic.font_image', 'Generic.font_name', 'Generic.font_image_open', 'Generic.font_name_open']
            },
            hide_list:{
              'default': ['Generic.font_image', 'Generic.font_name', 'Generic.font_image_open', 'Generic.font_name_open'],
              'font icon': ['Generic.bitmap', 'Generic.bitmapOpen']
            }
          },
          {name:'Closed image', propID:'bitmap',     type:'image'},
          {name:'Opened image', propID:'bitmapOpen', type:'image'},
  				{name:'font name close', propID:'font_name', type:'str'},
          {name:'font char close', propID:'font_image', type:'str',buttons:'pick', actions:'SelectIcons({font_name: "font_name"})'},
  				{name:'font name open', propID:'font_name_open', type:'str'},
          {name:'font char open', propID:'font_image_open', type:'str',buttons:'pick', actions:'SelectIcons({font_name: "font_name_open"})'},
          {name:'sequence',      propID:'sequence',   type:'str'},
          {name:'hidden',        propID:'disabled',   type:'checkbox'},
          {name:'in ext menu',   propID:'inExt',      type:'checkbox'},
          {name:'view type',     propID:'view_type',	type:'select[classic:,  columnar:col, columnar-3:col3, columnar-5:col5, columnar full page:colFull]'},
          {name:'insert point',  propID:'path',       type:'str',
            hide_list:{'':['Generic.insertion_action']},
            show_list:{'':[],'*':['Generic.insertion_action']}
          },
          {name:'insert action', propID:'insertion_action',	type:'select[Insert Before:P,Insert Into:I,Insert After:D,Remove:T]'}
        ],
        notes:[
          {name:'user notes',propID:'usernotes',	type:'str', buttons:'edit', actions: 'editDesc()'},
          {name:'tecnical notes',propID:'technotes',	type:'str',buttons:'edit', actions: 'editDesc()'}
        ]
      }
    }

    this.separatorObjClass={
      newProperties:{
        Generic:[
          {name:'bitmap',propID:'bmp',type:'image',disabled:true}
        ]
      }
    }

    // OGGETTI-------------------------------------
    this.formObj=function(obj) {
      this.objClass = ZTObjects.formObjClass;
      this.id='menueditor';
      this.name= obj.fileName;
      this.itemType="menueditor";
      this.revision = obj.revision;
      this.version = obj.version;
      this.author = obj.author;
      this.comment = obj.comment;
      this.created = obj.created;
      this.inSearch = obj.inSearch;
      this.client = obj.client;
      this.num_child = obj.num_child;
      this.note = obj.note;
      this.offline = obj.offline;
      this.custom = obj.custom;
      this.user_group = obj.user_group;
      this.company = obj.company;
      this.user = obj.user;
      this.group = obj.group;
    }
    this.searchObj = function() {
      this.objClass = ZTObjects.searchObjClass;
      this.cwword = false;
      this.ccsensitive = false;
      this.chighlight = false;
    };

    this.menuObj=function(obj) {
      this.objClass = ZTObjects.menuObjClass
      this.id = obj.id;
      this.name = obj.name;
      this.extended_name = (obj.extended_name ? obj.extended_name  : '');
      this.itemType ="menu";
      this.type = (obj.type=='Batch'?'Routine':obj.type=='MasterDetail'?'Master/Detail':obj.type);
      this.submenu = obj.submenu;
      this.level = obj.level;
      this.img_type= (obj.img_type ? obj.img_type : 'Default');
      this.bitmap= (obj.bmp_closed ? obj.bmp_closed : '');
      this.bitmapOpen=(obj.bmp_opened ? obj.bmp_opened : '');
      this.link = (obj.link ? obj.link  : 'NoNameProc');
      this.enabled = (obj.enabled!=undefined ? obj.enabled : true);
      this.disabled=!this.enabled;
      this.inExt=obj.inExt;
      this.sequence=obj.sequence;
      if (!Empty(obj.path)){
        var _path=obj.path.split('###');
        this.path=_path[0].substring(1);
        this.remove=_path[2]=='T'? 'true' : 'false';
      }
      else {
        this.path='';
        this.remove = 'false';
      }
      this.usernotes=(obj.usernotes ? obj.usernotes  : '');
      this.technotes=(obj.technotes ? obj.technotes : '');
      this.tooltip=(obj.tooltip ? obj.tooltip : '');
    }
    this.submenuObj=function(obj) {
      this.objClass = ZTObjects.submenuObjClass;
      this.id = obj.id;
      this.name= obj.name;
      this.itemType="submenu";
      this.submenu = obj.submenu;
      this.level = obj.level;
      this.img_type= (obj.img_type ? obj.img_type : 'Default');
      this.bitmap= (obj.bitmap ? obj.bitmap : '');
      this.bitmapOpen=(obj.bitmapO ? obj.bitmapO : '');
      this.link = (obj.link ? obj.link  :'NoNameProc');
      this.enabled = (obj.enabled!=undefined ? obj.enabled : true);
      this.disabled=!this.enabled;
      this.inExt=obj.inExt;
      this.sequence=obj.sequence;
      this.usernotes=(obj.usernotes ? obj.usernotes  : '')
      this.technotes=(obj.technotes ? obj.technotes : '')
      this.type=(obj.type=='Batch'?'Routine':obj.type=='MasterDetail'?'Master/Detail':obj.type)
      if (!Empty(obj.path)){
        var _path=obj.path.split('###');
        this.path=_path[0].substring(1);
        this.insertion_action=_path[2]=='T'? 'T' : _path[1];
      }
      else {
        this.path='';
        this.insertion_action='P';
      }
      this.view_type = obj.view_type ? obj.view_type : "";
    }
    this.separatorObj=function(obj) {
      this.objClass = ZTObjects.separatorObjClass;
      this.id = obj.id;
      this.name= obj.name;
      this.itemType="separator";
      this.type="";
      this.level = obj.level;
      this.bmp= (obj.bmp ? obj.bmp : '.bmp');
      this.link = (obj.link ? obj.link  : 'NoNameProc');
      this.submenu = 4;
      this.enabled = true;
    }
  }
}
