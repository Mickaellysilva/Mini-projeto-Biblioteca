import exceptions.LivroIndisponivelException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Livro> acervo = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
    }

    public void listarLivrosDisponiveis() {
        System.out.println("\n--- Livros Disponíveis ---");
        acervo.stream()
                .filter(Livro::isDisponivel)
                .forEach(System.out::println);
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) throws LivroIndisponivelException {
        if (!livro.isDisponivel()) {
            throw new LivroIndisponivelException("Erro: O livro '" + livro.getTitulo() + "' já está emprestado.");
        }
        livro.setDisponivel(false);
        System.out.println("Sucesso! O usuário " + usuario.getNome() + " pegou o livro: " + livro.getTitulo());
    }

    public void realizarDevolucao(Livro livro) {
        livro.setDisponivel(true);
        System.out.println("Livro '" + livro.getTitulo() + "' devolvido com sucesso!");
    }
}
