package cafeteria;

import java.util.Scanner;

public class SistemaCafeteria {
    private static FilaPedidos filaPendentes = new FilaPedidos();
    private static PilhaCancelados pilhaCancelados = new PilhaCancelados();
    private static int contadorId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n--- Sistema de Gerenciamento de Pedidos - Cafeteria ---");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do pedido: ");
                    String desc = scanner.nextLine();
                    filaPendentes.enqueue(new Pedido(contadorId++, desc));
                    System.out.println("Pedido adicionado!");
                    break;
                case 2:
                    Pedido atendido = filaPendentes.dequeue();
                    if (atendido != null) {
                        System.out.println("Atendendo pedido: " + atendido);
                    } else {
                        System.out.println("Não há pedidos pendentes.");
                    }
                    break;
                case 3:
                    Pedido cancelado = filaPendentes.dequeue();
                    if (cancelado != null) {
                        pilhaCancelados.push(cancelado);
                        System.out.println("Pedido cancelado: " + cancelado);
                    } else {
                        System.out.println("Não há pedidos para cancelar.");
                    }
                    break;
                case 4:
                    Pedido restaurado = pilhaCancelados.pop();
                    if (restaurado != null) {
                        filaPendentes.enqueue(restaurado);
                        System.out.println("Pedido restaurado para a fila: " + restaurado);
                    } else {
                        System.out.println("Não há pedidos cancelados para restaurar.");
                    }
                    break;
                case 5:
                    System.out.println("--- Pedidos Pendentes ---");
                    filaPendentes.printQueue();
                    break;
                case 6:
                    System.out.println("--- Pedidos Cancelados ---");
                    pilhaCancelados.printStack();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
