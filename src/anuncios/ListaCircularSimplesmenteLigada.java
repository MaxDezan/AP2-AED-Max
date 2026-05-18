package anuncios;

public class ListaCircularSimplesmenteLigada {
    private Anuncio anuncioAtual;
    private int tamanho;

    public ListaCircularSimplesmenteLigada() {
        this.anuncioAtual = null;
        this.tamanho = 0;
    }

    public void adicionarAnuncio(Anuncio novo) {
        if (anuncioAtual == null) {
            anuncioAtual = novo;
            novo.proximo = novo;
        } else {
            // Insere logo após o anúncio atual
            novo.proximo = anuncioAtual.proximo;
            anuncioAtual.proximo = novo;
        }
        tamanho++;
    }

    public void adicionarNoFinal(Anuncio novo) {
        if (anuncioAtual == null) {
            anuncioAtual = novo;
            novo.proximo = novo;
        } else {
            // Localiza o "fim" (nó que aponta para o primeiro, que vamos considerar o atual.proximo como o início lógico)
            // Na circular simples, qualquer ponto pode ser o início. Vamos inserir antes do atual.
            Anuncio aux = anuncioAtual;
            while (aux.proximo != anuncioAtual) {
                aux = aux.proximo;
            }
            aux.proximo = novo;
            novo.proximo = anuncioAtual;
        }
        tamanho++;
    }

    public void exibirEAvancar() {
        if (anuncioAtual == null) {
            System.out.println("Nenhum anúncio cadastrado.");
            return;
        }
        System.out.println("EXIBINDO: " + anuncioAtual);
        anuncioAtual.incrementarExibicoes();
        anuncioAtual = anuncioAtual.proximo;
    }

    public boolean removerAnuncio(int id) {
        if (anuncioAtual == null) return false;

        Anuncio anterior = null;
        Anuncio atual = anuncioAtual;
        boolean encontrado = false;

        // Caso especial: lista com apenas 1 elemento
        if (tamanho == 1) {
            if (atual.getId() == id) {
                anuncioAtual = null;
                tamanho = 0;
                return true;
            }
            return false;
        }

        // Procura o elemento e o anterior
        // Usamos um contador para evitar loop infinito se o ID não existir
        for (int i = 0; i < tamanho; i++) {
            if (atual.getId() == id) {
                encontrado = true;
                break;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        if (encontrado) {
            // Se o elemento a ser removido for o anuncioAtual, move o ponteiro antes de remover
            if (atual == anuncioAtual) {
                anuncioAtual = atual.proximo;
            }
            
            // Se anterior for null, significa que o elemento é o anuncioAtual e não percorremos o loop
            // Mas em lista circular, o anterior sempre existe. Vamos localizar se for o caso.
            if (anterior == null) {
                anterior = atual;
                while (anterior.proximo != atual) {
                    anterior = anterior.proximo;
                }
            }
            
            anterior.proximo = atual.proximo;
            tamanho--;
            return true;
        }

        return false;
    }

    public void listarCicloCompleto() {
        if (anuncioAtual == null) {
            System.out.println("Ciclo vazio.");
            return;
        }
        Anuncio aux = anuncioAtual;
        System.out.println("--- Ciclo de Anúncios ---");
        for (int i = 0; i < tamanho; i++) {
            System.out.println(aux);
            aux = aux.proximo;
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
