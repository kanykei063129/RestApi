package peaksoft.service;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    String deleteStudent(Long id);

}
