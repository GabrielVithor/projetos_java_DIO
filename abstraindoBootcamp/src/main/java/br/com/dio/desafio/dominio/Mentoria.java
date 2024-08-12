package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private LocalDate dataEvento;

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, LocalDate dataEvento) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.dataEvento = dataEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dataEvento=" + dataEvento +
                '}';
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }
}
