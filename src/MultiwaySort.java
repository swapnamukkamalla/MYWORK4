/*NAME          :SWAPNA MUKKAMALLA
  DATE          :10-07-2019
  COURSE        :IT-516 DATA STRUCTURES AND ALGORITHMS
  HOMEWORK      :HW04
  TITLE         :Minimum-oriented indexed PQ implementation
  DESCRIPTION   :This application Merges together the unsorted input
                 stream given as command-line arguments into a single
                 sorted output stream on standard output.*/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;


public class MultiwaySort {

    //merging the input streams method
    private static void merge(In[] streams) {
        int n = streams.length; // streams length
        //Minimum index PQ
        IndexMinPQ<String> pq = new IndexMinPQ<String>(n);
        ArrayList<String> al = new ArrayList<String>();
        //  String[] s = new String[26]; // string Array

        //inserting input stream data into Minimum index PQ
        for (int i = 0; i < n; i++) {
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }

        StdOut.println();
        //Displaying the unsorted input streams
        StdOut.println("Multiway Merge, unsorted...");
        StdOut.println("----------------------------------------------------");
        int j = 0;
        while (!pq.isEmpty()) {
            al.add(pq.minKey());
            // s[j] = pq.minKey(); // inserting the input streams data into string array
            // displaying the minimum key of unsorted PQ
            StdOut.print(pq.minKey() + " ");
            j++;
            int i = pq.delMin();
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }

        StdOut.println();
        StdOut.println();

        // Arrays.sort(s); // sorting the string array
        Collections.sort(al);

        StdOut.println("Multiway Merge, sorted...");
        StdOut.println("----------------------------------------------------");

        //Displaying the sorted input stream using string array
        /*for (int i = 0; i < s.length; i++) {
            StdOut.print(s[i] + " ");
        }*/
        for (String al1 : al) {
            System.out.print(al1);
            StdOut.print(" ");
        }
    }


    public static void main(String[] args) {
        int n = args.length;
        In[] streams = new In[n];

        //inputting streams
        for (int i = 0; i < n; i++)
            streams[i] = new In(args[i]);
        merge(streams); // passing all the input streams to merge method


    }
}
