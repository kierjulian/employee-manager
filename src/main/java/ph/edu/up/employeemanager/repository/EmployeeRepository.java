package ph.edu.up.employeemanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.edu.up.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findEmployeeById(Long id);
	void deleteEmployeeById(Long id);
}
