package Data;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import Entidades.Aluno;
import Entidades.Curso;
import Entidades.Registro;

public class Arquivos {
	private String alunoPath;
	private String cursoPath;
	private String relacaoPath;
	
	private Registro registroInput;
	
	public Arquivos(String aAlunoPath, String aCursoPath, String aRelacaoPath) {
		this.alunoPath = aAlunoPath;
		this.cursoPath = aCursoPath;
		this.relacaoPath = aRelacaoPath;
	}
	
	public Registro getRegistro() {
		this.registroInput = new Registro();
		
		loadAlunos();
		loadCursos();
		return loadRelacoes();
	}
	
	private Registro loadRelacoes(){
		
        try (   InputStream is = new FileInputStream(this.relacaoPath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String idAluno = palavras[0];
                String nomeCurso = palavras[1];
                String nivelCurso = palavras[2];
                int anoCurso = Integer.parseInt(palavras[3]);

                Curso curso = new Curso(nomeCurso, nivelCurso, anoCurso);
                Aluno aluno = this.registroInput.getAlunosPorId(idAluno);
                
                registroInput.addRelacaoAlunoCurso(aluno, curso);

            }

        }catch(IOException e){
            e.printStackTrace();
        }
        
        return this.registroInput; 

    }
	public void saveRegistro(Registro registroOutput) {
		saveAlunos(registroOutput.getAlunos());
		saveCursos(registroOutput.getCursos());
		saveRelacoes(registroOutput);
	}
	
	private void saveRelacoes(Registro registroOutput){
	
	    try(    OutputStream os = new FileOutputStream(this.relacaoPath);
	            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
	            PrintWriter pw = new PrintWriter(osw, true);
	            ){
	        for(Aluno aluno: registroOutput.getAlunos()){
	            for(Curso curso: registroOutput.getCursosPorAluno(aluno.getId())){
	                pw.println(aluno.getId()+","+curso.getNome()+","+curso.getNivel()+","+curso.getAno());
	            }
	        }
	
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	
	}
	
	private void loadAlunos(){

        try (   InputStream is = new FileInputStream(this.alunoPath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                System.out.println("linha " + i++);

                String[] palavras = linha.split(",");

                for(String p: palavras){
                    System.out.println("palavra: " + p);
                }

                String id = palavras[0];
                String nome = palavras[1];
                

                Aluno aluno = new Aluno(id, nome);
        		this.registroInput.addAluno(aluno);

            }

        }catch(IOException e){
            e.printStackTrace();
        }


    }

    private void saveAlunos(Set<Aluno> alunosOutput){

        try(    OutputStream os = new FileOutputStream(this.alunoPath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Aluno aluno: alunosOutput){
                pw.println(aluno.getId()+","+aluno.getNome());
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
    private void loadCursos(){

        try (   InputStream is = new FileInputStream(this.cursoPath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                System.out.println("linha " + i++);

                String[] palavras = linha.split(",");

                for(String p: palavras){
                    System.out.println("palavra: " + p);
                }

                String nome = palavras[0];
                String nivel = palavras[1];
                int ano = Integer.parseInt(palavras[2]);
                

                Curso curso = new Curso(nome, nivel, ano);
                this.registroInput.addCurso(curso);

            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    private void saveCursos(Set<Curso> cursosOutput){

        try(    OutputStream os = new FileOutputStream(this.cursoPath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Curso curso: cursosOutput){
                pw.println(curso.getNome()+","+curso.getNivel()+","+curso.getAno());
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
