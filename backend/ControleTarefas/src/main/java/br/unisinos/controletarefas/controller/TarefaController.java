package br.unisinos.controletarefas.controller;

import br.unisinos.controletarefas.entity.Tarefa;
import br.unisinos.controletarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador principal do sistema, gerenciando a entidade Tarefa e seus relacionamentos REST.
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    // POST: Ao receber o JSON da Tarefa, o Spring Boot faz o "binding" automático. 
    // Como a Tarefa contém objetos aninhados (Categoria e Prioridade) no JSON, 
    // o Jackson (biblioteca interna do Spring) converte isso perfeitamente antes de mandar para o Service.
    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(tarefaService.salvar(tarefa));
    }

    // GET: Recupera a lista completa de tarefas cadastradas.
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    // GET por ID: Retorna 200 OK com os dados completos da tarefa ou 404 Not Found.
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.buscarPorId(id);
        return tarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT: Rota para atualizar o status (concluída) ou os textos da tarefa.
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizar(id, tarefa);
        if (tarefaAtualizada != null) {
            return ResponseEntity.ok(tarefaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Rota para limpeza de registros de tarefas antigas ou cadastradas incorretamente.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (tarefaService.excluir(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}