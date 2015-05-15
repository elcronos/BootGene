//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 4	Mes: 14	Año :2015
//--		CLASE DAO: EN_ServicioDao
//------------------------------------------------------------------------------------------------

package Controlador;

//------------------------------------------------------------------------------------------------
//--		Imports
//------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.RowEditEvent;
import DB.PoolConectDB;
import Model.EN_ServicioDto;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="EN_ServicioController")
@SessionScoped
public class EN_ServicioDao implements Serializable {

public EN_ServicioDto selected;
private ArrayList<EN_ServicioDto> listEN_Servicio;
private String nameTable;

private void inicializaDao(){
	nameTable = "EN_Servicio";
	selected= new EN_ServicioDto();
    try {
        listEN_Servicio = findAll();
    } catch (SQLException ex) {
        Logger.getLogger(EN_ServicioDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public EN_ServicioDao() {
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


public ArrayList<EN_ServicioDto> findAll() throws SQLException{
	ArrayList<EN_ServicioDto> listaDto= new ArrayList<EN_ServicioDto>();
	PoolConectDB pc=null;
	try {
		pc = new PoolConectDB();
		Statement select= pc.getConnection().createStatement();
		String sql="Select * from "+getNametable()+" order by fechaservicio desc";
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
		String sql= " update EN_Servicio set " +
		"id = ?, " +
		"fechacreacion = ?, " +
		"fechaservicio = ?, " +
		"tiposervicio = ?, " +
		"jornada = ?, " +
		"direccion = ?, " +
		"observaciones = ?, " +
		"estadonovedad = ?, " +
		"diagnostico = ?, " +
		"fkpaciente = ?, " +
		"idenfermera = ? " +
		" Where id = ?";
		
		PreparedStatement pst = pc.getConnection().prepareStatement(sql);
		pst.setInt( 1, selected.getId());
		pst.setDate( 2, this.simpleFormatDate(selected.getFechacreacion()));
		pst.setDate( 3, this.simpleFormatDate(selected.getFechaservicio()));
		pst.setString( 4, selected.getTiposervicio());
		pst.setString( 5, selected.getJornada());
		pst.setString( 6, selected.getDireccion());
		pst.setString( 7, selected.getObservaciones());
		pst.setString( 8, selected.getEstadonovedad());
		pst.setString( 9, selected.getDiagnostico());
		pst.setInt( 10, selected.getFkpaciente());
		pst.setInt( 11, selected.getIdenfermera());
		pst.setInt( 12, selected.getId());
		pst.execute();
	} finally {
		pc.closeConnection();
	}
}
public void delete() throws SQLException {
	PoolConectDB pc = new PoolConectDB();
	try{
		String sql = "delete from EN_Servicio Where id = "+getSelected().getId();
		pc.getConnection().createStatement().execute(sql);
	} catch(Exception ex) {} finally {
		pc.closeConnection();
	}
}

private java.sql.Date simpleFormatDate(java.util.Date date){
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    String fecha= DATE_FORMAT.format(date);
    java.sql.Date sql=null;
    try {
        sql = new java.sql.Date(DATE_FORMAT.parse(fecha).getTime());
    } catch (ParseException ex) {
        System.out.println("Error en conversión de fecha");
    }
    return sql;  
}








//------------------------------------------------------------------------------------------------
//--		CreateDto
//------------------------------------------------------------------------------------------------

private EN_ServicioDto createDto(ResultSet rs) throws SQLException {
	EN_ServicioDto retorno = new EN_ServicioDto();
	retorno.setId (rs.getInt("id"));
	retorno.setFechacreacion (rs.getDate("fechacreacion"));
	retorno.setFechaservicio (rs.getDate("fechaservicio"));
	retorno.setTiposervicio (rs.getString("tiposervicio"));
	retorno.setJornada (rs.getString("jornada"));
	retorno.setDireccion (rs.getString("direccion"));
	retorno.setObservaciones (rs.getString("observaciones"));
	retorno.setEstadonovedad (rs.getString("estadonovedad"));
	retorno.setDiagnostico (rs.getString("diagnostico"));
	retorno.setFkpaciente (rs.getInt("fkpaciente"));
	retorno.setIdenfermera (rs.getInt("idenfermera"));
	return retorno;
}



//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------selected----------------------------------------------

public EN_ServicioDto getSelected(){return selected;}
public void setSelected(EN_ServicioDto selected){this.selected = selected;}

//------------------------------------------------------------------------------------------------

 //Otros Metodos
public ArrayList<EN_ServicioDto> getListEN_Servicio() {
        return listEN_Servicio;
    }

    public void setListEN_Servicio(ArrayList<EN_ServicioDto> listEN_Servicio) {
        this.listEN_Servicio = listEN_Servicio;
    }  

public int getSize() {
    return this.listEN_Servicio.size();
  }
  public void onEdit(RowEditEvent event) {
    EN_ServicioDto model = (EN_ServicioDto)event.getObject();
    this.selected = model;
    try {
        update();
    } catch (SQLException ex) {
        Logger.getLogger(EN_ServicioDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  public void onCancel(RowEditEvent event) {
    //Complete this method 
  }
public void render(){
    try {
        listEN_Servicio = findAll();
    } catch (SQLException ex) {
        //Exception
    }
}
}