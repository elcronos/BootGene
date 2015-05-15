//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 6	Mes: 19	Año :2015
//--		CLASE DTO: BG_CampoFormularioDto
//------------------------------------------------------------------------------------------------

package com.cp.BG_CampoFormularioForm.data;

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


@ManagedBean(name="BG_CampoFormularioModel")
public class BG_CampoFormularioDto implements Serializable {


//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------

public BG_CampoFormularioDto(){
	idtipodato= secuencia();
}

//------------------------------------------------------------------------------------------------



private int idtipodato;
private String tipodato;
private String sqltipo;
private String javatipo;
private String tipovalue;


//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------idtipodato----------------------------------------------

public int getIdtipodato(){return idtipodato;}
public void setIdtipodato(int idtipodato){this.idtipodato = idtipodato;}
//--------------------------------------tipodato----------------------------------------------

public String getTipodato(){return tipodato;}
public void setTipodato(String tipodato){this.tipodato = tipodato;}
//--------------------------------------sqltipo----------------------------------------------

public String getSqltipo(){return sqltipo;}
public void setSqltipo(String sqltipo){this.sqltipo = sqltipo;}
//--------------------------------------javatipo----------------------------------------------

public String getJavatipo(){return javatipo;}
public void setJavatipo(String javatipo){this.javatipo = javatipo;}
//--------------------------------------tipovalue----------------------------------------------

public String getTipovalue(){return tipovalue;}
public void setTipovalue(String tipovalue){this.tipovalue = tipovalue;}

//------------------------------------------------------------------------------------------------

public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(idtipodato) from BG_CampoFormulario"); rs.next();) {
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
	
		String sql = " insert into BG_CampoFormulario (" +
		"idtipodato," +
		"tipodato," +
		"sqltipo," +
		"javatipo," +
		" tipovalue " +
		") values(?,?,?,?,?) ";

		st = pc.getConnection().prepareStatement(sql);
		st.setInt( 1, getIdtipodato());
		st.setString( 2, getTipodato());
		st.setString( 3, getSqltipo());
		st.setString( 4, getJavatipo());
		st.setString( 5, getTipovalue());
		st.execute();
	} finally {
		pc.getConnection().close();
	}
}


}