/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Marca;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alexandre-carmo
 */
@ManagedBean (name = "mbMarc")
@SessionScoped
public class MB_Marca {
    
    private B_Marca marc;
    private ArrayList<B_Marca> marcs;
    private boolean edit = false;

    public MB_Marca(B_Marca marc, ArrayList<B_Marca> marcs) {
        this.marc = marc;
        this.marcs = marcs;
    }

    public MB_Marca() {
        marc = new B_Marca();
    }
    
    public void cadastraEeditaMarca(){
        if (edit) {
            int index = this.marcs.lastIndexOf(this.marc);
            this.marcs.set(index, marc);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_Marca m = new B_Marca(this.marc.getId(), this.marc.getNome(), 1);
            BD_Marca bdMarc = new BD_Marca();
            bdMarc.salvar(m);
            
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiManutencao(B_Marca m){
        this.marc = m;
        int index = this.marcs.lastIndexOf(m);
        this.marcs.remove(index);
    }
    
    public void editaManutencao(B_Marca m){
        this.marc = m;
        edit = true;
    }
    
    public ArrayList<B_Marca> getMarcs() {
        return marcs;
    }

    public void setMarcs(ArrayList<B_Marca> marcs) {
        this.marcs = marcs;
    }

    public B_Marca getMarc() {
        return marc;
    }

    public void setMarc(B_Marca marc) {
        this.marc = marc;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
