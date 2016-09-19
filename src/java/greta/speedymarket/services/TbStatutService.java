package greta.speedymarket.services;

import greta.speedymarket.dao.TbStatutDAO;
import greta.speedymarket.model.TbStatut;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbStatutService")
@ViewScoped
public class TbStatutService {

    private TbStatut selectedStatut;

    public TbStatut getSelectedStatut() {
        return this.selectedStatut;
    }

    public void setSelectedStatut(TbStatut selectedStatut) {
        this.selectedStatut = selectedStatut;
    }

    public void createStatut() {
        TbStatut newStatut = new TbStatut("Nouveau statut");
        TbStatutDAO tbStatutDAO = new TbStatutDAO();
        tbStatutDAO.save(newStatut);
    }

    public void saveStatut(TbStatut statut) {
        if (statut != null) {
            TbStatutDAO tbStatutDAO = new TbStatutDAO();
            tbStatutDAO.update(statut);
        }
    }

    public void deleteStatut(TbStatut statut) {
        if (statut != null) {
            TbStatutDAO tbStatutDAO = new TbStatutDAO();
            tbStatutDAO.remove(statut);
        }
    }

    public List<TbStatut> loadStatuts() {
        TbStatutDAO tbStatutDAO = new TbStatutDAO();
        return tbStatutDAO.findAll();
    }
}
