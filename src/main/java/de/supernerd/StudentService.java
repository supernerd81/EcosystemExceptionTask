package de.supernerd;

import de.supernerd.exeptions.StudentNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentService  {

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString());
        return repo.save(studentToSave);
    }

    public Student findById(String id) throws StudentNotFoundException {

            StudentRepo studentRepo = new StudentRepo();
            Optional<Student> student = studentRepo.findStudentById(id);

            if(student.isEmpty()) {
                throw new StudentNotFoundException("Student wurde nicht gefunden");
            }

            return student.get();
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }
}
