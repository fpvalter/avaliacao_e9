package br.com.e9.avaliacao.util;

import java.util.Comparator;

import br.com.e9.avaliacao.model.FuncionarioModel;

public class FuncionarioNomeComparator implements Comparator<FuncionarioModel>{

	@Override
	public int compare(FuncionarioModel func1, FuncionarioModel func2) {

		return func1.getNome().compareToIgnoreCase(func2.getNome());
		
	}
}
