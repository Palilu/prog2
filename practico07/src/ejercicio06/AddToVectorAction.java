package ejercicio06;

import java.util.Vector;

/**
 * Vector WTF!!!
 */
public class AddToVectorAction implements Action {

    private Vector<Comparable> vector;
    private Direction direction;

    public AddToVectorAction(Direction direction) {
        this.vector = new Vector<>();
        this.direction = direction;
    }

    @Override
    public void execute(SortedBinaryTreeNode node) {
        switch (direction) {
            case ASC:
                vector.add(node.getValue());
                break;
            case DESC:
                vector.add(0, node.getValue());
                break;
            default:
                break;
        }
    }

    public Vector<Comparable> getVector() {
        return new Vector<>(vector);
    }
}
