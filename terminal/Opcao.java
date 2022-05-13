package terminal;

public enum Opcao {
	
	LISTA_ALUNOS(1, "Listar todos os alunos"), 
	LISTA_CURSOS(2, "Listar todos os cursos"), 
	LISTA_ALUNOS_DE_CURSO(3, "Listar todos os alunos de um curso"), 
	LISTA_CURSOS_DE_ALUNO(4, "Listar todos os cursos de um aluno"),
	ADICIONA_ALUNO(5, "Cadastrar um novo aluno"),
	ADICIONA_CURSO(6, "Cadastrar um novo curso"),
	ADICIONA_RELACAO(7, "Adicionar uma relacao entre aluno e curso"),
	REMOVER_ALUNO(8, "Remover um aluno"),
	REMOVER_CURSO(9, "Remover um curso"),
	REMOVER_RELACAO(10, "Remover uma relacao entre aluno e curso"),
	SAIR(0, "Sair do programa e salvar os dados");
	
	public String descricao;
	public int codigo;
	
	private Opcao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
