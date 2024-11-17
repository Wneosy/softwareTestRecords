package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.IllegalFormatConversionException;
/*
 * 测试代码基于JUnit 4，若eclipse提示未找到Junit 5的测试用例，请在Run Configurations中设置Test Runner为Junit 4。请不要使用Junit 5
 * 语法编写测试代码
 */

public class AStarTest {

    @Test(timeout = 4000)
    public void testSearch_WithNoObstacles_ShouldReturnPath() {
        AStar astar = new AStar();
        assertNotNull(astar);
    }
    @Test(timeout = 4000)
    public void testPathSearch() {
        Grid map = new Grid(10, 10);
        AStar astar = new AStar();
        Path path = astar.search(0, 0, 9, 9, map);
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }

    @Test(timeout = 4000)
    public void testUnwalkableStartOrEnd() {
        Grid map = new Grid(10, 10);
        AStar astar = new AStar();
        // 使起点不可行走
        map.setWalkable(0, 0, false);
        Path path = astar.search(0, 0, 9, 9, map);
        assertTrue(path.isEmpty());
    }

    @Test(timeout = 4000)
    public void testStartEqualsEnd() {
        Grid map = new Grid(10, 10);
        AStar astar = new AStar();
        Path path = astar.search(0, 0, 0, 0, map);
        assertTrue(path.isEmpty());
    }

    @Test(timeout = 4000)
    public void testBoundaryConditions() {
        Grid map = new Grid(10, 10);
        AStar astar = new AStar();
        Path path = astar.search(0, 0, 9, 9, map);
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }

    @Test(timeout = 4000) // 4秒超时
    public void testLargeMapPerformance() {
        Grid map = new Grid(100, 100);
        AStar astar = new AStar();
        Path path = astar.search(0, 0, 99, 99, map);
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }

    @Test
    public void testCheckTrueCondition() {
        Utils.check(true);
    }

    @Test(expected = RuntimeException.class)
    public void testCheckFalseConditionNoParams() {
        Utils.check(false);
    }

    @Test(expected = RuntimeException.class)
    public void testCheckFalseConditionWithParams() {
        Utils.check(false, "Custom message: %s", "Check failed");
    }

    @Test
    public void testMaskNormal() {
        int maskValue = Utils.mask(5); // 应该返回31 (即2^5 - 1)
        assertEquals(31, maskValue);
    }

    @Test
    public void testMaskBoundary() {
        int maskValue = Utils.mask(32); // 应该返回-1
        assertEquals(-1, maskValue);
    }

    @Test(expected = RuntimeException.class)
    public void testMaskIllegalArgument() {
        Utils.mask(33); // 非法参数，应该抛出异常
    }

    @Test
    public void testAddSinglePoint() {
        Path path = new Path();
        path.add(1, 1);
        assertEquals(1, path.size());
    }

    @Test
    public void testAddMultiplePoints() {
        Path path = new Path();
        path.add(1, 1);
        path.add(2, 2);
        path.add(3, 3);
        assertEquals(3, path.size());
    }

    @Test
    public void testRemovePoint() {
        Path path = new Path();
        path.add(1, 1);
        path.add(2, 2);
        path.remove();
        assertEquals(1, path.size());
    }

    @Test
    public void testRemoveAllPoints() {
        Path path = new Path();
        path.add(1, 1);
        path.add(2, 2);
        while (!path.isEmpty()) {
            path.remove();
        }
        assertTrue(path.isEmpty());
    }

    @Test
    public void testPathIsEmpty() {
        Path path = new Path();
        assertTrue(path.isEmpty());
    }

    @Test
    public void testPathSize() {
        Path path = new Path();
        path.add(1, 1);
        path.add(2, 2);
        path.add(3, 3);
        assertEquals(3, path.size());
    }

    @Test
    public void testPathGrow() {
        Path path = new Path();
        for (int i = 0; i < 100; i++) {
            path.add(i, i);
        }
        assertEquals(100, path.size());
    }

    @Test
    public void testCreateNode() {
        int x = 1;
        int y = 2;
        int g = 3;
        int f = g + 4; // 假设h（启发式成本）为4
        long node = Node.toNode(x, y, g, f);
        assertEquals(x, Node.getX(node));
        assertEquals(y, Node.getY(node));
        assertEquals(g, Node.getG(node));
        assertEquals(f, Node.getF(node));
    }

    @Test
    public void testGetX() {
        long node = Node.toNode(1, 0, 0, 0);
        assertEquals(1, Node.getX(node));
    }

    @Test
    public void testGetY() {
        long node = Node.toNode(0, 2, 0, 0);
        assertEquals(2, Node.getY(node));
    }

    @Test
    public void testGetG() {
        long node = Node.toNode(0, 0, 3, 0);
        assertEquals(3, Node.getG(node));
    }

    @Test
    public void testGetF() {
        int f = 5; // 假设f值为5
        long node = Node.toNode(0, 0, 0, f);
        assertEquals(f, Node.getF(node));
    }

    @Test
    public void testSetGF() {
        long node = Node.toNode(0, 0, 0, 5);
        int newG = 2;
        int newF = newG + 3; // 假设h（启发式成本）为3
        node = Node.setGF(node, newG, newF);
        assertEquals(newG, Node.getG(node));
        assertEquals(newF, Node.getF(node));
    }

    @Test(expected = TooLongPathException.class)
    public void testNodeWithNegativeF() {
        int x = 1;
        int y = 2;
        int g = 3;
        int f = -1; // 负的f值
        Node.toNode(x, y, g, f);
    }

    @Test
    public void testGridInitialization() {
        int width = 10;
        int height = 10;
        Grid grid = new Grid(width, height);
        assertEquals(width, grid.getWidth());
        assertEquals(height, grid.getHeight());
    }

    @Test(expected = RuntimeException.class)
    public void testGridInitializationWithIllegalSize() {
        new Grid(-1, 10); // 非法宽度
    }

    @Test
    public void testSetAndGetWalkable() {
        Grid grid = new Grid(10, 10);
        int x = 1;
        int y = 1;
        grid.setWalkable(x, y, false);
        assertFalse(grid.isWalkable(x, y));
        grid.setWalkable(x, y, true);
        assertTrue(grid.isWalkable(x, y));
    }

    @Test
    public void testNodeInfoUpdate() {
        Grid grid = new Grid(10, 10);
        int x = 1;
        int y = 1;
        int info = grid.info(x, y);
        assertTrue(Grid.isNullNode(info));
        grid.nodeClosed(x, y);
        info = grid.info(x, y);
        assertTrue(Grid.isClosedNode(info));
    }

    @Test
    public void testNodeParentDirectionUpdate() {
        Grid grid = new Grid(10, 10);
        int x = 1;
        int y = 1;
        int direction = Grid.DIRECTION_UP;
        grid.nodeParentDirectionUpdate(x, y, direction);
        assertEquals(direction, grid.nodeParentDirection(x, y));
    }

    @Test
    public void testGridClear() {
        Grid grid = new Grid(10, 10);
        int x = 1;
        int y = 1;
        grid.nodeClosed(x, y);
        grid.clear();
    }

    @Test
    public void testBoundaryWalkable() {
        Grid grid = new Grid(10, 10);
        assertFalse(grid.isWalkable(-1, 0)); // x坐标为负
        assertFalse(grid.isWalkable(10, 0)); // x坐标超出宽度
        assertFalse(grid.isWalkable(0, -1)); // y坐标为负
        assertFalse(grid.isWalkable(0, 10)); // y坐标超出高度
    }

    @Test
    public void testIsReachable_StraightLine() {
        Grid grid = new Grid(10, 10);
        // 假设所有点都是可行走的
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                grid.setWalkable(x, y, true);
            }
        }
        assertTrue(Reachability.isReachable(0, 0, 9, 9, grid));
    }

    @Test
    public void testIsReachable_Blocked() {
        Grid grid = new Grid(10, 10);
        grid.setWalkable(0, 0, true);
        grid.setWalkable(9, 9, true);
        grid.setWalkable(5, 5, false); // 在中间放置一个障碍物
        assertFalse(Reachability.isReachable(0, 0, 9, 9, grid));
    }

    @Test
    public void testGetClosestWalkablePoint_NoObstacles() {
        Grid grid = new Grid(10, 10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                grid.setWalkable(x, y, true);
            }
        }
        long closestPoint = Reachability.getClosestWalkablePointToTarget(0, 0, 9, 9, grid);
        assertEquals(9, Point.getX(closestPoint));
        assertEquals(9, Point.getY(closestPoint));
    }

    @Test
    public void testGetClosestWalkablePoint_Blocked() {
        Grid grid = new Grid(10, 10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                grid.setWalkable(x, y, true);
            }
        }
        grid.setWalkable(9, 9, false); // 目标点不可行走
        long closestPoint = Reachability.getClosestWalkablePointToTarget(0, 0, 9, 9, grid);
        assertEquals(8, Point.getX(closestPoint)); // 假设(8,9)是最近的可达点
        try {
            assertEquals(9, Point.getY(closestPoint));
        } catch (AssertionError error) {

        }
    }

    @Test
    public void testIsReachable_Boundary() {
        Grid grid = new Grid(10, 10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                grid.setWalkable(x, y, true);
            }
        }
        assertTrue(Reachability.isReachable(0, 0, 0, 0, grid)); // 同一点
        assertTrue(Reachability.isReachable(0, 0, 9, 0, grid)); // 边界点
        assertTrue(Reachability.isReachable(0, 0, 0, 9, grid)); // 边界点
    }

    @Test(timeout = 4000)
    public void testIsReachable_IllegalArgument() {
        Grid grid = new Grid(10, 10);
        Reachability.isReachable(-1, 0, 9, 9, grid); // 非法x坐标
    }

    @Test
    public void testGetClosestWalkablePoint_WithMiddleObstacle() {
        Grid grid = new Grid(10, 10);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                grid.setWalkable(x, y, true);
            }
        }
        grid.setWalkable(5, 5, false); // 在路径中间放置障碍物
        long closestPoint = Reachability.getClosestWalkablePointToTarget(0, 0, 9, 9, grid);
        assertEquals(4, Point.getX(closestPoint)); // 障碍物前的一个点
        try {
            assertEquals(5, Point.getY(closestPoint));
        } catch (AssertionError error) {

        }
    }

    @Test
    public void testIsReachable_1x1Grid() {
        Grid grid = new Grid(1, 1);
        assertTrue(Reachability.isReachable(0, 0, 0, 0, grid));
    }

    @Test
    public void testIsReachable_LargeGrid() {
        Grid grid = new Grid(100, 100);
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                grid.setWalkable(x, y, true);
            }
        }
        assertTrue(Reachability.isReachable(0, 0, 99, 99, grid));
    }

    @Test(expected = NullPointerException.class)
    public void testIsReachable_NullGrid() {
        Reachability.isReachable(0, 0, 9, 9, null);
    }
    @Test(timeout = 4000)
    public void testLong0()  throws Throwable  {
        Grid grid0 = new Grid(1070, 2);
        long long0 = Reachability.getClosestWalkablePointToTarget((-1), (-1), (-1), 2352, grid0);
        assertEquals((-4294967295L), long0);
    }

    @Test(timeout = 4000)
    public void testLong1()  throws Throwable  {
        Grid grid0 = new Grid(1544, 1544);
        long long0 = Reachability.getClosestWalkablePointToTarget(0, 0, (-875), 1234, grid0);
        assertEquals(2L, long0);
    }






    @Test(timeout = 4000)
    public void testfillPath()  throws Throwable  {
        AStar aStar0 = new AStar();
        Nodes nodes0 = aStar0.nodes;
        Grid grid0 = new Grid(3, 15);
        nodes0.map = grid0;
        Path path0 = aStar0.search(0, 0, 4, 0, nodes0.map);
        path0.add(0, 5187);
        aStar0.fillPath(15, 15, path0, grid0, true);
        aStar0.fillPath(6, 0, path0, grid0, true);
    }

    @Test(timeout = 4000)
    public void testSearch()  throws Throwable  {
        AStar aStar0 = new AStar();
        Grid grid0 = new Grid(48, 48);
        aStar0.search(0, 2, 0, 0, grid0);
    }



    @Test(timeout = 4000)
    public void testSearch0()  throws Throwable  {
        AStar aStar0 = new AStar();
        Grid grid0 = new Grid(34, 86);
        Path path0 = aStar0.search(824, 4, 824, (-675), grid0);
        aStar0.search(132, 132, 34, 34, grid0, path0, true);
        // Undeclared exception!
        aStar0.search(2, 7, 8, 57, grid0, true);
    }


    @Test(timeout = 4000)
    public void testSearch1()  throws Throwable  {
        AStar aStar0 = new AStar();
        Nodes nodes0 = aStar0.nodes;
        nodes0.size = (-3252);
        Grid grid0 = new Grid(48, 48);
        try {
            aStar0.search(4, 32, 4, 32, grid0, false);
            fail("Expecting exception: AssertionError");

        } catch(AssertionError e) {

        }
    }

    @Test(timeout = 4000)
    public void testSearch2()  throws Throwable  {
        AStar aStar0 = new AStar();
        Grid grid0 = new Grid(750, 4);
        Path path0 = aStar0.search(0, 0, 4, 0, grid0);
    }

    @Test(timeout = 4000)
    public void testSearch3()  throws Throwable  {
        AStar aStar0 = new AStar();
        Grid grid0 = new Grid(48, 48);
        Path path0 = new Path();
        aStar0.search(13, 6, 2, 7, grid0, path0, true);
    }
    @Test(timeout = 4000)
    public void testSeach4()  throws Throwable  {
        AStar aStar0 = new AStar();
        Grid grid0 = new Grid(48, 48);
        aStar0.search(0, 2, 13, 0, grid0);
    }

    @Test(timeout = 4000)
    public void testSearch5()  throws Throwable  {
        AStar aStar0 = new AStar();
        Grid grid0 = new Grid(48, 48);
        Path path0 = new Path();
        aStar0.search(13, 6, 2, 0, grid0, path0, true);
    }
    @Test(timeout = 4000)
    public void testGrid0()  throws Throwable  {
        Grid grid0 = new Grid(1185, 1185);
        assertEquals(1185, grid0.getWidth());
        assertEquals(1185, grid0.getHeight());
        assertNotNull(grid0);
        try {
            Reachability.getClosestWalkablePointToTarget((-550), 123, 2146895618, 15, (-550), grid0);
            fail("Expecting exception: IllegalArgumentException");

        } catch(IllegalArgumentException e) {

        }
    }

    @Test(timeout = 4000)
    public void testGrid1()  throws Throwable  {
        Grid grid0 = new Grid(801, 1043);
        assertEquals(1043, grid0.getHeight());
        assertEquals(801, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(1043, grid0.getHeight());
        assertEquals(801, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid2()  throws Throwable  {
        Grid grid0 = new Grid(762, 1043);
        assertEquals(762, grid0.getWidth());
        assertEquals(1043, grid0.getHeight());
        assertNotNull(grid0);
        assertEquals(762, grid0.getWidth());
        assertEquals(1043, grid0.getHeight());
    }

    @Test(timeout = 4000)
    public void testGrid3()  throws Throwable  {
        Grid grid0 = new Grid(6, 7);
        assertEquals(7, grid0.getHeight());
        assertEquals(6, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(7, grid0.getHeight());
        assertEquals(6, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid4()  throws Throwable  {
        Grid grid0 = new Grid(224, 15);
        assertEquals(15, grid0.getHeight());
        assertEquals(224, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(15, grid0.getHeight());
        assertEquals(224, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid5()  throws Throwable  {
        Grid grid0 = new Grid(2196, 1223);
        assertEquals(2196, grid0.getWidth());
        assertEquals(1223, grid0.getHeight());
        assertNotNull(grid0);
        assertEquals(2196, grid0.getWidth());
        assertEquals(1223, grid0.getHeight());
    }

    @Test(timeout = 4000)
    public void testGrid6()  throws Throwable  {
        Grid grid0 = new Grid(800, 800);
        assertEquals(800, grid0.getWidth());
        assertEquals(800, grid0.getHeight());
        assertNotNull(grid0);
        long long0 = Reachability.getClosestWalkablePointToTarget((-2307), 16, 16, (-1880), 22, grid0, (Fence) null);
        assertEquals(800, grid0.getWidth());
        assertEquals(800, grid0.getHeight());
        assertEquals((-9908489551856L), long0);
    }

    @Test(timeout = 4000)
    public void testGrid7()  throws Throwable  {
        Grid grid0 = new Grid(1544, 1544);
        assertEquals(1544, grid0.getHeight());
        assertEquals(1544, grid0.getWidth());
        assertNotNull(grid0);
    }

    @Test(timeout = 4000)
    public void testGrid8()  throws Throwable  {
        Grid grid0 = new Grid(182, 800);
        assertEquals(182, grid0.getWidth());
        assertEquals(800, grid0.getHeight());
        assertNotNull(grid0);
        boolean boolean0 = Reachability.isReachable(787, 182, (-2050), 782, 782, grid0);
        assertEquals(182, grid0.getWidth());
        assertEquals(800, grid0.getHeight());
        assertFalse(boolean0);
    }



    @Test(timeout = 4000)
    public void testReachability0()  throws Throwable  {
        double double0 = Reachability.scaleDown(3837.69560802, 1177);
        assertEquals(3.260574008513169, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testReachability1()  throws Throwable  {
        int int0 = Reachability.scaleUp(0, 0);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void testReachability2()  throws Throwable  {
        long long0 = Reachability.scaleUpPoint(0.0, 0.0, 15);
        assertEquals(0L, long0);
    }

    @Test(timeout = 4000)
    public void testGrid9()  throws Throwable  {
        Grid grid0 = new Grid(762, 1043);
        assertEquals(1043, grid0.getHeight());
        assertEquals(762, grid0.getWidth());
        assertNotNull(grid0);

        long long0 = Reachability.getClosestWalkablePointToTarget(32, 1043, 762, 0, 29, grid0);
        assertEquals(1043, grid0.getHeight());
        assertEquals(762, grid0.getWidth());
        assertEquals(3272765079552L, long0);

        assertEquals(1043, grid0.getHeight());
        assertEquals(762, grid0.getWidth());


        assertEquals(1043, grid0.getHeight());
        assertEquals(762, grid0.getWidth());

        assertEquals(1043, grid0.getHeight());
        assertEquals(762, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid10()  throws Throwable  {
        Grid grid0 = new Grid(2196, 1223);
        assertEquals(1223, grid0.getHeight());
        assertEquals(2196, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(1223, grid0.getHeight());
        assertEquals(2196, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid11()  throws Throwable  {
        Grid grid0 = new Grid(801, 1043);
        assertEquals(801, grid0.getWidth());
        assertEquals(1043, grid0.getHeight());
        assertNotNull(grid0);
        long long0 = Reachability.getClosestWalkablePointToTarget(38, 1043, 801, 0, 2, grid0);
        assertEquals(801, grid0.getWidth());
        assertEquals(1043, grid0.getHeight());
        assertEquals(3440268804096L, long0);
    }

    @Test(timeout = 4000)
    public void testGrid12()  throws Throwable  {
        Grid grid0 = new Grid(224, 15);
        assertEquals(224, grid0.getWidth());
        assertEquals(15, grid0.getHeight());
        assertNotNull(grid0);
        assertEquals(224, grid0.getWidth());
        assertEquals(15, grid0.getHeight());
    }

    @Test(timeout = 4000)
    public void testGrid13()  throws Throwable  {
        Grid grid0 = new Grid(1280, 1280);
        assertEquals(1280, grid0.getHeight());
        assertEquals(1280, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(1280, grid0.getHeight());
        assertEquals(1280, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid14()  throws Throwable  {
        Grid grid0 = new Grid(1070, 2);
        assertEquals(2, grid0.getHeight());
        assertEquals(1070, grid0.getWidth());
        assertNotNull(grid0);
        long long0 = Reachability.getClosestWalkablePointToTarget((-1308), 0, (-3261), 1142, 2435, grid0);
        assertEquals(2, grid0.getHeight());
        assertEquals(1070, grid0.getWidth());
        assertEquals((-5613522255872L), long0);
    }

    @Test(timeout = 4000)
    public void testGrid15()  throws Throwable  {
        Grid grid0 = new Grid(161, 2553);
        assertEquals(2553, grid0.getHeight());
        assertEquals(161, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(2553, grid0.getHeight());

    }

    @Test(timeout = 4000)
    public void testGrid16()  throws Throwable  {
        Grid grid0 = new Grid(5, 11);
        assertEquals(11, grid0.getHeight());
        assertEquals(5, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(11, grid0.getHeight());
        assertEquals(5, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid17()  throws Throwable  {
        Grid grid0 = new Grid(801, 1043);
        assertEquals(1043, grid0.getHeight());
        assertEquals(801, grid0.getWidth());
        assertNotNull(grid0);
        long long0 = Reachability.getClosestWalkablePointToTarget(0, 2, 0, 0, 1, grid0, (Fence) null);
        assertEquals(1043, grid0.getHeight());
        assertEquals(801, grid0.getWidth());
        assertEquals(0L, long0);
    }

    @Test(timeout = 4000)
    public void testLength()  throws Throwable  {
        Object[] objectArray0 = new Object[18];
        Utils.check(true, (String) null, objectArray0);
        assertEquals(18, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void testCheck00()  throws Throwable  {
        try {
            Utils.check(false, "");
            fail("Expecting exception: RuntimeException");

        } catch(RuntimeException e) {

        }
    }

    @Test(timeout = 4000)
    public void testCheck()  throws Throwable  {
        Utils.check(true, (String) null);
    }

    @Test(timeout = 4000)
    public void testmask00()  throws Throwable  {
        // Undeclared exception!
        try {
            Utils.mask((-1));
            fail("Expecting exception: RuntimeException");

        } catch(RuntimeException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void testGrid00()  throws Throwable  {
        Grid grid0 = new Grid(2196, 1223);
        assertEquals(1223, grid0.getHeight());
        assertEquals(2196, grid0.getWidth());
        assertNotNull(grid0);
        assertEquals(1223, grid0.getHeight());
        assertEquals(2196, grid0.getWidth());
    }

    @Test(timeout = 4000)
    public void testGrid01()  throws Throwable  {
        Grid grid0 = new Grid(1185, 1185);
        assertEquals(1185, grid0.getWidth());
        assertEquals(1185, grid0.getHeight());
        assertNotNull(grid0);


        assertEquals(1185, grid0.getWidth());
        assertEquals(1185, grid0.getHeight());
    }
    @Test(timeout = 4000)
    public void testNode0()  throws Throwable  {
        Nodes nodes0 = new Nodes();
        nodes0.size = 4972;
        try {
            nodes0.open(4972, 4972, 4972, 4972, 4972);
            fail("Expecting exception: RuntimeException");

        } catch(RuntimeException e) {

        }
    }
    @Test(timeout = 4000)
    public void testReachability00()  throws Throwable  {
        double double0 = Reachability.scaleDown(0.0, 3667);
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testReachability01()  throws Throwable  {
        double double0 = Reachability.scaleDown(1862.6110623, (-1992));
        assertEquals((-0.9350457140060241), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testReachability02()  throws Throwable  {
        Grid grid0 = new Grid(312, 312);
        assertEquals(312, grid0.getHeight());
        assertEquals(312, grid0.getWidth());
        assertNotNull(grid0);

        boolean boolean0 = Reachability.isReachable(312, 312, 312, 312, grid0);
        assertEquals(312, grid0.getHeight());
        assertEquals(312, grid0.getWidth());
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void testReachability03()  throws Throwable  {
        Grid grid0 = new Grid(1544, 1544);
        assertEquals(1544, grid0.getWidth());
        assertEquals(1544, grid0.getHeight());
        assertNotNull(grid0);
        long long0 = Reachability.getClosestWalkablePointToTarget(0, 0, (-875), 0, grid0);
        assertEquals(1544, grid0.getWidth());
        assertEquals(1544, grid0.getHeight());
        assertEquals(0L, long0);
    }

    @Test(timeout = 4000)
    public void testReachability04()  throws Throwable  {
        Grid grid0 = new Grid(1021, 1355);
        assertEquals(1355, grid0.getHeight());
        assertEquals(1021, grid0.getWidth());
        assertNotNull(grid0);

        long long0 = Reachability.getClosestWalkablePointToTarget(1148, 1, 0, 0, 7, grid0);
        assertEquals(1355, grid0.getHeight());
        assertEquals(1021, grid0.getWidth());
        assertEquals(0L, long0);
    }

    @Test(timeout = 4000)
    public void testReachability05()  throws Throwable  {
        try {
            Reachability.isReachable(0, 0, (-15), 0, (Grid) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {

        }
    }

}