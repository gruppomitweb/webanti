<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  if (!Empty(this.docunico.Value())) {\n    this.image1.Hide();\n    this.image2.Hide();\n    this.image3.Hide();  \n    this.image4.Hide();  \n    this.image5.Hide();  \n    this.image6.Hide();      \n  } else {\n    if (!Empty(this.doc1.Value()) || !Empty(this.doc2.Value()) || !Empty(this.doc3.Value()) || !Empty(this.doc4.Value()) || !Empty(this.doc5.Value()) || !Empty(this.doc6.Value())) {\n      this.image0.Hide();            \n    }      \n  }  \n  this.ticket.Value(iif(Empty(this.aIDTicket.Value()),this.rIDTicket.Value(),this.aIDTicket.Value()))\n  this.ViewDocuments();  \n  this.ViewBottoni();  \n  this.ExistingDoc();\n  this.mDirectory.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=mDirectory');\n}\n\n\nfunction BtnSave_Click(){\n  if (confirm(\"Confermi il caricamento dei documenti?\")) {\n    _esito=this.RTLoadDoc.Link()\n    if (Left(_esito,1)==\"S\") {\n      alert('Documenti salvati correttamente')\n      DocUpdated(Right(_esito,1))\n      this.Query1.Query();\n      this.allegatiRefresh.Emit();\n    }\n    if (Left(_esito,1)==\"N\") {\n      if (Right(_esito,1)=='C') {\n        alert('Problemi nel collegamento al server di documentazione.Contattare HelpDesk!')              \n      } else {  \n        alert('Problemi nel salvataggio dei documenti. Contattare HelpDesk!')      \n      }  \n    }  \n    if (Left(_esito,1)==\"X\") {\n      if (Right(_esito,1)=='S') {\n        DocUpdated(Right(_esito,1))\n        this.allegatiRefresh.Emit();        \n      } \n      if (Right(_esito,1)=='Z') {\n        alert('Mancano alcuni documenti. Contattare Helpdesk!');        \n      } else {\n        alert('Non ci sono nuovi file da caricare!');        \n      }  \n    }      \n  }    \n}\n\nfunction image0_Click(){\n  \u002f\u002f funzione di upload file\n  this.RTUpload.Link()\n  this.org.Value(0)\n}\n\nfunction image1_Click(){  \n  \u002f\u002f funzione di upload file\n  this.org.Value(1)  \n  this.RTUpload.Link()\n}\n\nfunction image2_Click(){\n  \u002f\u002f funzione di upload file\n  this.org.Value(2)  \n  this.RTUpload.Link()\n}\n\nfunction image3_Click(){\n  this.org.Value(3)  \n  \u002f\u002f funzione di upload file    \n  this.RTUpload.Link()\n}\n\nfunction image4_Click(){\n  \u002f\u002f funzione di upload file\n  this.org.Value(4)  \n  this.RTUpload.Link()\n}\n\nfunction image5_Click(){\n  \u002f\u002f funzione di upload file\n  this.org.Value(5)  \n  this.RTUpload.Link()\n}\n\nfunction image6_Click(){\n  \u002f\u002f funzione di upload file  \n  this.org.Value(6)  \n  this.RTUpload.Link()\n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n  _esito=this.RTVerify.Link()  \n  if (_esito=='OK') {\n    if (this.org.Value()==0) {\n      this.docunico.Value(this.nomefile.Value())\n      this.old0.Value('N');      \n      this.doc1.Value('')\n      this.doc2.Value('')\n      this.doc3.Value('')\n      this.doc4.Value('')\n      this.doc5.Value('')\n      this.doc6.Value('')\n  \t\tthis.image1.Hide();\n  \t\tthis.image2.Hide();\n  \t\tthis.image3.Hide();  \n  \t\tthis.image4.Hide();  \n  \t\tthis.image5.Hide();  \n  \t\tthis.image6.Hide();        \n    }  \n    if (this.org.Value()==1) {\n      this.doc1.Value(this.nomefile.Value())\n      this.old1.Value('N');\n      this.docunico.Value('')\n      this.image0.Hide();  \n    }  \n    if (this.org.Value()==2) {\n      this.doc2.Value(this.nomefile.Value())\n      this.old2.Value('N');      \n      this.docunico.Value('')\n      this.image0.Hide();            \n    }  \n    if (this.org.Value()==3) {\n      this.doc3.Value(this.nomefile.Value())\n      this.old3.Value('N');      \n      this.docunico.Value('')   \n      this.image0.Hide();            \n    }  \n    if (this.org.Value()==4) {\n      this.doc4.Value(this.nomefile.Value())\n      this.old4.Value('N');  \n      this.docunico.Value('')\n      this.image0.Hide();            \n    }  \n    if (this.org.Value()==5) {\n      this.doc5.Value(this.nomefile.Value())\n      this.old5.Value('N');  \n      this.docunico.Value('')      \n      this.image0.Hide();            \n    }  \n    if (this.org.Value()==6) {\n      this.doc6.Value(this.nomefile.Value())\n      this.old6.Value('N');  \n      this.docunico.Value('')      \n      this.image0.Hide();            \n    }\n  } else {\n    alert(_esito)\n  }  \n  this.ViewDocuments();\n  this.ViewBottoni();    \n}\n\nfunction Calculate(_id,_tg,_imp,_cont,_full,_doc1,_doc2,_idticket) {\n  this.aID.Value(_id);\n  this.aTG.Value(_tg);\n  this.aImporto.Value(_imp);\n  this.aContanti.Value(_cont);\n  this.aFull.Value(_full);\n  this.w_idpratica.Value(_id);\n  this.pTG.Value(_tg);\n  this.pImporto.Value(_imp);\n  this.pContanti.Value(_cont);\n  this.pFull.Value(_full);\n  if (Empty(this.doc3.Value())) {\n    this.doc3.Value(_doc1);\n    this.old3.Value('N');          \n  }\n  if (Empty(this.doc4.Value())) {\n    this.doc4.Value(_doc2);\n    this.old4.Value('N');          \n  }\n  this.aIDTicket.Value(_idticket);\n  this.ticket.Value(_idticket);\n  this.ViewDocuments();\n  this.ViewBottoni();  \n}  \n\nfunction View00_Click(){\n  this.filename.Value(this.docunico.Value());\n  this.DocView()\n}\n\nfunction View01_Click(){\n  this.filename.Value(this.doc1.Value());\n  this.DocView()\n}\n\nfunction View02_Click(){\n  this.filename.Value(this.doc2.Value());\n  this.DocView()\n}\n\nfunction View03_Click(){\n  this.filename.Value(this.doc3.Value());\n  this.DocView()\n}\n\nfunction View04_Click(){\n  this.filename.Value(this.doc4.Value());\n  this.DocView()\n}\n\nfunction View05_Click(){\n  this.filename.Value(this.doc5.Value());\n  this.DocView()\n}\n\nfunction View06_Click(){\n  this.filename.Value(this.doc6.Value());\n  this.DocView()\n}\n\nfunction DocView() {\n  if(this.gdoc.Value()=='S') {\n    if (this.gBrowser.Value()=='I') {\n      var stile = \"top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no resizable=yes\";  \n    } else {\n      var stile = \"top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no\";  \n    }   \n    _fileout=this.RTCatchFile.Link();\n    window.open(_fileout,\"\",stile);    \n  } else {\n    this.RTViewDoc.Link()\n  }  \n}  \n\nfunction ViewDocuments() {\n  _attivi=this.RTActivate.Link();\n  this.attivi.Value(_attivi)\n  if (Substr(_attivi,1,1)=='S') {\n    this.lblDoc1.Show();    \n    this.doc1.Show();\n    this.View01.Show();\n    if (this.pFull.Value() != 'S') {\n      this.image1.Show()                    \n    } else {  \n      this.image1.Hide()                    \n    }  \n  } else {\n    this.lblDoc1.Hide();\n    this.doc1.Hide();\n    this.View01.Hide();\n    this.image1.Hide()\n  }  \n  if (Substr(_attivi,2,1)=='S') {\n    this.lblDoc2.Show();    \n    this.doc2.Show();\n    this.View02.Show();\n    if (this.pFull.Value() != 'S') {\n      this.image2.Show()              \n    } else {  \n      this.image2.Hide()                    \n    }  \n  } else {\n    this.lblDoc2.Hide();\n    this.doc2.Hide();\n    this.View02.Hide();\n    this.image2.Hide()\n  }    \n  if (Substr(_attivi,3,1)=='S') {\n    this.lblDoc3.Show();    \n    this.doc3.Show();\n    this.View03.Show();\n    if (this.pFull.Value() != 'S') {\n      this.image3.Show()              \n    } else {  \n      this.image3.Hide()                    \n    }  \n  } else {\n    this.lblDoc3.Hide();\n    this.doc3.Hide();\n    this.View03.Hide();\n    this.image3.Hide()\n  }    \n  if (Substr(_attivi,4,1)=='S') {\n    this.lblDoc4.Show();    \n    this.doc4.Show();\n    this.View04.Show();\n    if (this.pFull.Value() != 'S') {\n      this.image4.Show()              \n    } else {  \n      this.image4.Hide()                    \n    }  \n  } else {\n    this.lblDoc4.Hide();\n    this.doc4.Hide();\n    this.View04.Hide();\n    this.image4.Hide()\n  }    \n  if (Substr(_attivi,5,1)=='S') {\n    this.lblDoc5.Show();    \n    this.doc5.Show();\n    this.View05.Show();\n    if (this.pFull.Value() != 'S') {\n      this.image5.Show()              \n    } else {  \n      this.image5.Hide()                    \n    }  \n  } else {\n    this.lblDoc5.Hide();\n    this.doc5.Hide();\n    this.View05.Hide();\n    this.image5.Hide()\n  }  \n  if (Substr(_attivi,6,1)=='S') {\n    this.lblDoc6.Show();    \n    this.doc6.Show();\n    this.View06.Show();\n    if (this.pFull.Value() != 'S') {\n      this.image6.Show()              \n    } else {  \n      this.image6.Hide()                    \n    }  \n  } else {\n    this.lblDoc6.Hide();\n    this.doc6.Hide();\n    this.View06.Hide();\n    this.image6.Hide()\n  }    \n}  \n\n\nfunction ViewBottoni() {\n  if (Empty(this.docunico.Value())) {\n    this.View00.Hide()  \n  } else {\n    this.View00.Show()\n  }\n  if (Empty(this.doc1.Value())) {\n    this.View01.Hide()  \n  } else {\n    this.View01.Show()\n  } \n  if (Empty(this.doc2.Value())) {\n    this.View02.Hide()  \n  } else {\n    this.View02.Show()\n  } \n  if (Empty(this.doc3.Value())) {\n    this.View03.Hide()  \n  } else {\n    this.View03.Show()\n  } \n  if (Empty(this.doc4.Value())) {\n    this.View04.Hide()  \n  } else {\n    this.View04.Show()\n  } \n  if (Empty(this.doc5.Value())) {\n    this.View05.Hide()  \n  } else {\n    this.View05.Show()\n  } \n  if (Empty(this.doc6.Value())) {\n    this.View06.Hide()  \n  } else {\n    this.View06.Show()\n  }   \n}  \n\nfunction ExistingDoc(){\n  if (!Empty(this.docunico.Value())) {\n    this.old0.Value('S');\n  }\n  if (!Empty(this.doc1.Value())) {\n    this.old1.Value('S');\n  }\n  if (!Empty(this.doc2.Value())) {\n    this.old2.Value('S');\n  }\n  if (!Empty(this.doc3.Value())) {\n    this.old3.Value('S');\n  }\n  if (!Empty(this.doc4.Value())) {\n    this.old4.Value('S');\n  }\n  if (!Empty(this.doc5.Value())) {\n    this.old5.Value('S');\n  }\n  if (!Empty(this.doc6.Value())) {\n    this.old6.Value('S');\n  }\n} ","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"","htmlcode":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @BtnSave }}\n{{ @View06 }}\n{{ @View01 }}\n{{ @View05 }}\n{{ @View02 }}\n{{ @View03 }}\n{{ @View04 }}\n{{ @View00 }}\n{{ @image6 }}\n{{ @image1 }}\n{{ @image5 }}\n{{ @image2 }}\n{{ @image3 }}\n{{ @image4 }}\n{{ @image0 }}\n\n{{ @Box7 }}\n{{ @lblDoc6 }}\n{{ @lblDoc1 }}\n{{ @lblDoc5 }}\n{{ @lblDoc2 }}\n{{ @lblDoc3 }}\n{{ @lblDoc4 }}\n{{ @label6 }}\n{{ @doc6 }}\n{{ @doc1 }}\n{{ @doc5 }}\n{{ @doc2 }}\n{{ @doc3 }}\n{{ @doc4 }}\n{{ @docunico }}\n\n\n\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"790","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"1","name":"Query1","offline":"false","page":"1","parms":"pDCNUMOPE=w_idpratica","parms_source":"","query":"qbe_cgo_docope","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"147","x":"1100","y":"164"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"Root=mRoot,Directory=mDirectory","popup":"true","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":"","refresh":"","sequence":"2","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"147","x":"1100","y":"68"},{"allowedentities":"arfn_verify_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTVerify","offline":"false","page":"1","parms":"pTipo=org,pNomeDoc=nomefile,pTipoGioco=pTG,pImpTick=pImporto,pImpCont=pContanti,pCodDip=pCodDip","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"3","servlet":"arfn_verify_doc","target":"","type":"SPLinker","w":"147","x":"1100","y":"92"},{"allowedentities":"arfn_catchfile","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTCatchFile","offline":"false","page":"1","parms":"pID=w_idpratica,pFile=filename,pTipo=V,pCodDip=pCodDip","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"4","servlet":"arfn_catchfile","target":"","type":"SPLinker","w":"147","x":"1100","y":"116"},{"allowedentities":"arfn_activate_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTActivate","offline":"false","page":"1","parms":"pGioco=pTG,pTotale=pImporto,pContanti=pContanti","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"5","servlet":"arfn_activate_doc","target":"","type":"SPLinker","w":"147","x":"1100","y":"140"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'\u002f'","name":"mRoot","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"190"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"164"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"mDirectory","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"896","y":"164"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"org","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"numeric","w":"76","x":"806","y":"190"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gBrowser","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"214"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gCodDip","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"896","y":"214"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DCDOCUNICO","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"80","name":"docunico","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"574","wireframe_props":"name","x":"169","y":"11","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DCDOCNOM4","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"80","name":"doc4","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"574","wireframe_props":"name","x":"169","y":"54","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DCDOCNOM3","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"80","name":"doc3","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"574","wireframe_props":"name","x":"169","y":"87","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DCDOCNOM2","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"80","name":"doc2","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"574","wireframe_props":"name","x":"169","y":"120","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DCDOCNOM5","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"80","name":"doc5","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"574","wireframe_props":"name","x":"169","y":"153","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DCDOCNOM1","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"80","name":"doc1","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"574","wireframe_props":"name","x":"169","y":"186","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DCDOCNOM6","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"80","name":"doc6","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"18","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"574","wireframe_props":"name","x":"169","y":"219","zerofilling":"false","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"mFileName","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"140"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label6","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Doc. Unico:","w":"97","wireframe_props":"align,value,n_col","x":"69","y":"15","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDoc4","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Documento di Identità:","w":"124","wireframe_props":"align,value,n_col","x":"42","y":"58","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDoc3","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice Fiscale:","w":"97","wireframe_props":"align,value,n_col","x":"69","y":"91","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDoc2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"23","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Biglietto\u002fTicket:","w":"97","wireframe_props":"align,value,n_col","x":"69","y":"124","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDoc5","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Mezzo di Pagamento:","w":"124","wireframe_props":"align,value,n_col","x":"42","y":"157","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDoc1","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"25","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Modulo Identificazione Cliente:","w":"166","wireframe_props":"align,value,n_col","x":"0","y":"190","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDoc6","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Obbligazione:","w":"97","wireframe_props":"align,value,n_col","x":"69","y":"223","zindex":"1"},{"anchor":"","bg_color":"#FFFFFF","border_color":"#000000","border_weight":"1","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"2","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box7","page":"1","sequence":"27","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"790","wireframe_props":"","x":"0","y":"44","zindex":"0"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image0","page":"1","path_type":"","sequence":"28","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"745","y":"13","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image4","page":"1","path_type":"","sequence":"29","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"745","y":"56","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image3","page":"1","path_type":"","sequence":"30","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"745","y":"89","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image2","page":"1","path_type":"","sequence":"31","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"745","y":"122","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image5","page":"1","path_type":"","sequence":"32","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"745","y":"155","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image1","page":"1","path_type":"","sequence":"33","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"745","y":"188","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image6","page":"1","path_type":"","sequence":"34","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"745","y":"221","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"View00","page":"1","path_type":"","sequence":"35","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"763","y":"13","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"View04","page":"1","path_type":"","sequence":"36","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"763","y":"56","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"View03","page":"1","path_type":"","sequence":"37","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"763","y":"89","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"View02","page":"1","path_type":"","sequence":"38","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"763","y":"122","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"View05","page":"1","path_type":"","sequence":"39","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"763","y":"155","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"View01","page":"1","path_type":"","sequence":"40","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"763","y":"188","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"View06","page":"1","path_type":"","sequence":"41","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"763","y":"221","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","help_tips":"Conferma i documenti inseriti","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"BtnSave","page":"1","path_type":"","sequence":"42","server_side":"","spuid":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"43","wireframe_props":"","x":"377","y":"246","zindex":"1"},{"allowedentities":"arfn_confirm_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTLoadDoc","offline":"false","page":"1","parms":"pID=w_idpratica,pTipo=pOrigine,pDocUnico=docunico,pDoc1=doc1,pDoc2=doc2,pDoc3=doc3,pDoc4=doc4,pDoc5=doc5,pDoc6=doc6,pOld0=old0,pOld1=old1,pOld2=old2,pOld3=old3,pOld4=old4,pOld5=old5,pOld6=old6,pAttivi=attivi,pTicket=ticket,pCodDip=pCodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"43","servlet":"arfn_confirm_doc","target":"","type":"SPLinker","w":"147","x":"1100","y":"44"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"allegatiRefresh","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"44","type":"EventEmitter","w":"147","x":"1100","y":"20"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DCDOCNEW0","h":"20","init":"","init_par":"","name":"old0","page":"1","reactive":"","sequence":"45","server_side":"false","type":"Variable","typevar":"character","w":"28","x":"528","y":"249"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DCDOCNEW1","h":"20","init":"","init_par":"","name":"old1","page":"1","reactive":"","sequence":"46","server_side":"false","type":"Variable","typevar":"character","w":"28","x":"559","y":"249"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DCDOCNEW2","h":"20","init":"","init_par":"","name":"old2","page":"1","reactive":"","sequence":"47","server_side":"false","type":"Variable","typevar":"character","w":"28","x":"596","y":"249"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DCDOCNEW3","h":"20","init":"","init_par":"","name":"old3","page":"1","reactive":"","sequence":"48","server_side":"false","type":"Variable","typevar":"character","w":"28","x":"628","y":"249"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DCDOCNEW4","h":"20","init":"","init_par":"","name":"old4","page":"1","reactive":"","sequence":"49","server_side":"false","type":"Variable","typevar":"character","w":"28","x":"658","y":"249"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DCDOCNEW5","h":"20","init":"","init_par":"","name":"old5","page":"1","reactive":"","sequence":"50","server_side":"false","type":"Variable","typevar":"character","w":"28","x":"691","y":"249"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DCDOCNEW6","h":"20","init":"","init_par":"","name":"old6","page":"1","reactive":"","sequence":"51","server_side":"false","type":"Variable","typevar":"character","w":"28","x":"732","y":"249"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"attivi","page":"1","reactive":"","sequence":"52","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"140"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"53","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"166"},{"allowedentities":"arfn_upload_allegati_single","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N,pCodDip=pCodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"54","servlet":"arfn_upload_allegati_single","target":"","type":"SPLinker","w":"147","x":"1100","y":"-28"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"55","type":"EventReceiver","w":"147","x":"1100","y":"-4"},{"calculate":"iif(Empty(rFull),aFull,rFull)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"pFull","page":"1","reactive":"","sequence":"56","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"-4"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aTG","page":"1","reactive":"","sequence":"57","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"897","y":"-28"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rTG","page":"1","reactive":"","sequence":"58","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"-28"},{"calculate":"iif(Empty(rTG),aTG,rTG)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"pTG","page":"1","reactive":"","sequence":"59","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"-28"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aFull","page":"1","reactive":"","sequence":"60","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"897","y":"-4"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rFull","page":"1","reactive":"","sequence":"61","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"-4"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aID","page":"1","reactive":"","sequence":"62","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"897","y":"20"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rID","page":"1","reactive":"","sequence":"63","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"20"},{"calculate":"iif(Empty(rID),aID,rID)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"w_idpratica","page":"1","reactive":"","sequence":"64","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"20"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"nomefile","page":"1","reactive":"","sequence":"65","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"896","y":"140"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aIDTicket","page":"1","reactive":"","sequence":"66","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"897","y":"44"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rIDTicket","page":"1","reactive":"","sequence":"67","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"44"},{"calculate":"iif(Empty(aIDTicket),rIDTicket,aIDTicket)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"ticket","page":"1","reactive":"","sequence":"68","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"44"},{"calculate":"iif(Empty(rOrigine),aOrigine,rOrigine)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"pOrigine","page":"1","reactive":"","sequence":"69","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"806","y":"68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rOrigine","page":"1","reactive":"","sequence":"70","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"988","y":"68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aOrigine","page":"1","reactive":"","sequence":"71","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"896","y":"68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"Upload1","page":"1","reactive":"","sequence":"72","server_side":"false","type":"Variable","typevar":"character","w":"76","x":"896","y":"190"},{"calculate":"iif(Empty(rID),aImporto,rImporto)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"pImporto","page":"1","reactive":"","sequence":"73","server_side":"false","type":"Variable","typevar":"numeric","w":"76","x":"806","y":"92"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aImporto","page":"1","reactive":"","sequence":"74","server_side":"false","type":"Variable","typevar":"numeric","w":"76","x":"896","y":"92"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rImporto","page":"1","reactive":"","sequence":"75","server_side":"false","type":"Variable","typevar":"numeric","w":"76","x":"988","y":"92"},{"calculate":"iif(Empty(rID),aContanti,rContanti)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"pContanti","page":"1","reactive":"","sequence":"76","server_side":"false","type":"Variable","typevar":"numeric","w":"76","x":"806","y":"116"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aContanti","page":"1","reactive":"","sequence":"77","server_side":"false","type":"Variable","typevar":"numeric","w":"76","x":"896","y":"116"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rContanti","page":"1","reactive":"","sequence":"78","server_side":"false","type":"Variable","typevar":"numeric","w":"76","x":"988","y":"116"},{"allowedqueries":"qbe_intermbo","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"1","name":"Query2","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_intermbo","query_async":"false","return_fields_type":"true","sequence":"79","type":"SQLDataobj","w":"147","x":"1099","y":"188"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query2","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"FLGGESDOC","h":"22","init":"","init_par":"","name":"gdoc","page":"1","reactive":"","sequence":"80","server_side":"false","type":"Variable","typevar":"character","w":"72","x":"990","y":"217"},{"allowedentities":"arrt_view_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTViewDoc","offline":"false","page":"1","parms":"pFile=filename,pID=w_idpratica,pCodDip=pCodDip","popup":"true","popup_height":"768","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"1024","progressbar":"","refresh":"","sequence":"81","servlet":"arrt_view_doc","target":"","type":"SPLinker","w":"147","x":"1099","y":"211"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"aCodDip","page":"1","reactive":"","sequence":"82","server_side":"false","type":"Variable","typevar":"character","w":"73","x":"897","y":"240"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"rCodDip","page":"1","reactive":"","sequence":"83","server_side":"false","type":"Variable","typevar":"character","w":"71","x":"990","y":"243"},{"calculate":"iif(Empty(aCodDip),rCodDip,aCodDip)","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pCodDip","page":"1","reactive":"","sequence":"84","server_side":"false","type":"Variable","typevar":"character","w":"72","x":"808","y":"240"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:rTG,rFull,rID,rIDTicket,rOrigine,rImporto,rContanti,rCodDip*/%>
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
window.pg_allegati_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof BtnSave_Click !='undefined')this.BtnSave_Click=BtnSave_Click;
if(typeof image0_Click !='undefined')this.image0_Click=image0_Click;
if(typeof image1_Click !='undefined')this.image1_Click=image1_Click;
if(typeof image2_Click !='undefined')this.image2_Click=image2_Click;
if(typeof image3_Click !='undefined')this.image3_Click=image3_Click;
if(typeof image4_Click !='undefined')this.image4_Click=image4_Click;
if(typeof image5_Click !='undefined')this.image5_Click=image5_Click;
if(typeof image6_Click !='undefined')this.image6_Click=image6_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof Calculate !='undefined')this.Calculate=Calculate;
if(typeof View00_Click !='undefined')this.View00_Click=View00_Click;
if(typeof View01_Click !='undefined')this.View01_Click=View01_Click;
if(typeof View02_Click !='undefined')this.View02_Click=View02_Click;
if(typeof View03_Click !='undefined')this.View03_Click=View03_Click;
if(typeof View04_Click !='undefined')this.View04_Click=View04_Click;
if(typeof View05_Click !='undefined')this.View05_Click=View05_Click;
if(typeof View06_Click !='undefined')this.View06_Click=View06_Click;
if(typeof DocView !='undefined')this.DocView=DocView;
if(typeof ViewDocuments !='undefined')this.ViewDocuments=ViewDocuments;
if(typeof ViewBottoni !='undefined')this.ViewBottoni=ViewBottoni;
if(typeof ExistingDoc !='undefined')this.ExistingDoc=ExistingDoc;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
this.pCodDip.Set((Empty(this.aCodDip.Value()) ? this.rCodDip.Value() : this.aCodDip.Value()));
}
ZtVWeb.InitCtrl((Empty(this.rFull.Value()) ? this.aFull.Value() : this.rFull.Value()),this.pFull);
ZtVWeb.InitCtrl((Empty(this.rTG.Value()) ? this.aTG.Value() : this.rTG.Value()),this.pTG);
ZtVWeb.InitCtrl((Empty(this.rID.Value()) ? this.aID.Value() : this.rID.Value()),this.w_idpratica);
ZtVWeb.InitCtrl((Empty(this.aIDTicket.Value()) ? this.rIDTicket.Value() : this.aIDTicket.Value()),this.ticket);
ZtVWeb.InitCtrl((Empty(this.rOrigine.Value()) ? this.aOrigine.Value() : this.rOrigine.Value()),this.pOrigine);
ZtVWeb.InitCtrl((Empty(this.rID.Value()) ? this.aImporto.Value() : this.rImporto.Value()),this.pImporto);
ZtVWeb.InitCtrl((Empty(this.rID.Value()) ? this.aContanti.Value() : this.rContanti.Value()),this.pContanti);
this.Query1.addDataConsumer(this.docunico,<%=JSPLib.ToJSValue("DCDOCUNICO",true)%>);
this.Query1.addDataConsumer(this.doc4,<%=JSPLib.ToJSValue("DCDOCNOM4",true)%>);
this.Query1.addDataConsumer(this.doc3,<%=JSPLib.ToJSValue("DCDOCNOM3",true)%>);
this.Query1.addDataConsumer(this.doc2,<%=JSPLib.ToJSValue("DCDOCNOM2",true)%>);
this.Query1.addDataConsumer(this.doc5,<%=JSPLib.ToJSValue("DCDOCNOM5",true)%>);
this.Query1.addDataConsumer(this.doc1,<%=JSPLib.ToJSValue("DCDOCNOM1",true)%>);
this.Query1.addDataConsumer(this.doc6,<%=JSPLib.ToJSValue("DCDOCNOM6",true)%>);
this.Query1.addDataConsumer(this.old0,<%=JSPLib.ToJSValue("DCDOCNEW0",true)%>);
this.Query1.addDataConsumer(this.old1,<%=JSPLib.ToJSValue("DCDOCNEW1",true)%>);
this.Query1.addDataConsumer(this.old2,<%=JSPLib.ToJSValue("DCDOCNEW2",true)%>);
this.Query1.addDataConsumer(this.old3,<%=JSPLib.ToJSValue("DCDOCNEW3",true)%>);
this.Query1.addDataConsumer(this.old4,<%=JSPLib.ToJSValue("DCDOCNEW4",true)%>);
this.Query1.addDataConsumer(this.old5,<%=JSPLib.ToJSValue("DCDOCNEW5",true)%>);
this.Query1.addDataConsumer(this.old6,<%=JSPLib.ToJSValue("DCDOCNEW6",true)%>);
this.Query2.addDataConsumer(this.gdoc,<%=JSPLib.ToJSValue("FLGGESDOC",true)%>);
function this_Loaded(){
  if (!Empty(this.docunico.Value())) {
    this.image1.Hide();
    this.image2.Hide();
    this.image3.Hide();  
    this.image4.Hide();  
    this.image5.Hide();  
    this.image6.Hide();      
  } else {
    if (!Empty(this.doc1.Value()) || !Empty(this.doc2.Value()) || !Empty(this.doc3.Value()) || !Empty(this.doc4.Value()) || !Empty(this.doc5.Value()) || !Empty(this.doc6.Value())) {
      this.image0.Hide();            
    }      
  }  
  this.ticket.Value(iif(Empty(this.aIDTicket.Value()),this.rIDTicket.Value(),this.aIDTicket.Value()))
  this.ViewDocuments();  
  this.ViewBottoni();  
  this.ExistingDoc();
  this.mDirectory.Value('Tmp/');  
  this.RTUpload.Parameters('dir=mDirectory');
}
function BtnSave_Click(){
  if (confirm("Confermi il caricamento dei documenti?")) {
    _esito=this.RTLoadDoc.Link()
    if (Left(_esito,1)=="S") {
      alert('Documenti salvati correttamente')
      DocUpdated(Right(_esito,1))
      this.Query1.Query();
      this.allegatiRefresh.Emit();
    }
    if (Left(_esito,1)=="N") {
      if (Right(_esito,1)=='C') {
        alert('Problemi nel collegamento al server di documentazione.Contattare HelpDesk!')              
      } else {  
        alert('Problemi nel salvataggio dei documenti. Contattare HelpDesk!')      
      }  
    }  
    if (Left(_esito,1)=="X") {
      if (Right(_esito,1)=='S') {
        DocUpdated(Right(_esito,1))
        this.allegatiRefresh.Emit();        
      } 
      if (Right(_esito,1)=='Z') {
        alert('Mancano alcuni documenti. Contattare Helpdesk!');        
      } else {
        alert('Non ci sono nuovi file da caricare!');        
      }  
    }      
  }    
}
function image0_Click(){
  // funzione di upload file
  this.RTUpload.Link()
  this.org.Value(0)
}
function image1_Click(){  
  // funzione di upload file
  this.org.Value(1)  
  this.RTUpload.Link()
}
function image2_Click(){
  // funzione di upload file
  this.org.Value(2)  
  this.RTUpload.Link()
}
function image3_Click(){
  this.org.Value(3)  
  // funzione di upload file    
  this.RTUpload.Link()
}
function image4_Click(){
  // funzione di upload file
  this.org.Value(4)  
  this.RTUpload.Link()
}
function image5_Click(){
  // funzione di upload file
  this.org.Value(5)  
  this.RTUpload.Link()
}
function image6_Click(){
  // funzione di upload file  
  this.org.Value(6)  
  this.RTUpload.Link()
}
function Aggiorna() {
  this.RTSaveFile.Link();
  _esito=this.RTVerify.Link()  
  if (_esito=='OK') {
    if (this.org.Value()==0) {
      this.docunico.Value(this.nomefile.Value())
      this.old0.Value('N');      
      this.doc1.Value('')
      this.doc2.Value('')
      this.doc3.Value('')
      this.doc4.Value('')
      this.doc5.Value('')
      this.doc6.Value('')
  		this.image1.Hide();
  		this.image2.Hide();
  		this.image3.Hide();  
  		this.image4.Hide();  
  		this.image5.Hide();  
  		this.image6.Hide();        
    }  
    if (this.org.Value()==1) {
      this.doc1.Value(this.nomefile.Value())
      this.old1.Value('N');
      this.docunico.Value('')
      this.image0.Hide();  
    }  
    if (this.org.Value()==2) {
      this.doc2.Value(this.nomefile.Value())
      this.old2.Value('N');      
      this.docunico.Value('')
      this.image0.Hide();            
    }  
    if (this.org.Value()==3) {
      this.doc3.Value(this.nomefile.Value())
      this.old3.Value('N');      
      this.docunico.Value('')   
      this.image0.Hide();            
    }  
    if (this.org.Value()==4) {
      this.doc4.Value(this.nomefile.Value())
      this.old4.Value('N');  
      this.docunico.Value('')
      this.image0.Hide();            
    }  
    if (this.org.Value()==5) {
      this.doc5.Value(this.nomefile.Value())
      this.old5.Value('N');  
      this.docunico.Value('')      
      this.image0.Hide();            
    }  
    if (this.org.Value()==6) {
      this.doc6.Value(this.nomefile.Value())
      this.old6.Value('N');  
      this.docunico.Value('')      
      this.image0.Hide();            
    }
  } else {
    alert(_esito)
  }  
  this.ViewDocuments();
  this.ViewBottoni();    
}
function Calculate(_id,_tg,_imp,_cont,_full,_doc1,_doc2,_idticket) {
  this.aID.Value(_id);
  this.aTG.Value(_tg);
  this.aImporto.Value(_imp);
  this.aContanti.Value(_cont);
  this.aFull.Value(_full);
  this.w_idpratica.Value(_id);
  this.pTG.Value(_tg);
  this.pImporto.Value(_imp);
  this.pContanti.Value(_cont);
  this.pFull.Value(_full);
  if (Empty(this.doc3.Value())) {
    this.doc3.Value(_doc1);
    this.old3.Value('N');          
  }
  if (Empty(this.doc4.Value())) {
    this.doc4.Value(_doc2);
    this.old4.Value('N');          
  }
  this.aIDTicket.Value(_idticket);
  this.ticket.Value(_idticket);
  this.ViewDocuments();
  this.ViewBottoni();  
}  
function View00_Click(){
  this.filename.Value(this.docunico.Value());
  this.DocView()
}
function View01_Click(){
  this.filename.Value(this.doc1.Value());
  this.DocView()
}
function View02_Click(){
  this.filename.Value(this.doc2.Value());
  this.DocView()
}
function View03_Click(){
  this.filename.Value(this.doc3.Value());
  this.DocView()
}
function View04_Click(){
  this.filename.Value(this.doc4.Value());
  this.DocView()
}
function View05_Click(){
  this.filename.Value(this.doc5.Value());
  this.DocView()
}
function View06_Click(){
  this.filename.Value(this.doc6.Value());
  this.DocView()
}
function DocView() {
  if(this.gdoc.Value()=='S') {
    if (this.gBrowser.Value()=='I') {
      var stile = "top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no resizable=yes";  
    } else {
      var stile = "top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no";  
    }   
    _fileout=this.RTCatchFile.Link();
    window.open(_fileout,"",stile);    
  } else {
    this.RTViewDoc.Link()
  }  
}  
function ViewDocuments() {
  _attivi=this.RTActivate.Link();
  this.attivi.Value(_attivi)
  if (Substr(_attivi,1,1)=='S') {
    this.lblDoc1.Show();    
    this.doc1.Show();
    this.View01.Show();
    if (this.pFull.Value() != 'S') {
      this.image1.Show()                    
    } else {  
      this.image1.Hide()                    
    }  
  } else {
    this.lblDoc1.Hide();
    this.doc1.Hide();
    this.View01.Hide();
    this.image1.Hide()
  }  
  if (Substr(_attivi,2,1)=='S') {
    this.lblDoc2.Show();    
    this.doc2.Show();
    this.View02.Show();
    if (this.pFull.Value() != 'S') {
      this.image2.Show()              
    } else {  
      this.image2.Hide()                    
    }  
  } else {
    this.lblDoc2.Hide();
    this.doc2.Hide();
    this.View02.Hide();
    this.image2.Hide()
  }    
  if (Substr(_attivi,3,1)=='S') {
    this.lblDoc3.Show();    
    this.doc3.Show();
    this.View03.Show();
    if (this.pFull.Value() != 'S') {
      this.image3.Show()              
    } else {  
      this.image3.Hide()                    
    }  
  } else {
    this.lblDoc3.Hide();
    this.doc3.Hide();
    this.View03.Hide();
    this.image3.Hide()
  }    
  if (Substr(_attivi,4,1)=='S') {
    this.lblDoc4.Show();    
    this.doc4.Show();
    this.View04.Show();
    if (this.pFull.Value() != 'S') {
      this.image4.Show()              
    } else {  
      this.image4.Hide()                    
    }  
  } else {
    this.lblDoc4.Hide();
    this.doc4.Hide();
    this.View04.Hide();
    this.image4.Hide()
  }    
  if (Substr(_attivi,5,1)=='S') {
    this.lblDoc5.Show();    
    this.doc5.Show();
    this.View05.Show();
    if (this.pFull.Value() != 'S') {
      this.image5.Show()              
    } else {  
      this.image5.Hide()                    
    }  
  } else {
    this.lblDoc5.Hide();
    this.doc5.Hide();
    this.View05.Hide();
    this.image5.Hide()
  }  
  if (Substr(_attivi,6,1)=='S') {
    this.lblDoc6.Show();    
    this.doc6.Show();
    this.View06.Show();
    if (this.pFull.Value() != 'S') {
      this.image6.Show()              
    } else {  
      this.image6.Hide()                    
    }  
  } else {
    this.lblDoc6.Hide();
    this.doc6.Hide();
    this.View06.Hide();
    this.image6.Hide()
  }    
}  
function ViewBottoni() {
  if (Empty(this.docunico.Value())) {
    this.View00.Hide()  
  } else {
    this.View00.Show()
  }
  if (Empty(this.doc1.Value())) {
    this.View01.Hide()  
  } else {
    this.View01.Show()
  } 
  if (Empty(this.doc2.Value())) {
    this.View02.Hide()  
  } else {
    this.View02.Show()
  } 
  if (Empty(this.doc3.Value())) {
    this.View03.Hide()  
  } else {
    this.View03.Show()
  } 
  if (Empty(this.doc4.Value())) {
    this.View04.Hide()  
  } else {
    this.View04.Show()
  } 
  if (Empty(this.doc5.Value())) {
    this.View05.Hide()  
  } else {
    this.View05.Show()
  } 
  if (Empty(this.doc6.Value())) {
    this.View06.Hide()  
  } else {
    this.View06.Show()
  }   
}  
function ExistingDoc(){
  if (!Empty(this.docunico.Value())) {
    this.old0.Value('S');
  }
  if (!Empty(this.doc1.Value())) {
    this.old1.Value('S');
  }
  if (!Empty(this.doc2.Value())) {
    this.old2.Value('S');
  }
  if (!Empty(this.doc3.Value())) {
    this.old3.Value('S');
  }
  if (!Empty(this.doc4.Value())) {
    this.old4.Value('S');
  }
  if (!Empty(this.doc5.Value())) {
    this.old5.Value('S');
  }
  if (!Empty(this.doc6.Value())) {
    this.old6.Value('S');
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
.pg_allegati_container {
}
.pg_allegati_title_container {
  margin: auto;
}
.pg_allegati_portlet{
  position:relative;
  margin: auto;
  width:790px;
  min-width:790px;
  height:300px;
}
.pg_allegati_portlet[Data-page="1"]{
  height:300px;
  width:790px;
}
.pg_allegati_portlet > .docunico_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:169px;
  width:574px;
  height:20px;
}
.pg_allegati_portlet > .docunico_ctrl {
}
.pg_allegati_portlet > .docunico_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_allegati_portlet > .doc4_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:54px;
  left:169px;
  width:574px;
  height:20px;
}
.pg_allegati_portlet > .doc4_ctrl {
}
.pg_allegati_portlet > .doc4_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_allegati_portlet > .doc3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:87px;
  left:169px;
  width:574px;
  height:20px;
}
.pg_allegati_portlet > .doc3_ctrl {
}
.pg_allegati_portlet > .doc3_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_allegati_portlet > .doc2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:120px;
  left:169px;
  width:574px;
  height:20px;
}
.pg_allegati_portlet > .doc2_ctrl {
}
.pg_allegati_portlet > .doc2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_allegati_portlet > .doc5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:153px;
  left:169px;
  width:574px;
  height:20px;
}
.pg_allegati_portlet > .doc5_ctrl {
}
.pg_allegati_portlet > .doc5_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_allegati_portlet > .doc1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:186px;
  left:169px;
  width:574px;
  height:20px;
}
.pg_allegati_portlet > .doc1_ctrl {
}
.pg_allegati_portlet > .doc1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_allegati_portlet > .doc6_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:219px;
  left:169px;
  width:574px;
  height:20px;
}
.pg_allegati_portlet > .doc6_ctrl {
}
.pg_allegati_portlet > .doc6_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_allegati_portlet > .label6_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:69px;
  width:97px;
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .label6_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .label6_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_allegati_portlet > .lblDoc4_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:58px;
  left:42px;
  width:124px;
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc4_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc4_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_allegati_portlet > .lblDoc3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:91px;
  left:69px;
  width:97px;
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc3_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc3_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_allegati_portlet > .lblDoc2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:124px;
  left:69px;
  width:97px;
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc2_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_allegati_portlet > .lblDoc5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:157px;
  left:42px;
  width:124px;
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc5_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc5_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_allegati_portlet > .lblDoc1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:190px;
  left:0px;
  width:166px;
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_allegati_portlet > .lblDoc6_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:223px;
  left:69px;
  width:97px;
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc6_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allegati_portlet > .lblDoc6_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_allegati_portlet > .Box7_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:44px;
  left:0px;
  width:790px;
  height:auto;
  min-height:2px;
  display:flex;
  flex-direction:column;
}
.pg_allegati_portlet > .Box7_ctrl {
  height:2px;
}
.pg_allegati_portlet > .Box7_ctrl > .box_content {
  height:100%;
}
.pg_allegati_portlet > .Box7_ctrl {
  min-height:2px;
  background-color:#FFFFFF;
  border-width:1px;
  border-style:solid;
  border-color:#000000;
}
.pg_allegati_portlet > .image0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:745px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .image0_ctrl {
}
.pg_allegati_portlet > .image0_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .image4_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:56px;
  left:745px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .image4_ctrl {
}
.pg_allegati_portlet > .image4_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .image3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:89px;
  left:745px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .image3_ctrl {
}
.pg_allegati_portlet > .image3_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .image2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:122px;
  left:745px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .image2_ctrl {
}
.pg_allegati_portlet > .image2_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:155px;
  left:745px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .image5_ctrl {
}
.pg_allegati_portlet > .image5_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .image1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:188px;
  left:745px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .image1_ctrl {
}
.pg_allegati_portlet > .image1_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .image6_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:221px;
  left:745px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .image6_ctrl {
}
.pg_allegati_portlet > .image6_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .View00_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:763px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .View00_ctrl {
}
.pg_allegati_portlet > .View00_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .View04_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:56px;
  left:763px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .View04_ctrl {
}
.pg_allegati_portlet > .View04_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .View03_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:89px;
  left:763px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .View03_ctrl {
}
.pg_allegati_portlet > .View03_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .View02_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:122px;
  left:763px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .View02_ctrl {
}
.pg_allegati_portlet > .View02_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .View05_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:155px;
  left:763px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .View05_ctrl {
}
.pg_allegati_portlet > .View05_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .View01_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:188px;
  left:763px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .View01_ctrl {
}
.pg_allegati_portlet > .View01_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .View06_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:221px;
  left:763px;
  width:15px;
  height:15px;
}
.pg_allegati_portlet > .View06_ctrl {
}
.pg_allegati_portlet > .View06_ctrl > img{
  width:100%;
  vertical-align:top;
  height:15px;
}
.pg_allegati_portlet > .BtnSave_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:246px;
  left:377px;
  width:43px;
  height:30px;
}
.pg_allegati_portlet > .BtnSave_ctrl {
}
.pg_allegati_portlet > .BtnSave_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"790\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"164\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"68\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"92\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"116\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"140\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"190\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"164\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"896\",\"y\":\"164\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"190\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"214\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"896\",\"y\":\"214\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"docunico\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"574\",\"x\":\"169\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"doc4\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"574\",\"x\":\"169\",\"y\":\"54\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"doc3\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"574\",\"x\":\"169\",\"y\":\"87\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"doc2\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"574\",\"x\":\"169\",\"y\":\"120\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"doc5\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"574\",\"x\":\"169\",\"y\":\"153\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"doc1\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"574\",\"x\":\"169\",\"y\":\"186\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"doc6\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"574\",\"x\":\"169\",\"y\":\"219\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"mFileName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"140\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label6\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Doc. Unico:\",\"w\":\"97\",\"x\":\"69\",\"y\":\"15\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDoc4\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Documento di Identità:\",\"w\":\"124\",\"x\":\"42\",\"y\":\"58\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDoc3\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":\"97\",\"x\":\"69\",\"y\":\"91\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDoc2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Biglietto\\u002fTicket:\",\"w\":\"97\",\"x\":\"69\",\"y\":\"124\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDoc5\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Mezzo di Pagamento:\",\"w\":\"124\",\"x\":\"42\",\"y\":\"157\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDoc1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Modulo Identificazione Cliente:\",\"w\":\"166\",\"x\":\"0\",\"y\":\"190\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDoc6\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Obbligazione:\",\"w\":\"97\",\"x\":\"69\",\"y\":\"223\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"2\",\"layout_steps_values\":{},\"name\":\"Box7\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"790\",\"x\":\"0\",\"y\":\"44\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"image0\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"745\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"image4\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"745\",\"y\":\"56\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"image3\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"745\",\"y\":\"89\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"image2\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"745\",\"y\":\"122\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"image5\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"745\",\"y\":\"155\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"image1\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"745\",\"y\":\"188\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"image6\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"745\",\"y\":\"221\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"View00\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"763\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"View04\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"763\",\"y\":\"56\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"View03\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"763\",\"y\":\"89\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"View02\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"763\",\"y\":\"122\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"View05\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"763\",\"y\":\"155\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"View01\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"763\",\"y\":\"188\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"name\":\"View06\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"763\",\"y\":\"221\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"BtnSave\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"43\",\"x\":\"377\",\"y\":\"246\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTLoadDoc\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"44\"},{\"h\":\"20\",\"name\":\"allegatiRefresh\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"20\"},{\"h\":\"20\",\"name\":\"old0\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"28\",\"x\":\"528\",\"y\":\"249\"},{\"h\":\"20\",\"name\":\"old1\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"28\",\"x\":\"559\",\"y\":\"249\"},{\"h\":\"20\",\"name\":\"old2\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"28\",\"x\":\"596\",\"y\":\"249\"},{\"h\":\"20\",\"name\":\"old3\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"28\",\"x\":\"628\",\"y\":\"249\"},{\"h\":\"20\",\"name\":\"old4\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"28\",\"x\":\"658\",\"y\":\"249\"},{\"h\":\"20\",\"name\":\"old5\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"28\",\"x\":\"691\",\"y\":\"249\"},{\"h\":\"20\",\"name\":\"old6\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"28\",\"x\":\"732\",\"y\":\"249\"},{\"h\":\"20\",\"name\":\"attivi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"140\"},{\"h\":\"20\",\"name\":\"filename\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"166\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"-28\"},{\"h\":\"20\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"147\",\"x\":\"1100\",\"y\":\"-4\"},{\"h\":\"20\",\"name\":\"pFull\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"-4\"},{\"h\":\"20\",\"name\":\"aTG\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"897\",\"y\":\"-28\"},{\"h\":\"20\",\"name\":\"rTG\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"-28\"},{\"h\":\"20\",\"name\":\"pTG\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"-28\"},{\"h\":\"20\",\"name\":\"aFull\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"897\",\"y\":\"-4\"},{\"h\":\"20\",\"name\":\"rFull\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"-4\"},{\"h\":\"20\",\"name\":\"aID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"897\",\"y\":\"20\"},{\"h\":\"20\",\"name\":\"rID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"20\"},{\"h\":\"20\",\"name\":\"w_idpratica\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"20\"},{\"h\":\"20\",\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"896\",\"y\":\"140\"},{\"h\":\"20\",\"name\":\"aIDTicket\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"897\",\"y\":\"44\"},{\"h\":\"20\",\"name\":\"rIDTicket\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"44\"},{\"h\":\"20\",\"name\":\"ticket\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"44\"},{\"h\":\"20\",\"name\":\"pOrigine\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"68\"},{\"h\":\"20\",\"name\":\"rOrigine\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"68\"},{\"h\":\"20\",\"name\":\"aOrigine\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"896\",\"y\":\"68\"},{\"h\":\"20\",\"name\":\"Upload1\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"896\",\"y\":\"190\"},{\"h\":\"20\",\"name\":\"pImporto\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"92\"},{\"h\":\"20\",\"name\":\"aImporto\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"896\",\"y\":\"92\"},{\"h\":\"20\",\"name\":\"rImporto\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"92\"},{\"h\":\"20\",\"name\":\"pContanti\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"806\",\"y\":\"116\"},{\"h\":\"20\",\"name\":\"aContanti\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"896\",\"y\":\"116\"},{\"h\":\"20\",\"name\":\"rContanti\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"76\",\"x\":\"988\",\"y\":\"116\"},{\"h\":\"20\",\"name\":\"Query2\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"147\",\"x\":\"1099\",\"y\":\"188\"},{\"h\":\"22\",\"name\":\"gdoc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"72\",\"x\":\"990\",\"y\":\"217\"},{\"h\":\"20\",\"name\":\"RTViewDoc\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"1099\",\"y\":\"211\"},{\"h\":\"20\",\"name\":\"aCodDip\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"73\",\"x\":\"897\",\"y\":\"240\"},{\"h\":\"20\",\"name\":\"rCodDip\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"71\",\"x\":\"990\",\"y\":\"243\"},{\"h\":\"20\",\"name\":\"pCodDip\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"72\",\"x\":\"808\",\"y\":\"240\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_allegati","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_allegati_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_allegati','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String mRoot="/";
String gUrlApp=sp.getGlobal("gUrlApp","");
String mDirectory= "";
double org= 0;
String gBrowser=sp.getGlobal("gBrowser","");
String gCodDip=sp.getGlobal("gCodDip","");
String docunico= "";
if(request.getAttribute("pg_allegati_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String doc4= "";
String doc3= "";
String doc2= "";
String doc5= "";
String doc1= "";
String doc6= "";
String mFileName= "";
String label6= "Doc. Unico:";
String lblDoc4= "Documento di Identità:";
String lblDoc3= "Codice Fiscale:";
String lblDoc2= "Biglietto/Ticket:";
String lblDoc5= "Mezzo di Pagamento:";
String lblDoc1= "Modulo Identificazione Cliente:";
String lblDoc6= "Obbligazione:";
String old0= "";
String old1= "";
String old2= "";
String old3= "";
String old4= "";
String old5= "";
String old6= "";
String attivi= "";
String filename= "";
String pFull= "";
String aTG=JSPLib.translateXSS(Library.getAttribute(request,"aTG",""));
String rTG=JSPLib.translateXSS(sp.getParameter("rTG",""));
String pTG= "";
String aFull=JSPLib.translateXSS(Library.getAttribute(request,"aFull",""));
String rFull=JSPLib.translateXSS(sp.getParameter("rFull",""));
String aID=JSPLib.translateXSS(Library.getAttribute(request,"aID",""));
String rID=JSPLib.translateXSS(sp.getParameter("rID",""));
String w_idpratica= "";
String nomefile= "";
String aIDTicket=JSPLib.translateXSS(Library.getAttribute(request,"aIDTicket",""));
String rIDTicket=JSPLib.translateXSS(sp.getParameter("rIDTicket",""));
String ticket= "";
String pOrigine= "";
String rOrigine=JSPLib.translateXSS(sp.getParameter("rOrigine",""));
String aOrigine=JSPLib.translateXSS(Library.getAttribute(request,"aOrigine",""));
String Upload1= "";
double pImporto= 0;
double aImporto= Library.getAttribute(request,"aImporto",0);
double rImporto=sp.getParameter("rImporto",0);
double pContanti= 0;
double aContanti= Library.getAttribute(request,"aContanti",0);
double rContanti=sp.getParameter("rContanti",0);
String gdoc= "";
String aCodDip=JSPLib.translateXSS(Library.getAttribute(request,"aCodDip",""));
String rCodDip=JSPLib.translateXSS(sp.getParameter("rCodDip",""));
String pCodDip= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_allegati_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_allegati_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_allegati','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_docunico_wrp'><input id='<%=idPortlet%>_docunico' name='docunico' type='text' disabled maxlength='80' class='textbox' formid='<%=idPortlet%>' ps-name='docunico' /></span>
<span class='textbox-container'id='<%=idPortlet%>_doc4_wrp'><input id='<%=idPortlet%>_doc4' name='doc4' type='text' disabled maxlength='80' class='textbox' formid='<%=idPortlet%>' ps-name='doc4' /></span>
<span class='textbox-container'id='<%=idPortlet%>_doc3_wrp'><input id='<%=idPortlet%>_doc3' name='doc3' type='text' disabled maxlength='80' class='textbox' formid='<%=idPortlet%>' ps-name='doc3' /></span>
<span class='textbox-container'id='<%=idPortlet%>_doc2_wrp'><input id='<%=idPortlet%>_doc2' name='doc2' type='text' maxlength='80' class='textbox' formid='<%=idPortlet%>' ps-name='doc2' /></span>
<span class='textbox-container'id='<%=idPortlet%>_doc5_wrp'><input id='<%=idPortlet%>_doc5' name='doc5' type='text' disabled maxlength='80' class='textbox' formid='<%=idPortlet%>' ps-name='doc5' /></span>
<span class='textbox-container'id='<%=idPortlet%>_doc1_wrp'><input id='<%=idPortlet%>_doc1' name='doc1' type='text' disabled maxlength='80' class='textbox' formid='<%=idPortlet%>' ps-name='doc1' /></span>
<span class='textbox-container'id='<%=idPortlet%>_doc6_wrp'><input id='<%=idPortlet%>_doc6' name='doc6' type='text' maxlength='80' class='textbox' formid='<%=idPortlet%>' ps-name='doc6' /></span>
<span id='<%=idPortlet%>_label6'  formid='<%=idPortlet%>' ps-name='label6'    class='label label6_ctrl'><div id='<%=idPortlet%>_label6tbl' style='width:100%;'><%=JSPLib.ToHTML("Doc. Unico:")%></div></span>
<span id='<%=idPortlet%>_lblDoc4'  formid='<%=idPortlet%>' ps-name='lblDoc4'    class='label lblDoc4_ctrl'><div id='<%=idPortlet%>_lblDoc4tbl' style='width:100%;'><%=JSPLib.ToHTML("Documento di Identità:")%></div></span>
<span id='<%=idPortlet%>_lblDoc3'  formid='<%=idPortlet%>' ps-name='lblDoc3'    class='label lblDoc3_ctrl'><div id='<%=idPortlet%>_lblDoc3tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice Fiscale:")%></div></span>
<span id='<%=idPortlet%>_lblDoc2'  formid='<%=idPortlet%>' ps-name='lblDoc2'    class='label lblDoc2_ctrl'><div id='<%=idPortlet%>_lblDoc2tbl' style='width:100%;'><%=JSPLib.ToHTML("Biglietto/Ticket:")%></div></span>
<span id='<%=idPortlet%>_lblDoc5'  formid='<%=idPortlet%>' ps-name='lblDoc5'    class='label lblDoc5_ctrl'><div id='<%=idPortlet%>_lblDoc5tbl' style='width:100%;'><%=JSPLib.ToHTML("Mezzo di Pagamento:")%></div></span>
<span id='<%=idPortlet%>_lblDoc1'  formid='<%=idPortlet%>' ps-name='lblDoc1'    class='label lblDoc1_ctrl'><div id='<%=idPortlet%>_lblDoc1tbl' style='width:100%;'><%=JSPLib.ToHTML("Modulo Identificazione Cliente:")%></div></span>
<span id='<%=idPortlet%>_lblDoc6'  formid='<%=idPortlet%>' ps-name='lblDoc6'    class='label lblDoc6_ctrl'><div id='<%=idPortlet%>_lblDoc6tbl' style='width:100%;'><%=JSPLib.ToHTML("Obbligazione:")%></div></span>
<div id='<%=idPortlet%>_Box7' class='Box7_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box7_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_image0'>
<img id='<%=idPortlet%>_image0_img' class='image image0_ctrl' src="../images/009.gif" >
</div>
<div id='<%=idPortlet%>_image4'>
<img id='<%=idPortlet%>_image4_img' class='image image4_ctrl' src="../images/009.gif" >
</div>
<div id='<%=idPortlet%>_image3'>
<img id='<%=idPortlet%>_image3_img' class='image image3_ctrl' src="../images/009.gif" >
</div>
<div id='<%=idPortlet%>_image2'>
<img id='<%=idPortlet%>_image2_img' class='image image2_ctrl' src="../images/009.gif" >
</div>
<div id='<%=idPortlet%>_image5'>
<img id='<%=idPortlet%>_image5_img' class='image image5_ctrl' src="../images/009.gif" >
</div>
<div id='<%=idPortlet%>_image1'>
<img id='<%=idPortlet%>_image1_img' class='image image1_ctrl' src="../images/009.gif" >
</div>
<div id='<%=idPortlet%>_image6'>
<img id='<%=idPortlet%>_image6_img' class='image image6_ctrl' src="../images/009.gif" >
</div>
<div id='<%=idPortlet%>_View00'>
<img id='<%=idPortlet%>_View00_img' class='image View00_ctrl' src="../images/113.gif" >
</div>
<div id='<%=idPortlet%>_View04'>
<img id='<%=idPortlet%>_View04_img' class='image View04_ctrl' src="../images/113.gif" >
</div>
<div id='<%=idPortlet%>_View03'>
<img id='<%=idPortlet%>_View03_img' class='image View03_ctrl' src="../images/113.gif" >
</div>
<div id='<%=idPortlet%>_View02'>
<img id='<%=idPortlet%>_View02_img' class='image View02_ctrl' src="../images/113.gif" >
</div>
<div id='<%=idPortlet%>_View05'>
<img id='<%=idPortlet%>_View05_img' class='image View05_ctrl' src="../images/113.gif" >
</div>
<div id='<%=idPortlet%>_View01'>
<img id='<%=idPortlet%>_View01_img' class='image View01_ctrl' src="../images/113.gif" >
</div>
<div id='<%=idPortlet%>_View06'>
<img id='<%=idPortlet%>_View06_img' class='image View06_ctrl' src="../images/113.gif" >
</div>
<div id='<%=idPortlet%>_BtnSave'>
<img id='<%=idPortlet%>_BtnSave_img' class='image BtnSave_ctrl' src="../images/save.gif" >
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_allegati');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_allegati',["790"],["300"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"790","h":"300","title":"","layer":"false","npage":"1"}]);
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_docope","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_docope",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"1","page":1,"parms":"pDCNUMOPE=w_idpratica","parms_source":"","type":"SQLDataobj","w":147,"x":1100,"y":164});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"Root=mRoot,Directory=mDirectory","popup":"true","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":147,"x":1100,"y":68});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.RTVerify=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_verify_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTVerify","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTVerify","offline":false,"page":1,"parms":"pTipo=org,pNomeDoc=nomefile,pTipoGioco=pTG,pImpTick=pImporto,pImpCont=pContanti,pCodDip=pCodDip","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"arfn_verify_doc","target":"","type":"SPLinker","w":147,"x":1100,"y":92});
this.RTVerify.m_cID='<%=JSPLib.cmdHash("routine,arfn_verify_doc",request.getSession())%>';
this.RTCatchFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_catchfile",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCatchFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCatchFile","offline":false,"page":1,"parms":"pID=w_idpratica,pFile=filename,pTipo=V,pCodDip=pCodDip","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"arfn_catchfile","target":"","type":"SPLinker","w":147,"x":1100,"y":116});
this.RTCatchFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_catchfile",request.getSession())%>';
this.RTActivate=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_activate_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTActivate","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTActivate","offline":false,"page":1,"parms":"pGioco=pTG,pTotale=pImporto,pContanti=pContanti","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"arfn_activate_doc","target":"","type":"SPLinker","w":147,"x":1100,"y":140});
this.RTActivate.m_cID='<%=JSPLib.cmdHash("routine,arfn_activate_doc",request.getSession())%>';
this.mRoot=new ZtVWeb._VC(this,'mRoot',null,'character','<%=JSPLib.ToJSValue(mRoot,false,true)%>',false,false);
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.mDirectory=new ZtVWeb._VC(this,'mDirectory',null,'character','<%=JSPLib.ToJSValue(mDirectory,false,true)%>',false,false);
this.org=new ZtVWeb._VC(this,'org',null,'numeric',<%=org%>,false,false);
this.gBrowser=new ZtVWeb._VC(this,'gBrowser',null,'character','<%=JSPLib.ToJSValue(gBrowser,false,true)%>',false,false);
this.gCodDip=new ZtVWeb._VC(this,'gCodDip',null,'character','<%=JSPLib.ToJSValue(gCodDip,false,true)%>',false,false);
this.docunico=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_docunico","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DCDOCUNICO","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"docunico","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(docunico,false,true)%>","w":574,"x":169,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.doc4=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_doc4","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DCDOCNOM4","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"doc4","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(doc4,false,true)%>","w":574,"x":169,"y":54,"zerofilling":false,"zindex":"1","zoom":""});
this.doc3=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_doc3","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DCDOCNOM3","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"doc3","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(doc3,false,true)%>","w":574,"x":169,"y":87,"zerofilling":false,"zindex":"1","zoom":""});
this.doc2=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_doc2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DCDOCNOM2","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"doc2","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(doc2,false,true)%>","w":574,"x":169,"y":120,"zerofilling":false,"zindex":"1","zoom":""});
this.doc5=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_doc5","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DCDOCNOM5","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"doc5","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(doc5,false,true)%>","w":574,"x":169,"y":153,"zerofilling":false,"zindex":"1","zoom":""});
this.doc1=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_doc1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DCDOCNOM1","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"doc1","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(doc1,false,true)%>","w":574,"x":169,"y":186,"zerofilling":false,"zindex":"1","zoom":""});
this.doc6=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_doc6","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DCDOCNOM6","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"doc6","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(doc6,false,true)%>","w":574,"x":169,"y":219,"zerofilling":false,"zindex":"1","zoom":""});
this.mFileName=new ZtVWeb._VC(this,'mFileName',null,'character','<%=JSPLib.ToJSValue(mFileName,false,true)%>',false,false);
this.label6=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label6","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label6","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label6,false,true)%>","type":"Label","w":97,"x":69,"y":15,"zindex":"1"});
this.lblDoc4=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDoc4","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDoc4","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDoc4,false,true)%>","type":"Label","w":124,"x":42,"y":58,"zindex":"1"});
this.lblDoc3=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDoc3","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDoc3","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDoc3,false,true)%>","type":"Label","w":97,"x":69,"y":91,"zindex":"1"});
this.lblDoc2=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDoc2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDoc2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDoc2,false,true)%>","type":"Label","w":97,"x":69,"y":124,"zindex":"1"});
this.lblDoc5=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDoc5","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDoc5","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDoc5,false,true)%>","type":"Label","w":124,"x":42,"y":157,"zindex":"1"});
this.lblDoc1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDoc1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDoc1","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDoc1,false,true)%>","type":"Label","w":166,"x":0,"y":190,"zindex":"1"});
this.lblDoc6=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDoc6","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDoc6","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDoc6,false,true)%>","type":"Label","w":97,"x":69,"y":223,"zindex":"1"});
this.Box7=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"#FFFFFF","border_color":"#000000","border_weight":"1","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box7","groupName":"","h":2,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box7","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":790,"x":0,"y":44,"zindex":"0"});
this.image0=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image0_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image0","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image0","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":745,"y":13,"zindex":"1"});
this.image4=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image4_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image4","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image4","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":745,"y":56,"zindex":"1"});
this.image3=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image3_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image3","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image3","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":745,"y":89,"zindex":"1"});
this.image2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image2","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image2","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":745,"y":122,"zindex":"1"});
this.image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":745,"y":155,"zindex":"1"});
this.image1=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image1_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image1","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image1","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":745,"y":188,"zindex":"1"});
this.image6=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image6_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image6","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image6","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f009.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":745,"y":221,"zindex":"1"});
this.View00=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image View00_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_View00","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"View00","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":763,"y":13,"zindex":"1"});
this.View04=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image View04_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_View04","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"View04","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":763,"y":56,"zindex":"1"});
this.View03=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image View03_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_View03","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"View03","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":763,"y":89,"zindex":"1"});
this.View02=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image View02_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_View02","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"View02","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":763,"y":122,"zindex":"1"});
this.View05=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image View05_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_View05","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"View05","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":763,"y":155,"zindex":"1"});
this.View01=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image View01_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_View01","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"View01","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":763,"y":188,"zindex":"1"});
this.View06=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image View06_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_View06","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"View06","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002f113.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":763,"y":221,"zindex":"1"});
this.BtnSave=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image BtnSave_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnSave","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Conferma i documenti inseriti",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnSave","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":43,"x":377,"y":246,"zindex":"1"});
this.RTLoadDoc=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_confirm_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTLoadDoc","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTLoadDoc","offline":false,"page":1,"parms":"pID=w_idpratica,pTipo=pOrigine,pDocUnico=docunico,pDoc1=doc1,pDoc2=doc2,pDoc3=doc3,pDoc4=doc4,pDoc5=doc5,pDoc6=doc6,pOld0=old0,pOld1=old1,pOld2=old2,pOld3=old3,pOld4=old4,pOld5=old5,pOld6=old6,pAttivi=attivi,pTicket=ticket,pCodDip=pCodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_confirm_doc","target":"","type":"SPLinker","w":147,"x":1100,"y":44});
this.RTLoadDoc.m_cID='<%=JSPLib.cmdHash("routine,arfn_confirm_doc",request.getSession())%>';
this.allegatiRefresh=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_allegatiRefresh","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"allegatiRefresh","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":147,"x":1100,"y":20});
this.old0=new ZtVWeb._VC(this,'old0',null,'character','<%=JSPLib.ToJSValue(old0,false,true)%>',false,false);
this.old1=new ZtVWeb._VC(this,'old1',null,'character','<%=JSPLib.ToJSValue(old1,false,true)%>',false,false);
this.old2=new ZtVWeb._VC(this,'old2',null,'character','<%=JSPLib.ToJSValue(old2,false,true)%>',false,false);
this.old3=new ZtVWeb._VC(this,'old3',null,'character','<%=JSPLib.ToJSValue(old3,false,true)%>',false,false);
this.old4=new ZtVWeb._VC(this,'old4',null,'character','<%=JSPLib.ToJSValue(old4,false,true)%>',false,false);
this.old5=new ZtVWeb._VC(this,'old5',null,'character','<%=JSPLib.ToJSValue(old5,false,true)%>',false,false);
this.old6=new ZtVWeb._VC(this,'old6',null,'character','<%=JSPLib.ToJSValue(old6,false,true)%>',false,false);
this.attivi=new ZtVWeb._VC(this,'attivi',null,'character','<%=JSPLib.ToJSValue(attivi,false,true)%>',false,false);
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_allegati_single",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N,pCodDip=pCodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_allegati_single","target":"","type":"SPLinker","w":147,"x":1100,"y":-28});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_allegati_single",request.getSession())%>';
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":147,"x":1100,"y":-4});
this.pFull=new ZtVWeb._VC(this,'pFull',null,'character','<%=JSPLib.ToJSValue(pFull,false,true)%>',false,false);
this.aTG=new ZtVWeb._VC(this,'aTG',null,'character','<%=JSPLib.ToJSValue(aTG,false,true)%>',false,false);
this.rTG=new ZtVWeb._VC(this,'rTG',null,'character','<%=JSPLib.ToJSValue(rTG,false,true)%>',false,false);
this.pTG=new ZtVWeb._VC(this,'pTG',null,'character','<%=JSPLib.ToJSValue(pTG,false,true)%>',false,false);
this.aFull=new ZtVWeb._VC(this,'aFull',null,'character','<%=JSPLib.ToJSValue(aFull,false,true)%>',false,false);
this.rFull=new ZtVWeb._VC(this,'rFull',null,'character','<%=JSPLib.ToJSValue(rFull,false,true)%>',false,false);
this.aID=new ZtVWeb._VC(this,'aID',null,'character','<%=JSPLib.ToJSValue(aID,false,true)%>',false,false);
this.rID=new ZtVWeb._VC(this,'rID',null,'character','<%=JSPLib.ToJSValue(rID,false,true)%>',false,false);
this.w_idpratica=new ZtVWeb._VC(this,'w_idpratica',null,'character','<%=JSPLib.ToJSValue(w_idpratica,false,true)%>',false,false);
this.nomefile=new ZtVWeb._VC(this,'nomefile',null,'character','<%=JSPLib.ToJSValue(nomefile,false,true)%>',false,false);
this.aIDTicket=new ZtVWeb._VC(this,'aIDTicket',null,'character','<%=JSPLib.ToJSValue(aIDTicket,false,true)%>',false,false);
this.rIDTicket=new ZtVWeb._VC(this,'rIDTicket',null,'character','<%=JSPLib.ToJSValue(rIDTicket,false,true)%>',false,false);
this.ticket=new ZtVWeb._VC(this,'ticket',null,'character','<%=JSPLib.ToJSValue(ticket,false,true)%>',false,false);
this.pOrigine=new ZtVWeb._VC(this,'pOrigine',null,'character','<%=JSPLib.ToJSValue(pOrigine,false,true)%>',false,false);
this.rOrigine=new ZtVWeb._VC(this,'rOrigine',null,'character','<%=JSPLib.ToJSValue(rOrigine,false,true)%>',false,false);
this.aOrigine=new ZtVWeb._VC(this,'aOrigine',null,'character','<%=JSPLib.ToJSValue(aOrigine,false,true)%>',false,false);
this.Upload1=new ZtVWeb._VC(this,'Upload1',null,'character','<%=JSPLib.ToJSValue(Upload1,false,true)%>',false,false);
this.pImporto=new ZtVWeb._VC(this,'pImporto',null,'numeric',<%=pImporto%>,false,false);
this.aImporto=new ZtVWeb._VC(this,'aImporto',null,'numeric',<%=aImporto%>,false,false);
this.rImporto=new ZtVWeb._VC(this,'rImporto',null,'numeric',<%=rImporto%>,false,false);
this.pContanti=new ZtVWeb._VC(this,'pContanti',null,'numeric',<%=pContanti%>,false,false);
this.aContanti=new ZtVWeb._VC(this,'aContanti',null,'numeric',<%=aContanti%>,false,false);
this.rContanti=new ZtVWeb._VC(this,'rContanti',null,'numeric',<%=rContanti%>,false,false);
this.Query2=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_intermbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_intermbo","cmdHash":"<%=JSPLib.cmdHash("qbe_intermbo",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_Query2","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query2","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":147,"x":1099,"y":188});
this.gdoc=new ZtVWeb._VC(this,'gdoc',null,'character','<%=JSPLib.ToJSValue(gdoc,false,true)%>',false,false);
this.RTViewDoc=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_view_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTViewDoc","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTViewDoc","offline":false,"page":1,"parms":"pFile=filename,pID=w_idpratica,pCodDip=pCodDip","popup":"true","popup_height":"768","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"1024","progressbar":false,"refresh":"","servlet":"arrt_view_doc","target":"","type":"SPLinker","w":147,"x":1099,"y":211});
this.RTViewDoc.m_cID='<%=JSPLib.cmdHash("routine,arrt_view_doc",request.getSession())%>';
this.aCodDip=new ZtVWeb._VC(this,'aCodDip',null,'character','<%=JSPLib.ToJSValue(aCodDip,false,true)%>',false,false);
this.rCodDip=new ZtVWeb._VC(this,'rCodDip',null,'character','<%=JSPLib.ToJSValue(rCodDip,false,true)%>',false,false);
this.pCodDip=new ZtVWeb._VC(this,'pCodDip',null,'character','<%=JSPLib.ToJSValue(pCodDip,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_allegati_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_allegati_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_allegati_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.allegatiRefresh.setParms();
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Query1.firstQuery('true');
window.<%=idPortlet%>.Query2.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_allegati',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_allegati');
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
sp.endPage("pg_allegati");
}%>
<%! public String getJSPUID() { return "1982804992"; } %>