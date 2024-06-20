/* exported
  botreeitems
*/

function botreeitems() {
  var jItems;
  var itemsHTML = GetOpener().itemsHTML;
  let sectionName;
  this.fillDataItems = function () {
    if (!Empty(this.selectedBO.Value())) {
      //Leggo gli items dal BO
      this.callBO.Servlet(this.selectedBO.Value());
      this.callBO.Link();
    }
  };

  this.callBO_Result = function (JsonItems) {
    let form = GetOpener().formProp;
    let pagesProp = form.pagesProp;
    let DELTAY = pagesProp[form.page-1].deltay  || 0;
    let DELTAX = pagesProp[form.page-1].deltax  || 0;
    JsonItems = Strtran(JsonItems, "\u0080", "\u20AC");
    JsonItems = Strtran(JsonItems, "$\\u003e", "%\\u003e");
    JsonItems = Strtran(JsonItems, "\\u003c%", "\\u003c%");
    jItems = JSON.parse(JsonItems);
    jItems.shift(); // Levo il Form
    //ordino gli items per  page e per y
    jItems.sort((a, b) => {
      if (a.page > b.page) {
        return 1;
      } else if (a.page < b.page) {
        return -1;
      } else {
        if (parseInt(a.y) > parseInt(b.y)) {
          return 1;
        } else if(parseInt(a.y) < parseInt(b.y)) {
          return -1;
        } else {
          if (parseInt(a.x) > parseInt(b.x)) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    });
    //Set the tabindex incremental
    let first_tab = 0
    jItems.forEach(j => {
      j.y =  j.y - ( DELTAY && ! j.extended ? DELTAY : 0 ); // tolgo il deltay relativo al box o layer
      j.x =  j.x - ( DELTAX && ! j.extended ? DELTAX : 0 ); // tolgo il deltax relativo al box o layer
      if(j.tabindex){
        j.tabindex = (++first_tab).toString();
      }else if(j.type == 'Textbox'){
        j.tabindex = '-1';
      }
    })
    /**
     * itemsHTML:
     *  -get only rapp
     *  -order by page, Y
     *  -if type box make container
     */
    let portletItems = itemsHTML.slice(0).filter(i => i.zone);
    portletItems.sort((a, b) => {
      if (a.page > b.page) {
        return 1;
      } else if (a.page < b.page) {
        return -1;
      } else {
        if (parseInt(a.y) > parseInt(b.y)) {
          return 1;
        } else if(parseInt(a.y) < parseInt(b.y)) {
          return -1;
        } else {
          if (parseInt(a.x) > parseInt(b.x)) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    });
    let rapps = portletItems.filter(i => i.rapp);

    if (rapps.length) {
      rebuildMicrozoneFromPortlet(rapps)
    }
    /**
     * update zone name
     */
    rapps.forEach( z => {
      portletItems.forEach( i => {
        if (!i.rapp && i.zone == z.zone) {
          i.path = z.path;
        }
      })
    })

    /**
     * Make zones from items
     */
    let pzones = rapps.reduce((acc, i) => {

      let zone = {
        name: i.zone, // pag1_2_3
        path: i.path ? i.path : i.zone,
        items: [],
        page: i.page,
        children: [],
        rapp: i.spuid
      };
      //let zone_items = [];
      /* array with only ctrl not in zone with same rapp */
      portletItems = portletItems.filter( c => {
        if( c.zone == i.zone ) {
          zone.items.push(c);
        } else {
          return true;
        }
      }  );
      //zone.items = zone.items.concat(zone_items);
      acc.push(zone);
      return acc;
    }, []);
    /**
     * Add zones without rapp in portlet
     */
    pzones = pzones.concat(findMicroZones(portletItems));

    let bzones = findMicroZones(jItems);
    sectionName = GetOpener().formProp.altInterfaceForSection;
    setDiff(bzones,pzones);
    bzones = bzones.filter( i => (i.notFound || i.diff) );
    /*
    Filter for the current BO Section if needed
    */
   if(sectionName){
      let section, RowZone, isBodyDetail;
      section = bzones.find( i => {
        let items;
        items = i.items.find(it => ( it.name ==  Strtran(Strtran(sectionName, '@BEGIN', ''), '@END', '')));
        if(items ){
          return true;
        }
      } );
      //Layer Body_Row
      if(section){
        isBodyDetail = bzones.find( i => {
          if( i.path.startsWith(section.path )){
            let items = i.items.find(it => ( it.type == 'BodyDetail' ) );
            if(items ){
              return true;
            }
          }
        } );
      }
      RowZone = bzones.find( i => {
        let items = i.items.find(it => ( it.box_type == 'layer' && it.name == 'Body_Row' ) );
        if(items ){
          return true;
        }
      } );
      if(section){
        if(sectionName.indexOf('@')>-1 ) {
          bzones = bzones.filter( i => {
            if(sectionName.indexOf('@')>-1 &&  i.extended){
              return true;
            }
          });
        } else {
          bzones = bzones.filter( i => {
           if( (i.path.startsWith(section.path) && i.path != section.path) || i.extended ){
              i.path = "pag1" + i.path.replace(section.path,"");
              return true;
            }
            //Layer
            if(isBodyDetail && RowZone){
              if(i.path.startsWith(RowZone.path) ){
                return true;
              }
            }
          });
        }
      } else {
        // box shadow
        section = GetOpener().GetOpener().document.getElementById(sectionName);
        bzones = bzones.filter( i => {
          //if( ( (i.items[0].y + DELTAY) > section.offsetTop && (i.items[0].y + DELTAY) < section.offsetTop + section.offsetHeight && section.getAttribute('page') == i.items[0].page) || i.extended ){
          //Seleziono le zone al di fuori dei Section Box ufficiali
          let _ = i.path.split('_').length;
          if( ( section.getAttribute('page') == i.items[0].page && _ < 3 && i.items[0].box_type == null) || i.extended ){
             return true;
           }
         });
      }
    }
    /**
     * Add zones type page: loop first level zone
     * pages list from the origin Bo
     */
    bzones = findBoPages(bzones).concat( bzones );
    pzones = findPortletPages(pzones).concat( pzones );

    bzones = buildZoneStructure( bzones );
    pzones = buildZoneStructure( pzones );

    CreatePortletTree(pzones.children);
    CreateBoTree(bzones.children);
  };

  function setDiff(bzones,pzones){
    let idx=0;
    bzones.filter( bzone => {
      if (bzone.rapp) { //Only microzone
        let bzonesFound = pzones.filter( pzone => {
          if ( !pzone.matched && pzone.rapp == bzone.rapp) {
            if (pzone.items) {
              let portlet_diff = pzone.items.filter( i => {
                if (bzone.items.find(y => y.spuid == i.spuid) == null) {
                  i.diff = true;
                  return true;
                }
              });
              let bo_diff = bzone.items.filter( i => {
                if (pzone.items.find(y => y.spuid == i.spuid) == null) {
                  i.diff = true;
                  return true;
                }
              });
              if (portlet_diff.length || bo_diff.length) {
                idx++;
                pzone.diff = idx;
                bzone.diff = idx;
              }
            }
            pzone.matched = true;
            bzone.matched = true;
            return true;
          }
        });
        if(bzonesFound.length == 0){
          bzone.notFound = true;
        }
      }
    });
    pzones.filter( pzone => {
      if (!pzone.matched ){
        pzone.notFound = true;
      }
    });
  }

  /**
   * change path for rapp of zone
   * @param {*} rapps
   * @param {*} parentId
   * @returns
   */
  function rebuildMicrozoneFromPortlet(rapps, parentId) {
    let idx = 0;
    for (let i = 0; i < rapps.length; i++) {
      let z = rapps[i];
      z.path = (parentId ? parentId : "pag" + z.page) + "_" + (++idx);
      if (z.type == "Box") {
        let zones_in_box = rapps.slice(i + 1).filter(zz => parseInt(zz.y) < parseInt(z.y) + parseInt(z.h) && zz.page == z.page );
        i = i + rebuildMicrozoneFromPortlet(zones_in_box, z.path);
      }
    }
    return idx;
  }

  this.callBO_Error = function (cCause) {
    console.log(cCause);
  };

  this.bopick_icon_Click = function () {
    var offlinemode = false;
    var the_property = "selectedBO";
    var portletId = this.formid;
    window.layerOpenForeground(
      "../jsp-system/SPVQREditorSelectBO_portlet.jsp?hideLinkedTables=true&offlinemode=" +
        offlinemode +
        "&propRef=" +
        the_property +
        "&isForm=false&portletId=" +
        portletId,
      "BO_Picker",
      "",
      500,
      500,
      false,
      1
    );
  };

  this.selectedBO_onChange = function () {
    GetOpener().formProp["altInterfaceFor"] = this.selectedBO.Value();
    if (Empty(GetOpener().formProp["selectZone"])) {
      GetOpener().formProp["selectZone"] = "true";
    }
    GetOpener().FormProperties();
    this.fillDataItems();
  };

  this.this_EnablePage2 = function () {
    return !Empty(this.selectedBO.Value());
  };

  this.this_AfterPageChange = function (n, /* oldn */) {
    if (n == 2 && jItems == null) {
      this.fillDataItems();
    }
  };

  this.this_Loaded = function () {
    if (!Empty(this.selectedBO.Value())) {
      this.ZtTabs.Select("page2");
    }
  };

  function findMicroZones( jItems ) {
    var jItemsZones = [];
    jItemsZones = jItems.slice(0);
    var zones = []; // Array di zone [nomeZona:[items json]]
    //let yet_rapp = jItemsZones.find(j => j.rapp); //rapp already assigned
    /**
     * Make zones from items
     */
    zones = jItemsZones.reduce((acc, i) => {
      let x = acc.find( j => i.zone === j.name );
      if (!x) {
        acc.push({
          name: i.zone, // pag1_2_3
          title: i.zone, // pag1_2_3
          path: i.path ? i.path : i.zone,
          items: [i],
          page: i.page,
          children: [],
          rapp: i.spuid,
          extended: i.extended || false
        });
        i.rapp = true;
      } else {
        x.items.push(i);
      }
      return acc;
    }, []);
    /**
     * Set zone rapp: first if there isn't field
     */

    zones.forEach( z => {
      let field_idx = z.items.findIndex( i => i.type == "Textbox" );
      if( field_idx > -1 ){
        delete z.items[0].rapp;
        z.items[field_idx].rapp = true;
        z.rapp = z.items[field_idx].spuid;
      }
      z.name = z.rapp;
      /**
       * Change item.zone with zone rapp spuid
       */
      z.items.forEach( i => i.zone = z.name );
    });

    return zones;
  }

  function findPortletPages( zones ){
    /**
     * Add zones type page: loop first level zone
     * pages list from the origin Bo
     */
     let pages = zones.reduce((acc, z) => {
      let x = acc.find( j => j.name === "pag"+ z.page );
      if(!x) {
        let portlet_page = GetOpener().formProp.pagesProp[parseInt(z.page)-1];
        let page = {
          name: "pag"+ z.page,
          path: "pag"+ z.page,
          children: [],
          title: "Page " + z.page,
          type: "page",
          key: "pag"+ z.page,
          data: { 'page': parseInt(z.page) }
        };
        if( portlet_page.layer == "true"){
          page.data = {
                      'page': parseInt(z.page),
                'page_type' : 'layer',
            'title_caption': portlet_page.title,
          }
          page.title = portlet_page.title;
        }
        acc.push( page );
      }
      return acc;
    }, []);
    return pages;
  }
  function findBoPages( zones ){
    /**
     * Add zones type page: loop first level zone
     * pages list from the origin Bo
     */
     let pages = zones.reduce((acc, z) => {
      let x = acc.find( j => j.name === "pag"+ z.page );
      if(z.page && !x) {
        acc.push({
          name: "pag"+ z.page,
          path: "pag"+ z.page,
          children: [],
          title: "Page " + z.page,
          type: "page",
          key: "pag"+ z.page,
          data: { 'page': parseInt(z.page) }
        });
      }
      return acc;
    }, []);
    // deve rimanere almeno la pagina 1
    if(pages.length==0){
      pages.push({
        name: "pag1",
        path: "pag1" ,
        children: [],
        title: "Page 1",
        type: "page",
        key: "pag1",
        data: { 'page': 1 }
      });
    }
    /**
     * Set zone's type
     */
    let layer_page_idx = pages.length ;
    zones.forEach( z => {
      if(z.items){
        if( z.items.length == 1 && z.items[0].type == "Box" && z.items[0].box_type == "layer"  ){
          //the Layer create a page
          z.type = 'page';
          z.data = {
                      'page': ++layer_page_idx,
                'page_type' : 'layer',
            'title_caption': z.items[0].title_caption,
                  'box_name': z.items[0].box_name
          };
          z.key = "pag" + z.data.page;
          z.title = z.items[0].title_caption;
        }
      }
    })
    return pages;
  }

  function buildZoneStructure( zones ){
    /**
     * Set zone's type
     */
    zones.forEach( z => {
      if( z?.type != "page" && z.items ){
        z.type = z.items.length == 1 && z.items[0].type == "Box" ?   "container" : "microzone";
      }
    });

    //zones = buildDetailCtrl(zones);
    //Ordina gli itmes per x inversa di modo che nell'Array sono nell ordine di visualizzazione
    sortItems( zones );
    //creo le descrizioni delle zone
    makeDescription( zones );
    let zonesStructured = buildZonesChilds(zones);
    return zonesStructured;
  }

  function sortItems( zones ){
    zones.forEach( i => {
      if( i.items ){
        i.items.sort((a, b) => {
          return parseInt(a.x) > parseInt(b.x)
            ? 1
            : parseInt(a.x) < parseInt(b.x)
            ? -1
            : 0;
        });
      }
    })
  }

  function makeDescription(zones) {
    zones.forEach(i => {
      let diff_found;
      i.title = i.items?.reduce((acc, zz) => {
        if(zz.diff){
          diff_found = true;
        }
        return acc += '<span id="' + zz.spuid + '" class="bo_item' + ( zz.diff ? " diff" : "" ) + '"> ' + (zz.value ? zz.value : zz.name )  + " </span>";
      }, "") ?? i.title;
      if(diff_found){
        i.title += '<span id="' + i.rapp + '_update" class="ico-update" title="Update diff."></span>';
      }
    })
  }
  function makeNodeDescription(node) {
    let str ,diff_found;
    str = node.data.items?.reduce((acc, itm) => {
      if(itm.diff){
        diff_found = true;
      }
      //return acc += '<span id="' + itm.spuid + '" class="bo_item"> ' + (itm.value ? itm.value : itm.name )  + " </span>";
      return acc += '<span id="' + itm.spuid + '" class="bo_item' + ( itm.diff ? " diff" : "" ) + '"> ' + (itm.value ? itm.value : itm.name )  + " </span>";
    }, "") ?? node.title;
    if(diff_found){
      str += '<span id="' + node.rapp + '_update" class="ico-update" title="Update diff."></span>';
    }
    return str;
  }

  /**
   * Build Object with Page->zone->items
   * @param {*} zones
   * @returns {object} Zones
   * @returns {string} Object.name
   * @returns {object} Object.items
   * @returns {object} Object.data
   */
  function buildZonesChilds(zones) {

    class Tree {
      root
      constructor(){
        this.root = new Node("root", "", {}, null);
      }
      add ( name, path, data, parent_name ){
        let parent = this.find(parent_name);
        parent?.add(name, path, data) ?? this.root.add(name, path, data);
      }
      find( path ){
        return this.root.find(path);
      }
      get children(){
        return this.root.children;
      }
    }
    class Node {

      name = "";
      path = "";
      children = [];
      data = {};
      folder = false;
      title = ""
      expanded = true;


      constructor(  name, path, data, parent_name ){
        this.name = name;
        this.path = path;
        Object.keys( data ).forEach( k => this[k] = data[k] );
        this.parent = parent_name;
      }

      add( name, path, data ){
        this.children.push(new Node( name, path, data, this.name ));
        this.folder = true;
        return true;
      }

      /**
       * Find node path in children
       * @param {string} path
       * @returns {node}
       */
      find( path ){
        let f = this.children.find( c => c.path === path);
        if( !f ){
          this.children.find( c => f = c.find( path ))
        }
        return f;
      }

    }

    return zones.reduce( (tree, c) =>{
      /**
       * PageA_B_C
       */
      let parent_name = c.path.substring(0, c.path.lastIndexOf("_") > -1 ? c.path.lastIndexOf("_") : 0 );
      let data = Object.assign( {
        "name": c.name,
        "path": c.path,
        // "parent": tree.find(parent_name)?.name ?? "",
        "items": c.items
      },(c.data?c.data:{}));

      let obj = {
        "title": c.title,
        "type": c.type,
        "data": data,
        "key": c.key,
        "tooltip": ''
      };
      if( c.type == "page" ){
        parent_name = ""; // add in root
        data.page = c.data.page;
        obj.title = c.title + "<span data-page='"+c.data.page+"' class='fancytree-custom-icon ico-moveto move_page' data-key='"+c.key+"' title='Move All'></span>";
      }
      // if( c.type == "layer" ){
      //   parent_name = ""; // add in root
      //   data.title_caption = c.title_caption;
      // }
      data.rapp = c.rapp;
      data.diff = c.diff;
      data.notFound = c.notFound;
      tree.add(c.name, c.path, obj, parent_name)
      return tree;
    }, new Tree() );
  }

  function getBaseline(page_n) {
    //calcolo la baseline massima della page corrente gia' presente nel disegnatore
    let baseline = 0;
    if (itemsHTML.length > 0) {
      baseline = Math.max.apply(
        Math,
       itemsHTML.reduce(
          (acc, o) => {
            if (parseInt(o.page) == page_n) {
              acc.push(parseInt(o.y) + parseInt(o.h));
            }
            return acc;
          },
          [0]
        )
      );
    }
    return baseline;
  }

  this.import_sel_Click = function() {
    var jSelectedItems = [];
    var orderedData = $.ui.fancytree.getTree("#portlet_tree");
    let rebuild = this.rebuilditemspos.Value();

    /**
     * Structured data Page -> <container> -> microzone
     */
    var flatOrderedData = [];
    orderedData.visit( n => {
      flatOrderedData.push( n );
    })

    flatOrderedData.forEach( z => {
      /**
       * Misure microzone from items
       */
      if( z.data.items ){
        /**
         * acc[0,1,2,3] = rect for items
         */
        z.limit = z.data.items.reduce( (acc, i) => {
          acc[0] = Math.min( parseInt(i.y), acc[0])
          acc[1] = Math.max( parseInt(i.y) + parseInt(i.h), acc[1]);
          acc[2] = Math.min( parseInt(i.x), acc[2])
          acc[3] = Math.max( parseInt(i.x) + parseInt(i.w), acc[3]);
          // i.page = page;
          return acc;
        }, [Number.MAX_SAFE_INTEGER,0,Number.MAX_SAFE_INTEGER,0]);
        z.h = z.limit[1] - z.limit[0];
        z.w = z.limit[3] - z.limit[2];
      }else{
        //if layer page with no data.items
        if( z.type == "page" && z.data.page_type == "layer" ) {
          let layer = GetOpener().formProp.pagesProp[z.data.page-1];
          z.h = layer.h;
          z.w = layer.w;
          z.limit =[0, z.h, 0, z.w];
        }
      }
    })

    /**
     * Visit from leaf to root, result is array of children result and
     * calculate container height with max between box-height and sum children heights
     */

    visitAndDo($.ui.fancytree.getTree("#portlet_tree").getRootNode(), (result,z) => {
      let h = 0;
      let x = 0;
      let xx = 0;
      if( z.type == "microzone" ) {
        h = z.h;
        x = z.limit[2];
        xx = z.limit[3];
      } else if( z.type == "container" || z.type == "page" && z.data.page_type == "layer" ) {
        //Only in rebuild mode the box height is modified
        h = z.h = rebuild ? Math.max( result.reduce( (a,r,i) => a + r.h + 20 + (i == 0 ? 20 : 0), 0) , z.h ) : z.h;
        x = z.x = Math.min.apply( null, result.map ( r => r.x  ).concat(z.limit[2]).concat(0) );
        xx = Math.max.apply( null, result.map( r => r.xx + 20 ).concat(z.limit[3]) );
        z.w = xx - x;
      }
      return {h: h, x: x, xx: xx};
    }, []);
    /**
     * Set items y with baseline for every page
     */
    //&& (n.children || form.pagesProp[n.data.page - 1])
    let max_page = Math.max.apply( null, flatOrderedData.reduce( (acc,z) => {
      if( z.type == "page" && z.children ) {
        acc.push(z.data.page);
      }
      return acc;
    },[]).concat( [ GetOpener().formProp.pagesProp.reduce( (a,p) => {
      a = a + ( p.layer != "true" ? 1 : 0);
      return a;
    }, 0) ] ));
    max_page;
    let page = 0;
    let delta = 0;
    //let tree_items = [];
    /**
     * Set y for items in microzone and y,h,w for box:
     * every parent has baseline, microzone increment baseline of parent.
     * Box increments parent's baseline with his height
     */
    getBaseline(1);
    let tabindex = 1;
    let form = GetOpener().formProp;
    let pagesProp = form.pagesProp;
    //let DELTAY = pagesProp[form.page-1].deltay  || 0;
    orderedData.visit( n => {
      if ( n.type == "page" ){
        // page = n.data.page;
        page++;
        n.data.page = page;
        //n.baseline = getBaseline(page) + 20;
        n.baseline = 20;
      // } else if( n.type == "layer") {
      //   // page = ++max_page;
      //   page++;
      //   n.baseline = 20;
      //   n.data.page = page;
      } else if( n.data.items ){
        if ( n.type == "container" ){
          delta = n.limit[0] - n.parent.baseline;
          n.baseline = n.parent.baseline + 20;
          n.parent.baseline = n.parent.baseline + n.h + 20;
        } else {
          delta = n.limit[0] - n.parent.baseline;
          n.parent.baseline = n.parent.baseline + n.h + 20;
        }
        /**
         * Set y for every item
         */
        let deltax = null;
        n.data.items.forEach( i => {
          //tree_items.push(i);
          if(deltax == null){
            deltax =parseInt( n.data.items[0].x ) - 20;
          }
          let ctrl = itemsHTML.find( ctrl => ctrl.spuid == i.spuid ); //if ctrl in portlet, move it
          if( !ctrl ){
            jSelectedItems.push(i);
            ctrl = i;
          }
          ctrl.page = page;
          //ctrl.y = parseInt(i.y) - (rebuild ? delta - DELTAY : 0);
          ctrl.y = parseInt(i.y) - (rebuild ? delta  : 0);
          if(rebuild){
            ctrl.x = i.x - deltax;
          }
          /**
           * Set dimension for item Box of Zone layer and Zone container
           */
          if( n.type != "microzone" ) {
            ctrl.h = n.h;
            ctrl.w = n.w;
            ctrl.x = n.x;
          }else{
            if(ctrl.tabindex){
              ctrl.tabindex = tabindex ++;
            }
            if(ctrl.name=='CPROWNUM'){
              ctrl.tabindex = -1;
              ctrl.readonly = 'true';
            }
          }
        });
      }
    })

    /**
     * Remove Old element in itemsHTML
     */
    //let form = GetOpener().formProp;
    let bo_tree = $.ui.fancytree.getTree("#bo_tree");
    let bo_flat = [];
    bo_tree.visit( z => bo_flat.push(z) );
    /**
     * If element is removed from portletTree, remove it from itemsHTML
     */
     bo_flat = bo_flat.filter( el =>
      flatOrderedData.findIndex( i => i.data.name == el.data.name ) == -1
    );
    bo_flat.forEach( z => {
      z.data?.items?.forEach(el => {
        let idx = itemsHTML.findIndex( i => i.spuid == el.spuid );
        if(idx>-1){
          itemsHTML.splice( idx , 1 );
        }
      })
    });
    GetOpener().countindex = itemsHTML.length;

    /**
     * If new portlet add form
     */
    // if (itemsHTML.length == 0) {
      /**
       * Form dimensions
       */
      flatOrderedData.forEach( n => {
        if (n.type == "page" || n.type == "layer"){
          /**
           * Calculate xx and yy
           */
          let form_dimension = itemsHTML.concat(jSelectedItems).filter( i => i.page == n.data.page && !i.hidden )
            .reduce( (acc, o) => {
              acc[0] = Math.max( parseInt(o.x) + parseInt(o.w), acc[0]);
              acc[1] = Math.max( parseInt(o.y) + parseInt(o.h), acc[1]);
              return acc;
            }, [0, 0]);
          let page = pagesProp[n.data.page - 1] || {
            h: n.data.page_type != "layer" ? '300' : '0',
            w: n.data.page_type != "layer" ? '400' : '0'
          }; //pageProp start from 0, page start with 1
          page.title = page.title ? page.title : (n.data.page_type == "layer" ? n.data.title_caption : '');
          page.layer = page.layer ? page.layer : n.data.page_type == "layer" ? "true" : "false";
          page.layout_steps_values ={};
          page.altInterfacePage = true;
          page.name = n.data.box_name; // needed to open layer , in Bo the layer has name
          /**
           * For Detail Body the box layer with name '__body__grid__' must be titled as 'Body_Row' to generate correct altInterface
           */
          if(page.layer =='true' && page.name == '__body__grid__'){
            page.title = 'Body_Row';
          }
          /**
           * If LayoutSteps not modify form width
           */
          if( !form.layout_step ){
            //page.h = (Math.max( parseInt(page.h), form_dimension[1] + 20 ) - (this.rebuilditemspos.Value()?0:DELTAY)).toString();
            page.h = (Math.max( parseInt(page.h), form_dimension[1] + 20  )).toString();
            page.w = (Math.max( parseInt(page.w), form_dimension[0] + 20 )).toString();
          } else {
            /**
             * TODO
             */
            // page.layout_steps_values = form.npages < n.data.page ? page.layout_steps_values : form.steps.split(",").reduce( (acc,step) => {
            //   if(step){
            //     acc[step] = {
            //       w : form_dimension[0] + 20,
            //       h: form_dimension[1] + 20
            //     }
            //   }
            //   return acc;
            // }, {}) ;
          }
          pagesProp[n.data.page - 1] = page ;
        }

      })
      form.pages_names = form.pagesProp.map( p => p.title).join(",");
      form.page_layer = form.pagesProp.map( p => p.layer).join(",");
      form.h = form.pagesProp.map( p => p.h).join(",");
      form.w = form.pagesProp.map( p => p.w).join(",");
      form.language = 'true';
      // form.altInterfaceSelectedItems = JSON.stringify(orderedData.toDict(true));
      // jSelectedItems.unshift({
      //   type: "Form",
      //   w: pages_w,
      //   h: pages_h
      // });

    // }
    GetOpener().b_reload = true;
    if(sectionName && Empty(GetOpener().document.getElementById('srcform').value)){
      GetOpener().document.getElementById('srcform').value = sectionName.replace('@', '_AT_');
      GetOpener().document.getElementById('srcform').dispatchEvent(new Event('change'));
    }
    if( jSelectedItems.length > 0 ){
      GetOpener().reload_(jSelectedItems, true, true);
    }else{
      GetOpener().writeHTML(true);
      GetOpener().b_reload = false;
    }
    window.close();
  }

  // var LAST_EFFECT_DO = null,
    // LAST_EFFECT_DD = null,
    // lazyLogCache = {};

  function CreateBoTree(source) {
    $("#bo_tree").fancytree({
      treeId: "1",
      extensions: ["dnd5", "multi"],
      // selectMode: 3,
      titlesTabbable: true,
      source: source,
      idPrefix: "bo-",
      generateIds: true,
      autoCollapse: false, // Automatically collapse all siblings, when a node is expanded
      checkbox: false, // Show check boxes
      // checkboxAutoHide: true, // Display check boxes on hover only
      debugLevel: 0, // 0:quiet, 1:errors, 2:warnings, 3:infos, 4:debug
      // icon: false, // Display node icons
      tabindex: -1, // Whole tree behaves as one single control
      tooltip: true, // Use title as tooltip (also a callback could be specified)

      multi: {
        mode: "sameType",
      },
      // unselectable: function(event, data) {
      //   // return data.node.isFolder();
      // },
      types: {
        "container": {icon: "ico-container", iconTooltip: "This is a container"},
        "microzone": {icon: "ico-microzone", iconTooltip: "This is a microzone"},
        "page": {icon: "ico-page", iconTooltip: "This is a page"},
        "layer": {icon: "ico-layer", iconTooltip: "This is a page"}
      },

      icon: function(event, data) {
        // data.typeInfo contains tree.types[node.type] (or {} if not found)
        // Here we will return the specific icon for that type, or `undefined` if
        // not type info is defined (in this case a default icon is displayed).
        return data.typeInfo.icon;
      },
      iconTooltip: function(event, data) {
        return data.typeInfo.iconTooltip;
      },
      renderNode: function(event, data) {
        if(data.node.type == 'page'){
          $(data.node.span).find(".fancytree-title").addClass("page");
          $(data.node.span).find(".move_page").on("click", e => {
            e.stopPropagation();
            // let page_n = p.dataset.page;
            let key = data.node.key;
            let bo_node =  $.ui.fancytree.getTree("#bo_tree").getNodeByKey(key);
            let portlet_node =  $.ui.fancytree.getTree("#portlet_tree").getNodeByKey(key);
            if ( !portlet_node ) {
              /**
               * Add page if not already present
               */
              let root = $.ui.fancytree.getTree("#portlet_tree").getRootNode();
              //let first_layer_index = root.children.findIndex( p => p.type == "layer" );
              //let index = first_layer_index > -1 ? first_layer_index : root.children.length + 1;
              portlet_node = bo_node.copyTo(root ,'child');
              while( bo_node.children ){
                bo_node.removeChild(bo_node.children[0]);
              }
              // portlet_node =$.ui.fancytree.getTree("#portlet_tree").getRootNode().addNode({
              //       name: key,
              //   children: [],
              //       title: "Page " + index,
              //       type: "page",
              //         key: key,
              //       data: { 'page': index }
              //   }, "child" );
            } else{
              /**
               * Remove children when empty
               */
              while( bo_node.children ){
                bo_node.children[0].moveTo( portlet_node, "over");
              }
            }
            portlet_node.setExpanded(true);
          });
        }
        if( data.node.data.diff ){
          data.node.span.setAttribute("diff",data.node.data.diff);
           //bottone per l'update delle diff
           $(data.node.span).find("#"+ data.node.data.rapp + "_update").off(); //remove all events before
           $(data.node.span).find("#"+ data.node.data.rapp + "_update").on("click",function(){UpdateZone(data.node)} );
        }
        if( data.node.data.notFound ){
          data.node.span.setAttribute("notFound",true);
        }
      },
      // init: function (event, data) {
      //   //       data.tree.getFirstChild().setTitle("C:\\");
      // },
      dnd5: {
        multiSource: true,
        // autoExpandMS: 400,
        // preventForeignNodes: true,
        // preventNonNodes: true,
        preventRecursion: true, // Prevent dropping nodes on own descendants
        // preventSameParent: true,
        preventVoidMoves: true, // Prevent moving nodes 'before self', etc.
        // effectAllowed: "all",
        // dropEffectDefault: "move", // "auto",
        dropMarkerInsertOffsetX: 0, // Additional offset for drop-marker with hitMode = "before"/"after"
        dropMarkerOffsetX: 0, // Additional offset for drop-marker with hitMode = "before"/"after"
        // --- Drag-support:

        dragStart: function (node, data) {
          /* This function MUST be defined to enable dragging for the tree.
           *
           * Return false to cancel dragging of node.
           * data.dataTransfer.setData() and .setDragImage() is available
           * here.
           */
          // Set the allowed effects (i.e. override the 'effectAllowed' option)
          data.effectAllowed = "all";

          // Set a drop effect (i.e. override the 'dropEffectDefault' option)
          // data.dropEffect = "link";
          //         data.dropEffect = "copy";
          data.dropEffect = "move";

          // We could use a custom image here:
          // data.dataTransfer.setDragImage($("<div>TEST</div>").appendTo("body")[0], -10, -10);
          // data.useDefaultImage = false;

          // Return true to allow the drag operation
          if ( node.type == "page" ){
            return false
          } else {
            return true;
          }
        },
        // dragDrag: function(node, data) {
        //   logLazy("dragDrag", null, 2000,
        //     "T1: dragDrag: " + "data: " + data.dropEffect + "/" + data.effectAllowed +
        //     ", dataTransfer: " + data.dataTransfer.dropEffect + "/" + data.dataTransfer.effectAllowed );
        // },
        // dragEnd: function(node, data) {
        //   node.debug( "T1: dragEnd: " + "data: " + data.dropEffect + "/" + data.effectAllowed +
        //     ", dataTransfer: " + data.dataTransfer.dropEffect + "/" + data.dataTransfer.effectAllowed, data);
        //     alert("T1: dragEnd")
        // },

        // --- Drop-support:

        dragEnter: function (node, data) {
          // data.dropEffect = "copy";

           // data.dropEffect = "copy";
          // return node.type != "microzone";
          let element = data.otherNode;
          let result = {
            "before": false,
              "over": false,
             "after": false
          }
          switch ( element.type ){
            case "microzone":
            case "container":
              if( ( node.type == "page" || node.type == "layer") ) {
                result.over = true;
              }
              if( node.type == "container") {
                result.before = true;
                result.over = true;
                result.after = true;
              }
              if( node.type == "microzone" ){
                result.before = true;
                result.after = true;
              }
              break;
            case "layer":
              if( ( node.type == "page" || node.type == "layer") ) {
                result.before = true;
                result.after = true;
              }
              if( node.type == "container") {}
              if( node.type == "microzone" ) {}
              break;
          }
          //return result;
          if( data.otherNode.tree === data.tree ) { //!same tree
            return false;
          }else{
            return result ;
          }
          // return false;
        },
        dragOver: function (node, data) {
          // Assume typical mapping for modifier keys
          data.dropEffect = data.dropEffectSuggested;
          // data.dropEffect = "move";
        },
        dragDrop: function (node, data) {
          /* This function MUST be defined to enable dropping of items on
           * the tree.
           */
          var newNode,
            // transfer = data.dataTransfer,
            sourceNodes = data.otherNodeList,
            mode = data.dropEffect;

          if (data.hitMode === "after") {
            // If node are inserted directly after tagrget node one-by-one,
            // this would reverse them. So we compensate:
            sourceNodes.reverse();
          }
          if (node.parent) {
            node.parent;
          }
          if (data.otherNode) {
            // Drop another Fancytree node from same frame (maybe a different tree however)
            var sameParent = data.otherNode.parent === node;
            if (!sameParent && data.hitMode === "over") {
              data.otherNode.data.parent = node.data.name;
            }
            // var sameTree = (data.otherNode.tree === data.tree);
            if (mode === "move") {
              data.otherNodeList.forEach(element => {
                /**
                 * Not move page
                 */
                if( element.type != "page" ) {
                  /**
                   * Move into not microzone
                   */
                  if(
                    ( element.type == "microzone" && (
                      (( node.type == "page" || node.type == "layer") && data.hitMode == "over" ) ||  //insert into
                      node.type == "container" || // in after and before a box
                      ( node.type == "microzone" && data.hitMode != "over" ) // sorting
                    )) ||
                    (element.type == "layer" &&
                      (node.type == "page" || node.type == "layer") && data.hitMode != "over" ) ||  // layer sort with layers and pages
                    (element.type == "container" && ((
                      ( node.type == "page" || node.type == "layer") && data.hitMode == "over" ) ||  //insert into layers and pages
                      ( node.type == "container") ||  // in, after and before a box
                      (node.type == 'microzone' && data.hitMode != 'over') // after and before microzone
                    ))
                  ){
                    //console.log( [element.type, node.type, data.hitMode] );
                    element.moveTo( node, data.hitMode );
                    element.setSelected(false);
                  }
                }
              });
              // data.otherNode.moveTo(node, data.hitMode);
            } else {
              newNode = data.otherNode.copyTo(node, data.hitMode);
              if (mode === "link") {
                newNode.setTitle("Link to " + newNode.title);
              } else {
                newNode.setTitle("Copy of " + newNode.title);
              }
            }
          }
          node.setExpanded();
        },
      }
    });
  }
  function UpdateZone(node){
    let node_p = $.ui.fancytree.getTree("#portlet_tree").findFirst(function(n) {
      return n.data.rapp == node.data.rapp;
    });
    if(node_p){
      // let bz = bzones.find(z => z.rapp == node.data.rapp);
      // if(bz){
      //   bz.diff = null;
      // }
      //node.data.title = 'ciaoooooo';
      node.data.diff = null;
      node.data.items.forEach(i => {
        i.diff=false;
      })
      node.title = makeNodeDescription(node);
      node.moveTo(node_p,'before');
      node.span.removeAttribute('diff');
      $(node.span).find("#"+ node.data.rapp + "_update").removeClass('ico-update');
      $(node.span).find('.diff').removeClass('diff')
      node_p.remove();
    }
  }
  function CreatePortletTree( pages ) {
    $("#portlet_tree").fancytree({
      treeId: "2",
      idPrefix: "portlet-",
      generateIds: true,
      source: getPortletItems(pages),
      debugLevel: 0, // 0:quiet, 1:errors, 2:warnings, 3:infos, 4:debug
      // source: pages,
      types: {
        "container": {icon: "ico-container", iconTooltip: "This is a container"},
        "microzone": {icon: "ico-microzone", iconTooltip: "This is a microzone"},
        "page": {icon: "ico-page", iconTooltip: "This is a page"},
        "layer": {icon: "ico-layer", iconTooltip: "This is a page"}
      },
      renderNode: function(event, data) {
        if(data.node.type == 'page'){
          let title = $(data.node.span).find(".fancytree-title");
          if( data.node.children ){
            title.html( title.text() + "<span data-page='"+data.node.key+"' class='fancytree-custom-icon ico-remove-all remove_page' data-key='"+data.node.data.page+"' title='Remove All'></span>");
          }
          title.addClass("page");
          $(data.node.span).find(".remove_page").on("click", removeAll.bind(null, data.node.key));
        } else if( data.node.data.diff ){
          data.node.span.setAttribute("diff",data.node.data.diff);
        }
        if( data.node.data.notFound ){
          data.node.span.setAttribute("notFound",true);
        }
      },
      icon: function(event, data) {
        // data.typeInfo contains tree.types[node.type] (or {} if not found)
        // Here we will return the specific icon for that type, or `undefined` if
        // not type info is defined (in this case a default icon is displayed).
        return data.typeInfo.icon;
      },
      extensions: ["dnd5", "multi"],
      multi: {
        mode: "sameType",
      },
      // unselectable: function(event, data) {
      //  // return data.node.isFolder();
      // },
      dnd5: {
        multiSource: true,
        // autoExpandMS: 400,
        // preventForeignNodes: true,
        // preventNonNodes: true,
        preventRecursion: true, // Prevent dropping nodes on own descendants
        // preventSameParent: true,
        preventVoidMoves: true, // Prevent moving nodes 'before self', etc.
        // effectAllowed: "all",
        // dropEffectDefault: "move", // "auto",
        dropMarkerInsertOffsetX: 0, // Additional offset for drop-marker with hitMode = "before"/"after"
        dropMarkerOffsetX: 0, // Additional offset for drop-marker with hitMode = "before"/"after"


        // --- Drag-support:

        dragStart: function (node, data) {
          /* This function MUST be defined to enable dragging for the tree.
           *
           * Return false to cancel dragging of node.
           * data.dataTransfer.setData() and .setDragImage() is available
           * here.
           */

          // Set the allowed effects (i.e. override the 'effectAllowed' option)
          data.effectAllowed = "all";

          // Set a drop effect (i.e. override the 'dropEffectDefault' option)
          // data.dropEffect = "link";
          //         data.dropEffect = "copy";
          data.dropEffect = "move";

          // We could use a custom image here:
          // data.dataTransfer.setDragImage($("<div>TEST</div>").appendTo("body")[0], -10, -10);
          // data.useDefaultImage = false;

          // Return true to allow the drag operation
          if ( node.type == "page" ){
            return false
          } else {
            return true;
          }
          //return true;
        },
        // dragDrag: function(node, data) {
        //   logLazy("dragDrag", null, 2000,
        //     "T1: dragDrag: " + "data: " + data.dropEffect + "/" + data.effectAllowed +
        //     ", dataTransfer: " + data.dataTransfer.dropEffect + "/" + data.dataTransfer.effectAllowed );
        // },
        // dragEnd: function(node, data) {
        //   node.debug( "T1: dragEnd: " + "data: " + data.dropEffect + "/" + data.effectAllowed +
        //     ", dataTransfer: " + data.dataTransfer.dropEffect + "/" + data.dataTransfer.effectAllowed, data);
        //     alert("T1: dragEnd")
        // },

        // --- Drop-support:

        dragEnter: function (node, data ) {
          // data.dropEffect = "copy";
          // return node.type != "microzone";
          let element = data.otherNode;
          let result = {
            "before": false,
              "over": false,
             "after": false
          }
          switch ( element.type ){
            case "microzone":
            case "container":
              if( ( node.type == "page" || node.type == "layer") ) {
                result.over = true;
              }
              if( node.type == "container") {
                result.before = true;
                result.over = true;
                result.after = true;
              }
              if( node.type == "microzone" ){
                result.before = true;
                result.after = true;
              }
              break;
            case "layer":
              if(data.otherNode.tree != data.tree && ( node.type == "page" || node.type == "layer") ) { //! in same portlet tree
                result.before = true;
                result.after = true;
              }
              if( node.type == "container") {}
              if( node.type == "microzone" ) {}
            break;
          }
          return result;

        },
        dragOver: function (node, data) {
          //         logLazy("dragOver", null, 2000,
          //           "T1: dragOver: " + "data: " + data.dropEffect + "/" + data.effectAllowed +
          //           ", dataTransfer: " + data.dataTransfer.dropEffect + "/" + data.dataTransfer.effectAllowed );

          // Assume typical mapping for modifier keys
          data.dropEffect = data.dropEffectSuggested;
          //data.dropEffect = "none";
          // data.dropEffect = "move";
        },
        dragDrop: function (node, data) {
          /* This function MUST be defined to enable dropping of items on
           * the tree.
           */
          var newNode,
            // transfer = data.dataTransfer,
            sourceNodes = data.otherNodeList,
            mode = data.dropEffect;

          if (data.hitMode === "after") {
            // If node are inserted directly after tagrget node one-by-one,
            // this would reverse them. So we compensate:
            sourceNodes.reverse();
          }
          if (node.parent) {
            node.parent;
          }
          if (data.otherNode) {
            // Drop another Fancytree node from same frame (maybe a different tree however)
            var sameParent = data.otherNode.parent === node;
            // var sameTree = (data.otherNode.tree === data.tree);
            if (!sameParent && data.hitMode === "over") {
              data.otherNode.data.parent = node.data.name;
            }

            if (mode === "move") {
              data.otherNodeList.forEach(element => {
                /**
                 * Not move page
                 */
                if( element.type != "page" ) {
                  /**
                   * Move into not microzone
                   */
                  if(
                    ( element.type == "microzone" && (
                      (( node.type == "page" || node.type == "layer") && data.hitMode == "over" ) ||  //insert into
                      node.type == "container" || // in after and before a box
                      ( node.type == "microzone" && data.hitMode != "over" ) // sorting
                    )) ||
                    (element.type == "layer" &&
                      (node.type == "page" || node.type == "layer") && data.hitMode != "over" ) ||  // layer sort with layers and pages
                    (element.type == "container" && ((
                      ( node.type == "page" || node.type == "layer") && data.hitMode == "over" ) ||  //insert into layers and pages
                      ( node.type == "container") ||  // in, after and before a box
                      (node.type == 'microzone' && data.hitMode != 'over') // after and before microzone
                    ))
                  ){
                    //console.log( [element.type, node.type, data.hitMode] );
                    element.moveTo( node, data.hitMode );
                    element.setSelected(false);
                  }
                }
              });
              // data.otherNode.moveTo(node, data.hitMode);
            } else {
              newNode = data.otherNode.copyTo(node, data.hitMode);
              if (mode === "link") {
                newNode.setTitle("Link to " + newNode.title);
              } else {
                newNode.setTitle("Copy of " + newNode.title);
              }
            }
          }
          node.setExpanded();
        },
      },
    });
  }

  function getPortletItems( pages ){
    // return pages;
    if( pages.length ){
      return pages;
    // var form = GetOpener().formProp;
    // // if(!Empty(form.altInterfaceSelectedItems)){
    // //   return JSON.parse(form.altInterfaceSelectedItems);
    } else{
      return GetOpener().formProp.pagesProp.map( (p,i) => {
        let page_n = i + 1;
        return {
          name: "pag" + page_n,
          children: [],
          title: "Page " + page_n,
          type: p.layer != "true" ? "page" : "layer",
          key: "pag"+ page_n,
          data: {
            "page": page_n,
            "form_portlet": true
          }
        }
      });
    }
  }

    /** Call fn(node) for all child nodes in hierarchical order (depth-first).<br>
   * Stop iteration, if fn() returns false. Skip current branch, if fn() returns "skip".<br>
   * Return "stop" if iteration was stopped.
   *
   * @param {function} fn the callback function.
   *     Return false to stop iteration, return "skip" to skip this node and
   *     its children only.
   * @param {boolean} [includeSelf=false]
   * @returns {Array} result
   */
  function visitAndDo( node, fn, res) {
    var i,
      l,
      children_result = [],
      children = node.children;

    if (children) {
      for (i = 0, l = children.length; i < l; i++) {
        children_result[i] = visitAndDo(children[i], fn, res);
        // if (res === false) {
          // break;
        // }
      }
    }

    let result = fn(children_result,node);
    // if (res === "stop" || res === "skip") {
      // return res;
    // }

    return result;
  }

  function removeAll( key ){
    let portlet_node =  $.ui.fancytree.getTree("#portlet_tree").getNodeByKey(key);
    let bo_node =  $.ui.fancytree.getTree("#bo_tree").getNodeByKey(key);
    /**
     * Remove children when empty
     */
    while( portlet_node.children ){
      portlet_node.children[0].moveTo( bo_node, "over");
    }
    if( !portlet_node.data.form_portlet && portlet_node.key != 'pag1' ){
      portlet_node.remove();
    }
    bo_node.setExpanded(true);
  }
}
