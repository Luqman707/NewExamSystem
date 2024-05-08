import org.example.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      do{
        User user = new User();
        user.selectOption();
        System.out.println("*******************************************************************************");

        Main main = new Main();
        Quiz quiz = main.new Quiz();
        quiz.startQuiz();

        user.logout();

      } while (1 != 0);
    }

        class Quiz {
            void startQuiz() {

        System.out.println("Enter 'S' to start your exam + (Enter 'Q' to quit exam)");
        Scanner in = new Scanner(System.in);
        String enter = in.nextLine();
        System.out.println("******************************************************************************");
                    System.out.println("----------------------Your exam starts now--------------------");

                    Question[] questions = {
                    new Question(
                            "What is the capital of Nigeria?",  "Lagos","London", "Lagos", "Madrid", "Paris"),
                    new Question(
                            "What is the capital of Kwara?",  "Ilorin","London", "Ilorin", "Madrid", "Berlin"),
                    new Question(
                            "What is the capital of Spain?", "Madrid","London", "Paris", "Madrid", "Berlin"),
                    new Question(
                            "What is the capital of England?", "London","London", "Madrid", "Paris", "Berlin"),
                    new Question(
                            "When is democracy day celebrated in Nigeria", "June 12", "May 1", " May 5", "June 12", "October 1"),
                    new Question(
                            "Which is the most populated country in the world?", "China", "China", "India","USA","Nigeria"),
                    new Question(
                            "Which is the second largest continent in the world ", "Africa","Africa","America","Asia","Europe"),
                    new Question(
                            "Which African country first gained independence", "Liberia","Ghana","South Africa","Liberia","Nigeria"),
                    new Question(
                            "Who was he first president of Nigeria", "Dr. Nnamdi Azikwe", "Prof. Wole shoyinka","Dr. Nnamdi Azikwe","Tafawa Balewa","Babangida"),
                    new Question(
                            "Who is the current Governor of Central Bank","Mr. Olayemi Cardoso","Mr Charles Soludo","Lamido Sanusi","Godwin Emiefele","Mr. Olayemi Cardoso"),
                    new Question(
                            "Which continent is the smallest in the world?", "Australia","Australia","Asia","Africa","Europe"),
                    new Question(
                            "Who formed the first political party in Nigeria?","Herbert Macaulay","Mungo park","Herbert Macaulay","Obafemi Awolowo","Cristiano Ronaldo"),
                    new Question(
                            "What was the first political party in Nigeria?", "NNDP","ACN","NNDP","ANPP","SDP"),
                    new Question(
                            "When was paper currency introduced in Nigeria","1918","1914","1966","1980","1918"),
                    new Question(
                            "How many local government area are in Nigeria?","774","700","615","774","801"),
                    new Question(
                            "Which state in nigeria has the largest local government areas?","Kano","Kaduna","Kano","Niger","Imo"),
                    new Question(
                            "When did the federal military abolish the four regions?","1966","1914","1980","1918","1966"),
                    new Question(
                            "Which is the largest city in Africa?","Lagos","Nairobi","Cape Town","Lagos","Johannesburg"),
                    new Question(
                            "How many regional divisions does Africa have?", "6","4","8","5","6"),
                    new Question(
                            "Who was the longest serving senate president of Nigeria","David mark","Ayim Pius Ayim","David mark","Bukola Saraki","Godswill Akpabio")
            };

            int correctAnswers = 0;
//            Character.toLowerCase(correctAnswers);
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i].question);
                System.out.println("A. " + questions[i].option1);
                System.out.println("B. " + questions[i].option2);
                System.out.println("C. " + questions[i].option3);
                System.out.println("D. " + questions[i].option4);

                System.out.println("Enter your answer:");
                String answer = "";
                char userAnswer;
                Scanner scanner = new Scanner(System.in);
                userAnswer = scanner.next().charAt(0);
                if (userAnswer > 5) {
                    System.out.println("Enter 'C' to continue exam + ('L' to logout)");
                    userAnswer = scanner.next().charAt(0);
                }

//                Character.toLowerCase(userAnswer);
//                if (Character.isUpperCase(userAnswer)) {
//                    char toLowerCase = (char) (userAnswer + 32);
//                }

                answer = userAnswer == 'A'? questions[i].option1:
                        userAnswer == 'B'? questions[i].option2: userAnswer == 'C'? questions[i].option3 : questions[i].option4;

                if(answer.equals(questions[i].answer)) {
//                    equalsIgnoreCase
                    correctAnswers++;

                }
            }

            ResultService resultService = new ResultServiceImpl();
            resultService.showResult(correctAnswers, questions.length);
        }


        class Question {
            private String question;
            private String answer;
            private String option1;
            private String option2;
            private String option3;
            private String option4;

            public Question(
                    String question,
                    String answer,
                    String option1,
                    String option2,
                    String option3,
                    String option4) {
                this.question = question;
                this.answer = answer;
                this.option1 = option1;
                this.option2 = option2;
                this.option3 = option3;
                this.option4 = option4;
            }
        }
    }

    interface ResultService {
        void showResult(int correctAnswers, int totalQuestions);
    }

    class ResultServiceImpl implements ResultService {
        @Override
        public void showResult(int correctAnswers, int totalQuestions) {
            System.out.println("You got " + correctAnswers + " out of " + totalQuestions + " correct!");
        }
    }
}
