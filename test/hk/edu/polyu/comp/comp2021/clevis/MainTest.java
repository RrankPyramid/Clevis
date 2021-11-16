package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.ArrayList;

public class MainTest extends TestCase {

    Vertex v1 = new Vertex(0, 0);
    Vertex v2 = new Vertex(100, 100);
    Vertex v3 = new Vertex(200, 100);
    Vertex v4 = new Vertex(100, 200);
    Vector vector = new Vector(300, 400);
    Main testMain = new Main();

    @Before
    public void before() {
        testMain.createRectangle("r1", 100, 100, 200, 400);
        testMain.createSquare("s1", 300, 300, 200);
        testMain.createLine("l1", 400, 400, 200, 400);
        testMain.createCircle("c1", 300, 300, 200);
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("l1");
        testList.add("r1");
        testList.add("c1");
        testMain.createGroup("g1", testList);
    }

    public void testCreateRectangle() {
        testMain.createRectangle("r2", 100, 100, 200, 400);
        assert true;
    }

    public void testCreateSquare() {
        testMain.createSquare("s2", 300, 300, 200);
        assert true;
    }

    public void testCreateLine() {
        testMain.createLine("l2", 400, 400, 200, 400);
        assert true;
    }

    public void testCreateCircle() {
        testMain.createCircle("c2", 300, 300, 200);
        assert true;
    }

    public void testAlreadyExist() {
        assertFalse(testMain.isExist("c2"));
        testMain.createCircle("c1", 300, 300, 200);
        assertTrue(testMain.isExist("c1"));
    }

    public void testExistErr() {
        testMain.existErr("c2");
        assert true;
    }

    public void testCreateSuccess() {
        testMain.createSuccess();
        assert true;
    }

    public void testCreateGroup() {
        testMain.createRectangle("r1", 100, 100, 200, 400);
        testMain.createSquare("s1", 300, 300, 200);
        testMain.createLine("l1", 400, 400, 200, 400);
        testMain.createCircle("c1", 300, 300, 200);
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("l1");
        testList.add("r1");
        testList.add("c1");
        testMain.createGroup("g1", testList);
    }


    public void testUnGroup() {
        testMain.createRectangle("r1", 100, 100, 200, 400);
        testMain.createSquare("s1", 300, 300, 200);
        testMain.createLine("l1", 400, 400, 200, 400);
        testMain.createCircle("c1", 300, 300, 200);
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("l1");
        testList.add("r1");
        testList.add("c1");
        testMain.createGroup("g1", testList);
        testMain.unGroup("g1");
    }

    public void testPickAndMove() {
        testMain.createLine("l1", 20, 20, 400, 400);
        testMain.pickAndMove(100, 50, 50, 0);
        testMain.pickAndMove(100, 100, 50, 0);
        assert true;
    }

    public void testDelete() {
        testMain.createCircle("c1", 100, 100, 20);
        testMain.delete("c1");
    }

    public void testListAll() {
        testMain.createRectangle("r1", 100, 100, 200, 400);
        testMain.createSquare("s1", 300, 300, 200);
        testMain.createSquare("s2", 300, 200, 500);
        testMain.createLine("l1", 400, 400, 200, 400);
        testMain.createCircle("c1", 300, 300, 200);
        ArrayList<String> testList = new ArrayList<String>();
        ArrayList<String> testList_2 = new ArrayList<String>();
        testList.add("l1");
        testList.add("c1");
        testList_2.add("s2");
        testList_2.add("g1");
        testMain.createGroup("g1", testList);
        testMain.createGroup("g2", testList_2);
        testMain.listAll();
    }

    public void testErr() {
        testMain.err();
        assert true;
    }

    public void testGetCommand() {
        String cmd_1 = "circle c1 100 200 300";
        assertTrue(testMain.getCommand(cmd_1));
        String cmd_1_wrong = "circle c1 100 200";
        assertTrue(testMain.getCommand(cmd_1_wrong));

        String cmd_2 = "rectangle r1 100 200 300";
        assertTrue(testMain.getCommand(cmd_2));
        String cmd_2_wrong = "rectangle r1 100";
        assertTrue(testMain.getCommand(cmd_2_wrong));

        String cmd_3 = "line l1 100 200 300 400";
        assertTrue(testMain.getCommand(cmd_3));
        String cmd_3_wrong = "line 100 200 400 100";
        assertTrue(testMain.getCommand(cmd_3_wrong));

        String cmd_4 = "square s1 100 200 300";
        assertTrue(testMain.getCommand(cmd_4));
        String cmd_4_wrong = "square s1 100 200 300 100";
        assertTrue(testMain.getCommand(cmd_4_wrong));

        String cmd_5 = "group g1 c1 r1 s1";
        assertTrue(testMain.getCommand(cmd_5));
        String cmd_5_wrong = "group g2";
        assertTrue(testMain.getCommand(cmd_5_wrong));

        String cmd_6 = "ungroup g1";
        assertTrue(testMain.getCommand(cmd_6));
        String cmd_6_wrong = "ungroup";
        assertTrue(testMain.getCommand(cmd_6_wrong));

        String cmd_7 = "list l1";
        assertTrue(testMain.getCommand(cmd_7));
        String cmd_7_wrong = "list l1 l2";
        assertTrue(testMain.getCommand(cmd_7_wrong));

        String cmd_8 = "listAll";
        assertTrue(testMain.getCommand(cmd_8));
        String cmd_8_wrong = "listAll l1";
        assertTrue(testMain.getCommand(cmd_8_wrong));

        String cmd_9 = "move";
        assertTrue(testMain.getCommand(cmd_9));
        String cmd_9_wrong = "listAll l1";
        assertTrue(testMain.getCommand(cmd_9_wrong));

        String cmd_10 = "boundingbox l1";
        assertTrue(testMain.getCommand(cmd_10));
        String cmd_10_wrong = "boundingbox";
        assertTrue(testMain.getCommand(cmd_10_wrong));

        String cmd_11 = "delete l1";
        assertTrue(testMain.getCommand(cmd_11));
        String cmd_11_wrong = "delete";
        assertTrue(testMain.getCommand(cmd_11_wrong));

        String cmd_12 = "pick-and-move 100 200 30 40";
        assertTrue(testMain.getCommand(cmd_12));
        String cmd_12_wrong = "pick-and-move";
        assertTrue(testMain.getCommand(cmd_12_wrong));

        String cmd_13 = "listAll";
        assertTrue(testMain.getCommand(cmd_13));
        String cmd_13_wrong = "listAll l1";
        assertTrue(testMain.getCommand(cmd_13_wrong));

        String quit = "quit";
        assertFalse(testMain.getCommand(quit));

    }

    public void testWriteTxt() {
        String cmd_1 = "circle c1 100 200 300";
        String cmd_2 = "rectangle r1 100 200 300";
        ArrayList<String> testCommand = new ArrayList<>();
        testCommand.add(cmd_1);
        testCommand.add(cmd_2);

        Main.writeInTxt(testCommand, "test.txt");
        assert true;
    }

    public void testWriteInHtml() {
        String cmd_1 = "circle c1 100 200 300";
        String cmd_2 = "rectangle r1 100 200 300";
        ArrayList<String> testCommand = new ArrayList<>();
        testCommand.add(cmd_1);
        testCommand.add(cmd_2);

        Main.writeInHtml(testCommand, "test.html");
        assert true;
    }
}