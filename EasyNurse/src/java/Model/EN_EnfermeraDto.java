//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 23	Mes: 03	Año :2015
//--		CLASE DTO: EN_EnfermeraDto
//------------------------------------------------------------------------------------------------

package Model;

//------------------------------------------------------------------------------------------------
//--		Imports
//------------------------------------------------------------------------------------------------

import java.io.*;
import DB.PoolConectDB;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

//------------------------------------------------------------------------------------------------


@ManagedBean(name="EN_EnfermeraModel")
public class EN_EnfermeraDto implements Serializable {


//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------

public EN_EnfermeraDto(){
	id= secuencia();
}

//------------------------------------------------------------------------------------------------



private int id;
private String nombreComple;
private String numeDocu;
private String ciudad;
private Date fecha;
private String numeCelu;
private String correo;
private String nombBanc;
private String tipoCuenta;
private String numeroCuenta;

//------------------- COMBOS -----------------------------------------------------
private SelectItem comboBanco[] = {
        new SelectItem("Bancafé", "Bancafé"), new SelectItem("Banco AV Villas", "Banco AV Villas"), 
        new SelectItem("BBVA", "BBVA"), new SelectItem("Banco Caja Social BCSC","Banco Caja Social BCSC"),
        new SelectItem("Banco de Bogotá", "Banco de Bogotá"), new SelectItem("Banco de Credito", "Banco de Credito"), 
        new SelectItem("Banco de la República de Colombia", "Banco de la República de Colombia"), new SelectItem("Banco de Occidente","Banco de Occidente"),
        new SelectItem("Banco GNB Sudameris", "Banco GNB Sudameris"), new SelectItem("Banco Granahorrar", "Banco Granahorrar"), 
        new SelectItem("Banco Popular", "Banco Popular"), new SelectItem("Banco Santander","Banco Santander"),
        new SelectItem("Bancoldex", "Bancoldex"), new SelectItem("Bancolombia", "Bancolombia"), 
        new SelectItem("Banco Ganadero", "Banco Ganadero"), new SelectItem("Citi Bank","Citi Bank"),
        new SelectItem("Colmena BCSC", "Colmena BCSC"), new SelectItem("Colpatria", "Colpatria"), 
        new SelectItem("Conavi", "Conavi"), new SelectItem("Conavi","Conavi"),
        new SelectItem("Davivienda", "Davivienda"), new SelectItem("Deutsche Bank", "Deutsche Bank"), 
        new SelectItem("Helm Financial Services", "Helm Financial Services"), new SelectItem("Megabanco","Megabanco")
        
 };

private SelectItem comboCuenta[] = {
        new SelectItem("Ahorros", "Ahorros"), new SelectItem("Corriente", "Corriente")       
};

//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------

public String toString(){return this.nombreComple.toUpperCase();}

//--------------------------------------id----------------------------------------------

public int getId(){return id;}
public void setId(int id){this.id = id;}
//--------------------------------------nombreComple----------------------------------------------

public String getNombrecomple(){return nombreComple;}
public void setNombrecomple(String nombreComple){this.nombreComple = nombreComple;}
//--------------------------------------numeDocu----------------------------------------------

public String getNumedocu(){return numeDocu;}
public void setNumedocu(String numeDocu){this.numeDocu = numeDocu;}
//--------------------------------------ciudad----------------------------------------------

public String getCiudad(){return ciudad;}
public void setCiudad(String ciudad){this.ciudad = ciudad;}
//--------------------------------------fecha----------------------------------------------

public Date getFecha(){return fecha;}
public void setFecha(Date fecha){this.fecha = fecha;}
//--------------------------------------numeCelu----------------------------------------------

public String getNumecelu(){return numeCelu;}
public void setNumecelu(String numeCelu){this.numeCelu = numeCelu;}
//--------------------------------------correo----------------------------------------------

public String getCorreo(){return correo;}
public void setCorreo(String correo){this.correo = correo;}
//--------------------------------------nombBanc----------------------------------------------

public String getNombbanc(){return nombBanc;}
public void setNombbanc(String nombBanc){this.nombBanc = nombBanc;}
//--------------------------------------tipoCuenta----------------------------------------------

public String getTipocuenta(){return tipoCuenta;}
public void setTipocuenta(String tipoCuenta){this.tipoCuenta = tipoCuenta;}
//--------------------------------------numeroCuenta----------------------------------------------

public String getNumerocuenta(){return numeroCuenta;}
public void setNumerocuenta(String numeroCuenta){this.numeroCuenta = numeroCuenta;}

//------------------------------------------------------------------------------------------------

    public SelectItem[] getComboBanco() {
        return comboBanco;
    }

    public void setComboBanco(SelectItem[] comboBanco) {
        this.comboBanco = comboBanco;
    }

    public SelectItem[] getComboCuenta() {
        return comboCuenta;
    }

    public void setComboCuenta(SelectItem[] comboCuenta) {
        this.comboCuenta = comboCuenta;
    }

    


public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(id) from EN_Enfermera"); rs.next();) {
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
	
		String sql = " insert into EN_Enfermera (" +
		"id," +
		"nombreComple," +
		"numeDocu," +
		"ciudad," +
		"fecha," +
		"numeCelu," +
		"correo," +
		"nombBanc," +
		"tipoCuenta," +
		" numeroCuenta " +
		") values(?,?,?,?,?,?,?,?,?,?) ";

		st = pc.getConnection().prepareStatement(sql);
		st.setInt( 1, getId());
		st.setString( 2, getNombrecomple());
		st.setString( 3, getNumedocu());
		st.setString( 4, getCiudad());
		st.setDate( 5, new java.sql.Date(this.getFecha().getTime()));
		st.setString( 6, getNumecelu());
		st.setString( 7, getCorreo());
		st.setString( 8, getNombbanc());
		st.setString( 9, getTipocuenta());
		st.setString( 10, getNumerocuenta());
		st.execute();
	} finally {
		pc.getConnection().close();
	}
}


}