package cafeteria;

public class FilaPedidos {
    private Pedido inicio;
    private Pedido fim;

    public FilaPedidos() {
        this.inicio = null;
        this.fim = null;
    }

    public void enqueue(Pedido novoPedido) {
        if (fim == null) {
            inicio = novoPedido;
            fim = novoPedido;
        } else {
            fim.proximo = novoPedido;
            fim = novoPedido;
        }
    }

    public Pedido dequeue() {
        if (inicio == null) {
            return null;
        }
        Pedido removido = inicio;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        removido.proximo = null;
        return removido;
    }

    public void printQueue() {
        if (inicio == null) {
            System.out.println("Fila de pedidos vazia.");
            return;
        }
        Pedido atual = inicio;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proximo;
        }
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}
