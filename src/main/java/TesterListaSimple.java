public class TesterListaSimple {
    public static void main(String[] args) {


        var listaSimple = new SinglyLinkedList<Integer>();
        listaSimple.addFirst(1);
        listaSimple.addLast(20);
        listaSimple.addFirst(4);
        listaSimple.addFirst(7);
        listaSimple.add(2, 25);
        listaSimple.add(2, 7);

        System.out.println("\nBuscar(25): " + listaSimple.search(25));

        System.out.println("\nContenido: " + listaSimple.showList());
        System.out.println("- Número de nodos: " + listaSimple.getSize());

        System.out.println("\nEliminado (Inicio): " + listaSimple.removeFirst());


        System.out.println("\nEliminado (Fin): " + listaSimple.removeLast());


        System.out.println("\nContenido: " + listaSimple.showListRecursive());
        System.out.println("- Número de nodos: " + listaSimple.getSize());

        System.out.println("\nEliminar en posicion 2: " + listaSimple.removeAt(2));


        System.out.println("\nContenido: " + listaSimple.showListRecursive());
        System.out.println("- Número de nodos: " + listaSimple.getSize());

        System.out.println("\nEliminar en posicion 2: " + listaSimple.removeAt(2));


        System.out.println("\nContenido: " + listaSimple.showListRecursive());
        System.out.println("- Número de nodos: " + listaSimple.getSize());



//        listaSimple.shuffle();
//
//        System.out.println("\nContenido: " + listaSimple.showElementsRecursive());
//        System.out.println("- Número de nodos: " + listaSimple.getSize());
//
//        listaSimple.ordenarLista();
//        System.out.println("\nContenido: " + listaSimple.showElementsRecursive());
//        System.out.println("- Número de nodos: " + listaSimple.getSize());

    }
}
