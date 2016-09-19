package greta.speedymarket.model;
// Generated 19 sept. 2016 16:52:54 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TbStatut generated by hbm2java
 */
public class TbStatut  implements java.io.Serializable {


     private Integer idStatut;
     private String SLibelle;
     private Set tbCommandes = new HashSet(0);

    public TbStatut() {
    }

	
    public TbStatut(String SLibelle) {
        this.SLibelle = SLibelle;
    }
    public TbStatut(String SLibelle, Set tbCommandes) {
       this.SLibelle = SLibelle;
       this.tbCommandes = tbCommandes;
    }
   
    public Integer getIdStatut() {
        return this.idStatut;
    }
    
    public void setIdStatut(Integer idStatut) {
        this.idStatut = idStatut;
    }
    public String getSLibelle() {
        return this.SLibelle;
    }
    
    public void setSLibelle(String SLibelle) {
        this.SLibelle = SLibelle;
    }
    public Set getTbCommandes() {
        return this.tbCommandes;
    }
    
    public void setTbCommandes(Set tbCommandes) {
        this.tbCommandes = tbCommandes;
    }




}


