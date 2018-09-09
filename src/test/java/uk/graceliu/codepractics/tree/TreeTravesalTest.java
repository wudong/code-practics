package uk.graceliu.codepractics.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static uk.graceliu.codepractics.tree.TreeNode.*;

class TreeTravesalTest {

    private TreeNode<Integer> tree1;
    private TreeNode<Integer> tree2;
    private TreeNode<Integer> tree3;

    @BeforeEach
    void setUp() {
        //      1
        //   2    5
        //  3 4  6
        tree1 = from(1, from(2, from(3), from(4)), from(5, from(6)));
        //  1
        // 2
        //3
        tree2 = from(1, from(2, from(3)));

        // 1
        //  2
        //    3
        tree3 = from(1, null,  from(2, null, from(3)));
    }

    @Test
    void testInOrderTravesal() {
        List<Integer> integers = new TreeTravesal().inOder(tree1);
        assertEquals(Arrays.asList(3, 2, 4, 1, 6, 5), integers);

        List<Integer> integers2 = new TreeTravesal().inOder(tree2);
        assertEquals(Arrays.asList(3, 2, 1), integers2);

    }

    @Test
    void testInOrderTravesal2() {
        List<Integer> integers3 = new TreeTravesal().inOder(tree3);
        assertEquals(Arrays.asList(1,2,3), integers3);

    }

    @Test
    void testPreTravesal() {
        List<Integer> integers = new TreeTravesal().preOrder(tree1);
        assertEquals(Arrays.asList(1,2,3,4,5,6), integers);
    }

    @Test
    void testPostTravesal() {
        List<Integer> integers = new TreeTravesal().postOrder(tree1);
        assertEquals(Arrays.asList(3,4,2,6,5,1), integers);

        List<Integer> integers2 = new TreeTravesal().postOrder(tree2);
        assertEquals(Arrays.asList(3,2,1), integers2);


        List<Integer> integers3 = new TreeTravesal().postOrder(tree3);
        assertEquals(Arrays.asList(3,2,1), integers3);

    }
}