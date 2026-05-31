package br.unisinos.controletarefas.service;

import br.unisinos.controletarefas.entity.Tarefa;
import br.unisinos.controletarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Esta é a classe central do sistema, gerenciando as regras de negócio da entidade principal (Tarefa).
@Service
public class TarefaService {

    // Injeção de dependência do repositório da Tarefa, que já possui os comandos SQL mapeados pelo Hibernate/JPA.
    @Autowired
    private TarefaRepository tarefaRepository;

    // CREATE: O método save do Spring Data JPA insere a Tarefa no banco. 
    // Como a Tarefa tem chaves estrangeiras (Categoria e Prioridade), o JPA verifica esses relacionamentos automaticamente aqui.
    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // READ: Traz todas as tarefas. O banco também fará "JOINs" automáticos para trazer os dados das categorias e prioridades atreladas.
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    // READ: Busca por Chave Primária (ID). O uso do Optional aqui é uma exigência moderna do Java para lidar com dados que podem faltar.
    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    // UPDATE: Previne a criação de um novo registro por engano. 
    // Se o ID existir, forçamos que o objeto tarefaAtualizada tenha esse ID, garantindo que o comando executado no banco seja um UPDATE e não um INSERT.
    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        if (tarefaRepository.existsById(id)) {
            tarefaAtualizada.setId(id);
            return tarefaRepository.save(tarefaAtualizada);
        }
        return null;
    }

    // DELETE: Tenta apagar a tarefa. Por ser a tabela "filha" no relacionamento, apagá-la não afeta as categorias e prioridades (integridade referencial mantida).
    public boolean excluir(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}