/*NAME          :SWAPNA MUKKAMALLA
  DATE          :10-07-2019
  COURSE        :IT-516 DATA STRUCTURES AND ALGORITHMS
  HOMEWORK      :HW04
  TITLE         :max priority queue implementation
  DESCRIPTION   :This application gets the input stream given as
                 command-line arguments displays the bottom most-
                 (based on the batch size given on the command prompt)
                 values from the input stream on standard output
                 implementing the stack-LIFO.*/

import edu.princeton.cs.algs4.*;

public class BottomM {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);   //input batch size
        //implementing the max priority queues
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(m + 1);
        while (StdIn.hasNextLine()) {
            //inserting data into max priority queue
            pq.insert(new Transaction(StdIn.readLine()));
            //dleting the maximum key if the size is greater than the batch size.
            if (pq.size() > m)
                pq.delMax();
        }
        // stack implementation
        Stack<Transaction> stack = new Stack<Transaction>();

        //adding data to the stack LIFO
        while (!pq.isEmpty())
            stack.push(pq.delMax());
        //Displaying the bottom most values from input stream based on the batch size.
        for (Transaction transaction : stack)
            StdOut.println(transaction);
    }
}
