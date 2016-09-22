package greta.speedymarket.services;

import greta.speedymarket.dao.TbLigneCommandeIdDAO;
import greta.speedymarket.model.TbLigneCommandeId;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbLigneCommandeIdService")
@ViewScoped
public class TbLigneCommandeIdService {

    private TbLigneCommandeId selectedLigneCommandeId;

    public TbLigneCommandeId getSelectedLigneCommandeId() {
        return this.selectedLigneCommandeId;
    }

    public void setSelectedLigneCommandeId(TbLigneCommandeId selectedLigneCommandeId) {
        this.selectedLigneCommandeId = selectedLigneCommandeId;
    }

    public void createLigneCommandeId() {
        TbLigneCommandeId newLigneCommandeId = new TbLigneCommandeId();
        TbLigneCommandeIdDAO tbLigneCommandeIdDAO = new TbLigneCommandeIdDAO();
        tbLigneCommandeIdDAO.save(newLigneCommandeId);
    }

    public void saveLigneCommandeId(TbLigneCommandeId ligneCommandeId) {
        if (ligneCommandeId != null) {
            TbLigneCommandeIdDAO tbLigneCommandeIdDAO = new TbLigneCommandeIdDAO();
            tbLigneCommandeIdDAO.update(ligneCommandeId);
        }
    }

    public void deleteLigneCommandeId(TbLigneCommandeId ligneCommandeId) {
        if (ligneCommandeId != null) {
            TbLigneCommandeIdDAO tbLigneCommandeIdDAO = new TbLigneCommandeIdDAO();
            tbLigneCommandeIdDAO.remove(ligneCommandeId);
        }
    }

    public List<TbLigneCommandeId> loadLigneCommandeId() {
        TbLigneCommandeIdDAO tbLigneCommandeIdDAO = new TbLigneCommandeIdDAO();
        return tbLigneCommandeIdDAO.findAll();
    }
}
