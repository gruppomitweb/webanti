<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/TR/WD-xsl">

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
      BODY { font-family:Times New Roman; font-size:10pt; color:black; background:white; margin:20px}
      TABLE {font-family:Times New Roman; font-size:10pt; color:black; background:white}
      .Row1 {font-size:9pt;color:white; border-right-width:1; border-right-style:solid; border-right-color:white;
             border-bottom-width:1; border-bottom-style:solid ; border-bottom-color:black;background-color:"#000080"}
      .Row2 {font-size:9pt; border-right-width:1; border-right-style:solid; border-right-color:black; background-color:"#00FFFF"}
      .Row3 {font-size:9pt; border-top-width:1; border-top-style:solid; border-top-color:black; background-color:"#00FFFF"}
      A:hover {color:red}
     </STYLE>
  </HEAD>
  <SCRIPT>
    function changeXSL()  {
      document.XSLDocument.load('EntitiesRecap.xsl');
      var d=document.XMLDocument.selectSingleNode("/");
      document.write(d.transformNode(document.XSLDocument));
    }
  </SCRIPT>

  <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('PlanTitle'))==true">
    <TABLE BORDER="0" WIDTH="100%" CELLSPACING="0" >
      <TR BGCOLOR="#6495ED">
        <TD class="Row1">&#160;<B>Design file</B></TD>
        <TD class="Row1">&#160;<B>Title</B></TD>
        <TD class="Row1">&#160;<B>Author</B></TD>
        <TD class="Row1">&#160;<B>User</B></TD>
        <TD class="Row1" WIDTH="6%">&#160;<B>Version</B></TD>
        <TD class="Row1" WIDTH="8%">&#160;<B>Created</B></TD>
        <TD class="Row1" WIDTH="10%" STYLE="BORDER-RIGHT: 0;">&#160;<B>Last revision</B></TD>
      </TR>
      <TR BGCOLOR="#F5F5F5">
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
  <P ALIGN="CENTER"><FONT COLOR="#000080" SIZE="6"><B>Diagrams</B></FONT></P>
  <xsl:apply-templates select="Plan/PlanImagelist/JPG" />
  <TABLE BORDER="0" WIDTH="100%" CELLSPACING="0" >
    <TR>
      <TD ALIGN="CENTER" >
        <A><xsl:attribute name="HREF"><xsl:eval>PlanName+'_Main.xml'</xsl:eval></xsl:attribute>
          <FONT SIZE="2">BACK TO MAIN</FONT>
        </A>
      </TD>
      <TD ALIGN="CENTER" >
        <A><xsl:attribute name="HREF">JavaScript:changeXSL()</xsl:attribute>
          <FONT SIZE="2">Summing up entitites</FONT>
        </A>
      </TD>
    </TR>
  </TABLE>
  </BODY>
  </HTML>

</xsl:template>

<xsl:template match="JPG" >
<!-- ************************************ Titolo delle entita e dei gruppi ************************************ -->
  <A><xsl:attribute name="NAME"><xsl:eval>getNodeText(this)</xsl:eval></xsl:attribute>
    <FONT SIZE="5"><U><xsl:value-of/></U></FONT>
  </A>
  <P>
  <TABLE BORDER="0" WIDTH="100%" >
    <TR><TD>
      <TABLE BORDER="0" WIDTH="100%">
        <TR>
          <TD WIDTH="10%">&#160;</TD>
          <TD WIDTH="80%"><xsl:apply-templates select="//PlanItem[ItemName=context()]/ItemGroupnote"/></TD>
          <TD WIDTH="10%">&#160;</TD>
        </TR>
      </TABLE>
    </TD></TR>
    <TR>
      <TD ALIGN="MIDDLE">
      <IMG>
        <xsl:attribute name="SRC"><xsl:eval>PlanName+'_'+getNodeText(this)+'.jpg'</xsl:eval></xsl:attribute>
        <xsl:attribute name="ALIGN">MIDDLE</xsl:attribute>
      </IMG>
      </TD>
    </TR>
    <TR><TD>&#160;&#160;</TD></TR>
    <TR>
      <TD ALIGN="MIDDLE">
      <TABLE BORDER="1" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080" CELLPADDING="0" CELLSPACING="0">
      <TR BGCOLOR="#6495ED">
        <TD>&#160;<FONT COLOR="WHITE"><B>Entity</B></FONT>&#160;</TD>
        <TD>&#160;<FONT COLOR="WHITE"><B>Class</B></FONT>&#160;</TD>
        <TD>&#160;<FONT COLOR="WHITE"><B>Program</B></FONT>&#160;</TD>
        <TD>&#160;<FONT COLOR="WHITE"><B>Created</B></FONT>&#160;</TD>
        <TD>&#160;<FONT COLOR="WHITE"><B>File</B></FONT>&#160;</TD>
        <TD>&#160;<FONT COLOR="WHITE"><B>Menu</B></FONT>&#160;</TD>
      </TR>
      <xsl:choose>
        <xsl:when match="*[. = 'TOP-LEVEL']">
          <xsl:for-each select="//PlanItem[ItemGroup ='' $and$ ItemObj!='String']" order-by="ItemObj">
            <TR BGCOLOR="#F5F5F5">
              <xsl:apply-templates select="ItemName"/>
              <xsl:apply-templates select="ItemObj|ItemProcname|ItemDatecreate"/>
              <TD>
                &#160;<xsl:value-of select="ItemTbl"/>&#160;
                <xsl:if match="*[ItemMastertbl!='']">
                  <BR/>&#160;<xsl:value-of select="ItemMastertbl"/>&#160;
                </xsl:if>
              </TD>
              <TD ALIGN="CENTER"><xsl:apply-templates select="ItemMenu"/></TD>
            </TR>
          </xsl:for-each>
        </xsl:when>
        <xsl:otherwise>
          <xsl:for-each select="//PlanItem[ItemGroup=context() $and$ ItemObj!='String']" order-by="ItemObj">
            <TR BGCOLOR="#F5F5F5">
              <xsl:apply-templates select="ItemName"/>
              <xsl:apply-templates select="ItemObj|ItemProcname|ItemDatecreate"/>
              <TD>
                &#160;<xsl:value-of select="ItemTbl"/>&#160;
                <xsl:if match="*[ItemMastertbl!='']" >
                  <BR/>&#160;<xsl:value-of select="ItemMastertbl"/>&#160;
                </xsl:if>
              </TD>
              <TD ALIGN="CENTER"><xsl:apply-templates select="ItemMenu"/></TD>
            </TR>
          </xsl:for-each>
        </xsl:otherwise>
      </xsl:choose>
      </TABLE>
      </TD>
    </TR>
  </TABLE>
  <P/>
  </P>
</xsl:template>

<xsl:template match="ItemName|ItemObj|ItemProcname|ItemDatecreate|ItemGroup">
  <xsl:choose>
    <xsl:when match="PlanItem[ItemGroup='']/ItemGroup">
      <TD>&#160;TOP-LEVEL&#160;</TD>
    </xsl:when>
    <xsl:when match="PlanItem[ItemObj='Group']/ItemName">
      <TD>&#160;
      <A><xsl:attribute name="HREF">#<xsl:eval>getNodeText(this)</xsl:eval></xsl:attribute>
        <xsl:value-of />
      </A>
      &#160;</TD>
    </xsl:when>
    <xsl:when match="PlanItem[ItemObj!='Group']/ItemName">
      <TD>&#160;
      <A><xsl:attribute name="HREF"><xsl:eval>PlanName+'_Entities.xml#'+getNodeText(this)</xsl:eval></xsl:attribute>
        <xsl:value-of />
      </A>
      &#160;</TD>
    </xsl:when>
    <xsl:otherwise>
      <TD>&#160;<xsl:value-of />&#160;</TD>
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>

<!--************** Template x visualizzazione checkbox **************-->

<xsl:template match="ItemMenu">
  <xsl:choose>
    <xsl:when match="*[. = 'FALSE']"><IMG SRC="No.gif" /></xsl:when>
    <xsl:when match="*[. = 'TRUE']"><IMG SRC="Yes.gif" /></xsl:when>
    <xsl:otherwise>?</xsl:otherwise>
  </xsl:choose>
</xsl:template>

<!--************** Script JScript **************-->
<xsl:script>
  <![CDATA[
    var PlanName=getNodeText(this.lastChild);

    function getNodeText(currNode) {
      if (currNode!=null){
        return StrClean(currNode.firstChild.nodeValue)
      } else {
        return ''
      }
    }
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
    function StrClean(str) {

      var charsToClean=new Array('\n',' ','#','&',';')
      var id
      for (id in charsToClean) {
        str=Replace(str,charsToClean[id],'')
      }
      return str
    }

    function Replace(str,strFind,strReplace) {
      if (str!=null) {
        var re = new RegExp(strFind,"g")
        return str.replace(re, strReplace)
      }
    }
  ]]>
</xsl:script>
<!--*********************************************-->

</xsl:stylesheet>
