/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.e9.avaliacao.util;

import br.com.e9.avaliacao.model.FuncionarioModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thiago
 */
public interface FuncionarioGenerico {
    
    public FuncionarioModel criarFuncionario(String nome, String apelido, Date nasc, String cpf, String cep, String endereco, String num, String cidade, String estado, String cargo);
    
    public int getIdadeFuncionario(String cpf);
    
    public void imprimirNomeCargoFuncionario(ArrayList<FuncionarioModel> listaFunc, String cpf);
    
    public void imprimirOrdenadoNomeTerminal(ArrayList<FuncionarioModel> listaFunc);
    
    public void imprimirOrdenadoNascimentoTerminal(ArrayList<FuncionarioModel> listaFunc);
    
    public void imprimirOrdenadoNomeEmArquivo(File f, ArrayList<FuncionarioModel> listaFunc);
    
    public void imprimirOrdenadoNascimentoEmArquivo(File f, ArrayList<FuncionarioModel> listaFunc);
    
    /*O funcionario 1 eh vizinho do funcionario 2 se eles possuem o mesmo cep de endereco */
    public boolean isFunc1VizinhoFunc2(FuncionarioModel func1, FuncionarioModel func2);

	public boolean isNasceuAnoCopa(FuncionarioModel func);
    
}
