/*
    Nome / RM:
    Fernando Navajas Moraes RM555080;
    José Guilherme Sipaúba Costa RM557274;
    Lucas Feliciano RM557261;
    João Pedro de Soula Lopes RM557993;
*/
package br.com.fiap.main;

import br.com.fiap.bean.Aluno;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainAluno {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Aluno aluno1 = new Aluno("Fernando Navajas", 555080, LocalDate.of(2004, 12, 31));
        Aluno aluno2 = new Aluno("José Guilherme", 557274, LocalDate.of(2006, 6, 17));
        Aluno aluno3 = new Aluno();
        Aluno aluno4 = new Aluno();

        try {
            // Coleta de dados - aluno 3
            String nome3 = JOptionPane.showInputDialog("Digite o nome do Aluno 3:");
            int rm3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do Aluno 3 (entre 80000 e 599999):"));
            String data3 = JOptionPane.showInputDialog("Digite a data de nascimento (dd/MM/yyyy):");
            LocalDate nascimento3 = LocalDate.parse(data3, formatter);

            aluno3.setNomeCompleto(nome3);
            aluno3.setRegistroMatricula(rm3);
            aluno3.setDataDeNascimento(nascimento3);

            // Coleta de dados - aluno 4
            String nome4 = JOptionPane.showInputDialog("Digite o nome do Aluno 4:");
            int rm4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do Aluno 4 (entre 80000 e 599999):"));
            String data4 = JOptionPane.showInputDialog("Digite a data de nascimento (dd/MM/yyyy):");
            LocalDate nascimento4 = LocalDate.parse(data4, formatter);

            aluno4.setNomeCompleto(nome4);
            aluno4.setRegistroMatricula(rm4);
            aluno4.setDataDeNascimento(nascimento4);

            // Construção da mensagem com todos os alunos
            String mensagemFinal =
                    "ALUNO 1\n" +
                            "RM: " + aluno1.getRegistroMatricula() + "\n" +
                            "Nome: " + aluno1.getNomeCompleto() + "\n" +
                            "Idade: " + aluno1.calcularIdadeCompleta() + "\n\n" +

                            "ALUNO 2\n" +
                            "RM: " + aluno2.getRegistroMatricula() + "\n" +
                            "Nome: " + aluno2.getNomeCompleto() + "\n" +
                            "Idade: " + aluno2.calcularIdadeCompleta() + "\n\n" +

                            "ALUNO 3\n" +
                            "RM: " + aluno3.getRegistroMatricula() + "\n" +
                            "Nome: " + aluno3.getNomeCompleto() + "\n" +
                            "Idade: " + aluno3.calcularIdadeCompleta() + "\n\n" +

                            "ALUNO 4\n" +
                            "RM: " + aluno4.getRegistroMatricula() + "\n" +
                            "Nome: " + aluno4.getNomeCompleto() + "\n" +
                            "Idade: " + aluno4.calcularIdadeCompleta();

            // Exibir tudo de uma vez
            JOptionPane.showMessageDialog(null, mensagemFinal);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
