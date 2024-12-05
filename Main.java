import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int rounds = 0;
        String numberToGuess = createNumberToGuess();
        int[] numberToGuessArray = storeNumberToGuess(numberToGuess);
        List<String> roundHistoryList = new ArrayList<>();

        while (true) {
            String userGuess = getUserGuess(rounds);
            int[] userGuessArray = storeUserGuesses(userGuess);
            int numberOfCorrectPositions = checkCorrectPosition(numberToGuessArray, userGuessArray);
            int numberOfCorrectNumbers = checkCorrectNumbers(numberToGuessArray, userGuessArray);
            rounds++;

            if (numberOfCorrectNumbers == 4 && numberOfCorrectPositions == 4) {
                System.out.println("You win.");
                break;
            }

            if (rounds == 10) {
                showGameHistory(roundHistoryList);
                System.out.println("ROUND "+ rounds + " User Guess: " + userGuess + "\n \t \t Game over. The correct answer was " + numberToGuess + ".");
                break;
            }
            storeGameHistory(rounds, userGuess, numberOfCorrectPositions, numberOfCorrectNumbers, roundHistoryList);
            showGameHistory(roundHistoryList);
        }
    }

    //METHOD TO FETCH NUMBER TO GUESS
    public static String createNumberToGuess() {
        HttpClient client = HttpClient.newHttpClient();
        String apiUrl = "https://www.random.org/integers/?num=4&min=0&max=7&col=4&base=10&format=plain&rnd=new";
        try {
            //Create a get request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();
            //Store the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Create a String to manipulate the response (removing spaces)
            String numberToGuess = response.body().trim().replaceAll("\\s+", "");
            //Return the manipulated String
            return numberToGuess;
        }
        catch (Exception e) {
            System.out.println("Error failed to fetch from API. Exception message: " + e + "\nUsing default Number to Guess.");
        }
        return "0000";
    }

    //METHOD TO STORE NUMBER TO GUESS
    public static int[] storeNumberToGuess(String numberToGuess) {
        int[] numberToGuessArray = new int[4];

        for (int i = 0; i < numberToGuess.length(); i++) {
            numberToGuessArray[i] = Character.getNumericValue(numberToGuess.charAt(i));
        }
        return numberToGuessArray;
    }

    // METHOD TO CAPTURE USER GUESS AND VALIDATES THAT THE GUESS IS A VALID INPUT
    public static String getUserGuess(int rounds) {
        int remainingRounds = 10 - rounds;
        System.out.println("Guess the 4 digit code. Remaining rounds left:" + remainingRounds);

        Scanner keyboard = new Scanner(System.in);
        String userGuess = keyboard.nextLine();

        while (!userGuess.matches("[0-7]{4}")) {
            System.out.println("Invalid guess. Try again.");
            userGuess = keyboard.nextLine();
        }
        return userGuess;
    }

    //METHOD TO STORE USER GUESS
    public static int[] storeUserGuesses(String userGuess) {
        int[] userGuessArray = new int[4];

        for (int i = 0; i < 4; i++) {
            userGuessArray[i] = Character.getNumericValue(userGuess.charAt(i));
        }
        return userGuessArray;
    }

    //METHOD TO CHECK CORRECT POSITION
    public static int checkCorrectPosition(int[] numberToGuessArray, int[] userGuessArray) {
        int correctPosition = 0;

        for (int i = 0; i < 4; i++) {
            if (numberToGuessArray[i] == userGuessArray[i]) {
                correctPosition++;
            }
        }
        return correctPosition;
    }

    //METHOD TO CHECK FOR CORRECT NUMBERS
    public static int checkCorrectNumbers(int[] numberToGuessArray, int[] userGuessArray) {
        int correctNumbers = 0;
        boolean[] usedNumberToGuess = new boolean[numberToGuessArray.length];

        for (int i = 0; i < 4; i++) { //compares userGuessArray with every number in numberToGuessArray
            for (int j = 0; j < 4; j++) { //numberToGuess
                if (!usedNumberToGuess[j] && (userGuessArray[i] == numberToGuessArray[j])) {
                    correctNumbers++;
                    usedNumberToGuess[j] = true;
                    break;
                }
            }
        }
        return correctNumbers;
    }

    //METHOD TO CREATE AND STORE GAME HISTORY
    public static void storeGameHistory(int rounds, String userGuess, int numberOfCorrectPositions, int numberOfCorrectNumbers, List<String> roundHistoryList) {
        String roundHistory;

        if (numberOfCorrectNumbers == 0) {
            roundHistory = "ROUND " + rounds + " User guess: " + userGuess + " All numbers are incorrect.";
        } else {
            roundHistory = "ROUND " + rounds + " User guess: " + userGuess + " Correct position: " + numberOfCorrectPositions + " Correct Number: " + numberOfCorrectNumbers;
        }
        roundHistoryList.add(roundHistory);
    }

    //METHOD TO SHOW GAME HISTORY
    public static void showGameHistory(List<String> roundHistoryList) {
        for (int i = 0; i < roundHistoryList.size(); i++) {
            System.out.println(roundHistoryList.get(i));
        }
    }
}


