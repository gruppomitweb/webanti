/* exported
    doLoad addRowToGrid
  */

var raphael, structure, cols_items, errors = [],
  m_bError = false,
  m_bUpdated = false;

var col_width = 0,
  row_height = 0,
  hgap = 20,
  wgap = 8,
  td_margin = 0,
  tot_rows = 0,
  tot_cols = 0;

function doLoad() {
  /*creazione dell'elemento per Raphael*/
  raphael = Raphael(document.getElementById('backcanvas'), document.body.clientWidth, document.body.clientHeight - document.getElementById('topbar').getBoundingClientRect().height);

  LibJavascript.Events.addEvent(document.getElementById('toolbar_ok'), 'click', function() {
    parent.window.RowViewLayer.close();
    parent.viewrowopen = false;
  });
  LibJavascript.Events.addEvent(document.getElementById('toolbar_cancel'), 'click', function() {
    if(m_bUpdated) {
      if(confirm("Do you want to save new position of columns ?\n\nClick OK to save\nClick Cancel to ignore changes"))
        SaveAndClose()
      else {
        parent.window.RowViewLayer.close();
      }
    } else {
      parent.window.RowViewLayer.close();
    }
  });
  Load();
    function hide_loader(evt) {
      var target = (evt.target||evt.srcElement);
      target.style.display = 'none';
      target.removeEventListener('transitionend', hide_loader);
    }
    document.getElementById('loader').addEventListener('transitionend', hide_loader);
    LibJavascript.CssClassNameUtils.addClass(document.getElementById('container'), 'visible');
    LibJavascript.CssClassNameUtils.addClass(document.getElementById('loader'), 'hidden');
  LibJavascript.Events.addEvent(document.body, 'keydown', function(event) {
    var keyCode=(event.which || event.keyCode);
    if(event.ctrlKey && keyCode == 83) {
      if(Save()) {
        parent.save();
      }
      event.cancelBubble=true
      if(event.stopPropagation) event.stopPropagation();
      if(event.preventDefault) event.preventDefault(true);
      event.returnValue=false

    } //CTRL-S
  });
  LibJavascript.Events.addEvent(window, 'resize', function() {
    clearTimeout(resizeTimer);
    resizeTimer = setTimeout(ResizeEditor, 50);
  });
}

function SaveAndClose() {
  if(Save()) {
    parent.window.RowViewLayer.close();
    parent.viewrowopen = false;
  }
}

function Save() {
  var i;
  if(m_bError) {
    alert('You cannot have empty zones or zones with double or more fields.');
    return false;
  }
  structure.sort(function(a, b) {
    if(a.row != b.row) {
      return a.row - b.row;
    } else {
      return a.col - b.col;
    }
  });

  var newCols = new Array(structure.length);
  var curRow = 0;
  for(i = 0; i < structure.length; i++) {
    newCols[i] = {
      id: structure[i].id,
      field: structure[i].field,
      title: structure[i].title,
      col_span: structure[i].width + "",
      row_span: structure[i].height + "",
      new_line: (structure[i].row > curRow ? true : false)
    }
    curRow = structure[i].row;
  }
  var _cols = parent.columnsObj;
  for(i = 0; i < newCols.length; i++) {
    var idx = LibJavascript.Array.indexOf(_cols, newCols[i].id, function(el, tocompare) {
      return el.id == tocompare
    });
    var c = _cols.splice(idx, 1);
    c = c[0];
    c.col_span = newCols[i].col_span;
    c.row_span = newCols[i].row_span;
    c.new_line = newCols[i].new_line;
    _cols.splice(i, 0, c);
  }
  parent.columnsList.ReplaceList(parent.columnsObj);
  return true;
}

function Load() {
  var gridfill = [];
  var _cols = parent.columnsObj;
  structure = [];
  var col = 0,
    row = 0,
    last_width = 1;
  tot_rows = 1;
  for(var i = 0; i < _cols.length; i++) {
    if(_cols[i].new_line) {
      row++;
      tot_cols = Math.max(tot_cols, col + last_width);
      col = 0;
      tot_rows = row + 1;
    }
    if(gridfill[col] == null) gridfill[col] = [];
    while(gridfill[col][row] == 1) {
      col++;
      if(gridfill[col] == null) gridfill[col] = [];
    }
    for(var j = col; j < (col + parseInt(_cols[i].col_span) || 1); j++) {
      if(gridfill[j] == null) gridfill[j] = []
      for(var k = row; k < (row + parseInt(_cols[i].row_span) || 1); k++) {
        gridfill[j][k] = 1;
      }
    }
    var el = {
      id: _cols[i].id,
      field: _cols[i].field,
      title: _cols[i].title,
      width: parseInt(_cols[i].col_span) || 1,
      height: parseInt(_cols[i].row_span) || 1,
      row: row,
      col: col
    };
    structure.push(el);
    col++;
    last_width = el.width;
  }
  tot_rows++; //visualizzo spazio per una riga in piu'
  tot_cols = Math.max(tot_cols, col); //e' gia' stato fatto il +1 alla fine del ciclo
  // writeHTML()
  // clearTimeout(resizeTimer);
}

function writeHTML() {
  console.log('writehtml')
  raphael.clear();
  cols_items = [];
  errors = [];
  createGrid(cols_items, tot_cols + (tot_cols == structure.length ? 0 : 1));
  for(var i = 0; i < structure.length; i++) {
    drawItem(structure[i]);
  }
}

function createGrid(cols_items, cols_n) {
  var o_line, v_line, columns, i;
  var tot_width = document.getElementById('backcanvas').getBoundingClientRect().width;
  var tot_height = document.getElementById('backcanvas').getBoundingClientRect().height;
  var td_width = 0,
    point_top = 0;
  row_height = Math.min((tot_height - hgap) / tot_rows, 65);
  td_margin = 0;

  col_width = Math.min(Math.floor(tot_width / cols_n), 250);
  td_margin = Math.ceil(col_width * 0.05); // i margini sono il 5%
  td_width = col_width - (td_margin * 2);

  point_top = tot_height / 3 - 10;
  if(document.getElementById('o-line') && document.getElementById('columns')) {
    document.querySelectorAll('.o-line-element').forEach(function(el, index) {
      el.style.left = (col_width * index + wgap) + 'px';
    });
    document.querySelectorAll('.v-line-element').forEach(function(el, index) {
      el.style.top = (point_top * index + hgap) + 'px';
    });
    document.querySelectorAll('.col').forEach(function(el, index) {
      el.style.left = (col_width * index + wgap) + 'px';
      el.style.width = td_width + 'px';
    });
  } else {
    o_line = raphael.path("M" + wgap + ",0H" + (tot_width));
    o_line.attr('stroke', '#454545');
    v_line = raphael.path("M0, " + hgap + "V" + (tot_height));
    v_line.attr('stroke', '#454545');

    for(i = 0; i < cols_n; i++) {
      raphael.path("M" + (col_width * i + wgap) + ",0V3");
      cols_items.push(columns = raphael.rect((col_width * i + wgap) + td_margin, hgap, col_width - (td_margin * 2), tot_height - hgap));
      columns.node.setAttribute("class", "rect-container");
      columns.text = raphael.text(col_width * i + wgap + col_width / 2, 8, i);
      columns.text.node.setAttribute("class", "number");
      columns.text.node.setAttribute("style", "");
    }

    for(i = 0; i < tot_rows + 1; i++) {
      raphael.path("M0, " + (row_height * i + hgap) + ",0H3");
      var rows_txt = raphael.text(10, row_height * i + hgap + row_height / 2, i);
      rows_txt.node.setAttribute("class", "number");
      rows_txt.node.setAttribute("style", "");
    }

    // raphael.safari();
  }
}

function addRowToGrid(howmuch) {
  tot_rows += howmuch;
  writeHTML();
}

function checkView(forceWrite) {
  var i, j, k, b, w, el;
  var gridfill = [];
  for(i = 0; i < structure.length; i++) {
    gridfill.push([]);
    for(j = 0; j < structure.length; j++) {
      gridfill[i].push(0);
    }
  }

  var rowfilled = new Array(structure.length + 1).join('0').split('').map(function(e) {
    return parseInt(e, 10);
  });

  var colfilled = new Array(structure.length + 1).join('0').split('').map(function(e) {
    return parseInt(e, 10);
  });

  var rows = 0,
    cols = 0;

  for(i = 0; i < structure.length; i++) {
    for(j = structure[i].col; j < structure[i].col + structure[i].width; j++) {
      colfilled[j]++;
    }
    for(j = structure[i].row; j < structure[i].row + structure[i].height; j++) {
      rowfilled[j]++;
    }
    for(j = structure[i].col; j < structure[i].col + structure[i].width; j++) {
      for(k = structure[i].row; k < structure[i].row + structure[i].height; k++) {
        gridfill[j][k]++;
      }
    }
    cols = Math.max(structure[i].col + structure[i].width, cols);
    rows = Math.max(structure[i].row + structure[i].height, rows);
  }

  if(rows < structure.length) rows++;

  while(colfilled.length > 0 && colfilled[colfilled.length - 1] === 0) {
    gridfill.pop();
    colfilled.pop();

  }

  while(rowfilled.length > 0 && rowfilled[rowfilled.length - 1] === 0) {
    for(i = 0; i < gridfill.length; i++) {
      gridfill[i].pop();
    }
    rowfilled.pop();
  }

  var blankrow = rowfilled.indexOf(0);
  var blankcol = colfilled.indexOf(0);

  if(blankrow > -1) {
    for(i = 0; i < structure.length; i++) {
      if(structure[i].row > blankrow)
        structure[i].row--;
    }
    checkView(true);
    return;
  } else if(blankcol > -1) {
    for(i = 0; i < structure.length; i++) {
      if(structure[i].col > blankcol)
        structure[i].col--;
    }
    checkView(true);
    return;
  } else if(cols != tot_cols || rows != tot_rows || forceWrite) {
    tot_rows = rows;
    tot_cols = cols;
    writeHTML();
  }

  for(i = 0; i < errors.length; i++) {
    if(errors[i].text)
      errors[i].text.remove();
    errors[i].remove();
  }

  errors = [];
  m_bError = false;

  for(i = 0; i < gridfill.length; i++) {
    for(j = 0; j < gridfill[i].length; j++) {
      if(gridfill[i][j] === 0) { //spazio vuoto
        b = cols_items[i].getBBox();
        w = cols_items[i].getBBox().x - b.x;
        el = raphael.rect(b.x, j * row_height + hgap, w + b.width, (row_height) - hgap / 2, 1);
        el.node.setAttribute("class", "rect-empty");
        el.text = raphael.text(el.getBBox().x + 10, el.getBBox().y + 10, 'empty')
        el.text.attr('x', el.getBBox().x + (el.getBBox().width - el.text.getBBox().width) / 2)
        el.text.attr('y', el.getBBox().y + el.getBBox().height - (el.text.getBBox().height + 10))
        el.text.node.setAttribute("class", "text-empty");
        el.text.node.setAttribute("style", "");
        errors.push(el);
        m_bError = true;
      } else if(gridfill[i][j] > 1) { //due campi nella stessa posizione
        b = cols_items[i].getBBox();
        w = cols_items[i].getBBox().x - b.x;
        el = raphael.rect(b.x, j * row_height + hgap, w + b.width, (row_height) - hgap / 2, 1);
        el.node.setAttribute("class", "rect-error");
        el.text = raphael.text(el.getBBox().x + 10, el.getBBox().y + 10, 'two or more fields')
        el.text.attr('x', el.getBBox().x + (el.getBBox().width - el.text.getBBox().width) / 2)
        el.text.attr('y', el.getBBox().y + el.getBBox().height - (el.text.getBBox().height + 10))
        el.text.node.setAttribute("class", "text-error");
        el.text.node.setAttribute("style", "");
        el.insertAfter(cols_items);
        errors.push(el);
        m_bError = true;
      }
    }
  }
}

function drawItem(item) {
  var width = item.width;
  var height = item.height;
  var b = cols_items[item.col].getBBox();
  var w = cols_items[item.col + width - 1].getBBox().x - b.x;
  item.pict = raphael.rect(b.x, item.row * row_height + hgap, w + b.width, (row_height * height) - hgap / 2, 1);
  item.pict.data = item;
  item.pict.node.setAttribute("class", "rect-standard");
  item.pict.attr('title', item.title || item.field)
  item.pict.text = raphael.text(item.pict.getBBox().x + 10, item.pict.getBBox().y + 10, item.title || item.field)
  item.pict.text.attr('x', item.pict.getBBox().x + (item.pict.getBBox().width - item.pict.text.getBBox().width) / 2)
  item.pict.text.node.setAttribute("class", "text-standard");
  item.pict.text.node.setAttribute("style", "");
  item.pict.resize_handle = raphael.image('../portalstudio/images/ps-editor-resize.png', (item.pict.getBBox().x + item.pict.getBBox().width) - 12, (item.pict.getBBox().y + item.pict.getBBox().height) - 12, 12, 12)
  item.pict.resize_handle.attr('cursor', 'se-resize')
  item.pict.resize_handle.parent = item.pict;

  var col = 0,
    row = 0;
  var delta = {};
  item.pict.drag( //DRAG
    function(dx, dy, x, y/*, event*/) { /* onmove */
      var backcanvas = document.getElementById('backcanvas');
      var bcbcr = backcanvas.getBoundingClientRect();
      if(y > bcbcr.y &&
        y < bcbcr.y + bcbcr.height &&
        x > bcbcr.x &&
        x < bcbcr.x + bcbcr.width) {
        var pos = {
          'x': (x - bcbcr.x),
          'y': (y - bcbcr.y)
        }
        col = Math.round(dx / (col_width + td_margin));
        this.attr('x', pos.x - delta.x);
        this.resize_handle.attr('x', (this.getBBox().x + this.getBBox().width) - 12)
        this.text.attr('x', this.getBBox().x + (this.getBBox().width - this.text.getBBox().width) / 2)
        row = Math.round(dy / row_height);
        this.attr('y', pos.y - delta.y);
        this.resize_handle.attr('y', (this.getBBox().y + this.getBBox().height) - 12)
        this.text.attr('y', this.getBBox().y + 10)
      }
    },
    function(x, y/*, event*/) { /* onstart */
      delta = {
        'x': (x - (document.getElementById('backcanvas').getBoundingClientRect().x + this.getBBox().x)),
        'y': (y - (document.getElementById('backcanvas').getBoundingClientRect().y + this.getBBox().y))
      }
    },
    function() { /* onend */
      this.data.col = col + this.data.col > 0 ? (col + this.data.col + this.data.width < structure.length ? col + this.data.col : structure.length - this.data.width) : 0;
      this.data.row = (this.data.row + row > 0 ? this.data.row + row : 0);
      if(this.data.col > cols_items.length - 1)
        this.data.col = cols_items.length - 1;
      this.attr('x', cols_items[this.data.col].getBBox().x)
      this.attr('y', this.data.row * row_height + hgap)
      this.resize_handle.attr('x', (this.getBBox().x + this.getBBox().width) - 12)
      this.text.attr('x', this.getBBox().x + (this.getBBox().width - this.text.getBBox().width) / 2)
      this.resize_handle.attr('y', (this.getBBox().y + this.getBBox().height) - 12)
      this.text.attr('y', this.getBBox().y + 10)
      checkView();
      m_bUpdated = true;
      row = 0;
      col = 0;
    }
  )
  item.pict.resize_handle.drag( //RESIZE
    function(dx, dy, x, y/*, event*/) { /* onmove */
      var backcanvas = document.getElementById('backcanvas');
      var bcbcr = backcanvas.getBoundingClientRect();
      if(y > bcbcr.y &&
        y < bcbcr.y + bcbcr.height &&
        x > bcbcr.x &&
        x < bcbcr.x + bcbcr.width) {
        cols_items.forEach(function(c, i) {
          var pos = {
            'x': (x - bcbcr.x),
            'y': (y - bcbcr.y)
          }
          var b = c.getBBox();
          if(pos.x < (b.x + b.width) && pos.x > b.x) {
            var new_w = (b.x + b.width) - this.parent.getBBox().x;
            this.parent.attr('width', (new_w > b.width ? new_w : b.width))
            this.attr('x', (this.parent.getBBox().x + this.parent.getBBox().width) - 12)
            this.parent.text.attr('x', this.parent.getBBox().x + (this.parent.getBBox().width - this.parent.text.getBBox().width) / 2)
            this.parent.data.width = (i - this.parent.data.col) + 1;
          }
          if((pos.y > this.parent.getBBox().y) && pos.y < bcbcr.height) {
            var new_h = ((Math.floor(pos.y / row_height) + 1) * row_height) - (this.parent.getBBox().y - hgap / 2)
            this.parent.attr('height', (new_h > row_height ? new_h : row_height - hgap / 2))
            this.attr('y', (this.parent.getBBox().y + this.parent.getBBox().height) - 12)
            this.parent.data.height = Math.floor(this.parent.getBBox().height / row_height) + 1;
          }
        }, this)
      }
    },
    function(/*x, y, event*/) { /* onstart */ },
    function() { /* onend */
      m_bUpdated = true;
      checkView();
    }
  )

  item.pict.click(function(event) {
    event.stopPropagation();
  })
}

var resizeTimer=-1;
function ResizeEditor() {
  clearTimeout(resizeTimer);
  raphael.setSize(document.body.clientWidth, document.body.clientHeight - document.getElementById('topbar').getBoundingClientRect().height);
  checkView(true);
}
