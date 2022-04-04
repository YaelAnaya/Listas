public class DoublyLinkedList<T extends Comparable<T>> {
    private DoubleNode<T> inicio;
    private int size;

    public DoublyLinkedList() {
        inicio = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return inicio == null || size == 0;
    }

    public void insertarInicio(T elemento){
        var nuevoNodo = new DoubleNode<>(elemento, null, inicio);
        if (!isEmpty())
            inicio.setPrevious(nuevoNodo);
        inicio = nuevoNodo;
        size++;
    }

    public void insertarFin(T elemento){
        var nuevoNodo = new DoubleNode<>(elemento);
        if (isEmpty())
            inicio = nuevoNodo;
        else {
            var nodoAuxiliar = inicio;
            while (nodoAuxiliar.getNext() != null)
                nodoAuxiliar = (DoubleNode) nodoAuxiliar.getNext();

            nodoAuxiliar.setNext(nuevoNodo);
            nuevoNodo.setPrevious(nodoAuxiliar);
            size++;
        }
    }

    public T eliminarInicio(){
        T elementoEliminado = null;

        if (isEmpty()) {
            System.out.println("Lista vacía");
            return null;
        }
        else if (inicio.getNext() == null) {
            elementoEliminado = inicio.getElement();
            inicio = null;
            this.size--;
            return elementoEliminado;
        }

        elementoEliminado = inicio.getElement();
        inicio = (DoubleNode<T>) inicio.getNext();
        inicio.setPrevious(null);
        this.size--;
        return elementoEliminado;
    }

    public T eliminaFin(){
        T elementoEliminado = null;
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return null;
        }
        else if (inicio.getNext() == null) {
            elementoEliminado = inicio.getElement();
            inicio = null;
            this.size--;
            return elementoEliminado;
        }
        var nodoAuxiliar = inicio;
        while (nodoAuxiliar.getNext() != null)
            nodoAuxiliar = (DoubleNode<T>) nodoAuxiliar.getNext();

        elementoEliminado = nodoAuxiliar.getElement();
        nodoAuxiliar.getPrevious().setNext(null);
        this.size--;
        return elementoEliminado;
    }

    public String mostar(){
        var nodo = inicio;
        var cadena = "";

        if (inicio == null)
            return "Lista Vacía";

        while (nodo != null) {
            cadena += nodo.getElement().toString() + " -> ";
            nodo = (DoubleNode) nodo.getNext();
        }
        return cadena.substring(0, cadena.length() - 4);
    }

    public String mostrarRecursivo(){
        return recursivo(inicio);
    }

    private String recursivo(DoubleNode nodo){
        var cadena = " ";
        if (isEmpty())
            return "Lista vacía";
        while (nodo != null){
            cadena += nodo.getElement().toString() + " -> ";
            return cadena + recursivo((DoubleNode) nodo.getNext());
        }
        return cadena.substring(0, cadena.length() - 4);
    }


}
