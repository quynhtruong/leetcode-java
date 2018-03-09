package programming.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumMatrix {
    class Node {
        private int x, y, u, v, sum;
        private List<Node> children;

        public Node(int x, int y, int u, int v) {
            this.x = x;
            this.y = y;
            this.u = u;
            this.v = v;
            this.sum = 0;
            this.children = new ArrayList<>();
        }

        public void addChild(Node node) {
            this.children.add(node);
        }
    }

    private Node root;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        root = buildTree(0, 0, m - 1, n - 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(root, i, j, matrix[i][j]);
            }
        }
    }

    private Node buildTree(int x, int y, int u, int v) {
        if (x > u || y > v) return null;
        Node node = new Node(x, y, u, v);
        if (x == u && y == v) return node;
        int midX = (x + u) / 2;
        int midY = (y + v) / 2;
        node.addChild(buildTree(x, y, midX, midY));
        if (midX < u) node.addChild(buildTree(midX + 1, y, u, midY));
        if (midY < v) node.addChild(buildTree(x, midY + 1, midX, v));
        if (midX < u && midY < v) node.addChild(buildTree(midX + 1, midY + 1, u, v));
        return node;
    }

    private void update(Node node, int i, int j, int val) {
        if (node == null) return;
        node.sum += val;
        for (Node child : node.children) {
            if (child.x <= i && child.y <= j && child.u >= i && child.v >= j) {
                update(child, i, j, val);
            }
        }
    }

    public void update(int row, int col, int val) {
        update(root, row, col, val);
    }


    private int sumRegion(Node node, int x, int y, int u, int v) {
        if (node.x > u || node.y > v && node.u < x || node.v < y) return 0;
        if (node.x >= x && node.u <= u && node.y >= y && node.v <= v)
            return node.sum;
        int result = 0;
        for (Node child : node.children) {
            result += sumRegion(child, x, y, u, v);
        }
        return result;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(root, row1, col1, row2, col2);
    }

}
