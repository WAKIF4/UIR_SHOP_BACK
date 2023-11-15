package com.eclipse.UirShop.transformerDto;

import com.eclipse.UirShop.entities.Student;
import com.eclipse.UirShop.entitiesDto.StudentDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentTransformer {

    public static StudentDto studentTransformToDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFullname(),
                student.getPhonenumber(),
                student.getEmail(),
                student.getBiography(),
                student.getImage(),
                student.getInstagram(),
                student.getFacebook(),
                student.getTiktok(),
                student.getProductList()
        );
    }

    public static Student studentDtoTransformToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setFullname(studentDto.getFullname());
        student.setPhonenumber(studentDto.getPhonenumber());
        student.setEmail(studentDto.getEmail());
        student.setBiography(studentDto.getBiography());
        student.setImage(studentDto.getImage());
        student.setInstagram(studentDto.getInstagram());
        student.setFacebook(studentDto.getFacebook());
        student.setTiktok(studentDto.getTiktok());
        return student;
    }

    public static List<StudentDto> studentListTransformToDtoList(List<Student> students) {
        return students.stream()
                .map(StudentTransformer::studentTransformToDto)
                .collect(Collectors.toList());
    }

    public static List<Student> studentDtoListTransformToEntityList(List<StudentDto> studentDtos) {
        return studentDtos.stream()
                .map(StudentTransformer::studentDtoTransformToEntity)
                .collect(Collectors.toList());
    }

}
