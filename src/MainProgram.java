import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MainProgram {
    public static void main(String[] args){
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
        Date date = new Date();
        System.out.println("Start Time: "+formatter.format(date));
       try {
           System.out.println(FactorialsHandler.factorial(901000));
          //factorialsHandler.factorialNonThread(901000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date1 = new Date();
        System.out.println("End Time: "+formatter.format(date1));

    }
}
