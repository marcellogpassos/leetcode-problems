import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BstFromPreorderTest {

    private final BstFromPreorder instance = new BstFromPreorder();

    @Test
    void bstFromPreorder_example1() {
        final int[] preorder = {8, 5, 1, 7, 10, 12};
        final BstFromPreorder.TreeNode tree = this.instance.bstFromPreorder(preorder);
        assertEquals("8,5,1,7,10,null,12", tree.toString());
    }

    @Test
    void bstFromPreorder_example2() {
        final int[] preorder = {1, 3};
        final BstFromPreorder.TreeNode tree = this.instance.bstFromPreorder(preorder);
        assertEquals("1,null,3", tree.toString());
    }
}