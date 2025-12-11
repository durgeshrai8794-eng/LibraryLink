//package com.example.BookStoreMgmt.Controller;
//
//import com.example.BookStoreMgmt.Entity.Student;
//import com.example.BookStoreMgmt.Repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;

//@Controller
//public class StudentController {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    // Show list
//    @GetMapping("/students_list")
//    public String getStudents(Model model) {
//        List<Student> students = studentRepository.findAll();
//        model.addAttribute("students", students);
//        return "students_list";
//    }
//
//    // Show Add Student form
//    @GetMapping("/students/add")
//    public String addStudentForm(Model model) {
//        model.addAttribute("student", new Student());
//        return "add_student";
//    }
//
////    // Handle form submission
////    @PostMapping("/save")
////    public String saveStudent(@ModelAttribute Student student) {
////        studentRepository.save(student);
////        return "redirect:/students_list";
////    }
////
////    // Delete student
////    @GetMapping("/delete/{id}")
////    public String deleteStudent(@PathVariable Long id) {
////        studentRepository.deleteById(id);
////        return "redirect:/students_list";
////    }
//    
//    // Handle form submission
//    @PostMapping("/students/save")
//    public String saveStudent(@ModelAttribute Student student) {
//        studentRepository.save(student);
//        return "redirect:/students_list"; // 👈 back to list
//    }
//
//    // Delete student
//    @GetMapping("/students/delete/{id}")
//    public String deleteStudent(@PathVariable Long id) {
//        studentRepository.deleteById(id);
//        return "redirect:/students_list";
//    }
//
//    
// 
//   
//}

package com.example.BookStoreMgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookStoreMgmt.Entity.Student;
import com.example.BookStoreMgmt.Repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	// Show list
	@GetMapping("/students_list")
	public String getStudents(Model model) {
		List<Student> students = studentRepository.findAll();
		model.addAttribute("students", students);
		return "students_list";
	}

	// Show Add Student form
	@GetMapping("/students/add")
	public String addStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "add_student";
	}

	// Show Edit Student form
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		model.addAttribute("student", student);
		return "add_student"; // Reuse the same form
	}

	// Handle form submission (both add & edit)
	@PostMapping("/students/save")
	public String saveStudent(@ModelAttribute Student student) {
		studentRepository.save(student); // JPA will update if ID exists
		return "redirect:/students_list";
	}

	// Delete student
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentRepository.deleteById(id);
		return "redirect:/students_list";
	}
}
