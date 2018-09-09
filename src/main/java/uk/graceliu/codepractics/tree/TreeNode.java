package uk.graceliu.codepractics.tree;

public class TreeNode<T> {

    T node;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T node, TreeNode<T> left, TreeNode<T> right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }

    public static <T> TreeNode<T> from(T node, TreeNode<T> left, TreeNode<T> right){
        return new TreeNode(node, left, right);
    }


    public static <T> TreeNode<T> from(T node, TreeNode<T> left){
        return new TreeNode(node, left, null);
    }

    public static <T> TreeNode<T> from(T node){
        return new TreeNode(node, null, null);
    }

    public static <T> TreeNode<T> from(T node, T left, T right){
        return new TreeNode(node, from(left), from(right));
    }

    public static <T> TreeNode<T> from(T node, T left){
        return from(node, from(left));
    }

}
