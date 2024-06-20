import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.io.InputStream;
import java.sql.Timestamp;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
public class ExcelMit {

//---Start function: closeWb
public boolean closeWb() {
  boolean res = true;
  try{
    wb.close();
  }
  catch(Exception e) {
    CPStdCounter.Error(e);
    res = false;
  }
  return res;
}
public boolean closeWb(String path) {
  boolean res = true;
  try{
    //write file
    FileOutputStream fileOut = new FileOutputStream(path);
    wb.write(fileOut);
    fileOut.close();
    // Closing the workbook
    wb.close();
  }
  catch(Exception e) {
    CPStdCounter.Error(e);
    res = false;
  }
  return res;
}
//---End function

//---Start function: getCells
public void getCells() {
  cells = row.cellIterator();
}
//---End function

//---Start function: getMcCelle
public MemoryCursor_mccellaexcel_mcrdef getMcCelle() {
  return mcCelle;
}
//---End function

//---Start function: getRow
public void getRow() {
  row = rows.next();
}
//---End function

//---Start function: getRows
public void getRows() {
  rows = sheet.rowIterator();
}
//---End function

//---Start function: hasNextRows
public boolean hasNextRows() {
  boolean res = rows.hasNext();
  return res;
}
//---End function

//---Start function: newCell
public void newCell(int cellNum) {
  cell = row.createCell(cellNum);
}
//---End function

//---Start function: newRow
public void newRow(int rowNum) {
  row = sheet.createRow(rowNum);
}
//---End function

//---Start function: newSheet
public void newSheet(String namesheet) {
  sheet = wb.createSheet(namesheet);
}
//---End function

//---Start function: newWb
public void newWb(boolean xlsx) {
  wb = xlsx? new XSSFWorkbook():new HSSFWorkbook();
}
//---End function

//---Start function: openWb
public boolean openWb(String path) {
  boolean res = true;
  try{
    pathFile=path;
    wb = WorkbookFactory.create(new File(pathFile));
    nSheets = wb.getNumberOfSheets();
    setSheet(0);
  }
  catch(Exception e) {
    res = false;
    CPStdCounter.Error(e);
  }
  return res;
}
//---End function

//---Start function: readall
public void readall() {
  DataFormatter dataFormatter = new DataFormatter();
  mcCelle = new MemoryCursor_mccellaexcel_mcrdef();
  riga_letta=0;
  sheet.forEach(row -> {
    riga_letta++;
    colonna_letta=0;
    row.forEach(cell -> {
      colonna_letta++;
      mcCelle.AppendBlank();
      mcCelle.row.cellType=cell.getCellType().toString();
      switch (cell.getCellType()) {
        case BOOLEAN:
          mcCelle.row.logic = cell.getBooleanCellValue();
          break;
        case STRING:
          mcCelle.row.stringa = cell.getRichStringCellValue().getString();
          break;
        case NUMERIC:
          if (DateUtil.isCellDateFormatted(cell)) {
          mcCelle.row.datetime = new Timestamp(cell.getDateCellValue().getTime());
          mcCelle.row.stringa=dataFormatter.formatCellValue(cell);
          } else {
              mcCelle.row.numeric = cell.getNumericCellValue();
          }
          break;
        case FORMULA:
          mcCelle.row.stringa = cell.getCellFormula();
          break;
        case BLANK:
          mcCelle.row.stringa = "";
          break;
        default:
          mcCelle.row.stringa = "non definita";
      }
      mcCelle.row.riga=cell.getRowIndex();
      mcCelle.row.colonna=cell.getColumnIndex();
      mcCelle.SaveRow();
    });
  });
}
//---End function

//---Start function: setCellValue
public void setCellValue() {
//cell.setCellValue();
  switch (mcCelle.row.cellType) {
    case "BOOLEAN":
      cell.setCellValue(mcCelle.row.logic);
      break;
    case "STRING":
      cell.setCellValue(mcCelle.row.stringa);
      break;
    case "NUMERIC":
    if (!(CPLib.Empty(mcCelle.row.datetime))) {
      cell.setCellValue(mcCelle.row.datetime);
      cell.setCellStyle(dateCellStyle);
      //mcCelle.row.stringa=dataFormatter.formatCellValue(cell);
      } else {
        cell.setCellValue(mcCelle.row.numeric);
      }
      break;
    case "FORMULA":
      cell.setCellValue(mcCelle.row.stringa);
      break;
    case "BLANK":
      cell.setCellValue(mcCelle.row.stringa);
      break;
    default:
      cell.setCellValue(mcCelle.row.stringa);
  }
}
public void setCellValue(CellStyle pCellStyle) {
  setCellValue();
  cell.setCellStyle(pCellStyle);
}
//---End function

//---Start function: setMcCelle
public void setMcCelle(MemoryCursor_mccellaexcel_mcrdef pmcCelle) {
  mcCelle = new MemoryCursor_mccellaexcel_mcrdef();
  mcCelle=pmcCelle;
}
//---End function

//---Start function: setSheet
public void setSheet(int numeric_sheet) {
  sheet = wb.getSheetAt(numeric_sheet);
}
//---End function

//---Start function: writeall
public void writeall(boolean autoSizeHeader) {
  if(!(mcCelle.IsEmpty())){
    CellStyle headerCellStyle = wb.createCellStyle();
    Font ft=wb.createFont();
    ft.setBold(true);
    headerCellStyle.setFont(ft);
    headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    dateCellStyle = wb.createCellStyle();
    dateCellStyle.setDataFormat(wb.getCreationHelper().createDataFormat().getFormat("dd-MM-yyyy"));
    int riga, colonna;
    riga = -1;
    colonna = -1;
    mcCelle.GoTop();
    while (!(mcCelle.Eof())) {
      if(riga==-1){
        newSheet("Foglio_1");
      }
      if(riga!=mcCelle.row.riga){
        riga = (int) mcCelle.row.riga;
        newRow((int)riga);
      }
      if(colonna!=mcCelle.row.colonna){
        colonna = (int) mcCelle.row.colonna;
        newCell((int)colonna);
        if(riga==0){
          setCellValue(headerCellStyle);
          if(autoSizeHeader){
            sheet.autoSizeColumn(colonna);
          }
        }else{
          setCellValue();
        }
      }
      mcCelle.Next();
    }
  }
}
//---End function

//---Start attributes
public String pathFile;
public Workbook wb;
public double nSheets;
public Row row;
public Cell cell;
public Sheet sheet;
public Iterator<Row> rows;
public Iterator<Cell> cells;
public MemoryCursor_mccellaexcel_mcrdef mcCelle;
public double riga_letta;
public double colonna_letta;
public CellStyle dateCellStyle;
//---End attributes
}
