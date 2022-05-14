package aps;

import java.util.Scanner;
import java.util.Set;


public class Interface {
	public void exibeMenu(){
		
	
		int opc;
		
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("Escolha uma das opções abaixo:"
					+ "\n1 Listar Alunos"
					+ "\n2 Listar Cursos"
					+ "\n3 Adicionar Alunos"
					+ "\n4 Adicionar Cursos"
					+ "\n0 Sair");
			opc = scan.nextInt();
			
			Set<Aluno> alunos = Arquivos.loadAlunos("C:\\Facul\\Aps Java/Alunos.csv");
			Set<Curso> cursos = Arquivos.loadCursos("C:\\Facul\\Aps Java/Curso.csv");
			
			switch(opc) {
			case 1:
				System.out.println("Lista de Alunos");
				
				for(Aluno aluno: alunos){
		            System.out.println(aluno);
				}
	
				break;
			case 2:
				System.out.println("Lista de Cursos");
				for(Curso curso: cursos){
			        System.out.println(curso);
				}
	
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
	
				break;
			case 0:
				break;
			default:
				throw new IllegalArgumentException("Valor Desconhecido: " + opc);
				
			
			}
			
		}while(opc != 0);

	}
}
