package CPU;


public class Process {
    private int number;
    private int arriveTime;
    private int burstTime;
    private int priority;
    private int finishTime;
    private int leftExecuteTime;
    private boolean isExecuting;

    public Process(int number, int arriveTime, int burstTime, int priority) {
        this.number = number;
        this.arriveTime = arriveTime;
        this.burstTime = burstTime;
        this.priority = priority;
        leftExecuteTime = burstTime;
        isExecuting = false;
    }

    public int getNumber() {
        return number;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getLeftExecuteTime() {
        return leftExecuteTime;
    }

    public void reduceExecuteTime() {
        leftExecuteTime--;
    }

    public void setExecuting(boolean executing) {
        isExecuting = executing;
    }

    public boolean isExecuting() {
        return isExecuting;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

}
