import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RebuildTree {

    public static void main(String[] args){
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        BinaryTreeNode binaryTreeNode = rebuildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        if (null == binaryTreeNode){
            System.out.println("cannot rebuild a tree");
        } else {
            binaryTreeNode.outPut();
            List<Integer> list = new ArrayList<>();
            binaryTreeNode.outPut(list);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static BinaryTreeNode rebuildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        // 小心数组越界
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length < 1 || preStart > preEnd || inStart > inEnd){
            return null;
        }

        /*
        * 前序遍历的首个节点为根节点
        * */
        int rootValue = preOrder[preStart];
        int inOrderRootNodeIndex = 0;
        for (int i = 0; i < inOrder.length; i++){
            if (inOrder[i] == rootValue){
                inOrderRootNodeIndex = i;
                break;
            }
        }

        BinaryTreeNode rootNode = new BinaryTreeNode(rootValue);
        rootNode.setLeftChild(rebuildTree(preOrder, preStart + 1, preStart + (inOrderRootNodeIndex - inStart), inOrder, inStart, inOrderRootNodeIndex - 1));
        rootNode.setRightChild(rebuildTree(preOrder, preStart + (inOrderRootNodeIndex - inStart) + 1, preEnd, inOrder, inOrderRootNodeIndex + 1, inEnd));
        return rootNode;
    }

}

class BinaryTreeNode{
    private int value;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void outPut(){
        postLoop(this);
    }

    // 后续遍历输出
    private void postLoop(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null){
            return;
        }
        postLoop(binaryTreeNode.leftChild);
        postLoop(binaryTreeNode.rightChild);
        System.out.println(binaryTreeNode.value);
    }

    public void outPut(List<Integer> list){
        postLoop(this, list);
    }

    private void postLoop(BinaryTreeNode binaryTreeNode, List<Integer> list) {
        if (binaryTreeNode == null){
            return;
        }
        postLoop(binaryTreeNode.leftChild, list);
        postLoop(binaryTreeNode.rightChild, list);
        list.add(binaryTreeNode.value);
    }
}
