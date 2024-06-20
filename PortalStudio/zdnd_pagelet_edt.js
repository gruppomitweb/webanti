/*Z.AreaContainer*/
Z.PageletManager = Z.DnD.Manager.extend({

	constructor: function(){
		this.inherit();
	},

	updateDropletsUICoord: function(){
		for(var i=0; i<this.droplets.length; i++){
			this.droplets[i].UpdateUICoord();
		}
	},

	dragStart: function(e,h_element){
		var dragObj = this.inherit(e,h_element);
		this.currDroplet = this.currentDraglet.relDroplet;
		this.currentDraglet.relDroplet.setEvident();
		Ctrl('properties').style.display='none';
		return dragObj;
	},

	dragMove: function(e){
	  document.body.style.cursor="move"
		var dragObj = this.currentDraglet.dragObj;
		var y = parseInt(dragObj.css.top);
		var newDroplet,d,i;
		var px = e.clientX;
		var py = e.clientY;
    var l=this.droplets.length;
		for(i=0; i<l; i++){
			d=this.droplets[i];
			if(px >= d.x && px <= (d.x+d.w) && py >= d.y && py <= (d.y+d.h)){
				newDroplet = d;
				break;
			}
		}
		if(newDroplet){
			this.placeholder.style.visibility='visible';
			if(newDroplet!=this.currDroplet){
				//cambia droplet
				this.currDroplet.remDraglet(this.currentDraglet);
				this.currDroplet.remEvident();
				this.currDroplet = newDroplet;
				this.currDroplet.htmlElement.appendChild(this.placeholder);
				this.currDroplet.addDraglet(this.currentDraglet);
				this.updateDropletsUICoord();
			}
			this.currDroplet.setEvident();
			//posiziona il placeholder
			var sibs = this.currDroplet.getDragletsHtml();
			var h_drag = this.currentDraglet.htmlElement;
			var phPos;
			for(i=0, l=sibs.length; i<l; i++){
				if(sibs[i]==h_drag){
					phPos=i; break;
				}
			}

			if (phPos!=0 && y<=Z.LSUtils.findPosY(sibs[phPos-1])) {
				this.placeholder.parentNode.removeChild(this.placeholder);
				sibs[phPos-1].parentNode.insertBefore(this.placeholder, sibs[phPos-1]);
				this.currDroplet.swapDraglets(this.currentDraglet, this.currDroplet.getDraglets()[phPos-1]);
				this.updateDropletsUICoord();
			}

			if (phPos!=(sibs.length-1) && y>=Z.LSUtils.findPosY(sibs[phPos+1])) {
				if (sibs[phPos+2]) {
					this.currDroplet.swapDraglets(this.currentDraglet, this.currDroplet.getDraglets()[phPos+1]);
					this.placeholder.parentNode.removeChild(this.placeholder);
					sibs[phPos+2].parentNode.insertBefore(this.placeholder, sibs[phPos+2]);
				} else {
					var sibs2 = this.currDroplet.getDraglets();
					this.currDroplet.swapDraglets(this.currentDraglet,sibs2[sibs2.length-1]);
					sibs[phPos+1].parentNode.appendChild(this.placeholder);
				}
				this.updateDropletsUICoord();
			}
		}else{
			//drag all'esterno di ogni droplet
			this.currDroplet.remEvident()
			this.placeholder.style.visibility='hidden';
		}
	},

	dragEnd: function(/*e*/){
		this.currentDraglet.relDroplet=this.currDroplet;
		this.currDroplet.remEvident();
		var col = this.placeholder.parentNode;
		this.restoreProps();//se la si esegue dopo insertBefore in ie non viene visualizzato l'elemento
		var ifrs = this.currentDraglet.htmlElement.getElementsByTagName('iframe')
		if(ifrs.length) ifrs[0].style.display='none';//#IEbug; dopo lo visualizzo nuovamente perchè in ie dopo il drag sparice e non si vede piu'
		col.insertBefore(this.currentDraglet.htmlElement, this.placeholder);
		col.removeChild(this.placeholder);
		if(ifrs.length) ifrs[0].style.display='block';//#IEbug; prima l'ho nascosto perchè in ie dopo il drag sparice e non si vede piu'
		this.currentDraglet = null;
		this.placeholder = null;
		this.updateDropletsUICoord();
		document.body.style.cursor="default"
	  Ctrl('properties').style.display = '';
	},

	restoreProps: function(){
		//ripristina le proprieta'
		var cd = this.currentDraglet.dragObj
		for(var prop in cd.down){
			cd.css[prop] = cd.down[prop];
		}
		//nasconde il div di copertura
		var iframeSaver = Ctrl('iframe_saver');
		if(iframeSaver)
			iframeSaver.style.display = 'none';
	}
});
