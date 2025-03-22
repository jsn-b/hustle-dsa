public class Exponentiate
{
    public static void main(String[] args) {
        //brute
        int b = 2;
        int e = 10;
        @SuppressWarnings("unused")
        int absoluteE = Math.abs(e);
        int sol = 1;
/*
        for(int i=1; i<=e; i++)
        {
            sol*=b;
        }
        System.out.println(sol);
*/

        //optimal
        while(e!=0)
        {
            if(e%2==0)
            {
                b*=b;
                e/=2;
            }
            else
            {
                sol*=b;
                e--;
            }
        }
        System.err.println((double)1/sol);//to print for negative exponents.
    }
}
/*
* Space - O(1)
* Time - O(log2n)
*/