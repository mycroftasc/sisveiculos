/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jean.leal
 */
@Entity
public class B_Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private Integer idUsuario;
    private Integer idModelo;
       
    
    public B_Veiculo() {
    }

    public B_Veiculo(Integer id, String placa, Integer idUsuario, Integer idMarcaTipo) {
        this.id = id;
        this.placa = placa;
        this.idUsuario = idUsuario;
        this.idModelo = idMarcaTipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idMarcaTipo) {
        this.idModelo = idMarcaTipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
}
