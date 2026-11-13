/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {
       if(root==null) return null;

        HashMap<Integer, Node> nodeDirectory = new HashMap<>();

        HashSet<Integer> visited = new HashSet<>();

        
        

        return dfs(root, nodeDirectory, visited);
       
    }

    private Node dfs(Node root, HashMap<Integer, Node> nodeDirectory, HashSet<Integer> visited){
        if(root==null) return null;
        if(visited.contains(root.val)) return null;
        visited.add(root.val);

        Node copyRoot= getNode(root.val, nodeDirectory);
        

        for(Node nextNode: root.neighbors){

            Node nextNodeCopy = getNode(nextNode.val, nodeDirectory);
            copyRoot.neighbors.add(nextNodeCopy);

            if(visited.contains(nextNode.val)) continue;

            dfs(nextNode, nodeDirectory, visited);
        }
        return copyRoot;

    }

    private Node getNode(int val, HashMap<Integer, Node> nodeDirectory){
        return nodeDirectory.computeIfAbsent(val, k -> new Node(val));
    }
}