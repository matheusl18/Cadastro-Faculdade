package Interface;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import Data.Arquivos;
import Entidades.Aluno;
import Entidades.Curso;
import Entidades.Registro;



public class Menu {
	private Visualizacao terminal;
	private Arquivos data;
	private Registro registro;
	
	
	public static Map<Integer, Opcao> opc = new TreeMap<>();
	{
		for(Opcao o: Opcao.values()) {
			opc.put(o.codigo, o);
		}
	}
	public Menu(Visualizacao terminal, Arquivos data) {
		this.terminal = terminal;
		this.data = data;
		
	}
	public void init(){
		registro = data.getRegistro();
		int x;
		Scanner scan = new Scanner(System.in);
		Opcao codigo = null;
		while(codigo != Opcao.SAIR) {
			codigo = terminal.menu();
			x = 1;
			switch(codigo) {
			case LISTA_ALUNOS:
				while(x == 1) {
					listarAlunos();
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
	
				break;
			case LISTA_CURSOS:
				while(x == 1) {
					listarCursos();
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
	
				break;
			case LISTA_ALUNOS_DE_CURSO:
				listaAlunosPorCurso();
				break;
			case LISTA_CURSOS_DE_ALUNO:
				listaCursosPorAluno();
				break;
			case ADICIONA_ALUNO:
				while(x == 1) {
					adicionarAluno();
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case ADICIONA_CURSO:
				while(x == 1) {
					adicionarCurso();
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case ADICIONA_RELACAO:
				adicionarRelacao();
				break;
			case REMOVER_ALUNO:
				while(x == 1) {
					removerAluno();
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case REMOVER_CURSO:
				while(x == 1) {
					removerCurso();
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case REMOVER_RELACAO:
				removerRelacao();
				break;
			case SAIR:
				terminar();
				break;
			default:
				throw new IllegalArgumentException("Valor Desconhecido: " + opc);
				
			
			}
			
		}

	}
	private void listarAlunos() {
		terminal.listarAlunos(registro);
	}
	
	private void listarCursos() {
		terminal.listarCursos(registro);
	}
	
	private void adicionarAluno() {
		Aluno aluno = terminal.addAluno();
		this.registro.addAluno(aluno);
	}
	private void removerAluno() {
		Aluno aluno = terminal.delAluno();
		this.registro.delAluno(aluno);
	}
	
	private void adicionarCurso() {
		Curso curso = terminal.addCurso();
		this.registro.addCurso(curso);
	}
	private void removerCurso() {
		Curso curso = terminal.delCurso();
		this.registro.delCurso(curso);
	}
	
	private void listaAlunosPorCurso() {
		Curso curso = terminal.getCursoPorLista(registro);
		if(curso==null) return;
		terminal.listarAlunosPorCurso(registro, curso);
	}
	
	
	private void listaCursosPorAluno() {
		Aluno aluno = terminal.getAlunoPorLista(registro);
		if(aluno==null) return;
		terminal.listarCursosPorAluno(registro, aluno);
	}
	
	private void adicionarRelacao() {
		Aluno aluno = terminal.getAlunoPorLista(registro);
		if(aluno==null) return;
		Curso curso = terminal.getCursoPorLista(registro);
		if(curso==null) return;
		registro.addRelacaoAlunoCurso(aluno, curso);
	}
	private void removerRelacao() {
		Aluno aluno = terminal.getAlunoPorLista(registro);
		if(aluno==null) return;
		Curso curso = terminal.getCursoPorLista(registro);
		if(curso==null) return;
		registro.delRelacaoAlunoCurso(aluno, curso);
		
	}
	
	private void terminar() {
	data.saveRegistro(registro);
	}
}
