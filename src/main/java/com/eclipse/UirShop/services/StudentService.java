package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Student;
import com.eclipse.UirShop.entitiesDto.StudentDto;
import com.eclipse.UirShop.repositories.IStudentRepository;

import com.eclipse.UirShop.transformers.StudentTransformer;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class StudentService {

        private final IStudentRepository studentRepository;


        @Autowired
        public StudentService(IStudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

    public StudentDto saveStudent(StudentDto studentDto){
        Student student = StudentTransformer.studentDtoTransformToEntity(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentTransformer.studentTransformToDto(savedStudent);
    }

        public Optional<StudentDto> getStudentById(Long id){
            Optional<Student> studentOptional = studentRepository.findById(id);
            return studentOptional.map(StudentTransformer::studentTransformToDto);
        }

        public List<StudentDto> getAllStudents(){
            List<Student> students= studentRepository.findAll();
            for (Student student : students) {
                Hibernate.initialize(student.getProductList());
            }
            return StudentTransformer.studentListTransformToDtoList(students);
        }


        public void deleteStudent(Long id) {
            studentRepository.deleteById(id);
        }



    public StudentDto updateStudent(Long id, StudentDto updatedStudentDto) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
        Student student=StudentTransformer.studentDtoTransformToEntity(updatedStudentDto);
        existingStudent.setFullname(student.getFullname());
        existingStudent.setPhonenumber(student.getPhonenumber());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBiography(student.getBiography());
        existingStudent.setImage(student.getImage());
        existingStudent.setInstagram(student.getInstagram());
        existingStudent.setFacebook(student.getFacebook());
        existingStudent.setTiktok(student.getTiktok());
        Student updatedStudent = studentRepository.save(existingStudent);

        return StudentTransformer.studentTransformToDto(updatedStudent);
    }

}