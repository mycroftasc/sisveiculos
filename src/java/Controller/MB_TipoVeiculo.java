/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_TipoVeiculo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alexandre-carmo
 */
@ManagedBean (name = "mbTipo")
@SessionScoped
public class MB_TipoVeiculo {
    
    private  B_TipoVeiculo tipo;
    private List<B_TipoVeiculo> tipos;
    private boolean edit = false;

    public MB_TipoVeiculo(B_TipoVeiculo tipo, ArrayList<B_TipoVeiculo> tipos) {
        this.tipo = tipo;
        this.tipos = tipos;
    }

    public MB_TipoVeiculo() {
        tipo = new B_TipoVeiculo();
        this.tipos = new ArrayList<B_TipoVeiculo>();
        this.listarTipos();
    }
    
    public void cadastraEeditaTipo(){
        if (edit) {
            int index = this.tipos.lastIndexOf(this.tipo);
            this.tipos.set(index, tipo);
            //this.limpaCampos();
            this.listarTipos();
            this.edit = false;
        } else {
            B_TipoVeiculo t = new B_TipoVeiculo(this.tipo.getId(), this.tipo.getNome());
            BD_TipoVeiculo bdTipo = new BD_TipoVeiculo();
            bdTipo.salvar(t);
            this.listarTipos();
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiManutencao(B_TipoVeiculo t){
        this.tipo = t;
        int index = this.tipos.lastIndexOf(t);
        this.tipos.remove(index);
    }
    
    public void editaManutencao(B_TipoVeiculo t){
        this.tipo = t;
        edit = true;
    }
    
    public void listarTipos(){
        BD_TipoVeiculo bdtipo = new BD_TipoVeiculo();
        this.tipos = bdtipo.listar();
    }

    public B_TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(B_TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public List<B_TipoVeiculo> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<B_TipoVeiculo> tipos) {
        this.tipos = tipos;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
