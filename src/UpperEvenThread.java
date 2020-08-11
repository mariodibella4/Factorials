import java.math.BigInteger;

public class UpperEvenThread implements Calculate {
    private static BigInteger outUpperEven;
    public static BigInteger forRestriction;
    public UpperEvenThread(long n){
        outUpperEven = BigInteger.valueOf(n);
        forRestriction=BigInteger.valueOf(n/2);
    }
    @Override
    public void calc() {
        for(BigInteger j=outUpperEven.subtract(BigInteger.ONE);j.compareTo(forRestriction)>0;j=j.subtract(BigInteger.ONE)){
            outUpperEven=outUpperEven.multiply(j);
        }
    }

    public static BigInteger getOutUpperEven() {
        return outUpperEven;
    }
}
