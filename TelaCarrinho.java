import java.util.Scanner;
import java.util.ArrayList;

// questão 5
public class TelaCarrinho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrinho carrinho = new Carrinho(1, "Cliente Padrão");

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserir mercadoria");
            System.out.println("2 - Remover mercadoria");
            System.out.println("3 - Listar carrinho");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Tipo de produto (1 - Celular | 2 - Computador): ");
                    int tipo = sc.nextInt();
                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    if (tipo == 1) {
                        System.out.print("Desconto (%): ");
                        double desconto = sc.nextDouble();
                        carrinho.cadastrar(new Celular(codigo, nome, preco, desconto));
                    } else if (tipo == 2) {
                        sc.nextLine();
                        System.out.print("Configuração: ");
                        String config = sc.nextLine();
                        carrinho.cadastrar(new Computador(codigo, nome, preco, config));
                    }
                    break;

                case 2:
                    System.out.print("Código da mercadoria a remover: ");
                    int codRem = sc.nextInt();
                    Mercadoria m = carrinho.procurar(codRem);
                    carrinho.remover(m);
                    break;

                case 3:
                    carrinho.conteudo();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}