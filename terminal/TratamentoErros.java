package Interface;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import Entidades.Registro;
import Entidades.Curso;
import Entidades.Aluno;


public class TratamentoErros implements Visualizacao{
	public Opcao menu() {
		while(true) {
			try {
				System.out.println("Escolha uma das opcoes:");
				for(Opcao o: Opcao.values()) {
					System.out.println("" + o.codigo + " - " + o.descricao);
				}
				Scanner scan = new Scanner(System.in);
				try {
					String entrada = scan.nextLine();
					int opcaoCodigo = Integer.parseInt(entrada);
					if(!Menu.opc.keySet().contains(opcaoCodigo)) {
						throw new InputMismatchException("Nao existe essa opcao");
					}
					return Menu.opc.get(opcaoCodigo);
				}catch(NumberFormatException e) {
					throw new InputMismatchException("Caracter Invalido");
				}
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				
			}
			
		}	
	}
	@Override
	public void listarAlunos(Registro registro) {
		System.out.println("Todos os alunos:");
		for(Aluno a: registro.getAlunos()) {
			System.out.println(a);
		}
	}

	@Override
	public void listarCursos(Registro registro) {
		System.out.println("Todos os Cursos:");
		for(Curso c: registro.getCursos()) {
			System.out.println(c);
		}
	}
	

	@Override
	public void listarAlunosPorCurso(Registro registro, Curso curso) {
		System.out.println("Todos os alunos do curso " + curso + ":");
		for(Aluno a: registro.getAlunosPorCurso(curso)) {
			System.out.println(a);
		}
	}

	@Override
	public void listarCursosPorAluno(Registro registro, Aluno aluno) {
		System.out.println("Todos os cursos do aluno " + aluno + ":");
		for(Curso c: registro.getCursosPorAluno(aluno.getId())) {
			System.out.println(c);
		}
	}



	@Override
	public Curso addCurso() {
		return getNewCurso();
	}

	@Override
	public Aluno addAluno() {
		return getNewAluno();
	}

	@Override
	public Curso getCursoPorLista(Registro registro) {
		System.out.println("Escolha um curso");
		Curso curso = selecioneCurso(registro);
		if(!registro.getCursos().contains(curso)) {
			System.out.println("Nao existe esse curso");
			return null;
		}
		
		return curso;
	}

	@Override
	public Aluno getAlunoPorLista(Registro registro) {
		listarAluno(registro);
		System.out.println("Entre com o id do aluno");
		String id = getString();
		
		Aluno aluno = registro.getAlunosPorId(id);
		if(aluno==null) {
			System.out.println("Nao existe o id deste aluno");
		}
		
		return aluno;
	}

	
	
	public Aluno getNewAluno() {
		System.out.println("Entre com os dados do aluno");
		String id = getIdAluno();
		String nome = getNomeAluno();
		return new Aluno(id, nome);
	}
	
	public String getIdAluno() {
		System.out.println("Entre com o id do aluno");
		return getString();
	}
	
	public String getNomeAluno() {
		System.out.println("Entre com a nome do aluno");
		return getString();
	}
	
	
	
	public Curso getNewCurso() {
		System.out.println("Entre com os dados do curso");
		String nome = getNomeCurso();
		String nivel = getNivelCurso();
		int ano = getAnoCurso();
		return new Curso(nome, nivel, ano);
	}
	
	public String getNomeCurso() {
		System.out.println("Entre com o nome do curso");
		return getString();
	}
	
	public String getNivelCurso() {
		System.out.println("Entre com o nivel do cuso");
		return getString();
	}
	public int getAnoCurso() {
		System.out.println("Entre com o ano do cuso");
		return getInt();
	}
	private Curso selecioneCurso(Registro registro) {
		String nome = selecioneNomesCurso(registro);
		String nivel = selecioneNivelCurso(registro);
		int ano = selecioneAnoCurso(registro);
		return new Curso(nome, nivel, ano);
	}
	
	private String selecioneNivelCurso(Registro registro) {
		Set<String> niveis = new TreeSet<>();
		for(Curso c: registro.getCursos()) {
			niveis.add(c.getNivel());
		}
		System.out.println("Escolha um dos niveis");
		for(String nivel: niveis) {
			System.out.println(nivel);
		}
		System.out.println("Entre com o nivel escolhida:");
		return getString();
	}
	
	private String selecioneNomesCurso(Registro registro) {
		Set<String> nomes = new TreeSet<>();
		for(Curso c: registro.getCursos()) {
			nomes.add(c.getNome());
		}
		System.out.println("Escolha um dos nomes");
		for(String nome: nomes) {
			System.out.println(nome);
		}
		System.out.println("Entre com o nome escolhido:");
		return getString();
	}
	
	
	
	public String getString() {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		return str.trim();
	}
	public int getInt() {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		return num;
	}
}

