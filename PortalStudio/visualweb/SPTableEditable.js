jQuery.noConflict();
(function ( win, $ ) {
  'use strict';
  $.widget( "custom.SPTableEditable", {
    options: {
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
        }
      ],
      theadClass: 'table-th',
      tbodyClass: 'table-tbody',
      trClass: 'table-tr',
      rowSelectedClass: 'row-selected',
      sortable: false,
      sortHandle: null,
      onSelectRow: null
    },
    _create: function() {
      this.element.addClass( 'table' );
      this.thead = this._createTitle()
      this.tbody = this._createTBody();
      // if( this.options.data.length ){
        // if( !(this.options.struct.length == this.options.data[0].length) )
          // alert( "data and struct are incompatible" );
        // else
          // this._createRows();
      // }
      this.rowSelected = null;
      this.rowSelectedIdx = -1;
      this.lastRowIdx = -1;
    },
    // _refresh: function() {},
    // _destroy: function() {},
    // _setOptions: function() {
      // _super and _superApply handle keeping the right this-context
      // this._superApply( arguments );
      // this._refresh();
    // },

    // _setOption is called for each individual option that is changing
    _setOption: function( key, value ) {
      if ( /data/.test(key) && value.length ) {
        if( value[0].length != this.options.struct.length ) {
          alert( "data and struct are incompatible" );
        } else {
          this._super( key, value );
          this._createRows();
        }
      } else {
        this._super( key, value );
      }
    },

    _createTitle: function(  ) {
      var thead = $( '<div>' , {
        'class': this.options.theadClass +" thead"
      }).appendTo(this.element);
      var title_row = $( '<div>', {
        'class': "row"
      }).appendTo( thead );
      [].forEach.call( this.options.struct, function( item/*, idx */) {
        $('<span>' , {
          'class': item.cssClass + " cell",
          'html': item.title
        }).appendTo(title_row)
      }.bind( this ));
      return thead;
    },

    _createTBody: function() {
      var tbody = $( '<div>', {
        'class': this.options.tbodyClass + ' tbody'
      }).css( 'height', this.element.height() - this.thead.height() )
        .appendTo(this.element)
      if( this.options.sortable ) {
        tbody.sortable({ 'axis': 'y', 'handle': this.options.sortHandle });
      }
      return tbody;
    },

    _createRows: function() {
      [].forEach.call( this.options.data, this._addRow.bind( this ));
    },

    _addRow: function( data, idx ) {
      if( typeof(idx) != 'number' ){
        idx = this.lastRowIdx +1;
      }
      var row = $( '<div>', {
        'class': this.options.trClass + ' row',
        'rowId': idx
      })//.on('click', this._selectRow.bind(this) )
        .appendTo(this.tbody);
      //  If its last argument is true the event handler is set for the capturing phase, if it is false the event handler is set for the bubbling phase.
      // row[0].addEventListener( 'click', this._selectRow.bind(this), true);
      // row[0].addEventListener( 'click', function(_this){
        // return function(event){
          // _this._selectRow(event);
        // }
      // }(this), true)

      var _this = this;
      [].forEach.call( this.options.struct, function( item_struct, iidx ) {
        /* Manage input type*/
        var html = "";
        switch( item_struct.input_type ){
          case 'text':
          case 'number':
            html= $( '<input>', {
              type: item_struct.input_type,
              value: data[iidx],
              alias: item_struct.alias
            }).on( 'blur', _this._valueChange.bind(_this));
          break;
          case 'checkbox':
            var opt = {
              type: "checkbox",
              alias: item_struct.alias
            }
            if( data[iidx] && /(checked|true)/ig.test( data[iidx].toString() ) )
              opt.checked = "checked";
            html= $( '<input>' , opt ).on( 'click', _this._valueChange.bind(_this));
          break;
          case 'select':
            html = $( '<select >', { alias: item_struct.alias } ).on( 'change', _this._valueChange.bind(_this));
            if( data[iidx].length ){
              [].forEach.call( data[iidx], function( o ){
                var opt = { value: o.value, text: o.name};
                if( o.selected )
                  opt.selected = "selected";
                $( '<option>').appendTo(html);
              });
            }
          break;
        }
        html.appendTo( $( '<span>', {
          'class': item_struct.cssClass + " cell",
          }).appendTo(row)
        );
      }.bind( this ));
      this._disableRow( row );
      this.lastRowIdx = idx;
      return row;
    },

    // _clickOnRow: function( event ) {
      // this._selectRow($( event.currentTarget ));
    // },

    _selectRow: function( row , evt) {
      if( this.rowSelected ){
        this.rowSelected.removeClass( this.options.rowSelectedClass );
        this._disableRow( this.rowSelected );
      }
      this.rowSelected = row;
      this.rowSelectedIdx = parseInt(row[0].getAttribute( 'rowId' ));
      this.rowSelected.addClass( this.options.rowSelectedClass );
      this._enableRow( this.rowSelected );
      if (evt) {
        document.elementFromPoint(evt.pageX,evt.pageY).click();
      }
      if( this.options.onSelectRow )
        this.options.onSelectRow.call( this, this.rowSelectedIdx );
    },

    _enableRow: function( row ) {
      if( row.find( 'input' ).length ){
        row.find( 'input' ).removeAttr( 'disabled' );
        row.find( '.disabledClickFix' ).remove();
      }
    },

    _disableRow: function( row ) {
      if( row.find( 'input:not([type=checkbox])' ).length )
        row.find( 'input:not([type=checkbox])' ).attr( 'disabled', 'disabled' );
      /* fix bug in FireFox: disabled input prevent event firing */
      if( !row.find( 'div.disabledClickFix').length ){
        var divFix = $( '<div>', {
          'class': 'disabledClickFix'
        }) //.on('click', this._selectRow.bind( this, row ) )
          .appendTo(row);
        // can not use bind with $el like parameter because bind use apply and transform [el] to el
        divFix[0].addEventListener( 'click', function(_this, row) {
          return function(evt) {
            _this._selectRow(row, evt);
          }
        }(this,row), true)
      }
    },

    _valueChange: function (event) {
      /* if row added and focus fired the selected idx can be wrong */
      var value = event.target.value
      if( event.target.type == "checkbox" )
        value = event.target.checked ;
      if( event.target ){
        var parentRow = $(event.target).parents('.row[rowid]');
        if( parentRow.length ){
          var rowId = parseInt(parentRow.attr('rowId'))
          // console.log([rowId, this.getSelectedRowIdx()])
          if( typeof(rowId) == 'number' && rowId == this.getSelectedRowIdx()){
            this.element.trigger( 'rowValueChange', [ this.getSelectedRowIdx(), $(event.target).attr('alias'), value ])
          }
        }
      }
    },

    /* Public methods */

    addNewRow: function( row ) {
      // console.log([row])
      if( !row || row.length != this.options.struct.length ){
        row = [];
        [].forEach.call( this.options.struct, function(it, idx) {
          row[idx] = "";
        })
      }
      var addedRow= this._addRow( row );
      this._selectRow( addedRow );
      // addedRow.click();

      if( this.rowSelected.find( 'input' ).length ){
        this.rowSelected.find( 'input' )[0].focus();
      }
      addedRow[0].scrollIntoView( true ); // if true, the scrolled element is aligned with the top of the scroll area
    },

    removeSelectedRow: function( /*row*/ ) {
      if( this.rowSelected ){
        this.rowSelected.remove();
        /* after remove select next row */
        if( this.selectRow(this.rowSelectedIdx+1) ){}
        else if( this.selectRow(this.rowSelectedIdx-1) ){}
        else {this.rowSelectedIdx = -1;}
      }
    },

    selectRow: function (rowidx) {
      var row = this.element.find('.' + this.options.trClass + '.row[rowid='+rowidx+']' );
      if( row.length ) {
        this._selectRow( row );
        return true;
      } else {
        return false;
      }
        // row.click();
    },

    getSelectedRow: function () {
      return this.rowSelected;
    },

    getSelectedRowIdx: function () {
      return this.rowSelectedIdx;
    },

    getData: function() {
      var data = [];
      [].forEach.call( this.element.find('.' + this.options.trClass + '.row' ), function( row, idx ) {
        data[idx] = [];
        [].forEach.call( this.options.struct , function ( struct_cell, iidx ) {
          var d = null;
          switch( struct_cell.input_type ) {
            case 'text':
            case 'number':
              d = $(row).find( '.' + struct_cell.cssClass +' input[ type='+struct_cell.input_type+']' )[0].value;
            break;
            case 'checkbox':
              d = $(row).find( '.' + struct_cell.cssClass +' input[ type='+struct_cell.input_type+']' )[0].checked;
            break;
            case 'select':
              d = $(row).find( '.' + struct_cell.cssClass +' select' )[0].selected;
            break;
          }
          data[idx][iidx] = d;
        }.bind(this));
      }.bind(this));
      return data;
    },

    getRowData: function( rowidx ) {
      var data = {},
        row = this.element.find('.' + this.options.trClass + '.row[rowid='+rowidx+']' );
      if( row.length ){
        row = row[0];
        [].forEach.call( this.options.struct , function ( struct_cell/*, iidx */) {
          var d = null;
          switch( struct_cell.input_type ) {
            case 'text':
            case 'number':
              d = $(row).find( '.' + struct_cell.cssClass +' input[ type='+struct_cell.input_type+']' )[0].value;
            break;
            case 'checkbox':
              d = $(row).find( '.' + struct_cell.cssClass +' input[ type='+struct_cell.input_type+']' )[0].checked;
            break;
            case 'select':
              d = $(row).find( '.' + struct_cell.cssClass +' select' )[0].selected;
            break;
          }
          data[struct_cell.alias] = d;
        }.bind(this));
      } else {
        alert( 'rowid error' );
      }
      return data;
    },

    updateRow: function ( rowidx, alias, value, dontFireEvent ) {
      var row = this.element.find( '.' + this.options.trClass + '.row[rowid='+rowidx+']' )[0];
      if( row ){
        [].forEach.call( this.options.struct , function ( struct_cell/*, iidx */) {
          if( struct_cell.alias == alias ){
            switch( struct_cell.input_type ) {
              case 'text':
              case 'number':
                $(row).find( '.' + struct_cell.cssClass +' input[ type='+struct_cell.input_type+']' )[0].value = value;
              break;
              case 'checkbox':
                if( /(checked|true)/ig.test( value ) )
                  $(row).find( '.' + struct_cell.cssClass +' input[ type='+struct_cell.input_type+']' )[0].attr( 'checked', 'checked');
                else
                  $(row).find( '.' + struct_cell.cssClass +' input[ type='+struct_cell.input_type+']' )[0].removeAttr( 'checked' );
              break;
              case 'select':
                $(row).find( '.' + struct_cell.cssClass +' select' )[0].value =value ;
              break;
            }
          }
        })
      }
      if( !dontFireEvent )
        this.element.trigger( 'rowValueChange', [ rowidx , alias, value ]);
    },

    reset: function () {
      this.element.find('.' + this.options.trClass + '.row' ).remove();
      this.rowSelected = null;
      this.rowSelectedIdx = -1;
      this.lastRowIdx = -1;
    },

    getRowOrder: function () {
      var a = [];
      [].forEach.call( this.element.find('.' + this.options.trClass + '.row' ), function( row, idx ) {
        a[idx] = $(row).attr( 'rowId' );
      });
      return a;
    }

  });
}) ( window, jQuery )
