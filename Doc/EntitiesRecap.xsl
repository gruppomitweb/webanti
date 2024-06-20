<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/TR/WD-xsl">

<xsl:template match="/">
  <HTML>
  <HEAD>
    <STYLE>
      BODY { font-family:Times New Roman; font-size:10pt; color:black; background:white; margin:20px;}
      TABLE {font-family:Times New Roman; font-size:10pt; color:black; background:white}
      .Row1 {font-size:9pt;color:white; border-right-width:1; border-right-style:solid; border-right-color:white;
             border-bottom-width:1; border-bottom-style:solid ; border-bottom-color:black;background-color:"#000080"}
      .Row2 {font-size:9pt; border-right-width:1; border-right-style:solid; border-right-color:black; background-color:"#00FFFF"}
      .Row3 {font-size:9pt; border-top-width:1; border-top-style:solid; border-top-color:black; background-color:"#00FFFF"}
      A:hover {color:red}
    </STYLE>
  </HEAD>
  <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('PlanTitle'))==true">
    <TABLE BORDER="0" WIDTH="100%" CELLSPACING="0" >
      <TR>
        <TD class="Row1">&#160;<B>Design file</B></TD>
        <TD class="Row1">&#160;<B>Title</B></TD>
        <TD class="Row1">&#160;<B>Author</B></TD>
        <TD class="Row1">&#160;<B>User</B></TD>
        <TD class="Row1" WIDTH="6%">&#160;<B>Version</B></TD>
        <TD class="Row1" WIDTH="8%">&#160;<B>Created</B></TD>
        <TD class="Row1" WIDTH="10%" STYLE="BORDER-RIGHT: 0;">&#160;<B>Last revision</B></TD>
      </TR>
      <TR>
        <TD class="Row2">&#160;<xsl:value-of select="//text()"/></TD>
        <TD class="Row2">&#160;<xsl:value-of select="//PlanSubtitle"/></TD>
        <TD class="Row2">&#160;<xsl:value-of select="//PlanAuthor"/></TD>
        <TD class="Row2">&#160;<xsl:value-of select="//PlanUser"/></TD>
        <TD class="Row2">&#160;<xsl:value-of select="//PlanVersion"/></TD>
        <TD class="Row2">&#160;<xsl:value-of select="//PlanCreated"/></TD>
        <TD BGCOLOR="#00FFFF">&#160;<xsl:value-of select="//PlanLastrevision"/></TD>
      </TR>
      <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('PlanNote'))==true">
        <TR>
          <TD class="Row3" ALIGN="RIGHT" VALIGN="TOP"><B><I>Description:</I></B></TD>
          <TD class="Row3" COLSPAN="5"><xsl:value-of select="//PlanNote"/></TD>
          <TD class="Row3">&#160;</TD>
        </TR>
      </xsl:if>
    </TABLE>
  </xsl:if>
  <P/>
  <BODY>
  <P ALIGN="CENTER"><FONT COLOR="#000080" SIZE="6"><B>Summing up entities</B></FONT></P>
  <P ALIGN="CENTER">
  <TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0">
    <TR>
      <TD BGCOLOR="#C0C0C0">&#160;<B>Entity</B>&#160;</TD>
      <TD BGCOLOR="#C0C0C0">&#160;<B>Class</B>&#160;</TD>
      <TD BGCOLOR="#C0C0C0">&#160;<B>Program</B>&#160;</TD>
      <TD BGCOLOR="#C0C0C0">&#160;<B>Created</B>&#160;</TD>
      <TD BGCOLOR="#C0C0C0">&#160;<B>Group</B>&#160;</TD>
    </TR>
    <xsl:for-each select="//PlanItem[ItemObj!='String']" order-by="ItemGroup" >
      <TR>
        <xsl:apply-templates select="ItemName"/>
        <xsl:apply-templates select="ItemObj|ItemProcname|ItemDatecreate|ItemGroup"/>
      </TR>
    </xsl:for-each>
  </TABLE>
  </P>
  <TABLE BORDER="0" WIDTH="100%" CELLSPACING="0" >
    <TR>
      <TD ALIGN="CENTER" >
        <A><xsl:attribute name="HREF"><xsl:value-of select="//PlanMain" />_Main.xml</xsl:attribute>
          <FONT SIZE="2">BACK TO MAIN</FONT>
        </A>
      </TD>
      <TD ALIGN="CENTER" >
        <A><xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Diagrams.xml</xsl:attribute>
          <FONT SIZE="2">BACK TO DIAGRAMS</FONT>
        </A>
      </TD>
    </TR>
  </TABLE>
 </BODY>
  </HTML>
</xsl:template>

<xsl:template match="ItemName|ItemObj|ItemProcname|ItemDatecreate|ItemGroup">
   <xsl:choose>
     <xsl:when match="PlanItem[ItemGroup='']/ItemGroup">
       <TD>&#160;TOP-LEVEL&#160;</TD>
     </xsl:when>
     <xsl:when match="PlanItem[ItemObj='Group']/ItemName">
       <TD>&#160;
       <A><xsl:attribute name="HREF">#<xsl:value-of /></xsl:attribute>
         <xsl:value-of />
       </A>
       &#160;</TD>
     </xsl:when>
     <xsl:when match="PlanItem[ItemObj!='Group' $and$ ItemObj!='String']/ItemName">
       <TD>&#160;
       <A><xsl:attribute name="HREF"><xsl:value-of select="//text()" />_Entities.xml#<xsl:value-of /></xsl:attribute>
         <xsl:value-of />
       </A>
       &#160;</TD>
     </xsl:when>
     <xsl:when match="PlanItem[ItemGroup='']/ItemGroup">
       <TD>&#160;TOP-LEVEL&#160;</TD>
     </xsl:when>
     <xsl:otherwise>
       <TD>&#160;<xsl:value-of />&#160;</TD>
     </xsl:otherwise>
   </xsl:choose>
 </xsl:template>

<!--************** Script JScript **************-->
<xsl:script>
  <![CDATA[
    function NodeExistsAndNotEmpty(objNode) {
      if (objNode!=null) {
        if (objNode.text != '') {
          return(true)
        }
        else {
          return(false)
        }
      }
      else {
        return(false)
      }
    }
  ]]>
</xsl:script>
<!--*********************************************-->

</xsl:stylesheet>

