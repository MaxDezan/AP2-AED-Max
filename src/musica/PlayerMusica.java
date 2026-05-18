package musica;

import java.util.Scanner;

public class PlayerMusica {
    private static ListaDuplamenteLigada playlist = new ListaDuplamenteLigada();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("\n--- Player de Música - Gerenciamento de Playlist ---");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist (Título)");
            System.out.println("4. Ordenar playlist (Artista)");
            System.out.println("5. Tocar música atual");
            System.out.println("6. Adicionar música");
            System.out.println("7. Remover música");
            System.out.println("8. Listar músicas");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    Musica proxima = playlist.proximaMusica();
                    if (proxima != null) System.out.println("Avançou para: " + proxima);
                    else System.out.println("Fim da playlist.");
                    break;
                case 2:
                    Musica anterior = playlist.musicaAnterior();
                    if (anterior != null) System.out.println("Voltou para: " + anterior);
                    else System.out.println("Início da playlist.");
                    break;
                case 3:
                    playlist.ordenarPorTitulo();
                    System.out.println("Playlist ordenada por título.");
                    break;
                case 4:
                    playlist.ordenarPorArtista();
                    System.out.println("Playlist ordenada por artista.");
                    break;
                case 5:
                    Musica atual = playlist.getAtual();
                    if (atual != null) {
                        System.out.println("Tocando agora: " + atual);
                    } else {
                        System.out.println("Nenhuma música na playlist.");
                    }
                    break;
                case 6:
                    System.out.print("Título: "); String t = scanner.nextLine();
                    System.out.print("Artista: "); String art = scanner.nextLine();
                    System.out.print("Álbum: "); String alb = scanner.nextLine();
                    
                    int d = 0;
                    while (true) {
                        System.out.print("Duração (segundos): ");
                        try {
                            d = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Duração inválida. Digite um número inteiro.");
                        }
                    }

                    System.out.println("Onde adicionar? 1.Início 2.Fim 3.Posição");
                    int onde = 0;
                    try {
                        onde = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida. Operação cancelada.");
                        break;
                    }

                    Musica nova = new Musica(t, art, alb, d);
                    if (onde == 1) playlist.adicionarInicio(nova);
                    else if (onde == 2) playlist.adicionarFim(nova);
                    else if (onde == 3) {
                        System.out.print("Posição: ");
                        try {
                            int p = Integer.parseInt(scanner.nextLine());
                            playlist.adicionarPosicao(nova, p);
                        } catch (NumberFormatException e) {
                            System.out.println("Posição inválida. Operação cancelada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 7:
                    System.out.println("Remover por: 1.Título 2.Posição");
                    int r = 0;
                    try {
                        r = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    if (r == 1) {
                        System.out.print("Título: "); String tit = scanner.nextLine();
                        if (playlist.removerPorTitulo(tit)) System.out.println("Removida.");
                        else System.out.println("Não encontrada.");
                    } else if (r == 2) {
                        System.out.print("Posição: ");
                        try {
                            int pos = Integer.parseInt(scanner.nextLine());
                            if (playlist.removerPorPosicao(pos)) System.out.println("Removida.");
                            else System.out.println("Posição inválida.");
                        } catch (NumberFormatException e) {
                            System.out.println("Posição inválida.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 8:
                    playlist.listarMusicas();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
