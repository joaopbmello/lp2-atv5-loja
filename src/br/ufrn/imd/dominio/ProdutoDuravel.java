package br.ufrn.imd.dominio;

import java.util.Date;

/**
 * Classe que representa um produto dur�vel
 *
 * @author Jo�o Mello
 */
public class ProdutoDuravel extends Produto {
    private int durabilidade; // durabilidade do produto em anos

    public ProdutoDuravel(String nome, double preco, String marca, String descricao, Date dataFabricacao, int durabilidade) {
        super(nome, preco, marca, descricao, dataFabricacao);
        this.durabilidade = durabilidade;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }
}
