import java.util.Scanner;

public class Question20 {

    //Name: Hunter Browning-Smith
    //Class: IT2660 - Data Structures & Algorithms
    //2020.09.20

    //Code a class that implements the Sorted Array structure, and write a progressively developed driver program that
    // verifies the functionality of all of its methods. Assume that it is to store a data set whose nodes are described
    // in Exercise 19. Include error checking in the code of the basic operation methods, a constructor to permit the
    // client to specify the maximum size of the data set, and a method to display the contents of entire data set in
    // sorted order.



    public static void main(String[] args) {


        int n, i, j, temp;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the maximum number of elements to sort:");
        n = input.nextInt();

        int array[] = new int[n];

        System.out.println("Enter " + n + " Elements: ");

        for (i = 0; i < n; i++)
            array[i] = input.nextInt();

        //sorts based on integer values, from least to greatest
        for (i = 0; i < (n - 1); i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("Sorted elements :");

        for (i = 0; i < n; i++)
            System.out.println(array[i]); //Enter the maximum number of elements to sort: AASS Enter 5 Elements: 4 1 5 6 7 Sorted elements: BUILD SUCCESSFUL (total time:


        StudentListings aStudentListing = new StudentListings();
        System.out.print(aStudentListing);

        StudentListings anotherStudentListing = new StudentListings("Damian", "666", 1.7);
        System.out.print(anotherStudentListing);

        System.out.print(anotherStudentListing.toString());

        System.out.print(anotherStudentListing.compareTo("Hunter"));

        StudentListings oneMoreStudentListing = new StudentListings();
        oneMoreStudentListing.input();
        oneMoreStudentListing.toString();
        System.out.print(oneMoreStudentListing.compareTo(anotherStudentListing.getName()));

    }

}
