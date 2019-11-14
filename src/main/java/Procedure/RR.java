package Procedure;

import CPU.Process;

import java.io.IOException;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class RR extends ProcedureMethod {
    public RR() throws IOException {
        super();
    }

    @Override
    public String getOrder() {
        Deque<Process> processDeque = new LinkedList<>(processes);

        int time = totalExecutedTime;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= time; i++) {
            if (cpu.getExecutingProcess() != null) {
                cpu.getExecutingProcess().reduceExecuteTime();
                if (cpu.getExecutingProcess().getLeftExecuteTime() == 0) {
                    cpu.getExecutingProcess().setFinishTime(i);
                    processDeque.remove(cpu.getExecutingProcess());
                    cpu.getExecutingProcess().setExecuting(false);
                    cpu.setExecutingProcess(null);
                }
            }

            if (!processDeque.isEmpty() && i % 5 == 0) {
                Process executingProcess = processDeque.removeFirst();
                processDeque.addLast(executingProcess);
                if (i >= executingProcess.getArriveTime()) {
                    cpu.setExecutingProcess(executingProcess);
                    executingProcess.setExecuting(true);
                    result.append(i).append("s : ").append(executingProcess.getNumber()).append("; ");
                }
            }


        }
        return result.toString();
    }
}
