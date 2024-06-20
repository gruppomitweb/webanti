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
    this.parameterObj={};
    this.wunit=0;

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

    this.Draw=function(x1,y1,x2,y2, dim, txt ){
      if( x1 == x2 ) //vertical
        this.wcanvas.DrawLine( x1 * this.wunit, 0, x2 * this.wunit, dim, true);
      else
        this.wcanvas.DrawLine( 0, y1 * this.wunit , dim, y2 * this.wunit, true);
      if( txt != '')
        this.wcanvas.DrawText( this.font, this.fontsize, x1 * this.wunit, 12, this.wunit, 15, txt)
    }
    this.DrawHorizontal=function(wlen){
      // var XX = new Date().getTime();
      var wunit = 1;
      if(this.workunit == "mm" || this.workunit == "cm")
        wunit = 2.834*96/72; //mm to points

      if(this.workunit == "px")
        wunit = 96/72;

      wunit = wunit*this.scale/100;
      this.wunit = wunit;
      var w = wlen*this.scale/100;
      var wz = Round((w/wunit),0);
      this.wcanvas = CanvasLib.Init(this.divid,w,25);
      this.wcanvas.fillColor = [161,161,161];
      this.wcanvas.Clear();
      this.wcanvas.alphaChannel=1;
      this.wcanvas.scale=this.scale;
      if(this.bdraw==false)
        return;

      var txt="", dim=0;


      for(var z=0; z<wz; z++){
        dim = 0;
        txt = '';
        switch( this.workunit ){
          case "mm":
          case "cm":
            if(z%10 == 0){
              //scrittura ogni 10
              dim = 10;
              if(this.workunit == "cm"){
                txt = ' '+(z/10);
              }else if(this.workunit == "mm"){
                txt = ' '+z;
              }
            }else if(z%5 == 0){ //scrittura ogni 5
              dim = 7;
              if(this.scale >= 200){
                if(this.workunit == "cm"){
                  txt = ' '+(z/10);
                }else if(this.workunit == "mm"){
                  txt = ' '+z;
                }
              }else
                txt = ''
            }else{
              dim = 3;
              txt = '';
            }
            if( dim )
              this.Draw(z, 0, z, dim, dim, txt);
          break;
          case "pt":
          case "px":
              txt =  ' '+z;
            if(z%50 == 0){
              dim = 10;
            }
            else if(z%25 == 0){
              dim = 7;
              if(this.scale < 175){
                txt = '';
              }
            }else if(z%5 == 0){
              dim = 5;
              if(this.scale < 300){
                txt = '';
              }
            }else{
              if(this.scale > 200){
                dim = 3;
                txt = ''
              }
            }
            if( dim )
              this.Draw(z, 0, z, dim, dim, txt);
          break
          case "pc":
          case "inch":
            if(z%72 == 0){
              dim = 10
              if(this.workunit == "pc"){
                txt = ' '+(z/12);
              }else if(this.workunit == "inch"){
                txt = ' '+(z/72)
              }
            }else if(z%36 == 0){
              dim = 7;
              if(this.scale >= 175){
                if(this.workunit == "pc"){
                  txt = ' '+(z/12);
                }else if(this.workunit == "inch"){
                  txt = ' '+(z/72)
                }
              }else
                dim = 7;
            }else if(z%6 == 0){
              dim = 5;
              if(this.scale >= 300){
                if(this.workunit == "pc"){
                  txt = ' '+(z/12);
                }else if(this.workunit == "inch"){
                  dim = 0;
                  txt = '';
                }
              }
              else
                txt = '';
            }else{
              if(this.scale > 200)
                dim = 3;
            }
            if( dim )
              this.Draw(z, 0, z, dim, dim, txt);
          break;
        }
      }
      // console.log(["DH "+(new Date().getTime()-XX)]);
    }

    this.DrawVertical=function(hlen){
      // var log = new Date().getTime();
      var wunit=1
      if(this.workunit == "mm" || this.workunit == "cm")
        wunit = 2.834*96/72 //mm to points

	  if(this.workunit == "px")
        wunit = 96/72

      wunit = wunit*this.scale/100;
      var h = hlen*this.scale/100;
      var wz = Round((h/wunit),0);
      this.wcanvas = CanvasLib.Init(this.divid,20,h);
      this.wcanvas.fillColor = [161,161,161];
      this.wcanvas.Clear();
      this.wcanvas.alphaChannel=1;
      this.wcanvas.scale=this.scale;
      if(this.bdraw==false)
        return;
      for(var z=0; z<wz; z++){
        if(this.workunit == "mm" || this.workunit == "cm"){
          if(z%10 == 0){
            if(this.workunit == "cm"){
              this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
              this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/10))
            }
            else if(this.workunit == "mm"){
              this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
              this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
            }
          }
          else if(z%5 == 0){
            if(this.scale >= 200){
              if(this.workunit == "cm"){
                this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/10))
              }
              else if(this.workunit == "mm"){
                this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
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
            this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
            this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
          }
          else if(z%25 == 0){
            if(this.scale >= 175){
              this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
              this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
            }
            else
              this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
          }
          else if(z%5 == 0){
            if(this.scale >= 300){
              this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
              this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,z)
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
              this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
              this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/12))
            }else if(this.workunit == "inch"){
              this.wcanvas.DrawLine(0, z*wunit, 10, z*wunit, true);
              this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/72))
            }
          }
          else if(z%36 == 0){
            if(this.scale >= 175){
              if(this.workunit == "pc"){
                this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/12))
              }else if(this.workunit == "inch"){
                this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/72))
              }
            }
            else
              this.wcanvas.DrawLine(0, z*wunit, 7, z*wunit, true);
          }
          else if(z%6 == 0){
            if(this.scale >= 300){
              if(this.workunit == "pc"){
                this.wcanvas.DrawLine(0, z*wunit, 5, z*wunit, true);
                this.wcanvas.DrawText(this.font,this.fontsize,7,z*wunit+7,10,wunit,(z/12))
              }else if(this.workunit == "inch"){
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
      // console.log(["DV "+(new Date().getTime()-log)]);
    }

    this.ScrollHorizontal=function(offset){
      Ctrl(this.divid).scrollLeft = offset
    }

    this.ScrollVertical=function(offset){
      Ctrl(this.divid).scrollTop = offset
    }
    this.currRefIdH=''
    this.currRefIdV=''
    this.AddHorizontalLine=function(divstr, xpos, ypos,item){
      //if(!Empty(this.currRefIdH) && this.currRefIdH!=item)
      //  $$('.RefHLines').dispose()
      if(Ctrl(divstr)) Ctrl(this.divid).removeChild(Ctrl(divstr));
      if(this.bdraw==false)
        return;
        var divT=document.createElement("div");
        divT.setAttribute("id", divstr);
        divT.style.left=xpos+"px"
        divT.className='RefHLines'
        Ctrl(this.divid).appendChild(divT);
        this.currRefIdH=item;
    }
    this.AddVerticalLine=function(divstr, xpos, ypos, item){
        //if(!Empty(this.currRefIdV) && this.currRefIdV!=item)
        //$$('.RefVLines').dispose()
        if(Ctrl(divstr)) Ctrl(this.divid).removeChild(Ctrl(divstr));
        if(this.bdraw==false)
          return;
        var divT=document.createElement("div");
        divT.setAttribute("id", divstr);
        divT.style.top=ypos+"px"
        divT.className='RefVLines'
        Ctrl(this.divid).appendChild(divT);
        this.currRefIdV=item;
    }
    this.EmptyRefLines=function(){
      $$('.RefHLines').dispose();
      $$('.RefVLines').dispose();
    }
	}
}




/* SUPPORT FUNCTIONS */
/* exported convertFromPixel */
function convertFromPixel(workunit,ab){
	if(workunit=="mm")
		return ab/2.834
	else if(workunit=="cm")
		return ab/28.34
	else if(workunit=="pc")
		return ab/12;
	else if(workunit=="inch")
		return ab/72;
	else
		return ab;
}

/* exported convertToPixel */
function convertToPixel(workunit,ab){
	if(workunit=="mm")
		return ab*2.834
	else if(workunit=="cm")
		return ab*28.34
	else if(workunit=="pc")
		return ab*12;
	else if(workunit=="inch")
		return ab*72;
	else
		return ab;
}
