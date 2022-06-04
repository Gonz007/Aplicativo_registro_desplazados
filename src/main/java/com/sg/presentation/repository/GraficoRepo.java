package com.sg.presentation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sg.presentation.model.Grafico;

	@Repository
	public interface GraficoRepo extends MongoRepository<Grafico, Long>{

	}
