package terminal;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TratamentoErros {
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
						throw new InputMismatchException("Não existe essa opção");
					}
					return Menu.opc.get(opcaoCodigo);
				}catch(NumberFormatException e) {
					throw new InputMismatchException("Caracter Inválido");
				}
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				
			}
			
		}	
	}


}
