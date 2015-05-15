//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 19	Mes: 16	Año :2015
//--		CLASE DAO: EN_JornadaDao
//------------------------------------------------------------------------------------------------

package com.cp.EN_JornadaForm.Controllers;

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
import com.cp.EN_JornadaForm.data.EN_JornadaDto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.Statement;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="EN_JornadaController")
@SessionScoped
public class EN_JornadaDao implements Serializable {

public EN_JornadaDto selected;
private ArrayList<EN_JornadaDto> listEN_Jornada;
private String nameTable;

private void inicializaDao(){
	nameTable = "EN_Jornada";
	selected= new EN_JornadaDto();
	listEN_Jornada = findAll();
}

public EN_JornadaDao() {
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


public ArrayList<EN_JornadaDto> findAll() throws SQLException{
	ArrayList<EN_JornadaDto> listaDto= new ArrayList<EN_JornadaDto>();
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
		String sql= " update EN_Jornada set " +
		"id = ?, " +
		"jornada = ?, " +
		"valor = ?, " +
		"pago = ? " +
		" Where id = ?";
		
		PreparedStatement pst = pc.getConnection().prepareStatement(sql);
		pst.setInt( 1, selected.getId());
		pst.setString( 2, selected.getJornada());
		pst.setInt( 3, selected.getValor());
		pst.setInt( 4, selected.getPago());
		pst.setInt( 5, selected.getId());
		pst.execute();
	} finally {
		pc.closeConnection();
	}
}
public void delete() throws SQLException {
	PoolConectDB pc = new PoolConectDB();
	try{
		String sql = "delete from EN_Jornada Where id = "+getSelected().getId();
		pc.getConnection().createStatement().execute(sql);
	} catch(Exception ex) {} finally {
		pc.closeConnection();
	}
}










//------------------------------------------------------------------------------------------------
//--		CreateDto
//------------------------------------------------------------------------------------------------

private EN_JornadaDto createDto(ResultSet rs) throws SQLException {
	EN_JornadaDto retorno = new EN_JornadaDto();
	retorno.setId (rs.getInt("id"));
	retorno.setJornada (rs.getString("jornada"));
	retorno.setValor (rs.getInt("valor"));
	retorno.setPago (rs.getInt("pago"));
	return retorno;
}



//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------selected----------------------------------------------

public EN_JornadaDto getSelected(){return selected;}
public void setSelected(EN_JornadaDto selected){this.selected = selected;}

//------------------------------------------------------------------------------------------------

 //Otros Metodos
public ArrayList<EN_JornadaDto> getListEN_Jornada() {
        return listEN_Jornada;
    }

    public void setListEN_Jornada(ArrayList<EN_JornadaDto> listEN_Jornada) {
        this.listEN_Jornada = listEN_Jornada;
    }  

public int getSize() {
    return this.listEN_Jornada.size();
  }
  public void onEdit(RowEditEvent event) {
    EN_JornadaDto model = (EN_JornadaDto)event.getObject();
    this.selected = model;
    update();
  }
  public void onCancel(RowEditEvent event) {
    //Complete this method 
  }
public void render(){
    try {
        listEN_Jornada = findAll();
    } catch (SQLException ex) {
        //Exception
    }
}
}