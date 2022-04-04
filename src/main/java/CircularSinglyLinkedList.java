public class CircularSinglyLinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CircularSinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public void addFirst(T element){
        Node<T> firstNode = new Node(element);
        if (head == null){
            head = tail = firstNode;
            firstNode.setNext(head);
        } else {
            firstNode.setNext(head);
            head = firstNode;
            tail.setNext(head);
        }
        size++;
    }

    public void addLast(T element){
        Node<T> lastNode = new Node(element);
        if (head == null){
            head = tail = lastNode;
            lastNode.setNext(head);
        } else {
            tail.setNext(lastNode);
            tail = lastNode;
            tail.setNext(head);
        }
        size++;
    }

    public T removeFirst(){
        T deletedElement = null;
        if (head == null){
            System.out.printf("Lista Vacia");
            return null;
        } else if (head == tail)
            head = tail = null;
        else{
            deletedElement = head.getElement();
            head = head.getNext();
            tail.setNext(head);

        }
        return deletedElement;
    }

    public T removeLast(){
        T deletedElement = null;
        if (head == null){
            System.out.printf("Lista Vacia");
            return null;
        } else if (head == tail)
            head = tail = null;
        else{
            Node<T> current = head;

            while(current.getNext() != tail)
                current = current.getNext();

            deletedElement = (T) current.getNext().getElement();
            tail = current;
            tail.setNext(head);

        }
        return deletedElement;
    }

    public String showList(){
        Node<T> temp = head;
        var elements = "";
        if (head == null)
            return "Lista Vacia";
        do {
            elements += temp.getElement() + " -> ";
            temp = temp.getNext();
        } while (temp != head);
        return elements.substring(0, elements.length() - 4);
    }

    public String showListRecursive(){
        if (head == null)
            return "Lista vacia";
        else
            return recursive(head);
    }

    public String recursive(Node<T> node){
        String elements = "";

        if (node.getNext() == head)
            return elements + node.getElement();
        else
            return elements + node.getElement() + " -> " + recursive(node.getNext());
    }
}
