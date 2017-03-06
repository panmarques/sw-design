package br.edu.impacta.ads;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List; 
import static java.lang.System.out;



public class AgendaApp {
	private static Scanner entrada = new Scanner(System.in);
	private static list <contato> contatos = new ArrayList<>();
	public static void main(String[] args){
		boolean sair = false; 
		while(!sair) {
			int opcao = apresentarMenuPrincipal();
			switch(opcao){
			case 1: inserirContato(); break; 
			case 2: nuscarContato(); break;
			case 3: sair = true; break;
			default: out.println("ERRO: opção inválida!");
			
			}
			
		}
		out.println("\nfim do programa!");
		
	}
	
	private static int apresentarMenuPrincipal(){
		boolean inteiro = false; 
		int opcao = 0; 
		while(!inteiro){
			out.println("\nAGENDA TELEFONICA!");
			out.println("(1) Inserir");
			out.println("(2)Buscar ");
			out.println("(3) Sair");
			out.print("Escolha uma opção:");
			String s = entrada.nextline();
			try{
				opcao = Integer.parseInt(s);
				inteiro = true; 
				} catch(Exception e){
					out.println("ERRO: opção deve ser um valor inteiro!");
					
				}
		}
		return opcao;
	}
	
	private static void inserirContato(){
		out.println("\nINSERÇÃO DE NOVO CONTATO:");
		String nome = lerNome();
		String telefone = lerTelefone();
		Contato c = new Contato(nome, telefone);
		if(contato.contains(c)){
			out.println("Este Contato já está cadastrado!");
			
		}
		else{
			contatos.add(c);
			out.println("Contato inserido!");
			
			
		}
	}
	
	private static String lerNome(){
		boolean valido = false; 
		String nome = "";
		while(!valido){
			out.print("Nome:  ");
			nome = entrada.nextLine();
			if(nome.length()==0) || nome.length()>200){
				out.println("ERRO: nome de tamanho invalido!");
				
			}else{ valido = true;}
		}
		return nome;
	}
	private static String lerTelefone(){
		boolean valido = false; 
		String telefone = "";
		while(!valido){
			out.print("telefone:");
			telefone = entrada.nextLine();
			if(telefone.length()==0 || telefone.length()>25){
				out.println("ERRO: telefone de tamanho invalido!");
				
			}else {valido = true;}
		
		}
		return telefone;
	}
	private static void buscarContato(){
		out.println("\nBUSCA DE CONTATOS:");
		String nome = lerNome();
		List<Contato> resultado = new ArrayList<>();
		for(contato c: contatos ){
			if(nome.equals(c.getNome())){
				resultado.add(c);
				}
					
			if(resultado.size()== 0){
				out.println("Nao há contato com este nome!");
				
			}else{
				out.println("\nResultado da busca:");
				for(Contato c:resultado ){
					out.println(c);
					
				}
			}
		}
		
	}
}


