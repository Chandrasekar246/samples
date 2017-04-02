package com.scs.eis.server.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.eis.server.model.Employee;

@Component
public class EmployeeDAO {

	// Dummy database. Initialize with some dummy values.
	private static List<Employee> employeeList;
	{
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("101", "Anand", new Date(), "121-232-3435"));
		employeeList.add(new Employee("102", "Bala", new Date(), "121-232-3435"));
		employeeList.add(new Employee("103", "Chandra", new Date(), "121-232-3435"));
		employeeList.add(new Employee("104", "Dinesh", new Date(), "121-232-3435"));
	}

	/**
	 * Returns list of employees from dummy database.
	 * 
	 * @return list of employees
	 */
	public List<Employee> list() {
		return employeeList;
	}

	/**
	 * Return employee object for given id from dummy database. If employee is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            employee id
	 * @return employee object for given id
	 */
	public Employee get(Long id) {

		for (Employee emp : employeeList) {
			if (emp.getId().equals(id)) {
				return emp;
			}
		}
		return null;
	}

	/**
	 * Create new employee in dummy database. Updates the id and insert new
	 * employee in list.
	 * 
	 * @param employee
	 *            Employee object
	 * @return employee object with updated id
	 */
	public Employee create(Employee employee) {
		employeeList.add(employee);
		return employee;
	}

	/**
	 * Delete the employee object from dummy database. If employee not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the employee id
	 * @return id of deleted employee object
	 */
	public Long delete(Long id) {

		for (Employee emp : employeeList) {
			if (emp.getId().equals(id)) {
				employeeList.remove(emp);
				return id;
			}
		}

		return null;
	}

	/**
	 * Update the employee object for given id in dummy database. If employee
	 * not exists, returns null
	 * 
	 * @param id
	 * @param employee
	 * @return employee object with id
	 */
	public Employee update(Long id, Employee employee) {

		for (Employee emp : employeeList) {
			if (emp.getId().equals(id)) {
				employee.setId(emp.getId());
				employeeList.remove(emp);
				employeeList.add(employee);
				return employee;
			}
		}

		return null;
	}

}