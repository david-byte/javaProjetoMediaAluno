package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasse {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a senha");

		if (login.equalsIgnoreCase("adim") && senha.equalsIgnoreCase("admin")) {

			List<Aluno> alunos = new ArrayList<Aluno>();

			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			for (int qtd = 1; qtd <= 5; qtd++) {

				String nome = JOptionPane.showInputDialog("Qual nome do aluno " + qtd + "?");
				String idade = JOptionPane.showInputDialog("Qual a idade?");
				String dataNasc = JOptionPane.showInputDialog("Qual a data de nascimento?");
				String rg = JOptionPane.showInputDialog("Qual RG?");
				String cpf = JOptionPane.showInputDialog("Qual CPF?");
				String mae = JOptionPane.showInputDialog("Qual nome da mãe?");
				String pai = JOptionPane.showInputDialog("Qual nome do pai?");
				String dataMatricula = JOptionPane.showInputDialog("Data da matricula?");

				Aluno aluno1 = new Aluno();

				aluno1.setNome(nome);
				aluno1.setIdade(Integer.valueOf(idade));
				aluno1.setDataNascimento(dataNasc);
				aluno1.setRegistoGeral(rg);
				aluno1.setNumeroCpf(cpf);
				aluno1.setNomeMae(mae);
				aluno1.setNomePai(pai);
				aluno1.setDataMatricula(dataMatricula);

				for (int pos = 1; pos <= 4; pos++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina" + pos + "?");
					String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina" + pos + "?");

					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno1.getDisciplinas().add(disciplina);
				}

				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

				if (escolha == 0) {

					int continuarRemover = 0;
					int posicao = 1;

					while (continuarRemover == 0) {
						String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina? 1,2,3 ou 4 ?");
						aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
						posicao++;

						continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a removar?");
					}

				}

				alunos.add(aluno1);
			}

			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {
				if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO);
				} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO);

				} else {
					maps.get(StatusAluno.REPROVADO);
				}
			}

			System.out.println(" - Lista dos Aprovados - ");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Resultado = " + aluno.getAlunoAprovado());
				System.out.println("Média = " + aluno.getMediaNota());
			}

			System.out.println(" - Lista dos Reprovados - ");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Resultado = " + aluno.getAlunoAprovado());
				System.out.println("Média = " + aluno.getMediaNota());
			}

			System.out.println(" - Lista dos Recuperação - ");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Resultado = " + aluno.getAlunoAprovado());
				System.out.println("Média = " + aluno.getMediaNota());
			}

		}else {
			JOptionPane.showInternalMessageDialog(null, "Você errou o login ou senha");
		}
	}

}
