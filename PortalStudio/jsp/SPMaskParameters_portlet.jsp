<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u003c%\n  int configMode=sp.ZoomConfigMode();\n\tboolean canCustomizeVdm=sp.CanCustomizeVdm();\n%\u003e\nvar canSaveVdm=\u003c%=configMode%\u003e;\nvar canCustomizeVdm=\u003c%=canCustomizeVdm%\u003e\nthis.savinghashparameter = '\u003c%=JSPLib.cmdHash(\"VisualDinamicMask\", request.getSession())%\u003e';\nfunction this_OnSubmit() {\n\tif (EmptyString(this.splinker.Servlet())) {\n\t\tif (this.checkField())\n\t\t\tthis.$entity$_confirm.Emit();\n\t} else if (window.SendData)\n\t\twindow.SendData('confirm');\n\treturn false;\n}\n\nm_cLanguage = '\u003c%=sp.getLanguage()%\u003e';\nthis.isAdmin =  \u003c%=sp.isAdministrator()%\u003e ;\nthis.lblVersion = FormatMsg(\"VERSION_NAME\");\nthis.tempFieldsLbl=FormatMsg(\"MSG_TEMP_FILTERS\");\nthis.objRequest = {\n\t \u003c%\n\tEnumeration e = sp.getParameters();\n\tString p,\n\tsep = \"\";\n\twhile (e.hasMoreElements()) {\n\t\tp = (String)e.nextElement();\n\t\tif (p.startsWith(\"w_\")) {\n\t\t\tString campo = JSPLib.Substr(p, 3, p.length() - 2);\n\t\t\tout.print(sep + Library.ToJSValue(campo, \"C\", 0, 0, true, true) + \":\" + Library.ToJSValue(sp.getParameter(p, \"\"), \"C\", 0, 0, true, true));\n\t\t\tsep = \",\";\n\t\t}\n\t}\n\n\t %\u003e\n};\n\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_EMPTY\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_EMPTY\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_NOTEMPTY\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_NOTEMPTY\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_CONTAINS\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CONTAINS\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_STARTS_WITH\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_STARTS_WITH\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_CURRENTMONTH\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CURRENTMONTH\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_CURRENTYEAR\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CURRENTYEAR\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_LASTMONTH\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_LASTMONTH\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_LASTYEAR\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_LASTYEAR\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_LAST30DAYS\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_LAST30DAYS\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_LAST60DAYS\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_LAST60DAYS\"))%\u003e');\nZtVWeb.AddTranslation('\u003c%=JSPLib.ToJSValue(\"MSG_LAST90DAYS\")%\u003e', '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_LAST90DAYS\"))%\u003e');\n\ndrawMask.call(this);\n\nfunction splinker_Executed(result,cError){\n\tthis.dispatchEvent('Executed', result, cError);\n}\nfunction splinker_Result(result) {\n\tthis.dispatchEvent('Result', result);\n}\nfunction splinker_Error(cause,result){\n\tthis.dispatchEvent('Error', cause, result);\n}\nfunction ExecSpLinker() {\n  if(!Empty(this.ProgressBarPortlet.Value()))\n    this.splinker.setProgressBarPortlet(this.ProgressBarPortlet.Value());\n\tthis.splinker.Link();\n}\nfunction splinker_ProgressBarFinished() {\n\tthis.dispatchEvent('ProgressBarFinished');\n}\n\nfunction fillCustomToolbar(extendedFields,hiddenInVariantFields,state) {      \n  var customToolbar=this.getTitlePortlet();\n  this.HamburgerMenu.Clean();\n  if (this.editMode.Value()){\n    this.HamburgerMenu.Hide();\n   \tvar versionName=this.formObj.configName;\n\t  var idx=this.formObj.configName.lastIndexOf('__')\t \n    if (idx!=-1){\n\t    versionName=Trim(Strtran(versionName.substring(idx+2),'_',' '))\n      if (versionName.endsWith('.'+this.Table.Value()))\n        versionName='default'\n    }\n\t  else versionName='default';    \n\t\tcustomToolbar.SetTitle(FormatMsg(\"VERSION_NAME\")+\" \"+versionName);\n    \n    this.selectVersionPortlet.versionName.Value(versionName)\n\t  customToolbar.AppendButton({\n      image:SPTheme.smartEditorApplyImage || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fok.png\",pageContext.getServletContext())%\u003e', \n      action:'javascript:' + this.formid + \".apply()\", \n      title:FormatMsg(\"RPT_APPLY\")\n    });\n\t  customToolbar.AppendButton({\n      image:SPTheme.smartEditorSaveImage||'\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fsave.png\",pageContext.getServletContext())%\u003e', \n      action:'javascript:' + this.formid + \".saveMask()\", \n      title:FormatMsg(\"MSG_SAVE_CONFIG\")\n    });\n    customToolbar.AppendButton({\n      image:SPTheme.smartEditorDiscardImage || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fclose.png\",pageContext.getServletContext())%\u003e', \n      action:'javascript:' + this.formid + \".closeWindow()\", \n      title:FormatMsg(\"MSG_CLOSE_ONEXIT\")\n    });\n\t  customToolbar.RearrangeAll();\n  }\n  else {\n    if (\"none\"==this.m_cDecoration.Value()){      \n      this.HamburgerMenu.CloseMenu();\n      this.HamburgerMenu.Clean();\n    }\n    else{\n       customToolbar.CloseMenu();\n       customToolbar.Clean();\n       customToolbar.RemoveButton(\"extend_reduce\");       \n    }\n    \n    if (!this.hideEditToolbar.Value()){      \n      this.HamburgerMenu.Append({\n        id: 'versioni'\n      },null,1);\n      if (canCustomizeVdm){\n        this.HamburgerMenu.Append({\n          id : 'smarteditor'\n        , title : FormatMsg(\"MSG_EDIT_VERSION\")\n        , tooltip : FormatMsg(\"MSG_EDIT_VERSION\")\n        , image : SPTheme.prmSmartEditorImage||''\n        , action : 'javascript:' + this.formid+\".quickSettings()\"\n        },'versioni',0);\n      }\n      if (this.isAdmin) {\n        this.HamburgerMenu.Append({\n          id : 'maskeditor'\n        , title : FormatMsg(\"MSG_FULL_EDITOR\")\n        , tooltip : FormatMsg(\"MSG_FULL_EDITOR\")\n        , image : SPTheme.prmFullEditorImage||''\n        , action : 'javascript:' + this.formid+\".editMask()\"\n        },'versioni',1);\n      }\n      \n      var maskName=this.formObj.configName.toLowerCase();\n      var idx=maskName.lastIndexOf(\"__\");      \n      if (idx!=-1){\n        var versionName=maskName.substring(idx)\n        if (!versionName.endsWith('.'+this.Table.Value()))\n        \tmaskName=maskName.substring(0,idx);  \n      }      \n      var url='..\u002fservlet\u002fSPVDMProxy?m_cAction=vdmVariant&filter='+maskName;\n      this.vdmVersions=eval(new JSURL(url,true).Response());            \n      var item = {id:'current_version',children:[],maxsubitems:0, alwaysVisible:true};\n      var versName=''\n      for (var i=0; i\u003cthis.vdmVersions.length; i++){\n        this.vdmVersions[i]=this.vdmVersions[i].substring(0,this.vdmVersions[i].length-4).toLowerCase();\n        if (this.vdmVersions[i]==this.formObj.configName.toLowerCase()){\n          versName=this.vdmVersions[i]==maskName?\"default\":Strtran(Strtran(this.vdmVersions[i],maskName+\"__\",\"\"),\"_\",\" \")\n        }\n          item.children.push({\n            title : this.vdmVersions[i]==maskName?\"default\":Strtran(Strtran(this.vdmVersions[i],maskName+\"__\",\"\"),\"_\",\" \")\n          , action : \"javascript:changeVersion(\"+i+\")\"\n          , highlight : this.vdmVersions[i]==this.formObj.configName.toLowerCase()\n          });\n      }\n      \n      \n\u002f\u002f       if (state == 'all' && !hiddenInVariantFields)\n\u002f\u002f         state = 'extended';\n\u002f\u002f       if (state == 'extended' && !extendedFields)\n\u002f\u002f         state = 'reduced'\n\u002f\u002f       if (state == 'all') { \u002f\u002f campi estesi + nascosti\n\u002f\u002f         if (extendedFields) {\n\u002f\u002f           item.children.push({\n\u002f\u002f             id : 'extend_reduce',\n\u002f\u002f             title : FormatMsg(\"MSG_EXTENDED\"),\n\u002f\u002f             action : 'javascript:' + this.formid + \".extend()\"\n\u002f\u002f           })\n\u002f\u002f           item.children.push({\n\u002f\u002f             id : 'extend_reduce',\n\u002f\u002f             title : FormatMsg(\"MSG_REDUCED\"),\n\u002f\u002f             action : 'javascript:' + this.formid + \".reduce()\"\n\u002f\u002f           })\n\u002f\u002f         } else {\n\u002f\u002f           item.children.push({\n\u002f\u002f             id : 'extend_reduce',\n\u002f\u002f             title : FormatMsg(\"MSG_STANDARD\"),\n\u002f\u002f             action : 'javascript:' + this.formid + \".reduce()\"\n\u002f\u002f           })\n\u002f\u002f         }\n\n\u002f\u002f       } else \n      if (state == 'extended') { \u002f\u002fsolo campi estesi\n        item.children.push({\n          id : 'extend_reduce',\n          title : FormatMsg(\"MSG_REDUCED\"),\n          action : 'javascript:' + this.formid + \".reduce()\"\n        })\n\u002f\u002f         if (hiddenInVariantFields) {\n\u002f\u002f           item.children.push({\n\u002f\u002f             id : 'all',\n\u002f\u002f             title : FormatMsg(\"MSG_COMPLETE\"),\n\u002f\u002f             action : 'javascript:' + this.formid + \".showAll()\"\n\u002f\u002f           })\n\u002f\u002f         }\n      } \n      else if (extendedFields) {        \n        item.children.push({\n          id : 'extend_reduce',\n          title : FormatMsg(\"MSG_EXTENDED\"),\n          action : 'javascript:' + this.formid + \".extend()\"\n        })\n      }\n\u002f\u002f         if (hiddenInVariantFields) {\n\u002f\u002f           item.children.push({\n\u002f\u002f             id : 'all',\n\u002f\u002f             title : FormatMsg(\"MSG_COMPLETE\"),\n\u002f\u002f             action : 'javascript:' + this.formid + \".showAll()\"\n\u002f\u002f           })\n\u002f\u002f         }\n\u002f\u002f       }\n      \n      var old = this.HamburgerMenu.GetItem('current_version','versioni');\n      if (old) {\n        this.HamburgerMenu.UpdateItem('current_version',item);\n      } else {\n        this.HamburgerMenu.Append(item,'versioni',0);\n      }      \n    }\n    else {\n      this.HamburgerMenu.Hide();\n    }\n    if (\"none\"!=this.m_cDecoration.Value()){\n      var img=Trim(SPTheme.prmVersionList)||'..\u002fvisualweb\u002fimages\u002fzoom_versions_list.png',frag;\n      if (!this.hideEditToolbar.Value()){\n        frag = document.createDocumentFragment();\n        if (Left(img,1)=='{' && Right(img,1)=='}') {\n          img = JSON.parse(img);\n          var span = document.createElement(\"span\");\n          span.className = \"spMaskParameter_versionhandler\";\n          frag.appendChild(span);\n          LibJavascript.Events.addEvent(span, \"click\", function(e){e.stopPropagation();this.HamburgerMenu.ToggleMenu(span);}.bind(this));\n          span.innerText = String.fromCharCode(img.Char);\n          \u002f\u002fversion = \"\u003cspan class='spMaskParameter_versionhandler' onclick='\"+this.formid+\".HamburgerMenu.OpenMenu(this)' onselectstart='return false;'\u003e\"+String.fromCharCode(img.Char)+\"\u003c\u002fspan\u003e\";\n        } else {\n          var _img = document.createElement(\"img\");\n          _img.className = \"spMaskParameter_versionhandlerimage\";\n          frag.appendChild(_img);\n          _img.src = img;\n          LibJavascript.Events.addEvent(_img, \"click\", function(e){e.stopPropagation();this.HamburgerMenu.ToggleMenu(_img);}.bind(this));\n\u002f\u002f           version = \" \u003cimg class='spMaskParameter_versionhandlerimage' style='cursor:pointer;' src='\"+img+\"' onclick='\"+this.formid+\".HamburgerMenu.OpenMenu(this)' onselectstart='return false;'\u003e\u003c\u002fimg\u003e\";\n        }\n      }\n      customToolbar.title.Value(FormatMsg(this.titleMsg)+' \u003cspan class=\"SubtitleLabel\"\u003e'+(versName=='default'?'':(versName||''))+'\u003c\u002fspan\u003e');\n      if (frag)\n      \tcustomToolbar.title.Ctrltbl.appendChild(frag);\n      \n      if (\"onlytitle\"!=this.m_cDecoration.Value()) {\n        if (this.zoomMode.Value() || this.detailFilterMode.Value()){\n          if (canCustomizeVdm){\n          \tthis.saveToolbar.Append({\n              image:SPTheme.smartEditorSaveImage||'\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fsave.png\",pageContext.getServletContext())%\u003e', \n              action:'javascript:' + this.formid + \".quickSettings()\", \n              title:FormatMsg(\"MSG_SAVE_CONFIG\"),\n              id:'saveFilter'\n            })\n          }\n          if (this.zoomMode.Value()){\n            customToolbar.AppendButton({\n              image:SPTheme.prmApllyFilter || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fapplyfilters.png\",pageContext.getServletContext())%\u003e', \n              action:'javascript:' + this.formid + \".applyFilter()\", \n              title:FormatMsg('RPT_APPLY'),\n              id:'apply'\n            });\n          }\n          else if (this.detailFilterMode.Value()){\n            customToolbar.AppendButton({\n              image:SPTheme.prmPrevious || {\"Char\":\"60635\",\"Color\":\"\",\"FontName\":\"icons8_win10\",\"FontWeight\":\"normal\",\"Size\":\"20\"}, \n              action:'javascript:' + this.formid + \".findDetail(false)\", \n              title:FormatMsg('REPEAT_PREVIOUS'),\n              tooltip:FormatMsg('MSG_ZPDF_SEARCH_PREVIOUS'),\n              id:'prev'\n            });\n            customToolbar.AppendButton({\n              image:SPTheme.prmNext || {\"Char\":\"60530\",\"Color\":\"\",\"FontName\":\"icons8_win10\",\"FontWeight\":\"normal\",\"Size\":\"20\"}, \n              action:'javascript:' + this.formid + \".findDetail(true)\", \n              title:FormatMsg('REPEAT_NEXT'),\n              tooltip:FormatMsg('MSG_ZPDF_SEARCH_NEXT'),\n              id:'next'\n            });\n          }\n          if (!this.hideAddFilterButton.Value()){\n            customToolbar.AppendMenuButton({\n              image:SPTheme.prmAddFilter || ZtVWeb.SPWebRootURL+'\u002fvisualweb\u002fimages\u002fgrid_filters_add.png', \n              action : 'javascript:'+this.formid+'.'+'addFilter()',\n              title:FormatMsg(\"ADMIN_ADD\"),\n              id:'addFilter'\n            })\n          }\n          customToolbar.AppendButton({\n              image:SPTheme.prmAccept || ZtVWeb.SPWebRootURL+'\u002fvisualweb\u002fimages\u002fgrid_filters_add.png', \n              action : 'javascript:'+this.formid+'.'+'saveFilter()',\n              title:FormatMsg(\"RPT_APPLY\"),\n              id:'saveFilter'\n            })\n          customToolbar.toolbar.HideItem('saveFilter');\n          if (!Empty(this.zoomConfigName.Value()) && canSaveVdm\u003e0 && canCustomizeVdm){\n\n            customToolbar.AppendButton({\n              image:SPTheme.smartEditorSaveImage||'\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fsave.png\",pageContext.getServletContext())%\u003e', \n              action:'javascript:' + this.formid + \".saveMask()\", \n              title:FormatMsg(\"MSG_SAVE_CONFIG\"),\n              id:'saveMask'\n            });\n          }\n          customToolbar.AppendMenuButton({\n            image:SPTheme.prmRefresh || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002frefresh.png\",pageContext.getServletContext())%\u003e', \n            action:'javascript:' + this.formid + \".refreshZoom()\", \n            title:FormatMsg(\"MSG_VZM_RESET\"),\n            id:'reset'\n          });\n          if (!Empty(this.ReportName.Value())){\n            customToolbar.AppendButton({\n              image:SPTheme.prmPrint || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fprint.png\",pageContext.getServletContext())%\u003e', \n              action:'javascript:' + this.formid + \".print()\", \n              title:FormatMsg(\"MSG_VZM_PRINT\"),\n              id:'print'\n            });\n          }\n        }\n        else{\n          if (this.BOMode.Value() && this.saveBO.Value()){\n            customToolbar.AppendButton({\n              image:SPTheme.smartEditorSaveImage||'\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fsave.png\",pageContext.getServletContext())%\u003e',\n              action:'javascript:' + this.formid + \".saveBO_Click()\", \n              tooltip:FormatMsg(\"MSG_SAVE_BO\"),\n              title:FormatMsg(\"MSG_SAVE_BO\"),\n              id:'saveBO'\n          \t});\n          }\n\t\t\t\t\tif (!this.HideConfirmButton.Value()){\n            var confirmActionTitle=this.ConfirmActionTitle.Value()||this.formObj.confirmActionTitle||'Ok';\n            var confirmActionTooltip=this.ConfirmActionTooltip.Value()||this.formObj.confirmActionTooltip||FormatMsg(\"MSG_VIEWED\");\n            customToolbar.AppendButton({\n              image:SPTheme.prmAccept || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fok.png\",pageContext.getServletContext())%\u003e', \n              action:'javascript:' + this.formid + \".btn_confirm_Click()\", \n              tooltip:confirmActionTooltip,\n              title:confirmActionTitle,\n              id:'ok'\n            });\n          }\n          if (!this.HideDiscardButton.Value()){\n            \n            var discardActionTitle=this.DiscardActionTitle.Value()||this.formObj.discardActionTitle||FormatMsg(\"MSG_CLOSE_ONEXIT\");\n          \tvar discardActionTooltip=this.DiscardActionTooltip.Value()||this.formObj.discardActionTooltip||FormatMsg(\"MSG_ESC_CLOSE\");\n            \n            customToolbar.AppendButton({\n              image:SPTheme.prmClose || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fclose.png\",pageContext.getServletContext())%\u003e',\n              action:'javascript:' + this.formid + \".btn_discard_Click()\",\n              tooltip:discardActionTooltip,\n              title:discardActionTitle,\n              id:'close'\n            });\n          }\n        }\n      }\n      else if (this.zoomMode.Value() || this.detailFilterMode.Value()){\n        if (!this.hideAddFilterButton.Value()){\n          customToolbar.AppendButton({\n            image:SPTheme.prmAddFilter || ZtVWeb.SPWebRootURL+'\u002fvisualweb\u002fimages\u002fgrid_filters_add.png', \n            action : 'javascript:'+this.formid+'.'+'addFilter()',\n            title:FormatMsg(\"ADMIN_ADD\"),\n            id:'addFilter'\n          })\n        }\n      }\n      if (extendedFields){\n        if (state=='reduced'){ \u002f\u002f da estendere\n          customToolbar.AppendButton({\n            image:SPTheme.prmExtend || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fexpand.png\",pageContext.getServletContext())%\u003e', \n            action:'javascript:' + this.formid + \".extend()\", \n            title:FormatMsg(\"MSG_EXPAND\"),\n            id:'extend_reduce'\n          },this.detailFilterMode.Value()?2:0);\n        }\n        else if (state=='extended'){\n          customToolbar.AppendButton({\n            image:SPTheme.prmReduce || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002freduce.png\",pageContext.getServletContext())%\u003e', \n            action:'javascript:' + this.formid + \".reduce()\", \n            title:FormatMsg(\"MSG_REDUCE\"),\n            id:'extend_reduce'\n          },this.detailFilterMode.Value()?2:0);\n        }\n      }\n      this.drawActions();\n      customToolbar.RearrangeAll();\n      this.HamburgerMenu.Hide();\n    }\n    else {\n    \tthis.hideTitle();\n    }\n    \n  }\n}\n\nfunction updateExtendReduceButton(type){\n  this.getTitlePortlet().CloseMenu();\n  this.HamburgerMenu.CloseMenu();\n  if (type=='extend'){      \n    this.HamburgerMenu.UpdateItem('extend_reduce',{\n      title : FormatMsg(\"MSG_EXTENDED\"),\n      action : 'javascript:' + this.formid + \".extend()\"\n    })    \n    if (this.m_cDecoration.Value()!='none'){\n      this.getTitlePortlet().UpdateButton('extend_reduce',{\n        image:SPTheme.prmExtend || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fexpand.png\",pageContext.getServletContext())%\u003e', \n        action:'javascript:' + this.formid + \".extend()\", \n        title:FormatMsg(\"MSG_EXPAND\")      \n      });\n    }\n  }\n  else{\n    \tthis.HamburgerMenu.UpdateItem('extend_reduce',{\n      \ttitle : FormatMsg(\"MSG_REDUCED\"),\n      \taction : 'javascript:' + this.formid + \".reduce()\"\n    \t})\n    if (this.m_cDecoration.Value()!='none'){\n     \tthis.getTitlePortlet().UpdateButton('extend_reduce',{\n        image:SPTheme.prmReduce || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002freduce.png\",pageContext.getServletContext())%\u003e', \n        action:'javascript:' + this.formid + \".reduce()\", \n        title:FormatMsg(\"MSG_REDUCE\")     \n      });\n    }\n\t}\n   \n}\n\nfunction closeWindow(){\n window.close(); \n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","codemanifest":"{\"codemanifest\":\"\"}","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"formPage.css,portalstudio.css","css_class":"","css_code":"[]","custom":"","description":"Portlet che legge i campi presenti in una configurazione JSON  con estensione VDM e la rappresenta in un portlet.","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"true","grapesCode":"\u003cbody\u003e{{ @HamburgerMenu }}{{ @selectVersionPortlet }}{{ @saveToolbar }}{{ @Textbox67 }}\u003cdiv name=\"Calendario68\" index=\"68\" type=\"Calendario\"\u003eCalendario68\u003c\u002fdiv\u003e\u003cdiv name=\"Tabs69\" index=\"69\" type=\"Tabs\"\u003eTabs69\u003c\u002fdiv\u003e{{ @Calendario70 }}{{ @Tabs69 }}\u003c\u002fbody\u003e","grapesCss":"","h":"30","hsl":"","htmlcode":"{{ @Tabs69 }} \n{{ @Calendario70 }} \n{{ @Textbox67 }} \n{{ @saveToolbar }} \n{{ @selectVersionPortlet }} \n{{ @HamburgerMenu }} \n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ detailFilterMode }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ $entity$_focus }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ ConfigName }}\n{{ Mode }}\n{{ Columns }}\n{{ Width }}\n{{ MaxFieldWidth }}\n{{ splinker }}\n{{ splinkerDiscard }}\n{{ TitleMsg }}\n{{ ConfigObject }}\n{{ $entity$_updateFilters }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_Lights }}\n{{ $entity$_confirm }}\n{{ $entity$_discard }}\n{{ EmitterName }}\n{{ m_cDecoration }}\n{{ $entity$_focus }}\n{{ editMode }}\n{{ OffsetTop }}\n{{ zoomMode }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_filterChanged }}\n{{ $entity$_savedEntity }}\n{{ ReportName }}\n{{ lastFilterChanged }}\n{{ PrintFormat }}\n{{ PrintOrientation }}\n{{ hideEditToolbar }}\n{{ custom }}\n{{ editorMode }}\n{{ showHiddenVariant }}\n{{ showAlwaysHidden }}\n{{ ReceiverName }}\n{{ Table }}\n{{ extended }}\n{{ checkSplinker }}\n{{ checkFunction }}\n{{ OkResource }}\n{{ OkAction }}\n{{ initSplinker }}\n{{ ProgressBar }}\n{{ ProgressBarPortlet }}\n{{ presetParams }}\n{{ hideQueryParameters }}\n{{ disablePresetParams }}\n{{ BOName }}\n{{ PKFields }}\n{{ PKValues }}\n{{ BOMode }}\n{{ saveBO }}\n{{ HideDiscardButton }}\n{{ ConfirmActionTitle }}\n{{ DiscardActionTooltip }}\n{{ ConfirmActionTooltip }}\n{{ DiscardActionTitle }}\n{{ QueryName }}\n{{ offlineMode }}\n{{ HamburgerMenu }}\n{{ confirmSplinker }}\n{{ saveBOSplinker }}\n{{ selectVersionPortlet }}\n{{ zoomConfigName }}\n{{ hideAddFilterButton }}\n{{ closeWhenApplyFilter }}\n{{ saveToolbar }}\n{{ HideConfirmButton }}\n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"","max_w":"","min_w":"","mode":"NORMAL","my_library":"controlsBridge.js,SPMaskParameters.js,Utilities.js,LinkZoomObj.js,\u003c%=sp.isOfflineInstallation(request)?\"spofflineapp\u002fscripts\u002fDataBaseConnection.js\":\"\"%\u003e","offline":"true","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"30\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"true","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"true","title_url":"","type":"Form","v_line":"100","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ConfigName","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"229","y":"-2"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Mode","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"118","y":"23"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Columns","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"numeric","w":"107","x":"229","y":"23"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Width","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"numeric","w":"107","x":"340","y":"23"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"MaxFieldWidth","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"numeric","w":"107","x":"451","y":"23"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"splinker","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"","target":"","type":"SPLinker","w":"30","x":"-34","y":"-68"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"splinkerDiscard","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"","target":"","type":"SPLinker","w":"30","x":"-1","y":"-68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"TitleMsg","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"118","y":"48"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ConfigObject","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"118","y":"-2"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_updateFilters","objsValues":"this.UpdateTempFilters(evt.Filters)","page":"1","parmsNames":"Filters","sequence":"10","type":"EventReceiver","w":"22","x":"312","y":"-44"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_GetConfigurationField","objsValues":"this.SetConfigurationField(evt.Fields)","page":"1","parmsNames":"Filters","sequence":"11","type":"EventReceiver","w":"22","x":"342","y":"-44"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_Lights","objsValues":"this.Lights(evt.fieldName)","page":"1","parmsNames":"fieldName","sequence":"12","type":"EventReceiver","w":"22","x":"372","y":"-44"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_confirm","page":"1","parmsNames":"parametersObj","parmsTypes":"func","parmsValues":"this.getParametersValue()","persistent":"true","sequence":"13","type":"EventEmitter","w":"22","x":"194","y":"-44"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_discard","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"14","type":"EventEmitter","w":"22","x":"221","y":"-44"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"EmitterName","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"451","y":"-2"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cDecoration","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"562","y":"-2"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_focus","page":"1","parmsNames":"field_focus","parmsTypes":"func","parmsValues":"this.getFieldFocus()","persistent":"true","sequence":"17","type":"EventEmitter","w":"22","x":"248","y":"-44"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"editMode","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"340","y":"-2"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"OffsetTop","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"numeric","w":"107","x":"562","y":"22"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"zoomMode","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"229","y":"48"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_zoomSetFilter","page":"1","parmsNames":"row,ignoreFilterMap","parmsTypes":"func,const","parmsValues":"this.getZoomParametersValue(),true","persistent":"true","sequence":"21","type":"EventEmitter","w":"22","x":"280","y":"-44"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_filterChanged","page":"1","parmsNames":"name,value,operator","parmsTypes":"var,func,func","parmsValues":"lastFilterChanged,this.getLastFilterChangedValue(),this.getLastFilterChangedOperator()","persistent":"true","sequence":"22","type":"EventEmitter","w":"22","x":"194","y":"-68"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_savedEntity","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"23","type":"EventEmitter","w":"22","x":"222","y":"-68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ReportName","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"340","y":"48"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"lastFilterChanged","page":"1","reactive":"","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"102","x":"418","y":"-45"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PrintFormat","page":"1","reactive":"","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"451","y":"48"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PrintOrientation","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"562","y":"48"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"hideEditToolbar","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"118","y":"73"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"custom","page":"1","reactive":"","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"229","y":"73"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"editorMode","page":"1","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"340","y":"73"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"showHiddenVariant","page":"1","reactive":"","sequence":"31","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"451","y":"73"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"showAlwaysHidden","page":"1","reactive":"","sequence":"32","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"562","y":"73"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ReceiverName","page":"1","reactive":"","sequence":"33","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"118","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Table","page":"1","reactive":"","sequence":"34","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"229","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"false","init_par":"request","name":"extended","page":"1","reactive":"","sequence":"35","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"340","y":"98"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"function","name":"checkSplinker","offline":"","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"36","servlet":"","target":"","type":"SPLinker","w":"30","x":"31","y":"-68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"checkFunction","page":"1","reactive":"","sequence":"37","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"451","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"OkResource","page":"1","reactive":"","sequence":"38","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"118","y":"124"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"OkAction","page":"1","reactive":"","sequence":"39","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"229","y":"124"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"routine caller","name":"initSplinker","offline":"","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"40","servlet":"","target":"","type":"SPLinker","w":"30","x":"68","y":"-68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ProgressBar","page":"1","reactive":"","sequence":"41","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"340","y":"124"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ProgressBarPortlet","page":"1","reactive":"","sequence":"42","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"340","y":"149"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"presetParams","page":"1","reactive":"","sequence":"43","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"451","y":"148"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"hideQueryParameters","page":"1","reactive":"","sequence":"44","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"562","y":"148"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"disablePresetParams","page":"1","reactive":"","sequence":"45","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"118","y":"176"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"BOName","page":"1","reactive":"","sequence":"46","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"340","y":"176"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PKFields","page":"1","reactive":"","sequence":"47","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"451","y":"175"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PKValues","page":"1","reactive":"","sequence":"48","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"562","y":"174"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"BOMode","page":"1","reactive":"","sequence":"49","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"230","y":"176"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"saveBO","page":"1","reactive":"","sequence":"50","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"118","y":"202"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"HideDiscardButton","page":"1","reactive":"","sequence":"51","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"230","y":"202"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ConfirmActionTitle","page":"1","reactive":"","sequence":"52","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"340","y":"202"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"DiscardActionTooltip","page":"1","reactive":"","sequence":"53","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"118","y":"228"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ConfirmActionTooltip","page":"1","reactive":"","sequence":"54","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"451","y":"200"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"DiscardActionTitle","page":"1","reactive":"","sequence":"55","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"562","y":"200"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"QueryName","page":"1","reactive":"","sequence":"56","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"451","y":"124"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"offlineMode","page":"1","reactive":"","sequence":"57","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"562","y":"124"},{"anchor":"","bg_color":"","class_Css":"SPPortalZoomBaseMenuVersion","color":"","ctrlOfVariant":"","fixed":"","fontSize":"","h":"25","hide":"false","layer":"false","layout_steps_values":"{}","maxsubitemelements":"","name":"HamburgerMenu","page":"1","rapp":"","sequence":"58","spuid":"","type":"HamburgerMenu","visible_handler":"false","w":"25","wireframe_props":"","x":"0","y":"5","zindex":"100","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"routine caller","name":"confirmSplinker","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"59","servlet":"","target":"","type":"SPLinker","w":"30","x":"107","y":"-68"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"write","name":"saveBOSplinker","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"false","refresh":"","sequence":"60","servlet":"","target":"","type":"SPLinker","w":"30","x":"144","y":"-68"},{"anchor":"","ctrlOfVariant":"","fixed":"","h":"10","hide":"false","isoptional":"true","layer":"false","layout_steps_values":"{}","name":"selectVersionPortlet","page":"1","rapp":"","sequence":"61","spuid":"","src":"..\u002fjsp-system\u002fSPSelectVersion_portlet.jsp","themed":"","type":"Portlet","w":"100","wireframe_props":"","x":"0","y":"0","zindex":"3","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"zoomConfigName","page":"1","reactive":"","sequence":"62","server_side":"false","type":"Variable","typevar":"character","w":"107","x":"562","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"hideAddFilterButton","page":"1","reactive":"","sequence":"63","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"118","y":"150"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"closeWhenApplyFilter","page":"1","reactive":"","sequence":"64","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"229","y":"149"},{"FAB":"","anchor":"top-right","bg_color":"","css_class":"custom_toolbar","ctrlOfVariant":"","fixed":"","h":"42","hide":"true","iconWidth":"45","layer":"false","layout_steps_values":"{}","maxToolbarItem":"","menu_bg_color":"","name":"saveToolbar","page":"1","rapp":"","sequence":"65","spuid":"","toolbarAlign":"","type":"SPToolbar","w":"138","wireframe_props":"","x":"-38","y":"45","zindex":"4","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"HideConfirmButton","page":"1","reactive":"","sequence":"66","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"230","y":"228"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"detailFilterMode","page":"1","reactive":"","sequence":"67","server_side":"false","type":"Variable","typevar":"logic","w":"107","x":"340","y":"228"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox67","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"68","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"120","wireframe_props":"name","x":"157","y":"333","zerofilling":"false","zindex":"101","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"90","hide":"true","layer":"false","layout_steps_values":"{}","name":"Calendario70","page":"1","popup":"true","rapp":"","return_input":"Textbox67","sequence":"69","spuid":"","type":"Calendario","w":"120","wireframe_props":"","x":"153","y":"411","zindex":"102","zone":""},{"anchor":"","bg_color":"#FFFFFF","cell_distr":"","class_Css":"","class_Css_selected":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","h":"40","hide":"true","href":"","layer":"false","layout_steps_values":"{}","links":"...","name":"Tabs69","page":"1","rapp":"","selected_color":"","selected_item":"","sequence":"70","shrinkable":"","sp_tabstrip":"true","spuid":"","target":"","type":"Tabs","vertical":"false","vertical_text":"false","w":"120","wireframe_props":"","x":"154","y":"360","zindex":"103","zone":""},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"100","hide":"","layer":"","layout_steps_values":"{}","name":"Note71","page":"1","rapp":"","sequence":"71","spuid":"","type":"Note","value":"Ctrl utilizzati per importare le librerie (manifest)","w":"200","wireframe_props":"","x":"305","y":"333","zindex":"104","zone":""}]%>
<%/*Description:Portlet che legge i campi presenti in una configurazione JSON  con estensione VDM e la rappresenta in un portlet.*/%>
<%/*ParamsRequest:ConfigName,Mode,Columns,Width,MaxFieldWidth,TitleMsg,ConfigObject,EmitterName,m_cDecoration,editMode,OffsetTop,zoomMode,ReportName,PrintFormat,PrintOrientation,hideEditToolbar,custom,editorMode,showHiddenVariant,showAlwaysHidden,ReceiverName,Table,extended,checkFunction,OkResource,OkAction,ProgressBar,ProgressBarPortlet,presetParams,hideQueryParameters,disablePresetParams,BOName,PKFields,PKValues,BOMode,saveBO,HideDiscardButton,ConfirmActionTitle,DiscardActionTooltip,ConfirmActionTooltip,DiscardActionTitle,QueryName,offlineMode,zoomConfigName,hideAddFilterButton,closeWhenApplyFilter,HideConfirmButton,detailFilterMode*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.SPMaskParameters_container {
}
.SPMaskParameters_portlet{
  position:relative;
  width:100%;
  min-width:100px;
  height:30px;
}
.SPMaskParameters_portlet[Data-page="1"]{
  height:30px;
  width:100%;
}
.SPMaskParameters_portlet > .HamburgerMenu_ctrl {
  box-sizing:border-box;
  z-index:100;
  position:absolute;
  display:inline-block;
  top:5px;
  left:0px;
  width:25px;
  height:25px;
}
.SPMaskParameters_portlet .HamburgerMenu_ctrl.global_handler{
  visibility:hidden;
}
.SPMaskParameters_portlet > .selectVersionPortlet_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:100px;
  height:auto;
  min-height:10px;
}
.SPMaskParameters_portlet > .saveToolbar_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:45px;
  right:0px;
  width:138px;
  height:42px;
  display:none;
}
.SPMaskParameters_portlet > .Textbox67_ctrl {
  box-sizing:border-box;
  z-index:101;
  position:absolute;
  display:inline-block;
  top:333px;
  left:157px;
  width:120px;
  height:20px;
  display:none;
}
.SPMaskParameters_portlet > .Textbox67_ctrl {
}
.SPMaskParameters_portlet > .Textbox67_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPMaskParameters_portlet > .Calendario70_ctrl {
  box-sizing:border-box;
  z-index:102;
  position:absolute;
  display:inline-block;
  top:411px;
  left:153px;
  width:120px;
  height:90px;
  display:none;
}
.SPMaskParameters_portlet > .Tabs69_ctrl {
  box-sizing:border-box;
  z-index:103;
  position:absolute;
  display:inline-block;
  top:360px;
  left:154px;
  width:120px;
  height:40px;
  display:none;
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
 String def="[{\"h\":\"30\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"100\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"229\",\"y\":\"-2\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"23\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"229\",\"y\":\"23\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"23\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"23\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"-34\",\"y\":\"-68\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"-1\",\"y\":\"-68\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"48\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"-2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"312\",\"y\":\"-44\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"342\",\"y\":\"-44\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"372\",\"y\":\"-44\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"194\",\"y\":\"-44\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"221\",\"y\":\"-44\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"-2\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"-2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"248\",\"y\":\"-44\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"-2\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"22\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"229\",\"y\":\"48\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"280\",\"y\":\"-44\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"194\",\"y\":\"-68\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"222\",\"y\":\"-68\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"48\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"102\",\"x\":\"418\",\"y\":\"-45\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"48\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"48\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"73\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"229\",\"y\":\"73\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"73\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"73\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"73\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"229\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"98\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"31\",\"y\":\"-68\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"124\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"229\",\"y\":\"124\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"68\",\"y\":\"-68\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"124\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"149\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"148\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"148\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"176\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"176\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"175\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"174\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"230\",\"y\":\"176\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"202\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"230\",\"y\":\"202\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"202\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"228\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"200\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"200\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"451\",\"y\":\"124\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"124\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"HamburgerMenu\",\"w\":\"25\",\"x\":\"0\",\"y\":\"5\",\"zindex\":\"100\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"107\",\"y\":\"-68\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"144\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"3\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"562\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"118\",\"y\":\"150\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"229\",\"y\":\"149\"},{\"anchor\":\"top-right\",\"h\":\"42\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"SPToolbar\",\"w\":\"138\",\"x\":\"-38\",\"y\":\"45\",\"zindex\":\"4\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"230\",\"y\":\"228\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"340\",\"y\":\"228\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox67\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"157\",\"y\":\"333\",\"zindex\":\"101\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"name\":\"Calendario70\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"120\",\"x\":\"153\",\"y\":\"411\",\"zindex\":\"102\"},{\"anchor\":\"\",\"h\":\"40\",\"layout_steps_values\":{},\"name\":\"Tabs69\",\"page\":\"1\",\"type\":\"Tabs\",\"w\":\"120\",\"x\":\"154\",\"y\":\"360\",\"zindex\":\"103\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"Note71\",\"page\":\"1\",\"type\":\"Note\",\"w\":\"200\",\"x\":\"305\",\"y\":\"333\",\"zindex\":\"104\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPMaskParameters","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){
if(sp.isOfflineInstallation(request)){%><%if(Library.Empty(sp.getParameter("m_cSPOfflineApp",""))) {out.println("Empty SPOfflineApp parameter");return; }%><%}%><!DOCTYPE html>
<html <%if(sp.isOfflineInstallation(request)){%> <%=com.zucchetti.spofflineapp.Library.getManifestAttribute( request )%>=<%=sp.getManifestAttributeValue( request )%><%}%>>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPMaskParameters_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, true,false); %><script>
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
.SPMaskParameters_portlet > .saveToolbar_ctrl {
  display:none;
}
.SPMaskParameters_portlet > .Textbox67_ctrl {
  display:none;
}
.SPMaskParameters_portlet > .Calendario70_ctrl {
  display:none;
}
.SPMaskParameters_portlet > .Tabs69_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
<%String variant, variantThemed;%>ZtVWeb.RequireCSS('<%=sp.getSkin()%>/formPage.css');

ZtVWeb.RequireCSS('<%=sp.getSkin()%>/portalstudio.css');

/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("SPMaskParameters.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("Utilities.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>"></script>
<%if (!Library.Empty(sp.isOfflineInstallation(request)?"spofflineapp/scripts/DataBaseConnection.js":"")){%>
<script src="../<%=sp.isOfflineInstallation(request)?"spofflineapp/scripts/DataBaseConnection.js":""%>"></script>
<%}%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPMaskParameters','portletObj',<%if(sp.isOfflineInstallation(request)){%>new ZtVWeb.SPParameterSource().GetInclusionParameter('SPParentObjId', '<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>')<%}else{%>'<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>'<%}%>);
/*JS_MARKER_END*/
</script>
<%String ConfigName=JSPLib.translateXSS(sp.getParameter("ConfigName",""));
String Mode=JSPLib.translateXSS(sp.getParameter("Mode",""));
double Columns=sp.getParameter("Columns",0);
double Width=sp.getParameter("Width",0);
double MaxFieldWidth=sp.getParameter("MaxFieldWidth",0);
String TitleMsg=JSPLib.translateXSS(sp.getParameter("TitleMsg",""));
String ConfigObject=JSPLib.translateXSS(sp.getParameter("ConfigObject",""));
String EmitterName=JSPLib.translateXSS(sp.getParameter("EmitterName",""));
String m_cDecoration=JSPLib.translateXSS(sp.getParameter("m_cDecoration",""));
boolean editMode=sp.getParameter("editMode",false);
double OffsetTop=sp.getParameter("OffsetTop",0);
boolean zoomMode=sp.getParameter("zoomMode",false);
String ReportName=JSPLib.translateXSS(sp.getParameter("ReportName",""));
String lastFilterChanged= "";
String PrintFormat=JSPLib.translateXSS(sp.getParameter("PrintFormat",""));
String PrintOrientation=JSPLib.translateXSS(sp.getParameter("PrintOrientation",""));
boolean hideEditToolbar=sp.getParameter("hideEditToolbar",false);
String custom=JSPLib.translateXSS(sp.getParameter("custom",""));
boolean editorMode=sp.getParameter("editorMode",false);
boolean showHiddenVariant=sp.getParameter("showHiddenVariant",false);
boolean showAlwaysHidden=sp.getParameter("showAlwaysHidden",false);
String ReceiverName=JSPLib.translateXSS(sp.getParameter("ReceiverName",""));
String Table=JSPLib.translateXSS(sp.getParameter("Table",""));
boolean extended=sp.getParameter("extended",false);
String checkFunction=JSPLib.translateXSS(sp.getParameter("checkFunction",""));
String OkResource=JSPLib.translateXSS(sp.getParameter("OkResource",""));
String OkAction=JSPLib.translateXSS(sp.getParameter("OkAction",""));
String ProgressBar=JSPLib.translateXSS(sp.getParameter("ProgressBar",""));
String ProgressBarPortlet=JSPLib.translateXSS(sp.getParameter("ProgressBarPortlet",""));
String presetParams=JSPLib.translateXSS(sp.getParameter("presetParams",""));
boolean hideQueryParameters=sp.getParameter("hideQueryParameters",false);
boolean disablePresetParams=sp.getParameter("disablePresetParams",false);
String BOName=JSPLib.translateXSS(sp.getParameter("BOName",""));
String PKFields=JSPLib.translateXSS(sp.getParameter("PKFields",""));
String PKValues=JSPLib.translateXSS(sp.getParameter("PKValues",""));
boolean BOMode=sp.getParameter("BOMode",false);
boolean saveBO=sp.getParameter("saveBO",false);
boolean HideDiscardButton=sp.getParameter("HideDiscardButton",false);
String ConfirmActionTitle=JSPLib.translateXSS(sp.getParameter("ConfirmActionTitle",""));
String DiscardActionTooltip=JSPLib.translateXSS(sp.getParameter("DiscardActionTooltip",""));
String ConfirmActionTooltip=JSPLib.translateXSS(sp.getParameter("ConfirmActionTooltip",""));
String DiscardActionTitle=JSPLib.translateXSS(sp.getParameter("DiscardActionTitle",""));
String QueryName=JSPLib.translateXSS(sp.getParameter("QueryName",""));
boolean offlineMode=sp.getParameter("offlineMode",false);
if(request.getAttribute("SPMaskParameters_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("HamburgerMenuObj.js")%>'></script>
<%}
String zoomConfigName=JSPLib.translateXSS(sp.getParameter("zoomConfigName",""));
boolean hideAddFilterButton=sp.getParameter("hideAddFilterButton",false);
boolean closeWhenApplyFilter=sp.getParameter("closeWhenApplyFilter",false);
boolean HideConfirmButton=sp.getParameter("HideConfirmButton",false);
boolean detailFilterMode=sp.getParameter("detailFilterMode",false);
double Textbox67= 0;
if(request.getAttribute("SPMaskParameters_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("SPMaskParameters_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPMaskParameters_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='SPMaskParameters_container'>
<form id='<%=idPortlet%>_form' name='<%=idPortlet%>_form' METHOD='POST' style='MARGIN:0' onsubmit='if(window.<%=idPortlet%>.this_OnSubmit)return window.<%=idPortlet%>.this_OnSubmit();'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPMaskParameters_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPMaskParameters','<%=idPortlet%>',false,'');
</script><%}}%>
<input id='<%=idPortlet%>_ConfigName' name='ConfigName' type='hidden'/>
<input id='<%=idPortlet%>_Mode' name='Mode' type='hidden'/>
<input id='<%=idPortlet%>_Columns' name='Columns' type='hidden'/>
<input id='<%=idPortlet%>_Width' name='Width' type='hidden'/>
<input id='<%=idPortlet%>_MaxFieldWidth' name='MaxFieldWidth' type='hidden'/>
<input id='<%=idPortlet%>_TitleMsg' name='TitleMsg' type='hidden'/>
<input id='<%=idPortlet%>_ConfigObject' name='ConfigObject' type='hidden'/>
<input id='<%=idPortlet%>_EmitterName' name='EmitterName' type='hidden'/>
<input id='<%=idPortlet%>_m_cDecoration' name='m_cDecoration' type='hidden'/>
<input id='<%=idPortlet%>_editMode' name='editMode' type='hidden'/>
<input id='<%=idPortlet%>_OffsetTop' name='OffsetTop' type='hidden'/>
<input id='<%=idPortlet%>_zoomMode' name='zoomMode' type='hidden'/>
<input id='<%=idPortlet%>_ReportName' name='ReportName' type='hidden'/>
<input id='<%=idPortlet%>_lastFilterChanged' name='lastFilterChanged' type='hidden'/>
<input id='<%=idPortlet%>_PrintFormat' name='PrintFormat' type='hidden'/>
<input id='<%=idPortlet%>_PrintOrientation' name='PrintOrientation' type='hidden'/>
<input id='<%=idPortlet%>_hideEditToolbar' name='hideEditToolbar' type='hidden'/>
<input id='<%=idPortlet%>_custom' name='custom' type='hidden'/>
<input id='<%=idPortlet%>_editorMode' name='editorMode' type='hidden'/>
<input id='<%=idPortlet%>_showHiddenVariant' name='showHiddenVariant' type='hidden'/>
<input id='<%=idPortlet%>_showAlwaysHidden' name='showAlwaysHidden' type='hidden'/>
<input id='<%=idPortlet%>_ReceiverName' name='ReceiverName' type='hidden'/>
<input id='<%=idPortlet%>_Table' name='Table' type='hidden'/>
<input id='<%=idPortlet%>_extended' name='extended' type='hidden'/>
<input id='<%=idPortlet%>_checkFunction' name='checkFunction' type='hidden'/>
<input id='<%=idPortlet%>_OkResource' name='OkResource' type='hidden'/>
<input id='<%=idPortlet%>_OkAction' name='OkAction' type='hidden'/>
<input id='<%=idPortlet%>_ProgressBar' name='ProgressBar' type='hidden'/>
<input id='<%=idPortlet%>_ProgressBarPortlet' name='ProgressBarPortlet' type='hidden'/>
<input id='<%=idPortlet%>_presetParams' name='presetParams' type='hidden'/>
<input id='<%=idPortlet%>_hideQueryParameters' name='hideQueryParameters' type='hidden'/>
<input id='<%=idPortlet%>_disablePresetParams' name='disablePresetParams' type='hidden'/>
<input id='<%=idPortlet%>_BOName' name='BOName' type='hidden'/>
<input id='<%=idPortlet%>_PKFields' name='PKFields' type='hidden'/>
<input id='<%=idPortlet%>_PKValues' name='PKValues' type='hidden'/>
<input id='<%=idPortlet%>_BOMode' name='BOMode' type='hidden'/>
<input id='<%=idPortlet%>_saveBO' name='saveBO' type='hidden'/>
<input id='<%=idPortlet%>_HideDiscardButton' name='HideDiscardButton' type='hidden'/>
<input id='<%=idPortlet%>_ConfirmActionTitle' name='ConfirmActionTitle' type='hidden'/>
<input id='<%=idPortlet%>_DiscardActionTooltip' name='DiscardActionTooltip' type='hidden'/>
<input id='<%=idPortlet%>_ConfirmActionTooltip' name='ConfirmActionTooltip' type='hidden'/>
<input id='<%=idPortlet%>_DiscardActionTitle' name='DiscardActionTitle' type='hidden'/>
<input id='<%=idPortlet%>_QueryName' name='QueryName' type='hidden'/>
<input id='<%=idPortlet%>_offlineMode' name='offlineMode' type='hidden'/>
<div id='<%=idPortlet%>_HamburgerMenu' class='HamburgerMenu_ctrl SPPortalZoomBaseMenuVersion global_handler closed'></div><div id='<%=idPortlet%>_selectVersionPortlet'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp-system/SPSelectVersion_portlet.jsp?ForcedPortletUID="+idPortlet+"_16nujoe",true);%></div>
<input id='<%=idPortlet%>_zoomConfigName' name='zoomConfigName' type='hidden'/>
<input id='<%=idPortlet%>_hideAddFilterButton' name='hideAddFilterButton' type='hidden'/>
<input id='<%=idPortlet%>_closeWhenApplyFilter' name='closeWhenApplyFilter' type='hidden'/>
<div id='<%=idPortlet%>_saveToolbar' class='disable-selection ctrl_custom_toolbar_container custom_toolbar' >
<div id='<%=idPortlet%>_saveToolbar_openMenuHandlerDiv' class='custom_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_saveToolbar_openMenuHandlerImg' class='custom_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_saveToolbar_listButtons' class='custom_toolbar_listButtons'></div>
</div>
<input id='<%=idPortlet%>_HideConfirmButton' name='HideConfirmButton' type='hidden'/>
<input id='<%=idPortlet%>_detailFilterMode' name='detailFilterMode' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_Textbox67_wrp'><input id='<%=idPortlet%>_Textbox67' name='Textbox67' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox67' inputmode='numeric' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario70' class='calendar' onclick='window.<%=idPortlet%>.Calendario70.PopupCalendar();' style='text-decoration:none;'></a>
 <div id='<%=idPortlet%>_Tabs69' class='Tabs69_ctrl'></div>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>'></script>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
</div>
</form>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPMaskParameters');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ADD",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ADD"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CLOSE_ONEXIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CLOSE_ONEXIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COMPLETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COMPLETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EDIT_VERSION",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EDIT_VERSION"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ESC_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ESC_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXTENDED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXTENDED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FULL_EDITOR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FULL_EDITOR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_REDUCE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_REDUCE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_REDUCED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_REDUCED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SAVE_BO",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SAVE_BO"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SAVE_CONFIG",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SAVE_CONFIG"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STANDARD",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STANDARD"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_TEMP_FILTERS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_TEMP_FILTERS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VIEWED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VIEWED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VZM_PRINT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VZM_PRINT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VZM_RESET",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VZM_RESET"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ZPDF_SEARCH_NEXT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ZPDF_SEARCH_NEXT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ZPDF_SEARCH_PREVIOUS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ZPDF_SEARCH_PREVIOUS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("REPEAT_NEXT",true)+","+JSPLib.ToJSValue(sp.translate("REPEAT_NEXT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("REPEAT_PREVIOUS",true)+","+JSPLib.ToJSValue(sp.translate("REPEAT_PREVIOUS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("RPT_APPLY",true)+","+JSPLib.ToJSValue(sp.translate("RPT_APPLY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("VERSION_NAME",true)+","+JSPLib.ToJSValue(sp.translate("VERSION_NAME"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource = new ZtVWeb.SPParameterSource();<%}%>
var m_cSPPageletId = <%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('PageletId', '<%=JSPLib.ToJSValue(PageletId,false,true)%>');<%}else{%>'<%=JSPLib.ToJSValue(PageletId,false,true)%>';<%}%>
var m_cSPPortletTitleId = <%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('SPPortletTitleId', '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>');<%}else{%>'<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';<%}%>
ZtVWeb.newForm(this,'<%=idPortlet%>','SPMaskParameters',["100"],["30"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},true,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"100","h":"30","title":"","layer":""}]);
this.ConfigName=new ZtVWeb._VC(this,'ConfigName','<%=idPortlet%>_ConfigName','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ConfigName',<%}%>'<%=JSPLib.ToJSValue(ConfigName,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.Mode=new ZtVWeb._VC(this,'Mode','<%=idPortlet%>_Mode','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('Mode',<%}%>'<%=JSPLib.ToJSValue(Mode,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.Columns=new ZtVWeb._VC(this,'Columns','<%=idPortlet%>_Columns','numeric',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('Columns',<%}%><%=Columns%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.Width=new ZtVWeb._VC(this,'Width','<%=idPortlet%>_Width','numeric',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('Width',<%}%><%=Width%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.MaxFieldWidth=new ZtVWeb._VC(this,'MaxFieldWidth','<%=idPortlet%>_MaxFieldWidth','numeric',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('MaxFieldWidth',<%}%><%=MaxFieldWidth%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.splinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":-34,"y":-68});
this.splinker.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.splinkerDiscard=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkerDiscard","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkerDiscard","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":-1,"y":-68});
this.splinkerDiscard.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.TitleMsg=new ZtVWeb._VC(this,'TitleMsg','<%=idPortlet%>_TitleMsg','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('TitleMsg',<%}%>'<%=JSPLib.ToJSValue(TitleMsg,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.ConfigObject=new ZtVWeb._VC(this,'ConfigObject','<%=idPortlet%>_ConfigObject','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ConfigObject',<%}%>'<%=JSPLib.ToJSValue(ConfigObject,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.$entity$_updateFilters=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_updateFilters","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateFilters","objsValues":"this.UpdateTempFilters(evt.Filters)","page":1,"parmsNames":"Filters","type":"EventReceiver","w":22,"x":312,"y":-44});
this.$entity$_GetConfigurationField=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_GetConfigurationField","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_GetConfigurationField","objsValues":"this.SetConfigurationField(evt.Fields)","page":1,"parmsNames":"Filters","type":"EventReceiver","w":22,"x":342,"y":-44});
this.$entity$_Lights=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_Lights","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_Lights","objsValues":"this.Lights(evt.fieldName)","page":1,"parmsNames":"fieldName","type":"EventReceiver","w":22,"x":372,"y":-44});
this.$entity$_confirm=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_confirm","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_confirm","page":1,"parmsNames":"parametersObj","parmsTypes":"func","parmsValues":"this.getParametersValue()","persistent":"true","type":"EventEmitter","w":22,"x":194,"y":-44});
this.$entity$_discard=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_discard","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_discard","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":22,"x":221,"y":-44});
this.EmitterName=new ZtVWeb._VC(this,'EmitterName','<%=idPortlet%>_EmitterName','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('EmitterName',<%}%>'<%=JSPLib.ToJSValue(EmitterName,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.m_cDecoration=new ZtVWeb._VC(this,'m_cDecoration','<%=idPortlet%>_m_cDecoration','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('m_cDecoration',<%}%>'<%=JSPLib.ToJSValue(m_cDecoration,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.$entity$_focus=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_focus","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_focus","page":1,"parmsNames":"field_focus","parmsTypes":"func","parmsValues":"this.getFieldFocus()","persistent":"true","type":"EventEmitter","w":22,"x":248,"y":-44});
this.editMode=new ZtVWeb._VC(this,'editMode','<%=idPortlet%>_editMode','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('editMode',<%}%><%=editMode%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.OffsetTop=new ZtVWeb._VC(this,'OffsetTop','<%=idPortlet%>_OffsetTop','numeric',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('OffsetTop',<%}%><%=OffsetTop%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.zoomMode=new ZtVWeb._VC(this,'zoomMode','<%=idPortlet%>_zoomMode','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('zoomMode',<%}%><%=zoomMode%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.$entity$_zoomSetFilter=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_zoomSetFilter","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_zoomSetFilter","page":1,"parmsNames":"row,ignoreFilterMap","parmsTypes":"func,const","parmsValues":"this.getZoomParametersValue(),true","persistent":"true","type":"EventEmitter","w":22,"x":280,"y":-44});
this.$entity$_filterChanged=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_filterChanged","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_filterChanged","page":1,"parmsNames":"name,value,operator","parmsTypes":"var,func,func","parmsValues":"lastFilterChanged,this.getLastFilterChangedValue(),this.getLastFilterChangedOperator()","persistent":"true","type":"EventEmitter","w":22,"x":194,"y":-68});
this.$entity$_savedEntity=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_savedEntity","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_savedEntity","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":22,"x":222,"y":-68});
this.ReportName=new ZtVWeb._VC(this,'ReportName','<%=idPortlet%>_ReportName','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ReportName',<%}%>'<%=JSPLib.ToJSValue(ReportName,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.lastFilterChanged=new ZtVWeb._VC(this,'lastFilterChanged','<%=idPortlet%>_lastFilterChanged','character','<%=JSPLib.ToJSValue(lastFilterChanged,false,true)%>',false,false);
this.PrintFormat=new ZtVWeb._VC(this,'PrintFormat','<%=idPortlet%>_PrintFormat','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('PrintFormat',<%}%>'<%=JSPLib.ToJSValue(PrintFormat,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.PrintOrientation=new ZtVWeb._VC(this,'PrintOrientation','<%=idPortlet%>_PrintOrientation','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('PrintOrientation',<%}%>'<%=JSPLib.ToJSValue(PrintOrientation,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.hideEditToolbar=new ZtVWeb._VC(this,'hideEditToolbar','<%=idPortlet%>_hideEditToolbar','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('hideEditToolbar',<%}%><%=hideEditToolbar%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.custom=new ZtVWeb._VC(this,'custom','<%=idPortlet%>_custom','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('custom',<%}%>'<%=JSPLib.ToJSValue(custom,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.editorMode=new ZtVWeb._VC(this,'editorMode','<%=idPortlet%>_editorMode','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('editorMode',<%}%><%=editorMode%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.showHiddenVariant=new ZtVWeb._VC(this,'showHiddenVariant','<%=idPortlet%>_showHiddenVariant','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('showHiddenVariant',<%}%><%=showHiddenVariant%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.showAlwaysHidden=new ZtVWeb._VC(this,'showAlwaysHidden','<%=idPortlet%>_showAlwaysHidden','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('showAlwaysHidden',<%}%><%=showAlwaysHidden%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.ReceiverName=new ZtVWeb._VC(this,'ReceiverName','<%=idPortlet%>_ReceiverName','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ReceiverName',<%}%>'<%=JSPLib.ToJSValue(ReceiverName,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.Table=new ZtVWeb._VC(this,'Table','<%=idPortlet%>_Table','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('Table',<%}%>'<%=JSPLib.ToJSValue(Table,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.extended=new ZtVWeb._VC(this,'extended','<%=idPortlet%>_extended','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('extended',<%}%><%=extended%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.checkSplinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_checkSplinker","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"checkSplinker","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":31,"y":-68});
this.checkSplinker.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.checkFunction=new ZtVWeb._VC(this,'checkFunction','<%=idPortlet%>_checkFunction','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('checkFunction',<%}%>'<%=JSPLib.ToJSValue(checkFunction,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.OkResource=new ZtVWeb._VC(this,'OkResource','<%=idPortlet%>_OkResource','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('OkResource',<%}%>'<%=JSPLib.ToJSValue(OkResource,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.OkAction=new ZtVWeb._VC(this,'OkAction','<%=idPortlet%>_OkAction','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('OkAction',<%}%>'<%=JSPLib.ToJSValue(OkAction,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.initSplinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"routine caller","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_initSplinker","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"initSplinker","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":68,"y":-68});
this.initSplinker.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.ProgressBar=new ZtVWeb._VC(this,'ProgressBar','<%=idPortlet%>_ProgressBar','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ProgressBar',<%}%>'<%=JSPLib.ToJSValue(ProgressBar,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.ProgressBarPortlet=new ZtVWeb._VC(this,'ProgressBarPortlet','<%=idPortlet%>_ProgressBarPortlet','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ProgressBarPortlet',<%}%>'<%=JSPLib.ToJSValue(ProgressBarPortlet,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.presetParams=new ZtVWeb._VC(this,'presetParams','<%=idPortlet%>_presetParams','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('presetParams',<%}%>'<%=JSPLib.ToJSValue(presetParams,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.hideQueryParameters=new ZtVWeb._VC(this,'hideQueryParameters','<%=idPortlet%>_hideQueryParameters','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('hideQueryParameters',<%}%><%=hideQueryParameters%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.disablePresetParams=new ZtVWeb._VC(this,'disablePresetParams','<%=idPortlet%>_disablePresetParams','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('disablePresetParams',<%}%><%=disablePresetParams%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.BOName=new ZtVWeb._VC(this,'BOName','<%=idPortlet%>_BOName','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('BOName',<%}%>'<%=JSPLib.ToJSValue(BOName,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.PKFields=new ZtVWeb._VC(this,'PKFields','<%=idPortlet%>_PKFields','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('PKFields',<%}%>'<%=JSPLib.ToJSValue(PKFields,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.PKValues=new ZtVWeb._VC(this,'PKValues','<%=idPortlet%>_PKValues','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('PKValues',<%}%>'<%=JSPLib.ToJSValue(PKValues,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.BOMode=new ZtVWeb._VC(this,'BOMode','<%=idPortlet%>_BOMode','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('BOMode',<%}%><%=BOMode%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.saveBO=new ZtVWeb._VC(this,'saveBO','<%=idPortlet%>_saveBO','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('saveBO',<%}%><%=saveBO%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.HideDiscardButton=new ZtVWeb._VC(this,'HideDiscardButton','<%=idPortlet%>_HideDiscardButton','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('HideDiscardButton',<%}%><%=HideDiscardButton%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.ConfirmActionTitle=new ZtVWeb._VC(this,'ConfirmActionTitle','<%=idPortlet%>_ConfirmActionTitle','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ConfirmActionTitle',<%}%>'<%=JSPLib.ToJSValue(ConfirmActionTitle,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.DiscardActionTooltip=new ZtVWeb._VC(this,'DiscardActionTooltip','<%=idPortlet%>_DiscardActionTooltip','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('DiscardActionTooltip',<%}%>'<%=JSPLib.ToJSValue(DiscardActionTooltip,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.ConfirmActionTooltip=new ZtVWeb._VC(this,'ConfirmActionTooltip','<%=idPortlet%>_ConfirmActionTooltip','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('ConfirmActionTooltip',<%}%>'<%=JSPLib.ToJSValue(ConfirmActionTooltip,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.DiscardActionTitle=new ZtVWeb._VC(this,'DiscardActionTitle','<%=idPortlet%>_DiscardActionTitle','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('DiscardActionTitle',<%}%>'<%=JSPLib.ToJSValue(DiscardActionTitle,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.QueryName=new ZtVWeb._VC(this,'QueryName','<%=idPortlet%>_QueryName','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('QueryName',<%}%>'<%=JSPLib.ToJSValue(QueryName,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.offlineMode=new ZtVWeb._VC(this,'offlineMode','<%=idPortlet%>_offlineMode','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('offlineMode',<%}%><%=offlineMode%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.HamburgerMenu=new ZtVWeb.HamburgerMenuCtrl(this,{"anchor":"top-left","bg_color":"","color":"","css_class":"SPPortalZoomBaseMenuVersion","ctrlid":"<%=idPortlet%>_HamburgerMenu","fontSize":0,"h":25,"hide":"false","layer":false,"layout_steps_values":{},"maxsubitemelements":0,"name":"HamburgerMenu","page":1,"spuid":"","type":"HamburgerMenu","visible_handler":false,"w":25,"x":0,"y":5,"zindex":"100"});
this.confirmSplinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"routine caller","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_confirmSplinker","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"confirmSplinker","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":107,"y":-68});
this.confirmSplinker.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.saveBOSplinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"write","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_saveBOSplinker","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"saveBOSplinker","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":144,"y":-68});
this.saveBOSplinker.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
if(this.selectVersionPortlet=ZtVWeb.getPortletInc('<%=idPortlet%>_selectVersionPortlet')){
this.selectVersionPortlet.setContainer(this,'selectVersionPortlet')
this.selectVersionPortlet_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left","ctrlid":"<%=idPortlet%>_selectVersionPortlet","h":10,"hide":"false","layer":false,"layout_steps_values":{},"name":"selectVersionPortlet","page":1,"portlet_id":"<%=idPortlet%>_16nujoe","spuid":"","type":"Portlet","w":100,"x":0,"y":0,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_selectVersionPortlet').style.display='none';
}
this.zoomConfigName=new ZtVWeb._VC(this,'zoomConfigName','<%=idPortlet%>_zoomConfigName','character',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('zoomConfigName',<%}%>'<%=JSPLib.ToJSValue(zoomConfigName,false,true)%>'<%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.hideAddFilterButton=new ZtVWeb._VC(this,'hideAddFilterButton','<%=idPortlet%>_hideAddFilterButton','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('hideAddFilterButton',<%}%><%=hideAddFilterButton%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.closeWhenApplyFilter=new ZtVWeb._VC(this,'closeWhenApplyFilter','<%=idPortlet%>_closeWhenApplyFilter','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('closeWhenApplyFilter',<%}%><%=closeWhenApplyFilter%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.saveToolbar=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-right","bg_color":"","cssClass":"custom_toolbar","ctrlid":"<%=idPortlet%>_saveToolbar","h":42,"hide":"true","iconWidth":45,"layer":false,"layout_steps_values":{},"maxToolbarItem":0,"menu_bg_color":"","name":"saveToolbar","page":1,"spuid":"","toolbarAlign":"","type":"SPToolbar","w":138,"x":-38,"y":45,"zindex":"4"});
this.HideConfirmButton=new ZtVWeb._VC(this,'HideConfirmButton','<%=idPortlet%>_HideConfirmButton','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('HideConfirmButton',<%}%><%=HideConfirmButton%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.detailFilterMode=new ZtVWeb._VC(this,'detailFilterMode','<%=idPortlet%>_detailFilterMode','logic',<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('detailFilterMode',<%}%><%=detailFilterMode%><%if(sp.isOfflineInstallation(request)){%>)<%}%>,false,false);
this.Textbox67=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox67","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox67","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=Textbox67%>","w":120,"x":157,"y":333,"zerofilling":false,"zindex":"101","zoom":""});
this.Calendario70=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario70','Calendario70',153,411,120,90,'','','top-left','true','Textbox67',{});
this.Tabs69=new ZtVWeb.TabStripControl(this,{"anchor":"top-left","bg_color":"#FFFFFF","cell_distr":"","class_Css":"","class_Css_selected":"","ctrlid":"<%=idPortlet%>_Tabs69","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","h":40,"hide":"true","href":"","layer":false,"layout_steps_values":{},"name":"Tabs69","page":1,"selected_color":"","selected_item":"","shrinkable":"false","sp_tabstrip":true,"spuid":"","target":"","type":"Tabs","vertical":"false","vertical_text":"false","w":120,"x":154,"y":360,"zindex":"103"});
  <%if(sp.isOfflineInstallation(request)){%>
if(m_cSPPageletId){
  <%}%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
  <%if(sp.isOfflineInstallation(request)){%>
}
  <%}%>

}
/*JS_MARKER_END*/
</script>
<%request.setAttribute("SPMaskParameters_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPMaskParameters_Static=function(){
if(typeof this_OnSubmit !='undefined')this.this_OnSubmit=this_OnSubmit;
if(typeof splinker_Executed !='undefined')this.splinker_Executed=splinker_Executed;
if(typeof splinker_Result !='undefined')this.splinker_Result=splinker_Result;
if(typeof splinker_Error !='undefined')this.splinker_Error=splinker_Error;
if(typeof ExecSpLinker !='undefined')this.ExecSpLinker=ExecSpLinker;
if(typeof splinker_ProgressBarFinished !='undefined')this.splinker_ProgressBarFinished=splinker_ProgressBarFinished;
if(typeof fillCustomToolbar !='undefined')this.fillCustomToolbar=fillCustomToolbar;
if(typeof updateExtendReduceButton !='undefined')this.updateExtendReduceButton=updateExtendReduceButton;
if(typeof closeWindow !='undefined')this.closeWindow=closeWindow;
  <%if(sp.isOfflineInstallation(request)){%>
var m_cSPPageletId = this.m_oSPParameterSource.GetInclusionParameter('PageletId', '<%=JSPLib.ToJSValue(PageletId,false,true)%>');
if(m_cSPPageletId){
  <%}%>
this.this_Calc=function(){
  this.PageletCalc();
}
  <%if(sp.isOfflineInstallation(request)){%>
}
  <%}

  int configMode=sp.ZoomConfigMode();
	boolean canCustomizeVdm=sp.CanCustomizeVdm();
%>
var canSaveVdm=<%=configMode%>;
var canCustomizeVdm=<%=canCustomizeVdm%>
this.savinghashparameter = '<%=JSPLib.cmdHash("VisualDinamicMask", request.getSession())%>';
function this_OnSubmit() {
	if (EmptyString(this.splinker.Servlet())) {
		if (this.checkField())
			this.$entity$_confirm.Emit();
	} else if (window.SendData)
		window.SendData('confirm');
	return false;
}
m_cLanguage = '<%=sp.getLanguage()%>';
this.isAdmin =  <%=sp.isAdministrator()%> ;
this.lblVersion = FormatMsg("VERSION_NAME");
this.tempFieldsLbl=FormatMsg("MSG_TEMP_FILTERS");
this.objRequest = {
	 <%
	Enumeration e = sp.getParameters();
	String p,
	sep = "";
	while (e.hasMoreElements()) {
		p = (String)e.nextElement();
		if (p.startsWith("w_")) {
			String campo = JSPLib.Substr(p, 3, p.length() - 2);
			out.print(sep + Library.ToJSValue(campo, "C", 0, 0, true, true) + ":" + Library.ToJSValue(sp.getParameter(p, ""), "C", 0, 0, true, true));
			sep = ",";
		}
	}
	 %>
};
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_EMPTY")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_EMPTY"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_NOTEMPTY")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_CONTAINS")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_STARTS_WITH")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_CURRENTMONTH")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_CURRENTMONTH"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_CURRENTYEAR")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_CURRENTYEAR"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_LASTMONTH")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_LASTMONTH"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_LASTYEAR")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_LASTYEAR"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_LAST30DAYS")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_LAST30DAYS"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_LAST60DAYS")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_LAST60DAYS"))%>');
ZtVWeb.AddTranslation('<%=JSPLib.ToJSValue("MSG_LAST90DAYS")%>', '<%=JSPLib.ToJSValue(sp.translate("MSG_LAST90DAYS"))%>');
drawMask.call(this);
function splinker_Executed(result,cError){
	this.dispatchEvent('Executed', result, cError);
}
function splinker_Result(result) {
	this.dispatchEvent('Result', result);
}
function splinker_Error(cause,result){
	this.dispatchEvent('Error', cause, result);
}
function ExecSpLinker() {
  if(!Empty(this.ProgressBarPortlet.Value()))
    this.splinker.setProgressBarPortlet(this.ProgressBarPortlet.Value());
	this.splinker.Link();
}
function splinker_ProgressBarFinished() {
	this.dispatchEvent('ProgressBarFinished');
}
function fillCustomToolbar(extendedFields,hiddenInVariantFields,state) {      
  var customToolbar=this.getTitlePortlet();
  this.HamburgerMenu.Clean();
  if (this.editMode.Value()){
    this.HamburgerMenu.Hide();
   	var versionName=this.formObj.configName;
	  var idx=this.formObj.configName.lastIndexOf('__')	 
    if (idx!=-1){
	    versionName=Trim(Strtran(versionName.substring(idx+2),'_',' '))
      if (versionName.endsWith('.'+this.Table.Value()))
        versionName='default'
    }
	  else versionName='default';    
		customToolbar.SetTitle(FormatMsg("VERSION_NAME")+" "+versionName);
    
    this.selectVersionPortlet.versionName.Value(versionName)
	  customToolbar.AppendButton({
      image:SPTheme.smartEditorApplyImage || '<%=sp.getThemedImage("../images/custom_toolbar/ok.png",pageContext.getServletContext())%>', 
      action:'javascript:' + this.formid + ".apply()", 
      title:FormatMsg("RPT_APPLY")
    });
	  customToolbar.AppendButton({
      image:SPTheme.smartEditorSaveImage||'<%=sp.getThemedImage("../images/custom_toolbar/save.png",pageContext.getServletContext())%>', 
      action:'javascript:' + this.formid + ".saveMask()", 
      title:FormatMsg("MSG_SAVE_CONFIG")
    });
    customToolbar.AppendButton({
      image:SPTheme.smartEditorDiscardImage || '<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>', 
      action:'javascript:' + this.formid + ".closeWindow()", 
      title:FormatMsg("MSG_CLOSE_ONEXIT")
    });
	  customToolbar.RearrangeAll();
  }
  else {
    if ("none"==this.m_cDecoration.Value()){      
      this.HamburgerMenu.CloseMenu();
      this.HamburgerMenu.Clean();
    }
    else{
       customToolbar.CloseMenu();
       customToolbar.Clean();
       customToolbar.RemoveButton("extend_reduce");       
    }
    
    if (!this.hideEditToolbar.Value()){      
      this.HamburgerMenu.Append({
        id: 'versioni'
      },null,1);
      if (canCustomizeVdm){
        this.HamburgerMenu.Append({
          id : 'smarteditor'
        , title : FormatMsg("MSG_EDIT_VERSION")
        , tooltip : FormatMsg("MSG_EDIT_VERSION")
        , image : SPTheme.prmSmartEditorImage||''
        , action : 'javascript:' + this.formid+".quickSettings()"
        },'versioni',0);
      }
      if (this.isAdmin) {
        this.HamburgerMenu.Append({
          id : 'maskeditor'
        , title : FormatMsg("MSG_FULL_EDITOR")
        , tooltip : FormatMsg("MSG_FULL_EDITOR")
        , image : SPTheme.prmFullEditorImage||''
        , action : 'javascript:' + this.formid+".editMask()"
        },'versioni',1);
      }
      
      var maskName=this.formObj.configName.toLowerCase();
      var idx=maskName.lastIndexOf("__");      
      if (idx!=-1){
        var versionName=maskName.substring(idx)
        if (!versionName.endsWith('.'+this.Table.Value()))
        	maskName=maskName.substring(0,idx);  
      }      
      var url='../servlet/SPVDMProxy?m_cAction=vdmVariant&filter='+maskName;
      this.vdmVersions=eval(new JSURL(url,true).Response());            
      var item = {id:'current_version',children:[],maxsubitems:0, alwaysVisible:true};
      var versName=''
      for (var i=0; i<this.vdmVersions.length; i++){
        this.vdmVersions[i]=this.vdmVersions[i].substring(0,this.vdmVersions[i].length-4).toLowerCase();
        if (this.vdmVersions[i]==this.formObj.configName.toLowerCase()){
          versName=this.vdmVersions[i]==maskName?"default":Strtran(Strtran(this.vdmVersions[i],maskName+"__",""),"_"," ")
        }
          item.children.push({
            title : this.vdmVersions[i]==maskName?"default":Strtran(Strtran(this.vdmVersions[i],maskName+"__",""),"_"," ")
          , action : "javascript:changeVersion("+i+")"
          , highlight : this.vdmVersions[i]==this.formObj.configName.toLowerCase()
          });
      }
      
      
//       if (state == 'all' && !hiddenInVariantFields)
//         state = 'extended';
//       if (state == 'extended' && !extendedFields)
//         state = 'reduced'
//       if (state == 'all') { // campi estesi + nascosti
//         if (extendedFields) {
//           item.children.push({
//             id : 'extend_reduce',
//             title : FormatMsg("MSG_EXTENDED"),
//             action : 'javascript:' + this.formid + ".extend()"
//           })
//           item.children.push({
//             id : 'extend_reduce',
//             title : FormatMsg("MSG_REDUCED"),
//             action : 'javascript:' + this.formid + ".reduce()"
//           })
//         } else {
//           item.children.push({
//             id : 'extend_reduce',
//             title : FormatMsg("MSG_STANDARD"),
//             action : 'javascript:' + this.formid + ".reduce()"
//           })
//         }
//       } else 
      if (state == 'extended') { //solo campi estesi
        item.children.push({
          id : 'extend_reduce',
          title : FormatMsg("MSG_REDUCED"),
          action : 'javascript:' + this.formid + ".reduce()"
        })
//         if (hiddenInVariantFields) {
//           item.children.push({
//             id : 'all',
//             title : FormatMsg("MSG_COMPLETE"),
//             action : 'javascript:' + this.formid + ".showAll()"
//           })
//         }
      } 
      else if (extendedFields) {        
        item.children.push({
          id : 'extend_reduce',
          title : FormatMsg("MSG_EXTENDED"),
          action : 'javascript:' + this.formid + ".extend()"
        })
      }
//         if (hiddenInVariantFields) {
//           item.children.push({
//             id : 'all',
//             title : FormatMsg("MSG_COMPLETE"),
//             action : 'javascript:' + this.formid + ".showAll()"
//           })
//         }
//       }
      
      var old = this.HamburgerMenu.GetItem('current_version','versioni');
      if (old) {
        this.HamburgerMenu.UpdateItem('current_version',item);
      } else {
        this.HamburgerMenu.Append(item,'versioni',0);
      }      
    }
    else {
      this.HamburgerMenu.Hide();
    }
    if ("none"!=this.m_cDecoration.Value()){
      var img=Trim(SPTheme.prmVersionList)||'../visualweb/images/zoom_versions_list.png',frag;
      if (!this.hideEditToolbar.Value()){
        frag = document.createDocumentFragment();
        if (Left(img,1)=='{' && Right(img,1)=='}') {
          img = JSON.parse(img);
          var span = document.createElement("span");
          span.className = "spMaskParameter_versionhandler";
          frag.appendChild(span);
          LibJavascript.Events.addEvent(span, "click", function(e){e.stopPropagation();this.HamburgerMenu.ToggleMenu(span);}.bind(this));
          span.innerText = String.fromCharCode(img.Char);
          //version = "<span class='spMaskParameter_versionhandler' onclick='"+this.formid+".HamburgerMenu.OpenMenu(this)' onselectstart='return false;'>"+String.fromCharCode(img.Char)+"</span>";
        } else {
          var _img = document.createElement("img");
          _img.className = "spMaskParameter_versionhandlerimage";
          frag.appendChild(_img);
          _img.src = img;
          LibJavascript.Events.addEvent(_img, "click", function(e){e.stopPropagation();this.HamburgerMenu.ToggleMenu(_img);}.bind(this));
//           version = " <img class='spMaskParameter_versionhandlerimage' style='cursor:pointer;' src='"+img+"' onclick='"+this.formid+".HamburgerMenu.OpenMenu(this)' onselectstart='return false;'></img>";
        }
      }
      customToolbar.title.Value(FormatMsg(this.titleMsg)+' <span class="SubtitleLabel">'+(versName=='default'?'':(versName||''))+'</span>');
      if (frag)
      	customToolbar.title.Ctrltbl.appendChild(frag);
      
      if ("onlytitle"!=this.m_cDecoration.Value()) {
        if (this.zoomMode.Value() || this.detailFilterMode.Value()){
          if (canCustomizeVdm){
          	this.saveToolbar.Append({
              image:SPTheme.smartEditorSaveImage||'<%=sp.getThemedImage("../images/custom_toolbar/save.png",pageContext.getServletContext())%>', 
              action:'javascript:' + this.formid + ".quickSettings()", 
              title:FormatMsg("MSG_SAVE_CONFIG"),
              id:'saveFilter'
            })
          }
          if (this.zoomMode.Value()){
            customToolbar.AppendButton({
              image:SPTheme.prmApllyFilter || '<%=sp.getThemedImage("../images/custom_toolbar/applyfilters.png",pageContext.getServletContext())%>', 
              action:'javascript:' + this.formid + ".applyFilter()", 
              title:FormatMsg('RPT_APPLY'),
              id:'apply'
            });
          }
          else if (this.detailFilterMode.Value()){
            customToolbar.AppendButton({
              image:SPTheme.prmPrevious || {"Char":"60635","Color":"","FontName":"icons8_win10","FontWeight":"normal","Size":"20"}, 
              action:'javascript:' + this.formid + ".findDetail(false)", 
              title:FormatMsg('REPEAT_PREVIOUS'),
              tooltip:FormatMsg('MSG_ZPDF_SEARCH_PREVIOUS'),
              id:'prev'
            });
            customToolbar.AppendButton({
              image:SPTheme.prmNext || {"Char":"60530","Color":"","FontName":"icons8_win10","FontWeight":"normal","Size":"20"}, 
              action:'javascript:' + this.formid + ".findDetail(true)", 
              title:FormatMsg('REPEAT_NEXT'),
              tooltip:FormatMsg('MSG_ZPDF_SEARCH_NEXT'),
              id:'next'
            });
          }
          if (!this.hideAddFilterButton.Value()){
            customToolbar.AppendMenuButton({
              image:SPTheme.prmAddFilter || ZtVWeb.SPWebRootURL+'/visualweb/images/grid_filters_add.png', 
              action : 'javascript:'+this.formid+'.'+'addFilter()',
              title:FormatMsg("ADMIN_ADD"),
              id:'addFilter'
            })
          }
          customToolbar.AppendButton({
              image:SPTheme.prmAccept || ZtVWeb.SPWebRootURL+'/visualweb/images/grid_filters_add.png', 
              action : 'javascript:'+this.formid+'.'+'saveFilter()',
              title:FormatMsg("RPT_APPLY"),
              id:'saveFilter'
            })
          customToolbar.toolbar.HideItem('saveFilter');
          if (!Empty(this.zoomConfigName.Value()) && canSaveVdm>0 && canCustomizeVdm){
            customToolbar.AppendButton({
              image:SPTheme.smartEditorSaveImage||'<%=sp.getThemedImage("../images/custom_toolbar/save.png",pageContext.getServletContext())%>', 
              action:'javascript:' + this.formid + ".saveMask()", 
              title:FormatMsg("MSG_SAVE_CONFIG"),
              id:'saveMask'
            });
          }
          customToolbar.AppendMenuButton({
            image:SPTheme.prmRefresh || '<%=sp.getThemedImage("../images/custom_toolbar/refresh.png",pageContext.getServletContext())%>', 
            action:'javascript:' + this.formid + ".refreshZoom()", 
            title:FormatMsg("MSG_VZM_RESET"),
            id:'reset'
          });
          if (!Empty(this.ReportName.Value())){
            customToolbar.AppendButton({
              image:SPTheme.prmPrint || '<%=sp.getThemedImage("../images/custom_toolbar/print.png",pageContext.getServletContext())%>', 
              action:'javascript:' + this.formid + ".print()", 
              title:FormatMsg("MSG_VZM_PRINT"),
              id:'print'
            });
          }
        }
        else{
          if (this.BOMode.Value() && this.saveBO.Value()){
            customToolbar.AppendButton({
              image:SPTheme.smartEditorSaveImage||'<%=sp.getThemedImage("../images/custom_toolbar/save.png",pageContext.getServletContext())%>',
              action:'javascript:' + this.formid + ".saveBO_Click()", 
              tooltip:FormatMsg("MSG_SAVE_BO"),
              title:FormatMsg("MSG_SAVE_BO"),
              id:'saveBO'
          	});
          }
					if (!this.HideConfirmButton.Value()){
            var confirmActionTitle=this.ConfirmActionTitle.Value()||this.formObj.confirmActionTitle||'Ok';
            var confirmActionTooltip=this.ConfirmActionTooltip.Value()||this.formObj.confirmActionTooltip||FormatMsg("MSG_VIEWED");
            customToolbar.AppendButton({
              image:SPTheme.prmAccept || '<%=sp.getThemedImage("../images/custom_toolbar/ok.png",pageContext.getServletContext())%>', 
              action:'javascript:' + this.formid + ".btn_confirm_Click()", 
              tooltip:confirmActionTooltip,
              title:confirmActionTitle,
              id:'ok'
            });
          }
          if (!this.HideDiscardButton.Value()){
            
            var discardActionTitle=this.DiscardActionTitle.Value()||this.formObj.discardActionTitle||FormatMsg("MSG_CLOSE_ONEXIT");
          	var discardActionTooltip=this.DiscardActionTooltip.Value()||this.formObj.discardActionTooltip||FormatMsg("MSG_ESC_CLOSE");
            
            customToolbar.AppendButton({
              image:SPTheme.prmClose || '<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>',
              action:'javascript:' + this.formid + ".btn_discard_Click()",
              tooltip:discardActionTooltip,
              title:discardActionTitle,
              id:'close'
            });
          }
        }
      }
      else if (this.zoomMode.Value() || this.detailFilterMode.Value()){
        if (!this.hideAddFilterButton.Value()){
          customToolbar.AppendButton({
            image:SPTheme.prmAddFilter || ZtVWeb.SPWebRootURL+'/visualweb/images/grid_filters_add.png', 
            action : 'javascript:'+this.formid+'.'+'addFilter()',
            title:FormatMsg("ADMIN_ADD"),
            id:'addFilter'
          })
        }
      }
      if (extendedFields){
        if (state=='reduced'){ // da estendere
          customToolbar.AppendButton({
            image:SPTheme.prmExtend || '<%=sp.getThemedImage("../images/custom_toolbar/expand.png",pageContext.getServletContext())%>', 
            action:'javascript:' + this.formid + ".extend()", 
            title:FormatMsg("MSG_EXPAND"),
            id:'extend_reduce'
          },this.detailFilterMode.Value()?2:0);
        }
        else if (state=='extended'){
          customToolbar.AppendButton({
            image:SPTheme.prmReduce || '<%=sp.getThemedImage("../images/custom_toolbar/reduce.png",pageContext.getServletContext())%>', 
            action:'javascript:' + this.formid + ".reduce()", 
            title:FormatMsg("MSG_REDUCE"),
            id:'extend_reduce'
          },this.detailFilterMode.Value()?2:0);
        }
      }
      this.drawActions();
      customToolbar.RearrangeAll();
      this.HamburgerMenu.Hide();
    }
    else {
    	this.hideTitle();
    }
    
  }
}
function updateExtendReduceButton(type){
  this.getTitlePortlet().CloseMenu();
  this.HamburgerMenu.CloseMenu();
  if (type=='extend'){      
    this.HamburgerMenu.UpdateItem('extend_reduce',{
      title : FormatMsg("MSG_EXTENDED"),
      action : 'javascript:' + this.formid + ".extend()"
    })    
    if (this.m_cDecoration.Value()!='none'){
      this.getTitlePortlet().UpdateButton('extend_reduce',{
        image:SPTheme.prmExtend || '<%=sp.getThemedImage("../images/custom_toolbar/expand.png",pageContext.getServletContext())%>', 
        action:'javascript:' + this.formid + ".extend()", 
        title:FormatMsg("MSG_EXPAND")      
      });
    }
  }
  else{
    	this.HamburgerMenu.UpdateItem('extend_reduce',{
      	title : FormatMsg("MSG_REDUCED"),
      	action : 'javascript:' + this.formid + ".reduce()"
    	})
    if (this.m_cDecoration.Value()!='none'){
     	this.getTitlePortlet().UpdateButton('extend_reduce',{
        image:SPTheme.prmReduce || '<%=sp.getThemedImage("../images/custom_toolbar/reduce.png",pageContext.getServletContext())%>', 
        action:'javascript:' + this.formid + ".reduce()", 
        title:FormatMsg("MSG_REDUCE")     
      });
    }
	}
   
}
function closeWindow(){
 window.close(); 
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPMaskParameters_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_$entity$_updateFilters=function(parmsObj){<%=idPortlet%>.$entity$_updateFilters.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_$entity$_GetConfigurationField=function(parmsObj){<%=idPortlet%>.$entity$_GetConfigurationField.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_$entity$_Lights=function(parmsObj){<%=idPortlet%>.$entity$_Lights.receiveFnc(parmsObj);}
window.<%=idPortlet%>.$entity$_confirm.setParms();
window.<%=idPortlet%>.$entity$_discard.setParms();
window.<%=idPortlet%>.$entity$_focus.setParms();
window.<%=idPortlet%>.$entity$_zoomSetFilter.setParms();
window.<%=idPortlet%>.$entity$_filterChanged.setParms();
window.<%=idPortlet%>.$entity$_savedEntity.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPMaskParameters',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPMaskParameters');
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
sp.endPage("SPMaskParameters");
}%>
<%! public String getJSPUID() { return "2600266086"; } %>