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

        if (index < 0 || index > this.size - 1)
            System.out.println("Los subíndices de la lista deben estar en el rango: [0, " + (this.size - 1) + ")");

        else if (index == 0)
            addFirst(newElement);

        else if (index == this.size)
            addLast(newElement);

        else {
            Node<T> auxiliarNode = head;
            for (int i = 0; i < index - 1; i++)
                auxiliarNode = auxiliarNode.getNext();

            var oldNodeInPosition = auxiliarNode.getNext();
            auxiliarNode.setNext(newNode);
            newNode.setNext(oldNodeInPosition);
            size++;
        }

    }
    /*
     * Function to swap Nodes x and y in linked list by changing links
     */
    public void swapNodes(T firstElement, T secondElement) {
        // Nothing to do if firstElement and secondElement are same
        if (firstElement.equals(secondElement))
            return;

        // Search for firstElement (keep track of prevFirstElemenNode and CurrX)
        Node prevFirstElemenNode = null, currentFirstElemenNode = head;
        while (currentFirstElemenNode != null && !currentFirstElemenNode.getElement().equals(firstElement)) {
            prevFirstElemenNode = currentFirstElemenNode;
            currentFirstElemenNode = currentFirstElemenNode.getNext();
        }
        // Search for secondElement (keep track of prevSecondElemenNode and currentSecondElemenNode)
        Node prevSecondElemenNode = null, currentSecondElemenNode = head;
        while (currentSecondElemenNode != null && !currentSecondElemenNode.getElement().equals(secondElement)) {
            prevSecondElemenNode = currentSecondElemenNode;
            currentSecondElemenNode = currentSecondElemenNode.next;
        }

        // If either firstElement or secondElement is not present, nothing to do
        if (currentFirstElemenNode == null || currentSecondElemenNode == null)
            return;

        // If firstElement is not head of linked list
        if (prevFirstElemenNode != null)
            prevFirstElemenNode.setNext(currentSecondElemenNode);
        else // make secondElement the new head
            head = currentSecondElemenNode;

        // If secondElement is not head of linked list
        if (prevSecondElemenNode != null)
            prevSecondElemenNode.setNext(currentFirstElemenNode);
        else // make firstElement the new head
            head = currentFirstElemenNode;

        // Swap next pointers
        Node temp = currentFirstElemenNode.getNext();
        currentFirstElemenNode.setNext(currentSecondElemenNode.getNext());
        currentSecondElemenNode.setNext(temp);
    }

    public void shuffle() {
        Random random = new Random();
        // start from the end of the list
        for (int i = getSize() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapNodes(getAt(j), getAt(i));
        }
    }

    public void sortList(){
        quickSort(0, this.size - 1);
    }

    public void quickSort(int first, int last) {
        int i, j , center;
        T pivot;
        center = (first + last)/2;
        pivot = getAt(center);
        i = first;
        j = last;
        do {
            while (getAt(i).compareTo(pivot) < 0)
                i++;
            while (getAt(j).compareTo(pivot) > 0)
                j--;
            if (i <= j) {
                swapNodes(getAt(i), getAt(j));
                i++;
                j--;
            }
        }while (i <= j);

        if (first < j)
            quickSort(first, j);
        if (i < last)
            quickSort(i, last);

    }

    public void ordenarLista() {
        for (Node<T> current = head; current != null; current = current.getNext())
            for (Node<T> nextNode = head; nextNode.getNext() != null; nextNode = nextNode.getNext()){
                if (current.getElement().compareTo(nextNode.getElement()) < 0) {
                    T aux;
                    aux = current.getElement();
                    current.setElement(nextNode.getElement());
                    nextNode.setElement(aux);
                }
            }

    }
//
    public T removeAt(int index){

        if (index < 0 || index > this.size - 1) {
            System.out.println("Los subíndices de la lista deben estar en el rango: [0, " + (this.size - 1) + ")");
            return null;
        }
        if (index == 0)
            return removeFirst();

        if (index == this.size - 1)
            return removeLast();

        Node<T> nodeAtIndex = head;
        for (int i = 0; i < index - 1; i++)
            nodeAtIndex = nodeAtIndex.getNext();

        Node<T> auxiliarNode = nodeAtIndex.getNext();
        nodeAtIndex.setNext(auxiliarNode.getNext());
        size--;
        return auxiliarNode.getElement();

    }

    public T removeElement(T element) {
        if(search(element) != -1)
            return removeAt(search(element));

        System.out.println("Dato no encontrado");
        return null;
    }

    public T getAt(int index) {
        Node<T> auxiliarNode = head;
        if (index > 0 || index < this.size - 1) {
            for (int i = 0; i < index; i++)
                auxiliarNode = auxiliarNode.getNext();

            return auxiliarNode.getElement();
        }

        System.out.println("Dato no encontrado");
        return null;
    }


    public int search(T element) {
        Node<T> auxiliarNode = head;

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
