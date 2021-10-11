package ejercicio06;

import java.util.Optional;

public class SortedBinaryTreeNode {

    private Comparable value;
    private Optional<SortedBinaryTreeNode> left;
    private Optional<SortedBinaryTreeNode> right;

    public SortedBinaryTreeNode(Comparable value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        this.value = value;
        this.left = Optional.empty();
        this.right = Optional.empty();
    }

    public void add(Comparable value) {
        int diff = value.compareTo(this.value);
        if(diff == 0) { // Si son iguales
            // No voy a guardar repetidos
            return;
        } else if (diff < 0) { // Si es menor
            if (left.isEmpty()) { // Si la izquierda está vacia
                left = Optional.of(new SortedBinaryTreeNode(value)); // Creo un nodo
            } else { // Sino
                left.get().add(value); // Lo agrego a la izquierda
            }
        } else { // Si es mayor
            if (right.isEmpty()) { // Si la derecha está vacia
                right = Optional.of(new SortedBinaryTreeNode(value)); // Creo un nodo
            } else { // Sino
                right.get().add(value); // Lo agrego a la derecha
            }
        }
    }

    public void execute(Action action) {
        executeChild(action, this.left);
        action.execute(this);
        executeChild(action, this.right);
    }

    public void executeChild(Action action, Optional<SortedBinaryTreeNode> child) {
        if (child.isPresent()) {
            child.get().execute(action);
        }
    }

    public Comparable getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SortedBinaryTreeNode{" +
                "\nvalue=" + value +
                "\n, left=" + left +
                "\n, right=" + right +
                "\n}";
    }
}
