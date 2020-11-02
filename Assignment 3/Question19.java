public class Question19 {
    //Name: Hunter Browning-Smith
    //Class: IT2660 - Data Structures & Algorithms
    //2020.09.27

    // 19. Expand the implementation of the class Stack presented in Figure 3.13 to include methods to: 
    // reinitialize the stack to empty, test for an empty stack (underflow condition), test for a full stack 
    // (overflow condition), and to perform a Peek operaiton. Include a progressively developed driver program 
    // to demonstrate the functionality of each new method.
    
    public static void main(String[] args) {
        Stack s = new Stack(3);
        Listing l;
        Listing l1 = new Listing("Hunter", "Dreamland Avenue", "69420");
        Listing l2 = new Listing("Damian", "Mountain Hell Drive", "666");
        Listing l3 = new Listing("Browning", "Hunting Lane", "334");
        Listing l4 = new Listing("Smith", "Raintree Boulevard", "72");
        // an attempt to pop an (empty) stack will return null
        System.out.println(s.pop());
        // perform three pushes to fill the stack and then output
        System.out.println(s.push(l1));
        System.out.println(s.push(l2));
        System.out.println(s.push(l3));
        // perform three pop operations to empty the stack
        l = s.pop();
        System.out.println(l.toString());
        l = s.pop();
        System.out.println(l.toString());
        l = s.pop();
        System.out.println(l.toString());
        // an attempt to perform a pop on an empty stack will return null
        l = s.pop();
        System.out.println(1);
        System.exit(0)
    }
}
