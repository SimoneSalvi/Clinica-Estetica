package com.example.clinicaEstetica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clinicaEstetica.models.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Long>{

}
