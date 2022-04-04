public class CircularDoublyLinkedList <T extends Comparable<T>>{
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return head == null && tail == null || size == 0;
    }

    public void addFirst(T element){
        var firstNode = new DoubleNode<T>(element);
        if(head == null){
            head = tail = firstNode;
            firstNode.setNext(head);
            firstNode.setPrevious(head);
        }
        else{
            firstNode.setNext(head);
            head.setPrevious(firstNode);
            head = firstNode;
            tail.setNext(head);
            firstNode.setPrevious(tail);
        }
        size++;
    }

    public void addLast(T element){
        var lastNode = new DoubleNode<T>(element);
        if (head == null){
            head = tail = lastNode;
            lastNode.setNext(head);
            lastNode.setPrevious(head);
        }
        else{
            lastNode.setNext(head);
            head.setPrevious(lastNode);
            tail.setNext(lastNode);
            lastNode.setPrevious(tail);
            tail = lastNode;
        }
        size++;
    }

    public T removeFirst(){
        T deletedElement = null;
        if (head == null){
            System.out.println("Lista vacía");
            return null;
        }
        else if (head == tail){
            deletedElement = head.getElement();
            head = tail = null;
        }
        else {
            tail.setNext(head.getNext());
            head = head.getNext();
            head.setPrevious(tail);
        }
        size--;
        return deletedElement;
    }

    public T removeLast(){
        T deletedElement = null;
        if (head == null){
            System.out.println("Lista vacía");
            return null;
        }
        else if (head == tail){
            deletedElement = head.getElement();
            head = tail = null;
        }
        else {
            var newLastNode = tail.getPrevious();
            newLastNode.setNext(head);
            head.setPrevious(newLastNode);
            tail = newLastNode;
        }
        size--;
        return deletedElement;
    }


    public String showList(){
        var temp = head;
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

    private String recursive(DoubleNode<T> node){
        String elements = "";

        if (node.getNext() == head)
            return elements + node.getElement();
        else
            return elements + node.getElement() + " -> " + recursive(node.getNext());
    }


}
