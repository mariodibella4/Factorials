import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialsHandlerTest {

    @Test
    public void factorial() {
        BigInteger result = null;
        try {
            result = FactorialsHandler.factorial(19);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       BigInteger expected= BigInteger.valueOf(121645100408832000L);
       assertEquals(expected,result);
    }
}