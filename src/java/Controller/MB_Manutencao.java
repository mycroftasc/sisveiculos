/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Manutencao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jean.leal
 */
@ManagedBean (name = "mbMan")
@SessionScoped
public class MB_Manutencao {

    private B_Manutencao man;
    private ArrayList<B_Manutencao> mans;
    private boolean edit = false;

    public MB_Manutencao(B_Manutencao manExt, ArrayList<B_Manutencao> mans) {
        this.man = man;
        this.mans = mans;
    }

    public MB_Manutencao() {
        man = new B_Manutencao();
    }
    
    public void cadastraEeditaManutencao() {
        if (edit) {
            int index = this.mans.lastIndexOf(this.man);
            this.mans.set(index, man);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_Manutencao m = new B_Manutencao(this.man.getId(), 1, 1, this.man.getDataManutencao(), this.man.getKmManutencao(), this.man.getValorPeca(), this.man.getValorMaoDeObra());
            BD_Manutencao bdMan = new BD_Manutencao();
            bdMan.salvar(m);
            
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiManutencao(B_Manutencao m){
        this.man = m;
        int index = this.mans.lastIndexOf(m);
        this.mans.remove(index);
    }
    
    public void editaManutencao(B_Manutencao m){
        this.man = m;
        edit = true;
    }
    
    public ArrayList<B_Manutencao> getMans() {
        return mans;
    }

    public void setMans(ArrayList<B_Manutencao> mans) {
        this.mans = mans;
    }

    public B_Manutencao getMan() {
        return man;
    }

    public void setMan(B_Manutencao man) {
        this.man = man;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    
}
