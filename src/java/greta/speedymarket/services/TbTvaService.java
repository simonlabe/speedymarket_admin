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

    public void createTva() {
        TbTva newStatut = new TbTva("Nouvelle Tva", 0.0f);
        TbTvaDAO tbTvaDAO = new TbTvaDAO();
        tbTvaDAO.save(newStatut);
    }

    public void saveTva(TbTva statut) {
        if (statut != null) {
            TbTvaDAO tbTvaDAO = new TbTvaDAO();
            tbTvaDAO.update(statut);
        }
    }

    public void deleteTva(TbTva statut) {
        if (statut != null) {
            TbTvaDAO tbTvaDAO = new TbTvaDAO();
            tbTvaDAO.remove(statut);
        }
    }

    public List<TbTva> loadTvas() {
        TbTvaDAO tbTvaDAO = new TbTvaDAO();
        return tbTvaDAO.findAll();
    }
}
