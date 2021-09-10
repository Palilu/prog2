package ejercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Pila de elementos
 * Implementar en Java una pila de elementos. A una pila se le pueden agregar elementos
 * utilizando el método push(Object o). Para retirar elementos de la pila se utiliza el método
 * pop(), que retorna el último elemento agregado y lo elimina de la misma. Es posible
 * consultar el tope de la pila sin eliminarlo utilizando el método top(). La mencionada
 * anteriormente es la única forma de consultar y retirar elementos de la pila, es decir, no se
 * pueden obtener ni consultar elementos de otra posición que no sea el tope de la pila. Definir
 * también los siguientes métodos:
 *  ● size(): retorna la cantidad de elementos almacenados
 *  ● copy(): retornar una nueva pila con una copia de los elementos de la pila original, en
 *            el mismo orden. La pila original debe mantener el orden de los elementos.
 *  ● reverse(): retorna una copia de la pila pero con los elementos en el orden inverso.
 */
public class Stack {

    private List<Object> elements = new ArrayList<>();

    public void push(Object element) {
        elements.add(element);
    }

    public Object pop() {
        Object last = top();
        if (last != null) {
            elements.remove(last);
        }
        return last;
    }

    public List<Object> copy(List<Object> original) {
        return new ArrayList<>(original);
    }

    public Object top() {
        return elements.size() > 0 ? elements.get(elements.size() - 1) : null;
    }

    public Integer size() {
        return elements.size();
    }

    public Stack copy() {
        Stack copy = new Stack();
        new ArrayList<>(elements) // Copy the list
                .forEach(element -> copy.push(element)); // Push each element to the new Stack
        return copy;
    }

    public Stack reverse() {
        Stack copy = new Stack();
        new ArrayList<>(elements).stream() // Copy the list
                .sorted(Collections.reverseOrder()) // Reverse it
                .forEach(element -> copy.push(element)); // Push each element to the new Stack
        return copy;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + elements +
                '}';
    }
}
