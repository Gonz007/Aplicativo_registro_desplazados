package com.sg.presentation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sg.presentation.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

}
