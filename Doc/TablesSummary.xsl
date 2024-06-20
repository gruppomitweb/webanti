<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">

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
    <P ALIGN="CENTER"><FONT COLOR="#000080" SIZE="6"><B>Tables summary</B></FONT></P>
    <xsl:apply-templates select="//ItemTable" order-by="TableName"/>
    <DIV ALIGN="CENTER">
      <A><xsl:attribute name="HREF"><xsl:value-of select="//PlanMain" />_Main.xml</xsl:attribute>
        <FONT SIZE="2">BACK TO MAIN</FONT>
      </A>
    </DIV>
  </BODY>
  </HTML>
</xsl:template>

<!-- ****************** Elenco caratteristiche di tabella ************************ -->

<xsl:template match="ItemTable" >
  <A><xsl:attribute name="NAME">Table_<xsl:value-of select="TableName" /></xsl:attribute>
    <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Tables.xml#Table_<xsl:value-of select="TableName"/></xsl:attribute>
    <FONT SIZE="5"><U><xsl:value-of select="TableName" /></U></FONT>
  </A>
  <P>
  <BLOCKQUOTE>
  <TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080">
    <TR BGCOLOR="#6495ED">
      <TD>&#160;<FONT COLOR="WHITE"><B>Description</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Phname</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Company</B></FONT>&#160;</TD>
      <xsl:if match=".[TableYear]"><TD>&#160;<FONT COLOR="WHITE"><B>Year</B>&#160;</FONT></TD></xsl:if>
      <xsl:if match=".[TableUser]"><TD>&#160;<FONT COLOR="WHITE"><B>User</B>&#160;</FONT></TD></xsl:if>
      <xsl:if match=".[TableCheck]"><TD>&#160;<FONT COLOR="WHITE"><B>Check</B>&#160;</FONT></TD></xsl:if>
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

  <!-- ****************** Elenco numerato degli indici ************************ -->

  <xsl:if match="ItemTable[TableIndex]">
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

  <!-- ******************      Elenco delle FKeys       ************************ -->

  <xsl:if match="ItemTable[TableForeignkeys]">
    <BLOCKQUOTE>
    <TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0">
      <xsl:for-each select=".//TableForeignkey">
        <xsl:if expr="childNumber(this)==1">
          Foreign Key:<BR/>
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
  </xsl:if>

  <!-- ****************** Elenco dei campi di tabella ************************ -->

  <BLOCKQUOTE>
    <TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080">
      <CAPTION ALIGN="LEFT">Table attributes:</CAPTION>
      <xsl:apply-templates select="TableFields/*" />
    </TABLE>
  </BLOCKQUOTE>
  </P>
  <HR/>

</xsl:template>

<!-- *********** Template per la visualizzazione dei campi delle tabelle ***********  -->

<xsl:template match="TableFields/*" >
  <xsl:if expr="childNumber(this)==1">      <!-- identifica il I&#248 elemento -->
    <TR BGCOLOR="#6495ED">
      <TD>&#160;<FONT COLOR="WHITE"><B>Field</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Description</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Type</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Len</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Dec</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Key</B></FONT>&#160;</TD>
      <xsl:if match="./TableField[FieldNotnull]"><TD>&#160;<FONT COLOR="WHITE"><B>Not null</B></FONT>&#160;</TD></xsl:if>
      <xsl:if match="./TableField[FieldRepeated]"><TD>&#160;<FONT COLOR="WHITE"><B>Rep.</B></FONT>&#160;</TD></xsl:if>
      <xsl:if match="./TableField[FieldDefaultval]"><TD>&#160;<FONT COLOR="WHITE"><B>Default</B></FONT>&#160;</TD></xsl:if>
      <xsl:if match="./TableField[FieldCheck]"><TD>&#160;<FONT COLOR="WHITE"><B>Check</B></FONT>&#160;</TD></xsl:if>
    </TR>
  </xsl:if>
  <TR BGCOLOR="#F5F5F5">
    <TD>&#160;<xsl:value-of select="text()" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldComment" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldType" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldLen" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldDec" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldKey" />&#160;</TD>
    <xsl:if match="./TableField[FieldNotnull]"><TD ALIGN="CENTER"><xsl:apply-templates select="FieldNotnull"/></TD></xsl:if>
    <xsl:if match="./TableField[FieldRepeated]"><TD ALIGN="CENTER"><xsl:apply-templates select="FieldRepeated" /></TD></xsl:if>
    <xsl:if match="./TableField[FieldDefaultval]"><TD>&#160;<xsl:value-of select="FieldDefaultval"/>&#160;</TD></xsl:if>
    <xsl:if match="./TableField[FieldCheck]"><TD>&#160;<xsl:value-of select="FieldCheck" />&#160;</TD></xsl:if>
  </TR>
</xsl:template>

<!-- *********** Template per la visualizzazione dei checkbox ***********  -->

<xsl:template match="FieldNotnull|FieldRepeated|TableUser|TableYear|TableCompany|ForeignkeyWeakentity">
  <xsl:choose>
    <xsl:when match="*[. = 'FALSE']"><IMG SRC="No.gif" /></xsl:when>
    <xsl:when match="*[. = 'TRUE']"><IMG SRC="Yes.gif" /></xsl:when>
    <xsl:otherwise>?</xsl:otherwise>
  </xsl:choose>
</xsl:template>

<!-- *********** Script JScript per la numerazione progressiva indici ***********  -->

<xsl:script>
  <![CDATA[
    var idNum = 1;
    var str= "\u00B0";  // codice unicode per il simbolo di grado
    function unique(reset) {
      if (reset==true) {
        idNum=1;
        return;
      }
      else
      return idNum++ + str ;
    }
  ]]>
</xsl:script>

</xsl:stylesheet>
