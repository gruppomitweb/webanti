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
     .Item {font-family:Tahoma; font-size:8pt;}
     BODY  {font-family:Times New Roman; font-size:10pt; color:black; background:white; margin:20px;}
     TABLE {font-family:Times New Roman; font-size:10pt; color:black; background:white}
     .FIELD_TABLE {border: 1px solid;  margin-top:5; margin-bottom:5; background:moccasin}
     .FIELD_CELL {padding-left:20;}
     .RESERVED {font-weight:normal; font-style:italic;}
     .ERROR_MSG {color:red;font-weight:normal; font-style:italic;}
     A:hover {color:red;}
     .BATCH_LINK:hover {color:DARKORANGE;}
     .BATCH_LINK {color:DARKSLATEBLUE; font-weight:bold; text-decoration=none;}
     .PLUS { }
     .CP_Notes {background:lavender; font-family:Times New Roman; font-style:normal; margin-left:130; margin-right:130;margin-bottom:40;}
     .Page_Notes {font-size:10pt; font-style:oblique; color:black; background-color:#DCDCDC; BORDER-BOTTOM: 1 SOLID #000000;  BORDER-TOP: 1 SOLID #000000; BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;}
      .Row1 {font-size:9pt;color:white; border-right-width:1; border-right-style:solid; border-right-color:white;
             border-bottom-width:1; border-bottom-style:solid ; border-bottom-color:black;background-color:"#000080"}
      .Row2 {font-size:9pt; border-right-width:1; border-right-style:solid; border-right-color:black; background-color:"#00FFFF"}
  </STYLE>
  <SCRIPT language="JavaScript"><xsl:comment><![CDATA[
    var idNum = 1;
    var uidShow;
    var uidHide;

    function unique(reset) {
      if (reset==true) {
        idNum=1;
        return;
      }
      else
      uidHide="b" + idNum;
      uidShow="a" + idNum++;
      return uidHide;
    }

    function show(s,f) {
      f.style.display="block";
      s.style.display="none";
    }

    function hide(s,f) {
      s.style.display="block";
      f.style.display="none";
    }

    function divShow(display) {
      var d;
      if (display==true)
        d="block";
      else
        d="none";
      document.write(String.fromCharCode(60)+'DIV ID="'+uidShow+'" STYLE="display:'+d+'"'+String.fromCharCode(62));
    }

    function startDivShow() {
      //document.write('<A href="javascript:hide('+uidHide+','+uidShow+')">If '+document.XMLDocument.selectSingleNode("condition").attributes.getNamedItem('value').text+'</A>');
      document.write(String.fromCharCode(60)+'A CLASS="BATCH_LINK" TITLE="Collapse node" href="javascript:hide('+uidHide+','+uidShow+')"'+String.fromCharCode(62));
      document.write('<SPAN CLASS="PLUS">-</SPAN>');
    }

    function divHide(display) {
      var d;
      if (display==true)
        d="block";
      else
        d="none";
      document.write(String.fromCharCode(60)+'DIV ID="'+unique()+'" STYLE="display:'+d+'"'+String.fromCharCode(62));
      document.write(String.fromCharCode(60)+'TABLE WIDTH="100%" CELLPADDING="0" CELLSPACING="0" CLASS="Item"'+String.fromCharCode(62));
      // document.write('<A href="javascript:show('+uidHide+','+uidShow+')">If '+document.XMLDocument.selectSingleNode("condition").attributes.getNamedItem('value').text+'</A>');
      document.write(String.fromCharCode(60)+'A CLASS="BATCH_LINK" TITLE="Expand node" href="javascript:show('+uidHide+','+uidShow+')"'+String.fromCharCode(62));
      document.write('<SPAN CLASS="PLUS">+</SPAN>');
    }

    function endDivHide() {
      document.write(String.fromCharCode(60)+"/A"+String.fromCharCode(62));
      document.write(String.fromCharCode(60)+'/TABLE'+String.fromCharCode(62));
      document.write(String.fromCharCode(60)+'/DIV'+String.fromCharCode(62));
    }

    function endParShow() {
     document.write(String.fromCharCode(60)+"/A"+String.fromCharCode(62));
    }

    function endDivShow() {
      document.write(String.fromCharCode(60)+'/DIV'+String.fromCharCode(62));
    }

   ]]></xsl:comment></SCRIPT>

  </HEAD>
  <BODY BGCOLOR="#FFFFFF">
  <P ALIGN="CENTER"><FONT COLOR="#000080" SIZE="6"><B>
    <xsl:value-of select="//Title" />
  </B></FONT></P>

    <TABLE BORDER="0" WIDTH="100%" CELLSPACING="0" STYLE="margin-top:10;margin-bottom:30">
    <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('Version'))==true">
    <TR><TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Version:</B>
    </TD><TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="//Version" />
    </TD></TR>
    </xsl:if>
    <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('Author'))==true">
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Author:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="//Author" />
      </TD>
    </TR>
    </xsl:if>
    <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('Created'))==true">
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Created:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="//Created" />
      </TD>
    </TR>
    </xsl:if>
    <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('Lastrevision'))==true">
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>Last modify:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="//Lastrevision" />
      </TD>
    </TR>
    </xsl:if>
    <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('User'))==true">
    <TR>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="RIGHT" VALIGN="TOP" HEIGHT="25">
        <B>User:</B>
      </TD>
      <TD WIDTH="50%" COLSPAN="5" ALIGN="LEFT" VALIGN="TOP" >
        <xsl:value-of select="//User" />
      </TD>
    </TR>
    </xsl:if>
    </TABLE>
  <!-- ************** Visualizzazione delle note generali di codifica solo se presenti *******************-->

  <xsl:if expr="NodeExistsAndNotEmpty(documentElement.selectSingleNode('Note'))==true">
    <TABLE BORDER="0" WIDTH="80%" CELLPADDING="3" CELLSPACING="3" ALIGN="CENTER">
      <TR><TD HEIGHT="20">&#160;</TD></TR>   <!-- RIGA SPAZIATRICE -->
      <TR>
        <!--<TD STYLE="BORDER-LEFT: 1 SOLID #000000; BORDER-RIGHT: 1 SOLID #000000;"><xsl:apply-templates select="Routine/Note"/></TD>-->
        <TD COLSPAN="8" ALIGN="LEFT" STYLE="font-size:11pt; color:black;color: black; background-color:#F5F5F5; BORDER-TOP:1 SOLID #000000; BORDER-BOTTOM:1 SOLID #000000;BORDER-RIGHT:1 SOLID #000000;BORDER-LEFT:1 SOLID #000000;">
          <xsl:apply-templates select="Routine/Note"/>
        </TD>
      </TR>
      <TR><TD HEIGHT="30">&#160;</TD></TR>   <!-- RIGA SPAZIATRICE -->
    </TABLE>
  </xsl:if>

  <!-- ************ Indice delle pagine strutturato su 3 max pagine per riga ***********************-->

  <TABLE BORDER="0" WIDTH="100%" CELLPADDING="3" CELLSPACING="3" ALIGN="CENTER" ID="TblPageIndex">
    <xsl:for-each select="//Pag">
      <TD VALIGN="TOP">
        <TABLE BORDER="0" ALIGN="CENTER">
          <TR><TD ALIGN="CENTER" >
            <A><xsl:attribute name="HREF">#Pag<xsl:value-of select="@number" /></xsl:attribute>
              Procedure <xsl:value-of select="@number"/>
            </A>
          </TD></TR>
          <TR><TD ALIGN="CENTER" ><B><xsl:value-of select="Title"/></B></TD></TR>
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
  <A>
    <xsl:attribute name="NAME">Pag<xsl:value-of select="@number" /></xsl:attribute>
  </A>

  <!-- ************** Visualizzazione delle note di pagina solo se presenti *******************-->
    <P STYLE="color:white; font-size:14pt; font-weight: bold; text-align:center; background:#000080; margin-top:40;">
      Procedure <xsl:value-of select="@number"/>
      <xsl:if match=".[Title!='']">
       : <B><xsl:value-of select="Title"/></B>
      </xsl:if>
    </P>
  <xsl:if match=".[Note!='']">
  <DIV CLASS="Page_Notes">
    <xsl:apply-templates select="Note"/>
  </DIV>
  </xsl:if>
  <DIV>
    <TABLE WIDTH="100%" ALIGN="CENTER" CLASS="Item">
      <xsl:apply-templates select="Item"/>
    </TABLE>
  </DIV>
</xsl:template>



<!-- ************ Gestione di tutti gli oggetti nell'ordine in cui si presentano nel file XML ****************  -->


<xsl:template match="Item">
  <TR CLASS="Item">
    <TD STYLE="padding-left:20;">
  <xsl:choose>

<!-- ******** VAR ********  -->
    <xsl:when match=".[@type='var']">
      <xsl:if expr="selectSingleNode('Operation').text=='def'">
        <SPAN CLASS="RESERVED"><xsl:value-of select="@type"/>&#160;</SPAN>
      </xsl:if>

      <xsl:apply-templates select="Text"/>
    </xsl:when>

<!-- ******** EXEC ********  -->

    <xsl:when match=".[@type='exec']">

      <xsl:if expr="selectSingleNode('Check').text!='stm'">
        <SPAN CLASS="RESERVED"><xsl:value-of select="@type"/>&#160;</SPAN>
        <xsl:apply-templates select="Check"/>
      </xsl:if>

      <xsl:apply-templates select="Expression"/>
    </xsl:when>

<!-- ******** CREATE TEMPORARY TABLE ********  -->

    <xsl:when match=".[@type='temptable']">

      <SPAN CLASS="RESERVED">Create temporary table </SPAN>
      <xsl:apply-templates select="TempTable"/>from

       <xsl:if match=".[SelectType='query']">
         QUERY
         <xsl:apply-templates select="TableName"/>
       </xsl:if>
       <xsl:if match=".[SelectType='sql']">
         ( select <xsl:apply-templates select="Field"/>&#160; from
         <xsl:apply-templates select="TableName"/>
         <xsl:if match=".[Where]">
           <xsl:if match=".[Where!='']">
             <BR/>where <xsl:apply-templates select="Where"/>
           </xsl:if>
           <xsl:if match=".[Order!='']">
             order by <xsl:apply-templates select="Order"/>
           </xsl:if>
           <xsl:if match=".[Group!='']">
             group by <xsl:apply-templates select="Group"/>
           </xsl:if>
         </xsl:if>)
       </xsl:if>



      <xsl:apply-templates select="Expression"/>
    </xsl:when>

<!-- ******** DROP TEMPORARY TABLE ********  -->

    <xsl:when match=".[@type='droptemptable']">

      <SPAN CLASS="RESERVED">Drop temporary table</SPAN>
      <xsl:apply-templates select="TempTable"/>
    </xsl:when>

<!-- ******** IF CASE TRY-CATCH ********  -->

    <xsl:when match=".[@type='if' || @type='case'|| @type='try' || @type='while']">

       <SCRIPT LANGUAGE="JavaScript">divHide(false);</SCRIPT>

       <xsl:choose>
         <xsl:when match=".[@type='if']">
           <xsl:eval>'If '+this.selectSingleNode("condition").attributes.getNamedItem("value").text</xsl:eval>
         </xsl:when>
         <xsl:when match=".[@type='case']">
           <xsl:eval>'Case '+this.selectSingleNode("condition").attributes.getNamedItem("value").text</xsl:eval>
         </xsl:when>
         <xsl:when match=".[@type='try']">
           <xsl:eval>'Try '+this.selectSingleNode("condition").attributes.getNamedItem("value").text</xsl:eval>
         </xsl:when>
         <xsl:when match=".[@type='while']">
           <xsl:eval>'While '+this.selectSingleNode("condition").attributes.getNamedItem("value").text</xsl:eval>
         </xsl:when>
       </xsl:choose>

       <SCRIPT LANGUAGE="JavaScript">endDivHide();</SCRIPT>

       <SCRIPT LANGUAGE="JavaScript">divShow(true);</SCRIPT>

       <TABLE WIDTH="100%" CELLPADDING="0" CELLSPACING="0" CLASS="Item">
         <xsl:apply-templates select="condition"/>
         <xsl:if match=".[@type='if'|| @type='case']">
           <xsl:apply-templates select="else"/>
         </xsl:if>
       </TABLE>
       <SPAN CLASS="RESERVED">
       <xsl:choose>
         <xsl:when match=".[@type='if']">
           End If
         </xsl:when>
         <xsl:when match=".[@type='case']">
           End Case
         </xsl:when>
         <xsl:when match=".[@type='try']">
           End Try
         </xsl:when>
         <xsl:when match=".[@type='while']">
           End While
         </xsl:when>
       </xsl:choose>
       </SPAN>
       <SCRIPT LANGUAGE="JavaScript">endDivShow();</SCRIPT>
    </xsl:when>


<!-- ******** BEGIN ********  -->

    <xsl:when match=".[@type='begin']">
       <SCRIPT LANGUAGE="JavaScript">divHide(false);</SCRIPT>
       <xsl:eval>this.selectSingleNode("Comment").text</xsl:eval>
       <SCRIPT LANGUAGE="JavaScript">endDivHide();</SCRIPT>

       <SCRIPT LANGUAGE="JavaScript">
         divShow(true)
         startDivShow();
       </SCRIPT>
       <xsl:eval>this.selectSingleNode("Comment").text</xsl:eval>
       <SCRIPT LANGUAGE="JavaScript">endParShow();</SCRIPT>

       <TABLE WIDTH="100%" CELLPADDING="0" CELLSPACING="0" CLASS="Item">
         <xsl:apply-templates select="condition"/>
       </TABLE>
       <SPAN CLASS="RESERVED">End <xsl:eval>this.selectSingleNode("Comment").text</xsl:eval></SPAN>
       <SCRIPT LANGUAGE="JavaScript">endDivShow();</SCRIPT>

    </xsl:when>

<!-- ******** WRITE READ DELETE INSERT ********  -->

    <xsl:when match=".[@type='write' || @type='read' || @type='delete' || @type='insert']">
       <xsl:if match=".[Type='values' || @type='read' ]">  <!-- Read non ha la proprieta' values -->
       <SCRIPT LANGUAGE="JavaScript">divHide(true);</SCRIPT>
       <xsl:eval>this.selectSingleNode("Text").text</xsl:eval>
       <SCRIPT LANGUAGE="JavaScript">endDivHide();</SCRIPT>

       <SCRIPT LANGUAGE="JavaScript">
         divShow(false)
         startDivShow();
       </SCRIPT>
       <xsl:eval>this.selectSingleNode("Text").text</xsl:eval>
       <SCRIPT LANGUAGE="JavaScript">endParShow();</SCRIPT>

       <TABLE WIDTH="100%" CELLPADDING="0" CELLSPACING="0" CLASS="Item">
         <TR>
           <TD CLASS="FIELD_CELL">
           <TABLE FRAME="border" CELLSPACING="0" CLASS="FIELD_TABLE"><TR></TR>
           <TR>
             <TH CLASS="FIELD_CELL">Key fields</TH><TH CLASS="FIELD_CELL">Key values</TH>
           </TR>
         <xsl:apply-templates select="KeyFields"/>
         </TABLE></TD></TR>
         <FONT CLASS="ERROR_MSG">&#160;&#160;&#160;Error Message: <xsl:apply-templates select="Expression"/></FONT>
         <TR>
           <TD CLASS="FIELD_CELL">
           <TABLE FRAME="border"  CELLSPACING="0" CLASS="FIELD_TABLE"><TR></TR>
             <TR>
             <xsl:if match=".[@type='write']">
               <TH CLASS="FIELD_CELL">Write fields</TH><TH CLASS="FIELD_CELL">Values to write</TH><TH CLASS="FIELD_CELL">Operation</TH>
             </xsl:if>
             <xsl:if match=".[@type='read']">
                <TH CLASS="FIELD_CELL">Read fields</TH><TH CLASS="FIELD_CELL">Into variables</TH>
             </xsl:if>
             </TR>
             <xsl:if match=".[@type='write']">
               <xsl:apply-templates select="WriteFields"/>
             </xsl:if>
             <xsl:if match=".[@type='read']">
               <xsl:apply-templates select="ReadFields"/>
             </xsl:if>

           </TABLE>
         </TD></TR>
       </TABLE>

       <SPAN CLASS="RESERVED">End
         <xsl:if match=".[@type='write']">
           Write
         </xsl:if>
         <xsl:if match=".[@type='insert']">
           Insert
         </xsl:if>
         <xsl:if match=".[@type='delete']">
           Delete
         </xsl:if>
         <xsl:if match=".[@type='read']">
           Read
         </xsl:if>
       </SPAN>
       <SCRIPT LANGUAGE="JavaScript">endDivShow();</SCRIPT>
       </xsl:if>
       <xsl:if match=".[Type!='values']">
         <!-- Distinta delle varie operazioni sul database -->
         <xsl:choose>
           <xsl:when match=".[@type='insert']">
             <SPAN CLASS="RESERVED">Insert into</SPAN>
           </xsl:when>
           <xsl:when match=".[@type='delete']">
             <SPAN CLASS="RESERVED">Delete</SPAN>
           </xsl:when>

           <xsl:when match=".[@type='read']">
             <SPAN CLASS="RESERVED">Read</SPAN>
           </xsl:when>

           <xsl:when match=".[@type='write']">
             <SPAN CLASS="RESERVED">Write</SPAN>
           </xsl:when>
         </xsl:choose>

         <xsl:apply-templates select="TableName"/> from
       </xsl:if>
       <xsl:if match=".[Type='query']">
         QUERY
         <xsl:apply-templates select="SelectTable"/>
       </xsl:if>
       <xsl:if match=".[Type='sql']">
         (select <xsl:apply-templates select="Field"/> from
         <xsl:apply-templates select="SelectTable"/>
         <xsl:if match=".[Where]">
           <xsl:if match=".[Where!='']">
             <BR/>where <xsl:apply-templates select="Where"/>
           </xsl:if>
           <xsl:if match=".[Order!='']">
             order by <xsl:apply-templates select="Order"/>
           </xsl:if>
           <xsl:if match=".[Group!='']">
             group by <xsl:apply-templates select="Group"/>
           </xsl:if>
         </xsl:if>)
       </xsl:if>

    </xsl:when>

<!-- ******** SELECT ********  -->

    <xsl:when match=".[@type='select']">
       <SCRIPT LANGUAGE="JavaScript">divHide(true);</SCRIPT>
       <xsl:eval>this.selectSingleNode("Text").text</xsl:eval>
       <SCRIPT LANGUAGE="JavaScript">endDivHide();</SCRIPT>

       <SCRIPT LANGUAGE="JavaScript">
         divShow(false)
         startDivShow();
       </SCRIPT>
       Select <xsl:apply-templates select="Field"/> from
       <xsl:if match=".[Type!='fltb']">
         QUERY
       </xsl:if>
       <xsl:apply-templates select="TableName"/>
       <xsl:if match=".[Start]">
         <xsl:if match=".[Start!='']">
           ; Start: <xsl:apply-templates select="Start"/>
         </xsl:if>
         <xsl:if match=".[OrderKey!='']">
           ; Order Keys: <xsl:apply-templates select="OrderKey"/>
         </xsl:if>
         <xsl:if match=".[While!='']">
           ;<BR/>While: <xsl:apply-templates select="While"/>
         </xsl:if>
         <xsl:if match=".[Filter!='']">
           ; Filter: <xsl:apply-templates select="Filter"/>
         </xsl:if>
       </xsl:if>
       <xsl:if match=".[Where]">
         <xsl:if match=".[Where!='']">
           <BR/>where <xsl:apply-templates select="Where"/>
         </xsl:if>
         <xsl:if match=".[Order!='']">
           order by <xsl:apply-templates select="Order"/>
         </xsl:if>
         <xsl:if match=".[Group!='']">
           group by <xsl:apply-templates select="Group"/>
         </xsl:if>
       </xsl:if>
       <SCRIPT LANGUAGE="JavaScript">endParShow();</SCRIPT>

       <TABLE WIDTH="100%" CELLPADDING="0" CELLSPACING="0" CLASS="Item">
         <xsl:apply-templates select="condition"/>
       </TABLE>

       <SPAN CLASS="RESERVED">End Select</SPAN>
       <SCRIPT LANGUAGE="JavaScript">endDivShow();</SCRIPT>

    </xsl:when>

<!-- ******** OTHERS ********  -->

    <xsl:otherwise>
      <xsl:apply-templates select="Text"/>
    </xsl:otherwise>
  </xsl:choose>
    </TD>
  </TR>
</xsl:template>


<!--********* Gestione del tag "condition" *********-->

<xsl:template match="condition">
  <TR>
    <TD>

<!-- ******** IF ********  -->

     <xsl:if expr="this.parentNode.attributes.getNamedItem('type').text=='if'">
        <xsl:if expr="childNumber(this)==1">

         <SCRIPT LANGUAGE="JavaScript">startDivShow();</SCRIPT>

         <xsl:eval>'If '+this.attributes.getNamedItem("value").text</xsl:eval>

         <SCRIPT LANGUAGE="JavaScript">endParShow();</SCRIPT>

       </xsl:if>
       <xsl:if expr="childNumber(this)!=1">
         <SPAN CLASS="RESERVED">If</SPAN> <xsl:value-of select="@value"/>
       </xsl:if>
     </xsl:if>
<!-- ******** CASE ********  -->

     <xsl:if expr="this.parentNode.attributes.getNamedItem('type').text=='case'">
       <xsl:if expr="childNumber(this)==1">

       <SCRIPT LANGUAGE="JavaScript">startDivShow();</SCRIPT>

       <xsl:eval>'Case '+this.attributes.getNamedItem("value").text</xsl:eval>

       <SCRIPT LANGUAGE="JavaScript">endParShow();</SCRIPT>

       </xsl:if>
       <xsl:if expr="childNumber(this)!=1">
         <SPAN CLASS="RESERVED">Case</SPAN> <xsl:value-of select="@value"/>
       </xsl:if>
     </xsl:if>

<!-- ******** TRY ********  -->

     <xsl:if expr="this.parentNode.attributes.getNamedItem('type').text=='try'">
       <xsl:if expr="childNumber(this)==1">

       <SCRIPT LANGUAGE="JavaScript">startDivShow();</SCRIPT>

       <xsl:eval>'Try '+this.attributes.getNamedItem("value").text</xsl:eval>

       <SCRIPT LANGUAGE="JavaScript">endParShow();</SCRIPT>

       </xsl:if>
       <xsl:if expr="childNumber(this)!=1">
         <SPAN CLASS="RESERVED">Catch</SPAN> <xsl:value-of select="@value"/>
       </xsl:if>
     </xsl:if>

<!-- ******** WHILE ********  -->

     <xsl:if expr="this.parentNode.attributes.getNamedItem('type').text=='while'">
       <xsl:if expr="childNumber(this)==1">

       <SCRIPT LANGUAGE="JavaScript">startDivShow();</SCRIPT>

       <xsl:eval>'While '+this.attributes.getNamedItem("value").text</xsl:eval>

       <SCRIPT LANGUAGE="JavaScript">endParShow();</SCRIPT>

       </xsl:if>
     </xsl:if>

    </TD>
  </TR>
  <TR><TD><TABLE>
    <TR><TD>
      <xsl:apply-templates select="node()"/>  <!-- Cicla su tutti i nodi figli del nodo corrente (compresi
                                                     quelli di tipo "text") applicando il template relativo -->
    </TD></TR>
  </TABLE></TD></TR>
</xsl:template>


<!--********* Gestione del tag "else" *********-->

<xsl:template match="else">
  <TR><TD><SPAN CLASS="RESERVED">Else</SPAN></TD></TR>
  <TR><TD><TABLE>
    <TR><TD>
      <xsl:apply-templates select="node()"/>  <!-- Cicla su tutti i nodi figli del nodo corrente (compresi
                                                     quelli di tipo "text") applicando il template relativo -->
    </TD></TR>
  </TABLE></TD></TR>
</xsl:template>

<!--********* Gestione del tag "KeyFields" e "ReadFields" *********-->

<xsl:template match="KeyFields | ReadFields">
    <xsl:for-each select="Field">
    <TR>
      <TD CLASS="FIELD_CELL"><xsl:value-of select="@name"/></TD>
      <TD CLASS="FIELD_CELL"><xsl:value-of select="@value"/></TD>
    </TR>
    </xsl:for-each>
</xsl:template>

<!--********* Gestione del tag "WriteFields"  *********-->

<xsl:template match="WriteFields">
    <xsl:for-each select="Field">
    <TR>
      <TD CLASS="FIELD_CELL"><xsl:value-of select="@name"/></TD>
      <TD CLASS="FIELD_CELL"><xsl:value-of select="@value"/></TD>
      <TD CLASS="FIELD_CELL"><xsl:value-of select="@operation"/></TD>
    </TR>
    </xsl:for-each>
</xsl:template>

<!--********* Gestione del tag "Check" *********-->

<xsl:template match="Check">
  <xsl:choose>
    <xsl:when match="*[. = 'bat']">Routine</xsl:when>
    <xsl:when match="*[. = 'rep']">Report</xsl:when>
    <xsl:when match="*[. = 'scr']">Dialog window</xsl:when>
    <xsl:when match="*[. = 'man']">Manual Block</xsl:when>
    <xsl:when match="*[. = 'ext']">Program</xsl:when>
    <xsl:when match="*[. = 'page']">Page</xsl:when>
    <xsl:when match="*[. = 'utk']">UTK object</xsl:when>
    <xsl:otherwise><xsl:apply-templates select="text()"/></xsl:otherwise>
  </xsl:choose>
</xsl:template>

<!--********* Gestione del tag "Text" *********-->

<xsl:template match="Text">
   <xsl:if expr="this.parentNode.attributes.getNamedItem('type').text=='remark'">
     <SPAN STYLE="color:green">
       <xsl:apply-templates select="node()"/>
     </SPAN>
   </xsl:if>
   <xsl:if expr="this.parentNode.attributes.getNamedItem('type').text!='remark'">
      <xsl:apply-templates select="node()"/>
   </xsl:if>

</xsl:template>

<!--********* Gestione del tag "Paragraph" *********-->

<xsl:template match="Paragraph">
  <P>
    <H4><xsl:value-of select="@title"/></H4>
  </P>
  <BLOCKQUOTE>
    <xsl:apply-templates select="node()"/>
  </BLOCKQUOTE>
</xsl:template>

<!--********* Gestione del tag "SubParagraph" *********-->

<xsl:template match="SubParagraph">
  <P>
    <H5><xsl:value-of select="@title"/></H5>
  </P>
  <BLOCKQUOTE>
    <xsl:apply-templates select="node()"/>
  </BLOCKQUOTE>
</xsl:template>

<!--********* Gestione del tag "Code" *********-->

<xsl:template match="Code">
  <P>
  <DIV CLASS="CP_Code">
    <P STYLE="color:blue; font-size:14pt; font-family:Times New Roman; text-decoration:underline">
      <xsl:value-of select="@title"/>
    </P>
    <xsl:apply-templates select="text()|*"/>
  </DIV>
  </P>
</xsl:template>

<!--********* Gestione del tag "Linea di codice" *********-->

<xsl:template match="LineCode">
  <P STYLE="font-family: Courier New">
    <xsl:value-of />
  </P>
</xsl:template>

<!--********* Gestione del tag "Example" *********-->

<xsl:template match="Example">
  <P>
  <DIV CLASS="CP_Example">
    <P STYLE="color:green; font-size:14pt; text-decoration:underline">
    <xsl:choose>
      <xsl:when match=".[@title]"><xsl:value-of select="@title"/></xsl:when>
      <xsl:otherwise>Esempio</xsl:otherwise>
    </xsl:choose>
    </P>
    <xsl:apply-templates select="text()|*"/>
  </DIV>
  </P>
</xsl:template>


<!--********* Gestione del tag "Notes" *********-->

<xsl:template match="Notes">
  <P>
  <DIV CLASS="CP_Notes">
    <P STYLE="color:red; font-size:14pt; font-weight: bold; text-decoration:underline;">
    <xsl:choose>
      <xsl:when match=".[@title]"><xsl:value-of select="@title"/></xsl:when>
      <xsl:otherwise>&#160;Nota bene:x</xsl:otherwise>
    </xsl:choose>
    </P>
    <xsl:apply-templates select="text()|*"/>
  </DIV>
  </P>
</xsl:template>

<!--********* Gestione del tag "Image" *********-->

<xsl:template match="Image">
  <P/>
  <IMG>
    <xsl:attribute name="BORDER">0</xsl:attribute>
    <xsl:attribute name="SRC"><xsl:value-of select="@src"/></xsl:attribute>
    <xsl:attribute name="ALIGN">MIDDLE</xsl:attribute>
  </IMG>
   <SPAN CLASS="CP_Caption"><xsl:value-of select="@title"/></SPAN>
</xsl:template>

<!--********* Gestione del tag "CodePainter" *********-->

<xsl:template match="CodePainter">
  <FONT FACE="Avalon">CODE<B>PAINTER REVOLUTION</B></FONT>
</xsl:template>

<!--********* Gestione del tag "Field" *********-->

<xsl:template match="Field">
  <I><B><xsl:value-of/></B></I>
</xsl:template>


<!--********* Gestione del tag "File": link a un file XML o a un documento HTML ... *********-->

<xsl:template match="File">
  <A><xsl:attribute name="HREF"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:value-of />
  </A>
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

