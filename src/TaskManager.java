import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<Task>();
    Scanner input = new Scanner(System.in);

    public TaskManager() {
        userInterface();
    }

    private void userInterface() {
        System.out.println("Bem-vindo(a) ao TaskManager.");
        while (true) {
            System.out.println("\nEscolha:\n1 para adicionar\n2 para remover\n3 para marcar ou desmarcar uma tarefa\n4 para printar tarefas\noutro para sair\nsua escolha: ");
            String escolha = input.nextLine().strip();
            if (escolha.equals("1")) {
                System.out.println("\nAdicionando tarefa:");
                novaTask();
            } else if (escolha.equals("2")) {
                System.out.println("\nRemovendo tarefa:");
                removeTask();
            } else if (escolha.equals("3")) {
                System.out.println("\nMarcando tarefa:");
                marcarTask();
            } else if (escolha.equals("4")) {
                System.out.println("\nPrintando tarefas:");
                printaTasks();
            } else {
                System.out.println("Digite S para confirmar sua saída do programa: ");
                String escolha2 = input.nextLine().strip().toUpperCase();
                if (escolha2.equals("S")) {
                    System.out.println("Obrigado por utilizar o TaskManager.");
                    break;
                }
            }
        }
    }

    private void novaTask() {
        System.out.println("Digite o nome da sua task: ");
        String nome = input.nextLine();

        System.out.println("Digite a categoria da sua task: ");
        String categoria = input.nextLine();

        System.out.println("Digite a descrição da sua task: ");
        String descricao = input.nextLine();

        tasks.add(new Task(nome, categoria, descricao));
    }

    private void removeTask() {
        System.out.println("Digite o título da task que deseja remover: ");
        String remove = input.nextLine().strip().toLowerCase();
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getTitulo().toLowerCase().equals(remove)) {
                tasks.remove(i);
                System.out.println("Tarefa removida com sucesso!");
                break;
            }
        }
    }

    private void marcarTask() {
        System.out.println("Digite o título da task que deseja marcar: ");
        String marcar = input.nextLine().strip().toLowerCase();
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getTitulo().toLowerCase().equals(marcar)) {
                tasks.get(i).marcarStatus();
                System.out.println("Tarefa marcada com sucesso!");
                System.out.println(tasks.get(i).toString());
                break;
            }
        }
    }

    private void printaTasks() {
        System.out.println("Digite:\n1 para printar todas as tasks\n2 para printar as tasks concluídas\n3 para printar tasks não concluidas\noutro para escolher uma categoria específica");
        String escolha = input.nextLine().strip();
        if (escolha.equals("1")) {
            System.out.println("Suas tarefas:");
            System.out.println("-------------");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(tasks.get(i).toString());
                System.out.println("-------------");
            }
        } else if (escolha.equals("2")) {
            System.out.println("Suas tarefas:");
            System.out.println("-------------");
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).isStatus()) {
                    System.out.println(tasks.get(i).toString());
                    System.out.println("-------------");
                }
            }
        } else if(escolha.equals("3")) {
            System.out.println("Suas tarefas:");
            System.out.println("-------------");
            for (int i = 0; i < tasks.size(); i++) {
                if (!tasks.get(i).isStatus()) {
                    System.out.println(tasks.get(i).toString());
                    System.out.println("-------------");
                }
            }
        } else {
            System.out.println("Categorias disponiveis:");
            ArrayList<String> categorias = new ArrayList<String>();

            for(int i = 0; i < tasks.size(); i++) {
                String categoria_atual = tasks.get(i).getCategoria();
                if (!categorias.contains(categoria_atual)) {
                    categorias.add(categoria_atual);
                    System.out.println(categoria_atual);
                }
            }

            String categoria_escolha;
            while (true) {
                System.out.println("Escolha o nome da categoria desejada:");
                categoria_escolha = input.nextLine().strip();
                if (categorias.contains(categoria_escolha)) {
                    break;
                }
                else {
                    System.out.println("Categoria inexistente, ou escrita errada. Tente novamente");
                }
            }

            System.out.println("Suas tarefas:");
            System.out.println("-------------");

            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getCategoria().equals(categoria_escolha)) {
                    System.out.println(tasks.get(i).toString());
                    System.out.println("-------------");
                }
            }
        }
    }
}
