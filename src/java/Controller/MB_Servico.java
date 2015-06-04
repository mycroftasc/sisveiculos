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
@ManagedBean(name = "mbSv")
@SessionScoped
public class MB_Servico {

    private B_Servico sv;
    private List<B_Servico> svs;
    private boolean edit = false;

    public MB_Servico() {
        sv = new B_Servico();
        svs = new ArrayList<B_Servico>();
        this.listarServicos();
    }

    public void cadastraEeditaServico() {
        if (edit) {
            int index = this.svs.lastIndexOf(this.sv);
            this.svs.set(index, sv);
            //this.limpaCampos();
            this.listarServicos();
            this.edit = false;
        } else {
            B_Servico s = new B_Servico(this.sv.getId(), this.sv.getNome(), this.sv.getDescricao());
            BD_Servico bdS = new BD_Servico();
            bdS.salvar(s);
            this.listarServicos();
            //this.limpaCampos();
            this.edit = false;
        }
    }

    public void excluiServico(B_Servico m) {
        this.sv = m;
        int index = this.svs.lastIndexOf(m);
        this.svs.remove(index);
    }

    public void editaServico(B_Servico m) {
        this.sv = m;
        edit = true;
    }

    public void listarServicos() {
        BD_Servico bds = new BD_Servico();
        this.svs = bds.listar();
    }

    public B_Servico getSv() {
        return sv;
    }

    public void setSv(B_Servico sv) {
        this.sv = sv;
    }

    public List<B_Servico> getSvs() {
        return svs;
    }

    public void setSvs(List<B_Servico> svs) {
        this.svs = svs;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
