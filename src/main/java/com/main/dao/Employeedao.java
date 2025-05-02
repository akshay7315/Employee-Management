package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Employee;

@Repository
public interface Employeedao extends JpaRepository<Employee, Integer> {

}
