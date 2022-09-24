package br.ufrn.imd.main;

import br.ufrn.imd.dominio.Deposito;
import br.ufrn.imd.dominio.Produto;
import br.ufrn.imd.dominio.ProdutoDuravel;
import br.ufrn.imd.dominio.ProdutoNaoDuravel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LojaView {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");

        Deposito deposito = new Deposito();
        deposito.adicionarProduto(new ProdutoDuravel("Mobi", 50000, "Fiat", "Carro", dataFormato.parse("01/01/2020"), 10));
        deposito.adicionarProduto(new ProdutoDuravel("Sapiens: Uma breve história da humanidade", 69.90, "Companhia das Letras", "Livro", dataFormato.parse("02/02/2020"), 50));
        deposito.adicionarProduto(new ProdutoDuravel("Galaxy M52", 2299, "Samsung", "Celular", dataFormato.parse("03/03/2022"), 5));
        deposito.adicionarProduto(new ProdutoNaoDuravel("Meio Amargo", 4.68, "Hershey's", "Chocolate", dataFormato.parse("09/09/2022"), dataFormato.parse("10/10/2022"), "Alimentício"));
        deposito.adicionarProduto(new ProdutoNaoDuravel("Braga", 59.90, "Karsten", "Toalha", dataFormato.parse("04/04/2022"), dataFormato.parse("04/04/2023"), "Higiene pessoal"));
        deposito.adicionarProduto(new ProdutoNaoDuravel("Reviva", 1.69, "Johnson's", "Sabonete", dataFormato.parse("05/05/2022"), dataFormato.parse("05/05/2025"), "Higiene pessoal"));

        try {
            while (true) {
                System.out.println("--------------------DEPÓSITO DA LOJA--------------------");
                for (Produto produto : deposito.getProdutos()) {
                    System.out.println((deposito.getProdutos().indexOf(produto) + 1) + " - " + produto);
                }
                System.out.println("""
                                \nDigite a opção desejada:\s
                                1 - Adicionar produto\s
                                2 - Remover produto\s
                                3 - Visualizar quantos produtos há no depósito\s
                                4 - Visualizar se o depósito está vazio\s
                                5 - Visualizar qual o produto com o maior preço\s
                                6 - Sair""");
                int opcao = 0;
                while (opcao < 1 || opcao > 6) {
                    try {
                        opcao = Integer.parseInt(scanner.nextLine());
                        if (opcao < 1 || opcao > 6) {
                            System.out.println("Opção inválida. Por favor, tente novamente.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida. Por favor, tente novamente.\n");
                    }
                }
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Nome do produto:");
                        String nome = scanner.nextLine();
                        System.out.println("Preço do produto:");
                        double preco = 0;
                        while (preco == 0) {
                            try {
                                preco = Double.parseDouble(scanner.nextLine());
                                if (preco <= 0) {
                                    preco = 0;
                                    System.out.println("O valor deve ser maior que 0. Por favor, tente novamente.");
                                }
                            } catch (Exception e) {
                                System.out.println("Valor inválido. Por favor, tente novamente.");
                            }
                        }
                        System.out.println("Marca do produto:");
                        String marca = scanner.nextLine();
                        System.out.println("Descrição do produto:");
                        String descricao = scanner.nextLine();
                        System.out.println("Data de fabricação do produto (dia/mês/ano):");
                        Date dataFabricacao = null;
                        while (dataFabricacao == null) {
                            try {
                                dataFabricacao = dataFormato.parse(scanner.nextLine());
                            } catch (ParseException e) {
                                System.out.println("Formato de data inválido. Por favor, tente novamente.");
                            }
                        }
                        System.out.println("""
                                        Produto:
                                        1 - Durável
                                        2 - Não durável""");
                        opcao = 0;
                        while (opcao < 1 || opcao > 2) {
                            try {
                                opcao = Integer.parseInt(scanner.nextLine());
                                if (opcao < 1 || opcao > 2) {
                                    System.out.println("Opção inválida. Por favor, tente novamente.\n");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Opção inválida. Por favor, tente novamente.\n");
                            }
                        }
                        switch (opcao) {
                            case 1 -> {
                                System.out.println("Durabilidade do produto (em anos):");
                                int durabilidade = 0;
                                while (durabilidade == 0) {
                                    try {
                                        durabilidade = Integer.parseInt(scanner.nextLine());
                                        if (durabilidade <= 0) {
                                            durabilidade = 0;
                                            System.out.println("O valor deve ser maior que 0. Por favor, tente novamente.");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Valor inválido. Por favor, tente novamente.");
                                    }
                                }
                                deposito.adicionarProduto(new ProdutoDuravel(nome, preco, marca, descricao, dataFabricacao, durabilidade));
                            }
                            case 2 -> {
                                System.out.println("Data de validade do produto (dia/mês/ano):");
                                Date dataValidade = null;
                                while (dataValidade == null) {
                                    try {
                                        dataValidade = dataFormato.parse(scanner.nextLine());
                                    } catch (ParseException e) {
                                        System.out.println("Formato de data inválido. Por favor, tente novamente.");
                                    }
                                }
                                while (dataValidade.getTime() < dataFabricacao.getTime()) {
                                    System.out.println("Data de validade não pode ser anterior à data de fabricação, tente novamente.");
                                    dataValidade = dataFormato.parse(scanner.nextLine());
                                }
                                System.out.println("Gênero do produto (alimentício, limpeza, vestuário, higiene pessoal):");
                                String genero = scanner.nextLine();
                                deposito.adicionarProduto(new ProdutoNaoDuravel(nome, preco, marca, descricao, dataFabricacao, dataValidade, genero));
                            }
                            default -> System.out.println("Não foi possível identificar a opção selecionada.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Digite o número do produto:");
                        int indice = 0;
                        while (indice < 1 || indice > deposito.quantidadeProdutos()) {
                            try {
                                indice = Integer.parseInt(scanner.nextLine());
                                if (indice < 1 || indice > deposito.quantidadeProdutos()) {
                                    System.out.println("Produto não encontrado. Por favor, tente novamente.");
                                }
                            } catch (Exception e) {
                                System.out.println("Valor inválido. Por favor, tente novamente.");
                            }
                        }
                        System.out.println(
                                "Deseja mesmo remover " + deposito.getProdutos().get(indice - 1) + "?\n" +
                                "1 - Sim\n" +
                                "2 - Não");
                        opcao = 0;
                        while (opcao < 1 || opcao > 2) {
                            try {
                                opcao = Integer.parseInt(scanner.nextLine());
                                if (opcao < 1 || opcao > 2) {
                                    System.out.println("Opção inválida. Por favor, tente novamente.\n");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Opção inválida. Por favor, tente novamente.\n");
                            }
                        }
                        switch (opcao) {
                            case 1 -> {
                                deposito.removerProduto(deposito.getProdutos().get(indice - 1));
                                System.out.println("Produto removido com sucesso.\n");
                            }
                            case 2 -> {}
                        }
                    }
                    case 3 -> System.out.println("Há " + deposito.quantidadeProdutos() + " produtos no depósito.\n");
                    case 4 -> {
                        if (deposito.isDepositoVazio()) {
                            System.out.println("O depósito está vazio.\n");
                        } else {
                            System.out.println("O depósito não está vazio.\n");
                        }
                    }
                    case 5 -> System.out.println("Produto mais caro do depósito:\n" + deposito.produtoMaisCaro() + "\n");
                    case 6 -> System.exit(0);
                }
            }
        } finally {
            scanner.close();
        }
    }
}
