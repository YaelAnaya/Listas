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

    /**
     * Este método inserta un nodo al inicio de la lista.
     * */
    public void addFirst(T element) {
        head = new Node<>(element, head);
        size++;
    }
    /**
     * Este método inserta un nodo al final de la lista.
     * */
    public void addLast(T element) {
        var newNode = new Node<>(element);
        if (head == null) {
            newNode.setNext(null);
            head = newNode;
        }
         else {
            Node auxiliarNode = head;
            while (auxiliarNode.getNext() != null)
                auxiliarNode = auxiliarNode.getNext();

            auxiliarNode.setNext(newNode);
            newNode.setNext(null);
        }
        size++;

    }
    /**
     * Este método inserta un nodo con el elemento especificado en el index indicado.
     * */
    public void add(int index, T newElement) {
        // Se verifica que el índice sea válido.
        if (index < 0 || index > size)
            System.out.println("Índice fuera de rango");

        // Si el índice es 0, se inserta el nuevo nodo al inicio de la lista.
        else if (index == 0)
            addFirst(newElement);

        // Si el índice es igual al tamaño de la lista, se inserta el nuevo nodo al final de la lista.
        else if (index == size)
            addLast(newElement);

        // Si el índice es mayor a 0 y menor al tamaño de la lista, se inserta el nuevo nodo en el índice especificado.
        else {
            var newNode = new Node<>(newElement);
            var previousNodeAtIndex = head;
            // Se recorre la lista hasta llegar al nodo anterior al índice especificado.
            for (int i = 0; i < index - 1; i++)
                previousNodeAtIndex = previousNodeAtIndex.getNext();

            // Se inserta el nodo en la posición del índice especificado.
            var oldNodeAtIndex = previousNodeAtIndex.getNext();
            previousNodeAtIndex.setNext(newNode);
            newNode.setNext(oldNodeAtIndex);
            size++;
        }
    }
    /**
     * Este método elimina el primer nodo de la lista.
     * */
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
    /**
     * Este método elimina el último nodo de la lista.
     * */
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

    /**
     * Este método elimina el nodo en el índice especificado.
     * */
    public T removeAt(int index){
        // Se verifica que el índice sea válido.
        if (index < 0 || index > this.size - 1) {
            System.out.println("Índice fuera de rango");
            return null;
        }

        // Si el índice es 0, se elimina el primer nodo de la lista.
        else if (index == 0)
            return removeFirst();

        // Si el índice es igual al tamaño - 1 (último índice), se elimina el último nodo de la lista.
        else if (index == this.size - 1)
            return removeLast();

        var previousNodeAtIndex = head;
        // Se recorre la lista hasta llegar al nodo anterior del índice especificado.
        for (int i = 0; i < index - 1; i++)
            previousNodeAtIndex = previousNodeAtIndex.getNext();

        // Se elimina el nodo en la posición del índice especificado.
        Node<T> nodeAtIndex = previousNodeAtIndex.getNext();
        previousNodeAtIndex.setNext(nodeAtIndex.getNext());
        size--;
        return nodeAtIndex.getElement();

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
    private void swap(int i, int j) {
        T aux = getNodeAt(i).getElement();
        getNodeAt(i).setElement(getNodeAt(j).getElement());
        getNodeAt(j).setElement(aux);
    }

    /**
     * Este método retorna el nodo que se encuentra
     * en la posición index (los indices comienzan en 0).
     * */
    private Node<T> getNodeAt(int index) {
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
     * Este método utiliza la recursividad para poder
     * retorna el contenido de la lista en forma de String.
     * */
    public String showListRecursive(){
        if (head == null)
            return "Lista vacia";
        else
            return recursive(head);
    }

    private String recursive(Node<T> node){
        String elements = "";

        if (node.getNext() == null)
            return elements + node.getElement();
        else
            return elements + node.getElement() + " -> " + recursive(node.getNext());
    }

    /**
     * Este método retorna el contenido de la lista
     * en forma de String.
     * */
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
