import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;

public class Question21 {

    //Name: Hunter Browning-Smith
    //Class: IT2660 - Data Structures & Algorithms
    //2020.09.27

    // Code an application program that keeps track of student information at your college: names, identification
    // numbers, and grade point averages in a fully encapsulated (homogenous) Sorted array-based data structure.
    // When launched, the user will be asked to input the maximum size of the data set, the initial number of students,
    // and the initial data set. Once this is complete, the user will be presented with the following menu:

    //Enter: 1 to insert a new student's information,
    //2 to fetch and output a student's information,
    //3 to delete a student's information,
    //4 to update a student's information,
    //5 to output all the student information in sorted order, and
    //6 to exit the program.

    public static void main(String[] args) {
        int n, sel, initial, newnum;
        boolean studentFound = false;
        boolean op1 = true;
        double newGPA;
        String aname, newIDNo, newName;
        //Array studentArray = new StudentListings()
        Scanner input = new Scanner(System.in);
        n = 0;
        sel = 0;
        System.out.println("Enter number of students");
        initial = input.nextInt();
        StudentListings[] studentlistings = new StudentListings[initial]; //creates a StudentListings array of size "initial"

        //initialize original set of students
        for (n = 0; n < initial; n++) {
            studentlistings[n] = new StudentListings();
            System.out.println("Enter a student name");
            aname = input.next();
            System.out.println("Enter an ID No for " + aname);
            newIDNo = input.next();
            System.out.println("Enter GPA for " + aname);
            newGPA = input.nextDouble();
            studentlistings[n].setName(aname);
            studentlistings[n].setID(newIDNo);
            studentlistings[n].setGPA(newGPA);

            System.out.println("number n" + n + "number initial" + initial);
        }

        while(op1) {

            System.out.println("Enter: 1 to insert a new student's information,\n" +
                    "    2 to fetch and output a student's information,\n" +
                    "    3 to delete a student's information,\n" +
                    "    4 to update a student's information,\n" +
                    "    5 to output all the student information in sorted order, and\n" +
                    "    6 to exit the program.");
            sel = input.nextInt();

            switch (sel) {
                case 1:
                    System.out.println("1");
                    StudentListings[] temp = new StudentListings[initial+1];
                    //create an array 1 size larger than original array

                    //copy the old array to new array
                    for(int m = 0; m < initial; m++) {
                        temp[m] = studentlistings[m];
                        System.out.println(studentlistings.length);
                        System.out.println(temp.length);
                    }

                    //capture new student information
                    System.out.println("Enter a student name");
                    aname = input.next();
                    System.out.println("Enter an ID No for " + aname);
                    newIDNo = input.next();
                    System.out.println("Enter GPA for " + aname);
                    newGPA = input.nextDouble();

                    //insert new student info into new array
                    temp[temp.length-1].setName(aname); //null pointer exception
                    temp[temp.length-1].setID(newIDNo);
                    temp[temp.length-1].setGPA(newGPA);

                    //make old array equal new array
                    studentlistings = temp;
                    break;

                case 2:
                    //fetch and output student's information
                    studentFound = false;
                    System.out.println("Enter a student name to fetch their information:");
                    newName = input.next();

                    for (int o = 0; o < studentlistings.length; o++) {
                        if (!studentFound) {
                            if (studentlistings[o].getName().equals(newName)) {
                                studentFound = true;
                                System.out.println("GPA for " + studentlistings[o].getName() + " is " + studentlistings[o].getGPA());
                                System.out.println("ID for " + studentlistings[o].getName() + " is " + studentlistings[o].getID());
                                break;
                            }
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student " + newName + " not found.");
                    }
                    break;

                case 3:
                    studentFound = false;
                    System.out.println("Enter a student name to delete their information:");
                    newName = input.next();

                    for (int o = 0; o < studentlistings.length; o++) {
                        if (!studentFound) {
                            if (studentlistings[o].getName().equals(newName)) {
                                studentFound = true;
                                studentlistings[o] = null;
                                System.out.println("Student information for " + newName + " deleted successfully.");
                                break;
                            }
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student " + newName + " not found.");
                    }
                    break;

                case 4:
                    studentFound = false;
                    System.out.println("Enter a student name to change their information:");
                    newName = input.next();

                    for (int o = 0; o < studentlistings.length; o++) {
                        if (!studentFound) {
                            if (studentlistings[o].getName().equals(newName)) {
                                studentFound = true;
                                System.out.println("Enter a student name");
                                aname = input.next();
                                System.out.println("Enter an ID No for " + aname);
                                newIDNo = input.next();
                                System.out.println("Enter GPA for " + aname);
                                newGPA = input.nextDouble();
                                studentlistings[o].setName(aname);
                                studentlistings[o].setID(newIDNo);
                                studentlistings[o].setGPA(newGPA);

                                System.out.println("Student information for " + newName + " deleted successfully.");
                                break;
                            }
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student " + newName + " not found.");

                    }
                    break;

                case 5:
                    StudentListings[] sortedstudentlistings = studentlistings.clone();
                    StudentListings oldStudent;
                    System.out.println("Sort by GPA");

                    for (int i = 0; i < studentlistings.length-1; i++) {
                        for (int o = 0; o < studentlistings.length-1; o++) {
                            if (sortedstudentlistings[o].getGPA() > sortedstudentlistings[o+1].getGPA()) {
                                oldStudent = sortedstudentlistings[o];
                                sortedstudentlistings[o] = sortedstudentlistings[o+1];
                                sortedstudentlistings[o+1] = oldStudent;

                            }
                        }
                    }
                    System.out.println("Students sorted by GPA:");
                    for (int o = 0; o < sortedstudentlistings.length; o++) {
                        System.out.println(sortedstudentlistings[o].toString());
                    }
                    break;

                case 6:
                    System.exit(0);
                    op1 = false;

                default:
                    System.out.println("Please choose from one of the following options:");
            }

        }


    }


}
