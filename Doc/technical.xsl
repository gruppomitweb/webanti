<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">

<xsl:template match="/">
  <HTML>
  <BODY BGCOLOR="#FFFFFF">
  <P ALIGN="CENTER">
    <FONT COLOR="#000080" SIZE="6"><B><xsl:value-of select="//Title" /></B></FONT>
  </P>
  <TABLE ALIGN="CENTER" BORDER="0" CELLPADDING="4" CELLSPACING="0">
    <TR><TD COLSPAN="8" HEIGHT="30"></TD></TR>               <!-- RIGA SPAZIATRICE -->
    <TR>
      <xsl:if match=".[Codify/Note!='']">
        <TD COLSPAN="8" ALIGN="LEFT" STYLE="font-size:11pt; color:black;color: black; background-color:#F5F5F5; BORDER-TOP:1 SOLID #000000; BORDER-BOTTOM:1 SOLID #000000;BORDER-RIGHT:1 SOLID #000000;BORDER-LEFT:1 SOLID #000000;">
          <xsl:value-of select="Codify/Note"/>
        </TD>
      </xsl:if>
    </TR>
    <TR><TD COLSPAN="8" HEIGHT="30"></TD></TR>               <!-- RIGA SPAZIATRICE -->
    <TR BGCOLOR="#6495ED">
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Title</B></FONT></TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Template</B></FONT></TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Author</B></FONT></TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>User</B></FONT></TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Version</B></FONT></TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Created</B></FONT></TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Revised</B></FONT></TD>
    </TR>
    <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//Name!='']">&#160;<xsl:value-of select="//Name"/></xsl:when>
            <xsl:when match=".[//Name='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//Title!='']">&#160;<xsl:value-of select="//Title"/></xsl:when>
            <xsl:when match=".[//Title='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//Template!='']">&#160;<xsl:value-of select="//Template"/></xsl:when>
            <xsl:when match=".[//Template='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//Author!='']">&#160;<xsl:value-of select="//Author"/></xsl:when>
            <xsl:when match=".[//Author='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//User!='']">&#160;<xsl:value-of select="//User"/></xsl:when>
            <xsl:when match=".[//User='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//Version!='']">&#160;<xsl:value-of select="//Version"/></xsl:when>
            <xsl:when match=".[//Version='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//Created!='']">&#160;<xsl:value-of select="//Created"/></xsl:when>
            <xsl:when match=".[//Created='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
      <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
        <FONT SIZE="2">
          <xsl:choose>
            <xsl:when match=".[//Lastrevision!='']">&#160;<xsl:value-of select="//Lastrevision"/></xsl:when>
            <xsl:when match=".[//Lastrevision='']">&#160;N/A</xsl:when>
          </xsl:choose>
        </FONT>
      </TD>
    </TR>
    <TR><TD COLSPAN="8" HEIGHT="30"></TD></TR>   <!-- RIGA SPAZIATRICE -->

       <!-- **At end Action : testa il nome dell'entita che vieni chiamata alla chisura della dlg per avere la certezza che sia presente ** -->

    <xsl:if match=".[Codify/AtEndAction/EntityName!='']">
    <TR>
      <TR><TD COLSPAN="4" ALIGN="CENTER"><FONT COLOR="DARKBLUE" SIZE="4"><B>At end Action</B></FONT></TD></TR>
      <TR BGCOLOR="#6495ED">
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Entity Type</B></FONT></TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Entity Name</B></FONT></TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Entity Open On</B></FONT></TD>

        <xsl:choose>
          <xsl:when match=".[//AtEndAction/EntityParam!='']">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Entity Open Mode</B></FONT></TD>
          </xsl:when>
          <xsl:otherwise>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Entity Open Mode</B></FONT></TD>
          </xsl:otherwise>
        </xsl:choose>

        <xsl:if match=".[//AtEndAction/EntityParam!='']">
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Entity Parameters</B></FONT></TD>
        </xsl:if>
      </TR>

      <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;"><xsl:value-of select="//EntityType"/></TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;"><xsl:value-of select="//EntityName"/></TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;"><xsl:value-of select="//EntityOpenOn"/></TD>
        <xsl:choose>
          <xsl:when match=".[//AtEndAction/EntityParam!='']">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;"><xsl:value-of select="//EntityOpenMode"/></TD>
          </xsl:when>
          <xsl:otherwise>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><xsl:value-of select="//EntityOpenMode"/></TD>
          </xsl:otherwise>
        </xsl:choose>

        <xsl:if match=".[//AtEndAction/EntityParam!='']">
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
            <xsl:for-each select="//AtEndAction/EntityParam">
              <xsl:value-of select="."/>;
            </xsl:for-each>
          </TD>
        </xsl:if>

<!--    Non cancellare
        <xsl:if match=".[//AtEndAction/OpenOnFrame!='']">
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
            <xsl:value-of select="//OpenOnFrame"/>
          </TD>
        </xsl:if>
-->
      </TR>
    </TR>
    </xsl:if>
  </TABLE>


  <TABLE BORDER="0" ALIGN="CENTER" WIDTH="100%" CELLPADDING="4" CELLSPACING="0" ID="TblPageIndex">
    <TR>
      <xsl:for-each select="//Pag">
        <TD WIDTH="20%" VALIGN="TOP">
          <TABLE BORDER="0"  WIDTH="50%" ALIGN="CENTER">
            <TR>
              <TD ALIGN="CENTER">
                <FONT SIZE="2">
                  <A><xsl:attribute name="HREF">#Pag<xsl:value-of select="@number" /></xsl:attribute>
                    Page <xsl:value-of select="@number"/>
                  </A>
                </FONT>
              </TD>
            </TR>
            <TR><TD ALIGN="CENTER"><FONT SIZE="2"><B><xsl:value-of select="Title"/></B></FONT></TD></TR>
          </TABLE>
        </TD>
          <xsl:if expr="(childNumber(this)%3)==0">
            <TR/>
          </xsl:if>
      </xsl:for-each>
    </TR>
  </TABLE>

  <xsl:apply-templates select="//Pag"/>

  </BODY>
  </HTML>
</xsl:template>

<!-- ******** Gestione dell' immagine delle maschere e delle aree linkate ai vari oggetti contenuti  -->

<xsl:template match="Pag">
  <P>
  <TABLE BORDER="0" ALIGN="CENTER">
    <TR>
      <TABLE BORDER="0" WIDTH="100%" ALIGN="CENTER">
        <TR>
          <TD BGCOLOR="#B0C4DE" ALIGN="CENTER">
            <FONT COLOR="#000080" SIZE="4">
              <A><xsl:attribute name="NAME">Pag<xsl:value-of select="@number" /></xsl:attribute>
                <xsl:choose>
                  <xsl:when match=".[Title!='']"><B><xsl:value-of select="Title"/></B></xsl:when>
                  <xsl:otherwise><B>Page <xsl:value-of select="@number"/></B></xsl:otherwise>
                </xsl:choose>
              </A>
            </FONT>
          </TD>
        </TR>
        <TR>
          <TD>&#160;</TD>
        </TR>
      </TABLE>


     <TABLE  ALIGN="CENTER" WIDTH="80%" BORDER="0" CELLPADDING="0" CELLSPACING="0">
       <!-- ************** Visualizzazione delle note di pagina solo se presenti *******************-->

       <xsl:if match=".[Note!='']">
         <TR>
           <TD ALIGN="LEFT" STYLE="font-size:10pt; font-style:oblique; color:black; background-color:#DCDCDC; BORDER-BOTTOM: 1 SOLID #000000;  BORDER-TOP: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
             <xsl:value-of select="Note"/>
           </TD>
         </TR>
       </xsl:if>
     </TABLE>

     <TD ALIGN="MIDDLE">
       <MAP><xsl:attribute name="NAME">Pag<xsl:value-of select="@number"/></xsl:attribute>
         <xsl:for-each select="Item">
           <AREA>
             <xsl:attribute name="HREF">#<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
             <xsl:attribute name="SHAPE">RECT</xsl:attribute>
             <xsl:attribute name="COORDS">
             <xsl:value-of select="@x1"/>,<xsl:value-of select="@y1"/>,<xsl:value-of select="@x2"/>,<xsl:value-of select="@y2"/>
             </xsl:attribute>
             <xsl:attribute name="ALT">Go to <xsl:value-of select="@type"/> '<xsl:value-of select="Name"/>'</xsl:attribute>
           </AREA>
         </xsl:for-each>
       </MAP>
       <IMG>
         <xsl:attribute name="BORDER">0</xsl:attribute>
         <xsl:attribute name="SRC"><xsl:value-of select="JPG"/>.jpg</xsl:attribute>
         <xsl:attribute name="ALIGN">MIDDLE</xsl:attribute>
         <xsl:attribute name="USEMAP">#Pag<xsl:value-of select="@number"/></xsl:attribute>
       </IMG>
     </TD>
    </TR>
  </TABLE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='campo']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='variabile']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='stringa']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='bottone']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='calcolo']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='link_pc']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='oggetto']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='immagine']"/></BLOCKQUOTE>
  <BLOCKQUOTE><xsl:apply-templates select="Item[@type='espressione']"/></BLOCKQUOTE>
  </P>
</xsl:template>

<!-- **************************** Gestione degli oggetti di tipo 'campo' o 'variabile' *******************************  -->

<xsl:template match="Item[@type='campo' $or$ @type='variabile']">
  <TABLE BORDER="0">
      <TR><TD>
        <TABLE ALIGN="CENTER" BORDER="0" CELLPADDING="4" CELLSPACING="0">
          <CAPTION ALIGN="LEFT">
            <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
              <B><xsl:eval>this.selectSingleNode('Name').text</xsl:eval></B>
            </A>
          </CAPTION>
          <TR BGCOLOR="#6495ED">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Type</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Comment</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Note</B></FONT></TD>
            <xsl:if match=".[Hyperlink!='']">
              <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Hyperlink</B></FONT></TD>
            </xsl:if>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Help</B></FONT></TD>
          </TR>
          <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <xsl:choose>
                <FONT COLOR="RED" SIZE="2">
                  <xsl:when match=".[@type='variabile']">Variable &#160;</xsl:when>
                  <xsl:when match=".[@type='campo']">Field &#160;</xsl:when>
                </FONT>
              </xsl:choose>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Name!='']">
                    &#160;<xsl:value-of select="Name" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
               <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Comment!='']">
                    &#160;<xsl:value-of select="Comment" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Note!='']">
                    &#160;<xsl:value-of select="Note" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <!--** Solo i Filed Writer hanno la possibilita di Hyperlink (Update Row Action) **-->
            <xsl:if match=".[Hyperlink!='']">
              <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
                <FONT SIZE="2">&#160;<xsl:value-of select="Hyperlink" /></FONT>
              </TD>
            </xsl:if>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Help!='']">
                    &#160;<xsl:value-of select="Help" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
          </TR>
        </TABLE>
      </TD></TR>
      <TR>
        <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
          <A><xsl:attribute name="HREF">
            #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
            <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
          </A>
        </TD>
      </TR>
  </TABLE>
</xsl:template>

<!-- **************************** Gestione degli oggetti di tipo 'stringa' *******************************  -->

<xsl:template match="Item[@type='stringa']">
  <TABLE BORDER="0">
    <TR><TD>
      <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0">
        <CAPTION ALIGN="LEFT">
          <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute></A>
          <xsl:choose>
            <xsl:when match=".[Name!='']">
              <B><xsl:eval>this.selectSingleNode('Name').text</xsl:eval></B>
            </xsl:when>
            <xsl:otherwise>
              <B>Empty string with Hyperlink property</B>
            </xsl:otherwise>
          </xsl:choose>
        </CAPTION>
        <TR BGCOLOR="#6495ED">
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Type</B></FONT></TD>
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Hyerlink</B></FONT></TD>
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Hyperlink  Open On</B></FONT></TD>
        </TR>
        <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT COLOR="RED" SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[@type!='']">
                    &#160;String
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Name!='']">
                    &#160;<xsl:value-of select="Name" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>

            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Hyperlink!='']">
                    &#160;<xsl:value-of select="Hyperlink" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><xsl:value-of select="//HyperlinkOpenOn"/></TD>
        </TR>
      </TABLE>
    </TD></TR>
    <TR>
      <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
        <A><xsl:attribute name="HREF">
          #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
          <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
        </A>
      </TD>
    </TR>
  </TABLE>
</xsl:template>

<!-- **************************** Gestione degli oggetti di tipo 'oggetto' *******************************  -->

<xsl:template match="Item[@type='oggetto']">
  <TABLE BORDER="0">
      <TR><TD>
        <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0">
          <CAPTION ALIGN="LEFT">
            <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
              <B><xsl:eval>this.selectSingleNode('Name').text</xsl:eval></B>
            </A>
          </CAPTION>
          <TR BGCOLOR="#6495ED">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Comment</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Class</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Bitmap</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Property</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Ref</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Note</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Help</B></FONT></TD>
          </TR>
          <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Name!='']">
                    &#160;<xsl:value-of select="Name" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Comment!='']">
                    &#160;<xsl:value-of select="Comment" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Class!='']">
                    &#160;<xsl:value-of select="Class" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Bitmap!='']">
                    &#160;<xsl:value-of select="Bitmap" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Property!='']">
                    &#160;<xsl:value-of select="Property" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Ref!='']">
                    &#160;<xsl:value-of select="Ref" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Note!='']">
                    &#160;<xsl:value-of select="Note" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Help!='']">
                    &#160;<xsl:value-of select="Help" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
          </TR>
        </TABLE>
      </TD></TR>
      <TR>
        <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
          <A><xsl:attribute name="HREF">
            #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
            <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
          </A>
        </TD>
      </TR>
  </TABLE>
</xsl:template>


<!-- **************************** Gestione degli oggetti di tipo 'Link_pc' *******************************  -->

<xsl:template match="Item[@type='link_pc']">
  <TABLE BORDER="0">
      <TR><TD>
        <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0">
          <CAPTION ALIGN="LEFT">
            <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
              <B><xsl:eval>this.selectSingleNode('Name').text</xsl:eval></B>
            </A>
          </CAPTION>
          <TR BGCOLOR="#6495ED">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Edit</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Program</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Note</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Help</B></FONT></TD>
          </TR>
          <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">&#160;<xsl:value-of select="Name" /></TD>
            <xsl:choose>
              <xsl:when match=".[Edit='E']"><TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">Edit</TD></xsl:when>
              <xsl:when match=".[Edit='P']"><TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">Paint</TD></xsl:when>
              <xsl:when match=".[Edit='N']"><TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">Hide/No</TD></xsl:when>
            </xsl:choose>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Program!='']">
                    &#160;<xsl:value-of select="Program" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Note!='']">
                    &#160;<xsl:value-of select="Note" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Help!='']">
                    &#160;<xsl:value-of select="Help" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
          </TR>
        </TABLE>
      </TD></TR>
      <TR>
        <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
          <A><xsl:attribute name="HREF">
            #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
            <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
          </A>
        </TD>
      </TR>
  </TABLE>
</xsl:template>

<!-- **************************** Gestione degli oggetti di tipo 'calcolo' *******************************  -->

<xsl:template match="Item[@type='calcolo']">

  <xsl:if expr="childNumber(this)==1">                       <!-- identifica il I&#248 elemento -->
    <FONT SIZE="4" COLOR="#FFFFFF"><SPAN STYLE="background-color: #000080"><B>CALC OBJECTS:</B></SPAN></FONT>
  </xsl:if>

  <TABLE BORDER="0">
    <TR><TD>
      <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0">
        <CAPTION ALIGN="LEFT">
          <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
            <B><xsl:eval>this.selectSingleNode('Name').text</xsl:eval></B>
          </A>
        </CAPTION>
        <TR BGCOLOR="#6495ED">
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>

                                             <!--**** Questi elementi possono essere ripetuti (ROUTINE) ****-->

          <xsl:for-each select="Calc_routine">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Routine</B></FONT></TD>
          </xsl:for-each>

          <xsl:if match=".[Param!='']">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Routine Parameters</B></FONT></TD>
          </xsl:if>
                                             <!--**** Questi elementi possono essere ripetuti (VARIABLE) ****-->


          <xsl:if match=".[Calc_var!='']">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Variable</B></FONT></TD>
          </xsl:if>

          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Note</B></FONT></TD>
        </TR>

        <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;"><FONT SIZE="2">&#160;<xsl:value-of select="Name" /></FONT></TD>

          <xsl:for-each select="Calc_routine">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;"><FONT SIZE="2">&#160;<xsl:value-of select="." /></FONT></TD>
          </xsl:for-each>

          <xsl:if match=".[Param!='']">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:for-each select="Param">
                  <xsl:value-of select="."/>;
                </xsl:for-each>
              </FONT>
            </TD>
          </xsl:if>

          <xsl:if match=".[Calc_var!='']">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:for-each select="Calc_var">
                  <xsl:value-of select="." />;
                </xsl:for-each>
              </FONT>
            </TD>
          </xsl:if>

          <TD ALIGN="LEFT" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
            <FONT SIZE="2">
              <xsl:choose>
                <xsl:when match=".[Note!='']">
                  &#160;<xsl:value-of select="Note" />
                </xsl:when>
                <xsl:otherwise>&#160;N/A</xsl:otherwise>
              </xsl:choose>
            </FONT>
          </TD>

          <!--<TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT SIZE="2">&#160;<xsl:value-of select="Help" /></FONT></TD> x il momento non presente-->
        </TR>
      </TABLE>
    </TD></TR>
    <TR>
      <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
        <A><xsl:attribute name="HREF">
          #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
          <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
        </A>
      </TD>
    </TR>
  </TABLE>

</xsl:template>

<!-- **************************** Gestione degli oggetti di tipo 'bottone' *******************************  -->

<xsl:template match="Item[@type='bottone']">
  <xsl:if expr="childNumber(this)==1">                       <!-- identifica il I&#248 elemento -->
    <FONT SIZE="4" COLOR="#FFFFFF"><SPAN STYLE="background-color: #000080"><B>BUTTONS(S):</B></SPAN></FONT>
  </xsl:if>
  <TABLE BORDER="0">
    <TR><TD>
      <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0">
      <CAPTION ALIGN="LEFT">
        <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
          <B><xsl:eval>this.selectSingleNode('Name').text</xsl:eval></B>
        </A>
      </CAPTION>
      <TR BGCOLOR="#6495ED">
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Bitmap</B></FONT></TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Execute</B></FONT></TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Help</B></FONT></TD>
      </TR>
      <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
          <FONT SIZE="2">
            <xsl:choose>
              <xsl:when match=".[Name!='']">
                &#160;<xsl:value-of select="Name" />
              </xsl:when>
              <xsl:otherwise>&#160;N/A</xsl:otherwise>
            </xsl:choose>
          </FONT>
        </TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
          <FONT SIZE="2">
            <xsl:choose>
              <xsl:when match=".[Bitmap!='']">
                &#160;<xsl:value-of select="Bitmap" />
              </xsl:when>
              <xsl:otherwise>&#160;N/A</xsl:otherwise>
            </xsl:choose>
          </FONT>
        </TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
          <FONT SIZE="2">
            <xsl:choose>
              <xsl:when match=".[Execute!='']">
                &#160;<xsl:value-of select="Execute" />
              </xsl:when>
              <xsl:otherwise>&#160;N/A</xsl:otherwise>
            </xsl:choose>
          </FONT>
        </TD>
        <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
          <FONT SIZE="2">
            <xsl:choose>
              <xsl:when match=".[Help!='']">
                &#160;<xsl:value-of select="Help" />
              </xsl:when>
              <xsl:otherwise>&#160;N/A</xsl:otherwise>
            </xsl:choose>
          </FONT>
        </TD>
      </TR>
      </TABLE>
    </TD></TR>
    <TR>
      <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
        <A><xsl:attribute name="HREF">
          #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
          <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
        </A>
      </TD>
    </TR>
  </TABLE>

</xsl:template>

<!-- **************************** Gestione degli oggetti di tipo 'immagine' *******************************  -->
<xsl:template match="Item[@type='immagine']">
  <TABLE BORDER="0">
    <TR>
      <TD>
        <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0">
          <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
            <B>Immagine</B>
          </A>
          <TR BGCOLOR="#6495ED">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name-Path</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Hyperlink</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Hyerlink Open On</B></FONT></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Help</B></FONT></TD>
          </TR>
          <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Name!='']">
                    &#160;<xsl:value-of select="Name" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Hyperlink!='']">
                    &#160;<xsl:value-of select="Hyperlink" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;"><xsl:value-of select="//HyperlinkOpenOn"/></TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Comment!='']">
                    &#160;<xsl:value-of select="Comment" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
          </TR>
        </TABLE>
      </TD>
    </TR>
    <TR>
      <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
        <A><xsl:attribute name="HREF">
          #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
          <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
        </A>
      </TD>
    </TR>
  </TABLE>
</xsl:template>

<!-- **************************** Gestione degli oggetti di espressione c_' *******************************  -->
<xsl:template match="Item[@type='espressione']">
  <TABLE BORDER="0">
    <TR><TD>
      <TABLE BORDER="0" CELLPADDING="4" CELLSPACING="0">
        <CAPTION ALIGN="LEFT">
          <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute></A>
          <xsl:choose>
            <xsl:when match=".[Name!='']">
              <B><xsl:eval>this.selectSingleNode('Name').text</xsl:eval></B>
            </xsl:when>
            <xsl:otherwise>
              <B>Empty string with Hyperlink property</B>
            </xsl:otherwise>
          </xsl:choose>
        </CAPTION>
        <TR BGCOLOR="#6495ED">
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Type</B></FONT></TD>
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Name</B></FONT></TD>
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Hyerlink</B></FONT></TD>
          <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-TOP: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><FONT COLOR="WHITE" SIZE="3"><B>Hyperlink  Open On</B></FONT></TD>
        </TR>
        <TR BGCOLOR="#F5F5F5" BORDERCOLOR="#000000">
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT COLOR="RED" SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[@type!='']">
                    &#160;String
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Name!='']">
                    &#160;<xsl:value-of select="Name" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>

            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000;">
              <FONT SIZE="2">
                <xsl:choose>
                  <xsl:when match=".[Hyperlink!='']">
                    &#160;<xsl:value-of select="Hyperlink" />
                  </xsl:when>
                  <xsl:otherwise>&#160;N/A</xsl:otherwise>
                </xsl:choose>
              </FONT>
            </TD>
            <TD ALIGN="CENTER" STYLE="BORDER-BOTTOM: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><xsl:value-of select="//HyperlinkOpenOn"/></TD>
        </TR>
      </TABLE>
    </TD></TR>
    <TR>
      <TD ROWSPAN="2" ALIGN="RIGHT" VALIGN="MIDDLE">
        <A><xsl:attribute name="HREF">
          #<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
          <FONT SIZE="2">Back to <B><xsl:eval>this.parentNode.selectSingleNode("Title").text</xsl:eval></B></FONT>
        </A>
      </TD>
    </TR>
  </TABLE>
</xsl:template>

<!--************** Script JScript **************-->

<xsl:script>
  <![CDATA[
    var CurrNode;                //variabile globale
    function Trim(strToTrim) {
      re = / /g;
      return(strToTrim.replace(re, ""));
    }
    function CacheNode(objNode) {
      CurrNode=objNode
    }
  ]]>
</xsl:script>

</xsl:stylesheet>

