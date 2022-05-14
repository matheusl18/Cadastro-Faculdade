package aps;

import java.util.Scanner;
import java.util.Set;

public class Op��o {
	public static void main(String[] args) {
		int x = 1;
		int op = 9;
		while(op != 0) { 
			
			if(x == 1) {
			
				System.out.println("Escolha uma das op��es abaixo:"
						+ "\n1 Listar Alunos"
						+ "\n2 Listar Cursos"
						+ "\n3 Adicionar Alunos"
						+ "\n4 Adicionar Cursos"
						+ "\n0 Sair");
			}
			x = 2;
			Scanner scan = new Scanner(System.in);
			op = scan.nextInt();
			Set<Aluno> alunos = Arquivos.loadAlunos("C:\\Facul\\Aps Java/Alunos.csv");
			Set<Curso> cursos = Arquivos.loadCursos("C:\\Facul\\Aps Java/Curso.csv");
			switch(op) {
			case 1:
				System.out.println("Lista de Alunos");
				
				for(Aluno aluno: alunos){
		            System.out.println(aluno);
				}
				System.out.println("\n\n1 Voltar");
				x = scan.nextInt();
				break;
			case 2:
				System.out.println("Lista de Cursos");
				for(Curso curso: cursos){
			        System.out.println(curso);
				}
				System.out.println("\n\n1 Voltar");
				x = scan.nextInt();
				break;
			case 3:
				Scanner input = new Scanner(System.in);
				System.out.println("Digite a Id do aluno: ");
				String id = input.nextLine();
				System.out.println("Digite o nome do aluno: ");
				String nome = input.nextLine();
				Aluno aluno1 = new Aluno(id, nome );
				alunos.add(aluno1);
				Arquivos.saveAlunos(alunos, "C:\\Facul\\Aps Java/Alunos.csv");
				System.out.println("\n\n1 Voltar");
				x = scan.nextInt();
				break;
			case 4:
				Scanner input2 = new Scanner(System.in);
				System.out.println("Digite o nome do curso: ");
				String nome2 = input2.nextLine();
				System.out.println("Digite o nivel do curso: ");
				String nivel = input2.nextLine();
				System.out.println("Digite o ano do curso: ");
				int ano = input2.nextInt();
				Curso curso1 = new Curso(nome2, nivel, ano );
				cursos.add(curso1);
				Arquivos.saveCursos(cursos, "C:\\Facul\\Aps Java/Curso.csv");
				System.out.println("\n\n1 Voltar");
				x = scan.nextInt();
				break;
			case 0:
			default:
				throw new IllegalArgumentException("Valor Desconhecido: " + op);
				
			
			}
		}
	}
	
}
