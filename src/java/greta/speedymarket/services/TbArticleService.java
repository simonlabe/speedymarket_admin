/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbArticleDAO;
import greta.speedymarket.model.TbArticle;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Service gérant les Articles
 * @author Gael PHILIPPE
 */
@ManagedBean(name = "TbArticleService")
@ViewScoped
public class TbArticleService implements Serializable {

    /**
     * @var l'article sélectionné dans la vue
     */
    private TbArticle selectedArticle;
    /**
     * Une liste représentant tous les articles
     */
    private List<TbArticle> articles;

    /// GETTERS & SETTERS ////
    public TbArticle getSelectedArticle() {
        return this.selectedArticle;
    }

    public void setSelectedArticle(TbArticle selectedArticle) {
        this.selectedArticle = selectedArticle;
    }

    /**
     * Cette méthode est nécessaire pour remplir la liste d'Articles
     * au chargement de la vue
     */
    @PostConstruct
    public void init() {
        articles = this.loadArticles();
    }

    /**
     * Ce qu'il se passe quand on valide une édition de la liste
     */
    public void onRowEdit() {
        this.saveArticle(selectedArticle);
    }

    /**
     * Ce qu'il se passe quand on annule une édition de la liste
     */
    public void onRowEditCancel() {
        return;
    }

    /**
     * Insère un Article dans la table
     */
    public void createArticle() {
        TbArticle newArticle = new TbArticle("Nouvel Article", false);
        TbArticleDAO tbArticleDAO = new TbArticleDAO();
        tbArticleDAO.save(newArticle);
        this.articles = tbArticleDAO.findAll();
    }

    /**
     * Enregistre les modifications d'un article
     * @param article
     */
    public void saveArticle(TbArticle article) {
        if (article != null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            System.out.println("Article ID is " + article.getIdArticle());
            tbArticleDAO.update(article);

            // Il est nécessaire de recharger la liste d'articles pour mettre
            // à jour la dataTable
            this.articles = tbArticleDAO.findAll();
        }
    }

    /**
     * Supprime un Article de la table tb_article
     * @param article
     */
    public void deleteArticle(TbArticle article) {
        if (article != null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            tbArticleDAO.remove(article);

            // Il est nécessaire de recharger la liste d'articles pour mettre
            // à jour la dataTable
            this.articles = tbArticleDAO.findAll();
        }
    }

    /**
     * Charge tous les articles depuis la base de données
     * @return la liste de tous les articles de la base
     */
    public List<TbArticle> loadArticles() {
        if (this.articles == null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            this.articles = tbArticleDAO.findAll();
        }

        return this.articles;
    }
}
