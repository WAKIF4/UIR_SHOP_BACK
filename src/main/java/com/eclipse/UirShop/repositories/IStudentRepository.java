package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entitiesDto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentDto, Long> {
}
