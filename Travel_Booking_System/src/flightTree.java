
import java.time.LocalTime;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class flightTree {

    flightNode root;
    int size;

    flightTree(){
        root = null;
        size = 0;
    }

   
    private int compare(Flight a, Flight b){
        return key(a).compareTo(key(b));
    }

    private LocalTime key(Flight f){
        return f.getDepartureTime() == null ? LocalTime.MAX : f.getDepartureTime();
    }

 
    public void add(Flight flight){
        root = addRecursive(root, flight);
        size++;
    }

   
    public flightNode addRecursive(flightNode current, Flight flight){
        if(current == null){
            return new flightNode(flight);
        }

        if(compare(flight, current.value) < 0){
            current.left = addRecursive(current.left, flight);
        }else{
            current.right = addRecursive(current.right, flight);
        }

        return current;
    }

  
    public void transversalInOrder(flightNode node, LinkedList<Flight> result){
        if(node != null){
            transversalInOrder(node.left, result);
            result.add(node.value);
            transversalInOrder(node.right, result);
        }
    }

  
    public LinkedList<Flight> inOrder(){
        LinkedList<Flight> result = new LinkedList<>();
        transversalInOrder(root, result);
        return result;
    }


    public void searchByTime(flightNode node, LocalTime time, LinkedList<Flight> found){
        if(node != null){
            int cmp = time.compareTo(key(node.value));
            if(cmp < 0){
                searchByTime(node.left, time, found);
            }else{
                if(cmp == 0){
                    found.add(node.value);
                }
                searchByTime(node.right, time, found);
            }
        }
    }

    public LinkedList<Flight> searchByTime(LocalTime time){
        LinkedList<Flight> found = new LinkedList<>();
        searchByTime(root, time, found);
        return found;
    }

   
    public Flight earliest(){
        if(root == null){
            return null;
        }
        flightNode current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return root == null;
    }

}
