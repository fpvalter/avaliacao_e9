/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.e9.avaliacao.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.e9.avaliacao.model.FuncionarioModel;

/**
 *
 * @author Thiago
 */
public class ValidarFuncionario {
    
	/* Nome  - caracteres  max 128 - obrigatorio */
    /* Apelido - caracteres  max 64 */
    /* Nascimento - date - obrigatorio */
    /* CPF - caracteres  fixo 11 - obrigatorio */
    /* CEP - caracteres  fixo 8 - obrigatorio */
    /* Endereco - caracteres  max 128 - obrigatorio */    
    /* Número - caracteres  max 8 -  */    
    /* Cidade - caracteres  max 128 - obrigatorio */    
    /* Estado - caracteres  fixo 2 - obrigatorio */    
    /* Cargo - caracteres  max 64 - obrigatorio */    
	
	
    /** Validar os campos do modelo funcionario,
     *  caso algum campo esteja invalido ou haja um erro lancar um exception, se tudo ok nao retornar nada
     */
    public static void validarFuncionario(FuncionarioModel f) throws IllegalArgumentException{
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	
    	//Set<ConstraintViolation<Funcio>> violations = validator.validate(f)
    	Set<ConstraintViolation<FuncionarioModel>> violations = validator.validate(f);
    	
    	String msgErro = "";
    	for(ConstraintViolation<FuncionarioModel> v : violations) {
    		msgErro += v.getMessage() + "\n";
    	}
    	
    	if(!"".equals(msgErro)) {
    		throw new IllegalArgumentException(msgErro);
    	}
    }
    
}
