/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author camilo
 */
@ManagedBean(name="Schedule")
public class ScheduleBean {

    private ScheduleModel model;
    
    

    public ScheduleBean() {
       model.addEvent(new DefaultScheduleEvent("Evento1", new Date(), new Date()));      
       model.addEvent(new DefaultScheduleEvent("Evento2", new Date(), new Date()));
    }

    public ScheduleModel getModel() {
        return model;
    }
}
