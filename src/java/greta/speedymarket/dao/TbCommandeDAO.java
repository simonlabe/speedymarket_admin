/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.dao;

import greta.speedymarket.model.TbCommande;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbCommandeDAO")
public class TbCommandeDAO {
    
    public void save(TbCommande commande) {
        System.out.println("persist commande");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(commande);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void update(TbCommande commande) {
        System.out.println("merge client " + commande.getIdCommande());
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(commande);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void remove(TbCommande commande) {
        System.out.println("Suppression du categorie " + commande);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(commande);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<TbCommande> findAll() {
        List<TbCommande> lesCommandes = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesCommandes = session.createQuery("from TbCommande").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();

            session.getTransaction().rollback();
        }
        return lesCommandes;
    }
}
