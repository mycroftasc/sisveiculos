/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_ManutencaoExt;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jean.leal
 */
@ManagedBean (name = "mbManExt")
@SessionScoped
public class MB_ManutencaoExt {

    private B_ManutencaoExt manExt;
    private ArrayList<B_ManutencaoExt> mans;
    private boolean edit = false;

    public MB_ManutencaoExt(B_ManutencaoExt manExt, ArrayList<B_ManutencaoExt> mans) {
        this.manExt = manExt;
        this.mans = mans;
    }

    public MB_ManutencaoExt() {
        manExt = new B_ManutencaoExt();
        
    }
    
    
    
    public void cadastraEeditaManutencao() {
        if (edit) {
            int index = this.mans.lastIndexOf(this.manExt);
            this.mans.set(index, manExt);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_ManutencaoExt mExt = new B_ManutencaoExt(this.manExt.getId(), this.manExt.getIdManutencao(), this.manExt.getIdVeiculo(), this.manExt.getDataManutencao(), this.manExt.getKmManutencao(), this.manExt.getValorPeca(), this.manExt.getValorMaoDeObra());
            BD_ManutencaoExt bdManExt = new BD_ManutencaoExt();
            bdManExt.salvar(mExt);
            
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiManutencao(B_ManutencaoExt mExt){
        this.manExt = mExt;
        int index = this.mans.lastIndexOf(mExt);
        this.mans.remove(index);
    }
    
    public void editaManutencao(B_ManutencaoExt m){
        this.manExt = m;
        edit = true;
    }
    
    public ArrayList<B_ManutencaoExt> getMans() {
        return mans;
    }

    public void setMans(ArrayList<B_ManutencaoExt> mans) {
        this.mans = mans;
    }

    public B_ManutencaoExt getManExt() {
        return manExt;
    }

    public void setManExt(B_ManutencaoExt manExt) {
        this.manExt = manExt;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    
}
