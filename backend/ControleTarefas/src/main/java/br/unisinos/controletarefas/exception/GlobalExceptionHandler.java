package br.unisinos.controletarefas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice: Age como um "pára-raios" ou interceptador global para a API.
// Ele fica "escutando" toda a aplicação. Se qualquer Controller lançar um erro, esta classe captura
// antes que o erro quebre o servidor e chegue ao usuário final de forma desorganizada.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler: Especifica qual classe de erro este método vai tratar.
    // Aqui, ele captura qualquer erro do tipo "RecursoNaoEncontradoException".
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<String> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {
        // Em vez de retornar um erro genérico (como Erro 500), ele devolve um Status 404 (Not Found)
        // super elegante, junto com a mensagem exata do que deu errado.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Captura erros específicos de violação de regras de negócio.
    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<String> tratarRegraNegocio(RegraNegocioException ex) {
        // Se uma regra de negócio for violada, o sistema devolve um Status 400 (Bad Request),
        // avisando o cliente (Postman/Swagger) que a requisição que ele fez é inválida.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}