var folders_container, category_title, main_zone;
var resources_json = null,
  folders_json = null;
var resourceInfo = {};

var sort_by = function(field, reverse, primer) {
  reverse = (reverse) ? -1 : 1;

  return function(a, b) {
    a = a[field];
    b = b[field];

    if (typeof(primer) != 'undefined') {
      a = primer(a);
      b = primer(b);
    }

    if (a < b) return reverse * -1;
    if (a > b) return reverse * 1;
    return 0;
  };
};

function closest(el, fn) {
  return el && (
    fn(el) ? el : closest(el.parentNode, fn)
  );
}

function setResources() {
  main_zone.innerHTML = "";
  category_title.innerHTML += " (" + resources_json.objects.length + ")";

  for (var i = 0; i < resources_json.objects.length; i++) {
    var elem = resources_json.objects[i];
    var UID = Number.random(100000, 10000000000);
    var resource = new Element('div', { 'class': 'resource', 'id': 'resource_' + UID }).inject(main_zone);

    var html = '<div class="resource-header">';
    html += '<div class="image-resource" style="background-image: url(' + SPWebRootURL + '/' + elem.imgPath + ');"></div>';

    var txtToTrim = elem.title;
    resource.typeLabel = txtToTrim;
    var trimmedTxt = (txtToTrim.length > 30) ?
      txtToTrim.substr(0, 1).toUpperCase() + txtToTrim.substring(1, 30) + "..." :
      txtToTrim.substr(0, 1).toUpperCase() + txtToTrim.substring(1);

    html += '<div class="title" title="' + txtToTrim + '">' + trimmedTxt + '</div>';
    html += '<div id="resource_' + UID + '_plus" class="icon-add"></div>';
    html += '</div>';
    html += '<div id="resource_' + UID + '_descr" class="text">' + elem.description + '</div>';

    resource.innerHTML += html;
    resource.originalLink = elem.linkPath;
    resource.type = elem.type;
    resource.title = txtToTrim;
    resourceInfo[resource.type] = { "link": resource.originalLink.replace(SPWebRootURL + "/", "../").replace("?", "&") };
  }

  $('loader').setStyle('display', 'none');
  $$('.icon-add').each(function(el/*, index*/) {
    el.addEvents({
      'click': function(/*evt*/) {
        var res = closest(el, function(el) {
          return el.className === 'resource';
        });
        var link = SPWebRootURL + "/jsp/gscs_be_gadget_config_tpl.jsp";
        /* global curr_zone */
        link += "?title=" + res.typeLabel + "&portlet=" + resourceInfo[res.type].link + "&zone=" + curr_zone + "&type=" + res.type;
        GetOpener().layerOpenForeground(link, res.typeLabel, '', 700, 640, true, 1);
        // WindowClose();
      }
    });
  });
}

function composeDialog() {
  resources_json = eval("(" + new JSURL(SPWebRootURL + "/servlet/SPCMSPanel", true).Response() + ")");
  var rjs = resources_json.objects;
  rjs.sort(sort_by('title', false, function(a) {
    return a.toUpperCase();
  }));
  setResources();

  category_title.innerHTML = "Root (" + resources_json.objects.length + ")";

  if (Empty(folders_json)) {
    folders_json = eval("(" + new JSURL(SPWebRootURL + "/servlet/SPCMSPanel?getAllFolders=yes", true).Response() + ")");
  }

  new Element('div', { 'class': 'folder root selected', 'html': '<span>Root</span>' }).inject(folders_container);

  for (var i = 0; i < folders_json.objects.length; i++) {
    var folder = folders_json.objects[i];
    new Element('div', { 'class': 'folder', 'id': folder.folderName, 'html': "<span>" + folder.folderName + "</span>" }).inject(folders_container);
  }
  $$('.folder').each(function(element/*, index*/) {
    element.addEvents({
      'click': function() {
        if (!this.hasClass('selected')) {
          $$('.selected').each(function(el) {
            el.removeClass('selected');
          });
          this.addClass('selected');
          if (!this.id)
            resources_json = eval("(" + new JSURL(SPWebRootURL + "/servlet/SPCMSPanel", true).Response() + ")");
          else
            resources_json = eval("(" + new JSURL(SPWebRootURL + "/servlet/SPCMSPanel?folder=" + this.id, true).Response() + ")");
          var rjs = resources_json.objects;
          rjs.sort(sort_by('title', false, function(a) {
            return a.toUpperCase();
          }));

          category_title.innerHTML = this.getElement('span').get('text');
          setResources();
        }
      }
    });
  });
}

window.addEvent('domready', function() {
  folders_container = document.getElementById("folder_pane");
  category_title = document.getElementById("title");
  main_zone = document.getElementById("main_zone");
  composeDialog();
});
