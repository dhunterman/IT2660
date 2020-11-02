public class Question19 {
    //Name: Hunter Browning-Smith
    //Class: IT2660 - Data Structures & Algorithms
    //2020.09.20

    // 19. A database is to be developed to keep track of student information at your college. It will include names,
    // identification numbers, and grade point averages. The data set will be accessed in the key field mode, with the
    // student's name being the key field. Code a class named StudentListings that defines the nodes. Your class should
    // include all the methods in the class shown in Figure 2.28 except for the setAddress() method. It should also include
    // a no-parameter constructor. Test it with a progressively developed driver program that verifies the functionality
    // of all of its methods.

    public static void main(String[] args) {
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
