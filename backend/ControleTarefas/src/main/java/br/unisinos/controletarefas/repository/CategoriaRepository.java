package br.unisinos.controletarefas.repository;

import br.unisinos.controletarefas.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// A anotação @Repository avisa ao Spring que este arquivo é o responsável por acessar o banco de dados.
// Ele também traduz exceções específicas do banco (como erro de conexão) para exceções padrão do Java.
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // extends JpaRepository<Categoria, Long>:
    // Aqui dizemos para o Spring Data JPA assumir o controle. 
    // Passamos dois parâmetros nas chaves <>: 
    // 1. A Entidade que esta interface vai gerenciar (Categoria).
    // 2. O tipo de dado da Chave Primária (@Id) dessa entidade (Long).
    
    // OBS: Não precisamos escrever métodos como salvar(), deletar() ou buscar() aqui dentro, 
    // porque ao herdar de JpaRepository, nós já ganhamos todo o CRUD pronto de graça!
}