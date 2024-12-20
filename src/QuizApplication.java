import java.util.*;
import java.util.concurrent.*;

public class QuizApplication {

    static Scanner scanner = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Application!\n");

        List<Question> questions = Arrays.asList(
                new Question("What is the capital of France?", "A. Paris", "B. London", "C. Berlin", "D. Rome", 'A'),
                new Question("What is 2 + 2?", "A. 3", "B. 4", "C. 5", "D. 6", 'B'),
                new Question("Which language runs on JVM?", "A. C++", "B. Python", "C. Java", "D. JavaScript", 'C'),
                new Question("What is the largest planet in our solar system?", "A. Earth", "B. Mars", "C. Jupiter", "D. Saturn", 'C'),
                new Question("Who developed the theory of relativity?", "A. Isaac Newton", "B. Galileo Galilei", "C. Marie Curie", "D. Albert Einstein", 'D')
        );

        for (Question q : questions) {
            askQuestion(q);
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Final Score: " + score + " / " + questions.size());
    }

    static void askQuestion(Question q) {
        System.out.println("\n" + q.question);
        System.out.println(q.optionA);
        System.out.println(q.optionB);
        System.out.println(q.optionC);
        System.out.println(q.optionD);

        System.out.println("You have 10 seconds to answer.");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Character> future = executor.submit(() -> scanner.next().toUpperCase().charAt(0));

        try {
            char answer = future.get(10, TimeUnit.SECONDS);
            if (answer == q.correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.correctAnswer);
            }
        } catch (TimeoutException e) {
            System.out.println("Time's up! The correct answer was: " + q.correctAnswer);
        } catch (Exception e) {
            System.out.println("An error occurred.");
        } finally {
            executor.shutdownNow();
        }
    }
}

class Question {
    String question, optionA, optionB, optionC, optionD;
    char correctAnswer;

    public Question(String question, String optionA, String optionB, String optionC, String optionD, char correctAnswer) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }
}
