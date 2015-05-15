<#macro campos parametros nombre>
    <#assign v="#{">
    <#assign f="}">
    <#list parametros as parametro>     
    <#assign valor="${v}${nombre}Model${parametro.nameCampo}${f}">          
                    <!--  ${parametro.nameCampo?upper_case}  -->
    <#if parametro.tipoDato="Number(10)"  && parametro.nameCampo !="id">
                    <#if parametro.esObligatorio="S">
                        <#assign x="true">
                    <#else>
                        <#assign x="false">
                    </#if>
                    <h:outputLabel for="${parametro.nameCampo}Input" value="" />
                    <h:inputText id="${parametro.nameCampo}Input" value="${v}${nombre}Model.${parametro.nameCampo}${f}" required="${x}"/> 
    <#elseif parametro.tipoDato="VarChar2(80)">
                    <#if parametro.esObligatorio="S">
                        <#assign x="true">
                    <#else>
                        <#assign x="false">
                    </#if>
                    <h:outputLabel for="${parametro.nameCampo}Input" value="${parametro.nameCampo} :" />
                    <h:inputText id="${parametro.nameCampo}Input" value="${v}${nombre}Model.${parametro.nameCampo}${f}" required="${x}"/>  

    <#elseif parametro.tipoDato="Date">
                    <#if parametro.esObligatorio="S">
                        <#assign x="true">
                    <#else>
                        <#assign x="false">
                    </#if>
                    <h:outputLabel for="${parametro.nameCampo}Input" value="${parametro.nameCampo} :" />                   
                    <p:calendar mask="99/99/9999" navigator="true" locale="es" pattern="dd/MM/yyyy" id="${parametro.nameCampo}Input" 
                                 value="${v}${nombre}Model.${parametro.nameCampo}${f}" required="${x}${f}"/>

   <#elseif parametro.tipoDato="VarChar2(250)">
                    <#if parametro.esObligatorio="S">
                        <#assign x="true">
                    <#else>
                        <#assign x="false">
                    </#if>
                    <h:outputLabel for="${parametro.nameCampo}Input" value="${parametro.nameCampo} :" />
                    <h:inputText id="${parametro.nameCampo}Input" value="${v}${nombre}Model.${parametro.nameCampo}${f}" required="${x}"/> 
    <#else>
                    <#if parametro.esObligatorio="S">
                        <#assign x="true">
                    <#else>
                        <#assign x="false">
                    </#if>
                    <h:outputLabel for="${parametro.nameCampo}Input" value="${parametro.nameCampo} :" />
                    <p:inputMask mask="(999) 999-9999" id="${parametro.nameCampo}Input" value="${v}${nombre}Model.${parametro.nameCampo}${f}" required="${x}"/>

    </#if>

    </#list>
</#macro>
<#macro lista parametros nombre>
<#assign v="#{">
<#assign f="}">
<#assign valor="${v}${nombre}Controller.nombBusq${f}">
<#assign valor2="${v}${nombre}Controller.buscaPaciente()${f}">
            <div class="heading-buttons border-bottom innerLR">
                <h4 class="margin-none innerTB pull-left">Lista ${nombre}</h4>
                <div class="clearfix"></div>
            </div>

            <div class="bg-white border-bottom innerAll">
                <div class="input-group input-group-sm">


                    <h:form id="form1">
                        <table>
                            <tr>
                                <td>
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Nombre <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Nombre</a></li>         
                                        </ul>
                                    </div>
                                </td>
                                <td>
                                    <p:inputText class="form-control" value="${valor}" placeholder="" />
                                </td>
                                <td>
                                    <p:commandButton id="cmb" value="Buscar" update="componenteLista" style="color: white" class="pull-right btn btn-primary btn-stroke btn-xs">
                                        <f:actionListener binding="#{valor2}"/>
                                    </p:commandButton>
                                    <p:blockUI block="cmb" trigger="cmb">
                                        Buscando ${nombre}...<br />
                                    </p:blockUI>
                                </td>
                            </tr>
                        </table>
                    </h:form>
                </div>
            </div>

            <ul class="list-group list-group-1 borders-none margin-none">
                <h:panelGroup id="componenteLista">
                <h:form id="form2" rendered="true">
                <ui:repeat id="lista"  value="${v}${nombre}Controller.list${nombre}${f}" var="var">
                    <li class="list-group-item">
                        <div class="media innerAll">
                            <p:commandButton  value="Consultar" ajax="false" style="color: white" class="pull-right btn btn-primary btn-stroke btn-xs" >

                                    <f:setPropertyActionListener value="${v}${nombre}${f}" target="${v}${nombre}Controller.selected${f}" />
                                    <f:actionListener binding="#{nav.goPage('${nombre}Info')}"/>
                                    
                            </p:commandButton>
                        
                            <div class="media-body">
                                <h5 class="media-heading strong"><h:outputText value="${v}${nombre}.nombrecomple.toUpperCase()${f}"/></h5>
                                <ul class="list-unstyled">
                                    <li><i class="fa fa-user"></i> <h:outputText value="${v}${nombre}.numedocu${f}"/></li>
                                    <li><i class="fa fa-calendar"></i> <h:outputText value="${v}${nombre}.fechnaci${f}"/></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ui:repeat>
                </h:form>
                </h:panelGroup>
            </ul>
            <!-- ./ END ${nombre?upper_case} LIST -->
</#macro>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets">

<!--
        PROYECTO:    ${titulo}
        ABREVIATURA: ${proyecto.abrevProyecto}
        DESCRIPCION: ${proyecto.descProyecto}
        FORMULARIO:  ${formulario.nameFormulario}
        DESCRIPCION FORMULARIO: ${formulario.descFormulario}        
-->

<f:view contentType="text/html">
        <h:head>
            <f:facet name="form"><meta content='text/html; charset=UTF-8' http-equiv="Content-Type"/>
                <title>${titulo}</title>
            </f:facet>            
        </h:head>
        <h:body>

            <!--*******************************FORM - CREATE*******************************-->
            <h:form id="form">
                <p:panelGrid id="grd" columns="2" style="font-size: 10px;" rendered="true">
                    <f:facet name="header">
                        Nueva Enfermera
                    </f:facet>
                    
                    <@campos parametros nombre/>
                    <@lista parametros nombre(> 
                </p:panelGrid> <!-- ./ panelGrid --> 
                
          
                <p:commandButton id="add${nombre}" style="color: white" class="btn btn-primary btn-stroke btn-xs"  update="componenteLista" value="Agregar">
                    
                    <f:actionListener binding=""/>
                    <f:actionListener binding=""/>
                </p:commandButton>

                <p:blockUI animate="true" block="add${nombre}" trigger="add${nombre}">
                      Creando ${formulario.nameFormulario}...<br />
                </p:blockUI>

            </h:form> <!-- ./form -->
            
            <!--**************************************************************-->
            <!--**************************************************************-->
        </h:body> <!-- ./body -->
    </f:view> <!-- ./view -->
</html><!-- ./ FIN HTML -->