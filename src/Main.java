public class Main
{

    private static class Node {
        public String value;
        public Node next;
        public Node (String value) { this.value = value; }
    }

    private static Node startNode = null;

    private static void addToEnd(String item) {
        if (startNode == null){
            startNode = new Node(item);
        } else {
            Node endfinder = startNode;
            while(endfinder.next != null){
                endfinder = endfinder.next;
            }
            endfinder.next = new Node(item);
        }
    }

    private static String getAtPosition(int index) {
        if (startNode == null) { return "";}
        Node nodefinder = startNode;
        int counter = 0;
        while(counter < index){
            if (nodefinder.next == null)return "";
            nodefinder = nodefinder.next;
            counter++;
        }
        return nodefinder.value;
    }

    private static void insertAtPosition(int index, String item) {
        if (index == 0){
            Node newNode = new Node(item);
            newNode.next = startNode;
            startNode = newNode;
        }else {
            Node nodeFinder = startNode;
            int counter = 1;
            while (counter < index) {
                if (nodeFinder.next == null) return;
                nodeFinder = nodeFinder.next;
                counter++;
            }
            Node newNode = new Node(item);
            newNode.next = nodeFinder.next;
            nodeFinder.next = newNode;
        }

    }

    private static void removeAtPosition(int index) {
        Node nodeFinder = startNode;
        Node previousNode = null;
        int counter = 1;
        while (counter < index) {
            if (nodeFinder.next == null) return;
            previousNode = nodeFinder.next;
            nodeFinder = nodeFinder.next;
            counter++;
        }
        previousNode.next = nodeFinder.next;


    }

    private static int getLength() {
        if (startNode == null) { return 0;}
        int counter = 1;
        Node lastNodeFinder = startNode;
        while(lastNodeFinder.next != null){
            lastNodeFinder = lastNodeFinder.next;
            counter ++;
        }
        return counter;
    }

    private static void clearLinkedList() {
        startNode = null;
    }

    private static void printLinkedList() {
        Node node = startNode;
        while(node.next != null){
            System.out.println(node.value + ", ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addToEnd("super");
        addToEnd("cali");
        addToEnd("fragi");
        addToEnd("listic");
        addToEnd("expi");
        addToEnd("ali");
        addToEnd("docious");
        printLinkedList();

        removeAtPosition(2);
        removeAtPosition(2);
        printLinkedList();

        insertAtPosition(2, "foo");
        insertAtPosition(3, "bar");
        printLinkedList();

        insertAtPosition(0, "weeeeeeeelllll");
        printLinkedList();

    }
}
