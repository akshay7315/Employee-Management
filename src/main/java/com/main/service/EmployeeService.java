package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.Employeedao;
import com.main.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private Employeedao dao;
	
	public Employee add(Employee e) {
		return dao.save(e);
	}
	
	public List<Employee>viewall(){
		return dao.findAll();
	}
	
	public Employee update(Employee e) {
		if(dao.existsById(e.getId())) {
			return dao.save(e);
		}else {
			throw new RuntimeException("Employee id is not found");
		}
	}
	
	public boolean delete(int id) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
            return true;
        } else {
            return false;
        }
	}}

