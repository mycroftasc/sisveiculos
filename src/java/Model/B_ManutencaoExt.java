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
 * @author JeanCarlo
 */
@Entity
public class B_ManutencaoExt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idManutencao;
    private Integer idVeiculo;
    private String dataManutencao;
    private String kmManutencao;
    private Float valorPeca;
    private Float valorMaoDeObra;

    public B_ManutencaoExt(Integer id, Integer idManutencao, Integer idVeiculo, String dataManutencao, String kmManutencao, Float valorPeca, Float valorMaoDeObra) {
        this.id = id;
        this.idManutencao = idManutencao;
        this.idVeiculo = idVeiculo;
        this.dataManutencao = dataManutencao;
        this.kmManutencao = kmManutencao;
        this.valorPeca = valorPeca;
        this.valorMaoDeObra = valorMaoDeObra;
    }

    public B_ManutencaoExt() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Integer idManutencao) {
        this.idManutencao = idManutencao;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(String dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getKmManutencao() {
        return kmManutencao;
    }

    public void setKmManutencao(String kmManutencao) {
        this.kmManutencao = kmManutencao;
    }

    public Float getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(Float valorPeca) {
        this.valorPeca = valorPeca;
    }

    public Float getValorMaoDeObra() {
        return valorMaoDeObra;
    }

    public void setValorMaoDeObra(Float valorMaoDeObra) {
        this.valorMaoDeObra = valorMaoDeObra;
    }
    
    
}
