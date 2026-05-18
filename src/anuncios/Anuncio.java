package anuncios;

public class Anuncio {
    private int id;
    private String empresa;
    private String descricao;
    private int exibicoes;
    public Anuncio proximo;

    public Anuncio(int id, String empresa, String descricao) {
        this.id = id;
        this.empresa = empresa;
        this.descricao = descricao;
        this.exibicoes = 0;
        this.proximo = null;
    }

    public int getId() { return id; }
    public String getEmpresa() { return empresa; }
    public String getDescricao() { return descricao; }
    public int getExibicoes() { return exibicoes; }
    
    public void incrementarExibicoes() {
        this.exibicoes++;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Empresa: %s | Descrição: %s | Exibições: %d", 
                id, empresa, descricao, exibicoes);
    }
}
