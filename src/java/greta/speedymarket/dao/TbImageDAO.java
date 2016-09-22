package greta.speedymarket.dao;

import greta.speedymarket.model.TbImage;

import greta.speedymarket.services.HibernateUtil;

import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

@ManagedBean(name = "TbImageDAO")

public class TbImageDAO {

    public void save(TbImage image) {

        System.out.println("persist image");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction();

            session.save(image);

            session.getTransaction().commit();

        } catch (RuntimeException e) {

            e.printStackTrace();

            session.getTransaction().rollback();

        }

    }

    public void update(TbImage image) {

        System.out.println("merge image " + statut.getIdImage() + " - " + image.getSLibelle());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction();

            session.update(image);

            session.getTransaction().commit();

        } catch (RuntimeException e) {

            e.printStackTrace();

            session.getTransaction().rollback();

        }

    }

    public void remove(TbImage image) {

        System.out.println("Suppression de l'image " + image);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction();

            session.delete(image);

            session.getTransaction().commit();

        } catch (RuntimeException e) {

            e.printStackTrace();

            session.getTransaction().rollback();

        }

    }

    public List<TbImage> findAll() {

        List<TbImage> lesImages = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            session.beginTransaction();

            lesImages = session.createQuery("from TbImage").list();

            session.getTransaction().commit();

        } catch (RuntimeException e) {

            e.printStackTrace();

            session.getTransaction().rollback();

        }

        return lesImages;

    }

}
