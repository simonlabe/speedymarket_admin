/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbCommandeDAO;
import greta.speedymarket.model.TbCommande;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbCommandeService")
@ViewScoped
public class TbCommandeService {
    
    private TbCommande selectedCommande;
    
    public TbCommande getSelectedCommande (){
        return this.selectedCommande;
    }
    
    public void setSelectedCommande (TbCommande selectedCommande){
        this.selectedCommande = selectedCommande;
    }
    
    public void createCommande(){
        TbCommande newCommande = new TbCommande();
        TbCommandeDAO tbCommandeDAO = new TbCommandeDAO();
        tbCommandeDAO.save(newCommande);
    }
    
    public void saveCommande (TbCommande commande){
        if (commande != null){
            TbCommandeDAO tbCommandeDAO = new TbCommandeDAO();
            tbCommandeDAO.update(commande); 
        }
    }
    
    public void deleteCommande (TbCommande commande){
        if(commande != null){
            TbCommandeDAO tbCommandeDAO = new TbCommandeDAO();
            tbCommandeDAO.remove(commande);
        }
    }
    
    public List<TbCommande> loadCommandes(){
        TbCommandeDAO tbCommandeDAO = new TbCommandeDAO();
        return tbCommandeDAO.findAll();
    }
}
