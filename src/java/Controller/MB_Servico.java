/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Servico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jean.leal
 */
@ManagedBean (name = "mbSv")
@SessionScoped
public class MB_Servico {

    private B_Servico sv;
    private ArrayList<B_Servico> svs;
    private boolean edit = false;
    
    public MB_Servico() {
        sv = new B_Servico();
        svs = new ArrayList<B_Servico>();
    }
    
    public void cadastraEeditaManutencao() {
        if (edit) {
            int index = this.svs.lastIndexOf(this.sv);
            this.svs.set(index, sv);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_Servico v = new B_Servico(this.sv.getId(), this.sv.getNome(), this.sv.getDescricao());
            BD_Servico bdMan = new BD_Servico();
            bdMan.salvar(v);
            
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiManutencao(B_Servico m){
        this.sv = m;
        int index = this.svs.lastIndexOf(m);
        this.svs.remove(index);
    }
    
    public void editaManutencao(B_Servico m){
        this.sv = m;
        edit = true;
    }
    
    public ArrayList<B_Servico> getMans() {
        return svs;
    }

    public void setMans(ArrayList<B_Servico> svs) {
        this.svs = svs;
    }

    public B_Servico getMan() {
        return sv;
    }

    public void setMan(B_Servico sv) {
        this.sv = sv;
    }
}
