public class LinkedList {
    //Constructor
    Node head;

    // Doesnt need a constructor method because LinkedList() has no parameter

    public boolean is_empty() {return this.head == null;}
    public Node head() {return this.head;}

    public boolean have(String name) {
        Node curr = this.head;
        while (curr != null) {
            if (curr.name.equals(name)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public Node rm_from_hd() {
        Node rm_node;
        rm_node = this.head;
        this.head = rm_node.next;
        rm_node.next = null;
        return rm_node;
    }

    public Node get_element(String search_name) {
        Node curr = this.head;
        Node prev = null;
        while (curr != null && curr.name.compareTo(search_name) <= 0) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public Node get_name(String name) {
        Node curr = this.head;
        while (curr != null && !curr.name.equals(name)) {
            curr = curr.next;
        }
        return curr;
    }

    // add at the front
    public void add_f(Node curr) {
        curr.next = this.head;
        this.head = curr;
    }

    public void insert_after(Node nodeAtInsert, Node insertNode) {
        if (nodeAtInsert != null) {
            insertNode.next = nodeAtInsert.next;
            nodeAtInsert.next = insertNode;
        }
    }

    public void alpbtcl_sort () {
        LinkedList sorted = new LinkedList();

        if (this.head == null) {
            return ;
        }

        Node curr = this.head;
        if (sorted.head == null) {
            this.head = this.head.next();
            sorted.add_f(curr);
        }

        while (this.head != null) {
            curr = this.rm_from_hd();
            if (curr.name.compareTo(sorted.head.name()) < 0) {
                sorted.add_f(curr);
            } else {
                Node nodeAtInsert = sorted.get_element(curr.name());
                sorted.insert_after(nodeAtInsert, curr);
            }
        }
        this.head = sorted.head;
        sorted.head = null;
    }

    public void special_print() {
        if (this.head != null) {
            System.out.println("Friends in common: ");
        }
        Node curr = this.head;
        while (curr != null) {
            System.out.println(curr.name());
            curr = curr.next;
        }
    }

    public String printList() {
        Node curr = this.head;
        String result = "List -> ";
        while (curr != null) {
            result += curr.toString();
            curr = curr.next;
        }
        result += "]";
        return result;
    }

}