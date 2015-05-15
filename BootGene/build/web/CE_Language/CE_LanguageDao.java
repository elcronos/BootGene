//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 5	Mes: 19	Año :2015
//--		CLASE DAO: CE_LanguageDao
//------------------------------------------------------------------------------------------------

package com.cp.CE_LanguageForm.Controllers;

//------------------------------------------------------------------------------------------------
//--		Imports
//------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.RowEditEvent;
import com.capcarde.DB.PoolConectDB;
import java.io.Serializable;
import java.sql.SQLException;
import com.cp.CE_LanguageForm.data.CE_LanguageDto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.Statement;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="CE_LanguageController")
@SessionScoped
public class CE_LanguageDao implements Serializable {

public CE_LanguageDto selected;
private ArrayList<CE_LanguageDto> listCE_Language;
private String nameTable;

private void inicializaDao(){
	nameTable = "CE_Language";
	selected= new CE_LanguageDto();
	listCE_Language = findAll();
}

public CE_LanguageDao() {
	inicializaDao();
}





//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------nameTable----------------------------------------------

public String getNametable(){return nameTable;}
public void setNametable(String nameTable){this.nameTable = nameTable;}

//------------------------------------------------------------------------------------------------


public ArrayList<CE_LanguageDto> findAll() throws SQLException{
	ArrayList<CE_LanguageDto> listaDto= new ArrayList<CE_LanguageDto>();
	PoolConectDB pc=null;
	try {
		pc = new PoolConectDB();
		Statement select= pc.getConnection().createStatement();
		String sql="Select * from "+getNametable();
		ResultSet result= select.executeQuery(sql);
		while(result.next()){
			listaDto.add(createDto(result));
		}
	} catch (SQLException ex) {
	}finally{
		pc.closeConnection();
	}
	return listaDto;
}


public void update() throws SQLException {
	PoolConectDB pc= new PoolConectDB();
	try{
		String sql= " update CE_Language set " +
		"ID = ?, " +
		"Language = ? " +
		" Where ID = ?";
		
		PreparedStatement pst = pc.getConnection().prepareStatement(sql);
		pst.setInt( 1, selected.getId());
		pst.setString( 2, selected.getLanguage());
		pst.setInt( 3, selected.getId());
		pst.execute();
	} finally {
		pc.closeConnection();
	}
}
public void delete() throws SQLException {
	PoolConectDB pc = new PoolConectDB();
	try{
		String sql = "delete from CE_Language Where ID = "+getSelected().getId();
		pc.getConnection().createStatement().execute(sql);
	} catch(Exception ex) {} finally {
		pc.closeConnection();
	}
}










//------------------------------------------------------------------------------------------------
//--		CreateDto
//------------------------------------------------------------------------------------------------

private CE_LanguageDto createDto(ResultSet rs) throws SQLException {
	CE_LanguageDto retorno = new CE_LanguageDto();
	retorno.setId (rs.getInt("ID"));
	retorno.setLanguage (rs.getString("Language"));
	return retorno;
}



//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------selected----------------------------------------------

public CE_LanguageDto getSelected(){return selected;}
public void setSelected(CE_LanguageDto selected){this.selected = selected;}

//------------------------------------------------------------------------------------------------

 //Otros Metodos
public ArrayList<CE_LanguageDto> getListCE_Language() {
        return listCE_Language;
    }

    public void setListCE_Language(ArrayList<CE_LanguageDto> listCE_Language) {
        this.listCE_Language = listCE_Language;
    }  

public int getSize() {
    return this.listCE_Language.size();
  }
  public void onEdit(RowEditEvent event) {
    CE_LanguageDto model = (CE_LanguageDto)event.getObject();
    this.selected = model;
    update();
  }
  public void onCancel(RowEditEvent event) {
    //Complete this method 
  }
public void render(){
    try {
        listCE_Language = findAll();
    } catch (SQLException ex) {
        //Exception
    }
}
}