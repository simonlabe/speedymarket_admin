package greta.speedymarket.dao;

import greta.speedymarket.model.TbLigneCommande;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

@ManagedBean(name = "TbLigneCommandeDAO")
public class TbLigneCommandeDAO {

    public void save(TbLigneCommande ligneCommande) {
        System.out.println("persist ligneCommande");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(ligneCommande);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void update(TbLigneCommande ligneCommande) {
        System.out.println(
                "merge ligneCommande " + ligneCommande.hashCode() + " - " + ligneCommande
                .hashCode());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.update(ligneCommande);
            session.getTransaction().commit();

        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public void remove(TbLigneCommande ligneCommande) {
        System.out.println("Suppression du ligneCommande " + ligneCommande);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.delete(ligneCommande);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<TbLigneCommande> findAll() {
        List<TbLigneCommande> lesLigneCommande = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesLigneCommande = session.createQuery("from TbLigneCommande").list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return lesLigneCommande;
    }

}
