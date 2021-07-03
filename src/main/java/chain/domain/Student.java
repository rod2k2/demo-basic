package chain.domain;


import lombok.Data;

@Data
public class Student {
    private Integer score;
    private StudentLevel level;

    public Student(int score, StudentLevel level) {
        this.score = score;
        this.level = level;
    }
}
