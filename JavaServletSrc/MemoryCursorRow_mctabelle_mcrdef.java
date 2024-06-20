public class MemoryCursorRow_mctabelle_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mctabelle_mcrdef() {
  }
  public MemoryCursorRow_mctabelle_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mctabelle_mcrdef toBuild = new MemoryCursor_mctabelle_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mctabelle_mcrdef toBuild = new MemoryCursor_mctabelle_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  boolean _clientiope = false;
  boolean _sogopebo = false;
  boolean _beneficope = false;
  boolean _terzistiope = false;
  boolean _clientifrz = false;
  boolean _sogopefbo = false;
  boolean _terzistifrz = false;
  boolean _beneficfrz = false;
  boolean _xperazbo = false;
  boolean _xlientiope = false;
  boolean _xogopebo = false;
  boolean _xeneficope = false;
  boolean _xerzistiope = false;
  boolean _xraziobo = false;
  boolean _xlientifrz = false;
  boolean _xogopefbo = false;
  boolean _xerzistifrz = false;
  boolean _xeneficfrz = false;
  boolean _rapopebo = false;
  boolean _soginfo = false;
  boolean _intestbo = false;
  boolean _delegabo = false;
  boolean _fiduciabo = false;
  boolean _garantbo = false;
  boolean _xapopebo = false;
  boolean _xoginfo = false;
  boolean _xntestbo = false;
  boolean _xelegabo = false;
  boolean _xiduciabo = false;
  boolean _xarantbo = false;
  boolean _rapotit = false;
  boolean _intestit = false;
  boolean _xapotit = false;
  boolean _xntestit = false;
  boolean _japopebo = false;
  boolean _jntestbo = false;
  boolean _jelegabo = false;
  boolean _jarantbo = false;
  boolean _japotit = false;
  boolean _jntestit = false;
  boolean _jperazbo = false;
  boolean _kperazbo = false;
  boolean _opextrbo = false;
  boolean _wperazbo = false;
  boolean _wlientiope = false;
  boolean _wogopebo = false;
  boolean _weneficope = false;
  boolean _werzistiope = false;
  boolean _wraziobo = false;
  boolean _wlientifrz = false;
  boolean _wogopefbo = false;
  boolean _weneficfrz = false;
  boolean _werzistifrz = false;
  boolean _wapopebo = false;
  boolean _woginfo = false;
  boolean _wntestbo = false;
  boolean _welegabo = false;
  boolean _widuciabo = false;
  boolean _warantbo = false;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(_clientiope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_sogopebo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_beneficope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_terzistiope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_clientifrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_sogopefbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_terzistifrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_beneficfrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xperazbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xlientiope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xogopebo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xeneficope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xerzistiope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xraziobo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xlientifrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xogopefbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xerzistifrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xeneficfrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_rapopebo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_soginfo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_intestbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_delegabo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_fiduciabo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_garantbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xapopebo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xoginfo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xntestbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xelegabo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xiduciabo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xarantbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_rapotit))) {
      return false;
    }
    if ( ! (CPLib.Empty(_intestit))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xapotit))) {
      return false;
    }
    if ( ! (CPLib.Empty(_xntestit))) {
      return false;
    }
    if ( ! (CPLib.Empty(_japopebo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_jntestbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_jelegabo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_jarantbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_japotit))) {
      return false;
    }
    if ( ! (CPLib.Empty(_jntestit))) {
      return false;
    }
    if ( ! (CPLib.Empty(_jperazbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_kperazbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_opextrbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wperazbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wlientiope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wogopebo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_weneficope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_werzistiope))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wraziobo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wlientifrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wogopefbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_weneficfrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_werzistifrz))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wapopebo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_woginfo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_wntestbo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_welegabo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_widuciabo))) {
      return false;
    }
    if ( ! (CPLib.Empty(_warantbo))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mctabelle_mcrdef p_row) {
    MemoryCursorRow_mctabelle_mcrdef l_row = new MemoryCursorRow_mctabelle_mcrdef();
    CopyOperation<MemoryCursorRow_mctabelle_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mctabelle_mcrdef.this._clientiope = l_row._clientiope;
      MemoryCursorRow_mctabelle_mcrdef.this._sogopebo = l_row._sogopebo;
      MemoryCursorRow_mctabelle_mcrdef.this._beneficope = l_row._beneficope;
      MemoryCursorRow_mctabelle_mcrdef.this._terzistiope = l_row._terzistiope;
      MemoryCursorRow_mctabelle_mcrdef.this._clientifrz = l_row._clientifrz;
      MemoryCursorRow_mctabelle_mcrdef.this._sogopefbo = l_row._sogopefbo;
      MemoryCursorRow_mctabelle_mcrdef.this._terzistifrz = l_row._terzistifrz;
      MemoryCursorRow_mctabelle_mcrdef.this._beneficfrz = l_row._beneficfrz;
      MemoryCursorRow_mctabelle_mcrdef.this._xperazbo = l_row._xperazbo;
      MemoryCursorRow_mctabelle_mcrdef.this._xlientiope = l_row._xlientiope;
      MemoryCursorRow_mctabelle_mcrdef.this._xogopebo = l_row._xogopebo;
      MemoryCursorRow_mctabelle_mcrdef.this._xeneficope = l_row._xeneficope;
      MemoryCursorRow_mctabelle_mcrdef.this._xerzistiope = l_row._xerzistiope;
      MemoryCursorRow_mctabelle_mcrdef.this._xraziobo = l_row._xraziobo;
      MemoryCursorRow_mctabelle_mcrdef.this._xlientifrz = l_row._xlientifrz;
      MemoryCursorRow_mctabelle_mcrdef.this._xogopefbo = l_row._xogopefbo;
      MemoryCursorRow_mctabelle_mcrdef.this._xerzistifrz = l_row._xerzistifrz;
      MemoryCursorRow_mctabelle_mcrdef.this._xeneficfrz = l_row._xeneficfrz;
      MemoryCursorRow_mctabelle_mcrdef.this._rapopebo = l_row._rapopebo;
      MemoryCursorRow_mctabelle_mcrdef.this._soginfo = l_row._soginfo;
      MemoryCursorRow_mctabelle_mcrdef.this._intestbo = l_row._intestbo;
      MemoryCursorRow_mctabelle_mcrdef.this._delegabo = l_row._delegabo;
      MemoryCursorRow_mctabelle_mcrdef.this._fiduciabo = l_row._fiduciabo;
      MemoryCursorRow_mctabelle_mcrdef.this._garantbo = l_row._garantbo;
      MemoryCursorRow_mctabelle_mcrdef.this._xapopebo = l_row._xapopebo;
      MemoryCursorRow_mctabelle_mcrdef.this._xoginfo = l_row._xoginfo;
      MemoryCursorRow_mctabelle_mcrdef.this._xntestbo = l_row._xntestbo;
      MemoryCursorRow_mctabelle_mcrdef.this._xelegabo = l_row._xelegabo;
      MemoryCursorRow_mctabelle_mcrdef.this._xiduciabo = l_row._xiduciabo;
      MemoryCursorRow_mctabelle_mcrdef.this._xarantbo = l_row._xarantbo;
      MemoryCursorRow_mctabelle_mcrdef.this._rapotit = l_row._rapotit;
      MemoryCursorRow_mctabelle_mcrdef.this._intestit = l_row._intestit;
      MemoryCursorRow_mctabelle_mcrdef.this._xapotit = l_row._xapotit;
      MemoryCursorRow_mctabelle_mcrdef.this._xntestit = l_row._xntestit;
      MemoryCursorRow_mctabelle_mcrdef.this._japopebo = l_row._japopebo;
      MemoryCursorRow_mctabelle_mcrdef.this._jntestbo = l_row._jntestbo;
      MemoryCursorRow_mctabelle_mcrdef.this._jelegabo = l_row._jelegabo;
      MemoryCursorRow_mctabelle_mcrdef.this._jarantbo = l_row._jarantbo;
      MemoryCursorRow_mctabelle_mcrdef.this._japotit = l_row._japotit;
      MemoryCursorRow_mctabelle_mcrdef.this._jntestit = l_row._jntestit;
      MemoryCursorRow_mctabelle_mcrdef.this._jperazbo = l_row._jperazbo;
      MemoryCursorRow_mctabelle_mcrdef.this._kperazbo = l_row._kperazbo;
      MemoryCursorRow_mctabelle_mcrdef.this._opextrbo = l_row._opextrbo;
      MemoryCursorRow_mctabelle_mcrdef.this._wperazbo = l_row._wperazbo;
      MemoryCursorRow_mctabelle_mcrdef.this._wlientiope = l_row._wlientiope;
      MemoryCursorRow_mctabelle_mcrdef.this._wogopebo = l_row._wogopebo;
      MemoryCursorRow_mctabelle_mcrdef.this._weneficope = l_row._weneficope;
      MemoryCursorRow_mctabelle_mcrdef.this._werzistiope = l_row._werzistiope;
      MemoryCursorRow_mctabelle_mcrdef.this._wraziobo = l_row._wraziobo;
      MemoryCursorRow_mctabelle_mcrdef.this._wlientifrz = l_row._wlientifrz;
      MemoryCursorRow_mctabelle_mcrdef.this._wogopefbo = l_row._wogopefbo;
      MemoryCursorRow_mctabelle_mcrdef.this._weneficfrz = l_row._weneficfrz;
      MemoryCursorRow_mctabelle_mcrdef.this._werzistifrz = l_row._werzistifrz;
      MemoryCursorRow_mctabelle_mcrdef.this._wapopebo = l_row._wapopebo;
      MemoryCursorRow_mctabelle_mcrdef.this._woginfo = l_row._woginfo;
      MemoryCursorRow_mctabelle_mcrdef.this._wntestbo = l_row._wntestbo;
      MemoryCursorRow_mctabelle_mcrdef.this._welegabo = l_row._welegabo;
      MemoryCursorRow_mctabelle_mcrdef.this._widuciabo = l_row._widuciabo;
      MemoryCursorRow_mctabelle_mcrdef.this._warantbo = l_row._warantbo;
    }
  }
  protected CopyOperation<MemoryCursorRow_mctabelle_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mctabelle_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mctabelle_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mctabelle_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mctabelle_mcrdef p_From,MemoryCursorRow_mctabelle_mcrdef p_To) {
        p_To._clientiope = copyAndCast(p_From._clientiope);
        p_To._sogopebo = copyAndCast(p_From._sogopebo);
        p_To._beneficope = copyAndCast(p_From._beneficope);
        p_To._terzistiope = copyAndCast(p_From._terzistiope);
        p_To._clientifrz = copyAndCast(p_From._clientifrz);
        p_To._sogopefbo = copyAndCast(p_From._sogopefbo);
        p_To._terzistifrz = copyAndCast(p_From._terzistifrz);
        p_To._beneficfrz = copyAndCast(p_From._beneficfrz);
        p_To._xperazbo = copyAndCast(p_From._xperazbo);
        p_To._xlientiope = copyAndCast(p_From._xlientiope);
        p_To._xogopebo = copyAndCast(p_From._xogopebo);
        p_To._xeneficope = copyAndCast(p_From._xeneficope);
        p_To._xerzistiope = copyAndCast(p_From._xerzistiope);
        p_To._xraziobo = copyAndCast(p_From._xraziobo);
        p_To._xlientifrz = copyAndCast(p_From._xlientifrz);
        p_To._xogopefbo = copyAndCast(p_From._xogopefbo);
        p_To._xerzistifrz = copyAndCast(p_From._xerzistifrz);
        p_To._xeneficfrz = copyAndCast(p_From._xeneficfrz);
        p_To._rapopebo = copyAndCast(p_From._rapopebo);
        p_To._soginfo = copyAndCast(p_From._soginfo);
        p_To._intestbo = copyAndCast(p_From._intestbo);
        p_To._delegabo = copyAndCast(p_From._delegabo);
        p_To._fiduciabo = copyAndCast(p_From._fiduciabo);
        p_To._garantbo = copyAndCast(p_From._garantbo);
        p_To._xapopebo = copyAndCast(p_From._xapopebo);
        p_To._xoginfo = copyAndCast(p_From._xoginfo);
        p_To._xntestbo = copyAndCast(p_From._xntestbo);
        p_To._xelegabo = copyAndCast(p_From._xelegabo);
        p_To._xiduciabo = copyAndCast(p_From._xiduciabo);
        p_To._xarantbo = copyAndCast(p_From._xarantbo);
        p_To._rapotit = copyAndCast(p_From._rapotit);
        p_To._intestit = copyAndCast(p_From._intestit);
        p_To._xapotit = copyAndCast(p_From._xapotit);
        p_To._xntestit = copyAndCast(p_From._xntestit);
        p_To._japopebo = copyAndCast(p_From._japopebo);
        p_To._jntestbo = copyAndCast(p_From._jntestbo);
        p_To._jelegabo = copyAndCast(p_From._jelegabo);
        p_To._jarantbo = copyAndCast(p_From._jarantbo);
        p_To._japotit = copyAndCast(p_From._japotit);
        p_To._jntestit = copyAndCast(p_From._jntestit);
        p_To._jperazbo = copyAndCast(p_From._jperazbo);
        p_To._kperazbo = copyAndCast(p_From._kperazbo);
        p_To._opextrbo = copyAndCast(p_From._opextrbo);
        p_To._wperazbo = copyAndCast(p_From._wperazbo);
        p_To._wlientiope = copyAndCast(p_From._wlientiope);
        p_To._wogopebo = copyAndCast(p_From._wogopebo);
        p_To._weneficope = copyAndCast(p_From._weneficope);
        p_To._werzistiope = copyAndCast(p_From._werzistiope);
        p_To._wraziobo = copyAndCast(p_From._wraziobo);
        p_To._wlientifrz = copyAndCast(p_From._wlientifrz);
        p_To._wogopefbo = copyAndCast(p_From._wogopefbo);
        p_To._weneficfrz = copyAndCast(p_From._weneficfrz);
        p_To._werzistifrz = copyAndCast(p_From._werzistifrz);
        p_To._wapopebo = copyAndCast(p_From._wapopebo);
        p_To._woginfo = copyAndCast(p_From._woginfo);
        p_To._wntestbo = copyAndCast(p_From._wntestbo);
        p_To._welegabo = copyAndCast(p_From._welegabo);
        p_To._widuciabo = copyAndCast(p_From._widuciabo);
        p_To._warantbo = copyAndCast(p_From._warantbo);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"_clientiope","_sogopebo","_beneficope","_terzistiope","_clientifrz","_sogopefbo","_terzistifrz","_beneficfrz","_xperazbo","_xlientiope","_xogopebo","_xeneficope","_xerzistiope","_xraziobo","_xlientifrz","_xogopefbo","_xerzistifrz","_xeneficfrz","_rapopebo","_soginfo","_intestbo","_delegabo","_fiduciabo","_garantbo","_xapopebo","_xoginfo","_xntestbo","_xelegabo","_xiduciabo","_xarantbo","_rapotit","_intestit","_xapotit","_xntestit","_japopebo","_jntestbo","_jelegabo","_jarantbo","_japotit","_jntestit","_jperazbo","_kperazbo","_opextrbo","_wperazbo","_wlientiope","_wogopebo","_weneficope","_werzistiope","_wraziobo","_wlientifrz","_wogopefbo","_weneficfrz","_werzistifrz","_wapopebo","_woginfo","_wntestbo","_welegabo","_widuciabo","_warantbo"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L","L"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    return l_names;
  }
}
