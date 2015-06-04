/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_ModeloVeiculo;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alexandre-carmo
 */
@ManagedBean(name = "mbModel")
@SessionScoped
public class MB_ModeloVeiculo {
    
    private B_ModeloVeiculo mdl;
    private ArrayList<B_ModeloVeiculo> mdls;
    private boolean edit = false;

    public MB_ModeloVeiculo(B_ModeloVeiculo mdl, ArrayList<B_ModeloVeiculo> mdls) {
        this.mdl = mdl;
        this.mdls = mdls;
    }

    
    
    public MB_ModeloVeiculo() {
        mdl = new B_ModeloVeiculo();
    }
    
    
    public void cadastraEeditaModelo(){
        if (edit) {
            int index = this.mdls.lastIndexOf(this.mdl);
            this.mdls.set(index, mdl);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_ModeloVeiculo m = new B_ModeloVeiculo(this.mdl.getId(), this.mdl.getNome(), 1);
            BD_ModeloVeiculo bdMdl = new BD_ModeloVeiculo();
            bdMdl.salvar(m);
            
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiModelo(B_ModeloVeiculo m){
        this.mdl = m;
        int index = this.mdls.lastIndexOf(m);
        this.mdls.remove(index);
    }
    
    public void editaModelo(B_ModeloVeiculo m){
        this.mdl = m;
        edit = true;
    }
    
    public ArrayList<B_ModeloVeiculo> getMdls() {
        return mdls;
    }

    public void setMdls(ArrayList<B_ModeloVeiculo> mdls) {
        this.mdls = mdls;
    }

    public B_ModeloVeiculo getMdl() {
        return mdl;
    }

    public void setMdl(B_ModeloVeiculo mdl) {
        this.mdl = mdl;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    
}