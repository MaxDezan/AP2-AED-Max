package cafeteria;

public class PilhaCancelados {
    private Pedido topo;

    public PilhaCancelados() {
        this.topo = null;
    }

    public void push(Pedido pedido) {
        pedido.proximo = topo;
        topo = pedido;
    }

    public Pedido pop() {
        if (topo == null) {
            return null;
        }
        Pedido removido = topo;
        topo = topo.proximo;
        removido.proximo = null;
        return removido;
    }

    public void printStack() {
        if (topo == null) {
            System.out.println("Pilha de cancelados vazia.");
            return;
        }
        Pedido atual = topo;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proximo;
        }
    }

    public boolean isEmpty() {
        return topo == null;
    }
}
