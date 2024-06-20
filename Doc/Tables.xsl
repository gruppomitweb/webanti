<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">

<xsl:template match="text()">
  <xsl:value-of/>
</xsl:template>

<xsl:template match="*">
  <xsl:copy>
    <xsl:apply-templates select="@* | node()"/>
  </xsl:copy>
</xsl:template>

<xsl:template match="@*">
  <xsl:attribute><xsl:value-of/></xsl:attribute>
</xsl:template>

<xsl:template match="/">
  <HTML>
  <HEAD>
    <STYLE>
      BODY { font-family:Times New Roman; font-size:10pt; color:black; background:white; margin:20px;}
      TABLE {font-family:Times New Roman; font-size:10pt; color:black; background:white}
      A:hover {color:red}
    </STYLE>
  </HEAD>
  <BODY>
    <P ALIGN="CENTER"><FONT COLOR="#000080" SIZE="6"><B>Tables</B></FONT></P>
    <xsl:apply-templates select="//ItemTable" order-by="TableName" />
    <DIV ALIGN="CENTER">
      <A><xsl:attribute name="HREF"><xsl:value-of select="//PlanMain" />_Main.xml</xsl:attribute>
        <FONT SIZE="2">BACK TO MAIN</FONT>
      </A>
    </DIV>
  </BODY>
  </HTML>
</xsl:template>

<!--*********************   Template per i dati di tabella   *********************-->

<xsl:template match="ItemTable" >
  <A><xsl:attribute name="NAME">Table_<xsl:value-of select="TableName"/></xsl:attribute>
    <FONT SIZE="5"><U><xsl:value-of select="TableName"/></U></FONT>
  </A>

  <BLOCKQUOTE>
  <TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080">
    <TR BGCOLOR="#6495ED">
      <TD>&#160;<FONT COLOR="WHITE"><B>Description</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Phname</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Company</B></FONT>&#160;</TD>
      <xsl:if match=".[TableYear]"><TD>&#160;<FONT COLOR="WHITE"><B>Year</B></FONT>&#160;</TD></xsl:if>
      <xsl:if match=".[TableUser]"><TD>&#160;<FONT COLOR="WHITE"><B>User</B></FONT>&#160;</TD></xsl:if>
      <xsl:if match=".[TableCheck]"><TD>&#160;<FONT COLOR="WHITE"><B>Check</B></FONT>&#160;</TD></xsl:if>
    </TR>
    <TR BGCOLOR="#F5F5F5">
      <TD>&#160;<xsl:value-of select="TableComment"/>&#160;</TD>
      <TD STYLE="BORDER-LEFT: 1 SOLID #000000;">&#160;<xsl:value-of select="TablePhname"/>&#160;</TD>
      <TD STYLE="BORDER-LEFT: 1 SOLID #000000;" ALIGN="CENTER"><xsl:apply-templates select="TableCompany"/></TD>
      <xsl:if match=".[TableYear]"><TD STYLE="BORDER-LEFT: 1 SOLID #000000;" ALIGN="CENTER"><xsl:apply-templates select="TableYear"/></TD></xsl:if>
      <xsl:if match=".[TableUser]"><TD STYLE="BORDER-LEFT: 1 SOLID #000000;" ALIGN="CENTER"><xsl:apply-templates select="TableUser"/></TD></xsl:if>
      <xsl:if match=".[TableCheck]"><TD STYLE="BORDER-LEFT: 1 SOLID #000000;">&#160;<xsl:value-of select="TableCheck"/>&#160;</TD></xsl:if>
    </TR>
  </TABLE>
  </BLOCKQUOTE>

  <!-- ************************* Autonum ************************* -->

  <xsl:if match="ItemTable[TableAutonum]">      <!-- Visualizza solo se ci sono elementi -->
    <BLOCKQUOTE>
      <FONT SIZE="4" COLOR="#FFFFFF"><SPAN STYLE="background-color: #000080"><B>AUTONUMBER(S):</B></SPAN></FONT>
      <BLOCKQUOTE>
        <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
          <TR BGCOLOR="#B0C4DE">
            <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Field</B>&#160;</TD>
            <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Tbl</B>&#160;</TD>
            <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000;">&#160;<B>Cnd</B>&#160;</TD>
          </TR>
          <xsl:for-each select="TableAutonum">
            <TR BGCOLOR="#ADD8E6">
              <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">&#160;<xsl:value-of />&#160;</TD>
              <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">&#160;<xsl:value-of select="@Tbl"/>&#160;</TD>
              <TD>&#160;<xsl:value-of select="@Cnd"/>&#160;</TD>
            </TR>
          </xsl:for-each>
        </TABLE>
      </BLOCKQUOTE>
    </BLOCKQUOTE>
  </xsl:if>

<!-- ************************* Indici ************************* -->

  <xsl:if match="ItemTable[TableIndex]">      <!-- Visualizza solo se ci sono elementi -->
    <BLOCKQUOTE>
      <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080">
        <TR BGCOLOR="#6495ED">
          <TD COLSPAN="2" ALIGN="CENTER"><FONT COLOR="YELLOW"><B>Index(es)</B></FONT></TD>
        </TR>
        <xsl:for-each select="TableIndex">
          <TR BGCOLOR="#B0C4DE">
            <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">
              <FONT COLOR="#800000">&#160;<B><xsl:eval>unique()</xsl:eval></B>&#160;</FONT>
            </TD>
            <TD>
              <FONT COLOR="BLACK">&#160;<xsl:value-of />&#160;</FONT>
            </TD>
          </TR>
        </xsl:for-each>
        <xsl:eval>unique(true)</xsl:eval>
      </TABLE>
    </BLOCKQUOTE>
 </xsl:if>

  <!-- ************************* Links ************************* -->
  <BLOCKQUOTE>
    <xsl:apply-templates select="TableLink" order-by="@Type"/>
    <xsl:eval>SetFlag(false)</xsl:eval>
  </BLOCKQUOTE>

<!-- ************************* FKeys ************************* -->
  <xsl:if match=".[TableForeignkeys!='']">
  <BLOCKQUOTE>
    <FONT SIZE="4" COLOR="#FFFFFF"><SPAN STYLE="background-color: #000080"><B>FOREIGN KEY(S):</B></SPAN></FONT>
    <BLOCKQUOTE>
      <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
      <xsl:for-each select=".//TableForeignkey">
        <xsl:if expr="childNumber(this)==1">
        <TR BGCOLOR="#B0C4DE">
            <TD STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Table</B>&#160;</TD>
            <TD STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Weak entity</B>&#160;</TD>
            <TD STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Key</B>&#160;</TD>
            <TD STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000;">&#160;<B>Ref</B>&#160;</TD>
          </TR>
        </xsl:if>
        <TR BGCOLOR="#ADD8E6">
            <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;" VALIGN="CENTER">&#160;<xsl:value-of select="ForeignkeyTable"/>&#160;</TD>
            <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;" ALIGN="CENTER" VALIGN="CENTER"><xsl:apply-templates select="ForeignkeyWeakentity"/></TD>
            <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">
              <xsl:for-each select="ForeignkeyKey">
              &#160;<xsl:value-of />&#160;<BR/>
            </xsl:for-each>
            </TD>
            <TD>
              <xsl:for-each select="ForeignkeyRef">
                &#160;<xsl:value-of />&#160;<BR/>
              </xsl:for-each>
            </TD>
          </TR>
      </xsl:for-each>
      </TABLE>
    </BLOCKQUOTE>
  </BLOCKQUOTE>
  </xsl:if>

<!-- ************************* Fields ************************* -->
  <BLOCKQUOTE>
    <xsl:apply-templates select="TableFields/*" />
  </BLOCKQUOTE>

  <HR/>
</xsl:template>

<!--*********************   Template per i dati sui link   *********************-->

<xsl:template match="TableLink">

  <xsl:if expr="TableFlag==false">      <!-- identifica il I&#248 elemento -->
    <FONT SIZE="4" COLOR="#FFFFFF"><SPAN STYLE="background-color: #000080"><B>LINK(S):</B></SPAN></FONT>
    <xsl:eval>SetFlag(true)</xsl:eval>
  </xsl:if>

  <BLOCKQUOTE>
  <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0" ><TR>
  <TD VALIGN="BOTTOM" >
    <B><xsl:value-of select="@Type"/></B>: <xsl:value-of select="//PlanItem[ItemUID=context()/LinkUID]//TableName"/>
    <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
      <TR BGCOLOR="#B0C4DE">
        <TD WIDTH="50%" ALIGN="CENTER" STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Fk KEY</B>&#160;</TD>
        <TD WIDTH="50%" ALIGN="CENTER" STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000;">&#160;<B>Fk REF</B>&#160;</TD>
      </TR>
      <TR BGCOLOR="#ADD8E6">
        <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">&#160;<xsl:value-of select="LinkFk/@Key"/>&#160;</TD>
        <TD>&#160;<xsl:value-of select="LinkFk/@Ref"/>&#160;</TD>
      </TR>
    </TABLE>
  </TD>

  <TD VALIGN="BOTTOM" >
    <xsl:if match="TableLink[@Type='Relationship'][LinkWrite]">
      <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
        <TR BGCOLOR="#B0C4DE">
          <TD STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Write from</B>&#160;</TD>
          <TD STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000;">&#160;<B>To field</B>&#160;</TD>
          <TD>&#160;<B>Oper.</B>&#160;</TD>
        </TR>
        <xsl:for-each select="context()/LinkWrite" >
          <TR BGCOLOR="#ADD8E6">
            <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">&#160;<xsl:value-of select="@From"/>&#160;</TD>
            <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">&#160;<xsl:value-of select="@To"/>&#160;</TD>
            <TD ALIGN="CENTER">&#160;<xsl:value-of select="@Operation"/>&#160;</TD>
          </TR>
        </xsl:for-each >
      </TABLE>
    </xsl:if>
  </TD>

  <xsl:if match=".[LinkCreate='TRUE']">
  <TD ROWSPAN="2" VALIGN="MIDDLE" >
    <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="1"><TR>
      <TD VALIGN="MIDDLE">&#160;&#160;&#160;<xsl:apply-templates select="LinkCreate" /></TD>
      <TD VALIGN="MIDDLE">Create record if it does not exist</TD>
    </TR></TABLE>
  </TD>
  </xsl:if>

   <xsl:if match="TableLink[@Type='Relationship'][LinkRead]">
    <TR>
    <TD VALIGN="TOP" COLSPAN="2">
      <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" >
        <TR BGCOLOR="#B0C4DE">
          <TD WIDTH="50%" STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">&#160;<B>Read from</B>&#160;</TD>
          <TD WIDTH="50%" STYLE="BORDER-TOP: 2 SOLID #000000; BORDER-BOTTOM: 1 SOLID #000000;">&#160;<B>To field</B>&#160;</TD>
        </TR>
        <xsl:for-each select="context()/LinkRead" >
          <TR BGCOLOR="#ADD8E6">
            <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;">&#160;<xsl:value-of select="@From"/>&#160;</TD>
            <TD>&#160;<xsl:value-of select="@To"/>&#160;</TD>
          </TR>
        </xsl:for-each >
      </TABLE>
    </TD>
    </TR>
  </xsl:if>

   </TR>
  </TABLE>

  <xsl:if match=".[LinkNote!='']">
    <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" >
      <TR><TD COLSPAN="2">&#160;</TD></TR>
      <TR>
        <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000;">&#160;&#160;<I>Notes:</I></TD>
        <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000;">&#160;</TD>
      </TR><TR>
        <TD>&#160;</TD>
        <TD>&#160;<xsl:apply-templates select="LinkNote"/></TD>
      </TR>
    </TABLE>
  </xsl:if>

  </BLOCKQUOTE>

</xsl:template>


<!--*********************   Template per i dati sui campi   *********************-->

<xsl:template match="TableFields/*" >

  <xsl:if expr="childNumber(this)==1">      <!-- identifica il I&#248 elemento -->
    <FONT SIZE="4" COLOR="#FFFFFF"><SPAN STYLE="background-color: #000080"><B>FIELD(S):</B></SPAN></FONT>
  </xsl:if>

  <BLOCKQUOTE>
  <TABLE BORDER="0" WIDTH="80%">
  <TR><TD>
  <TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080">
  <CAPTION ALIGN="LEFT" >
  <A><xsl:attribute name="NAME">
     <!-- La riga che segue non deve essere spezzata altrimenti il link non funziona in quanto viene riempito di spazi. -->
     <xsl:eval>this.parentNode.parentNode.selectSingleNode("TableName").text</xsl:eval>_<xsl:eval>Trim(this.firstChild.text)</xsl:eval></xsl:attribute>
     <B>&#183;&#160;<xsl:eval>Trim(this.firstChild.text)</xsl:eval></B>
  </A>
  </CAPTION>

  <TR BGCOLOR="#6495ED">
    <TD>&#160;<FONT COLOR="WHITE"><B>Description</B></FONT>&#160;</TD>
    <TD>&#160;<FONT COLOR="WHITE"><B>Type</B>&#160;</FONT></TD>
    <TD>&#160;<FONT COLOR="WHITE"><B>Len</B>&#160;</FONT></TD>
    <TD>&#160;<FONT COLOR="WHITE"><B>Dec</B>&#160;</FONT></TD>
    <TD>&#160;<FONT COLOR="WHITE"><B>Key</B>&#160;</FONT></TD>
    <xsl:if match=".[FieldNotnull]"><TD>&#160;<FONT COLOR="WHITE"><B>Not null</B>&#160;</FONT></TD></xsl:if>
    <xsl:if match=".[FieldRepeated]"><TD>&#160;<FONT COLOR="WHITE"><B>Rep.</B>&#160;</FONT></TD></xsl:if>
    <xsl:if match=".[FieldDefaultval]"><TD>&#160;<FONT COLOR="WHITE"><B>Default</B>&#160;</FONT></TD></xsl:if>
    <xsl:if match=".[FieldCheck]"><TD>&#160;<FONT COLOR="WHITE"><B>Check</B>&#160;</FONT></TD></xsl:if>
  </TR>
  <TR BGCOLOR="#F5F5F5">
   <TD>&#160;<xsl:value-of select="FieldComment" />&#160;</TD>
   <TD>&#160;<xsl:value-of select="FieldType" />&#160;</TD>
   <TD>&#160;<xsl:value-of select="FieldLen" />&#160;</TD>
   <TD>&#160;<xsl:value-of select="FieldDec" />&#160;</TD>
   <TD>&#160;<xsl:value-of select="FieldKey" />&#160;</TD>
   <xsl:if match=".[FieldNotnull]"><TD ALIGN="CENTER"><xsl:apply-templates select="FieldNotnull" /></TD></xsl:if>
   <xsl:if match=".[FieldRepeated]"><TD ALIGN="CENTER"><xsl:apply-templates select="FieldRepeated" /></TD></xsl:if>
   <xsl:if match=".[FieldDefaultval]"><TD>&#160;<xsl:value-of select="FieldDefaultval" />&#160;</TD></xsl:if>
   <xsl:if match=".[FieldCheck]"><TD>&#160;<xsl:value-of select="FieldCheck" />&#160;</TD></xsl:if>
  </TR>
  </TABLE>
  </TD>
  <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE" >
   <A><xsl:attribute name="HREF">
     <!-- La riga che segue non deve essere spezzata altrimenti il link non funziona in quanto viene riempito di spazi. -->
     #Table_<xsl:eval>this.parentNode.parentNode.selectSingleNode("TableName").text</xsl:eval></xsl:attribute>
     <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.parentNode.selectSingleNode("TableName").text</xsl:eval></B></FONT>
  </A>
  </TD></TR>
  </TABLE>

  <xsl:if match=".[FieldNote!='']">
    <P>
    <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" >
      <TR>
        <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000;">&#160;&#160;<I>Notes:</I></TD>
        <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000;">&#160;</TD>
      </TR><TR>
        <TD>&#160;</TD>
        <TD>&#160;<xsl:apply-templates select="FieldNote"/></TD>
      </TR>
    </TABLE>
    </P>
  </xsl:if>

  </BLOCKQUOTE>

</xsl:template>

<!--************** Template per visualizzazione campi TRUE/FALSE tramite immagine check box **************-->

<xsl:template match="FieldNotnull|FieldRepeated|TableUser|TableYear|TableCompany|ForeignkeyWeakentity|LinkBlinkedismaster|LinkBismaster|LinkCreate">
  <xsl:choose>
    <xsl:when match="*[. = 'FALSE']"><IMG SRC="No.gif" /></xsl:when>
    <xsl:when match="*[. = 'TRUE']"><IMG SRC="Yes.gif" /></xsl:when>
    <xsl:otherwise>?</xsl:otherwise>
  </xsl:choose>
</xsl:template>

<!--************** Script JScript **************-->
<xsl:script>
  <![CDATA[
    var TableFlag=false
    var idNum = 1;
    var str= "\u00B0";  // codice unicode per il simbolo di grado

    function unique(reset) {
      if (reset==true) {
        idNum=1;
        return;
      }
      else
      return idNum++ + str;
    }

    function Trim(strToTrim) {
      re = / /g;
      return(strToTrim.replace(re, ""));
    }

    function SetFlag(FlagValue) {
      TableFlag=FlagValue;
    }
  ]]>
</xsl:script>

</xsl:stylesheet>
