package aps;

import java.util.Objects;

public class Aluno implements Comparable<Aluno>{


	private String id;
	private String nome;
	
	
	public Aluno(String aId, String aNome) {
		this.id = aId;
		this.nome = aNome;
	}
	public String getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Aluno oAluno = (Aluno)o;
		return Objects.equals(this.id, oAluno.id);
	}
	
	@Override
	public int compareTo(Aluno o) {
		return this.id.compareTo(o.id);
	}
	@Override
	public String toString() {
		String res = "";
		res += "Id: " + this.id +"\n";
		res += "Nome: " + this.nome;
		return res;
	}
}
