package greta.speedymarket.dao;

import greta.speedymarket.model.TbPersonne;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

@ManagedBean(name = "TbPersonneDAO")
public class TbPersonneDAO {

    public void save(TbPersonne personne) {
        System.out.println("persist personne");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(personne);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void update(TbPersonne personne) {
        System.out.println(
                "merge personne " + personne.getIdPersonne()+ " - " + personne
                .getPNom() + personne.getPPrenom());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.update(personne);
            session.getTransaction().commit();

        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public void remove(TbPersonne personne) {
        System.out.println("Suppression du personne " + personne);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.delete(personne);
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<TbPersonne> findAll() {
        List<TbPersonne> lesPersonnes = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesPersonnes = session.createQuery("from TbPersonne").list();
            session.getTransaction().commit();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return lesPersonnes;
    }

}
