import java.util.ArrayList;
import java.util.Arrays;


public class Tweetter extends DiGraph {

    public Tweetter(){
        // call the constructor of DiGraph in which a HashMap called adjList is initialised
        super();

        // fill the Tweeter network with the edges given in the diagram
        // put a String to our list as a key and an ArrayList of Strings which represents the direction of rumours as an item
        this.adjList.put("Alice", new ArrayList<>(Arrays.asList("Oscar", "Grace")));
        this.adjList.put("Grace", new ArrayList<>(Arrays.asList("Carol")));
        this.adjList.put("Oscar", new ArrayList<>(Arrays.asList("Carol", "Alice")));
        this.adjList.put("Carol", new ArrayList<>(Arrays.asList("Trudy")));
        this.adjList.put("Trudy", new ArrayList<>(Arrays.asList("Carol")));
        this.adjList.put("Victor", new ArrayList<>(Arrays.asList("Trudy", "Frank")));
        this.adjList.put("Frank", new ArrayList<>(Arrays.asList("Peggy")));
        this.adjList.put("Eve", new ArrayList<>(Arrays.asList("Oscar", "Frank", "Bob")));
        this.adjList.put("Bob", new ArrayList<>(Arrays.asList("Peggy", "Eve")));
        this.adjList.put("Peggy", new ArrayList<>(Arrays.asList("Frank", "Eve", "Victor")));
    }


    public ArrayList<String> broadcastsTo(String person){
        /* use a variable in type of ArrayList called broadcasters which contains the Strings of people who broadcast
           rumours to the person and return the ArrayList
        */
        ArrayList<String> broadcasters = new ArrayList<>(); // 1
        // iterate through the HashMap, if the ArrayList contains person, add the key value to the new ArrayList broadcasters
        for (String key : adjList.keySet()) {
            if (adjList.get(key).contains(person)) {
                broadcasters.add(key);
            }
        }
        System.out.println(broadcasters);
        return broadcasters;
    }


    public boolean canReach(String source, String target){
        // the person who is starting the rumour can't be the target and the target can't be null, so return false
        if(source.equals(target) || target == null)
            return false;
        // call DFS method to see if the rumour will reach the target and print the name of the people that have taken
        // the rumour
        return this.DFS(source, target);
    }


    public ArrayList<String> receiversOf(String person){
        // call BFS method which will search and print the names of people who will receive the rumour
        return this.BFS(person);
    }
}