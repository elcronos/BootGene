package Controlador;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Stack;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="nav")
@SessionScoped
public class NavBean
    implements Serializable
{
    private String page;
    private Stack<String> pilaNav;
    private boolean logged;
    
    //RUTAS
    
    private final  String ADMIN="Administrador/views/Admin.xhtml";
    private final String SIGNIN= "Signin.xhtml";
    
    
    private String ruta;
    
    
    public NavBean()
    {
        
        this.ruta=ADMIN;
        this.page="dashboard";
        pilaNav= new Stack();
    }

    public String getPage()
    {
        return page;
    }

    public void setPage(String page)
    {
        this.page = page;
    }

    public void printPage()
    {
        System.out.println(page);
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
    
    

    public void redirige(String page)
    {
        this.page = page;
        
    }
    //Metodo para ir a una pagina
    public void goPage(String page){
        //Graba la pagina actual
        pilaNav.push(this.getPage());
        this.setPage(page);
        //Pagina a la que va
        pilaNav.push(this.getPage());            
    }
    
    public void goBack(){
       String v="";
       
       if(!pilaNav.empty()){
           
          if(pilaNav.peek().equals(page)){
              pilaNav.pop();
          } 
          if(!pilaNav.empty()){
            v= pilaNav.pop().toString();
            this.setPage(v);
          }
       }
    }
    
    public String ruta(){
        return ruta;
    }
    
    public String login(){
        System.out.println("LOGIN");
        //Metodo para validar loggin
        this.logged=true;
        
        ruta=ADMIN;
        this.setPage("dashboard");
        
        return ruta;
    }
    
    public String logout(){
        
        this.ruta=SIGNIN;
        return ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    
    
    
}
