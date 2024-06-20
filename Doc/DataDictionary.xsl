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
  <STYLE>
    BODY { font-family:Times New Roman; font-size:10pt; color:black; background:white; margin:20px;}
    TABLE {font-family:Times New Roman; font-size:10pt; color:black; background:white}
    A:hover {color:red}
  </STYLE>
  <BODY>
    <P ALIGN="CENTER"><FONT COLOR="#000080" SIZE="6"><B>Data dictionary</B></FONT></P>
    <P ALIGN="CENTER">
      <TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080">
        <xsl:apply-templates select="//PlanItem/ItemField" order-by="FieldName;@TablePhName"/>
      </TABLE>
    </P>
    <DIV ALIGN="CENTER">
      <A><xsl:attribute name="HREF"><xsl:value-of select="//PlanMain" />_Main.xml</xsl:attribute>
        <FONT SIZE="2">BACK TO MAIN</FONT>
      </A>
    </DIV>
  </BODY>
  </HTML>
</xsl:template>

<!--*********************************************-->

<xsl:template match="ItemField" >
  <xsl:if expr="TableFlag==false">      <!-- identifica il I&#248 elemento -->
    <TR BGCOLOR="#6495ED">
      <TD>&#160;<FONT COLOR="WHITE"><B>Field</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Description</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Type</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Len</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Dec</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Key</B></FONT>&#160;</TD>
      <xsl:if match=".[FieldNotnull]"><TD>&#160;<FONT COLOR="WHITE"><B>Not null</B></FONT>&#160;</TD></xsl:if>
      <TD>&#160;<FONT COLOR="WHITE"><B>Rep.</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Table</B></FONT>&#160;</TD>
      <TD>&#160;<FONT COLOR="WHITE"><B>Phisical name</B></FONT>&#160;</TD>
    </TR>
    <xsl:eval>SetFlag(true)</xsl:eval>
  </xsl:if>
  <TR BGCOLOR="#F5F5F5">
    <TD>&#160;
      <A><xsl:attribute name="HREF">
           <xsl:value-of select="//text()" />_Tables.xml#<xsl:value-of select="@TableName" />_<xsl:value-of select="FieldName" />
         </xsl:attribute>
         <xsl:value-of select="FieldName" />
      </A>
    &#160;</TD>
    <TD>&#160;<xsl:apply-templates select="FieldComment" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldType" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldLen" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldDec" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="FieldKey" />&#160;</TD>
    <xsl:if match=".[FieldNotnull]"><TD ALIGN="CENTER"><xsl:apply-templates select="FieldNotnull" /></TD></xsl:if>
    <TD ALIGN="CENTER"><xsl:apply-templates select="FieldRepeated" /></TD>
    <TD>&#160;<xsl:value-of select="@TableName" />&#160;</TD>
    <TD>&#160;<xsl:value-of select="@TablePhName" />&#160;</TD>
  </TR>
</xsl:template>

<!--*********************************************-->

<xsl:template match="FieldNotnull|FieldRepeated">
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

    function SetFlag(FlagValue) {
      TableFlag=FlagValue;
    }
  ]]>
</xsl:script>

</xsl:stylesheet>
