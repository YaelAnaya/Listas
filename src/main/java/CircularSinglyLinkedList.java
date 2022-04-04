public class CircularSinglyLinkedList<T extends Comparable<T>>{
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

    public boolean isEmpty(){
        return head == null && tail == null || size == 0;
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
            System.out.println("Lista Vacia");
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
            System.out.println("Lista Vacia");
            return null;
        } else if (head == tail)
            head = tail = null;
        else{
            var current = head;

            while(current.getNext() != tail)
                current = current.getNext();

            deletedElement = (T) current.getNext().getElement();
            tail = current;
            tail.setNext(head);

        }
        return deletedElement;
    }
    public void add(int index, T newElement) {
        var newNode = new Node<T>(newElement);

        if (index < 0 || index > size)
            System.out.println("Índice fuera de rango");

        else if (index == 0)
            addFirst(newElement);

        else if (index == size)
            addLast(newElement);

        else {
            var previousNodeAtIndex = head;
            for (int i = 0; i < index - 1; i++)
                previousNodeAtIndex = previousNodeAtIndex.getNext();

            var oldNodeAtIndex = previousNodeAtIndex.getNext();
            previousNodeAtIndex.setNext(newNode);
            newNode.setNext(oldNodeAtIndex);
            size++;
        }

    }

    // sort the list using the direct selection algorithm
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (getAt(j).compareTo(getAt(minIndex)) < 0)
                    minIndex = j;
            }
            swap(i, minIndex);
        }
    }

    public void swap(int i, int j) {
        T aux = getAt(i);
        setAt(i, getAt(j));
        setAt(j, aux);
    }

    public void setAt(int index, T element) {
        if (index < 0 || index > this.size - 1)
            System.out.println("Los subíndices de la lista deben estar en el rango: [0, " + (this.size - 1) + ")");

        else {
            Node<T> auxiliarNode = head;
            for (int i = 0; i < index; i++)
                auxiliarNode = auxiliarNode.getNext();

            auxiliarNode.setElement(element);
        }
    }


    public T removeAt(int index){

        if (index < 0 || index > this.size - 1)
            System.out.println("Índice fuera de rango");

        if (index == 0)
            return removeFirst();

        if (index == this.size - 1)
            return removeLast();

        var previousNodeAtIndex = head;
        for (int i = 0; i < index - 1; i++)
            previousNodeAtIndex = previousNodeAtIndex.getNext();

        Node<T> nodeAtIndex = previousNodeAtIndex.getNext();
        previousNodeAtIndex.setNext(nodeAtIndex.getNext());
        size--;
        return nodeAtIndex.getElement();

    }

    public T removeElement(T element) {
        if(search(element) != -1)
            return removeAt(search(element));

        System.out.println("Dato no encontrado");
        return null;
    }

    public T getAt(int index) {
        var auxiliarNode = head;
        if (index > 0 || index < this.size - 1) {
            for (int i = 0; i < index; i++)
                auxiliarNode = auxiliarNode.getNext();

            return auxiliarNode.getElement();
        }

        System.out.println("Dato no encontrado");
        return null;
    }


    public int search(T element) {
        var auxiliarNode = head;

        for (int index = 0; index < this.size; index++) {
            if (element.equals(auxiliarNode.getElement()))
                return index;

            auxiliarNode = auxiliarNode.getNext();
        }
        System.out.println("Elemento [" + element + "] no encontrado");
        return -1;
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

    private String recursive(Node<T> node){
        String elements = "";

        if (node.getNext() == head)
            return elements + node.getElement();
        else
            return elements + node.getElement() + " -> " + recursive(node.getNext());
    }
}
