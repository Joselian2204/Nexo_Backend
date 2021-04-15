package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {
}
