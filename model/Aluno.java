package model;

public class Aluno extends Usuario {
    public Aluno(String nome, String email) { super(nome, email); }

    @Override
    public void exibirInfo() {
        System.out.println("[Aluno] Nome: " + getNome());
    }
}
