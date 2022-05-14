package aps;

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
import java.util.TreeSet;


public class Arquivos {
	
	public static Set<Aluno> loadAlunos(String filePath){

        
        Set<Aluno> alunos = new TreeSet<>();

        try (   InputStream is = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");
                
                String id = palavras[0];
                String nome = palavras[1];
                

                Aluno aluno = new Aluno(id, nome);
        		alunos.add(aluno);

            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return alunos;

    }

    public static void saveAlunos(Set<Aluno> alunos, String filePath){

        try(    OutputStream os = new FileOutputStream(filePath/*, true*/);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Aluno aluno: alunos){
                pw.println(aluno.getId()+","+aluno.getNome());
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static Set<Curso> loadCursos(String filePath){
    	
        
        Set<Curso> cursos = new TreeSet<>();

        try (   InputStream is = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String nome = palavras[0];
                String nivel = palavras[1];
                int ano = Integer.parseInt(palavras[2]);
                

                Curso curso = new Curso(nome, nivel, ano);
                cursos.add(curso);

            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return cursos;

    }

    public static void saveCursos(Set<Curso> cursos, String filePath){

        try(    OutputStream os = new FileOutputStream(filePath/*, true*/);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Curso curso: cursos){
                pw.println(curso.getNome()+","+curso.getNivel()+","+curso.getAno());
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
