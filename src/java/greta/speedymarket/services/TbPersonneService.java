package greta.speedymarket.services;

import greta.speedymarket.dao.TbPersonneDAO;
import greta.speedymarket.model.TbPersonne;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbPersonneService")
@ViewScoped
public class TbPersonneService {

    private TbPersonne selectedPersonne;
    private List<TbPersonne> personnes;

    public TbPersonne getSelectedPersonne() {
        return this.selectedPersonne;
    }

    public void setSelectedPersonne(TbPersonne selectedPersonne) {
        this.selectedPersonne = selectedPersonne;
    }
    
    @PostConstruct
    public void init() {
        personnes = this.loadPersonnes();
    }

    public void onRowEdit() {
        this.savePersonne(selectedPersonne);
    }

    public void onRowEditCancel() {
        return;
    }

    public void createPersonne() {
        TbPersonne newStatut = new TbPersonne();
        TbPersonneDAO tbStatutDAO = new TbPersonneDAO();
        tbStatutDAO.save(newStatut);
    }

    public void savePersonne(TbPersonne personne) {
        if (personne != null) {
            TbPersonneDAO tbStatutDAO = new TbPersonneDAO();
            tbStatutDAO.update(personne);
        }
    }

    public void deletePersonne(TbPersonne personne) {
        if (personne != null) {
            TbPersonneDAO tbStatutDAO = new TbPersonneDAO();
            tbStatutDAO.remove(personne);
        }
    }

    public List<TbPersonne> loadPersonnes() {
        TbPersonneDAO tbPersonneDAO = new TbPersonneDAO();
        return tbPersonneDAO.findAll();
    }
}
