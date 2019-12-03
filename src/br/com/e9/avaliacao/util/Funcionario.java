/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.e9.avaliacao.util;

import br.com.e9.avaliacao.model.FuncionarioModel;
import br.com.e9.avaliacao.validator.ValidarFuncionario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Thiago
 */
public class Funcionario implements FuncionarioGenerico {
    
    @Override
    public FuncionarioModel criarFuncionario(String nome, String apelido, Date nasc, String cpf, String cep, String endereco, String num, String cidade, String estado, String cargo) {    	
    	return new FuncionarioModel(nome, apelido, nasc, cpf, cep, endereco, num, cidade, estado, cargo);    		    	    	
    }

    @Override
    public int getIdadeFuncionario(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimirNomeCargoFuncionario(ArrayList<FuncionarioModel> listaFunc, String cpf) {
    	
    	cpf = cpf.replaceAll("[.-]", "");
    	
    	FuncionarioModel func = new FuncionarioModel();
    	func.setCpf(cpf);
    	
    	int index = listaFunc.indexOf(func);
    	
    	if(index > 0) {
    		FuncionarioModel funcEncontrado = listaFunc.get(index);
    		System.out.println("Nome Funcionario: " + funcEncontrado.getNome() );
    		System.out.println("Cargo Funcionario: " + funcEncontrado.getCargo() );
    	} else {
    		System.out.println("CPF não encontrado");
    	}
    	        
    }

    @Override
    public void imprimirOrdenadoNomeTerminal(ArrayList<FuncionarioModel> listaFunc) {
    	System.out.println("Lista Ordenada Por Nome");
    	Collections.sort(listaFunc, new FuncionarioNomeComparator());
    	System.out.println(listaFunc.toString());        
    }

    @Override
    public void imprimirOrdenadoNascimentoTerminal(ArrayList<FuncionarioModel> listaFunc) {
    	System.out.println("Lista Ordenada Por Nascimento");
    	Collections.sort(listaFunc, new FuncionarioNascimentoComparator());
    	System.out.println(listaFunc.toString());        
    }

    @Override
    public void imprimirOrdenadoNomeEmArquivo(File f, ArrayList<FuncionarioModel> listaFunc) {
    	Collections.sort(listaFunc, new FuncionarioNomeComparator());
		gravarArquivo(f, listaFunc);		
    }

    @Override
    public void imprimirOrdenadoNascimentoEmArquivo(File f, ArrayList<FuncionarioModel> listaFunc) {
    	Collections.sort(listaFunc, new FuncionarioNascimentoComparator());    	
		gravarArquivo(f, listaFunc);		
    }

    @Override
    public boolean isFunc1VizinhoFunc2(FuncionarioModel func1, FuncionarioModel func2) {
    	
    	FuncionarioCepComparator cepComparator = new FuncionarioCepComparator();
    	int igual = cepComparator.compare(func1, func2);
    	
    	if(igual == 0) {
    		return true;
    	}
    	
        return false;
    }
    
    @Override
    public boolean isNasceuAnoCopa(FuncionarioModel func) {
        
    	GregorianCalendar dataCal = new GregorianCalendar();
    	dataCal.setTime(func.getNascimento());
    	int ano = dataCal.get(Calendar.YEAR);
    	
    	CopaMundo copa = new CopaMundo();    	
    	return copa.nasceuAnoCopa(ano);
    	
    	
    }
    
    private void gravarArquivo(File file, ArrayList<FuncionarioModel> listaFunc) {
    	
    	FileWriter arq;
    	PrintWriter gravar;
		try {
			arq = new FileWriter(file);
			gravar = new PrintWriter(arq);     
	        gravar.println(listaFunc.toString());
	        arq.close();
		} catch (IOException e) {
			System.out.println("Não foi possível gravar em arquivo");
		}
        
    }
}
