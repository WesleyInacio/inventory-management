/*import model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoTeste2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> listaProdutos = new ArrayList();
        int qtd;
        Produto produto;
        System.out.println("Quantos produtos vai cadastrar?");
        qtd = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < qtd; i++) {
            //nova instância para produto (referência)
            produto = new Produto();
            System.out.println("Digite o código: ");
            produto.setCodigo(Integer.parseInt(scanner.nextLine()));
            System.out.println("Digite a descrição: ");
            produto.setDescricao(scanner.nextLine());
            System.out.println("Digite o valor: ");
            produto.setValorUnitario(Double.parseDouble(scanner.nextLine()));
            System.out.println("Digite a quantidade: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
            listaProdutos.add(produto);
        }

        //percorrrer a lista e imprimir todos os dados de todos produtos
        for (Produto item : listaProdutos){
            System.out.println(item);
        }
    }
}
*/