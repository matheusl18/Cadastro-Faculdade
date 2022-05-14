package interfac;

import entidades.Aluno;
import entidades.Curso;

public interface Acoes {
		
		Opcao menu();
		
		void listarAlunos(Aluno aluno);
		void listarCursos(Curso curso);
		
		Curso addCurso();
		Aluno addAluno();		
		

	}

