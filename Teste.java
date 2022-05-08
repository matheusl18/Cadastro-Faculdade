package aps;

import java.util.Set;

public class Teste {
public static void main(String[] args) {
		
		Set<Aluno> alunos = Arquivos.loadAlunos("C:\\Facul\\Aps Java/Alunos.csv");
		for(Aluno aluno: alunos){
            System.out.println(aluno);
		}
		
		Aluno aluno1 = new Aluno("a1", "Gabriele" );
		alunos.add(aluno1);
		for(Aluno aluno: alunos){
            System.out.println(aluno);
        }
		Arquivos.saveAlunos(alunos, "C:\\Facul\\Aps Java/Alunos.csv");

	

	
	Set<Curso> cursos = Arquivos.loadCursos("C:\\Facul\\Aps Java/Curso.csv");
	for(Curso curso: cursos){
        System.out.println(curso);
	}
	
	Curso curso1 = new Curso("Ciencias da Computação", "Graduação", 2021 );
	cursos.add(curso1);
	for(Curso curso: cursos){
        System.out.println(curso);
    }
	Arquivos.saveCursos(cursos, "C:\\Facul\\Aps Java/Curso.csv");

}

}
