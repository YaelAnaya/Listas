public class Node<T> {
    protected T element;
    protected Node<T> next;

    public Node(T element) {
        this.element = element;
        this.next = null;
    }

    public Node(T element, Node next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

//    public boolean compare(T value) {
//        return this.element.compareTo(value) > 0;
//    }

}
