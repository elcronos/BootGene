//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 19	Mes: 16	Año :2015
//--		CLASE DTO: EN_JornadaDto
//------------------------------------------------------------------------------------------------

package com.cp.EN_JornadaForm.data;

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


@ManagedBean(name="EN_JornadaModel")
public class EN_JornadaDto implements Serializable {


//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------

public EN_JornadaDto(){
	id= secuencia();
}

//------------------------------------------------------------------------------------------------



private int id;
private String jornada;
private int valor;
private int pago;


//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------id----------------------------------------------

public int getId(){return id;}
public void setId(int id){this.id = id;}
//--------------------------------------jornada----------------------------------------------

public String getJornada(){return jornada;}
public void setJornada(String jornada){this.jornada = jornada;}
//--------------------------------------valor----------------------------------------------

public int getValor(){return valor;}
public void setValor(int valor){this.valor = valor;}
//--------------------------------------pago----------------------------------------------

public int getPago(){return pago;}
public void setPago(int pago){this.pago = pago;}

//------------------------------------------------------------------------------------------------

public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(id) from EN_Jornada"); rs.next();) {
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
	
		String sql = " insert into EN_Jornada (" +
		"id," +
		"jornada," +
		"valor," +
		" pago " +
		") values(?,?,?,?) ";

		st = pc.getConnection().prepareStatement(sql);
		st.setInt( 1, getId());
		st.setString( 2, getJornada());
		st.setInt( 3, getValor());
		st.setInt( 4, getPago());
		st.execute();
	} finally {
		pc.getConnection().close();
	}
}


}