import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String user_input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static LinkedList process_input(String file_input ) {

        LinkedList friends_ll = new LinkedList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file_input));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                String person1 = parts[0];
                String person2 = parts[1];

                //add person1 to the ll and person2 to person1s friends list
                if (!friends_ll.have(person1)) {
                    friends_ll.add_f(new Node(person1));
                }
                //in friends_ll, get the node person1, in LinkedList person1, create new node that is person2
                friends_ll.get_name(person1).get_friends().add_f(new Node(person2));
                if (!friends_ll.have(person2)) {
                    friends_ll.add_f(new Node(person2));
                }
                friends_ll.get_name(person1).get_friends().add_f(new Node(person2));

                System.out.println(friends_ll.printList());
            }


            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return friends_ll;
    }

    public static LinkedList common_friend(String name1, String name2, LinkedList friends_ll){
        //Get the node of the name1s first friend
        Node name1_curr = friends_ll.get_name(name1).get_friends().head();

        LinkedList common_ll = new LinkedList();

        //go through every name1s friends
        while (name1_curr != null) {
            Node name2_curr = friends_ll.get_name(name2).get_friends().head();
            // for each name1 friend, go through every name2s friends to check
            while (name2_curr != null) {
                if (name1_curr.name().equals(name2_curr.name()) ){
                    common_ll.add_f(new Node(name1_curr.name()));
                }
                name2_curr = name2_curr.next();
            }
            name1_curr = name1_curr.next();
        }
        return common_ll;
    }



    public static void main(String[] args) {
        String file_input = "in10.txt";
        String name1 = "William";
        String name2 = "Abigail";

        LinkedList friends_ll = process_input(file_input);
        System.out.println(friends_ll.printList());

        if (friends_ll.have(name1) && friends_ll.have(name2)) {
            LinkedList common_friend_ll = common_friend(name1,name2, friends_ll);
            common_friend_ll.alpbtcl_sort();
            System.out.println(common_friend_ll.printList());
            common_friend_ll.special_print();
        } else {
            System.out.println("ERROR");
        }
    }

}

