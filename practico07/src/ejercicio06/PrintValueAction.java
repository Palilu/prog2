package ejercicio06;

public class PrintValueAction implements Action {

    @Override
    public void execute(SortedBinaryTreeNode node) {
        System.out.println(node.getValue());
    }
}
