//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 4	Mes: 14	Año :2015
//--		CLASE DTO: EN_ServicioDto
//------------------------------------------------------------------------------------------------

package Model;

//------------------------------------------------------------------------------------------------
//--		Imports
//------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Date;
import DB.PoolConectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="EN_ServicioModel")
public class EN_ServicioDto implements Serializable {


//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------

public EN_ServicioDto(){
	id= secuencia();
}

//------------------------------------------------------------------------------------------------



private int id;
private Date fechacreacion;
private Date fechaservicio;
private String tiposervicio;
private String jornada;
private String direccion;
private String observaciones;
private String estadonovedad;
private String diagnostico;
private int fkpaciente;
private int idenfermera;


private SelectItem comboServicio[] = {
        new SelectItem("Domiciliario", "Domiciliario"),
         new SelectItem("Hospitalario", "Hospitalario")
};

private SelectItem comboJornada[] = {
        new SelectItem("Mañana", "Mañana"), new SelectItem("Tarde", "Tarde"),
        new SelectItem("Completo", "Completo"), 
        new SelectItem("Mañana Festivo", "Mañana Festivo"), new SelectItem("Tarde Festivo", "Tarde Festivo"), 
        new SelectItem("Completo Festivo", "Completo Festivo")
};


//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

//public String toString(){Agregue el retorno del toString}

//--------------------------------------id----------------------------------------------

public int getId(){return id;}
public void setId(int id){this.id = id;}
//--------------------------------------fechacreacion----------------------------------------------

public Date getFechacreacion(){return fechacreacion;}
public void setFechacreacion(Date fechacreacion){this.fechacreacion = fechacreacion;}
//--------------------------------------fechaservicio----------------------------------------------

public Date getFechaservicio(){return fechaservicio;}
public void setFechaservicio(Date fechaservicio){this.fechaservicio = fechaservicio;}
//--------------------------------------tiposervicio----------------------------------------------

public String getTiposervicio(){return tiposervicio;}
public void setTiposervicio(String tiposervicio){this.tiposervicio = tiposervicio;}
//--------------------------------------jornada----------------------------------------------

public String getJornada(){return jornada;}
public void setJornada(String jornada){this.jornada = jornada;}
//--------------------------------------direccion----------------------------------------------

public String getDireccion(){return direccion;}
public void setDireccion(String direccion){this.direccion = direccion;}
//--------------------------------------observaciones----------------------------------------------

public String getObservaciones(){return observaciones;}
public void setObservaciones(String observaciones){this.observaciones = observaciones;}
//--------------------------------------estadonovedad----------------------------------------------

public String getEstadonovedad(){return estadonovedad;}
public void setEstadonovedad(String estadonovedad){this.estadonovedad = estadonovedad;}
//--------------------------------------diagnostico----------------------------------------------

public String getDiagnostico(){return diagnostico;}
public void setDiagnostico(String diagnostico){this.diagnostico = diagnostico;}
//--------------------------------------fkpaciente----------------------------------------------

public int getFkpaciente(){return fkpaciente;}
public void setFkpaciente(int fkpaciente){this.fkpaciente = fkpaciente;}
//--------------------------------------idenfermera----------------------------------------------

public int getIdenfermera(){return idenfermera;}
public void setIdenfermera(int idenfermera){this.idenfermera = idenfermera;}

//------------------------------------------------------------------------------------------------

public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(id) from EN_Servicio"); rs.next();) {
                sec = rs.getInt(1);
            }

            p.getConnection().close();
        } catch (SQLException ex) {

        }
        return sec + 1;
}

public void insert() throws SQLException{
        pruebaDatos();
	PoolConectDB pc = new PoolConectDB();
	PreparedStatement st = null;
	try{
	
		String sql = " insert into EN_Servicio (" +
		"id," +
		"fechacreacion," +
		"fechaservicio," +
		"tiposervicio," +
		"jornada," +
		"direccion," +
		"observaciones," +
		"estadonovedad," +
		"diagnostico," +
		"fkpaciente," +
		" idenfermera " +
		") values(?,?,?,?,?,?,?,?,?,?,?) ";

		st = pc.getConnection().prepareStatement(sql);
		st.setInt( 1, getId());
		st.setDate( 2, new java.sql.Date(this.getFechacreacion().getTime()));
		st.setDate( 3, new java.sql.Date(this.getFechaservicio().getTime()));
		st.setString( 4, getTiposervicio());
		st.setString( 5, getJornada());
		st.setString( 6, getDireccion());
		st.setString( 7, getObservaciones());
		st.setString( 8, getEstadonovedad());
		st.setString( 9, getDiagnostico());
		st.setInt( 10, getFkpaciente());
		st.setInt( 11, getIdenfermera());
		st.execute();
	} finally {
		pc.getConnection().close();
	}
}

public void pruebaDatos(){
    System.out.println(this.fechacreacion+" "+this.fechaservicio+" "+this.estadonovedad+" "+this.tiposervicio+" "+this.direccion);
}

public void llenarCampos(){
    //Dia de hoy
    this.setFechacreacion(new Date());
    //Asignado
    this.setEstadonovedad("AS");
    System.out.println("Llenar Campos");
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

    public SelectItem[] getComboServicio() {
        return comboServicio;
    }

    public void setComboServicio(SelectItem[] comboServicio) {
        this.comboServicio = comboServicio;
    }

    public SelectItem[] getComboJornada() {
        return comboJornada;
    }

    public void setComboJornada(SelectItem[] comboJornada) {
        this.comboJornada = comboJornada;
    }



}