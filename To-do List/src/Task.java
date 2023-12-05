public class Task {
    private String titulo;
    private String categoria;
    private String descricao;
    public Data prazo;
    private String status;

    public Task(String titulo, String categoria, String descricao, Data prazo) {
        this.status = "A fazer";
        this.prazo = prazo;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public void marcarStatus() {
        if (this.status.equals("A fazer")) {
            this.status = "Feito";
        } else {
            this.status = "A fazer";
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String isStatus() {
        return status;
    }

    public String getCategoria() {
        return categoria;
    }

    public String toString() {
        return this.titulo.toUpperCase() + "\nCategoria: " +  this.categoria + "\n" + this.descricao  +
                "\nPrazo: " + this.prazo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}