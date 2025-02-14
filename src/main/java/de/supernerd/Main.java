package de.supernerd;

import de.supernerd.exeptions.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();

        Student savedStudent = studentService.addNewStudent(newStudent);

        System.out.println("Student saved: " + savedStudent);

        try {
            studentService.findById("4455");
        } catch(StudentNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
}
