package structure;

public class Mcq implements McqInterface {
    static int count;
    String question;
    String[] options;
    String answer;
    private String id;

    public Mcq(String[] question) {
        this.setId(question[0]);
        this.setQuestion(question[1]);
        this.setOptions(new String[] {question[2], question[3],question[4],question[5]});
        this.setAnswer(question[6]);
        count++;
    }


    public void setId(String id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }
    @Override
    public String getQuestion() {
        return question;
    }
    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    public String getAnswer() {
        return answer;
    }
    public void setOptions(String[] options) {
        this.options = options;
    }
    public String[] getOptions() {
        return options;
    }



    //--------------------------------
    @Override
    public void displayQuestion() {
        System.out.print(this.getQuestion() + "\n");
    }
    public void displayOptions() {
        System.out.println();
        for (int i = 0; i < this.getOptions().length; i++) {
            if (this.getOptions()[i] != "") {
                System.out.println("\t" + (i+1) + " - " + this.getOptions()[i]);
            }
        }
    }

    public void displayMCQ() {
        this.displayQuestion();
        this.displayOptions();
    }

    //----------------------------------
    static void printLearnerAnswer(int answer) {
        switch (answer) {
            case 1 -> System.out.print("1. ");
            case 2 -> System.out.print("2. ");
            case 3 -> System.out.print("3. ");
            case 4 -> System.out.print("4. ");
        }
    }

    //-----------------------------------------------
    @Override
    public void displayAnswer() {
        printLearnerAnswer(Integer.parseInt(this.answer));
        String answer = this.options[Integer.parseInt(this.answer)-1];
        System.out.print(answer + "\n");
    }

    public boolean evaluate(int answerCode) {
        if (answerCode == Integer.parseInt(this.getAnswer())) {
            System.out.println("Correct");
            System.out.println();
            return true;
        } else {
            System.out.print("Incorrect, the correct answer is : ");
            displayAnswer();
            System.out.println();
            return false;
        }
    }





}
