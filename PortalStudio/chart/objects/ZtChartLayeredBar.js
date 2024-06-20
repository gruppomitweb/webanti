function ZtLayeredBarChart(type, isH) {
  ZtBarChart.apply(this, [type, isH, -1]);
}
ZtLayeredBarChart.prototype = Object.create(ZtBarChart.prototype);
ZtLayeredBarChart.prototype.constructor = ZtLayeredBarChart;

ZtLayeredBarChart.prototype._DrawChartElements = function () {
  delete this.bandWidth;
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var yIndex = -1,
  progressWidth = this._GetBarWidthFromDomainEvaluation(),
  cobj,
  dSeries = this._GetDrawingList();
  for(var i = 0; i < dSeries.length; i++) {
    yIndex = this.propertyName.indexOf(dSeries[i]);
    cobj = this._GetDrawParamObject(progressWidth);
    cobj.scaleY = this.scaleY[dSeries[i]];
    this.DrawBar(group, this.dataSet, i, this.xIndex, yIndex, cobj);
    progressWidth = progressWidth - (progressWidth / dSeries.length);
  }
}

ZtLayeredBarChart.prototype._GetVBarX = function (data, dataIndex, xIndex, yIndex, cobj) {
  var x = this.scaleX(data[xIndex]) + (this._GetBarWidthFromDomainEvaluation() / 2) - (cobj.barWidth / 2);
  return x;
}

ZtLayeredBarChart.prototype._GetVBarY = function (data, dataIndex, xIndex, yIndex, cobj) {
  var y = 0,
  max = this.defSettings.valueAxis.maxValue,
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  if (data[yIndex] < 0) {
    if (!Empty(max) && max < 0)
      y = cobj.scaleY(max);
    else
      y = cobj.scaleY(sMax);
  }
  else {
    if (!Empty(max) && data[yIndex] > max)
      y = cobj.scaleY(max);
    else
      y = cobj.scaleY(data[yIndex]);
  }
  return y;
}

ZtLayeredBarChart.prototype._GetVBarWidth = function (data, yIndex, cobj) {
  var w = cobj.barWidth;
  return w;
}

ZtLayeredBarChart.prototype._GetVBarHeight = function (data, yIndex, cobj) {
  var h = 0,
  min = this.defSettings.valueAxis.minValue,
  max = this.defSettings.valueAxis.maxValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain()),
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  
  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;
  if ((isNaN(max) || max === undefined || Empty(max)) && max !== 0)
    max = null;

  if (data[yIndex] < 0) {
    if (Empty(max) || max >= 0) {
      if (!Empty(min) && min <= 0 && data[yIndex] < min)
        h = Math.abs(cobj.scaleY(min) - cobj.scaleY(sMax));
      else if (!Empty(min) && min >= 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMax));
    }
    else {
      if (max <= data[yIndex])
        h = 0;
      if (!Empty(min) && min <= 0 && data[yIndex] < min)
        h = Math.abs(cobj.scaleY(min) - cobj.scaleY(max));
      else if (!Empty(min) && min >= 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(max));
    }
  }
  else {
    if (!Empty(min) && min > 0) {
      if (min > data[yIndex])
        h = 0;
      if (!Empty(max) && data[yIndex] > max && max >= 0)
        h = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
      else if (max < 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(min));
    }
    else {
      if (!Empty(max) && data[yIndex] > max && max >= 0)
        h = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
      else if (max < 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
    }
  }
  return h;
}

ZtLayeredBarChart.prototype._GetHBarX = function (data, dataIndex, xIndex, yIndex, cobj) {
  var x = 0,
  min = this.defSettings.valueAxis.minValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain()),
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  
  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;

  if (data[yIndex] < 0) {
    if (!Empty(min) && min <= 0 && data[yIndex] < min)
      x = cobj.scaleY(Math.min(sMax, min));
    else
      x = cobj.scaleY(Math.min(sMax, data[yIndex]));
  }
  else {
    if (!Empty(min) && min > 0)
      x = cobj.scaleY(Math.min(min, data[yIndex]));
    else
      x = cobj.scaleY(Math.min(sMin, data[yIndex]));
  }
  return x;
}

ZtLayeredBarChart.prototype._GetHBarY = function (data, dataIndex, xIndex, yIndex, cobj) {
  return this._GetVBarX(data, dataIndex, xIndex, yIndex, cobj);
}

ZtLayeredBarChart.prototype._GetHBarWidth = function (data, yIndex, cobj) {
  var w = 0,
  min = this.defSettings.valueAxis.minValue,
  max = this.defSettings.valueAxis.maxValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain()),
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  
  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;
  if ((isNaN(max) || max === undefined || Empty(max)) && max !== 0)
    max = null;

  if (data[yIndex] < 0) {
    if (!Empty(max)) {
      if (max < 0 && max > data[yIndex]) {
        if (!Empty(min) && min < 0 && data[yIndex] <= min)
          w = Math.abs(cobj.scaleY(min) - cobj.scaleY(max));
        else if ((!Empty(min) && min < 0 && data[yIndex] > min) || Empty(min))
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(max));
        else
          w = 0;
      }
      else if (max >= 0) {
        if (!Empty(min) && min < 0 && data[yIndex] <= min) {
          w = Math.abs(cobj.scaleY(min) - cobj.scaleY(sMax));
        }
        else if ((!Empty(min) && min < 0 && data[yIndex] > min) || Empty(min)) {
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMax));
        }
        else
          w = 0;
      }
      else
        w = 0;
    }
    else{
      if (!Empty(min) && min < 0 && data[yIndex] <= min) {
        w = Math.abs(cobj.scaleY(min) - cobj.scaleY(sMax));
      }
      else if ((!Empty(min) && min < 0 && data[yIndex] > min) || Empty(min)) {
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMax));
      }
      else
        w = 0;
    }
  }
  else{
    if (!Empty(min)) {
      if (min < data[yIndex] && min >= 0) {
        if (!Empty(max)) {
          if (max > 0 && max <= data[yIndex])
            w = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
          else if (max > 0 && max > data[yIndex])
            w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(min));
          else
            w = 0;
        }
        else{
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(min));
        }
      }
      else if (min < 0) {
        if (!Empty(max)) {
          if (max > 0 && max <= data[yIndex])
            w = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
          else if (max > 0 && max > data[yIndex])
            w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
          else
            w = 0;
        }
        else{
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
        }
      }
      else
        w = 0;
    }
    else{
      if (!Empty(max)) {
        if (max >  0 && max <= data[yIndex])
          w = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
        else if (max > 0 && max > data[yIndex])
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
        else
          w = 0;
      }
      else{
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
      }
    }
  }
  return w;
}

ZtLayeredBarChart.prototype._GetHBarHeight = function (data, yIndex, cobj) {
  return this._GetVBarWidth(data, yIndex, cobj);
}

ZtLayeredBarChart.prototype._GetDrawParamObject = function (barWidth) {
  return  { barWidth : barWidth }
}
