public class DoublyLinkedList<T extends Comparable<T>> {
    private DoubleNode<T> head;
    private int size;

    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null || size == 0;
    }

    public void addFirst(T element){
        var firstNode = new DoubleNode<>(element, null, head);
        if (!isEmpty())
            head.setPrevious(firstNode);
        head = firstNode;
        size++;
    }

    public void addLast(T element){
        var lastNode = new DoubleNode<>(element);
        if (isEmpty())
            head = lastNode;
        else {
            var currentLastNode = head;
            while (currentLastNode.getNext() != null)
                currentLastNode = currentLastNode.getNext();

            currentLastNode.setNext(lastNode);
            lastNode.setPrevious(currentLastNode);
        }
        size++;
    }

    public T removeFirst(){
        T deletedElement;

        if (isEmpty()) {
            System.out.println("Lista vacía");
            return null;
        }
        else if (head.getNext() == null) {
            deletedElement = head.getElement();
            head = null;
        } else{
            deletedElement = head.getElement();
            head = head.getNext();
            head.setPrevious(null);
        }
        this.size--;
        return deletedElement;
    }

    public T removeLast(){
        T deletedElement;
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return null;
        }
        else if (head.getNext() == null) {
            deletedElement = head.getElement();
            head = null;
        }
        else {
            var currentLastNode = head;
            while (currentLastNode.getNext() != null)
                currentLastNode = currentLastNode.getNext();

            deletedElement = currentLastNode.getElement();
            currentLastNode.getPrevious().setNext(null);
        }
        this.size--;
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


    public String showListRecursive(){
        if (head == null)
            return "Lista vacia";
        else
            return recursive(head);
    }

    public String recursive(DoubleNode<T> node){
        String elements = "";

        if (node.getNext() == null)
            return elements + node.getElement();
        else
            return elements + node.getElement() + " -> " + recursive(node.getNext());
    }

    public String showList() {
        var auxiliarNode = head;
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
