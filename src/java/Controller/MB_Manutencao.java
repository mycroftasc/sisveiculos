/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Manutencao;
import java.util.ArrayList;
import java.util.List;
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
    
    public MB_Manutencao() {
        man = new B_Manutencao();
        mans = new ArrayList<B_Manutencao>();
    }
    
    public void cadastraEeditaManutencao() {
        if (edit) {
            int index = this.mans.lastIndexOf(this.man);
            this.mans.set(index, man);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_Manutencao v = new B_Manutencao(this.man.getId(), this.man.getNome(), this.man.getDescricao());
            BD_Manutencao bdMan = new BD_Manutencao();
            bdMan.salvar(v);
            
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
}
