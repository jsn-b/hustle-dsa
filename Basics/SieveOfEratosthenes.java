/**
 * Sieve of eratosthenes is used to find the primenumbers upto a particular number until N.
 * n is expected to be small about ~10 million or so - 10^7.
 * useful to solve the query based problems - problems which repeatedly check if a number is prime or not
 * 
 * TC = O(N.log(log(n)) - because of the prime harmonic series in the nested loop
 * SC = O(N)
 * 
 * boolean array is used to save some space as compared to an int array
 * 
 */

public class SieveOfEratosthenes
{
    public static boolean[] getSieve(int n) {
        boolean[] notprimes = new boolean[n+1];
        if(n<2) return new boolean[0];
        /**
         * Correct but not completely optimised.
         * 
        for(int i=2; i<=n; i++)
        {
            if(i>2 && notprimes[i]==true)
                continue;
            for(int j=i+i; j<=n;j+=i){//j*j<=n is better than j<=n whem the increment is based on j++
                notprimes[j] = true;
            }
        }

         */
        for(int i=2; i*i<=n; i++)
        {

            if(i>2 && notprimes[i]==true)
                continue;
            for(int j = i*i;j<=n;j+=i)//faster than i+i or 2i. rather than comparing from 2i or i+i, we compare from i*i to avoid redundant operations - 2*3 is already marked, so 3*2 need not be checked. Hence, we start from 3*3, 4*4, 5*5 and so on. this helps avoid redundant comparisons.
            //we need not check j<=n, but j<=sqrt(n). i.e, for n = 30 at i=6, notprimes[i] == true. but at 7, notprimes[i] == false and i*i(49)<=n(30) is false. So rather than looping i till n we can have stopped comparisons at sqrt of n, because i > sqrt(n) are typically>n at the j loop.
            //find out why j+=i only is giving correct answer. why not j++?
            {
                notprimes[j] = true;
            }
        }
        if(n>=2) notprimes[2] = false;
        return notprimes;
    }
}

/**
 * The sieve eratosthenes is an example of creating blackboxes using precomputation
 * for things that are frequently needed.
 * 
 * so we can create blackboxes by precomputing necessary data beforehand to avoid redundant computations. 
 */