package br.unisinos.controletarefas.service;

import br.unisinos.controletarefas.entity.Prioridade;
import br.unisinos.controletarefas.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Define esta classe como um componente de serviço do Spring (regras de negócio da Prioridade).
@Service
public class PrioridadeService {

    // Injeta a interface que se comunica com a tabela de Prioridades no banco de dados.
    @Autowired
    private PrioridadeRepository prioridadeRepository;

    // CREATE: Recebe a Prioridade (ex: Alta, Baixa) e persiste no banco de dados via JPA.
    public Prioridade salvar(Prioridade prioridade) {
        return prioridadeRepository.save(prioridade);
    }

    // READ: Busca todos os registros da tabela de Prioridades e devolve em formato de Lista.
    public List<Prioridade> listarTodas() {
        return prioridadeRepository.findAll();
    }

    // READ: Busca uma prioridade específica pelo ID. Embrulha o resultado em um Optional 
    // para tratamento seguro contra valores nulos na camada do Controller.
    public Optional<Prioridade> buscarPorId(Long id) {
        return prioridadeRepository.findById(id);
    }

    // UPDATE: Valida a existência do registro. Se confirmado, atualiza os dados da prioridade correspondente.
    public Prioridade atualizar(Long id, Prioridade prioridadeAtualizada) {
        if (prioridadeRepository.existsById(id)) {
            prioridadeAtualizada.setId(id);
            return prioridadeRepository.save(prioridadeAtualizada);
        }
        return null;
    }

    // DELETE: Confirma se o registro existe. Se sim, executa a remoção e retorna sucesso (true).
    public boolean excluir(Long id) {
        if (prioridadeRepository.existsById(id)) {
            prioridadeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}