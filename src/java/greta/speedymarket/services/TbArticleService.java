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
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbArticleService")
@ViewScoped
public class TbArticleService implements Serializable {

    private static final long serialVersionUID = 4003047561926425600L;

    private TbArticle selectedArticle;
    private List<TbArticle> articles;
    private final static List<String> COLUMN_KEYS = Arrays.asList("idArticle",
                                                                  "ADesignation",
                                                                  "ADescription",
                                                                  "idCategorie",
                                                                  "AQuantiteStock",
                                                                  "AVisible");
    private List<ColumnModel> columns;
    private String columnTemplate = "idArticle ADesignation ADescription AQuantiteStock AVisible";

    public TbArticle getSelectedArticle() {
        return this.selectedArticle;
    }

    public void setSelectedArticle(TbArticle selectedArticle) {
        this.selectedArticle = selectedArticle;
    }

    public List<TbArticle> getArticles() {
        return this.articles;
    }

    public List<ColumnModel> getColumns() {
        return this.columns;
    }

    public String getColumnTemplate() {
        return columnTemplate;
    }

    public void setColumnTemplate(String columnTemplate) {
        this.columnTemplate = columnTemplate;
    }

    @PostConstruct
    public void init() {
        articles = this.loadArticles();

        createDynamicColumns();
    }

    private void createDynamicColumns() {
        String[] columnKeys = this.columnTemplate.split(" ");

        this.columns = new ArrayList<>();

        for (String columnKey : columnKeys) {
            String key = columnKey.trim();

            if (COLUMN_KEYS.contains(key)) {
                this.columns.add(new ColumnModel(columnKey.toUpperCase(),
                                                 columnKey));
            }
        }
    }

    private void updateColumns() {
        UIComponent table = FacesContext.getCurrentInstance().getViewRoot()
                .findComponent(":form:tablesArticles");

        table.setValueExpression("sortBy", null);

        //update columns
        createDynamicColumns();
    }

    public void createArticle() {
        TbArticle newArticle = new TbArticle("Nouvel Article", false);
        TbArticleDAO tbArticleDAO = new TbArticleDAO();
        tbArticleDAO.save(newArticle);
    }

    public void saveArticle(TbArticle article) {
        if (article != null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            tbArticleDAO.update(article);
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

//        createArticle();

        return this.articles;
    }

    static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
    }
}
