var descriptionList = [];

descriptionList["portlet"] = [];
descriptionList["portlet"]["chart"] = [];
descriptionList["portlet"]["chart"] = {
	data_order: {
		desc: "",
		link: ""
	},
	downloadlist: {
		desc: "The property allows the user to export the inset.",
		link: ""
	},
	chart_type: {
		desc: "Set category chart type",
		link: "prova"
	}
}






/* exported getPropertyDescriptionObj */
function getPropertyDescriptionObj(tool,obj,prop){
	return descriptionList[tool][obj][prop];
}

/* exported getDescList */
function getDescList(){
	return descriptionList;
}
