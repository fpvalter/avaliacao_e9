package br.com.e9.avaliacao.util;

public class CopaMundo {

	private int anoPrimeiraCopa = 1930;
	private int ocorrenciaCopa = 4;
	
	public boolean nasceuAnoCopa(int anoNascimento) {
		
		if(anoNascimento >= anoPrimeiraCopa) {
			int diferenca = anoNascimento - anoPrimeiraCopa;
			
			if(diferenca % ocorrenciaCopa == 0) {
				return true;
			}
		}
		
		return false;
	}
}
