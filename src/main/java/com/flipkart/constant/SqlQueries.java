package com.flipkart.constant;

public class SqlQueries {

    // Admin
    public static final String DELETE_COURSE_QUERY = "delete from course where courseId = ?";
    public static final String ADD_COURSE_QUERY = "insert into course(courseId, profId, courseName, courseFee) values (?, ?, ?, ?)";
    public static final String APPROVE_STUDENT_QUERY = "update userCredentials set approvalStatus = 1 where userId = ?";


    // student
    public static final String ADD_COURSE ="insert into studentCourseRegistration (studentId,courseId) values ( ? , ? )";
    public static final String DROP_COURSE = "delete from studentCourseRegistration where courseId = ? AND studentId = ?";
    public static final String VIEW_GRADE = "select course.courseId,course.courseName,studentGrade.grade from course inner join studentGrade on course.courseId = studentGrade.courseId where studentGrade.studentId = ?";
    //fetch Course added



    // professor
    public static final String ADD_GRADE = "update studentGrade set grade=? where courseId=? and studentId=?";
    public static final String VIEW_ENROLLED_STUDENTS = "select student.Id, student.name, student.department from student inner join studentCourseRegistration on student.Id = studentCourseRegistration.studentId where studentCourseRegistration.courseId = ?";
    public static final String ADD_COURSE_TO_TEACH = "update course set professorId=? where courseId=?";
    public static final String ADD_COURSE_TO_TEACH_PROFESSOR = "insert into course (courseId,profId,courseName,courseFee) values ( ? , ? , default , default )";
    public static final String CHECK_PROF_ALLOTTED = "select count(*) from course where courseId=?";


    //common
    //view courses
    //get credentials
    public static final String AUTHENTICATE_CREDS = "select * from userCredentials where userId=? and password=?";
    public static final String GET_COURSE_LIST = "select course.courseId,course.courseName,course.courseFee, course.profId from course inner join courseCatalogue on course.courseId = courseCatalogue.courseId";

    public static final String GET_HEADCOUNT_COURSE ="select count(*) from studentCourseRegistration where courseId=?";
    public static final String STUDENT_COURSE_COUNT ="select count(*) from studentCourseRegistration where studentId=?";
    public static final String CHECK_COURSE_ADDED ="select count(*) from studentCourseRegistration where studentId=? and courseId =?";


}