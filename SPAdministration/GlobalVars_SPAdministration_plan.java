public class GlobalVars_SPAdministration_plan {
  public GlobalVars_SPAdministration_plan() {
    CPGlobalDefaults d = CPGlobalDefaults.GetGlobalDefaults();
    d.AddString("IsSPAdministrationInstalled",new GlobalDefaultSPAdministration_planVar_IsSPAdministrationInstalled());
    d.AddNumber("MinimumPasswordComplexity",new GlobalDefaultSPAdministration_planVar_MinimumPasswordComplexity());
    d.AddNumber("PasswordDaysDuration",new GlobalDefaultSPAdministration_planVar_PasswordDaysDuration());
  }
}
class GlobalDefaultSPAdministration_planVar_IsSPAdministrationInstalled extends CPGlobalDefaultValue {
 GlobalDefaultSPAdministration_planVar_IsSPAdministrationInstalled() {
   super();
   readonly=true;
   frequency="oneTimePerApplication";
 }
 Object compute(CPContext p_Ctx) {
   CPContext m_Ctx=p_Ctx;
   return "yes";
 }
}
class GlobalDefaultSPAdministration_planVar_MinimumPasswordComplexity extends CPGlobalDefaultValue {
 GlobalDefaultSPAdministration_planVar_MinimumPasswordComplexity() {
   super();
   readonly=true;
   frequency="oneTimePerApplication";
 }
 Object compute(CPContext p_Ctx) {
   CPContext m_Ctx=p_Ctx;
   return Double.valueOf(8);
 }
}
class GlobalDefaultSPAdministration_planVar_PasswordDaysDuration extends CPGlobalDefaultValue {
 GlobalDefaultSPAdministration_planVar_PasswordDaysDuration() {
   super();
   readonly=true;
   frequency="oneTimePerApplication";
 }
 Object compute(CPContext p_Ctx) {
   CPContext m_Ctx=p_Ctx;
   return Double.valueOf(0);
 }
}
