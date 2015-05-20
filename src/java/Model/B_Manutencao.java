/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jean.leal
 */
public class B_Manutencao {
    private Integer tipo;
    private String nome;
    private String descricao;
    private String dataDaManutencao;
    private String dataDaProximaManutencao;
    private String quilometragemDaManutencao;
    private String quilometragemDaProximaManutencao;
    private Double valorPeca;
    private Double valorMaoDeObra;
    private Double valorTotal;
    
    public B_Manutencao() {
    }
    public B_Manutencao(B_Manutencao man) {
        this.setDataDaManutencao(man.dataDaManutencao);
        this.setDataDaProximaManutencao(man.dataDaProximaManutencao);
        this.setDescricao(man.descricao);
        this.setNome(man.nome);
        this.setQuilometragemDaManutencao(man.quilometragemDaManutencao);
        this.setQuilometragemDaProximaManutencao(man.quilometragemDaProximaManutencao);
        this.setTipo(man.tipo);
        this.setValorMaoDeObra(man.valorMaoDeObra);
        this.setValorPeca(man.valorPeca);
        this.setValorTotal(man.valorTotal);
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataDaManutencao() {
        return dataDaManutencao;
    }

    public void setDataDaManutencao(String dataDaManutencao) {
        this.dataDaManutencao = dataDaManutencao;
    }

    public String getDataDaProximaManutencao() {
        return dataDaProximaManutencao;
    }

    public void setDataDaProximaManutencao(String dataDaProximaManutencao) {
        this.dataDaProximaManutencao = dataDaProximaManutencao;
    }

    public String getQuilometragemDaManutencao() {
        return quilometragemDaManutencao;
    }

    public void setQuilometragemDaManutencao(String quilometragemDaManutencao) {
        this.quilometragemDaManutencao = quilometragemDaManutencao;
    }

    public String getQuilometragemDaProximaManutencao() {
        return quilometragemDaProximaManutencao;
    }

    public void setQuilometragemDaProximaManutencao(String quilometragemDaProximaManutencao) {
        this.quilometragemDaProximaManutencao = quilometragemDaProximaManutencao;
    }

    public Double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(Double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public Double getValorMaoDeObra() {
        return valorMaoDeObra;
    }

    public void setValorMaoDeObra(Double valorMaoDeObra) {
        this.valorMaoDeObra = valorMaoDeObra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
