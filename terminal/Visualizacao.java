package Interface;

import Entidades.Aluno;
import Entidades.Curso;
import Entidades.Registro;

public interface Visualizacao {
Opcao menu();
	
	void listarAlunos(Registro registro);
	void listarCursos(Registro registro);
	
	void listarAlunosPorCurso(Registro registro, Curso curso);
	void listarCursosPorAluno(Registro registro, Aluno aluno);
	
	Curso addCurso();
	Aluno addAluno();
	
	Curso delCurso();
	Aluno delAluno();

	Curso getCursoPorLista(Registro registro);
	Aluno getAlunoPorLista(Registro registro);
	
}

