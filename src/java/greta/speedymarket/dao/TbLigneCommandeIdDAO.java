package greta.speedymarket.dao;

import greta.speedymarket.model.TbLigneCommandeId;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

@ManagedBean(name = "TbLigneCommandeIdDAO")
public class TbLigneCommandeIdDAO {

    public void save(TbLigneCommandeId ligneCommandeId) {
        System.out.println("persist ligneCommandeId");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(ligneCommandeId);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void update(TbLigneCommandeId ligneCommandeId) {
        System.out.println(
                "merge ligneCommandeId " + ligneCommandeId.hashCode() + " - " + ligneCommandeId
                .hashCode());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.update(ligneCommandeId);
            session.getTransaction().commit();

        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public void remove(TbLigneCommandeId ligneCommandeId) {
        System.out.println("Suppression du ligneCommandeId " + ligneCommandeId);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.delete(ligneCommandeId);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<TbLigneCommandeId> findAll() {
        List<TbLigneCommandeId> lesLigneCommandeId = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesLigneCommandeId = session.createQuery("from TbLigneCommandeId").list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return lesLigneCommandeId;
    }

}
