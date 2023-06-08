import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class TestL11BitList {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @Before
    public void setUp() {

    }

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Iterative (out of possible 2.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testBitListConstructorOneBit0() {
        try {
            BitList list = new BitList("0");
            assertEquals("Constructor with a bne bit string: 0", "0", list.toString());
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }


    @Test
    public void testBitListConstructorOneBit1() {
        try{
            BitList list = new BitList("1");
            assertEquals("Constructor with a bne bit string: 1", "1", list.toString());
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testBitListConstructorMultipleBits() {
        try{
            BitList list = new BitList("100111");
            assertEquals("Constructor with a multiple-bit string: 100111", "100111", list.toString());
            grade += 1;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL11BitList.class);

    }

}
