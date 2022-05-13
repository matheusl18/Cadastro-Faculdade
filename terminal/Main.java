package terminal;
import aps.Arquivos;

public class Main {
	public static void main(String[] args) {
		TratamentoErros terminal = new TratamentoErros();
		
		new Menu(terminal).init();
	}

}
