package tneves.academia_aps;

import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Aluno> alunos;
    private List<Funcionario> funcionarios;
    private List<Usuario> usuarios;
    private List<Aula> aulas;

    public Academia() {
        this.alunos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }
    
    public void cadastrarAluno(String nome, String senha, int idade, double altura, double peso) {
        Aluno aluno = new Aluno(nome, senha, idade, altura, peso);
        alunos.add(aluno);
        usuarios.add(aluno);
    }

    public void cadastrarFuncionario(String nome, String senha) {
        Funcionario funcionario = new Funcionario(nome, senha);
        funcionarios.add(funcionario);
        usuarios.add(funcionario);
    }

    public void cadastrarAdmin(String nome, String senha) {
        Admin admin = new Admin(nome, senha);
        usuarios.add(admin);
    }

    public void criarAula(String nomeAula, String nomeProfessor, String horario) {
        Funcionario professor = (Funcionario) buscarUsuario(nomeProfessor, PerfilUsuario.PROFESSOR);
        if (professor != null) {
            Aula novaAula = new Aula(nomeAula, professor, horario);
            aulas.add(novaAula);
            professor.adicionarAula(novaAula);
        } else {
            System.out.println("Professor não encontrado.");
        }
    }


    public Usuario autenticarUsuario(String nome, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.autenticar(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private Aula buscarAula(String nomeAula) {
        for (Aula aula : aulas) {
            if (aula.getNome().equalsIgnoreCase(nomeAula)) {
                return aula;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(String nome, PerfilUsuario perfil) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome) && usuario.getPerfil() == perfil) {
                return usuario;
            }
        }
        return null;
    }

    public void listarProfessores() {
        System.out.println("Professores cadastrados:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("- " + funcionario.getNome());
        }
    }

    public void listarAlunos() {
        System.out.println("Alunos cadastrados:");
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome());
        }
    }

   public void listarAulas() {
        if (aulas.isEmpty()) {
            System.out.println("Nenhuma aula programada.");
        } else {
            System.out.println("Agenda de aulas:");
            for (Aula aula : aulas) {
                System.out.println("- " + aula.getNome() + " | Horário: " + aula.getHorario());
                aula.listarAlunos();
            }
        }
    }
public boolean inscreverAlunoEmAula(String nomeAluno, String nomeAula) {
    Aluno aluno = (Aluno) buscarUsuario(nomeAluno, PerfilUsuario.ALUNO);
    Aula aula = buscarAula(nomeAula);

    if (aluno != null && aula != null) {
        aula.adicionarAluno(aluno);
        return true;
    } else {
        System.out.println("Aluno ou aula não encontrados.");
        return false;
    }
}
}
