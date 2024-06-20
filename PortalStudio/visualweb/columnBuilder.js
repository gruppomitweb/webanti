/*
exported SPTheme
*/
jQuery.noConflict();
(function ( win, $ ) {
  'use strict';

  /* Column Default value */
  var defaultValue = {
    "field" : "",
    "title" : "",
    "font_family" : "",
    "bg_color" : "",
    "fg_color" : "",
    "font_weight" : "",
    "font_size" : "",
    "align" : "",
    "col_class" : "",
    "width" : "",
    "height" : "",
    "fixedwidth" : "",
    "ColSpan" : 0,
    "RowSpan" : 0,
    "picture" : "",
    "layer" : "",
    "newline" : false,
    "enable_HTML" : false,
    "sanitize" : "xssPrevent",
    "sanitize_tags" : "",
    "orderby_field" : "",
    "extensible" : false,
    "link" : "",
    "target" : "",
    "onclick" : "",
    "droppable" : false,
    "droppable_name" : "",
    "disable_fields_conditions" : "",
    "title_tooltip" : "",
    "type":"C",
    "title_align":"",
    "printable": true
  }
  /* End Column Default value */

  /* Global var */
  var sptable, queryFieldTable;
  /* End Global var */

  /* Create TableOptions for column */

  var tableOpt = {
    struct: [
      {
        title: 'Title',
        editable: true,
        cssClass: 'table-title',
        input_type: 'text',
        alias: 'title'
      },{
        title: 'Expression',
        editable: true,
        cssClass: 'table-expr',
        input_type: 'text',
        alias: 'field'
      },{
        title: 'Editable',
        editable: true,
        cssClass: 'table-edit',
        input_type: 'checkbox',
        alias: 'isEditable'
      }
      ,{
        title: 'Hidden',
        editable: true,
        cssClass: 'table-hidden',
        input_type: 'checkbox',
        alias: 'hidden'
      }
      ,{
        title: 'Secondary bar',
        editable: true,
        cssClass: 'table-show-extra-title',
        input_type: 'checkbox',
        alias: 'show_extra_title'
      }
      ,{
        title: 'Printable',
        editable: true,
        cssClass: 'table-printable',
        input_type: 'checkbox',
        alias: 'printable'
      }
    ],
    theadClass: 'thead_table title',
    tbodyClass: 'table_content',
    trClass: 'table_row',
    rowSelectedClass: 'row_selected',
    onSelectRow: PopolateProps,  // parameter: idx
    sortable: true,
    sortHandle: '#sort-handler'
  };

  var queryFieldTableOpt = {
    struct: [
      {
        title: 'Title',
        editable: false,
        cssClass: 'table-query-field-title',
        input_type: 'text',
        alias: 'table-query-field-title'
      },{
        title: 'Fields',
        editable: false,
        cssClass: 'table-query-field',
        input_type: 'text',
        alias: 'table-query-field'
      },{
        title: 'Select',
        editable: true,
        cssClass: 'table-field-selected',
        input_type: 'checkbox',
        alias: 'query-field-selected'
      }
    ],
    theadClass: 'thead_table title',
    tbodyClass: 'table_content',
    trClass: 'table_row',
    rowSelectedClass: 'row_selected',
  }

  /* End TableOptions */

  /* QueryString */

  function getParameterByName(name) {
    var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
  }

  /* End QueryString */

  /* Load Parameters */

  var returnObjectIndex = getParameterByName( "for" ),
    opener = GetOpener(),
    returnObj = opener.itemsHTML[returnObjectIndex],
    FieldsList = opener.TempArray[0],
    DescList=opener.TempArray[1],
    fieldsTypes = opener.TempArray[2],
    FieldsTypes = {},
    ColArrObj ={}
  if(Empty(FieldsList)) FieldsList=[];
  for(var ii=0;ii<FieldsList.length;ii++){
    FieldsTypes[FieldsList[ii]]=fieldsTypes[ii];
  }
  if(returnObj.colProperties){ // Properties in json
    var a=JSON.parse(returnObj.colProperties);
    /* array to obj with index like key*/
    a.forEach( function(it,ii) {
      ColArrObj[ii] = it;
      // retrocomp. printable
      if(!("printable" in it))
        ColArrObj[ii].printable = true;
    });


  }
  /* End Load Parameters */

  var editableMessageSend = (!Empty(returnObj.checkbox_fields) ? true : false);

  /* Populate Comumn */

  function PopolateColumns(){
    var data = [];
    // for (var i=0; i<ColArrObj.length; i++){
    for( var ii in ColArrObj ) {
      // columns_list.options[i] = new Option(ColArrObj[i]['alias'], ColArrObj[i]['alias'], false, false);
      //columns_layer_type.innerHTML+='<div style="height:15px">a</div>'
      data[ii] = [
        ColArrObj[ii]['title'], //title
        ColArrObj[ii]['field'],  //expression
        ColArrObj[ii]['isEditable'], //editable
        ColArrObj[ii]['hidden'] ,
        ColArrObj[ii]['show_extra_title'],
        ColArrObj[ii]['printable']
      ]
      editableMessageSend = ( editableMessageSend
        ? editableMessageSend
        : (!Empty(ColArrObj[ii]['isEditable'])
          ? ColArrObj[ii]['isEditable']
          : false )
      )

    }
    if( data.length )
      sptable.option( 'data', data );
  }

  /* End Populate Comumn */

  /* Popolate Props */

  function PopolateProps( idx ) {
    var rowId = idx ;
    if( typeof(idx) == 'undefined' )
      rowId = sptable.getSelectedRowIdx();
    if(rowId!=-1 && ColArrObj[rowId] ){
      //Titolo della colonna corrente
      $('#table_footer_title').text('Column: '+(!Empty(ColArrObj[rowId]['title'])?ColArrObj[rowId]['title']:ColArrObj[rowId]['field']));
      // mostra i dati del nuovo selezionato
      $('.ps-prop').each( function ( ii, prop ) {
        var value = '';
        switch ( prop.id ) {
          case 'link':
          case 'field':
          case 'target':
          case 'onclick':
          case 'align':
          case 'picture':
          case 'col_class':
            value = (typeof(ColArrObj[rowId][prop.id])=='undefined' ? defaultValue[prop.id] :Strtran( Strtran( Strtran( ColArrObj[rowId][prop.id], '$|$', ',') , '|', ',' ),'$',','));
            break;
          case 'title':
            value = (typeof(ColArrObj[rowId][prop.id])=='undefined' ? defaultValue[prop.id]: ColArrObj[rowId][prop.id]);
            break;
          case 'fg_color':
          case 'bg_color':
            value = (typeof(ColArrObj[rowId][prop.id])=='undefined' ? defaultValue[prop.id] :Strtran( Strtran( ColArrObj[rowId][prop.id], '|', ',' ),'$',','));
            $(prop).data('custom-SPPropertie').value(value);

            var objInput = $(prop).data('custom-SPPropertie').Input[0];
            objInput.className += ' properties_color';

            $(prop).data('custom-SPPropertie').Buttons[0][0].id = objInput.id+"_btn";
            jsColorPicker('input.properties_color', {
              size: 1,
              expires: 365, // durata del cookie contentente i colori salvati
              noResize: true,
              init: function(elm/*, col*/) {
                document.getElementById(elm.id+"_btn").style.backgroundColor = elm.value;
              }
            });
            break;
          case 'fixedwidth': //Compatibilità con prop maxwidth deprecata
            if(ColArrObj[rowId]['maxwidth'] &&  ColArrObj[rowId]['maxwidth']==ColArrObj[rowId]['width'])
              value=ColArrObj[rowId]['width'];
            else
              value = ( typeof(ColArrObj[rowId][prop.id]) !='undefined' ? ColArrObj[rowId][prop.id] : defaultValue[prop.id]);
            break;
          case 'sanitize': //compatibilità con le colonne pre xssPrevent
            if(ColArrObj[rowId].enable_HTML && Empty(ColArrObj[rowId][prop.id])){
              ColArrObj[rowId][prop.id] = 'none';
            }
          default:
            value = ( typeof(ColArrObj[rowId][prop.id]) !='undefined' ? ColArrObj[rowId][prop.id] : defaultValue[prop.id]);
        };
        ColArrObj[rowId][prop.id] = value;
        // console.log( [prop.id, typeof(ColArrObj[rowId][prop.id]), ColArrObj[rowId][prop.id], value]);
        $(prop).data('custom-SPPropertie').value(value);
      });
    }
    var active_row_field = sptable.getSelectedRow().find( 'span.table-expr.cell');
    var field_picker = $( '#field-picker' );
    // var pos = active_row_field.position();
    // var width = $(active_row_field).outerWidth();
    // field_picker.css({
      // top: pos.top + "px",
      // left: (pos.left + width - 30) + "px"
    // }).show();
    field_picker.appendTo( active_row_field ).show();
    field_picker.attr( 'for', rowId );
    // var active_row_editable = sptable.getSelectedRow().find( 'span.table-show-extra-title.cell');
    var active_row_printable = sptable.getSelectedRow().find( 'span.table-printable.cell');
    var sort_handler = $( '#sort-handler' );
    sort_handler.appendTo( /*active_row_editable*/active_row_printable ).show();
    sort_handler.attr( 'for', rowId );
  }


  /* End Popolate Props */

  function ResetProperties() {
    $('.ps-prop').each( function ( idx, prop ) {
      $(prop).data('custom-SPPropertie').value(defaultValue[prop.id]);
    });
    $('#table_footer_title').text('No row selected');
  }

  function PopolateAndShowQueryTable() {
    queryFieldTable.reset();
    var data = [];
    [].forEach.call( FieldsList, function( item, idx ) {
      data[idx] = [DescList[idx],item,false];
    });
    if( FieldsList.length )
      queryFieldTable.option( 'data', data );
    $( '#dialog' ).show();
    $( '#cinema' ).show();
  }

  function CreateFieldDialog() {
    $('#picker-cancel').on('click', function(/*event*/) {
      $( '#dialog' ).hide();
      $( '#cinema' ).hide();
    });

    $('#picker-ok').on('click', function(/*event*/) {
      var data = queryFieldTable.getData();
      var lastIndex = 0;
      for( var ii in ColArrObj ) {
        if( parseInt(ii) >= lastIndex )
          lastIndex = parseInt(ii)+1;
      }
      data.forEach ( function( field/*, ii */) {
        if( field[2] ) {
          ColArrObj[lastIndex] = jQuery.extend({}, defaultValue);
          ColArrObj[lastIndex]['field'] = field[1];
          ColArrObj[lastIndex]['title'] = field[0];
          sptable.addNewRow( [field[0], field[1], false, false, false, false] );
          lastIndex++;
        }
      });
      $( '#dialog' ).hide();
      $( '#cinema' ).hide();
    });

  }

  function Save(/*event*/) {
    /* sort array like sptable */
    var order = sptable.getRowOrder();
    var returnArray = [];
    for( var ii=0; ii < order.length; ii++ ){
      returnArray[ii] = ColArrObj[order[ii]];
      returnArray[ii]['type']= (!Empty(FieldsTypes[returnArray[ii]['field']])?FieldsTypes[returnArray[ii]['field']]:'C');
      if(returnArray[ii]['maxwidth']) delete returnArray[ii]['maxwidth'];
      if(returnArray[ii]['url']) {
        returnArray[ii]['link']=returnArray[ii]['url'];
        delete returnArray[ii]['url'];
      }
    }
    returnObj.colProperties = JSON.stringify( returnArray );
    opener.Properties();
    opener.writeHTML();
    window.close();
  }

  /* Functions for expression builder */

  win.GetFunctionsForExpBuilder= function() {
    return [{
    		name : "functionsName",
    		desc : "Available Options",
    		prefix : "",
    		postfix : "",
    		functions : [
          ["%", "", "Separator for field value Es.:%myVar%, %field%"],
          ["var:", "", "Es.var:myVar"],
          ["html:", "", "Es.:html:"+ToHTML("<b>")+"%myField%"+ToHTML("</b>")],
          ["function:", "", "Es.:function:myFunc(%myField%,..)"],
          ["eval:", "", "Es.:eval:myExpr"],
          ["checkbox:", "", "Es.:checkbox:myField"],
          ["combobox:", "", "Es.:combobox:columnField:myDatobj:value_fld:label_fld:bHasEmptyValue<br>" +
           "Es.:combobox:columnField:[[value1,label1],[value2,label2],..]:bHasEmptyValue"],
          ["image:", "", "Es.:image:myUrl:myTooltip"],
          ["bar:", "", "Es.:bar:Value,Value min,Value max,bg. color,color,css class"],
          ["template:", "", "Es.:template:"+ToHTML("<div>")+"{{ \"%this.myField%\" }} - {{\"%myVariable%\"}}"+ToHTML("</div>")]
        ]
    	}
    ]
  }
  win.getFieldsOfTables= function() {
    var fields = [];
    FieldsList.forEach ( function (fld , idx ) {
      fields[idx] = [fld,"",DescList[idx]+" <br>type: "+fieldsTypes[idx]]
    });
    return [{
    		name : "fields",
    		desc : "data object",
    		prefix : "",
    		postfix : "",
    		fields : fields
    	}
    ]
  }
  win.GetVariablesForExpBuilder= function () {
    return []
    // {
    		// name : "variablesName",
    		// desc : "Description Functions",
    		// prefix : "",
    		// postfix : "",
    		// functions : [["nome", "parametri", "descrizione lunga"], ["nome2", "parametri", "descrizione lunga"]]
    	// }
    // ]
  }
  win.getParametersOfQueries=function () {

  }
  win.GetExpressionFromId= function( field_id ) {
    switch ( field_id ) {
      case 'field':
        return sptable.getRowData(sptable.getSelectedRowIdx())['field'];
      break;
      case 'onclick':
        return $( '#onclick.ps-prop' ).SPPropertie().data("custom-SPPropertie").value();
      break;
      case 'disable_fields_conditions':
        return $( '#disable_fields_conditions.ps-prop' ).SPPropertie().data("custom-SPPropertie").value();
      break;
    }

  }

  win.SetFieldExpression=function( field_id, value ) {
    switch ( field_id ) {
      case 'field':
        sptable.updateRow(sptable.getSelectedRowIdx(), 'field', value);
      break;
      case 'onclick':
        $( '#onclick.ps-prop' ).SPPropertie().data("custom-SPPropertie").value(value);
      break;
      case 'disable_fields_conditions':
        $( '#disable_fields_conditions.ps-prop' ).SPPropertie().data("custom-SPPropertie").value(value);
      break;
    }
  }

  // win.TemplateExpression = function (value) {
  //   if (value) {
  //     $('#template.ps-prop').SPPropertie().data("custom-SPPropertie").value(value);
  //   } else {
  //     return $('#template.ps-prop').SPPropertie().data("custom-SPPropertie").value();
  //   }
  // }

  win.SetPropExpression=function(/* rowid, value */) {

  }

  /* End Functions for expression builder */

  /* OnLoad */

  $(win).on('load', function(){

    /* Tabs management */
    var pages = win.document.querySelectorAll('.page');
    var tabs = win.document.querySelectorAll('.prop_tab');
    [].forEach.call( tabs, function(item, index/*, arr*/){
      $(item).on('click', function(){
        $('.page.selected').removeClass('selected');
        $('.prop_tab.selected').removeClass('selected');
        $(item).addClass('selected');
        $(pages[index]).addClass('selected');
      })
    });
    /* End Tabs management */

    /* Apply Props */

    $('.ps-prop').each( function ( idx, it ) {
      /* Create Properties */
      $(it).SPPropertie().data("custom-SPPropertie");
      /* Management value change:
       * change ColArrObj value
       * if change table value, update table
      */
      $(it).on('valueChange', function ( event, newValue ) {
        var rowId = sptable.getSelectedRowIdx();
        if( rowId > -1 ) {
          ColArrObj[rowId][this.id] = newValue;
          /* Refresh Table  attention to circular event call */
          // if( /(field|title|isEditable)/ig.test( this.id ) ){
            // sptable.updateRow(sptable.getSelectedRowIdx(), this.id, newValue, true);
          // }
        }
      }.bind(it));
    });

    /* End Apply Props */

    /* Create Table */

    sptable = $( "#table" ).SPTableEditable( tableOpt ).data( "custom-SPTableEditable" );
    queryFieldTable = $('#table-field-list').SPTableEditable( queryFieldTableOpt ).data( "custom-SPTableEditable" );

    /* End Create Table */

    /* Set Button Functions */
    $('#select-field').on('click', PopolateAndShowQueryTable);

    $('#add').on('click', function() {
      var lastIndex = 0;
      for( var ii in ColArrObj ) {
        if( parseInt(ii) >= lastIndex )
          lastIndex = parseInt(ii)+1;
      }
      ColArrObj[lastIndex] = jQuery.extend({}, defaultValue) ;
      sptable.addNewRow(['', '', false, false, false, false]);
    });

    $('#remove').on('click', function() {
      /* Preserve field-picker e sort-handler */
      $( '#field-picker' ).hide()
        .appendTo( $('body') );
      $( '#sort-handler' ).hide()
        .appendTo( $('body') );
      var removedRowId = sptable.getSelectedRowIdx();
      sptable.removeSelectedRow();
      /* Remove from json obj */
      ColArrObj[removedRowId] = null;
      if( sptable.getSelectedRowIdx() < 0 ) {
        ResetProperties();
      }
    });

    $('#ok').on('click', Save );

    $('#cancel').on('click', function(/*event*/) {
      window.close();
    });

    /* End Set Button Function*/

    /* Update value on table change */
    $( "#table" ).on( 'rowValueChange', function( event, rowid, alias, value ) {
      if( !ColArrObj[rowid] ) {
        ColArrObj[rowid] = jQuery.extend({}, defaultValue) ; //clone defaultValue
        /* if row is new set default value */
        ResetProperties();
      }
      ColArrObj[rowid][alias] = value;
      if( /isEditable/.test( alias ) && value === true && !editableMessageSend ){
        $( '#info' ).show();
        editableMessageSend = true;
      }
      /* update properies */
      if( $('#'+alias+'.ps-prop').length ) /* Portebbe essere una prop solo della tabella */
        $('#'+alias+'.ps-prop').data('custom-SPPropertie').value(value);
    });

    $( "body" ).keydown( function( event ) {
      if ( event.ctrlKey && event.keyCode==83 ) { //CTRL-S
        event.stopPropagation();
        event.preventDefault();
        Save();
      }
    });

    window.focus();
    PopolateColumns();
    // navElement("columns_list") //
    if( ColArrObj[0] ){
      sptable.selectRow(0);
      // PopolateProps();
    }

    /* Create Dialog Picker */

    CreateFieldDialog();

    $( '#field-picker' ).on( 'click', function() {
      window.layerOpenForeground("../portalstudio/expression_builder.jsp?ExpressionID=field&callerFunction=SetFieldExpression","field_picker",'',500,600,true,1);
      //openSPModalLayer("../portalstudio/expression_builder.jsp?ExpressionID=field&callerFunction=SetFieldExpression", 0, 0, 500, 600, true, 1, false,false,win);
    });




    /* Props function */
    win.buildExpr= function( button, input, prop ) {
      openSPModalLayer("../portalstudio/expression_builder.jsp?ExpressionID="+prop.id+"&callerFunction=SetFieldExpression", 0, 0, 500, 600, true, 1, false,false);
    }
    // win.setTemplate = function (button, input, prop) {
    //   win.ActionCodeLayer = openSPModalLayer("editTemplate.htm?propID=" + prop.id + "&callerFunction=TemplateExpression", 0, 0, 500, 600, true, 1, false, false, win);
    // }
    /* End Props function*/


    /* End Create Dialog Picker */

    /* Management info dialog*/

    $( '#close-info' ).on( 'click', function() { $( '#info' ).hide(); } );

    /* End Management info dialog*/

  });

  /* End OnLoad*/


}) ( window, jQuery )

var SPTheme= parent.SPTheme;

