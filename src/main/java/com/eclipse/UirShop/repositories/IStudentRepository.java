package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.Student;  // Import the correct entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}