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

<!-- Gestione del tag "Code" -->

<xsl:template match="Code">
  <P></P>
  <TABLE WIDTH="100%">
    <TR><!-- Row 1 -->
       <TD STYLE="font-size:14pt; color:white; background-color:#888888">
         <xsl:value-of select="@title"/>
       </TD>
  </TR>
  <TR><!-- Row 2 -->
     <TD>
     &#160;
     </TD>
  </TR>
  <TR><!-- Row 3 -->
     <TD STYLE="font-family: Courier New">
     <xsl:apply-templates select="text()|*"/>
     </TD>
  </TR>
  <TR><!-- Row 4 -->
     <TD STYLE="border-bottom: 2 SOLID #888888;">
     &#160;
     </TD>
  </TR>
</TABLE>
</xsl:template>

<!-- Gestione del tag "Linea di codice" -->

<xsl:template match="LineCode">
  <P><SPAN STYLE="font-family: Courier New">
  <xsl:value-of />
  </SPAN></P>
</xsl:template>

<!-- Gestione del tag "Example" -->

<xsl:template match="Example">
  <P></P>
  <TABLE WIDTH="100%">
    <TR><!-- Row 1 -->
       <TD STYLE="font-size:14pt; color:red; font-style:italic; font-weight:bold;">
         <xsl:value-of select="@title"/>
       </TD>
  </TR>
  <TR><!-- Row 2 -->
     <TD>
     &#160;
     </TD>
  </TR>
  <TR><!-- Row 3 -->
     <TD>
     <xsl:apply-templates select="text()|*"/>
     </TD>
  </TR>
  <TR><!-- Row 4 -->
     <TD STYLE="font-family: Courier New; border-bottom: 2 SOLID red;">
     &#160;
     </TD>
  </TR>
</TABLE>
</xsl:template>


<!-- Gestione del tag "Notes" -->

<xsl:template match="Notes">
  <P></P>
  <TABLE BORDER="2" STYLE="Border-color:yellow; border-width:100%;">
    <TR><!-- Row 1 -->
       <TD STYLE="font-size:14pt; background-color:yellow;">
         <xsl:value-of select="@title"/>
       </TD>
  </TR>
  <TR><!-- Row 2 -->
     <TD>
     <xsl:apply-templates select="text()|*"/>
     </TD>
  </TR>
</TABLE>
</xsl:template>

<!-- Gestione del tag "Image" -->
<!-- L'allineamento al centro, perche non funziona???-->
<xsl:template match="Image">
  <P></P>
   <IMG>
     <xsl:attribute name="BORDER">0</xsl:attribute>
     <xsl:attribute name="SRC"><xsl:value-of select="@file"/></xsl:attribute>
     <xsl:attribute name="ALIGN">MIDDLE</xsl:attribute>
   </IMG>
   <P><SPAN STYLE="font-size:8pt; align:center;">
   <xsl:value-of select="@caption"/>
   </SPAN></P>
</xsl:template>


<!-- Gestione del tag "File": link a un file XML o a un documento HTML ... -->

<xsl:template match="File">
  <A>
    <xsl:attribute name="HREF"><xsl:value-of select="@src"/></xsl:attribute>
    <xsl:eval>this.firstChild.text</xsl:eval>
  </A>
  <xsl:if expr="NodeExistsAndNotEmpty(selectSingleNode('Note'))==true">
    <DD><xsl:apply-templates select="Note"/></DD>
  </xsl:if>
</xsl:template>


<!-- Gestione del tag "Include": -->

<xsl:template match="Include">
  <DL STYLE="margin-top:40; margin-bottom:40; margin-left:30; margin-right;30;">
    <xsl:for-each select="File">
      <DT STYLE="margin-top:10;"><xsl:apply-templates select="."/></DT>
    </xsl:for-each>
  </DL>
</xsl:template>

<xsl:template match="/">
  <HTML>
  <HEAD>
  <STYLE>
     BODY  {font-family:Times New Roman; font-size:10pt; color:black; background:white; margin:20px;}
     TABLE {font-family:Times New Roman; font-size:10pt; color:black; background:white}
    A:hover {color:red;}
  </STYLE>
  </HEAD>
  <BODY BGCOLOR="#FFFFFF">
  <IMG SRC="Backto.gif" STYLE="{display:none}"></IMG>
  <P ALIGN="CENTER">
    <FONT COLOR="#000080" SIZE="6">
      <B><xsl:value-of select="//Title" /></B>
    </FONT>
  </P>

  <!-- ************** Visualizzazione delle note generali di codifica solo se presenti *******************-->

  <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('Note'))==true">
    <TABLE BORDER="0" WIDTH="80%" CELLPADDING="3" CELLSPACING="3" ALIGN="CENTER">
      <TR><TD HEIGHT="20">&#160;</TD></TR>   <!-- RIGA SPAZIATRICE -->
      <TR>
        <xsl:if match=".[Codify/Note!='']">
          <TD ALIGN="LEFT" STYLE="font-size:11pt; color:black; background-color:#F5F5F5; BORDER-TOP:1 SOLID #000000; BORDER-BOTTOM:1 SOLID #000000;BORDER-RIGHT:1 SOLID #000000;BORDER-LEFT:1 SOLID #000000;">
            <xsl:apply-templates select="Codify/Note"/>
          </TD>
        </xsl:if>
      </TR>
      <TR><TD HEIGHT="30">&#160;</TD></TR>   <!-- RIGA SPAZIATRICE -->
    </TABLE>
  </xsl:if>

  <!-- ************** Visualizzazione dei file di include solo se presenti *******************-->

  <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('Include'))==true">
    <xsl:apply-templates select="Codify/Include"/>
  </xsl:if>

  <!-- ************ Indice delle pagine strutturato su 3 max pagine per riga ***********************-->

  <TABLE BORDER="0" WIDTH="100%" CELLPADDING="3" CELLSPACING="3" ALIGN="CENTER" ID="TblPageIndex">
    <xsl:for-each select="//Pag">
      <TD WIDTH="20%" VALIGN="TOP">
        <TABLE BORDER="0" WIDTH="50%" ALIGN="LEFT">
          <TR><TD ALIGN="CENTER" >
            <A><xsl:attribute name="HREF">#Pag<xsl:value-of select="@number" /></xsl:attribute>
              Page <xsl:value-of select="@number"/>
            </A>
          </TD></TR>
          <TR><TD ALIGN="CENTER"><B><xsl:value-of select="Title"/></B></TD></TR>
        </TABLE>
      </TD>
      <xsl:if expr="(childNumber(this)%3)==0">
        <TR/>
      </xsl:if>
    </xsl:for-each>
  </TABLE>
  <xsl:apply-templates select="//Pag"/>
  </BODY>
  </HTML>
</xsl:template>

<!-- ******** Gestione dell' immagine delle maschere e delle aree linkate ai vari oggetti contenuti  -->

<xsl:template match="Pag">
  <P>
  <A><xsl:attribute name="NAME">Pag<xsl:value-of select="@number" /></xsl:attribute>
  <TABLE BORDER="0" WIDTH="100%" ALIGN="CENTER">
    <TR>
      <TD BGCOLOR="#B0C4DE" ALIGN="CENTER">
        <FONT COLOR="#000080" SIZE="4">
          <xsl:choose>
            <xsl:when match=".[Title!='']"><B><xsl:value-of select="Title"/></B></xsl:when>
            <xsl:otherwise><B>Page <xsl:value-of select="@number"/></B></xsl:otherwise>
          </xsl:choose>
        </FONT>
      </TD>
    </TR>
    <TR>
      <TD>&#160;</TD>
    </TR>
  </TABLE>
  </A>

  <!-- ************** Visualizzazione delle note di pagina solo se presenti *******************-->

  <xsl:if match=".[Note!='']">
    <TABLE BORDER="0" WIDTH="80%" CELLPADDING="3" CELLSPACING="3" ALIGN="CENTER">
      <TR>
        <xsl:if match=".[Note!='']">
          <TD STYLE="font-size:10pt; font-style:oblique; color:black; background-color:#DCDCDC; BORDER-BOTTOM: 1 SOLID #000000;  BORDER-TOP: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;">
            <xsl:apply-templates select="Note"/>
          </TD>
        </xsl:if>
      </TR>
      <TR><TD HEIGHT="30">&#160;</TD></TR>   <!-- RIGA SPAZIATRICE -->
    </TABLE>
  </xsl:if>

  <TABLE BORDER="0" ALIGN="CENTER" WIDTH="100%">
    <TR>
      <TD ALIGN="MIDDLE">
        <MAP><xsl:attribute name="NAME">Pag<xsl:value-of select="@number"/></xsl:attribute>
          <xsl:for-each select="Item">
            <AREA>
              <xsl:attribute name="HREF">
                #<xsl:eval>
                'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)
                </xsl:eval>
              </xsl:attribute>
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
  <BLOCKQUOTE><xsl:apply-templates select="Item"/></BLOCKQUOTE>
  </P>
</xsl:template>

<!-- ************ Gestione di tutti gli oggetti nell'ordine in cui si presentano nel file XML ****************  -->

<xsl:template match="Item">
 <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="4" BORDERCOLORLIGHT="#007CF9" BORDERCOLORDARK="#000080">
   <TR>
     <TD VALIGN="MIDDLE" ALIGN="LEFT" WIDTH="30" HEIGHT="30">
       <A><xsl:attribute name="HREF">#<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute></A>
     </TD>

      <!--NOTE: Parte che inserisce i nomi degli item -->

     <TD VALIGN="MIDDLE" ALIGN="LEFT">
       <A><xsl:attribute name="NAME"><xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text+'_'+Trim(this.selectSingleNode('Name').text)</xsl:eval></xsl:attribute>
         <FONT COLOR="BLACK" SIZE="3"><B>
           <xsl:choose>
             <xsl:when match=".[Comment!='']">
               <xsl:value-of select="Comment" />
             </xsl:when>
             <xsl:when match=".[@type='stringa']">
                <xsl:choose>
                  <xsl:when match=".[Name!='']">
                    <xsl:value-of select="Name" />
                  </xsl:when>
                  <xsl:otherwise>
                    <B>Empty string with Hyperlink property</B>
                  </xsl:otherwise>
                </xsl:choose>
             </xsl:when>
             <xsl:otherwise>
               <xsl:value-of select="Name" />
             </xsl:otherwise>
           </xsl:choose>
         </B></FONT>
       </A>
     </TD>
     <TD WIDTH="30">&#160;</TD>
     <TD VALIGN="MIDDLE" ALIGN="LEFT" WIDTH="30">&#160;
       <xsl:if match=".[Key='key1']">
         <IMG><xsl:attribute name="SRC">Key.gif</xsl:attribute><xsl:attribute name="ALIGN">MIDDLE</xsl:attribute></IMG>
       </xsl:if>
     </TD>
     <TD VALIGN="MIDDLE" ALIGN="LEFT" WIDTH="30">&#160;
       <xsl:if match=".[Zoom]">
         <IMG><xsl:attribute name="SRC">Zoom.gif</xsl:attribute><xsl:attribute name="ALIGN">MIDDLE</xsl:attribute></IMG>
       </xsl:if>
     </TD>
     <TD VALIGN="MIDDLE" ALIGN="LEFT" WIDTH="30">&#160;
       <xsl:if match=".[Obligatory='TRUE']">
         <IMG><xsl:attribute name="SRC">Stop.gif</xsl:attribute><xsl:attribute name="ALIGN">MIDDLE</xsl:attribute></IMG>
       </xsl:if>
     </TD>
   </TR>
   <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Note'))==true">
   <TR>
     <BLOCKQUOTE>
       <TR>
         <TD>&#160;</TD>
         <TD ALIGN="CENTER" VALING="MIDDLE" BGCOLOR="#6495ED"><FONT COLOR="WHITE" SIZE="2"><B>Note</B></FONT></TD>
       </TR>
       <TR>
         <TD VALIGN="MIDDLE" ALIGN="LEFT" WIDTH="30" HEIGHT="30"></TD>
         <TD ALIGN="LEFT" VALING="MIDDLE" BGCOLOR="#F5F5F5"><xsl:value-of select="Note" /></TD>
        </TR>
     </BLOCKQUOTE>
   </TR>
   </xsl:if>
   <TR>
     <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Class'))==true | NodeExistsAndNotEmpty(this.selectSingleNode('Bitmap'))==true | NodeExistsAndNotEmpty(this.selectSingleNode('Help'))==true | NodeExistsAndNotEmpty(this.selectSingleNode('Hyperlink'))==true" >
     <BLOCKQUOTE>
       <TR>
         <TD>&#160;</TD>
         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Class'))==true">
           <TD ALIGN="CENTER" VALING="MIDDLE" BGCOLOR="#6495ED"><FONT COLOR="WHITE" SIZE="2">&#160;<B>Class</B>&#160;</FONT></TD>
         </xsl:if>
         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Bitmap'))==true">
           <TD ALIGN="CENTER" VALING="MIDDLE" BGCOLOR="#6495ED"><FONT COLOR="WHITE" SIZE="2">&#160;<B>Bitmap</B>&#160;</FONT></TD>
         </xsl:if>

         <!--** Per l'immagine al posto di help ci va comment nel tooltip (vedi sotto)... ma non si riesce a fare un OR **-->
         <xsl:if match="Item[@type='immagine']">
           <TD ALIGN="CENTER" VALING="MIDDLE" BGCOLOR="#6495ED"><FONT COLOR="WHITE" SIZE="2">&#160;<B>Tooltip</B>&#160;</FONT></TD>
         </xsl:if>
         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Help'))==true">
           <TD ALIGN="CENTER" VALING="MIDDLE" BGCOLOR="#6495ED"><FONT COLOR="WHITE" SIZE="2">&#160;<B>Tooltip</B>&#160;</FONT></TD>
         </xsl:if>

         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Hyperlink'))==true">
           <TD ALIGN="CENTER" VALING="MIDDLE" BGCOLOR="#6495ED"><FONT COLOR="WHITE" SIZE="2">&#160;<B>HyperLink</B>&#160;</FONT></TD>
         </xsl:if>
       </TR>
       <TR>
         <TD>&#160;</TD>
         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Class'))==true">
           <TD ALIGN="LEFT" VALING="MIDDLE" BGCOLOR="#F5F5F5">&#160;<xsl:value-of select="Class" />&#160;</TD>
         </xsl:if>
         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Bitmap'))==true">
           <TD ALIGN="LEFT" VALING="MIDDLE" BGCOLOR="#F5F5F5">&#160;<xsl:value-of select="Bitmap" />&#160;</TD>
         </xsl:if>

         <xsl:if match="Item[@type='immagine']">
           <TD ALIGN="LEFT" VALING="MIDDLE" BGCOLOR="#F5F5F5">&#160;<xsl:value-of select="Comment" />&#160;</TD>
         </xsl:if>
         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Help'))==true">
           <TD ALIGN="LEFT" VALING="MIDDLE" BGCOLOR="#F5F5F5">&#160;<xsl:value-of select="Help" />&#160;</TD>
         </xsl:if>

         <xsl:if expr="NodeExistsAndNotEmpty(this.selectSingleNode('Hyperlink'))==true">
           <TD ALIGN="LEFT" VALING="MIDDLE" BGCOLOR="#F5F5F5">&#160;<xsl:value-of select="Hyperlink" />&#160;</TD>
         </xsl:if>
       </TR>
     </BLOCKQUOTE>
     </xsl:if>
   </TR>
   <TR>
     <TD>&#160;</TD>
     <TD COLSPAN="4" ALIGN="RIGHT">
        <A><xsl:attribute name="HREF">#<xsl:eval>'Pag'+this.parentNode.attributes.getNamedItem('number').text</xsl:eval></xsl:attribute>
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

</xsl:stylesheet>

