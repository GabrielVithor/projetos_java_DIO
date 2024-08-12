package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Curso curso = new Curso();

        curso.setTitulo("Curso java");
        curso.setDescricao("Descricao curso java");
        curso.setCargaHoraria(8);

        Curso curso1 = new Curso();

        curso1.setTitulo("Curso javascript");
        curso1.setDescricao("Descricao curso javascript");
        curso1.setCargaHoraria(10);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria java");
        mentoria.setDescricao("Descricao mentoria java");
        mentoria.setDataEvento(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria);

        Dev gabriel  = new Dev();
        gabriel.setNome("Gabriel Mota");
        gabriel.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos incritos Gabriel:  "+ gabriel.getConteudosInscritos());
        gabriel.progredir();
        System.out.println("-");
        System.out.println("Conteudos incritos Gabriel:  "+ gabriel.getConteudosInscritos());
        System.out.println("Conteudos incritos Gabriel:  "+ gabriel.getConteudosConcluidos());
        System.out.println("XP: " + gabriel.calcularTotalXP());

        System.out.println("========================================");
        Dev joao = new Dev();
        joao.setNome("Joao Vithor");
        joao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos incritos João:"+ joao.getConteudosInscritos());
        joao.progredir();
        joao.progredir();
        joao.progredir();
        System.out.println("-");
        System.out.println("Conteudos incritos João:"+ joao.getConteudosInscritos());
        System.out.println("Conteudos incritos João:"+ joao.getConteudosConcluidos());
        System.out.println("XP: " + joao.calcularTotalXP());

    }
}
