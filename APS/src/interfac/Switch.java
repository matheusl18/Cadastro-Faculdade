package interfac;

import java.util.Set;


import data.Arquivos;
import entidades.Aluno;
import entidades.Curso;

public class Switch {
	private Acoes acoes;
	private Arquivos arquivos;
	private Aluno aluno;
	private Curso curso;
	
	public Switch(Acoes acoes, Arquivos arquivos){
		this.acoes = acoes;
		this.arquivos = arquivos;
	}

	public void init() {
		/*Set<Aluno> alunos = Arquivos.loadAlunos("C:\\Facul\\Aps Java/Alunos.csv");
		Opcao codigo = null;
		while(codigo!=Opcao.SAIR) {
			codigo = acoes.menu();
			switch (codigo) {
			case LISTA_ALUNOS: {listarAlunos(); break;}
			case LISTA_CURSOS: {listarCursos(); break;}
			case LISTA_ALUNOS_DE_CURSO: { break;}
			case LISTA_CURSOS_DE_ALUNO: { break;}
			case ADICIONA_ALUNO: { break;}
			case ADICIONA_CURSO: { break;}
			case REMOVER_ALUNO: break;
			case REMOVER_CURSO: break;
			case REMOVER_RELACAO: break;
			case ADICIONA_RELACAO: { break;}
			case SAIR: { break;}
			default:
				throw new IllegalArgumentException("Unexpected value: " + codigo);
			}
		}
	}
	
	private void listarAlunos() {
		acoes.listarAlunos(aluno);
	}
	
	private void listarCursos() {
		acoes.listarCursos(curso);
	}
	
	/*private void adicionarAluno() {
		Aluno aluno = acoes.addAluno();
		this.aluno.addAluno(aluno);
	}
	
	private void adicionarCurso() {
		Curso curso = acoes.addCurso();
		this.curso.addCurso(curso);
	}
	*/
	
	
	
	}
}

