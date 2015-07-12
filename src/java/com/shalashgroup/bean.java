/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shalashgroup;


import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author AhmedBek
 */
@ManagedBean
@RequestScoped
public class bean {
private List<Patient> patient=null;
private static SessionFactory factory;
    
    public bean() {
        listadmin();
       
    }
     public void execute() {
      System.out.println("Im too young");
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "Hi Ya M3lem"));
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }
    Patient pat=new Patient();
    public void listadmin() {

        factory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
           patient=new ArrayList<>();
            Transaction tx = null;
            
            patient = (List) session.createQuery("FROM Patient").list();
            if (tx != null) {
                tx.rollback();
            }
        } catch (Exception e) {
            e.getStackTrace();

        } finally {
            session.close();
        }
    }
    
}
