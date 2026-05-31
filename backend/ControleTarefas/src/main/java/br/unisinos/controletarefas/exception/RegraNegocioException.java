package br.unisinos.controletarefas.exception;

import lombok.experimental.StandardException;

// Gera os construtores da classe automaticamente usando o Lombok.
@StandardException
// extends RuntimeException: Classe personalizada para representar "Violação de Regra de Negócio".
// Exemplo prático: se o gerente da regra disser "Não pode cadastrar duas categorias com o mesmo nome",
// o sistema pode lançar (throw new RegraNegocioException) e o GlobalExceptionHandler vai 
// transformar isso em um erro 400 amigável para o usuário.
public class RegraNegocioException extends RuntimeException {

}