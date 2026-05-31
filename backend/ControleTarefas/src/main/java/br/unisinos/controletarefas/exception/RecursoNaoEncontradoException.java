package br.unisinos.controletarefas.exception;

import lombok.experimental.StandardException;

// @StandardException: É uma anotação da biblioteca Lombok. 
// Ela cria automaticamente todos os construtores necessários nos bastidores,
// deixando o código limpo e evitando que tenhamos que digitar várias linhas repetitivas.
@StandardException
// extends RuntimeException: Indica que esta é uma exceção que ocorre durante a execução (unchecked).
// Nós criamos esta classe "personalizada" para o sistema saber exatamente quando o erro
// se trata de um ID ou dado que foi buscado, mas não existe no banco de dados.
public class RecursoNaoEncontradoException extends RuntimeException {

}