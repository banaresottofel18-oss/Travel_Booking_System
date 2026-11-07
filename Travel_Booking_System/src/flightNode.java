/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
public class flightNode {
    
    Flight value;
    flightNode left;
    flightNode right;

    flightNode(Flight value){
        this.value = value;
        left = null;
        right = null;
    }
}
