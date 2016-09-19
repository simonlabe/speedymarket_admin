package greta.speedymarket.services;

import greta.speedymarket.dao.TbPreparateurDAO;
import greta.speedymarket.model.TbPreparateur;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbPreparateurService")
@ViewScoped
public class TbPreparateurService {

    private TbPreparateur selectedPreparateur;

    public TbPreparateur getSelectedPreparateur() {
        return this.selectedPreparateur;
    }

    public void setSelectedPreparateur(TbPreparateur selectedPreparateur) {
        this.selectedPreparateur = selectedPreparateur;
    }

    public void createStatut() {
        TbPreparateur newStatut = new TbPreparateur();
        TbPreparateurDAO tbStatutDAO = new TbPreparateurDAO();
        tbStatutDAO.save(newStatut);
    }

    public void saveStatut(TbPreparateur statut) {
        if (statut != null) {
            TbPreparateurDAO tbStatutDAO = new TbPreparateurDAO();
            tbStatutDAO.update(statut);
        }
    }

    public void deleteStatut(TbPreparateur statut) {
        if (statut != null) {
            TbPreparateurDAO tbStatutDAO = new TbPreparateurDAO();
            tbStatutDAO.remove(statut);
        }
    }

    public List<TbPreparateur> loadStatuts() {
        TbPreparateurDAO tbStatutDAO = new TbPreparateurDAO();
        return tbStatutDAO.findAll();
    }
}
