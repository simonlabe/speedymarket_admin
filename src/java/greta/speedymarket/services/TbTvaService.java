package greta.speedymarket.services;

import greta.speedymarket.dao.TbTvaDAO;
import greta.speedymarket.model.TbTva;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbTvaService")
@ViewScoped
public class TbTvaService {

    private TbTva selectedTva;

    public TbTva getSelectedTva() {
        return this.selectedTva;
    }

    public void setSelectedTva(TbTva selectedTva) {
        this.selectedTva = selectedTva;
    }

    public void createStatut() {
        TbTva newStatut = new TbTva("Nouvelle Tva", 0.0f);
        TbTvaDAO tbStatutDAO = new TbTvaDAO();
        tbStatutDAO.save(newStatut);
    }

    public void saveStatut(TbTva statut) {
        if (statut != null) {
            TbTvaDAO tbStatutDAO = new TbTvaDAO();
            tbStatutDAO.update(statut);
        }
    }

    public void deleteStatut(TbTva statut) {
        if (statut != null) {
            TbTvaDAO tbStatutDAO = new TbTvaDAO();
            tbStatutDAO.remove(statut);
        }
    }

    public List<TbTva> loadStatuts() {
        TbTvaDAO tbStatutDAO = new TbTvaDAO();
        return tbStatutDAO.findAll();
    }
}
