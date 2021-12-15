import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import java.util.*;

public class DirectedWG implements DirectedWeightedGraph {
    int MC, edgeNum;
    boolean flageiteratorex=false;

    HashMap<Integer, NodeData> graph;
    HashMap<Integer, HashMap<Integer, EdgeData>> edges;
    List<EdgeData> EdgeList = Collections.emptyList();

    /**
     * constructor function
     */
    public DirectedWG() {
        MC = 0;
        edgeNum = 0;
        graph = new HashMap<>();
        edges = new HashMap<>();

    }

    /**
     * returns the node_data by the node_id,
     *
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    @Override
    public NodeData getNode(int key) {
        if (!(graph.containsKey(key))) return null;
        return graph.get(key);
    }

    /**
     * returns the data of the edge (src,dest), null if none.
     * Note: this method should run in O(1) time.
     *
     * @param src
     * @param dest
     * @return
     */
    @Override
    public EdgeData getEdge(int src, int dest) {
        //checks if both nodes are in the graph, and edge are exists
        if (!(graph.containsKey(src)) || !(graph.containsKey(dest)) || !(edges.get(src).containsKey(dest)))
            return null;
        return edges.get(src).get(dest);
    }

    /**
     * adds a new node to the graph with the given node_data.
     * Note: this method should run in O(1) time.
     *
     * @param n
     */
    @Override
    public void addNode(NodeData n) {
        if(n == null) return;
        graph.put(n.getKey(), n);
        edges.put(n.getKey(), new HashMap<>());
        MC++;
        if(flageiteratorex)//if Iterator has been
            throw new RuntimeException("Iterator has been changed you need a new Iterator!");


    }

    /**
     * Connects an edge with weight w between node src to node dest.
     * * Note: this method should run in O(1) time.
     *
     * @param src  - the source of the edge.
     * @param dest - the destination of the edge.
     * @param w    - positive weight representing the cost (aka time, price, etc) between src-->dest.
     */
    @Override
    public void connect(int src, int dest, double w) {
        if (!(graph.containsKey(src)) || !(graph.containsKey(dest)) || getEdge(src, dest) != null)
            return;
        EdgeData e = new EdgeD(getNode(src), getNode(dest), w);
        edges.get(src).put(dest, e);
        edgeNum++;
        MC++;

    }

    /**
     * This method returns an Iterator for the
     * collection representing all the nodes in the graph.
     * Note: if the graph was changed since the iterator was constructed - a RuntimeException should be thrown.
     *
     * @return Iterator<node_data>
     */
    @Override
    public Iterator<NodeData> nodeIter() {
        flageiteratorex=true;
        return graph.values().iterator();
    }

    /**
     * This method returns an Iterator for all the edges in this graph.
     * Note: if any of the edges going out of this node were changed since the iterator was constructed - a RuntimeException should be thrown.
     *
     * @return Iterator<EdgeData>
     */
    @Override
    public Iterator<EdgeData> edgeIter() {
        flageiteratorex=true;

        return EdgeList.iterator();
    }

    /**
     * This method returns an Iterator for edges getting out of the given node (all the edges starting (source) at the given node).
     * Note: if the graph was changed since the iterator was constructed - a RuntimeException should be thrown.
     *
     * @param node_id
     * @return Iterator<EdgeData>
     */
    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        flageiteratorex=true;
        if (!(graph.containsKey(node_id)))
            return null;
       return edges.get(node_id).values().iterator();

    }

    /**
     * Deletes the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method should run in O(k), V.degree=k, as all the edges should be removed.
     *
     * @param key
     * @return the data of the removed node (null if none).
     */
    @Override
    public NodeData removeNode(int key) {
        return null;
    }

    /**
     * Deletes the edge from the graph,
     * Note: this method should run in O(1) time.
     *
     * @param src
     * @param dest
     * @return the data of the removed edge (null if none).
     */
    @Override
    public EdgeData removeEdge(int src, int dest) {
        return null;
    }

    /**
     * Returns the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     *
     * @return
     */
    @Override
    public int nodeSize() {
        return 0;
    }

    /**
     * Returns the number of edges (assume directional graph).
     * Note: this method should run in O(1) time.
     *
     * @return
     */
    @Override
    public int edgeSize() {
        return 0;
    }

    /**
     * Returns the Mode Count - for testing changes in the graph.
     *
     * @return
     */
    @Override
    public int getMC() {
        return MC;
    }
}
