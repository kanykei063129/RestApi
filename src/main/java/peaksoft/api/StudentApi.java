package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Student;
import peaksoft.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping()
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/{id}")
    public Student getStudentBy(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

}

//    @GetMapping("/{id}/getUser")
//    public String getUserToUpdateById(@PathVariable Long id,Model model){
//        model.addAttribute("user",userService.getUserById(id));
//        return "updateUser";
//    }

//    @GetMapping("/{email}/getUser")
//    public String getUserToUpdateByEmail(@PathVariable String email,Model model){
//        model.addAttribute("user",userService.getUserByEmail(email));
//        return "updateUser";
//    }
//
//    @PostMapping("/{id}/update")
//    public String updateUser(@PathVariable Long id,
//                             @ModelAttribute ("user") User user){
//        userService.updateUser(id,user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String deleteUser(@PathVariable Long id){
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
//}
