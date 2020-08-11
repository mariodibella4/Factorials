import java.math.BigInteger;

public class LowerOddThread implements Calculate {
    private static BigInteger outLowerOdd;
    public LowerOddThread(long n) {
        outLowerOdd=BigInteger.valueOf((n+1)/2);
    }

    @Override
    public void calc() {
        for(BigInteger i=outLowerOdd.subtract(BigInteger.ONE);i.compareTo(BigInteger.ZERO)>0;i=i.subtract(BigInteger.ONE)){
            outLowerOdd=outLowerOdd.multiply(i);
        }
    }

    public static BigInteger getOutLowerOdd() {
        return outLowerOdd;
    }
}
