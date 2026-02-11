package src.model;
import java.time.LocalDateTime;

public class Tarefa{
    private long id;
    private String titulo,descricao;
    private boolean concluida;
    private LocalDateTime dataCricao;

    public Tarefa(long id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
        this.dataCricao = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public LocalDateTime getDataCricao() {
        return dataCricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void concluir() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", concluida=" + concluida
                + ", dataCricao=" + dataCricao + "]";
    }
}