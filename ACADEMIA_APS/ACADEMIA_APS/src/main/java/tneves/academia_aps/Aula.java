package tneves.academia_aps;

import java.util.ArrayList;
import java.util.List;

public class Aula {
    private String nome;
    private Funcionario professor;
    private String horario;
    private List<Aluno> alunos;

    public Aula(String nome, Funcionario professor, String horario) {
        this.nome = nome;
        this.professor = professor;
        this.horario = horario;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Funcionario getProfessor() {
        return professor;
    }

    public String getHorario() {
        return horario;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        aluno.adicionarAula(this);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado.");
        } else {
            System.out.println("Alunos inscritos:");
            for (Aluno aluno : alunos) {
                System.out.println("- " + aluno.getNome());
            }
        }
    }
}
