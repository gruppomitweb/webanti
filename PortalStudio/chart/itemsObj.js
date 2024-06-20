/* exported
    index itemsHTML m_bUpdated formProp last_index newPropObj getChartName getChartImageName newObj
*/

var index = null; // indice corrente del mainitem  nell'Array
var itemsHTML = new Array(); // Array contenente tutti gli oggetti item con id,HTML,shadow,ecc
var m_bUpdated = false;
var formProp = null;
var last_index, newPropObj, newObj = {};
var defversion = 2.0;

function initPropertiesDefaultValue(obj) {
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    var tab, ii;
    for (var i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        mainObject[tab[ii].propID] = tab[ii].defaultValue;
        if (typeof(tab[ii].defaultValue) == 'undefined') {
          if (tab[ii].type == 'str') { mainObject[tab[ii].propID] = ''; }
          else if (tab[ii].type == 'color') { mainObject[tab[ii].propID] = ''; }
          else if (tab[ii].type == 'checkbox') { mainObject[tab[ii].propID] = false; }
          else if (tab[ii].type == 'int') { mainObject[tab[ii].propID] = null; }
          else if (tab[ii].type.substring(0,7) == 'select[') {
            var s1 = tab[ii].type.substring(7, tab[ii].type.indexOf(","));
            var p = s1.indexOf(":");
            if (p >= 0) { s1 = s1.substring(p + 1); }
              mainObject[tab[ii].propID] = s1;
          }
        }
      }
    }
  }
}

if (typeof(ZTObjects) == 'undefined') {
	var ZTObjects = new function() {
		var charts_type = "select[Line:LINES,Line Time:TIME,Horizontal Bar:HBAR,Horizontal Bar 3D:HBAR3D,Vertical Bar:VBAR,Vertical Bar 3D:VBAR3D";
		charts_type += ",Gantt:GANTT,Stack Horizontal Bar:HSTACKBAR,Stack Horizontal Bar 3D:HSTACKBAR3D,Stack Vertical Bar:VSTACKBAR,Stack Vertical Bar 3D:VSTACKBAR3D";
		charts_type += ",Pie:PIE,Ring:RING,Pie 3D:PIE3D,Radar Line:RADARLINE,Radar Area:RADARAREA,Area:AREA,StackedArea:STACKEDAREA";
		charts_type += ",Scatter:SCATTER,Arc Dial:ARCDIAL,Bubble:BUBBLE,Thermometer:THERMO,Pareto:PARETO,Traffic Lights:LIGHTS,Images Chart:IMAGES,Display:DISPLAY";
		charts_type += ",Counter:COUNTER,Paddle:PADDLE,Waterfall:WATERF,Vertical Bar Time:TIMEBAR,Stack Horizontal Bar Time:TIMESTACK,Pie Time:TIMEPIE";
		charts_type += ",Lagplot:LAGPLOT,Arc Dial Time:TIMEARCDIAL,Traffic Lights Time:TIMELIGHTS,Display Time:TIMEDISPLAY,Bubble Time:TIMEBUBBLE,Area Time:TIMEAREA,Word Cloud:WORDCLOUD";
		charts_type += ",Pyramid Distribution:PYRAMID,Treemap:TREEMAP,Treemap Bar:TREEMAPBAR,Layered Bar:LAYEREDBAR,Treemap Horizontal Bar:TREEMAPBARH,Layered Horizontal Bar:LAYEREDBARH";
		charts_type += ",Geographic Map:GEOMAP,Aster Plot:ASTER,AreaBar:AREABAR,Sunburst:SUNB,Sunburst Structure:SUNBSTR,Tree:TREE,Tree Structure:TREESTR,Bubble Cloud:CPACK";
		charts_type += ",Circle Pack:CPACKSTR,Force Layout Structure:FORCESTR,Force Layout:FORCE,Adjacency Matrix:MATRIX,Chord Diagram:CHORD,Calendar:CAL,PyramidStructure:PYRSTR,Pyramid:PYR,NeckedPyramidStructure:NECKEDPYRSTR,NeckedPyramid:NECKEDPYR,Funnel:FUNNEL";
		charts_type += ",Marimekko:MARIMEKKO,Matrice BCG:BCMATRIX,Parallel Coordinates:PCOORDS,Voronoi:VORONOI,Sankey:SANKEY,Percentage Ring:RINGPERC]";
		var fonts_style = "select[,normal:N,bold:B,Italic:I,bold italic:BI]",
		grid_type = "select[Small dashed:small_dashed,Long dashed:long_dashed,dotted,plain]",
		//fonts_select2 = "select[,Arial,Arial Black,Comic Sans MS,Courier,DejaVu Sans,DejaVu Serif,Digital System,Electronic Highway Sign,Georgia,JD LCD Rounded Regular,Let's go Digital:Lets go Digital,Liquid Crystal,Lucida Sans,NovaMono,Open Sans,Share Tech Mono,Source Code Pro,Tahoma,Times New Roman,Ubuntu,Verdana,VT323]",
		fontsList = getAllFonts(),
		fList = fontsList.online,
		label_type = "select[horizontal:H,vertical:V,vertical down:VD,45Up:45U,45Down:45D]",
		timeformat_select = "select[,yyyy-mm-dd,dd-mm-yyyy,dd-MMM-yyyy,MMM-yyyy,yyyy,yyyy-mm-dd hh:mm:ss,yyyy-mm-dd hh:mm,hh:mm:ss,hh:mm]",
    global_font = "select[use global font:true,use custom font:false]",
    legend_font = "select[use legend font:true,use custom font:false]",
    show_hide = 'select[show:true,hide:false]',
    value_global_font = 'select[use value axis font:value,use global font:global,use custom font:custom]',
    value_line = 'select[use value axis style:true,use custom style:false]',
    reuse_colors = 'select[differs for each series:false,reuses for each series:true]',
    map_select = 'select[Simple definition:simple,Medium definition:medium,High definition:high,Complete:org]',
    pattern_select = 'select[,hexagons,wiggle,eyes,blank note,boxes,flipped diamonds,brick wall,hideout,subtle dots,simple horizontal,simple vertical,cross stripes,bamboo,rain,heavy rain,tiny checkers,smaller tiny checkers,4 point stars,stripes,horizontal stripes,diagonal stripes,diagonal lines,polka dots,pixel dots,bubbles]',
    defvlab = "outside top:otop,outside bottom:obottom,outside left:oleft,outside right:oright,inside:in",
    vervlab = "outside top:otop,outside bottom:obottom,inside center:in,inside top:itop,inside bottom:ibottom",
    horvlab = "outside left:oleft,outside right:oright,inside center:in,inside left:ileft,inside right:iright",
    pievlab = "outside:out,inside:in",
    vlavlab = "outside top:otop,inside top:itop",
    hlavlab = "outside right:oright,inside right:iright",
    pyrvlab = "ouside:out,inside center:in,inside border:iborder",
    outvlab = "outside top:otop,outside bottom:obottom,outside left:oleft,outside right:oright",
    sankeymiddlelab = "left,right", 
    sankeylab = "outside,inside", 
    value_labels = 'select[only domain label:label,only series label:ser,only value:value,Only percentage (series based):perc,only percentage (domain based):dperc,';
    value_labels += "label + value:labelvalue,series + value:servalue,series + label:serlabel,label + percentage (series based):labelperc,label + percentage (domain based):dlabelperc,";
    value_labels += "value + percentage (series based):valueperc,value + percentage (domain based):dvalueperc,series + percentage (series based):serperc,series + percentage (domain based):dserperc,both percentages:totperc]";


/*    


    var measureConfig = {
      hideTabs : ['treemap','graphtype','preview','slice','bars','radar','percentage_axis','time','display_label','waterfall','layout','line',
      'shapes','axis_label','domain_axis','value_axis','hierarchy','quadrants','overlapping'],
      hideProps : {
        general:['is3D','normalized','trendimages','digitNum','remfilltransp','mapdef','mapundefcol','mapundefstr','imageset', 'treelayout',
        'ordercol', 'lights_layout', 'display_layout','ringperc_bck', 'ringperc_layout'],
        gauge:['gaugeorient','gaugestyle','gfanlights','geffect','gfillcolor','pyramidrotation','hfunnel','wfunnel','funneltype'],
        value_label:['showTotVL','wprec','wusecfonttot','wfonttot','wsizetot','wcolortot','wstyletot','defvlabpos','vervlabpos','horvlabpos',
        'pievlabpos','vlavlabpos','hlavlabpos','pyrvlabpos','outvlabpos','vlzero','firstlastlabpos','middlabpos']
      }
    };

    var thermoConfig = {};
    thermoConfig.hideTabs = measureConfig.hideTabs.slice();
    thermoConfig.hideTabs.push("pointer");
    thermoConfig.hideTabs.push("cap");
    thermoConfig.hideTabs.push("radius");
    thermoConfig.hideProps = {};
    thermoConfig.hideProps.general = measureConfig.hideProps.general.slice();
    thermoConfig.hideProps.general.push('display_layout');
    thermoConfig.hideProps.value_label = treemapConfig.hideProps.value_label.slice();
    thermoConfig.hideProps.scale = ["scaletickradius", "scaleticklabeloffset"];
    thermoConfig.hideProps.tick_axis = ["startdeg", "enddeg"];
    thermoConfig.hideProps.gauge = measureConfig.hideProps.gauge.slice();
    thermoConfig.hideProps.gauge.splice(thermoConfig.hideProps.gauge.indexOf('gaugeorient'), 1);
    thermoConfig.hideProps.gauge.push("gstartdeg");
    thermoConfig.hideProps.gauge.push("genddeg");
    thermoConfig.hideProps.gauge.push("fitSize");

    var stateConfig = {
      hideTabs : ['treemap','graphtype','preview','slice','bars','radar','pointer','cap','scale','percentage_axis','time','radius','tick_axis',
      'display_label','waterfall','layout','axis_label','line','domain_axis','value_axis','shapes','hierarchy','quadrants','overlapping'],
      hideProps : {
        general: measureConfig.hideProps.general.slice(),
        gauge: ['gstartdeg','genddeg','gfillcolor','gbordercolor','gborderstroke','pyramidrotation','hfunnel','wfunnel','funneltype','fitSize'],
        value_label:['showTotVL','wprec','wusecfonttot','wfonttot','wsizetot','wcolortot','wstyletot','defvlabpos','vervlabpos','horvlabpos',
        'pievlabpos','vlavlabpos','hlavlabpos','pyrvlabpos','vlzero','firstlastlabpos','middlabpos']
      }
    };
    stateConfig.hideProps.general.splice(stateConfig.hideProps.general.indexOf('lights_layout'), 1);
    stateConfig.hideProps.general.push('display_layout');

    var imageConfig = {
      hideTabs : ['treemap','graphtype','preview','slice','bars','radar','pointer','cap','scale','percentage_axis','time','radius','tick_axis',
      'display_label','waterfall','layout','axis_label','line','domain_axis','value_axis','shapes','gauge','hierarchy','quadrants','overlapping'],
      hideProps : {
        general: measureConfig.hideProps.general.slice(),
        value_label:['showTotVL','wprec','wusecfonttot','wfonttot','wsizetot','wcolortot','wstyletot','defvlabpos','vervlabpos','horvlabpos',
        'pievlabpos','vlavlabpos','hlavlabpos','pyrvlabpos','vlzero','firstlastlabpos','middlabpos']
      }
    };
    imageConfig.hideProps.general.splice(imageConfig.hideProps.general.indexOf('imageset'), 1);
    imageConfig.hideProps.general.push('display_layout');

    var counterConfig = {
      hideTabs : ['treemap','graphtype','preview','slice','bars','radar','percentage_axis','time','waterfall','layout','line','shapes','axis_label',
      'domain_axis','value_axis','pointer','cap','radius','scale','tick_axis','hierarchy','quadrants','overlapping'],
      hideProps : {
        general:['is3D','normalized','trendimages','remfilltransp','mapdef','mapundefcol','mapundefstr','imageset', 'treelayout', 'ordercol','lights_layout',
        'ringperc_bck', 'ringperc_layout'],
        gauge:['gaugeorient','gaugestyle','gfanlights','geffect','gstartdeg','genddeg','pyramidrotation','hfunnel','wfunnel','funneltype','fitSize'],
        value_label:['showTotVL','wprec','wusecfonttot','wfonttot','wsizetot','wcolortot','wstyletot','outvlabpos','vervlabpos','horvlabpos',
        'pievlabpos','vlavlabpos','hlavlabpos','pyrvlabpos','vlzero','firstlastlabpos','middlabpos']
      }
    };
*/

    var tooltips = {
      advanced_font: "Set websafe (offline) font",
      use_global_font: "Use Global Font settings or custom settings",
      value_global_font: "Apply Value Axis Font settings or Global Font settings or custom settings"
    };
    
		this.formObjClass={
			helper : {
				description :'Common properties as legends, series colors, pictures, patterns, ... for charts'
			},
			newProperties:{
				},
      _allProps: {
				generic:[
					{name:'version', propID:'version', type:'str', disabled:true, tooltip:'Tool version'},
					{name:'image type', propID:'imagetype', type:'select[JPEG,PNG]', disabled:true, tooltip:'Image Type'},
          {name:'description', propID:'description', type:'str', tooltip:'Chart description'},
					{name:'width', propID:'width', type:'int', defaultValue:800, tooltip:'Set the chart\'s width'/*, section:"dimensions"*/, extraClass: 'col-3'},
					{name:'height', propID:'height', type:'int', defaultValue:600, tooltip:'Set the chart\'s height'/*, section:"dimensions"*/, extraClass: 'col-3'}
				],
				colors:[
          {name:'color', propID:'graphcolor', type:'color', tooltip:'Fill the background with the selected color', defaultValue:'', section:'background', extraClass: 'col-3'},
					{name:'gradient', propID:'graphgradient', type:'color', tooltip:'Diagonally gradient for the background color', defaultValue:'', section:'background', extraClass: 'col-3'},
					{name:'color', propID:'chartcolor', type:'color', tooltip:'Fill the chart with the selected color', defaultValue:'', section:'chart', extraClass: 'col-3'},
					{name:'gradient',		propID:'chartgradient',		type:'color',		tooltip:'Diagonally gradient for the color of the chart', defaultValue:'', section:'chart', extraClass: 'col-3'},
					{name:'border color',		propID:'bordercolor',		type:'color',		tooltip:'Design the border of the chart with the selected color', defaultValue:'', section:'chart', extraClass: 'col-3'},
          {name:'transparency', propID:'transparency', type:'int', tooltip:'Transparency of the chart', defaultValue:0, section:'chart', extraClass: 'col-3'},
          {name:'colors', propID:'colourseries',		type:'str',		buttons:'edit',		actions:'LoadCG()',		tooltip:'Collection of colors to be applied to each series elements', defaultValue:'', section:'series', extraClass: 'col-3'},
					{name:'gradients', propID:'gradientseries',		type:'str',		buttons:'edit',		actions:'LoadCG()',		tooltip:'Collection of gradient to be applied to each series elements', defaultValue:'', section:'series', extraClass: 'col-3'},
					{name:'color series', propID:'usecseach', type:"select[apply colors per each series:false,apply colors per each element:true]",	defaultValue:'false', section:'series', tooltip:'Series-based colors or elements-based colors (elements belonging to the same series may have different colors)'},
					{name:'colors per series', propID:'reusecolourseries', type:reuse_colors,	defaultValue:'false', tooltip:'Apply the collection of series colors cyclically to all chart\'s series', section:'series'},
          {name:'hover color',		propID:'hovercolor',		type:'color',		tooltip:'The item color change on mouse over it', defaultValue:'', section:'series'}
				],
				global_font:[
					{ name: 'font offline', propID: 'gfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_gfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size', propID:'gsize',			type:'int', tooltip:'Global font size (pixel)',		defaultValue:12, section:"font settings", extraClass: 'col-3'},
					{name:'color', propID:'gcolor',		type:'color',		tooltip:'Global font color', defaultValue:'#000000', section:"font settings", extraClass: 'col-3'},
					{name:'style', propID:'gstyle',		type:fonts_style, tooltip:'Global font style',		defaultValue:'N', section:"font settings"}
				],
				titles:[
					{name:'title',		propID:'ttitle',		type:'str',			tooltip:'Chart title',		defaultValue:'', section:"title"},
					{name:'text position', propID:'ttitlepos',		type:'select[top,bottom,left,right]',			tooltip:'Chart title position',		defaultValue:'top', section:"title", extraClass: 'col-3'},
          {name:'text alignment', propID:'ttitleali',		type:'select[center,left,right]',			tooltip:'Chart title alignment',		defaultValue:'center',section:"title", extraClass: 'col-3'},
          {name:'chart title font', propID:'tusecfont',		type:global_font
						,hide_list:{
							'true':['this.titles_tfont','this.titles_tsize','this.titles_tcolor','this.titles_tstyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.titles_tfont','this.titles_tsize','this.titles_tcolor','this.titles_tstyle']
						}
						,defaultValue:'true'
            , section: "title"
            , tooltip: tooltips.use_global_font
					},
					{ name: 'font offline', propID: 'tfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_tfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'tsize',		type:'int',			tooltip:'Chart Title font size (pixel)',		defaultValue:12, section: "title", extraClass: 'col-3'},
					{name:'color',		propID:'tcolor',		type:'color',		tooltip:'Chart Title font color', defaultValue:'#000000', section: "title", extraClass: 'col-3'},
					{name:'style',		propID:'tstyle',		type:fonts_style,		tooltip:'Chart Title font style',		defaultValue:'N', section: "title"},
          {name:'subtitle',		propID:'stitle',		type:'str',			tooltip:'Chart Subtitle',		defaultValue:'', section:"subtitle"},
					{name:'text position',		propID:'stitlepos',		type:'select[top,bottom,left,right]',			tooltip:'Chart Subtitle position',		defaultValue:'bottom', section:"subtitle", extraClass: 'col-3'},
          {name:'text alignment',		propID:'stitleali',		type:'select[center,left,right]',			tooltip:'Chart Subtitle alignment',		defaultValue:'center',section:"subtitle", extraClass: 'col-3'},
					{name:'text order',		propID:'stitleorder',		type:'select[after legend:after,before legend:before]',			tooltip:'Chart Subtitle order',		defaultValue:'after',section:"subtitle"},
          {name:'chart subtitle font', propID:'susecfont',		type:global_font
						,hide_list:{
							'true':['this.titles_sfont','this.titles_ssize','this.titles_scolor','this.titles_sstyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.titles_sfont','this.titles_ssize','this.titles_scolor','this.titles_sstyle']
						}
						,defaultValue:'true'
            , section: "subtitle"
            , tooltip: tooltips.use_global_font
					},
					{ name: 'font offline', propID: 'sfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_sfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		  propID:'ssize',		type:'int',			tooltip:'Chart Subtitle font size (pixel)',		defaultValue:12, section: "subtitle", extraClass: 'col-3'},
					{name:'color',		propID:'scolor',		type:'color',		tooltip:'Chart Subtitle font color', defaultValue:'#000000', section: "subtitle", extraClass: 'col-3'},
					{name:'style',		propID:'sstyle',		type:fonts_style,		tooltip:'Chart Subtitle font style',		defaultValue:'N', section: "subtitle"}
				],
				value_settings:[
				 	{name:'pattern',		propID:'negpattern',		      type:pattern_select ,    tooltip:'Pattern to apply for negative value',		defaultValue:'', section: "negative value"},
          {name:'color',		  propID:'negpatterncolor',		  type:'color' ,  tooltip:'Pattern color',		defaultValue:'', section: "negative value"},
          {name:'pattern',		propID:'outpattern',		      type:pattern_select ,    tooltip:'Pattern to apply for negative value',		defaultValue:'', section: "out of range value"},
          {name:'color',		  propID:'outpatterncolor',		  type:'color' ,  tooltip:'Pattern color',		defaultValue:'', section: "out of range value"}
				],
				legend:[
          {name:'title',		propID:'ltitle',		type:'str',			tooltip:'Legend (series) title',		defaultValue:'Series Title',section:"layout"},
					{name:'legend position',		propID:'legendpos',		type:'select[hide,top,bottom,left,right]',		tooltip:'Legend position relative to the chart', defaultValue:'top',section:"layout", extraClass: 'col-3'},
					{name:'text alignment',		propID:'legendali',		type:'select[center,left,right]',			tooltip:'Chart Legend alignment',		defaultValue:'center',section:"layout", extraClass: 'col-3'},   
          {name:'view limit', propID:'showLegendButtonWhen', type: 'int', section:"layout", tooltip:'When the chart width or height is less than the specified value, the legend will be hidden and there will be a button to display it', defaultValue:0, extraClass: 'col-3'},
					{name:'unit', propID:'lpercbtn', type: 'select[constant:false,percentage:true]', section:"layout", tooltip:'Specify if numeric limit is constant or percentage', defaultValue:'false', extraClass: 'col-3'},
					{name:'view serie value', propID:'valueinlegend', type: 'select[default,only value:val,only percentage:perc,both value and percentage:valperc,none]', section:"layout", tooltip:'View series totals (values or perc.) in legend', defaultValue:'default'},
					{name:'legend icon type',		propID:'legendicon',		type:'select[default,circle,cross,diamond,square,triangle,star,wye]', section:"style", defaultValue:"default", tooltip: "Select custom shape for elements in legend"},
					{name:'legend background', propID:'lusebkgc', type:'select[apply chart style:true,apply custom style:false]'
						,hide_list:{
							'true':['this.legend_legendcolor','this.legend_legendgradient'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.legend_legendcolor','this.legend_legendgradient']
						}
						,defaultValue:'true'
            ,section:"style"
            , tooltip: "Apply chart background settings or custom settings"
					},
					{name:'fill color',		propID:'legendcolor',		type:'color',		tooltip:'Fill the legend with the selected color', defaultValue:'', section:"style", extraClass: 'col-3'},
					{name:'gradient',		propID:'legendgradient',		type:'color',		tooltip:'Diagonally gradient for the color of the legend', defaultValue:'', section:"style", extraClass: 'col-3'},
					{name:'line color',		propID:'llinecolor',		type:'color',		tooltip:'Chart Legend outline border color', defaultValue:'', section:"style", extraClass: 'col-3'},
					{name:'stroke',		propID:'llinestroke',		type:'int',		tooltip:'Chart Legend outline border stroke', defaultValue:1, section:"style", extraClass: 'col-3'},
          {name:'legend font', propID:'lusecfont',		type:global_font
						,hide_list:{
							'true':['this.legend_lfont','this.legend_lsize','this.legend_lcolor','this.legend_lstyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.legend_lfont','this.legend_lsize','this.legend_lcolor','this.legend_lstyle']
						}
						,defaultValue:'true'
            , section: "font settings"
            , tooltip: tooltips.use_global_font
					},
					{ name: 'font offline', propID: 'lfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_lfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'lsize',		type:'int',			tooltip:'Chart Legend font size (pixel)',		defaultValue:12, section: "font settings", extraClass: 'col-3'},
					{name:'color',		propID:'lcolor',		type:'color',		tooltip:'Chart Legend font color', defaultValue:"#000000", section: "font settings", extraClass: 'col-3'},
					{name:'style',		propID:'lstyle',		type:fonts_style,		tooltip:'Chart Legend font style',		defaultValue:'N', section: "font settings"}
				],
				range_legend:[
          {name:'title',		propID:'rbltitle',		type:'str',			tooltip:'Legend (series) title', defaultValue:'',section:"layout",disabled:true},
					{name:'legend position',		propID:'rblegendpos',		type:'select[default,hide,top,bottom,left,right]',		tooltip:'Legend position relative to the chart', defaultValue:'default', section:"layout", extraClass: 'col-3'},
					{name:'text alignment',		propID:'rblegendali',		type:'select[center,left,right]',			tooltip:'Chart Legend alignment',		defaultValue:'center',section:"layout", extraClass: 'col-3'},
          {name:'view limit', propID:'rbshowLegendButtonWhen', type: 'int'/*, section:"view"*/, tooltip:'When the chart width or height is less than the specified value, the legend will be hidden and there will be a button to display it', defaultValue:0, extraClass: 'col-3'},
          {name:'unit', propID:'rblpercbtn', type: 'select[constant:false,percentage:true]'/*, section:"view"*/, tooltip:'Specify if numeric limit is constant or percentage', defaultValue:'false', extraClass: 'col-3'},
					{name:'legend background', propID:'rblusebkgc', type:'select[apply legend style:true,apply custom style:false]'
						,hide_list:{
							'true':['this.range_legend_rblegendcolor','this.range_legend_rblegendgradient','this.range_legend_rbllinecolor','this.range_legend_rbllinestroke'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.range_legend_rblegendcolor','this.range_legend_rblegendgradient','this.range_legend_rbllinecolor','this.range_legend_rbllinestroke']
						}
						,defaultValue:'true'
            ,section:"style"
            , tooltip: "Apply chart legend background settings or custom settings"
					},
					{name:'fill color',		propID:'rblegendcolor',		type:'color',		tooltip:'Fill the legend with the selected color', defaultValue:'', section:"style", extraClass: 'col-3'},
					{name:'gradient',		propID:'rblegendgradient',		type:'color',		tooltip:'Diagonally gradient for the color of the legend', defaultValue:'', section:"style", extraClass: 'col-3'},
					{name:'line color',		propID:'rbllinecolor',		type:'color',		tooltip:'Chart Legend outline border color', defaultValue:'', section:"style", extraClass: 'col-3'},
					{name:'stroke',		propID:'rbllinestroke',		type:'int',		tooltip:'Chart Legend outline border stroke', defaultValue:1, section:"style", extraClass: 'col-3'},
          {name:'legend font', propID:'rblusecfont',		type:legend_font
						,hide_list:{
							'true':['this.range_legend_rblfont','this.range_legend_rblsize','this.range_legend_rblcolor','this.range_legend_rblstyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.range_legend_rblfont','this.range_legend_rblsize','this.range_legend_rblcolor','this.range_legend_rblstyle']
						}
						,defaultValue:'true'
            ,section: "font settings"
            , tooltip: "Use chart legend font settings or custom settings"
					},
					{ name: 'font offline', propID: 'rblfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_rblfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'font size',		propID:'rblsize',		type:'int',			tooltip:'Chart Legend font size (pixel)',		defaultValue:12, section: "font settings", extraClass: 'col-3'},
					{name:'font color',		propID:'rblcolor',		type:'color',		tooltip:'Chart Legend font color', defaultValue:"#000000", section: "font settings", extraClass: 'col-3'},
					{name:'font style',		propID:'rblstyle',		type:fonts_style,		tooltip:'Chart Legend font style',		defaultValue:'N', section: "font settings"}
				],
				customization:[
					{name:'save in custom dir' ,propID:'customChart', type:'checkbox', tooltip:'Save chartdef in custom directory'},
					{name:'chart for user or group', propID:'user_group', type: 'select[,User:user,Group:group]',
						hide_list:{'':['this.Customization_user','this.Customization_group'],'user':['this.Customization_group'],'group':['this.Customization_user']},
						show_list:{'user':['this.Customization_user'],'group':['this.Customization_group']}
            , tooltip: "Specify if chart is custom for user or group"
					},
					{name:'Group',propID:'group',type:'str',validFunc:'IsNumericInput', extraClass: 'col-3', tooltip: "Indicates group code" },
					{name:'User',propID:'user',type:'str',validFunc:'IsNumericInput', extraClass: 'col-3', tooltip: "Indicates user code" }
				]
			}
		};

		this.chartObjClass={
			helper : {
				/*description :'Common properties as legends, series colors,... for charts',*/
        /*usage:'Line ... usage',
				'LINES': {
          description :'Line description'
          ,usage:'Line ... usage'
        }*/
			},
			newProperties:{
      },
      _allProps: {
				general:[
					{name:'Layout styles', propID:'lights_layout', type:'select[default,round bordered flat:rflatbord,only lights flat:flat]', defaultValue:"default", tooltip:'Apply style effects on chart'}, //round filled:rfill,
          {name:'Layout styles', propID:'display_layout', type:'select[default,minimal,simple]', defaultValue:"default", tooltip:'Apply style effects on chart'},
          {name:'View 3D', propID:'is3D', type:'select[false,true]', defaultValue:"false", validFunc:"apply3D", tooltip:'Apply 3D effect on chart'},
          {name:'Tooltips on chart', propID:'chartTooltips', type:'select[show,hide]', defaultValue:"show", tooltip:'View tooltips on chart'},
          {name:'Layout style', propID:'ringperc_layout', type:'select[default,round]', defaultValue:"default", tooltip:'Apply style effects on chart', section: "layout"},
          {name:'Background ring color', propID:'ringperc_bck', type:'color', defaultValue:"", tooltip:'Apply style effects on ring chart background', section: "layout"},
					{name: 'Apply series color', propID:'ordercol', type:'select[horizontally,vertically]', defaultValue:"vertically", tooltip:'Apply series color'},
					{name:'type',	propID:'rangetype',	type:'select[none,default,custom]'
            ,hide_list:{
							'none':['this.general_rangebands','this.general_trendlinesv','this.general_rangegrad','this.general_rangexy','this.general_rangexyz'],
							'default':['this.general_rangebands'],
							'custom':[]
						}
						,show_list:{
							'none':[],
							'default':['this.general_trendlinesv','this.general_rangegrad'],
							'custom':['this.general_rangebands','this.general_trendlinesv','this.general_rangegrad']
						}
            ,defaultValue:'none'
            ,section:"range bands"
            , tooltip: "Apply default ranges or custom range bands"
          },
					{name:'definition',	propID:'rangebands',	type:'str', buttons:'edit', actions:'LoadTL()',	tooltip:'Set range bands and their colors', defaultValue:'', section:"range bands"},
					{name:'range as value',		propID:'trendlinesv',		type:'select[don\'t apply range color to value:false,apply range color to value:true]',tooltip:'When this property is selected, the range band color is applied to pointer', defaultValue:'true', section:"range bands"},
					{name:'range gradient',		propID:'rangegrad',		type:'select[none:none,monochromatic gradient to each color:mono,gradient from first to last color:multi]',tooltip:'When this property is selected, the range band color gradient is applied to chart elements', defaultValue:'none', section:"range bands"},
					{name:'animation',	propID:'animate',	type:'select[enable:true,disable:false]',	defaultValue:'true', tooltip:'Apply an animation on chart\'s elements', section:"draw with animation", extraClass: 'col-3'},
					{name:'duration (ms)',	propID:'durationAnimation',	type:'int',	defaultValue:1000, tooltip:'Set the duration of animation (in milliseconds)', section:"draw with animation", extraClass: 'col-3'},
          {name:'element style',	propID:'remfilltransp',			type:'select[apply fill transparency:true,remove fill transparency:false]',	defaultValue:'true', tooltip:'When this property is selected, the fill-transparency is applied to chart\'s elements', section:"settings"},
					{name:'normalize values',				propID:'normalized',			type:'select[disable:false,enable:true]',	defaultValue:'false', tooltip:'When this property is selected, data are shown normalized', section:"settings"},
					{name:'digits',				propID:'digitNum',			type:'int', tooltip:'Set a fixed number of digits', defaultValue:0, section:"settings"},
					{name:'domain type',	propID:'domaintype', type:'str', defaultValue:"", disabled:true, tooltip:'Set the domain type', section:"settings"},
					{name:'map definition',	propID:'mapdef', type:map_select, defaultValue:"simple", tooltip:'Set the map definition type', section:"settings"},
					{name:'map undefined data fill color',	propID:'mapundefcol', type:"color", defaultValue:"", tooltip:'Set the map undefined data fill color', section:"settings"},
					{name:'map undefined data stroke color',	propID:'mapundefstr', type:"color", defaultValue:"", tooltip:'Set the map undefined data stroke color', section:"settings"},
					{name:'image',	propID:'imageset', type:"select[default,font icon:icon]", defaultValue:"default", tooltip:'Set if image is within source or icon font', section:"settings"},
					{name:'layout',	propID:'treelayout', type:"select[horizontal,vertical,radial]", defaultValue:"horizontal", tooltip:'Set the orientation of tree layout', section:"settings"},
					{name:'transparency on unselected elements',	propID:'unseltr', type:"select[default,lighter,none]", defaultValue:"default", tooltip:'Set if unselected items should have opacity', section:"selection visual effects"},
					{name:'alternative color on unselected elements',	propID:'unselcol', type:"color", defaultValue:"", tooltip:'Set alternative color on unselected items', section:"selection visual effects"}
				],
				waterfall:[
					{name:'start value label',		propID:'startLabel',	type:'str', tooltip:'Label for the start value', disabled:true},
					{name:'start value',			propID:'startValue',	type:'int', tooltip:'Set a start value', disabled:true},
					{name:'total bar',				propID:'showTot',		type:show_hide
						,hide_list:{
							'true':[],
							'false':['this.waterfall_totalLabel','this.waterfall_totalCol','this.waterfall_totalGrad']
						}
						,show_list:{
							'true':['this.waterfall_totalLabel','this.waterfall_totalCol','this.waterfall_totalGrad'],
							'false':[]
						}
						,tooltip:'When this property is selected, total value is displayed'
            ,defaultValue:'false'
            ,section:"total bar settings"
					},
					{name:'title',				propID:'totalLabel',		type:'str', tooltip:'Label for the total value', defaultValue:'',section:"total bar settings"},
					{name:'bar color',				propID:'totalCol',			type:'color', tooltip:'Fill the total value bar with the selected color', defaultValue:'',section:"total bar settings", extraClass: "col-3"},
					{name:'gradient',				propID:'totalGrad',			type:'color', tooltip:'Diagonally gradient for the color of total value bar', defaultValue:'',section:"total bar settings", extraClass: "col-3"}
				],
				axis_label:[
					{name:'domain axis',		propID:'xlabel',		type:'str',			tooltip:'This label refers to the values represented on the X axis', defaultValue:'x label'/*, section:"titles"*/, extraClass: "col-3"},
					{name:'value axis',		propID:'ylabel',		type:'str',			tooltip:'This label refers to the values represented on the Y axis', defaultValue:'y label'/*, section:"titles"*/, extraClass: "col-3"},
					{name:'percent axis',		propID:'percentLabel',		type:'str',			tooltip:'This label refers to the values represented on the Percent axis', defaultValue:'percent label'/*, section:"titles"*/},
					{name:'axis labels font',		propID:'ausecfont',		type:global_font
						,hide_list:{
							'true':['this.axis_label_afont','this.axis_label_asize','this.axis_label_acolor','this.axis_label_astyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.axis_label_afont','this.axis_label_asize','this.axis_label_acolor','this.axis_label_astyle']
						}
						,tooltip:'When this property is selected, the Axis Label will be printed using the Global Font'
						,defaultValue:'true'
            , section: "font settings"
					},
					{ name: 'font offline', propID: 'afont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_afont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'asize',		type:'int',			tooltip:'Axis Label font size (pixel)',		defaultValue:24, section: "font settings", extraClass: "col-3"},
					{name:'color',		propID:'acolor',		type:'color',		tooltip:'Axis Label font color', defaultValue:'#000000', section: "font settings", extraClass: "col-3"},
					{name:'style',		propID:'astyle',		type:fonts_style,		tooltip:'Axis Label font style', defaultValue:'N', section: "font settings"}
				],
				value_axis:[
          {name:'value axis and labels',		propID:'vshow',		type:show_hide
						,hide_list:{
							'true':[],
							'false':['this.value_axis_vshowaxis','this.value_axis_vusecfont','this.value_axis_vfont','this.value_axis_vsize','this.value_axis_vcolor','this.value_axis_vstyle','this.value_axis_vlinecolor','this.value_axis_vlinestroke']
						}
						,show_list:{
							'true':['this.value_axis_vshowaxis','this.value_axis_vusecfont','this.value_axis_vfont','this.value_axis_vsize','this.value_axis_vcolor','this.value_axis_vstyle','this.value_axis_vlinecolor','this.value_axis_vlinestroke'],
							'false':[]
						}
						, tooltip:'When this property is selected, the Value Axis and its labels are visible'
						, defaultValue:'true'
            , section:"axis settings"
					},
					{name:'minimum value',		propID:'vminvalue',		type:'int',			tooltip:'Minimum value set to the value axis', section:"axis settings", extraClass: "col-3"},
					{name:'maximum value',		propID:'vmaxvalue',		type:'int',			tooltip:'Maximum value set to the value axis', section:"axis settings", extraClass: "col-3"},
					{name:'tick unit',			propID:'vtickunit',		type:'int',			tooltip:'Set the tick interval between two values on the Value Axis', section:"axis settings", extraClass: "col-3"},
					{name:'precision',			propID:'vprecision',		type:'int',			tooltip:'Set scale numeric precision to display desired format of values', section:"axis settings", extraClass: "col-3"},
					{name:'value axis tick labels font',		propID:'vusecfont', type:global_font
						, hide_list:{
							'true':['this.value_axis_vfont','this.value_axis_vsize','this.value_axis_vcolor','this.value_axis_vstyle'],
							'false':[]
						}
						, show_list:{
							'true':[],
							'false':['this.value_axis_vfont','this.value_axis_vsize','this.value_axis_vcolor','this.value_axis_vstyle']
						}
						, tooltip:'When this property is selected, the Value Axis will be printed using the Global Font'
						, defaultValue:"true"
            , section: "font settings"
					},
					{ name: 'font offline', propID: 'vfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_vfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'vsize',			type:'int',			tooltip:'Value Axis Label font size (pixel)',		defaultValue:24, section: "font settings", extraClass: "col-3"},
					{name:'color',		propID:'vcolor',		type:'color',		tooltip:'Value Axis Label font color', defaultValue:'#000000', section: "font settings", extraClass: "col-3"},
					{name:'style',		propID:'vstyle',		type:fonts_style,		tooltip:'Value Axis Label font style', defaultValue:'N', section: "font settings"},
          {name:'value axis line',		propID:'vshowaxis',		type:show_hide
						, hide_list:{
							'true':[],
							'false':['this.value_axis_vlinecolor','this.value_axis_vlinestroke']
						}
						, show_list:{
							'true':['this.value_axis_vlinecolor','this.value_axis_vlinestroke'],
							'false':[]
						}
						, tooltip:'When this property is selected, the Value Axis and its labels are visible'
						, defaultValue:'true'
            , section:"line settings"
					},
					{name:'color',		propID:'vlinecolor',		type:'color',		tooltip:'Value Axis line color', defaultValue:'', section:"line settings", extraClass: "col-3"},
					{name:'stroke',		propID:'vlinestroke',		type:'int',		tooltip:'Value Axis line stroke', defaultValue:1, section:"line settings", extraClass: "col-3"},
					{name:'value axis grid',			propID:'vgridline',		type:show_hide
						, hide_list:{
							'false':['this.value_axis_vgridlinecolor','this.value_axis_vgridlinetype'],
							'true':[]
						}
						, show_list:{
							'false':[],
							'true':['this.value_axis_vgridlinecolor','this.value_axis_vgridlinetype']
						}
						, tooltip:'When this property is selected, the gridline on Value Axis is visible'
						, defaultValue:'false'
            , section:"grid settings"
					},
					{name:'color',		propID:'vgridlinecolor',		type:'color',		tooltip:'Value axis gridline color', defaultValue:'#000000', section:"grid settings", extraClass: "col-3"},
					{name:'type',	propID:'vgridlinetype',		type:grid_type,		tooltip:'Value axis gridline type', defaultValue:'small_dashed', section:"grid settings", extraClass: "col-3"}
				],
				domain_axis:[
					{name:'domain axis and labels',		propID:'dshow',		type:show_hide
						, hide_list:{
							'true':[],
							'false':['this.domain_axis_dusecfont','this.domain_axis_dfont','this.domain_axis_dsize','this.domain_axis_dcolor','this.domain_axis_dstyle','this.domain_axis_dusevaxisline','this.domain_axis_dlinecolor','this.domain_axis_dlinestroke']
						}
						, show_list:{
							'true':['this.domain_axis_dusecfont','this.domain_axis_dfont','this.domain_axis_dsize','this.domain_axis_dcolor','this.domain_axis_dstyle','this.domain_axis_dusevaxisline','this.domain_axis_dlinecolor','this.domain_axis_dlinestroke'],
							'false':[]
						}
						, tooltip:'When this property is selected, the Value Axis and its labels are visible'
						, defaultValue:true
            , section: "axis settings"
					},
					{name:'domain axis and labels', propID:'daxismatrix', type:'select[show both:both,show only left:left,show only top:top,hide]', defaultValue:"show both", tooltip:'When this property is selected, the Value Axis and its labels are visible'},
          {name:'label orientation',		propID:'dlabeltype',		type:label_type,		tooltip:'Set the alignment of the domain axis labels', section: "axis settings"},
          {name:'label orientation',		propID:'dlabeltypealt',		type:"select[horizontal:0,vertical:90,vertical down:-90,45Up:45,45Down:-45]",		tooltip:'Set the alignment of the domain axis labels', section: "axis settings"},
          {name:'precision',			propID:'dprecision',		type:'int',			tooltip:'Set scale numeric precision to display desired format of values', section:"axis settings"},
          {name:'domain axis tick labels font',		propID:'dusefont', type:value_global_font
						, hide_list:{
							'value':['this.domain_axis_dfont','this.domain_axis_dsize','this.domain_axis_dcolor','this.domain_axis_dstyle'],
							'global':['this.domain_axis_dfont','this.domain_axis_dsize','this.domain_axis_dcolor','this.domain_axis_dstyle'],
              'custom':[]
						}
						, show_list:{
							'value':[],
							'global':[],
              'custom':['this.domain_axis_dfont','this.domain_axis_dsize','this.domain_axis_dcolor','this.domain_axis_dstyle']
						}
						, tooltip: tooltips.value_global_font
						, defaultValue:'value'
            , section:"font settings"
					},
					{ name: 'font offline', propID: 'dfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_dfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'dsize',			type:'int',			tooltip:'Domain Axis Label font size (pixel)',		defaultValue:24, section:"font settings", extraClass: "col-3"},
					{name:'color',		propID:'dcolor',		type:'color',		tooltip:'Domain Axis Label font color', defaultValue:'#000000', section:"font settings", extraClass: "col-3"},
					{name:'style',		propID:'dstyle',		type:fonts_style,		tooltip:'Domain Axis Label font style', defaultValue:'N', section:"font settings"},
          {name:'domain axis line',		propID:'dusevaxisline', type:value_line
						,hide_list:{
							'true':['this.domain_axis_dlinecolor','this.domain_axis_dlinestroke'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.domain_axis_dlinecolor','this.domain_axis_dlinestroke']
						}
						,defaultValue:'true'
            ,section:"line settings"
            , tooltip: "Use Value Axis style settings or custom settings"
					},
					{name:'color',		propID:'dlinecolor',	type:'color',		tooltip:'Domain Axis line color', defaultValue:'',section:"line settings", extraClass: "col-3"},
					{name:'stroke',		propID:'dlinestroke',	type:'int',		tooltip:'Domain Axis line stroke', defaultValue:1,section:"line settings", extraClass: "col-3"},
          {name:'domain axis grid',		propID:'dusegrid',		type:'select[use value axis settings:value,show:show,hide:hide]'
            , hide_list:{
                'value':['this.domain_axis_dgridlinecolor','this.domain_axis_dgridlinetype'],
                'show':[],
                'hide':['this.domain_axis_dgridlinecolor','this.domain_axis_dgridlinetype']
            }
            , show_list:{
                'value':[],
                'show':['this.domain_axis_dgridlinecolor','this.domain_axis_dgridlinetype'],
                'hide':[]
            }
            , section:"grid settings"
            , tooltip: "Use Value Axis grid settings or custom settings"
          },
					{name:'color',		propID:'dgridlinecolor',	type:'color',		tooltip:'Domain Axis gridline color', defaultValue:'', section:"grid settings", extraClass: "col-3"},
					{name:'type',	propID:'dgridlinetype',		type:grid_type,		tooltip:'Domain Axis gridline type', defaultValue:'small_dashed', section:"grid settings", extraClass: "col-3"}
				],
				percentage_axis:[
          {name:'percentage axis and labels',		propID:'pshow',		type:show_hide
						,hide_list:{
							'true':[],
							'false':['this.percentage_axis_pusecfont','this.percentage_axis_pfont','this.percentage_axis_psize','this.percentage_axis_pcolor','this.percentage_axis_pstyle','this.percentage_axis_pusevaxisline','this.percentage_axis_plinecolor','this.percentage_axis_plinestroke']
						}
						,show_list:{
							'true':['this.percentage_axis_pusecfont','this.percentage_axis_pfont','this.percentage_axis_psize','this.percentage_axis_pcolor','this.percentage_axis_pstyle','this.percentage_axis_pusevaxisline','this.percentage_axis_plinecolor','this.percentage_axis_plinestroke'],
							'false':[]
						}
						,tooltip:'When this property is selected, the Percentage Axis and its labels are visible'
						,defaultValue:'true'
            ,section: "axis settings"
					},
					{name:'maximum value', propID:'pmaxValue',type:'int',tooltip:'Maximum value set to the percentage axis', defaultValue:0, section: "axis settings", extraClass: "col-3"},
					{name:'% reference', propID:'percentageReference',type:'int',tooltip:'Percentage reference', defaultValue:80, section: "axis settings", extraClass: "col-3"},
          {name:'percentage axis tick labels font',		propID:'pusefont',		type:value_global_font
						, hide_list:{
							'value':['this.percentage_axis_pfont','this.percentage_axis_psize','this.percentage_axis_pcolor','this.percentage_axis_pstyle'],
							'global':['this.percentage_axis_pfont','this.percentage_axis_psize','this.percentage_axis_pcolor','this.percentage_axis_pstyle'],
              'custom':[]
						}
						, show_list:{
							'value':[],
							'global':[],
              'custom':['this.percentage_axis_pfont','this.percentage_axis_psize','this.percentage_axis_pcolor','this.percentage_axis_pstyle']
						}
						, defaultValue:'value'
            , section:"font settings"
            , tooltip: tooltips.value_global_font
					},
					{ name: 'font offline', propID: 'pfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_pfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'psize',			type:'int',			tooltip:'Percentage Axis Label font size (pixel)',		defaultValue:24, section:"font settings", extraClass: "col-3"},
					{name:'color',		propID:'pcolor',		type:'color',		tooltip:'Percentage Axis Label font color', defaultValue:'#000000', section:"font settings", extraClass: "col-3"},
					{name:'style',		propID:'pstyle',		type:fonts_style,		tooltip:'Percentage Axis Label font style', defaultValue:'N', section:"font settings"},
          {name:'percentage axis line',		propID:'pusevaxisline', type:value_line
						,hide_list:{
							'true':['this.percentage_axis_plinecolor','this.percentage_axis_plinestroke'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.percentage_axis_plinecolor','this.percentage_axis_plinestroke']
						}
						,defaultValue:'true'
            ,section:"line settings"
            , tooltip: "Use Value Axis style settings or custom settings"
					},
					{name:'color',		propID:'plinecolor',	type:'color',		tooltip:'Percentage Axis line color', defaultValue:'',section:"line settings", extraClass: "col-3"},
					{name:'stroke',		propID:'plinestroke',	type:'int',		tooltip:'Percentage Axis line stroke', defaultValue:1,section:"line settings", extraClass: "col-3"}
				],
				value_label:[
					{name:'show value label',		propID:'valueshow', defaultValue:'hide', type: "select[hide,default,show always horizontal:horizontal,show always vertical:vertical]", section: "layout", tooltip: "Show or hide value labels. Default: if the label goes beyond the margins of the elements, it will be hidden. Show always: Labels are always shown" },
					{name:'position',		propID:'defvlabpos',		type:'select[' + defvlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name:'position',		propID:'vervlabpos',		type:'select[' + vervlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name:'position',		propID:'horvlabpos',		type:'select[' + horvlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name:'position',		propID:'pievlabpos',		type:'select[' + pievlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name:'position',		propID:'vlavlabpos',		type:'select[' + vlavlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name:'position',		propID:'hlavlabpos',		type:'select[' + hlavlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name:'position',		propID:'pyrvlabpos',		type:'select[' + pyrvlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name:'position',		propID:'outvlabpos',		type:'select[' + outvlab + ']', tooltip:'Let you choose the position of the Value Labels on the chart', section: "layout"},
					{name: 'middle levels position',		propID:'middlabpos',		type:'select[' + sankeymiddlelab + ']', tooltip:'Let you choose the position of the Value Labels in the middle levels on the chart', section: "layout"},
					{name: 'first/last level position',		propID:'firstlastlabpos',		type:'select[' + sankeylab + ']', tooltip:'Let you choose the position of the Value Labels in the first and last level on the chart', section: "layout"},
					{name:'format',		propID:'valuetype', defaultValue:'label', type:value_labels, tooltip:'Let you choose the format to be applied to the Value Labels', section: "layout"
						, hide_list:{
							"label": ['this.value_label_vl_vprec', 'this.value_label_vl_pprec'],
							"ser": ['this.value_label_vl_vprec', 'this.value_label_vl_pprec'],
							"value": ['this.value_label_vl_pprec'],
							"perc": ['this.value_label_vl_vprec'],
							"dperc": ['this.value_label_vl_vprec'],
							"labelvalue": ['this.value_label_vl_pprec'],
							"servalue": ['this.value_label_vl_pprec'],
							"serlabel": ['this.value_label_vl_vprec', 'this.value_label_vl_pprec'],
							"labelperc": ['this.value_label_vl_vprec'],
							"dlabelperc": ['this.value_label_vl_vprec'],
							"valueperc": [],
							"dvalueperc": [],
							"serperc": ['this.value_label_vl_vprec'],
							"dserperc": ['this.value_label_vl_vprec'],
							"totperc": ['this.value_label_vl_vprec']
						}
						, show_list:{
							"label": [],
							"ser": [],
							"value": ['this.value_label_vl_vprec'],
							"perc": ['this.value_label_vl_pprec'],
							"dperc": ['this.value_label_vl_pprec'],
							"labelvalue": ['this.value_label_vl_vprec'],
							"servalue": ['this.value_label_vl_vprec'],
							"serlabel": [],
							"labelperc": ['this.value_label_vl_pprec'],
							"dlabelperc": ['this.value_label_vl_pprec'],
							"valueperc": ['this.value_label_vl_vprec', 'this.value_label_vl_pprec'],
							"dvalueperc": ['this.value_label_vl_vprec', 'this.value_label_vl_pprec'],
							"serperc": ['this.value_label_vl_pprec'],
							"dserperc": ['this.value_label_vl_pprec'],
							"totperc": ['this.value_label_vl_pprec']
						}
					},
					{name:'value precision',		propID:'vl_vprec', type: "int", tooltip:'Set numeric precision to display desired format of values', section: "layout", extraClass: "col-3"},
					{name:'percentage precision',		propID:'vl_pprec', type: "int", tooltip:'Set numeric precision to display desired format of percentages', section: "layout", extraClass: "col-3"},
					{name:'apply value picture',		propID:'applypicture', defaultValue:'false', type:'select[false,true]', tooltip:'Apply picture to Value Labels', section: "layout"},
          {name:'position inside',		propID:'valueinsidepos',		type:'select[radial,center,borderline]', tooltip:'', defaultValue:'radial', section: "layout", disabled:true},
          {name:'total value label',  propID:'showTotVL',		type:show_hide
						,hide_list:{
							'true':[],
							'false':['this.value_label_wprec']
						}
						,show_list:{
							'true':['this.value_label_wprec'],
							'false':[]
						}
						,tooltip:'When this property is selected, total value label is displayed'
            ,defaultValue:'false'
            ,section:"layout"
					},
					{name:'total value precision',		propID:'wprec', type:'int', tooltip:'Set numeric precision to display desired format of values',  section: "layout"},
					{name:'empty values (like 0)',		propID:'vlzero', type:'select[show:true,hide:false]', defaultValue:"true", tooltip:'Choose if you want show/hide 0-value value label',  section: "layout"},
          {name:'value labels font',		propID:'wusecfont',		type:global_font
						,hide_list:{
							'true':['this.value_label_wfont','this.value_label_wsize','this.value_label_wcolor','this.value_label_wstyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.value_label_wfont','this.value_label_wsize','this.value_label_wcolor','this.value_label_wstyle']
						}
						,defaultValue:'true'
            ,section: "font settings"
            , tooltip: tooltips.use_global_font
					},
					{ name: 'font offline', propID: 'wfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_wfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'wsize',			type:'int',			tooltip:'Value Label font size (pixel)',		defaultValue:24,section: "font settings", extraClass: "col-3"},
					{name:'color',		propID:'wcolor',		type:'color',		tooltip:'Value Label font color', defaultValue:'#000000',section: "font settings", extraClass: "col-3"},
					{name:'style',		propID:'wstyle',		type:fonts_style,		tooltip:'Value Label font style', defaultValue:'N',section: "font settings", extraClass: "col-3"},
          {name:'total value label font',		propID:'wusecfonttot',		type:global_font
						,hide_list:{
							'true':['this.value_label_wfonttot','this.value_label_wsizetot','this.value_label_wcolortot','this.value_label_wstyletot'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.value_label_wfonttot','this.value_label_wsizetot','this.value_label_wcolortot','this.value_label_wstyletot']
						}
						,defaultValue:'true'
            ,section: "font settings"
            , tooltip: tooltips.use_global_font
					},
					{ name: 'font offline', propID: 'wfonttot', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_wfonttot', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'wsizetot',			type:'int',			tooltip:'Value Label font size (pixel)',		defaultValue:24,section: "font settings", extraClass: "col-3"},
					{name:'color',		propID:'wcolortot',		type:'color',		tooltip:'Value Label font color', defaultValue:'#000000',section: "font settings", extraClass: "col-3"},
					{name:'style',		propID:'wstyletot',		type:fonts_style,		tooltip:'Value Label font style', defaultValue:'N',section: "font settings", extraClass: "col-3"}
				],
				shapes:[
					{name:'shapes',		propID:'drawshapes',		type:'select[hide:hide,draw fill shapes:fill,draw outline shapes:outline]'
						,hide_list:{
							'hide':['this.shapes_sizeshapes','this.shapes_sizetypeshapes','this.shapes_shapesstroke', 'this.shapes_shapesseriescol'],
							'fill':[],
							'outline':[]
						}
						,show_list:{
							'hide':[],
							'fill':['this.shapes_sizeshapes','this.shapes_sizetypeshapes','this.shapes_shapesstroke', 'this.shapes_shapesseriescol'],
							'outline':['this.shapes_sizeshapes','this.shapes_sizetypeshapes','this.shapes_shapesstroke', 'this.shapes_shapesseriescol']
						}
						,tooltip:'When this property is selected, the shapes will be printed in correspondence of values on chart'
						,defaultValue:'hide'
					},
          {name:'shapes',		propID:'drawshapesalt',		type:'select[hide,draw]'
            ,hide_list:{
              'hide':['this.shapes_sizeshapes','this.shapes_sizetypeshapes'],
              'draw':[]
            }
            ,show_list:{
              'hide':[],
              'draw':['this.shapes_sizeshapes','this.shapes_sizetypeshapes']
            }
						,tooltip:'When this property is selected, the shapes will be printed in correspondence of values on chart'
						,defaultValue:'hide'
					},
					{name:'type',		propID:'shapetype',		type:'select[circle,square,triangle,cross,diamond,star,wye]', tooltip:'Determines the type of shapes', defaultValue:"circle"},
					{name:'type',		propID:'shapetypealt',		type:'select[circle,outline circle:emptyCircle,rect,roundRect,triangle,diamond,pin,arrow]', tooltip:'Determines the type of shapes', defaultValue:"circle"},
					{name:'shapes on series',		propID:'shapeserie',		type:'select[apply on each serie:false,differ for each serie:true]', defaultValue:"false", tooltip: "Choose whether to apply the same shape to all series" },
					{name:'draw only shapes',		propID:'shapeline',		type:'select[disable:false,enable:true]',		tooltip:'Check enable if you don\'t want line but only shapes on chart', defaultValue:"false"},
					{name:'size',		propID:'sizeshapes',		type:'int',		tooltip:'Determines the size of shapes',		defaultValue:2, extraClass: "col-3"},
					{name:'size type',		propID:'sizetypeshapes',		type:'select[percent,fixed]',		tooltip:'Determines the measure unit of the size above', defaultValue:'percent', extraClass: "col-3"},
					{name:'shape stroke',		propID:'shapesstroke',		type:'int',		tooltip:'Set stroke size', defaultValue:'1'},
          {name:'shape stroke series color',		propID:'shapesseriescol',		type:'str',		buttons:'edit',		actions:'LoadCGs()',		tooltip:'Set the color of the bar border line', defaultValue:''},
          {name:'apply custom series color',		propID:'shpapply',		type:'select[false,true]',		tooltip:'Apply custom colors to shapes', defaultValue:''},
          {name:'shape series color',		propID:'shapescols',		type:'str',		buttons:'edit',		actions:'LoadCGsc()',		tooltip:'Indicates the custom colors to apply to the shapes', defaultValue:''}
				],
				slice:[
					{name:'percent',		propID:'slicepercent',		type:'int',		tooltip:'Set the distance between the selected slice and the pie', defaultValue:0},
					{name:'slice type',		propID:'slicetype',		type:'select[,first,last,min,max]',		tooltip:'Set the slice to be highlighted', disabled:true}
				],
				bars:[
					{name:'margins (%)',			propID:'barmargins',		type:'int',		tooltip:'Set the distance between each bar for serie',		defaultValue:0, section: "layout"},
					{name:'max width (vbar)/height (hbar) (px)',			propID:'barmaxw',		type:'int',		tooltip:'Set the max widht for each bar',		defaultValue:0, section: "layout"},
					{name:'x offset',		propID:'xshadow',		type:'int',		tooltip:'Set the horizontal offset of the bar shadow',		defaultValue:"0", section: "bars shadow", extraClass: "col-3"},
					{name:'y offset',		propID:'yshadow',		type:'int',		tooltip:'Set the vertical offset of the bar shadow',		defaultValue:"0", section: "bars shadow", extraClass: "col-3"},
					{name:'color',			propID:'shadowcolor',		type:'color',		tooltip:'Set the shadow color to be applied on each bar', defaultValue:'', section: "bars shadow"},
					{name:'stroke',			propID:'outlinestroke',		type:'int',		tooltip:'Set the stroke of the bar border line', defaultValue:0, section:"bars border line"},
					{name:'series color',		propID:'outlinecolour',		type:'str',		buttons:'edit',		actions:'LoadCGb()',		tooltip:'Set the color of the bar border line', defaultValue:'', section:"bars border line", extraClass: "col-3"},
					{name:'gradient',		propID:'outlinegradient',		type:'str',		buttons:'edit',		actions:'LoadCGb()',		tooltip:'Set the gradient of the bar border line', defaultValue:'', section:"bars border line", extraClass: "col-3"},
					{name:'reuse outline color series', propID:'reuseoutlineseries', type:reuse_colors,	defaultValue:'false', tooltip:'Apply the collection of outline series colors cyclically to all chart\'s series', section:"bars border line"},
					{name:'use one color by bar (one category only)',		propID:'onecolourbar',		type:'checkbox',		tooltip:'',		defaultValue:false, disabled:true},
					{name:'remove default gradient', propID:'remdefaultgradient', type:'checkbox', tooltip:'When this property is selected, the default gradient will be removed', defaultValue:true, disabled:true}
				],
				line:[
					{name:'area element',				propID:'extarea',			type:'select[extend area:true,reduce area:false]',	defaultValue:true, tooltip:'When "Extend" is selected, Area chart covers the whole space'},
          {name:'stroke',		propID:'wlinestroke',		type:'int',		tooltip:'Set the stroke on the chart lines', defaultValue:1, section: "line style"},
					{name:'color',	propID:'lineColor',	type:'color',tooltip:'Set the color of the line.', defaultValue:'', section: "line style"},
					{name:'appereance',	propID:'lineType',	type:'select[linear:curveLinear,step-before:curveStepBefore,step-after:curveStepAfter,basis:curveBasis,bundle:curveBasis,cardinal:curveCardinal,monotone:curveMonotoneX]', tooltip:'Let you choose different types of line', defaultValue:'curveLinear', section: "line style"},
          {name:'position', propID:'linePosition',	type:'select[Top - Middle:topMiddle,Top-Right:topRight,Inside:inside]',tooltip:'The initial position of the Pareto chart\'s line.', defaultValue:'topMiddle', section: "line style"},
					{name:'links', propID:'vorolinks',	type:'select[hide:false,show:true]',tooltip:'Show or hide Voronoi\'s points links', defaultValue:'false', section: "Voronoi links"},
					{name:'type', propID:'vorolinksType',	type:'select[voronoi,delaunay]',tooltip:'Sets links type', defaultValue:'voronoi', section: "Voronoi links"},
					{name:'color', propID:'vorolinksColor',	type:'color', tooltip:'Set the Voronoi\'s points links color', defaultValue:'', section: "Voronoi links"},
					{name:'stroke', propID:'vorolinksStroke',	type:'int', tooltip:'Set the stroke on Voronoi\'s points links', defaultValue:'', section: "Voronoi links"}
				],
				time:[
					{name:'format', propID:'tiformat', type:timeformat_select, tooltip:'Let you choose the date format to be applied', section:"axis format and settings"},
          {name:'custom format', propID:'tcustformat',		type:'str', tooltip:'Allows you to set a custom date format to be applied', section:"axis format and settings"},
					{name:'tick unit', propID:'tdomainunit',		type:'select[day:d,month:M,year:y,hours:h,minutes:m,seconds:s]', tooltip:'Let you choose the time unit to be applied', section:"axis format and settings", extraClass: "col-3"},
					{name:'tick value', propID:'tdomainvalue',		type:'int', tooltip:'Set the tick interval between two dates', section:"axis format and settings", extraClass: "col-3"},
					{name:'data view', propID:'tdataview',		type:'select[year,month]', tooltip:'', section:"axis format and settings", extraClass: "col-3", disabled: true},
					{name:'date limit load',		propID:'tdatelimit',		type:'str', tooltip:'Allows you to Set an upper limit in the specified date format', section:"data settings"},
          {name:'type',		propID:'datatype',		type:'select[default,continuous,with holes:holes]', tooltip:'Let you choose different data visualizations', section:"data settings"}
				],
				radar:[
					{name:'start angle (deg)',		propID:'startangle',		type:'int', tooltip:'Set the angle to start drawing chart', defaultValue:90/*, section:"plot settings"*/},
					{name:'data order',		propID:'dataorder',		type:'select[column,row]', tooltip:'Allows you to change the data order',disabled:true},
					{name:'direction',		propID:'plotdirection',		type:'select[clockwise,Anti-Clockwise:anticlockwise]', tooltip:'Let you choose the direction of the plot', defaultValue:'clockwise'/*, section:"plot settings"*/}
				],
				pointer:[
					{name:'type',		propID:'pointertype',	type:'select[Pointer,Pin,Needle,Reverse,Arrow]', tooltip:'Let you choose the layout of the pointer', defaultValue:'pointer', section:"layout"},
					{name:'length (%)',		propID:'pointerradius',	type:'int',	defaultValue:0.95, tooltip:'Determines the dimension of the pointer in correspondence of the dial plot', section:"layout", extraClass: "col-3"},
					{name:'base width (%)',		propID:'pointerbase',	type:'int',	defaultValue:0.05, tooltip:'Determines the dimension of the base in correspondence of the dial plot', section:"layout", extraClass: "col-3"},
					{name:'fill color',		propID:'pointfillcolor',		type:'color',		tooltip:'Pointer fill color', defaultValue:'', section:"style", disabled:true},
					{name:'line color',		propID:'pointlinecolor',		type:'color',		tooltip:'Pointer line color', defaultValue:'', section:"style", extraClass: "col-3"},
					{name:'stroke',		propID:'pointlinestroke',		type:'int',	defaultValue:2,	tooltip:'Pointer line stroke', section:"style", extraClass: "col-3"}
				],
				cap:[
					{name:'radius (%)',		propID:'capradius',	type:'int',	defaultValue:0.10, tooltip:'Determines the radius referred to the cap'},
					{name:'fill color',		propID:'capfillcolor',		type:'color',		tooltip:'Cap fill color', defaultValue:'', section:"style"},
					{name:'line color',		propID:'caplinecolor',		type:'color',		tooltip:'Cap line color', defaultValue:'', section:"style", extraClass: "col-3"},
					{name:'stroke',		propID:'caplinestroke',		type:'int',	defaultValue:1,	tooltip:'Cap line stroke', section:"style", extraClass: "col-3"}
				],
				scale:[
					{name:'tick radius (%)',			propID:'scaletickradius',		type:'int',		defaultValue:0.88, tooltip:'Set the radius of the dial plot', extraClass: "col-3", disabled:true},
					{name:'label offset (%)',		propID:'scaleticklabeloffset',		type:'int',		defaultValue:0.15, tooltip:'Set the distance between the ticks and the labels'},
					{name:'major tick',		propID:'majortickincrement',		type:'int', tooltip:'Set the tick between each principal (major) tick', extraClass: "col-3"},
					{name:'minor tick',			propID:'minortickcount',		type:'int',		defaultValue:4, tooltip:'Set the tick between two principal (major) ticks', extraClass: "col-3"}
				],
				radius:[
					{name:'inner (%)',	propID:'ringradin',	type:'int',	tooltip:'Set the inner radius (percentage of the outer)', defaultValue:75, extraClass: "col-3"},
					{name:'inner (%)',	propID:'innradius',	type:'int',	tooltip:'Set the inner radius (percentage of the outer)', defaultValue:15, extraClass: "col-3"},
					{name:'outer (%)',	propID:'ringradout',	type:'int',	tooltip:'Set the outer radius (percentage of the radial axis)', defaultValue:100, extraClass: "col-3"}
				],
				tick_axis:[
					{name:'start angle (deg)',	propID:'startdeg',	type:'int',	tooltip:'Set the start angle', defaultValue:0/*, section:"layout"*/, extraClass: "col-3"},
					{name:'end angle (deg)',	propID:'enddeg',	type:'int',	tooltip:'Set the end angle', defaultValue:180/*, section:"layout"*/, extraClass: "col-3"},
          {name:'tick axis and labels',		propID:'tishow',		type:show_hide
						,hide_list:{
							'true':[],
							'false':['this.tick_axis_scaleminvalue','this.tick_axis_scalemaxvalue','this.tick_axis_tausecfont','this.tick_axis_tafont','this.tick_axis_tasize','this.tick_axis_tacolor','this.tick_axis_tastyle']
						}
						,show_list:{
							'true':['this.tick_axis_scaleminvalue','this.tick_axis_scalemaxvalue','this.tick_axis_tausecfont','this.tick_axis_tafont','this.tick_axis_tasize','this.tick_axis_tacolor','this.tick_axis_tastyle'],
							'false':[]
						}
						, tooltip:'When this property is selected, the Tick Axis and its labels are visible'
						, defaultValue:'true'
            , section:"axis settings"
					},
					{name:'min value',			propID:'scaleminvalue',		type:'int',		tooltip:'Minimum value set to the chart', section:"axis settings", extraClass: "col-3"},
					{name:'max value',			propID:'scalemaxvalue',		type:'int',		tooltip:'Maximum value set to the chart', section:"axis settings", extraClass: "col-3"},
					{name:'data value',			propID:'scaledatavalue',		type:'int',		tooltip:'Value oriented by the pointer of the chart',defaultValue:0,disabled:true},
          {name:'tick axis labels font',		propID:'tausecfont',		type:global_font
						,hide_list:{
							'true':['this.tick_axis_tafont','this.tick_axis_tasize','this.tick_axis_tacolor','this.tick_axis_tastyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.tick_axis_tafont','this.tick_axis_tasize','this.tick_axis_tacolor','this.tick_axis_tastyle']
						}
						,defaultValue:'true'
            ,section: "font settings"
            , tooltip: tooltips.use_global_font
					},
					{ name: 'font offline', propID: 'tafont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_tafont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'tasize',			type:'int',			tooltip:'Tick Axis Label font size (pixel)', defaultValue:24,section: "font settings", extraClass: "col-3"},
					{name:'color',		propID:'tacolor',		type:'color',		tooltip:'Tick Axis Label font color', defaultValue:'#000000',section: "font settings", extraClass: "col-3"},
					{name:'style',		propID:'tastyle',		type:fonts_style,		tooltip:'Tick Axis Label font style', defaultValue:'N',section: "font settings"}
				],
				gauge:[
					{name:'fit size (only 180 degrees)',	propID:'fitSize',	type:'select[false,true]',	tooltip:'Let you fit gauge size on area', defaultValue:'false'},
					{name:'start angle (deg)',	propID:'gstartdeg',	type:'int',	tooltip:'Set the start angle', defaultValue:0/*, section:"layout"*/, extraClass: "col-3"},
					{name:'end angle (deg)',	propID:'genddeg',	type:'int',	tooltip:'Set the end angle', defaultValue:180/*, section:"layout"*/, extraClass: "col-3"},
					{name:'orientation',	propID:'gaugeorient',	type:'select[vertical,horizontal]',defaultValue:'vertical', tooltip:'Let you choose gauge orientation', section:"layout"},
					{name:'type',	propID:'gaugestyle',	type:'select[square,round]',defaultValue:'square', tooltip:'Let you choose gauge border style', section:"layout"},
					{name:'rotation (degrees)', propID:'pyramidrotation', type:'select[0,90,180,270]', defaultValue:'0', tooltip:'Let you choose the pyramid orientation', section:"layout"},
					{name:'height (%)', propID:'hfunnel', type:'int', tooltip:"Set the funnel's neck height", defaultValue:'20', section:"layout", extraClass: "col-3"},
					{name:'width (%)', propID:'wfunnel', type:'int', tooltip:"Set the funnel's neck width", defaultValue:'20', section:"layout", extraClass: "col-3"},
					{name:'type', propID:'funneltype', type:'select[default:shapes,blocks,value in middle:middle,value in bottom:bottom]', tooltip:"Let you choose funnel style", defaultValue:'shapes', section:"layout"},
					{name:'fill color',	propID:'gfillcolor',	type:'color',	tooltip:'Set the fill color', defaultValue:'', section:"style"},
					{name:'borderline color',	propID:'gbordercolor',	type:'color',	tooltip:'Set the borderline color', defaultValue:'#000000', section:"style", extraClass: "col-3"},
					{name:'stroke',	propID:'gborderstroke',	type:'int',	tooltip:'Set the borderline stroke', defaultValue:1, section:"style", extraClass: "col-3"},
					{name:'fanlights',	propID:'gfanlights',	type:'select[show:false,hide:true]',	tooltip:'If checked, hide the fanlights', defaultValue:false, extraClass: "col-3", disabled : true},
					{name:'lights effects',	propID:'geffect',	type:'select[shadow top:plain,shadow bottom:bubble,flat,concentric]',	defaultValue:'plain', tooltip:'Let you choose different lights effects'}
				],
				display_label:[
					{ name: 'font offline', propID: 'dispfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_dispfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'dispsize',			type:'int',			tooltip:'Display Label font size (pixel)', defaultValue:0,section: "font settings", extraClass: "col-3", disabled: true},
					{name:'color',		propID:'dispcolor',		type:'color',		tooltip:'Display Label font color', defaultValue:'',section: "font settings", extraClass: "col-3"},
					{name:'style',		propID:'dispstyle',		type:fonts_style,		tooltip:'Display Label font style', defaultValue:'N',section: "font settings", extraClass: "col-3"}
				],
				layout:[
          {name:'minimum font size', propID:'minfont', type:'int', defaultValue:10, tooltip:'Min word cloud font size',section: "font settings", disabled:true},
					{name:'maximum font size', propID:'maxfont', type:'int', defaultValue:25, tooltip:'Max word cloud font size',section: "font settings", disabled:true},
          {name:'word cloud font',		propID:'wcusecfont',		type:global_font
						,hide_list:{
							'true':['this.layout_wcfont','this.layout_wcstyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.layout_wcfont','this.layout_wcstyle']
						}
						,defaultValue:'true'
            ,section: "font settings"
            , tooltip: tooltips.use_global_font
					},
					{ name: 'font offline', propID: 'wcfont', type: 'advanced-font', section: 'font settings', tooltip: tooltips.advanced_font },
					{ name: 'font web online', propID: 'online_wcfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'style',		propID:'wcstyle',		type:fonts_style,		tooltip:'Word cloud font style', defaultValue:'N',section: "font settings"},
					{name:'min orientation', propID:'minorientation', type:'int', defaultValue:-90, tooltip:'Min word cloud orientation',section: "word layout", extraClass: "col-2"},
					{name:'max orientation', propID:'maxorientation', type:'int', defaultValue:90, tooltip:'Max word cloud orientation',section: "word layout", extraClass: "col-2"},
					{name:'angles count', propID:'anglescount', type:'int', defaultValue:5, tooltip:'Number of angles',section: "word layout", extraClass: "col-2"},
					{name:'blocks and ribbons order', propID:'sandataorder', type:"select[data driven:true,sankey default:false]", tooltip:'Sets layout position', defaultValue:'true'},
					{name:'position', propID:'layoutpos', type:"select[left,right,justify]", tooltip:'Sets layout position', defaultValue:'left'},
					{name:'width (px)', propID:'nodewidth', type:"int", tooltip:'Sets nodes width in px - default is 24', defaultValue:'24', section: "nodes", extraClass: "col-3"},
					{name:'padding (px)', propID:'nodepadding', type:"int", tooltip:'Sets padding between nodes in px - default is 8', defaultValue:'8', section: "nodes", extraClass: "col-3"}
				],
        treemap:[
          {name:'group by', propID:'trgroupby', type:'select[default,none,column,row]', defaultValue:'default', tooltip:'Group data by',section: "data"},
          {name:'order', propID:'trorder', type:'select[default,none,ascendent,descendent]', defaultValue:'default', tooltip:'Order data',section: "data"},
          {name:'layout tile',		propID:'trtile',		type:'select[,binary,squarify,squarifyV1,squarifyV2,resquarify,resquarifyV1,resquarifyV2,dice,slice,slicedice]',		tooltip:'Layout style', defaultValue:'', section: "style"},
          {name:'inner padding', propID:'trinpadding', type:'int', defaultValue:0, tooltip:'Inner padding',section: "style", extraClass: "col-3"},
          {name:'outer padding', propID:'troutpadding', type:'int', defaultValue:0, tooltip:'Outer padding',section: "style", extraClass: "col-3"}
				],
				hierarchy:[
					{name:'display', propID:'showbc', type:'select[show:true,hide:false]', defaultValue:'true', tooltip:'Show breadcrumb hierarchy path on hover',section: "breadcrumb"},
					{name:'root', propID:'showroot', type:'select[show:true,hide:false]', defaultValue:'true', tooltip:'Show root in chart',section: "structure"},
					{name:'element hover', propID:'hoverpath', type:'select[hover all elements on path:path,hover only one element:element]', defaultValue:'path', tooltip:'Choose if hover entire hierarchy path or only last element',section: "structure"}
				],
				quadrants:[
					{name:'colors', propID:'qcolors', type:'color', disabled:true},
					{name:'type', propID:'qlabels', type:'select[hide,only label:label,label + distr. value:labval,label + distr. percentage:labperc,label + val. + perc.:laball,only distr. value:val,only distr. percentage:perc]'
						, hide_list:{
							'hide':['this.quadrants_qlabelspos','this.quadrants_qlabelsali','this.quadrants_qvalprec','this.quadrants_qperprec'],
							'label':['this.quadrants_qvalprec','this.quadrants_qperprec'],
							'labval':['this.quadrants_qperprec'],
							'labperc':['this.quadrants_qvalprec'],
							'laball':[],
							'val':['this.quadrants_qperprec'],
							'perc':['this.quadrants_qvalprec']
						}
						, show_list:{
							'hide':[],
							'label':['this.quadrants_qlabelspos','this.quadrants_qlabelsali'],
							'labval':['this.quadrants_qlabelspos','this.quadrants_qlabelsali','this.quadrants_qvalprec'],
							'labperc':['this.quadrants_qlabelspos','this.quadrants_qlabelsali','this.quadrants_qperprec'],
							'laball':['this.quadrants_qlabelspos','this.quadrants_qlabelsali','this.quadrants_qvalprec','this.quadrants_qperprec'],
							'val':['this.quadrants_qlabelspos','this.quadrants_qlabelsali','this.quadrants_qvalprec'],
							'perc':['this.quadrants_qlabelspos','this.quadrants_qlabelsali','this.quadrants_qperprec']
						}	
						, defaultValue:'hide'
						, tooltip:'Hide or show titles in each quadrant'
						, section: 'labels'
					},
					{name:'position', propID:'qlabelspos', type:'select[top,bottom]', defaultValue:'top', section: 'labels', extraClass: "col-3", tooltip: "Labels position in each quadrant" },
					{name:'alignment', propID:'qlabelsali', type:'select[left,center,right]', defaultValue:'left', section: 'labels', extraClass: "col-3", tooltip: "Labels alignment in each quadrant"},
					{name:'values precision', propID:'qvalprec', type:'int', defaultValue:'', section: 'labels', extraClass: "col-3", tooltip: "Set numeric precision to display desired format of values"},
					{name:'percentages precision', propID:'qperprec', type:'int', defaultValue:'', section: 'labels', extraClass: "col-3", tooltip: "Set numeric precision to display desired format of percentages"},
					{name:'font',		propID:'qusefont',		type:global_font
						,hide_list:{
							'true':['this.quadrants_qfont','this.quadrants_qsize','this.quadrants_qcolor','this.quadrants_qstyle'],
							'false':[]
						}
						,show_list:{
							'true':[],
							'false':['this.quadrants_qfont','this.quadrants_qsize','this.quadrants_qcolor','this.quadrants_qstyle']
						}
						,defaultValue:'true'
            ,section: "labels"
            , tooltip: tooltips.use_global_font
					},
					{name: 'font offline', propID: 'qfont', type: 'advanced-font', section: 'labels', tooltip: tooltips.advanced_font },
					{name: 'font web online', propID: 'online_qfont', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'labels', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
					{name:'size',		propID:'qsize',			type:'int',			tooltip:'Quadrants Label font size (pixel)', defaultValue:24,section: "labels", extraClass: "col-3"},
					{name:'color',		propID:'qcolor',		type:'color',		tooltip:'Quadrants Label font color', defaultValue:'#000000',section: "labels", extraClass: "col-3"},
					{name:'style',		propID:'qstyle',		type:fonts_style,		tooltip:'Quadrants Label font style', defaultValue:'N',section: "labels"}
				],
				overlapping:[
					{name: 'visual effect type', propID: 'oltype', type: 'select[none,with border:border,only border:contrast]', defaultValue:'none'
						,hide_list:{
							'none':['this.overlapping_olcolor'],
							'border':['this.overlapping_olcolor'],
							'contrast':[]
						}
						,show_list:{
							'none':[],
							'border':[],
							'contrast':['this.overlapping_olcolor']
						}
            , tooltip: "Specify the style in case of overlapping elements"
					},
					{name: 'overlay element border color', propID: 'olcolor', type: 'color', tooltip: "Specifies the border color to apply to the overlay element"},
					{name: 'elements radius', propID: 'olrad', type: 'select[default,bigger,bigger proportional:bigprop]', defaultValue:'default', tooltip: "Specifies the radius style to apply to the overlay element"}
				]
			}
		}

    this.formObjClass._GetChartProps = function (/* type, macro_type*/) {
      this.newProperties = {};  // reset
      if (isAdvMode()){
        var strProps = JSON.stringify(this._allProps);
        this.newProperties = JSON.parse(strProps);
      }
      else { // echarts
        var echartsProps = {
          "all": ["generic.description", "generic.width", "generic.height",
            "colors.graphcolor", "colors.graphgradient", "colors.colourseries", "colors.gradientseries", "colors.usecseach", "colors.reusecolourseries", "colors.hovercolor",
            "global_font.gfont", "global_font.gsize", "global_font.gcolor", "global_font.gstyle",
            "titles.ttitlepos", "titles.ttitleali", "titles.ttitle", "titles.tusecfont",
            "titles.tfont", "titles.online_tfont", "titles.tsize","titles.tcolor","titles.tstyle",
            "titles.stitle","titles.susecfont","titles.sfont","titles.online_sfont","titles.ssize","titles.scolor","titles.sstyle",
            "legend.legendpos","legend.legendali","legend.valueinlegend","legend.legendicon","legend.lusebkgc",
            "legend.legendcolor","legend.llinecolor","legend.llinestroke","legend.lusecfont",
            "legend.lfont","legend.online_lfont","legend.lsize","legend.lcolor","legend.lstyle",
            "customization.customChart","customization.user_group","customization.group","customization.user"
          ]
        },
        refProps = echartsProps.all;  // per ora comuni a tutti i tipi
        for (var tab in this._allProps) {
          var allFlds = this._allProps[tab];
          for (var i = 0; i < allFlds.length; i++) {
            var str_prop = tab + "." + allFlds[i].propID;
            if (refProps.indexOf(str_prop) >= 0) {
              if (!(tab in this.newProperties))
                this.newProperties[tab] = [];
              this.newProperties[tab].push(allFlds[i]);
            }
          }
        }
      }
    }
    this.chartObjClass._GetChartProps = function (type/*, macro_type*/) {
      var default_chart = "LINES";
      this.newProperties = {
        graphtype: this._graphtype.slice()
      };  // reset
      var hide_props = {};
      hide_props.LINES = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time',
          'radius', 'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset',
          'treelayout', 'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'vervlabpos',
          'horvlabpos', 'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos'],
        line: ['extarea', 'linePosition', 'lineColor', 'vorolinks', 'vorolinksType', 'vorolinksColor', 'vorolinksStroke'],
        axis_label: ['percentLabel'],
        domain_axis: ['daxismatrix']
      };
      hide_props.AREA = {
        _tabs: hide_props.LINES._tabs.slice(),
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset',
          'treelayout', 'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: hide_props.LINES.value_label.slice(),
        axis_label: hide_props.LINES.axis_label.slice(),
        line: ['linePosition', 'vorolinks', 'vorolinksType', 'vorolinksColor', 'vorolinksStroke']
      };
      hide_props.STACKEDAREA = {
        _tabs: hide_props.AREA._tabs.slice(),
        general: ['is3D', 'trendimages', 'digitNum', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset',
          'treelayout', 'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: hide_props.AREA.value_label.slice(),
        axis_label: hide_props.AREA.axis_label.slice(),
        line: hide_props.AREA.line.slice()
      };
      hide_props.RADARLINE = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius', 'tick_axis'
          , 'display_label', 'waterfall', 'layout', 'line', 'axis_label', 'domain_axis', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'vervlabpos', 'horvlabpos',
          'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos']
      };
      hide_props.RADARAREA = {
        _tabs: hide_props.RADARLINE._tabs.slice(),
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout']
      };
      hide_props.VBAR = {
        _tabs: ['treemap', 'graphtype', 'preview', 'shapes', 'slice', 'line', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'horvlabpos',
          'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'firstlastlabpos', 'middlabpos'],
        axis_label: ['percentLabel']
      };
      hide_props.VBAR3D = hide_props.VBAR;
      hide_props.HBAR = {
        _tabs: hide_props.VBAR._tabs.slice(),
        general: hide_props.VBAR.general.slice(),
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos',
          'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'firstlastlabpos', 'middlabpos'],
        axis_label: hide_props.VBAR.axis_label.slice()
      };
      hide_props.HBAR3D = hide_props.HBAR;
      hide_props.LAYEREDBAR = {
        _tabs: hide_props.VBAR._tabs.slice(),
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout', 'is3D'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos', 'horvlabpos',
          'pievlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'firstlastlabpos', 'middlabpos'],
        axis_label: hide_props.VBAR.axis_label.slice()
      };
      hide_props.LAYEREDBARH = {
        _tabs: hide_props.VBAR._tabs.slice(),
        general: hide_props.LAYEREDBAR.general.slice(),
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos', 'horvlabpos',
          'pievlabpos', 'vlavlabpos', 'pyrvlabpos', 'outvlabpos', 'firstlastlabpos', 'middlabpos'],
        axis_label: hide_props.VBAR.axis_label.slice()
      };
      hide_props.PYRAMID = {
        _tabs: hide_props.VBAR._tabs.slice(),
        general: hide_props.LAYEREDBAR.general.slice(),
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos', 'horvlabpos',
          'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'outvlabpos', 'firstlastlabpos', 'middlabpos'],
        axis_label: hide_props.VBAR.axis_label.slice()
      };
      hide_props.AREABAR = {
        _tabs: hide_props.VBAR._tabs.slice(),
        general: hide_props.LAYEREDBAR.general.slice(),
        value_label: hide_props.VBAR.value_label.slice(),
        axis_label: hide_props.VBAR.axis_label.slice()
      };
      hide_props.VSTACKBAR = {
        _tabs: hide_props.VBAR._tabs.slice(),
        general: ['trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: hide_props.VBAR.value_label.slice(),
        axis_label: hide_props.VBAR.axis_label.slice()
      };
      hide_props.VSTACKBAR3D = hide_props.VSTACKBAR;
      hide_props.HSTACKBAR = {
        _tabs: hide_props.HBAR._tabs.slice(),
        general: hide_props.VSTACKBAR.general.slice(),
        value_label: hide_props.HBAR.value_label.slice(),
        axis_label: hide_props.HBAR.axis_label.slice()
      };
      hide_props.HSTACKBAR3D = hide_props.HSTACKBAR;
      hide_props.PIE = {
        _tabs: ['treemap', 'graphtype', 'bars', 'axis_label', 'value_axis', 'domain_axis', 'preview', 'shapes', 'line', 'pointer', 'cap', 'scale', 'gauge',
          'percentage_axis', 'time', 'radius', 'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['defvlabpos', 'vervlabpos', 'horvlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos'],
        radar: ['plotdirection']
      };
      hide_props.PIE3D = hide_props.PIE;
      hide_props.RING = {
        _tabs: ['treemap', 'graphtype', 'bars', 'axis_label', 'value_axis', 'domain_axis', 'preview', 'shapes', 'line', 'pointer', 'cap', 'scale', 'gauge',
          'percentage_axis', 'time', 'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout', 'is3D'],
        value_label: hide_props.PIE.value_label.slice(),
        radar: hide_props.PIE.radar.slice(),
        radius: ['ringradout', 'innradius']
      };
      hide_props.SCATTER = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'layout', 'line', 'shapes', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'vervlabpos', 'horvlabpos', 'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero'],
        axis_label: ['percentLabel']
      };
      hide_props.BUBBLE = {
        _tabs: hide_props.SCATTER._tabs.slice(),
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: hide_props.SCATTER.value_label
      };
      hide_props.TREEMAP = {
        _tabs: ['graphtype', 'preview', 'slice', 'bars', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius', 'tick_axis',
          'display_label', 'waterfall', 'layout', 'axis_label', 'line', 'domain_axis', 'value_axis', 'shapes', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos', 'horvlabpos',
          'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos']
      };
      hide_props.TREEMAPBAR = {
        _tabs: ['graphtype', 'preview', 'shapes', 'slice', 'line', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping', 'bars', 'value_axis'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'ordercol', 'lights_layout',
          'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos', 'horvlabpos',
          'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos'],
        axis_label: ['ylabel', 'percentLabel']
      };
      hide_props.TREEMAPBARH = hide_props.TREEMAPBAR;
      hide_props.WORDCLOUD = {
        _tabs: ['graphtype', 'preview', 'shapes', 'slice', 'line', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'treemap', 'hierarchy', 'quadrants', 'overlapping', 'bars', 'value_axis', 'value_label', 'domain_axis'],
        general: hide_props.TREEMAP.general.slice()
      };
      hide_props.PARETO = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping'],
        general: hide_props.VBAR.general.slice(),
        value_label: hide_props.VBAR.value_label.slice(),
        line: ['extarea', 'vorolinks', 'vorolinksType', 'vorolinksColor', 'vorolinksStroke']
      };
      hide_props.WATERF = {
        _tabs: ['treemap', 'graphtype', 'preview', 'shapes', 'slice', 'line', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'layout', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout', 'is3D'],
        value_label: hide_props.TREEMAPBAR.value_label.slice(),
        axis_label: hide_props.VBAR.axis_label.slice()
      };
      hide_props.GEOMAP = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'layout', 'shapes', 'axis_label', 'domain_axis', 'value_axis', 'hierarchy', 'quadrants', 'overlapping'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'imageset', 'treelayout', 'ordercol', 'lights_layout', 'display_layout',
          'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos', 'horvlabpos',
          'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos'],
        line: ['extarea', 'linePosition', 'lineType', 'vorolinks', 'vorolinksType', 'vorolinksColor', 'vorolinksStroke']
      };
      hide_props.ASTER = {
        _tabs: hide_props.RING._tabs.slice(),
        general: hide_props.RING.general.slice(),
        value_label: hide_props.RING.value_label.slice(),
        radar: hide_props.RING.radar.slice(),
        radius: ['ringradout', 'ringradin']
      };
      hide_props.SUNB = {
        _tabs: ['treemap', 'graphtype', 'bars', 'axis_label', 'value_axis', 'domain_axis', 'preview', 'shapes', 'pointer', 'cap', 'scale', 'gauge',
          'percentage_axis', 'time', 'tick_axis', 'display_label', 'waterfall', 'layout', 'quadrants', 'overlapping', 'slice'],
        general: hide_props.RING.general.slice(),
        value_label: hide_props.RING.value_label.slice(),
        radar: hide_props.RING.radar.slice(),
        radius: hide_props.RING.radius.slice(),
        line: ['extarea', 'linePosition', 'lineType', 'vorolinks', 'vorolinksType', 'vorolinksColor', 'vorolinksStroke']
      };
      hide_props.SUNBSTR = hide_props.SUNB;
      hide_props.TREE = {
        _tabs: ['treemap', 'graphtype', 'bars', 'axis_label', 'value_axis', 'domain_axis', 'preview', 'shapes', 'pointer', 'cap', 'scale', 'gauge',
          'percentage_axis', 'time', 'radius', 'tick_axis', 'display_label', 'waterfall', 'layout', 'quadrants', 'overlapping', 'slice'],
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'is3D',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout', 'rangetype', 'rangebands', 'trendlinesv', 'rangegrad'],
        value_label: hide_props.PIE.value_label.slice(),
        radar: hide_props.PIE.radar.slice(),
        line: ['extarea', 'linePosition', 'lineType', 'vorolinks', 'vorolinksType', 'vorolinksColor', 'vorolinksStroke'],
        hierarchy: ['showroot']
      };
      hide_props.TREESTR = hide_props.TREE;
      hide_props.CPACKSTR = {
        _tabs: ['treemap', 'graphtype', 'bars', 'axis_label', 'value_axis', 'domain_axis', 'preview', 'shapes', 'pointer', 'cap', 'scale', 'gauge',
          'percentage_axis', 'time', 'radius', 'tick_axis', 'display_label', 'waterfall', 'layout', 'quadrants', 'overlapping', 'slice', 'line'],
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'is3D', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout', 'rangetype', 'rangebands', 'trendlinesv', 'rangegrad'],
        value_label: hide_props.TREE.value_label.slice(),
        radar: hide_props.TREE.radar.slice(),
        hierarchy: hide_props.TREE.hierarchy.slice()
      };
      hide_props.CPACK = {
        _tabs: ['treemap', 'graphtype', 'bars', 'axis_label', 'value_axis', 'domain_axis', 'preview', 'shapes', 'pointer', 'cap', 'scale', 'gauge',
          'percentage_axis', 'time', 'radius', 'tick_axis', 'display_label', 'waterfall', 'layout', 'quadrants', 'overlapping', 'slice', 'line', 'hierarchy'],
        general: hide_props.CPACKSTR.general.slice(),
        value_label: hide_props.CPACKSTR.value_label.slice(),
        radar: hide_props.CPACKSTR.radar.slice(),
        hierarchy: hide_props.CPACKSTR.hierarchy.slice()
      };
      hide_props.FORCE = hide_props.CPACK;
      hide_props.FORCESTR = hide_props.CPACK;
      hide_props.CHORD = hide_props.CPACK;
      hide_props.PYR = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'percentage_axis', 'time', 'waterfall', 'layout', 'line', 'shapes', 'axis_label',
          'domain_axis', 'value_axis', 'pointer', 'cap', 'radius', 'scale', 'tick_axis', 'hierarchy', 'display_label', 'value_label', 'quadrants', 'overlapping'],
        general: ['is3D', 'normalized', 'trendimages', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout', 'digitNum', 'ordercol',
          'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        gauge: ['gaugeorient', 'gaugestyle', 'gfanlights', 'geffect', 'gstartdeg', 'genddeg', 'hfunnel', 'wfunnel', 'funneltype', 'fitSize', 'gfillcolor',
          'gbordercolor', 'gborderstroke', 'fitSize']
      };
      hide_props.PYRSTR = hide_props.PYR;
      hide_props.NECKEDPYR = {
        _tabs: hide_props.PYR._tabs.slice(),
        general: hide_props.PYR.general.slice(),
        gauge: ['gaugeorient', 'gaugestyle', 'gfanlights', 'geffect', 'gstartdeg', 'genddeg', 'funneltype', 'fitSize', 'gfillcolor', 'gbordercolor',
          'gborderstroke', 'fitSize']
      };
      hide_props.NECKEDPYRSTR = hide_props.NECKEDPYR;
      hide_props.FUNNEL = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'percentage_axis', 'time', 'waterfall', 'layout', 'line', 'axis_label',
          'domain_axis', 'value_axis', 'pointer', 'cap', 'radius', 'scale', 'tick_axis', 'hierarchy', 'display_label', 'value_label', 'quadrants', 'overlapping'],
        general: hide_props.PYR.general.slice(),
        gauge: ['gaugeorient', 'gaugestyle', 'gfanlights', 'geffect', 'gstartdeg', 'genddeg', 'pyramidrotation', 'hfunnel', 'wfunnel', 'fitSize', 'gfillcolor',
          'gbordercolor', 'gborderstroke', 'fitSize']
      };
      hide_props.MARIMEKKO = {
        _tabs: ['treemap', 'graphtype', 'preview', 'shapes', 'slice', 'line', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping', 'bars'],
        general: ['trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: hide_props.VBAR.value_label.slice(),
        axis_label: hide_props.VBAR.axis_label.slice(),
        domain_axis: ['dlabeltype', 'dusegrid', 'dgridlinecolor', 'dgridlinetype'],
        value_axis: ['vminvalue', 'vmaxvalue']
      };
      hide_props.PCOORDS = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time',
          'radius', 'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping', 'axis_label', 'domain_axis'],
        general: hide_props.LINES.general.slice(),
        value_label: hide_props.LINES.value_label.slice(),
        axis_label: hide_props.LINES.axis_label.slice(),
        domain_axis: hide_props.LINES.domain_axis.slice()
      };
      hide_props.VORONOI = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time',
          'radius', 'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping', 'axis_label', 'domain_axis',
          'value_axis', 'shapes'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout', 'ordercol',
          'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'vervlabpos', 'horvlabpos', 'pievlabpos',
          'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos'],
        line: ['extarea', 'linePosition', 'lineType'],
        axis_label: ['percentLabel']
      };
      hide_props.SANKEY = {
        _tabs: ['treemap', 'graphtype', 'preview', 'shapes', 'slice', 'line', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'hierarchy', 'quadrants', 'overlapping', 'axis_label', 'domain_axis', 'value_axis', 'bars'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout', 'ordercol',
          'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['defvlabpos', 'vervlabpos', 'horvlabpos', 'pievlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'valuetype',
          'applypicture', 'showTotVL', 'wprec', 'vlzero', 'wusecfonttot', 'online_wfonttot', 'vl_vprec', 'vl_pprec', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot'],
        layout: ['wcusecfont', 'online_wcfont', 'wcfont', 'wcstyle', 'minorientation', 'maxorientation', 'anglescount']
      };
      hide_props.MATRIX = {
        _tabs: ['treemap', 'graphtype', 'preview', 'shapes', 'slice', 'line', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius',
          'tick_axis', 'display_label', 'waterfall', 'hierarchy', 'quadrants', 'overlapping', 'axis_label', 'value_axis', 'bars', 'value_label', 'layout'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout', 'lights_layout',
          'display_layout', 'ringperc_bck', 'ringperc_layout'],
        domain_axis: ['dlabeltype', 'dprecision', 'dusevaxisline', 'dshow', 'dusevaxisline', 'dlinecolor', 'dlinestroke']
      };
      hide_props.BCMATRIX = {
        _tabs: ['treemap', 'graphtype', 'preview', 'slice', 'bars', 'radar', 'pointer', 'cap', 'scale', 'gauge', 'percentage_axis', 'time', 'radius', 'tick_axis', 'display_label',
          'waterfall', 'layout', 'hierarchy', 'shapes', 'line', 'multiDimensional'],
        general: ['is3D', 'normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout', 'ordercol',
          'lights_layout', 'display_layout', 'ringperc_bck', 'ringperc_layout'],
        value_label: ['showTotVL', 'wprec', 'wusecfonttot', 'wfonttot', 'wsizetot', 'wcolortot', 'wstyletot', 'defvlabpos', 'vervlabpos', 'horvlabpos', 'pievlabpos',
          'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos'],
        axis_label: ['percentLabel']
      };
      hide_props.RINGPERC = {
        _tabs: ['treemap', 'graphtype', 'bars', 'axis_label', 'value_axis', 'domain_axis', 'preview', 'shapes', 'line', 'pointer', 'cap', 'scale', 'gauge',
          'percentage_axis', 'time', 'tick_axis', 'display_label', 'waterfall', 'layout', 'hierarchy', 'quadrants', 'overlapping', 'slice'],
        general: ['normalized', 'trendimages', 'digitNum', 'remfilltransp', 'mapdef', 'mapundefcol', 'mapundefstr', 'imageset', 'treelayout',
          'ordercol', 'lights_layout', 'display_layout', 'is3D'],
        value_label: ['defvlabpos', 'vervlabpos', 'horvlabpos', 'vlavlabpos', 'hlavlabpos', 'pyrvlabpos', 'outvlabpos', 'vlzero', 'firstlastlabpos', 'middlabpos',
          'valueshow', 'pievlabpos', 'valuetype', 'applypicture', 'vl_vprec', 'vl_pprec', 'wfont', 'wsize', 'wcolor', 'wstyle', 'online_wfont', 'wusecfont'],
        radar: hide_props.RING.radar.slice(),
        radius: hide_props.RING.radius.slice()
      }
      
      for (var key in hide_props) {
        if (!Empty(hide_props[key]._tabs)) {
          if (hide_props[key]._tabs.indexOf("shapes") < 0) {
            if (!Empty(hide_props[key].shapes)) {
              if (isAdvMode()) {
                hide_props[key].shapes.push('drawshapesalt');
                hide_props[key].shapes.push('shapetypealt');
              }
              else {
                hide_props[key].shapes.push('drawshapes');
                hide_props[key].shapes.push('shapetype');
                hide_props[key].shapes.push('shapesstroke');
                hide_props[key].shapes.push('shapesseriescol');
                hide_props[key].shapes.push('shpapply');
                hide_props[key].shapes.push('shapescols');
              }
            }
            else {
              if (isAdvMode())
                hide_props[key].shapes = ['drawshapesalt', 'shapetypealt'];
              else
                hide_props[key].shapes = ['drawshapes', 'shapetype', 'shapesstroke', 'shapesseriescol', 'shpapply', 'shapescols'];
            }
          }
          if (hide_props[key]._tabs.indexOf("domain_axis") < 0) {
            if (!Empty(hide_props[key].domain_axis)) {
              if (isAdvMode())
                hide_props[key].domain_axis.push('dlabeltypealt');
              else {
                hide_props[key].domain_axis.push('dlabeltype');
                hide_props[key].domain_axis.push('dprecision');
              }
            }
            else {
              if (isAdvMode())
                hide_props[key].domain_axis = ['dlabeltypealt'];
              else
                hide_props[key].domain_axis = ['dlabeltype', 'dprecision'];
            }
          }
        }
        else {
          if (hide_props[key]._tabs.indexOf("shapes") < 0) {
            if (!Empty(hide_props[key].shapes)) {
              if (isAdvMode()) {
                hide_props[key].shapes.push('drawshapesalt');
                hide_props[key].shapes.push('shapetypealt');
              }
              else {
                hide_props[key].shapes.push('drawshapes');
                hide_props[key].shapes.push('shapetype');
                hide_props[key].shapes.push('shapesstroke');
                hide_props[key].shapes.push('shapesseriescol');
                hide_props[key].shapes.push('shpapply');
                hide_props[key].shapes.push('shapescols');
              }
            }
            else {
              if (isAdvMode())
                hide_props[key].shapes = ['drawshapesalt', 'shapetypealt'];
              else
                hide_props[key].shapes = ['drawshapes', 'shapetype', 'shapesstroke', 'shapesseriescol', 'shpapply', 'shapescols'];
            }
          }
          if (hide_props[key]._tabs.indexOf("domain_axis") < 0) {
            if (!Empty(hide_props[key].domain_axis)) {
              if (isAdvMode())
                hide_props[key].domain_axis.push('dlabeltypealt');
              else {
                hide_props[key].domain_axis.push('dlabeltype');
                hide_props[key].domain_axis.push('dprecision');
              }
            }
            else {
              if (isAdvMode())
                hide_props[key].domain_axis = ['dlabeltypealt'];
              else
                hide_props[key].domain_axis = ['dlabeltype', 'dprecision'];
            }
          }
        }
      }
      if (!isAdvMode()) {
        // prop fisse da togliere
        hide_props.PIE._tabs.splice(hide_props.PIE._tabs.indexOf('radius'), 1);
        hide_props.RING.radius.splice(hide_props.RING.radius.indexOf('ringradout'), 1);
        
      }

      type = type || this.newProperties.graphtype[0].defaultValue;
      var refProps = hide_props[type];
      if (Empty(refProps))
        refProps = hide_props[default_chart];
      for (var tab in this._allProps) {
        var allFlds = this._allProps[tab];
        if (refProps._tabs.indexOf(tab) >= 0)
          continue;
        for (var i = 0; i < allFlds.length; i++) {
          if (!(tab in this.newProperties))
            this.newProperties[tab] = [];
          if (!Empty(refProps[tab])) {
            if (refProps[tab].indexOf(allFlds[i].propID) >= 0)
              continue;
          }
          this.newProperties[tab].push(allFlds[i]);
        }
      }
    }

    /*** TOOLBARS ***/
    this.PSToolbarLines = [
			{ 'id': 'lines'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('LINES'); }
				, 'image': getChartImageName('LINES')
				, 'title': getChartName('LINES')
			},
			{ 'id': 'radarline'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('RADARLINE'); }
				, 'image': getChartImageName('RADARLINE')
				, 'title': getChartName('RADARLINE')
			},
			{ 'id': 'pcoords' //'pcoordinates'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('PCOORDS'); }
				, 'image': getChartImageName('PCOORDS')
				, 'title': getChartName('PCOORDS')
			}
		]

		this.PSToolbarAreas = [
      { 'id': 'area'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('AREA'); }
				, 'image': getChartImageName('AREA')
				, 'title': getChartName('AREA')
			},
			{ 'id': 'stackedarea'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('STACKEDAREA'); }
				, 'image': getChartImageName('STACKEDAREA')
				, 'title': getChartName('STACKEDAREA')
			},
			{ 'id': 'radararea'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('RADARAREA'); }
				, 'image': getChartImageName('RADARAREA')
				, 'title': getChartName('RADARAREA')
			},
			{	'id': 'funnel'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('FUNNEL'); }
				, 'image': getChartImageName('FUNNEL')
				, 'title': getChartName('FUNNEL')
			}
		];

		this.PSToolbarBars = [
			{ 'id': 'vbar'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('VBAR'); }
				, 'image': getChartImageName('VBAR')
				, 'title': getChartName('VBAR')
				, 'withTitle': true
			},
			{ 'id': 'hbar'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('HBAR'); }
				, 'image': getChartImageName('HBAR')
				, 'title': getChartName('HBAR')
				, 'withTitle': true
			},
			{ 'id': 'vstackbar'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('VSTACKBAR'); }
				, 'image': getChartImageName('VSTACKBAR')
				, 'title': getChartName('VSTACKBAR')
				, 'withTitle': true
			},
			{ 'id': 'hstackbar'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('HSTACKBAR'); }
				, 'image': getChartImageName('HSTACKBAR')
				, 'title': getChartName('HSTACKBAR')
				, 'withTitle': true
			},
			{ 'id': 'layeredbar'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('LAYEREDBAR'); }
				, 'image': getChartImageName('LAYEREDBAR')
				, 'title': getChartName('LAYEREDBAR')
				, 'withTitle': true
			},
      { 'id': 'layeredbarh'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('LAYEREDBARH'); }
				, 'image': getChartImageName('LAYEREDBARH')
				, 'title': getChartName('LAYEREDBARH')
				, 'withTitle': true
			},
			{ 'id': 'treemapbar'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('TREEMAPBAR'); }
				, 'image': getChartImageName('TREEMAPBAR')
				, 'title': getChartName('TREEMAPBAR')
			},
			{ 'id': 'treemapbarh'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('TREEMAPBARH'); }
				, 'image': getChartImageName('TREEMAPBARH')
				, 'title': getChartName('TREEMAPBARH')
			},
			{ 'id': 'waterf'  //'water'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('WATERF'); }
				, 'image': getChartImageName('WATERF')
				, 'title': getChartName('WATERF')
				, 'withTitle': true
			},
			{ 'id': 'pyramid'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('PYRAMID'); }
				, 'image': getChartImageName('PYRAMID')
				, 'title': getChartName('PYRAMID')
				, 'withTitle': true
			},
			{ 'id': 'areabar'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('AREABAR'); }
				, 'image': getChartImageName('AREABAR')
				, 'title': getChartName('AREABAR')
				, 'withTitle': true
			}
		];

		this.PSToolbarCalculated = [
      { 'id': 'pareto'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('PARETO'); }
				, 'image': getChartImageName('PARETO')
				, 'title': getChartName('PARETO')
				, 'withTitle': true
			},
      { 'id': 'wordcloud' //'word'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('WORDCLOUD'); }
				, 'image': getChartImageName('WORDCLOUD')
				, 'title': getChartName('WORDCLOUD')
				, 'withTitle': true
			},
      { 'id': 'voronoi'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('VORONOI'); }
				, 'image': getChartImageName('VORONOI')
				, 'title': getChartName('VORONOI')
				, 'withTitle': true
			}
    ];

    this.PSToolbarTimes = [
			{ 'id': 'cal' //'tcal'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('CAL'); }
				, 'image': getChartImageName('CAL')
				, 'title': getChartName('CAL')
			}
		];

		this.PSToolbarPie = [
			{ 'id': 'pie'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('PIE'); }
				, 'image': getChartImageName('PIE')
				, 'title': getChartName('PIE')
				, 'withTitle': true
			},
			{ 'id': 'ring'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('RING'); }
				, 'image': getChartImageName('RING')
				, 'title': getChartName('RING')
				, 'withTitle': true
			},
			{ 'id': 'aster'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('ASTER'); }
				, 'image': getChartImageName('ASTER')
				, 'title': getChartName('ASTER')
				, 'withTitle': true
			},
			{ 'id': 'ringperc'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('RINGPERC'); }
				, 'image': getChartImageName('RINGPERC')
				, 'title': getChartName('RINGPERC')
				, 'withTitle': true
			}
		];

		this.PSToolbarPyramid = [
			{ 'id': 'pyr'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('PYR'); }
				, 'image': getChartImageName('PYR')
				, 'title': getChartName('PYR')
			},
			{ 'id': 'neckedpyr' //'neckedpyramid'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('NECKEDPYR'); }
				, 'image': getChartImageName('NECKEDPYR')
				, 'title': getChartName('NECKEDPYR')
			},
			{ 'id': 'pyrstr'  //'pyramidstr'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('PYRSTR'); }
				, 'image': getChartImageName('PYRSTR')
				, 'title': getChartName('PYRSTR')
			},
			{ 'id': 'neckedpyrstr'  //'neckedpyramidstr'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('NECKEDPYRSTR'); }
				, 'image': getChartImageName('NECKEDPYRSTR')
				, 'title': getChartName('NECKEDPYRSTR')
			}
		];

		this.PSToolbarXYZ = [
			{ 'id': 'scatter'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('SCATTER'); }
				, 'image': getChartImageName('SCATTER')
				, 'title': getChartName('SCATTER')
				, 'withTitle': true
			},
			{ 'id': 'bubble'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('BUBBLE'); }
				, 'image': getChartImageName('BUBBLE')
				, 'title': getChartName('BUBBLE')
				, 'withTitle': true
			}
		];

		this.PSToolbarHIE = [
			{ 'id': 'treemap' //'mtreemap'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('TREEMAP'); }
				, 'image': getChartImageName('TREEMAP')
				, 'title': getChartName('TREEMAP')
			},
			{ 'id': 'sunb'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('SUNB'); }
				, 'image': getChartImageName('SUNB')
				, 'title': getChartName('SUNB')
			},
			{ 'id': 'tree'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('TREE'); }
				, 'image': getChartImageName('TREE')
				, 'title': getChartName('TREE')
			},
			{ 'id': 'cpack' //'bubblec'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('CPACK'); }
				, 'image': getChartImageName('CPACK')
				, 'title': getChartName('CPACK')
			},
			{ 'id': 'marimekko'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('MARIMEKKO'); }
				, 'image': getChartImageName('MARIMEKKO')
				, 'title': getChartName('MARIMEKKO')
			},
			{ 'id': 'bcmatrix'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('BCMATRIX'); }
				, 'image': getChartImageName('BCMATRIX')
				, 'title': getChartName('BCMATRIX')
			}
		];

		this.PSToolbarHIEStr = [
			{ 'id': 'sunbstr'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('SUNBSTR'); }
				, 'image': getChartImageName('SUNBSTR')
				, 'title': getChartName('SUNBSTR')
			},
			{ 'id': 'treestr'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('TREESTR'); }
				, 'image': getChartImageName('TREESTR')
				, 'title': getChartName('TREESTR')
			},
			{ 'id': 'cpackstr'  //'cpacking'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('CPACKSTR'); }
				, 'image': getChartImageName('CPACKSTR')
				, 'title': getChartName('CPACKSTR')
			},
			{ 'id': 'force'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('FORCE'); }
				, 'image': getChartImageName('FORCE')
				, 'title': getChartName('FORCE')
			}
		];

		this.PSToolbarMeter = [
			{ 'id': 'arcdial' //'dial'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('ARCDIAL'); }
				, 'image': getChartImageName('ARCDIAL')
				, 'title': getChartName('ARCDIAL')
			},
			{ 'id': 'thermo'  //'thermom'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('THERMO'); }
				, 'image': getChartImageName('THERMO')
				, 'title': getChartName('THERMO')
			}
		];

		this.PSToolbarState = [
			{ 'id': 'lights'  //'trafficl'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('LIGHTS'); }
				, 'image': getChartImageName('LIGHTS')
				, 'title': getChartName('LIGHTS')
			},
			{ 'id': 'images'  //'imagesc'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('IMAGES'); }
				, 'image': getChartImageName('IMAGES')
				, 'title': getChartName('IMAGES')
			}
		];

		this.PSToolbarCounters = [
			{ 'id': 'display' //'displays'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('DISPLAY'); }
				, 'image': getChartImageName('DISPLAY')
				, 'title': getChartName('DISPLAY')
			},
			{ 'id': 'counter' //'counte'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('COUNTER'); }
				, 'image': getChartImageName('COUNTER')
				, 'title': getChartName('COUNTER')
			},
			{ 'id': 'paddle'  //'paddles'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('PADDLE'); }
				, 'image': getChartImageName('PADDLE')
				, 'title': getChartName('PADDLE')
			}
		];

		this.PSToolbarMaps = [
      { 'id': 'geomap'  //'geogmap'
        , 'class_name': 'btn'
        , 'action': function(){ setgraph('GEOMAP'); }
				, 'image': getChartImageName('GEOMAP')
				, 'title': getChartName('GEOMAP')
				, 'withTitle': true
      }
		];

		this.PSToolbarDeps = [
      { 'id': 'matrix'
        , 'class_name': 'btn'
        , 'action': function(){ setgraph('MATRIX'); }
				, 'image': getChartImageName('MATRIX')
				, 'title': getChartName('MATRIX')
				, 'withTitle': true
			},
			{ 'id': 'chord' //'chordribbon'
        , 'class_name': 'btn'
        , 'action': function(){ setgraph('CHORD'); }
				, 'image': getChartImageName('CHORD')
				, 'title': getChartName('CHORD')
				, 'withTitle': true
			},
			{ 'id': 'forcestr'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('FORCESTR'); }
				, 'image': getChartImageName('FORCESTR')
				, 'title': getChartName('FORCESTR')
			},
			{ 'id': 'sankey'
				, 'class_name': 'btn'
				, 'action': function(){ setgraph('SANKEY'); }
				, 'image': getChartImageName('SANKEY')
				, 'title': getChartName('SANKEY')
			}
		];

		this.PSToolbarAction = [
			{ 'id': 'new'
				, 'class_name': 'btn'
				, 'action': function(){ newCurrentObj(); }
				, 'image': '../portalstudio/images/icon/btn_new.png'
				, 'title': 'New'
			},
			{ 'id': 'open'
				, 'class_name': 'btn'
				, 'action': function(){ openFile(); }
				, 'image': '../portalstudio/images/icon/btn_open.png'
				, 'title': 'Open'
			},
			{ 'id': 'save'
				, 'class_name': 'btn'
				, 'action': function(){ save(); }
				, 'image': '../portalstudio/images/icon/btn_save.png'
				, 'title': 'Save'
			},
			{ 'id': 'saveas'
				, 'class_name': 'btn'
				, 'action': function(){ saveAs('true'); }
				, 'image': '../portalstudio/images/icon/btn_saveAs.png'
				, 'title': 'Save As'
			}
		]

		// OGGETTI-------------------------------------
		this.formObj=function(/*obj*/) {
			this.objClass = ZTObjects.formObjClass;
			this.type = 'Form';
//			initPropertiesDefaultValue(this);
			this.updateHTML = false;
			this.version = defversion;
			this.font_list = fList.slice();
			this._objType = "chart";
		}

		this.chartObj = function(/*obj*/) {
			this.objClass = ZTObjects.chartObjClass;
      var mobj = {};
      mobj.name = 'chart type';
      mobj.propID = 'ctype';
      mobj.type = charts_type;
      mobj.tooltip = 'Chart type';
      mobj.defaultValue = 'LINES';
      this.objClass._graphtype = [mobj];
			this.type = 'chart';
			this.updateHTML = false;
			this.id = "item0";
			this.name = "chart";
			this.font_list = fList.slice();
			this._objType = "chart";
		}
	}

	ZTObjects.formObj.prototype.getColors = function() {
		return this.colourseries;
	}
	ZTObjects.formObj.prototype.getGradients = function() {
		return this.gradientseries;
	}
	ZTObjects.chartObj.prototype.getColorsB = function() {
		return this.outlinecolour;
	}
	ZTObjects.chartObj.prototype.getGradientsB = function() {
		return this.outlinegradient;
	}
	ZTObjects.chartObj.prototype.getTrendlines = function() {
		return this.rangebands;
	}
  ZTObjects.chartObj.prototype.getColorsS = function() {
		return this.shapesseriescol;
	}
  ZTObjects.chartObj.prototype.getGradientS = function() {
		return "";
  }
  ZTObjects.chartObj.prototype.getColorsSC = function() {
		return this.shapescols;
	}
}

function getChartName(type) {
	if (type == "TIME")
		type = "LINES";
	if (type == "TIMEAREA")
		type = "AREA";
	if (ZtChartDict && ZtChartDict.Translate) {
		var trad = ZtChartDict.Translate("ZTC_" + type);
		if (typeof trad != "object")
      return trad;
		return trad.eng;
	}
	return type;
}

function getChartImageName(type){
	var ret = "../portalstudio/images/icon/btn_";
  switch (type) {
		case "HBAR":
			ret+="hbars";
			break;
		case "HBAR3D":
			ret+="hbars3";
			break;
		case "VBAR":
			ret+="bars";
			break;
		case "VBAR3D":
			ret+="3dbars";
			break;
		case "HSTACKBAR":
			ret+="hstackbars";
			break;
		case "HSTACKBAR3D":
			ret+="hstackbar3";
			break;
		case "VSTACKBAR":
			ret+="stackbars";
			break;
		case "VSTACKBAR3D":
			ret+="3dstackbars";
			break;
		case "PIE":
			ret+="pies";
			break;
		case "PIE3D":
			ret+="pies3";
			break;
		case "AREA":
			ret+="areas";
			break;
		case "STACKEDAREA":
			ret+="stacked_areas";
			break;
		case "ARCDIAL":
			ret+="dial";
			break;
		case "IMAGES":
			ret="../portalstudio/images/icon/bot_image_off";
			break;
		case "WORDCLOUD":
			ret+="word_cloud"
			break;
		case "TIMEAREA":
			ret+="tarea"
			break;
		default:
      // ret = "";
      ret += type.toLowerCase()
			break;
	}
	ret+=".png";
	return ret;
}