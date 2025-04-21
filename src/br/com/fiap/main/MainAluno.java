// RM: ________ - Nome: __________________________
// RM: ________ - Nome: __________________________
// RM: ________ - Nome: __________________________

package br.com.fiap.main;

import br.com.fiap.bean.Aluno;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Fernando Navajas", 123456, LocalDate.of(2003, 4, 15));
        Aluno aluno2 = new Aluno("Henrique Botti", 234567, LocalDate.of(2002, 12, 20));

        Aluno aluno3 = new Aluno();
        Aluno aluno4 = new Aluno();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Coleta do usuário - Aluno 3
            String nome3 = JOptionPane.showInputDialog("Digite o nome do Aluno 3:");
            int rm3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do Aluno 3:"));
            String dataNasc3 = JOptionPane.showInputDialog("Digite a data de nascimento (dd/mm/aaaa):");
            LocalDate nascimento3 = LocalDate.parse(dataNasc3, formatter);

            aluno3.setNome(nome3);
            aluno3.setRegistroMatricula(rm3);
            aluno3.setDataDeNascimento(nascimento3);

            // Coleta do usuário - Aluno 4
            String nome4 = JOptionPane.showInputDialog("Digite o nome do Aluno 4:");
            int rm4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do Aluno 4:"));
            String dataNasc4 = JOptionPane.showInputDialog("Digite a data de nascimento (dd/mm/aaaa):");
            LocalDate nascimento4 = LocalDate.parse(dataNasc4, formatter);

            aluno4.setNome(nome4);
            aluno4.setRegistroMatricula(rm4);
            aluno4.setDataDeNascimento(nascimento4);

            // Data atual
            LocalDate dataAtual = LocalDate.now();

            // Exibir dados
            StringBuilder sb = new StringBuilder();
            Aluno[] alunos = {aluno1, aluno2, aluno3, aluno4};
            for (Aluno a : alunos) {
                sb.append(String.format("RM: %d\nNome: %s\nIdade: %s\n\n",
                        a.getRegistroMatricula(), a.getNome(), a.calcularIdadeCompleta()));
            }

            JOptionPane.showMessageDialog(null, sb.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}

