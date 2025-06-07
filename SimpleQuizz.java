import java.util.Scanner;



class Quizzcode {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String BLUE = "\u001B[34m";
    public static final String MEGENTA = "\u001B[35m";
    
    Scanner sc = new Scanner(System.in);
    String Use_Name;
    String User_city;
    int Total_Amount = 0;

  
    boolean audiencePollUsed = false;
    boolean fiftyFiftyUsed = false;

    void User_data() {
        System.out.println("Enter Your Name: ");
        Use_Name = sc.nextLine();
        System.out.println("Enter your city: ");
        User_city = sc.nextLine();
    }

    void displayLifelineTree() {
        System.out.println(YELLOW + "Available Lifelines:");
        System.out.println(" ├── Audience poll [" + (audiencePollUsed ? "Used" : "Available") + "]");
        System.out.println(" └── 50-50 [" + (fiftyFiftyUsed ? "Used" : "Available") + "]" + RESET);
    }

    void Quizz_Questions() {
        System.out.println(CYAN + "WELCOME TO THE JAVA QUIZZ!!" + RESET);
        System.out.println("__________________________________________");

        // Questions and correct answers
        String[] questions = {
                "Where is memory allocated when an object is created in Java?",
                "What is the default value of an uninitialized int variable in Java?",
                "Which of these is a method of the String class?",
                "Which data type is used to create a variable that can store text?",
                "Java uses which symbol for single-line comments?",
                "Which keyword is used to create a subclass in Java?",
                "Which keyword is used to prevent a class from being subclassed?",
                "Which keyword is used for inheritance in Java?",
                "Which loop executes at least once even if the condition is false?",
                "Which keyword is used to create a new object in Java?"
        };

        String[][] options = {
                {"1.Stack", "2.Heap", "3.Static", "4.Cache"},
                {"1.0", "2.null", "3.1", "4.garbage value"},
                {"1.length()", "2.size()", "3.capacity()", "4.compare()"},
                {"1.int", "2.char", "3.String", "4.double"},
                {"1.#", "2.//", "3./* */", "4.<!-- -->"},
                {"1.implements", "2.super", "3.inherits", "4.extends"},
                {"1.final", "2.static", "3.abstract", "4.private"},
                {"1.implements", "2.extends", "3.inherits", "4.super"},
                {"1.for", "2.while", "3.do-while", "4.foreach"},
                {"1.construct", "2.create", "3.make", "4.new"}
        };

        int[] correctAnswers = {2, 1, 1, 3, 2, 4, 1, 2, 3, 4};

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + BRIGHT_PURPLE+ questions[i] + RESET);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Display available lifelines 
            displayLifelineTree();
            System.out.println(MEGENTA + "Enter your answer number or enter 5 to use a lifeline:" + RESET);

            int answer = sc.nextInt();
            sc.nextLine(); 

            // If lifeline  chosen
            
            if (answer == 5) {
                if (!audiencePollUsed || !fiftyFiftyUsed) {
                    System.out.println("Choose lifeline:");
                    if (!audiencePollUsed) System.out.println(" a. Audience poll");
                    if (!fiftyFiftyUsed) System.out.println(" b. 50-50");
                    String lifeline = sc.nextLine();

                    if (lifeline.equalsIgnoreCase("a") && !audiencePollUsed) {
                        System.out.println(BLUE +"Most audience choose option "+RESET
                        		+ GREEN +correctAnswers[i] +RESET);
                        audiencePollUsed = true;
                    } else if (lifeline.equalsIgnoreCase("b") && !fiftyFiftyUsed) {
                        System.out.println("Here are two options:");
                        System.out.println("option "+correctAnswers[i] );
                        int incorrectOption = -1;
                        for (int j = 1; j <= 4; j++) {
                            if (j != correctAnswers[i]) {
                                incorrectOption = j;
                                break; 
                            }
                        }
                        System.out.println("option "+incorrectOption );

                        fiftyFiftyUsed = true;
                    } else {
                        System.out.println(RED + "Invalid lifeline choice or already used!" + RESET);
                        System.out.println("Please enter your answer directly:");
                    }

                    answer = sc.nextInt();
                    sc.nextLine(); 
                } else {
                    System.out.println(RED + "No lifelines left! Choose your answer directly:" + RESET);
                    answer = sc.nextInt();
                    sc.nextLine(); 
                }
            }

            if (answer == correctAnswers[i]) {
                System.out.println(GREEN + "CORRECT ANSWER!!" + RESET);
                Total_Amount += 1000;
            } else {
                System.out.println(RED + "WRONG ANSWER. YOU WON: Rs. " + RESET+ GREEN +Total_Amount + RESET);
                System.out.println("Thank you for playing, " + Use_Name + " from " + User_city + "!");
                return;
            }
        }

        System.out.println(GREEN + "\nCONGRATULATIONS!! YOU COMPLETED THE QUIZ."+RESET);
        System.out.println(BLUE + "\n  TOTAL AMOUNT WON: Rs." + Total_Amount + RESET);

   }
}

public class SimpleQuizz {
    public static void main(String[] args) {
        Quizzcode q = new Quizzcode();
        q.User_data();
        q.Quizz_Questions();
    }
}
