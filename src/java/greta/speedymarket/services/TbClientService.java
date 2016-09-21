/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbClientDAO;
import greta.speedymarket.model.TbClient;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbClientService")
@ViewScoped
public class TbClientService {
    
    private TbClient selectedClient;
    
    public TbClient getSelectedClient(){
        return this.selectedClient;
    }
    
    public void setSelectedCLient (TbClient selectedClient){
        this.selectedClient = selectedClient;
    }
    
    public void createClient (){
        TbClient newClient = new TbClient();
        TbClientDAO tbClientDAO = new TbClientDAO();
        tbClientDAO.save(newClient);
    }
    
    public void saveClient(TbClient client){
        if(client != null){
            TbClientDAO tbClientDAO =  new TbClientDAO();
            tbClientDAO.update(client);
        }
    }
    
    public void deleteClient (TbClient client){
        if(client != null){
            TbClientDAO tbClientDAO =  new TbClientDAO();
            tbClientDAO.remove(client);
        }
    }
    
    public List<TbClient> loadClient(){
        TbClientDAO tbClientDAO =  new TbClientDAO();
        return tbClientDAO.findAll();
    }
    
}
