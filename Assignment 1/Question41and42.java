import java.util.Scanner;

public class Question41and42 {
//Name: Hunter Browning-Smith
//Class: IT2660 - Data Structures & Algorithms
//2020.09.07

    public static void main(String[] args) {

        //question 41 - see Listing Public Class
        //testing follows:

        //default Listing initialization
        Listing aListing = new Listing();
        System.out.print(aListing);

        //Listing initialization with user inputs
        Listing anotherListing = new Listing(0,33,"Hunter");
        System.out.print(anotherListing.toString());

        //Listing input sub routine
        anotherListing.input();
        System.out.print(anotherListing.toString());

        //Testing setName, setAge, setPosition, getName, getAge, getPosition
        anotherListing.setName("New Name");
        anotherListing.setAge(666);
        anotherListing.setPosition(1);
        System.out.print("Name: " + anotherListing.getName() + "\n Age: " + anotherListing.getAge() + "\n Position: " + anotherListing.getPosition());

        //question 42

        int pos,anAge;
        String theName;
        //Created a "Listing" Class
        Listing[] Listings = new Listing[3]; //allocates 3 spaces for Listings object
        Listing[] ReverseListings = new Listing[3]; //allocates 3 spaces for ReverseListings object

        Scanner userInput = new Scanner(System.in);

        for(int i = 0; i<Listings.length; i++) {
            System.out.print("Please enter name for User " + i + ": ");
            theName = userInput.nextLine();

            System.out.print("Please enter age for " + theName +": ");

            anAge = userInput.nextInt();
            userInput.nextLine();
            Listings[i] = new Listing(i,anAge,theName);

            Listings[i] = new Listing(i,anAge,theName);
            System.out.print("Position " + i + " name is " + Listings[i].name + ". Position " + i + " number is " + Listings[i].age + ". \n");
        }

        //Reverse the order of user inputs by utilizing "ReverseListings"
        for(int i = 0; i<Listings.length; i++) {
            ReverseListings[i]=Listings[Listings.length-1-i];
        }

        //Print contents of ReverseListing
        for(int i = 0; i<Listings.length; i++) {
            //System.out.print("Position " + i + " name is " + ReverseListings[i].name + ". Position " + i + " number is " + ReverseListings[i].number + ".");
            System.out.print("Name: " + ReverseListings[i].name + ". Age: " + ReverseListings[i].age + ". \n");

        }

    }
}
