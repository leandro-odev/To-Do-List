import java.util.Date;

public class Task {
    private boolean status;
    private String categoria;
    private String titulo;
    private String descricao;

    public Task(String titulo, String categoria, String descricao) {
        this.status = false;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public void marcarStatus() {
        status = !status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isStatus() {
        return status;
    }

    public String toString() {
        return "Tarefa: " + this.titulo + " - " +  this.categoria + "\n" + this.descricao + "\nStatus: " + this.status ;
    }
}
