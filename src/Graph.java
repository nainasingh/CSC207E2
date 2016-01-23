package e2soln;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * An undirected graph of Node<T>s.
 * @param <T> the type of values in this Graph's Nodes.
 */
public class Graph<T>{

    // instance variable
	public Map<Node<T>, Set<Node<T>>> graph; 

    /**
     * Creates a new empty Graph.
     */
        // constructor
	public Graph()  {
		this.graph = new HashMap<>(); 
	}
    /**
     * Returns a Set of Nodes in this Graph.
     * @return a Set of Nodes in this Graph
     */
        // getNodes
	public Set<Node<T>> getNodes(){
		Set<Node<T>> keyset = graph.keySet();
		return keyset; 
	}	

    /**
     * Returns the Node from this Graph with the given ID.
     * @param id the ID of the Node to return
     * @return the Node from this Graph with the given ID
     * @throws NoSuchNodeException if there is no Node with ID
     *    id in this Graphs
     */
        // getNode
	public Node<T> getNode(int id) throws NoSuchNodeException{
		Set<Node<T>> keyset = graph.keySet(); 
		
		for (Node<T> key : keyset){
			int otherid = key.getId(); 
			if (otherid == id){
				return key;
		}
		}
		throw new NoSuchNodeException("It doesn't exist");
		}

    /**
     * Returns a Set of neighbours of the given Node.
     * @param node the Node whose neighbours are returned
     * @return a Set of neighbours of node
     */
    // getNeighbours
	
	public Set<Node<T>> getNeighbours(Node<T> node){
		Set<Node<T>> set = graph.get(node);
		
		
	
		return set;
	 }
	
    /**
     * Returns whether Nodes with the given IDs are adjacent in this Graph.
     * @param id1 ID of the node to test for adjacency
     * @param id2 ID of the node to test for adjacency
     * @return true, if Nodes with IDs id1 and id2 are adjacent in this Graph,
     *    and false otherwise
     * @throws NoSuchNodeException if node with ID id1 or id2 is not in this Graph
     */
    // areAdjacent
	public boolean areAdjacent(int id1, int id2) throws NoSuchNodeException{
		Set<Node<T>> keyset = graph.keySet(); 
		boolean b1 = false;
		for (Node<T> key1 : keyset){
			int otherid = key1.getId(); 
			if (otherid == id1){
				b1 = true;
			}
			
			}
		boolean b2 = false;
		for(Node<T> key2: keyset){
			int otherid2 = key2.getId();
			if (otherid2 == id2){
				b2 = true;
		}
		}
		
		if (b1 == true && b2 == true){
			Node<T> node2 = getNode(id2);
			Node<T> node1 = getNode(id1);
			Set<Node<T>> r =getNeighbours(node1);
			Set<Node<T>> j =getNeighbours(node2);
			if (r.contains(node2) == true && j.contains(node1) == true){
				return true; 
				}
			else{
				return false;
			}
			}
		else{
			throw new NoSuchNodeException("It doesn't exist");
		}
	}

    /**
     * Returns whether the given Nodes are adjacent in this Graph.
     * @param node1 the Node to test for adjacency with node2
     * @param node2 the Node to test for adjacency with node1
     * @return true, if node1 and node2 are adjacent in this Graph,
     *    and false otherwise
     * @throws NoSuchNodeException if node1 or node2 are not in this Graph
     */
    // areAdjacent
	public boolean areAdjacent(Node<T> node1, Node<T> node2) throws NoSuchNodeException{
		Set<Node<T>> keys = graph.keySet(); 
		if ( keys.contains(node1) == true && keys.contains(node2) == true){
			Integer x = node1.getId(); 
			Integer y = node2.getId(); 
			return areAdjacent(x,y); 
			
		}
		else {
			throw new NoSuchNodeException("It doesn't exist");
		}	
	}

    /**
     * Returns the number of nodes in this Graph.
     * @return The number of nodes in this Graph.
     */
    public int getNumNodes() {
        return getNodes().size();	
    }

    /**
     * Returns the number of edges in this Graph.
     * @return The number of edges in this Graph.
     */
    public int getNumEdges() {	
        int total = 0;

        for (Node<T> node : getNodes()) {
            total += getNeighbours(node).size();
        }

        return total / 2;
    }

    /**
     * Adds a new Node with the given value to this Graph. 
     * @param i the ID of the new Node
     * @param value the value of the new Node
     */
    // addNode
    public void addNode(int i, T value) {
    	Node<T> node = new Node<T>(i, value);
    	Set<Node<T>> set = (Set<Node<T>>) new TreeSet<T>();
    	graph.put(node, set);
    }
    		
    	
    /**c
     * Adds an edge between the given nodes in this Graph. If there 
     * is already an edge between node1 and node2, does nothing.
     * @param node1 the node to add an edge to and from node2
     * @param node2 the node to add an edge to and from node1
     * @throws NoSuchNodeException if node1 or node2 is not in
     *    this Graph
     */
    // addEdge
    public void addEdge(Node<T> node1, Node<T> node2) throws NoSuchNodeException{
    	Set<Node<T>> keys = graph.keySet(); 
		if ( keys.contains(node1) == true && keys.contains(node2) == true){
			Set<Node<T>> id1value = getNeighbours(node1);
			Set<Node<T>> id2value = getNeighbours(node2);
			if ((id1value.contains(node2) == true && id2value.contains(node1)) || node1 == node2 == true){
	 
			}
			else{
				id1value.add(node2);
				graph.remove(node1);
				graph.remove(node2);
				id2value.add(node1);
				graph.put(node1,id1value);
				graph.put(node2, id2value);
				}	
		}
		else{
			throw new NoSuchNodeException("It doesn't exist");
		}

    }

    /**
     * Adds an edge between the nodes with the given IDs in this Graph. 
     * @param id1 ID of the node to add an edge to and from
     * @param id2 ID of the node to add an edge to and from
     * @throws NoSuchNodeExceptionf there is no Node with ID 
     *    id1 or ID id2 in this Graph.
     */
    // addEdge
    public void addEdge(int id1, int id2) throws NoSuchNodeException{
    	Set<Node<T>> keys = graph.keySet();
    	boolean b1 = false;
		for (Node<T> key1 : keys){
			int otherid = key1.getId(); 
			if (otherid == id1){
				b1 = true;
			}
			
			}
		boolean b2 = false;
		for(Node<T> key2: keys){
			int otherid2 = key2.getId();
			if (otherid2 == id2){
				b2 = true;
		}
		}
		if (id1==id2){
			
			
		}
		else if (b1 == true && b2 == true ){
			Node<T> n1 = getNode(id1);
			Node<T> n2 = getNode(id2); 
			addEdge(n1,n2); 
		}	
		else{
			throw new NoSuchNodeException("It doesn't exist");
		}
    	
    	
    	
    }

    @Override
    public String toString() {

        String result = "";
        result += "Number of nodes: " + getNumNodes() + "\n";
        result += "Number of edges: " + getNumEdges() + "\n";

        for (Node<T> node: getNodes()) {
            result += node + " is adjacent to: ";
            for    (Node<T> neighbour: getNeighbours(node)) {
                result += neighbour + " ";
            }
            result += "\n";
        }
        return result;
    }
}