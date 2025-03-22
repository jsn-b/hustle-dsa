import java.util.ArrayList;
import java.util.Arrays;
/**
 * Sum of prefix can be used here to prevent repeated counting
 * Sieve of eratosthenes can be used here for optimising repeated queries.
 * 
 */
public class CountOfPrimesInRange
{
    public static void primesInRange(ArrayList<Integer[]> queries) 
    {
        int n = 200;
        boolean[] np = SieveOfEratosthenes.getSieve(n);
        int[] sol = new int[n+1];
        int cnt = 0;
        
        for(int i=2; i<np.length; i++)
        {
            if(np[i]==false)
                sol[i] = ++cnt;
            else
                sol[i] = cnt;
        }
        System.err.println("Finished");
        System.err.println(Arrays.toString(sol));
        for(int i=0; i<queries.size(); i++)
        {
            Integer[] t = queries.get(i);
            int noOfPrimes = sol[t[1]]-sol[t[0]-1];//-1 to prevent subtraction of cnt, incase the lower bound is also a prime.
            System.err.println(t[0]+" - "+t[1]+"="+noOfPrimes);
        }
       
    }
}