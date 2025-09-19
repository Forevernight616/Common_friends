public class Node {
    String name;
    LinkedList friends;
    Node next;

    Node (String name) {
        this.name = name;
        this.friends = new LinkedList();
        // this.next = next isnt needed because next is already assigned to itself
    }
    String name() {
        return this.name;
    }
    LinkedList get_friends() {
        return this.friends;
    }
    Node next() {
        return this.next;
    }

    public String toString() {
        String ending;
        if (this.next == null) {
            ending = "";
        } else {
            ending = "->";
        }

        StringBuilder friends_str = new StringBuilder();
        Node curr = this.get_friends().head;
        while (curr != null) {
            friends_str.append(curr.name).append(",");
            curr = curr.next;
        }

        return this.name + "-[" + friends_str + "]" + ending;
    }
}