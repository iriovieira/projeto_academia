package tneves.academia_aps;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private int idade;
    private double altura;
    private double peso;
    private List<Aula> aulas;

    public Aluno(String nome, String senha, int idade, double altura, double peso) {
        super(nome, senha, PerfilUsuario.ALUNO);
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.aulas = new ArrayList<>();
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

    public void listarAulas() {
        if (aulas.isEmpty()) {
            System.out.println("Nenhuma aula programada.");
        } else {
            System.out.println("Agenda de aulas:");
            for (Aula aula : aulas) {
                System.out.println("- " + aula.getNome() + " | Horário: " + aula.getHorario() + " | Professor: " + aula.getProfessor().getNome());
            }
        }
    }
}
