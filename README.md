<h1> Mastermind Game</h1>

<h2>🏞️Quest Begins</h2>
Hello, adventurer please put on your thinking cap as you embark on the quest to crack some codes.</br>
</br>
🎇Welcome to the game of Mastermind.🎇</br>
</br>
The rules are simple:</br>
1. At the start of each game you will be given a 4 digit code,between the numbers of 0-7, to guess.</br>
2. You will have 10 attempts to guess the number combination. An invalid attempt will not be counted.</br>
3. After each attempt, your guess will receive feedback on:</br>
  &emsp; &emsp; &emsp; a.the amount of correct numbers </br>
  &emsp; &emsp; &emsp; b.the amount of correct positions</br>
</br>
I hope that you enjoy your challenge and keep in mind that just when you think its over, sometimes, life likes to giveSecondChances().

<h2>🛠️Assembling Your Arsenal</h2>
For you to begin your quest, please ensure that you have the following installed:</br>
1. Java Development Kit Version 15</br>
2. Git</br>

Please enter the following in your command prompt:
`git clone https://github.com/blunasco/MasterMind.git`

<h2>New Horizons and Updates</h2>
The guild has some exciting updates planned to further challenge your mind and gain some insights in your thought process.
<h3>1.🧠Self Discovery </h3>
True treasure not lies in conquering the quest, but instead in understanding yourself.
This update will allow you to uncover your habits like favorite numbers you tend to use.
At the end of each game the quest will reveal the ranking of your most to least used number.

***
<h2> Hello, developer here!🙋🏽‍♀️ </h2>

Creating this game has been a really fun and rewarding process - thank you for the opportunity reader.</br>
</br>
The making of Mastermind took place in 4 stages:</br>
1. Conceptualization</br>
2. Developing Methods</br>
   a.I started with creating the two methods that generate the main data</br>
        *&emsp; &emsp; &emsp;createNumberToGuess()</br>*
        *&emsp; &emsp; &emsp; getUserGuess()</br>*
   </br>
   b.This was followed by creating the two corresponding methods that would store the current string of numbers into an integer array. I wanted to store the data in an integer array because I thought that it would be fun to treat each digit individually and play around on how else each digit can be used in the future(ideas like the update mentioned above).</br>
        *&emsp; &emsp; &emsp;storeNumberToGuess()</br>*
        *&emsp; &emsp; &emsp;storeUserGuess()</br>*
     </br>
   c.The next two methods compared the arrays returned from storeNumberToGuess() and storeUserGuess() </br>
        *&emsp; &emsp; &emsp;checkCorrectPosition()</br>*
        *&emsp; &emsp; &emsp; checkCorrectNumbers()</br>*
     </br>
   d.The last two methods were created in order to store and provide the user feedback</br>
        *&emsp; &emsp; &emsp;storeGameHistory()</br>*
        *&emsp; &emsp; &emsp;showGameHistory()</br>*
     </br>
3. Developing the Main Logic</br>
   This stage involved analyzing what "Game Over" means: losing and winning.</br>
   Winning meant that the return from checkCorrectPosition and checkCorrectNumbers are both "4".</br>
   Losing meant that the number was not guessed correctly within 10 rounds(or does it??🤔).</br>
     </br>
4. Testing</br>
This was the stage where I came across some bugs and changed some logic in order to address these.</br>
