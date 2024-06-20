/*****************************************************************

	RulersLib Object:

	workunit :
		mm 		millimeters
		cm 		centimeters
		pc 		picas
		inch	inches
		pt		points/pixels


	@Need: canvasLib.js

	@Author: Michel Glele Ahanhanzo - Zucchetti Padova

*****************************************************************/

if (typeof(RulersLib)=='undefined') {

	var RulersLib=function(){
		this.workunit="mm";
		this.wcanvas;
		this.font = "sans-serif";
		this.fontsize = 8;
		this.scale=100;
		this.divid="";
		this.bdraw=true;

    this.Init=function(id, workunit){
      this.divid=id;
      this.workunit=workunit;
      return this;
    }

    this.SetDraw=function(bcandraw){
      this.bdraw=bcandraw;
    }

    this.SetScale=function(scale){
      this.scale=scale;
    }

    this.SetWorkUnit=function(wunit){
      this.workunit=wunit;
    }

	this.DrawGrid=function(wlen, hlen, type, color, stroke, step){
		var wunit=1
		if(this.workunit == "mm" || this.workunit == "cm")
			wunit = 2.834*96/72 //mm to points

		if(this.workunit == "px")
			wunit = 96/72

		wunit = wunit*this.scale/100;
		var w = wlen*this.scale/100;
		var h = hlen*this.scale/100;
		var wz = Round((w/wunit),0);
		var hz = Round((h/wunit),0);
		this.wcanvas = CanvasLib.Init(this.divid,w,h);
		//this.wcanvas.Clear();
		this.wcanvas.alphaChannel=1;
		this.wcanvas.fillColor = [103,103,103];
		this.wcanvas.scale=this.scale;
		if(this.bdraw==false)
			return;

		/*for(var z=0; z<wz; z++){
			for(var k=0; k<hz; k++){
				if(z%5 == 0 && k%5==0){
					this.wcanvas.DrawLine(z*wunit, k*wunit, z*wunit, (k+1)*wunit, true); //linea verticale
					this.wcanvas.DrawLine(z*wunit, k*wunit, (z+1)*wunit, k*wunit, true);
				}
				//this.wcanvas.DrawRect(z*wunit, k*wunit, 0.5, 0.5);
			}
		}*/

		var pattern = false;
    var draw, gap;
		switch(type){
			case "small-dashed":
				pattern = true;
				draw = 3;
				gap = 3;
				break;
			case "long-dashed":
				pattern = true;
				draw = 7;
				gap = 4;
				break;
			case "dotted":
				pattern = true;
				draw = 0.5;
				gap = 6;
				break;
			default:	// plain
				break;
		}

		var divid = 5;
		switch(step){
			case "25":
				divid = 2;
				break;
			case "100":
				divid = 10;
				break;
			default:
				break;
		}

		if(!Empty(color))
			this.wcanvas.fillColor = color;
		if(!Empty(stroke+""))
			this.wcanvas.lineWidth = stroke;

		for(var z=0; z<wz; z++){
			if(z%divid == 0){
				if(!pattern)
					this.wcanvas.DrawLine(z*wunit, 0, z*wunit, hlen, true); //linea verticale
				else
					this.wcanvas.DrawDashedLine(z*wunit, 0, z*wunit, hlen, draw, gap); //linea verticale
			}
		}
		for(z=0; z<hz;	z++){
			if(z%divid == 0){
				if(!pattern)
					this.wcanvas.DrawLine(0, z*wunit, wlen, z*wunit, true); //linea orizzontale
				else
					this.wcanvas.DrawDashedLine(0, z*wunit, wlen, z*wunit, draw, gap); //linea orizzontale
			}
		}
	}

    this.DrawHorizontal=function(wlen,color,stroke){
      var wunit=1
      if(this.workunit == "mm" || this.workunit == "cm")
        wunit = 2.834*96/72 //mm to points

	  if(this.workunit == "px")
        wunit = 96/72

      wunit = wunit*this.scale/100;
      var w = wlen*this.scale/100;
      var wz = Round((w/wunit),0);
      this.wcanvas = CanvasLib.Init(this.divid,w,20);
	  this.wcanvas.Clear();
	  this.wcanvas.alphaChannel=1;
      this.wcanvas.scale=this.scale;
      if(this.bdraw==false)
        return;

	  if(!Empty(color))
		this.wcanvas.fillColor = color;
	  if(!Empty(stroke+""))
		this.wcanvas.lineWidth = stroke;

      for(var z=0; z<wz; z++){
        if(this.workunit == "mm" || this.workunit == "cm"){
          if(z%10 == 0){
            if(this.workunit == "cm"){
              if(this.wcanvas.isIE){
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true,'<br>'+"&nbsp;"+(z/10),this.font,this.fontsize);
              }
              else{
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true);
                this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+(z/10))
              }
            }
            else if(this.workunit == "mm"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true);
                this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
              }
            }
          }
          else if(z%5 == 0){
            if(this.scale >= 200){
              if(this.workunit == "cm"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true,'<br>'+"&nbsp;"+(z/10),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+(z/10))
                }
              }
              else if(this.workunit == "mm"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
                }
              }
            }
            else
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
          }
          else{
            this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 3, true)
          }
        }
        else if(this.workunit == "pt" || this.workunit == "px"){
          if(z%50 == 0){
            if(this.wcanvas.isIE)
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
            else{
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true);
              this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
            }
          }
          else if(z%25 == 0){
            if(this.scale >= 175){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
                this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
              }
            }
            else
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
          }
          else if(z%5 == 0){
            if(this.scale >= 300){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true);
                this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
              }
            }
            else
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true);
          }
          else{
            if(this.scale > 200)
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 3, true);
          }
        }
        else{
          if(z%72 == 0){
            if(this.workunit == "pc"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true,'<br>'+"&nbsp;"+(z/12),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true);
                this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+(z/12))
              }
            }
            /*else if(this.workunit == "pt" || this.workunit == "px"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true);
                this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
              }
            }*/
            else if(this.workunit == "inch"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true,'<br>'+"&nbsp;"+(z/72),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 10, true);
                this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+(z/72))
              }
            }
          }
          else if(z%36 == 0){
            if(this.scale >= 175){
              if(this.workunit == "pc"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true,'<br>'+"&nbsp;"+(z/12),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+(z/12))
                }
              }
              /*else if(this.workunit == "pt" || this.workunit == "px"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
                }
              }*/
              else if(this.workunit == "inch"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true,'<br>'+"&nbsp;"+(z/72),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+(z/72))
                }
              }
            }
            else
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 7, true);
          }
          else if(z%6 == 0){
            if(this.scale >= 300){
              if(this.workunit == "pc"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true,'<br>'+"&nbsp;"+(z/12),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+(z/12))
                }
              }
              /*else if(this.workunit == "pt" || this.workunit == "px"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true,'<br>'+"&nbsp;"+(z),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,z*wunit,12,wunit,15,' '+z)
                }
              }*/
              else if(this.workunit == "inch"){
              }
            }
            else
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 5, true)
          }
          else{
            if(this.scale > 200)
              this.wcanvas.DrawLine(z*wunit, 0, z*wunit, 3, true)
          }
        }
      }
    }

    this.DrawVertical=function(hlen,color,stroke){
      var wunit=1
      if(this.workunit == "mm" || this.workunit == "cm")
        wunit = 2.834*96/72 //mm to points

	  if(this.workunit == "px")
        wunit = 96/72

      wunit = wunit*this.scale/100;
      var h = hlen*this.scale/100;
      var wz = Round((h/wunit),0);
      this.wcanvas = CanvasLib.Init(this.divid,40,h);
      this.wcanvas.Clear();
      this.wcanvas.alphaChannel=1;
      this.wcanvas.scale=this.scale;
      if(this.bdraw==false)
        return;

	  if(!Empty(color))
		this.wcanvas.fillColor = color;
	  if(!Empty(stroke+""))
		this.wcanvas.lineWidth = stroke;

      for(var z=0; z<wz; z++){
        if(this.workunit == "mm" || this.workunit == "cm"){
          if(z%10 == 0){
            if(this.workunit == "cm"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true,Replicate("&nbsp;",4)+(z/10),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/10))
              }
            }
            else if(this.workunit == "mm"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
              }
            }
          }
          else if(z%5 == 0){
            if(this.scale >= 200){
              if(this.workunit == "cm"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true,Replicate("&nbsp;",4)+(z/10),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/10))
                }
              }
              else if(this.workunit == "mm"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
                }
              }
            }
            else
              this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
          }
          else{
            this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
          }
        }
        else if(this.workunit == "pt" || this.workunit == "px"){
          if(z%50 == 0){
            if(this.wcanvas.isIE)
              this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
            else{
              this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
              this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
            }
          }
          else if(z%25 == 0){
            if(this.scale >= 175){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
              }
            }
            else
              this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
          }
          else if(z%5 == 0){
            if(this.scale >= 300){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
              }
            }
            else
              this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
          }
          else{
            if(this.scale > 200)
              this.wcanvas.DrawLine(0, z*wunit, 3, z*wunit, true);
          }
        }
        else{
          if(z%72 == 0){
            if(this.workunit == "pc"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true,Replicate("&nbsp;",4)+(z/12),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/12))
              }
            }
            /*else if(this.workunit == "pt" || this.workunit == "px"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
              }
            }*/
            else if(this.workunit == "inch"){
              if(this.wcanvas.isIE)
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true,Replicate("&nbsp;",4)+(z/72),this.font,this.fontsize);
              else{
                this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/72))
              }
            }
          }
          else if(z%36 == 0){
            if(this.scale >= 175){
              if(this.workunit == "pc"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true,Replicate("&nbsp;",4)+(z/12),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/12))
                }
              }
              /*else if(this.workunit == "pt" || this.workunit == "px"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
                }
              }*/
              else if(this.workunit == "inch"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true,Replicate("&nbsp;",4)+(z/72),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/72))
                }
              }
            }
            else
              this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
          }
          else if(z%6 == 0){
            if(this.scale >= 300){
              if(this.workunit == "pc"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true,Replicate("&nbsp;",4)+(z/12),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/12))
                }
              }
              /*else if(this.workunit == "pt" || this.workunit == "px"){
                if(this.wcanvas.isIE)
                  this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true,Replicate("&nbsp;",4)+(z),this.font,this.fontsize);
                else{
                  this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
                  this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
                }
              }*/
              else if(this.workunit == "inch"){
              }
            }
            else
              this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
          }
          else{
            if(this.scale > 200)
              this.wcanvas.DrawLine(0, z*wunit, 3, z*wunit, true);
          }
        }
      }
    }

    this.ScrollHorizontal=function(offset){
      Ctrl(this.divid).scrollLeft = offset
    }

    this.ScrollVertical=function(offset){
      Ctrl(this.divid).scrollTop = offset
    }
    this.currRefIdH=''
    this.currRefIdV=''
    this.AddHorizontalLine=function(divstr, xpos, ypos,color,item){
      //if(!Empty(this.currRefIdH) && this.currRefIdH!=item)
      //  $$('.RefHLines').dispose()
      if(Ctrl(divstr)) Ctrl(this.divid).removeChild(Ctrl(divstr));
      if(this.bdraw==false)
        return;
        var divT=document.createElement("div");
        divT.setAttribute("id", divstr);
        divT.style.zIndex=1010;
        divT.style.position="absolute"
        divT.style.top=0
        divT.style.color=color
        divT.style.left=xpos+"px"
        divT.style.width="1px"
        divT.style.height="10px"
        divT.style.borderLeft="1px solid"
        divT.style.fontSize="1px"
        divT.style.lineHeight="0"
        divT.className='RefHLines'
        divT.innerHTML = "";
        Ctrl(this.divid).appendChild(divT);
        this.currRefIdH=item;
    }
    this.AddVerticalLine=function(divstr, xpos, ypos, color,item){
        //if(!Empty(this.currRefIdV) && this.currRefIdV!=item)
        //$$('.RefVLines').dispose()
        if(Ctrl(divstr)) Ctrl(this.divid).removeChild(Ctrl(divstr));
        if(this.bdraw==false)
          return;
        var divT=document.createElement("div");
        divT.setAttribute("id", divstr);
        divT.style.zIndex=1010;
        divT.style.position="absolute"
        divT.style.top=ypos+"px"
        divT.style.color=color
        divT.style.left=0
        divT.style.width="10px"
        divT.style.height="1px"
        divT.style.borderTop="1px solid"
        divT.style.fontSize="1px"
        divT.style.lineHeight="0"
        divT.className='RefVLines'
        divT.innerHTML = "";
        Ctrl(this.divid).appendChild(divT);
        this.currRefIdV=item;
    }
    this.EmptyRefLines=function(){
      $$('.RefHLines').dispose();
      $$('.RefVLines').dispose();
    }
	}
}
