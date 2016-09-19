package greta.speedymarket.dao;

import greta.speedymarket.model.TbPreparateur;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

@ManagedBean(name = "TbPreparateurDAO")
public class TbPreparateurDAO {

    public void save(TbPreparateur preparateur) {
        System.out.println("persist preparateur");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(preparateur);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void update(TbPreparateur preparateur) {
        System.out.println(
                "merge preparateur " + preparateur.getIdPersonne()+ " - " + preparateur
                .getTbPersonne().getPNom() + preparateur.getTbPersonne().getPPrenom());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.update(preparateur);
            session.getTransaction().commit();

        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public void remove(TbPreparateur preparateur) {
        System.out.println("Suppression du preparateur " + preparateur);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.delete(preparateur);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<TbPreparateur> findAll() {
        List<TbPreparateur> lesPreparateurs = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesPreparateurs = session.createQuery("from TbPreparateur").list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return lesPreparateurs;
    }

}
