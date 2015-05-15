//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 6	Mes: 19	Año :2015
//--		CLASE DAO: BG_CampoFormularioDao
//------------------------------------------------------------------------------------------------

package com.cp.BG_CampoFormularioForm.Controllers;

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
import com.cp.BG_CampoFormularioForm.data.BG_CampoFormularioDto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.Statement;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="BG_CampoFormularioController")
@SessionScoped
public class BG_CampoFormularioDao implements Serializable {

public BG_CampoFormularioDto selected;
private ArrayList<BG_CampoFormularioDto> listBG_CampoFormulario;
private String nameTable;

private void inicializaDao(){
	nameTable = "BG_CampoFormulario";
	selected= new BG_CampoFormularioDto();
	listBG_CampoFormulario = findAll();
}

public BG_CampoFormularioDao() {
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


public ArrayList<BG_CampoFormularioDto> findAll() throws SQLException{
	ArrayList<BG_CampoFormularioDto> listaDto= new ArrayList<BG_CampoFormularioDto>();
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
		String sql= " update BG_CampoFormulario set " +
		"idtipodato = ?, " +
		"tipodato = ?, " +
		"sqltipo = ?, " +
		"javatipo = ?, " +
		"tipovalue = ? " +
		" Where idtipodato = ?";
		
		PreparedStatement pst = pc.getConnection().prepareStatement(sql);
		pst.setInt( 1, selected.getIdtipodato());
		pst.setString( 2, selected.getTipodato());
		pst.setString( 3, selected.getSqltipo());
		pst.setString( 4, selected.getJavatipo());
		pst.setString( 5, selected.getTipovalue());
		pst.setInt( 6, selected.getIdtipodato());
		pst.execute();
	} finally {
		pc.closeConnection();
	}
}
public void delete() throws SQLException {
	PoolConectDB pc = new PoolConectDB();
	try{
		String sql = "delete from BG_CampoFormulario Where idtipodato = "+getSelected().getIdtipodato();
		pc.getConnection().createStatement().execute(sql);
	} catch(Exception ex) {} finally {
		pc.closeConnection();
	}
}










//------------------------------------------------------------------------------------------------
//--		CreateDto
//------------------------------------------------------------------------------------------------

private BG_CampoFormularioDto createDto(ResultSet rs) throws SQLException {
	BG_CampoFormularioDto retorno = new BG_CampoFormularioDto();
	retorno.setIdtipodato (rs.getInt("idtipodato"));
	retorno.setTipodato (rs.getString("tipodato"));
	retorno.setSqltipo (rs.getString("sqltipo"));
	retorno.setJavatipo (rs.getString("javatipo"));
	retorno.setTipovalue (rs.getString("tipovalue"));
	return retorno;
}



//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------selected----------------------------------------------

public BG_CampoFormularioDto getSelected(){return selected;}
public void setSelected(BG_CampoFormularioDto selected){this.selected = selected;}

//------------------------------------------------------------------------------------------------

 //Otros Metodos
public ArrayList<BG_CampoFormularioDto> getListBG_CampoFormulario() {
        return listBG_CampoFormulario;
    }

    public void setListBG_CampoFormulario(ArrayList<BG_CampoFormularioDto> listBG_CampoFormulario) {
        this.listBG_CampoFormulario = listBG_CampoFormulario;
    }  

public int getSize() {
    return this.listBG_CampoFormulario.size();
  }
  public void onEdit(RowEditEvent event) {
    BG_CampoFormularioDto model = (BG_CampoFormularioDto)event.getObject();
    this.selected = model;
    update();
  }
  public void onCancel(RowEditEvent event) {
    //Complete this method 
  }
public void render(){
    try {
        listBG_CampoFormulario = findAll();
    } catch (SQLException ex) {
        //Exception
    }
}
}