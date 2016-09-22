package greta.speedymarket.services;

import greta.speedymarket.dao.TbLigneCommandeDAO;
import greta.speedymarket.model.TbLigneCommande;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbLigneCommandeService")
@ViewScoped
public class TbLigneCommandeService {

    private TbLigneCommande selectedLigneCommande;

    public TbLigneCommande getSelectedLigneCommande() {
        return this.selectedLigneCommande;
    }

    public void setSelectedLigneCommande(TbLigneCommande selectedLigneCommande) {
        this.selectedLigneCommande = selectedLigneCommande;
    }

    public void createLigneCommande() {
        TbLigneCommande newLigneCommande = new TbLigneCommande();
        TbLigneCommandeDAO tbLigneCommandeDAO = new TbLigneCommandeDAO();
        tbLigneCommandeDAO.save(newLigneCommande);
    }

    public void saveLigneCommande(TbLigneCommande ligneCommande) {
        if (ligneCommande != null) {
            TbLigneCommandeDAO tbLigneCommandeDAO = new TbLigneCommandeDAO();
            tbLigneCommandeDAO.update(ligneCommande);
        }
    }

    public void deleteLigneCommande(TbLigneCommande ligneCommande) {
        if (ligneCommande != null) {
            TbLigneCommandeDAO tbLigneCommandeDAO = new TbLigneCommandeDAO();
            tbLigneCommandeDAO.remove(ligneCommande);
        }
    }

    public List<TbLigneCommande> loadLigneCommandeDAO() {
        TbLigneCommandeDAO tbLigneCommandeDAO = new TbLigneCommandeDAO();
        return tbLigneCommandeDAO.findAll();
    }
}
