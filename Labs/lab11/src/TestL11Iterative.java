import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class TestL11Iterative {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @Before
    public void setUp() {

    }

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Iterative (out of possible 8.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testComplementSingle0() {
        try{
            BitList list = new BitList("0");
            Iterative it = new Iterative();
            BitList listComp = it.complement(list);
            int bit = listComp.removeFirst();
            assertEquals(1, bit);
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testComplementSingle1() {
        try{
            BitList list = new BitList("1");
            Iterative it = new Iterative();
            BitList listComp = it.complement(list);
            int bit = listComp.removeFirst();
            assertEquals(0, bit);
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testComplementMultiple() {
        try{
            BitList list = new BitList("1011");
            Iterative it = new Iterative();
            BitList listComp = it.complement(list);
            int bit1 = listComp.removeFirst();
            int bit2 = listComp.removeFirst();
            int bit3 = listComp.removeFirst();
            int bit4 = listComp.removeFirst();

            assertEquals(0, bit1);
            assertEquals(0, bit2);
            assertEquals(1, bit3);
            assertEquals(0, bit4);

            grade += 1;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testOrExceptionsNotTheSameLength() {

        try {
            BitList list2 = new BitList("1");
            BitList list3 = new BitList("10");
            Iterative it = new Iterative();
            BitList list4;

            list4 = it.or(list2, list3);
            fail("list.or on lists of different length was expected to throw IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testOrExceptionsEmptyEmpty() {

        try {
            BitList list0 = new BitList("");
            BitList list1 = new BitList("");
            Iterative it = new Iterative();
            BitList list4;

            list4 = it.or(list0, list1);
            fail("list.or on empty lists was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testAndExceptionsNotTheSameLength() {

        try {
            BitList list2 = new BitList("1");
            BitList list3 = new BitList("10");
            Iterative it = new Iterative();
            BitList list4;

            list4 = it.and(list2, list3);
            fail("list.and on lists of different length was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testAndExceptionsEmptyEmpty() {

        try {
            BitList list0 = new BitList("");
            BitList list1 = new BitList("");
            Iterative it = new Iterative();
            BitList list4;

            list4 = it.and(list0, list1);
            fail("list.and on empty lists was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void testXorExceptionsNotTheSameLength() {

        try {
            BitList list2 = new BitList("1");
            BitList list3 = new BitList("10");
            Iterative it = new Iterative();
            BitList list4;

            list4 = it.xor(list2, list3);
            fail("list.xor on lists of different length was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testXorExceptionsEmptyEmpty() {

        try {
            BitList list0 = new BitList("");
            BitList list1 = new BitList("");
            Iterative it = new Iterative();
            BitList list4;

            list4 = it.xor(list0, list1);
            fail("list.xor on empty lists was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            grade += 0.5;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }

    }


    @Test
    public void testOr() {
        try{

            BitList list1 = new BitList("10001");
            BitList list2 = new BitList("00011");
            Iterative it = new Iterative();

            BitList list3 = it.or(list1, list2);

            int bit1 = list3.removeFirst();
            int bit2 = list3.removeFirst();
            int bit3 = list3.removeFirst();
            int bit4 = list3.removeFirst();
            int bit5 = list3.removeFirst();

            assertEquals(1, bit1);
            assertEquals(1, bit2);
            assertEquals(0, bit3);
            assertEquals(0, bit4);
            assertEquals(1, bit5);

            grade += 1;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testAnd() {
        try {
            BitList list1 = new BitList("10001");
            BitList list2 = new BitList("00011");
            Iterative it = new Iterative();

            BitList list3 = it.and(list1, list2);

            int bit1 = list3.removeFirst();
            int bit2 = list3.removeFirst();
            int bit3 = list3.removeFirst();
            int bit4 = list3.removeFirst();
            int bit5 = list3.removeFirst();

            assertEquals(1, bit1);
            assertEquals(0, bit2);
            assertEquals(0, bit3);
            assertEquals(0, bit4);
            assertEquals(0, bit5);

            grade += 1;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void testXor() {
        try{
            BitList list1 = new BitList("10001");
            BitList list2 = new BitList("00011");
            Iterative it = new Iterative();

            BitList list3 = it.xor(list1, list2);

            int bit1 = list3.removeFirst();
            int bit2 = list3.removeFirst();
            int bit3 = list3.removeFirst();
            int bit4 = list3.removeFirst();
            int bit5 = list3.removeFirst();

            assertEquals(0, bit1);
            assertEquals(1, bit2);
            assertEquals(0, bit3);
            assertEquals(0, bit4);
            assertEquals(1, bit5);

            grade += 1;
        } catch (Exception e){
            e.printStackTrace();
            fail(e.toString());
        }
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL11Iterative.class);

    }

}
