import api from './api';

export default {
  // Equivalente ao GET /tarefas
  listarTodas() {
    return api.get('/tarefas');
  },

  // Equivalente ao GET /tarefas/{id}
  buscarPorId(id) {
    return api.get(`/tarefas/${id}`);
  },

  // Equivalente ao POST /tarefas
  salvar(tarefa) {
    return api.post('/tarefas', tarefa);
  },

  // Equivalente ao PUT /tarefas/{id}
  atualizar(id, tarefa) {
    return api.put(`/tarefas/${id}`, tarefa);
  },

  // Equivalente ao DELETE /tarefas/{id}
  deletar(id) {
    return api.delete(`/tarefas/${id}`);
  }
};