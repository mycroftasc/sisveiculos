/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_ModeloVeiculo;
import java.util.ArrayList;
import java.util.List;
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
    private List<B_ModeloVeiculo> mdls;
    private boolean edit = false;

    public MB_ModeloVeiculo(B_ModeloVeiculo mdl, ArrayList<B_ModeloVeiculo> mdls) {
        this.mdl = mdl;
        this.mdls = mdls;
    }
    
    public MB_ModeloVeiculo() {
        mdl = new B_ModeloVeiculo();
        this.mdls = new ArrayList<B_ModeloVeiculo>();
        this.listarModelo();
    }
    
    
    public void cadastraEeditaModelo(){
        if (edit) {
            int index = this.mdls.lastIndexOf(this.mdl);
            this.mdls.set(index, mdl);
            this.listarModelo();
            this.edit = false;
        } else {
            B_ModeloVeiculo m = new B_ModeloVeiculo(this.mdl.getId(), this.mdl.getNome(), 1);
            BD_ModeloVeiculo bdMdl = new BD_ModeloVeiculo();
            bdMdl.salvar(m);
            this.listarModelo();
            this.edit = false;
        }
    }
    
    public void excluiModelo(B_ModeloVeiculo m){
        BD_ModeloVeiculo bdm = new BD_ModeloVeiculo();
        bdm.excluir(m);
        this.listarModelo();
    }
    
    public void editaModelo(B_ModeloVeiculo m){
        this.mdl = m;
        edit = true;
    }
    
    public void listarModelo(){
        this.limpar();
        BD_ModeloVeiculo bdM = new BD_ModeloVeiculo();
        this.mdls = bdM.listar();
    }
    
    public void limpar(){
        this.mdls.clear();
        this.mdl.setId(null);
        this.mdl.setIdMarca(null);
        this.mdl.setNome(null);
    }
    
    public List<B_ModeloVeiculo> getMdls() {
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
