/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
        int start = node.label;
        UndirectedGraphNode startNode = new UndirectedGraphNode(start);
        map.put(start,startNode);
        Stack<UndirectedGraphNode> st = new Stack<>();
        st.push(node);
        //bfs
        while(!st.isEmpty()){
            Stack<UndirectedGraphNode> curSt = new Stack<>();
            while(!st.isEmpty()){
                UndirectedGraphNode current = st.pop();
                UndirectedGraphNode currentClone = map.get(current.label);
                for(UndirectedGraphNode neighbor: current.neighbors){
                    if(map.containsKey(neighbor.label)){
                        currentClone.neighbors.add(map.get(neighbor.label));
                    }else{
                        UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
                        map.put(neighborClone.label,neighborClone);
                        currentClone.neighbors.add(neighborClone);
                        curSt.push(neighbor);
                    }
                }
            }
            st = curSt;
        }
        return map.get(start);
    }
}