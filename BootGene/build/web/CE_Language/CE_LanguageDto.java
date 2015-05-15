//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 5	Mes: 19	Año :2015
//--		CLASE DTO: CE_LanguageDto
//------------------------------------------------------------------------------------------------

package com.cp.CE_LanguageForm.data;

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


@ManagedBean(name="CE_LanguageModel")
public class CE_LanguageDto implements Serializable {


//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------

public CE_LanguageDto(){
	ID= secuencia();
}

//------------------------------------------------------------------------------------------------



private int ID;
private String Language;


//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------ID----------------------------------------------

public int getId(){return ID;}
public void setId(int ID){this.ID = ID;}
//--------------------------------------Language----------------------------------------------

public String getLanguage(){return Language;}
public void setLanguage(String Language){this.Language = Language;}

//------------------------------------------------------------------------------------------------

public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(ID) from CE_Language"); rs.next();) {
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
	
		String sql = " insert into CE_Language (" +
		"ID," +
		" Language " +
		") values(?,?) ";

		st = pc.getConnection().prepareStatement(sql);
		st.setInt( 1, getId());
		st.setString( 2, getLanguage());
		st.execute();
	} finally {
		pc.getConnection().close();
	}
}


}