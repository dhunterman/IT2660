import javax.swing.*;
import static javax.swing.JOptionPane.showInputDialog;
import java.util.Scanner;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class StudentListings {
//Name: Hunter Browning-Smith
//Class: IT2660 - Data Structures & Algorithms


    private String name;
    private String ID_number;
    private double GPA;
    Scanner input = new Scanner(System.in);

    public StudentListings() {
        //name = "Hunter";
        //ID_number = "69420";
        //GPA = 4.9;
    }

    public StudentListings(String n, String m, double o) {
        name = n;
        ID_number = m;
        GPA = o;
    }

    public String toString() {
        return("\nName is " + name +
                "\nIdentification number is " + ID_number +
                "\nGrade Point Average is " + GPA + "\n");

    }

    public int compareTo(String targetKey) {
        return(name.compareTo(targetKey));
    }

    public String getName() {
        return name;
    }

    public void setName(String aname) {
        name = aname;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(double newGPA) {
        GPA = newGPA;
    }

    public String getID() {
        return ID_number;
    }

    public void setID(String newID) {
        ID_number = newID;
    }

    public void input() {
        name = showInputDialog("Enter a name");
        ID_number = showInputDialog("Enter Identification number");
        System.out.println("Enter Grade Point Average");
        GPA = input.nextInt();

    }

    public StudentListings deepCopy() {
        StudentListings clone = new StudentListings();
        return clone;
    }


}