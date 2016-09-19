package greta.speedymarket.services;

import greta.speedymarket.dao.TbLigneCommandeIdDAO;
import greta.speedymarket.model.TbLigneCommandeId;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbLigneCommandeIdService")
@ViewScoped
public class TbLigneCommandeIdService {

    private TbLigneCommandeId selectedPersonne;

    public TbLigneCommandeId getSelectedPersonne() {
        return this.selectedPersonne;
    }

    public void setSelectedPersonne(TbLigneCommandeId selectedPersonne) {
        this.selectedPersonne = selectedPersonne;
    }

    public void createStatut() {
        TbLigneCommandeId newLigneCommandeId = new TbLigneCommandeId();
        TbLigneCommandeIdDAO tbLigneCommandeIdDAO = new TbLigneCommandeIdDAO();
        tbLigneCommandeIdDAO.save(newLigneCommandeId);
    }

    public void saveStatut(TbLigneCommandeId personne) {
        if (personne != null) {
            TbLigneCommandeIdDAO tbLigneCommandeIdDAO = new TbLigneCommandeIdDAO();
            tbLigneCommandeIdDAO.update(personne);
        }
    }

    public void deleteStatut(TbLigneCommandeId personne) {
        if (personne != null) {
            TbLigneCommandeIdDAO tbLigneCommandeIdDAO = new TbLigneCommandeIdDAO();
            tbLigneCommandeIdDAO.remove(personne);
        }
    }

    public List<TbLigneCommandeId> loadPersonnes() {
        TbLigneCommandeIdDAO tbPersonneDAO = new TbLigneCommandeIdDAO();
        return tbPersonneDAO.findAll();
    }
}
