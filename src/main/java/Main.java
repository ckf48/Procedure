import Procedure.*;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FCFS = "fcfs";
    private static final String RR = "rr";
    private static final String SJF = "sjf";
    private static final String STRF = "strf";
    private static final String PRIORITY = "priority";
    private static final String EXIT = "exit";

    public static void main(String[] args) throws IOException {
        ProcedureMethod method;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String data = scanner.nextLine().replace("\n", "");
            if (data.equals(EXIT)) {
                break;
            }
            if (data.equals(FCFS)) {
                method = new FCFS();
                method.getResult();
            }
            if (data.equals(RR)) {
                method = new RR();
                method.getResult();
            }
            if (data.equals(SJF)) {
                method = new SJF();
                method.getResult();
            }
            if (data.equals(STRF)) {
                method = new STRF();
                method.getResult();
            }
            if (data.equals(PRIORITY)) {
                method = new PRIORITY();
                method.getResult();
            }


        }

    }
}
