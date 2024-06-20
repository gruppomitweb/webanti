public class GlobalVars_PortalStudio_plan {
  public GlobalVars_PortalStudio_plan() {
    CPGlobalDefaults d = CPGlobalDefaults.GetGlobalDefaults();
    d.AddString("IsPortalStudioInstalled",new GlobalDefaultPortalStudio_planVar_IsPortalStudioInstalled());
  }
}
class GlobalDefaultPortalStudio_planVar_IsPortalStudioInstalled extends CPGlobalDefaultValue {
 GlobalDefaultPortalStudio_planVar_IsPortalStudioInstalled() {
   super();
   readonly=true;
   frequency="oneTimePerApplication";
 }
 Object compute(CPContext p_Ctx) {
   CPContext m_Ctx=p_Ctx;
   return "yes";
 }
}
