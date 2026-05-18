package musica;

public class Musica {
    private String titulo;
    private String artista;
    private String album;
    private int duracao; // em segundos

    public Musica proximo;
    public Musica anterior;

    public Musica(String titulo, String artista, String album, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getAlbum() { return album; }
    public int getDuracao() { return duracao; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setArtista(String artista) { this.artista = artista; }
    public void setAlbum(String album) { this.album = album; }
    public void setDuracao(int duracao) { this.duracao = duracao; }

    @Override
    public String toString() {
        return String.format("Título: %s | Artista: %s | Álbum: %s | Duração: %ds", 
                titulo, artista, album, duracao);
    }
}
