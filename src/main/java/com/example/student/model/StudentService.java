package com.example.student.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private Map<String, Student> students = new HashMap<String, Student>();

    public void addStudent(Student student) {
        if(student != null) {
            students.put(student.getId(), student);
        }
    }

    public void addScore(float score, String id) throws IllegalArgumentException {
        Student student = students.get(id);
        if(student != null) {
            student.addScore(score);
        } else {
            throw new IllegalStateException("Student " + id + "doesn't exist'");
        }

    }

    public List<Student> getClassification(){
        List<Student> classification = new ArrayList<>(students.values());
        classification.sort((a,b) -> -1 * Float.compare(a.getScore(), b.getScore()));
        return classification;
    }

}
