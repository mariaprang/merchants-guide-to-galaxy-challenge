package main;

import main.workflow.WorkflowManager;

public class Main {

    public static void main(String[] args) {
        WorkflowManager controller = new WorkflowManager("input.txt");
        controller.run();
    }
}
