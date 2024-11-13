package tneves.academia_aps;

public abstract class Usuario {
    private String nome;
    private String senha;
    private PerfilUsuario perfil;

    public Usuario(String nome, String senha, PerfilUsuario perfil) {
        this.nome = nome;
        this.senha = senha;
        this.perfil = perfil;
    }
    
    public String getNome() {
        return nome;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
