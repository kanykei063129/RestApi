package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
    return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
      return studentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Student with id: " + id + " is not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student student1 = studentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Student with id: " + id + " is not found"));
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        studentRepository.save(student1);
        return student1;
    }

    @Override
    public String deleteStudent(Long id) {
        boolean exists=studentRepository.existsById(id);
        if (!exists) {
            throw new NullPointerException("Student with id: " + id + " is not found");
        }
            studentRepository.deleteById(id);
        return "Student with id: " + id + " is deleted...";
    }
}
