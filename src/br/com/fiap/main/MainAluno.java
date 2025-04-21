/*
    Nome / RM:
    Fernando Navajas Moraes RM555080;
    José Guilherme Sipaúba Costa RM557274;
    Lucas Feliciano RM557261;
*/
package br.com.fiap.main; // Pacote principal da aplicação

// Importações necessárias
import br.com.fiap.bean.Aluno; // Importa a classe Aluno da pasta bean
import javax.swing.*; // Importa JOptionPane para entrada/saída de dados
import java.time.LocalDate; // Para manipular datas
import java.time.format.DateTimeFormatter; // Para formatar a data recebida

public class MainAluno {
    public static void main(String[] args) {
        // Define o formato da data que será digitada pelo usuário (dia/mês/ano)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Instancia três alunos com o construtor com parâmetros (dados fixos do grupo)
        Aluno aluno1 = new Aluno("Fernando Navajas", 555080, LocalDate.of(2004, 12, 31));
        Aluno aluno2 = new Aluno("José Guilherme", 557274, LocalDate.of(2006, 6, 17));
        Aluno aluno3 = new Aluno("Lucas Feliciano", 557261, LocalDate.of(2003, 5, 7));

        // Instancia dois alunos com o construtor vazio (serão preenchidos via JOptionPane)
        Aluno aluno4 = new Aluno();
        Aluno aluno5 = new Aluno();

        try {
            // Coleta de dados do aluno 4
            String nome4 = JOptionPane.showInputDialog("Digite o nome do Aluno 4:");
            int rm4 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do Aluno 4 (entre 80000 e 599999):"));
            String data4 = JOptionPane.showInputDialog("Digite a data de nascimento (dd/MM/yyyy):");
            LocalDate nascimento4 = LocalDate.parse(data4, formatter); // Converte String em LocalDate

            aluno4.setNomeCompleto(nome4); // Define nome
            aluno4.setRegistroMatricula(rm4); // Valida e define RM
            aluno4.setDataDeNascimento(nascimento4); // Valida e define a data

            // Coleta de dados do aluno 5
            String nome5 = JOptionPane.showInputDialog("Digite o nome do Aluno 5:");
            int rm5 = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM do Aluno 5 (entre 80000 e 599999):"));
            String data5 = JOptionPane.showInputDialog("Digite a data de nascimento (dd/MM/yyyy):");
            LocalDate nascimento5 = LocalDate.parse(data5, formatter);

            aluno5.setNomeCompleto(nome5);
            aluno5.setRegistroMatricula(rm5);
            aluno5.setDataDeNascimento(nascimento5);

            // Obtém a data atual do sistema (não usada diretamente aqui, mas pode ser útil)
            LocalDate dataAtual = LocalDate.now();

            // StringBuilder para montar a mensagem com os dados dos alunos
            StringBuilder mensagem = new StringBuilder();
            Aluno[] alunos = {aluno1, aluno2, aluno3, aluno4, aluno5};

            // Percorre o vetor de alunos e monta a mensagem formatada
            for (Aluno aluno : alunos) {
                mensagem.append(String.format("RM: %d\nNome: %s\nIdade: %s\n\n",
                        aluno.getRegistroMatricula(),
                        aluno.getNomeCompleto(),
                        aluno.calcularIdadeCompleta()));
            }

            // Exibe a mensagem no JOptionPane
            JOptionPane.showMessageDialog(null, mensagem.toString());

        } catch (Exception e) {
            // Captura qualquer erro e mostra a mensagem
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
