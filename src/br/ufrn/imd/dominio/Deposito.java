package br.ufrn.imd.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe que representa um depósito
 *
 * @author João Mello
 */
public class Deposito {
    private final ArrayList<Produto> produtos;

    public Deposito() {
        this.produtos = new ArrayList<>();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public int quantidadeProdutos() {
        return produtos.size();
    }

    public boolean isDepositoVazio() {
        return produtos.isEmpty();
    }

    public Produto produtoMaisCaro() {
        return Collections.max(produtos, Comparator.comparingDouble(Produto::getPreco));
    }
}
