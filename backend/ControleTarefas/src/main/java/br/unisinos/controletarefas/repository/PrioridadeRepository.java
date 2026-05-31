package br.unisinos.controletarefas.repository;

import br.unisinos.controletarefas.entity.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Define este componente como a camada de persistência para a entidade Prioridade.
@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {
    
    // Ao herdar de JpaRepository, o framework atua como um ORM (Object-Relational Mapping).
    // Ele converte automaticamente os comandos feitos no PrioridadeService (como o .findAll())
    // em comandos SQL reais (como SELECT * FROM prioridades) que o PostgreSQL consegue entender.
}