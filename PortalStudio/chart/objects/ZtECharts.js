if (typeof ZtECharts == 'undefined')
  var ZtECharts = {
    nSeries: -1
  };

ZtECharts.GetSeries = function (type, objConfig, allFields, dataset, noDef, graphs) {
  this.nSeries = -1;
  var ser_array = [],
  ser_obj,
  i,
  fld_list = [],
  strSer_obj,
  ser_data;

  switch (type) {
    case "LINES":
    case "AREA":
    case "STACKEDAREA":
      ser_obj = {
        type: "line"
      };
      if (!noDef) {
        ser_obj.symbol = !graphs.shape.draw ? "none" : graphs.shape.figure;
        ser_obj.symbolSize = graphs.shape.size;
      }
      if (type.indexOf("AREA") >= 0)
        ser_obj.areaStyle = {
          opacity: 0.3
        };
      fld_list = objConfig.valueFields.split(",");
      break;
    case "HBAR":
    case "VBAR":
    case "HSTACKBAR":
    case "VSTACKBAR":
    case "WATERF":
      ser_obj = { type: "bar" };
      fld_list = objConfig.valueFields.split(",");
      break;
    case "PIE":
    case "RING":
      ser_obj = {
        type: "pie"
      };
      if (!noDef)
        ser_obj.radius = [type == "PIE" ? "0%" : (graphs.radius.inner + "%"), "100%"];
      else
        ser_obj.radius = [type == "PIE" ? "0%" : "75%", "100%"];
      ser_array.push(ser_obj);
      break;
    case "RINGPERC":
      ser_obj = {
        type: "gauge",
        startAngle: 90,
        endAngle: -270,
        radius: ["30%", "100%"],
        pointer: {
          show: false
        },
        progress: {
          show: true,
          overlap: false
        },
        axisLine: {
          lineStyle: {
            width: 100 - (noDef ? 75 : graphs.radius.inner)
          }
        },
        splitLine: {
          show: false,
        },
        axisTick: {
          show: false
        },
        axisLabel: {
          show: false
        },
        detail: {
          show: false
        }
      }
      fld_list = getList(allFields.indexOf(objConfig.labelField), dataset);
      break;
    case "RADARLINE":
    case "RADARAREA":
      ser_obj = {
        type: "radar",
        data: []
      };
      if (!noDef) {
        ser_obj.symbol = !graphs.shape.draw ? "none" : graphs.shape.figure;
        ser_obj.symbolSize = graphs.shape.size;
      }
      fld_list = objConfig.valueFields.split(",");
      ser_array.push(ser_obj);
      break;
    case "SCATTER":
    case "BUBBLE":
      fld_list =  getList(allFields.indexOf(objConfig.labelSeries), dataset);
      ser_obj = { type: "scatter" };
      break;
    case "PCOORDS":
      fld_list = getList(allFields.indexOf(objConfig.labelField), dataset);
      ser_obj = { type: "parallel" };
      break;
    case "TREEMAP":
    case "SUNB":
    case "SUNBSTR":
      var levelsFields = objConfig.labelField.split(","),
        lSeries = !Empty(objConfig.labelSeries) ? objConfig.labelSeries : levelsFields[0],
        hie_data = getHieDataset(dataset, levelsFields, objConfig.valueFields, lSeries, allFields, [], false, null, ([] || objConfig.keyField.split(",")));
      ser_obj = {
        type: (type.indexOf("SUNB") >= 0) ? "sunburst" : "treemap",
        data: hie_data.children.slice()
      }
      if (type == "TREEMAP" && !noDef)
        ser_obj.levels = [
          { itemStyle: { gapWidth: graphs.treemap.outerPadding } },
          { itemStyle: { gapWidth: graphs.treemap.innerPadding } }
        ]
      ser_array.push(ser_obj)
      this.nSeries = ser_obj.data.length;
      break;
  }

  if (type.indexOf("STACK") >= 0 || type == "WATERF")
    ser_obj.stack = "stacked";

  if (!noDef) {
    ser_obj.emphasis = {
      itemStyle: {
        color: Empty(graphs.hoverColor) ? "auto" : graphs.hoverColor
      }
    }
    ser_obj.colorBy = (type == "PIE" || type == "RING" || graphs.useColorSeriesForEach || type.indexOf("RADAR") >= 0) 
      ? "data" 
      : "series";
  }
  
  ser_data = [];
  for (i = 0; i < fld_list.length; i++) {
    if (type.indexOf("RADAR") >= 0) {
      ser_data = dataset.reduce(function(total, record) {
        var y = allFields.indexOf(fld_list[i]);
        total.push(record[y]);
        return total;
      }, []);
      ser_obj.data.push({ value: ser_data.slice(), name: objConfig.labelSeries.split(",")[i]});
      if (type == "RADARAREA") {
        ser_obj.data[ser_obj.data.length - 1].areaStyle = { opacity: 0.3 }
      }
    }
    else if (type == "WATERF") {
      var data_1 = [],
        data_2 = [],
        y = allFields.indexOf(fld_list[i]);
      for (var j = 0; j < dataset.length; j++) {
        if (j == 0) {
          data_1.push(0);
          data_2.push(dataset[j][y]);
        }
        else {
          if ((dataset[j][y] - dataset[j - 1][y]) >= 0)
            data_1.push(dataset[j - 1][y]);
          else
            data_1.push(dataset[j][y]);
          data_2.push(Math.abs(dataset[j][y] - dataset[j - 1][y]));
        }
      }
      strSer_obj = JSON.stringify(ser_obj);
      ser_array.push(JSON.parse(strSer_obj)); // evito reference
      ser_array[ser_array.length - 1].data = data_1;
      ser_array[ser_array.length - 1].itemStyle = {
        borderColor: 'transparent',
        color: 'transparent'
      }
      ser_array[ser_array.length - 1].emphasis.itemStyle = 'transparent';
      ser_array.push(JSON.parse(strSer_obj)); // evito reference
      ser_array[ser_array.length - 1].data = data_2;
    }
    else {
      if (type == "SCATTER" || type == "BUBBLE") {
        ser_data = dataset.reduce(function(total, record) {
          var s = allFields.indexOf(objConfig.labelSeries),
            x = allFields.indexOf(objConfig.labelField),
            y = allFields.indexOf(objConfig.valueFields);
          if (record[s] == fld_list[i]) {
            total.push([record[x], record[y]])
          }
          return total;
        }, []);
        ser_obj.data = ser_data.slice();
      }
      else if (type == "PCOORDS") {
        var nAxis = objConfig.valueFields.split(",");
        ser_data = dataset.reduce(function(total, record) {
          var x = allFields.indexOf(objConfig.labelField);
          if (record[x] == fld_list[i]) {
            var t_rec = [];
            for (var j = 0; j < nAxis.length; j++) {
              var y = allFields.indexOf(nAxis[j]);
              t_rec.push(record[y])
            }
            total.push(t_rec.slice())
          }
          return total;
        }, []);
        ser_obj.data = ser_data.slice();
        ser_obj.name = fld_list[i];
      }
      else if (type == "RINGPERC") {
        ser_data = dataset.reduce(function(total, record) {
          var x = allFields.indexOf(objConfig.labelField),
          y = allFields.indexOf(objConfig.valueFields);
          if (record[x] == fld_list[i]) {
            if (Empty(objConfig.maxFields)) {
              total.push(/*record[x],*/ record[y]/*, 100 - record[y]*/)
            }
            else {
              //var max = record[allFields.indexOf(objConfig.maxFields)];
              total.push(/*record[x],*/ record[y]/*, (record[y] * 100) / max*/)
            }
          }
          return total;
        }, []);
        ser_obj.data = ser_data.slice();
        ser_obj.name = fld_list[i];
        // posizionamento delle serie
  //      ser_obj.left = (i * (100 / fld_list.length)) + "%";
  //      ser_obj.right = (((fld_list.length - 1) - i) * (100 / fld_list.length)) + "%";

        ser_obj.center = [(i * (100 / fld_list.length) / 2) + (100 / fld_list.length) / 2 + "%", "50%"];
      }

      strSer_obj = JSON.stringify(ser_obj);
      ser_array.push(JSON.parse(strSer_obj)); // evito reference

      if (type == "SCATTER") {
        /*ser_array[ser_array.length - 1].symbolSize = function (datam) {
          console.log("data", datam)
          return 4// Math.sqrt(data[2]) / 5e2;
        }*/
      }
    }
  }
  
  if (fld_list.length > 0)
    this.nSeries = fld_list.length;
  
  return ser_array;
}

ZtECharts.GetDimensions = function (type, objConfig/*, dataset*/) {
  var dim_array = [];
  switch (type) {
    case "SCATTER":
    case "BUBBLE":
    case "RADARLINE":
    case "RADARAREA":
    case "PCOORDS":
    case "RINGPERC":
    case "WATERF":
    case "TREEMAP":
    case "SUNB":
    case "SUNBSTR":
      break;
    default:
      dim_array = [objConfig.labelField].concat(objConfig.labelSeries.split(","));
      break;
  }
  return dim_array;
}

ZtECharts.GetDataset = function (type, objConfig, dataset) {
  switch (type) {
    case "SCATTER":
    // case "BUBBLE":
    case "RADARLINE":
    case "RADARAREA":
    case "PCOORDS":
    case "RINGPERC":
    case "WATERF":
    case "TREEMAP":
    case "SUNB":
    case "SUNBSTR":
      return null;
    case "HBAR":
    case "HSTACKBAR":
      return dataset.slice().reverse();
    default:
      return dataset.slice();
  }
}

ZtECharts.SetAxisTypes = function (type, opts) {
  if (type == "SCATTER") {
  //  opts.yAxis.min = "dataMin";
   //opts.yAxis.max = "dataMax";
    return;
  }
  opts.xAxis.type = "category";
  opts.yAxis.type = "value";
  if (type == "HBAR" || type == "HSTACKBAR") {
    opts.xAxis.type = "value";
    opts.xAxis.position = "top";
    var xName = opts.xAxis.name;
    opts.xAxis.name = opts.yAxis.name;
    opts.yAxis.type = "category";
    opts.yAxis.name = xName;
  }

  var noAxis = (
    type == "PIE" ||
    (type.indexOf("RING") >= 0) ||
    (type.indexOf("RADAR") >= 0) ||
    type == "PCOORDS" ||
    type == "TREEMAP" ||
    (type.indexOf("SUNB") >= 0)
  )
  if (noAxis) {
    delete opts.xAxis;
    delete opts.yAxis;
  }
}

ZtECharts.SetGraphicOptions = function (type, opts, objConfig, allFields, dataset) {
  if (type.indexOf("RADAR") >= 0) {
    opts.radar = { 
      indicator: (function () {
        var names = [];
        for (var i = 0; i < dataset.length; i++) {
          var x = allFields.indexOf(objConfig.labelField);
          names.push({ name: dataset[i][x] });
        }
        return names;
      })(),
      splitLine: {
        show: false
      },
      splitArea: {
        show: false
      }
    };
  }
  else if (type == "PCOORDS") {
    opts.parallelAxis = (function () {
      var dims = [],
      nAxis = objConfig.labelSeries.split(",");
      for (var i = 0; i < nAxis.length; i++) {
        dims.push({ dim: i, name: nAxis[i] });
      }
      return dims;
    })();
  }
  else if (type == "WATERF") {
    opts.xAxis.data = getList(allFields.indexOf(objConfig.labelField), dataset);
  }
}

ZtECharts.SetColors = function (cconfig, opts) {
  if (this.nSeries <= 0 && opts.dataset)
    this.nSeries = opts.dataset.source.length;

  var colors = cconfig.graphSettings.colorSeries.slice();
  /* wip
  if (!Empty(this.customColors.array)) {
    colors = this.customColors.array.slice();
    cconfig.graphSettings.useColorSeriesForEach = this.customColors.useForEach;
  }*/
  if (colors.length == 0 || (colors.length == 1 && Empty(colors[0].color) && Empty(colors[0].gradient)))
    colors = [];
  var seriesColors = [];
  if (colors && (!Empty(colors) || colors.length > 0)) {
    seriesColors = seriesColors.concat(colors.map(function (c_obj) {
      // creo gradiente se presente
      if (!Empty(c_obj.gradient)) {
        return {
          type: 'linear',
          x: 0,
          y: 0,
          x2: 0,
          y2: 1,
          colorStops: [{
            offset: 0, color: c_obj.color
          }, {
            offset: 1, color: c_obj.gradient
          }]
        }
      }
      return c_obj.color;
    }));
  }
  // reusecolor applicata di default dalla lib
  if (!cconfig.graphSettings.reuseColorSeries && seriesColors.length < this.nSeries) {
    var defaultColors = getAllDefaultColors(true),
      diffLen = Math.abs(seriesColors.length - this.nSeries),
      i;
    if (defaultColors < diffLen) {
      seriesColors = seriesColors.concat(defaultColors);
      for (i = 0; i < (diffLen - defaultColors.length); i++) {
        seriesColors.push(getRandomColor());
      }
    }
    else {
      for (i = 0; i < diffLen; i++) {
        seriesColors.push(defaultColors[i]);
      }
    }

    /* wip
    var indexes = Object.keys(this._ZtChart.StdChart.customColorsSeries);
    for (var i = 0; i < indexes.length; i++) {
      var idx = parseInt(Strtran(indexes[i], "_", ""));
      this.colorSet[idx] = this._ZtChart.StdChart.customColorsSeries[indexes[i]];
    }*/

    opts.color = seriesColors.slice();
  }
}

/* gestito per ora in ChartCtrl
ZtECharts._AvailableChart = function (type) {
  var avCharts = ["LINES", "AREA", "STACKEDAREA", 
    "HBAR", "VBAR", "HSTACKBAR", "VSTACKBAR", "WATERF",
    "PIE", "RING", "RINGPERC", "RADARLINE", "RADARAREA",
    "SCATTER", "BUBBLE", "PCOORDS", "TREEMAP", "SUNB", "SUNBSTR"
  ];

  return (avCharts.indexOf(type.toUpperCase()) >= 0);
}*/