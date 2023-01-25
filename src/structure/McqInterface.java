package structure;

public interface McqInterface {

    //----------------
    void setQuestion(String question);
    String getQuestion();

    //----------------
    void setAnswer(String answer);
    String getAnswer();

    //-----------------
    void displayQuestion();
    void displayAnswer();

}
