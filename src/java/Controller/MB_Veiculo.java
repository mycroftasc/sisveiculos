/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.B_Veiculo;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jean.leal
 */
@ManagedBean (name = "mbVeic")
@SessionScoped
public class MB_Veiculo {

    private B_Veiculo veic;
    private ArrayList<B_Veiculo> veics;
    private boolean edit = false;
    
    public MB_Veiculo() {
        veic = new B_Veiculo();
        veics = new ArrayList<B_Veiculo>();
    }
    
    public void cadastraEeditaVeiculo() {
        if (edit) {
            int index = this.veics.lastIndexOf(this.veic);
            this.veics.set(index, veic);
            //this.limpaCampos();
            this.edit = false;
        } else {
            B_Veiculo v = new B_Veiculo(veic);
            veics.add(v);
            //this.limpaCampos();
            this.edit = false;
        }
    }
    
    public void excluiVeiculo(B_Veiculo v){
        this.veic = v;
        int index = this.veics.lastIndexOf(v);
        this.veics.remove(index);
    }
    
    public void editaVeiculo(B_Veiculo v){
        this.veic = v;
        edit = true;
    }
    
    public void limpaCampos(){
        this.veic.setAnoFabricacao(null);
        this.veic.setAnoModelo(null);
        this.veic.setCor(null);
        this.veic.setMarca(null);
        this.veic.setModelo(null);
        this.veic.setPlaca(null);
        this.veic.setQuilometragem(null);
        this.veic.setTipo(null);
    }

    public B_Veiculo getVeic() {
        return veic;
    }

    public void setVeic(B_Veiculo veic) {
        this.veic = veic;
    }

    public ArrayList<B_Veiculo> getVeics() {
        return veics;
    }

    public void setVeics(ArrayList<B_Veiculo> veics) {
        this.veics = veics;
    }
}
