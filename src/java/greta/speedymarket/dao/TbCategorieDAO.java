/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.dao;

import greta.speedymarket.model.TbCategorie;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbCategorieDAO")
public class TbCategorieDAO {

    public void save(TbCategorie categorie) {
        System.out.println("persist categorie");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(categorie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void update(TbCategorie categorie) {
        System.out.println("merge categorie " + categorie.getIdCategorie() + " - " + categorie.getCLibelle());
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(categorie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();

        }

    }

    public void remove(TbCategorie categorie) {

        System.out.println("Suppression du categorie " + categorie);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction();

            session.delete(categorie);

            session.getTransaction().commit();

        } catch (RuntimeException e) {

            e.printStackTrace();

            session.getTransaction().rollback();

        }

    }

    public List<TbCategorie> findAll() {

        List<TbCategorie> lesCategories = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction();

            lesCategories = session.createQuery("from TbCategorie").list();

            session.getTransaction().commit();

        } catch (RuntimeException e) {

            e.printStackTrace();

            session.getTransaction().rollback();

        }

        return lesCategories;

    }
}

