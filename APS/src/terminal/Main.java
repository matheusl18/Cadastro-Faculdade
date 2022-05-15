package terminal;
import data.Arquivos;

public class Main {
	public static void main(String[] args) {
		Visualizacao terminal = new TratamentoErros();
		String alunoPath = "files/Alunos.csv";
		String cursoPath = "files/Curso.csv";
		String relacaoPath = "files/Relacao.csv";
		Arquivos data = new Arquivos(alunoPath, cursoPath, relacaoPath);
		new Menu(terminal, data).init();
	}

}
