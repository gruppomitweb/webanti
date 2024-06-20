/* exported
    selectModel
    dragstartx dragstarty newx newy mainitem nitem countindex m_bUpdated
  */

// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
var dragstartx, dragstarty, newx, newy, mainitem;
var index; // indice corrente del mainitem  nell'Array
var nitem = 0; // numero item crescente
var itemsHTML = []; //array contenente tutti gli oggetti item  con id ,HTML,shadow,ecc
var countindex = 0; //contatore indice array
var m_bUpdated = false;
if(typeof(ZTPlanObjects) == 'undefined') {
  var ZTPlanObjects = new function() {
    if(isCMS) {
      this.formObjClass = {
        newProperties: {
          configurazione: [
            { name: 'height', propID: 'height', type: 'int' },
            { name: 'width', propID: 'width', type: 'int' },
            { name: '', propID: 'library', type: 'str', disabled: true },
            { name: 'description', propID: 'description', type: 'description' },
            { name: '', propID: 'global_variables', type: 'str', disabled: true },
            { name: 'Template', propID: 'template_folder', type: 'str' },
            { name: 'Online', propID: 'online', type: 'checkbox' },
            { name: 'Azienda', propID: 'company', type: 'select[' + companies + ']' }
          ]
        }
      };
    } else {
      this.formObjClass = {
        newProperties: {
          generic: [
            { name: 'height', propID: 'height', type: 'int' },
            { name: 'width', propID: 'width', type: 'int' },
            { name: '', propID: 'library', type: 'str', disabled: true },
            { name: 'description', propID: 'description', type: 'str' },
            { name: '', propID: 'global_variables', type: 'str', disabled: true },
            { name: 'Version', propID:'version', type:'str', disabled: true}
          ]
        }
      };
    }
    if(!isCMS) {
      this.pageObjClass = {
        newProperties: {
          generic: [
            { name: 'x', propID: 'x', type: 'int', disabled: true },
            { name: 'y', propID: 'y', type: 'int', disabled: true },
            { name: '', propID: 'page_parameters', type: 'str', disabled: true },
            { name: '', propID: 'contents', type: 'str', disabled: true },
            { name: '', propID: 'contents_type', type: 'str', disabled: true },
            { name: '', propID: 'urls', type: 'str', disabled: true },
            { name: '', propID: 'parameters', type: 'str', disabled: true },
            { name: '', propID: 'groups', type: 'str', disabled: true },
            { name: '', propID: 'conditions', type: 'str', disabled: true },
            { name: '', propID: 'titles', type: 'str', disabled: true },
            { name: 'name', propID: 'name', type: 'str' },
            { name: 'title', propID: 'title', type: 'str' },
            { name: 'description', propID: 'description', type: 'str' },
            { name: 'is a model', propID: 'model', type: 'checkbox', section: 'Model', extraClass: 'col-2',
              hide_list: { 'checked': ['this.generic_modelselected'] },
              show_list: { 'unchecked': ['this.generic_modelselected'] }
            },
            { name: 'select model', propID: 'modelselected', type: 'select[function:selectModel()]', section: 'Model', extraClass: 'col-4' },
            { name: 'type color', propID: 'type_category', type: 'select[,red,yellow,blue,green,orange,purple]', extraClass: 'col-3' },
            { name: 'page page', propID: 'page_image', type: 'select[default,404,login,cards,contact,dashboard,datagrid,slider]', extraClass: 'col-3' },
            { name: 'importance', propID: 'importance', type: 'select[,high,medium,low]', extraClass: 'col-3' }
          ],
          layout: [
            { name: 'css', propID: 'css', type: 'str' },
            { name: 'sp skin', propID: 'sp_theme', type: 'checkbox' },
            { name: 'devices list', propID: 'user_agent', type: 'str', buttons: 'plus,edit,del', actions: "newMultipleProp({'props':props,tabName:tabName}),editMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})", multiple: { 'type': 'combo', 'id': 'user_agent' }, section: 'Device settings' },
            { name: 'layout', propID: 'template', type: 'str', validFunc: 'IsObligatory', multiple: { 'type': 'input', 'id': 'user_agent' }, section: 'Device settings' },
            { name: 'set skin name', propID: 'theme', type: 'str', multiple: { 'type': 'input', 'id': 'user_agent' }, section: 'Device settings' },
            { name: 'page to redirect', propID: 'redirect', type: 'str', multiple: { 'type': 'input', 'id': 'user_agent' }, section: 'Device settings' },
            { name: 'User-Agent Priority', propID: 'ua_priority', type: 'checkbox', section: 'Device settings' }
          ],
          security: [
            { name: 'security', propID: 'security', type: 'select[none,administrator,logged,pagelet,profiled]',
              hide_list: { 'none,public,logged,pagelet,administrator': ['this.security_roles'] },
              show_list: { 'profiled': ['this.security_roles'] }
            },
            { name: 'roles', propID: 'roles', type: 'str' },
            { name: 'on security failure', propID: 'on_security_failure', type: 'select[login,empty,default page,custom]',
              hide_list: { 'login,empty,default page': ['this.security_custom_url_failure'] },
              show_list: { 'custom': ['this.security_custom_url_failure'] }
            },
            { name: 'custom url on security failure', propID: 'custom_url_failure', type: 'str' }
          ],
          advanced: [
            { name: 'query', propID: 'query', type: 'str' },
            { name: 'query params', propID: 'query_params', type: 'str' },
            { name: 'body attributes', propID: 'body_attributes', type: 'str' },
            { name: 'meta keywords', propID: 'meta', type: 'str' },
            { name: 'meta description', propID: 'meta_description', type: 'str' },
            { name: 'js library', propID: 'library', type: 'str' },
            { name: 'client cache time', propID: 'cache_time', type: 'str', tooltip: 'Set cache time with unit (s=seconds, m=minutes, h=hours)\nexample: 10m\ndefault is seconds' },
            { name: 'server cache time', propID: 'server_cache_time', type: 'str', tooltip: 'Set cache time with unit (s=seconds, m=minutes, h=hours)\nexample: 10m\ndefault is seconds' },
            { name: 'links', propID: 'links', type: 'str' },
            { name: '', propID: 'menu_urls_links', type: 'str', disabled: true },
            { name: '', propID: 'menu_label_links', type: 'str', disabled: true },
            { name: 'father', propID: 'father', type: 'str', disabled: true },
            { name: '', propID: 'menu_label_father', type: 'str', disabled: true },
            { name: '', propID: 'codeevents', type: 'str', disabled: true },
            { name: '', propID: 'codeStatus', type: 'str', disabled: true },
            { name: 'offline', propID: 'offline', type: 'checkbox', extraClass: 'col-3' },
            { name: 'Shared manifest', propID: 'shared_manifest', type: 'checkbox', extraClass: 'col-3' }
          ]
        },
        events: [],
        functions: []
      };
    } else {
      this.pageObjClass = {
          newProperties: {
            generic: [
              { name: 'name', propID: 'name', type: 'str', disabled: true },
              { name: 'name', propID: 'pname', type: 'str' },
              { name: '', propID: 'pname_translate', type: 'str', disabled: true },
              { name: 'alias', propID: 'alias', type: 'str' },
              { name: '', propID: 'alias_translate', type: 'str', disabled: true },
              { name: 'x', propID: 'x', type: 'int', disabled: true },
              { name: 'y', propID: 'y', type: 'int', disabled: true },
              { name: 'title', propID: 'title', type: 'str' },
              { name: '', propID: 'title_translate', type: 'str', disabled: true },
              { name: 'description', propID: 'description', type: 'str' },
              { name: 'is a model', propID: 'model', type: 'checkbox', section: 'Model', extraClass: 'col-2',
                hide_list: { 'checked': ['this.generic_modelselected'] },
                show_list: { 'unchecked': ['this.generic_modelselected'] }
              },
              { name: 'select model', propID: 'modelselected', type: 'select[function:selectModel()]', section: 'Model', extraClass: 'col-4' },
              { name: 'type color', propID: 'type_category', type: 'select[,red,yellow,blue,green,orange,purple]', extraClass: 'col-3' },
              { name: 'importance', propID: 'importance', type: 'select[,high,medium,low]', extraClass: 'col-3' },
              { name: 'page type', propID: 'page_type', type: 'select[Standard,Home,Login,403,404,503,Redirect,Forward,Category,Content]',
                show_list: { 'Forward': ['this.generic_forward'], 'Redirect': ['this.generic_redirect'] },
                hide_list: { 'Forward': ['this.generic_redirect'], 'Redirect': ['this.generic_forward'], 'Standard': ['this.generic_forward', 'this.generic_redirect'] }
              },
              { name: 'forward to', propID: 'forward', type: 'select[-]' },
              { name: 'url redirect', propID: 'redirect', type: 'str' },
              { name: '', propID: 'page_parameters', type: 'str', disabled: true },
              { name: '', propID: 'contents', type: 'str', disabled: true },
              { name: '', propID: 'contents_type', type: 'str', disabled: true },
              { name: '', propID: 'urls', type: 'str', disabled: true },
              { name: '', propID: 'parameters', type: 'str', disabled: true },
              { name: '', propID: 'groups', type: 'str', disabled: true },
              { name: '', propID: 'conditions', type: 'str', disabled: true },
              { name: 'security', propID: 'security', type: 'select[none,administrator,logged,pagelet,profiled]' },
              { name: 'on security failure go to', propID: 'on_security_failure', type: 'select[403,login,home]' }
            ],
            style: [
              { name: 'css', propID: 'css', type: 'str' },
              { name: 'layout', propID: 'layout', type: 'str' },

            ],
            advanced: [
              { name: 'body attributes', propID: 'body_attributes', type: 'str', disabled: true },
              { name: 'meta keywords', propID: 'meta', type: 'str' },
              { name: '', propID: 'meta_translate', type: 'str', disabled: true },
              { name: 'meta description', propID: 'meta_description', type: 'str' },
              { name: '', propID: 'meta_description_translate', type: 'str', disabled: true },
              { name: 'js library', propID: 'library', type: 'str' },
              { name: 'published', propID: 'published', type: 'checkbox', extraClass: 'col-3'  },
              { name: 'links', propID: 'links', type: 'str', disabled: true, extraClass: 'col-3'  },
              { name: '', propID: 'menu_urls_links', type: 'str', disabled: true },
              { name: '', propID: 'menu_label_links', type: 'str', disabled: true },
              { name: 'father', propID: 'father', type: 'str', disabled: true, extraClass: 'col-3' },
              { name: '', propID: 'menu_label_father', type: 'str', disabled: true },
              { name: '', propID: 'codeevents', type: 'str', disabled: true },
              { name: 'menu', propID: 'menu', type: 'checkbox', extraClass: 'col-3',
                hide_list: { 'unchecked': ['this.advanced_overlink', 'this.advanced_overlinkparams'] },
                show_list: { 'checked': ['this.advanced_overlink', 'this.advanced_overlinkparams'] }
              },
              { name: 'overlink', propID: 'overlink', type: 'select[-]' },
              { name: 'overlink parameters', propID: 'overlinkparams', type: 'str' },
              { name: 'target', propID: 'target', type: 'str' },
              { name: 'menu sequence', propID: 'sorting', type: 'int' },
            ]
        },
        functions: [
          ['getPagelet()', 'getPagelet()', 'Ritorna la pagelet inclusa']
        ]
      };
    }

    this.linkObjClass = {
      newProperties: {
        Generic: [
          { name: 'name', propID: 'name', type: 'str', disabled: true },
          { name: '', propID: 'x', type: 'str', disabled: true },
          { name: '', propID: 'y', type: 'str', disabled: true },
          { name: '', propID: 'from', type: 'str', disabled: true },
          { name: '', propID: 'to', type: 'str', disabled: true },
          { name: 'type', propID: 'type_link', type: 'select[hyperlink]' },
          { name: 'description', propID: 'description', type: 'str' }
        ]
      }
    };
    this.prjObjClass = new function() {
      this.propertiesNames = new Array('name', '', '', 'menu_label', 'url', '', '', '', '');
      this.properties = new Array('name', 'x', 'y', 'menu_label', 'url', 'links', 'menu_label_links', 'father', 'menu_label_father');
      this.propertyTypes = new Array('str', 'int', 'int', 'str', 'str', 'str', 'str', 'str', 'str');
    }();

    this.formObj = function() {
      this.objClass = ZTPlanObjects.formObjClass;
      this.my_library = ' ';
      this.global_variables = ' ';
      this.company = (!Empty(companies) ? companies.split(',')[0] : '');
    };

    this.pageObj = function(id, name, type, html, value, shadow, x, y) {
      this.objClass = ZTPlanObjects.pageObjClass;
      this.id = id;
      this.name = name;
      this.menu_label = name;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;
      this.x = x;
      this.y = y;
      this.title = name;
      this.description = 'New Page';
      this.meta = '';
      this.body_attributes = '';
      this.sp_theme = 'false';
      this.theme = '';
      this.css = '';
      this.library = '';
      this.contents = '';
      this.neww = false;
      this.urls = '';
      this.groups = '';
      this.conditions = '';
      this.titles = '';
      this.template = '';
      this.security = 'none';
      this.on_security_failure = 'login';
      this.links = '';
      this.menu_urls_links = '';
      this.menu_label_links = '';
      this.father = '';
      this.menu_label_father = '';
      this.page_type = 'Standard';
      this.user_agent = 'DEFAULT';
      this.layout = 'layout';
      this.redirect = '';
      this.ua_priority = 'true';
      this.sorting = 500;
      this.offline = 'false';
      this.shared_manifest = 'false';
      this.codeevents = '';
      this.codeStatus = '';
      this.published = 'true';
    };

    this.prjObj = function(id, name, type, html, value, shadow, x, y) {
      this.objClass = ZTPlanObjects.prjObjClass;
      this.id = id;
      this.name = name;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;
      this.x = x;
      this.y = y;
      this.menu_label = name;
      this.url = '';
      this.links = '';
      this.menu_label_links = '';
      this.father = '';
      this.menu_label_father = '';
    };
    this.linkObj = function(id, name, type, html, value, shadow, x, y, from, to) {
        this.objClass = ZTPlanObjects.linkObjClass;
        this.id = id;
        this.name = name;
        this.type = type;
        this.html = html;
        this.value = value;
        this.shadow = shadow;
        this.x = x;
        this.y = y;
        this.from = from;
        this.to = to;
        this.type_link = 'hyperlink';
        this.description = '';
      };
      //Oggetti per operazione UNDO
    this.undoObj = function(id, action, x, y, x_init, y_init, obj) {
      this.id = id;
      this.action = action;
      this.x_init = x_init;
      this.y_init = y_init;
      this.x = x;
      this.x = x;
      this.y = y;
      this.obj = obj;
    };
    this.PSToolbarAction = [{
      'id': 'add_new_page',
      'class_name': 'btn',
      'action': function() { addItem('Page'); },
      'image': '../portalstudio/images/icon/btn_add.png',
      'title': 'Add a new page'
    }, {
      'isSeparator': true
    }, {
      'id': 'delete_page',
      'class_name': 'btn',
      'action': function() { deleteItem(); },
      'image': '../portalstudio/images/icon/btn_delete.png',
      'title': 'Delete page'
    }, {
      'id': 'copy',
      'class_name': 'btn',
      'action': function() { CopyPaste(true, false); },
      'image': '../portalstudio/images/icon/btn_copy.png',
      'title': 'Copy'
    }, {
      'id': 'paste',
      'class_name': 'btn',
      'action': function() { CopyPaste(false); },
      'image': '../portalstudio/images/icon/btn_paste.png',
      'title': 'Paste'
    }, {
      'isSeparator': true
    }, {
      'id': 'save',
      'class_name': 'btn',
      'action': function () { save('true'); },
      'image': '../portalstudio/images/icon/btn_savegenerate.png',
      'title': 'Save and generate'
    }];
    this.PSToolbarAlign = [{
      'id': 'bottom_align',
      'class_name': 'btn',
      'action': function() { alignItems('bottom'); },
      'image': '../portalstudio/images/icon/btn_alignbottom.png',
      'title': 'Align bottom'
    }, {
      'id': 'top_align',
      'class_name': 'btn',
      'action': function() { alignItems('top'); },
      'image': '../portalstudio/images/icon/btn_aligntop.png',
      'title': 'Align top'
    }, {
      'id': 'left_align',
      'class_name': 'btn',
      'action': function() { alignItems('left'); },
      'image': '../portalstudio/images/icon/btn_alignleft.png',
      'title': 'Align left'
    }, {
      'id': 'right_align',
      'class_name': 'btn',
      'action': function() { alignItems('right'); },
      'image': '../portalstudio/images/icon/btn_alignright.png',
      'title': 'Align right'
    }];
  }();
}

function selectModel() {
  var list = [''];
  for(var f = 0; f < itemsHTML.length; f++) {
    var cPage = itemsHTML[f];
    if(cPage.type == 'Page' && itemsHTML[index].name != cPage.name && cPage.model == 'true') {
      if(isCMS) {
        list.push(cPage.alias);
      } else {
        list.push(cPage.name);
      }
    }
  }
  return list.join(',');
}
