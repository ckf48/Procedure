package CPU;

public enum CPU {
    INSTANCE;
    private Process executingProcess = null;

    public void setExecutingProcess(Process executingProcess) {
        this.executingProcess = executingProcess;
    }

    public Process getExecutingProcess() {
        return executingProcess;
    }
}
