
/** Runs all the tests using a textual runner.  This is the
 *  alternative to running all the tests within your favorite
 *  development environment (DrJava, Eclipse...).  This may require
 *  downloading JUnit from <a href="www.junit.org">www.junit.org</a>.
 *
 * <pre>
 * > javac -cp junit-4.12.jar:hamcrest-core-1.3.jar:. GameModelJUnitTest.java
 * > java -cp junit-4.12.jar:hamcrest-core-1.3.jar:. GameModelJUnitTest
 * </pre>
 *
 * Requires JUnit 4.12 or higher.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 * @author GV Jourdan (gjourdan@uottawa.ca)
 */


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

import org.junit.AfterClass;


public class TicTacToeGameTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested
    private static double DoorLock_grade = 0.0;
    @AfterClass
    public static void afterClass() {

       

        System.out.println("Grade for DoorLock (out of possible 50): " + DoorLock_grade);

        

    }
    @Test
    public void testDefaultConstructor() {
        TicTacToeGame g = new TicTacToeGame();
        assertEquals(3, g.getLines());
        assertEquals(3, g.getColumns());
        assertEquals(3, g.getSizeWin());
        assertEquals(0, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        DoorLock_grade += 1;
    }

    @Test
    public void testConstructor2X2() {
        TicTacToeGame g = new TicTacToeGame(2,2);
        assertEquals(2, g.getLines());
        assertEquals(2, g.getColumns());
        assertEquals(3, g.getSizeWin());
        assertEquals(0, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        DoorLock_grade += 1;
    }


    @Test
    public void testConstructor5X2() {
        TicTacToeGame g = new TicTacToeGame(5,2);
        assertEquals(5, g.getLines());
        assertEquals(2, g.getColumns());
        assertEquals(3, g.getSizeWin());
        assertEquals(0, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        DoorLock_grade += 1;
    }

    @Test
    public void testConstructor2X5() {
        TicTacToeGame g = new TicTacToeGame(2,5);
        assertEquals(2, g.getLines());
        assertEquals(5, g.getColumns());
        assertEquals(3, g.getSizeWin());
        assertEquals(0, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        DoorLock_grade += 1;
   }

    @Test
    public void testConstructor2X2X2() {
        TicTacToeGame g = new TicTacToeGame(2,2,2);
        assertEquals(2, g.getLines());
        assertEquals(2, g.getColumns());
        assertEquals(2, g.getSizeWin());
        assertEquals(0, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        DoorLock_grade += 1;
    }

    @Test
    public void testConstructor5X2X4() {
        TicTacToeGame g = new TicTacToeGame(5,2,4);
        assertEquals(5, g.getLines());
        assertEquals(2, g.getColumns());
        assertEquals(4, g.getSizeWin());
        assertEquals(0, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        DoorLock_grade += 1;
   }

    @Test
    public void testConstructor2X5X4() {
        TicTacToeGame g = new TicTacToeGame(2,5,4);
        assertEquals(2, g.getLines());
        assertEquals(5, g.getColumns());
        assertEquals(4, g.getSizeWin());
        assertEquals(0, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        DoorLock_grade += 1;
    }

    @Test
    public void testDefaultConstructorInitValues() {
        TicTacToeGame g = new TicTacToeGame();
        for(int i =0 ; i < 9; i++)
            assertEquals(CellValue.EMPTY, g.valueAt(i));
        DoorLock_grade += 1;
    }

    @Test
    public void testConstructorInitValues2X5() {
        TicTacToeGame g = new TicTacToeGame(2,5);
        for(int i =0 ; i < 10; i++)
            assertEquals(CellValue.EMPTY, g.valueAt(i));
        DoorLock_grade += 1;
    }


    @Test
    public void testConstructorInitValues5X2() {
        TicTacToeGame g = new TicTacToeGame(5,2);
        for(int i =0 ; i < 10; i++)
            assertEquals(CellValue.EMPTY, g.valueAt(i));
        DoorLock_grade += 1;
    }

    @Test
    public void testConstructorInitValues4X5X4() {
        TicTacToeGame g = new TicTacToeGame(4,5,4);
        for(int i =0 ; i < 20; i++)
            assertEquals(CellValue.EMPTY, g.valueAt(i));
        DoorLock_grade += 1;
    }

    @Test
    public void testPlay3X3() {
        TicTacToeGame g = new TicTacToeGame(3,3);
        for(int i =0 ; i < 9; i++) {
            g.play(i);
            if(i%2 == 0) {
                assertEquals(CellValue.X, g.valueAt(i));
            } else {
                assertEquals(CellValue.O, g.valueAt(i));                
            }
        }
        DoorLock_grade += 1;
    }

    @Test
    public void testPlay5X2() {
        TicTacToeGame g = new TicTacToeGame(5,2);
        for(int i =0 ; i < 10; i++) {
            g.play(i);
            if(i%2 == 0) {
                assertEquals(CellValue.X, g.valueAt(i));
            } else {
                assertEquals(CellValue.O, g.valueAt(i));                
            }
        }
        DoorLock_grade += 1;
    }

    @Test
    public void testPlay2x5() {
        TicTacToeGame g = new TicTacToeGame(2,5);
        for(int i =0 ; i < 10; i++) {
            g.play(i);
            if(i%2 == 0) {
                assertEquals(CellValue.X, g.valueAt(i));
            } else {
                assertEquals(CellValue.O, g.valueAt(i));                
            }
        }
        DoorLock_grade += 1;
    }

    @Test
    public void testGameStateDefaultFirstLineX() {
        TicTacToeGame g = new TicTacToeGame();
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState3x3FirstLineO() {
        TicTacToeGame g = new TicTacToeGame(3,3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.OWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState3x3SecondColumnX() {
        TicTacToeGame g = new TicTacToeGame(3,3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState2x5FirstLineX() {
        TicTacToeGame g = new TicTacToeGame(2,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState2x5x4FirstLineX() {
        TicTacToeGame g = new TicTacToeGame(2,5,4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState2x5x5FirstLineX() {
        TicTacToeGame g = new TicTacToeGame(2,5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(9);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }


    @Test
    public void testGameState2x5FirstLineO() {
        TicTacToeGame g = new TicTacToeGame(2,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.OWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState5x5MiddleLineX() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(11);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(13);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(12);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState5x5x5MiddleLineX() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(11);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(13);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(14);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(15);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(10);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(18);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(12);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }
   @Test
    public void testGameState5x5MiddleColumnX() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(12);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(17);
        assertEquals(GameState.OWIN, g.getGameState());
        DoorLock_grade += 1;
    }


    @Test
    public void testGameState3x3FirstDiagX() {
        TicTacToeGame g = new TicTacToeGame(3,3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState3x3SecondDiagO() {
        TicTacToeGame g = new TicTacToeGame(3,3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(8);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.OWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState3x3Draw() {
        TicTacToeGame g = new TicTacToeGame(3,3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(8);
        assertEquals(GameState.DRAW, g.getGameState());
        DoorLock_grade += 1;
    }


    @Test
    public void testGameState5x5MainDiagX() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(12);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(18);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState5x5x4MainDiagX() {
        TicTacToeGame g = new TicTacToeGame(5,5,4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(12);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(18);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(24);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState5x5x4SecondDiagX() {
        TicTacToeGame g = new TicTacToeGame(5,5,4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(19);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(13);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(11);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }


    @Test
    public void testGameState5x5MainCounterDiagO() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(8);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(12);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(18);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(16);
        assertEquals(GameState.OWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState5x5x5MainCounterDiagO() {
        TicTacToeGame g = new TicTacToeGame(5,5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(6);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(8);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(12);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(18);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(16);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(20);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.OWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testGameState5x5SecondCounterDiagO() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(14);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(8);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(18);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(22);
        assertEquals(GameState.OWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testWrapAroundColumn1() {
        TicTacToeGame g = new TicTacToeGame();
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testWrapAroundColumn2() {
        TicTacToeGame g = new TicTacToeGame();
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testWrapAroundLine1() {
        TicTacToeGame g = new TicTacToeGame(4,3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(10);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testWrapAroundLine2() {
        TicTacToeGame g = new TicTacToeGame(4,3);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(10);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState());
        g.play(7);
        assertEquals(GameState.PLAYING, g.getGameState());
        DoorLock_grade += 1;
    }


    @Test
    public void testGameGetLevel5x5() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        for(int i = 0; i < 25; i++){
            assertEquals(i, g.getLevel());
            g.play(i);
        }
        assertEquals(25, g.getLevel());
        DoorLock_grade += 1;
    }

    @Test
    public void testNextCellValue5x5() {
        TicTacToeGame g = new TicTacToeGame(5,5);
        for(int i = 0; i < 25; i++){
            if(i%2 == 0) {
                assertEquals(CellValue.X, g.nextCellValue());
            } else {
                assertEquals(CellValue.O, g.nextCellValue());                
            }
            g.play(i);
        }
        DoorLock_grade += 1;
    }

    @Test
    public void testGameGetLevel6x5x4() {
        TicTacToeGame g = new TicTacToeGame(6,5,4);
        for(int i = 0; i < 30; i++){
            assertEquals(i, g.getLevel());
            g.play(i);
        }
        assertEquals(30, g.getLevel());
        DoorLock_grade += 1;
    }

    @Test
    public void testNextCellValue6x5x4() {
        TicTacToeGame g = new TicTacToeGame(6,5,4);
        for(int i = 0; i < 30; i++){
            if(i%2 == 0) {
                assertEquals(CellValue.X, g.nextCellValue());
            } else {
                assertEquals(CellValue.O, g.nextCellValue());                
            }
            g.play(i);
        }
        DoorLock_grade += 1;
    }
    
// new tests below

    @Test
    public void testMoreThanSizeWin() {
        TicTacToeGame g = new TicTacToeGame(6,6,4);
        g.play(7);
        g.play(13);
        g.play(8);
        g.play(14);
        g.play(10);
        g.play(16);
        g.play(11);
        g.play(17);
        DoorLock_grade += 1;
        assertEquals(GameState.PLAYING, g.getGameState()); 
        g.play(9);
        assertEquals(GameState.XWIN, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testNotInARow() {
        TicTacToeGame g = new TicTacToeGame();
        g.play(0);
        g.play(3);
        g.play(4);
        g.play(1);
        g.play(2);
        assertEquals(GameState.PLAYING, g.getGameState());
        DoorLock_grade += 1;
    }

    @Test
    public void testKeepPlayingWinnerDoesntChange() {
        TicTacToeGame g = new TicTacToeGame(3,3);
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState()); 
        g.play(3);
        assertEquals(GameState.PLAYING, g.getGameState()); 
        g.play(1);
        assertEquals(GameState.PLAYING, g.getGameState()); 
        g.play(4);
        assertEquals(GameState.PLAYING, g.getGameState()); 
        g.play(2);
        assertEquals(GameState.XWIN, g.getGameState()); 
        assertEquals(5, g.getLevel());
        assertEquals(CellValue.O, g.nextCellValue());
        g.play(5);
        assertEquals(GameState.XWIN, g.getGameState()); 
        assertEquals(6, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        g.play(6);
        DoorLock_grade += 1;
        assertEquals(GameState.XWIN, g.getGameState()); 
        assertEquals(7, g.getLevel());
        assertEquals(CellValue.O, g.nextCellValue());
        g.play(7);
        assertEquals(GameState.XWIN, g.getGameState()); 
        assertEquals(8, g.getLevel());
        assertEquals(CellValue.X, g.nextCellValue());
        g.play(8);
        assertEquals(GameState.XWIN, g.getGameState()); 
        assertEquals(9, g.getLevel());
        assertEquals(CellValue.O, g.nextCellValue());
        DoorLock_grade += 1;

    }

    @Test
    public void testDoesntCrashOutOfRangeTooBig() {
        TicTacToeGame g = new TicTacToeGame();
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.O, g.nextCellValue());
        assertEquals(1, g.getLevel());
        try{ 
            g.play(11);
        } catch(Exception e) {};// trying to continue even with
                                // the code throws some exception 
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.O, g.nextCellValue());
        assertEquals(1, g.getLevel());
        DoorLock_grade += 1;
    }


    @Test
    public void testDoesntCrashOutOfRangeTooSmall() {
        TicTacToeGame g = new TicTacToeGame(4,4,3);
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.O, g.nextCellValue());
        assertEquals(1, g.getLevel());
        try{ 
            g.play(-5);
        } catch(Exception e) {};
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.O, g.nextCellValue());
        assertEquals(1, g.getLevel());
        DoorLock_grade += 1;
   }

    @Test
    public void testInvalidDoesntChangeState() {
        TicTacToeGame g = new TicTacToeGame(4,4,3);
        g.play(0);
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.O, g.nextCellValue());
        assertEquals(1, g.getLevel());
       try{ 
            g.play(0);
        } catch(Exception e) {};
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.O, g.nextCellValue());
        assertEquals(1, g.getLevel());
        g.play(1);
        
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.X, g.nextCellValue());
        assertEquals(2, g.getLevel());
        DoorLock_grade += 1;
        try{ 
            g.play(1);
        } catch(Exception e) {};
        assertEquals(GameState.PLAYING, g.getGameState()); 
        assertEquals(CellValue.X, g.nextCellValue());
        assertEquals(2, g.getLevel());
        DoorLock_grade += 1;

    }


    /**
     * Runs the test suite using the textual runner.
     *
     * @param args reference to the array of values passed on the command lines
     */

    public static void main( String[] args ) {

        TestUtils.runClass(TicTacToeGameTest.class);
        
    }
}
