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
      .XMLlist { font-family:Verdana; font-size:10pt; font-weight:bold;  text-align:center; margin:50px; color:gray; }
      .arrow { font-family:Webdings; }
      .prjsum {font-size: 10pt; font-family:Times New Roman ;border-right: 1px solid rgb(0,0,0); background="#DBDBDB"}
      .prjsum2 {font-size: 10pt; font-family:Times New Roman ;background="#DBDBDB"; }
    </STYLE>
  </HEAD>
  <BODY>

  <xsl:apply-templates select="Plan" />
  <xsl:apply-templates select="Plan/PlanTotalizer" />

  </BODY>
  </HTML>
</xsl:template>

<xsl:template match="Plan" >
  <TABLE BORDER="0" WIDTH="100%" CELLSPACING="0">
    <xsl:if match="Plan[PlanTitle!='']">
      <TR>
        <TD WIDTH="100%" COLSPAN="10" HEIGHT="50" VALIGN="BOTTOM" ALIGN="CENTER">
          <FONT SIZE="7" COLOR="#000080"><B><xsl:value-of select="PlanTitle" /></B></FONT>
        </TD>
      </TR>
    </xsl:if>
    <TR>
      <TD WIDTH="100%" COLSPAN="10" HEIGHT="45" VALIGN="TOP" ALIGN="CENTER">
        <FONT SIZE="5" COLOR="#000080"><B><xsl:value-of select="PlanSubtitle" /></B></FONT>
      </TD>
    </TR>
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Version:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="PlanVersion" />
      </TD>
    </TR>
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Author:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="PlanAuthor" />
      </TD>
    </TR>
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Created:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="PlanCreated" />
      </TD>
    </TR>
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Last modify:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="PlanLastrevision" />
      </TD>
    </TR>
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>User:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="PlanUser" />
      </TD>
    </TR>

    <xsl:if match="Plan[PlanNote!='']">
      <TR>
        <TD HEIGHT="60">&#160;</TD>
        <TD ALIGN="RIGHT" VALIGN="BOTTOM" HEIGHT="60">
          <B>Description</B>:
        </TD>
        <TD STYLE="BORDER-BOTTOM: 1 SOLID #000000; " COLSPAN="7" >&#160;</TD>
        <TD HEIGHT="60">&#160;</TD>
      </TR>

      <TR>
        <TD WIDTH="20%" COLSPAN="2" ALIGN="RIGHT" VALIGN="TOP" >&#160;</TD>
        <TD COLSPAN="7" ALIGN="LEFT" VALIGN="TOP" >
          <xsl:apply-templates select="PlanNote" />
        </TD>
        <TD WIDTH="10%">&#160;</TD>
      </TR>
    </xsl:if>

    <TR><TD COLSPAN="10" HEIGHT="60">&#160;</TD></TR>

    <TR>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="RIGHT" >
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Diagrams.xml</xsl:attribute>
          <IMG BORDER="0" SRC="Diagrams.gif" ALT="Show main project plan" WIDTH="60" HEIGHT="60"/>
        </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="LEFT">
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Diagrams.xml</xsl:attribute>
          <FONT SIZE="5">Diagrams</FONT>
        </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="RIGHT" >
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Entities.xml</xsl:attribute>
          <IMG BORDER="0" SRC="Entities.gif" ALT="Show entities list" WIDTH="60" HEIGHT="60"/>
        </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="LEFT">
       <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Entities.xml</xsl:attribute>
          <FONT SIZE="5">Entities</FONT>
       </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="RIGHT" >
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_TablesSummary.xml</xsl:attribute>
          <IMG BORDER="0" SRC="TablesSummary.gif"  ALT="Show tables attributes" WIDTH="60" HEIGHT="60"/>
        </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="LEFT">
       <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_TablesSummary.xml</xsl:attribute>
          <FONT SIZE="5">Tables summary</FONT>
       </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="RIGHT" >
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Tables.xml</xsl:attribute>
          <IMG BORDER="0" SRC="Tables.gif" ALT="Show table field details" WIDTH="60" HEIGHT="60"/>
        </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="LEFT">
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Tables.xml</xsl:attribute>
          <FONT SIZE="5">Tables</FONT>
        </A>
      </TD>

      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="RIGHT" >
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_DataDictionary.xml</xsl:attribute>
          <IMG BORDER="0" SRC="DataDictionary.gif" ALT="Show all project fields"/>
        </A>
      </TD>
      <TD WIDTH="10%" VALIGN="MIDDLE" ALIGN="LEFT">
        <A>
          <xsl:attribute name="HREF"><xsl:value-of select="//text()" />_DataDictionary.xml</xsl:attribute>
          <FONT SIZE="5">Data dictionary</FONT>
        </A>
      </TD>

    </TR>
    <xsl:for-each select="//Module">
    <TR>
      <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;" ALIGN="CENTER" COLSPAN="2">
       <A><xsl:attribute name="HREF"><xsl:value-of />_Diagrams.xml</xsl:attribute><xsl:value-of /></A>
      </TD>
      <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;" ALIGN="CENTER" COLSPAN="2">
       <A><xsl:attribute name="HREF"><xsl:value-of />_Entities.xml</xsl:attribute><xsl:value-of /></A>
      </TD>
      <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;" ALIGN="CENTER" COLSPAN="2">
       <A><xsl:attribute name="HREF"><xsl:value-of />_TablesSummary.xml</xsl:attribute><xsl:value-of /></A>
      </TD>
      <TD STYLE="BORDER-RIGHT: 1 SOLID #000000;" ALIGN="CENTER" COLSPAN="2">
       <A><xsl:attribute name="HREF"><xsl:value-of />_Tables.xml</xsl:attribute><xsl:value-of /></A>
      </TD>
      <TD ALIGN="CENTER" COLSPAN="2">
       <A><xsl:attribute name="HREF"><xsl:value-of />_DataDictionary.xml</xsl:attribute><xsl:value-of /></A>
      </TD>
   </TR>
    </xsl:for-each>

  </TABLE>
</xsl:template>

<xsl:template match="PlanTotalizer" >
  <P align="center">
  <TABLE border="0" width="480" cellspacing="0" cellpadding="0" >
  <TR>
    <TD width="489" bgcolor="#DBDBDB" colSPAN="4" height="35">
      <P align="center"><font color="#000080"><B>Project summary</B></font></P>
    </TD>
  </TR>
  <TR>
    <TD width="65" bgcolor="#DBDBDB" height="22"></TD>
    <TD width="172" bgcolor="#000080" style="border-right: 1px solid rgb(0,0,0)" height="22">
      <P align="center"><SPAN style="color: rgb(255,255,255)">Entities</SPAN></P>
    </TD>
    <TD width="97" bgcolor="#000080" style="border-right: 1px solid rgb(0,0,0)" height="22">
      <P align="center"><SPAN style="color: rgb(255,255,255)">Tables</SPAN></P>
    </TD>
    <TD width="155" bgcolor="#000080" height="22">
      <P align="center"><SPAN  style="color: rgb(255,255,255)">Fields</SPAN></P>
    </TD>
  </TR>
  <TR>
    <TD width="100" bgcolor="#FFFF00" height="22">Total nr.</TD>
    <TD width="146" bgcolor="#FFFF00" style="border-right: 1px solid rgb(0,0,0)" height="22" align="center">
       <xsl:value-of select="TotEntities"/>
    </TD>
    <TD width="97" bgcolor="#FFFF00" style="border-right: 1px solid rgb(0,0,0)" height="22" align="center">
       <xsl:value-of select="TotTables"/>
    </TD>
    <TD width="155" bgcolor="#FFFF00" height="22" align="center">
       <xsl:value-of select="TotFields"/>
    </TD>
  </TR>
  <TR>
    <TD class="prjsum2">&#160;</TD>
    <TD class="prjsum2">&#160;</TD>
    <TD class="prjsum2">&#160;</TD>
    <TD class="prjsum2">&#160;</TD>
  </TR>
  <xsl:if expr="this.selectSingleNode('Entities').hasChildNodes()">
    <TR>
      <TD width="65" bgcolor="#DBDBDB" height="19"></TD>
      <TD bgcolor="#DBDBDB" height="19">
        <TABLE border="0" width="100%" cellspacing="0">
          <TR>
            <TD style="border-right: 1px solid rgb(0,0,0); border-bottom: 2px solid rgb(0,0,0)" bgcolor="#DBDBDB">
              <font face="Times New Roman" size="2"><B> Entity type</B></font>
            </TD>
            <TD style="border-bottom: 2px solid rgb(0,0,0)" bgcolor="#DBDBDB">
              <P align="center"><font face="Times New Roman" size="2"><B>Q.ty</B></font></P>
            </TD>
          </TR>
          <xsl:for-each select="Entities/node()">
            <TR>
              <TD class="prjsum"><xsl:eval>this.nodeName</xsl:eval></TD>
              <TD class="prjsum2" align="center"><xsl:value-of /></TD>
            </TR>
          </xsl:for-each>
        </TABLE>
      </TD>
      <TD bgcolor="#DBDBDB" height="19"></TD>
      <TD width="146" bgcolor="#DBDBDB" height="19"></TD>
    </TR>
    <TR>
      <TD class="prjsum2">&#160;</TD>
      <TD class="prjsum2">&#160;</TD>
      <TD class="prjsum2">&#160;</TD>
      <TD class="prjsum2">&#160;</TD>
    </TR>
  </xsl:if>
  </TABLE>
  </P>
</xsl:template>

</xsl:stylesheet>

