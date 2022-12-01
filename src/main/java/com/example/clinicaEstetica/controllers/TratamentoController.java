package com.example.clinicaEstetica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinicaEstetica.models.Tratamento;
import com.example.clinicaEstetica.services.TratamentoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clinica")
@CrossOrigin(origins = "*")
@Api(value = "Clinica Estetica")
public class TratamentoController {

	@Autowired
	TratamentoServices tratamentoService;

	@ApiOperation(value = "Lista de Tratamentos")
	@GetMapping("/lstAll")
	public ResponseEntity<List<Tratamento>> getAllTratamentos() {
		List<Tratamento> lstTratamentos = tratamentoService.findAll();
		if (lstTratamentos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Tratamento>>(lstTratamentos, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Busca o Tratamento pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Tratamento> findById(@PathVariable(value = "id") long id) {
		Tratamento tratamento = tratamentoService.findByID(id);
		if (tratamento == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<Tratamento>(tratamento, HttpStatus.OK);
	}

	@ApiOperation(value = "Criar novo Tratamento")
	@PostMapping("/save")
	public ResponseEntity<Tratamento> saveCliente(@RequestBody Tratamento tratamento) {
		return new ResponseEntity<Tratamento>(tratamentoService.salvarTratamento(tratamento), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Apagar tratamento")
	public ResponseEntity<Tratamento> deleteTratamento(@PathVariable(value = "id") long id) {
		Tratamento tratamento = tratamentoService.delete(id);
		if (tratamento == null) {
			return new ResponseEntity<Tratamento>(tratamento, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Tratamento>(HttpStatus.OK);
		}

	}
}