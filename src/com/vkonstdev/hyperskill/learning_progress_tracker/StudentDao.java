package com.vkonstdev.hyperskill.learning_progress_tracker;

import java.util.Map;

public interface StudentDao {
    Map<Integer, Student> getAllStudents();
    Student getStudent(int studentID);
    void addStudent(Student student);
    void updateStudent(Student st);
}
