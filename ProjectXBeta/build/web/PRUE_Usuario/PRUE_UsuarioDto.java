//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 21	Mes: 17	Año :2015
//--		CLASE DTO: PRUE_UsuarioDto
//------------------------------------------------------------------------------------------------

package com.cp.PRUE_UsuarioForm.data;

//------------------------------------------------------------------------------------------------
//--		Imports
//------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import com.capcarde.DB.PoolConectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import javax.faces.bean.ManagedBean;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="PRUE_UsuarioModel")
public class PRUE_UsuarioDto implements Serializable {


//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------

public PRUE_UsuarioDto(){
	id= secuencia();
}

//------------------------------------------------------------------------------------------------



private int id;
private String nombre;
private String direccion;


//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------id----------------------------------------------

public int getId(){return id;}
public void setId(int id){this.id = id;}
//--------------------------------------nombre----------------------------------------------

public String getNombre(){return nombre;}
public void setNombre(String nombre){this.nombre = nombre;}
//--------------------------------------direccion----------------------------------------------

public String getDireccion(){return direccion;}
public void setDireccion(String direccion){this.direccion = direccion;}

//------------------------------------------------------------------------------------------------

public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(id) from PRUE_Usuario"); rs.next();) {
                sec = rs.getInt(1);
            }

            p.getConnection().close();
        } catch (SQLException ex) {

        }
        return sec + 1;
}

public void insert() throws SQLException{
	PoolConectDB pc = new PoolConectDB();
	PreparedStatement st = null;
	try{
	
		String sql = " insert into PRUE_Usuario (" +
		"id," +
		"nombre," +
		" direccion " +
		") values(?,?,?) ";

		st = pc.getConnection().prepareStatement(sql);
		st.setInt( 1, getId());
		st.setString( 2, getNombre());
		st.setString( 3, getDireccion());
		st.execute();
	} finally {
		pc.getConnection().close();
	}
}


}