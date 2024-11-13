package tneves.academia_aps;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Usuario {
    private List<Aula> aulas;

    public Funcionario(String nome, String senha) {
        super(nome, senha, PerfilUsuario.PROFESSOR);
        this.aulas = new ArrayList<>();
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

}
