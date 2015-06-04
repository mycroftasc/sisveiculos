/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_MarcaVeiculo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alexandre-carmo
 */
@ManagedBean (name = "mbMarc")
@SessionScoped
public class MB_MarcaVeiculo {
    
    private B_MarcaVeiculo marc;
    private List<B_MarcaVeiculo> marcs;
    private boolean edit = false;

    public MB_MarcaVeiculo(B_MarcaVeiculo marc, ArrayList<B_MarcaVeiculo> marcs) {
        this.marc = marc;
        this.marcs = marcs;
    }

    public MB_MarcaVeiculo() {
        marc = new B_MarcaVeiculo();
        this.marcs = new ArrayList<B_MarcaVeiculo>();
        this.listarMarcas();
    }
    
    public void cadastraEeditaMarca(){
        if (edit) {
            int index = this.marcs.lastIndexOf(this.marc);
            this.marcs.set(index, marc);
            //this.limpaCampos();
            this.listarMarcas();
            this.edit = false;
        } else {
            B_MarcaVeiculo m = new B_MarcaVeiculo(this.marc.getId(), this.marc.getNome());
            BD_MarcaVeiculo bdMarc = new BD_MarcaVeiculo();
            bdMarc.salvar(m);
            this.listarMarcas();
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiManutencao(B_MarcaVeiculo m){
        this.marc = m;
        int index = this.marcs.lastIndexOf(m);
        this.marcs.remove(index);
    }
    
    public void editaManutencao(B_MarcaVeiculo m){
        this.marc = m;
        edit = true;
    }
    
    public void listarMarcas(){
        BD_MarcaVeiculo bdM = new BD_MarcaVeiculo();
        this.marcs = bdM.listar();
    }
    
    public List<B_MarcaVeiculo> getMarcs() {
        return marcs;
    }

    public void setMarcs(ArrayList<B_MarcaVeiculo> marcs) {
        this.marcs = marcs;
    }

    public B_MarcaVeiculo getMarc() {
        return marc;
    }

    public void setMarc(B_MarcaVeiculo marc) {
        this.marc = marc;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
