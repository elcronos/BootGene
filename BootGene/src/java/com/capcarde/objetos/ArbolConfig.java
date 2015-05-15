/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capcarde.objetos;

/**
 *
 * @author CPESTA1
 */
public class ArbolConfig extends Nodo {

    public boolean buscarNodo(String idNodo) {
        boolean encontrado = false;

        switch (idNodo.length()) {
            //Si es un Proyecto
            case 3:
                if (this.getId().equals(idNodo)) {
                    System.out.println("Se encontró Nodo:" + idNodo + " de Tipo:" + tipoNodo(idNodo));
                    return true;
                } else {
                    return false;
                }
            //Si es un ID de Formulario
            case 5:
                //Si tienen el mismo ID de proyecto y el proyecto tiene Formularios
                if (this.getId().equals(idNodo.subSequence(0, 2)) && this.getSubnivel() != null) {
                    //Buscar el formulario
                    for (Nodo nodo : this.getSubnivel()) {
                        if (nodo.getId().equals(idNodo)) {
                            System.out.println("Se encontró Nodo:" + idNodo + " de Tipo:" + tipoNodo(idNodo));
                            return true;
                        }
                    }
                }else{return false;}
            //Si es un ID de Parametro
            case 7:
                //Si tienen el mismo ID de proyecto y el proyecto tiene parametros
                if (this.getId().equals(idNodo.subSequence(0, 2)) && this.getSubnivel() != null) {
                    //Buscar el formulario
                    for (Nodo nodo : this.getSubnivel()) {
                        //Busqueda Parametros
                        for (Nodo nodoParam : nodo.getSubnivel()) {

                            if (nodoParam.getId().equals(idNodo)) {
                                System.out.println("Se encontró Nodo:" + idNodo + " de Tipo:" + tipoNodo(idNodo));
                                return true;
                            }
                        }
                    }
                }else{return false;}
                
            default: break;
        }


        return encontrado;
    }

    /*
     * Identifica que tipo de Nodo es dado el ID del nodo
     */
    public String tipoNodo(String idNodo) {
        String tipo = "";

        if (idNodo.length() == 3) {
            tipo = "PROYECTO";
        } else if (idNodo.length() == 5) {
            tipo = "FORMULARIO";
        } else if (idNodo.length() == 7) {
            tipo = "PARAMETRO";
        } else if (idNodo.length() == 9) {
            tipo = "PAGINA";
        }

        return tipo;
    }
}
