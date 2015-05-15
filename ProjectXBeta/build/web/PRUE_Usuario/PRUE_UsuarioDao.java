//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 21	Mes: 17	Año :2015
//--		CLASE DAO: PRUE_UsuarioDao
//------------------------------------------------------------------------------------------------

package com.cp.PRUE_UsuarioForm.Controllers;

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
import com.cp.PRUE_UsuarioForm.data.PRUE_UsuarioDto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.Statement;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="PRUE_UsuarioController")
@SessionScoped
public class PRUE_UsuarioDao implements Serializable {

public PRUE_UsuarioDto selected;
private ArrayList<PRUE_UsuarioDto> listPRUE_Usuario;
private String nameTable;

private void inicializaDao(){
	nameTable = "PRUE_Usuario";
	selected= new PRUE_UsuarioDto();
	listPRUE_Usuario = findAll();
}

public PRUE_UsuarioDao() {
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


public ArrayList<PRUE_UsuarioDto> findAll() throws SQLException{
	ArrayList<PRUE_UsuarioDto> listaDto= new ArrayList<PRUE_UsuarioDto>();
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
		String sql= " update PRUE_Usuario set " +
		"id = ?, " +
		"nombre = ?, " +
		"direccion = ? " +
		" Where id = ?";
		
		PreparedStatement pst = pc.getConnection().prepareStatement(sql);
		pst.setInt( 1, selected.getId());
		pst.setString( 2, selected.getNombre());
		pst.setString( 3, selected.getDireccion());
		pst.setInt( 4, selected.getId());
		pst.execute();
	} finally {
		pc.closeConnection();
	}
}
public void delete() throws SQLException {
	PoolConectDB pc = new PoolConectDB();
	try{
		String sql = "delete from PRUE_Usuario Where id = "+getSelected().getId();
		pc.getConnection().createStatement().execute(sql);
	} catch(Exception ex) {} finally {
		pc.closeConnection();
	}
}










//------------------------------------------------------------------------------------------------
//--		CreateDto
//------------------------------------------------------------------------------------------------

private PRUE_UsuarioDto createDto(ResultSet rs) throws SQLException {
	PRUE_UsuarioDto retorno = new PRUE_UsuarioDto();
	retorno.setId (rs.getInt("id"));
	retorno.setNombre (rs.getString("nombre"));
	retorno.setDireccion (rs.getString("direccion"));
	return retorno;
}



//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------selected----------------------------------------------

public PRUE_UsuarioDto getSelected(){return selected;}
public void setSelected(PRUE_UsuarioDto selected){this.selected = selected;}

//------------------------------------------------------------------------------------------------

 //Otros Metodos
public ArrayList<PRUE_UsuarioDto> getListPRUE_Usuario() {
        return listPRUE_Usuario;
    }

    public void setListPRUE_Usuario(ArrayList<PRUE_UsuarioDto> listPRUE_Usuario) {
        this.listPRUE_Usuario = listPRUE_Usuario;
    }  

public int getSize() {
    return this.listPRUE_Usuario.size();
  }
  public void onEdit(RowEditEvent event) {
    PRUE_UsuarioDto model = (PRUE_UsuarioDto)event.getObject();
    this.selected = model;
    update();
  }
  public void onCancel(RowEditEvent event) {
    //Complete this method 
  }
public void render(){
    try {
        listPRUE_Usuario = findAll();
    } catch (SQLException ex) {
        //Exception
    }
}
}