import java.math.BigInteger;

public class UpperEvenThread implements Calculate {
    public static BigInteger outUpperEven;
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

        /*
        for (long j = outUpperEven - 1; j > outUpperEven/2; j--) {
            outUpperEven = outUpperEven * j;
            System.out.println(outUpperEven);
        }*/
    }
    /*
    public void run(){
        this.calc();
    }*/
}
