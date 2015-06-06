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
    private List<B_Manutencao> mans;
    private boolean edit = false;

    public MB_Manutencao(B_Manutencao manExt, List<B_Manutencao> mans) {
        this.man = man;
        this.mans = mans;
        this.listarManutencao();
    }

    public MB_Manutencao() {
        man = new B_Manutencao();
        this.mans = new ArrayList<B_Manutencao>();
        this.listarManutencao();
    }
    
    public void cadastraEeditaManutencao() {
        if (edit) {
            int index = this.mans.lastIndexOf(this.man);
            this.mans.set(index, man);
            this.edit = false;
        } else {
            B_Manutencao m = new B_Manutencao(this.man.getId(), 1, 1, this.man.getDataManutencao(), this.man.getKmManutencao(), this.man.getValorPeca(), this.man.getValorMaoDeObra());
            BD_Manutencao bdMan = new BD_Manutencao();
            bdMan.salvar(m);
            this.listarManutencao();
            this.edit = false;
        }
    }
    
    public void excluiManutencao(B_Manutencao m){
        BD_Manutencao bdm = new BD_Manutencao();
        bdm.excluir(m);
        this.listarManutencao();
    }
    
    public void editaManutencao(B_Manutencao m){
        this.man = m;
        edit = true;
    }
    
    public void listarManutencao(){
        this.limpar();
        BD_Manutencao bdman = new BD_Manutencao();
        this.mans = bdman.listar();
    }
    
    public void limpar(){
        this.mans.clear();
        this.man.setDataManutencao(null);
        this.man.setId(null);
        this.man.setIdServico(null);
        this.man.setIdVeiculo(null);
        this.man.setKmManutencao(null);
        this.man.setValorMaoDeObra(null);
        this.man.setValorPeca(null);
    }
    
    public List<B_Manutencao> getMans() {
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
