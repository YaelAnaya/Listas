public class TesterListaDoble {
    public static void main(String[] args) {
        var listaDoble = new DoublyLinkedList<Integer>();

        listaDoble.insertarInicio(2);
        listaDoble.insertarFin(1);
        listaDoble.insertarFin(3);
        listaDoble.insertarInicio(0);

        System.out.println("\nElementos: " + listaDoble.mostar() + "\t -> Nodos = " + listaDoble.getSize());

        System.out.println("\nElemento eliminado: " + listaDoble.eliminarInicio() + "\t -> Nodos = " + listaDoble.getSize());
        System.out.println("\nElemento eliminado: " + listaDoble.eliminaFin() + "\t -> Nodos = " + listaDoble.getSize());

        System.out.println("\nElementos: " + listaDoble.mostrarRecursivo() + "\t -> Nodos = " + listaDoble.getSize());

        while(!listaDoble.isEmpty())
            listaDoble.eliminarInicio();

        System.out.println("\nElementos: " + listaDoble.mostrarRecursivo() + "\t -> Nodos = " + listaDoble.getSize());
    }
}
