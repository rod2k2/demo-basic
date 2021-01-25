package chain;

import chain.domain.Student;
import chain.domain.StudentLevel;
import chain.task.TaskCommandBuilder;

import java.util.ArrayList;
import java.util.List;

public class Boost {
    public static void main(String[] args) {

        List<Student> myTaskList = new ArrayList<>();
        myTaskList.add(new Student(100,StudentLevel.A));
        myTaskList.add(new Student(90,StudentLevel.A));
        myTaskList.add(new Student(80,StudentLevel.A));
        myTaskList.forEach( x->{
                  TaskCommandBuilder.build(x).execute();
                }

        );
    }
}
