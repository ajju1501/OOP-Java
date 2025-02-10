import java.util.ArrayList;

public class Solution {
    
}
class Question{
    String questionText;
    String[] choices;
    int correctOption;
    int maxMarks;
    int penalty;
    int userChoice;
    int score;

    public Question(String questionText,String[] choices,int correctOption,int maxMarks,int penalty){
        this.questionText = questionText;
        this.choices = choices;
        this.correctOption = correctOption;
        this.maxMarks = maxMarks;
        this.penalty = penalty;
        this.userChoice = -1;
        this.score = -1;
    }

    public int evaluateAnswer(){
        if (this.userChoice == this.correctOption) {
            this.score = maxMarks;
        }
        else{
            this.score = penalty;
        }
        return this.score;
    }
    public String getQuestionText(){
        return this.questionText;
    }
    public int getMaxMarks(){
        return this.maxMarks;
    }
    public int getPenalty(){
        return this.penalty;
    }
    public int getScore(){
        return this.score;
    }
}
class Quiz{
    ArrayList<Question> questions;
    int totalScore;

    public Quiz(){
        this.questions = new ArrayList<>();
        this.totalScore =0;
    }

    public void parseQuestions(String s){
        String[] l = s.split("\n");
        for(String q:l){
            String[] ques = q.split(":");
            String question = ques[0];
            String[] choices = ques[1].split(",");
            int correctOption = Integer.parseInt(ques[2]);
            int maxMarks = Integer.parseInt(ques[3]);
            int penalty = Integer.parseInt(ques[4]);
            Question que = new Question(question,choices, correctOption, maxMarks, penalty);
            questions.add(que);
        }
    }

    public void startQuiz(int[] ans){
        int i=0;
        for(Question q:questions){
            q.userChoice = ans[i++];
            q.score = q.evaluateAnswer();
            totalScore +=q.score;
        }
    }
    public void scoreReport(){
        int i=0;
        String s="Choices: ";
        for(Question q:questions){
            System.out.println("Question: "+q.questionText);
            for(String c:q.choices){
                s+=c+", ";
            }
            s=s.substring(0,s.length()-2);
            System.out.println(s);
            s="Choices: ";
            System.out.println("Your Answer: "+q.userChoice+" | "+"Correct Answer: "+q.correctOption);
            if (q.userChoice==q.correctOption) {
                System.out.println("Correct Answer! Marks Awarded: "+q.maxMarks);
            }
            else{
                System.out.println("Wrong Answer! Penalty Applied: "+q.penalty);
            }
            System.out.println("");
        }
        System.out.println("Total Score: "+this.totalScore);
    }
}
