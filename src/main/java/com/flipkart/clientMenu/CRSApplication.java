package com.flipkart.clientMenu;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.UserType;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;
import com.flipkart.handler.AuthenticationHandler;
import jdk.internal.util.xml.impl.Pair;
import org.apache.log4j.Logger;

import java.util.Scanner;



public class CRSApplication {

    private static Logger logger = Logger.getLogger(CRSApplication.class);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        welcomeScreen();


    }



    public static void welcomeScreen(){

        logger.info("----------Welcome to Course Management System---------");

        logger.info("=========Enter action code as below=========");
        logger.info("1 - Login");
        logger.info("2 - Student Registration");
        logger.info("3 - Update password");
        logger.info("9 - Exit");

        int userAction = scanner.nextInt();

        switch (userAction){
            case 1:
                login();
            case 2:
                studentRegistration();
            case 3:
                updatePassword();
            case 9:
                logger.info("logging out");
                break;
        }



    }


    public static void login() {

        String userId;
        String password;
        System.out.println("Enter UserId");
        scanner.nextLine();
        userId = scanner.nextLine();
        System.out.println("Enter Password");
        password = scanner.nextLine();


        AuthenticationHandler authenticationHandler = new AuthenticationHandler();
        String userType = authenticationHandler.callAuthService(userId, password) ;

        try {


            if (userType != null) {

                switch (userType) {
                    case "STUDENT"://student
//                    System.out.println(UserType.STUDENT);
//                    Student student = (Student) user;
//                    System.out.println("accessing student ========"+student.getStudentName());
                        StudentMenu studentMenu = new StudentMenu(userId);
                        studentMenu.enterStudentDashboard();

                        break;
                    case "PROFESSOR":

                        ProfessorMenu professorMenu = new ProfessorMenu();
                        // enterring prof menu
                        professorMenu.enterProfessorDashboard(userId);

                        break;


                }


            } else {
                System.out.println("invalid======");
            }


        } catch (CourseCapacityReached courseCapacityReached) {
            courseCapacityReached.printStackTrace();
        } catch (CourseNotFoundException e) {
            e.printStackTrace();
        } catch (RequiredCourseAdditionException e) {
            e.printStackTrace();
        } catch (CourseAlreadyRegisteredException e) {
            e.printStackTrace();
        }

    }

    public static void studentRegistration(){




    }

    public static void updatePassword(){



    }


}