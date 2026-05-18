package anuncios;

import java.util.Scanner;

public class PainelDigital {
    private static ListaCircularSimplesmenteLigada carrossel = new ListaCircularSimplesmenteLigada();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        int proximoId = 101;

        while (opcao != 6) {
            System.out.println("\n--- Painel Digital - Carrossel de Anúncios ---");
            System.out.println("1. Exibir e Avançar");
            System.out.println("2. Adicionar Anúncio (após o atual)");
            System.out.println("3. Adicionar Anúncio (ao final lógico)");
            System.out.println("4. Remover Anúncio por ID");
            System.out.println("5. Listar Ciclo Completo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    carrossel.exibirEAvancar();
                    break;
                case 2:
                    System.out.print("Nome da Empresa: "); String emp1 = scanner.nextLine();
                    System.out.print("Descrição: "); String desc1 = scanner.nextLine();
                    carrossel.adicionarAnuncio(new Anuncio(proximoId++, emp1, desc1));
                    System.out.println("Anúncio adicionado após o atual.");
                    break;
                case 3:
                    System.out.print("Nome da Empresa: "); String emp2 = scanner.nextLine();
                    System.out.print("Descrição: "); String desc2 = scanner.nextLine();
                    carrossel.adicionarNoFinal(new Anuncio(proximoId++, emp2, desc2));
                    System.out.println("Anúncio adicionado ao final.");
                    break;
                case 4:
                    System.out.print("ID do anúncio para remover: ");
                    try {
                        int idRemover = Integer.parseInt(scanner.nextLine());
                        if (carrossel.removerAnuncio(idRemover)) {
                            System.out.println("Anúncio removido.");
                        } else {
                            System.out.println("Anúncio não encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Digite um número.");
                    }
                    break;
                case 5:
                    carrossel.listarCicloCompleto();
                    break;
                case 6:
                    System.out.println("Encerrando painel...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
