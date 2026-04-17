import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Predefined list of words
        String[] wordList = {"pastel", "rodillo", "futbol", "barcelona", "calabaza", "telefono", "mariguana" };

        int playerScore = 0;
        boolean keepPlaying = true;

        System.out.println("Welcome to Word Scramble");
        System.out.println("Unscramble the words to score points!");

        //game lopp
        while(keepPlaying){
            String word = wordList[random.nextInt(wordList.length)];
            String scrambleWord = scrambleWord(word, random);
            System.out.println("Scrambled word: " + scrambleWord);

            boolean wordGuessed = false;
            int attempts = 3;

            while(attempts > 0 && !wordGuessed){
                System.out.println("Your guess: ");
                String playerGuess = scanner.nextLine();

                if (playerGuess.equalsIgnoreCase(word)){
                    System.out.println("Correct! YOu've unscrambled the word");
                    playerScore++;
                    wordGuessed = true;
                }else {
                    attempts--;
                    System.out.println("Wrong! Attempts reamining: " + attempts);
                }

            }if (!wordGuessed){
                System.out.println("The correct word was " + word);
            }
            System.out.println("Your current score: " + playerScore);

            System.out.println("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine();
            keepPlaying =  response.equalsIgnoreCase("yes");

            System.out.println("Thank you for playing! Your final Score is: " + playerScore);
        }
    }


    public static String scrambleWord(String word, Random random){
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt();
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = letters[i];

        }
        return new String(letters);
    }
}