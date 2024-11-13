package tneves.academia_aps;

import java.util.Scanner;
import static tneves.academia_aps.PerfilUsuario.ADMIN;
import static tneves.academia_aps.PerfilUsuario.ALUNO;
import static tneves.academia_aps.PerfilUsuario.PROFESSOR;

public class ACADEMIA_APS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Academia academia = new Academia();
        
        // Cadastro de usuário inicial
        academia.cadastrarAdmin("Admin", "admin123");
        academia.cadastrarAluno("Jorge", "jorge1", 22, 1.80, 73.8);
        academia.cadastrarAluno("Samuel", "Samu123", 29, 1.65, 80.3);
        academia.cadastrarAluno("Sarah", "Sarah123", 21, 1.55, 54.7);
        academia.cadastrarAluno("Roberta", "Roberta1", 27, 1.82, 81.2);
        academia.cadastrarAluno("Vinicius", "vini123", 26, 1.68, 70.9);
        academia.cadastrarFuncionario("Aurelio Augusto", "Aurelio1");
        academia.cadastrarFuncionario("Raimundo Roberto", "R123");
        
        // Cadastro de Aula inicial
        academia.criarAula("Pilates", "Aurelio Augusto", "18:30");
        academia.inscreverAlunoEmAula("Roberta", "Pilates");
        academia.inscreverAlunoEmAula("Jorge", "Pilates");

        while (true) {
            Usuario usuario = autenticarUsuario(academia, scanner);
            
            if (usuario == null) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }

            int opcao;
            boolean sair = false;
            
            do {
                System.out.println("\n--- Menu de Opções ---");
                switch (usuario.getPerfil()) {
                    case ADMIN -> {
                        System.out.println("1. Cadastrar Aluno");
                        System.out.println("2. Cadastrar Professor");
                        System.out.println("3. Criar Aula");
                        System.out.println("4. Listar Professores");
                        System.out.println("5. Listar Alunos");
                        System.out.println("6. Listar Aulas Disponíveis");
                        System.out.println("7. Deslogar");
                        System.out.println("8. Sair");
                        opcao = lerOpcao(scanner);

                        switch (opcao) {
                            case 1 -> cadastrarAluno(academia, scanner);
                            case 2 -> cadastrarFuncionario(academia, scanner);
                            case 3 -> criarAula(academia, scanner);
                            case 4 -> academia.listarProfessores();
                            case 5 -> academia.listarAlunos();
                            case 6 -> academia.listarAulas();
                            case 7 -> {
                                System.out.println("Deslogando...");
                                sair = true;
                            }
                            case 8 -> {
                                System.out.println("Saindo do programa...");
                                System.exit(0);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                    case ALUNO -> {
                        System.out.println("1. Inscrever-se em uma Aula");
                        System.out.println("2. Listar Aulas Inscritas");
                        System.out.println("3. Listar Professores Disponíveis");
                        System.out.println("4. Deslogar");
                        System.out.println("5. Sair");
                        opcao = lerOpcao(scanner);

                        switch (opcao) {
                            case 1 -> inscreverAlunoEmAula((Aluno) usuario, academia, scanner);
                            case 2 -> ((Aluno) usuario).listarAulas();
                            case 3 -> academia.listarProfessores();
                            case 4 -> {
                                System.out.println("Deslogando...");
                                sair = true;
                            }
                            case 5 -> {
                                System.out.println("Saindo do programa...");
                                System.exit(0);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                    case PROFESSOR -> {
                        System.out.println("1. Listar Aulas Ministradas");
                        System.out.println("2. Listar Alunos Cadastrados");
                        System.out.println("3. Deslogar");
                        System.out.println("4. Sair");
                        opcao = lerOpcao(scanner);

                        switch (opcao) {
                            case 1 -> academia.listarAulas();
                            case 2 -> academia.listarAlunos();
                            case 3 -> {
                                System.out.println("Deslogando...");
                                sair = true;
                            }
                            case 4 -> {
                                System.out.println("Saindo do programa...");
                                System.exit(0);
                            }
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                }
            } while (!sair);
        }
    }

    private static Usuario autenticarUsuario(Academia academia, Scanner scanner) {
        System.out.println("Bem-vindo ao sistema de autenticação!");

        while (true) {
            System.out.println("1. Fazer login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = lerOpcao(scanner);

            if (escolha == 2) {
                
                return null;
            } else if (escolha == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                return academia.autenticarUsuario(nome, senha);
            } else {
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.\n");
            }
        }
    }

   private static void cadastrarAluno(Academia academia, Scanner scanner) {
    System.out.print("Nome do Aluno: ");
    String nome = scanner.nextLine();
    System.out.print("Senha do Aluno: ");
    String senha = scanner.nextLine();
    System.out.print("Idade: ");
    int idade = scanner.nextInt();
    scanner.nextLine(); 

    double altura;
    while (true) {
        System.out.print("Altura (em metros, ex: 1.68): ");
        String entradaAltura = scanner.nextLine().trim();

        try {
            altura = Double.parseDouble(entradaAltura);
            System.out.println("Altura registrada: " + altura + " metros");
            break;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite a altura como um número decimal (ex: 1.68).");
        }
    }

    double peso;
    while (true) {
        System.out.print("Peso (em kg, ex: 70.5): ");
        String entradaPeso = scanner.nextLine().trim();

        try {
            peso = Double.parseDouble(entradaPeso);
            System.out.println("Peso registrado: " + peso + " kg");
            break;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite o peso como um número decimal (ex: 70.5).");
        }
    }

    academia.cadastrarAluno(nome, senha, idade, altura, peso);
    System.out.println("Aluno cadastrado com sucesso!");
}


    private static void cadastrarFuncionario(Academia academia, Scanner scanner) {
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        System.out.print("Senha do Professor: ");
        String senha = scanner.nextLine();

        academia.cadastrarFuncionario(nome, senha);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void criarAula(Academia academia, Scanner scanner) {
        System.out.print("Nome da Aula: ");
        String nomeAula = scanner.nextLine();
        System.out.print("Nome do Professor responsável: ");
        String nomeProfessor = scanner.nextLine();
        System.out.print("Horário da Aula: ");
        String horario = scanner.nextLine();

        academia.criarAula(nomeAula, nomeProfessor, horario);
        System.out.println("Aula criada com sucesso!");
    }

    private static int lerOpcao(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
            }
        }
    }

    private static void inscreverAlunoEmAula(Aluno aluno, Academia academia, Scanner scanner) {
        System.out.println("Aulas disponíveis para inscrição:");
        academia.listarAulas();

        System.out.print("Digite o nome da aula que deseja se inscrever: ");
        String nomeAula = scanner.nextLine();

        if (academia.inscreverAlunoEmAula(aluno.getNome(), nomeAula)) {
            System.out.println("Inscrição realizada com sucesso!");
        } else {
            System.out.println("Erro ao inscrever-se na aula. Verifique se o nome da aula está correto.");
        }
    }
}
