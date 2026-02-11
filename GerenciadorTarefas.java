import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorTarefas {
    private long idTarefa;
    private List<Tarefa> listaTarefas;

    public GerenciadorTarefas() {
        this.listaTarefas = new ArrayList<>();
        this.idTarefa = 1;
    }

    public void adicionarTarefa(String titulo,String descricao){
        Tarefa tarefa = new Tarefa(idTarefa++, titulo, descricao);
        listaTarefas.add(tarefa);
    }

    public List<Tarefa> listarTarefa(){
        return listaTarefas;
    }

// Buscar tarefa por ID
    public Optional<Tarefa> buscarPorId(int id) {
        return listaTarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    // Concluir tarefa
    public boolean concluirTarefa(int id) {
        Optional<Tarefa> tarefa = buscarPorId(id);

        if (tarefa.isPresent()) {
            tarefa.get().concluir();
            return true;
        }

        return false;
    }

    // Editar tarefa
    public boolean editarTarefa(int id, String novoTitulo, String novaDescricao) {
        Optional<Tarefa> tarefa = buscarPorId(id);

        if (tarefa.isPresent()) {
            tarefa.get().setTitulo(novoTitulo);
            tarefa.get().setDescricao(novaDescricao);
            return true;
        }

        return false;
    }

    // Remover tarefa
    public boolean removerTarefa(int id) {
        Optional<Tarefa> tarefa = buscarPorId(id);

        if (tarefa.isPresent()) {
            listaTarefas.remove(tarefa.get());
            return true;
        }

        return false;
    }
}

