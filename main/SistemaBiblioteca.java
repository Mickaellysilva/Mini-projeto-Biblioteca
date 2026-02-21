package main;

import model.*;
import service.BibliotecaService;
import exceptions.LivroIndisponivelException;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();

        Usuario aluno = new Aluno("João Silva", "joao@email.com");
        Usuario prof = new Professor("Dra. Isandra", "DrsIsandra@faculdade.com");

        Livro l1 = new Livro("Java: Como Programar", "Deitel");
        Livro l2 = new Livro("Clean Code", "Robert Martin");

        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);

        // Fluxo de teste
        biblioteca.listarLivrosDisponiveis();

        try {
            System.out.println("Tentando primeiro empréstimo...");
            biblioteca.realizarEmprestimo(aluno, l1);

            System.out.println("Tentando segundo empréstimo do mesmo livro...");
            biblioteca.realizarEmprestimo(prof, l1);

        } catch (LivroIndisponivelException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Devolvendo livro...");
        biblioteca.realizarDevolucao(l1);

        biblioteca.listarLivrosDisponiveis();
    }
}
