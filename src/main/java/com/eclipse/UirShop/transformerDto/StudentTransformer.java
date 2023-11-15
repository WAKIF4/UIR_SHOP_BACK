package com.eclipse.UirShop.transformerDto;

import com.eclipse.UirShop.entities.Student;
import com.eclipse.UirShop.entitiesDto.StudentDto;

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
                student.getTiktok()
        );
    }

    public static Student studentDtoTransformToEntity(StudentDto studentDto){
        Student student = new Student();
        student.setFullname(studentDto.getFullName());
        student.setPhonenumber(studentDto.getPhonenumber());
        student.setEmail(studentDto.getEmail());
        student.setBiography(studentDto.getBiographie());
        student.setImage(studentDto.getImage());
        student.setInstagram(studentDto.getInstagram());
        student.setFacebook(studentDto.getFacebook());
        student.setTiktok(studentDto.getTiktok());
        return student;
    }

}
