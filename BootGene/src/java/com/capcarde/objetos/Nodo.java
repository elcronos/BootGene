/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capcarde.objetos;

import java.util.ArrayList;

/**
 *
 * @author CPESTA1
 */
public class Nodo {
    
    private String id; 
    private String tipo;
    private String nombre;
    private String desc;
    private ArrayList<Nodo> subnivel;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Nodo> getSubnivel() {
        return subnivel;
    }

    public void setSubnivel(ArrayList<Nodo> subnivel) {
        this.subnivel = subnivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
