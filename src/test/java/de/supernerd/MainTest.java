package de.supernerd;

import de.supernerd.exeptions.StudentNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void studentNotFoundExceptionTest() {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();

        studentService.addNewStudent(newStudent);

        Assertions.assertThrows(StudentNotFoundException.class, () -> {new StudentService().findById("4455");});
    }
}
