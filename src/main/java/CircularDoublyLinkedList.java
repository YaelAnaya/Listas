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

    /**
     * Este método inserta un nodo al inicio de la lista.
     * */
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

    /**
     * Este método inserta un nodo al final de la lista.
     * */
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
    /**
     * Este método inserta un nodo con el elemento especificado en el index indicado.
     * */
    public void add(int index, T element) {
        // Se verifica que el index sea válido.
        if (index < 0 || index > size)
            System.out.println("Índice fuera de rango");

        // Si el índice es 0, se inserta al inicio.
        else if (index == 0)
            addFirst(element);

        // Si el índice es igual al tamaño de la lista, se inserta al final.
        else if (index == size)
            addLast(element);

        else {
            // Se recorre la lista hasta el índice.
            var currentNodeAtIndex = head;
            for (int i = 0; i < index; i++)
                currentNodeAtIndex = currentNodeAtIndex.getNext();
            // Se crea el nuevo nodo y se inserta en la lista.
            var newNode = new DoubleNode<>(element, currentNodeAtIndex, currentNodeAtIndex.getNext());
            currentNodeAtIndex.getNext().setPrevious(newNode);
            currentNodeAtIndex.setNext(newNode);
            size++;
        }
    }
    /**
     * Este método elimina el primer nodo de la lista.
     * */
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
            deletedElement = head.getElement();
            tail.setNext(head.getNext());
            head = head.getNext();
            head.setPrevious(tail);
        }
        size--;
        return deletedElement;
    }

    /**
     * Este método elimina el ulimo nodo de la lista.
     * */
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
            deletedElement = tail.getElement();
            var newLastNode = tail.getPrevious();
            newLastNode.setNext(head);
            head.setPrevious(newLastNode);
            tail = newLastNode;
        }
        size--;
        return deletedElement;
    }

    /**
     * Este método elimina el nodo que se encuentra
     * en la posición index (los indices comienzan en 0).
     * */
    public T removeAt(int index){
        // Se verifica que el índice sea válido.
        if (index < 0 || index > size - 1) {
            System.out.println("Índice fuera de rango");
            return null;
        }
        // Si el índice es 0, se elimina el primer elemento
        else if (index == 0)
            return removeFirst();
        // Si el índice es igual al tamaño - 1, se elimina el último elemento.
        else if (index == size - 1)
            return removeLast();

        else {
            // Se recorre la lista hasta llegar al nodo que se quiere eliminar.
            var currentNodeAtIndex = head;
            for (int i = 0; i < index; i++)
                currentNodeAtIndex = currentNodeAtIndex.getNext();

            // Se elimina el nodo.
            var deletedElement = currentNodeAtIndex.getElement();
            currentNodeAtIndex.getPrevious().setNext(currentNodeAtIndex.getNext());
            currentNodeAtIndex.getNext().setPrevious(currentNodeAtIndex.getPrevious());
            size--;
            return deletedElement;
        }
    }

    /**
     * Este método elimina el primer nodo
     * que contenga el elemento especificado.
     * */
    public T remove(T element){
        // Se verifica que la lista no esté vacía.
        if (search(element) != -1)
            // Se elimina el primer nodo que contenga el elemento especificado.
            return removeAt(search(element));

        // Si no se encuentra el elemento, se devuelve null.
        return null;
    }

    /**
     * Este método retorna el indice del primer
     * nodo que contenga el elemento especificado.
     * */
    public int search(T element){
        var auxiliarNode = head;
        // Se recorre la lista hasta encontrar el elemento especificado.
        for (int index = 0; index < this.size; index++, auxiliarNode = auxiliarNode.getNext())
            // Si se encuentra el elemento, se devuelve el índice.
            if (element.equals(auxiliarNode.getElement()))
                return index;

        // Si no se encuentra el elemento, se devuelve -1.
        System.out.println("Elemento [" + element + "] no encontrado");
        return -1;
    }

    /**
     * Este método ordena la lista en orden ascendente
     * utilizando el método de ordenamiento Selección.
     * */
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (getNodeAt(j).getElement().compareTo(getNodeAt(minIndex).getElement()) < 0)
                    minIndex = j;
            }
            swap(i, minIndex);
        }
    }

    /**
     * Este método intercambia los elementos
     * de los nodos que se encuentran en las posiciones i y j.
     * */
    public void swap(int i, int j) {
        T aux = getNodeAt(i).getElement();
        getNodeAt(i).setElement(getNodeAt(j).getElement());
        getNodeAt(j).setElement(aux);
    }

    /**
     * Este método retorna el nodo que se encuentra
     * en la posición index (los indices comienzan en 0).
     * */
    public DoubleNode<T> getNodeAt(int index) {
        var auxiliarNode = head;
        //
        if (index > 0 || index < this.size - 1) {
            for (int i = 0; i < index; i++)
                auxiliarNode = auxiliarNode.getNext();

            return auxiliarNode;
        }

        return null;
    }

    /**
     * Este método retorna el contenido de la lista
     * en forma de String.
     * */
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


    /**
     * Este método utiliza la recursividad para poder
     * retorna el contenido de la lista en forma de String.
     * */
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
