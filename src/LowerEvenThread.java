import java.math.BigInteger;

public class LowerEvenThread implements Calculate {
    private static BigInteger outLowerEven;
    public LowerEvenThread(long n){
        outLowerEven = BigInteger.valueOf(n/2);
    }
    @Override
    public void calc() {
        for(BigInteger i=outLowerEven.subtract(BigInteger.ONE);i.compareTo(BigInteger.ZERO)>0;i=i.subtract(BigInteger.ONE)){
            outLowerEven=outLowerEven.multiply(i);
        }

    }

    public static BigInteger getOutLowerEven() {
        return outLowerEven;
    }
}
