import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;

public class trees {

    //Hunter Browning-Smith
    //ITC2660
    //Question 30: A database is to be developed to keep track of student information at your college.
    // Their names, identification numbers, and grade point averages will be included. The data set will be
    // accessed in the key field mode, with the student's name being the key field. Code a class named Listing that
    // defines the nodes. The class must comply with the guidelines that permit student information nodes to be stored
    // in the fully encapsulated BinaryTree structure discussed in this chapter. As such, your class should include all
    // the methods in the class shown in Figure 2.16 and include a getKey method. Test it with a progressively developed
    // driver program that demonstrates the functionality of all of its methods.

    //Question 31: Code an application program that keeps track of student information at your college. Include their
    // names, identification numbers, and grade point averages in a fully encapsulated, homogeneous, linked-based
    // binary search tree. When launched, the user will be presented with the following menu:
    //Enter: 1 to insert a new students information,
    //2 to fetch and output a student's information,
    //3 to delete a student's information,
    //4 to update a student's information,
    //5 to output all the student information in descending order, and
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
        //creates a StudentListings array of size "initial"
        StudentListings[] studentlistings = new StudentListings[initial];

        //initialize original set of students
        for (n = 0; n < initial; n++) {
            studentlistings[n] = new StudentListings();
            //System.out.println("Enter a student name");
            //aname = input.next();
            aname = "Hunter"+Integer.toString((int)(Math.pow(Math.random()*999999999,Math.random())));//Add numbers to "Hunter" to create unique names
            //need to alphabetize after
            //System.out.println("Enter an ID No for " + aname);
            //newIDNo = input.next();
            newIDNo = Integer.toString((int)(Math.random()*initial*1000)); //Create Unique ID No for each student
            //System.out.println("Enter GPA for " + aname);
            //newGPA = input.nextDouble();
            newGPA = Math.random()*4.0; //create random GPAs for each student
            studentlistings[n].setName(aname);
            studentlistings[n].setID(newIDNo);
            studentlistings[n].setGPA(newGPA);

            //System.out.println("number n" + n + "number initial" + initial);
        }

        BinarySLTree studentBST = new BinarySLTree();
        for (n = 0; n < initial; n++) {
            studentBST.addNode(studentlistings[n]);
        }

        //studentlistings = alphabetizedSL(studentlistings, studentlistings.length);
        //alphabetized order of student listings to save time

        //create the studentlistings name tree

        //create the descending order routine using the RNL traversal


        while(op1) {

            System.out.println("Enter: 1 to insert a new student's information,\n" +
                    "    2 to fetch and output a student's information,\n" +
                    "    3 to delete a student's information,\n" +
                    "    4 to update a student's information,\n" +
                    "    5 to output all the student information in sorted order based on GPA, and\n" +
                    "    6 to output all the student information in descending order based on name, and\n" +
                    "    7 to exit the program.");
            sel = input.nextInt();

            switch (sel) {
                case 1:
                    System.out.println("1");
                    StudentListings[] temp = new StudentListings[initial+1];
                    initial++;
                    //create an array 1 size larger than original array

                    //copy the old array to new array
                    for(int m = 0; m < initial-1; m++) {
                        temp[m] = studentlistings[m];
                        //System.out.println(studentlistings.length);
                        //System.out.println(temp.length);
                    }

                    //capture new student information
                    System.out.println("Enter a student name");
                    aname = input.next();
                    System.out.println("Enter an ID No for " + aname);
                    newIDNo = input.next();
                    System.out.println("Enter GPA for " + aname);
                    newGPA = input.nextDouble();

                    //insert new student info into new array
                    temp[temp.length-1] = new StudentListings(aname, newIDNo, newGPA);

                    //add BST node
                    studentBST.addNode(temp[temp.length-1]);

                    //make old array equal new array
                    studentlistings = temp;
                    break;

                case 2:
                    //fetch and output student's information
                    //studentFound = false;
                    System.out.println("Enter a student name to fetch their information:");
                    newName = input.next();
                    studentBST.searchNode(newName);

//                    for (int o = 0; o < studentlistings.length; o++) {
//                        if (!studentFound) {
//                            if (studentlistings[o].getName().equals(newName)) {
//                                studentFound = true;
//                                System.out.println("GPA for " + studentlistings[o].getName() + " is " + studentlistings[o].getGPA());
//                                System.out.println("ID for " + studentlistings[o].getName() + " is " + studentlistings[o].getID());
//                                break;
//                            }
//                        }
//                    }
//                    if (!studentFound) {
//                        System.out.println("Student " + newName + " not found.");
//                    }



                    break;

                case 3:
                    studentFound = false;
                    System.out.println("Enter a student name to delete their information:");
                    newName = input.next();
                    studentBST.deleteNode(newName);

                    for (int o = 0; o < studentlistings.length; o++) {
                        if (!studentFound) {
                            if (studentlistings[o].getName().equals(newName)) {
                                studentFound = true;
                                studentlistings[o] = null;
                                System.out.println("Student information for " + newName + " deleted successfully from array.");
                                initial = initial - 1;
                                break;
                            }
                        }
                    }

                    temp = new StudentListings[initial];
                    int count = 0;
                    for (int o = 0; o < initial+1; o++) {
                        if (studentlistings[o] != null) {
                            temp[count] = studentlistings[o];
                            count++;
                        }
                    }

                    studentlistings = temp;

                    studentBST = new BinarySLTree();
                    for (n = 0; n < initial; n++) {
                        studentBST.addNode(studentlistings[n]);
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

                                System.out.println("Student information for " + newName + " changed successfully.");
                                break;
                            }
                        }


                    }

                    studentBST = new BinarySLTree();
                    for (n = 0; n < initial; n++) {
                        studentBST.addNode(studentlistings[n]);
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
                    //capturing the information via the system output console
                    PrintStream previousConsole = System.out;
                    ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
                    System.setOut(new PrintStream(newConsole));
                    studentBST.traverseInOrder();
                    String RNL = newConsole.toString();
                    String[] arrayRNL = new String[initial];
                    arrayRNL = RNL.split("\\r\\n|\\n|\\r");
                    System.setOut(previousConsole);


                    StudentListings[] sl = studentlistings.clone();

                    System.out.println("Sort all student information in descending order of username");

                    for (int j = 0; j < initial; j++) {
                        for (int i = 0; i < initial; i++) {
                            if (arrayRNL[j].equals(studentlistings[i].getName())) {
                                sl[j] = studentlistings[i];

                            }
                        }
                    }

                    for (int i = 0; i < initial; i++) {
                        System.out.println("User name: " + sl[i].getName());
                        System.out.println("GPA: " + sl[i].getGPA());
                        System.out.println("ID: " + sl[i].getID());
                    }

                    break;


                case 7:
                    System.exit(0);
                    op1 = false;

                default:
                    System.out.println("Please choose from one of the following options:");
            }

        }

    }


    public static StudentListings[] alphabetizedSL(StudentListings[] sl, int len) {
        //len is number of students in sl
        StudentListings[] temp = new StudentListings[1];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String str1 = sl[i].getName();
                String str2 = sl[j].getName();
                if (str1.compareTo(str2) > 0) {
                    temp[0] = sl[i];
                    sl[i] = sl[j];
                    sl[j] = temp[0];
                }
            }
        }
        return sl;
    }

    public static class BinarySLTree {
        private StudentListings data;
        private BinarySLTree left;
        private BinarySLTree right;
        private boolean deletefound = false;

        public BinarySLTree() {
            this.data = null;
            this.left = null;
            this.right = null;
        }

        public BinarySLTree(StudentListings data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static BinarySLTree createTree(StudentListings content) {
            BinarySLTree bsltree = new BinarySLTree();
            if (content != null) {
                bsltree = new BinarySLTree();
                bsltree.addNode(content);
            }
            return bsltree;
        }

        public void addNode(StudentListings data) {
            if (this.data == null) {
                this.data = data;

            } else {
                if (this.data.getName().compareTo(data.getName()) < 0) {
                    if (this.left != null) {
                        this.left.addNode(data);

                    } else {
                        this.left = new BinarySLTree(data);
                    }

                } else {
                    if (this.right != null) {
                        this.right.addNode(data);

                    } else {
                        if (this.right != null) {
                            this.right.addNode(data);
                        } else {
                            this.right = new BinarySLTree(data);
                        }
                    }
                }
            }
        }

        public void searchNode(String value) {
            if(this != null) {
                if(this.data.getName().equals(value)) {
                    System.out.println(this.data.getName() + " found. GPA is " + this.data.getGPA() + " and User ID is " + this.data.getID());
                    return;
                } else {
                    if (this.left != null) {
                        this.left.searchNode(value);
                        if(this.data.getName().equals(value)) {
                            System.out.println(this.data.getName() + " found. GPA is " + this.data.getGPA() + " and User ID is " + this.data.getID());
                            return;
                        } else {
                            if (this.right != null) {
                                this.right.searchNode(value);
                                if(this.data.getName().equals(value)) {
                                    System.out.println(this.data.getName() + " found. GPA is " + this.data.getGPA() + " and User ID is " + this.data.getID());
                                    return;
                                } else {
                                    System.out.println("User name not found.");
                                    return;
                                }
                            }  else {
                                System.out.println("User name not found.");
                                return;
                            }
                        }
                    } else {
                        System.out.println("User name not found.");
                        return;
                    }
                }
            } else {
                System.out.println("User name not found.");
                return;
            }

        }

        public void deleteNode(String value) {
            if (!deletefound) {
                if(this != null) {
                    if(this.data.getName().equals(value)) {
                        this.data = null;
                        System.out.println("Student information for " + value + " deleted successfully from BST.");
                        return;
                    } else {
                        if (this.left != null) {
                            this.left.deleteNode(value);
                            if(this.data.getName().equals(value)) {
                                this.data = null;
                                System.out.println("Student information for " + value + " deleted successfully from BST.");
                                return;
                            } else {
                                if (this.right != null) {
                                    this.right.deleteNode(value);
                                    if(this.data.getName().equals(value)) {
                                        this.data = null;
                                        System.out.println("Student information for " + value + " deleted successfully from BST.");
                                        return;
                                    } else {
                                        return;
                                    }
                                }  else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                } else {

                    return;
                }
            } else {
                System.out.println("User name " + value + " not found.");
            }


        }

        public void traversePreOrder() {
            System.out.println(this.data.getName());
            if (this.left != null) {
                this.left.traversePreOrder();
            }
            if (this.right != null) {
                this.right.traversePreOrder();
            }
        }

        public void traverseInOrder() {
            if (this.left != null) {
                this.left.traverseInOrder();
            }
            System.out.println(this.data.getName());
            if (this.right != null) {
                this.right.traverseInOrder();
            }
        }

        public void traverseInOrderOpposite() {
            if (this.right != null) {
                this.right.traverseInOrderOpposite();
            }
            System.out.println(this.data.getName());
            if (this.left != null) {
                this.left.traverseInOrderOpposite();
            }
        }

        public void traversePostOrder() {
            if (this.left != null) {
                this.left.traversePostOrder();
            }
            if (this.right != null) {
                this.right.traversePostOrder();
            }
            System.out.println(this.data.getName());
        }


    }
}
