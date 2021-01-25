package chain.task;

import chain.domain.Student;

public class TaskCommandBuilder {


     public static TaskCommand  build(Student x) {
         return new BasicTaskCommand(x);
    }
}
