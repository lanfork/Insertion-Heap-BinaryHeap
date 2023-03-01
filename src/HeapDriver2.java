import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HeapDriver2 {

	static long startTime, endTime;
	static String name = "A1.txt";
	static int input = 800000;

	/* 
	 * Driver program for HeapSort program
	 * Writes an input number of numbers onto a file, reads the file into an array.
	 * Performs Heap Sort on the array's values and records the time it takes to sort in nanoseconds. 
	 * 
	 * Kimberly Lanford CSCI321-01M-SUMMER-2022
	 */
    public static void main( String [ ] args ) throws UnderflowException, IOException
    {
    	 BinaryHeap2<Integer> h = new BinaryHeap2<>( );
         
    	 //loops through entire program for 5 different files and inputs
       
        	
              
       
        	 BufferedWriter out = null;
        	    try {
        	        // Write File Contents - incremented socre
        	        out = new BufferedWriter(new FileWriter(name, false));
        	        for(int i1 = 1; i1 <=input; i1++) {
        	        out.write(String.valueOf(i1+"\n"));
        	        }
        	    } catch (IOException e) {
        	        e.printStackTrace();
        	    } finally {
        	        if (out != null) {
        	            try {
        	                out.close();
        	            } catch (IOException e) {
        	                // TODO Auto-generated catch block
        	                e.printStackTrace();
        	            }
        	            
        	        }
        	    }
    
    	        
      
        	
        	
        	// Read File Contents - score
            BufferedReader br = new BufferedReader(new FileReader(name));
            String storedScore="0";
            int storedScoreNumber = 0;
            int[] a = new int[input];
            int num = 0;
           while ((storedScore = br.readLine()) != null) {
               storedScoreNumber=(Integer.parseInt(storedScore));
               a[num] = storedScoreNumber;
               num++;
               startTime += System.nanoTime();
               h.insert(storedScoreNumber);
               endTime += System.nanoTime();
            }
           br.close();
                
           h.buildHeap();
          
        // start with index 0 (the root of the heap)
           int index = 0;
    
           if (h.isHeap(a, 0, index)) {
               System.out.println("The given array is a heap");
           }
           else {
               System.out.println("The given array is not a heap");
           }
    
       
             
  	 	// sleep for 5 seconds
  	 	    try {
  	 			TimeUnit.SECONDS.sleep(5);
  	 		} catch (InterruptedException e) {
  	 			// TODO Auto-generated catch block
  	 			e.printStackTrace();
  	 		}


  	 	// get the difference between the two nano time valuess.
  	 	    // writes the differences to file and prints to console.
  	 	    long timeElapsed = endTime - startTime;
	 	    System.out.println("Execution time for " + name + " in nanoseconds: " + timeElapsed);
        }  
    }

       

