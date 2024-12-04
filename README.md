<h1> Mastermind Game</h1>

<h2>Quest Begins</h2>
Hello, adventurer please put on your thinking cap as you embark on the quest to crack some codes.

Welcome to the game of Mastermind. 

The rules are simple:
1. At the start of each game you will be given a 4 digit code,between the numbers of 0-7, to guess.
2. You will have 10 attempts to guess the number combination. An invalid attempt will not be counted.
3. After each attempt, your guess will receive feedback on:
   a.the amount of correct numbers 
   b.the amount of correct positions

I hope that you enjoy your challenge.

<h2>Assembling Your Arsenal</h2>
For you to begin your quest, please ensure that you have the following installed:
1. Java Development Kit
2. Git

Please enter the following in your command prompt:
git clone https: git.....

<h2>New Horizons and Updates</h2>
The guild has some exciting updates planned to further challenge your mind and gain some insights in your thought process.

<h3>1.Multiplying the Fun</h3>
As the update name suggests, gear up and level up your Arithemetic skills. 
This new feature will allow you to gain additional rounds at the very last round if you can solve the product of your guess!

For example:
If your guess (2517), at the last round was incorrect, the quest offers you another chance.
Solve the multiplication riddle of  (2*5*1*7) to earn one more attempt.

<h3> 2.Self Discovery </h3>
True treasure not lies in conquering the quest, but instead in understanding yourself.
This update will allow you to uncover your habits like favorite numbers you tend to use.
At the end of each game the quest will reveal the ranking of your most to least used number.

***
Hello, developer here!

Creating this game has been a really fun and rewarding process - thank you for the opportunity reader.</br>
The making of Mastermind took place in X stages:</br>
1. Conceptualization</br>
2. Developing Methods
   a.I started with creating the two methods that generate the main date</br>
        createNumberToGuess()</br>
        getUserGuess()</br>
   b.This was followed by creating the two corresponding methods that would store the current string of numbers into an integer array.</br>
   I wanted to store the data in an integer array because I thought that it would be fun to treat each digit individually and play around on how else each digit can be used in the future(ideas like the update mentioned above).</br>
        storeNumberToGuess()</br>
        storeUserGuess()</br>
   c.The next two methods compared the arrays returned from storeNumberToGuess() and storeUserGuess() </br>
        checkCorrectPosition()</br>
        checkCorrectNumbers()</br>
   d.The last two methods were created in order to store and provide the user feedback</br>
        storeGameHistory()</br>
        showGameHistory()</br>
3. Developing the Main Logic
   This stage involved analyzing what "Game Over" means: losing and winning.</br>
   Winning meant that the return from checkCorrectPosition and checkCorrectNumbers are both "4".</br>
   Losing meant that the number was not guessed correctly within 10 rounds.</br>
4.Testing
This was the stage where I came across some bugs and changed some logic in order to address these.</br>
