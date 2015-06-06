/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jean.leal
 */
@ManagedBean(name = "mbVeic")
@SessionScoped
public class MB_Veiculo {

    private B_Veiculo veic;
    private List<B_Veiculo> veics;
    private boolean edit = false;

    public MB_Veiculo() {
        veic = new B_Veiculo();
        this.veics = new ArrayList<B_Veiculo>();
        this.listarVeiculo();
    }

    public void cadastraEeditaVeiculo() {
        if (edit) {
            int index = this.veics.lastIndexOf(this.veic);
            this.veics.set(index, veic);
            this.listarVeiculo();
            this.edit = false;
        } else {
            B_Veiculo v = new B_Veiculo(this.veic.getId(), 1, 1, 1, this.veic.getAnoFabricacao(), this.veic.getAnoModelo(), this.veic.getKm(), this.veic.getCor(), this.veic.getPlaca(), 1);
            BD_Veiculo ve = new BD_Veiculo();
            ve.salvar(v);
            this.listarVeiculo();
            this.edit = false;
        }
    }

    public void excluiVeiculo(B_Veiculo v) {
        BD_Veiculo bdv = new BD_Veiculo();
        bdv.excluir(v);
        this.listarVeiculo();
    }

    public void editaVeiculo(B_Veiculo v) {
        this.veic = v;
        edit = true;
    }

    public void listarVeiculo() {
        this.limpar();
        BD_Veiculo bdVeic = new BD_Veiculo();
        this.veics = bdVeic.listar();
    }

    public void limpar() {
        this.veics.clear();
        this.veic.setAnoFabricacao(null);
        this.veic.setAnoModelo(null);
        this.veic.setCor(null);
        this.veic.setId(null);
        this.veic.setIdMarca(null);
        this.veic.setIdModelo(null);
        this.veic.setIdTipo(null);
        this.veic.setIdUsuario(null);
        this.veic.setKm(null);
        this.veic.setPlaca(null);
    }

    public B_Veiculo getVeic() {
        return veic;
    }

    public void setVeic(B_Veiculo veic) {
        this.veic = veic;
    }

    public List<B_Veiculo> getVeics() {
        return veics;
    }

    public void setVeics(ArrayList<B_Veiculo> veics) {
        this.veics = veics;
    }
}
