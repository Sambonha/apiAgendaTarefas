package br.com.cotiinformatica.controllers;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {

	@PostMapping
	public ResponseEntity<?> post() {
		return ResponseEntity.ok("Sucesso!");
	}

	@PutMapping
	public ResponseEntity<?> put() {
		return ResponseEntity.ok("Sucesso!");
	}

	@DeleteMapping
	public ResponseEntity<?> delete() {
		return ResponseEntity.ok("Sucesso!");

	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok("Sucesso!");

	}

=======
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.TarefaPostRequest;
import br.com.cotiinformatica.dtos.TarefaPutRequest;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.Prioridade;
import br.com.cotiinformatica.repositories.TarefaRepository;

@RequestMapping("/api/v1/tarefas")
@RestController
public class TarefaController {

	private TarefaRepository tarefaRepository = new TarefaRepository();

	@PostMapping
	public ResponseEntity<?> post(@RequestBody TarefaPostRequest request) {

		var tarefa = new Tarefa();

		tarefa.setId(UUID.randomUUID());
		tarefa.setNome(request.getNomeTarefa());
		tarefa.setData(LocalDate.parse(request.getDataTarefa()));
		tarefa.setPrioridade(Prioridade.valueOf(request.getPrioridadeTarefa()));
		tarefa.setFinalizado(false);
		tarefa.setCategoria(new Categoria());
		tarefa.getCategoria().setId(UUID.fromString(request.getIdCategoria()));

		tarefaRepository.insert(tarefa);

		return ResponseEntity.ok("Tarefa cadastrada com sucesso!");

	}

	@PutMapping
	public ResponseEntity<?> put(@RequestBody TarefaPutRequest request) {

		var tarefa = new Tarefa();

		tarefa.setId(UUID.fromString(request.getIdTarefa()));
		tarefa.setNome(request.getNomeTarefa());
		tarefa.setData(LocalDate.parse(request.getDataTarefa()));
		tarefa.setPrioridade(Prioridade.valueOf(request.getPrioridadeTarefa()));
		tarefa.setFinalizado(false);
		tarefa.setCategoria(new Categoria());
		tarefa.getCategoria().setId(UUID.fromString(request.getIdCategoria()));

		tarefaRepository.update(tarefa);

		return ResponseEntity.ok("Tarefa Atualizada com sucesso!");

	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		if (tarefaRepository.delete(id)) {
			return ResponseEntity.ok("Tarefa excluída com sucesso!");

		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping()
	public ResponseEntity<?> getAll() {
		var tarefas = tarefaRepository.findAll();

		return ResponseEntity.ok(tarefas);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable UUID id) {

		var tarefa = tarefaRepository.findById(id);

		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);

		} else {
			return ResponseEntity.notFound().build();
		}

	}
>>>>>>> 0bf73ba (Adicionando novas funcionalidades e atualizações)
}
