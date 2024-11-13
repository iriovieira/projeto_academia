package tneves.academia_aps;

public class Admin extends Usuario {
    public Admin(String nome, String senha) {
        super(nome, senha, PerfilUsuario.ADMIN);
    }
}
