import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void isSameNumberTest() {
        int a = 100;
        int b = 100;
        int c = 200;

        assertEquals(true, Flik.isSameNumber(a, b));
        assertEquals(false, Flik.isSameNumber(a, c));
    }
}
