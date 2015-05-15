/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capcarde.generator;

import com.capcarde.Beans.FormularioBean;
import com.capcarde.Beans.ParametroBean;
import com.capcarde.Beans.ProyectoBean;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author camilo
 */
@ManagedBean(name = "generator")
@SessionScoped
public class Generator {

    private ProyectoBean proyecto;
    private FormularioBean formulario;
    private String nombreFormulario;
    private ArrayList<ParametroBean> parametro;

    public Generator() {
        proyecto = new ProyectoBean();
        formulario = new FormularioBean();
        parametro = new ArrayList<ParametroBean>();
        nombreFormulario = "";
    }

    public void imprimir() {
        System.out.println("PRUEBA BOOT-LISTA");
    }
    
    private String getPath(){   
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath(".").replaceAll("build/web/.", "");
    }


    public void generate() {

        try {
            //Freemarker configuration object
            Configuration cfg = new Configuration();

            String ruta = this.getPath() + "src/java/com/capcarde/templates";
            cfg.setDirectoryForTemplateLoading(new File(ruta));
            //Load template from source folder
            Template template = cfg.getTemplate("boot-form.ftl");

            Map<String, Object> data = new HashMap<String, Object>();
            data.put("titulo", proyecto.getNombreProyecto());
            data.put("proyecto", proyecto);
            data.put("parametros", parametro);
            data.put("formulario", formulario);
            data.put("nombre", this.formulario.getNameFormulario());

            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

           
             // File output
             Writer file = new FileWriter (new File(this.getPath()+"src/java/com/capcarde/generados/g.html"));
             template.process(data, file);
             file.flush();
             file.close();
           
             
        } catch (Exception ex) {
            System.out.println("MENSAJE:"+ex);
        }
    
}

private Map<String,Object> getDatos(){
         Map<String,Object> data = new HashMap<String,Object>();
         
         data.put("titulo", nombreFormulario);
         data.put("proyecto", proyecto);
         data.put("formulario", formulario);
         data.put("parametros", parametro);
         
         return data;
    }
    
   
    public ProyectoBean getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoBean proyecto) {
        this.proyecto = proyecto;
    }

    public FormularioBean getFormulario() {
        return formulario;
    }

    public void setFormulario(FormularioBean formulario) {
        this.formulario = formulario;
    }

    public String getNombreFormulario() {
        return nombreFormulario;
    }

    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    public ArrayList<ParametroBean> getParametro() {
        return parametro;
    }

    public void setParametro(ArrayList<ParametroBean> parametro) {
        this.parametro = parametro;
    }

    
    
}
