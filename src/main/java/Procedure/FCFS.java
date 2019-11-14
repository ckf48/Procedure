package Procedure;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

import CPU.Process;

public class FCFS extends ProcedureMethod {
    public FCFS() throws IOException {
        super();
    }


    @Override
    public String getOrder() {
        PriorityQueue<Process> processPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getArriveTime));
        processPriorityQueue.addAll(processes);

        int time = totalExecutedTime;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= time; i++) {
            if (cpu.getExecutingProcess() != null) {
                cpu.getExecutingProcess().reduceExecuteTime();
                if (cpu.getExecutingProcess().getLeftExecuteTime() == 0) {
                    cpu.getExecutingProcess().setFinishTime(i);
                    processPriorityQueue.remove(cpu.getExecutingProcess());
                    cpu.getExecutingProcess().setExecuting(false);
                    cpu.setExecutingProcess(null);
                }
            }

            for (Process process : processPriorityQueue) {
                if (process.getArriveTime() <= i && cpu.getExecutingProcess() == null && process.getLeftExecuteTime() > 0) {
                    cpu.setExecutingProcess(process);
                    process.setExecuting(true);
                    result.append(i).append("s : ").append(process.getNumber()).append("; ");
                }

            }
        }
        return result.toString();
    }
}
