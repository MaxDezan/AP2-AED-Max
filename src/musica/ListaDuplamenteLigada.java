package musica;

public class ListaDuplamenteLigada {
    private Musica inicio;
    private Musica fim;
    private Musica atual;
    private int tamanho;

    public ListaDuplamenteLigada() {
        this.inicio = null;
        this.fim = null;
        this.atual = null;
        this.tamanho = 0;
    }

    public void adicionarInicio(Musica musica) {
        if (inicio == null) {
            inicio = fim = atual = musica;
        } else {
            musica.proximo = inicio;
            inicio.anterior = musica;
            inicio = musica;
        }
        tamanho++;
    }

    public void adicionarFim(Musica musica) {
        if (fim == null) {
            inicio = fim = atual = musica;
        } else {
            fim.proximo = musica;
            musica.anterior = fim;
            fim = musica;
        }
        tamanho++;
    }

    public void adicionarPosicao(Musica musica, int posicao) {
        if (posicao <= 0) {
            adicionarInicio(musica);
        } else if (posicao >= tamanho) {
            adicionarFim(musica);
        } else {
            Musica aux = inicio;
            for (int i = 0; i < posicao; i++) {
                aux = aux.proximo;
            }
            musica.anterior = aux.anterior;
            musica.proximo = aux;
            aux.anterior.proximo = musica;
            aux.anterior = musica;
            tamanho++;
        }
    }

    public boolean removerPorTitulo(String titulo) {
        Musica aux = inicio;
        while (aux != null) {
            if (aux.getTitulo().equalsIgnoreCase(titulo)) {
                removerNo(aux);
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public boolean removerPorPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return false;
        Musica aux = inicio;
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        removerNo(aux);
        return true;
    }

    private void removerNo(Musica no) {
        if (no == inicio) {
            inicio = no.proximo;
            if (inicio != null) inicio.anterior = null;
            else fim = null;
        } else if (no == fim) {
            fim = no.anterior;
            if (fim != null) fim.proximo = null;
            else inicio = null;
        } else {
            no.anterior.proximo = no.proximo;
            no.proximo.anterior = no.anterior;
        }
        if (atual == no) {
            atual = (no.proximo != null) ? no.proximo : inicio;
        }
        tamanho--;
    }

    public Musica proximaMusica() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
        }
        return atual;
    }

    public Musica musicaAnterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
        }
        return atual;
    }

    public Musica getAtual() {
        return atual;
    }

    public void listarMusicas() {
        if (inicio == null) {
            System.out.println("Playlist vazia.");
            return;
        }
        Musica aux = inicio;
        int i = 0;
        while (aux != null) {
            String mark = (aux == atual) ? "-> " : "   ";
            System.out.println(mark + "[" + i + "] " + aux);
            aux = aux.proximo;
            i++;
        }
    }

    public void ordenarPorTitulo() {
        if (tamanho < 2) return;
        for (int i = 0; i < tamanho - 1; i++) {
            Musica aux = inicio;
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (aux.getTitulo().compareToIgnoreCase(aux.proximo.getTitulo()) > 0) {
                    trocarDados(aux, aux.proximo);
                }
                aux = aux.proximo;
            }
        }
    }

    public void ordenarPorArtista() {
        if (tamanho < 2) return;
        for (int i = 0; i < tamanho - 1; i++) {
            Musica aux = inicio;
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (aux.getArtista().compareToIgnoreCase(aux.proximo.getArtista()) > 0) {
                    trocarDados(aux, aux.proximo);
                }
                aux = aux.proximo;
            }
        }
    }

    public void buscar(String termo) {
        Musica aux = inicio;
        boolean encontrou = false;
        while (aux != null) {
            if (aux.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                aux.getArtista().toLowerCase().contains(termo.toLowerCase()) ||
                aux.getAlbum().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(aux);
                encontrou = true;
            }
            aux = aux.proximo;
        }
        if (!encontrou) System.out.println("Nenhuma música encontrada.");
    }

    private void trocarDados(Musica a, Musica b) {
        String tempTitulo = a.getTitulo();
        String tempArtista = a.getArtista();
        String tempAlbum = a.getAlbum();
        int tempDuracao = a.getDuracao();

        a.setTitulo(b.getTitulo());
        a.setArtista(b.getArtista());
        a.setAlbum(b.getAlbum());
        a.setDuracao(b.getDuracao());

        b.setTitulo(tempTitulo);
        b.setArtista(tempArtista);
        b.setAlbum(tempAlbum);
        b.setDuracao(tempDuracao);
    }
}
