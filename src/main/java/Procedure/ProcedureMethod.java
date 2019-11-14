package Procedure;

import CPU.CPU;

import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import CPU.Process;

/**
 * This class is the super class of all algorithm classes
 */
public abstract class ProcedureMethod {
    protected static final File file = new File("input.txt");
    protected List<Process> processes;
    protected int totalExecutedTime;
    protected CPU cpu = CPU.INSTANCE;

    /**
     * constructor to initial all kinds of data
     * @throws IOException
     */
    public ProcedureMethod() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        processes = new ArrayList<Process>();
        totalExecutedTime = 0;
        String line;
        while ((line = raf.readLine()) != null) {
            String[] lines = line.split(" ");
            int[] data = new int[4];
            for (int i = 0; i < 4; i++) {
                data[i] = Integer.parseInt(lines[i]);
            }
            processes.add(new Process(data[0], data[1], data[2], data[3]));
            totalExecutedTime += data[2];
        }
        processes.sort(Comparator.comparingInt(o -> o.getArriveTime()));
    }

    /**
     * Calculate average waiting time
     * @return average waiting time
     */
    public  double getAvgWaitTime(){
        int totalWaitTime = 0;
        for (Process process : processes) {
            totalWaitTime += process.getFinishTime() - process.getArriveTime() - process.getBurstTime();
        }
        return totalWaitTime / processes.size();
    }

    /**
     * Calculate average response time
     * @return average response time
     */

    public  double getAvgResponseTime(){
        int totalResponseTime = 0;
        for (Process process : processes) {
            totalResponseTime += process.getFinishTime() - process.getArriveTime();
        }
        return totalResponseTime / processes.size();
    }

    /**
     * Simulate the CPU procedure process.
     * In this method, every process's finish time should be initialed.
     * @return the result of executing order
     */
    public abstract String getOrder();

    /**
     * to print the result.
     */
    public void getResult() {
        System.out.println("Order : " + getOrder());
        System.out.println("Average waiting time : " + getAvgWaitTime());
        System.out.println("Average response time : " + getAvgResponseTime());
    }


}
