import java.math.BigInteger;

public class UpperOddThread implements Calculate{
    public static BigInteger outUpperOdd;
    public static BigInteger forRestriction;
    public UpperOddThread(long n) {
        outUpperOdd = BigInteger.valueOf(n);
        forRestriction=BigInteger.valueOf((n+1)/2);
    }

    @Override
    public void calc() {
        for(BigInteger j=outUpperOdd.subtract(BigInteger.ONE);j.compareTo(forRestriction)>0;j=j.subtract(BigInteger.ONE)){
            outUpperOdd=outUpperOdd.multiply(j);
        }
    }
}

