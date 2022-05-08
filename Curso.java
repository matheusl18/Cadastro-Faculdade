package aps;

import java.util.Objects;

public class Curso implements Comparable<Curso>{

	private String nome;
	private String nivel;
	private int ano;
	
	public Curso(String aNome, String aNivel, int aAno) {
		this.nome = aNome;
		this.nivel = aNivel;
		this.ano = aAno;
	}
	public String getNome() {
		return this.nome;
	}
	public String getNivel() {
		return this.nivel;
	}
	public int getAno() {
		return this.ano;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Curso oCurso = (Curso)o;
		return Objects.equals(this.nome, oCurso.nome)&&
				Objects.equals(this.nivel, oCurso.nivel)&&
				Objects.equals(this.ano, oCurso.ano);
	}
	
	@Override
	public int compareTo(Curso o) {
		if(!this.nome.equals(o.nome)) {
			return this.nome.compareTo(o.nome);
		}
		if(!this.nivel.equals(o.nivel)) {
			return this.nivel.compareTo(o.nivel);
		}
			return Integer.compare(this.ano, o.ano);
		}
	
	@Override
	public String toString() {
		String res = "";
		res += "Nome: " + this.nome +"\n";
		res += "Nivel: " + this.nivel +"\n";
		res += "Ano: " + this.ano;
		return res;
	}
}