package cli;
import model.Produto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoGerenciamento {
    List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProdutoGerenciamento gerenciamento = new ProdutoGerenciamento();
        int opcao = 0;
        do{
            System.out.println("Menu Principal");
            System.out.println("1. Cadastro de produto");
            System.out.println("2. Lista de produtos");
            System.out.println("3. Quantidade em estoque");
            System.out.println("4. Patrimônio estocado");
            System.out.println("5. Registrar entrada de produto");
            System.out.println("6. Registrar saída de produto");
            System.out.println("9. Sair");
            System.out.println("Digite sua opção: ");
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao){
                case 1:
                    gerenciamento.execCadastro(sc);
                    break;
                case 2:
                    gerenciamento.execListarProdutos();
                    break;
                case 3:
                    gerenciamento.execVerEstoque(sc);
                    break;
                case 4:
                    gerenciamento.execPatrimonio();
                    break;
                case 5:
                    gerenciamento.execEntrada(sc);
                    break;
                case 6:
                    gerenciamento.execSaida(sc);
                    break;
                case 9:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 9);
    }

    private void execCadastro(Scanner sc) {
        Produto p = new Produto();
        System.out.println("Cadastro do novo produto");
        System.out.println("Digite o código do produto: ");
        p.setCodigo(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite a descrição do produto: ");
        p.setDescricao(sc.nextLine());
        System.out.println("Digite o valor unitário do produto: ");
        p.setValorUnitario(Double.parseDouble(sc.nextLine()));
        System.out.println("Produto cadastrado com sucesso");
        produtos.add(p);
    }

    private void execListarProdutos() {
        for(Produto produto : produtos){
            System.out.println(produto);
        }
        System.out.println("Produtos listados com sucesso");
    }

    private void execVerEstoque(Scanner sc) {
        Produto produtoProc = null;
        String codigo = JOptionPane.showInputDialog(null, "Digite o código do produto desejado: ", "Código", JOptionPane.QUESTION_MESSAGE);
        produtoProc = encontrarProduto(Integer.parseInt(codigo));
        if (produtoProc != null){
            System.out.println(produtoProc);
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    private void execPatrimonio() {
        double acumulado = 0.0;
        for(Produto produto : produtos){
            acumulado += produto.getQuantidade() * produto.getValorUnitario();
        }
        System.out.println("Valor em reais estocado: R$" + acumulado);
    }

    private void execEntrada(Scanner sc) {
        Produto produtoProc = null;
        System.out.println("Digite o código do produto desejado: ");
        produtoProc = encontrarProduto(Integer.parseInt(sc.nextLine()));
        if (produtoProc != null){
            System.out.println("Digite a quantidade de entrada: ");
            int entrada = Integer.parseInt(sc.nextLine());
            produtoProc.registrarEntrada(entrada);
            System.out.println("Entrada registrada");
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    private void execSaida(Scanner sc) {
        try {
            Produto produtoProc = null;
            System.out.println("Digite o código do produto desejado: ");
            produtoProc = encontrarProduto(Integer.parseInt(sc.nextLine()));
            if (produtoProc != null){
                System.out.println("Digite a quantidade de saída: ");
                int saida = Integer.parseInt(sc.nextLine());
                produtoProc.registrarSaida(saida);
                System.out.println("Saída registrada");
            } else {
                System.out.println("Produto não encontrado");
            }
        } catch (Exception e){
            System.out.println("Aconteceu o erro: "+e.getMessage());
        }
    }

    private Produto encontrarProduto(int codigo) {
        for(Produto produto : produtos){
            if (produto.getCodigo() == codigo) return produto;
        }
        return null;
    }
}