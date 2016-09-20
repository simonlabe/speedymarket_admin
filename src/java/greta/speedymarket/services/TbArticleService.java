/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;
import greta.speedymarket.dao.TbArticleDAO;
import greta.speedymarket.model.TbArticle;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbArticleService")
@ViewScoped
public class TbArticleService {
    
    private TbArticle selectedArticle;
    
    public TbArticle getSelectedArticle (){
        return this.selectedArticle;
    }
    
    public void setSelectedArticle (TbArticle selectedArticle){
        this.selectedArticle = selectedArticle;
    }
    
    public void createArticle(){
        TbArticle newArticle = new TbArticle();
        TbArticleDAO tbArticleDAO = new TbArticleDAO();
        tbArticleDAO.save(newArticle);
    }
    
    public void saveArticle (TbArticle article){
        if (article != null){
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            tbArticleDAO.update(article); 
        }
    }
    
    public void deleteArticle (TbArticle article){
        if(article != null){
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            tbArticleDAO.remove(article);
        }
    }
    
    public List<TbArticle> loadArticles(){
        TbArticleDAO tbArticleDAO = new TbArticleDAO();
        return tbArticleDAO.findAll();
    }
}
