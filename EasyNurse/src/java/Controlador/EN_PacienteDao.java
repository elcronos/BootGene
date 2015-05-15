//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 23	Mes: 03	Año :2015
//--		CLASE DAO: EN_PacienteDao
//------------------------------------------------------------------------------------------------

package Controlador;

//------------------------------------------------------------------------------------------------
//--		Imports
//------------------------------------------------------------------------------------------------

import java.util.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.RowEditEvent;
import DB.PoolConectDB;
import Model.EN_PacienteDto;
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


@ManagedBean(name="EN_PacienteController")
@SessionScoped
public class EN_PacienteDao implements Serializable {

public EN_PacienteDto selected;
private ArrayList<EN_PacienteDto> listEN_Paciente;
private String nameTable;
private String nombBusq="";

private void inicializaDao(){
	nameTable = "EN_Paciente";
	selected= new EN_PacienteDto();
   
    try {
        listEN_Paciente = findAll();
    } catch (SQLException ex) {
        Logger.getLogger(EN_PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

public EN_PacienteDao() {
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

    public String getNombBusq() {
        return nombBusq;
    }

    public void setNombBusq(String nombBusq) {
        this.nombBusq = nombBusq;
    }


public ArrayList<EN_PacienteDto> findAll() throws SQLException{
	ArrayList<EN_PacienteDto> listaDto= new ArrayList<>();
	PoolConectDB pc=null;
	try {
		pc = new PoolConectDB();
		Statement select= pc.getConnection().createStatement();
		String sql="Select * from "+getNametable()+                   
                        " order by lower(nombreComple)"
                      
                        ;
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

public List<EN_PacienteDto> findAllByName() throws SQLException{
	List<EN_PacienteDto> listaDto= new ArrayList<>();
	PoolConectDB pc=null;
	try {
		pc = new PoolConectDB();
		Statement select= pc.getConnection().createStatement();
		String sql="Select * from "+getNametable()+
                        " where nombreComple like '%"+this.nombBusq+"%' "
                        + " order by lower(nombreComple)"
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

public void buscaPaciente(){
    try {
        this.setListEN_Paciente((ArrayList<EN_PacienteDto>) this.findAllByName());
    } catch (SQLException ex) {
        Logger.getLogger(EN_PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public String getEdad() {
    Date fechaNacimiento= this.getSelected().getFechnaci();
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


public void update() throws SQLException {
	PoolConectDB pc= new PoolConectDB();
	try{
		String sql= " update EN_Paciente set " +
		"id = ?, " +
		"nombreComple = ?, " +
		"numeDocu = ?, " +
		"fechNaci = ? " +
		" Where id = ?";
		
		PreparedStatement pst = pc.getConnection().prepareStatement(sql);
		pst.setInt( 1, selected.getId());
		pst.setString( 2, selected.getNombrecomple());
		pst.setString( 3, selected.getNumedocu());
		pst.setDate(4, this.simpleFormatDate(selected.getFechnaci()));
		pst.setInt( 5, selected.getId());
		pst.execute();
	} finally {
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


public void delete() throws SQLException {
	PoolConectDB pc = new PoolConectDB();
	try{
		String sql = "delete from EN_Paciente Where id = "+getSelected().getId();
		pc.getConnection().createStatement().execute(sql);
	} catch(Exception ex) {} finally {
		pc.closeConnection();
	}
}










//------------------------------------------------------------------------------------------------
//--		CreateDto
//------------------------------------------------------------------------------------------------

private EN_PacienteDto createDto(ResultSet rs) throws SQLException {
	EN_PacienteDto retorno = new EN_PacienteDto();
	retorno.setId (rs.getInt("id"));
	retorno.setNombrecomple (rs.getString("nombreComple"));
	retorno.setNumedocu (rs.getString("numeDocu"));
	retorno.setFechnaci (rs.getDate("fechNaci"));
	return retorno;
}



//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------selected----------------------------------------------

public EN_PacienteDto getSelected(){return selected;}
public void setSelected(EN_PacienteDto selected){this.selected = selected;}

//------------------------------------------------------------------------------------------------

 //Otros Metodos
public ArrayList<EN_PacienteDto> getListEN_Paciente() {
        return listEN_Paciente;
    }

    public void setListEN_Paciente(ArrayList<EN_PacienteDto> listEN_Paciente) {
        this.listEN_Paciente = listEN_Paciente;
    }  

public int getSize() {
    return this.listEN_Paciente.size();
  }
 
public void onEdit(RowEditEvent event) {
    EN_PacienteDto model = (EN_PacienteDto)event.getObject();
    this.selected = model;
    try {
        update();
    } catch (SQLException ex) {
        Logger.getLogger(EN_PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  public void onCancel(RowEditEvent event) {
    //Complete this method 
  }
public void render(){
    try {
        listEN_Paciente = findAll();
    } catch (SQLException ex) {
        //Exception
    }
}

public void eventoBuscar(){
    System.out.println("PRUEBA CAMILO PACIENTE");
    if(this.nombBusq.length()>2){
        buscaPaciente();
    }
}

}