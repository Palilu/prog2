package ejercicio06;

public class CountNodesAction implements Action {

    private int nodes = 0;

    @Override
    public void execute(SortedBinaryTreeNode node) {
        nodes++;
    }

    public int getNodes() {
        return nodes;
    }
}
