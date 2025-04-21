/*
    Nome / RM:
    Fernando Navajas Moraes RM555080;
    José Guilherme Sipaúba Costa RM557274;
    Lucas Feliciano RM557261;
*/
package br.com.fiap.bean; // Pacote de entidades ("bean" = objeto de negócio)

import java.time.LocalDate; // Para trabalhar com datas
import java.time.Period; // Para calcular diferença entre datas

public class Aluno {
    // Atributos privados (encapsulados)
    private String nomeCompleto;
    private int registroMatricula;
    private LocalDate dataDeNascimento;

    // Construtor vazio: permite criar um objeto sem passar dados inicialmente
    public Aluno() {
    }

    // Construtor com parâmetros: já cria o objeto com os dados
    public Aluno(String nome, int registroMatricula, LocalDate dataDeNascimento) {
        setNomeCompleto(nome);
        setRegistroMatricula(registroMatricula);
        setDataDeNascimento(dataDeNascimento);
    }

    // Getter do nome
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    // Setter do nome
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    // Getter do RM
    public int getRegistroMatricula() {
        return registroMatricula;
    }

    // Setter com try-catch e validação de regra de negócio
    public void setRegistroMatricula(int registroMatricula) {
        if (registroMatricula >= 80000 && registroMatricula <= 599999) {
            this.registroMatricula = registroMatricula;
        } else {
            throw new IllegalArgumentException("RM inválido. Deve estar entre 80000 e 599999.");
        }
    }

    // Getter da data de nascimento
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    // Setter com try-catch e validação de regra de negócio
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        LocalDate dataMinima = LocalDate.of(1960, 1, 1);
        LocalDate dataAtual = LocalDate.now();

        if (dataDeNascimento.isBefore(dataMinima) || dataDeNascimento.isAfter(dataAtual)) {
            throw new IllegalArgumentException("Data de Nascimento deve ser entre 01/01/1960 e a data atual.");
        } else {
            this.dataDeNascimento = dataDeNascimento;
        }
    }

    // Metodo para calcular idade completa em anos, meses e dias
    public String calcularIdadeCompleta() {
        Period idade = Period.between(dataDeNascimento, LocalDate.now());
        return String.format("%d anos, %d meses e %d dias", idade.getYears(), idade.getMonths(), idade.getDays());
    }
}
