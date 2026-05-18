package cafeteria;

public class Pedido {
    private int id;
    private String descricao;
    public Pedido proximo;

    public Pedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.proximo = null;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Descrição: " + descricao;
    }
}
