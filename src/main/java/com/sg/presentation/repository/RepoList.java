package com.sg.presentation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sg.presentation.model.Donacion;


@Repository
public interface RepoList extends MongoRepository<Donacion, String> {

}