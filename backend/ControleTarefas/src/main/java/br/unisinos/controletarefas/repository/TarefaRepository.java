package br.unisinos.controletarefas.repository;

import br.unisinos.controletarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Ponto de comunicação exclusivo com a tabela "tarefas" no PostgreSQL.
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
    // A Tarefa possui chaves estrangeiras (Categoria e Prioridade).
    // A vantagem do JpaRepository é que, ao executar um comando de busca por ID aqui,
    // o próprio JPA faz os "JOINs" necessários no banco de dados para trazer os dados
    // da Categoria e da Prioridade junto com a Tarefa, sem precisarmos escrever uma linha de SQL.
}