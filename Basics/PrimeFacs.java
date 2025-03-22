import java.util.ArrayList;

class PrimeFacs
{
    
    public static ArrayList<Integer> primeFactors(int n)
    {
        ArrayList<Integer> primeFacts = new ArrayList<>();
        if(n<2){
            return primeFacts;
        }

        if(n%2==0)
        {
            primeFacts.add(2);
            while(n%2==0)
                n/=2;
        }

        for(int i=3; i*i<=n; i+=2)
        {
            if(n%i==0){
                primeFacts.add(i);
            while(n%i==0)
                n=n/i;
            }
        }
        if(n!=1)
                primeFacts.add(n);

        return primeFacts;
    }
}
