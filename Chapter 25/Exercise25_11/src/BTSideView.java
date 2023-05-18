import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTSideView extends Pane {

    private BST<Integer> tree;
    private double radius = 15; // Tree node radius
    private double hGap = 50; // Gap between nodes horizontally

    BTSideView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            double x = radius * 2;
            double y = getHeight() / 2;
            displayTree(tree.getRoot(), x, y, hGap);
        }
    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(BST.TreeNode<Integer> root, double x, double y, double vGap) {
        if (root.left != null) {
            // Draw a line to the left child node
            getChildren().add(new Line(x + vGap, y + hGap, x, y));
            // Draw the left subtree recursively
            displayTree(root.left, x + vGap, y + hGap, vGap / 2);
        }

        if (root.right != null) {
            // Draw a line to the right child node
            getChildren().add(new Line(x + vGap, y - hGap, x, y));
            // Draw the right subtree recursively
            displayTree(root.right, x + vGap, y - hGap, vGap / 2); 
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - radius / 2, y + radius / 2, root.element + ""));
    }
}