if (typeof(ZtAssistant) == "undefined") {
    function ZtAssistant(opts, htmlContainer, PSCtrl) {
        this.opts = opts;
        this.ztVPivotData;
        this.htmlContainer = htmlContainer;
        this.PSCtrl = PSCtrl; //PortalStudio Control

        this.helpsList = [];
        this.helpsPos = -1;
        this.helpElement = null;
        this.helpPSTooltip = null;
        this.helpActive = false;
        this._inId =  LibJavascript.AlfaKeyGen(5);
        this.scroll  = {
            left: 0,
            top: 0
        };
        window[this._inId] = this;
        
        this.EnableAssistant = function() {
            if (this.helpActive == false) {
                this.helpActive = true;
                this.ExecuteAssistant();
            }
            else {
                this.RemoveAssistant();
                this.helpActive = false;
            }
        }

        this.IsActive = function() {
            return this.helpActive;
        }

        this._isHidden = function(el) {
            return (el.offsetParent === null) 
        }

        this.IsEmpty = function() {
            return this.helpsList.length == 0;
        }

        this.Next = function() {
            if (!this.helpActive)
                return;
            if(this.helpsList.length > 0 && (this.helpsPos+1) < this.helpsList.length ) {
                this.RemoveAssistant();
                var lctrl = this.helpsList[this.helpsPos];
                this.helpsPos++;
                var ctrl = this.helpsList[this.helpsPos];
                if( lctrl && ctrl && (lctrl.page != ctrl.page) ) {
                    if ( this.opts && this.opts.GoToPage ) {
                        this.opts.GoToPage(ctrl.page+1);
                        return;
                    }
                }
                if(!lctrl && ctrl) {
                    if ( this.opts && this.opts.GoToPage ) {
                        this.opts.GoToPage(ctrl.page+1);
                        return;
                    }
                }
                var hele = document.getElementById(ctrl.htmlId);
                if ( hele == null || this._isHidden(hele) ) {
                    this.Next();
                    return;
                }
                this.Execute(ctrl);
            }
            else {
                this.helpsPos = -1;
                this.RemoveAssistant();
            }
        }
        
        this.Previous = function() {
            if (!this.helpActive)
                return;
            if(this.helpsList.length > 0 && (this.helpsPos-1) < this.helpsList.length && (this.helpsPos-1 >=0 )) {
                this.RemoveAssistant();
                var lctrl = this.helpsList[this.helpsPos];
                this.helpsPos--;
                var ctrl = this.helpsList[this.helpsPos];
                if( lctrl && ctrl && (lctrl.page != ctrl.page) ) {
                    if ( this.opts && this.opts.GoToPage ) {
                        this.opts.GoToPage(ctrl.page+1);
                        return;
                    }
                }
                if(!lctrl && ctrl) {
                    if ( this.opts && this.opts.GoToPage ) {
                        this.opts.GoToPage(ctrl.page+1);
                        return;
                    }
                }
                var hele = document.getElementById(ctrl.htmlId);
                if ( hele == null || this._isHidden(hele) ) {
                    this.Previous();
                    return;
                }
                this.Execute(ctrl);
              }
              else {
                this.helpsPos = -1;
                this.RemoveAssistant();
              }
        }

        this.SetScroll = function( top, left )  {
            this.scroll.top = top;
            this.scroll.left = left;
        }  

        this.Scroll = function( top, left )  {
            this.SetScroll(top, left)
            this.ContinueAssistant();
        }

        this.Execute = function( _ctrlE )  {
            if (!this.helpActive)
                return;
            this.helpElement = document.getElementById(_ctrlE.htmlId);
            var c = this.helpElement;
            var o = this.helpsList[this.helpsPos];
            if( o && o.cssClass != undefined ) {
                LibJavascript.CssClassNameUtils.addClass( this.helpElement, o.cssClass );
            }
            else {
                LibJavascript.CssClassNameUtils.addClass( this.helpElement, 'pstooltiphelp' );
            }
            if(c) {
              var html = '<div class="wizard_layer_custom">'
			  +'<div class="wizardform_custom">'
			  +'<div class="lab_wiz_fase_big Lblfase_Copy_ctrl lab_wiz_fase_evid_custom">[num]</div>'
			  +'<div class="lab_wiz_titolo_custom">[title]</div>'
			  +'<div onclick="[closeclick]" class="lab_wiz_close_custom"></div>'
			  +'<div class="lab_wiz_desc_custom">[note]</div>'
			  +'<div class="lab_wiz_toolbar_custom">'
			  +'<div onclick="[previousclick]" class="wiz_prec_custom" style="visibility: [previous];"></div>'
			  +'<div class="lab_wiz_stepper_custom">'
			  +'<div class="lab_wiz_fase_custom">[num]</div>'
			  +'<div class="lab_wiz_divider_custom">/</div>'
			  +'<div class="lab_wiz_fasi_custom">[tot]</div>'
			  +'</div>'
			  +'<div onclick="[nextclick]" class="wiz_succ_custom" style="visibility: [next];"></div>';
              if( o && o.jsActions != undefined ) {
                var i;  
                for(i=0; i<o.jsActions.length; i++) {
                    html +='<div title="' + o.jsActions[i].title + '" onclick="' + o.jsActions[i].func + '" class="lab_wiz_func_custom ' + o.jsActions[i].class + '" style="visibility: visible;"></div>'
                }
              }
              html += '</div>'
              html += '</div>'
              html += '</div>'
              var prevfunc ='window.'+ this._inId + '.Previous()';
              var nextfunc ='window.'+ this._inId + '.Next()';
              var closefunc ='window.'+ this._inId + '.EnableAssistant()';
              html = Strtran(html, '[note]', Trim(ToHTag( _ctrlE.note, 'xssPrevent')))
              html = Strtran(html, '[num]', (this.helpsPos+1))
              html = Strtran(html, '[tot]', (this.helpsList.length))
              html = Strtran(html, '[title]', Trim(ToHTag(_ctrlE.title, 'xssPrevent')))
              html = Strtran(html, '[nextclick]', nextfunc)
              html = Strtran(html, '[previousclick]', prevfunc)
              html = Strtran(html, '[closeclick]', closefunc)
              if( this.helpsPos > 0 )
                html = Strtran(html, '[previous]', 'visible') // Maurizio
              else
                html = Strtran(html, '[previous]', 'hidden') // Maurizio
              if( this.helpsPos < this.helpsList.length-1 )
                html = Strtran(html, '[next]', 'visible')  // Maurizio
              else
                html = Strtran(html, '[next]', 'hidden') // Maurizio
              this.helpPSTooltip = new PSTooltip(c, {'text' : html, 'html': true, 'arrow_size': 8}, false);
              this.helpPSTooltip.setScroll(this.scroll.top, this.scroll.left)
              c.addEventListener('psFocusHelp', function () {}, false);
              c.addEventListener('psLostFocusHelp', function () {}, false);
              c.focus();
              var event = new Event('psFocusHelp');
              c.dispatchEvent(event);
            }
            else {
                LibJavascript.CssClassNameUtils.addClass( this.helpElement, 'pstooltiphelp' );
            }
        }

        this.ExecuteAssistant = function(){
            this.RemoveAssistant();
            this.helpsPos = -1;
            this.helpElement = null;
            this.helpPSTooltip = null;
            if(this.helpsList.length > 0) {
                this.Next();
            }
        }

        this.ContinueAssistant = function(id, page){
            if (!this.helpActive)
                return;
            this.RemoveAssistant();
            if( !id && this.helpsPos < 0 ){
                return this.Next();
            } 
            if( id ){
                var i;
                this.helpsPos = -1;
                for ( i=0; i<this.helpsList.length; i++ ){
                    if ( this.helpsList[i].htmlId == id ) {
                        this.helpsPos = i;
                        i = this.helpsList.length;
                    }   
                }   
            }
            if(this.helpsList.length > 0 && (this.helpsPos) < this.helpsList.length && (this.helpsPos>=0 )) {
                var ctrl = this.helpsList[this.helpsPos];
                if( page != undefined && ctrl.page != page) {
                    for ( i=0; i<this.helpsList.length; i++ ){
                        if ( this.helpsList[i].page == page ) {
                            this.helpsPos = i;
                            this.Execute(this.helpsList[i]);
                            return;
                        }  
                    }
                }
                else {
                    this.Execute(ctrl);
                }
            }
        }  

        this.Register = function(htmlId, title, note, page, cssClass, jsActions){
            var o = {};
            o.htmlId = htmlId;
            o.title = title;
            o.note = note;
            o.page = page;
            o.cssClass = cssClass;
            //o.x = x;
            //o.y = y;
            o.jsActions = jsActions;
            if ( o.title == undefined )
                o.title = '';
            if ( o.note == undefined )
                o.note = '';
            this.helpsList.push(o);
            this.helpsList.sort ( function (a, b){
                var pa = parseInt(a.page);
                var pb = parseInt(b.page);
                if( pa == pb ) {
                    if( a.y != undefined && b.y != undefined ) {
                        var ya = parseFloat(a.y);
                        var yb = parseFloat(b.y);
                        if( ya == yb ) {
                            if( a.x != undefined && b.x != undefined ) {
                                var xa = parseFloat(a.x);
                                var xb = parseFloat(b.x);
                                return xa - xb;
                            }
                            else
                                return 0;
                        }
                        else
                            return ya - yb;
                    }
                    else
                        return 0;
                }
                else
                    return pa-pb;
              });
              this.UpdateAssistant();
        }

        this.Update = function(htmlId, title, note, cssClass) {
            var i;
            for ( i=0; i<this.helpsList.length; i++ ){
                if ( this.helpsList[i].htmlId == htmlId ) {
                    var o = this.helpsList[i];
                    if ( title != undefined )
                        o.title = title;
                    if ( note != undefined )
                        o.note = note;
                    if ( cssClass != undefined )
                        o.cssClass = cssClass;
                    this.UpdateAssistant();
                    i = this.helpsList.length;
                }   
            } 
        }

        this.Remove = function(htmlId) {
            var i;
            for ( i=0; i<this.helpsList.length; i++ ){
                if ( this.helpsList[i].htmlId == htmlId ) {
                    var li = this.helpsList.length;
                    this.helpsList.splice(i, 1);
                    i = li;
                    this.helpsPos = -1;
                    this.UpdateAssistant();
                }   
            } 
        }

        this.RemoveAssistant = function () {
            if (this.helpElement != null ) {
                LibJavascript.CssClassNameUtils.removeClass( this.helpElement, 'pstooltiphelp' );
                var c = this.helpElement;
                var o = this.helpsList[this.helpsPos];
                if( o && o.cssClass != undefined && !Empty(o.cssClass)) {
                    LibJavascript.CssClassNameUtils.removeClass( this.helpElement, o.cssClass );
                }
                if(c) {
                    var event = new Event('psLostFocusHelp');
                    c.dispatchEvent(event);
                    if(this.helpPSTooltip != null) {
                    delete this.helpPSTooltip;
                    this.helpPSTooltip = null;
                    }
                    c.removeEventListener('psFocusHelp', function () {}, false);  
                    c.removeEventListener('psLostFocusHelp', function () {}, false);
                }
            }
        }

        this.UpdateAssistant = function () {
            if (!this.helpActive)
                return;
            if(this.helpsList.length > 0 && (this.helpsPos) < this.helpsList.length && (this.helpsPos>=0 )) {
                var ctrl = this.helpsList[this.helpsPos];
                this.Execute(ctrl);
            }
            else {
                this.RemoveAssistant();
            }
        }

    }
}