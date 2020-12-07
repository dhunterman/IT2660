import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;

public class Assignment4 {

    //Name: Hunter Browning-Smith
    //Class: IT2660 - Data Structures & Algorithms
    //LinkedLists

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
        String aname, newIDNo, newName;
        double newGPA;
        Scanner input = new Scanner(System.in);
        n = 0;
        sel = 0;
        System.out.println("Enter number of students");
        initial = input.nextInt();
        LinkedList<StudentListings> studentlistings = new LinkedList<StudentListings>();

        //initialize original set of students
        StudentListings studentListings = new StudentListings();
        for (n = 0; n < initial; n++) {

            //System.out.println("Enter a student name");
            //aname = input.next();
            aname = "Hunter"+Integer.toString((int)(Math.pow(Math.random()*999999999,Math.random())));//Add numbers to "Hunter" to create unique names
            //System.out.println("Enter an ID No for " + aname);
            //newIDNo = input.next();
            newIDNo = Integer.toString((int)(Math.random()*initial*1000));
            //System.out.println("Enter GPA for " + aname);
            //newGPA = input.next();
            newGPA = Math.random()*4.0;
            studentlistings.add(new StudentListings(aname, newIDNo, newGPA));
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

                    //capture new student information
                    System.out.println("Enter a student name");
                    aname = input.next();
                    System.out.println("Enter an ID No for " + aname);
                    newIDNo = input.next();
                    System.out.println("Enter GPA for " + aname);
                    newGPA = Double.parseDouble(input.next());

                    studentListings = new StudentListings(aname, newIDNo, newGPA);
                    studentlistings.add(studentListings);

                    break;

                case 2:
                    //fetch and output student's information
                    studentFound = false;
                    System.out.println("Enter a student name to fetch their information:");
                    newName = input.next();


                    for (int o = 0; o < studentlistings.size(); o++) {
                        if (!studentFound) {
                            if (studentlistings.get(o).getName().equals(newName)) {
                                studentFound = true;
                                System.out.println("GPA for " + studentlistings.get(o).getName() + " is " + studentlistings.get(o).getGPA());
                                System.out.println("ID for " + studentlistings.get(o).getName() + " is " + studentlistings.get(o).getID());
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

                    for (int o = 0; o < studentlistings.size(); o++) {
                        if (!studentFound) {
                            if (studentlistings.get(o).getName().equals(newName)) {
                                studentFound = true;
                                studentlistings.remove(o);
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

                    for (int o = 0; o < studentlistings.size(); o++) {
                        if (!studentFound) {
                            if (studentlistings.get(o).getName().equals(newName)) {
                                studentFound = true;
                                System.out.println("Enter a student name");
                                aname = input.next();
                                System.out.println("Enter an ID No for " + aname);
                                newIDNo = input.next();
                                System.out.println("Enter GPA for " + aname);
                                newGPA = Double.parseDouble(input.next());
                                studentlistings.get(o).setName(aname);
                                studentlistings.get(o).setID(newIDNo);
                                studentlistings.get(o).setGPA(newGPA);

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
                    System.out.println("Sort by GPA");
                    Collections.sort(studentlistings);
                    for (int o = 0; o < studentlistings.size(); o++) {
                        System.out.println(o);
                        System.out.println(studentlistings.get(o));
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
