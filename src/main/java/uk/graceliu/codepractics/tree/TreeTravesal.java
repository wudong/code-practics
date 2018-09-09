package uk.graceliu.codepractics.tree;

import java.util.*;

public class TreeTravesal {

    static enum Order {
        Pre,
        In,
        Post
    }

    public <T> List<T> preOrder(TreeNode<T> tree){
        ArrayList<T> ts = new ArrayList<>();
        //recursiveTravel(tree, ts, Order.Pre);
        iterativePreOrder(tree, ts);
        return ts;
    }

    public <T> List<T> inOder(TreeNode<T> tree){
        ArrayList<T> ts = new ArrayList<>();
        //recursiveTravel(tree, ts, Order.In);
        iterativeInOrder(tree, ts);
        return ts;
    }

    public <T> List<T> postOrder(TreeNode<T> tree){
        ArrayList<T> ts = new ArrayList<>();
      //  recursiveTravel(tree, ts, Order.Post);
        iterativePostOrder(tree, ts);
        return ts;
    }


    public <T> void iterativePreOrder(TreeNode<T> tree, List<T> ts){
        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.push(tree);

        while(!stack.isEmpty()){
            TreeNode<T> pop = stack.pop();
            ts.add(pop.node);
            if (pop.right!=null) stack.push(pop.right);
            if (pop.left!=null) stack.push(pop.left);
        }
    }

    static class InOrderStackItem<T>{
        TreeNode<T> node;
        boolean  pushed = false;


        public InOrderStackItem(TreeNode<T> node) {
            this.node = node;
        }

    }

    public <T> void iterativeInOrder(TreeNode<T> tree, List<T> ts){
        Deque<InOrderStackItem<T>> stack = new LinkedList<>();
        stack.push(new InOrderStackItem<>(tree));

        while(!stack.isEmpty()) {
            InOrderStackItem<T> pop = stack.pop();

            TreeNode<T> node = pop.node;

            if (pop.node.left == null && pop.node.right == null) {
                ts.add(pop.node.node);
            } else {
                if (pop.pushed){ // its left has already been checked.. This is important!
                                 // it is basically set the stage of before/after the recursive call.
                                 //  https://www.codeproject.com/Articles/418776/How-to-replace-recursive-functions-using-stack-and
                    ts.add(pop.node.node);
                    if (pop.node.right!=null){
                        stack.push(new InOrderStackItem<>(node.right));
                    }
                }else{
                    if (node.left != null) {
                        pop.pushed = true;
                        stack.push(pop);
                        stack.push(new InOrderStackItem<>(node.left));
                    }else if (node.right!=null){
                        pop.pushed = true;
                        stack.push(pop);
                    }
                }

            }
        }

    }

    static class PostOrderStackItem<T>{
        public boolean parentPoped;
        TreeNode<T> node;


        public PostOrderStackItem(TreeNode<T> node) {
            this.node = node;
        }

    }

    public <T> void iterativePostOrder(TreeNode<T> tree, List<T> ts) {
        Deque<PostOrderStackItem<T>> stack = new LinkedList<>();
        stack.push(new PostOrderStackItem<T>(tree));

        while (!stack.isEmpty()) {
            PostOrderStackItem<T> pop = stack.pop();
            if (pop.parentPoped){
                ts.add(pop.node.node);
            }else{
                if (pop.node.left==null && pop.node.right ==null){
                    ts.add(pop.node.node);
                }else{
                    pop.parentPoped = true;
                    stack.push(pop);
                    if (pop.node.right!=null){
                        stack.push(new PostOrderStackItem<>(pop.node.right));
                    }
                    if (pop.node.left!=null){
                        stack.push(new PostOrderStackItem<>(pop.node.left));
                    }
                }
            }
        }
    }

    private <T> void recursiveTravel(TreeNode<T> tree, ArrayList<T> ts, Order order) {
        if (order==Order.Pre){
            ts.add(tree.node);
        }else{
            if (tree.left!=null){
                recursiveTravel(tree.left, ts, order);
            }
        }

        if (order==Order.In){
            ts.add(tree.node);
        }else if (order==Order.Pre){
            if (tree.left!=null){
                recursiveTravel(tree.left, ts, order);
            }
        }else{
            if (tree.right!=null){
                recursiveTravel(tree.right, ts, order);
            }
        }

        if (order==Order.Post){
            ts.add(tree.node);
        }else{
            if (tree.right!=null){
                recursiveTravel(tree.right, ts, order);
            }
        }
    }



}
