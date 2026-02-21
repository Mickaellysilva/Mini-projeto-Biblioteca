package model;

public class Professor extends Usuario {
    public Professor(String nome, String email) { super(nome, email); }

    @Override
    public void exibirInfo() {
        System.out.println("[Professor] Nome: " + getNome());
    }
}
