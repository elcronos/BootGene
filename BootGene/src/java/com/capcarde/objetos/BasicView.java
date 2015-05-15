/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capcarde.objetos;

/**
 *
 * @author CPESTA1
 */
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
 
@ManagedBean(name="treeBasicView")
@ViewScoped
public class BasicView implements Serializable {
     
    private TreeNode root;
    private TreeNode[] selectedNode;
     
    @PostConstruct
    public void init() {
       ArbolConfig arbol= new ArbolConfig();
       arbol.setId("001");
       arbol.setNombre("Proyecto 1");
       ArrayList subnivel= new ArrayList();
       for (int i = 0; i < 9; i++) {
            Nodo nodo= new Nodo();
            nodo.setId(arbol.getId()+"0"+i);
            nodo.setNombre("Formulario:"+arbol.getId()+"0"+i);
            subnivel.add(nodo);
            ArrayList subnivel2= new ArrayList();
            for (int j = 1; j < 10; j++) {
               Nodo parametro= new Nodo();
               parametro.setId(""+j);
               parametro.setNombre("Parametro:"+nodo.getId()+"0"+j);
               subnivel2.add(parametro);
           }
            nodo.setSubnivel(subnivel2);
       }
       arbol.setSubnivel(subnivel);
       
       this.setArbol(arbol);
    }
    
    public void setArbol(ArbolConfig arbol){
        // -- PROYECTOS
        root = new DefaultTreeNode(arbol.getNombre().toUpperCase(), null);
        
        
        // -- FORMULARIOS
        ArrayList<Nodo> formularios= new ArrayList<Nodo>();
        formularios= arbol.getSubnivel();
        if(formularios!= null && formularios.size()>0){
            //Si tiene Formularios
            for(Nodo form: formularios){
                TreeNode nodo= new DefaultTreeNode(form.getNombre().toUpperCase(), root);
                //Si tiene Parametros
                ArrayList<Nodo> parametros= new ArrayList<Nodo>();
                parametros= form.getSubnivel();
                if(parametros !=null && parametros.size()>0){
                    for(Nodo param: parametros){
                        TreeNode paramNodo= new DefaultTreeNode(param.getNombre().toUpperCase(), nodo);
                        nodo.getChildren().add(paramNodo);
                    }
                }
            }
        }
        
        
    }
    
    public void displaySelectedMultiple(TreeNode[] nodes) {
        if(nodes != null && nodes.length > 0) {
            StringBuilder builder = new StringBuilder();
 
            for(TreeNode node : nodes) {
                builder.append(node.getData().toString());
                builder.append("<br />");
            }
 
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", builder.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
 
    public TreeNode getRoot() {
        return root;
    }

    public TreeNode[] getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode[] selectedNode) {
        this.selectedNode = selectedNode;
    }

    
    
    
}