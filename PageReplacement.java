//COSC 439 Program #4
//Michael Santoro
//Due 5-11-16

import java.io.*;
import java.util.*;
public class PageReplacement {

    public static void main(String[] args) throws IOException {  //drives the program 
        
        int reference[];
        int memory[][];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int frame;
        int p = 0;
        int pageHit = 0; //counters to keep track
        int pageFault = 0;       //initializing necessary variables 
        int ref_len;
        int buffer[];

        //The user will enter the number of frames 
        //followed by how long our string will be
        //followed by the actual string which will be used in calculations 
        System.out.println("Enter how big the free frames will be:  ");
        frame = Integer.parseInt(input.readLine());        
        System.out.println("How long will the string be? ");
        ref_len = Integer.parseInt(input.readLine());
         
        //this initializes our arrays based on the input from the user 
        reference = new int[ref_len];
        memory = new int[ref_len][frame];  //shows how memory will appear
        buffer = new int[frame];
        
        //buffer will start out as -1 to show values that are not yet filled
        for(int j = 0; j < frame; j++)
                buffer[j] = -1;
        
        System.out.println("Reference String-->  ");
        for(int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(input.readLine());
        } //ends for loop
        
        System.out.println();
        for(int i = 0; i < ref_len; i++) {  //nested for to parse through the input string and frames
         int search = -1;
         for(int j = 0; j < frame; j++) {
          if(buffer[j] == reference[i]) {   //if what is in the buffer equals the reference...search and declare a hit
           search = j;
           pageHit++;
           break;
          } //ends if 
         } //ends for 
         
         if(search == -1) {         //if the search comes up with nothing declare a page fault 
          buffer[p] = reference[i];
          pageFault++;
          p++;
          if(p == frame)          //reset the pointer 
           p = 0;
         } //ends if
         
            for(int j = 0; j < frame; j++)
                memory[i][j] = buffer[j];
        } //ends for 
        
        for(int i = 0; i < frame; i++) {                 //this just prints memory just like it would show in the texbook 
            for(int j = 0; j < ref_len; j++)             //just a simple trace through our memory array 
                System.out.printf("%3d ",memory[j][i]);
            System.out.println();
        }  //ends for loop 
        
        //Simply calculate the hits and faults
        //shows how FIFO is not the best algorithm
        //it results in a lot of faults althouht it is easy to implement 
        System.out.println("Page hits --> " + pageHit);
        System.out.println("Page faults --> " + pageFault);
        System.out.println("Ratio -->  " + (float)((float)pageHit/ref_len));
        
    } // Ends  Main
    
} //Ends PageReplacement 
