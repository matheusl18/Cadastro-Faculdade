package terminal;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import aps.Arquivos;
import aps.Aluno;
import aps.Curso;



public class Menu {
	private TratamentoErros terminal;
	
	
	public static Map<Integer, Opcao> opc = new TreeMap<>();
	{
		for(Opcao o: Opcao.values()) {
			opc.put(o.codigo, o);
		}
	}
	public Menu(TratamentoErros terminal) {
		this.terminal = terminal;
		
	}
	public void init(){
		int x;
		Scanner scan = new Scanner(System.in);
		Set<Aluno> alunos = Arquivos.loadAlunos("C:\\Facul\\Aps Java/Alunos.csv");
		Set<Curso> cursos = Arquivos.loadCursos("C:\\Facul\\Aps Java/Curso.csv");
		Opcao codigo = null;
		while(codigo != Opcao.SAIR) {
			codigo = terminal.menu();
			x = 1;
			switch(codigo) {
			case LISTA_ALUNOS:
				while(x == 1) {
					System.out.println("Lista de Alunos");
					
					for(Aluno aluno: alunos){
			            System.out.println(aluno);
					}
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
	
				break;
			case LISTA_CURSOS:
				while(x == 1) {
					System.out.println("Lista de Cursos");
					for(Curso curso: cursos){
				        System.out.println(curso);
					}
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
	
				break;
			case LISTA_ALUNOS_DE_CURSO:
				break;
			case LISTA_CURSOS_DE_ALUNO:
				break;
			case ADICIONA_ALUNO:
				while(x == 1) {
					Scanner input = new Scanner(System.in);
					System.out.println("Digite a Id do aluno: ");
					String id = input.nextLine();
					System.out.println("Digite o nome do aluno: ");
					String nome = input.nextLine();
					Aluno aluno1 = new Aluno(id, nome );
					alunos.add(aluno1);
					Arquivos.saveAlunos(alunos, "C:\\Facul\\Aps Java/Alunos.csv");
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case ADICIONA_CURSO:
				while(x == 1) {
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
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case ADICIONA_RELACAO:
				break;
			case REMOVER_ALUNO:
				while(x == 1) {
					Scanner input3 = new Scanner(System.in);
					System.out.println("Digite a Id do aluno: ");
					String id2 = input3.nextLine();
					System.out.println("Digite o nome do aluno: ");
					String nome3 = input3.nextLine();
					Aluno aluno2 = new Aluno(id2, nome3 );
					alunos.remove(aluno2);
					Arquivos.saveAlunos(alunos, "C:\\Facul\\Aps Java/Alunos.csv");
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case REMOVER_CURSO:
				while(x == 1) {
					Scanner input4 = new Scanner(System.in);
					System.out.println("Digite o nome do curso: ");
					String nome4 = input4.nextLine();
					System.out.println("Digite o nivel do curso: ");
					String nivel2 = input4.nextLine();
					System.out.println("Digite o ano do curso: ");
					int ano2 = input4.nextInt();
					Curso curso2 = new Curso(nome4, nivel2, ano2 );
					cursos.remove(curso2);
					Arquivos.saveCursos(cursos, "C:\\Facul\\Aps Java/Curso.csv");
					System.out.println("\n\n1 Continuar\n2 voltar");
					x = scan.nextInt();
				}
				break;
			case REMOVER_RELACAO:
				break;
			case SAIR:
				break;
			default:
				throw new IllegalArgumentException("Valor Desconhecido: " + opc);
				
			
			}
			
		}

	}
}
