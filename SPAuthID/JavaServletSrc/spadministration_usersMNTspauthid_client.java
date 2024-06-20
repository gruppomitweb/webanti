public class spadministration_usersMNTspauthid_client {
  public static String[][] m_Fkd={
    {"code","usercode"}
  };
  public static int order = 0;
  public static void CopyKeys(spadministration_usersBO parent,spauthid_clientBO child) {
    child.w_usercode = parent.w_code;
  }
  public static String PageTitle() {
    return "SPAuthID";
  }
  public static String IncludeParentFunctions() {
    return "";
  }
  public static String CopyWorkVar() {
    return " if (!(ChildToLoad(FrameRef('spauthid_client'))) && typeof(FrameRef('spauthid_client').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('spauthid_client').m_oTrs)!='undefined'){\n   FrameRef('spauthid_client').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('spauthid_client'),['name','fullname'],['name','fullname'],true);\n }\n";
  }
  public static String CopyWorkVarInit() {
    return "function SetChildVariables_spauthid_client(){\n if (!(ChildToLoad(FrameRef('spauthid_client'))) && typeof(FrameRef('spauthid_client').DoUpdate)!='undefined'){\n  if (typeof(FrameRef('spauthid_client').m_oTrs)!='undefined'){\n   FrameRef('spauthid_client').EnableEntity(false)\n  }\n  CopyWorkVar(FrameRef('spauthid_client'),['name','fullname'],['name','fullname'],false);\n }\n}\n";
  }
  public static String DoQueryFromChild() {
    return "function DoQueryFrom_spauthid_client(firstAlias){\n return m_cVirtName+'.code = '+firstAlias+'.usercode '\n}\n";
  }
  public static String MountingMode() {
    return "cbox";
  }
  public static String MountingModeBoxState() {
    return "collapsed";
  }
  public static String MountingBoxOnPage() {
    return "1";
  }
  public static String MountingBoxOnTabbedGroup() {
    return "configurazioni";
  }
  public static boolean RepeatedChild() {
    return false;
  }
  public static boolean CreateOnDemand() {
    return true;
  }
}
