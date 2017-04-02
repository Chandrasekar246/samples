package com.scs.eis.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scs.eis.server.dao.EmployeeDAO;
import com.scs.eis.server.model.Employee;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@PostMapping(value = "/employees/xml/employee", consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity createXMLEmployee(@RequestBody String employee) {

		System.out.println(employee);

		return new ResponseEntity("All success!", HttpStatus.OK);
	}

	@GetMapping("/employees")
	public List getCustomers() {
		return employeeDAO.list();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity getEmployee(@PathVariable("id") Long id) {

		Employee employee = employeeDAO.get(id);
		if (employee == null) {
			return new ResponseEntity("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(employee, HttpStatus.OK);
	}

	@PostMapping(value = "/employees")
	public ResponseEntity createEmployee(@RequestBody Employee employee) {

		employeeDAO.create(employee);

		return new ResponseEntity(employee, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == employeeDAO.delete(id)) {
			return new ResponseEntity("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/employees/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Employee employee) {

		employee = employeeDAO.update(id, employee);

		if (null == employee) {
			return new ResponseEntity("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(employee, HttpStatus.OK);
	}

}