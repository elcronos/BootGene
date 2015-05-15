//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 23	Mes: 03	Año :2015
//--		CLASE DAO: EN_EnfermeraDao
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
import Model.EN_EnfermeraDto;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.faces.event.ActionEvent;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="EN_EnfermeraController")
@SessionScoped
public class EN_EnfermeraDao implements Serializable {

public EN_EnfermeraDto selected;
private ArrayList<EN_EnfermeraDto> listEN_Enfermera;
private String enfeBusq="";
private String nameTable;

private void inicializaDao(){
	nameTable = "EN_Enfermera";
	selected= new EN_EnfermeraDto();
    try {
        listEN_Enfermera = findAll();
    } catch (SQLException ex) {
        Logger.getLogger(EN_EnfermeraDao.class.getName()).log(Level.SEVERE, null, ex);
    }
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
		pst.setDate( 5, this.simpleFormatDate(selected.getFecha()));
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

public List<EN_EnfermeraDto> findAllByName() throws SQLException{
	List<EN_EnfermeraDto> listaDto= new ArrayList<>();
	PoolConectDB pc=null;
	try {
		pc = new PoolConectDB();
		Statement select= pc.getConnection().createStatement();
		String sql="Select * from "+getNametable()+
                        " where nombrecomple like '%"+this.enfeBusq+"%' "
                        + " order by lower(nombrecomple)"
                        ;
		ResultSet result= select.executeQuery(sql);
		
                while (result.next()) {
                    listaDto.add(createDto(result));
                }
                
	} catch (SQLException ex) {
	}finally{
		pc.closeConnection();
	}
	return listaDto;
}

public void buscaEnfermera(){
    try {
        this.setListEN_Enfermera((ArrayList<EN_EnfermeraDto>) this.findAllByName());
    } catch (SQLException ex) {
        Logger.getLogger(EN_PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void eventoBuscar(){    
    System.out.println("PRUEBA CAMILO ENFERMERA");
    if(this.enfeBusq.length()>3){
        buscaEnfermera();
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

    public String getEnfeBusq() {
        return enfeBusq;
    }

    public void setEnfeBusq(String enfeBusq) {
        this.enfeBusq = enfeBusq;
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

public String getEdad() {
    Date fechaNacimiento= this.getSelected().getFecha();
		if (fechaNacimiento != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			StringBuilder result = new StringBuilder();
			if (fechaNacimiento != null) {
				result.append(sdf.format(fechaNacimiento));
				result.append(" (");
				Calendar c = new GregorianCalendar();
				c.setTime(fechaNacimiento);
				result.append(calcularEdad(c));
				result.append(" años)");
			}
			return result.toString();
		}
		return "";
}

private int calcularEdad(Calendar fechaNac) {
		Calendar today = Calendar.getInstance();
		int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
		// Si está en ese año pero todavía no los ha cumplido
		if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
			diffYear = diffYear - 1; 
		}
		return diffYear;
}

public int getSize() {
    return this.listEN_Enfermera.size();
  }
  public void onEdit(RowEditEvent event) {
    EN_EnfermeraDto model = (EN_EnfermeraDto)event.getObject();
    this.selected = model;
    try {
        update();
    } catch (SQLException ex) {
        Logger.getLogger(EN_EnfermeraDao.class.getName()).log(Level.SEVERE, null, ex);
    }
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