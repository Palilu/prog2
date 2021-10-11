package ejercicio06;

/**
 * 6 - Árbol binario de búsqueda
 *
 * Un árbol binario es una estructura de datos formada por
 * nodos que contienen un determinado valor. El primer
 * elemento agregado a la estructura se conoce con el nombre
 * de “raíz” y es el único punto de acceso a la misma. Cada
 * nodo, puede tener un nodo “hijo” a su izquierda y un nodo
 * hijo a su derecha cumpliendo con la restricción que los
 * valores a su izquierda son valores menores que su propio valor, y los valores a su derecha son
 * valores mayores (no se almacenan valores repetidos). Los nodos sin hijos se conocen como
 * “hojas”. Normalmente, para facilitar el recorrido de la estructura, cada nodo tiene una
 * referencia a su nodo “padre”.
 * A. Implementar la funcionalidad para agregar un nuevo objeto a la estructura. Para poder
 * trabajar con cualquier objeto es necesario que el mismo pueda ser comparable, es
 * decir, implementar la interfaz Comparable de Java.
 * B. Implementar un método que permita recorrer la estructura en orden, es decir, todos los
 * elementos a la izquierda, luego la raíz y después todos los elementos a la derecha. Al
 * recorrer los elementos es necesario que se defina una acción la cual se va a ejecutar.
 * Para poder trabajar de forma transparente y que se pueda extender la funcionalidad
 * definir una interfaz AccionEjecutable. La misma posee un método public void
 * ejecutarNodo(Object nodo). Una posible implementación sería:
 * public class ImprimirEnPantalla implements AccionEjecutable {
 * public void ejecutarNodo(Object nodo) {
 * System.out.println(nodo.toString());
 * }
 * }
 *
 * ● Crear una acción que permita incorporar los elementos de forma ordenada
 * ascendentemente a un Vector.
 * ● Crear una acción que permita incorporar los elementos de forma ordenada
 * descendentemente a un Vector.
 * ● Crear una acción que cuente la cantidad de elementos visitados.
 */
public class Main {

    public static void main(String[] args) {
        SortedBinaryTreeNode root = new SortedBinaryTreeNode(13L);
        root.add(21l);
        root.add(5l);
        root.add(3l);
        root.add(8l);
        System.out.println(root);
        System.out.println("Ejecutando imprimir valores");
        root.execute(new PrintValueAction());
        // Crear una acción que permita incorporar los elementos de forma ordenada ascendentemente a un Vector.
        AddToVectorAction asc = new AddToVectorAction(Direction.ASC);
        root.execute(asc);
        System.out.println("El vector que agrega ordenado es " + asc.getVector());
        // Crear una acción que permita incorporar los elementos de forma ordenada descendentemente a un Vector.
        AddToVectorAction desc = new AddToVectorAction(Direction.DESC);
        root.execute(desc);
        System.out.println("El vector que agrega revertido es " + desc.getVector());
        // Crear una acción que cuente la cantidad de elementos visitados.
        CountNodesAction countNodesAction = new CountNodesAction();
        root.execute(countNodesAction);
        System.out.println("El arbol tiene " + countNodesAction.getNodes() + " nodos.");
    }
}
