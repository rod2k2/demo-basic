package chain.task;

import chain.domain.Student;

public class BasicTaskCommand implements TaskCommand {

    private Student task;

    BasicTaskCommand(Student task){
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Executing task for "+ task.toString());
    }
}
