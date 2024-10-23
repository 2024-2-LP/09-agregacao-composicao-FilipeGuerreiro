package school.sptech;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        if(livro != null && livro.getTitulo() != null && !livro.getTitulo().isEmpty() && !livro.getTitulo().isBlank()
        && livro.getAutor() != null && !livro.getAutor().isEmpty() && !livro.getAutor().isBlank()
        && livro.getDataPublicacao() != null){
        this.livros.add(livro);
        }
    }

    public void removerLivroPorTitulo(String titulo){
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
    }

    public Livro buscarLivroPorTitulo(String titulo){
        if(titulo != null){
           return livros.stream().filter(l -> l.getTitulo()
                            .equalsIgnoreCase(titulo)).findAny()
                            .orElse(null);
        }
        return null;
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        LocalDate data = LocalDate.of(ano, 12, 31);
        List<Livro> novaLista = new ArrayList<>();
        livros.forEach(l -> {
            if(l.getDataPublicacao().isBefore(data) || l.getDataPublicacao().isEqual(data)){
                novaLista.add(l);
            }
        });
        return novaLista;
    }

    public List<Livro> retornarTopCincoLivros(){
        return livros.stream().sorted(Comparator.comparing(Livro::calcularMediaAvaliacoes).reversed())
                .limit(5).toList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
