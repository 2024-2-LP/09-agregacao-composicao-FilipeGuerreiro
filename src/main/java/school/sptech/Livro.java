package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro() {
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        Avaliacao novaAvaliacao = new Avaliacao();
        if(descricao != null && !descricao.isEmpty() && !descricao.isBlank() && qtdEstrelas != null){
            if (qtdEstrelas >= 0.0 && qtdEstrelas <= 5.0){
                novaAvaliacao.setDescricao(descricao);
                novaAvaliacao.setQtdEstrelas(qtdEstrelas);

                avaliacoes.add(novaAvaliacao);
            }
        }
    }

    public Double calcularMediaAvaliacoes(){
        return avaliacoes.stream().mapToDouble(Avaliacao::getQtdEstrelas).average().orElse(0.0);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Autor: " + this.autor;
    }
}
