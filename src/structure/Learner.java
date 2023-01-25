package structure;

public class Learner {
    private String name;
    private double grade = 0;
    private int score = 0;

    public Learner(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public Learner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    public void addLearnerScore() {
        score++;
    }

    public void gradingPhase(int questions) {
        this.grade = Math.round((double) score/questions * 100);
    }


}
