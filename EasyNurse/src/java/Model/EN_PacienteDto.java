//------------------------------------------------------------------------------------------------
//--		Generado Automaticamente por MPDF(MetaProgrammingFaces)
//--		Dia: 23	Mes: 03	Año :2015
//--		CLASE DTO: EN_PacienteDto
//------------------------------------------------------------------------------------------------
package Model;

//------------------------------------------------------------------------------------------------
//--		Imports
//------------------------------------------------------------------------------------------------
import java.io.*;
import DB.PoolConectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.faces.bean.ManagedBean;

//------------------------------------------------------------------------------------------------
@ManagedBean(name = "EN_PacienteModel")
public class EN_PacienteDto implements Serializable {

//------------------------------------------------------------------------------------------------
//--		Constructora
//------------------------------------------------------------------------------------------------
    public EN_PacienteDto() {
        id = secuencia();
    }

//------------------------------------------------------------------------------------------------
    private int id;
    private String nombreComple;
    private String numeDocu;
    private Date fechNaci;

//------------------------------------------------------------------------------------------------
//--		GET's y SET's
//------------------------------------------------------------------------------------------------
    public String toString(){return this.nombreComple.toUpperCase();}
//--------------------------------------id----------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//--------------------------------------nombreComple----------------------------------------------

    public String getNombrecomple() {
        return nombreComple;
    }

    public void setNombrecomple(String nombreComple) {
        this.nombreComple = nombreComple;
    }
//--------------------------------------numeDocu----------------------------------------------

    public String getNumedocu() {
        return numeDocu;
    }

    public void setNumedocu(String numeDocu) {
        this.numeDocu = numeDocu;
    }
//--------------------------------------fechNaci----------------------------------------------

    public Date getFechnaci() {
        return fechNaci;
    }

    public void setFechnaci(Date fechNaci) {
        this.fechNaci = fechNaci;
    }

//------------------------------------------------------------------------------------------------
    public int secuencia() {
        int sec = 0;
        try {
            PoolConectDB p = new PoolConectDB();
            Statement s = p.getConnection().createStatement();
            for (ResultSet rs = s.executeQuery("select max(id) from EN_Paciente"); rs.next();) {
                sec = rs.getInt(1);
            }

            p.getConnection().close();
        } catch (SQLException ex) {

        }
        return sec + 1;
    }

    public void insert() throws SQLException {
        PoolConectDB pc = new PoolConectDB();
        PreparedStatement st = null;
        try {

            String sql = " insert into EN_Paciente ("
                    + "id,"
                    + "nombreComple,"
                    + "numeDocu,"
                    + " fechNaci "
                    + ") values(?,?,?,?) ";

            st = pc.getConnection().prepareStatement(sql);
            st.setInt(1, getId());
            st.setString(2, getNombrecomple());
            st.setString(3, getNumedocu());
            st.setDate(4, new java.sql.Date(getFechnaci().getTime()));
            st.execute();
        } finally {
            pc.getConnection().close();
        }
    }

}
