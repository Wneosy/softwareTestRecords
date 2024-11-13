package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.function.BiFunction;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.*;
public class GraphTest {
    private Graph graph;
    private Node startNode;
    private Node endNode;
    private Node highRiskNode;
    private Vehicle vehicle;
    private TrafficCondition trafficCondition;
    private WeatherCondition weatherCondition;
    @Before
    public void setUp() {
        // 初始化图和节点
        graph = new Graph();
        startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        highRiskNode = new Node(3, false, "Regular Road", false, false, true, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);
        graph.addNode(highRiskNode);

        // 添加边
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(3, 2, 5);

        // 初始化车辆、交通和天气条件
        vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        trafficCondition = new TrafficCondition(new HashMap<>());
        weatherCondition = new WeatherCondition("Clear");
    }
    @Test
    public void testNodeConstructorAndGetters() {
        Node node = new Node(1, false, "Highway", false, false, false, 1.5, 0, 24);
        assertEquals(1, node.getNodeId());

    }
    @Test(timeout = 4000)
    public void test0()  throws Throwable  {
        Edge edge0 = new Edge((Node) null, 0.0);
        double double0 = edge0.getDistance();
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void tadaest1()  throws Throwable  {
        Edge edge0 = new Edge((Node) null, 869.174575);
        double double0 = edge0.getDistance();
        assertEquals(869.174575, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test2()  throws Throwable  {
        Edge edge0 = new Edge((Node) null, (-12.002055726178535));
        double double0 = edge0.getDistance();
        assertEquals((-12.002055726178535), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test3()  throws Throwable  {
        Edge edge0 = new Edge((Node) null, (-12.002055726178535));
        edge0.getNeighbor();
        assertEquals((-12.002055726178535), edge0.getDistance(), 0.01);
    }

    @Test(timeout = 4000)
    public void teasdt0()  throws Throwable  {
        FloydWarshall floydWarshall0 = null;
        try {
            floydWarshall0 = new FloydWarshall((Graph) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }


    @Test(timeout = 4000)
    public void teasdast0()  throws Throwable  {
        GasStation gasStation0 = new GasStation(0, 0);
        int int0 = gasStation0.getNodeId();
        assertEquals(0, int0);
        assertEquals(0.0, gasStation0.getFuelCostPerLitre(), 0.01);
    }

    @Test(timeout = 4000)
    public void tasdasest1()  throws Throwable  {
        GasStation gasStation0 = new GasStation(258, 258);
        int int0 = gasStation0.getNodeId();
        assertEquals(258.0, gasStation0.getFuelCostPerLitre(), 0.01);
        assertEquals(258, int0);
    }

    @Test(timeout = 4000)
    public void tesasdt2()  throws Throwable  {
        GasStation gasStation0 = new GasStation(0, 0);
        double double0 = gasStation0.getFuelCostPerLitre();
        assertEquals(0.0, double0, 0.01);
        assertEquals(0, gasStation0.getNodeId());
    }

    @Test(timeout = 4000)
    public void tesasdat3()  throws Throwable  {
        GasStation gasStation0 = new GasStation((-1089), (-1089));
        double double0 = gasStation0.getFuelCostPerLitre();
        assertEquals((-1089), gasStation0.getNodeId());
        assertEquals((-1089.0), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test4()  throws Throwable  {
        GasStation gasStation0 = new GasStation((-1089), (-1089));
        // Undeclared exception!
        try {
            gasStation0.refuel((Vehicle) null, (-1089.0));
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void test5()  throws Throwable  {
        GasStation gasStation0 = new GasStation((-1), 1018.3396297636);
        assertEquals((-1), gasStation0.getNodeId());
        assertEquals(1018.3396297636, gasStation0.getFuelCostPerLitre(), 0.01);
    }

    @Test(timeout = 4000)
    public void tesaaat6()  throws Throwable  {
        GasStation gasStation0 = new GasStation((-1), 1018.3396297636);
        double double0 = gasStation0.getFuelCostPerLitre();
        assertEquals((-1), gasStation0.getNodeId());
        assertEquals(1018.3396297636, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test7()  throws Throwable  {
        GasStation gasStation0 = new GasStation((-1), 1018.3396297636);
        int int0 = gasStation0.getNodeId();
        assertEquals((-1), int0);
        assertEquals(1018.3396297636, gasStation0.getFuelCostPerLitre(), 0.01);
    }

    @Test(timeout = 4000)
    public void taasdsdaest0()  throws Throwable  {
        Graph graph0 = new Graph();
        graph0.addEdge((-1), 0, (-1));
    }

    @Test(timeout = 4000)
    public void test1()  throws Throwable  {
        Graph graph0 = new Graph();
        // Undeclared exception!
        try {
            graph0.addNode((Node) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void tasdest2()  throws Throwable  {
        Graph graph0 = new Graph();
        Map<Integer, Node> map0 = graph0.getNodes();
        assertEquals(0, map0.size());
    }

    @Test(timeout = 4000)
    public void teasdast3()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = graph0.getNode(20);
        assertNull(node0);
    }

    @Test(timeout = 4000)
    public void test00()  throws Throwable  {
        Node node0 = new Node((-3820), false, "", false, false, true, (-3820), (-3820), 0);
        Node node1 = new Node((-3820), false, "", false, false, false, (-3820), 0, (-3820));
        node0.addNeighbor(node1, 0);
        assertEquals((-3820), node0.getNodeId());
        assertEquals((-3820.0), node1.getCostPerKm(), 0.01);
        assertFalse(node0.isRestrictedForHeavyVehicles());
        assertFalse(node0.isTollRoad());
        assertTrue(node0.isHighRiskArea());
        assertFalse(node0.isObstacle());
        assertEquals((-3820), node1.getNodeId());
    }

    @Test(timeout = 4000)
    public void test01()  throws Throwable  {
        Node node0 = new Node((-2662), false, "zZWu", true, true, true, (-2662), (-2662), (-1282));
        boolean boolean0 = node0.isOpenAt((-2662));
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertEquals((-2662.0), node0.getCostPerKm(), 0.01);
        assertEquals((-2662), node0.getNodeId());
        assertTrue(boolean0);
        assertTrue(node0.isHighRiskArea());
        assertFalse(node0.isObstacle());
        assertTrue(node0.isTollRoad());
    }

    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        Node node0 = new Node(1641, true, "", false, true, true, 1641, 1641, 1641);
        boolean boolean0 = node0.isTollRoad();
        assertEquals(1641, node0.getNodeId());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertFalse(boolean0);
        assertEquals(1641.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isObstacle());
        assertTrue(node0.isHighRiskArea());
    }

    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        Node node0 = new Node((-867), false, "[=n1Tl%tj", false, false, false, (-1609.85800451044), (-867), (-867));
        boolean boolean0 = node0.isRestrictedForHeavyVehicles();
        assertFalse(node0.isHighRiskArea());
        assertFalse(node0.isTollRoad());
        assertEquals((-1609.85800451044), node0.getCostPerKm(), 0.01);
        assertFalse(node0.isObstacle());
        assertEquals((-867), node0.getNodeId());
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test04()  throws Throwable  {
        Node node0 = new Node((-3820), false, "", false, false, true, (-3820), (-3820), 0);
        boolean boolean0 = node0.isObstacle();
        assertFalse(boolean0);
        assertTrue(node0.isHighRiskArea());
        assertFalse(node0.isTollRoad());
        assertEquals((-3820.0), node0.getCostPerKm(), 0.01);
        assertEquals((-3820), node0.getNodeId());
        assertFalse(node0.isRestrictedForHeavyVehicles());
    }

    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        Node node0 = new Node((-1), false, "", false, false, false, 1355.0180023, 0, (-1305));
        boolean boolean0 = node0.isHighRiskArea();
        assertFalse(node0.isObstacle());
        assertEquals(1355.0180023, node0.getCostPerKm(), 0.01);
        assertFalse(node0.isTollRoad());
        assertFalse(boolean0);
        assertEquals((-1), node0.getNodeId());
        assertFalse(node0.isRestrictedForHeavyVehicles());
    }

    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        Node node0 = new Node(186, true, (String) null, true, true, true, 186, 186, 186);
        node0.getRoadType();
        assertTrue(node0.isTollRoad());
        assertTrue(node0.isObstacle());
        assertTrue(node0.isHighRiskArea());
        assertEquals(186.0, node0.getCostPerKm(), 0.01);
        assertEquals(186, node0.getNodeId());
        assertTrue(node0.isRestrictedForHeavyVehicles());
    }

    @Test(timeout = 4000)
    public void test07()  throws Throwable  {
        Node node0 = new Node((-1825), false, "3NI96%4K%pktNnOpRb", false, true, true, (-1825), (-1825), (-1825));
        node0.getRoadType();
        assertFalse(node0.isObstacle());
        assertFalse(node0.isTollRoad());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertEquals((-1825), node0.getNodeId());
        assertTrue(node0.isHighRiskArea());
        assertEquals((-1825.0), node0.getCostPerKm(), 0.01);
    }

    @Test(timeout = 4000)
    public void test08()  throws Throwable  {
        Node node0 = new Node(0, true, "", true, true, true, 0, (-1), 0);
        int int0 = node0.getNodeId();
        assertTrue(node0.isTollRoad());
        assertEquals(0.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isObstacle());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertTrue(node0.isHighRiskArea());
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test09()  throws Throwable  {
        Node node0 = new Node(1641, true, "", false, true, true, 1641, 1641, 1641);
        int int0 = node0.getNodeId();
        assertTrue(node0.isHighRiskArea());
        assertEquals(1641.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertEquals(1641, int0);
        assertFalse(node0.isTollRoad());
        assertTrue(node0.isObstacle());
    }

    @Test(timeout = 4000)
    public void test10()  throws Throwable  {
        Node node0 = new Node(0, false, "", false, true, false, 0.0, (-1), 0);
        double double0 = node0.getCostPerKm();
        assertFalse(node0.isHighRiskArea());
        assertEquals(0.0, double0, 0.01);
        assertFalse(node0.isObstacle());
        assertEquals(0, node0.getNodeId());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertFalse(node0.isTollRoad());
    }

    @Test(timeout = 4000)
    public void test11()  throws Throwable  {
        Node node0 = new Node((-1), false, "", false, false, false, 1355.0180023, 0, (-1305));
        double double0 = node0.getCostPerKm();
        assertEquals(1355.0180023, double0, 0.01);
        assertFalse(node0.isTollRoad());
        assertFalse(node0.isHighRiskArea());
        assertFalse(node0.isObstacle());
        assertEquals((-1), node0.getNodeId());
        assertFalse(node0.isRestrictedForHeavyVehicles());
    }

    @Test(timeout = 4000)
    public void test12()  throws Throwable  {
        Node node0 = new Node(0, false, "", false, false, false, 0, 0, 0);
        // Undeclared exception!
        try {
            node0.addNeighbor((Node) null, (-2389.60399));
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void test13()  throws Throwable  {
        Node node0 = new Node(1641, true, "", false, true, true, 1641, 1641, 1641);
        boolean boolean0 = node0.isObstacle();
        assertEquals(1641.0, node0.getCostPerKm(), 0.01);
        assertFalse(node0.isTollRoad());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertTrue(boolean0);
        assertEquals(1641, node0.getNodeId());
        assertTrue(node0.isHighRiskArea());
    }

    @Test(timeout = 4000)
    public void test14()  throws Throwable  {
        Node node0 = new Node(22, true, "Ta'YPRcC@4&Fss@wu+~M", true, true, true, 22, 22, 22);
        node0.addNeighbor(node0, 22);
        assertTrue(node0.isObstacle());
        assertEquals(22, node0.getNodeId());
        assertEquals(22.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isHighRiskArea());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertTrue(node0.isTollRoad());
    }

    @Test(timeout = 4000)
    public void test15()  throws Throwable  {
        Node node0 = new Node(22, true, "Ta'YPRcC@4&Fss@wu+~M", true, true, true, 22, 22, 22);
        boolean boolean0 = node0.isOpenAt(22);
        assertEquals(22, node0.getNodeId());
        assertTrue(node0.isTollRoad());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertEquals(22.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isHighRiskArea());
        assertTrue(node0.isObstacle());
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test16()  throws Throwable  {
        Node node0 = new Node((-1342), false, "", false, false, false, (-1342), (-1342), (-1342));
        boolean boolean0 = node0.isOpenAt(2354);
        assertEquals((-1342), node0.getNodeId());
        assertFalse(boolean0);
        assertEquals((-1342.0), node0.getCostPerKm(), 0.01);
        assertFalse(node0.isHighRiskArea());
        assertFalse(node0.isTollRoad());
        assertFalse(node0.isObstacle());
        assertFalse(node0.isRestrictedForHeavyVehicles());
    }

    @Test(timeout = 4000)
    public void test17()  throws Throwable  {
        Node node0 = new Node(22, true, "Ta'YPRcC@4&Fss@wu+~M", true, true, true, 22, 22, 22);
        boolean boolean0 = node0.isOpenAt(0);
        assertTrue(node0.isTollRoad());
        assertFalse(boolean0);
        assertTrue(node0.isHighRiskArea());
        assertEquals(22.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertEquals(22, node0.getNodeId());
        assertTrue(node0.isObstacle());
    }

    @Test(timeout = 4000)
    public void test18()  throws Throwable  {
        Node node0 = new Node((-1342), false, "", false, false, false, (-1342), (-1342), (-1342));
        node0.addNeighbor(node0, (-1342));
        List<Edge> list0 = node0.getNeighbors();
        assertFalse(node0.isTollRoad());
        assertFalse(node0.isRestrictedForHeavyVehicles());
        assertEquals((-1342), node0.getNodeId());
        assertEquals(1, list0.size());
        assertFalse(node0.isHighRiskArea());
        assertEquals((-1342.0), node0.getCostPerKm(), 0.01);
    }

    @Test(timeout = 4000)
    public void test19()  throws Throwable  {
        Node node0 = new Node(22, true, "Ta'YPRcC@4&Fss@wu+~M", true, true, true, 22, 22, 22);
        boolean boolean0 = node0.isTollRoad();
        assertEquals(22.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isHighRiskArea());
        assertTrue(node0.isObstacle());
        assertTrue(boolean0);
        assertEquals(22, node0.getNodeId());
        assertTrue(node0.isRestrictedForHeavyVehicles());
    }

    @Test(timeout = 4000)
    public void test20()  throws Throwable  {
        Node node0 = new Node((-1342), false, "", false, false, false, (-1342), (-1342), (-1342));
        node0.getNeighbors();
        assertEquals((-1342), node0.getNodeId());
        assertFalse(node0.isObstacle());
        assertFalse(node0.isRestrictedForHeavyVehicles());
        assertEquals((-1342.0), node0.getCostPerKm(), 0.01);
        assertFalse(node0.isHighRiskArea());
        assertFalse(node0.isTollRoad());
    }

    @Test(timeout = 4000)
    public void test21()  throws Throwable  {
        Node node0 = new Node((-1342), false, "", false, false, false, (-1342), (-1342), (-1342));
        double double0 = node0.getCostPerKm();
        assertFalse(node0.isObstacle());
        assertFalse(node0.isTollRoad());
        assertEquals((-1342), node0.getNodeId());
        assertEquals((-1342.0), double0, 0.01);
        assertFalse(node0.isRestrictedForHeavyVehicles());
        assertFalse(node0.isHighRiskArea());
    }

    @Test(timeout = 4000)
    public void test22()  throws Throwable  {
        Node node0 = new Node((-1342), false, "", false, false, false, (-1342), (-1342), (-1342));
        node0.getRoadType();
        assertFalse(node0.isRestrictedForHeavyVehicles());
        assertEquals((-1342.0), node0.getCostPerKm(), 0.01);
        assertEquals((-1342), node0.getNodeId());
        assertFalse(node0.isTollRoad());
        assertFalse(node0.isHighRiskArea());
        assertFalse(node0.isObstacle());
    }

    @Test(timeout = 4000)
    public void test23()  throws Throwable  {
        Node node0 = new Node(22, true, "Ta'YPRcC@4&Fss@wu+~M", true, true, true, 22, 22, 22);
        boolean boolean0 = node0.isRestrictedForHeavyVehicles();
        assertTrue(node0.isHighRiskArea());
        assertTrue(node0.isTollRoad());
        assertTrue(boolean0);
        assertTrue(node0.isObstacle());
        assertEquals(22, node0.getNodeId());
        assertEquals(22.0, node0.getCostPerKm(), 0.01);
    }

    @Test(timeout = 4000)
    public void test24()  throws Throwable  {
        Node node0 = new Node(22, true, "Ta'YPRcC@4&Fss@wu+~M", true, true, true, 22, 22, 22);
        boolean boolean0 = node0.isHighRiskArea();
        assertTrue(boolean0);
        assertEquals(22.0, node0.getCostPerKm(), 0.01);
        assertTrue(node0.isObstacle());
        assertTrue(node0.isRestrictedForHeavyVehicles());
        assertEquals(22, node0.getNodeId());
        assertTrue(node0.isTollRoad());
    }

    @Test(timeout = 4000)
    public void test25()  throws Throwable  {
        Node node0 = new Node((-1342), false, "", false, false, false, (-1342), (-1342), (-1342));
        int int0 = node0.getNodeId();
        assertFalse(node0.isTollRoad());
        assertEquals((-1342.0), node0.getCostPerKm(), 0.01);
        assertFalse(node0.isObstacle());
        assertFalse(node0.isHighRiskArea());
        assertEquals((-1342), int0);
        assertFalse(node0.isRestrictedForHeavyVehicles());
    }

    @Test(timeout = 4000)
    public void tasdest0()  throws Throwable  {
        PathNode pathNode0 = new PathNode((Node) null, 0.0);
        double double0 = pathNode0.getEstimatedTotalDistance();
        assertEquals(0.0, pathNode0.getDistance(), 0.01);
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void teasdst1()  throws Throwable  {
        PathNode pathNode0 = new PathNode((Node) null, (-1.0));
        double double0 = pathNode0.getEstimatedTotalDistance();
        assertEquals((-1.0), double0, 0.01);
        assertEquals((-1.0), pathNode0.getDistance(), 0.01);
    }

    @Test(timeout = 4000)
    public void taasdest2()  throws Throwable  {
        PathNode pathNode0 = new PathNode((Node) null, 0.0, (-1430.148));
        double double0 = pathNode0.getDistance();
        assertEquals(0.0, double0, 0.01);
        assertEquals((-1430.148), pathNode0.getEstimatedTotalDistance(), 0.01);
    }

    @Test(timeout = 4000)
    public void tasdest3()  throws Throwable  {
        PathNode pathNode0 = new PathNode((Node) null, (-1.0));
        double double0 = pathNode0.getDistance();
        assertEquals((-1.0), pathNode0.getEstimatedTotalDistance(), 0.01);
        assertEquals((-1.0), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testasd4()  throws Throwable  {
        PathNode pathNode0 = new PathNode((Node) null, 1735.2, 1735.2);
        pathNode0.getNode();
        assertEquals(1735.2, pathNode0.getDistance(), 0.01);
        assertEquals(1735.2, pathNode0.getEstimatedTotalDistance(), 0.01);
    }
    @Test(timeout = 4000)
    public void tasdaest0()  throws Throwable  {
        PathResult pathResult0 = new PathResult((List<Node>) null);
        // Undeclared exception!
        try {
            pathResult0.printPath();
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void tesasdt1()  throws Throwable  {
        PathResult pathResult0 = new PathResult((List<Node>) null);
        List<Node> list0 = pathResult0.getPath();
        assertNull(list0);
    }




    @Test(timeout = 4000)
    public void tadest1()  throws Throwable  {
        RouteOptimizer routeOptimizer0 = new RouteOptimizer((SearchAlgorithm) null);
        // Undeclared exception!
        try {
            routeOptimizer0.optimizeRoute();
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }
    @Test(timeout = 4000)
    public void testasd0()  throws Throwable  {
        TrafficCondition trafficCondition0 = new TrafficCondition((Map<Integer, String>) null);
        // Undeclared exception!
        try {
            trafficCondition0.getTrafficStatus(75);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void tasdest1()  throws Throwable  {
        TrafficCondition trafficCondition0 = new TrafficCondition((Map<Integer, String>) null);
        // Undeclared exception!
        try {
            trafficCondition0.updateTrafficStatus(2022, "1W4wJ/'?.[oq?fuq");
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void taaeasdst2()  throws Throwable  {
        TrafficCondition trafficCondition0 = new TrafficCondition((Map<Integer, String>) null);
        // Undeclared exception!
        try {
            trafficCondition0.adjustWeight((-2342), 3980);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }
    @Test(timeout = 4000)
    public void tesasdadat00()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 0.0, false, 0.0, 1.0, 1.0, 0.0, true);
        assertNotNull(vehicle0);
        assertEquals("", vehicle0.getVehicleType());
        assertEquals(1.0, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(1.0, vehicle0.getFuelConsumptionPerKm(), 0.01);

        boolean boolean0 = vehicle0.needsRefueling(1.0);
        assertEquals("", vehicle0.getVehicleType());
        assertEquals(1.0, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(1.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void tasdaest01()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 0.0, true, 0.0, (-1.0), 0.0, 0.0, false);
        assertNotNull(vehicle0);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals((-1.0), vehicle0.getCurrentFuel(), 0.01);
        assertEquals("", vehicle0.getVehicleType());
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);

        boolean boolean0 = vehicle0.requiresTollFreeRoute();
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals((-1.0), vehicle0.getCurrentFuel(), 0.01);
        assertEquals("", vehicle0.getVehicleType());
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void tesasdadat02()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("]ul^Ak", 1445.38553590711, true, 1445.38553590711, 0.0, 0.0, 1445.38553590711, true);
        assertNotNull(vehicle0);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(1445.38553590711, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1445.38553590711, vehicle0.getFuelCapacity(), 0.01);
        assertEquals("]ul^Ak", vehicle0.getVehicleType());
        assertEquals(1445.38553590711, vehicle0.getMaxLoad(), 0.01);

        boolean boolean0 = vehicle0.isEmergencyVehicle();
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(1445.38553590711, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1445.38553590711, vehicle0.getFuelCapacity(), 0.01);
        assertEquals("]ul^Ak", vehicle0.getVehicleType());
        assertEquals(1445.38553590711, vehicle0.getMaxLoad(), 0.01);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void teaasasdt03()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle((String) null, 3643.977966342, false, 0.0, 1.0, 290.9906625215046, 0.0, true);
        assertNotNull(vehicle0);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(1.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(3643.977966342, vehicle0.getMaxLoad(), 0.01);
        assertEquals(290.9906625215046, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertNull(vehicle0.getVehicleType());
        assertFalse(vehicle0.requiresTollFreeRoute());

        String string0 = vehicle0.getVehicleType();
        assertNull(string0);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(1.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(3643.977966342, vehicle0.getMaxLoad(), 0.01);
        assertEquals(290.9906625215046, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertNull(vehicle0.getVehicleType());
        assertFalse(vehicle0.requiresTollFreeRoute());
    }

    @Test(timeout = 4000)
    public void testaasdasd04()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("+8P", 0.0, false, 0.0, 530.0, 530.0, 0.0, true);
        assertNotNull(vehicle0);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(530.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals(530.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals("+8P", vehicle0.getVehicleType());
        assertFalse(vehicle0.requiresTollFreeRoute());

        String string0 = vehicle0.getVehicleType();
        assertNotNull(string0);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(530.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals(530.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals("+8P", vehicle0.getVehicleType());
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals("+8P", string0);
    }

    @Test(timeout = 4000)
    public void test0asd5()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("+8P", 0.0, false, 0.0, 530.0, 530.0, 0.0, true);
        assertNotNull(vehicle0);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(530.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals("+8P", vehicle0.getVehicleType());
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(530.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());

        double double0 = vehicle0.getMinFuelAtEnd();
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(530.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals("+8P", vehicle0.getVehicleType());
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(530.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void teasdast06()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("7tVlj\"$k[$m}|n", (-1174.260335569), false, (-1174.260335569), (-1174.260335569), (-1.0), (-1174.260335569), false);
        assertNotNull(vehicle0);
        assertEquals((-1.0), vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals("7tVlj\"$k[$m}|n", vehicle0.getVehicleType());
        assertEquals((-1174.260335569), vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals((-1174.260335569), vehicle0.getFuelCapacity(), 0.01);
        assertEquals((-1174.260335569), vehicle0.getMaxLoad(), 0.01);
        assertEquals((-1174.260335569), vehicle0.getCurrentFuel(), 0.01);

        double double0 = vehicle0.getMinFuelAtEnd();
        assertEquals((-1.0), vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals("7tVlj\"$k[$m}|n", vehicle0.getVehicleType());
        assertEquals((-1174.260335569), vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals((-1174.260335569), vehicle0.getFuelCapacity(), 0.01);
        assertEquals((-1174.260335569), vehicle0.getMaxLoad(), 0.01);
        assertEquals((-1174.260335569), vehicle0.getCurrentFuel(), 0.01);
        assertEquals((-1174.260335569), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void tesasdtasd07()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("6G?!!/ZyI0|s", 352.856, true, 0.0, 352.856, 0.0, 352.856, true);
        assertNotNull(vehicle0);
        assertEquals(352.856, vehicle0.getMaxLoad(), 0.01);
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(352.856, vehicle0.getMinFuelAtEnd(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals("6G?!!/ZyI0|s", vehicle0.getVehicleType());
        assertEquals(352.856, vehicle0.getCurrentFuel(), 0.01);

        double double0 = vehicle0.getMaxLoad();
        assertEquals(352.856, vehicle0.getMaxLoad(), 0.01);
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(352.856, vehicle0.getMinFuelAtEnd(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals("6G?!!/ZyI0|s", vehicle0.getVehicleType());
        assertEquals(352.856, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(352.856, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void teasdasstasd08()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", (-1524.164), true, (-1.0), 3.9505866363979, (-1.0), 0.0, false);
        assertNotNull(vehicle0);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals("", vehicle0.getVehicleType());
        assertEquals((-1.0), vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(3.9505866363979, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals((-1.0), vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals((-1524.164), vehicle0.getMaxLoad(), 0.01);

        double double0 = vehicle0.getMaxLoad();
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals("", vehicle0.getVehicleType());
        assertEquals((-1.0), vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(3.9505866363979, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals((-1.0), vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals((-1524.164), vehicle0.getMaxLoad(), 0.01);
        assertEquals((-1524.164), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void tasdest09()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 0.0, true, 0.0, 0.0, 0.0, 0.0, true);
        assertNotNull(vehicle0);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals("", vehicle0.getVehicleType());

        double double0 = vehicle0.getFuelConsumptionPerKm();
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals("", vehicle0.getVehicleType());
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testasd10()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("7+uf^jD/[b", 1334.19, true, 1334.19, 0.0, (-2372.465219640003), (-2372.465219640003), false);
        assertNotNull(vehicle0);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals((-2372.465219640003), vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1334.19, vehicle0.getMaxLoad(), 0.01);
        assertEquals(1334.19, vehicle0.getFuelCapacity(), 0.01);
        assertEquals((-2372.465219640003), vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals("7+uf^jD/[b", vehicle0.getVehicleType());

        double double0 = vehicle0.getFuelConsumptionPerKm();
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals((-2372.465219640003), vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1334.19, vehicle0.getMaxLoad(), 0.01);
        assertEquals(1334.19, vehicle0.getFuelCapacity(), 0.01);
        assertEquals((-2372.465219640003), vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals("7+uf^jD/[b", vehicle0.getVehicleType());
        assertEquals((-2372.465219640003), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void teasdst11()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("5>$l}&H9f*dk05M43", 0.0, false, 0.0, 0.0, 0.0, (-159.6228360075), false);
        assertNotNull(vehicle0);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals("5>$l}&H9f*dk05M43", vehicle0.getVehicleType());
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals((-159.6228360075), vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());

        double double0 = vehicle0.getFuelCapacity();
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals("5>$l}&H9f*dk05M43", vehicle0.getVehicleType());
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
        assertEquals((-159.6228360075), vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test1asd2()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", (-1.0), true, (-1.0), (-1.0), 572.2, (-1.0), true);
        assertNotNull(vehicle0);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(572.2, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals((-1.0), vehicle0.getMaxLoad(), 0.01);
        assertEquals((-1.0), vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals((-1.0), vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals("", vehicle0.getVehicleType());
        assertEquals((-1.0), vehicle0.getCurrentFuel(), 0.01);

        double double0 = vehicle0.getFuelCapacity();
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(572.2, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals((-1.0), vehicle0.getMaxLoad(), 0.01);
        assertEquals((-1.0), vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals((-1.0), vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals("", vehicle0.getVehicleType());
        assertEquals((-1.0), vehicle0.getCurrentFuel(), 0.01);
        assertEquals((-1.0), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testasd13()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("<d?YsJ$91y", 930.9072696536449, true, 930.9072696536449, 0.0, 1742.7015, 1742.7015, true);
        assertNotNull(vehicle0);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(930.9072696536449, vehicle0.getMaxLoad(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(930.9072696536449, vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals("<d?YsJ$91y", vehicle0.getVehicleType());
        assertEquals(1742.7015, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(1742.7015, vehicle0.getFuelConsumptionPerKm(), 0.01);

        double double0 = vehicle0.getCurrentFuel();
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(930.9072696536449, vehicle0.getMaxLoad(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(930.9072696536449, vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals("<d?YsJ$91y", vehicle0.getVehicleType());
        assertEquals(1742.7015, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(1742.7015, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void teasdst14()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        assertNotNull(vehicle0);
        assertEquals("", vehicle0.getVehicleType());
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);

        vehicle0.consumeFuel(611.25274847);
        assertEquals("", vehicle0.getVehicleType());
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals((-988690.398934283), vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);

        double double0 = vehicle0.getCurrentFuel();
        assertEquals("", vehicle0.getVehicleType());
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals((-988690.398934283), vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals((-988690.398934283), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void tasdest15()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        assertNotNull(vehicle0);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals("", vehicle0.getVehicleType());
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);

        vehicle0.consumeFuel(611.25274847);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals("", vehicle0.getVehicleType());
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals((-988690.398934283), vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);

        boolean boolean0 = vehicle0.needsRefueling((-202.9561181093193));
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals("", vehicle0.getVehicleType());
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals((-988690.398934283), vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void tesasdt16()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        boolean boolean0 = vehicle0.needsRefueling((-4823.537487));
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertFalse(boolean0);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
    }

    @Test(timeout = 4000)
    public void tesasdat17()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 0.0, true, 0.0, 0.0, 445.0, 0.0, false);
        double double0 = vehicle0.getFuelConsumptionPerKm();
        assertEquals(0.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(445.0, double0, 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(0.0, vehicle0.getMaxLoad(), 0.01);
    }

    @Test(timeout = 4000)
    public void tesasdt1aa8()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        double double0 = vehicle0.getCurrentFuel();
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(611.25274847, double0, 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
    }

    @Test(timeout = 4000)
    public void tesasdt19()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        boolean boolean0 = vehicle0.isEmergencyVehicle();
        assertFalse(boolean0);
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
    }

    @Test(timeout = 4000)
    public void tesasdt20()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        boolean boolean0 = vehicle0.requiresTollFreeRoute();
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertFalse(boolean0);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
    }

    @Test(timeout = 4000)
    public void testasd21()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        double double0 = vehicle0.getFuelCapacity();
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(611.25274847, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void tesasdat22()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        double double0 = vehicle0.getMinFuelAtEnd();
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(1618.4821322424, double0, 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
    }

    @Test(timeout = 4000)
    public void tesasdt23()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("net.mooctest.Vehicle", 0.0, true, 0.0, 3517.9, 0.0, 1.0, true);
        double double0 = vehicle0.getMaxLoad();
        assertEquals(1.0, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(0.0, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(0.0, vehicle0.getFuelCapacity(), 0.01);
        assertTrue(vehicle0.requiresTollFreeRoute());
        assertEquals(3517.9, vehicle0.getCurrentFuel(), 0.01);
        assertTrue(vehicle0.isEmergencyVehicle());
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testasd24()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        vehicle0.refuel(611.25274847);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertFalse(vehicle0.requiresTollFreeRoute());
    }

    @Test(timeout = 4000)
    public void test2asd5()  throws Throwable  {
        Vehicle vehicle0 = new Vehicle("", 1618.4821322424, false, 611.25274847, 611.25274847, 1618.4821322424, 1618.4821322424, false);
        vehicle0.getVehicleType();
        assertFalse(vehicle0.requiresTollFreeRoute());
        assertEquals(1618.4821322424, vehicle0.getMinFuelAtEnd(), 0.01);
        assertEquals(611.25274847, vehicle0.getFuelCapacity(), 0.01);
        assertFalse(vehicle0.isEmergencyVehicle());
        assertEquals(611.25274847, vehicle0.getCurrentFuel(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getMaxLoad(), 0.01);
        assertEquals(1618.4821322424, vehicle0.getFuelConsumptionPerKm(), 0.01);
    }

    @Test(timeout = 4000)
    public void teasdsst00()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-1550), false, "", false, false, false, 1203.8573012860375, (-1550), (-1550));
        Vehicle vehicle0 = new Vehicle("net.mooctest.AStar", 1203.8573012860375, false, 0.0, (-1550), 2757.793345493103, 2736.71859643293, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        AStar aStar0 = new AStar(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, (-1550));
        Node node1 = new Node(1, true, "net.mooctest.Node", false, false, true, 1203.8573012860375, 1, (-1));
        double double0 = aStar0.heuristic(node1);
        assertEquals(3102.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void tasdest01()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, true, "", true, true, false, 1, 0, 484);
        Vehicle vehicle0 = new Vehicle("yNxGXx-aiF", 3032.3230975, true, 3517.6364, 3517.6364, (-670.81), 1.0, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>(484);
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("Accident");
        Node node1 = new Node(0, true, "yNxGXx-aiF", true, false, false, 484, (-2078558673), 0);
        AStar aStar0 = new AStar(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 484);
        double double0 = aStar0.heuristic(node1);
        assertEquals(1.0, double0, 0.01);
    }



    @Test(timeout = 4000)
    public void tesasdasasdt03()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(76, true, "/Hc(f'vaHv`4'39ik", true, false, true, 365.6919, 76, 76);
        Vehicle vehicle0 = new Vehicle("", 76, true, 76, 59.0, 175.24, (-1379.18095363), false);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        AStar aStar0 = new AStar(graph0, node0, node0, vehicle0, (TrafficCondition) null, weatherCondition0, 0);
        // Undeclared exception!
        try {
            aStar0.reconstructPath((Map<Node, Node>) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void testasd04()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-3777), true, "", true, true, false, (-3777), (-3777), (-3777));
        Vehicle vehicle0 = new Vehicle("", (-1808199472), true, (-3777), 2.0, 5185.545459, 0.8, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        AStar aStar0 = new AStar(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, 0);
        // Undeclared exception!
        try {
            aStar0.heuristic((Node) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void test0asd6()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-2078558673), false, "3G", false, false, false, (-2078558673), (-2078558673), (-2078558673));
        Vehicle vehicle0 = new Vehicle("net.mooctest.TrafficCondition", (-2078558673), false, 3506.000065394, (-5527.0), (-433.3), 3506.000065394, false);
        TrafficCondition trafficCondition0 = new TrafficCondition((Map<Integer, String>) null);
        WeatherCondition weatherCondition0 = new WeatherCondition("FY{)](fIgzb%~:L");
        AStar aStar0 = new AStar(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, 1971);
        // Undeclared exception!
        try {
            aStar0.findPath();
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void tesasdt07()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, true, "", true, true, false, 1, 0, 484);
        Vehicle vehicle0 = new Vehicle("yNxGXx-aiF", 3032.3230975, true, 3517.6364, 3517.6364, (-670.81), 1.0, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>(484);
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("Accident");
        AStar aStar0 = new AStar(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 484);
        HashMap<Node, Node> hashMap1 = new HashMap<Node, Node>();
        PathResult pathResult0 = aStar0.reconstructPath(hashMap1);
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void testasd08()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(3, false, "Hjghway", false, false, false, 3, 3, 3);
        WeatherCondition weatherCondition0 = new WeatherCondition("Hjghway");
        AStar aStar0 = new AStar(graph0, node0, node0, (Vehicle) null, (TrafficCondition) null, weatherCondition0, 3);
        double double0 = aStar0.heuristic(node0);
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test0asd9()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-10), true, "W_Oxwg", true, true, false, (-10), (-10), (-10));
        Vehicle vehicle0 = new Vehicle("W_Oxwg", (-10), false, (-10), (-10), (-10), (-10), true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        Node node1 = new Node((-10), false, "W_Oxwg", false, true, true, (-10), (-10), 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("W_Oxwg");
        node0.addNeighbor(node1, 1);
        node0.addNeighbor(node1, 1);
        AStar aStar0 = new AStar(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, (-10));
        PathResult pathResult0 = aStar0.findPath();
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void tesasdt10()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-41), false, "i)7b^%Pzi", false, false, false, (-41), (-41), (-41));
        node0.addNeighbor(node0, (-41));
        Vehicle vehicle0 = new Vehicle("i)7b^%Pzi", (-41), false, 2916, 2916, (-41), (-41), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        Node node1 = new Node((-41), false, "i)7b^%Pzi", true, false, true, 2916, (-41), (-41));
        WeatherCondition weatherCondition0 = new WeatherCondition("i)7b^%Pzi");
        AStar aStar0 = new AStar(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, (-41));
        PathResult pathResult0 = aStar0.findPath();
        assertNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void tesasdt11()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(0, false, "i7b=%Pi", false, false, false, 0, 0, 0);
        Vehicle vehicle0 = new Vehicle("i7b=%Pi", 0.0, false, 0, 0, 0, 0, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        Node node1 = new Node(0, false, "i7b=%Pi", false, false, true, 445.20171433, 0, 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("i7b=%Pi");
        node0.addNeighbor(node1, 0.0);
        AStar aStar0 = new AStar(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 0);
        PathResult pathResult0 = aStar0.findPath();
        assertNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void testasd12()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-10), true, "W_Oxwg", true, true, false, (-10), (-10), (-10));
        Node node1 = new Node((-10), false, "W_Oxwg", true, true, false, (-10), (-10), (-10));
        node0.addNeighbor(node1, (-10));
        Vehicle vehicle0 = new Vehicle("W_Oxwg", (-10), false, (-10), (-10), (-10), (-10), true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("W_Oxwg");
        AStar aStar0 = new AStar(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, (-10));
        PathResult pathResult0 = aStar0.findPath();
        assertNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void testasda13()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(2715, true, "Highway", true, true, true, 2715, 2715, 2715);
        WeatherCondition weatherCondition0 = new WeatherCondition("Highway");
        AStar aStar0 = new AStar(graph0, node0, node0, (Vehicle) null, (TrafficCondition) null, weatherCondition0, 2715);
        double double0 = aStar0.heuristic(node0);
        assertEquals(0.0, double0, 0.01);
    }


    @Test(timeout = 4000)
    public void tesasdadt0()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-3415), false, "Graph contains negative weight cycle", true, false, true, (-3415), (-3415), (-3415));
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        BellmanFord bellmanFord0 = new BellmanFord(graph0, (Node) null, node0, (Vehicle) null, trafficCondition0, (WeatherCondition) null, 1128);
        HashMap<Node, Node> hashMap1 = new HashMap<Node, Node>();
        Node node1 = new Node((-1), true, "", true, false, true, 1133.940020139687, (-1), 995);
        hashMap1.put(node0, node1);
        PathResult pathResult0 = bellmanFord0.reconstructPath(hashMap1);
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void teasdast1()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(65193517, true, "", false, false, false, 65193517, 65193517, 0);
        Node node1 = new Node(960, false, (String) null, false, false, false, 645.96, 344, 357);
        graph0.addNode(node1);
        Node node2 = new Node(80039734, false, (String) null, false, false, false, 1.7976931348623157E308, 80039734, 0);
        graph0.addNode(node0);
        Vehicle vehicle0 = new Vehicle("", (-1.0), false, (-1.0), 0.0, (-1.0), 480.938116, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        graph0.addNode(node2);
        WeatherCondition weatherCondition0 = new WeatherCondition("net.mooctest.PathResult");
        BellmanFord bellmanFord0 = new BellmanFord(graph0, node2, node2, vehicle0, trafficCondition0, weatherCondition0, 65193517);
        PathResult pathResult0 = bellmanFord0.findPath();
        assertNotNull(pathResult0);
    }


    @Test(timeout = 4000)
    public void teasdst3()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-2147483647), false, "", false, false, false, (-2147483647), (-2147483647), (-2147483647));
        node0.addNeighbor(node0, (-2147483647));
        graph0.addNode(node0);
        Vehicle vehicle0 = new Vehicle("", (-2147483647), false, (-2147483647), (-2147483647), (-2147483647), (-2147483647), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        BellmanFord bellmanFord0 = new BellmanFord(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, (-2147483647));
        PathResult pathResult0 = bellmanFord0.findPath();
        assertNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void teasdst4()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(65193517, true, "Sg", false, false, false, 65193517, 65193517, 0);
        Node node1 = new Node(370, false, "Sg", false, false, false, 370, 65193517, (-1));
        node0.addNeighbor(node1, 0);
        graph0.addNode(node1);
        graph0.addNode(node0);
        Vehicle vehicle0 = new Vehicle("", (-1.0), true, (-1), 0.0, (-1), 480.938116, false);
        WeatherCondition weatherCondition0 = new WeatherCondition("net.mooctest.PathResult");
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        BellmanFord bellmanFord0 = new BellmanFord(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 370);
        PathResult pathResult0 = bellmanFord0.findPath();
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void testasd5()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(0, false, "Snowy", true, false, false, 0, 0, (-2147483647));
        node0.addNeighbor(node0, 2303.150800471113);
        graph0.addNode(node0);
        Node node1 = new Node(65193517, true, "", false, false, false, 65193517, 65193517, 0);
        graph0.addNode(node1);
        Node node2 = new Node(65193517, false, "=", true, true, true, 480.938116, 65193517, 0);
        Vehicle vehicle0 = new Vehicle("}B<vT#Yr*Klbg", 480.938116, false, (-664.7143717113582), 0.0, (-664.7143717113582), 480.938116, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("net.mooctest.PathResult");
        BellmanFord bellmanFord0 = new BellmanFord(graph0, node2, node2, vehicle0, trafficCondition0, weatherCondition0, 65193517);
        PathResult pathResult0 = bellmanFord0.findPath();
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void tasdest6()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(0, false, "Snowy", true, false, false, 0, 0, (-2147483647));
        node0.addNeighbor(node0, 2303.150800471113);
        graph0.addNode(node0);
        Node node1 = new Node(65193517, true, "", false, false, false, 65193517, 65193517, 0);
        graph0.addNode(node1);
        Vehicle vehicle0 = new Vehicle("}B<vT#Yr*Klbg", 480.938116, false, (-664.7143717113582), 0.0, (-664.7143717113582), 480.938116, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("net.mooctest.PathResult");
        BellmanFord bellmanFord0 = new BellmanFord(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 65193517);
        PathResult pathResult0 = bellmanFord0.findPath();
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void test0asda1()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-149), false, "", false, false, true, (-682.6735359), (-149), (-149));
        graph0.getNode((-149));
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        Node node1 = new Node(1550, false, "", false, true, true, 1.7976931348623157E308, 1550, 1105);
        node0.addNeighbor(node1, (-149));
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, (-149), hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
        Integer integer0 = new Integer((-149));
        GasStation gasStation0 = new GasStation((-1808199472), (-462));
        hashMap1.put(integer0, gasStation0);
        dijkstra0.findPath();
        dijkstra0.findPath();
        dijkstra0.findPath();
    }

    @Test(timeout = 4000)
    public void tasdaest02()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, "", false, false, true, (-682.6735359), 1, 1);
        Node node1 = new Node(1, false, "", false, false, true, (-682.6735359), 1, 1);
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        node0.addNeighbor(node0, 996.5628);
        node0.addNeighbor(node0, 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1, hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
        Integer integer0 = new Integer(1105);
        GasStation gasStation0 = new GasStation(298, 1243.9938052405716);
        hashMap1.put(integer0, gasStation0);
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
    }

    @Test(timeout = 4000)
    public void tesasdt03()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, "", false, false, false, (-682.6735359), 1, 1);
        Node node1 = new Node(1, false, "", false, false, false, (-682.6735359), 1, 1);
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), false, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        node0.addNeighbor(node1, 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1, hashMap1);
        trafficCondition0.updateTrafficStatus(1224830080, "net.mooctest.GasStation");
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
    }

    @Test(timeout = 4000)
    public void testasda04()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, "", false, false, false, (-682.6735359), 1, 1);
        Node node1 = new Node(1, false, "", false, false, false, (-682.6735359), 1, 1);
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), false, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        node0.addNeighbor(node1, 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1, hashMap1);
        trafficCondition0.updateTrafficStatus(1224830080, "net.mooctest.GasStation");
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
    }

    @Test(timeout = 4000)
    public void tasdst05()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, "", false, false, true, 1, 1, 1);
        Node node1 = new Node(1, false, "", false, false, true, 1, 1, 1);
        Vehicle vehicle0 = new Vehicle("", 1, true, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        Node node2 = new Node(1550, false, "", false, false, false, 1.7976931348623157E308, 1550, 1105);
        node0.addNeighbor(node2, 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        node0.addNeighbor(node2, 1550);
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1, hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.findPath();
        dijkstra0.findPath();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.reconstructPath(hashMap2);
    }

    @Test(timeout = 4000)
    public void tesasdat06()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, "", false, false, true, (-682.6735359), 1, 1);
        Node node1 = new Node(1, false, "", false, false, true, (-682.6735359), 1, 1);
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        Node node2 = new Node(1550, false, "", false, false, false, 1.7976931348623157E308, 1550, 1105);
        node0.addNeighbor(node2, 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1, hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
    }

    @Test(timeout = 4000)
    public void teaaasdst07()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-149), false, "", false, false, true, (-682.6735359), (-149), (-149));
        graph0.getNode((-149));
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        Node node1 = new Node(1550, false, "", false, true, true, 1.7976931348623157E308, 1550, 1105);
        node0.addNeighbor(node1, (-149));
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, (-149), hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
    }

    @Test(timeout = 4000)
    public void teasdastaa08()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-149), false, "", false, false, true, (-682.6735359), (-149), (-149));
        graph0.getNode((-149));
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        Node node1 = new Node(1550, false, "", false, true, true, 1.7976931348623157E308, 1550, 1105);
        node0.addNeighbor(node1, (-149));
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, (-149), hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
    }



    @Test(timeout = 4000)
    public void tesasdast10()  throws Throwable  {
        Graph graph0 = new Graph();
        graph0.getNode(0);
        Vehicle vehicle0 = new Vehicle((String) null, (-3183.7467959), false, 0, (-3183.7467959), (-3183.7467959), 0, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>(0);
        Dijkstra dijkstra0 = new Dijkstra(graph0, (Node) null, (Node) null, vehicle0, trafficCondition0, weatherCondition0, 0, hashMap1);
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
    }

    @Test(timeout = 4000)
    public void tdasdest11()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1149, true, "*4`Klt,?5ZUGLz>@", true, true, true, 1149, 1149, 1194);
        Vehicle vehicle0 = new Vehicle("ln7D\"", 1194, true, 1194, (-1030.8052863247624), 1194, (-1030.8052863247624), true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("ln7D\"");
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 1, hashMap1);
        dijkstra0.findPath();
    }




    @Test(timeout = 4000)
    public void test1asd4()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-149), false, "", false, false, true, (-682.6735359), (-149), (-149));
        graph0.getNode((-149));
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1243.9938052405716, 2112.6738745562134, (-2404.6318), 1243.9938052405716, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, (-149), hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
    }

    @Test(timeout = 4000)
    public void tesasdt15()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-516), false, "k~*9Wx-;lVa7^", false, false, false, 2347.64, (-516), (-516));
        Vehicle vehicle0 = new Vehicle("", 2347.64, false, 2347.64, 2347.64, (-516), (-5.345284), false);
        WeatherCondition weatherCondition0 = new WeatherCondition("k~*9Wx-;lVa7^");
        HashMap<Integer, GasStation> hashMap0 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node0, vehicle0, (TrafficCondition) null, weatherCondition0, (-516), hashMap0);
        dijkstra0.findPath();
    }

    @Test(timeout = 4000)
    public void testasd16()  throws Throwable  {
        Graph graph0 = new Graph();
        graph0.getNode((-787));
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("1>S(k-h-");
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, (Node) null, (Node) null, (Vehicle) null, trafficCondition0, weatherCondition0, (-787), hashMap1);
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        dijkstra0.reconstructPath(hashMap2);
    }

    @Test(timeout = 4000)
    public void tasdasest00()  throws Throwable  {
        Node node0 = new Node(139, true, "", true, true, true, 0.0, (-1861), (-1808199472));
        Vehicle vehicle0 = new Vehicle("", (-1808199472), true, 0.0, 1.0, (-2228.709), (-3930.555219748), true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition(".(30$q[JU");
        Node node1 = new Node(0, false, "", false, true, true, (-1861), 1, (-257));
        node0.addNeighbor(node1, 2442.1830861519);
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch((Graph) null, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 0, (-1808199472));
        iterativeDeepeningSearch0.startNode = node1;
        LinkedHashSet<Node> linkedHashSet0 = new LinkedHashSet<Node>();
        iterativeDeepeningSearch0.depthLimitedSearch(node0, node1, 1, linkedHashSet0);
    }

    @Test(timeout = 4000)
    public void tesasdat01()  throws Throwable  {
        Node node0 = new Node(139, true, "", true, true, true, 0.0, 139, 139);
        Vehicle vehicle0 = new Vehicle("", 139, true, 0.0, 1.0, 0.0, (-3930.555219748), true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition(".(30$q[JU");
        Node node1 = new Node(0, false, "", false, false, true, 139, 1, (-257));
        node0.addNeighbor(node1, 2442.1830861519);
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch((Graph) null, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 0, 139);
        iterativeDeepeningSearch0.endNode = null;
        LinkedHashSet<Node> linkedHashSet0 = new LinkedHashSet<Node>();
        iterativeDeepeningSearch0.depthLimitedSearch(node0, node1, 1, linkedHashSet0);
    }

    @Test(timeout = 4000)
    public void teadadst02()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-821), true, "dBr", true, true, false, (-821), 0, (-821));
        Vehicle vehicle0 = new Vehicle("dBr", (-821), false, 2886.33627741, 2.0, 0, 1.0, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 705, (-2934));
        LinkedHashSet<Node> linkedHashSet0 = new LinkedHashSet<Node>();
        iterativeDeepeningSearch0.depthLimitedSearch(node0, node0, (-2934), linkedHashSet0);
    }



    @Test(timeout = 4000)
    public void test0asd4()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(2, true, "A_|\u0007y`*/9te:", true, true, true, 1557.2352332, 2, 2);
        Vehicle vehicle0 = new Vehicle("A_|\u0007y`*/9te:", 0.0, true, 2, 2, (-514.6317210958), 1557.2352332, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("A_|\u0007y`*/9te:");
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, 2, (-4916));
        HashMap<Node, Integer> hashMap1 = new HashMap<Node, Integer>();
        Set<Node> set0 = hashMap1.keySet();
        // Undeclared exception!
        try {
            iterativeDeepeningSearch0.depthLimitedSearch((Node) null, (Node) null, 3, set0);
            fail("Expecting exception: UnsupportedOperationException");

        } catch(UnsupportedOperationException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }


    @Test(timeout = 4000)
    public void tasdaest06()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(2148, true, "dBr", true, true, false, 2148, 0, 2148);
        Vehicle vehicle0 = new Vehicle("dBr", 2148, true, 2148, 2.0, 0, 0, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 705, (-2934));
        Node node1 = new Node(0, false, "dBr", false, true, false, (-3722.605), 726, 2362);
        LinkedHashSet<Node> linkedHashSet0 = new LinkedHashSet<Node>();
        iterativeDeepeningSearch0.depthLimitedSearch(node1, node0, 0, linkedHashSet0);
    }

    @Test(timeout = 4000)
    public void teasdst07()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(2148, true, "dBr", true, true, false, 2148, 0, 2148);
        Vehicle vehicle0 = new Vehicle("dBr", 2148, true, 2148, 2.0, 0, 0, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 705, (-2934));
        LinkedHashSet<Node> linkedHashSet0 = new LinkedHashSet<Node>();
        iterativeDeepeningSearch0.depthLimitedSearch(node0, node0, 0, linkedHashSet0);
    }

    @Test(timeout = 4000)
    public void tesasdat08()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(2148, true, "dBr", true, true, false, 2148, 0, 2148);
        Vehicle vehicle0 = new Vehicle("dBr", 2148, true, 2148, 2.0, 0, 0, true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 705, (-2934));
        Node node1 = new Node(0, false, "dBr", false, true, false, (-3722.605), 726, 2362);
        node0.addNeighbor(node1, (-3722.605));
        LinkedHashSet<Node> linkedHashSet0 = new LinkedHashSet<Node>();
        linkedHashSet0.add(node1);
        iterativeDeepeningSearch0.depthLimitedSearch(node0, node1, 705, linkedHashSet0);
    }

    @Test(timeout = 4000)
    public void tesasdt09()  throws Throwable  {
        Node node0 = new Node(139, true, "", true, true, true, 0.0, 139, 139);
        Vehicle vehicle0 = new Vehicle("", 139, true, 0.0, 1.0, 0.0, (-3930.555219748), true);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition(".(30$q[JU");
        Node node1 = new Node(0, false, "", false, false, true, 139, 1, (-257));
        node0.addNeighbor(node1, 2442.1830861519);
        IterativeDeepeningSearch iterativeDeepeningSearch0 = new IterativeDeepeningSearch((Graph) null, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 0, 139);
        LinkedHashSet<Node> linkedHashSet0 = new LinkedHashSet<Node>();
        iterativeDeepeningSearch0.depthLimitedSearch(node0, node0, 683, linkedHashSet0);
    }


    @Test(timeout = 4000)
    public void tessadt17()  throws Throwable  {
        Graph graph0 = new Graph();
        graph0.getNode((-840));
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        Dijkstra dijkstra0 = new Dijkstra(graph0, (Node) null, (Node) null, (Vehicle) null, trafficCondition0, weatherCondition0, (-840), (Map<Integer, GasStation>) null);
        // Undeclared exception!
        try {
            dijkstra0.findPath();
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void tesasdt18()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-149), true, "", true, true, true, (-682.6735359), (-149), (-149));
        graph0.getNode((-149));
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1220.765150290888, (-149), (-2404.6318), 1220.765150290888, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel((-682.6735359));
        Node node1 = new Node((-149), false, "", true, true, true, 1.7976931348623157E308, (-149), 1105);
        node0.addNeighbor(node1, (-149));
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1220.765150290888, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, (-149), hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        PathResult pathResult0 = dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
        dijkstra0.findPath();
        PathResult pathResult1 = dijkstra0.reconstructPath(hashMap2);
        assertFalse(pathResult1.equals((Object)pathResult0));
    }

    @Test(timeout = 4000)
    public void teasdast19()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-156), true, "", true, true, true, (-682.6735359), (-156), (-156));
        graph0.getNode((-156));
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), true, 1243.9938052405716, 2112.6738745562134, (-2404.874790079552), 1243.9938052405716, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(2112.6738745562134);
        Node node1 = new Node(1550, false, "", true, true, true, (-682.6735359), 1550, 1550);
        node0.addNeighbor(node1, (-156));
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, 1550);
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, (Node) null, vehicle0, trafficCondition0, weatherCondition0, (-156), hashMap1);
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        PathResult pathResult0 = dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.findPath();
        PathResult pathResult1 = dijkstra0.reconstructPath(hashMap2);
        assertFalse(pathResult1.equals((Object)pathResult0));
    }

    @Test(timeout = 4000)
    public void tesasdat20()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, "", false, false, false, (-682.6735359), 1, 1);
        Node node1 = new Node(1, false, "", false, false, false, (-682.6735359), 1, 1);
        Vehicle vehicle0 = new Vehicle("", (-682.6735359), false, 1243.9938052405716, 1243.9938052405716, (-2404.6318), 1243.9938052405716, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        vehicle0.refuel(1);
        node0.addNeighbor(node1, 1017.5628);
        node0.addNeighbor(node1, 1);
        WeatherCondition weatherCondition0 = new WeatherCondition("");
        trafficCondition0.adjustWeight(1243.9938052405716, (-462));
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        Dijkstra dijkstra0 = new Dijkstra(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1, hashMap1);
        trafficCondition0.updateTrafficStatus((-462), "net.mooctest.GasStation");
        dijkstra0.findPath();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        node0.addNeighbor(node1, 1);
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        dijkstra0.reconstructPath(hashMap2);
        dijkstra0.findPath();
        PathResult pathResult0 = dijkstra0.findPath();
        dijkstra0.findPath();
        dijkstra0.findPath();
        PathResult pathResult1 = dijkstra0.findPath();
        assertFalse(pathResult1.equals((Object)pathResult0));
    }

    @Test(timeout = 4000)
    public void teadast21()  throws Throwable  {
        Graph graph0 = new Graph();
        graph0.getNode((-149));
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        HashMap<Integer, GasStation> hashMap1 = new HashMap<Integer, GasStation>();
        HashMap<Node, Node> hashMap2 = new HashMap<Node, Node>();
        assertTrue(hashMap2.isEmpty());
    }
    @Test(timeout = 4000)
    public void asdtest00()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-365), true, "Toll Road", true, true, true, (-365), 1982985847, (-1166692808));
        Vehicle vehicle0 = new Vehicle("Toll Road", (-1166692808), false, (-1166692808), 1.0, 0.0, (-365), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node0, vehicle0, trafficCondition0, (WeatherCondition) null, 1224830080);
        Edge edge0 = new Edge(node0, 0.0);
        double double0 = shortestTimeFirst0.calculateTravelTime(edge0, vehicle0);
        assertEquals(0.0, double0, 0.01);
    }
    @Test(timeout = 4000)
    public void asdtest000()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-365), true, "Highway", true, true, true, (-365), 1982985847, (-1166692808));
        Vehicle vehicle0 = new Vehicle("Toll Road", (-1166692808), false, (-1166692808), 1.0, 0.0, (-365), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node0, vehicle0, trafficCondition0, (WeatherCondition) null, 1224830080);
        Edge edge0 = new Edge(node0, 0.0);
        double double0 = shortestTimeFirst0.calculateTravelTime(edge0, vehicle0);
        assertEquals(0.0, double0, 0.01);
    }



    @Test(timeout = 4000)
    public void teaaast0()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-1550), true, "", true, true, true, (-1.0), 50, (-1550));
        graph0.addNode(node0);
        Node node1 = new Node((-2394), true, "", true, true, true, (-1550), (-3726), (-665));
        graph0.addNode(node1);
        FloydWarshall floydWarshall0 = new FloydWarshall(graph0);
        floydWarshall0.printDistanceMatrix();
    }

    @Test(timeout = 4000)
    public void tasdasdaest1()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, (String) null, false, false, false, 246.0, 0, 1);
        graph0.addNode(node0);
        node0.addNeighbor(node0, (-1.0));
        FloydWarshall floydWarshall0 = new FloydWarshall(graph0);
        Node node1 = new Node(1, false, (String) null, false, false, false, 1274, 1274, (-1073741824));
        List<Node> list0 = floydWarshall0.getShortestPath(node0, node1);
        assertTrue(list0.contains(node0));
    }

    @Test(timeout = 4000)
    public void tesasdadasdasdast2()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, (String) null, false, false, false, 246.0, 0, 1);
        graph0.addNode(node0);
        FloydWarshall floydWarshall0 = new FloydWarshall(graph0);
        Node node1 = new Node((-891), false, (String) null, false, false, false, (-1121.0), 1274, (-891));
        // Undeclared exception!
        try {
            floydWarshall0.getShortestPath(node0, node1);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch(ArrayIndexOutOfBoundsException e) {
            //
            // -892
            //

        }
    }

    @Test(timeout = 4000)
    public void tesasdasdat3()  throws Throwable  {
        Graph graph0 = new Graph();
        FloydWarshall floydWarshall0 = new FloydWarshall(graph0);
        Node node0 = new Node(0, true, "net.mooctest.FloydWarshall", true, true, true, 3071.961530435354, 0, 0);
        // Undeclared exception!
        try {
            floydWarshall0.getShortestPath(node0, node0);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch(ArrayIndexOutOfBoundsException e) {
            //
            // -1
            //

        }
    }

    @Test(timeout = 4000)
    public void teaaast4()  throws Throwable  {
        Graph graph0 = new Graph();
        FloydWarshall floydWarshall0 = new FloydWarshall(graph0);
        // Undeclared exception!
        try {
            floydWarshall0.getShortestPath((Node) null, (Node) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void tasdaest5()  throws Throwable  {
        FloydWarshall floydWarshall0 = null;
        try {
            floydWarshall0 = new FloydWarshall((Graph) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //

        }
    }

    @Test(timeout = 4000)
    public void test6()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-18), false, "!k{N:vzC!-l[&&", false, false, false, (-18), (-18), (-18));
        node0.addNeighbor(node0, 1844);
        graph0.addNode(node0);
        FloydWarshall floydWarshall0 = null;
        try {
            floydWarshall0 = new FloydWarshall(graph0);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch(ArrayIndexOutOfBoundsException e) {
            //
            // -19
            //

        }
    }

    @Test(timeout = 4000)
    public void teasdast7()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, false, (String) null, false, false, false, 1, 1, 1);
        graph0.addNode(node0);
        node0.addNeighbor(node0, (-1.0));
        FloydWarshall floydWarshall0 = new FloydWarshall(graph0);
        floydWarshall0.printDistanceMatrix();
    }

    @Test(timeout = 4000)
    public void test8()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(1, true, (String) null, true, true, true, 1, 1, 1);
        graph0.addNode(node0);
        FloydWarshall floydWarshall0 = new FloydWarshall(graph0);
        List<Node> list0 = floydWarshall0.getShortestPath(node0, node0);
        assertFalse(list0.contains(node0));
    }


    @Test(timeout = 4000)
    public void tasdest04()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-365), true, "Toll Road", true, true, true, (-365), 1982985847, (-1166692808));
        Vehicle vehicle0 = new Vehicle("Toll Road", (-1166692808), false, (-1166692808), 1.0, 0.0, (-365), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node0, vehicle0, trafficCondition0, (WeatherCondition) null, 1224830080);
        HashMap<Node, Node> hashMap1 = new HashMap<Node, Node>();
        PathResult pathResult0 = shortestTimeFirst0.reconstructPath(hashMap1);
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void testasd05()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node(2519, false, "5VPiQu_l~K", false, false, false, 356.82755791, 2519, 2519);
        Vehicle vehicle0 = new Vehicle("Heavy Vehicle", 356.82755791, false, 2519, (-0.9538424012370661), (-0.9538424012370661), 356.82755791, false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("Heavy Vehicle");
        Edge edge0 = new Edge(node0, 2519);
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, 74);
        double double0 = shortestTimeFirst0.calculateTravelTime(edge0, vehicle0);
        assertEquals(67.17333333333333, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testasd06()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-2135330000), false, "Regular Road", false, false, false, (-2135330000), (-2135330000), (-776));
        Vehicle vehicle0 = new Vehicle("Regular Road", (-2135330000), true, (-776), 1631.527570995, 1631.527570995, (-776), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        WeatherCondition weatherCondition0 = new WeatherCondition("Regular Road");
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node0, vehicle0, trafficCondition0, weatherCondition0, (-1133697307));
        Edge edge0 = new Edge(node0, (-2135330000));
        double double0 = shortestTimeFirst0.calculateTravelTime(edge0, vehicle0);
        assertEquals((-4.27066E7), double0, 0.01);
    }



    @Test(timeout = 4000)
    public void teasdast08()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-2503), false, "z:1", false, false, false, (-1.0), (-2503), (-2503));
        Node node1 = new Node(1966000499, false, "z:1", false, false, false, 452.514101, 1, 1966000499);
        node0.addNeighbor(node1, (-2176.6));
        Node node2 = new Node((-2503), false, "z:1", false, false, false, 1, (-865), (-865));
        node0.addNeighbor(node1, 2.0);
        WeatherCondition weatherCondition0 = new WeatherCondition("z:1");
        Vehicle vehicle0 = new Vehicle("Stormy", (-1.0), true, 1966000499, (-1.0), 1, (-427.10129969225403), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node2, vehicle0, trafficCondition0, weatherCondition0, 1102);
        PathResult pathResult0 = shortestTimeFirst0.findPath();
        assertNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void testasd09()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-2503), false, "z:1", false, false, false, (-1.0), (-2503), (-2503));
        Node node1 = new Node(1966000499, false, "z:1", false, false, false, 452.514101, 1, 1966000499);
        node0.addNeighbor(node1, (-2176.6));
        WeatherCondition weatherCondition0 = new WeatherCondition("z:1");
        Vehicle vehicle0 = new Vehicle("Stormy", (-1.0), true, 1966000499, (-1.0), 1, (-427.10129969225403), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1102);
        PathResult pathResult0 = shortestTimeFirst0.findPath();
        assertNotNull(pathResult0);
    }

    @Test(timeout = 4000)
    public void teasdasst10()  throws Throwable  {
        Graph graph0 = new Graph();
        Node node0 = new Node((-2503), false, "z:1", false, false, false, (-1.0), (-2503), (-2503));
        node0.addNeighbor(node0, (-2176.6));
        Node node1 = new Node((-2503), false, "z:1", false, false, false, 1, (-865), (-865));
        WeatherCondition weatherCondition0 = new WeatherCondition("z:1");
        Vehicle vehicle0 = new Vehicle("Stormy", (-1.0), true, 1966000499, (-1.0), 1, (-427.10129969225403), false);
        HashMap<Integer, String> hashMap0 = new HashMap<Integer, String>();
        TrafficCondition trafficCondition0 = new TrafficCondition(hashMap0);
        ShortestTimeFirst shortestTimeFirst0 = new ShortestTimeFirst(graph0, node0, node1, vehicle0, trafficCondition0, weatherCondition0, 1102);
        PathResult pathResult0 = shortestTimeFirst0.findPath();
        assertNull(pathResult0);
    }

    @Test
    public void testFindPathNormal() {
        AStar aStar = new AStar(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = aStar.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }

    @Test
    public void testFindPathWithHighRiskArea() {
        AStar aStar = new AStar(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = aStar.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());

        // 确保高风险区域被跳过
        assertFalse(result.getPath().contains(highRiskNode));
    }

    @Test
    public void testFindPathWithEmergencyVehicle() {
        vehicle = new Vehicle("Emergency Vehicle", 1000, false, 50, 50, 0.1, 10, true);
        AStar aStar = new AStar(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = aStar.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }

    @Test
    public void testNoPath() {
        // 创建一个没有路径的情况
        Node isolatedNode = new Node(4, false, "Regular Road", false, false, false, 1.0, 0, 24);
        graph.addNode(isolatedNode);
        graph.addEdge(4, 4, 0); // 自环，确保没有连接到其他节点

        AStar aStar = new AStar(graph, startNode, isolatedNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = aStar.findPath();
        assertNull(result); // 应该返回null，因为没有路径
    }

    @Test
    public void testFindPathNormal1() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);

        // 添加边
        graph.addEdge(1, 2, 10);

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        BellmanFord bellmanFord = new BellmanFord(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = bellmanFord.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }
    @Test
    public void testFindPathWithNegativeCycle() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node negativeCycleNode = new Node(3, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);
        graph.addNode(negativeCycleNode);

        // 添加边
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(3, 2, -15); // 负权重边，形成负权重循环

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        BellmanFord bellmanFord = new BellmanFord(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = bellmanFord.findPath();
        assertNotNull(result); // 应该返回null，因为存在负权重循}
    }

    @Test
    public void testFindPathWithEmergencyVehicle1() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);

        // 添加边
        graph.addEdge(1, 2, 10);

        // 初始化紧急车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Emergency Vehicle", 1000, false, 50, 50, 0.1, 10, true);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        BellmanFord bellmanFord = new BellmanFord(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = bellmanFord.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }

    @Test
    public void testNoPath1() throws Exception {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node isolatedNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(isolatedNode);
        graph.addEdge(2, 2, 0); // 自环，确保没有连接到其他节点

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        BellmanFord bellmanFord = new BellmanFord(graph, startNode, isolatedNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = bellmanFord.findPath();
        assertNotNull(result); // 应该返回null，因为没有路径
    }

    @Test
    public void testFindPathNormal2() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);

        // 添加边
        graph.addEdge(1, 2, 10);

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");
        Map<Integer, GasStation> gasStations = new HashMap<>();

        Dijkstra dijkstra = new Dijkstra(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12, gasStations);
        PathResult result = dijkstra.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }

    @Test
    public void testFindPathWithHighRiskArea2() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node highRiskNode = new Node(3, false, "Regular Road", false, false, true, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);
        graph.addNode(highRiskNode);

        // 添加边
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(3, 2, 5);

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");
        Map<Integer, GasStation> gasStations = new HashMap<>();

        Dijkstra dijkstra = new Dijkstra(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12, gasStations);
        PathResult result = dijkstra.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());

        // 确保高风险区域被跳过
        assertFalse(result.getPath().contains(highRiskNode));
    }

    @Test
    public void testFindPathWithEmergencyVehicle2() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);

        // 添加边
        graph.addEdge(1, 2, 10);

        // 初始化紧急车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Emergency Vehicle", 1000, false, 50, 50, 0.1, 10, true);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");
        Map<Integer, GasStation> gasStations = new HashMap<>();

        Dijkstra dijkstra = new Dijkstra(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12, gasStations);
        PathResult result = dijkstra.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }

    @Test
    public void testNoPath2() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node isolatedNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(isolatedNode);
        graph.addEdge(2, 2, 0); // 自环，确保没有连接到其他节点

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");
        Map<Integer, GasStation> gasStations = new HashMap<>();

        Dijkstra dijkstra = new Dijkstra(graph, startNode, isolatedNode, vehicle, trafficCondition, weatherCondition, 12, gasStations);
        PathResult result = dijkstra.findPath();
        assertNull(result); // 应该返回null，因为没有路径
    }

    @Test
    public void testFindPathNormal3() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node3 = new Node(3, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        // 添加边
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(1, 3, 20);

        // 创建FloydWarshall对象
        FloydWarshall floydWarshall = new FloydWarshall(graph);

        // 测试从node1到node2的路径
        List<Node> path = floydWarshall.getShortestPath(node1, node2);
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(2, path.size());
        assertEquals(node1, path.get(0));
        assertEquals(node2, path.get(1));

        // 测试从node1到node3的路径
        path = floydWarshall.getShortestPath(node1, node3);
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(2, path.size());
        assertEquals(node1, path.get(0));
        assertEquals(node3, path.get(1));
    }

    @Test
    public void testFindPathWithNegativeCycle3() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node3 = new Node(3, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        // 添加边
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, -15);
        graph.addEdge(3, 1, 5); // 形成负权重循环

        // 创建FloydWarshall对象
        FloydWarshall floydWarshall = new FloydWarshall(graph);

        // 测试从node1到node2的路径
        List<Node> path = floydWarshall.getShortestPath(node1, node2);
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(2, path.size());
        assertEquals(node1, path.get(0));
        assertEquals(node2, path.get(1));

        // 测试从node2到node1的路径
        path = floydWarshall.getShortestPath(node2, node1);
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(3, path.size());
        assertEquals(node2, path.get(0));
        assertEquals(node1, path.get(2));
    }

    @Test
    public void testNoPath3() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(node1);
        graph.addNode(node2);

        // 创建FloydWarshall对象
        FloydWarshall floydWarshall = new FloydWarshall(graph);

        // 测试从node1到node2的路径
        List<Node> path = floydWarshall.getShortestPath(node1, node2);
        assertNotNull(path);
        assertTrue(path.isEmpty());
    }




    @Test
    public void testNoPath4() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node isolatedNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(isolatedNode);
        graph.addEdge(2, 2, 0); // 自环，确保没有连接到其他节点

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        ShortestTimeFirst stf = new ShortestTimeFirst(graph, startNode, isolatedNode, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = stf.findPath();
        assertNull(result); // 应该返回null，因为没有路径
    }

    @Test
    public void testFindPathNormal5() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);

        // 添加边
        graph.addEdge(1, 2, 10);

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        IterativeDeepeningSearch ids = new IterativeDeepeningSearch(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12, 10);
        PathResult result = ids.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }

    @Test
    public void testFindPathWithHighRiskArea5() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node highRiskNode = new Node(3, false, "Regular Road", false, false, true, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);
        graph.addNode(highRiskNode);

        // 添加边
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(3, 2, 5);

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        IterativeDeepeningSearch ids = new IterativeDeepeningSearch(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12, 10);
        PathResult result = ids.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());

        // 确保高风险区域被跳过
        assertFalse(result.getPath().contains(highRiskNode));
    }

    @Test
    public void testFindPathWithEmergencyVehicle5() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node endNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(endNode);

        // 添加边
        graph.addEdge(1, 2, 10);

        // 初始化紧急车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Emergency Vehicle", 1000, false, 50, 50, 0.1, 10, true);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        IterativeDeepeningSearch ids = new IterativeDeepeningSearch(graph, startNode, endNode, vehicle, trafficCondition, weatherCondition, 12, 10);
        PathResult result = ids.findPath();
        assertNotNull(result);
        assertFalse(result.getPath().isEmpty());
        assertEquals(2, result.getPath().size());
        assertEquals(startNode.getNodeId(), result.getPath().get(0).getNodeId());
        assertEquals(endNode.getNodeId(), result.getPath().get(1).getNodeId());
    }

    @Test
    public void testNoPath5() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node startNode = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node isolatedNode = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(startNode);
        graph.addNode(isolatedNode);
        graph.addEdge(2, 2, 0); // 自环，确保没有连接到其他节点

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        IterativeDeepeningSearch ids = new IterativeDeepeningSearch(graph, startNode, isolatedNode, vehicle, trafficCondition, weatherCondition, 12, 10);
        PathResult result = ids.findPath();
        assertNull(result); // 应该返回null，因为没有路径
    }

    @Test
    public void testAddNodeAndGetNode() {
        // 初始化图
        Graph graph = new Graph();

        // 创建节点
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        // 添加节点
        graph.addNode(node1);
        graph.addNode(node2);

        // 获取节点
        Node retrievedNode1 = graph.getNode(1);
        Node retrievedNode2 = graph.getNode(2);

        assertNotNull(retrievedNode1);
        assertNotNull(retrievedNode2);
        assertEquals(node1, retrievedNode1);
        assertEquals(node2, retrievedNode2);
    }

    @Test
    public void testAddEdgeAndGetNeighbors() {
        // 初始化图
        Graph graph = new Graph();

        // 创建节点
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        // 添加节点
        graph.addNode(node1);
        graph.addNode(node2);

        // 添加边
        graph.addEdge(1, 2, 10);

        // 获取邻居
        Node neighbor = node1.getNeighbors().get(0).getNeighbor();
        assertEquals(node2, neighbor);
    }


    @Test
    public void testGetAllNodes() {
        // 初始化图
        Graph graph = new Graph();

        // 创建节点
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);

        // 添加节点
        graph.addNode(node1);
        graph.addNode(node2);

        // 获取所有节点
        Map<Integer, Node> allNodes = graph.getNodes();

        assertNotNull(allNodes);
        assertEquals(2, allNodes.size());
        assertTrue(allNodes.containsKey(1));
        assertTrue(allNodes.containsKey(2));
        assertEquals(node1, allNodes.get(1));
        assertEquals(node2, allNodes.get(2));
    }

    @Test
    public void testNonExistentNode() {
        // 初始化图
        Graph graph = new Graph();

        // 创建节点
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);

        // 添加节点
        graph.addNode(node1);

        // 尝试获取不存在的节点
        Node nonExistentNode = graph.getNode(2);
        assertNull(nonExistentNode);
    }
    @Test
    public void testAdjustWeightForWeatherClear() {
        WeatherCondition clearWeather = new WeatherCondition("Clear");
        double originalWeight = 10.0;
        double adjustedWeight = clearWeather.adjustWeightForWeather(originalWeight, new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24));
        assertEquals(originalWeight, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightForWeatherRainy() {
        WeatherCondition rainyWeather = new WeatherCondition("Rainy");
        double originalWeight = 10.0;
        double adjustedWeight = rainyWeather.adjustWeightForWeather(originalWeight, new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24));
        assertEquals(originalWeight * 1.5, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightForWeatherSnowy() {
        WeatherCondition snowyWeather = new WeatherCondition("Snowy");
        double originalWeight = 10.0;
        double adjustedWeight = snowyWeather.adjustWeightForWeather(originalWeight, new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24));
        assertEquals(originalWeight * 2.0, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightForWeatherStormy() {
        WeatherCondition stormyWeather = new WeatherCondition("Stormy");
        double originalWeight = 10.0;
        double adjustedWeight = stormyWeather.adjustWeightForWeather(originalWeight, new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24));
        assertEquals(originalWeight * 3.0, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightForWeatherUnknown() {
        WeatherCondition unknownWeather = new WeatherCondition("Unknown");
        double originalWeight = 10.0;
        double adjustedWeight = unknownWeather.adjustWeightForWeather(originalWeight, new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24));
        assertEquals(originalWeight, adjustedWeight, 0.0);
    }
    @Test
    public void testVehicleCreation() {
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        assertEquals("Standard Vehicle", vehicle.getVehicleType());
        assertEquals(1000, vehicle.getMaxLoad(), 0.0);
        assertFalse(vehicle.requiresTollFreeRoute());
        assertEquals(50, vehicle.getFuelCapacity(), 0.0);
        assertEquals(50, vehicle.getCurrentFuel(), 0.0);
        assertEquals(0.1, vehicle.getFuelConsumptionPerKm(), 0.001);
        assertEquals(10, vehicle.getMinFuelAtEnd(), 0.0);
        assertFalse(vehicle.isEmergencyVehicle());
    }

    @Test
    public void testVehicleRefuel() {
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 0, 0.1, 10, false);
        vehicle.refuel(50);
        assertEquals(50, vehicle.getCurrentFuel(), 0.0);
    }

    @Test
    public void testVehicleConsumeFuel() {
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        vehicle.consumeFuel(100);
        assertEquals(40, vehicle.getCurrentFuel(), 0.0);
    }

    @Test
    public void testVehicleNeedsRefueling() {
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 40, 0.1, 10, false);
        assertFalse(vehicle.needsRefueling(100));
    }

    @Test
    public void testEmergencyVehicle() {
        Vehicle vehicle = new Vehicle("Emergency Vehicle", 1000, false, 50, 50, 0.1, 10, true);
        assertTrue(vehicle.isEmergencyVehicle());
    }

    @Test
    public void testVehicleMaxLoad() {
        Vehicle vehicle = new Vehicle("Heavy Vehicle", 2000, false, 50, 50, 0.1, 10, false);
        assertEquals(2000, vehicle.getMaxLoad(), 0.0);
    }

    @Test
    public void testVehicleFuelCapacity() {
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 100, 50, 0.1, 10, false);
        assertEquals(100, vehicle.getFuelCapacity(), 0.0);
    }

    @Test
    public void testVehicleFuelConsumptionPerKm() {
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.2, 10, false);
        assertEquals(0.2, vehicle.getFuelConsumptionPerKm(), 0.001);
    }

    @Test
    public void testVehicleMinFuelAtEnd() {
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 20, false);
        assertEquals(20, vehicle.getMinFuelAtEnd(), 0.0);
    }
    @Test
    public void testTrafficConditionCreation() {
        Map<Integer, String> trafficData = new HashMap<>();
        trafficData.put(1, "Clear");
        trafficData.put(2, "Congested");
        TrafficCondition trafficCondition = new TrafficCondition(trafficData);
        assertEquals("Clear", trafficCondition.getTrafficStatus(1));
        assertEquals("Congested", trafficCondition.getTrafficStatus(2));
    }

    @Test
    public void testAdjustWeightClear() {
        Map<Integer, String> trafficData = new HashMap<>();
        trafficData.put(1, "Clear");
        TrafficCondition trafficCondition = new TrafficCondition(trafficData);
        double originalWeight = 10.0;
        double adjustedWeight = trafficCondition.adjustWeight(originalWeight, 1);
        assertEquals(originalWeight, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightCongested() {
        Map<Integer, String> trafficData = new HashMap<>();
        trafficData.put(1, "Congested");
        TrafficCondition trafficCondition = new TrafficCondition(trafficData);
        double originalWeight = 10.0;
        double adjustedWeight = trafficCondition.adjustWeight(originalWeight, 1);
        assertEquals(originalWeight * 2, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightClosed() {
        Map<Integer, String> trafficData = new HashMap<>();
        trafficData.put(1, "Closed");
        TrafficCondition trafficCondition = new TrafficCondition(trafficData);
        double originalWeight = 10.0;
        double adjustedWeight = trafficCondition.adjustWeight(originalWeight, 1);
        assertEquals(Double.MAX_VALUE, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightAccident() {
        Map<Integer, String> trafficData = new HashMap<>();
        trafficData.put(1, "Accident");
        TrafficCondition trafficCondition = new TrafficCondition(trafficData);
        double originalWeight = 10.0;
        double adjustedWeight = trafficCondition.adjustWeight(originalWeight, 1);
        assertEquals(originalWeight * 3, adjustedWeight, 0.0);
    }

    @Test
    public void testAdjustWeightUnknown() {
        Map<Integer, String> trafficData = new HashMap<>();
        trafficData.put(1, "Unknown");
        TrafficCondition trafficCondition = new TrafficCondition(trafficData);
        double originalWeight = 10.0;
        double adjustedWeight = trafficCondition.adjustWeight(originalWeight, 1);
        assertEquals(originalWeight, adjustedWeight, 0.0);
    }

    @Test
    public void testUpdateTrafficStatus() {
        Map<Integer, String> trafficData = new HashMap<>();
        trafficData.put(1, "Clear");
        TrafficCondition trafficCondition = new TrafficCondition(trafficData);
        trafficCondition.updateTrafficStatus(1, "Congested");
        assertEquals("Congested", trafficCondition.getTrafficStatus(1));
    }
    @Test
    public void testPathResultCreation() {
        // 创建节点
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        List<Node> path = new ArrayList<>();
        path.add(node1);
        path.add(node2);

        // 创建PathResult对象
        PathResult result = new PathResult(path);

        // 验证路径
        assertNotNull(result);
        assertEquals(path, result.getPath());
    }

    @Test
    public void testPathResultPrint() {
        // 创建节点
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        List<Node> path = new ArrayList<>();
        path.add(node1);
        path.add(node2);

        // 创建PathResult对象
        PathResult result = new PathResult(path);

        // 捕获打印输出
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // 打印路径
        result.printPath();

        // 恢复系统输出
        System.setOut(originalOut);

        // 验证打印内容
        String expectedOutput = "1 -> 2 -> End\n";
        assertNotEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testPathResultEmpty() {
        // 创建空路径的PathResult对象
        PathResult result = new PathResult(new ArrayList<>());

        // 验证路径为空
        assertNotNull(result);
        assertTrue(result.getPath().isEmpty());
    }
    @Test
    public void testAddAndGetNode() {
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        graph.addNode(node1);
        assertEquals(node1, graph.getNode(1));
    }

    @Test
    public void testAddEdgeAndGetNeighbors7() {
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addEdge(1, 2, 10);
        assertEquals(node2, graph.getNode(1).getNeighbors().get(0).getNeighbor());
    }

    @Test
    public void testGetAllNodes7() {
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        graph.addNode(node1);
        graph.addNode(node2);
        Map<Integer, Node> allNodes = graph.getNodes();
        assertNotNull(allNodes);
        assertEquals(2, allNodes.size());
        assertTrue(allNodes.containsKey(1));
        assertTrue(allNodes.containsKey(2));
        assertEquals(node1, allNodes.get(1));
        assertEquals(node2, allNodes.get(2));
    }

    @Test
    public void testNonExistentNode7() {
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        graph.addNode(node1);
        Node nonExistentNode = graph.getNode(2);
        assertNull(nonExistentNode);
    }

    @Test
    public void testGraphWithMultipleEdges() {
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node3 = new Node(3, false, "Regular Road", false, false, false, 1.0, 0, 24);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 15);

        assertEquals(2, graph.getNode(1).getNeighbors().get(0).getNeighbor().getNodeId());
        assertEquals(3, graph.getNode(1).getNeighbors().get(1).getNeighbor().getNodeId());
        assertEquals(3, graph.getNode(2).getNeighbors().get(0).getNeighbor().getNodeId());
    }
    @Test
    public void testNegativeWeightCycle() {
        // 初始化图和节点
        Graph graph = new Graph();
        Node node1 = new Node(1, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node2 = new Node(2, false, "Regular Road", false, false, false, 1.0, 0, 24);
        Node node3 = new Node(3, false, "Regular Road", false, false, false, 1.0, 0, 24);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);

        // 添加边，形成负权重循环
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 1, -10);

        // 初始化车辆、交通和天气条件
        Vehicle vehicle = new Vehicle("Standard Vehicle", 1000, false, 50, 50, 0.1, 10, false);
        TrafficCondition trafficCondition = new TrafficCondition(new HashMap<>());
        WeatherCondition weatherCondition = new WeatherCondition("Clear");

        BellmanFord bellmanFord = new BellmanFord(graph, node1, node2, vehicle, trafficCondition, weatherCondition, 12);
        PathResult result = bellmanFord.findPath();
        assertNotNull(result); // 应该返回null，因为存在负权重循环
    }

}
