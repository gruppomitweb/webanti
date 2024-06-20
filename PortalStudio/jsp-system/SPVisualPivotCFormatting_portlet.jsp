<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var props = ['index', 'condType', 'vCompareType', 'vCompare1', 'vCompare2', 'vFontName', 'vFontStyle', 'vFontSize', 'vFontColor', 'vBckColor',\n  \t\t\t\t\t 'sCompare1', 'sCompare2', 'sCompare3', 'sBckColor1', 'sBckColor2', 'sBckColor3'\n            ],\n    startidx = 0;\n\nfunction getData(){\n  var obj = {};\n  for (var i = startidx; i \u003c props.length; i++) {\n    if (this[props[i]])\n  \t\tobj[props[i]] = this[props[i]].Value();\n  }\n  return obj;\n}\n\nfunction btnOk_Click(){\n  if (GetOpener() && GetOpener().SetCFormatting)\n  \tGetOpener().SetCFormatting(this.getData());\n  else if (GetOpener() && GetOpener()[this.parentID.Value()] && GetOpener()[this.parentID.Value()].SetCFormatting)\n  \tGetOpener()[this.parentID.Value()].SetCFormatting(this.getData());\n  WindowClose();\n}\n\nfunction btnClose_Click(){\n  WindowClose();\n}\n\nfunction setJsColor(input, input_btn) {\n  jsColorPicker(\"#\"+input.id, input_btn.id, {\n      size: 1,\n      expires: 365, \n      noResize: true,\n      init: function(elm, val) {\n        elm.style.backgroundColor = val;\n      }.bind(this, input_btn, input.value)\n    });\n  input_btn.style.backgroundColor = input.value;\n}\n\nfunction this_Loaded(){\n\tthis.BoxMeasC.Collapse();\n  this.BoxMeasS.Collapse();\n  this.condType_onChange();\n  \u002f*if( Empty(this.vFontColor.Value() )) this.vFontColor.Value('#000000')\n  if( Empty(this.vBckColor.Value() )) this.vBckColor.Value('#ffffff')\n  if( Empty(this.sBckColor1.Value() )) this.sBckColor1.Value('#ff0000')\n  if( Empty(this.sBckColor2.Value() )) this.sBckColor2.Value('#ffff00')\n  if( Empty(this.sBckColor3.Value() )) this.sBckColor3.Value('#77c277')*\u002f\n  setJsColor(this.vFontColor.Ctrl_input,this.vFontColor_btn.Ctrl)\n  setJsColor(this.vBckColor.Ctrl_input,this.vBckColor_btn.Ctrl)\n  setJsColor(this.sBckColor1.Ctrl_input,this.sBckColor1_btn.Ctrl)\n  setJsColor(this.sBckColor2.Ctrl_input,this.sBckColor2_btn.Ctrl)\n  setJsColor(this.sBckColor3.Ctrl_input,this.sBckColor3_btn.Ctrl)\n}\n\nfunction vCompareType_onChange(){\n  var v = this.vCompareType.Value();\n  if( v == 'between' || v == 'notbetween') {\n    this.lblValue2.Show();\n    this.vCompare2.Show()\n  }\n  else {\n    this.lblValue2.Hide();\n    this.vCompare2.Hide()\n  }\n}\n\n\nfunction condType_onChange(){\n\tvar v = this.condType.Value();\n  this.BoxMeasC.Collapse();\n  this.BoxMeasS.Collapse();\n  if( v == 'compare' ) {\n    this.BoxMeasC.Expand();\n    this.BoxMeasS.Collapse();\n  }\n  else if( v == '2scale' || v == '3scale') {\n    this.BoxMeasS.Expand();\n    this.BoxMeasC.Collapse();\n    \n    if( v == '2scale' ) {\n      this.label_bc3.Hide();\n      this.lblMax.Hide();\n      this.sBckColor3.Hide();\n      this.sBckColor3_btn.Hide();\n      this.sCompare3.Hide();\n      this.lblMid.Value('Max. Value');\n    }\n    else {\n      this.lblMid.Value('Int. Value');\n    }\n  }\n  this.vCompareType_onChange();\n}\n\n\n\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"portalstudio\u002fportalstudioTheme.css,properties.css","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @label_bc }}{{ @label_bc1 }}{{ @vBckColor_btn }}{{ @sCompare2 }}{{ @sCompare1 }}{{ @sCompare3 }}{{ @sBckColor1 }}{{ @sBckColor1_btn }}{{ @sBckColor2 }}{{ @sBckColor2_btn }}{{ @sBckColor3 }}{{ @sBckColor3_btn }}{{ @label_bc2 }}{{ @label_bc3 }}{{ @vFontColor }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @lblFormatting }}{{ @condformats }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @lblMin }}{{ @lblMid }}{{ @lblMax }}{{ @label_bc }}{{ @label_bc1 }}{{ @vBckColor_btn }}{{ @sCompare2 }}{{ @sCompare1 }}{{ @sCompare3 }}{{ @sBckColor1 }}{{ @sBckColor1_btn }}{{ @sBckColor2 }}{{ @sBckColor2_btn }}{{ @sBckColor3 }}{{ @sBckColor3_btn }}{{ @label_bc2 }}{{ @label_bc3 }}{{ @vFontColor }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @condformats }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @BoxMeasS }}{{ @lblMin }}{{ @lblMid }}{{ @lblMax }}{{ @BoxMeasC }}{{ @BoxMeasS }}{{ @labelTitle }}{{ @label_bc1 }}{{ @vBckColor_btn }}{{ @sCompare2 }}{{ @sCompare1 }}{{ @sCompare3 }}{{ @sBckColor1 }}{{ @sBckColor1_btn }}{{ @sBckColor2 }}{{ @sBckColor2_btn }}{{ @sBckColor3 }}{{ @sBckColor3_btn }}{{ @label_bc2 }}{{ @label_bc3 }}{{ @vFontColor }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @condformats }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @BoxMeasS }}{{ @lblMin }}{{ @lblMid }}{{ @label_bc }}{{ @lblMax }}{{ @labelTitle }}{{ @btnOk }}{{ @btnClose }}{{ @label_bc1 }}{{ @vBckColor_btn }}{{ @btnClose }}{{ @sCompare2 }}{{ @sCompare1 }}{{ @sCompare3 }}{{ @sBckColor1 }}{{ @sBckColor1_btn }}{{ @sBckColor2 }}{{ @sBckColor2_btn }}{{ @sBckColor3 }}{{ @sBckColor3_btn }}{{ @label_bc2 }}{{ @label_bc3 }}{{ @vFontColor }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @condType }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @BoxMeasS }}{{ @lblMin }}{{ @lblMid }}{{ @label_bc }}{{ @lblMax }}{{ @labelTitle }}{{ @btnOk }}{{ @condType }}{{ @lblValue_Copy }}{{ @btnClose }}{{ @condType }}{{ @btnOk }}{{ @lblValue1 }}{{ @lblValue1_Copy }}{{ @lblValue2 }}{{ @lblValue1 }}{{ @lblValue2 }}{{ @label_fc_Copy }}{{ @lblValue1 }}{{ @lblValue2 }}{{ @label_ft }}{{ @Combobox37 }}{{ @label_ft_Copy }}{{ @btnClose }}{{ @condType }}{{ @labelTitle }}{{ @btnOk }}{{ @lblValue1 }}{{ @lblValue2 }}{{ @label_ft }}{{ @Combobox37 }}{{ @label_ft_Copy }}{{ @vCompare1_Copy }}{{ @vFontName }}{{ @label_fs }}{{ @vFontSize }}{{ @vFontName }}{{ @label_fs }}{{ @vFontSize }}{{ @label_ft }}{{ @vFontName }}{{ @label_fs }}{{ @vFontSize }}{{ @label_fy }}{{ @vFontName_Copy }}{{ @vFontStyle }}\u003c\u002fbody\u003e","grapesCss":"","h":"346","hsl":"","htmlcode":"{{ @label_fy }} \n{{ @label_ft }} \n{{ @lblValue1 }} \n{{ @lblMax }} \n{{ @lblMid }} \n{{ @lblMin }} \n{{ @BoxMeasS }} \n{{ @vCompare2 }} \n{{ @vCompare1 }} \n{{ @vCompareType }} \n{{ @lblValue }} \n{{ @condType \n \n }} \n{{ @lblFormatting }} \n{{ @BoxMeasC }} \n{{ @vBckColor }} \n{{ @vFontColor_btn }} \n{{ @label_fc }} \n{{ @vFontColor }} \n{{ @label_bc3 }} \n{{ @label_bc2 }} \n{{ @sBckColor3_btn }} \n{{ @sBckColor3 }} \n{{ @sBckColor2_btn }} \n{{ @sBckColor2 }} \n{{ @sBckColor1_btn }} \n{{ @sBckColor1 }} \n{{ @sCompare3 }} \n{{ @sCompare1 }} \n{{ @sCompare2 }} \n{{ @vBckColor_btn }} \n{{ @label_bc1 }} \n{{ @label_bc }} \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n{{ @btnClose }} \n{{ @btnOk }} \n{{ @labelTitle }} \n{{ @lblValue1{{ @lblValue2 }} \n }} \n{{ @label_ft{{ @vFontSize }} \n{{ @label_fs }} \n{{ @vFontName }} \n }} \n{{ @label_fy{{ @vFontStyle }} \n }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"portalstudio\u002fstyleVariables.js,portalstudio\u002fjscolor\u002fjscolor.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"h\":\"346\",\"w\":\"100%\",\"title\":\"\",\"layer\":\"\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"661","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_bc1","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Background Color:","w":"108","wireframe_props":"align,value,n_col","x":"42","y":"232","zindex":"2","zone":""},{"anchor":"","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"vBckColor_btn","page":"1","rapp":"","sequence":"1","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"622","y":"157","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnClose","page":"1","rapp":"","sequence":"2","spuid":"","tabindex":"32","type":"Button","type_submit":"false","type_wizard":"","value":"Close","w":"69","wireframe_props":"value","x":"576","y":"308","zindex":"2","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sCompare2","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"120","wireframe_props":"name","x":"263","y":"211","zerofilling":"false","zindex":"16","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"false","init_par":"request","name":"index","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"671","y":"68"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sCompare1","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"120","wireframe_props":"name","x":"42","y":"211","zerofilling":"false","zindex":"16","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"parentID","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"671","y":"96"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sCompare3","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"120","wireframe_props":"name","x":"487","y":"211","zerofilling":"false","zindex":"16","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sBckColor1","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"15","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"113","wireframe_props":"name","x":"42","y":"253","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"sBckColor1_btn","page":"1","rapp":"","sequence":"9","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"157","y":"253","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sBckColor2","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"15","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"113","wireframe_props":"name","x":"263","y":"253","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"sBckColor2_btn","page":"1","rapp":"","sequence":"11","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"378","y":"253","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sBckColor3","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"12","spuid":"","tabindex":"15","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"113","wireframe_props":"name","x":"487","y":"253","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"sBckColor3_btn","page":"1","rapp":"","sequence":"13","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"602","y":"253","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_bc2","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Background Color:","w":"108","wireframe_props":"align,value,n_col","x":"263","y":"232","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_bc3","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Background Color:","w":"108","wireframe_props":"align,value,n_col","x":"487","y":"232","zindex":"2","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"vFontColor","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"16","spuid":"","tabindex":"14","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"113","wireframe_props":"name","x":"361","y":"157","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_fc","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Font Color:","w":"78","wireframe_props":"align,value,n_col","x":"361","y":"137","zindex":"2","zone":""},{"anchor":"","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"false","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"vFontColor_btn","page":"1","rapp":"","sequence":"18","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"476","y":"157","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"vBckColor","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"15","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"113","wireframe_props":"name","x":"505","y":"157","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"true","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"100","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"BoxMeasC","page":"1","rapp":"","sequence":"20","shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"646","wireframe_props":"","x":"4","y":"83","zindex":"0","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblFormatting","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Formatting","w":"90","wireframe_props":"align,value,n_col","x":"46","y":"33","zindex":"2","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","name":"condType","page":"1","picture":"","rapp":"","sequence":"22","spuid":"","tabindex":"","textlist":"Compare,2 scale,3 scale","type":"Combobox","typevar":"character","valuelist":"compare,2scale,3scale","visible":"true","w":"265","wireframe_props":"name,textlist","x":"46","y":"55","zindex":"14","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblValue","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"23","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Compare Type","w":"90","wireframe_props":"align,value,n_col","x":"42","y":"87","zindex":"2","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","name":"vCompareType","page":"1","picture":"","rapp":"","sequence":"24","spuid":"","tabindex":"","textlist":"between,not between,equals,not equals,more than,less than,more or equals,less or equals","type":"Combobox","typevar":"character","valuelist":"between,notbetween,equals,notequals,more,less,moreequals,lessequals","visible":"true","w":"120","wireframe_props":"name,textlist","x":"42","y":"107","zindex":"15","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"vCompare1","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"25","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"120","wireframe_props":"name","x":"176","y":"107","zerofilling":"false","zindex":"16","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"vCompare2","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"26","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"120","wireframe_props":"name","x":"319","y":"107","zerofilling":"false","zindex":"17","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"true","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"96","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"BoxMeasS","page":"1","rapp":"","sequence":"27","shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"646","wireframe_props":"","x":"4","y":"184","zindex":"0","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMin","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"28","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Min. Value","w":"90","wireframe_props":"align,value,n_col","x":"42","y":"190","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMid","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"29","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Int. Value","w":"90","wireframe_props":"align,value,n_col","x":"263","y":"190","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_bc","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Background Color:","w":"108","wireframe_props":"align,value,n_col","x":"505","y":"137","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMax","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Max. Value","w":"90","wireframe_props":"align,value,n_col","x":"487","y":"190","zindex":"2","zone":""},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"30","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"32","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Measure Conditional Formatting:","w":"660","wireframe_props":"align,value,n_col","x":"0","y":"1","zindex":"2","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Confirm column and apply settings","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnOk","page":"1","rapp":"","sequence":"33","spuid":"","tabindex":"30","type":"Button","type_submit":"false","type_wizard":"","value":"Ok","w":"69","wireframe_props":"value","x":"497","y":"308","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblValue1","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"34","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Value 1","w":"90","wireframe_props":"align,value,n_col","x":"176","y":"87","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblValue2","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"35","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Value 2","w":"90","wireframe_props":"align,value,n_col","x":"319","y":"87","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_ft","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"36","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Font:","w":"78","wireframe_props":"align,value,n_col","x":"42","y":"137","zindex":"2","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","name":"vFontName","page":"1","picture":"","rapp":"","sequence":"37","spuid":"","tabindex":"","textlist":"Courier,DejaVu Sans,DejaVu Sans Condensed,DejaVu Sans Mono,DejaVu Serif,DejaVu Serif Condensed,Fira Sans,Helvetica,Open Sans,Raleway,Roboto,Times New Roman","type":"Combobox","typevar":"character","valuelist":"Courier,DejaVu Sans,DejaVu Sans Condensed,DejaVu Sans Mono,DejaVu Serif,DejaVu Serif Condensed,Fira Sans,Helvetica,Open Sans,Raleway,Roboto,Times New Roman","visible":"true","w":"120","wireframe_props":"name,textlist","x":"42","y":"157","zindex":"18","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_fs","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"38","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Font Size:","w":"78","wireframe_props":"align,value,n_col","x":"268","y":"137","zindex":"2","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"vFontSize","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"39","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"78","wireframe_props":"name","x":"268","y":"157","zerofilling":"false","zindex":"16","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_fy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"40","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Font Style:","w":"78","wireframe_props":"align,value,n_col","x":"172","y":"137","zindex":"2","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","name":"vFontStyle","page":"1","picture":"","rapp":"","sequence":"41","spuid":"","tabindex":"","textlist":"Normal,Bold,Italic,Bold Italic","type":"Combobox","typevar":"character","valuelist":"normal,bold,italic,bolditalic","visible":"true","w":"84","wireframe_props":"name,textlist","x":"172","y":"157","zindex":"18","zone":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:sCompare2,index,sCompare1,parentID,sCompare3,sBckColor1,sBckColor2,sBckColor3,vFontColor,vBckColor,condType,vCompareType,vCompare1,vCompare2,vFontName,vFontSize,vFontStyle*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));
if(sp.getParameter("SpStaticCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/javascript");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
window.SPVisualPivotCFormatting_Static=function(){
if(typeof getData !='undefined')this.getData=getData;
if(typeof btnOk_Click !='undefined')this.btnOk_Click=btnOk_Click;
if(typeof btnClose_Click !='undefined')this.btnClose_Click=btnClose_Click;
if(typeof setJsColor !='undefined')this.setJsColor=setJsColor;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof vCompareType_onChange !='undefined')this.vCompareType_onChange=vCompareType_onChange;
if(typeof condType_onChange !='undefined')this.condType_onChange=condType_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var props = ['index', 'condType', 'vCompareType', 'vCompare1', 'vCompare2', 'vFontName', 'vFontStyle', 'vFontSize', 'vFontColor', 'vBckColor',
  					 'sCompare1', 'sCompare2', 'sCompare3', 'sBckColor1', 'sBckColor2', 'sBckColor3'
            ],
    startidx = 0;
function getData(){
  var obj = {};
  for (var i = startidx; i < props.length; i++) {
    if (this[props[i]])
  		obj[props[i]] = this[props[i]].Value();
  }
  return obj;
}
function btnOk_Click(){
  if (GetOpener() && GetOpener().SetCFormatting)
  	GetOpener().SetCFormatting(this.getData());
  else if (GetOpener() && GetOpener()[this.parentID.Value()] && GetOpener()[this.parentID.Value()].SetCFormatting)
  	GetOpener()[this.parentID.Value()].SetCFormatting(this.getData());
  WindowClose();
}
function btnClose_Click(){
  WindowClose();
}
function setJsColor(input, input_btn) {
  jsColorPicker("#"+input.id, input_btn.id, {
      size: 1,
      expires: 365, 
      noResize: true,
      init: function(elm, val) {
        elm.style.backgroundColor = val;
      }.bind(this, input_btn, input.value)
    });
  input_btn.style.backgroundColor = input.value;
}
function this_Loaded(){
	this.BoxMeasC.Collapse();
  this.BoxMeasS.Collapse();
  this.condType_onChange();
  
  setJsColor(this.vFontColor.Ctrl_input,this.vFontColor_btn.Ctrl)
  setJsColor(this.vBckColor.Ctrl_input,this.vBckColor_btn.Ctrl)
  setJsColor(this.sBckColor1.Ctrl_input,this.sBckColor1_btn.Ctrl)
  setJsColor(this.sBckColor2.Ctrl_input,this.sBckColor2_btn.Ctrl)
  setJsColor(this.sBckColor3.Ctrl_input,this.sBckColor3_btn.Ctrl)
}
function vCompareType_onChange(){
  var v = this.vCompareType.Value();
  if( v == 'between' || v == 'notbetween') {
    this.lblValue2.Show();
    this.vCompare2.Show()
  }
  else {
    this.lblValue2.Hide();
    this.vCompare2.Hide()
  }
}
function condType_onChange(){
	var v = this.condType.Value();
  this.BoxMeasC.Collapse();
  this.BoxMeasS.Collapse();
  if( v == 'compare' ) {
    this.BoxMeasC.Expand();
    this.BoxMeasS.Collapse();
  }
  else if( v == '2scale' || v == '3scale') {
    this.BoxMeasS.Expand();
    this.BoxMeasC.Collapse();
    
    if( v == '2scale' ) {
      this.label_bc3.Hide();
      this.lblMax.Hide();
      this.sBckColor3.Hide();
      this.sBckColor3_btn.Hide();
      this.sCompare3.Hide();
      this.lblMid.Value('Max. Value');
    }
    else {
      this.lblMid.Value('Int. Value');
    }
  }
  this.vCompareType_onChange();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.SPVisualPivotCFormatting_container {
}
.SPVisualPivotCFormatting_portlet{
  position:relative;
  width:100%;
  min-width:661px;
  height:346px;
}
.SPVisualPivotCFormatting_portlet[Data-page="1"]{
  height:346px;
  width:100%;
}
.SPVisualPivotCFormatting_portlet > .label_bc1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:232px;
  left:42px;
  width:108px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc1_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc1_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .vBckColor_btn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:157px;
  left:622px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotCFormatting_portlet > .vBckColor_btn_ctrl {
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vBckColor_btn_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .vBckColor_btn_ctrl {
  min-height:20px;
  border-width:1px;
  border-style:solid;
  border-color:#00A0BD;
}
.SPVisualPivotCFormatting_portlet > .btnClose_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:308px;
  right:16px;
  width:69px;
  height:24px;
}
.SPVisualPivotCFormatting_portlet > .btnClose_ctrl {
}
.SPVisualPivotCFormatting_portlet > .sCompare2_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:211px;
  left:263px;
  width:120px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sCompare2_ctrl {
}
.SPVisualPivotCFormatting_portlet > .sCompare2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sCompare1_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:211px;
  left:42px;
  width:120px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sCompare1_ctrl {
}
.SPVisualPivotCFormatting_portlet > .sCompare1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sCompare3_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:211px;
  left:487px;
  width:120px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sCompare3_ctrl {
}
.SPVisualPivotCFormatting_portlet > .sCompare3_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sBckColor1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:253px;
  left:42px;
  width:113px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sBckColor1_ctrl {
}
.SPVisualPivotCFormatting_portlet > .sBckColor1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sBckColor1_btn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:253px;
  left:157px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotCFormatting_portlet > .sBckColor1_btn_ctrl {
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sBckColor1_btn_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sBckColor1_btn_ctrl {
  min-height:20px;
  border-width:1px;
  border-style:solid;
  border-color:#00A0BD;
}
.SPVisualPivotCFormatting_portlet > .sBckColor2_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:253px;
  left:263px;
  width:113px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sBckColor2_ctrl {
}
.SPVisualPivotCFormatting_portlet > .sBckColor2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sBckColor2_btn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:253px;
  left:378px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotCFormatting_portlet > .sBckColor2_btn_ctrl {
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sBckColor2_btn_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sBckColor2_btn_ctrl {
  min-height:20px;
  border-width:1px;
  border-style:solid;
  border-color:#00A0BD;
}
.SPVisualPivotCFormatting_portlet > .sBckColor3_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:253px;
  left:487px;
  width:113px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sBckColor3_ctrl {
}
.SPVisualPivotCFormatting_portlet > .sBckColor3_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sBckColor3_btn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:253px;
  left:602px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotCFormatting_portlet > .sBckColor3_btn_ctrl {
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .sBckColor3_btn_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .sBckColor3_btn_ctrl {
  min-height:20px;
  border-width:1px;
  border-style:solid;
  border-color:#00A0BD;
}
.SPVisualPivotCFormatting_portlet > .label_bc2_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:232px;
  left:263px;
  width:108px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc2_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc2_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .label_bc3_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:232px;
  left:487px;
  width:108px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc3_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc3_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .vFontColor_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:157px;
  left:361px;
  width:113px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vFontColor_ctrl {
}
.SPVisualPivotCFormatting_portlet > .vFontColor_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .label_fc_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:137px;
  left:361px;
  width:78px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_fc_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_fc_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .vFontColor_btn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:157px;
  left:476px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotCFormatting_portlet > .vFontColor_btn_ctrl {
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vFontColor_btn_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .vFontColor_btn_ctrl {
  min-height:20px;
  border-width:1px;
  border-style:solid;
  border-color:#00A0BD;
}
.SPVisualPivotCFormatting_portlet > .vBckColor_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:157px;
  left:505px;
  width:113px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vBckColor_ctrl {
}
.SPVisualPivotCFormatting_portlet > .vBckColor_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasC_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:83px;
  left:4px;
  width:646px;
  height:auto;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasC_ctrl {
  height:100px;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasC_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasC_ctrl {
  border-width:0px;
  border-style:solid;
}
.SPVisualPivotCFormatting_portlet > .lblFormatting_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:33px;
  left:46px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblFormatting_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblFormatting_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .condType_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:55px;
  left:46px;
  width:265px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblValue_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:87px;
  left:42px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblValue_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblValue_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .vCompareType_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:107px;
  left:42px;
  width:120px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vCompare1_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:107px;
  left:176px;
  width:120px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vCompare1_ctrl {
}
.SPVisualPivotCFormatting_portlet > .vCompare1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .vCompare2_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:107px;
  left:319px;
  width:120px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vCompare2_ctrl {
}
.SPVisualPivotCFormatting_portlet > .vCompare2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasS_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:184px;
  left:4px;
  width:646px;
  height:auto;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasS_ctrl {
  height:96px;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasS_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .BoxMeasS_ctrl {
  border-width:0px;
  border-style:solid;
}
.SPVisualPivotCFormatting_portlet > .lblMin_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:190px;
  left:42px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblMin_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblMin_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .lblMid_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:190px;
  left:263px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblMid_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblMid_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .label_bc_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:137px;
  left:505px;
  width:108px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_bc_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .lblMax_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:190px;
  left:487px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblMax_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblMax_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .labelTitle_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:1px;
  left:0px;
  right:1px;
  width:auto;
  height:auto;
  min-height:30px;
}
.SPVisualPivotCFormatting_portlet > .labelTitle_ctrl {
  height:auto;
  min-height:30px;
}
.SPVisualPivotCFormatting_portlet > .labelTitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .btnOk_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:308px;
  right:95px;
  width:69px;
  height:24px;
}
.SPVisualPivotCFormatting_portlet > .btnOk_ctrl {
}
.SPVisualPivotCFormatting_portlet > .lblValue1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:87px;
  left:176px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblValue1_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblValue1_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .lblValue2_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:87px;
  left:319px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblValue2_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .lblValue2_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .label_ft_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:137px;
  left:42px;
  width:78px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_ft_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_ft_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .vFontName_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:157px;
  left:42px;
  width:120px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_fs_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:137px;
  left:268px;
  width:78px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_fs_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_fs_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .vFontSize_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:157px;
  left:268px;
  width:78px;
  height:20px;
}
.SPVisualPivotCFormatting_portlet > .vFontSize_ctrl {
}
.SPVisualPivotCFormatting_portlet > .vFontSize_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPVisualPivotCFormatting_portlet > .label_fy_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:137px;
  left:172px;
  width:78px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_fy_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotCFormatting_portlet > .label_fy_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotCFormatting_portlet > .vFontStyle_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:157px;
  left:172px;
  width:84px;
  height:20px;
}
<%}else if(sp.getParameter("SpWireframe","").equals("true")){
String containerId=sp.getParameter("containerID",idPortlet);
Library.SetMimeType(response,"text/html");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
PrintWireFrame(containerId,out);
%>
<%!
void PrintWireFrame(String containerId, java.io.Writer out) throws java.lang.Throwable {
 String def="[{\"h\":\"346\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"661\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Background Color:\",\"w\":\"108\",\"x\":\"42\",\"y\":\"232\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"622\",\"y\":\"157\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"Close\",\"w\":\"69\",\"x\":\"576\",\"y\":\"308\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sCompare2\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"263\",\"y\":\"211\",\"zindex\":\"16\"},{\"h\":\"20\",\"name\":\"index\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"671\",\"y\":\"68\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sCompare1\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"42\",\"y\":\"211\",\"zindex\":\"16\"},{\"h\":\"20\",\"name\":\"parentID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"671\",\"y\":\"96\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sCompare3\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"487\",\"y\":\"211\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sBckColor1\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"42\",\"y\":\"253\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sBckColor1_btn\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"157\",\"y\":\"253\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sBckColor2\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"263\",\"y\":\"253\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sBckColor2_btn\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"378\",\"y\":\"253\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sBckColor3\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"487\",\"y\":\"253\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sBckColor3_btn\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"602\",\"y\":\"253\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_bc2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Background Color:\",\"w\":\"108\",\"x\":\"263\",\"y\":\"232\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_bc3\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Background Color:\",\"w\":\"108\",\"x\":\"487\",\"y\":\"232\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vFontColor\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"361\",\"y\":\"157\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_fc\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Font Color:\",\"w\":\"78\",\"x\":\"361\",\"y\":\"137\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vFontColor_btn\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"476\",\"y\":\"157\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vBckColor\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"505\",\"y\":\"157\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"BoxMeasC\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"646\",\"x\":\"4\",\"y\":\"83\",\"zindex\":\"0\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblFormatting\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Formatting\",\"w\":\"90\",\"x\":\"46\",\"y\":\"33\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"condType\",\"page\":\"1\",\"textlist\":\"Compare,2 scale,3 scale\",\"type\":\"Combobox\",\"w\":\"265\",\"x\":\"46\",\"y\":\"55\",\"zindex\":\"14\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblValue\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Compare Type\",\"w\":\"90\",\"x\":\"42\",\"y\":\"87\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vCompareType\",\"page\":\"1\",\"textlist\":\"between,not between,equals,not equals,more than,less than,more or equals,less or equals\",\"type\":\"Combobox\",\"w\":\"120\",\"x\":\"42\",\"y\":\"107\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vCompare1\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"176\",\"y\":\"107\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vCompare2\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"319\",\"y\":\"107\",\"zindex\":\"17\"},{\"anchor\":\"\",\"h\":\"96\",\"layout_steps_values\":{},\"name\":\"BoxMeasS\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"646\",\"x\":\"4\",\"y\":\"184\",\"zindex\":\"0\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMin\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Min. Value\",\"w\":\"90\",\"x\":\"42\",\"y\":\"190\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMid\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Int. Value\",\"w\":\"90\",\"x\":\"263\",\"y\":\"190\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_bc\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Background Color:\",\"w\":\"108\",\"x\":\"505\",\"y\":\"137\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMax\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Max. Value\",\"w\":\"90\",\"x\":\"487\",\"y\":\"190\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"30\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelTitle\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Measure Conditional Formatting:\",\"w\":\"660\",\"x\":\"0\",\"y\":\"1\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnOk\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Ok\",\"w\":\"69\",\"x\":\"497\",\"y\":\"308\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblValue1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Value 1\",\"w\":\"90\",\"x\":\"176\",\"y\":\"87\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblValue2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Value 2\",\"w\":\"90\",\"x\":\"319\",\"y\":\"87\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_ft\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Font:\",\"w\":\"78\",\"x\":\"42\",\"y\":\"137\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vFontName\",\"page\":\"1\",\"textlist\":\"Courier,DejaVu Sans,DejaVu Sans Condensed,DejaVu Sans Mono,DejaVu Serif,DejaVu Serif Condensed,Fira Sans,Helvetica,Open Sans,Raleway,Roboto,Times New Roman\",\"type\":\"Combobox\",\"w\":\"120\",\"x\":\"42\",\"y\":\"157\",\"zindex\":\"18\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_fs\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Font Size:\",\"w\":\"78\",\"x\":\"268\",\"y\":\"137\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vFontSize\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"78\",\"x\":\"268\",\"y\":\"157\",\"zindex\":\"16\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_fy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Font Style:\",\"w\":\"78\",\"x\":\"172\",\"y\":\"137\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vFontStyle\",\"page\":\"1\",\"textlist\":\"Normal,Bold,Italic,Bold Italic\",\"type\":\"Combobox\",\"w\":\"84\",\"x\":\"172\",\"y\":\"157\",\"zindex\":\"18\"}]";
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("stdFunctions.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("portalstudio/renderDef.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("visualweb/itemsObj.js")+"'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../visualweb/itemsObj.css'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../portalstudio/renderDef.css'></script>\n");
 out.write("<div id="+JSPLib.ToHTMLValue(containerId)+"></div>\n");
 out.write("<script> /*JS_MARKER_START*/\n");
 out.write("new renderDef({\n");
 out.write("def: "+def+",\n");
 out.write("container: '"+JSPLib.ToJSValue(containerId)+"',\n");
 out.write("replaceContainer: true\n");
 out.write("})\n");
 out.write("/*JS_MARKER_END*/ </script>\n");
}/**/%>
<%}else{
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPVisualPivotCFormatting","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPVisualPivotCFormatting_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>

</style>
<script>
/*JS_MARKER_START*/
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("portalstudio/portalstudioTheme.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("properties.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("properties.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPVisualPivotCFormatting','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label_bc1= "Background Color:";
double sCompare2=sp.getParameter("sCompare2",0);
if(request.getAttribute("SPVisualPivotCFormatting_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
double index=sp.getParameter("index",0);
double sCompare1=sp.getParameter("sCompare1",0);
String parentID=JSPLib.translateXSS(sp.getParameter("parentID",""));
double sCompare3=sp.getParameter("sCompare3",0);
String sBckColor1=JSPLib.translateXSS(sp.getParameter("sBckColor1",""));
String sBckColor2=JSPLib.translateXSS(sp.getParameter("sBckColor2",""));
String sBckColor3=JSPLib.translateXSS(sp.getParameter("sBckColor3",""));
String label_bc2= "Background Color:";
String label_bc3= "Background Color:";
String vFontColor=JSPLib.translateXSS(sp.getParameter("vFontColor",""));
String label_fc= "Font Color:";
String vBckColor=JSPLib.translateXSS(sp.getParameter("vBckColor",""));
String lblFormatting= "Formatting";
String condType=JSPLib.translateXSS(sp.getParameter("condType",""));
String lblValue= "Compare Type";
String vCompareType=JSPLib.translateXSS(sp.getParameter("vCompareType",""));
double vCompare1=sp.getParameter("vCompare1",0);
double vCompare2=sp.getParameter("vCompare2",0);
String lblMin= "Min. Value";
String lblMid= "Int. Value";
String label_bc= "Background Color:";
String lblMax= "Max. Value";
String labelTitle= "Measure Conditional Formatting:";
String lblValue1= "Value 1";
String lblValue2= "Value 2";
String label_ft= "Font:";
String vFontName=JSPLib.translateXSS(sp.getParameter("vFontName",""));
String label_fs= "Font Size:";
double vFontSize=sp.getParameter("vFontSize",0);
String label_fy= "Font Style:";
String vFontStyle=JSPLib.translateXSS(sp.getParameter("vFontStyle",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPVisualPivotCFormatting_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPVisualPivotCFormatting_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPVisualPivotCFormatting','<%=idPortlet%>',false,'');
</script><%}}%>
<label id='<%=idPortlet%>_label_bc1'  formid='<%=idPortlet%>' ps-name='label_bc1'    class='portalstudio_label label_bc1_ctrl'><div id='<%=idPortlet%>_label_bc1tbl' style='width:100%;'><%=JSPLib.ToHTML("Background Color:")%></div></label>
<div id='<%=idPortlet%>_vBckColor_btn' class='vBckColor_btn_ctrl SPSection_expanded box_colorpicker' data-original-display='flex'><div id='<%=idPortlet%>_vBckColor_btn_td' class='box_content'></div>
</div>
<input id='<%=idPortlet%>_btnClose' type='button' class='portalstudio_button black btnClose_ctrl' tabindex='32'/>
<span class='textbox-container'id='<%=idPortlet%>_sCompare2_wrp'><input id='<%=idPortlet%>_sCompare2' name='sCompare2' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='sCompare2' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_sCompare1_wrp'><input id='<%=idPortlet%>_sCompare1' name='sCompare1' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='sCompare1' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_sCompare3_wrp'><input id='<%=idPortlet%>_sCompare3' name='sCompare3' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='sCompare3' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_sBckColor1_wrp'><input id='<%=idPortlet%>_sBckColor1' name='sBckColor1' type='text' class='portalstudio_textbox' tabindex='15' formid='<%=idPortlet%>' ps-name='sBckColor1' /></span>
<div id='<%=idPortlet%>_sBckColor1_btn' class='sBckColor1_btn_ctrl SPSection_expanded box_colorpicker' data-original-display='flex'><div id='<%=idPortlet%>_sBckColor1_btn_td' class='box_content'></div>
</div>
<span class='textbox-container'id='<%=idPortlet%>_sBckColor2_wrp'><input id='<%=idPortlet%>_sBckColor2' name='sBckColor2' type='text' class='portalstudio_textbox' tabindex='15' formid='<%=idPortlet%>' ps-name='sBckColor2' /></span>
<div id='<%=idPortlet%>_sBckColor2_btn' class='sBckColor2_btn_ctrl SPSection_expanded box_colorpicker' data-original-display='flex'><div id='<%=idPortlet%>_sBckColor2_btn_td' class='box_content'></div>
</div>
<span class='textbox-container'id='<%=idPortlet%>_sBckColor3_wrp'><input id='<%=idPortlet%>_sBckColor3' name='sBckColor3' type='text' class='portalstudio_textbox' tabindex='15' formid='<%=idPortlet%>' ps-name='sBckColor3' /></span>
<div id='<%=idPortlet%>_sBckColor3_btn' class='sBckColor3_btn_ctrl SPSection_expanded box_colorpicker' data-original-display='flex'><div id='<%=idPortlet%>_sBckColor3_btn_td' class='box_content'></div>
</div>
<label id='<%=idPortlet%>_label_bc2'  formid='<%=idPortlet%>' ps-name='label_bc2'    class='portalstudio_label label_bc2_ctrl'><div id='<%=idPortlet%>_label_bc2tbl' style='width:100%;'><%=JSPLib.ToHTML("Background Color:")%></div></label>
<label id='<%=idPortlet%>_label_bc3'  formid='<%=idPortlet%>' ps-name='label_bc3'    class='portalstudio_label label_bc3_ctrl'><div id='<%=idPortlet%>_label_bc3tbl' style='width:100%;'><%=JSPLib.ToHTML("Background Color:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_vFontColor_wrp'><input id='<%=idPortlet%>_vFontColor' name='vFontColor' type='text' class='portalstudio_textbox' tabindex='14' formid='<%=idPortlet%>' ps-name='vFontColor' /></span>
<label id='<%=idPortlet%>_label_fc'  formid='<%=idPortlet%>' ps-name='label_fc'    class='portalstudio_label label_fc_ctrl'><div id='<%=idPortlet%>_label_fctbl' style='width:100%;'><%=JSPLib.ToHTML("Font Color:")%></div></label>
<div id='<%=idPortlet%>_vFontColor_btn' class='vFontColor_btn_ctrl SPSection_expanded box_colorpicker' data-original-display='flex'><div id='<%=idPortlet%>_vFontColor_btn_td' class='box_content'></div>
</div>
<span class='textbox-container'id='<%=idPortlet%>_vBckColor_wrp'><input id='<%=idPortlet%>_vBckColor' name='vBckColor' type='text' class='portalstudio_textbox' tabindex='15' formid='<%=idPortlet%>' ps-name='vBckColor' /></span>
<div id='<%=idPortlet%>_BoxMeasC' class='BoxMeasC_ctrl SPSection_expanded box' data-original-display='flex' status='open'><div id='<%=idPortlet%>_BoxMeasC_td' class='box_content'></div>
</div>
<label id='<%=idPortlet%>_lblFormatting'  formid='<%=idPortlet%>' ps-name='lblFormatting'    class='portalstudio_label lblFormatting_ctrl'><div id='<%=idPortlet%>_lblFormattingtbl' style='width:100%;'><%=JSPLib.ToHTML("Formatting")%></div></label>
<select id='<%=idPortlet%>_condType' name='condType' class='combobox' style=''></select>
<label id='<%=idPortlet%>_lblValue'  formid='<%=idPortlet%>' ps-name='lblValue'    class='portalstudio_label lblValue_ctrl'><div id='<%=idPortlet%>_lblValuetbl' style='width:100%;'><%=JSPLib.ToHTML("Compare Type")%></div></label>
<select id='<%=idPortlet%>_vCompareType' name='vCompareType' class='combobox' style=''></select>
<span class='textbox-container'id='<%=idPortlet%>_vCompare1_wrp'><input id='<%=idPortlet%>_vCompare1' name='vCompare1' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='vCompare1' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_vCompare2_wrp'><input id='<%=idPortlet%>_vCompare2' name='vCompare2' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='vCompare2' inputmode='numeric' /></span>
<div id='<%=idPortlet%>_BoxMeasS' class='BoxMeasS_ctrl SPSection_expanded box' data-original-display='flex' status='open'><div id='<%=idPortlet%>_BoxMeasS_td' class='box_content'></div>
</div>
<label id='<%=idPortlet%>_lblMin'  formid='<%=idPortlet%>' ps-name='lblMin'    class='portalstudio_label lblMin_ctrl'><div id='<%=idPortlet%>_lblMintbl' style='width:100%;'><%=JSPLib.ToHTML("Min. Value")%></div></label>
<label id='<%=idPortlet%>_lblMid'  formid='<%=idPortlet%>' ps-name='lblMid'    class='portalstudio_label lblMid_ctrl'><div id='<%=idPortlet%>_lblMidtbl' style='width:100%;'><%=JSPLib.ToHTML("Int. Value")%></div></label>
<label id='<%=idPortlet%>_label_bc'  formid='<%=idPortlet%>' ps-name='label_bc'    class='portalstudio_label label_bc_ctrl'><div id='<%=idPortlet%>_label_bctbl' style='width:100%;'><%=JSPLib.ToHTML("Background Color:")%></div></label>
<label id='<%=idPortlet%>_lblMax'  formid='<%=idPortlet%>' ps-name='lblMax'    class='portalstudio_label lblMax_ctrl'><div id='<%=idPortlet%>_lblMaxtbl' style='width:100%;'><%=JSPLib.ToHTML("Max. Value")%></div></label>
<span id='<%=idPortlet%>_labelTitle'  formid='<%=idPortlet%>' ps-name='labelTitle'    class='portalstudio_title labelTitle_ctrl'><div id='<%=idPortlet%>_labelTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Measure Conditional Formatting:")%></div></span>
<input id='<%=idPortlet%>_btnOk' type='button' class='portalstudio_button btnOk_ctrl' tabindex='30'/>
<label id='<%=idPortlet%>_lblValue1'  formid='<%=idPortlet%>' ps-name='lblValue1'    class='portalstudio_label lblValue1_ctrl'><div id='<%=idPortlet%>_lblValue1tbl' style='width:100%;'><%=JSPLib.ToHTML("Value 1")%></div></label>
<label id='<%=idPortlet%>_lblValue2'  formid='<%=idPortlet%>' ps-name='lblValue2'    class='portalstudio_label lblValue2_ctrl'><div id='<%=idPortlet%>_lblValue2tbl' style='width:100%;'><%=JSPLib.ToHTML("Value 2")%></div></label>
<label id='<%=idPortlet%>_label_ft'  formid='<%=idPortlet%>' ps-name='label_ft'    class='portalstudio_label label_ft_ctrl'><div id='<%=idPortlet%>_label_fttbl' style='width:100%;'><%=JSPLib.ToHTML("Font:")%></div></label>
<select id='<%=idPortlet%>_vFontName' name='vFontName' class='combobox' style=''></select>
<label id='<%=idPortlet%>_label_fs'  formid='<%=idPortlet%>' ps-name='label_fs'    class='portalstudio_label label_fs_ctrl'><div id='<%=idPortlet%>_label_fstbl' style='width:100%;'><%=JSPLib.ToHTML("Font Size:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_vFontSize_wrp'><input id='<%=idPortlet%>_vFontSize' name='vFontSize' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='vFontSize' inputmode='numeric' /></span>
<label id='<%=idPortlet%>_label_fy'  formid='<%=idPortlet%>' ps-name='label_fy'    class='portalstudio_label label_fy_ctrl'><div id='<%=idPortlet%>_label_fytbl' style='width:100%;'><%=JSPLib.ToHTML("Font Style:")%></div></label>
<select id='<%=idPortlet%>_vFontStyle' name='vFontStyle' class='combobox' style=''></select>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPVisualPivotCFormatting');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPVisualPivotCFormatting',["661"],["346"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"661","h":"346","title":"","layer":""}]);
this.label_bc1=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_bc1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_bc1","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_bc1,false,true)%>","type":"Label","w":108,"x":42,"y":232,"zindex":"2"});
this.vBckColor_btn=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vBckColor_btn","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"vBckColor_btn","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":622,"y":157,"zindex":"1"});
this.btnClose=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black btnClose_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnClose","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnClose","page":1,"spuid":"","tabindex":"32","text":"Close","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":576,"y":308,"zindex":"2"});
this.sCompare2=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sCompare2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"sCompare2","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=sCompare2%>","w":120,"x":263,"y":211,"zerofilling":false,"zindex":"16","zoom":""});
this.index=new ZtVWeb._VC(this,'index',null,'numeric',<%=index%>,false,false);
this.sCompare1=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sCompare1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"sCompare1","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=sCompare1%>","w":120,"x":42,"y":211,"zerofilling":false,"zindex":"16","zoom":""});
this.parentID=new ZtVWeb._VC(this,'parentID',null,'character','<%=JSPLib.ToJSValue(parentID,false,true)%>',false,false);
this.sCompare3=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sCompare3","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"sCompare3","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=sCompare3%>","w":120,"x":487,"y":211,"zerofilling":false,"zindex":"16","zoom":""});
this.sBckColor1=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sBckColor1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"sBckColor1","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sBckColor1,false,true)%>","w":113,"x":42,"y":253,"zerofilling":false,"zindex":"2","zoom":""});
this.sBckColor1_btn=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sBckColor1_btn","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"sBckColor1_btn","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":157,"y":253,"zindex":"1"});
this.sBckColor2=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sBckColor2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"sBckColor2","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sBckColor2,false,true)%>","w":113,"x":263,"y":253,"zerofilling":false,"zindex":"2","zoom":""});
this.sBckColor2_btn=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sBckColor2_btn","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"sBckColor2_btn","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":378,"y":253,"zindex":"1"});
this.sBckColor3=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sBckColor3","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"sBckColor3","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sBckColor3,false,true)%>","w":113,"x":487,"y":253,"zerofilling":false,"zindex":"2","zoom":""});
this.sBckColor3_btn=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sBckColor3_btn","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"sBckColor3_btn","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":602,"y":253,"zindex":"1"});
this.label_bc2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_bc2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_bc2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_bc2,false,true)%>","type":"Label","w":108,"x":263,"y":232,"zindex":"2"});
this.label_bc3=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_bc3","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_bc3","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_bc3,false,true)%>","type":"Label","w":108,"x":487,"y":232,"zindex":"2"});
this.vFontColor=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vFontColor","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"vFontColor","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(vFontColor,false,true)%>","w":113,"x":361,"y":157,"zerofilling":false,"zindex":"2","zoom":""});
this.label_fc=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_fc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_fc","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_fc,false,true)%>","type":"Label","w":78,"x":361,"y":137,"zindex":"2"});
this.vFontColor_btn=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vFontColor_btn","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"vFontColor_btn","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":476,"y":157,"zindex":"1"});
this.vBckColor=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vBckColor","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"vBckColor","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(vBckColor,false,true)%>","w":113,"x":505,"y":157,"zerofilling":false,"zindex":"2","zoom":""});
this.BoxMeasC=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"true","create_undercond":"","ctrlid":"<%=idPortlet%>_BoxMeasC","groupName":"","h":100,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"BoxMeasC","page":1,"shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","titled":"","type":"Box","w":646,"x":4,"y":83,"zindex":"0"});
this.BoxMeasC.containedCtrls = ['label_fs','label_ft','label_fy','vFontColor','lblValue2','lblValue1','lblValue','label_fc','vCompareType','vBckColor','label_bc','vFontStyle','vCompare2','vCompare1','vFontColor_btn','vBckColor_btn','vFontSize','vFontName'];
this.lblFormatting=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblFormatting","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblFormatting","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblFormatting,false,true)%>","type":"Label","w":90,"x":46,"y":33,"zindex":"2"});
this.condType=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_condType","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=condType%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"condType","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Compare,2 scale,3 scale","type":"Combobox","typevar":"character","valuelist":"compare,2scale,3scale","visible":true,"w":265,"x":46,"y":55,"zindex":"14"});
this.lblValue=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblValue","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblValue","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblValue,false,true)%>","type":"Label","w":90,"x":42,"y":87,"zindex":"2"});
this.vCompareType=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_vCompareType","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=vCompareType%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"vCompareType","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"between,not between,equals,not equals,more than,less than,more or equals,less or equals","type":"Combobox","typevar":"character","valuelist":"between,notbetween,equals,notequals,more,less,moreequals,lessequals","visible":true,"w":120,"x":42,"y":107,"zindex":"15"});
this.vCompare1=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vCompare1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"vCompare1","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=vCompare1%>","w":120,"x":176,"y":107,"zerofilling":false,"zindex":"16","zoom":""});
this.vCompare2=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vCompare2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"vCompare2","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=vCompare2%>","w":120,"x":319,"y":107,"zerofilling":false,"zindex":"17","zoom":""});
this.BoxMeasS=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"true","create_undercond":"","ctrlid":"<%=idPortlet%>_BoxMeasS","groupName":"","h":96,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"BoxMeasS","page":1,"shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","titled":"","type":"Box","w":646,"x":4,"y":184,"zindex":"0"});
this.BoxMeasS.containedCtrls = ['label_bc3','label_bc2','label_bc1','lblMid','sBckColor1_btn','sCompare2','sCompare3','lblMin','sBckColor2_btn','sCompare1','sBckColor3_btn','lblMax','sBckColor1','sBckColor3','sBckColor2'];
this.lblMin=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMin","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMin","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMin,false,true)%>","type":"Label","w":90,"x":42,"y":190,"zindex":"2"});
this.lblMid=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMid","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMid","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMid,false,true)%>","type":"Label","w":90,"x":263,"y":190,"zindex":"2"});
this.label_bc=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_bc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_bc","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_bc,false,true)%>","type":"Label","w":108,"x":505,"y":137,"zindex":"2"});
this.lblMax=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMax","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMax","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMax,false,true)%>","type":"Label","w":90,"x":487,"y":190,"zindex":"2"});
this.labelTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":30,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTitle","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelTitle,false,true)%>","type":"Label","w":660,"x":0,"y":1,"zindex":"2"});
this.btnOk=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button btnOk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnOk","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Confirm column and apply settings","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnOk","page":1,"spuid":"","tabindex":"30","text":"Ok","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":497,"y":308,"zindex":"2"});
this.lblValue1=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblValue1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblValue1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblValue1,false,true)%>","type":"Label","w":90,"x":176,"y":87,"zindex":"2"});
this.lblValue2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblValue2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblValue2","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblValue2,false,true)%>","type":"Label","w":90,"x":319,"y":87,"zindex":"2"});
this.label_ft=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_ft","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_ft","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_ft,false,true)%>","type":"Label","w":78,"x":42,"y":137,"zindex":"2"});
this.vFontName=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_vFontName","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=vFontName%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"vFontName","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Courier,DejaVu Sans,DejaVu Sans Condensed,DejaVu Sans Mono,DejaVu Serif,DejaVu Serif Condensed,Fira Sans,Helvetica,Open Sans,Raleway,Roboto,Times New Roman","type":"Combobox","typevar":"character","valuelist":"Courier,DejaVu Sans,DejaVu Sans Condensed,DejaVu Sans Mono,DejaVu Serif,DejaVu Serif Condensed,Fira Sans,Helvetica,Open Sans,Raleway,Roboto,Times New Roman","visible":true,"w":120,"x":42,"y":157,"zindex":"18"});
this.label_fs=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_fs","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_fs","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_fs,false,true)%>","type":"Label","w":78,"x":268,"y":137,"zindex":"2"});
this.vFontSize=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vFontSize","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"vFontSize","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=vFontSize%>","w":78,"x":268,"y":157,"zerofilling":false,"zindex":"16","zoom":""});
this.label_fy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_fy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_fy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_fy,false,true)%>","type":"Label","w":78,"x":172,"y":137,"zindex":"2"});
this.vFontStyle=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_vFontStyle","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=vFontStyle%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"vFontStyle","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Normal,Bold,Italic,Bold Italic","type":"Combobox","typevar":"character","valuelist":"normal,bold,italic,bolditalic","visible":true,"w":84,"x":172,"y":157,"zindex":"18"});
<%if(!Library.Empty(PageletId) ){%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
<%}%>

}
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPVisualPivotCFormatting_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPVisualPivotCFormatting_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPVisualPivotCFormatting_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.condType.FillData();
window.<%=idPortlet%>.vCompareType.FillData();
window.<%=idPortlet%>.vFontName.FillData();
window.<%=idPortlet%>.vFontStyle.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPVisualPivotCFormatting',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPVisualPivotCFormatting');
/*JS_MARKER_END*/
</script>
<%if(!included){%>
</body>
<%}
}finally{
}%>
<%if(!included){%>
</html>
<%}
sp.endPage("SPVisualPivotCFormatting");
}%>
<%! public String getJSPUID() { return "2631996875"; } %>