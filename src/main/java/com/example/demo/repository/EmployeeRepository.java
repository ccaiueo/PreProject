package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee;

/**
 * JPA利用時クラス
 * @author eharada
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
