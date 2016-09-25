/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbArticleDAO;
import greta.speedymarket.model.TbArticle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbArticleService")
@ViewScoped
public class TbArticleService implements Serializable {

    private TbArticle selectedArticle;
    private List<TbArticle> articles;

    public TbArticle getSelectedArticle() {
        if (this.selectedArticle == null) {
            this.selectedArticle = new TbArticle("Nouvel Article Youpi!!!", true);
        }
        return this.selectedArticle;
    }

    public void setSelectedArticle(TbArticle selectedArticle) {
        this.selectedArticle = selectedArticle;
    }

    @PostConstruct
    public void init() {
        articles = this.loadArticles();
    }

    public void onRowEdit() {
        this.saveArticle(selectedArticle);
    }

    public void onRowEditCancel() {
        return;
    }

    public void createArticle() {
        TbArticle newArticle = new TbArticle("Nouvel Article", false);
        TbArticleDAO tbArticleDAO = new TbArticleDAO();
        tbArticleDAO.save(newArticle);
    }

    public void saveArticle(TbArticle article) {
        if (article != null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            System.out.println("Article ID is " + article.getIdArticle());
            if (article.getIdArticle() != null)
                tbArticleDAO.update(article);
            else
                tbArticleDAO.save(article);
        }
    }

    public void deleteArticle(TbArticle article) {
        if (article != null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            tbArticleDAO.remove(article);
        }
    }

    public List<TbArticle> loadArticles() {
        if (this.articles == null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            this.articles = tbArticleDAO.findAll();
        }

        return this.articles;
    }
}
