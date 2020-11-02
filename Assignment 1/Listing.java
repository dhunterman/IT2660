import java.util.Scanner;

public class Listing {
//Name: Hunter Browning-Smith
//Class: IT2660 - Data Structures & Algorithms
//2020.09.07

    int age;
    int position;
    String name;


    //assign default values
    public Listing()
    {
        position = 0;
        name = " ";
        age = 0;
    }

    //Provide the option to assign position, age, and name during initialization
    public Listing(int position, int number, String name) {
        this.position = position;
        this.age = number;
        this.name = name;
    }

    //return name and age as string
    public String toString()
    {
        return "Name: " + name + "\n Age: " + age + "\n Position: " + position + "\n";
    }


    public void input() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter name for User " + position + ": ");
        name = userInput.nextLine();

        System.out.print("Please enter age for " + name +": ");

        age = userInput.nextInt();
        userInput.nextLine();

    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPosition() {
        return position;
    }

}
