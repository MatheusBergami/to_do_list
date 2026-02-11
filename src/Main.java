import java.util.List;
import java.util.Scanner;

public class Main {

    private static GerenciadorTarefas gerenciador = new GerenciadorTarefas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    concluirTarefa();
                    break;
                case 4:
                    editarTarefa();
                    break;
                case 5:
                    removerTarefa();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== TO DO LIST =====");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Concluir tarefa");
        System.out.println("4 - Editar tarefa");
        System.out.println("5 - Remover tarefa");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.println("Digite um numero valido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void adicionarTarefa() {
        scanner.nextLine();

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Descricao: ");
        String descricao = scanner.nextLine();

        gerenciador.adicionarTarefa(titulo, descricao);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void listarTarefas() {
        List<Tarefa> tarefas = gerenciador.listarTarefa();

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (Tarefa t : tarefas) {
            System.out.println(t);
        }
    }

    private static void concluirTarefa() {
        System.out.print("Digite o ID da tarefa: ");
        int id = lerInteiro();

        boolean sucesso = gerenciador.concluirTarefa(id);

        if (sucesso) {
            System.out.println("Tarefa concluida com sucesso.");
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }

    private static void editarTarefa() {
        System.out.print("Digite o ID da tarefa: ");
        int id = lerInteiro();

        scanner.nextLine();

        System.out.print("Novo titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Nova descricao: ");
        String descricao = scanner.nextLine();

        boolean sucesso = gerenciador.editarTarefa(id, titulo, descricao);

        if (sucesso) {
            System.out.println("Tarefa editada com sucesso.");
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }

    private static void removerTarefa() {
        System.out.print("Digite o ID da tarefa: ");
        int id = lerInteiro();

        boolean sucesso = gerenciador.removerTarefa(id);

        if (sucesso) {
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }
}
