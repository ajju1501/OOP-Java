import java.util.*;

public class QuizTest {
    public static void main(String[] args) {
        // Create a Quiz object.
        Quiz quiz = new Quiz();
        
        // 1. Manually load quiz questions in main.
        String data = 
            "Who is the current Chief Minister of Telangana?:KCR,Chandra Babu Naidu,President’s Rule,Jagan:1:3:-1\n" +
            "What is the capital of France?:Paris,London,Rome,Berlin:1:2:0\n" +
            "Which planet is known as the Red Planet?:Earth,Mars,Jupiter,Venus:2:4:-2";
        
        // 2. Test parseQuestions method.
        quiz.parseQuestions(data);
        if (quiz.questions.size() == 3) {
            System.out.println("parseQuestions Test: PASS");
        } else {
            System.out.println("parseQuestions Test: FAIL - Expected 3 questions, got " + quiz.questions.size());
        }
        
        // Additional tests for individual question parsing.
        boolean individualTestPassed = true;
        if (!quiz.questions.get(0).getQuestionText().equals("Who is the current Chief Minister of Telangana?")) {
            individualTestPassed = false;
            System.out.println("Test Failed: Incorrect question text for question 1.");
        }
        if (quiz.questions.get(1).getMaxMarks() != 2) {
            individualTestPassed = false;
            System.out.println("Test Failed: Incorrect max marks for question 2.");
        }
        if (quiz.questions.get(2).getPenalty() != -2) {
            individualTestPassed = false;
            System.out.println("Test Failed: Incorrect penalty for question 3.");
        }
        if (individualTestPassed) {
            System.out.println("Individual Question Parsing Tests: PASS");
        }
        
        // 3. Test startQuiz method.
        // Simulate answers: first question correct (1), second wrong (2), third correct (2).
        int[] testAnswers = {1, 2, 2};
        quiz.startQuiz(testAnswers);
        
        boolean quizTestPassed = true;
        // For question 1, expected score = 3 (max marks).
        if (quiz.questions.get(0).getScore() != quiz.questions.get(0).getMaxMarks()) {
            quizTestPassed = false;
            System.out.println("startQuiz Test Failed: Question 1 score incorrect.");
        }
        // For question 2, expected score = 0 (penalty 0 for wrong answer).
        if (quiz.questions.get(1).getScore() != quiz.questions.get(1).getPenalty()) {
            quizTestPassed = false;
            System.out.println("startQuiz Test Failed: Question 2 score incorrect.");
        }
        // For question 3, expected score = 4 (max marks) since answer matches correct.
        if (quiz.questions.get(2).getScore() != quiz.questions.get(2).getMaxMarks()) {
            quizTestPassed = false;
            System.out.println("startQuiz Test Failed: Question 3 score incorrect.");
        }
        if (quizTestPassed) {
            System.out.println("startQuiz Test: PASS");
        }
        
        // 4. Test total score calculation.
        int expectedTotal = quiz.questions.get(0).getMaxMarks() +
                            quiz.questions.get(1).getPenalty() +
                            quiz.questions.get(2).getMaxMarks();
        if (quiz.totalScore == expectedTotal) {
            System.out.println("Total Score Calculation Test: PASS");
        } else {
            System.out.println("Total Score Calculation Test: FAIL - Expected " + expectedTotal + ", got " + quiz.totalScore);
        }
        
        // 5. Finally, test and display the score report.
        System.out.println("\n--- Score Report ---");
        quiz.scoreReport();
    }
}
