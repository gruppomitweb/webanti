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

<xsl:script>
  <![CDATA[
    var Flags = new Array(false,false,false,false);
    var PlanName=getNodeText(this.lastChild);

    function MkTbl_HyperLink(currNode,param) {
      if (param!=null) {
          return PlanName+'_TablesSummary.xml#Table_'+getNodeText(currNode.selectSingleNode("ItemTable/TableName[@Type='"+param+"']"))
      } else {
          return PlanName+'_TablesSummary.xml#Table_'+getNodeText(currNode.selectSingleNode("ItemTable/TableName"))
      }
    }

    function MkLink_HyperLink(Linknode) {
      return '#'+getNodeText(Linknode.selectSingleNode("//PlanItem[ItemUID='"+getUid(Linknode)+"']/ItemName"))
    }

    function getNodeText(currNode) {
      if (currNode!=null){
        return StrClean(currNode.firstChild.nodeValue)
      } else {
        return ''
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

    function getUid(Linknode) {
      return Linknode.selectSingleNode("Uid").firstChild.nodeValue
    }

    function SetFlag(ID,FlagValue) {
      Flags[ID]=FlagValue;
    }

  ]]>
</xsl:script>

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
    <P ALIGN="CENTER"><FONT COLOR="#000080" SIZE="6"><B>Entities</B></FONT></P>
    <xsl:apply-templates select="//PlanItem[ItemObj!='Group']" order-by="ItemObj;ItemName"/>
  <DIV ALIGN="CENTER">
    <A><xsl:attribute name="HREF"><xsl:eval>PlanName+'_Main.xml'</xsl:eval></xsl:attribute>
      <FONT SIZE="2">BACK TO MAIN</FONT>
    </A>
  </DIV>
</BODY>
  </HTML>
</xsl:template>

<xsl:template match="PlanItem[ItemDesc]" >
  <P>
    <TABLE BORDER="0" CELLSPACING ="0">
  <TR>
  <TD WIDTH="40" ALIGN="LEFT" VALIGN="MIDDLE" >
    <xsl:choose>
      <xsl:when match="*[ItemObj = 'Table']">
        <A>
          <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this)</xsl:eval></xsl:attribute>
          <IMG BORDER="0" SRC="ds_Tbl.gif" ALT="Show Table" WIDTH="40" HEIGHT="40"/>
        </A>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'DataTable']">
        <A>
          <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this)</xsl:eval></xsl:attribute>
          <xsl:choose>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='TRUE']">
              <IMG BORDER="0" SRC="ds_StorageExtLink.gif" ALT="Show Database Table" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='FALSE']">
              <IMG BORDER="0" SRC="ds_Storage.gif" ALT="Show Database Table" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
          </xsl:choose>
        </A>
      </xsl:when>

       <!-- Insermento di exsternal linkable.gif -->
      <xsl:when match="*[ItemObj = 'Master']">
        <A>
          <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this)</xsl:eval></xsl:attribute>
          <xsl:choose>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='TRUE']">
              <IMG BORDER="0" SRC="ds_MstExtLink.gif" ALT="Show Master" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='FALSE']">
              <IMG BORDER="0" SRC="ds_Mst.gif" ALT="Show Master" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
          </xsl:choose>
        </A>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'MasterDetail']">
        <A>
          <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this)</xsl:eval></xsl:attribute>
          <xsl:choose>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='TRUE']">
              <IMG BORDER="0" SRC="ds_MDtExtLink.gif" ALT="Show Master Detail" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='FALSE']">
              <IMG BORDER="0" SRC="ds_MDt.gif" ALT="Show Master Detail" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
          </xsl:choose>
        </A>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'Detail']">
        <A>
          <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this)</xsl:eval></xsl:attribute>
          <xsl:choose>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='TRUE']">
              <IMG BORDER="0" SRC="ds_DtlExtLink.gif" ALT="Show Detail" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
            <xsl:when match="*[ItemDesc/ItemDescLinkable='FALSE']">
              <IMG BORDER="0" SRC="ds_Dtl.gif" ALT="Show Detail" WIDTH="40" HEIGHT="40"/>
            </xsl:when>
          </xsl:choose>
        </A>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'Batch']">
        <IMG BORDER="0" SRC="ds_Btc.gif" ALT="Routine" WIDTH="40" HEIGHT="40"/>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'Mask']">
        <IMG BORDER="0" SRC="ds_Msk.gif" ALT="Mask" WIDTH="40" HEIGHT="40"/>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'Report']">
        <IMG BORDER="0" SRC="ds_Rpt.gif" ALT="Report" WIDTH="40" HEIGHT="40"/>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'Output']">
        <IMG BORDER="0" SRC="ds_Output.gif" ALT="Output" WIDTH="40" HEIGHT="40"/>
      </xsl:when>

      <xsl:when match="*[ItemObj = 'Page']">
        <IMG BORDER="0" SRC="ds_Page.gif" ALT="Page" WIDTH="40" HEIGHT="40"/>
      </xsl:when>

    </xsl:choose>
  </TD>
  <TD ALIGN="LEFT" VALIGN="MIDDLE" >
    <A>
      <xsl:if match="*[ItemObj='DataTable' $or$ ItemObj='Master' $or$ ItemObj='Detail' $or$ ItemObj='Table']">
      <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this)</xsl:eval></xsl:attribute>
      </xsl:if>
    <FONT SIZE="5"><B><xsl:value-of select="ItemDesc/ItemDescName" /></B></FONT>
    </A>
  </TD>

  <!--  Inserimento della scritta ext linkable-->
  <!--<xsl:if match="*[ItemDesc/ItemDescLinkable='TRUE' $or$ ItemDesc/ItemDescExternal='TRUE']">-->
    <xsl:if match="*[ItemDesc/ItemDescExternal='TRUE']">
    <TD>&#160;(
     <!-- Sostituito con gif <xsl:if match="*[ItemDesc/ItemDescLinkable='TRUE']">Ext. linkable</xsl:if> -->
      <xsl:if match="*[ItemDesc/ItemDescExternal='TRUE']">External entity</xsl:if>
    )</TD>
  </xsl:if>

  <TD>
  <xsl:if match="*[ItemObj='MasterDetail']">
    <TABLE BORDER="0">
      <TR>
        <TD>&#160;<A>
          <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this,'Master')</xsl:eval></xsl:attribute>
           Master
        </A></TD>
      </TR>
      <TR>
        <TD>&#160;<A>
          <xsl:attribute name="HREF"><xsl:eval>MkTbl_HyperLink(this,'Detail')</xsl:eval></xsl:attribute>
           Detail
        </A></TD>
      </TR>
    </TABLE>
  </xsl:if>
  </TD>
  <xsl:apply-templates select="ItemDesc/ItemDescName"/>
  </TR>
  </TABLE>

  <!-- Tabella HTML per l'inserimento dei dati generali dell'entita' -->

  <TABLE WIDTH="100%">
  <TR>
    <TD COLSPAN="3">&#160;</TD>
  </TR>
  <TR>
    <TD WIDTH="5%">&#160;&#160;&#160;&#160;&#160;&#160;</TD>
    <TD>
      <TABLE CELLSPACING ="0">
      <TR>
        <TD WIDTH="16%" STYLE="BORDER-BOTTOM: 1 SOLID #000000;" ><B>Program</B>&#160;</TD>
        <xsl:if match="*[ItemDesc/ItemDescTemplate!='']">
          <TD WIDTH="15%" STYLE="BORDER-BOTTOM: 1 SOLID #000000;"><B>Template</B>&#160;</TD>
        </xsl:if>
        <TD WIDTH="13%" STYLE="BORDER-BOTTOM: 1 SOLID #000000;"><B>Created</B>&#160;</TD>
        <TD WIDTH="13%" STYLE="BORDER-BOTTOM: 1 SOLID #000000;"><B>Revised</B>&#160;</TD>
        <TD WIDTH="5%" STYLE="BORDER-BOTTOM: 1 SOLID #000000;" ALIGN="CENTER"><B>Menu</B>&#160;</TD>
        <TD WIDTH="5%" STYLE="BORDER-BOTTOM: 1 SOLID #000000;" ALIGN="CENTER"><B>Prototype</B>&#160;</TD>

        <!--  aggiunta titoli per tmptable e public-->
        <xsl:if match="*[ItemDesc/ItemDescTmpTable!='' || ItemDesc/ItemDescTmpTable='?']">
          <TD WIDTH="5%"  STYLE="BORDER-BOTTOM: 1 SOLID #000000;" ALIGN="CENTER"><B>Tmp Table</B>&#160;</TD>
        </xsl:if>

        <xsl:if match="*[ItemDesc/ItemDescPublic!='' || ItemDesc/ItemDescPublic='?']">
          <TD WIDTH="5%" STYLE="BORDER-BOTTOM: 1 SOLID #000000;" ALIGN="CENTER"><B>Public</B>&#160;</TD>
        </xsl:if>
      </TR>
      <TR>
        <TD WIDTH="16%"><xsl:value-of select="ItemDesc/ItemDescProcedure" />&#160;</TD>
        <xsl:if match="*[ItemDesc/ItemDescTemplate!='']">
          <TD WIDTH="15%"><xsl:value-of select="ItemDesc/ItemDescTemplate" />&#160;</TD>
        </xsl:if>
        <TD WIDTH="13%"><xsl:value-of select="ItemDesc/ItemDescCreated" />&#160;</TD>
        <TD WIDTH="13%"><xsl:value-of select="ItemDesc/ItemDescRevised" />&#160;</TD>
        <TD WIDTH="5%" ALIGN="CENTER"><xsl:apply-templates select="ItemDesc/ItemDescMenu" />&#160;</TD>
        <TD WIDTH="5%" ALIGN="CENTER"><xsl:apply-templates select="ItemDesc/ItemDescPrototype" />&#160;</TD>

        <!-- se queste informazioni mancano, non serve a niente inserirle-->
        <xsl:if match="*[ItemDesc/ItemDescTmpTable!='' || ItemDesc/ItemDescTmpTable='?']">
          <TD WIDTH="5%" ALIGN="CENTER"><xsl:apply-templates select="ItemDesc/ItemDescTmpTable" />&#160;</TD>
        </xsl:if>

        <xsl:if match="*[ItemDesc/ItemDescPublic!='' || ItemDesc/ItemDescPublic='?']">
          <TD WIDTH="5%" ALIGN="CENTER"><xsl:apply-templates select="ItemDesc/ItemDescPublic" />&#160;</TD>
        </xsl:if>

      </TR>
      </TABLE>
    </TD>
    <TD WIDTH="5%">&#160;&#160;&#160;&#160;&#160;&#160;</TD>
  </TR>
  </TABLE>

  <!-- Tabella HTML per l'inserimento delle note (visulizzata solo se presenti)-->

  <xsl:if match="*[ItemDesc/ItemDescNote!='']">
    <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="3">&#160;</TD>
    </TR>
    <TR>
      <TD WIDTH="5%">&#160;&#160;&#160;&#160;&#160;&#160;</TD>
      <TD>
        <TABLE WIDTH="100%">
          <TR>
            <TD ALIGN="CENTER"><B>Notes</B></TD>
          </TR>
          <TR>
            <TD STYLE="BORDER-TOP: 2 SOLID #000000;">
              <xsl:apply-templates select="ItemDesc/ItemDescNote" />
            </TD>
          </TR>
        </TABLE>
      </TD>
      <TD WIDTH="5%">&#160;&#160;&#160;&#160;&#160;&#160;</TD>
    </TR>
    </TABLE>
  </xsl:if>

  <!-- Tabella HTML per l'inserimento dei links e relative note (visulizzata solo se presenti)-->

  <xsl:if match="*[ItemLinks/Link]">
    <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="3">&#160;</TD>
    </TR>
    <TR>
      <TD WIDTH="5%">&#160;</TD>
      <TD>
        <TABLE CELLSPACING="0" BORDER="0" WIDTH="100%">
        <xsl:for-each select="ItemLinks/Link">
          <xsl:if expr="childNumber(this)==1">      <!-- identifica il I&#248 elemento -->
            <TR>
              <TD COLSPAN="4" ALIGN="CENTER" STYLE="BORDER-BOTTOM: 2 SOLID #000000;"><B>Relationships</B></TD>
            </TR>
          </xsl:if>
        </xsl:for-each>

        <!--Gestione Link Parent/Child Relationship -->

        <TR>
          <TD VALIGN="TOP">
            <TABLE WIDTH="100%" BORDER="0" cellspacing="0" cellpadding="2">
            <xsl:for-each select="ItemLinks/Link[Type='Parent/Child Relationship']">
              <xsl:if expr="Flags[0]==false">
                <TR><TD HEIGHT="25" COLSPAN="2" VALIGN="BOTTOM" STYLE="BORDER-BOTTOM: 1 SOLID #000000;">
                  <B><xsl:value-of select="Type"/></B>
                </TD></TR>
                <xsl:eval>SetFlag(0,true)</xsl:eval>
              </xsl:if>
              <TR>
                <TD WIDTH="30%" VALIGN="MIDDLE">
                  <A><xsl:attribute name="HREF">
                     <xsl:eval>MkLink_HyperLink(this)</xsl:eval>
                    </xsl:attribute>
                    <xsl:value-of select="//PlanItem[ItemUID=context()/Uid]/ItemName"/>
                  </A>
                </TD>
                <TD WIDTH="70%" VALIGN="MIDDLE" STYLE="BORDER-LEFT: 1 SOLID #000000;"><xsl:apply-templates select="Notes"/></TD>
              </TR>
              </xsl:for-each>
            </TABLE>
          </TD>
        </TR>

        <!--Gestione Link Relationship -->

        <TR>
          <TD VALIGN="TOP">
            <TABLE WIDTH="100%" BORDER="0" cellspacing="0" cellpadding="2">
            <xsl:for-each select="ItemLinks/Link[Type='Relationship']">
              <xsl:if expr="Flags[1]==false">
                <TR><TD HEIGHT="25" COLSPAN="2" VALIGN="BOTTOM" STYLE="BORDER-BOTTOM: 1 SOLID #000000;">
                  <B><xsl:value-of select="Type"/></B>
                </TD></TR>
                <xsl:eval>SetFlag(1,true)</xsl:eval>
              </xsl:if>
              <TR>
                  <TD WIDTH="30%" VALIGN="MIDDLE">
                  <A><xsl:attribute name="HREF">
                     <xsl:eval>MkLink_HyperLink(this)</xsl:eval>
                    </xsl:attribute>
                    <xsl:value-of select="//PlanItem[ItemUID=context()/Uid]/ItemName"/>
                  </A>
                </TD>
                <TD WIDTH="70%" VALIGN="MIDDLE" STYLE="BORDER-LEFT: 1 SOLID #000000;"><xsl:apply-templates select="Notes"/></TD>
            </TR>
            </xsl:for-each>
            </TABLE>
          </TD>
        </TR>

        <!-- Gestione Link Data Flow -->

        <TR>
          <TD VALIGN="TOP">
            <TABLE WIDTH="100%" BORDER="0" cellspacing="0" cellpadding="2">
            <xsl:for-each select="ItemLinks/Link[Type='Data Flow']">
              <xsl:if expr="Flags[2]==false">
                <TR><TD HEIGHT="25" COLSPAN="2" VALIGN="BOTTOM" STYLE="BORDER-BOTTOM: 1 SOLID #000000;">
                <B><xsl:value-of select="Type"/></B>
                </TD></TR>
                <xsl:eval>SetFlag(2,true)</xsl:eval>
              </xsl:if>
              <TR>
                <TD WIDTH="30%" VALIGN="MIDDLE">
                  <A><xsl:attribute name="HREF">
                    <xsl:eval>MkLink_HyperLink(this)</xsl:eval>
                    </xsl:attribute>
                    <xsl:value-of select="//PlanItem[ItemUID=context()/Uid]/ItemName"/>
                  </A>
                </TD>
                <TD WIDTH="70%" VALIGN="MIDDLE" STYLE="BORDER-LEFT: 1 SOLID #000000;"><xsl:apply-templates select="Notes"/></TD>
              </TR>
            </xsl:for-each>
            </TABLE>
          </TD>
        </TR>

        <!-- Gestione Link Event -->

        <TR>
          <TD VALIGN="TOP">
            <TABLE WIDTH="100%" BORDER="0" cellspacing="0" cellpadding="2">
            <xsl:for-each select="ItemLinks/Link[Type='Event']">
              <xsl:if expr="Flags[3]==false">
                <TR><TD HEIGHT="25" COLSPAN="2" VALIGN="BOTTOM" STYLE="BORDER-BOTTOM: 1 SOLID #000000;">
                  <B><xsl:value-of select="Type"/></B>
                </TD></TR>
                <xsl:eval>SetFlag(3,true)</xsl:eval>
              </xsl:if>
              <TR>
                <TD WIDTH="30%" VALIGN="MIDDLE">
                  <A><xsl:attribute name="HREF">
                    <xsl:eval>MkLink_HyperLink(this)</xsl:eval>
                    </xsl:attribute>
                    <xsl:value-of select="//PlanItem[ItemUID=context()/Uid]/ItemName"/>
                  </A>
                </TD>
                <TD WIDTH="70%" VALIGN="MIDDLE" STYLE="BORDER-LEFT: 1 SOLID #000000;"><xsl:apply-templates select="Notes"/></TD>
              </TR>
            </xsl:for-each>
            </TABLE>
          </TD>
        </TR>
        </TABLE>
      </TD>
      <TD WIDTH="5%">&#160;</TD>
    </TR>
    </TABLE>
  </xsl:if>

</P>
<!-- Reset di tutti i flag  -->
<xsl:eval>SetFlag(0,false)</xsl:eval>
<xsl:eval>SetFlag(1,false)</xsl:eval>
<xsl:eval>SetFlag(2,false)</xsl:eval>
<xsl:eval>SetFlag(3,false)</xsl:eval>

</xsl:template>

<xsl:template match="ItemDescName">
  <A><xsl:attribute name="NAME"><xsl:eval>getNodeText(this)</xsl:eval></xsl:attribute>
    &#160;
  </A>
</xsl:template>

<!--   Sostituzione dei valori dei nodi con immagini dei flag -->
<xsl:template match="ItemDescMenu|ItemDescPrototype|ItemDescTmpTable|ItemDescPublic">
  <xsl:choose>
    <xsl:when match="*[. = 'FALSE']"><IMG ALIGN="MIDDLE" SRC="No.gif" /></xsl:when>
    <xsl:when match="*[. = 'TRUE']"><IMG ALIGN="MIDDLE" SRC="Yes.gif" /></xsl:when>
    <xsl:otherwise></xsl:otherwise>
  </xsl:choose>
</xsl:template>

</xsl:stylesheet>
