package br.ufrn.imd.dominio;

import java.util.Date;

/**
 * Classe que representa um produto n�o dur�vel
 *
 * @author Jo�o Mello
 */
public class ProdutoNaoDuravel extends Produto {
    private Date dataValidade;
    private String genero; // aliment�cio, limpeza, vestu�rio, higiene pessoal, etc

    public ProdutoNaoDuravel(String nome, double preco, String marca, String descricao, Date dataFabricacao, Date dataValidade, String genero) {
        super(nome, preco, marca, descricao, dataFabricacao);
        this.dataValidade = dataValidade;
        this.genero = genero;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
