package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Student;
import com.eclipse.UirShop.entitiesDto.StudentDto;
import com.eclipse.UirShop.repositories.IStudentRepository;

import com.eclipse.UirShop.transformerDto.StudentTransformer;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class StudentService {

        private final IStudentRepository studentRepository;

        @Value("${file.upload.directory}")
        private String fileUploadDirectory;

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
        // Fetch the existing student entity by ID
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));

        // Update the fields of the existing student entity with the values from the updatedStudentDto
        existingStudent.setFullname(updatedStudentDto.getFullname());
        existingStudent.setPhonenumber(updatedStudentDto.getPhonenumber());
        existingStudent.setEmail(updatedStudentDto.getEmail());
        existingStudent.setBiography(updatedStudentDto.getBiography());
        existingStudent.setImage(updatedStudentDto.getImage());
        existingStudent.setInstagram(updatedStudentDto.getInstagram());
        existingStudent.setFacebook(updatedStudentDto.getFacebook());
        existingStudent.setTiktok(updatedStudentDto.getTiktok());

        // Save the updated student entity back to the repository
        Student updatedStudent = studentRepository.save(existingStudent);

        // Transform and return the updated student as a StudentDto
        return StudentTransformer.studentTransformToDto(updatedStudent);
    }

}