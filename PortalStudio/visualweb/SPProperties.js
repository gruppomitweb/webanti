jQuery.noConflict();
(function(win, $){
  $.widget( "custom.SPPropertie", {
    options: {
      //solo per valori di default
    },
    _create: function(){
      this.options = {
        'id': this.element.prop('id'),
        'label': $(this.element).attr('ps-label'),
        'type': $(this.element).attr('ps-type'),
        'buttons': $(this.element).attr('ps-button') ? JSON.parse( $(this.element).attr('ps-button')) : null,
        'value': $(this.element).attr('ps-value') ? JSON.parse( $(this.element).attr('ps-value')) : null,
        'help': $(this.element).attr('ps-help') ? $(this.element).attr('ps-help') : null,
        'tooltip': $(this.element).attr('ps-tooltip') ? $(this.element).attr('ps-tooltip') : null
      }
      var table = $( '<table>' ),
        tr = $( '<tr>' );
      /* Creazione label */
      $( '<label>', {
          'class': "properties_label",
          'html': '<a href="javascript:'+( this.options.help ? this.options.help /* +'(\''+this.options.id+'\')' */ : 'void(0)')+';" >'+this.options.label+' <i '+(this.options.tooltip?' class="pstooltip-info"':'')+'></i></a>'
      }).appendTo($( '<td '+(this.options.buttons && this.options.buttons.length ? 'colspan="'+(this.options.buttons.length+1)+'"' : '' )+'>' ).appendTo($( '<tr>' ).appendTo(table)));
      /* Creazione input */
      this.Input;
      this.Buttons=[];

      switch( this.options.type ){
        case 'text':
        case 'number':
          this.Input = $( '<input>', {
            'class': "property_item",
            'id': this.options.id+"_input",
            type: this.options.type
          }).on('blur', this._valueChange.bind(this))
        break;
        case 'checkbox':
          this.Input =$( '<input>', {
            'class': "property_item",
            type: this.options.type
          }).on( 'change', this._valueChange.bind(this))
        break;
        case 'select':
          this.Input = $( '<select>', {
            'class': "property_item properties_select"
          }).on( 'change', this._valueChange.bind(this))
          if( this.options.value ){
            [].forEach.call( this.options.value, function( o ){
              $( '<option>', {
                value: o.value,
                text: o.name
              }).appendTo(this.Input);
            }.bind(this));
          }
        break;
        case 'textarea':
          this.Input = $( '<textarea>', {
            'class': "property_item",
          }).on('blur', this._valueChange.bind(this))
        break;
      }
      this.Input.appendTo( $('<td>').appendTo(tr));

      // debugger
      // var propLabel = document.getElementById("bg_color");



      /* Creazione eventuali bottoni */
      if( this.options.buttons && this.options.buttons.length){
        [].forEach.call( this.options.buttons, function ( it, idx ){
          var button = $( '<div>', {
            'class': "input_inline_btn "+ it.type
          }),
            _this = this;
          if( it.action )
            button.on( 'click', function( /*event*/ ) {
              if( !$(this).attr('disabled') )
                win[it.action].call(this, this, $($(this).parents('tr')[0]).find('.property_item')[0], _this.element[0])
            });
          button.appendTo( $('<td>').appendTo(tr));
          this.Buttons[idx] =  button;
        }.bind(this));
      }
      tr.appendTo(table)
      table.appendTo(this.element)
      new PSTooltip(this.element[0].querySelector('.properties_label i'), {'text' : this.options.tooltip, 'html': false});
    },

    _setOption: function ( key, value ){
      if ( /value/.test(key) ) {
        return alert('use value(value)');
      }
      this._super( key, value );
    },

    value: function( value ) {
      if( typeof(value) == 'undefined' ){
        value = this.Input.val(); 
        if (typeof value == 'string') {
          value = Strtran(value, '&#13;', '\r');
          value = Strtran(value, '&#10;', '\n');
        }
        return value;
      }else{
        if( this.options.type == 'checkbox' ){
          this.Input.prop('checked',value);
        }
        if (typeof value == 'string') {
          value = Strtran(value, '\r', '&#13;');
          value = Strtran(value, '\n', '&#10;');
        }
        this.Input.val(value);
        this.element.attr('value',value);
        // this.element.trigger( 'valueChange', [value] );
      }
    },

    _valueChange: function( /*event*/ ){
      var value = this.value();
      this.element.attr('value',value);
      if( this.options.type == 'checkbox' ){
        value = this.Input.prop('checked');
      }
      this.element.trigger( 'valueChange', [value] );
    },

    getButton: function( idx ){
      return this.Buttons[idx];
    }
  });




}) ( window, jQuery );
