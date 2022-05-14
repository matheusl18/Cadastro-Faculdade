package aps;
import java.util.InputMismatchException;

public class TratamentoErros {
	public static void main(String[] args) {
		Interface menu = new Interface();
		while(true) {
			try {
				menu.exibeMenu();
				
			}catch(InputMismatchException e) {
				System.out.println("Caracter Inválido");
				
			}
			
		}	
	}


}
