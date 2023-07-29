package com.oulku.Employee.repository;

import com.oulku.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Spring Data JPA - Query Creation from Method Names
    List<Employee> findByName(String name);

    //JPQL
    @Query("SELECT e FROM Employee e WHERE e.employeeId =:employeeId and e.name =:name")
    Employee getEmployee(@Param("employeeId") int employeeId, @Param("name") String name);

    //Native SQL Query
    @Query(value = "SELECT * FROM Employee e WHERE e.employee_id = :employeeId and e.employee_name = :name", nativeQuery = true)
    Employee getEmployeeByNativeQuery(@Param("employeeId") int employeeId, @Param("name") String name);

}
