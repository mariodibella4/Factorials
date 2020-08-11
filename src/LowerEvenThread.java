import java.math.BigInteger;

public class LowerEvenThread implements Calculate {
    public static BigInteger outLowerEven;
    public LowerEvenThread(long n){
        outLowerEven = BigInteger.valueOf(n/2);
    }
    @Override
    public void calc() {
        for(BigInteger i=outLowerEven.subtract(BigInteger.ONE);i.compareTo(BigInteger.ZERO)>0;i=i.subtract(BigInteger.ONE)){
            outLowerEven=outLowerEven.multiply(i);
        }
        /*
        for (long i = outLowerEven - 1; i > 0; i--) {
            outLowerEven = outLowerEven * i;
            System.out.println(outLowerEven);
        }*/
    }

}
