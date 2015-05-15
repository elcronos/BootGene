//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 21	Mes: 17	Año :2015
//--		CLASE DAO: EN_EnfermeraDao
//------------------------------------------------------------------------------------------------

package com.cp.EN_EnfermeraForm.Controllers;

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
import com.cp.EN_EnfermeraForm.data.EN_EnfermeraDto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.Statement;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="EN_EnfermeraController")
@SessionScoped
public class EN_EnfermeraDao implements Serializable {

public EN_EnfermeraDto selected;
private ArrayList<EN_EnfermeraDto> listEN_Enfermera;
private String nameTable;

private void inicializaDao(){
	nameTable = "EN_Enfermera";
	selected= new EN_EnfermeraDto();
	listEN_Enfermera = findAll();
}

public EN_EnfermeraDao() {
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


public ArrayList<EN_EnfermeraDto> findAll() throws SQLException{
	ArrayList<EN_EnfermeraDto> listaDto= new ArrayList<EN_EnfermeraDto>();
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
		String sql= " update EN_Enfermera set " +
		"id = ?, " +
		"nombreComple = ?, " +
		"numeDocu = ?, " +
		"ciudad = ?, " +
		"fecha = ?, " +
		"numeCelu = ?, " +
		"correo = ?, " +
		"nombBanc = ?, " +
		"tipoCuenta = ?, " +
		"numeroCuenta = ? " +
		" Where id = ?";
		
		PreparedStatement pst = pc.getConnection().prepareStatement(sql);
		pst.setInt( 1, selected.getId());
		pst.setString( 2, selected.getNombrecomple());
		pst.setString( 3, selected.getNumedocu());
		pst.setString( 4, selected.getCiudad());
		pst.setDate( 5, selected.getFecha());
		pst.setString( 6, selected.getNumecelu());
		pst.setString( 7, selected.getCorreo());
		pst.setString( 8, selected.getNombbanc());
		pst.setString( 9, selected.getTipocuenta());
		pst.setString( 10, selected.getNumerocuenta());
		pst.setInt( 11, selected.getId());
		pst.execute();
	} finally {
		pc.closeConnection();
	}
}
public void delete() throws SQLException {
	PoolConectDB pc = new PoolConectDB();
	try{
		String sql = "delete from EN_Enfermera Where id = "+getSelected().getId();
		pc.getConnection().createStatement().execute(sql);
	} catch(Exception ex) {} finally {
		pc.closeConnection();
	}
}










//------------------------------------------------------------------------------------------------
//--		CreateDto
//------------------------------------------------------------------------------------------------

private EN_EnfermeraDto createDto(ResultSet rs) throws SQLException {
	EN_EnfermeraDto retorno = new EN_EnfermeraDto();
	retorno.setId (rs.getInt("id"));
	retorno.setNombrecomple (rs.getString("nombreComple"));
	retorno.setNumedocu (rs.getString("numeDocu"));
	retorno.setCiudad (rs.getString("ciudad"));
	retorno.setFecha (rs.getDate("fecha"));
	retorno.setNumecelu (rs.getString("numeCelu"));
	retorno.setCorreo (rs.getString("correo"));
	retorno.setNombbanc (rs.getString("nombBanc"));
	retorno.setTipocuenta (rs.getString("tipoCuenta"));
	retorno.setNumerocuenta (rs.getString("numeroCuenta"));
	return retorno;
}



//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------selected----------------------------------------------

public EN_EnfermeraDto getSelected(){return selected;}
public void setSelected(EN_EnfermeraDto selected){this.selected = selected;}

//------------------------------------------------------------------------------------------------

 //Otros Metodos
public ArrayList<EN_EnfermeraDto> getListEN_Enfermera() {
        return listEN_Enfermera;
    }

    public void setListEN_Enfermera(ArrayList<EN_EnfermeraDto> listEN_Enfermera) {
        this.listEN_Enfermera = listEN_Enfermera;
    }  

public int getSize() {
    return this.listEN_Enfermera.size();
  }
  public void onEdit(RowEditEvent event) {
    EN_EnfermeraDto model = (EN_EnfermeraDto)event.getObject();
    this.selected = model;
    update();
  }
  public void onCancel(RowEditEvent event) {
    //Complete this method 
  }
public void render(){
    try {
        listEN_Enfermera = findAll();
    } catch (SQLException ex) {
        //Exception
    }
}
}