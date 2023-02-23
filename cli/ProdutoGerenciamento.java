package cli;
import model.Produto;
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
                    gerenciamento.execEntrada();
                    break;
                case 6:
                    gerenciamento.execSaida();
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
        int codigoProcurado;
        System.out.println("Digite o código do produto desejado: ");
        codigoProcurado = Integer.parseInt(sc.nextLine());
        for(Produto produto : produtos){
            if (produto.getCodigo() == codigoProcurado){
                System.out.println(produto);
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    private void execPatrimonio() {
        double acumulado = 0.0;
        for(Produto produto : produtos){
            acumulado += produto.getQuantidade() * produto.getValorUnitario();
        }
        System.out.println("Valor em reais estocado: R$" + acumulado);
    }

    private void execEntrada() {

    }

    private void execSaida() {

    }
}
