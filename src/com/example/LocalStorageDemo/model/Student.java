package com.example.LocalStorageDemo.model;

/**
 * User: anhnt
 * Date: 10/23/13
 * Time: 8:17 AM
 */
public class Student
{
    private int studentId;
    private String studentName;
    private String studentAge;

    public Student()
    {
    }

    public Student(String studentName, String studentAge)
    {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public Student(int studentId, String studentName, String studentAge)
    {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentAge()
    {
        return studentAge;
    }

    public void setStudentAge(String studentAge)
    {
        this.studentAge = studentAge;
    }
}
