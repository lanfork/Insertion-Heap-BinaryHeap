import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class sortDriver2 {


	static long startTime, endTime;
	static String name = "A1.txt";
	static int input = 800000;
	
	/* 
	 * Driver program for Insertion Sort program
	 * Writes an input number of numbers onto a file, reads the file into an array.
	 * Performs Heap Sort on the array's values and records the time it takes to sort in nanoseconds. 
	 * 
	 * Kimberly Lanford CSCI321-01M-SUMMER-2022
	 */
    public static void main( String [ ] args ) throws UnderflowException, IOException
    {
    	
    	 
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
        	
            	// Read File Contents - score
                BufferedReader br = new BufferedReader(new FileReader(name));
                String storedScore="0";
              Integer[] a = new Integer[input];
              int in = 0;
               while ((storedScore = br.readLine()) != null) {
                   
                   a[in] = (Integer.parseInt(storedScore));
                   in++;
                }
               br.close();
               
             Sort2.shuffleArray(a);
             startTime = System.nanoTime();
             Sort2.insertionSort(a);
             endTime = System.nanoTime();
             Sort2.checkSort(a);
             for(int n : a)
            	 System.out.println(n);
             
     		System.out.println();
     		Sort2.checkSort(a);
     		System.out.println();
     		
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
  	 	    System.out.println("Execution time for insertion in nanoseconds: " + timeElapsed);
  	 	    
  	 	    
 		}
    }
