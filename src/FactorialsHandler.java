import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class FactorialsHandler {
    public static BigInteger factorial(long n) throws InterruptedException {
        if (n == 0)
            return BigInteger.ONE;
        if (n < 0)
            return BigInteger.valueOf(n);
        if (isItEven(n)) {
            UpperEvenThread upperEvenThread = new UpperEvenThread(n);
            LowerEvenThread lowerEvenThread = new LowerEvenThread(n);
            ExecutorService es = Executors.newCachedThreadPool();
            es.execute(new Runnable() {
                @Override
                public void run() {
                    upperEvenThread.calc();
                }
            });
            es.execute(new Runnable() {
                @Override
                public void run() {
                    lowerEvenThread.calc();
                }
            });
            es.shutdown();
            es.awaitTermination(300, TimeUnit.MILLISECONDS);
            if (es.isShutdown())
                return UpperEvenThread.getOutUpperEven().multiply(LowerEvenThread.getOutLowerEven());
            return null;
        } else {
            UpperOddThread upperOddThread = new UpperOddThread(n);
            LowerOddThread lowerOddThread = new LowerOddThread(n);
            ExecutorService es = Executors.newCachedThreadPool();
            es.execute(new Runnable() {
                @Override
                public void run() {
                    upperOddThread.calc();
                }
            });
            es.execute(new Runnable() {
                @Override
                public void run() {
                    lowerOddThread.calc();
                }
            });
            es.shutdown();
            es.awaitTermination(300, TimeUnit.MILLISECONDS);
            if (es.isShutdown())
                return UpperOddThread.getOutUpperOdd().multiply(LowerOddThread.getOutLowerOdd());
            return null;
        }
    }
    public static void factorialNonThread(long n){
        if(isItEven(n)){
            UpperEvenThread upperEvenThread = new UpperEvenThread(n);
            LowerEvenThread lowerEvenThread = new LowerEvenThread(n);
            upperEvenThread.calc();
            lowerEvenThread.calc();
            System.out.println(UpperEvenThread.getOutUpperEven().multiply(LowerEvenThread.getOutLowerEven()));
        }else{
            UpperOddThread upperOddThread = new UpperOddThread(n);
            LowerOddThread lowerOddThread = new LowerOddThread(n);
            upperOddThread.calc();
            lowerOddThread.calc();
            System.out.println(UpperOddThread.getOutUpperOdd().multiply(LowerOddThread.getOutLowerOdd()));
        }
    }
    public static boolean isItEven(long n){
        String longVal=String.valueOf(n);
        return Pattern.matches("^[0-9]*[02468]$", longVal);
    }
}
