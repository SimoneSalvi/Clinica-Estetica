package com.example.clinicaEstetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clinicaEstetica.models.Tratamento;
import com.example.clinicaEstetica.repository.TratamentoRepository;

@Service
public class TratamentoServices {
	
	@Autowired
	TratamentoRepository tratamentoRepository;

	public List<Tratamento> findAll() {
		List<Tratamento> lstTratamentos = tratamentoRepository.findAll();
		return lstTratamentos;
	}
	
	public Tratamento findByID(long id){
		Optional<Tratamento> tratamentoOp = tratamentoRepository.findById(id);
		Tratamento cliente = null;
		if (tratamentoOp.isPresent()) {
			cliente = tratamentoOp.get();
		}
		return cliente;
		
	}
	
	public Tratamento salvarTratamento(Tratamento tratamento) {
		return tratamentoRepository.save(tratamento);
	}

	public Tratamento delete(long id) {
		Optional<Tratamento> tratamentoModel = tratamentoRepository.findById(id);
		Tratamento tratamento = null;
		if (tratamentoModel.isPresent()) {
			tratamento = tratamentoModel.get();
			tratamentoRepository.delete(tratamentoModel.get());
		}
		return tratamento;

	}
}
