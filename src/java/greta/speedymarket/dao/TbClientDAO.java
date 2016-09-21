/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.dao;

import greta.speedymarket.model.TbClient;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbClientDAO")
public class TbClientDAO {
    
    public void save(TbClient client) {
        System.out.println("persist client");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void update(TbClient client) {
        System.out.println("merge client " + client.getIdPersonne());
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void remove(TbClient client) {
        System.out.println("Suppression du categorie " + client);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<TbClient> findAll() {
        List<TbClient> lesClients = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesClients = session.createQuery("from TbClient").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();

            session.getTransaction().rollback();
        }
        return lesClients;
    }
}
