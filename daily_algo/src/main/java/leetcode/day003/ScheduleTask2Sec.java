package leetcode.day003;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTask2Sec {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    public static void main(String[] args) throws InterruptedException {
        var ScheduleTask2Sec = new ScheduleTask2Sec();
        ScheduleTask2Sec.printCurrentTimeEvery2Second();
        Thread.sleep(15_000);
        ScheduleTask2Sec.stopPrinting();
    }

    private void printCurrentTimeEvery2Second() {
        Runnable task = () -> System.out.println(LocalTime.now());
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }
    private void stopPrinting() {
        scheduledExecutorService.shutdown();
    }


}
