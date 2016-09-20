/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;
import greta.speedymarket.dao.TbCategorieDAO;
import greta.speedymarket.model.TbCategorie;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author helldown
 */
@ManagedBean(name="TbCategorieService")
@ViewScoped
public class TbCategorieService {
    
    private TbCategorie selectedCategorie;
    
    public TbCategorie getSelectedCategorie(){
        return this.selectedCategorie;
    }
    public void setSelectedCategorie(TbCategorie selectedCategorie){
        this.selectedCategorie = selectedCategorie;
    }
    public void createCategorie(){
        TbCategorie newCategorie = new TbCategorie("Nouvelle catégorie");
        TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
        tbCategorieDAO.save(newCategorie);
    }
    public void saveCategorie(TbCategorie categorie){
        if(categorie != null){
            TbCategorieDAO tbCategorieDAO =  new TbCategorieDAO();
            tbCategorieDAO.update(categorie);
        }
    }
    public void deleteCategorie (TbCategorie categorie){
        if(categorie != null){
            TbCategorieDAO tbCategorieDAO =  new TbCategorieDAO();
            tbCategorieDAO.remove(categorie);
        }
    }
    public List<TbCategorie> loadCategorie(){
        TbCategorieDAO tbCategorieDAO =  new TbCategorieDAO();
        return tbCategorieDAO.findAll();
    }
}
