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

    public void add(int index, T element) {
        if (index < 0 || index > size)
            System.out.println("Índice fuera de rango");

        else if (index == 0)
            addFirst(element);
        else if (index == size)
            addLast(element);
        else {
            var currentNodeAtIndex = head;
            for (int i = 0; i < index; i++)
                currentNodeAtIndex = currentNodeAtIndex.getNext();

            var newNode = new DoubleNode<>(element, currentNodeAtIndex, currentNodeAtIndex.getNext());
            currentNodeAtIndex.getNext().setPrevious(newNode);
            currentNodeAtIndex.setNext(newNode);
            size++;
        }
    }

    public T removeAt(int index){
        if (index < 0 || index > size - 1) {
            System.out.println("Índice fuera de rango");
            return null;
        }
        else if (index == 0)
            return removeFirst();

        else if (index == size - 1)
            return removeLast();

        else {
            var currentNodeAtIndex = head;
            for (int i = 0; i < index; i++)
                currentNodeAtIndex = currentNodeAtIndex.getNext();

            var deletedNode = currentNodeAtIndex.getNext();
            currentNodeAtIndex.setNext(deletedNode.getNext());
            deletedNode.getNext().setPrevious(currentNodeAtIndex);
            size--;
            return deletedNode.getElement();
        }
    }

    public T remove(T element){
        if (search(element) != -1)
            return removeAt(search(element));

        System.out.println("Dato no encontrado");
        return null;
    }

    public int search(T element){
        var auxiliarNode = head;

        for (int index = 0; index < this.size; index++) {
            if (element.equals(auxiliarNode.getElement()))
                return index;

            auxiliarNode = auxiliarNode.getNext();
        }
        System.out.println("Elemento [" + element + "] no encontrado");
        return -1;
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
            var auxiliarNode = head;
            for (int i = 0; i < index; i++)
                auxiliarNode = auxiliarNode.getNext();

            auxiliarNode.setElement(element);
        }
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
