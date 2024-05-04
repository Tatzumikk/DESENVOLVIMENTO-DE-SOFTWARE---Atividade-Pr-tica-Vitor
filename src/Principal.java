import java.util.ArrayList;

public class Principal {

    private static GestaoFuncionarios gestaoFuncionarios = new GestaoFuncionarios();

    public static void main(String[] args) {

        while (true) {

            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar funcionário");
            System.out.println("2 - Remover funcionário por nome");
            System.out.println("3 - Remover funcionário por matrícula");
            System.out.println("4 - Exibir todos os funcionários");
            System.out.println("5 - Buscar funcionário por nome");
            System.out.println("6 - Buscar funcionário por matrícula");
            System.out.println("0 - Sair");

            int opcao = Console.lerInt();

            switch (opcao) {

                case 1:
                    adicionarFuncionario();
                    break;

                case 2:

                    removerFuncionarioPorNome();
                    break;

                case 3:

                    removerFuncionarioPorMatricula();
                    break;

                case 4:
                
                    exibirTodosFuncionarios();
                    break;

                case 5:

                    buscarFuncionarioPorNome();
                    break;

                case 6:
                
                    buscarFuncionarioPorMatricula();
                    break;

                case 0:

                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        }

    }

    private static void adicionarFuncionario() {

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Desenvolvedor");
        System.out.println("3 - Estagiário");

        int tipoFuncionario = Console.lerInt();

        System.out.println("Digite o nome do funcionário:");
        String nome = Console.lerString();

        System.out.println("Digite a matrícula do funcionário:");
        int matricula = Console.lerInt();

        switch (tipoFuncionario) {

            case 1:

                System.out.println("Digite o bônus anual do gerente:");
                double bonusAnual = Console.lerDouble();

                System.out.println("Digite a equipe do gerente:");
                String equipe = Console.lerString();

                Gerente gerente = new Gerente(nome, matricula, bonusAnual, equipe);
                gestaoFuncionarios.adicionarFuncionario(gerente);
                break;

            case 2:

                Desenvolvedor desenvolvedor = new Desenvolvedor(nome, matricula, new ArrayList<>());
                gestaoFuncionarios.adicionarFuncionario(desenvolvedor);
                break;

            case 3:

                System.out.println("Digite o número de horas trabalhadas do estagiário:");
                int horasTrabalhadas = Console.lerInt();

                System.out.println("Digite o supervisor do estagiário:");
                String supervisor = Console.lerString();

                Estagiario estagiario = new Estagiario(nome, matricula, horasTrabalhadas, supervisor);
                gestaoFuncionarios.adicionarFuncionario(estagiario);
                break;

            default:

                System.out.println("Tipo de funcionário inválido.");

        }

    }

    private static void removerFuncionarioPorNome() {

        System.out.println("Digite o nome do funcionário que deseja remover:");
        String nome = Console.lerString();
        gestaoFuncionarios.removerFuncionarioPorNome(nome);

    }

    private static void removerFuncionarioPorMatricula() {

        System.out.println("Digite a matrícula do funcionário que deseja remover:");
        int matricula = Console.lerInt();
        gestaoFuncionarios.removerFuncionarioPorMatricula(matricula);

    }

    private static void exibirTodosFuncionarios() {

        System.out.println("Lista de funcionários:");
        gestaoFuncionarios.exibirTodosFuncionarios();

    }


    private static void buscarFuncionarioPorNome() {

        System.out.println("Digite o nome do funcionário que deseja buscar:");
        String nome = Console.lerString();
        Funcionario funcionarioEncontrado = gestaoFuncionarios.buscarFuncionarioPorNome(nome);

        if (funcionarioEncontrado != null) {
            System.out.println("Funcionário encontrado: " + funcionarioEncontrado.nome);
        } else {
            System.out.println("Funcionário não encontrado.");
        }

    }

    private static void buscarFuncionarioPorMatricula() {

        System.out.println("Digite a matrícula do funcionário que deseja buscar:");
        int matricula = Console.lerInt();

        Funcionario funcionarioEncontrado = gestaoFuncionarios.buscarFuncionarioPorMatricula(matricula);

        if (funcionarioEncontrado != null) {
            System.out.println("Funcionário encontrado: " + funcionarioEncontrado.nome);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

}
