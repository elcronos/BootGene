package com.capcarde.logic;

import com.capcarde.Beans.FormularioBean;
import com.capcarde.Beans.ProyectoBean;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.capcarde.logic:
//            CRUDParameObject

public class CreateForms{

    
    public CreateForms()
    {
        htmlTag = "";
        bodyTag = "";
        formTag = "";
        descForm="";
        //Default Values
        emptyMessage="Lista Vacia";
        headerTitle="@nameTable";
        scrollHeight=10;
        rows=10;
        fontSize=14;
        paginator=true;
        editable=true;
        
        initClass();
    }

    private void initClass()
    {
        //Etiquetas: @body, @nameForm, @form,@inputForm
        htmlTag = "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n\t"
                + "xmlns:h=\"http://java.sun.com/jsf/html\"\n\t"
                + "xmlns:f=\"http://java.sun.com/jsf/core\"\n\t"
                + "xmlns:p=\"http://primefaces.org/ui\">\n"
                + "\n@descForm\n@body\n</html>";
        
        
                 
        bodyTag= "<f:view contentType=\"text/html\">\n<h:head>"
                +"\n\t<h:outputStylesheet library=\"css\" name=\"style.css\"/>\n"
                +"<f:facet name=\"form\">"
                +"<meta content='text/html; charset=UTF-8' http-equiv=\"Content-Type\"/>"
                +"\n\t<title>@nameForm</title>\n</f:facet>\n</h:head>\n<h:body>\n\n@form\n</h:body>\n</f:view>";
                
       
        formTag = "<!--*******************************FORM - CREATE*******************************-->\n" +
                  "<h:form id=\"form\">\n"
                + "<p:panelGrid id=\"grd\" columns=\"2\" style=\"font-size: 10px;\" rendered=\"true\">"
                + "\n<f:facet name=\"header\">\n\tNuevo @nameForm\n</f:facet>@inputForm@dataTable"
                ;
    }
    //Agrega la descripcion del formulario
    public void addDescForm(ProyectoBean proyecto,FormularioBean form){
        descForm= "<!--\n\tPROYECTO:"+proyecto.getNombreProyecto()+"\n\tABREVIATURA:"+proyecto.getAbrevProyecto()+"\n\t"
                + "DESCRIPCION:"+proyecto.getDescProyecto()+"\n\t"
                + "FORMULARIO:"+form.getNameFormulario()+"\n\t"+"DESCRIPCION FORMULARIO:"+form.getDescFormulario()
                + "\n-->";
    }
    
    //Crear un formulario CRUD simple(Vista)
    public String createForm(ArrayList listaParametros, String nombreForm)
    {
        htmlTag=htmlTag.replace("@descForm",descForm);
        htmlTag=htmlTag.replace("@body",bodyTag);
        htmlTag=htmlTag.replace("@form",formTag);
        htmlTag=htmlTag.replace("@inputForm",makeForm(listaParametros,nombreForm));
        htmlTag= htmlTag.replace("@nameForm", nombreForm);
        htmlTag= htmlTag.replace("@dataTable", makeDataTable(listaParametros, nombreForm));
        htmlTag= htmlTag.replace("@columns", makeForm2(listaParametros));
        htmlTag= htmlTag.replaceAll("@nameDto", converVar(nombreForm)+"Model");
        //NameForm

       
        //htmlTag.replaceAll("@body", bodyTag).replaceAll("@form", formTag).replaceAll("@form1", table).replaceAll("@panelGrid", panelGrid).replaceAll("@listaVariables", parametros);
        return htmlTag;
    }
    
     private String converVar(String var){
        String resultado="";
        
        resultado=var.replaceAll(" ","").trim();
        
        return resultado;
    }
    //@inputForm replace
    private String makeForm(ArrayList listaParametros, String nombreForm){
  
        String parametros = "\n";
        String tipo="";
        for(Iterator i$ = listaParametros.iterator(); i$.hasNext();)
        {
            CRUDParameObject param = (CRUDParameObject)i$.next();
            String nombreVar = (new StringBuilder()).append(converVar(param.getNombVariable())).toString();
            String required="";
            //No se aplica para Pkey
            if(!param.isIsPkey()){
            
            //Es obligatorio?
            if(param.isIsNull()){
                required="false";
            }else{required="true";}
            
             //Tipo Descripcion(Corregir para todos los tipos de datos)
            if(param.getTipoVariable().equals("VarChar2(250)")){
               tipo="inputTextarea";
            }
            else if(param.getTipoVariable().equals("Date")){
                tipo="date";
            }
            else{
               tipo="inputText";
            }
            
            parametros = (new StringBuilder()).append(parametros).append("\n<h:outputLabel for=\"").append(nombreVar).append("Input").append("\" value=\"").append(capitalLetra(param.getNombVariable())).append(" :\" />\n").append("<h:").append(tipo).append(" id=\"").append(nombreVar).append("Input").append("\" value=\"").append("#{")
                         .append(nombreForm).append("Model").append(".").append(nombreVar).append("}\" required=\"").append(required).append("\"/>\n\n").toString();
            
            }
         }
         
       
        parametros+="</p:panelGrid>\n<p:commandButton ajax=\"false\" update=\"dataTable\" value=\"Nuevo\">\n"
                    +"<f:actionListener binding=\"#{"+nombreForm+"Model"+".insert()}\"/>\n" 
                    +"<f:actionListener binding=\"#{"+nombreForm+"Controller"+".render()}\"/>\n" 
                    +"</p:commandButton>\n</h:form>\n"
                    +"<!--**************************************************************-->\n";
    
        return parametros;                    
    }
    //@nameDao = nombreController, @nameDto =nombreModel
    private String makeDataTable(ArrayList listaParametros, String nombreForm){
        String plantilla="<h:form id=\"table\">\n" +
"                     <p:dataTable id=\"dataTable\" var=\"list\" value=\"#{@nameTableController.list@nameTable}\" style=\"font-size: "+fontSize+"px\"\n" +
"                       emptyMessage=\""+emptyMessage+"\"\n" +
"                       paginator=\""+String.valueOf(paginator)+"\" rows=\""+rows+"\"\n" +
"                       scrollHeight=\""+Integer.toString(scrollHeight)+"\"\n" +
"                       editable=\""+String.valueOf(editable)+"\"\n" +
"                             >\n" +
"                    <f:facet name=\"header\">\n" +
"                       "+headerTitle+"\n" +
"                    </f:facet>\n"+
                "<!--******************************** COLUMNS ***************************-->\n@columns\n"
                + "<p:column headerText=\"Editar\">\n" +
"                            <p:rowEditor/>   \n" +
"                        </p:column>\n" +
"                        <p:column headerText=\"Eliminar\">\n" +
"                            <p:commandButton ajax=\"false\" update=\"@this\" icon=\"ui-icon-close\">\n" +
"                                <f:setPropertyActionListener value=\"#{list}\" target=\"#{@nameTableController.selected}\" />\n" +
"                                <f:actionListener binding=\"#{@nameTableController.delete()}\"/>\n" +
"                                <f:actionListener binding=\"#{@nameTableController.render()}\"/>\n" +
"                            </p:commandButton>\n" +
"                        </p:column>"
                 
                + "<!-- AJAX-->\n" +
"                        <p:ajax event=\"rowEdit\"  listener=\"#{@nameTableController.onEdit}\"/>\n" +
"                        <p:ajax event=\"rowEditCancel\" listener=\"#{@nameTableController.onCancel}\"/>\n\n" +
"                        <f:facet name=\"footer\">\n" +
"                            En total hay  <h:outputText value=\"#{@nameTableController.size}\"/> @nameTable(s).\n" +
"                        </f:facet>\n" +
"                    </p:dataTable>\n" +
"                </h:form>\n\n";
        
        plantilla= plantilla.replaceAll("@columns", makeForm2(listaParametros));
        plantilla= plantilla.replaceAll("@nameTable", nombreForm);
        
        
        return plantilla;
    }
    
    //@nameDao, @nameDto
    private String makeForm2(ArrayList listaParametros){
     String plantilla="";
     String required="";
     String tipo="";
             
     for(Iterator i$ = listaParametros.iterator(); i$.hasNext();)
        {
            CRUDParameObject param = (CRUDParameObject)i$.next();
            String conver=converVar(param.getNombVariable());
            //No se aplica para Pkey
            if(!param.isIsPkey()){
            
            //Es obligatorio?
            if(param.isIsNull()){
                required="false";
            }else{required="true";}
            
             //Tipo Descripcion(Corregir para todos los tipos de datos)
            //Tipo Descripcion(Corregir para todos los tipos de datos)
            if(param.getTipoVariable().equals("VarChar2(250)")){
               tipo="inputTextarea";
            }
            else if(param.getTipoVariable().equals("Date")){
                tipo="date";
            }
            else{
               tipo="inputText";
            }
            
            String columna="<p:column headerText=\""+param.getNombVariable()+"\" filterBy=\""+conver+"\" sortBy=\""+conver+"\">\n" +
"                            <p:cellEditor>\n" +
"                                <f:facet name=\"output\">\n" +
"                                    <h:outputText value=\"#{list."+conver
                    + "}\" />\n" +
"                                </f:facet>\n" +
"                                <f:facet name=\"input\">\n" +
"                                    <p:"+tipo+" value=\"#{list."+conver
                    + "}\" />\n" +
"                                </f:facet>\n" +
"                            </p:cellEditor>\n" +
"</p:column>\n\n";
            
            
            plantilla += columna;
           }
        }
     return plantilla;
    }

    public String getHtmlTag() {
        return htmlTag;
    }

    public void setHtmlTag(String htmlTag) {
        this.htmlTag = htmlTag;
    }

    public String getBodyTag() {
        return bodyTag;
    }

    public void setBodyTag(String bodyTag) {
        this.bodyTag = bodyTag;
    }

    public String getFormTag() {
        return formTag;
    }

    public void setFormTag(String formTag) {
        this.formTag = formTag;
    }

    public String getEmptyMessage() {
        return emptyMessage;
    }

    public void setEmptyMessage(String emptyMessage) {
        this.emptyMessage = emptyMessage;
    }

    public Integer getScrollHeight() {
        return scrollHeight;
    }

    public void setScrollHeight(Integer scrollHeight) {
        this.scrollHeight = scrollHeight;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public Boolean getPaginator() {
        return paginator;
    }

    public void setPaginator(Boolean paginator) {
        this.paginator = paginator;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    private String capitalLetra(String capital)
    {
        capital = (new StringBuilder()).append(capital.substring(0, 1).toUpperCase()).append(capital.substring(1, capital.length()).toLowerCase()).toString();
        return capital;
    }
    
    
    

    private String htmlTag;
    private String bodyTag;
    private String formTag;
    private String emptyMessage;
    private Integer scrollHeight;
    private Integer rows;
    private Integer fontSize;
    private String headerTitle;
    private Boolean paginator;
    private Boolean editable;
    private String descForm;
   
    
}

