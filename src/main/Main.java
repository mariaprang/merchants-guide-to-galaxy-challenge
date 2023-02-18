package main;

import main.workflow.WorkflowManager;

public class Main {

    public static void main(String[] args) {
        WorkflowManager controller = new WorkflowManager("input.txt");
        controller.run();
    }

}

/*
> pish tegj glob glob is 42
> glob prok Silver is 68 Credits
> glob prok Gold is 57800 Credits
> glob prok Iron is 782 Credits
 */