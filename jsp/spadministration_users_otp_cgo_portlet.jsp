<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"if (this.pIssuer.Value() == ''){\n  var iussuer= Strtran(window.location.host+window.location.pathname,(window.location.host+window.location.pathname).substring((window.location.host+window.location.pathname).indexOf(\"\u002fjsp\")),\"\")\n\tiussuer = Strtran(Strtran(iussuer,' ','_'),':','_');\n  this.pIssuer.Value(iussuer);\n}\nif (this.pAccount.Value() == '')  {\n  this.pAccount.Value(Strtran(Strtran(Trim('\u003c%=sp.getUserName()%\u003e'+ ' ' ),' ','_'),':','_'))\n}\nthis.pAccountDis.Value(this.pAccount.Value())\n\t\n\nvar qrcode = new QRCode(this.qrSide.ctrlid+'_td', {\n              width: 150,\n              height: 150,\n              colorDark : \"black\",\n              colorLight : \"white\",\n              correctLevel : QRCode.CorrectLevel.H\n            });  \n\nfunction dec2hex(s) { return (s \u003c 15.5 ? '0' : '') + Math.round(s).toString(16); }\nfunction hex2dec(s) { return parseInt(s, 16); }\n\nfunction base32tohex(base32) {\n  var base32chars = \"ABCDEFGHIJKLMNOPQRSTUVWXYZ234567\";\n  var bits = \"\";\n  var hex = \"\";\n\n  for (var i = 0; i \u003c base32.length; i++) {\n    var val = base32chars.indexOf(base32.charAt(i).toUpperCase());\n    bits += this.leftpad(val.toString(2), 5, '0');\n  }\n  for (var i = 0; i+4 \u003c= bits.length; i+=4) {\n    var chunk = bits.substr(i, 4);\n    hex = hex + parseInt(chunk, 2).toString(16) ;\n  }\n  return hex;}\n\nfunction leftpad(str, len, pad) {\n  if (len + 1 \u003e= str.length) {\n    str = Array(len + 1 - str.length).join(pad) + str;\n  }\n  return str;\n}\n\nfunction updateOtp() {\n  qrcode.clear();\n  var keyBase32 = this.secret.Value();\n  var key = this.base32tohex(keyBase32);\n  var epoch = Math.round(new Date().getTime() \u002f 1000.0);\n  var time = this.leftpad(this.dec2hex(Math.floor(epoch \u002f 30)), 16, '0');\n  \n  var shaObj = new jsSHA(\"SHA-1\", \"HEX\");\n  try {\n\t  shaObj.setHMACKey(key, \"HEX\");\n    shaObj.update(time);\n    var hmac = shaObj.getHMAC(\"HEX\");\n\t\tqrcode.makeCode('otpauth:\u002f\u002ftotp\u002f' + this.pIssuer.Value() + ':' + this.pAccount.Value() + \n                    '?secret=' + keyBase32 + \n                    '&algorithm=SHA1' + \n                    '&issuer=' + this.pIssuer.Value()); \u002f\u002f + '&period=30&digits=6'\n    var offset = hex2dec(hmac.substring(hmac.length - 1));\n    var otp = (this.hex2dec(hmac.substr(offset * 2, 8)) & this.hex2dec('7fffffff')) + '';\n    otp = (otp).substr(otp.length - 6, 6);\n    this.OTP.Value(otp)\n    this.txtOTP.Value('')\n  } catch (e) {\n    alert('Error: ' + e)\n  }\n}\n\nfunction timer_onTimer(){\n  var epoch = Math.round(new Date().getTime() \u002f 1000.0);\n  var countDown = 30 - (epoch % 30);\n  if (epoch % 30 == 0) this.updateOtp();\n}\n\nfunction btnChk_Click(){\n  if (this.OTP.Value() == this.txtOTP.Value()) {\n    this.btnActive.Enabled()\n    this.lb_result.Value(FormatMsg(\"OTP_ENABLED_RESULT_OK\"));\n  } else\n    this.lb_result.Value(FormatMsg(\"OTP_ENABLED_RESULT_KO\"));\n}\n\nfunction btnReset_Click(){\n  this.resetSecret(Upper(CharKeyGen(16)))\n}\n\n\nfunction resetSecret(secret){\n  this.btnActive.Disabled()\n  this.secret.Value(secret); \u002f\u002f solo lunga 10 perchè al momento posso scrivere nel campo tmp trovato solo 10 caratteri (ba_users_info.ufvoippassword)\n  this.updateOtp();\n  this.timer.Start()\n}\n\nfunction btnActive_Click(){\n  debugger\n\tthis.SPLinkerActive.Link()  \n  Alert(FormatMsg(\"OTP_ACTIVATION\"))\n  this.LinkZoomUsr.DoLink();\n\u002f\u002f   GetOpener().Set_otp(this.user_otp.Value());\n  this.SPLogout.Link();  \n\u002f\u002f   window.close();\n}\n\n\nfunction btnDisable_Click(){\n\tthis.SPLinkerDisable.Link()  \n  Alert(FormatMsg(\"OTP_DEACTIVATION\"))\n  this.LinkZoomUsr.DoLink();\n\u002f\u002f   GetOpener().Set_otp(this.user_otp.Value()); \n  this.SPLogout.Link();\n\u002f\u002f   window.close();\n}\n\n\u002f\u002f Gestione tasto INVIO per Login\nthis.Ctrl.onkeydown = function(e){\n  if (navigator.userAgent.indexOf(\"MSIE\")\u003e=0){\n    var el = window.event.srcElement.id;\n    var keycode = event.keyCode;\n  }\n  else{\n    var el = e.target.id;\n    var keycode = e.which;\n  }\n  if (keycode == 13){\n  \u002f\u002f Eseguo la login\n    \u003c%=idPortlet%\u003e.btnChk_Click();\n  }\n}\n\nfunction this_Loaded(){    \n  if (LRTrim(this.secretDb.Value()) != '') {\n    this.resetSecret(this.secretDb.Value())\n  } else\n    this.btnReset_Click();\n  this.btnActive.Disabled();\n  if(!Empty(this.pCode.Value())) {\n     this.user_id.Value(this.pCode.Value());\n     this.user_id.Show();\n     this.LinkZoomUsr.Show()\n     this.user_name.Show();\n  \n     this.user_id_dis.Value(this.pCode.Value());\n     this.user_id_dis.Show();\n     this.LinkZoomUsrDis.Show()\n     this.user_name_dis.Show();\n  } else if(\u003c%=sp.isAdministrator()%\u003e){ \n     this.user_id.Value(\u003c%=sp.getUserCode()%\u003e);\n     this.user_id.Show();\n     this.LinkZoomUsr.Show()\n     this.user_name.Show();\n  \n     this.user_id_dis.Value(\u003c%=sp.getUserCode()%\u003e);\n     this.user_id_dis.Show();\n     this.LinkZoomUsrDis.Show()\n     this.user_name_dis.Show();\n  } else {\n     this.lblHelp1.Value(FormatMsg(\"OTP_ENABLED_STEPS\"))\n\t\t this.lblHelpDis1.Hide()     \n  }\t\n  this.LinkZoomUsr.Hide()\n  this.LinkZoomUsrDis.Hide()\n}\n\nfunction LinkZoomUsr_LinkExecuted(){\n  this.qrSide.Show()\n  this.resetSecret(Upper(CharKeyGen(16)));\n}\nfunction LinkZoomUsr_LinkFailed(){\n  this.qrSide.Hide() \n}\n\nfunction LinkZoomUsrDis_LinkExecuted(){\n  this.btnDisable.Enabled()\n}\nfunction LinkZoomUsr_LinkFailed(){\n  this.btnDisable.Disabled()\n}\nfunction CharKeyGen(keyLen){\n  if (!keyLen || keyLen\u003c0) keyLen=10;\n\tvar res = \"\";\n  for(var i = 0; i \u003c keyLen; i++) {\n    res += String.fromCharCode(Math.floor(Math.random()*26+97)); \u002f\u002flettere minuscole\n  }\n\treturn res;\n}\n\n\u002f\u002f CUSTOM\n\u002f\u002f function user_otp_onChange(){\n\u002f\u002f   if(!Empty(this.user_otp.Value())){\n\u002f\u002f     this.ZtTabs.Select(\"page2\");\n\u002f\u002f \t}\n\u002f\u002f   else{\n\u002f\u002f     this.ZtTabs.Select(\"page1\");\n\u002f\u002f   }\n\u002f\u002f }\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"400","hsl":"true","htmlcode":"{{ pIssuer }}\n{{ pAccount }}\n{{ pAccountDis }}\n{{ qrSide }}\n{{ txtOTP }}\n{{ btnChk }}\n{{ btnActive }}\n{{ btnDisable }}\n{{ secret }}\n{{ OTP }}\n{{ SPLinkerActive }}\n{{ SPLinkerDisable }}\n{{ secretDb }}\n{{ lblHelp2 }}\n{{ lblHelp3 }}\n{{ lblHelp1 }}\n{{ lblHelp4 }}{{ SPLogout }}\n{{ lblHelpDis1 }}\n{{ lblHelpDis4 }}\n{{ lb_result }}\n{{ forRoutine }}\n{{ forRoutineDis }}\n{{ user_id }}\n{{ LinkZoomUsr }}\n{{ user_name }}\n{{ user_id_dis }}\n{{ LinkZoomUsrDis }}\n{{ user_name_dis }}\n{{ pCode }}\n{{ user_otp }}\n{{ timer }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"visualweb\u002fqrcode2.js,sha.js","offline":"false","on_security_failure":"empty","pages_names":"OTP_ACTIVATE,OTP_DEACTIVATE","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"profiled","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"true","tag":"","title":"none","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"540","wizard":""},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"pIssuer","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"55"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"pAccount","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"78"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pAccountDis","page":"2","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"751","y":"30"},{"anchor":"","bg_color":"#FFFFFF","border_color":"#000000","border_weight":"0","class_Css":"box","create_undercond":"","h":"150","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"qrSide","page":"1","sequence":"4","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"150","wireframe_props":"","x":"360","y":"115","zindex":"0"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"txtOTP","page":"1","password":"","picture":"","placeholder":"Digita OTP","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"80","wireframe_props":"name","x":"20","y":"251","zerofilling":"false","zindex":"6"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnChk","page":"1","sequence":"6","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"OTP_CHECK","w":"68","wireframe_props":"value","x":"108","y":"251","zindex":"7"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnActive","page":"1","sequence":"7","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"OTP_ACTIVATE","w":"120","wireframe_props":"value","x":"210","y":"330","zindex":"7"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnDisable","page":"2","sequence":"8","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"OTP_DEACTIVATE","w":"120","wireframe_props":"value","x":"210","y":"275","zindex":"7"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"secret","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"101"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"OTP","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"124"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPLinkerActive","offline":"false","page":"1","parms":"pSecret=forRoutine,pUserCode=user_id","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"sp_totpsecret_save","target":"","type":"SPLinker","w":"131","x":"596","y":"147"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPLinkerDisable","offline":"false","page":"2","parms":"pSecret=forRoutineDis,pUserCode=user_id_dis","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"sp_totpsecret_save","target":"","type":"SPLinker","w":"131","x":"751","y":"54"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"secret","h":"20","init":"","init_par":"","name":"secretDb","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"32"},{"align":"justify","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"82","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lblHelp2","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OTP_ENABLED_QRCODE","w":"297","wireframe_props":"align,value,n_col","x":"19","y":"107","zindex":"13"},{"align":"justify","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"48","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lblHelp3","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OTP_ENABLED_CODE","w":"297","wireframe_props":"align,value,n_col","x":"20","y":"195","zindex":"13"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lblHelp1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OTP_ENABLED_SELECT_USER","w":"500","wireframe_props":"align,value,n_col","x":"20","y":"20","zindex":"13"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lblHelp4","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OTP_ENABLED_CONFIRM","w":"500","wireframe_props":"align,value,n_col","x":"20","y":"304","zindex":"13"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblHelpDis1","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OTP_DISABLED_SELECT_USER","w":"500","wireframe_props":"align,value,n_col","x":"20","y":"47","zindex":"13"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"26","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lblHelpDis4","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"19","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OTP_DISABLED_CONFIRM","w":"500","wireframe_props":"align,value,n_col","x":"20","y":"240","zindex":"13"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lb_result","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"130","wireframe_props":"align,value,n_col","x":"187","y":"254","zindex":"14"},{"calculate":"'sha1$'+secret","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"forRoutine","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"170"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"forRoutineDis","page":"2","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"751","y":"78"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"28","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"user_id","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"23","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"32","wireframe_props":"name","x":"126","y":"56","zerofilling":"false","zindex":"16"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"spadministration_user_otp","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"user_id,user_name,pAccount,user_otp","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"user_id","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoomUsr","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"code,name,name,cpotp","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"24","servlet":"spadministration_users","spuid":"","suggest":"false","table":"cpusers","type":"LinkZoom","w":"20","wireframe_props":"","x":"163","y":"60","zindex":"15","zoomtitle":"OTP_USERS_LIST"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"28","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"user_name","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"25","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"233","wireframe_props":"name","x":"191","y":"56","zerofilling":"false","zindex":"16"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"28","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"user_id_dis","page":"2","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"26","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"32","wireframe_props":"name","x":"119","y":"114","zerofilling":"false","zindex":"16"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"spadministration_user_otp","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"user_id_dis,user_name_dis,pAccountDis","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"user_id_dis","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoomUsrDis","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","readfields":"code,name,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"27","servlet":"spadministration_users","spuid":"","suggest":"false","table":"cpusers","type":"LinkZoom","w":"20","wireframe_props":"","x":"156","y":"118","zindex":"15","zoomtitle":"OTP_USERS_LIST"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"28","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"user_name_dis","page":"2","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"28","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"233","wireframe_props":"name","x":"183","y":"114","zerofilling":"false","zindex":"16"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"pCode","page":"1","reactive":"","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"193"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"user_otp","page":"1","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"131","x":"596","y":"216"},{"allowedentities":"cp_logout","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"SPLogout","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"31","servlet":"cp_logout","target":"","type":"SPLinker","w":"120","x":"598","y":"243"},{"delay":"0","duration":"","h":"30","interval":"1000","name":"timer","page":"1","repeated":"true","rounds":"","start_activated":"false","type":"Timer","w":"129","x":"596","y":"-5"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:pIssuer,pAccount,pCode*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.spadministration_users_otp_cgo_container {
}
.spadministration_users_otp_cgo_title_container {
  margin: auto;
}
.spadministration_users_otp_cgo_portlet{
  position:relative;
  margin: auto;
  min-width:540px;
  height:400px;
}
.spadministration_users_otp_cgo_portlet[Data-page="1"]{
  height:400px;
  width:540px;
}
.spadministration_users_otp_cgo_portlet[Data-page="2"]{
  height:400px;
  width:540px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .qrSide_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:115px;
  left:360px;
  width:150px;
  height:auto;
  min-height:150px;
  display:flex;
  flex-direction:column;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .qrSide_ctrl {
  height:150px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .qrSide_ctrl > .box_content {
  height:100%;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .qrSide_ctrl {
  min-height:150px;
  background-color:#FFFFFF;
  border-width:0px;
  border-style:solid;
  border-color:#000000;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .txtOTP_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:251px;
  left:20px;
  width:80px;
  height:24px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .txtOTP_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .txtOTP_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .btnChk_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:251px;
  left:108px;
  width:68px;
  height:24px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .btnChk_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .btnActive_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:330px;
  left:210px;
  width:120px;
  height:28px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .btnActive_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .btnDisable_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:275px;
  left:210px;
  width:120px;
  height:28px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .btnDisable_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp2_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:107px;
  left:19px;
  width:297px;
  height:auto;
  min-height:82px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp2_ctrl {
  height:auto;
  min-height:82px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp2_ctrl {
  overflow:hidden;
  text-align:justify;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp3_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:195px;
  left:20px;
  width:297px;
  height:auto;
  min-height:48px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp3_ctrl {
  height:auto;
  min-height:48px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp3_ctrl {
  overflow:hidden;
  text-align:justify;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp1_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:20px;
  left:20px;
  width:500px;
  height:auto;
  min-height:20px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp1_ctrl {
  height:auto;
  min-height:20px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp1_ctrl {
  overflow:hidden;
  text-align:center;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp4_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:304px;
  left:20px;
  width:500px;
  height:auto;
  min-height:20px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp4_ctrl {
  height:auto;
  min-height:20px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelp4_ctrl {
  overflow:hidden;
  text-align:center;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelpDis1_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:47px;
  left:20px;
  width:500px;
  height:auto;
  min-height:20px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelpDis1_ctrl {
  height:auto;
  min-height:20px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelpDis1_ctrl {
  overflow:hidden;
  text-align:center;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelpDis4_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:240px;
  left:20px;
  width:500px;
  height:auto;
  min-height:26px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelpDis4_ctrl {
  height:auto;
  min-height:26px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lblHelpDis4_ctrl {
  overflow:hidden;
  text-align:center;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lb_result_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:254px;
  left:187px;
  width:130px;
  height:auto;
  min-height:18px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lb_result_ctrl {
  height:auto;
  min-height:18px;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .lb_result_ctrl {
  overflow:hidden;
  font-weight:bold;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:56px;
  left:126px;
  width:32px;
  height:28px;
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .LinkZoomUsr_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:60px;
  left:163px;
  width:20px;
  height:20px;
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:56px;
  left:191px;
  width:233px;
  height:28px;
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_dis_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:114px;
  left:119px;
  width:32px;
  height:28px;
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_dis_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_dis_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .LinkZoomUsrDis_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:118px;
  left:156px;
  width:20px;
  height:20px;
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_dis_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:114px;
  left:183px;
  width:233px;
  height:28px;
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_dis_ctrl {
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_dis_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
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
 String def="[{\"h\":\"400\",\"layout_steps_values\":{},\"pages_names\":\"OTP_ACTIVATE,OTP_DEACTIVATE\",\"steps\":\"\",\"title\":\"none\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"540\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"55\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"78\"},{\"h\":\"20\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"751\",\"y\":\"30\"},{\"anchor\":\"\",\"h\":\"150\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"150\",\"x\":\"360\",\"y\":\"115\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"txtOTP\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"20\",\"y\":\"251\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnChk\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"OTP_CHECK\",\"w\":\"68\",\"x\":\"108\",\"y\":\"251\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"name\":\"btnActive\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"OTP_ACTIVATE\",\"w\":\"120\",\"x\":\"210\",\"y\":\"330\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"name\":\"btnDisable\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"OTP_DEACTIVATE\",\"w\":\"120\",\"x\":\"210\",\"y\":\"275\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"secret\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"101\"},{\"h\":\"20\",\"name\":\"OTP\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"124\"},{\"h\":\"20\",\"name\":\"SPLinkerActive\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"131\",\"x\":\"596\",\"y\":\"147\"},{\"h\":\"20\",\"name\":\"SPLinkerDisable\",\"page\":\"2\",\"type\":\"SPLinker\",\"w\":\"131\",\"x\":\"751\",\"y\":\"54\"},{\"h\":\"20\",\"name\":\"secretDb\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"32\"},{\"align\":\"justify\",\"anchor\":\"\",\"h\":\"82\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lblHelp2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"OTP_ENABLED_QRCODE\",\"w\":\"297\",\"x\":\"19\",\"y\":\"107\",\"zindex\":\"13\"},{\"align\":\"justify\",\"anchor\":\"\",\"h\":\"48\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lblHelp3\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"OTP_ENABLED_CODE\",\"w\":\"297\",\"x\":\"20\",\"y\":\"195\",\"zindex\":\"13\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lblHelp1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"OTP_ENABLED_SELECT_USER\",\"w\":\"500\",\"x\":\"20\",\"y\":\"20\",\"zindex\":\"13\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lblHelp4\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"OTP_ENABLED_CONFIRM\",\"w\":\"500\",\"x\":\"20\",\"y\":\"304\",\"zindex\":\"13\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblHelpDis1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"OTP_DISABLED_SELECT_USER\",\"w\":\"500\",\"x\":\"20\",\"y\":\"47\",\"zindex\":\"13\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"26\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lblHelpDis4\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"OTP_DISABLED_CONFIRM\",\"w\":\"500\",\"x\":\"20\",\"y\":\"240\",\"zindex\":\"13\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lb_result\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"130\",\"x\":\"187\",\"y\":\"254\",\"zindex\":\"14\"},{\"h\":\"20\",\"name\":\"forRoutine\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"170\"},{\"h\":\"20\",\"name\":\"forRoutineDis\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"751\",\"y\":\"78\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"name\":\"user_id\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"126\",\"y\":\"56\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoomUsr\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"163\",\"y\":\"60\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"name\":\"user_name\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"233\",\"x\":\"191\",\"y\":\"56\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"name\":\"user_id_dis\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"119\",\"y\":\"114\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoomUsrDis\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"156\",\"y\":\"118\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"name\":\"user_name_dis\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"233\",\"x\":\"183\",\"y\":\"114\",\"zindex\":\"16\"},{\"h\":\"20\",\"name\":\"pCode\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"193\"},{\"h\":\"20\",\"name\":\"user_otp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"131\",\"x\":\"596\",\"y\":\"216\"},{\"h\":\"20\",\"name\":\"SPLogout\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"598\",\"y\":\"243\"},{\"h\":\"30\",\"name\":\"timer\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"129\",\"x\":\"596\",\"y\":\"-5\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_users_otp_cgo","UTF-8")) {return; }
 %><%if(!sp.isLogged()){
if (true) return;
}%>
<%if(!sp.CanAccess("ps/spadministration_users_otp_cgo")){%><%if (true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spadministration_users_otp_cgo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
ZtVWeb.RequireLibrary('<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>');
<%String variantTabstrip=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantTabstrip != null) { %> ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');<%}%>
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<% sp.WritePortalStudioCSS(request, out); 
if(Library.IsMobile(request)){%><%}%>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_ctrl {
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .LinkZoomUsr_ctrl {
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_ctrl {
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_id_dis_ctrl {
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .LinkZoomUsrDis_ctrl {
  display:none;
}
.spadministration_users_otp_cgo_portlet > .spadministration_users_otp_cgo_page > .user_name_dis_ctrl {
  display:none;
}

</style>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/qrcode2.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("sha.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_users_otp_cgo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String pIssuer=JSPLib.translateXSS(sp.getParameter("pIssuer",""));
String pAccount=JSPLib.translateXSS(sp.getParameter("pAccount",""));
String pAccountDis= "";
String txtOTP= "";
if(request.getAttribute("spadministration_users_otp_cgo_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String secret= "";
String OTP= "";
String secretDb= "";
String lblHelp2= "OTP_ENABLED_QRCODE";
String lblHelp3= "OTP_ENABLED_CODE";
String lblHelp1= "OTP_ENABLED_SELECT_USER";
String lblHelp4= "OTP_ENABLED_CONFIRM";
String lblHelpDis1= "OTP_DISABLED_SELECT_USER";
String lblHelpDis4= "OTP_DISABLED_CONFIRM";
String lb_result= "";
String forRoutine= "";
String forRoutineDis= "";
double user_id= 0;
if(request.getAttribute("spadministration_users_otp_cgo_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String user_name= "";
double user_id_dis= 0;
String user_name_dis= "";
String pCode=JSPLib.translateXSS(sp.getParameter("pCode",""));
String user_otp= "";
if(request.getAttribute("spadministration_users_otp_cgo_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("TimerObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;display:none;'></div>
<div id='<%=idPortlet%>_container' class='spadministration_users_otp_cgo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_users_otp_cgo_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_users_otp_cgo','<%=idPortlet%>',true,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='spadministration_users_otp_cgo_page' style='display:block'>
<div id='<%=idPortlet%>_qrSide' class='qrSide_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_qrSide_td' class='box_content'></div>
</div>
<span class='textbox-container'id='<%=idPortlet%>_txtOTP_wrp'><input id='<%=idPortlet%>_txtOTP' name='txtOTP' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='txtOTP' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("Digita OTP"))%>/></span>
<input id='<%=idPortlet%>_btnChk' type='button' class='button btnChk_ctrl'/>
<input id='<%=idPortlet%>_btnActive' type='button' class='button btnActive_ctrl'/>
<span id='<%=idPortlet%>_lblHelp2'  formid='<%=idPortlet%>' ps-name='lblHelp2'    class='label lblHelp2_ctrl'><div id='<%=idPortlet%>_lblHelp2tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("OTP_ENABLED_QRCODE"))%></div></span>
<span id='<%=idPortlet%>_lblHelp3'  formid='<%=idPortlet%>' ps-name='lblHelp3'    class='label lblHelp3_ctrl'><div id='<%=idPortlet%>_lblHelp3tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("OTP_ENABLED_CODE"))%></div></span>
<span id='<%=idPortlet%>_lblHelp1'  formid='<%=idPortlet%>' ps-name='lblHelp1'    class='label lblHelp1_ctrl'><div id='<%=idPortlet%>_lblHelp1tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("OTP_ENABLED_SELECT_USER"))%></div></span>
<span id='<%=idPortlet%>_lblHelp4'  formid='<%=idPortlet%>' ps-name='lblHelp4'    class='label lblHelp4_ctrl'><div id='<%=idPortlet%>_lblHelp4tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("OTP_ENABLED_CONFIRM"))%></div></span>
<span id='<%=idPortlet%>_lb_result'  formid='<%=idPortlet%>' ps-name='lb_result'    class='label lb_result_ctrl'><div id='<%=idPortlet%>_lb_resulttbl' style='width:100%;'></div></span>
<span class='textbox-container'id='<%=idPortlet%>_user_id_wrp'><input id='<%=idPortlet%>_user_id' name='user_id' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='user_id' inputmode='numeric' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoomUsr'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_user_name_wrp'><input id='<%=idPortlet%>_user_name' name='user_name' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='user_name' /></span>
</div>
<div id='<%=idPortlet%>_page_2' class='spadministration_users_otp_cgo_page' style='display:none'>
<input id='<%=idPortlet%>_btnDisable' type='button' class='button btnDisable_ctrl'/>
<span id='<%=idPortlet%>_lblHelpDis1'  formid='<%=idPortlet%>' ps-name='lblHelpDis1'    class='label lblHelpDis1_ctrl'><div id='<%=idPortlet%>_lblHelpDis1tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("OTP_DISABLED_SELECT_USER"))%></div></span>
<span id='<%=idPortlet%>_lblHelpDis4'  formid='<%=idPortlet%>' ps-name='lblHelpDis4'    class='label lblHelpDis4_ctrl'><div id='<%=idPortlet%>_lblHelpDis4tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("OTP_DISABLED_CONFIRM"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_user_id_dis_wrp'><input id='<%=idPortlet%>_user_id_dis' name='user_id_dis' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='user_id_dis' inputmode='numeric' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoomUsrDis'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_user_name_dis_wrp'><input id='<%=idPortlet%>_user_name_dis' name='user_name_dis' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='user_name_dis' /></span>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_users_otp_cgo');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("OTP_ACTIVATION",true)+","+JSPLib.ToJSValue(sp.translate("OTP_ACTIVATION"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("OTP_DEACTIVATION",true)+","+JSPLib.ToJSValue(sp.translate("OTP_DEACTIVATION"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("OTP_ENABLED_RESULT_KO",true)+","+JSPLib.ToJSValue(sp.translate("OTP_ENABLED_RESULT_KO"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("OTP_ENABLED_RESULT_OK",true)+","+JSPLib.ToJSValue(sp.translate("OTP_ENABLED_RESULT_OK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("OTP_ENABLED_STEPS",true)+","+JSPLib.ToJSValue(sp.translate("OTP_ENABLED_STEPS"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/spadministration_users_otp_cgo_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("OTP_ACTIVATE"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("OTP_DEACTIVATE"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_users_otp_cgo',["540"],["400"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"540","h":"400","title":"OTP_ACTIVATE","layer":"false","npage":"1"},{"layout_steps_values":{},"w":"540","h":"400","title":"OTP_DEACTIVATE","layer":"false","npage":"2"}]);
this.pIssuer=new ZtVWeb._VC(this,'pIssuer',null,'character','<%=JSPLib.ToJSValue(pIssuer,false,true)%>',false,false);
this.pAccount=new ZtVWeb._VC(this,'pAccount',null,'character','<%=JSPLib.ToJSValue(pAccount,false,true)%>',false,false);
this.pAccountDis=new ZtVWeb._VC(this,'pAccountDis',null,'character','<%=JSPLib.ToJSValue(pAccountDis,false,true)%>',false,false);
this.qrSide=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"#FFFFFF","border_color":"#000000","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_qrSide","groupName":"","h":150,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"qrSide","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":150,"x":360,"y":115,"zindex":"0"});
this.txtOTP=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtOTP","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"txtOTP","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtOTP,false,true)%>","w":80,"x":20,"y":251,"zerofilling":false,"zindex":"6","zoom":""});
this.btnChk=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnChk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnChk","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnChk","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("OTP_CHECK"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":68,"x":108,"y":251,"zindex":"7"});
this.btnActive=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnActive_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnActive","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnActive","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("OTP_ACTIVATE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":120,"x":210,"y":330,"zindex":"7"});
this.btnDisable=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnDisable_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDisable","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnDisable","page":2,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("OTP_DEACTIVATE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":120,"x":210,"y":275,"zindex":"7"});
this.secret=new ZtVWeb._VC(this,'secret',null,'character','<%=JSPLib.ToJSValue(secret,false,true)%>',false,false);
this.OTP=new ZtVWeb._VC(this,'OTP',null,'character','<%=JSPLib.ToJSValue(OTP,false,true)%>',false,false);
this.SPLinkerActive=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinkerActive","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinkerActive","offline":false,"page":1,"parms":"pSecret=forRoutine,pUserCode=user_id","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"sp_totpsecret_save","target":"","type":"SPLinker","w":131,"x":596,"y":147});
this.SPLinkerActive.m_cID='<%=JSPLib.cmdHash("routine,sp_totpsecret_save",request.getSession())%>';
this.SPLinkerDisable=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinkerDisable","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinkerDisable","offline":false,"page":2,"parms":"pSecret=forRoutineDis,pUserCode=user_id_dis","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"sp_totpsecret_save","target":"","type":"SPLinker","w":131,"x":751,"y":54});
this.SPLinkerDisable.m_cID='<%=JSPLib.cmdHash("routine,sp_totpsecret_save",request.getSession())%>';
this.secretDb=new ZtVWeb._VC(this,'secretDb',null,'character','<%=JSPLib.ToJSValue(secretDb,false,true)%>',false,false);
this.lblHelp2=new ZtVWeb._LC(this,{"align":"justify","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHelp2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":82,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHelp2","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblHelp2),false,true)%>","type":"Label","w":297,"x":19,"y":107,"zindex":"13"});
this.lblHelp3=new ZtVWeb._LC(this,{"align":"justify","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHelp3","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":48,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHelp3","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblHelp3),false,true)%>","type":"Label","w":297,"x":20,"y":195,"zindex":"13"});
this.lblHelp1=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHelp1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHelp1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblHelp1),false,true)%>","type":"Label","w":500,"x":20,"y":20,"zindex":"13"});
this.lblHelp4=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHelp4","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHelp4","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblHelp4),false,true)%>","type":"Label","w":500,"x":20,"y":304,"zindex":"13"});
this.lblHelpDis1=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHelpDis1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHelpDis1","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblHelpDis1),false,true)%>","type":"Label","w":500,"x":20,"y":47,"zindex":"13"});
this.lblHelpDis4=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHelpDis4","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":26,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHelpDis4","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblHelpDis4),false,true)%>","type":"Label","w":500,"x":20,"y":240,"zindex":"13"});
this.lb_result=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lb_result","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lb_result","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lb_result),false,true)%>","type":"Label","w":130,"x":187,"y":254,"zindex":"14"});
this.forRoutine=new ZtVWeb._VC(this,'forRoutine',null,'character','<%=JSPLib.ToJSValue(forRoutine,false,true)%>',false,false);
this.forRoutineDis=new ZtVWeb._VC(this,'forRoutineDis',null,'character','<%=JSPLib.ToJSValue(forRoutineDis,false,true)%>',false,false);
this.user_id=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_user_id","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"user_id","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=user_id%>","w":32,"x":126,"y":56,"zerofilling":false,"zindex":"16","zoom":""});
this.LinkZoomUsr=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"spadministration_user_otp","ctrlid":"<%=idPortlet%>_LinkZoomUsr","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fspadministration_users_otp_cgo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"user_id,user_name,pAccount,user_otp","intovarsType":"N,C,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/spadministration_users_otp_cgo_portlet.jspLinkZoomUsr",request.getSession())%>","linkedField":"user_id","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoomUsr","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name,name,cpotp","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"spadministration_users","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpusers,spadministration_user_otp",request.getSession())%>","suggest":false,"table":"cpusers","type":"LinkZoom","w":20,"x":163,"y":60,"zindex":"15","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("OTP_USERS_LIST"),false,true)%>"});
this.user_name=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_user_name","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"user_name","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(user_name,false,true)%>","w":233,"x":191,"y":56,"zerofilling":false,"zindex":"16","zoom":""});
this.user_id_dis=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_user_id_dis","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"user_id_dis","page":2,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=user_id_dis%>","w":32,"x":119,"y":114,"zerofilling":false,"zindex":"16","zoom":""});
this.LinkZoomUsrDis=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"spadministration_user_otp","ctrlid":"<%=idPortlet%>_LinkZoomUsrDis","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fspadministration_users_otp_cgo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"user_id_dis,user_name_dis,pAccountDis","intovarsType":"N,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/spadministration_users_otp_cgo_portlet.jspLinkZoomUsrDis",request.getSession())%>","linkedField":"user_id_dis","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoomUsrDis","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"code,name,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"spadministration_users","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpusers,spadministration_user_otp",request.getSession())%>","suggest":false,"table":"cpusers","type":"LinkZoom","w":20,"x":156,"y":118,"zindex":"15","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("OTP_USERS_LIST"),false,true)%>"});
this.user_name_dis=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_user_name_dis","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"user_name_dis","page":2,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(user_name_dis,false,true)%>","w":233,"x":183,"y":114,"zerofilling":false,"zindex":"16","zoom":""});
this.pCode=new ZtVWeb._VC(this,'pCode',null,'character','<%=JSPLib.ToJSValue(pCode,false,true)%>',false,false);
this.user_otp=new ZtVWeb._VC(this,'user_otp',null,'character','<%=JSPLib.ToJSValue(user_otp,false,true)%>',false,false);
this.SPLogout=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("cp_logout",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLogout","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLogout","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"cp_logout","target":"","type":"SPLinker","w":120,"x":598,"y":243});
this.SPLogout.m_cID='<%=JSPLib.cmdHash("routine,cp_logout",request.getSession())%>';
this.timer=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_timer","delay":"0","duration":"","h":30,"hide":"false","interval":"1000","layer":false,"layout_steps_values":{},"name":"timer","page":1,"repeated":"true","rounds":"","start_activated":"false","type":"Timer","w":129,"x":596,"y":-5});
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
<script>
/*JS_MARKER_START*/
<%=idPortlet%>_tabstrip.Select('page1');
/*JS_MARKER_END*/
</script>
<%request.setAttribute("spadministration_users_otp_cgo_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_users_otp_cgo_Static=function(){
if(typeof dec2hex !='undefined')this.dec2hex=dec2hex;
if(typeof hex2dec !='undefined')this.hex2dec=hex2dec;
if(typeof base32tohex !='undefined')this.base32tohex=base32tohex;
if(typeof leftpad !='undefined')this.leftpad=leftpad;
if(typeof updateOtp !='undefined')this.updateOtp=updateOtp;
if(typeof timer_onTimer !='undefined')this.timer_onTimer=timer_onTimer;
if(typeof btnChk_Click !='undefined')this.btnChk_Click=btnChk_Click;
if(typeof btnReset_Click !='undefined')this.btnReset_Click=btnReset_Click;
if(typeof resetSecret !='undefined')this.resetSecret=resetSecret;
if(typeof btnActive_Click !='undefined')this.btnActive_Click=btnActive_Click;
if(typeof btnDisable_Click !='undefined')this.btnDisable_Click=btnDisable_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LinkZoomUsr_LinkExecuted !='undefined')this.LinkZoomUsr_LinkExecuted=LinkZoomUsr_LinkExecuted;
if(typeof LinkZoomUsr_LinkFailed !='undefined')this.LinkZoomUsr_LinkFailed=LinkZoomUsr_LinkFailed;
if(typeof LinkZoomUsrDis_LinkExecuted !='undefined')this.LinkZoomUsrDis_LinkExecuted=LinkZoomUsrDis_LinkExecuted;
if(typeof LinkZoomUsr_LinkFailed !='undefined')this.LinkZoomUsr_LinkFailed=LinkZoomUsr_LinkFailed;
if(typeof CharKeyGen !='undefined')this.CharKeyGen=CharKeyGen;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
this.forRoutine.Set('sha1$'+this.secret.Value());
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.LinkZoomUsr.addObserverFixedVars();
this.LinkZoomUsrDis.addObserverFixedVars();
if (this.pIssuer.Value() == ''){
  var iussuer= Strtran(window.location.host+window.location.pathname,(window.location.host+window.location.pathname).substring((window.location.host+window.location.pathname).indexOf("/jsp")),"")
	iussuer = Strtran(Strtran(iussuer,' ','_'),':','_');
  this.pIssuer.Value(iussuer);
}
if (this.pAccount.Value() == '')  {
  this.pAccount.Value(Strtran(Strtran(Trim('<%=sp.getUserName()%>'+ ' ' ),' ','_'),':','_'))
}
this.pAccountDis.Value(this.pAccount.Value())
	
var qrcode = new QRCode(this.qrSide.ctrlid+'_td', {
              width: 150,
              height: 150,
              colorDark : "black",
              colorLight : "white",
              correctLevel : QRCode.CorrectLevel.H
            });  
function dec2hex(s) { return (s < 15.5 ? '0' : '') + Math.round(s).toString(16); }
function hex2dec(s) { return parseInt(s, 16); }
function base32tohex(base32) {
  var base32chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
  var bits = "";
  var hex = "";
  for (var i = 0; i < base32.length; i++) {
    var val = base32chars.indexOf(base32.charAt(i).toUpperCase());
    bits += this.leftpad(val.toString(2), 5, '0');
  }
  for (var i = 0; i+4 <= bits.length; i+=4) {
    var chunk = bits.substr(i, 4);
    hex = hex + parseInt(chunk, 2).toString(16) ;
  }
  return hex;}
function leftpad(str, len, pad) {
  if (len + 1 >= str.length) {
    str = Array(len + 1 - str.length).join(pad) + str;
  }
  return str;
}
function updateOtp() {
  qrcode.clear();
  var keyBase32 = this.secret.Value();
  var key = this.base32tohex(keyBase32);
  var epoch = Math.round(new Date().getTime() / 1000.0);
  var time = this.leftpad(this.dec2hex(Math.floor(epoch / 30)), 16, '0');
  
  var shaObj = new jsSHA("SHA-1", "HEX");
  try {
	  shaObj.setHMACKey(key, "HEX");
    shaObj.update(time);
    var hmac = shaObj.getHMAC("HEX");
		qrcode.makeCode('otpauth://totp/' + this.pIssuer.Value() + ':' + this.pAccount.Value() + 
                    '?secret=' + keyBase32 + 
                    '&algorithm=SHA1' + 
                    '&issuer=' + this.pIssuer.Value()); // + '&period=30&digits=6'
    var offset = hex2dec(hmac.substring(hmac.length - 1));
    var otp = (this.hex2dec(hmac.substr(offset * 2, 8)) & this.hex2dec('7fffffff')) + '';
    otp = (otp).substr(otp.length - 6, 6);
    this.OTP.Value(otp)
    this.txtOTP.Value('')
  } catch (e) {
    alert('Error: ' + e)
  }
}
function timer_onTimer(){
  var epoch = Math.round(new Date().getTime() / 1000.0);
  var countDown = 30 - (epoch % 30);
  if (epoch % 30 == 0) this.updateOtp();
}
function btnChk_Click(){
  if (this.OTP.Value() == this.txtOTP.Value()) {
    this.btnActive.Enabled()
    this.lb_result.Value(FormatMsg("OTP_ENABLED_RESULT_OK"));
  } else
    this.lb_result.Value(FormatMsg("OTP_ENABLED_RESULT_KO"));
}
function btnReset_Click(){
  this.resetSecret(Upper(CharKeyGen(16)))
}
function resetSecret(secret){
  this.btnActive.Disabled()
  this.secret.Value(secret); // solo lunga 10 perchè al momento posso scrivere nel campo tmp trovato solo 10 caratteri (ba_users_info.ufvoippassword)
  this.updateOtp();
  this.timer.Start()
}
function btnActive_Click(){
  debugger
	this.SPLinkerActive.Link()  
  Alert(FormatMsg("OTP_ACTIVATION"))
  this.LinkZoomUsr.DoLink();
//   GetOpener().Set_otp(this.user_otp.Value());
  this.SPLogout.Link();  
//   window.close();
}
function btnDisable_Click(){
	this.SPLinkerDisable.Link()  
  Alert(FormatMsg("OTP_DEACTIVATION"))
  this.LinkZoomUsr.DoLink();
//   GetOpener().Set_otp(this.user_otp.Value()); 
  this.SPLogout.Link();
//   window.close();
}
// Gestione tasto INVIO per Login
this.Ctrl.onkeydown = function(e){
  if (navigator.userAgent.indexOf("MSIE")>=0){
    var el = window.event.srcElement.id;
    var keycode = event.keyCode;
  }
  else{
    var el = e.target.id;
    var keycode = e.which;
  }
  if (keycode == 13){
  // Eseguo la login
    <%=idPortlet%>.btnChk_Click();
  }
}
function this_Loaded(){    
  if (LRTrim(this.secretDb.Value()) != '') {
    this.resetSecret(this.secretDb.Value())
  } else
    this.btnReset_Click();
  this.btnActive.Disabled();
  if(!Empty(this.pCode.Value())) {
     this.user_id.Value(this.pCode.Value());
     this.user_id.Show();
     this.LinkZoomUsr.Show()
     this.user_name.Show();
  
     this.user_id_dis.Value(this.pCode.Value());
     this.user_id_dis.Show();
     this.LinkZoomUsrDis.Show()
     this.user_name_dis.Show();
  } else if(<%=sp.isAdministrator()%>){ 
     this.user_id.Value(<%=sp.getUserCode()%>);
     this.user_id.Show();
     this.LinkZoomUsr.Show()
     this.user_name.Show();
  
     this.user_id_dis.Value(<%=sp.getUserCode()%>);
     this.user_id_dis.Show();
     this.LinkZoomUsrDis.Show()
     this.user_name_dis.Show();
  } else {
     this.lblHelp1.Value(FormatMsg("OTP_ENABLED_STEPS"))
		 this.lblHelpDis1.Hide()     
  }	
  this.LinkZoomUsr.Hide()
  this.LinkZoomUsrDis.Hide()
}
function LinkZoomUsr_LinkExecuted(){
  this.qrSide.Show()
  this.resetSecret(Upper(CharKeyGen(16)));
}
function LinkZoomUsr_LinkFailed(){
  this.qrSide.Hide() 
}
function LinkZoomUsrDis_LinkExecuted(){
  this.btnDisable.Enabled()
}
function LinkZoomUsr_LinkFailed(){
  this.btnDisable.Disabled()
}
function CharKeyGen(keyLen){
  if (!keyLen || keyLen<0) keyLen=10;
	var res = "";
  for(var i = 0; i < keyLen; i++) {
    res += String.fromCharCode(Math.floor(Math.random()*26+97)); //lettere minuscole
  }
	return res;
}
// CUSTOM
// function user_otp_onChange(){
//   if(!Empty(this.user_otp.Value())){
//     this.ZtTabs.Select("page2");
// 	}
//   else{
//     this.ZtTabs.Select("page1");
//   }
// }

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_users_otp_cgo_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_users_otp_cgo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_users_otp_cgo');
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
sp.endPage("spadministration_users_otp_cgo");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoomUsr")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpusers";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "spadministration_users";
  result.m_rdField = new String[]{"code", "name", "name", "cpotp"};
  result.m_rdTypes = new String[]{"N", "C", "C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoomUsrDis")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpusers";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "spadministration_users";
  result.m_rdField = new String[]{"code", "name", "name"};
  result.m_rdTypes = new String[]{"N", "C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "554119953"; } %>