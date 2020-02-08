import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Multiplefiles {

    public static void main(String[] args) {


        int n = args.length;
        In[] streams = new In[n];

        //inputting streams
        for (int i = 0; i < n; i++)
            streams[i] = new In(args[i]);
        merge(streams);


//procedure on file;
    }

    //merging the input streams method
    private static void merge(In[] streams) {
        int n = streams.length; // streams length
        //Minimum index PQ
        //IndexMinPQ<String> pq = new IndexMinPQ<String>(n);
        Integer[] s = new Integer[8]; // string Array
        String line;
        //inserting input stream data into Minimum index PQ
        int j = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (!streams[i].isEmpty()) {
                line = streams[i].readLine();
                String[] wordList = line.split("\\s+");
                for (int k = 0; k < wordList.length; k++) {
                    s[l] = Integer.parseInt(wordList[k]);
                    // s[l] = wordList[k];
                    StdOut.print(s[l] + " ");
                    l++;
                }


            }
        }

        Arrays.sort(s);
        StdOut.println("Sorted----------------------");
        for (int i = 0; i < s.length; i++) {
            StdOut.print(s[i] + " ");
        }
    }

}

