package greta.speedymarket.services;

import greta.speedymarket.dao.TbPreparateurDAO;
import greta.speedymarket.model.TbPreparateur;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TbPreparateurService")
@ViewScoped
public class TbPreparateurService {

    private TbPreparateur selectedPreparateur;
    private List<TbPreparateur> preparateurs;

    public TbPreparateur getSelectedPreparateur() {
        return this.selectedPreparateur;
    }

    public void setSelectedPreparateur(TbPreparateur selectedPreparateur) {
        this.selectedPreparateur = selectedPreparateur;
    }
    
    @PostConstruct
    public void init() {
        preparateurs = this.loadPreparateurs();
    }

    public void onRowEdit() {
        this.savePreparateur(selectedPreparateur);
    }

    public void onRowEditCancel() {
        return;
    }

    public void createPreparateur() {
        TbPreparateur newPreparateur = new TbPreparateur();
        TbPreparateurDAO tbPreparateurDAO = new TbPreparateurDAO();
        tbPreparateurDAO.save(newPreparateur);
    }

    public void savePreparateur(TbPreparateur preparateur) {
        if (preparateur != null) {
            TbPreparateurDAO tbPreparateurDAO=  new TbPreparateurDAO();
            tbPreparateurDAO.update(preparateur);
            
            this.preparateurs = tbPreparateurDAO.findAll();
        }
    }

    public void deletePreparateur(TbPreparateur preparateur) {
        if (preparateur != null) {
            TbPreparateurDAO tbPreparateurDAO = new TbPreparateurDAO();
            tbPreparateurDAO.remove(preparateur);
        }
    }

    public List<TbPreparateur> loadPreparateurs() {
        TbPreparateurDAO tbPreparateurDAO = new TbPreparateurDAO();
        return tbPreparateurDAO.findAll();
    }
}
