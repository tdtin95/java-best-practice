package vn.tdtin.java.practice;

import java.util.Optional;
import java.util.stream.Stream;

public class BadOrElse {

    private static class Node {
        private Node parentNode;
        private boolean isBadNode;
        private String nodeName;

        public Node(Node parentNode, boolean isBadNode, String nodeName) {
            this.parentNode = parentNode;
            this.isBadNode = isBadNode;
            this.nodeName = nodeName;
        }

        public Node getParentNode() {

            return parentNode;
        }

        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }

        public boolean isBadNode() {
            if(isBadNode) {
                System.out.println("Found bad node: "+ nodeName);
            }
            return isBadNode;
        }

        public void setBadNode(boolean badNode) {
            isBadNode = badNode;
        }

        public String getNodeName() {
            return nodeName;
        }

        public void setNodeName(String nodeName) {
            this.nodeName = nodeName;
        }
    }

    public static Node findNodeOrElse(Node node) {
        System.out.println("checking node: "+ node.getNodeName());
        if(node.getParentNode() == null) {
            return null;
        }

        return Stream.of(node).filter(Node::isBadNode)
                .findFirst().orElse(findNodeOrElse(node.getParentNode()));

    }

    public static Node findNodeOrElseGet(Node node) {
        System.out.println("checking node: "+ node.getNodeName());
        if(node.getParentNode() == null) {
            return null;
        }

        Optional<Node> first = Stream.of(node).filter(Node::isBadNode)
                .findFirst();

        return first.orElseGet(() -> BadOrElse.findNodeOrElseGet(node.getParentNode()));

    }

    public static void main(String[] args) {
        Node node10 = new Node(null, false, "node-10");
        Node node9 = new Node(node10, false, "node-10");
        Node node8 = new Node(node9, false, "node-9");
        Node node7 = new Node(node8, false, "node-8");
        Node node6 = new Node(node7, false, "node-7");
        Node node5 = new Node(node6, false, "node-6");
        Node node4 = new Node(node5, false, "node-5");
        Node node3 = new Node(node4, false, "node-4");
        Node node2 = new Node(node3, false, "node-3");
        //Found Bad Node
        Node node1 = new Node(node2, true, "node-2");
        Node node0 = new Node(node1, false, "node-1");

        System.out.println("---------Find node with orElse----------- ");
        Node foundNode = BadOrElse.findNodeOrElse(node0);
        System.out.println("Bad node is "+ foundNode.getNodeName());

        System.out.println("---------Find node with orElseGet----------- ");
        foundNode = BadOrElse.findNodeOrElseGet(node0);
        System.out.println("Bad node is "+ foundNode.getNodeName());
    }
}
