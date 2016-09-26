/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greta.speedymarket.services;

import greta.speedymarket.dao.TbCategorieDAO;
import greta.speedymarket.model.TbCategorie;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;

/**
 *
 * @author helldown
 */
@ManagedBean(name = "TbCategorieService")
@ViewScoped
public class TbCategorieService {

    private TbCategorie selectedCategorie;
    private TreeNode root = null;
    private TreeNode selectedNode;

    public TbCategorie getSelectedCategorie() {
        return this.selectedCategorie;
    }

    public void setSelectedCategorie(TbCategorie selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }

    public TreeNode getSelectedNode() {
        return this.selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TbCategorie getSelectedNodeCategorie() {
        return (TbCategorie) this.selectedNode.getData();
    }

    public void seRoot(TreeNode root) {
        this.root = root;
    }

    public void createCategorie() {
        TbCategorie newCategorie = new TbCategorie("Nouvelle catégorie");
        TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
        tbCategorieDAO.save(newCategorie);
    }

    public void saveCategorie(TbCategorie categorie) {
        if (categorie != null) {
            TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
            tbCategorieDAO.update(categorie);
        }
    }

    public void deleteCategorie(TbCategorie categorie) {
        if (categorie != null) {
            TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
            tbCategorieDAO.remove(categorie);
        }
    }

    public List<TbCategorie> loadCategorie() {
        TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
        return tbCategorieDAO.findAll();
    }

    public List<TbCategorie> loadCategoriesParentes() {
        List<TbCategorie> categories = new ArrayList<>();
        for (TbCategorie category : loadCategorie()) {
            if  (category.getTbCategorie() == null) {
                categories.add(category);
            }
        }

        return categories;
    }

    public TreeNode getRoot() {
        root = (TreeNode) new DefaultTreeNode();

        for (TbCategorie categorie : loadCategoriesParentes()) {
            TreeNode node = new DefaultTreeNode(categorie, root);

            createCategoriesTreeNode(categorie, node);
        }

        return root;
    }

    public void createCategoriesTreeNode(TbCategorie categorie, TreeNode nodeParent) {
        for (Object category : categorie.getTbCategories()) {
            TbCategorie cat = (TbCategorie) category;
            TreeNode node = new DefaultTreeNode(category, nodeParent);

            createCategoriesTreeNode(cat, node);
        }
    }
}
