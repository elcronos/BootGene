//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 21	Mes: 17	Año :2015
//--		CLASE DTO: EN_EnfermeraDto
//------------------------------------------------------------------------------------------------

package com.cp.EN_EnfermeraForm.data;

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


@ManagedBean(name="EN_EnfermeraModel")
public class EN_EnfermeraDto implements Serializable {


//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------

public EN_EnfermeraDto(){
	id= secuencia();
}

//------------------------------------------------------------------------------------------------



private int id;
private String nombreComple;
private String numeDocu;
private String ciudad;
private Date fecha;
private String numeCelu;
private String correo;
private String nombBanc;
private String tipoCuenta;
private String numeroCuenta;


//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------id----------------------------------------------

public int getId(){return id;}
public void setId(int id){this.id = id;}
//--------------------------------------nombreComple----------------------------------------------

public String getNombrecomple(){return nombreComple;}
public void setNombrecomple(String nombreComple){this.nombreComple = nombreComple;}
//--------------------------------------numeDocu----------------------------------------------

public String getNumedocu(){return numeDocu;}
public void setNumedocu(String numeDocu){this.numeDocu = numeDocu;}
//--------------------------------------ciudad----------------------------------------------

public String getCiudad(){return ciudad;}
public void setCiudad(String ciudad){this.ciudad = ciudad;}
//--------------------------------------fecha----------------------------------------------

public Date getFecha(){return fecha;}
public void setFecha(Date fecha){this.fecha = fecha;}
//--------------------------------------numeCelu----------------------------------------------

public String getNumecelu(){return numeCelu;}
public void setNumecelu(String numeCelu){this.numeCelu = numeCelu;}
//--------------------------------------correo----------------------------------------------

public String getCorreo(){return correo;}
public void setCorreo(String correo){this.correo = correo;}
//--------------------------------------nombBanc----------------------------------------------

public String getNombbanc(){return nombBanc;}
public void setNombbanc(String nombBanc){this.nombBanc = nombBanc;}
//--------------------------------------tipoCuenta----------------------------------------------

public String getTipocuenta(){return tipoCuenta;}
public void setTipocuenta(String tipoCuenta){this.tipoCuenta = tipoCuenta;}
//--------------------------------------numeroCuenta----------------------------------------------

public String getNumerocuenta(){return numeroCuenta;}
public void setNumerocuenta(String numeroCuenta){this.numeroCuenta = numeroCuenta;}

//------------------------------------------------------------------------------------------------

public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(id) from EN_Enfermera"); rs.next();) {
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
	
		String sql = " insert into EN_Enfermera (" +
		"id," +
		"nombreComple," +
		"numeDocu," +
		"ciudad," +
		"fecha," +
		"numeCelu," +
		"correo," +
		"nombBanc," +
		"tipoCuenta," +
		" numeroCuenta " +
		") values(?,?,?,?,?,?,?,?,?,?) ";

		st = pc.getConnection().prepareStatement(sql);
		st.setInt( 1, getId());
		st.setString( 2, getNombrecomple());
		st.setString( 3, getNumedocu());
		st.setString( 4, getCiudad());
		st.setDate( 5, getFecha());
		st.setString( 6, getNumecelu());
		st.setString( 7, getCorreo());
		st.setString( 8, getNombbanc());
		st.setString( 9, getTipocuenta());
		st.setString( 10, getNumerocuenta());
		st.execute();
	} finally {
		pc.getConnection().close();
	}
}


}