/*****************************************************************

	CanvasLib Object: This library allow us to use Canvas in a "browser-agnostic" way

	@Author: Stefano Ceschi Berrini - Zucchetti Padova

*****************************************************************/

if (typeof(CanvasLib)=='undefined') {

	CanvasLib=new function(){
    //Content name
    this.container;
	this.canvas;
	this.scale = 100;
	this.scaleincrement = 20;
	this.rotation = 0;
		//Browser Name
		this.browserName=navigator.appName;

		//I hope we are in a Netscape or Opera Browser
		this.isIE=false;

		//Namespace for IE is not active atm. Read above
		this.namespaceactivated=false;

		//Fill color
		this.fillColor = [0,0,0];

		//Alpha transparency
		this.alphaChannel = 0.5;

		//Environment Initialization
    this.id,this.w,this.h;

	this.lineWidth = 0.5;

    this.Init=function(id, w, h){
      this.id=id;
      this.w=w;
      this.h=h;
	  this.rotation=0;
	  if(!document.createElement('canvas').getContext)
      this.isIE=true;
	  //if(this.browserName == "Microsoft Internet Explorer"){ //IE Check
		//this.isIE=true;
    if(this.isIE){
		// setup namespace (WORKING!)
		if (!document.namespaces["g_vml_"]) {
      document.namespaces.add('g_vml_', 'urn:schemas-microsoft-com:vml', "#default#VML");
		}
		// setup default css (WORKING!)
		try{
		  var ss = document.createStyleSheet();
		  ss.cssText = "g_vml_\:*{behavior:url(#default#VML)}";
		}catch(e){}

	  }
			//Nothing, we're using a !MS browser


	  var tmpObj = document.getElementById(id);
	  tmpObj.style.width = w + "px";
	  tmpObj.style.height = h + "px";
	  tmpObj.style.overflow = "hidden";
	  this.container = tmpObj;
	  this.canvas = tmpObj;

      if(!this.isIE){
			var UID=AlfaKeyGen(10);
			tmpObj.innerHTML = '<canvas id="'+UID+'" width="' + w + '" height="' + h + '"></canvas>';
			tmpObj = document.getElementById(UID);
			if(tmpObj.getContext){
				this.container = tmpObj.getContext("2d");
				this.canvas = tmpObj;
			}
      }
      return this;
	}

    this.Clear=function(){
      if(!this.isIE){
        var tmpObj = document.getElementById(this.id);
        var UID=AlfaKeyGen(10);
        tmpObj.innerHTML = '<canvas id="'+UID+'" width="' + this.w + '" height="' + this.h + '"></canvas>';
		tmpObj = document.getElementById(UID);
        if(tmpObj.getContext){
			this.container = tmpObj.getContext("2d");
			this.canvas = tmpObj;
        }
      }
	  else
        this.container.innerHTML = "";
    }

		/*
		*******************************************

		All the CanvasLib public functions (methods)

		*******************************************
		*/

		/*
      @Name: DrawText
			@Param:
		*/
		this.DrawText=function(font,fontsize,x,y,w,h,text){
			if(this.isIE){
				this.container.innerHTML += '<div style="width:' + w + 'px;height:' + h + 'px;position:absolute;left:' + x + 'px;top:' + y + 'px;font:'+font+';font-size:'+fontsize+'px">' + text +'</div>';
			}
			else{
				this.container.font = fontsize + "px " + font;
				this.container.fillText(text, x, y);
			}
		}

		/*
      @Name: DrawRect
			@Param:
		*/
    this.DrawRect=function(x,y,w,h,filled){
		if(this.isIE){
			var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
			if(filled)
			  this.container.innerHTML += '<g_vml_:rect style="width:' + w + ';height:' + h + ';position:absolute;left:' + x + 'px;top:' + y + 'px;" fillcolor="'+col+'"><g_vml_:fill opacity="'+this.alphaChannel+'"/></g_vml_:rect>';
			else
			  this.container.innerHTML += '<g_vml_:rect style="width:' + w + ';height:' + h + ';position:absolute;left:' + x + 'px;top:' + y + 'px;"  StrokeColor="'+col+'"><g_vml_:fill opacity="'+this.alphaChannel+'"/></g_vml_:rect>';
		}else{
			if(filled){
			  this.container.fillStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
			  this.container.fillRect(x,y,w,h);
						this.container.strokeRect(x,y,w,h);
			}else{
			  this.container.strokeRect(x,y,w,h);
			}
			}
		}

		/*
			@Name: DrawLine
			@Param:
		*/
	this.DrawLine=function(x1,y1,x2,y2,colorline,text,font,fontsize){
			if(this.isIE){
				var line = document.createElement("g_vml_:line");
				var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
				line.style.position = "absolute";
				line.style.left = x1;
				line.style.top = y1;
				line.from = x1+','+y1;
				line.to=(x2)+","+(y2);
				if(colorline){
					line.strokecolor = col;
				}
				var lineOp = document.createElement("g_vml_:stroke");
				lineOp.opacity = this.alphaChannel;
				line.appendChild(lineOp);

				if(text){
					if(font && fontsize){
						var fontObj = document.createElement("div");
						fontObj.style.fontFamily = font;
						fontObj.style.fontSize = fontsize+"px";
						fontObj.style.lineHeight = fontsize+"px";
						fontObj.innerHTML=text
						line.appendChild(fontObj);
					}
				}

				this.container.appendChild(line);
				//this.container.innerHTML += '<g_vml_:line style="position:absolute;left:' + x1 + 'px;top:' + y1 + 'px;" from="0,0" to="' + (x2-x1) + ',' + (y2-y1) + '"><g_vml_:stroke opacity="'+this.alphaChannel+'"/></g_vml_:line>';
			}
			else{
				this.container.strokeStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
				this.container.beginPath();
				this.container.moveTo(x1,y1);
				this.container.lineTo(x2,y2);
				this.container.lineWidth=this.lineWidth;
				this.container.stroke();
			}
		}

		this.DrawDashedLine=function(x1,y1,x2,y2,stepDraw,stepPause){
			// manca x IE 9-
			this.container.strokeStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
			this.container.beginPath();
      var i;
			if(x1==x2){	//verticale
				for(i=y1; i<=y2; i=i+(stepPause+stepDraw)){
					this.container.moveTo(x1,i);
					this.container.lineTo(x1,i+stepDraw);
				}
			}
			else if(y1==y2){	//orizzontale
				for(i=x1; i<=x2; i=i+(stepPause+stepDraw)){
					this.container.moveTo(i,y1);
					this.container.lineTo(i+stepDraw,y1);
				}
			}
			this.container.lineWidth=this.lineWidth;
			this.container.stroke();
		}

	this.DrawRhombus=function(x,y,w,h){
			if(this.isIE){
				var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
				var sel = document.createElement("g_vml_:shape");
				sel.style.position = "absolute";
				sel.style.left = x;
				sel.style.top = y;
				sel.style.width = w;
				sel.style.height = h;
				sel.coordsize=w+ "," +h;
				sel.fillcolor = col;
				var interMx = parseInt(x+(w/2));
				var interMy = parseInt(y+(h/2));
				var path = document.createElement("g_vml_:path");
				path.v = "m "+ interMx +","+ y;
				path.v += " l" +" " + (x+w) +","+ interMy + " ";
				path.v += interMx + "," + (y+h) + " ";
				path.v += x +","+ interMy + " x e";
				sel.appendChild(path);

				var selOp = document.createElement("g_vml_:fill");
				selOp.opacity = this.alphaChannel;
				sel.appendChild(selOp);

				this.container.appendChild(sel);

        //this.container.innerHTML += '<g_vml_:line style="position:absolute;left:' + x1 + 'px;top:' + y1 + 'px;" from="0,0" to="' + (x2-x1) + ',' + (y2-y1) + '"><g_vml_:stroke opacity="'+this.alphaChannel+'"/></g_vml_:line>';
			}else{
				this.container.fillStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
				this.container.beginPath();
		        this.container.moveTo(x+(w/2),y);
		        this.container.lineTo(x+w,y+(h/2));
		        this.container.lineTo(x+(w/2),y+h);
		        this.container.lineTo(x,y+(h/2));
		        this.container.lineTo(x+(w/2),y);
		        this.container.fill();
				this.container.stroke();
			}
		}

	this.DrawSelector=function(x,y,w,h){
    var pFirst, pSecond;
			if(this.isIE){
				var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
				var sel = document.createElement("g_vml_:shape");
				sel.style.position = "absolute";
				sel.style.left = x;
				sel.style.top = y;
				sel.style.width = w;
				sel.style.height = h;
				sel.coordsize=w+ "," +h;
				sel.fillcolor = col;
				pFirst = parseInt((w*15)/100);
				pSecond = w-pFirst;
				var interM = parseInt(y+(h/2));
				var path = document.createElement("g_vml_:path");
				path.v = "m "+ parseInt(x+pFirst) +","+ y;
				path.v += " l" +" " + parseInt(x+pSecond) +","+ y + " ";
				path.v += (x+w)+ "," + interM + " ";
				path.v += parseInt(x+pSecond)+","+ (y+h) + " " ;
				path.v += parseInt(x+pFirst)+","+ (y+h) + " " + x +","+ interM + " x e";
				sel.appendChild(path);

				var selOp = document.createElement("g_vml_:fill");
				selOp.opacity = this.alphaChannel;
				sel.appendChild(selOp);

				this.container.appendChild(sel);

				/*

			   <v:shape strokecolor="red"
			   coordorigin="0 0" coordsize="200 200"
			   style="top:1;left:1;width:50;height:50">
			   <v:path v="m 1,1 l 1,200, 200,200, 200,1 x e"/>
			   </v:shape>

				m 0,0: Move to the point (0, 0).
				l 200,200: Draw a line from the current position to (200, 200). (That's an L, not a one.)
				e: End drawing.
				*/

			}else{
				this.container.fillStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
				pFirst = parseInt((w*15)/100);
				pSecond = w-pFirst;
				this.container.beginPath();
		        this.container.moveTo(x+pFirst,y);
		        this.container.lineTo(x+pSecond,y);
		        this.container.lineTo(x+w,y+(h/2));
		        this.container.lineTo(x+pSecond,y+h);
		        this.container.lineTo(x+pFirst,y+h);
				this.container.lineTo(x,y+(h/2));
				this.container.lineTo(x+pFirst,y);
		        this.container.fill();
				this.container.stroke();
			}
		}

		/*
			@Name: DrawArc
			@Param:
		*/
    this.DrawArc=function(x,y,radius,filled){
			if(this.isIE){
        var col, arc, arcOp;
				if(filled){
					col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
					arc = document.createElement("g_vml_:oval");
					arc.style.position = "absolute";
					arc.style.left = x-radius;
					arc.style.top = y-radius;
					arc.style.width = radius*2;
					arc.style.height = radius*2;
					arc.strokeweight="1pt";
					arc.fillcolor=col;
					arcOp = document.createElement("g_vml_:fill");
					arcOp.opacity = this.alphaChannel;
					arc.appendChild(arcOp);
					this.container.appendChild(arc);


          		/*this.container.innerHTML += '<g_vml_:oval style="position:absolute;' +
          		'left:' + (x-radius) + 'px;top:' + (y-radius) + 'px;" style="' +
          		'width:'+(radius*2)+';height:'+(radius*2)+'" strokeweight="1pt"  ' +
          		'fillcolor="'+col+'" ><g_vml_:fill opacity="'+this.alphaChannel+'"/>' +
          		'</g_vml_:oval>'
          		*/
				}else{
					col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
					arc = document.createElement("g_vml_:oval");

					arc.style.position = "absolute";
					arc.style.left = x-radius;
					arc.style.top = y-radius;
					arc.style.width = radius*2;
					arc.style.height = radius*2;
					arc.strokeweight="1pt";
					arc.filled="false";
					arcOp = document.createElement("g_vml_:stroke");
					arcOp.opacity = this.alphaChannel;
					arc.appendChild(arcOp);
					this.container.appendChild(arc);
          			/*this.container.innerHTML += '<g_vml_:oval style="position:absolute;left:' + (x-radius) + 'px;' +
          					'top:' + (y-radius) + 'px;" style="width:'+(radius*2)+';height:'+(radius*2)+'" ' +
          					'filled="false" strokeweight="1pt" />'
          					*/
				}
				//obj.innerHTML += '<g_vml_:line style="position:absolute;left:' + x1 + 'px;top:' + y1 + 'px;" from="0,0" to="' + (x2-x1) + ',' + (y2-y1) + '" />';
			}else{
				this.container.fillStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
				this.container.beginPath();
				this.container.arc(x,y,radius,0,Math.PI*2,true);
				if(filled){
					this.container.fill();
					this.container.stroke();
				}else{
					this.container.stroke();
				}
			}
		}
    this.RoundRect = function(x,y,width,height,radius,filled){
			if(this.isIE){
				//obj.innerHTML += '<g_vml_:roundrect style="width:100;height:100" arcsize="0.3" fillcolor="blue" strokecolor="red"/>'
				if(filled){
					var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
					this.container.innerHTML += '<g_vml_:roundrect arcsize="'+(radius/100)+'" fillcolor="'+col+'" style="position:absolute;left:' + x + 'px;top:' + y + 'px;width:'+width+';height:'+height+';" filled="true"><g_vml_:fill opacity="'+this.alphaChannel+'"/></g_vml_:roundrect>';
				}else{
					this.container.innerHTML += '<g_vml_:roundrect arcsize="'+(radius/100)+'" style="position:absolute;left:' + x + 'px;top:' + y + 'px;width:'+width+';height:'+height+';" filled="false"/>';
				}
				//obj.innerHTML += '<g_vml_:line style="position:absolute;left:' + x1 + 'px;top:' + y1 + 'px;" from="0,0" to="' + (x2-x1) + ',' + (y2-y1) + '" />';
			}else{
					this.container.fillStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
					this.container.beginPath();
					this.container.moveTo(x,y+radius);
					this.container.lineTo(x,y+height-radius);
					this.container.quadraticCurveTo(x,y+height,x+radius,y+height);
					this.container.lineTo(x+width-radius,y+height);
					this.container.quadraticCurveTo(x+width,y+height,x+width,y+height-radius);
					this.container.lineTo(x+width,y+radius);
					this.container.quadraticCurveTo(x+width,y,x+width-radius,y);
					this.container.lineTo(x+radius,y);
					this.container.quadraticCurveTo(x,y,x,y+radius);
					if(filled){
						this.container.fill();
						this.container.stroke();
					}else{
						this.container.stroke();
					}
				}
		}
		/*
			@Name: DrawFillkeRect
			@Param:
		*/
    	this.qCurve=function(mx,my,cp1x,cp1y,x,y){
			if(this.isIE){
				var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
        		this.container.innerHTML += '<g_vml_:curve from="'+mx+','+my+'" control1="'+cp1x+','+cp1y+'" to="'+x+','+y+'" strokeweight="1pt" filled="false" strokecolor="'+col+'"><g_vml_:stroke opacity="'+this.alphaChannel+'"/></g_vml_:curve>'
				//obj.innerHTML += '<g_vml_:line style="position:absolute;left:' + x1 + 'px;top:' + y1 + 'px;" from="0,0" to="' + (x2-x1) + ',' + (y2-y1) + '" />';
			}else{
			this.container.strokeStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
			this.container.beginPath();
			this.container.moveTo(mx,my);
			this.container.quadraticCurveTo(cp1x,cp1y,x,y);
			this.container.stroke();
			}
		}

		this.qCurves=function(mx,my,cPoints,x,y){
      var i, line, lineOp, cFrmX, cFrmY, cToX, cToY;
			if(this.isIE){
				var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
				var pX = 0;
				var pY = 0;
				var fX = 0;
				var fY = 0;
				for(i=0;i<cPoints.length;i++){
					if(pX != 0 || pY != 0){
						fX = pX;
						fY = pY;
					}
					if(i == (cPoints.length-1) && i != 0){
						line = document.createElement("g_vml_:curve");

						line.from = pX+","+pY;
						line.control1 = (cPoints[i].x+8)+","+(cPoints[i].y+8);

						line.to=x+","+y;
						line.filled="false";
						line.strokeweight="1pt";
						line.strokecolor=col;
						lineOp = document.createElement("g_vml_:stroke");
						lineOp.opacity = this.alphaChannel;
						line.appendChild(lineOp);
						this.container.appendChild(line);

						//this.container.innerHTML += '<g_vml_:curve from="'+pX+','+pY+'" control1="'+(cPoints[i].x+8)+','+(cPoints[i].y+8)+'" to="'+x+','+y+'" strokeweight="1pt" filled="false" strokecolor="'+col+'"><g_vml_:stroke opacity="'+this.alphaChannel+'"/></g_vml_:curve>'
						break;
					}else{
						cFrmX = cPoints[i].x+8;
						cFrmY = cPoints[i].y+8;
						cToX = 0;
						cToY = 0;
						pX = 0;
						pY = 0;
						if(cPoints.length != 1){
							cToX = cPoints[i+1].x+8;
							cToY = cPoints[i+1].y+8;
							pX = cToX - ((cToX-cFrmX)/2);
							pY = cFrmY - ((cFrmY-cToY)/2);
						}else{
							pX = x;
							pY = y;
						}
						if(i == 0){
							line = document.createElement("g_vml_:curve");

							line.from = mx+","+my;
							line.control1 = cFrmX+","+cFrmY;

							line.to=pX+","+pY;
							line.filled="false";
							line.strokeweight="1pt";
							line.strokecolor=col;
							lineOp = document.createElement("g_vml_:stroke");
							lineOp.opacity = this.alphaChannel;
							line.appendChild(lineOp);
							this.container.appendChild(line);

							//this.container.innerHTML += '<g_vml_:curve from="'+mx+','+my+'" control1="'+cFrmX+','+cFrmY+'" to="'+pX+','+pY+'" strokeweight="1pt" filled="false" strokecolor="'+col+'"><g_vml_:stroke opacity="'+this.alphaChannel+'"/></g_vml_:curve>'
						}else{
							line = document.createElement("g_vml_:curve");

							line.from = fX+","+fY;
							line.control1 = cFrmX+","+cFrmY;

							line.to=pX+","+pY;
							line.filled="false";
							line.strokeweight="1pt";
							line.strokecolor=col;
							lineOp = document.createElement("g_vml_:stroke");
							lineOp.opacity = this.alphaChannel;
							line.appendChild(lineOp);
							this.container.appendChild(line);

							//this.container.innerHTML += '<g_vml_:curve from="'+fX+','+fY+'" control1="'+cFrmX+','+cFrmY+'" to="'+pX+','+pY+'" strokeweight="1pt" filled="false" strokecolor="'+col+'"><g_vml_:stroke opacity="'+this.alphaChannel+'"/></g_vml_:curve>'
						}
					}
				}
			}else {
				this.container.strokeStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
				this.container.beginPath();
				this.container.moveTo(mx,my);
				pX = 0;
				pY = 0;
				for(i=0;i<cPoints.length;i++){
					if(pX != 0 || pY != 0)
						this.container.moveTo(pX,pY);
					if(i == (cPoints.length-1)){
						this.container.quadraticCurveTo(cPoints[i].x+8,cPoints[i].y+8,x,y);
						break;
					}else{
						cFrmX = cPoints[i].x+8;
						cFrmY = cPoints[i].y+8;
						cToX = cPoints[i+1].x+8;
						cToY = cPoints[i+1].y+8;

						pX = cToX - ((cToX-cFrmX)/2);
						pY = cFrmY - ((cFrmY-cToY)/2);

						this.container.quadraticCurveTo(cFrmX,cFrmY,pX,pY);
					}
				}
				this.container.stroke();
			}
		}

		this.DrawArrow=function(w,h,x,y,pos){
			if(this.isIE){
         x=600
         y=600
				var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";
				var arrow = document.createElement("g_vml_:shape");
				arrow.style.position = "absolute";
				arrow.style.left = x+'px';
				arrow.style.top = y+'px';
				arrow.style.width = w+'px';
				arrow.style.height = h+'px';
				arrow.coordsize=w+ "," +h;
				arrow.fillcolor = col;
				arrow.strokecolor = col;
				var path = document.createElement("g_vml_:path");
				switch(pos){
					case "bottom":
						path.v = "m "+ parseInt(x+(w/2)) +","+ y;
						path.v += " l" +" " + (x+w) +","+ (y+h) + " ";
						path.v += x + "," + (y+h) + " x e";
					break;
					case "top":
						path.v = "m "+ x +","+ y;
						path.v += " l" +" " + parseInt(x+w) +","+ y + " ";
						path.v += parseInt(x+(w/2)) + "," + parseInt(y+h) + " x e";
					break;
					case "left":
						path.v = "m "+ x +","+ y;
						path.v += " l" +" " + parseInt(x+w) +","+ parseInt(y+(h/2)) + " ";
						path.v += x + "," + parseInt(y+h) + " x e";
					break;
					case "right":
						path.v = "m "+ parseInt(x+w) +","+ y;
						path.v += " l" +" " + parseInt(x+w) +","+ parseInt(y+h) + " ";
						path.v += x + "," + parseInt(y+(h/2)) + " x e";
					break;
				}

				arrow.appendChild(path);

				var arOp = document.createElement("g_vml_:fill");
				arOp.opacity = this.alphaChannel;
				arrow.appendChild(arOp);

				this.container.appendChild(arrow);

			}else{
				this.container.fillStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";
				this.container.beginPath();
				switch(pos){
					case "bottom":
						this.container.moveTo(parseInt(x+(w/2)),y);
						this.container.lineTo((x+w),(y+h));
						this.container.lineTo(x,(y+h));
						this.container.lineTo(parseInt(x+(w/2)),y);
					break;
					case "top":
						this.container.moveTo(x,y);
						this.container.lineTo((x+w),y);
						this.container.lineTo(parseInt(x+(w/2)),(y+h));
						this.container.lineTo(x,y);
					break;
					case "left":
						this.container.moveTo(x,y);
						this.container.lineTo((x+w),parseInt(y+(h/2)));
						this.container.lineTo(x,(y+h));
						this.container.lineTo(x,y);
					break;
					case "right":
						this.container.moveTo(parseInt(x+w),y);
						this.container.lineTo(parseInt(x+w),parseInt(y+h));
						this.container.lineTo(x,parseInt(y+(h/2)));
						this.container.lineTo(parseInt(x+w),y);
					break;
				}
		        this.container.fill();
				this.container.stroke();
			}
		}

		this.DrawEllipse = function(centerX,centerY,dimensionX,dimensionY){
	    var col = "rgb("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+")";

    	if(this.isIE){
				var str = '<g_vml_:oval title="ellipse" strokeweight="1pt" filled="true" fillcolor="'+col+'" style="position:absolute;'
					+'left:'+(centerX-dimensionX/2)+'; '
					+'top:'+(centerY-dimensionY/2)+'; '
					+'width:'+dimensionX+'px; '
					+'height:'+dimensionY+'px'
				  +'"><g_vml_:fill opacity="'+this.alphaChannel+'"/></g_vml_:oval>';
        this.container.innerHTML += str;
				  return;
			}

    	this.container.save();
    	this.container.beginPath();
			this.container.fillStyle = "rgba("+this.fillColor[0]+","+this.fillColor[1]+","+this.fillColor[2]+","+this.alphaChannel+")";

    	dimensionX/=2;
    	dimensionY/=2;

    	if(dimensionX<dimensionY){ 	//scalo su X
                    var rapp = dimensionX/dimensionY;
                    this.container.translate(centerX-rapp*centerX,0);
    								this.container.scale(rapp,1);
    								this.container.arc(centerX,centerY,dimensionY,0,Math.PI*2,true);
    	}
    	else{ 	//scalo su Y
                    rapp = dimensionY/dimensionX;

    								this.container.translate(0,centerY-rapp*centerY);
    								this.container.scale(1,rapp);

    								this.container.arc(centerX,centerY,dimensionX,0,Math.PI*2,true);
    	}
    	this.container.fill();
		this.container.stroke();
    	this.container.restore();
    }



		this.Translate = function(x,y){
			this.transX = x;
			this.transX = y;

			if(this.isIE){

			}else{
				this.container.translate(x,y);
			}
		}

		this.Rotate = function(alfa){
			this.rotat = alfa;

			if(this.isIE){

			}else{
				this.container.rotate(alfa);
			}
		}

		this.Scale = function(scala){
			this.scale = scala;

			if(this.isIE){

			}else{
				this.container.scale(scala);
			}
		}

		// ZoomOut
		this.zoomOut = function() {
			if(this.scale>40){
				this.scale = this.scale - this.scaleincrement;
				this.refresh();
			}
		}

		// ZoomIn
		this.zoomIn = function() {
			if(this.scale<801){
				this.scale = this.scale + this.scaleincrement;
				this.refresh();
			}
		}

		// Zoom
		this.zoom = function(scale) {
			if(scale>24 && scale<801){
				this.scale = scale;
				this.refresh();
			}
		}

		/*
			@Name: SetAttrib
			@Param:
		*/
		this.SetAttrib=function(col,alpha){
		  var color = HexToRGB(col);
		  var alphac = parseFloat(alpha);
		  this.fillColor = color;
		  this.alphaChannel = alphac;
		}

		// Scale canvas
		this.canvasScale=function() {
		}

		this.refresh=function(){
			this.canvasScale();
		}


		/*Image*/
	this.DrawImage=function(src, x, y, w, h, r){
      var img;
			if(this.isIE){
				img = document.createElement("g_vml_:image");
				img.style.position = "absolute";
				var imgx = new Image();
				imgx.onload = function(){
				}
				switch(r) {
						default :
						case '0':
						case '360':
							img.style.left = x;
							img.style.top = y;
							img.style.width = w + "px";
							img.style.height = h + "px";
							img.src = src;
							this.container.appendChild(img);
							break;
						case '90' :
							img.style.rotation='90deg';
							img.style.top = (h-w)/2;
							img.style.left = -(h-w)/2;
							img.style.width = h + "px";
							img.style.height = w + "px";
							img.src = src;
							this.container.appendChild(img);
							break;
						case '180' :
							img.style.rotation='180deg';
							img.style.left = x;
							img.style.top = y;
							img.style.width = w + "px";
							img.style.height = h + "px";
							img.src = src;
							this.container.appendChild(img);
							break;
						case '270' :
						case '-90' :
							img.style.rotation='270deg';
							img.style.left = -(h-w)/2;
							img.style.top = (h-w)/2;
							img.style.width = h + "px";
							img.style.height = w + "px";
							img.src = src;
							this.container.appendChild(img);
							break;
				};
				imgx.src = src;
				return imgx;
			}else{
				var ctx = this.container;
				img = new Image();
				img.onload = function(){
					switch(r) {
						default :
						case '0':
						case '360':
							ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img,x, y,w,h);
							break;
						case '90' :
							ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img, x, -w,h,w);
							break;
						case '180' :
							ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img,-w,-h,w,h);
							break;
						case '270' :
						case '-90' :
							ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img, -h, y,h,w);
							break;
					};
				}
				img.src = src;
				return img;
			}
	}

	this.DrawRectImage=function(src, x, y, w, h, r){
		if(this.isIE){
				var imgx = new Image();
				imgx.onload = function(){
				}
				switch(r) {
						default :
						case '0':
						case '360':
							this.container.innerHTML += '<g_vml_:rect style="width:' + w + ';height:' + h + ';position:absolute;left:' + x + 'px;top:' + y + 'px"><img width="'+w+'" height="'+h+'" src="'+src+'" /></g_vml_:rect>';
							break;
						case '90' :
							this.container.innerHTML += '<g_vml_:rect style="width:' + h + ';height:' + w + ';position:absolute;left:' + (x-(h-w)/2) + 'px;top:' + (y+(h-w)/2) + 'px; rotation:'+ "90" + '"><g_vml_:stroke On="false"/><g_vml_:fill type="frame" src="'+src+'" rotate="t"/></g_vml_:rect>';
							break;
						case '180' :
							this.container.innerHTML += '<g_vml_:rect style="width:' + w + ';height:' + h + ';position:absolute;left:' + x + 'px;top:' + y + 'px; rotation:'+ "180" + '"><g_vml_:stroke On="false"/><g_vml_:fill type="frame" src="'+src+'" rotate="t"/></g_vml_:rect>';
							break;
						case '270' :
						case '-90' :
							this.container.innerHTML += '<g_vml_:rect style="width:' + h + ';height:' + w + ';position:absolute;left:' + (x-(h-w)/2) + 'px;top:' + (y+(h-w)/2) + 'px; rotation:'+ "270" + '"><g_vml_:stroke On="false"/><g_vml_:fill type="frame" src="'+src+'" rotate="t"/></g_vml_:rect>';
							break;
				};
				imgx.src = src;
				return imgx;
		}else{
				var ctx = this.container;
				var img = new Image();
				img.onload = function(){
					switch(r) {
						default :
						case '0':
						case '360':
							if(this.rotation != r )
								ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img,x, y,w,h);
							break;
						case '90' :

							if(this.rotation != r )
								ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img, y, -w-x,h,w);
							break;
						case '180' :
							if(this.rotation != r )
								ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img,-w-x,-y-h,w,h);
							break;
						case '270' :
						case '-90' :
							if(this.rotation != r )
								ctx.rotate(r * Math.PI / 180);
							ctx.drawImage(img, -h-y, x,h,w);
							break;
					};
					this.rotation = r;
				}
				img.src = src;
				return img;
		}
	}


	}//endCL
}//endIF


/* SUPPORT FUNCTIONS */

function HexToRGB(hex){
	var R = HexToR(hex);
	var G = HexToG(hex);
	var B = HexToB(hex);
	var tmp = [R,G,B];
	return tmp;
}
function HexToR(h){
	return parseInt((cutHex(h)).substring(0,2),16)
}
function HexToG(h){
	return parseInt((cutHex(h)).substring(2,4),16)
}
function HexToB(h){
	return parseInt((cutHex(h)).substring(4,6),16)
}
function cutHex(h){
	return (h.charAt(0)=="#") ? h.substring(1,7):h
}
function AlfaKeyGen(keyLen){
	var res="";
  	for(var i=0; i++<keyLen; res+=String.fromCharCode(Math.floor(Math.random()*26+97)));
	return res;
}

// EOF
