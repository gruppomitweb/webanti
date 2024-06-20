import java.sql.Date;
import java.sql.Timestamp;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;
public class ReportLibrary {

//---Start function: REPORTLIBRARY_LIBRARY_CODE
    CPContext m_Ctx;
    Caller m_Caller;
    private Vector<RPParameterSource> parameterSourceVector = new Vector<RPParameterSource>();
    private Vector<String> reportNameVector = new Vector<String>();
    private Vector<Boolean> editFieldsVector = new Vector<Boolean>();
    private Vector<String> modelVector = new Vector<String>();
    private Vector<CPMemoryCursor> memCursVector = new Vector<CPMemoryCursor>();
    private String FileName = "";
    private String ExternalServer = "";
    private String ErrorMsg = "";
    private double ErrorCode = 0;
    private String language = "";
    private boolean mixed_merge = false;
    private double nNumPage = -1;
    private boolean duplexPrint = false;
    private boolean modelPdfA = false;
    private double standardMarginLeft = -1;
    private double standardMarginTop = -1;
    private double standardMarginBottom = -1;
    private String mrpOutName = "";
    private JSONArray fieldsForGrid = new org.json.JSONArray();
    private RPPrinterObj printerObj = new RPPrinterObj();
    private Vector<RPPrinterObj> printersVector = new Vector<RPPrinterObj>();
    protected ReportLibrary(){
    }
    public static ReportLibrary Make(CPContext ctx) {
      ReportLibrary l_ReportLibrary = new ReportLibrary();
      l_ReportLibrary.m_Ctx = ctx;
      l_ReportLibrary.m_Caller = CallerImpl.EMPTY_CALLER;
      return l_ReportLibrary;
    }
    public static ReportLibrary Make(CPContext ctx,Caller c) {
      ReportLibrary l_ReportLibrary = Make(ctx);
      l_ReportLibrary.m_Caller = c;
      return l_ReportLibrary; 
    }
    public void addFieldToReportGrid(String fieldName, String fieldTitle, String fieldPicture, String fieldType) {
      AddFieldToReportGrid(fieldName, fieldTitle, fieldPicture, fieldType);
    }
    public void AddFieldToReportGrid(String fieldName, String fieldTitle, String fieldPicture) {
      AddFieldToReportGrid(fieldName, fieldTitle, fieldPicture, "");
    }
    public void addReport(String ReportName, String Model, boolean editFields) {
      AddReport(ReportName, Model, editFields);
    }
    public void cleanObj() {
      CleanObj();
    }
    public String getMrpOutName() {
      return GetMrpOutName();
    }
    public double getnNumPage() {
      return GetnNumPage();
    }
    public String getPdfKeyWords(String pdfFile) {
      return GetPdfKeyWords(pdfFile);
    }
    public double getPdfNumberOfPages(String pdfFile) {
      return GetPdfNumberOfPages(pdfFile);
    }
    public boolean makeReport(String reportName, String fileName, String pageFormat, String rotation, String outputFormat) {
      return MakeReport(reportName, fileName, pageFormat, rotation, outputFormat);
    }
    public boolean makeReportBinderPdf(String pdfList, String FileName, String pageFormat, String rotation, String outputFormat) {
      return MakeReportBinderPdf(pdfList, FileName, pageFormat, rotation, outputFormat);
    }
    public boolean makeReportBinderPdf(Vector<String> ReportName, String FileName, String pageFormat, String rotation, String outputFormat) {
      return makeReportBinderPdf(ReportName, FileName, pageFormat, rotation, outputFormat, language);
    }
    public boolean makeReportBinderPdf(Vector<String> ReportName, String FileName, String pageFormat, String rotation, String outputFormat, String language) {
      RPUtilError rpuerror = new RPUtilError();
      boolean ret = false;
      if(parameterSourceVector.size() < 0){
        return ret;
      } else {
        if(parameterSourceVector.size() == 0){
          ret = ReportUtilities.MakeReportBinderPdf(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, null, rpuerror, language);
        } else if(parameterSourceVector.size() >= 1){
          ret = ReportUtilities.MakeReportBinderPdf(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, (RPParameterSource)parameterSourceVector.get(0), rpuerror, language);
        }
        ErrorMsg = rpuerror.GetLastErrMsg();
        ErrorCode = rpuerror.GetErrCode();
        return ret;
      }
    }
    public boolean makeReportGrid(String Filename, String VqrName, String outputFormat, String reportTitle, String fieldsOrderBy) {
      return MakeReportGrid(Filename, VqrName, outputFormat, reportTitle, fieldsOrderBy);
    }
    public boolean makeReportMargins(String ReportName, String FileName, String pageFormat, String rotation, String outputFormat, double marginTop, double marginLeft, double marginBottom, double pageWidth, double pageHeight) {
      return MakeReportMargins(ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight);
    }
    public boolean makeReportMarginsVQRH(String ReportName, String FileName, String pageFormat, String rotation, String outputFormat, double marginTop, double marginLeft, double marginBottom, double pageWidth, double pageHeight, VQRHolder VQRH) {
      return MakeReportMarginsVQRH(ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, VQRH);
    }
    public boolean makeReportMergingPdf(Vector<String> ReportName, String FileName, String pageFormat, String rotation, String outputFormat) {
      return makeReportMergingPdf(ReportName, FileName, pageFormat, rotation, outputFormat, "");
    }
    public boolean makeReportMergingPdf(String pdfList, String FileName, String pageFormat, String rotation, String outputFormat) {
      return MakeReportMergingPdf(pdfList, FileName, pageFormat, rotation, outputFormat);
    }
    public boolean makeReportMergingPdf(Vector<String> ReportName, String FileName, String pageFormat, String rotation, String outputFormat, String language) {
      RPUtilError rpuerror = new RPUtilError();
      boolean ret = false; 
      if(parameterSourceVector.size() < 0){
        return ret;
      } else {
        if(parameterSourceVector.size() == 0){
          ret = ReportUtilities.MakeReportMergingPdf(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, null, rpuerror, language);
        } else if(parameterSourceVector.size() >= 1){
          ret = ReportUtilities.MakeReportMergingPdf(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, (RPParameterSource)parameterSourceVector.get(0), rpuerror, language);
        }
        ErrorMsg = rpuerror.GetLastErrMsg();
        ErrorCode = rpuerror.GetErrCode();
        return ret;
      }
    }
    public boolean makeReportVQRH(String reportName, String fileName, String pageFormat, String rotation, String outputFormat, VQRHolder VQRH) {
      return MakeReportVQRH(reportName, fileName, pageFormat, rotation, outputFormat, VQRH);
    }
    public boolean makeXmlStrReport() {
      return MakeXmlStrReport();
    }
    public boolean MergingPdf(Vector<String> pdfList, String outputFile, boolean deleteFiles) {
      return JApplyPdfTemplate.MergingPdf(pdfList, outputFile, null, deleteFiles);
    }
    public boolean MergingPdf(String pdfList, String outputFile, boolean deleteFiles) {
      return MergingPdf(pdfList, outputFile, deleteFiles, false);
    }
    public void setDuplexPrint(boolean duplexPrint) {
      SetDuplexPrint(duplexPrint);
    }
    public void setExternalServer(String ExternalServer) {
      SetExternalServer(ExternalServer);
    }
    public void setFileName(String FileName) {
      SetFileName(FileName);
    }
    public void setLanguage(String language) {
      SetLanguage(language);
    }
    public void setMixedMerge(boolean mixed) {
      SetMixedMerge(mixed);
    }
    private RPParameterSource setIndex(double index) {
      int dd = parameterSourceVector.size();
      for(int i=dd; i<=index; i++){
        RPParameterSource rp = new RPParameterSource();
        parameterSourceVector.add(rp);
      }
      return (RPParameterSource)parameterSourceVector.get((int)index);
    }
    private RPPrinterObj setIndexPrinter(double index) {
      int dd = printersVector.size();
      for(int i=dd; i<=index; i++){
        RPPrinterObj rp = new RPPrinterObj();
        printersVector.add(rp);
      }
      return (RPPrinterObj)printersVector.get((int)index);
    }
    public void setParameter(String arg0, String arg1) {
      RPParameterSource rp = setIndex(0);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(String arg0, double arg1) {
      RPParameterSource rp = setIndex(0);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(String arg0, Date arg1) {
      RPParameterSource rp = setIndex(0);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(String arg0, Timestamp arg1) {
      RPParameterSource rp = setIndex(0);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(String arg0, boolean arg1) {
      RPParameterSource rp = setIndex(0);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(double index, String arg0, String arg1) {
      RPParameterSource rp = setIndex((int)index);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(double index, String arg0, double arg1) {
      RPParameterSource rp = setIndex((int)index);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(double index, String arg0, Date arg1) {
      RPParameterSource rp = setIndex((int)index);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(double index, String arg0, Timestamp arg1) {
      RPParameterSource rp = setIndex((int)index);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameter(double index, String arg0, boolean arg1) {
      RPParameterSource rp = setIndex((int)index);
      rp.SetParameter(arg0, arg1);
    }
    public void setParameterChar(String arg0, String arg1) {
      SetParameterChar(arg0, arg1);
    }
    public void setParameterCharIndex(double index, String arg0, String arg1) {
      SetParameterCharIndex(index, arg0, arg1);
    }
    public void setParameterDate(String arg0, java.sql.Date arg1) {
      SetParameterDate(arg0, arg1);
    }
    public void setParameterDateIndex(double index, String arg0, java.sql.Date arg1) {
      SetParameterDateIndex(index, arg0, arg1);
    }
    public void setParameterDateTime(String arg0, java.sql.Timestamp arg1) {
      SetParameterDateTime(arg0, arg1);
    }
    public void setParameterDateTimeIndex(double index, String arg0, java.sql.Timestamp arg1) {
      SetParameterDateTimeIndex(index, arg0, arg1);
    }
    public void setParameterLogic(String arg0, boolean arg1) {
      SetParameterLogic(arg0, arg1);
    }
    public void setParameterLogicIndex(double index, String arg0, boolean arg1) {
      SetParameterLogicIndex(index, arg0, arg1);
    }
    public void setParameterNumeric(String arg0, double arg1) {
      SetParameterNumeric(arg0, arg1);
    }
    public void setParameterNumericIndex(double index, String arg0, double arg1) {
      SetParameterNumericIndex(index, arg0, arg1);
    }
    public void setPdfAprint(boolean pPdfA) {
      SetPdfAprint(pPdfA);
    }
    public boolean serverPrintPdf(String pdfFile, String ownerPassword, String printerName, double nCopies, String mediaFormatTray, boolean isMediaTray, String orientation, String ranges, String collateMode, String colorMode, String duplexSide, String scalingMode) {
      boolean res = false;
      RPUtilError rpuerror = new RPUtilError();
      res = ReportUtilities.ServerPrintPdf(this.m_Ctx, pdfFile, ownerPassword, printerName, nCopies, mediaFormatTray, isMediaTray, orientation, ranges, collateMode, colorMode, duplexSide, scalingMode ,rpuerror);
      ErrorMsg = rpuerror.GetLastErrMsg();
      ErrorCode = rpuerror.GetErrCode();
      return res;
    }
    private void setPrinterObjToParameters(RPPrinterObj printer, RPParameterSource parametersSource) {
      parametersSource.SetParameter("printingOn", !CPLib.Empty(printer.printerName) ? printer.printerName : "");
      parametersSource.SetParameter("printerCopies", !CPLib.Empty(printer.nCopies) ? printer.nCopies : 0);
      parametersSource.SetParameter("printingMedia", !CPLib.Empty(printer.mediaFormat) ? printer.mediaFormat : "");
      parametersSource.SetParameter("printingMediaTray", !CPLib.Empty(printer.mediaTray) ? printer.mediaTray : "");
      parametersSource.SetParameter("printingOrientation", !CPLib.Empty(printer.orientation) ? printer.orientation : "");
      parametersSource.SetParameter("printingRanges", !CPLib.Empty(printer.ranges) ? printer.ranges : "");
      parametersSource.SetParameter("printingCollateMode", !CPLib.Empty(printer.collateMode) ? printer.collateMode : "");
      parametersSource.SetParameter("printingColorMode", !CPLib.Empty(printer.colorMode) ? printer.colorMode : "");
      parametersSource.SetParameter("printingDuplexMode", !CPLib.Empty(printer.duplexMode) ? printer.duplexMode : "");
      parametersSource.SetParameter("printingScalingMode", !CPLib.Empty(printer.scalingMode) ? printer.scalingMode : "");
    }
    public boolean MergingProtectedPdfA(String pdfList, String passwordList, String outputFile, boolean deleteFiles) {
      CPWarningError log = new CPWarningError("Not possible merging protected PDFA1B");
      CPStdCounter.Error(log);
      return false;
    }
//---End function

//---Start function: AddFieldToReportGrid
public void AddFieldToReportGrid(String fieldName, String fieldTitle, String fieldPicture, String fieldType) {
  JSONObject objJson = new org.json.JSONObject();
  objJson.put("field_name", fieldName);
  objJson.put("field_title", fieldTitle);
  objJson.put("field_picture", fieldPicture);
  objJson.put("field_type", fieldType);
  objJson.put("field_image", false);
  fieldsForGrid.put(objJson);
}
//---End function

//---Start function: AddImageFieldToReportGrid
public void AddImageFieldToReportGrid(String fieldName, String fieldTitle, boolean imgTypeExpr, double imgHeight, double imgWidth) {
  String res = "";
  if (imgTypeExpr) {
    res = "expression";
  } else {
    res = "constant";
  }
  JSONObject objJson = new org.json.JSONObject();
  objJson.put("field_name", fieldName);
  objJson.put("field_title", fieldTitle);
  objJson.put("field_image", true);
  objJson.put("field_type", res);
  objJson.put("field_image_height", Double.toString(imgHeight));
  objJson.put("field_image_width", Double.toString(imgWidth));
  fieldsForGrid.put(objJson);
}
//---End function

//---Start function: AddReport
public void AddReport(String ReportName, String Model, boolean editFields) {
    AddReportMemCurs(ReportName, Model, editFields, null);
}
//---End function

//---Start function: AddReportMemCurs
public void AddReportMemCurs(String ReportName, String Model, boolean editFields, CPMemoryCursor cpMem) {
    reportNameVector.add(ReportName);
    modelVector.add(Model); 
    editFieldsVector.add(Boolean.valueOf(editFields));
    memCursVector.add(cpMem);
}
//---End function

//---Start function: AddReportServerPrinting
public void AddReportServerPrinting(String ReportName, String Model, boolean editFields, String printerName, double nCopies) {
    AddReport(ReportName, Model, editFields);
    RPPrinterObj printer = setIndexPrinter(reportNameVector.size()-1);
    printer.printerName = printerName;
    printer.nCopies = nCopies;
    printersVector.add(printer);
}
//---End function

//---Start function: AddReportServerPrintingMedia
public void AddReportServerPrintingMedia(String ReportName, String Model, boolean editFields, String printerName, double nCopies, String mediaFormat, String orientation) {
    AddReport(ReportName, Model, editFields);
    RPPrinterObj printer = setIndexPrinter(reportNameVector.size()-1);
    printer.printerName = printerName;
    printer.nCopies = nCopies;
    printer.mediaFormat = mediaFormat;
    printer.orientation = orientation;
    printersVector.add(printer);
}
//---End function

//---Start function: AddReportServerPrintingMediaTray
public void AddReportServerPrintingMediaTray(String ReportName, String Model, boolean editFields, String printerName, double nCopies, String mediaTray, String orientation) {
    AddReport(ReportName, Model, editFields);
    RPPrinterObj printer = new RPPrinterObj();
    printer.printerName = printerName;
    printer.nCopies = nCopies;
    printer.mediaTray = mediaTray;
    printer.orientation = orientation;
    printersVector.add(printer);
}
//---End function

//---Start function: AddReportServerQueue
public void AddReportServerQueue(String ReportName, String Model, boolean editFields, String queueName) {
    AddReportServerPrinting(ReportName, Model, editFields, RPPrintingService.CODEQUEUE+queueName, 0);
}
//---End function

//---Start function: CleanObj
public void CleanObj() {
    parameterSourceVector.clear();
    reportNameVector.clear();
    editFieldsVector.clear();
    modelVector.clear();
    memCursVector.clear();
    printersVector.clear();
    for (int i = fieldsForGrid.length() - 1; i >= 0; i--) {
      fieldsForGrid.remove(i);
    }
}
//---End function

//---Start function: GetLastErrorCode
public double GetLastErrorCode() {
    return ErrorCode;
}
//---End function

//---Start function: GetLastErrorMessage
public String GetLastErrorMessage() {
    return ErrorMsg;
}
//---End function

//---Start function: GetMrpOutName
public String GetMrpOutName() {
    return mrpOutName;
}
//---End function

//---Start function: GetPdfKeyWords
public String GetPdfKeyWords(String pdfFile) {
    String res = ReportUtilities.GetPdfKeyWords(pdfFile);
    return res;
}
//---End function

//---Start function: GetPdfNumberOfPages
public double GetPdfNumberOfPages(String pdfFile) {
    return ReportUtilities.GetPdfNumberOfPages(pdfFile);
}
//---End function

//---Start function: GetProtectedPdfKeyWords
public String GetProtectedPdfKeyWords(String pdfFile, String ownerPassword) {
    String res = ReportUtilities.GetPdfKeyWords(pdfFile, ownerPassword);
    return res;
}
//---End function

//---Start function: GetProtectedPdfNumberOfPages
public double GetProtectedPdfNumberOfPages(String pdfFile, String ownerPassword) {
    return ReportUtilities.GetPdfNumberOfPages(pdfFile, ownerPassword);
}
//---End function

//---Start function: GetReportLibrary
public ReportLibrary GetReportLibrary() {
    return this;
}
//---End function

//---Start function: GetnNumPage
public double GetnNumPage() {
    return nNumPage;
}
//---End function

//---Start function: MakeReport
public boolean MakeReport(String reportName, String fileName, String pageFormat, String rotation, String outputFormat) {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
    }
    if(parameterSourceVector.size() == 1){
      ret = ReportUtilities.MakeReport(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, (RPParameterSource)parameterSourceVector.get(0), rpuerror, language);
    } else if(parameterSourceVector.size() > 1){
      ret = ReportUtilities.MakeReportPdfParamVect(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, parameterSourceVector, rpuerror, language);
    }
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MakeReportBinderPdf
public boolean MakeReportBinderPdf(String pdfList, String FileName, String pageFormat, String rotation, String outputFormat) {
    Vector<String> pList = new Vector<String>();
    String pdfL[] = pdfList.split(";");
    for(int j=0; j<pdfL.length; j++) {
      pList.add(pdfL[j]);
    }
    return makeReportBinderPdf(pList, FileName, pageFormat, rotation, outputFormat, language);
}
//---End function

//---Start function: MakeReportGrid
public boolean MakeReportGrid(String Filename, String VqrName, String outputFormat, String reportTitle, String fieldsOrderBy) {
    boolean ret = false;
    ret = MakeReportGrid(Filename, VqrName, outputFormat, reportTitle, fieldsForGrid.toString(), fieldsOrderBy);
    return ret;
}
public boolean MakeReportGrid(String Filename, String VqrName, String outputFormat, String reportTitle, String fields, String fieldsTitle, String fieldsPicture, String fieldsOrderBy) {
    String fieldsGrid = ReportUtilities.AnalyzeGridFields(fields, fieldsTitle, fieldsPicture);
    boolean ret = false;
    ret = MakeReportGrid(Filename, VqrName, outputFormat, reportTitle, fieldsGrid, fieldsOrderBy);
    return ret;
}
public boolean MakeReportGrid(String Filename, String VqrName, String outputFormat, String reportTitle, String fieldsGrid, String fieldsOrderBy) {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
    }
    ret = ReportUtilities.MakeReportGrid(this.m_Caller, this.m_Ctx, outputFormat, Filename, VqrName, reportTitle, fieldsGrid, fieldsOrderBy, (RPParameterSource)parameterSourceVector.get(0), rpuerror);
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MakeReportMargins
public boolean MakeReportMargins(String ReportName, String FileName, String pageFormat, String rotation, String outputFormat, double marginTop, double marginLeft, double marginBottom, double pageWidth, double pageHeight) {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
    }
    if(parameterSourceVector.size() == 1){
      ret = ReportUtilities.MakeReport(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, (RPParameterSource)parameterSourceVector.get(0), rpuerror, language);
    } else if(parameterSourceVector.size() > 1) {
      ret = ReportUtilities.MakeReportPdfParamVect(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, parameterSourceVector, rpuerror, language);
    }
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MakeReportMarginsMemCurs
public boolean MakeReportMarginsMemCurs(String ReportName, String FileName, String pageFormat, String rotation, String outputFormat, double marginTop, double marginLeft, double marginBottom, double pageWidth, double pageHeight, CPMemoryCursor cpMem) {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
    }
    if(parameterSourceVector.size() == 0){
      ret = ReportUtilities.MakeReportMemCurs(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, null, rpuerror, cpMem, language);
    } else if(parameterSourceVector.size() == 1){
      ret = ReportUtilities.MakeReportMemCurs(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, (RPParameterSource)parameterSourceVector.get(0), rpuerror, cpMem, language);
    } else if(parameterSourceVector.size() > 1) {
      ret = ReportUtilities.MakeReportPdfParamVectMemCurs(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, parameterSourceVector, rpuerror, cpMem, language);
    }
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MakeReportMarginsVQRH
public boolean MakeReportMarginsVQRH(String ReportName, String FileName, String pageFormat, String rotation, String outputFormat, double marginTop, double marginLeft, double marginBottom, double pageWidth, double pageHeight, VQRHolder VQRH) {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
    }
    if(parameterSourceVector.size() == 0){
      ret = ReportUtilities.MakeReport(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, null, rpuerror, VQRH, language);
    } else if(parameterSourceVector.size() == 1){
      ret = ReportUtilities.MakeReport(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, (RPParameterSource)parameterSourceVector.get(0), rpuerror, VQRH, language);
    } else if(parameterSourceVector.size() > 1) {
      ret = ReportUtilities.MakeReportPdfParamVect(this.m_Caller, this.m_Ctx, ReportName, FileName, pageFormat, rotation, outputFormat, marginTop, marginLeft, marginBottom, pageWidth, pageHeight, parameterSourceVector, rpuerror,VQRH, language);
    }
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MakeReportMemCurs
public boolean MakeReportMemCurs(String reportName, String fileName, String pageFormat, String rotation, String outputFormat, CPMemoryCursor cpMem) {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
    }
    if(parameterSourceVector.size() == 0){
      ret = ReportUtilities.MakeReportMemCurs(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, null, rpuerror, cpMem, language);
    } else if(parameterSourceVector.size() == 1){
      ret = ReportUtilities.MakeReportMemCurs(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, (RPParameterSource)parameterSourceVector.get(0), rpuerror, cpMem, language);
    } else if(parameterSourceVector.size() > 1){
      ret = ReportUtilities.MakeReportPdfParamVectMemCurs(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, parameterSourceVector, rpuerror, cpMem, language);
    }
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MakeReportMergingPdf
public boolean MakeReportMergingPdf(String pdfList, String FileName, String pageFormat, String rotation, String outputFormat) {
    Vector<String> pList = new Vector<String>();
    String pdfL[] = pdfList.split(";");
    for(int j=0; j<pdfL.length; j++){
      pList.add(pdfL[j]);
    }
    return makeReportMergingPdf(pList, FileName, pageFormat, rotation, outputFormat, language);
}
//---End function

//---Start function: MakeReportVQRH
public boolean MakeReportVQRH(String reportName, String fileName, String pageFormat, String rotation, String outputFormat, VQRHolder VQRH) {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
    }
    if(parameterSourceVector.size() == 0){
      ret = ReportUtilities.MakeReport(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, null, rpuerror, VQRH, language);
    } else if(parameterSourceVector.size() == 1){
      ret = ReportUtilities.MakeReport(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, (RPParameterSource)parameterSourceVector.get(0), rpuerror, VQRH, language);
    } else if(parameterSourceVector.size() > 1){
      ret = ReportUtilities.MakeReportPdfParamVect(this.m_Caller, this.m_Ctx, reportName, fileName, pageFormat, rotation, outputFormat, standardMarginTop, standardMarginLeft, standardMarginBottom, 0, 0, parameterSourceVector, rpuerror, VQRH, language);
    }
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MakeXmlStrReport
public boolean MakeXmlStrReport() {
    RPUtilError rpuerror = new RPUtilError();
    boolean ret = false;
    if(FileName.trim().length() == 0){
      return ret;
    }
    if(reportNameVector.size() == 0){
      return ret;
    }
    if(parameterSourceVector.size() <= 0){
      setIndex(0);
    }
    for(int i=0; i<parameterSourceVector.size(); i++) {
      if(printersVector.size()>i){
        setPrinterObjToParameters(printersVector.get(i), parameterSourceVector.get(i));
      }
      else{
        setPrinterObjToParameters(printerObj, parameterSourceVector.get(i));
      }
    }
    if(reportNameVector.size() == 1){
      if(parameterSourceVector.size() == 0){
        ret = ReportUtilities.MakeReportXmlStrPdf(this.m_Caller, this.m_Ctx, (String)reportNameVector.get(0), FileName, ExternalServer, (String)modelVector.get(0), ((Boolean)editFieldsVector.get(0)).booleanValue(), (CPMemoryCursor)memCursVector.get(0), this.mixed_merge, null, rpuerror, this.duplexPrint, this.modelPdfA);
      } else if(parameterSourceVector.size() >= 1){
        ret = ReportUtilities.MakeReportXmlStrPdf(this.m_Caller, this.m_Ctx, (String)reportNameVector.get(0), FileName, ExternalServer, (String)modelVector.get(0), ((Boolean)editFieldsVector.get(0)).booleanValue(), (CPMemoryCursor)memCursVector.get(0), this.mixed_merge, (RPParameterSource)parameterSourceVector.get(0), rpuerror, this.duplexPrint, this.modelPdfA);
        mrpOutName = ((RPParameterSource)parameterSourceVector.get(0)).GetParameter("mrpOutName","");
      }
    } else {
      if(parameterSourceVector.size() == 0){
        ret = ReportUtilities.MakeReportXmlStrPdf(this.m_Caller, this.m_Ctx, reportNameVector, FileName, ExternalServer, modelVector, editFieldsVector, memCursVector, this.mixed_merge, null, rpuerror, this.duplexPrint, this.modelPdfA);
      } else if(parameterSourceVector.size() == 1){
        ret = ReportUtilities.MakeReportXmlStrPdf(this.m_Caller, this.m_Ctx, reportNameVector, FileName, ExternalServer, modelVector, editFieldsVector, memCursVector, this.mixed_merge, (RPParameterSource)parameterSourceVector.get(0), rpuerror, this.duplexPrint, this.modelPdfA);
        mrpOutName = ((RPParameterSource)parameterSourceVector.get(0)).GetParameter("mrpOutName","");
      }
      else if(parameterSourceVector.size() > 1){
        ret = ReportUtilities.MakeReportXmlStrPdfParamVect(this.m_Caller, this.m_Ctx, reportNameVector, FileName, ExternalServer, modelVector, editFieldsVector, memCursVector, this.mixed_merge, parameterSourceVector, rpuerror, this.duplexPrint, this.modelPdfA);
        mrpOutName = ((RPParameterSource)parameterSourceVector.get(0)).GetParameter("mrpOutName","");
      }
    }
    ErrorMsg = rpuerror.GetLastErrMsg();
    ErrorCode = rpuerror.GetErrCode();
    nNumPage = rpuerror.getNumPage();
    return ret;
}
//---End function

//---Start function: MergingDocx
public boolean MergingDocx(String docxList, String outputFile, boolean deleteFiles, boolean keepHeadersFooters) {
  Vector<String> pList = new Vector<String>();
  String pdfL[] = docxList.split(";");
  for(int j=0; j<pdfL.length; j++){
    pList.add(pdfL[j]);
  }
  return JApplyPdfTemplate.MergingDocx(pList,outputFile,deleteFiles,keepHeadersFooters);
}
public boolean MergingDocx(String docxList, String outputFile, boolean deleteFiles) {
  Vector<String> pList = new Vector<String>();
  String pdfL[] = docxList.split(";");
  for(int j=0; j<pdfL.length; j++){
    pList.add(pdfL[j]);
  }
  return JApplyPdfTemplate.MergingDocx(pList,outputFile,deleteFiles,false);
}
//---End function

//---Start function: MergingOdt
public boolean MergingOdt(String odtList, String outputFile, boolean deleteFiles) {
    Vector<String> pList = new Vector<String>();
    String pdfL[] =odtList.split(";");
    for(int j=0; j<pdfL.length; j++){
      pList.add(pdfL[j]);
    }
    return JApplyPdfTemplate.MergingOdt(pList,outputFile,deleteFiles);
}
//---End function

//---Start function: MergingPdf
public boolean MergingPdf(String pdfList, String outputFile, boolean deleteFiles, boolean withAcroFields) {
    Vector<String> pList = new Vector<String>();
    String pdfL[] = pdfList.split(";");
    for(int j=0; j<pdfL.length; j++){
      pList.add(pdfL[j]);
    }
    RPParameterSource rp = null;
    if (parameterSourceVector.size() > 0){
      rp = parameterSourceVector.get(0);
    }
    if (withAcroFields) {
      return JApplyPdfTemplate.MergingPdfStreams(pList ,outputFile, rp, deleteFiles);
    }
    else {
      return JApplyPdfTemplate.MergingPdf(pList, outputFile, rp, deleteFiles);
    }
}
//---End function

//---Start function: MergingPdfA
public boolean MergingPdfA(String pdfList, String outputFile, boolean deleteFiles) {
    Vector<String> pList = new Vector<String>();
    String pdfL[] = pdfList.split(";");
    RPParameterSource rp = null;
    if (parameterSourceVector.size() > 0) {
      rp = parameterSourceVector.get(0);
    }
    for(int j=0; j<pdfL.length; j++){
      pList.add(pdfL[j]);
    }
    return JApplyPdfTemplate.MergingPdfA(pList,outputFile, rp, deleteFiles);
}
//---End function

//---Start function: MergingProtectedPdf
public boolean MergingProtectedPdf(String pdfList, String passwordList, String outputFile, boolean deleteFiles, boolean withAcroFields) {
    Vector<String> pList = new Vector<String>();
    Vector<String> paList = new Vector<String>();
    String pdfL[] = pdfList.split(";");
    String passL[] = passwordList.split(";",-1); // -1 for empty string.
    RPParameterSource rp = null;
    if (parameterSourceVector.size() > 0) {
      rp = parameterSourceVector.get(0);
    }
    for(int j=0; j<pdfL.length; j++){
      pList.add(pdfL[j]);
    }
    for(int j=0; j<passL.length; j++){
      paList.add(passL[j]);
    }
    if (withAcroFields) {
      return JApplyPdfTemplate.MergingPdfStreamsProtected(pList, paList, outputFile, rp, deleteFiles);
    }
    else {
      return JApplyPdfTemplate.MergingPdfProtected(pList, paList, outputFile, rp, deleteFiles);
    }
}
//---End function

//---Start function: RemovePagesPdf
public boolean RemovePagesPdf(String oripdf, String resultpdf, String pageslist) {
    RPParameterSource rp = null;
    if (parameterSourceVector.size() > 0){
      rp = parameterSourceVector.get(0);
    }
    return ReportUtilities.RemovePagesPdf(oripdf, null, resultpdf, rp, pageslist);
}
//---End function

//---Start function: RemovePagesProtectedPdf
public boolean RemovePagesProtectedPdf(String oripdf, String ownerPassword, String resultpdf, String pageslist) {
    RPParameterSource rp = null;
    if (parameterSourceVector.size() > 0) {
      rp = parameterSourceVector.get(0);
    }
    return ReportUtilities.RemovePagesPdf(oripdf, ownerPassword, resultpdf, rp, pageslist);
}
//---End function

//---Start function: ServerPrintPdf
public boolean ServerPrintPdf(String pdfFile, String printerName, double nCopies) {
    boolean res = serverPrintPdf(pdfFile, null, printerName, nCopies, null, false, null, null, null, null, null, null);
    return res;
}
//---End function

//---Start function: ServerPrintPdfMedia
public boolean ServerPrintPdfMedia(String pdfFile, String printerName, double nCopies, String mediaFormat, String orientation) {
    boolean res = serverPrintPdf(pdfFile, null, printerName, nCopies, mediaFormat, false, orientation, null, null, null, null, null);
    return res;
}
//---End function

//---Start function: ServerPrintPdfMediaTray
public boolean ServerPrintPdfMediaTray(String pdfFile, String printerName, double nCopies, String mediaTray, String orientation) {
    boolean res = serverPrintPdf(pdfFile, null, printerName, nCopies, mediaTray, true, orientation, null, null, null, null, null);
    return res;
}
//---End function

//---Start function: ServerPrintProtectedPdf
public boolean ServerPrintProtectedPdf(String pdfFile, String ownerPassword, String printerName, double nCopies) {
    boolean res = serverPrintPdf(pdfFile, ownerPassword, printerName, nCopies, null, false, null, null, null, null, null, null);
    return res;
}
//---End function

//---Start function: ServerPrintProtectedPdfMedia
public boolean ServerPrintProtectedPdfMedia(String pdfFile, String ownerPassword, String printerName, double nCopies, String mediaFormat, String orientation) {
    boolean res = serverPrintPdf(pdfFile, ownerPassword, printerName, nCopies, mediaFormat, false, orientation, null, null, null, null, null);
    return res;
}
//---End function

//---Start function: ServerPrintProtectedPdfMediaTray
public boolean ServerPrintProtectedPdfMediaTray(String pdfFile, String ownerPassword, String printerName, double nCopies, String mediaTray, String orientation) {
    boolean res = serverPrintPdf(pdfFile, ownerPassword, printerName, nCopies, mediaTray, true, orientation, null, null, null, null, null);
    return res;
}
//---End function

//---Start function: SetDuplexPrint
public void SetDuplexPrint(boolean duplexPrint) {
    this.duplexPrint = duplexPrint;
}
//---End function

//---Start function: SetExternalServer
public void SetExternalServer(String ExternalServer) {
    this.ExternalServer = ExternalServer;
}
//---End function

//---Start function: SetFileName
public void SetFileName(String FileName) {
    this.FileName = FileName;
}
//---End function

//---Start function: SetLanguage
public void SetLanguage(String language) {
    this.language = language;
}
//---End function

//---Start function: SetMixedMerge
public void SetMixedMerge(boolean mixed) {
    this.mixed_merge = mixed;
}
//---End function

//---Start function: SetParameterChar
public void SetParameterChar(String arg0, String arg1) {
    RPParameterSource rp = setIndex(0);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterCharIndex
public void SetParameterCharIndex(double index, String arg0, String arg1) {
    RPParameterSource rp = setIndex((int)index);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterDate
public void SetParameterDate(String arg0, java.sql.Date arg1) {
    RPParameterSource rp = setIndex(0);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterDateIndex
public void SetParameterDateIndex(double index, String arg0, java.sql.Date arg1) {
    RPParameterSource rp = setIndex((int)index);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterDateTime
public void SetParameterDateTime(String arg0, java.sql.Timestamp arg1) {
    RPParameterSource rp = setIndex(0);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterDateTimeIndex
public void SetParameterDateTimeIndex(double index, String arg0, java.sql.Timestamp arg1) {
    RPParameterSource rp = setIndex((int)index);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterLogic
public void SetParameterLogic(String arg0, boolean arg1) {
    RPParameterSource rp = setIndex(0);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterLogicIndex
public void SetParameterLogicIndex(double index, String arg0, boolean arg1) {
    RPParameterSource rp = setIndex((int)index);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterNumeric
public void SetParameterNumeric(String arg0, double arg1) {
    RPParameterSource rp = setIndex(0);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetParameterNumericIndex
public void SetParameterNumericIndex(double index, String arg0, double arg1) {
    RPParameterSource rp = setIndex((int)index);
    rp.SetParameter(arg0, arg1);
}
//---End function

//---Start function: SetPdfAprint
public void SetPdfAprint(boolean pPdfA) {
    this.modelPdfA = pPdfA;
}
//---End function

//---Start function: SetServerPrinting
public void SetServerPrinting(String printerName, double nCopies) {
    printerObj.printerName = printerName;
    printerObj.nCopies = nCopies;
}
//---End function

//---Start function: SetServerPrintingMedia
public void SetServerPrintingMedia(String printerName, double nCopies, String mediaFormat, String orientation) {
    SetServerPrinting(printerName, nCopies);
    printerObj.mediaFormat = mediaFormat;
    printerObj.orientation = orientation;
}
//---End function

//---Start function: SetServerPrintingMediaTray
public void SetServerPrintingMediaTray(String printerName, double nCopies, String mediaTray, String orientation) {
    SetServerPrinting(printerName, nCopies);
    printerObj.mediaTray = mediaTray;
    printerObj.orientation = orientation;
}
//---End function

//---Start attributes
//---End attributes
}
