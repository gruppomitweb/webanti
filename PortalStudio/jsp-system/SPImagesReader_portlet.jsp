<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _this = this;\n\nfunction getImg(name){\n  var url = \"..\u002f\" + this.folder_path.Value() + name;\n  var uid = LibJavascript.AlfaKeyGen(5);\n  resizeImg(uid, url);\n  return \"\u003cdiv id=\\\"\"+uid+\"\\\" class=\\\"img-thumbnail\\\" style=\\\"background-image:url('\"+ url + \"')\\\" \u003e\"+setName(name)+\"\u003c\u002fdiv\u003e\";\n}\n\nfunction resizeImg(uid, url) {\n  var img = new Image();\n  img.onload = function() {\n    var w = this.naturalWidth;\n    var h = this.naturalHeight;\n    var div = document.getElementById(uid);\n    if(div.offsetWidth \u003e w && div.offsetHeight \u003e h) {\n      div.style.backgroundSize = \"auto\";\n    }    \n    div.setAttribute(\"title\", \"Size: \" + w + \"x\" + h);\n    this.onload = \"void(0)\";\n  }\n  img.src = url;\n}\n\nfunction setName(name) {\n return \"\u003cspan class=\\\"title-thumbnail\\\" title=\\\"\"+name+\"\\\"\u003e\"+name+\"\u003c\u002fspan\u003e\"; \n}\n\nfunction delete_image(name) {\n  this.image_name.Value(name);\n  if(confirm(\"Are you sure you want to proceed?\\nThe image \"+ name +\" will be permanently deleted.\")) {    \n    var res = this.delete_spLinker.Link();\n    if(res && !Empty(window.GetOpener()) && !Empty(window.GetOpener().notimooManager)) {\n      window.GetOpener().notimooManager.show({\n        title:'Delete completed!',\n        message: \"The file \" + name + \" was deleted successful.\",\n        visibleTime: 2500,\n        width: 220\n      });\n    }\n    this.elencoImmagini.Refresh();\n  }\n}\n\nfunction image_Click(name){\n  var retTo = this.retTo.Value();\n\tif( !Empty(name) && !Empty(retTo)) {\n    var element = window.GetOpener().document.getElementById(retTo);\n    if(!Empty(element)){\n      var url = \"..\u002f\" + this.folder_path.Value() + name;\n      element.value = url;\n      element.focus();\n      window.close();\n    }\n  }\n  else alert('Impossibile inserire l\\'immagine!');\n}\n\nfunction currentNode_onChange(){\n\tvar treeValue = this.currentNode.Value();\n  var oldPath = this.folder_path.Value();\n  var treepath = this.elencoCartelle.getPath();\n  if( treeValue != \"..\u002f\" ){\n    \u002f\u002fpareggio il numero di pipe con il numero dei nodi dei path\n    if( !treepath.match(\u002f\\|\u002fg) ) { \u002f\u002fsono nella root\n      this.folder_path.Value(\"images\u002f\");\n    }else if( oldPath.match(\u002f\\\u002f\u002fg) && treepath.match(\u002f\\|\u002fg).length \u003c oldPath.match(\u002f\\\u002f\u002fg).length  ){\n      var str = oldPath ;\n      var indx;\n      while ( treepath.match(\u002f\\|\u002fg).length \u003c str.match(\u002f\\\u002f\u002fg).length ){\n      \tindx = str.lastIndexOf(\"\u002f\", str.length-2)+1\n        str = Left(oldPath,indx )\n      }\n      this.folder_path.Set(str+treeValue+\"\u002f\");\n    } else {\n  \t\tthis.folder_path.Set(oldPath+treeValue+\"\u002f\");\n    }\n  } else { \u002f\u002fdeprecato\n  \tthis.folder_path.Set(Left(oldPath,oldPath.lastIndexOf(\"\u002f\",oldPath.length-2)+1));\n  }\n  this.dragUploader.SetUploadDir(\"..\u002f\" + this.folder_path.Value());\n}\n\nfunction dragUploader_UploadCompleted(){\n  this.elencoImmagini.Refresh();\n\tif(!Empty(window.GetOpener()) && !Empty(window.GetOpener().notimooManager)) {\n    window.GetOpener().notimooManager.show({\n      title:'Upload completed!',\n      message: \"The file \" + this.dragUploader.GetFileName() + \" was uploaded successful.\",\n      visibleTime: 2500,\n      width: 220\n    });\n  }  \n}","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"#E3E3E3","container_bg_image":"","container_bg_pos":"","css":"","css_class":"picker","css_code":"[{\"type\":\"Label\",\"name\":\"normal_button\",\"selector\":\".normal_button\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"display\\\":\\\"\\\",\\\"pad_top\\\":\\\"10\\\",\\\"pad_bottom\\\":\\\"10\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"pad_left\\\":\\\"10\\\",\\\"pad_right\\\":\\\"10\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"bg_color\\\":\\\"#00A0BD\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_color\\\":\\\"#D2D2D2\\\",\\\"border_type\\\":\\\"solid\\\",\\\"border_width\\\":\\\"1\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\" 600\\\",\\\"decoration\\\":\\\"none\\\",\\\"font_color\\\":\\\"#FFFFFF\\\",\\\"align\\\":\\\"center\\\",\\\"code\\\":\\\"margin: 0 auto 10px;\\\\ncursor: pointer;\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"label0\\\",\\\"type\\\":\\\"Label\\\",\\\"class_name\\\":\\\"normal_button\\\",\\\"selector\\\":\\\".normal_button\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px;\\\\\\\"\u003eCarica una foto\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\"Carica una foto\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"font_unit\\\":\\\"px\\\",\\\"class_Css\\\":\\\"label\\\",\\\"display\\\":\\\"\\\",\\\"pad_top\\\":\\\"10\\\",\\\"pad_bottom\\\":\\\"10\\\",\\\"pad_left\\\":\\\"10\\\",\\\"pad_right\\\":\\\"10\\\",\\\"bg_color\\\":\\\"#00A0BD\\\",\\\"border_color\\\":\\\"#D2D2D2\\\",\\\"border_width\\\":\\\"1\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"weight\\\":\\\" 600\\\",\\\"decoration\\\":\\\"none\\\",\\\"font_color\\\":\\\"#FFFFFF\\\",\\\"align\\\":\\\"center\\\",\\\"code\\\":\\\"margin: 0 auto 10px;\\\\ncursor: pointer;\\\"}\",\"code\":\".normal_button{padding: 10px 10px 10px 10px;border: 1px solid #D2D2D2;background-color: #00A0BD;margin: 0 auto 10px;\\ncursor: pointer;font-family: Open Sans, sans-serif;color: #FFFFFF;text-decoration: none;font-weight:  600;text-align: center;}\\n\",\"fontoffline\":\"Open Sans, sans-serif\"},{\"type\":\"undefined_type\",\"name\":\"grid_card_container\",\"selector\":\".grid_card_container \u003e table\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"display\\\":\\\"block\\\",\\\"bg_color\\\":\\\"#EEEEEE\\\",\\\"code\\\":\\\"-webkit-box-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);\\\\nbox-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);\\\\ncursor: pointer;\\\",\\\"position_type\\\":\\\"relative\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"grid_card_container\\\",\\\"selector\\\":\\\".grid_card_container \u003e table\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:480px; height:240px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"block\\\",\\\"bg_color\\\":\\\"#EEEEEE\\\",\\\"code\\\":\\\"-webkit-box-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);\\\\nbox-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);\\\\ncursor: pointer;\\\",\\\"position_type\\\":\\\"relative\\\"}\",\"code\":\".grid_card_container \u003e table{display : block;position: relative;background-color: #EEEEEE;-webkit-box-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);\\nbox-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);\\ncursor: pointer;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"grid_card_container\",\"selector\":\".grid_card_container \u003e table \u003e tbody \",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"display\\\":\\\"block\\\",\\\"code\\\":\\\"overflow: hidden;\\\\nopacity: 1;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"grid_card_container\\\",\\\"selector\\\":\\\".grid_card_container \u003e table \u003e tbody \\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:480px; height:240px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"block\\\",\\\"code\\\":\\\"overflow: hidden;\\\\nopacity: 1;\\\"}\",\"code\":\".grid_card_container \u003e table \u003e tbody {display : block;overflow: hidden;\\nopacity: 1;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"grid_card_container\",\"selector\":\".grid_card_container\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"display\\\":\\\"inline-block\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"bg_color\\\":\\\"#FFFFFF\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"align\\\":\\\"center\\\",\\\"tx_shadow_color\\\":\\\"#464646\\\",\\\"code\\\":\\\"cursor: pointer;\\\\nlist-style: none;\\\\n-webkit-user-select: none;\\\\n-moz-user-select: none;\\\\n-ms-user-select: none;\\\\nuser-select: none;\\\\nwidth: 16.666666%;\\\\nfloat: left;\\\\npadding: 8px !important;\\\\nmargin: 0 !important;\\\\nbox-sizing: border-box;\\\",\\\"position_type\\\":\\\"relative\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"grid_card_container\\\",\\\"selector\\\":\\\".grid_card_container\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:400px; height:560px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"inline-block\\\",\\\"bg_color\\\":\\\"#FFFFFF\\\",\\\"align\\\":\\\"center\\\",\\\"tx_shadow_color\\\":\\\"#464646\\\",\\\"code\\\":\\\"cursor: pointer;\\\\nlist-style: none;\\\\n-webkit-user-select: none;\\\\n-moz-user-select: none;\\\\n-ms-user-select: none;\\\\nuser-select: none;\\\\nwidth: 16.666666%;\\\\nfloat: left;\\\\npadding: 8px !important;\\\\nmargin: 0 !important;\\\\nbox-sizing: border-box;\\\",\\\"position_type\\\":\\\"relative\\\"}\",\"code\":\".grid_card_container{display : inline-block;position: relative;background-color: #FFFFFF;cursor: pointer;\\nlist-style: none;\\n-webkit-user-select: none;\\n-moz-user-select: none;\\n-ms-user-select: none;\\nuser-select: none;\\nwidth: 16.666666%;\\nfloat: left;\\npadding: 8px !important;\\nmargin: 0 !important;\\nbox-sizing: border-box;text-shadow: 0 0 0 #464646;text-align: center;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"row_image\",\"selector\":\".row_image:first-child\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"width: 100%;\\\\nheight: 100%;\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"display\\\":\\\"block\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"row_image\\\",\\\"selector\\\":\\\".row_image:first-child\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:400px; height:560px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"width: 100%;\\\\nheight: 100%;\\\",\\\"display\\\":\\\"block\\\"}\",\"code\":\".row_image:first-child{display : block;width: 100%;\\nheight: 100%;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"row_image\",\"selector\":\".row_image:first-child td, .row_image:first-child td \u003e div \",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"height: 100%;\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"display\\\":\\\"block\\\",\\\"pad_top\\\":\\\"0\\\",\\\"pad_bottom\\\":\\\"0\\\",\\\"pad_left\\\":\\\"0\\\",\\\"pad_right\\\":\\\"0\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"row_image\\\",\\\"selector\\\":\\\".row_image:first-child td, .row_image:first-child td \u003e div \\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:400px; height:560px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"height: 100%;\\\",\\\"display\\\":\\\"block\\\",\\\"pad_top\\\":\\\"0\\\",\\\"pad_bottom\\\":\\\"0\\\",\\\"pad_left\\\":\\\"0\\\",\\\"pad_right\\\":\\\"0\\\"}\",\"code\":\".row_image:first-child td, .row_image:first-child td \u003e div {display : block;padding: 0px 0px 0px 0px;height: 100%;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"picker\",\"selector\":\".picker\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"font_color\\\":\\\"#333333\\\",\\\"align\\\":\\\"\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"size\\\":\\\"12\\\",\\\"font_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"picker\\\",\\\"selector\\\":\\\".picker\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:400px; height:560px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"font_color\\\":\\\"#333333\\\",\\\"align\\\":\\\"\\\",\\\"size\\\":\\\"12\\\",\\\"font_unit\\\":\\\"px\\\"}\",\"code\":\".picker{font-family: Open Sans, sans-serif;color: #333333;font-size: 12px;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"row_image\",\"selector\":\".row_image .img-thumbnail\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"min-height: 146px;\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"display\\\":\\\"block\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"bg_pos\\\":\\\"center center\\\",\\\"bg_repeat\\\":\\\"no-repeat\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"row_image\\\",\\\"selector\\\":\\\".row_image .img-thumbnail\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:400px; height:560px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"min-height: 146px;\\\",\\\"display\\\":\\\"block\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"bg_pos\\\":\\\"center center\\\",\\\"bg_repeat\\\":\\\"no-repeat\\\"}\",\"code\":\".row_image .img-thumbnail{display : block;background-position: center center;background-repeat: no-repeat;background-size: cover;min-height: 146px;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl img\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"display\\\":\\\"none\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl img\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"none\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl img{display : none;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_line img \",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"display\\\":\\\"block\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_line img \\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"block\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_line img {display : block;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_Root\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"weight\\\":\\\" bold\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_Root\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"weight\\\":\\\" bold\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_Root{font-weight:  bold;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedRoot\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font_color\\\":\\\"#00A0BD\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedRoot\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"font_color\\\":\\\"#00A0BD\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedRoot{color: #00A0BD;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedNode\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font_color\\\":\\\"#00A0BD\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedNode\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"font_color\\\":\\\"#00A0BD\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedNode{color: #00A0BD;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"uploader_holder\",\"selector\":\".SpUpload .uploader_holder\",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"hover\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"dotted\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"border_width\\\":\\\"2\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"\\\",\\\"code\\\":\\\"border-color: rgba(160,160,160,.4);\\\",\\\"border_color\\\":\\\"#A0A0A0\\\"},\\\"hover\\\":{\\\"code\\\":\\\"border-color: rgba(160,160,160,.4);\\\",\\\"border_color\\\":\\\"#A0A0A0\\\",\\\"border_type\\\":\\\"dotted\\\",\\\"border_width\\\":\\\"2\\\"},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"uploader_holder\\\",\\\"selector\\\":\\\".SpUpload .uploader_holder\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:120px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"border-color: rgba(160,160,160,.4);\\\",\\\"border_color\\\":\\\"#A0A0A0\\\",\\\"border_type\\\":\\\"dotted\\\",\\\"border_width\\\":\\\"2\\\"}\",\"code\":\".SpUpload .uploader_holder{border: 2px dotted #A0A0A0;border-color: rgba(160,160,160,.4);font-family: Open Sans, sans-serif;}\\n.SpUpload .uploader_holder:hover{border: 2px dotted #A0A0A0;border-color: rgba(160,160,160,.4);}\\n\"},{\"type\":\"undefined_type\",\"name\":\"uploader_holder\",\"selector\":\".SpUpload .uploader_holder.onHover\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"dotted\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"bg_color\\\":\\\"#F1F1F1\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_color\\\":\\\"#A0A0A0\\\",\\\"border_type\\\":\\\"dotted\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"border_width\\\":\\\"2\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"uploader_holder\\\",\\\"selector\\\":\\\".SpUpload .uploader_holder.onHover\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:120px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"bg_color\\\":\\\"#F1F1F1\\\",\\\"border_color\\\":\\\"#A0A0A0\\\",\\\"border_width\\\":\\\"2\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".SpUpload .uploader_holder.onHover{border: 2px dotted #A0A0A0;background-color: #F1F1F1;}\\n\"},{\"type\":\"Label\",\"name\":\"text_button\",\"selector\":\".text_button\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"11\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\" 500\\\",\\\"style\\\":\\\"italic\\\",\\\"transform\\\":\\\"capitalize\\\",\\\"font_color\\\":\\\"#00A0BD\\\",\\\"align\\\":\\\"right\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"code\\\":\\\"cursor: pointer;\\\",\\\"pad_right\\\":\\\"2\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"label0\\\",\\\"type\\\":\\\"Label\\\",\\\"class_name\\\":\\\"text_button\\\",\\\"selector\\\":\\\".text_button\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:110px;\\\\\\\"\u003eclassic uploader\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\"classic uploader\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"font_unit\\\":\\\"px\\\",\\\"class_Css\\\":\\\"label\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"11\\\",\\\"weight\\\":\\\" 500\\\",\\\"style\\\":\\\"italic\\\",\\\"transform\\\":\\\"capitalize\\\",\\\"font_color\\\":\\\"#00A0BD\\\",\\\"align\\\":\\\"right\\\",\\\"code\\\":\\\"cursor: pointer;\\\",\\\"pad_right\\\":\\\"2\\\"}\",\"code\":\".text_button{padding: 0 2px 0 0;cursor: pointer;font-family: Open Sans, sans-serif;color: #00A0BD;text-transform: capitalize;font-style: italic;font-weight:  500;font-size: 11px;text-align: right;}\\n\",\"fontoffline\":\"Open Sans, sans-serif\"},{\"type\":\"undefined_type\",\"name\":\"uploader_holder\",\"selector\":\".SpUpload .uploader_holder .message\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"size\\\":\\\"16\\\",\\\"font_unit\\\":\\\"px\\\",\\\"transform\\\":\\\"uppercase\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"uploader_holder\\\",\\\"selector\\\":\\\".SpUpload .uploader_holder .message\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:110px; height:25px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"size\\\":\\\"16\\\",\\\"font_unit\\\":\\\"px\\\",\\\"transform\\\":\\\"uppercase\\\"}\",\"code\":\".SpUpload .uploader_holder .message{text-transform: uppercase;font-size: 16px;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"close_icon\",\"selector\":\".grid_cell.close_icon a\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"\\\",\\\"font_color\\\":\\\"#666666\\\",\\\"align\\\":\\\"\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"size\\\":\\\"\\\",\\\"font_unit\\\":\\\"px\\\",\\\"code\\\":\\\"font-family: icons8_win10 !important;\\\\nbackground-color: rgba(255,255,255,0.8);\\\\nfont-size: 11px !important;\\\",\\\"position_type\\\":\\\"absolute\\\",\\\"pos_top\\\":\\\"4px\\\",\\\"pos_right\\\":\\\"4px\\\",\\\"pad_top\\\":\\\"3px\\\",\\\"pad_bottom\\\":\\\"3px\\\",\\\"pad_left\\\":\\\"3px\\\",\\\"pad_right\\\":\\\"3px\\\",\\\"border_radius_tl\\\":\\\"50%\\\",\\\"border_radius_tr\\\":\\\"50%\\\",\\\"border_radius_bl\\\":\\\"50%\\\",\\\"border_radius_br\\\":\\\"50%\\\",\\\"border_color\\\":\\\"#BFBFBF\\\",\\\"border_width\\\":\\\"1px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"close_icon\\\",\\\"selector\\\":\\\".grid_cell.close_icon a\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:400px; height:560px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"font\\\":\\\"\\\",\\\"font_color\\\":\\\"#666666\\\",\\\"align\\\":\\\"\\\",\\\"size\\\":\\\"\\\",\\\"font_unit\\\":\\\"px\\\",\\\"code\\\":\\\"font-family: icons8_win10 !important;\\\\nbackground-color: rgba(255,255,255,0.8);\\\\nfont-size: 11px !important;\\\",\\\"position_type\\\":\\\"absolute\\\",\\\"pos_top\\\":\\\"4px\\\",\\\"pos_right\\\":\\\"4px\\\",\\\"pad_top\\\":\\\"3px\\\",\\\"pad_bottom\\\":\\\"3px\\\",\\\"pad_left\\\":\\\"3px\\\",\\\"pad_right\\\":\\\"3px\\\",\\\"border_radius_tl\\\":\\\"50%\\\",\\\"border_radius_tr\\\":\\\"50%\\\",\\\"border_radius_bl\\\":\\\"50%\\\",\\\"border_radius_br\\\":\\\"50%\\\",\\\"border_color\\\":\\\"#BFBFBF\\\",\\\"border_width\\\":\\\"1px\\\"}\",\"code\":\".grid_cell.close_icon a{padding: 3px 3px 3px 3px;border-radius: 50% 50% 50% 50%;border: 1px solid #BFBFBF;position: absolute;top: 4px;right: 4px;font-family: icons8_win10 !important;\\nbackground-color: rgba(255,255,255,0.8);\\nfont-size: 11px !important;color: #666666;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"row_image\",\"selector\":\".row_image .title-thumbnail\",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"overflow: hidden;\\\\nmax-height: 100%;\\\\nword-wrap: break-word;\\\\nbackground: rgba(255,255,255,.8);\\\\nbox-shadow: inset 0 0 0 1px rgba(0,0,0,.15);\\\\nheight: auto !important;\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"display\\\":\\\"block\\\",\\\"pad_top\\\":\\\"8\\\",\\\"pad_bottom\\\":\\\"8\\\",\\\"pad_left\\\":\\\"8\\\",\\\"pad_right\\\":\\\"8\\\",\\\"size\\\":\\\"14\\\",\\\"weight\\\":\\\" bold\\\",\\\"font_color\\\":\\\"#464646\\\",\\\"align\\\":\\\"center\\\",\\\"position_type\\\":\\\"absolute\\\",\\\"pos_bottom\\\":\\\"0\\\",\\\"pos_left\\\":\\\"0\\\",\\\"pos_right\\\":\\\"0\\\"},\\\"hover\\\":{\\\"code\\\":\\\"\\\",\\\"size\\\":\\\"\\\",\\\"decoration\\\":\\\"\\\",\\\"position_type\\\":\\\"\\\"},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"row_image\\\",\\\"selector\\\":\\\".row_image .title-thumbnail\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:400px; height:560px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"overflow: hidden;\\\\nmax-height: 100%;\\\\nword-wrap: break-word;\\\\nbackground: rgba(255,255,255,.8);\\\\nbox-shadow: inset 0 0 0 1px rgba(0,0,0,.15);\\\\nheight: auto !important;\\\",\\\"size\\\":\\\"14\\\",\\\"position_type\\\":\\\"absolute\\\",\\\"display\\\":\\\"block\\\",\\\"pad_top\\\":\\\"8\\\",\\\"pad_bottom\\\":\\\"8\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"pad_left\\\":\\\"8\\\",\\\"pad_right\\\":\\\"8\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"weight\\\":\\\" bold\\\",\\\"font_color\\\":\\\"#464646\\\",\\\"align\\\":\\\"center\\\",\\\"pos_bottom\\\":\\\"0\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"pos_left\\\":\\\"0\\\",\\\"pos_right\\\":\\\"0\\\"}\",\"code\":\".row_image .title-thumbnail{display : block;padding: 8px 8px 8px 8px;position: absolute;bottom: 0px;left: 0px;right: 0px;overflow: hidden;\\nmax-height: 100%;\\nword-wrap: break-word;\\nbackground: rgba(255,255,255,.8);\\nbox-shadow: inset 0 0 0 1px rgba(0,0,0,.15);\\nheight: auto !important;color: #464646;font-weight:  bold;font-size: 14px;text-align: center;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"row_image\",\"selector\":\".row_image:hover .title-thumbnail\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"decoration\\\":\\\"underline\\\",\\\"code\\\":\\\"box-shadow: none;\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"row_image\\\",\\\"selector\\\":\\\".row_image:hover .title-thumbnail\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:480px; height:240px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"decoration\\\":\\\"underline\\\",\\\"code\\\":\\\"box-shadow: none;\\\"}\",\"code\":\".row_image:hover .title-thumbnail{box-shadow: none;text-decoration: underline;}\\n\"},{\"type\":\"undefined_type\",\"name\":\"griafter\",\"selector\":\".griafter\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"box-shadow: inset 0 0 0 1px rgba(0,0,0,.1);\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"griafter\\\",\\\"selector\\\":\\\".griafter\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:480px; height:240px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"box-shadow: inset 0 0 0 1px rgba(0,0,0,.1);\\\"}\",\"code\":\".griafter{box-shadow: inset 0 0 0 1px rgba(0,0,0,.1);}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.open\",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\":after\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"background: url(\\\\\\\"..\u002fportalstudio\u002fimages\u002fpanel\u002ffolder-open.png\\\\\\\") no-repeat center top !important;\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{\\\"display\\\":\\\"none\\\"}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.open\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"none\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.open {\\n  background: url(\\\"..\u002fportalstudio\u002fimages\u002fpanel\u002ffolder-open.png\\\") no-repeat center top !important;\\n}\\n\\n.stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.open::after {\\n  display: none;\\n}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon \",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\":after\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"width: 18px !important;\\\\nheight: 18px !important;\\\\ncursor: pointer !important;\\\\nbackground: url(\\\\\\\"..\u002fportalstudio\u002fimages\u002fpanel\u002ffolder-close.png\\\\\\\") no-repeat center top !important;\\\\nmargin-right: 5px !important;\\\\nmargin-top: -10px !important;\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{\\\"display\\\":\\\"\\\"}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon \\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon {\\n  width: 18px !important;\\n  height: 18px !important;\\n  cursor: pointer !important;\\n  background: url(\\\"..\u002fportalstudio\u002fimages\u002fpanel\u002ffolder-close.png\\\") no-repeat center top !important;\\n  margin-right: 5px !important;\\n  margin-top: -10px !important;\\n}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.single\",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\":after\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{\\\"display\\\":\\\"none\\\"}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.single\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"display\\\":\\\"none\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.single::after {\\n  display: none;\\n}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.folder\",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{\\\"display\\\":\\\"none\\\"}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.folder\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.folder::after {\\n  display: none;\\n}\\n\"},{\"type\":\"undefined_type\",\"name\":\"stdtreeview.elencoCartelle_ctrl\",\"selector\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.root\",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"pos_unit\\\":\\\"px\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_unit\\\":\\\"px\\\",\\\"mar_unit\\\":\\\"px\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\",\\\"pos_unit\\\":\\\"px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{\\\"display\\\":\\\"none\\\"}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"stdtreeview.elencoCartelle_ctrl\\\",\\\"selector\\\":\\\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.root\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:200px; height:470px;\\\\\\\" \u003eUndefined preview.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.root::after {\\n  display: none;\\n}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"position_type\":\"absolute\",\"pos_top\":\"0\",\"pos_right\":\"0\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"close_icon\",\"selector\":\".close_icon\",\"id\":\"form\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"565","hsl":"","htmlcode":"{{ elencoImmagini }}\n{{ elencoCartelle }}\n{{ retTo }}\n{{ directory_to_upload }}\n{{ folder_path }}\n{{ filedataobj }}\n{{ currentNode }}\n{{ folderdataobj }}\n{{ return_file }}\n{{ return_folder }}\n{{ delete_spLinker }}\n{{ image_name }}\n{{ dragUploader }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Select Image","portlet_position":"align center","positioning":"absolute","roles":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"680","version":"37","w":"100%","wizard":""},{"align":"center","anchor":"top-left-right-bottom","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":true,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"function:getImg('%url%')\",\"maxwidth\":\"\",\"title\":\"\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function: image_Click('%url%')\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"field\":\"html:&#xf048;\",\"title\":\"\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"close_icon\",\"width\":\"\",\"maxwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"function: delete_image('%url%')\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"row_image","css_class_row_odd":"row_image","css_class_row_over":"","css_class_row_selected":"row_image","css_class_title":"","css_class_title_hover":"","dataobj":"filedataobj","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":",","filters":"false","floatRows":"true","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"545","hide":"false","hide_default_titles":"","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"elencoImmagini","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"false","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"false","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"18","scroll_bars":"infinite_scroll","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"middle","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"251","y":"14","zindex":""},{"anchor":"top-left-bottom","css":"","css_class":"","dataobj":"folderdataobj","droppable":"false","droppable_name":"","enable_html":"false","field_ChildCount":"Childcount","field_NodeDescr":"folder","field_NodeID":"ID","field_picture":"","font":"","font_color":"","font_size":"","frame":"","h":"280","hidden_fields":"","hide":"false","layout_steps_values":"{}","name":"elencoCartelle","node_link":"","page":"1","root_label":"Images","root_link":"","root_node_value":"","scroll_bars":"true","sequence":"2","set_icons":"","type":"StdTreeView","w":"200","wireframe_props":"","x":"30","y":"30","zindex":""},{"calculate":"","dataobj":"","field":"","h":"24","init":"","init_par":"request:retTo","name":"retTo","page":"1","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"124","x":"720","y":"221"},{"calculate":"","dataobj":"","field":"","h":"24","init":"","init_par":"..\u002fimages\u002f","name":"directory_to_upload","page":"1","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"124","x":"720","y":"251"},{"calculate":"","dataobj":"","field":"","h":"24","init":"","init_par":"images\u002f","name":"folder_path","page":"1","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"124","x":"720","y":"85"},{"appendingData":"false","auto_exec":"true","clientDB":"false","count":"false","h":"30","localDBName":"","n_records":"18","name":"filedataobj","offline":"false","page":"1","parms":"folder_path=folder_path,return_type=return_file","parms_source":"elencoCartelle","query":"rows:spimagereaderroutine","query_async":"false","return_fields_type":"true","sequence":"6","type":"SQLDataobj","w":"30","x":"720","y":"149"},{"calculate":"","dataobj":"elencoCartelle","field":"folder","h":"24","init":"","init_par":"''","name":"currentNode","page":"1","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"124","x":"720","y":"190"},{"appendingData":"false","auto_exec":"true","clientDB":"false","count":"false","h":"30","localDBName":"","n_records":"1000","name":"folderdataobj","offline":"false","page":"1","parms":"folder_path=folder_path,return_type=return_folder","parms_source":"elencoCartelle","query":"rows:spimagereaderroutine","query_async":"false","return_fields_type":"false","sequence":"8","type":"SQLDataobj","w":"30","x":"757","y":"149"},{"calculate":"","dataobj":"","field":"","h":"24","init":"","init_par":"'file'","name":"return_file","page":"1","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"124","x":"720","y":"20"},{"calculate":"","dataobj":"","field":"","h":"24","init":"","init_par":"'folder'","name":"return_folder","page":"1","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"124","x":"720","y":"49"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","name":"delete_spLinker","offline":"false","page":"1","parms":"folder_path, image=image_name","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"rt_imgdel","target":"","type":"SPLinker","w":"30","x":"804","y":"149"},{"calculate":"","dataobj":"","field":"","h":"24","init":"","init_par":"","name":"image_name","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"124","x":"720","y":"116"},{"anchor":"bottom-left","css_class":"","custom_file_prefix":"","extallowed":"jpg, png, gif","file_prefix":"none","h":"160","hide":"false","layout_steps_values":"{}","my_max_file_size":"8","name":"dragUploader","page":"1","sequence":"13","style_mode":"mixed","submiturl":"","type":"SpUpload","uploaddir":"..\u002fimages\u002f","w":"200","wireframe_props":"","x":"30","y":"360","zindex":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:retTo*/%>
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
window.SPImagesReader_Static=function(){
if(typeof getImg !='undefined')this.getImg=getImg;
if(typeof resizeImg !='undefined')this.resizeImg=resizeImg;
if(typeof setName !='undefined')this.setName=setName;
if(typeof delete_image !='undefined')this.delete_image=delete_image;
if(typeof image_Click !='undefined')this.image_Click=image_Click;
if(typeof currentNode_onChange !='undefined')this.currentNode_onChange=currentNode_onChange;
if(typeof dragUploader_UploadCompleted !='undefined')this.dragUploader_UploadCompleted=dragUploader_UploadCompleted;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.filedataobj.addRowConsumer(this.elencoImmagini);
this.folderdataobj.addRowConsumer(this.elencoCartelle);
this.elencoCartelle.SetDataObject(this.folderdataobj);
this.elencoCartelle.addParmConsumer(this.filedataobj);
this.elencoCartelle.addDataConsumer(this.currentNode,<%=JSPLib.ToJSValue("folder",true)%>);
this.elencoCartelle.addParmConsumer(this.folderdataobj);
var _this = this;
function getImg(name){
  var url = "../" + this.folder_path.Value() + name;
  var uid = LibJavascript.AlfaKeyGen(5);
  resizeImg(uid, url);
  return "<div id=\""+uid+"\" class=\"img-thumbnail\" style=\"background-image:url('"+ url + "')\" >"+setName(name)+"</div>";
}
function resizeImg(uid, url) {
  var img = new Image();
  img.onload = function() {
    var w = this.naturalWidth;
    var h = this.naturalHeight;
    var div = document.getElementById(uid);
    if(div.offsetWidth > w && div.offsetHeight > h) {
      div.style.backgroundSize = "auto";
    }    
    div.setAttribute("title", "Size: " + w + "x" + h);
    this.onload = "void(0)";
  }
  img.src = url;
}
function setName(name) {
 return "<span class=\"title-thumbnail\" title=\""+name+"\">"+name+"</span>"; 
}
function delete_image(name) {
  this.image_name.Value(name);
  if(confirm("Are you sure you want to proceed?\nThe image "+ name +" will be permanently deleted.")) {    
    var res = this.delete_spLinker.Link();
    if(res && !Empty(window.GetOpener()) && !Empty(window.GetOpener().notimooManager)) {
      window.GetOpener().notimooManager.show({
        title:'Delete completed!',
        message: "The file " + name + " was deleted successful.",
        visibleTime: 2500,
        width: 220
      });
    }
    this.elencoImmagini.Refresh();
  }
}
function image_Click(name){
  var retTo = this.retTo.Value();
	if( !Empty(name) && !Empty(retTo)) {
    var element = window.GetOpener().document.getElementById(retTo);
    if(!Empty(element)){
      var url = "../" + this.folder_path.Value() + name;
      element.value = url;
      element.focus();
      window.close();
    }
  }
  else alert('Impossibile inserire l\'immagine!');
}
function currentNode_onChange(){
	var treeValue = this.currentNode.Value();
  var oldPath = this.folder_path.Value();
  var treepath = this.elencoCartelle.getPath();
  if( treeValue != "../" ){
    //pareggio il numero di pipe con il numero dei nodi dei path
    if( !treepath.match(/\|/g) ) { //sono nella root
      this.folder_path.Value("images/");
    }else if( oldPath.match(/\//g) && treepath.match(/\|/g).length < oldPath.match(/\//g).length  ){
      var str = oldPath ;
      var indx;
      while ( treepath.match(/\|/g).length < str.match(/\//g).length ){
      	indx = str.lastIndexOf("/", str.length-2)+1
        str = Left(oldPath,indx )
      }
      this.folder_path.Set(str+treeValue+"/");
    } else {
  		this.folder_path.Set(oldPath+treeValue+"/");
    }
  } else { //deprecato
  	this.folder_path.Set(Left(oldPath,oldPath.lastIndexOf("/",oldPath.length-2)+1));
  }
  this.dragUploader.SetUploadDir("../" + this.folder_path.Value());
}
function dragUploader_UploadCompleted(){
  this.elencoImmagini.Refresh();
	if(!Empty(window.GetOpener()) && !Empty(window.GetOpener().notimooManager)) {
    window.GetOpener().notimooManager.show({
      title:'Upload completed!',
      message: "The file " + this.dragUploader.GetFileName() + " was uploaded successful.",
      visibleTime: 2500,
      width: 220
    });
  }  
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
.SPImagesReader_container .normal_button{  padding-top: 10px;
  padding-right: 10px;
  padding-bottom: 10px;
  padding-left: 10px;
  border: 1px solid #D2D2D2;
  background-color: #00A0BD;
  margin: 0 auto 10px;
  cursor: pointer;
  font-family: Open Sans, sans-serif;
  color: #FFFFFF;
  text-decoration: none;
  font-weight:  600;
  text-align: center;
}
.SPImagesReader_container .grid_card_container > table{
  display: block;
  position: relative;
  background-color: #EEEEEE;
  -webkit-box-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);
  box-shadow: inset 0 0 15px rgba(0,0,0,.1),inset 0 0 0 1px rgba(0,0,0,.05);
  cursor: pointer;
}
.SPImagesReader_container .grid_card_container > table > tbody {
  display: block;
  overflow: hidden;
  opacity: 1;
}
.SPImagesReader_container .grid_card_container{
  display: inline-block;
  position: relative;
  background-color: #FFFFFF;
  cursor: pointer;
  list-style: none;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  width: 16.666666%;
  float: left;
  padding: 8px !important;
  margin: 0 !important;
  box-sizing: border-box;
  text-shadow: 0 0 0 #464646;
  text-align: center;
}
.SPImagesReader_container .row_image:first-child{
  display: block;
  width: 100%;
  height: 100%;
}
.SPImagesReader_container .row_image:first-child td, .row_image:first-child td > div {
  display: block;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
  height: 100%;
}
.SPImagesReader_container .picker{
  font-family: Open Sans, sans-serif;
  color: #333333;
  font-size: 12px;
}
.SPImagesReader_container .row_image .img-thumbnail{
  display: block;
  background-position: center center;
  background-repeat: no-repeat;
  background-size: cover;
  min-height: 146px;
}
.SPImagesReader_container .SpUpload .uploader_holder{
  border: 2px dotted #A0A0A0;
  border-color: rgba(160,160,160,.4);
  font-family: Open Sans, sans-serif;
}
.SPImagesReader_container .SpUpload .uploader_holder:hover{
  border: 2px dotted #A0A0A0;
  border-color: rgba(160,160,160,.4);
}
.SPImagesReader_container .SpUpload .uploader_holder.onHover{
  border: 2px dotted #A0A0A0;
  background-color: #F1F1F1;
}
.SPImagesReader_container .text_button{
  padding-right: 2px;
  cursor: pointer;
  font-family: Open Sans, sans-serif;
  color: #00A0BD;
  text-transform: capitalize;
  font-style: italic;
  font-weight:  500;
  font-size: 11px;
  text-align: right;
}
.SPImagesReader_container .SpUpload .uploader_holder .message{
  text-transform: uppercase;
  font-size: 16px;
}
.SPImagesReader_container .grid_cell.close_icon a{
  padding-top: 3px;
  padding-right: 3px;
  padding-bottom: 3px;
  padding-left: 3px;
  border-radius: 50% 50% 50% 50%;
  border: 1px solid #BFBFBF;
  position: absolute;
  top: 4px;
  right: 4px;
  font-family: icons8_win10 !important;
  background-color: rgba(255,255,255,0.8);
  font-size: 11px !important;
  color: #666666;
}
.SPImagesReader_container .row_image .title-thumbnail{
  display: block;
  padding-top: 8px;
  padding-right: 8px;
  padding-bottom: 8px;
  padding-left: 8px;
  position: absolute;
  bottom: 0px;
  left: 0px;
  right: 0px;
  overflow: hidden;
  max-height: 100%;
  word-wrap: break-word;
  background: rgba(255,255,255,.8);
  box-shadow: inset 0 0 0 1px rgba(0,0,0,.15);
  height: auto !important;
  color: #464646;
  font-weight:  bold;
  font-size: 14px;
  text-align: center;
}
.SPImagesReader_container .row_image:hover .title-thumbnail{
  box-shadow: none;
  text-decoration: underline;
}
.SPImagesReader_container .griafter{
  box-shadow: inset 0 0 0 1px rgba(0,0,0,.1);
}
.SPImagesReader_container .close_icon{
  position: absolute;
  top: 0px;
  right: 0px;
}
.SPImagesReader_container {
  background-color:#E3E3E3;
  height:100%;
  overflow:auto;
}
.SPImagesReader_title_container {
  margin: auto;
}
.SPImagesReader_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:680px;
  height:100%;
}
.SPImagesReader_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.SPImagesReader_portlet > .elencoImmagini_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:251px;
  right:29px;
  bottom:6px;
  width:auto;
}
.SPImagesReader_portlet > .elencoCartelle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:30px;
  left:30px;
  bottom:255px;
  width:200px;
}
.SPImagesReader_portlet > .dragUploader_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  left:30px;
  bottom:45px;
  width:200px;
  height:160px;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl img{
  display: none;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_line img {
  display: block;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_Root{
  font-weight:  bold;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedRoot{
  color: #00A0BD;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_selectedNode{
  color: #00A0BD;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.open{
  background: url("../portalstudio/images/panel/folder-open.png") no-repeat center top !important;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.open::after{
  display: none;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_icon {
  width: 18px !important;
  height: 18px !important;
  cursor: pointer !important;
  background: url("../portalstudio/images/panel/folder-close.png") no-repeat center top !important;
  margin-right: 5px !important;
  margin-top: -10px !important;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.single::after{
  display: none;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.folder::after{
  display: none;
}
.SPImagesReader_container .stdtreeview.elencoCartelle_ctrl .stdtreeview_icon.root::after{
  display: none;
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
 String def="[{\"h\":\"565\",\"layout_steps_values\":{},\"pages_names\":\"Select Image\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"680\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right-bottom\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"\"}],\"h\":\"545\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"18\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"251\",\"y\":\"14\",\"zindex\":\"\"},{\"anchor\":\"top-left-bottom\",\"h\":\"280\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"StdTreeView\",\"w\":\"200\",\"x\":\"30\",\"y\":\"30\",\"zindex\":\"\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"720\",\"y\":\"221\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"720\",\"y\":\"251\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"720\",\"y\":\"85\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"720\",\"y\":\"149\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"720\",\"y\":\"190\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"757\",\"y\":\"149\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"720\",\"y\":\"20\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"720\",\"y\":\"49\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"804\",\"y\":\"149\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"720\",\"y\":\"116\"},{\"anchor\":\"bottom-left\",\"h\":\"160\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"SpUpload\",\"w\":\"200\",\"x\":\"30\",\"y\":\"360\",\"zindex\":\"\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPImagesReader","UTF-8")) {return; }
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
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPImagesReader_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><link href='../<%=SPPrxycizer.proxycizedPath("fonts/OpenSans.css", SPPrxycizer.Mode.QUERYSTRING)%>' rel='stylesheet' type='text/css'>
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

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPImagesReader','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPImagesReader_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%if(request.getAttribute("SPImagesReader_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("StdTreeViewObj.js")%>'></script>
<%}
String retTo=JSPLib.translateXSS(sp.getParameter("retTo",""));
String directory_to_upload="../images/";
String folder_path="images/";
String currentNode="";
String return_file="file";
String return_folder="folder";
String image_name= "";
if(request.getAttribute("SPImagesReader_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("SpUploadObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPImagesReader_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPImagesReader_portlet picker' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPImagesReader','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_elencoImmagini' formid='<%=idPortlet%>' ps-name='elencoImmagini'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_elencoCartelle' formid='<%=idPortlet%>' ps-name='elencoCartelle' class='stdtreeview' style='overflow:auto'></div>
<div id='<%=idPortlet%>_dragUploader' class='drag'><div id='uploader_<%=idPortlet%>_dragUploader' class='SpUpload '><div id='uploader_holder_<%=idPortlet%>_dragUploader' class='uploader_holder'></div><label id='uploader_button_<%=idPortlet%>_dragUploader' class='button' for='uploader_input_file_<%=idPortlet%>_dragUploader' style='display: none'><%=Library.ToHTML(sp.translate("SPUPLOAD_MSG_CHOOSE_FILE"),"C",0,0)%>…</label><input id='uploader_input_file_<%=idPortlet%>_dragUploader' class='uploader_input_file' type='file' name='file' style='display: none' multiple></div></div></div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPImagesReader');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FIELD_UNDEFINED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FIELD_UNDEFINED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FILLING_SUBLAYER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FILLING_SUBLAYER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_ABORT",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_ABORT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_CANCEL_UPLOAD",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_CANCEL_UPLOAD"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_CHOOSE_FILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_CHOOSE_FILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_DRAG_FILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_DRAG_FILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_FILE_SELECTED",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_FILE_SELECTED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_MAX_FILE_SIZE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_MAX_FILE_SIZE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_MULTI_UPLOAD_ERROR",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_MULTI_UPLOAD_ERROR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_NOFILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_NOFILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_UNSUPPORTED_FILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_UNSUPPORTED_FILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_UNSUPPORTED_HTML5",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_UNSUPPORTED_HTML5"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_UPLOADING",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_UPLOADING"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPImagesReader',["680"],["565"],'picker',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"680","h":"565","title":"Select Image","layer":"false","npage":"1"}]);
this.elencoImmagini=new ZtVWeb.GridCtrl(this,{"align":"center","anchor":"top-left-right-bottom","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"row_image","class_row_odd":"row_image","class_row_over":"grid_rowover","class_row_selected":"row_image","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_elencoImmagini","dataobj":"filedataobj","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":true,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":545,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"false","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"elencoImmagini","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":false}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"middle","w":400,"x":251,"y":14,"zindex":""});
this.elencoImmagini.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":18,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"extensible":false,"height":"","title_align":"","enable_HTML":true,"onclick":"function: image_Click('%url%')","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:getImg('%url%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"close_icon","font_size":"","link":"","fixedwidth":"","title":"","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","title_align":"","enable_HTML":false,"onclick":"function: delete_image('%url%')","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:&#xf048;","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.elencoCartelle=new ZtVWeb.StdTreeViewCtrl(this,{"anchor":"top-left-bottom","class_css":"stdtreeview","ctrlid":"<%=idPortlet%>_elencoCartelle","droppable":false,"droppable_name":"","enable_html":false,"font":"","font_color":"","font_size":"","h":280,"hide":"false","icon":"","layer":false,"layout_steps_values":{},"name":"elencoCartelle","node_link":"","page":1,"root_label":"Images","root_link":"","root_value":"","scroll_bars":"true","target":"","type":"StdTreeView","w":200,"x":30,"y":30,"zindex":""});
this.elencoCartelle.setRowsCols({"field_ChildCount":"Childcount","field_NodeID":"ID","hiddenFlds":"","NodeDescr":"folder","pictures":""});
this.retTo=new ZtVWeb._VC(this,'retTo',null,'character','<%=JSPLib.ToJSValue(retTo,false,true)%>',false,false);
this.directory_to_upload=new ZtVWeb._VC(this,'directory_to_upload',null,'character','<%=JSPLib.ToJSValue(directory_to_upload,false,true)%>',false,false);
this.folder_path=new ZtVWeb._VC(this,'folder_path',null,'character','<%=JSPLib.ToJSValue(folder_path,false,true)%>',false,false);
this.filedataobj=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"rows:spimagereaderroutine","cmdHash":"<%=JSPLib.cmdHash("rows:spimagereaderroutine",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_filedataobj","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"filedataobj","nrows":"18","page":1,"parms":"folder_path=folder_path,return_type=return_file","parms_source":"elencoCartelle","type":"SQLDataobj","w":30,"x":720,"y":149});
this.currentNode=new ZtVWeb._VC(this,'currentNode',null,'character','<%=JSPLib.ToJSValue(currentNode,false,true)%>',false,false);
this.folderdataobj=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"rows:spimagereaderroutine","cmdHash":"<%=JSPLib.cmdHash("rows:spimagereaderroutine",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_folderdataobj","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"folderdataobj","nrows":"1000","page":1,"parms":"folder_path=folder_path,return_type=return_folder","parms_source":"elencoCartelle","type":"SQLDataobj","w":30,"x":757,"y":149});
this.return_file=new ZtVWeb._VC(this,'return_file',null,'character','<%=JSPLib.ToJSValue(return_file,false,true)%>',false,false);
this.return_folder=new ZtVWeb._VC(this,'return_folder',null,'character','<%=JSPLib.ToJSValue(return_folder,false,true)%>',false,false);
this.delete_spLinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_delete_spLinker","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"delete_spLinker","offline":false,"page":1,"parms":"folder_path, image=image_name","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"rt_imgdel","target":"","type":"SPLinker","w":30,"x":804,"y":149});
this.delete_spLinker.m_cID='<%=JSPLib.cmdHash("routine,rt_imgdel",request.getSession())%>';
this.image_name=new ZtVWeb._VC(this,'image_name',null,'character','<%=JSPLib.ToJSValue(image_name,false,true)%>',false,false);
this.dragUploader=new ZtVWeb.SpUploadCtrl(this,{"allow_live_abort":"","allow_multiple_files":"","anchor":"bottom-left","ctrlid":"<%=idPortlet%>_dragUploader","custom_file_prefix":"","extallowed":"jpg, png, gif","file_prefix":"none","h":160,"hide":"false","layer":false,"layout_steps_values":{},"manual_upload":"","my_max_file_size":"8","name":"dragUploader","page":1,"show_selected_files":"","show_selected_files_name":"","style_mode":"mixed","submiturl":"","type":"SpUpload","uploaddir":"..\u002fimages\u002f","w":200,"x":30,"y":360,"zindex":""});
this.dragUploader.initUploader();
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
<%if(request.getAttribute("SPImagesReader_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPImagesReader_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPImagesReader_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.filedataobj.firstQuery('true');
window.<%=idPortlet%>.folderdataobj.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','SPImagesReader',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPImagesReader');
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
sp.endPage("SPImagesReader");
}%>
<%! public String getJSPUID() { return "1011749179"; } %>