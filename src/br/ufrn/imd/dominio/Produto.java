package br.ufrn.imd.dominio;

import java.util.Date;

/**
 * Classe que representa um produto
 *
 * @author João Mello
 */
public class Produto {
    private String nome;
    private double preco;
    private String marca;
    private String descricao;
    private Date dataFabricacao;

    public Produto(String nome, double preco, String marca, String descricao, Date dataFabricacao) {
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String toString() {
        return descricao + " " + marca + " " + nome + " - R$ " + preco;
    }
}
