package br.unisinos.controletarefas.controller;

import br.unisinos.controletarefas.entity.Prioridade;
import br.unisinos.controletarefas.service.PrioridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Porta de entrada para os endpoints de prioridade, garantindo a comunicação REST via JSON.
@RestController
@RequestMapping("/prioridades") // Base da URL: localhost:8080/prioridades
public class PrioridadeController {

    @Autowired
    private PrioridadeService prioridadeService;

    // Endpoint para criar prioridades. Usa @RequestBody para ler os dados enviados pelo cliente.
    @PostMapping
    public ResponseEntity<Prioridade> criar(@RequestBody Prioridade prioridade) {
        return ResponseEntity.ok(prioridadeService.salvar(prioridade));
    }

    // Endpoint de leitura geral. Retorna um array JSON com todas as prioridades.
    @GetMapping
    public ResponseEntity<List<Prioridade>> listarTodas() {
        return ResponseEntity.ok(prioridadeService.listarTodas());
    }

    // Endpoint de leitura por ID. Utiliza @PathVariable para extrair o identificador da URL.
    @GetMapping("/{id}")
    public ResponseEntity<Prioridade> buscarPorId(@PathVariable Long id) {
        Optional<Prioridade> prioridade = prioridadeService.buscarPorId(id);
        // Encadeamento funcional que resolve a resposta HTTP dependendo da existência do dado.
        return prioridade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint de atualização total do recurso (PUT). Recebe o ID pela URL e os novos dados pelo corpo (JSON).
    @PutMapping("/{id}")
    public ResponseEntity<Prioridade> atualizar(@PathVariable Long id, @RequestBody Prioridade prioridade) {
        Prioridade prioridadeAtualizada = prioridadeService.atualizar(id, prioridade);
        if (prioridadeAtualizada != null) {
            return ResponseEntity.ok(prioridadeAtualizada);
        }
        // Tratamento de requisição inválida
        return ResponseEntity.notFound().build();
    }

    // Endpoint de remoção. Não retorna corpo no JSON (ResponseEntity<Void>), apenas o status HTTP.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (prioridadeService.excluir(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}