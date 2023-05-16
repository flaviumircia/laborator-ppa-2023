package com.ion_popescu.laborator4.repo;

public class User {
//        "id": 5,
//                "studentName": "test",
//                "laboratoryGroup": "test2",
//                "hashedPassword": "sssad",
//                "post": "cdg"
    Long id;
    String studentName;
    String laboratoryGroup;
    String hashedPassword;
    String post;

    public User() {
    }

    public User(Long id, String studentName, String laboratoryGroup, String hashedPassword, String post) {
        this.id = id;
        this.studentName = studentName;
        this.laboratoryGroup = laboratoryGroup;
        this.hashedPassword = hashedPassword;
        this.post = post;
    }

    public User(String studentName, String laboratoryGroup, String hashedPassword, String post) {
        this.studentName = studentName;
        this.laboratoryGroup = laboratoryGroup;
        this.hashedPassword = hashedPassword;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLaboratoryGroup() {
        return laboratoryGroup;
    }

    public void setLaboratoryGroup(String laboratoryGroup) {
        this.laboratoryGroup = laboratoryGroup;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
