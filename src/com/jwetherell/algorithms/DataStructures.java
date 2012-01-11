package com.jwetherell.algorithms;

import java.util.Random;

import com.jwetherell.algorithms.data_structures.BinarySearchTree;
import com.jwetherell.algorithms.data_structures.BinaryHeap;
import com.jwetherell.algorithms.data_structures.BinaryHeap.TYPE;

public class DataStructures {
    private static final int SIZE = 10;
    
    private static int[] unsorted = null;
    
    public static void main(String[] args) {
        Random random = new Random();
        
        System.out.print("Array=");
        unsorted = new int[SIZE];
        int i=0;
        System.out.print("array=");
        while (i<unsorted.length) {
            int j = random.nextInt(unsorted.length*10);
            unsorted[i++] = j;
            System.out.print(j+",");
        }
        System.out.println();

        {
            // BINARY SEARCH TREE
            System.out.println("Binary search tree.");
            BinarySearchTree bst = new BinarySearchTree(unsorted);

            // Add random node
            int next = random.nextInt(unsorted.length*100);
            System.out.println("Adding "+next);
            bst.add(next);
            System.out.println(bst.toString());

            // Add previously added node
            next = random.nextInt(unsorted.length);
            System.out.println("Adding "+unsorted[next]);
            bst.add(unsorted[next]);
            System.out.println(bst.toString());

            // Remove a previously added node
            next = random.nextInt(unsorted.length);
            System.out.println("Removing "+unsorted[next]);
            bst.remove(unsorted[next]);
            System.out.println(bst.toString());
            
            // Remove a random node (shouldn't do anything if it doesn't exist in the tree)
            next = random.nextInt(unsorted.length*100);
            System.out.println("Removing "+next);
            bst.remove(next);
            System.out.println(bst.toString());
            System.out.println();
        }
        
        {
            // HEAP
            System.out.println("Min-Heap.");
            BinaryHeap minHeap = new BinaryHeap(unsorted);
            System.out.println(minHeap.toString());
            
            System.out.println("Max-Heap.");
            BinaryHeap maxHeap = new BinaryHeap(unsorted,TYPE.MAX);
            System.out.println(maxHeap.toString());
        }
    }
}