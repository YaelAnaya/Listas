import java.util.Random;

public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T element) {
        head = new Node<>(element, head);
        size++;
    }

    public void addLast(T element) {
        var newNode = new Node<>(element);
        if (head == null) {
            newNode.setNext(null);
            head = newNode;
        }
        Node auxiliarNode = head;
        while (auxiliarNode.getNext() != null)
            auxiliarNode = auxiliarNode.getNext();

        auxiliarNode.setNext(newNode);
        newNode.setNext(null);
        size++;

    }

    public T removeFirst() {
        T deletedElement = head.getElement();
        if (head == null) {
            System.out.println("Lista Vacía");
            return null;
        }
        head = head.getNext();
        size--;
        return deletedElement;
    }

    public T removeLast() {
        T deletedElement;
        if (head == null) {
            System.out.println("Lista vacía");
            return null;
        }
        if (head.getNext() == null) {
            deletedElement = head.getElement();
            head = null;
        } else {
            var auxiliarNode = head;
            Node<T> previousNode = null;

            while (auxiliarNode.getNext() != null) {
                previousNode = auxiliarNode;
                auxiliarNode = auxiliarNode.getNext();
            }
            deletedElement = auxiliarNode.getElement();
            previousNode.setNext(null);
            size--;
        }
        return deletedElement;
    }

    public void add(int index, T newElement) {
        Node<T> newNode = new Node<T>(newElement);

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

    public String showListRecursive(){
        if (head == null)
            return "Lista vacia";
        else
            return recursive(head);
    }

    public String recursive(Node<T> node){
        String elements = "";

        if (node.getNext() == null)
            return elements + node.getElement();
        else
            return elements + node.getElement() + " -> " + recursive(node.getNext());
    }

    public String showList() {
        Node<T> auxiliarNode = head;
        var elements = " ";

        if (head == null)
            return "Lista Vacía";

        while (auxiliarNode != null) {
            elements += auxiliarNode.getElement() + " -> ";
            auxiliarNode = auxiliarNode.getNext();
        }
        return elements.substring(0, elements.length() - 4);
    }

}
