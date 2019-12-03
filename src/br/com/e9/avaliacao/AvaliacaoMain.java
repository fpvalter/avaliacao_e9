/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.e9.avaliacao;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import br.com.e9.avaliacao.model.FuncionarioModel;
import br.com.e9.avaliacao.util.Funcionario;
import br.com.e9.avaliacao.validator.ValidarFuncionario;

/**
 *
 * @author Thiago
 */
public class AvaliacaoMain {
    	
	static Scanner scn = new Scanner(System.in);
	static Funcionario funcUtil = new Funcionario();
	
    public static void main(String args[]){
    	
    	System.out.println("\n\nFuncionarios Válidos");
    	ArrayList<FuncionarioModel> listaFuncValidos = getFuncionarios(10, true);
    	
    	System.out.println("\n\nFuncionarios Inválidos");
    	ArrayList<FuncionarioModel> listaFuncInvalidos = getFuncionarios(10, false);
    	

    	System.out.println("TAREFA 1\n\n");
    	executarTarefa1(listaFuncValidos, listaFuncInvalidos);
    	    	
    	System.out.println("\n\n\nTAREFA 2\n\n");
    	executarTarefa2(listaFuncValidos, listaFuncInvalidos);
       
    }
    
    /**
     * Executa tarefa 1
     */
    private static void executarTarefa1(ArrayList<FuncionarioModel> listaFuncValidos, ArrayList<FuncionarioModel> listaFuncInvalidos) {
    	    			
    	funcUtil.imprimirOrdenadoNomeTerminal(listaFuncValidos);
    	funcUtil.imprimirOrdenadoNascimentoTerminal(listaFuncValidos);
    	funcUtil.imprimirOrdenadoNomeTerminal(listaFuncInvalidos);		
	}
		
    /**
     * Executa a tarefa 2
     */
	private static void executarTarefa2(ArrayList<FuncionarioModel> listaFuncValidos, ArrayList<FuncionarioModel> listaFuncInvalidos) {
		
		System.out.println("\nCOPA DO MUNDO");
		//Leitura de 1 funcionario para verificar ano de nascimento na copa do mundo
		ArrayList<FuncionarioModel> listaFuncCopa = getFuncionarios(1, true);
		FuncionarioModel funcCopa = listaFuncCopa.get(0);
		
		if(funcUtil.isNasceuAnoCopa(funcCopa)) {
			System.out.println("O Funcionario " + funcCopa.getNome() + " nasceu em ano de copa do mundo");
		} else {
			System.out.println("O Funcionario " + funcCopa.getNome() + " NÃO nasceu em ano de copa do mundo");
		}
		
			
		
		System.out.println("\n\nVIZINHOS - Informe 2 Funcionarios");
		//Leitura de 2 funcionários pra saber se eles são vizinhos
		ArrayList<FuncionarioModel> listaFuncVizinho = getFuncionarios(2, true);			
		
		try {
			FuncionarioModel funcVizinho1 = listaFuncVizinho.get(0);
			FuncionarioModel funcVizinho2 = listaFuncVizinho.get(1);
			
			if(funcUtil.isFunc1VizinhoFunc2(funcVizinho1, funcVizinho2)) {
				System.out.println("Os Funcionarios são vizinhos");
			} else {
				System.out.println("Os Funcionarios NÃO são vizinhos");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi informado dois funcionarios para poder comparar se eles são vizinhos");
		}
		
		System.out.println("\n\nPROCURANDO CPF");
		//Leitura de um CPF pra procurar na lista de funcionários validos		
		String cpf = lerTeclado("Digite um CPF: ");
		funcUtil.imprimirNomeCargoFuncionario(listaFuncValidos, cpf);
		
		
		//Impressões
		funcUtil.imprimirOrdenadoNomeEmArquivo(new File("validos_ordenado_nome.txt"), listaFuncValidos);
		
		//Pela lógica seria imprimir em arquivo, mas na tarefa está pedindo pra imprimir no terminal
		//funcUtil.imprimirOrdenadoNascimentoEmArquivo(new File("validos_ordenado_nascimento.txt"), listaFuncValidos);
		//funcUtil.imprimirOrdenadoNomeEmArquivo(new File("invalidos_ordenado_nome.txt"), listaFuncInvalidos);
		
		funcUtil.imprimirOrdenadoNascimentoTerminal(listaFuncValidos);
		funcUtil.imprimirOrdenadoNomeTerminal(listaFuncInvalidos);
	}
	
	/**
	 * Abre o prompt para digitar os dados do funcionário
	 * @param validar Parametro para indicar se irá validar ou não o funcionário
	 * @return Lista de FuncionarioModel
	 */
	private static ArrayList<FuncionarioModel> getFuncionarios(int maxFunc, boolean validar) {
				
		ArrayList<FuncionarioModel> listaFunc = new ArrayList<FuncionarioModel>();
				
		String addFunc = "N";
				
		int contFunc = 0;
		do {
						
			System.out.println("Informe dos dados do funcionário");
			
			String nome = lerTeclado("Nome:");					
			String apelido = lerTeclado("Apelido:");			
			String nascimento = lerTeclado("Nascimento (dd/mm/aaaa):");
			
			Date dataNascimento;
			try {
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			    dataNascimento = formatter.parse(nascimento);
			} catch(ParseException e) {
				dataNascimento = null;
			}
			
			String cpf = lerTeclado("CPF:");
			String cep = lerTeclado("CEP:");
			String endereco = lerTeclado("Endereço:");
			String numero = lerTeclado("Número:");
			String cidade = lerTeclado("Cidade:");
			String estado = lerTeclado("Estado:");
			String cargo = lerTeclado("Cargo:");
			
						
			FuncionarioModel func = funcUtil.criarFuncionario(nome, apelido, dataNascimento, cpf, cep, endereco, numero, cidade, estado, cargo);
			
			if(validar) {
				try {
					ValidarFuncionario.validarFuncionario(func);					
				} catch(IllegalArgumentException e) {
					System.out.println("\n\n" + e.getMessage());
					continue;
				}
			}
			
			if(listaFunc.contains(func)) {
				System.out.println("Já existe um funcionario cadastrado com o CPF " + func.getCpf());
				continue;
			}
			
			listaFunc.add(func);
			contFunc++;
			
			if(contFunc < maxFunc) {
				do {				
					addFunc = lerTeclado("Deseja adicionar outro funcionário? (S/N)");
				} while(!"S".equalsIgnoreCase(addFunc) && !"N".equalsIgnoreCase(addFunc));
			}
			
		} while(contFunc <= maxFunc && "S".equalsIgnoreCase(addFunc));
		
		return listaFunc;
	}
 
	/**
	 * Faz a leitura do campo pelo teclado
	 * @param campo O campo que será lido
	 * @return Valor lido pelo teclado
	 */
	private static String lerTeclado(String campo) {
		System.out.printf(campo);
		String campoLido = scn.nextLine();
		return campoLido;
	}
}
