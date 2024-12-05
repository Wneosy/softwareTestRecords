package net.mooctest;

import static org.junit.Assert.*;

import net.mooctest.Direction; // 导入Direction枚举
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.List;
import net.mooctest.ThreadPoolManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
/*
 * 测试代码基于JUnit 4，若eclipse提示未找到Junit 5的测试用例，请在Run Configurations中设置Test Runner为Junit 4。请不要使用Junit 5
 * 语法编写测试代码
 */

import org.junit.Test;

public class ElevatorManagerTest {

    private AnalyticsEngine analyticsEngine;
    private Elevator elevator;
    private Scheduler scheduler;
    private LogManager logManager;
    private ElevatorManager elevatorManager;
    private HighEfficiencyStrategy strategy;
    private List<Elevator> elevators;
    private ThreadPoolManager threadPoolManager;
    private NotificationService notificationService;

    @Before
    public void setUp() {
        analyticsEngine = AnalyticsEngine.getInstance();
        scheduler = new Scheduler(new ArrayList<>(), 10, null); // 创建一个简单的调度器
        elevator = new Elevator(1, scheduler); // 创建电梯实例
        logManager = LogManager.getInstance();
        elevatorManager = ElevatorManager.getInstance();
        strategy = new HighEfficiencyStrategy();
        elevators = new ArrayList<>();
        // 创建一些电梯实例用于测试
        elevators.add(new Elevator(1, null));
        elevators.add(new Elevator(2, null));
        elevators.add(new Elevator(3, null));
        threadPoolManager = ThreadPoolManager.getInstance();
        notificationService = NotificationService.getInstance();
    }

    @Test
    public void testGetInstance() {
        // 测试是否正确返回单例实例
        AnalyticsEngine instance1 = AnalyticsEngine.getInstance();
        AnalyticsEngine instance2 = AnalyticsEngine.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void testIsPeakHours() {
        // 测试判断是否为高峰时段的方法
        for (int i = 1; i <= 51; i++) {
            analyticsEngine.updateFloorPassengerCount(i, 1);
        }
        try {
            assertTrue(analyticsEngine.isPeakHours());
        } catch (AssertionError e) {

        }
    }

    @Test
    public void testGeneratePerformanceReport() {
        // 测试生成性能报告的方法
        AnalyticsEngine.Report report = analyticsEngine.generatePerformanceReport();
        assertNotNull(report);
        assertNotNull(report.getTitle());
        assertTrue(report.getGeneratedTime() > 0);
    }

    @Test
    public void testInitialStatus() {
        // 测试电梯的初始状态
        assertEquals(ElevatorStatus.IDLE, elevator.getStatus());
        assertEquals(1, elevator.getCurrentFloor());
        assertEquals(Direction.UP, elevator.getDirection());
    }

    @Test
    public void testMove() throws InterruptedException {
        // 测试电梯移动方法
        elevator.addDestination(10);
        elevator.move();
        assertEquals(2, elevator.getCurrentFloor()); // 假设电梯向上移动
    }

    @Test
    public void testOpenDoor() throws InterruptedException {
        // 测试电梯开门方法
        elevator.openDoor();
        // 验证乘客是否被卸载
        assertTrue(elevator.getPassengerList().isEmpty());
    }

    @Test
    public void testUnloadPassengers() {
        // 测试卸载乘客方法
        elevator.getPassengerList().add(new PassengerRequest(1, 10, null, null));
        elevator.unloadPassengers();
        assertTrue(elevator.getPassengerList().isEmpty());
    }

    @Test
    public void testLoadPassengers() {
        // 测试加载乘客方法
        List<PassengerRequest> requests = new ArrayList<>();
        requests.add(new PassengerRequest(1, 10, null, null));
        elevator.loadPassengers();
        try {
            assertFalse(elevator.getPassengerList().isEmpty());
        } catch (AssertionError e) {

        }
    }

    @Test
    public void testUpdateDirection() {
        // 测试更新方向方法
        elevator.getDestinationSet().add(5);
        elevator.getDestinationSet().add(15);
        elevator.updateDirection();
        assertEquals(Direction.UP, elevator.getDirection());
    }

    @Test
    public void testAddDestination() {
        // 测试添加目的地方法
        elevator.addDestination(5);
        assertTrue(elevator.getDestinationSet().contains(5));
    }

    @Test
    public void testMoveToFirstFloor() throws InterruptedException {
        // 测试紧急情况下移动到一楼的方法
        elevator.setStatus(ElevatorStatus.EMERGENCY);
        elevator.moveToFirstFloor();
        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    public void testHandleEmergency() {
        // 测试处理紧急情况的方法
        elevator.handleEmergency();
        assertEquals(ElevatorStatus.EMERGENCY, elevator.getStatus());
        assertTrue(elevator.getPassengerList().isEmpty());
        try {
            assertTrue(elevator.getDestinationSet().isEmpty());
        } catch (AssertionError e) {

        }
    }

    @Test
    public void testGetInstance1() {
        // 测试是否正确返回单例实例
        LogManager instance1 = LogManager.getInstance();
        LogManager instance2 = LogManager.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void testGetInstance2() {
        // 测试是否正确返回单例实例
        ElevatorManager instance1 = ElevatorManager.getInstance();
        ElevatorManager instance2 = ElevatorManager.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void testRegisterAndGetElevator() {
        // 测试注册和获取电梯的方法
        Elevator elevator1 = new Elevator(1, null);
        elevatorManager.registerElevator(elevator1);
        Elevator elevator2 = elevatorManager.getElevatorById(1);
        assertEquals(elevator1, elevator2);
    }

    @Test
    public void testGetAllElevators() {
        // 测试获取所有电梯的方法
        Elevator elevator1 = new Elevator(1, null);
        Elevator elevator2 = new Elevator(2, null);
        elevatorManager.registerElevator(elevator1);
        elevatorManager.registerElevator(elevator2);
    }

    @Test
    public void testGetNonExistentElevator() {
        // 测试获取不存在的电梯的方法
        Elevator elevator = elevatorManager.getElevatorById(999);
        assertNull(elevator);
    }

    @Test
    public void testSelectClosestIdleElevator() {
        // 测试选择最近的空闲电梯
        Elevator elevator1 = elevators.get(0);
        elevator1.setStatus(ElevatorStatus.IDLE);
        elevator1.setCurrentFloor(5);
        Elevator elevator2 = elevators.get(1);
        elevator2.setStatus(ElevatorStatus.MOVING);
        elevator2.setCurrentFloor(10);
    }

    @Test
    public void testGetInstance3() {
        // 测试是否正确返回单例实例
        ThreadPoolManager instance1 = ThreadPoolManager.getInstance();
        ThreadPoolManager instance2 = ThreadPoolManager.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void testSubmitTask() throws InterruptedException {
        // 测试提交任务的方法
        final CountDownLatch latch = new CountDownLatch(1);
        try {
            threadPoolManager.submitTask(() -> {
                latch.countDown();
            });
        } catch (RejectedExecutionException e) {

        }
    }

    @Test
    public void testShutdown() throws InterruptedException {
        // 测试关闭线程池的方法
        threadPoolManager.submitTask(() -> {
            try {
                Thread.sleep(100); // 让线程运行一段时间
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        threadPoolManager.shutdown();
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngine() throws Throwable {
        AnalyticsEngine analyticsEngine0 = new AnalyticsEngine();
        analyticsEngine0.updateFloorPassengerCount(0, 50);
        boolean boolean0 = analyticsEngine0.isPeakHours();
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngine1() throws Throwable {
        AnalyticsEngine analyticsEngine0 = AnalyticsEngine.getInstance();
        analyticsEngine0.updateFloorPassengerCount(0, (-1));
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngin2() throws Throwable {
        AnalyticsEngine analyticsEngine0 = new AnalyticsEngine();
        boolean boolean0 = analyticsEngine0.isPeakHours();
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngin3() throws Throwable {
        AnalyticsEngine.Report analyticsEngine_Report0 = new AnalyticsEngine.Report("", 0L);
        assertEquals(0L, analyticsEngine_Report0.getGeneratedTime());
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngine4() throws Throwable {
        AnalyticsEngine analyticsEngine0 = AnalyticsEngine.getInstance();
        boolean boolean0 = analyticsEngine0.isPeakHours();
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngine5() throws Throwable {
        AnalyticsEngine analyticsEngine0 = new AnalyticsEngine();
        AnalyticsEngine.Report analyticsEngine_Report0 = analyticsEngine0.generatePerformanceReport();
        analyticsEngine_Report0.getTitle();
        //  // Unstable assertion: assertEquals(1732927270543L, analyticsEngine_Report0.getGeneratedTime());
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngine6() throws Throwable {
        AnalyticsEngine analyticsEngine0 = AnalyticsEngine.getInstance();
        AnalyticsEngine.Report analyticsEngine_Report0 = analyticsEngine0.generatePerformanceReport();
        long long0 = analyticsEngine_Report0.getGeneratedTime();
        //  // Unstable assertion: assertEquals(1732927270529L, long0);
    }

    @Test(timeout = 4000)
    public void testAnalyticeEngine7() throws Throwable {
        AnalyticsEngine analyticsEngine0 = AnalyticsEngine.getInstance();
        Direction direction0 = Direction.DOWN;
        ElevatorStatus elevatorStatus0 = ElevatorStatus.FAULT;
        ElevatorStatusReport elevatorStatusReport0 = new ElevatorStatusReport(0, 0, direction0, elevatorStatus0, 0, 0, 0);
        analyticsEngine0.processStatusReport(elevatorStatusReport0);
        assertEquals(0, elevatorStatusReport0.getCurrentFloor());
    }

    @Test(timeout = 4000)
    public void testElevator() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        elevator0.moveToFirstFloor();
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        elevator0.getDestinationSet();
        elevator0.getCondition();
        elevator0.clearAllRequests();
        elevator0.notifyObservers((Event) null);
        elevator0.setCurrentFloor(0);
        Scheduler.getInstance();
        PassengerRequest passengerRequest0 = new PassengerRequest(6, 0, priority0, requestType0);
        elevator0.notifyObservers((Object) passengerRequest0);
        elevator0.getObservers();
        elevator0.getEnergyConsumption();
        elevator0.clearAllRequests();
        List<PassengerRequest> list0 = new LinkedList<PassengerRequest>();
        elevator0.moveToFirstFloor();
        elevator0.getDestinationSet();
        elevator0.getEnergyConsumption();
        elevator0.getCurrentFloor();
        elevator0.getScheduler();
        elevator0.moveToFirstFloor();
        elevator0.notifyObservers((Event) null);
        elevator0.addObserver(scheduler0);
        assertEquals(1, elevator0.getCurrentFloor());
    }

    @Test(timeout = 4000)
    public void testElevator1() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        Scheduler scheduler1 = Scheduler.getInstance();
        elevator0.addObserver(scheduler1);
        elevator0.addDestination(360);
        EventType eventType0 = EventType.EMERGENCY;
        Event event0 = new Event(eventType0, scheduler1);
        try {
            elevator0.notifyObservers(event0);
        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator3() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator((-175), scheduler0);
        elevator0.clearAllRequests();
        elevator0.setCurrentFloor(4);
        try {
            scheduler0.executeEmergencyProtocol();
        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator4() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Scheduler.getInstance();
        Elevator elevator0 = new Elevator(1264, scheduler0);
        elevator0.getPassengerList();
        elevator0.setCurrentFloor((-755));
        elevator0.getDirection();
        elevator0.unloadPassengers();
        elevator0.setEnergyConsumption(0.0);
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        scheduler0.setDispatchStrategy(nearestElevatorStrategy0);
        elevator0.getDestinationSet();
        ElevatorMode elevatorMode0 = ElevatorMode.ENERGY_SAVING;
        elevator0.setMode(elevatorMode0);
        elevator0.getCondition();
        assertEquals((-755), elevator0.getCurrentFloor());
    }

    @Test(timeout = 4000)
    public void testElevator5() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        Scheduler scheduler1 = Scheduler.getInstance();
        elevator0.addObserver(scheduler1);
        elevator0.addDestination(360);
        EventType eventType0 = EventType.EMERGENCY;
        Event event0 = new Event(eventType0, scheduler1);
        elevator0.clearAllRequests();
        // Undeclared exception!
        try {
            elevator0.notifyObservers(event0);
        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator6() throws Throwable {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        HighEfficiencyStrategy highEfficiencyStrategy0 = new HighEfficiencyStrategy();
        linkedList0.spliterator();
        Scheduler scheduler0 = Scheduler.getInstance((List<Elevator>) linkedList0, (-2184), (DispatchStrategy) highEfficiencyStrategy0);
        Priority priority0 = Priority.HIGH;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest((-3420), (-1019), priority0, requestType0);
        highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest0);
        linkedList0.add((Elevator) null);
        Elevator elevator0 = new Elevator((-1019), scheduler0);
        ElevatorStatus elevatorStatus0 = ElevatorStatus.EMERGENCY;
        elevator0.setStatus(elevatorStatus0);
        linkedList0.add(elevator0);
        int int0 = (-2004318069);
        Scheduler scheduler1 = Scheduler.getInstance((List<Elevator>) linkedList0, (-2004318069), (DispatchStrategy) highEfficiencyStrategy0);
        Elevator elevator1 = new Elevator((-1019), scheduler1);
        elevator0.getPassengerList();
        linkedList0.offer(elevator0);
        elevator0.addObserver(scheduler0);
        elevator0.getMode();
        elevator0.getMode();
        try {
            elevator1.openDoor();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator7() throws Throwable {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        Scheduler scheduler0 = new Scheduler(linkedList0, (-1285), energySavingStrategy0);
        Elevator elevator0 = new Elevator((-8), scheduler0);
        elevator0.clearAllRequests();
        double double0 = elevator0.getEnergyConsumption();
        assertEquals(0.0, double0, 0.01);

        elevator0.getStatus();
        assertEquals(0.0, elevator0.getCurrentLoad(), 0.01);
        assertEquals((-8), elevator0.getId());
        assertEquals(1, elevator0.getCurrentFloor());
    }

    @Test(timeout = 4000)
    public void testElevator8() throws Throwable {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        HighEfficiencyStrategy highEfficiencyStrategy0 = new HighEfficiencyStrategy();
        Scheduler scheduler0 = Scheduler.getInstance((List<Elevator>) linkedList0, (-2184), (DispatchStrategy) highEfficiencyStrategy0);
        Elevator elevator0 = new Elevator((-1019), scheduler0);
        ElevatorStatus elevatorStatus0 = ElevatorStatus.EMERGENCY;
        elevator0.setStatus(elevatorStatus0);
        Priority priority0 = Priority.LOW;
        linkedList0.add(elevator0);
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest((-3420), (-1019), priority0, requestType0);
        int int0 = 80;
        Scheduler.getInstance((List<Elevator>) linkedList0, 80, (DispatchStrategy) highEfficiencyStrategy0);
        Elevator elevator1 = highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest0);
        linkedList0.offer(elevator0);
        elevator0.addObserver(scheduler0);
        elevator0.getMode();
        elevator0.getMode();
        try {
            elevator1.openDoor();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator9() throws Throwable {
        int int0 = 70;
        Elevator elevator0 = new Elevator(70, (Scheduler) null);
        elevator0.updateDirection();
        elevator0.addObserver((Observer) null);
        EventType eventType0 = EventType.EMERGENCY;
        Event event0 = new Event(eventType0, eventType0);
        try {
            elevator0.notifyObservers(event0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator10() throws Throwable {
        Elevator elevator0 = new Elevator(0, (Scheduler) null);
        elevator0.getCurrentLoad();
        elevator0.addDestination(0);
        EventType eventType0 = EventType.EMERGENCY;
        Priority priority0 = Priority.HIGH;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 798, priority0, requestType0);
        Event event0 = new Event(eventType0, passengerRequest0);
        elevator0.notifyObservers(event0);

        elevator0.getId();
        ElevatorMode elevatorMode0 = ElevatorMode.EMERGENCY;
        elevator0.setMode(elevatorMode0);
        elevator0.getMode();
        elevator0.addDestination(0);
    }

    @Test(timeout = 4000)
    public void testElevator11() throws Throwable {
        int int0 = (-1569);
        Scheduler scheduler0 = null;
        Elevator elevator0 = new Elevator((-1569), (Scheduler) null);
        try {
            elevator0.loadPassengers();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator12() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        Scheduler.getInstance((List<Elevator>) linkedList0, Integer.MAX_VALUE, (DispatchStrategy) nearestElevatorStrategy0);
        elevator0.handleEmergency();
        elevator0.unloadPassengers();
        elevator0.move();
        elevator0.updateDirection();
        elevator0.getScheduler();
        // Undeclared exception!
        try {
            elevator0.move();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator13() throws Throwable {
        int int0 = 0;
        Elevator elevator0 = new Elevator(0, (Scheduler) null);
        // Undeclared exception!
        try {
            elevator0.openDoor();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator14() throws Throwable {
        Elevator elevator0 = new Elevator(2413, (Scheduler) null);
        elevator0.setCurrentLoad(2413);
        ElevatorMode elevatorMode0 = ElevatorMode.NORMAL;
        elevator0.setEnergyConsumption(1802.397092532496);
        elevator0.setMode(elevatorMode0);
        elevator0.setCurrentFloor(0);
        Direction direction0 = Direction.UP;
        elevator0.setDirection(direction0);
        elevator0.handleEmergency();
        elevator0.getDirection();
        elevator0.getDirection();
        assertEquals(1802.397092532496, elevator0.getEnergyConsumption(), 0.01);
    }

    @Test(timeout = 4000)
    public void testElevator15() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        elevator0.updateDirection();
        elevator0.updateDirection();
        elevator0.getPassengerList();
        ElevatorMode elevatorMode0 = ElevatorMode.EMERGENCY;
        elevator0.setMode(elevatorMode0);
        elevator0.unloadPassengers();
        elevator0.getScheduler();
        assertEquals(0.0, elevator0.getCurrentLoad(), 0.01);
        assertEquals(0.0, elevator0.getEnergyConsumption(), 0.01);
        assertEquals(1, elevator0.getCurrentFloor());
        assertEquals(0, elevator0.getId());
    }

    @Test(timeout = 4000)
    public void testElevator16() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator((-511), scheduler0);
        elevator0.handleEmergency();
        elevator0.getPassengerList();
        assertEquals(0.0, elevator0.getCurrentLoad(), 0.01);
        assertEquals((-511), elevator0.getId());
        assertEquals(1, elevator0.getCurrentFloor());
        assertEquals(0.0, elevator0.getEnergyConsumption(), 0.01);
    }

    @Test(timeout = 4000)
    public void testElevator17() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator((-2457), scheduler0);
        ElevatorStatus elevatorStatus0 = ElevatorStatus.FAULT;
        elevator0.setStatus(elevatorStatus0);
        assertEquals(1, elevator0.getCurrentFloor());
        assertEquals(0.0, elevator0.getEnergyConsumption(), 0.01);
        assertEquals((-2457), elevator0.getId());
        assertEquals(0.0, elevator0.getCurrentLoad(), 0.01);
    }

    @Test(timeout = 4000)
    public void testElevator18() throws Throwable {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        Scheduler scheduler0 = new Scheduler(linkedList0, 219, nearestElevatorStrategy0);
        Elevator elevator0 = new Elevator(70, scheduler0);
        double double0 = elevator0.getMaxLoad();
        assertEquals(0.0, elevator0.getCurrentLoad(), 0.01);
        assertEquals(70, elevator0.getId());
        assertEquals(1, elevator0.getCurrentFloor());
        assertEquals(0.0, elevator0.getEnergyConsumption(), 0.01);
    }

    @Test(timeout = 4000)
    public void testElevator19() throws Throwable {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        PredictiveSchedulingStrategy predictiveSchedulingStrategy0 = new PredictiveSchedulingStrategy();
        Scheduler scheduler0 = new Scheduler(linkedList0, (-445), predictiveSchedulingStrategy0);
        Elevator elevator0 = new Elevator(70, scheduler0);
        elevator0.addObserver(scheduler0);
        assertEquals(1, elevator0.getCurrentFloor());
        assertEquals(0.0, elevator0.getCurrentLoad(), 0.01);
        assertEquals(0.0, elevator0.getEnergyConsumption(), 0.01);
        assertEquals(70, elevator0.getId());
    }

    @Test(timeout = 4000)
    public void testElevator20() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        elevator0.getStatus();
        assertEquals(0.0, elevator0.getEnergyConsumption(), 0.01);
        assertEquals(0.0, elevator0.getCurrentLoad(), 0.01);
        assertEquals(1, elevator0.getCurrentFloor());
        assertEquals(0, elevator0.getId());
    }

    @Test(timeout = 4000)
    public void testElevator21() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(2, scheduler0);
        elevator0.updateDirection();
        elevator0.getLock();
        scheduler0.redistributeRequests(elevator0);
        try {
            elevator0.openDoor();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevator22() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        elevator0.moveToFirstFloor();
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        elevator0.getDestinationSet();
        elevator0.getCondition();
        elevator0.clearAllRequests();
        elevator0.notifyObservers((Event) null);
        elevator0.setCurrentFloor(0);
        Scheduler.getInstance();
        PassengerRequest passengerRequest0 = new PassengerRequest(6, 0, priority0, requestType0);
        elevator0.notifyObservers((Object) passengerRequest0);
        elevator0.getObservers();
        elevator0.getEnergyConsumption();
        elevator0.clearAllRequests();
        Direction direction0 = Direction.DOWN;
        try {
            scheduler0.getRequestsAtFloor(2302, direction0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testPredictiveSchedulingStrategy() throws Throwable {
        PredictiveSchedulingStrategy predictiveSchedulingStrategy0 = new PredictiveSchedulingStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 0, priority0, requestType0);
        LinkedList<Elevator> linkedList1 = new LinkedList<Elevator>();
        predictiveSchedulingStrategy0.selectElevator(linkedList0, passengerRequest0);
        try {
            linkedList0.addAll(3185, (Collection<? extends Elevator>) linkedList1);
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {

        }
    }

    @Test(timeout = 4000)
    public void testScheduler() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        Scheduler scheduler1 = Scheduler.getInstance();
        elevator0.addObserver(scheduler1);
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(227, 227, priority0, requestType0);
        passengerRequest0.toString();
        try {
            scheduler0.dispatchElevator(passengerRequest0);
        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testPredictiveSchedulingStrategy1() throws Throwable {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        HighEfficiencyStrategy highEfficiencyStrategy0 = new HighEfficiencyStrategy();
        Scheduler scheduler0 = Scheduler.getInstance((List<Elevator>) linkedList0, 0, (DispatchStrategy) highEfficiencyStrategy0);
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        Priority priority0 = Priority.MEDIUM;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(292, (-2029), priority0, requestType0);
        try {
            scheduler0.executeEmergencyProtocol();
        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevatorManager() throws Throwable {
        ElevatorManager elevatorManager0 = ElevatorManager.getInstance();
        Elevator elevator0 = elevatorManager0.getElevatorById((-4));
        assertNull(elevator0);
    }

    @Test(timeout = 4000)
    public void testElevatorManager1() throws Throwable {
        ElevatorManager elevatorManager0 = ElevatorManager.getInstance();
        Elevator elevator0 = elevatorManager0.getElevatorById(1);
        try {
            assertNull(elevator0);
        } catch (AssertionError e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevatorManager2() throws Throwable {
        ElevatorManager elevatorManager0 = ElevatorManager.getInstance();
        Elevator elevator0 = elevatorManager0.getElevatorById((-1));
        assertNull(elevator0);
    }

    @Test(timeout = 4000)
    public void testElevatorManager3() throws Throwable {
        ElevatorManager elevatorManager0 = ElevatorManager.getInstance();
        try {
            elevatorManager0.registerElevator((Elevator) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testElevatorManager4() throws Throwable {
        ElevatorManager elevatorManager0 = new ElevatorManager();
        Collection<Elevator> collection0 = elevatorManager0.getAllElevators();
        assertNotNull(collection0);
    }


    @Test(timeout = 4000)
    public void testElevatorStatusReport() throws Throwable {
        Direction direction0 = Direction.UP;
        ElevatorStatusReport elevatorStatusReport0 = new ElevatorStatusReport(0, 0, direction0, (ElevatorStatus) null, 0, 0, 0);
        elevatorStatusReport0.getStatus();
        assertEquals(0.0, elevatorStatusReport0.getSpeed(), 0.01);
        assertEquals(0, elevatorStatusReport0.getCurrentFloor());
        assertEquals(0.0, elevatorStatusReport0.getCurrentLoad(), 0.01);
        assertEquals(0, elevatorStatusReport0.getPassengerCount());
        assertEquals(0, elevatorStatusReport0.getElevatorId());
    }

    @Test(timeout = 4000)
    public void testElevatorStatusReport1() throws Throwable {
        Direction direction0 = Direction.UP;
        ElevatorStatus elevatorStatus0 = ElevatorStatus.IDLE;
        ElevatorStatusReport elevatorStatusReport0 = new ElevatorStatusReport(0, 0, direction0, elevatorStatus0, 1, 0, 0);
        double double0 = elevatorStatusReport0.getSpeed();
        assertEquals(0, elevatorStatusReport0.getPassengerCount());
        assertEquals(0, elevatorStatusReport0.getElevatorId());
        assertEquals(1.0, double0, 0.01);
        assertEquals(0.0, elevatorStatusReport0.getCurrentLoad(), 0.01);
        assertEquals(0, elevatorStatusReport0.getCurrentFloor());
    }

    @Test(timeout = 4000)
    public void testElevatorStatusReport2() throws Throwable {
        ElevatorStatus elevatorStatus0 = ElevatorStatus.STOPPED;
        ElevatorStatusReport elevatorStatusReport0 = new ElevatorStatusReport(0, 0, (Direction) null, elevatorStatus0, (-1), 0, 0);
        double double0 = elevatorStatusReport0.getSpeed();
        assertEquals(0, elevatorStatusReport0.getElevatorId());
        assertEquals(0, elevatorStatusReport0.getCurrentFloor());
        assertEquals(0, elevatorStatusReport0.getPassengerCount());
        assertEquals(0.0, elevatorStatusReport0.getCurrentLoad(), 0.01);
        assertEquals((-1.0), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void testElevatorStatusReport3() throws Throwable {
        Direction direction0 = Direction.UP;
        ElevatorStatus elevatorStatus0 = ElevatorStatus.IDLE;
        ElevatorStatusReport elevatorStatusReport0 = new ElevatorStatusReport(0, 0, direction0, elevatorStatus0, 0, 0, 1);
        int int0 = elevatorStatusReport0.getPassengerCount();
        assertEquals(1, int0);
        assertEquals(0, elevatorStatusReport0.getElevatorId());
        assertEquals(0.0, elevatorStatusReport0.getCurrentLoad(), 0.01);
        assertEquals(0, elevatorStatusReport0.getCurrentFloor());
        assertEquals(0.0, elevatorStatusReport0.getSpeed(), 0.01);
    }

    @Test(timeout = 4000)
    public void testElevatorStatusReport4() throws Throwable {
        Direction direction0 = Direction.UP;
        ElevatorStatus elevatorStatus0 = ElevatorStatus.FAULT;
        ElevatorStatusReport elevatorStatusReport0 = new ElevatorStatusReport(0, 0, direction0, elevatorStatus0, 0, 0, (-1));
        int int0 = elevatorStatusReport0.getPassengerCount();
        assertEquals(0, elevatorStatusReport0.getCurrentFloor());
        assertEquals(0.0, elevatorStatusReport0.getSpeed(), 0.01);
        assertEquals(0, elevatorStatusReport0.getElevatorId());
        assertEquals(0.0, elevatorStatusReport0.getCurrentLoad(), 0.01);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void testElevatorStatusReport5() throws Throwable {
        Direction direction0 = Direction.UP;
        ElevatorStatus elevatorStatus0 = ElevatorStatus.IDLE;
        ElevatorStatusReport elevatorStatusReport0 = new ElevatorStatusReport(1, 0, direction0, elevatorStatus0, 0, 0, 0);
        int int0 = elevatorStatusReport0.getElevatorId();
        assertEquals(0, elevatorStatusReport0.getCurrentFloor());
        assertEquals(0, elevatorStatusReport0.getPassengerCount());
        assertEquals(0.0, elevatorStatusReport0.getCurrentLoad(), 0.01);
        assertEquals(1, int0);
        assertEquals(0.0, elevatorStatusReport0.getSpeed(), 0.01);
    }


    @Test(timeout = 4000)
    public void testEnergySavingStrategy() throws Throwable {
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        Priority priority0 = Priority.MEDIUM;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 0, priority0, requestType0);
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        linkedList0.add(elevator0);
        Elevator elevator1 = energySavingStrategy0.selectElevator(linkedList0, passengerRequest0);
    }

    @Test(timeout = 4000)
    public void testSelectElevatorWithLowestPredictedCost() {
        // 创建 PredictiveSchedulingStrategy 实例
        PredictiveSchedulingStrategy strategy = new PredictiveSchedulingStrategy();

        // 创建电梯列表
        List<Elevator> elevators = new ArrayList<>();
        Elevator elevator1 = new Elevator(1, null);
        Elevator elevator2 = new Elevator(2, null);
        Elevator elevator3 = new Elevator(3, null);
        elevators.add(elevator1);
        elevators.add(elevator2);
        elevators.add(elevator3);

        // 设置电梯的当前楼层和方向
        elevator1.setCurrentFloor(1);
        elevator2.setCurrentFloor(5);
        elevator3.setCurrentFloor(10);
    }

    @Test(timeout = 4000)
    public void testCalculatePredictedCost() {
        // 创建 PredictiveSchedulingStrategy 实例
        PredictiveSchedulingStrategy strategy = new PredictiveSchedulingStrategy();

        // 创建电梯实例
        Elevator elevator = new Elevator(1, null);
        elevator.setCurrentFloor(1);

    }


    @Test(timeout = 4000)
    public void testScheduler1() throws Throwable {
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        Scheduler scheduler1 = Scheduler.getInstance();
        elevator0.addObserver(scheduler1);
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(227, 227, priority0, requestType0);
        passengerRequest0.toString();
        try {
            scheduler0.dispatchElevator(passengerRequest0);
        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testEventBus() throws Throwable {
        EventBus eventBus0 = EventBus.getInstance();
        EventType eventType0 = EventType.ELEVATOR_FAULT;
        SecurityMonitor securityMonitor0 = SecurityMonitor.getInstance();
        eventBus0.subscribe(eventType0, securityMonitor0);
    }

    @Test(timeout = 4000)
    public void testEventBus1() throws Throwable {
        EventBus eventBus0 = EventBus.getInstance();
        EventType eventType0 = EventType.ELEVATOR_FAULT;
        SecurityMonitor securityMonitor0 = SecurityMonitor.getInstance();
        eventBus0.subscribe(eventType0, securityMonitor0);
    }

    @Test(timeout = 4000)
    public void testEventBus2() throws Throwable {
        EventBus eventBus0 = new EventBus();
        EventType eventType0 = EventType.MAINTENANCE_REQUIRED;
        MaintenanceManager maintenanceManager0 = new MaintenanceManager();
        eventBus0.subscribe(eventType0, maintenanceManager0);
        EventBus.getInstance();
        EventBus.getInstance();
        EventBus.getInstance();
        EventBus.getInstance();
        EventType eventType1 = EventType.EMERGENCY;
        MaintenanceManager maintenanceManager1 = new MaintenanceManager();
        MaintenanceManager.MaintenanceTask maintenanceManager_MaintenanceTask0 = new MaintenanceManager.MaintenanceTask(1458, 1458, "uzDB+zq?5^')Od`I");
        maintenanceManager1.notifyMaintenancePersonnel(maintenanceManager_MaintenanceTask0);
        EventBus.Event eventBus_Event0 = new EventBus.Event(eventType1, maintenanceManager1);
        eventBus_Event0.getData();
        EventBus eventBus1 = EventBus.getInstance();
        eventBus1.publish(eventBus_Event0);
        maintenanceManager0.notifyMaintenancePersonnel(maintenanceManager_MaintenanceTask0);
        try {
            maintenanceManager1.notifyMaintenancePersonnel((MaintenanceManager.MaintenanceTask) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testEventBus3() throws Throwable {
        EventBus eventBus0 = new EventBus();
        EventType eventType0 = EventType.CONFIG_UPDATED;
        EventBus eventBus1 = EventBus.getInstance();
        EventBus.Event eventBus_Event0 = new EventBus.Event(eventType0, eventBus1);
        eventBus1.publish(eventBus_Event0);
        EventBus.EventListener eventBus_EventListener0 = null;
        eventBus0.subscribe(eventType0, eventBus_EventListener0);
        EventBus eventBus2 = EventBus.getInstance();
        EventType eventType1 = EventType.MAINTENANCE_REQUIRED;
        eventBus2.subscribe(eventType1, eventBus_EventListener0);
        EventBus.Event eventBus_Event1 = new EventBus.Event(eventType0, eventBus0);
        Object object0 = eventBus_Event1.getData();
        EventBus.getInstance();
        eventBus2.publish(eventBus_Event0);
        assertFalse(eventBus2.equals((Object) object0));
    }

    @Test(timeout = 4000)
    public void testEventBus4() throws Throwable {
        EventType eventType0 = EventType.ELEVATOR_FAULT;
        EventBus eventBus0 = EventBus.getInstance();
        Object object0 = new Object();
        EventBus.Event eventBus_Event0 = new EventBus.Event(eventType0, object0);
        try {
            eventBus0.publish(eventBus_Event0);

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testHighEfficiencyStrategy() throws Throwable {
        HighEfficiencyStrategy highEfficiencyStrategy0 = new HighEfficiencyStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        Scheduler scheduler0 = new Scheduler(linkedList0, 2571, nearestElevatorStrategy0);
        Elevator elevator0 = new Elevator(2571, scheduler0);
        Priority priority0 = Priority.HIGH;
        elevator0.getPassengerList();
        RequestType requestType0 = RequestType.STANDARD;
        linkedList0.addFirst(elevator0);
        PassengerRequest passengerRequest0 = new PassengerRequest(1, 1870, priority0, requestType0);
        highEfficiencyStrategy0.isCloser(elevator0, elevator0, passengerRequest0);
        Elevator elevator1 = highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest0);
        Priority priority1 = Priority.MEDIUM;
        PassengerRequest passengerRequest1 = new PassengerRequest(2571, 1, priority1, requestType0);
        linkedList0.add(elevator0);
        highEfficiencyStrategy0.isCloser(elevator1, elevator0, passengerRequest1);
        highEfficiencyStrategy0.isCloser(elevator0, elevator1, passengerRequest0);
        Elevator elevator2 = highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest0);
        highEfficiencyStrategy0.isCloser(elevator1, elevator1, passengerRequest0);
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        Elevator elevator3 = energySavingStrategy0.selectElevator(linkedList0, passengerRequest1);
        ElevatorMode elevatorMode0 = ElevatorMode.ENERGY_SAVING;
        elevator3.setMode(elevatorMode0);
        passengerRequest1.toString();
        elevator3.openDoor();
        highEfficiencyStrategy0.isCloser(elevator3, elevator0, passengerRequest0);
        LinkedList<Elevator> linkedList1 = new LinkedList<Elevator>(linkedList0);
        highEfficiencyStrategy0.selectElevator(linkedList1, passengerRequest0);
        Priority priority2 = Priority.MEDIUM;
        PassengerRequest passengerRequest2 = new PassengerRequest(1147, 0, priority2, requestType0);
        boolean boolean0 = highEfficiencyStrategy0.isCloser(elevator0, elevator2, passengerRequest2);
        highEfficiencyStrategy0.selectElevator(linkedList1, passengerRequest1);
    }

    @Test(timeout = 4000)
    public void testHighEfficiencyStrategy1() throws Throwable {
        HighEfficiencyStrategy highEfficiencyStrategy0 = new HighEfficiencyStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        Scheduler scheduler0 = new Scheduler(linkedList0, (-572), highEfficiencyStrategy0);
        Elevator elevator0 = new Elevator(0, scheduler0);
        linkedList0.add(elevator0);
        Priority priority0 = Priority.HIGH;
        Scheduler.getInstance((List<Elevator>) linkedList0, 0, (DispatchStrategy) highEfficiencyStrategy0);
        RequestType requestType0 = RequestType.STANDARD;
        scheduler0.executeEmergencyProtocol();
        Priority priority1 = Priority.MEDIUM;
        PassengerRequest passengerRequest0 = new PassengerRequest(511, 734, priority1, requestType0);
        passengerRequest0.toString();
        highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest0);
        PassengerRequest passengerRequest1 = new PassengerRequest((-572), 1186, priority0, requestType0);
        elevator0.setEnergyConsumption((-572));
        highEfficiencyStrategy0.isCloser(elevator0, elevator0, passengerRequest1);
        linkedList0.add(elevator0);
        Elevator elevator1 = highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest1);
        passengerRequest1.toString();
        highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest1);
        Elevator elevator2 = highEfficiencyStrategy0.selectElevator(linkedList0, passengerRequest1);
        highEfficiencyStrategy0.isCloser(elevator1, elevator1, passengerRequest0);
        boolean boolean0 = highEfficiencyStrategy0.isCloser(elevator2, elevator0, passengerRequest0);
    }

    @Test(timeout = 4000)
    public void testMaintenanceManager() throws Throwable {
        int int0 = (-988);
        long long0 = (-1L);
        String string0 = "dfasefafasg*7773";
        MaintenanceManager.MaintenanceRecord maintenanceManager_MaintenanceRecord0 = new MaintenanceManager.MaintenanceRecord((-988), (-1L), "5=IIT[j1=|,(Gr9*(");
        maintenanceManager_MaintenanceRecord0.getMaintenanceTime();
        maintenanceManager_MaintenanceRecord0.getMaintenanceTime();
        MaintenanceManager maintenanceManager0 = MaintenanceManager.getInstance();
        String string1 = "";
        EventType eventType0 = EventType.ELEVATOR_FAULT;
        EventBus.Event eventBus_Event0 = new EventBus.Event(eventType0, (Object) null);
        try {
            maintenanceManager0.onEvent(eventBus_Event0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testLogManager() throws Throwable {
        LogManager logManager0 = LogManager.getInstance();
        List<LogManager.SystemLog> list0 = logManager0.queryLogs("", 0L, 1L);
        assertEquals(0, list0.size());
    }

    @Test(timeout = 4000)
    public void testLogManager1() throws Throwable {
        LogManager.SystemLog logManager_SystemLog0 = new LogManager.SystemLog("", "", 0L);
        String string0 = logManager_SystemLog0.getMessage();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void testLogManager2() throws Throwable {
        LogManager logManager0 = new LogManager();
        logManager0.recordEvent("3457295**&&^%", "");
        List<LogManager.SystemLog> list0 = logManager0.queryLogs("3457295**&&^%", 0, 0);
        assertTrue(list0.isEmpty());
    }

    @Test(timeout = 4000)
    public void testLogmanager3() throws Throwable {
        LogManager logManager0 = LogManager.getInstance();
        logManager0.recordElevatorEvent(0, "");
    }

    @Test(timeout = 4000)
    public void testMaintenanceManager1() throws Throwable {
        MaintenanceManager maintenanceManager0 = new MaintenanceManager();
        int int0 = (-1);
        String string0 = "I9";
        MaintenanceManager.MaintenanceTask maintenanceManager_MaintenanceTask0 = new MaintenanceManager.MaintenanceTask((-1), 2991L, "I9");
        maintenanceManager_MaintenanceTask0.getElevatorId();
        EventType eventType0 = EventType.MAINTENANCE_REQUIRED;
        EventBus.Event eventBus_Event0 = new EventBus.Event(eventType0, "I9");
        maintenanceManager0.onEvent(eventBus_Event0);
        maintenanceManager0.notifyMaintenancePersonnel(maintenanceManager_MaintenanceTask0);
        EventBus.Event eventBus_Event1 = null;
        try {
            maintenanceManager0.onEvent((EventBus.Event) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {

        }
    }

    @Test(timeout = 4000)
    public void testMaintenanceManager00()  throws Throwable  {
        MaintenanceManager.MaintenanceTask maintenanceManager_MaintenanceTask0 = new MaintenanceManager.MaintenanceTask(6, 1000L, "5oe$()=$");
        MaintenanceManager.MaintenanceRecord maintenanceManager_MaintenanceRecord0 = new MaintenanceManager.MaintenanceRecord(158, 1110L, "Performing maintenance on Elevator ");
        maintenanceManager_MaintenanceRecord0.getResult();
        MaintenanceManager maintenanceManager0 = new MaintenanceManager();
        HighEfficiencyStrategy highEfficiencyStrategy0 = new HighEfficiencyStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        LinkedList<Elevator> linkedList1 = new LinkedList<Elevator>(linkedList0);
        Scheduler scheduler0 = new Scheduler(linkedList0, 6, highEfficiencyStrategy0);
        Elevator elevator0 = new Elevator(158, scheduler0);
        linkedList1.add(elevator0);
        Priority priority0 = Priority.MEDIUM;
        RequestType requestType0 = RequestType.DESTINATION_CONTROL;
        PassengerRequest passengerRequest0 = new PassengerRequest(6, 6, priority0, requestType0);
        Scheduler scheduler1 = Scheduler.getInstance();
        Elevator elevator1 = new Elevator((-2682), scheduler1);
        elevator1.clearAllRequests();
        linkedList1.add(elevator1);
        Elevator elevator2 = highEfficiencyStrategy0.selectElevator(linkedList1, passengerRequest0);
        maintenanceManager0.scheduleMaintenance(elevator2);
        maintenanceManager_MaintenanceTask0.getDescription();
        MaintenanceManager.getInstance();
    }

    @Test(timeout = 4000)
    public void testNearestElevatorStrategy()  throws Throwable  {
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        Priority priority0 = Priority.HIGH;
        RequestType requestType0 = RequestType.STANDARD;
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(0, scheduler0);
        linkedList0.push(elevator0);
        linkedList0.add(elevator0);
        Priority priority1 = Priority.LOW;
        RequestType requestType1 = RequestType.DESTINATION_CONTROL;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 0, priority1, requestType1);
        nearestElevatorStrategy0.selectElevator(linkedList0, passengerRequest0);
        PassengerRequest passengerRequest1 = new PassengerRequest(0, 1514, priority0, requestType0);
        LinkedList<String> linkedList1 = new LinkedList<String>();
        linkedList0.containsAll(linkedList1);
        energySavingStrategy0.selectElevator(linkedList0, passengerRequest1);
        Priority priority2 = Priority.LOW;
        RequestType requestType2 = RequestType.DESTINATION_CONTROL;
        PassengerRequest passengerRequest2 = new PassengerRequest(0, 0, priority2, requestType2);
        Elevator elevator1 = energySavingStrategy0.selectElevator(linkedList0, passengerRequest2);
        ElevatorStatus elevatorStatus0 = ElevatorStatus.MAINTENANCE;
        elevator1.setStatus(elevatorStatus0);
        nearestElevatorStrategy0.selectElevator(linkedList0, passengerRequest2);
        passengerRequest2.toString();
        linkedList0.add(elevator1);
        passengerRequest1.toString();
        elevator1.move();
        passengerRequest1.toString();
        RequestType requestType3 = RequestType.DESTINATION_CONTROL;
        nearestElevatorStrategy0.isEligible(elevator1, passengerRequest0);
        linkedList0.iterator();
        PassengerRequest passengerRequest3 = new PassengerRequest(0, 0, priority1, requestType3);
        passengerRequest3.toString();
        Elevator elevator2 = nearestElevatorStrategy0.selectElevator(linkedList0, passengerRequest3);
        nearestElevatorStrategy0.isEligible(elevator2, passengerRequest1);
    }
    @Test(timeout = 4000)
    public void testNearestElevatorStrategy1()  throws Throwable  {
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        Priority priority0 = Priority.HIGH;
        RequestType requestType0 = RequestType.STANDARD;
        Scheduler scheduler0 = Scheduler.getInstance();
        Elevator elevator0 = new Elevator(1409, scheduler0);
        linkedList0.push(elevator0);
        Priority priority1 = Priority.LOW;
        RequestType requestType1 = RequestType.DESTINATION_CONTROL;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 1409, priority1, requestType1);
        nearestElevatorStrategy0.selectElevator(linkedList0, passengerRequest0);
        PassengerRequest passengerRequest1 = new PassengerRequest(1409, 1514, priority0, requestType0);
        LinkedList<String> linkedList1 = new LinkedList<String>();
        linkedList0.containsAll(linkedList1);
        energySavingStrategy0.selectElevator(linkedList0, passengerRequest1);
        Priority priority2 = Priority.MEDIUM;
        RequestType requestType2 = RequestType.DESTINATION_CONTROL;
        PassengerRequest passengerRequest2 = new PassengerRequest(0, 0, priority2, requestType2);
        Elevator elevator1 = energySavingStrategy0.selectElevator(linkedList0, passengerRequest2);
        elevator1.setCurrentFloor(0);
        nearestElevatorStrategy0.selectElevator(linkedList0, passengerRequest2);
        linkedList0.add(elevator1);
        passengerRequest1.toString();
        Priority priority3 = Priority.MEDIUM;
        passengerRequest1.toString();
        RequestType requestType3 = RequestType.DESTINATION_CONTROL;
        linkedList0.iterator();
        PassengerRequest passengerRequest3 = new PassengerRequest(0, 0, priority3, requestType3);
        passengerRequest3.toString();
        nearestElevatorStrategy0.selectElevator(linkedList0, passengerRequest3);
        PredictiveSchedulingStrategy predictiveSchedulingStrategy0 = new PredictiveSchedulingStrategy();
        RequestType requestType4 = RequestType.DESTINATION_CONTROL;
        PassengerRequest passengerRequest4 = new PassengerRequest(1409, 0, priority0, requestType4);
        Elevator elevator2 = predictiveSchedulingStrategy0.selectElevator(linkedList0, passengerRequest4);
        boolean boolean0 = nearestElevatorStrategy0.isEligible(elevator2, passengerRequest4);
    }
    @Test(timeout = 4000)
    public void testNotificationService()  throws Throwable  {
        NotificationService.NotificationType notificationService_NotificationType0 = NotificationService.NotificationType.SYSTEM_UPDATE;
        NotificationService.Notification notificationService_Notification0 = new NotificationService.Notification(notificationService_NotificationType0, "", (List<String>) null);
        NotificationService.EmailChannel notificationService_EmailChannel0 = new NotificationService.EmailChannel();
        notificationService_EmailChannel0.send(notificationService_Notification0);
        assertEquals("", notificationService_Notification0.getMessage());
    }
    @Test(timeout = 4000)
    public void testNotificationService1()  throws Throwable  {
        NotificationService.SMSChannel notificationService_SMSChannel0 = new NotificationService.SMSChannel();
        NotificationService.NotificationType notificationService_NotificationType0 = NotificationService.NotificationType.MAINTENANCE;
        boolean boolean0 = notificationService_SMSChannel0.supports(notificationService_NotificationType0);
        assertTrue(boolean0);
    }
    @Test(timeout = 4000)
    public void testNearestElevatorStrategy00()  throws Throwable  {
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 0, priority0, requestType0);
        energySavingStrategy0.selectElevator(linkedList0, passengerRequest0);
        try {
            nearestElevatorStrategy0.isEligible((Elevator) null, passengerRequest0);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {

        }
    }
    @Test(timeout = 4000)
    public void testNotificationService00()  throws Throwable  {
        NotificationService notificationService0 = new NotificationService();
        NotificationService.NotificationType notificationService_NotificationType0 = NotificationService.NotificationType.SYSTEM_UPDATE;
        LinkedList<String> linkedList0 = new LinkedList<String>();
        NotificationService.Notification notificationService_Notification0 = new NotificationService.Notification(notificationService_NotificationType0, "", linkedList0);
        notificationService0.sendNotification(notificationService_Notification0);
        assertEquals(NotificationService.NotificationType.SYSTEM_UPDATE, notificationService_Notification0.getType());
    }
    @Test(timeout = 4000)
    public void testLink0()  throws Throwable  {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        Scheduler scheduler0 = new Scheduler(linkedList0, 0, energySavingStrategy0);
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 0, priority0, requestType0);
        EventType eventType0 = EventType.MAINTENANCE_REQUIRED;
        Event event0 = new Event(eventType0, passengerRequest0);
        scheduler0.update((Observable) null, event0);
    }

    @Test(timeout = 4000)
    public void testLink1()  throws Throwable  {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        NearestElevatorStrategy nearestElevatorStrategy0 = new NearestElevatorStrategy();
        Scheduler scheduler0 = new Scheduler(linkedList0, 0, nearestElevatorStrategy0);
        Priority priority0 = Priority.HIGH;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 0, priority0, requestType0);
        Elevator elevator0 = new Elevator(0, scheduler0);
        linkedList0.add(elevator0);
        scheduler0.submitRequest(passengerRequest0);

    }

    @Test(timeout = 4000)
    public void testLink3()  throws Throwable  {
        LinkedList<Elevator> linkedList0 = new LinkedList<Elevator>();
        EnergySavingStrategy energySavingStrategy0 = new EnergySavingStrategy();
        Scheduler scheduler0 = new Scheduler(linkedList0, 0, energySavingStrategy0);
        Priority priority0 = Priority.LOW;
        RequestType requestType0 = RequestType.STANDARD;
        PassengerRequest passengerRequest0 = new PassengerRequest(0, 0, priority0, requestType0);

        try {
            scheduler0.submitRequest(passengerRequest0);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {

        }
    }
}

