import java.util.ArrayList;
import java.util.HashMap;

public class DiGraph {
    /* We are going to work with Strings so I used a HashMap which will take a String as a key and an ArrayList of Strings
    as values and called it adjList.
     */
    protected HashMap<String, ArrayList<String>> adjList;

    /**
     * Constructor for a directed graphs with a number of nodes but no edges
     */

    public DiGraph() {
        //make the array of ArrayLists
        adjList = new HashMap<>();
    }

    /**
     * Add an edge between the two nodes given
     *
     * @param fromNode the node the edge starts from
     * @param toNode the node that the edge goes to
     */
    // make an edge which will get a node and connect another node
    public void addEdge(String fromNode, String toNode){
        adjList.get(fromNode).add(toNode);

    }

    /**
     * Return the number of nodes in the graph
     *
     * @return the number of nodes in the graph
     */
    public int getNumberOfNodes(){
        return adjList.size();
    }

    /**
     * Determine whether there is an edge between the two nodes given
     *
     * @param fromNode the node the edge starts from
     * @param toNode the node that the edge goes to
     * @return true if there is an edge between fromNode and toNode, false otherwise
     */
    // return true if two nodes are connected, otherwise return false
    public boolean hasEdge(String fromNode, String toNode){
        return adjList.get(fromNode).contains(toNode);
    }

    /**
     * Print the adjacency list representation of the graph
     */

    public void printAdjacencyList(){
        System.out.println("Number of nodes = "+ adjList.size());
        // traverse the adjList and print the graph with all the neighbours
        for (String key : adjList.keySet()) {
            System.out.print("Neighbours of " + key + " : ");
            for (String neighbour:adjList.get(key)) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }

    /**
     * Perform a BFS traversal of the graph, printing the nodes in the order visited
     */
    public ArrayList<String> BFS(String start){

        //create the list of visited nodes and the queue
        ArrayList<String> visitedNodes = new ArrayList<>();
        Queue theQueue = new ArrayQueue();

        //mark the start as visited and put it in the Queue
        visitedNodes.add(start);
        theQueue.enqueue(start);

        while(!theQueue.isEmpty()){
            String item = (String) theQueue.dequeue();
            //process the item
            System.out.println("next item = " + item);


            //mark all the neighbours of the item which have not been visited
            // as visited and
            //add them to the queue
            for (String neighbour:adjList.get(item)){
                if (!visitedNodes.contains(neighbour)){
                    visitedNodes.add(neighbour);
                    theQueue.enqueue(neighbour);
                }
            }

        }
        // it contains the owner of the rumour, so remove the index 0, meaning the owner
        visitedNodes.remove(0);
        return visitedNodes;
    }

    /**
     * Perform a DFS traversal of the graph, printing the nodes in the order visited
     */
    public boolean DFS(String start, String finish){

        //create the list of visited nodes and the stack
        ArrayList<String> visitedNodes = new ArrayList<>();
        Stack theStack = new ArrayStack();

        //mark the start as visited and put it in the stack
        visitedNodes.add(start);
        theStack.push(start);

        while(!theStack.isEmpty()){
            String item = (String) theStack.pop();

            // a person can't spread the rumour to themself so while the owner doesn't equal to one of the people that
            // have taken the rumour, print the targets
            if(! start.equals(item)){
                System.out.println("The target " + item + " has just taken the rumour!");

            }
            //mark all the neighbours of the item which have not been visited
            // as visited and
            //add them to the stack
            for (String neighbour:adjList.get(item)){
                if (!visitedNodes.contains(neighbour)){
                    visitedNodes.add(neighbour);
                    theStack.push(neighbour);
                }
            }
        }
        // return the targets
        return visitedNodes.contains(finish);
    }
}
