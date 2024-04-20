# Requirements and Specification Document

[![pipeline status](https://git.doit.wisc.edu/cdis/cs/courses/cs506/sp2024/team/tuesdaythursdaylecture/T_33/main-project/badges/main/pipeline.svg)](https://git.doit.wisc.edu/cdis/cs/courses/cs506/sp2024/team/tuesdaythursdaylecture/T_33/main-project/-/commits/main) 
[![coverage report](https://git.doit.wisc.edu/cdis/cs/courses/cs506/sp2024/team/tuesdaythursdaylecture/T_33/main-project/badges/main/coverage.svg)](https://git.doit.wisc.edu/cdis/cs/courses/cs506/sp2024/team/tuesdaythursdaylecture/T_33/main-project/-/commits/main)
[![Latest Release](https://git.doit.wisc.edu/cdis/cs/courses/cs506/sp2024/team/tuesdaythursdaylecture/T_33/main-project/-/badges/release.svg)](https://git.doit.wisc.edu/cdis/cs/courses/cs506/sp2024/team/tuesdaythursdaylecture/T_33/main-project/-/releases)

## Team Name

Deck’d Out

### Project Abstract

<!--A one paragraph summary of what the software will do.-->

This application will be a graphical user interface that will act as a hub for the user to access the two card games that we are developing: spades and euchre. Our application will allow the user to play the different card games while keeping track of the score. There will also be user profiles, which will track of the number of respective games the user has won and will be able to rank the users against each other. 

### Customer

<!--A brief description of the customer for this software, both in general (the population who might eventually use such a system) and specifically for this document (the customer(s) who informed this document). Every project will have a customer from the CS506 instructional staff. Requirements should not be derived simply from discussion among team members. Ideally your customer should not only talk to you about requirements but also be excited later in the semester to use the system.-->

In terms of the population who might eventually our system, it would be used by younger or middle-aged working men and women who enjoy card games, but are not intense enough to play at weekly in-person meetings. Then again, those intense individuals could also use our app and compete with others via the ranking system. Much older and younger individuals will likely either not understand or have access to the required technology to run our application, though technology like this is becoming more accessible every day.

### User Requirements

<!--This section lists the behavior that the users see. This information needs to be presented in a logical, organized fashion. It is most helpful if this section is organized in outline form: a bullet list of major topics (e.g., one for each kind of user, or each major piece of system functionality) each with some number of subtopics.-->

| ID   | Description                                                  | Priority | Status |
| ---- | ------------------------------------------------------------ | -------- | ------ |
| [R1](#76)  | When the user first opens the application or when the user logs out, the frontend SHALL display the login page. | Med      | Open   |
| [R2](#77)  | When the user clicks on the sign in button after entering their valid username and password on the login page, the frontend SHALL display the game lobby page. | High      | Open   |
| [R3](78)  | When the user clicks on the "Join Now" button on the login page, the frontend SHALL display the register page. | High      | Open   |
| [R4](#79)  | When the user clicks on the profile button on any screen that it appears in, the frontend SHALL display the profile page. | Med      | Open   |
| [R5](#80)  | When the user clicks on the settings button on any screen that it appears in, the frontend SHALL display the settings page. | Low      | Open   |
| [R6](#81)  | On the game lobby page, when the user selects a game to play, the frontend SHALL display the game in question, and the backend SHALL begin the repsective game() method. | High      | Open   |
| [R7](#82)  | When the user clicks on the leaderboard button, the frontend SHALL display a leaderboard containing the user's score compared to the scores of other registered users. | Med      | Open   |
| [R8](#83)  | When the user clicks on the home button (top left, in the form of the logo), the frontend SHALL display the game lobby home screen. | Med      | Open   |
| [R9](#84)  | When the user selects a card to play, the card will be inserted into the trick, the card SHALL be removed from the user's hand of cards, and the correct winner of the trick will be determined by the backend logic. | High      | Open   |
| [R10](#85)  | When the winner of a trick is determined, the application SHALL display who won the trick to the user. | Med      | Open   |
| [R11](#86)  | After a round of spades, the correct number of points SHALL be calculated and added to each teams total, and if one team has over 500 points then they SHALL be declared the winner of the game. | Med      | Open   |
| [R12](#87)  | [GENERAL REQ] When the user begins a game of spades, the game logic defined in the backend SHALL be correctly implemented and allow for a legal game of spades to be played. | High      | Open   |
| [R13](#88)  | Users SHALL be able to sign into the application with an account and access their high scores. | Med      | Open   |
| [R14](#89)  | Users SHALL be able to play the specified card games against other players. | Low     | Open   |
| [R15](#90)  | There SHALL be a ranking system that compares the user's scores to other player's scores. | Med     | Open   |
| [R16](#91)  | The user SHALL be able to access a hub that will allow them to pick the card game that they want to play. | High      | Open   |
| [R17](#92)  | The logic of each card game SHALL work properly, and allow for a winner and a loser, as well as correct scoring. | Med     | Open   |
| [R18](#93)  | Application UI SHALL be as accessible and clear, with no confusing buttons or settings. | High     | Open   |
| [R19](#122)  | The application SHALL be able to connect to the backend logic and display the correct information to the user. | High     | Open   |
| [R20](#123)  | The application SHALL be able to handle an incorrect username / password pair and display an error message to the user. | High      | Open   |
| [R21](#124)  | The application SHALL be able to prevent users from making illegal moves in the card games. | High     | Open   |
| [R22](#125)  | The user SHALL be able to see the cards that they are playing with in a graphical representation. | High     | Open   |
| [R23](#126)  | The user SHALL be able to see the game of spades that they are playing. | High     | Open   |
| [R24](#127)  | The user SHALL be able to see the game of euchre that they are playing. | High     | Open   |
| [R25](#128)  | The user SHALL be able to view all the past card games they played while logged into their account. | Low     | Open   |


### Use Cases & User Stories

<!--Use cases and user stories that support the user requirements in the previous section. The use cases should be based off user stories. Every major scenario should be represented by a use case, and every use case should say something not already illustrated by the other use cases. Diagrams (such as sequence charts) are encouraged. Ask the customer what are the most important use cases to implement by the deadline. You can have a total ordering, or mark use cases with “must have,” “useful,” or “optional.” For each use case you may list one or more concrete acceptance tests (concrete scenarios that the customer will try to see if the use case is implemented).-->

As a user, I want to be able to register for an account so that I can access the features available to my account.

As a user, I want to log into the card game hub using a username and password so that I can access the features available to my account.

As a user, I want to be able to use the graphical user interface (GUI) to select the mode of operation.

As a user, I want to be able to use the GUI to view all the past card games I played while logged into my account.

As a user, while viewing past card games, I want the application to show the optimal move for any given card hand, based only on the information known to the player.

As a user, I want to play a legal game of Euchre against a computer player.

As a user, I want to play a legal game of Spades against a computer player.

As a user, I want the card application to prevent me from making an illegal move.

As a user I want the Euchre backend logic to be correct.

As a user, I want to play a legal game of Euchre against a human player over the internet.

As a user, I want to play a legal game of Spades against a human player over the internet.

As a user, I want to be able to view my game statistics, including the number of wins and losses in each card game.

As a user, I want to my game statistics to update after I play games. 

As a user, I want to be able to view a leaderboard to see how I rank against other players.

As a user, I want to be able to view my leaderboard rank update as I play more games against other players.

As a user, I want to be able to navigate between screens.

As a user, I want to be able to access the game lobby from any screen.

As a user, I want the card data from the UI to connect with the Backend functionality in both Spades and Euchre logic.

As a developer, I want more insight on how to connect frontend to backend.

As a user, I want a graphical representation of the cards that I am playing with.

As a user, I want to be able to see the game of Spades that I am playing.

### User Interface Requirements

<!--Describes any customer user interface requirements including graphical user interface requirements as well as data exchange format requirements. This also should include necessary reporting and other forms of human readable input and output. This should focus on how the feature or product and user interact to create the desired workflow. Describing your intended interface as “easy” or “intuitive” will get you nowhere unless it is accompanied by details.-->

<!--NOTE: Please include illustrations or screenshots of what your user interface would look like -- even if they’re rough -- and interleave it with your description.-->

The user interface for the application will have a login page, a register page, a home page, a game page, and a leaderboard page. 

The login page will have a text field for the user to enter their username and a text field for the user to enter their password.
![Login Page](Images/signIn.png)
There will be a sign in button that the user can click to sign in and a join now button that the user can click to register. 
The register page will have a text field for the user to enter their username, a text field for the user to enter their email, a text field for the user to enter their password, and a text field for the user to verify their password. 
![Register Page](Images/register.png)

The home page will allow the user to select a game to play. 
![Home Page](Images/home.png)

The game page will display the game that the user is playing.
![Game Page](Images/gameDeal.png)
For both Spades and Euchre
![Spades Game](Images/spadesGame.png)
![Euchre Game](Images/euchreTrump.png)

The leaderboard page will display the user's rank compared to other users.
![Leaderboard Page](Images/leaderboard.png)

### Security Requirements

<!--Discuss what security requirements are necessary and why. Are there privacy or confidentiality issues? Is your system vulnerable to denial-of-service attacks?-->

| ID   | Description                                                  | Priority | Status |
| ---- | ------------------------------------------------------------ | -------- | ------ |
| [SR1](#129)  | Users should be able to safely input their username and password and know it is protected. | Low      | Open   |
| [SR2](#130)  | Users should be able to log into their account anytime they wish assuming they have the correct password. | High      | Open   |
| [SR3](#131)  | Incorrect username / password pairs should not be allowed to access accounts. | High     | Open   |
| [SR4](#132)  | Users should not be able to access other user's accounts. | High     | Open   |
| [SR5](#133)  | Users should not be able to access the backend logic of the application. | Low     | Open   |
| [SR6](#134)  | Users should not be able to access the database of the application. | High     | Open   |


### System Requirements

<!--List here all of the external entities, other than users, on which your system will depend. For example, if your system inter-operates with sendmail, or if you will depend on Apache for the web server, or if you must target both Unix and Windows, list those requirements here. List also memory requirements, performance/speed requirements, data capacity requirements, if applicable.-->

| ID   | Description                                                  | Priority | Status |
| ---- | ------------------------------------------------------------ | -------- | ------ |
| [SYSR1](#135)  | We are targeting Windows users with our application. | Med      | Open   |
| [SYSR2](#136)  | We are targeting MacOS users with our application. | Med      | Open   |
| [SYSR3](#137)  | We are targeting Linux users with our application. | Med      | Open   |
| [SYSR4](#138)  | Web browsers that support JavaScript are required to run our application. | High      | Open   |
| [SYSR5](#139)  | The application should be able to run on a computer with at least 4GB of RAM. | High      | Open   |
| [SYSR6](#140)  | The application should be able to run on a computer with at least 1GB of free storage space. | High      | Open   |
| [SYSR7](#141)  | The application should be able to run on a computer with at least a 2.0 GHz processor. | High      | Open   |
| [SYSR8](#142)  | The application should be able to run on a computer with at least a 1280x720 resolution screen. | High      | Open   |

### Specification

<!--A detailed specification of the system. UML, or other diagrams, such as finite automata, or other appropriate specification formalisms, are encouraged over natural language.-->

<!--Include sections, for example, illustrating the database architecture (with, for example, an ERD).-->

<!--Included below are some sample diagrams, including some example tech stack diagrams.-->

#### Technology Stack

User Interface Frontend:
- Technologies: JavaScript, Maven
- Purpose: This layer handles the presentation and interactivity with the user, delivering a responsive and accessible experience.

Backend:
- Technologies: Java, Spring Boot
- Purpose: The backend serves as the bridge between the frontend and the game engine, handling requests, and processing the game logic.

Game Engine:
- Technologies: Java 
- Purpose: The core of the game's operation, managing game state, enforcing rules, and running the main game loop.

Game Logic:
- Technologies: Java 
- Purpose: Implements the specific rules and mechanics of each game (Euchre, Spades), including scoring calculations and decision-making.

<!--Networking:
- Technologies: Java sockets for network communication, and Java RMI (Remote Method Invocation) for distributed object applications.
- Purpose: To handle multiplayer interactions, synchronization of game state across clients, and to facilitate communication with the backend for authentication and database interactions.-->
Networking:
- Technologies: Java Database Connectivity (JDBC)
- Purpose: To connect to the database, allowing for the storage and retrieval of user data, game states, and scores.

User Authentication:
- Technologies: JSON Web Tokens (JWT) 
- Purpose: To securely identify users and manage sessions, ensuring that users can securely log in and interact with the system.

Database:
- Technologies: MySQL Database
- Purpose: To store user information, game states, scores, and potentially complex game-related data structures.

Score Calculation:
- Technologies: Java 
- Purpose: To calculate and maintain scores based on the rules of Euchre and Spades, respectively. 


#### Database

```mermaid
---
title: Deck'd Out Database ERD
---
erDiagram
    Users {
        int ID PK, UK
        varchar email "NOT NULL"
        varchar username UK "NOT NULL"
        varchar password "NOT NULL"
        int spades_num_games "DEFAULT 0"
        int spades_games_won "DEFAULT 0"
        int euchre_num_games "DEFAULT 0"
        int euchre_games_won "DEFAULT 0"
    }

```
<!--Target database design-->
<!--erDiagram
    Users {
        int ID PK, UK
        varchar email
        varchar username UK
        varchar password
    }

    Users ||--o{ Spades : played

    Spades {
        int USER_ID FK, UK
        int highScore
        int numGames
        int gamesWon
    }

    Spades ||--|{ UserSpadesGame : contains

    UserSpadesGame {
        int USER_ID FK
        int GAME_ID PK, UK
    }

    UserSpadesGame ||--|{ SpadesGameHistoryTemplate : contains

    SpadesGameHistoryTemplate {
        int GAME_ID FK
        time timestamp
        varchar move
    }

    Users ||--o{ Euchre : played

    Euchre {
        int USER_ID FK
        int highScore
        int numGames
        int gamesWon
    }

    Euchre ||--|{ UserEuchreGame : contains

    UserEuchreGame {
        int USER_ID FK
        int GAME_ID PK, UK
    }

    UserEuchreGame ||--|{ EuchreGameHistoryTemplate : contains

    EuchreGameHistoryTemplate {
        int GAME_ID FK
        time timestamp
        varchar move
    }-->


#### Class Diagram

```mermaid
---
title: Class Diagram
---
classDiagram
    class Player {
        - String userName
        - int bid 
        - ArrayList<Card> hand
        + Player(String userName)
        + Card pickCard(Card card)
        + void setBid(int bid)
        + int getBid()
        + void setHand(ArrayList<Card> hand)
        + ArrayList<Card> getHand()
        + void removePlayedCard(Card playedCard)
        + String getuserName()
        + boolean hasTrump(ArrayList<Card> hand)
        + boolean hasLeadingSuit(ArrayList<Card> hand, String leadingSuit)
        + Card getHighNorm(Player player)
        + Card getLowNorm(Player player)
        + int numtrump(Player player)
        + boolean containsCard(Card card, Player player)
        + boolean containsNormAce(Player player)
        + Card getHighSuit(Player player, String suit)
        + Card getLowSuit(Player player, String suit)
        + boolean hasGivenSuit(Player player, String suit)
        + boolean hasGivenCard(Player player, Stringsuit, int cardVal)
        + int numNonTrumpVals(Player player, int cardVal)
        + Card cpuChooseCardSpades(Player cpu, String leadingSuit, Player startPlayer)
        + int cpuChooseBid(Player cpu)
        + String[] cpuSuitDecision(Player cpu, String flippedTrump)
    }

    class Card {
        - String suit 
        - int cardValue 
        - Player owner 
        - boolean dealt 
        + Card(String suit, int cardValue, Player owner)
        + Card(String suit, int value)
        + void setOwner(Player owner)
        + void setDealt(boolean dealt)
        + boolean getDealt()
        + String getSuit()
        + int getCardValue()
        + Player getOwner()
        + boolean isSpade()
        + String toString()
    }

    class Deck {
        - ArrayList<Card> deck
        + Deck()
        + void shuffle()
        + ArrayList<Card> spadesDeal(Player playerName)
        + ArrayList<Card> euchreDeal(Player playerName)
        + Card cardCompareEuchre()
        + String toString()
    }

    class EuchreRound {
        - String declaredTrump
        - String flippedTrump
        - int p1EuchreTricks
        - int p2EuchreTricks
        - int p3EuchreTricks
        - int p4EuchreTricks
        - String teamPrediction
        - int team1EuchreTricks
        - int team2EuchreTricks
        - Trick[] euchreTrick
        - Player euchreStartPlayer
        - Deck deck
        - Player p1Euchre
        - Player p2Euchre
        - Player p3Euchre
        - Player p4Euchre
        - String EuchreLeadingSuit
        - boolean goAlone
        - boolean nameSuit
        - int dealerTracker
        + EuchreRound(String teamPrediction, Player p1Euchre, Player p2Euchre, Player p3Euchre, Player p4Euchre)
        + trickLogicSpades(ArrayList<Card> p1EuchreHand, ArrayList<Card> p2EuchreHand, ArrayList<Card> p3EuchreHand, ArrayList<Card> p4EuchreHand, Player euchreStartPlayer)
        + int[] playRoundEuchre()
    }

    class SpadesRound { 
        - int p1SpadesBid
        - int p2SpadesBid
        - int p3SpadesBid
        - int p4SpadesBid
        - int p1SpadesTricks
        - int p2SpadesTricks
        - int p3SpadesTricks
        - int p4SpadesTricks
        - int team1SpadesPred
        - int team2SpadesPred
        - Trick[] spadesTrick
        - Player spadesStartPlayer
        - Deck deck
        - Player p1Spades
        - Player p2Spades
        - Player p3Spades
        - Player p4Spades
        - int team1SpadesOvrTricks
        - int team2SpadesOvrTricks
        - String spadesLeadingSuit
        + SpadesRound(int team1SpadesPred, int team2SpadesPred, Player p1Spades, Player p2Spades, Player p3Spades, Player p4Spades)
        + boolean legalCardCheck(Card card)
        + Player trickLogicSpades(ArrayList<Card> p1SpadesHand, ArrayList<Card> p2SpadesHand, ArrayList<Card> p3SpadesHand, ArrayList<Card> p4SpadesHand, Player spadesStartPlayer)
        + int[] playRoundSpades()
        + int pointCalc(int player1SpadesTrick, int player2spadesTrick, int prediction, int teamOverspadesTrick, String team)
        + void setTeam1OvrspadesTrick(int num)
        + void setTeam2OvrspadesTrick(int num)
        + ArrayList<Card> getLegalCards(String spadesLeadingSuit)
    }

    class SpadeGameLogic { 
        String player1Name
        String player2Name
        String player3Name
        String player4Name
        Deck deck
        int team1PT
        int team2PT
        int placeHldrBid
        + void gameLogic()
    }

    class Trick {
        - String leadingSuit
        - String trumpSuit
        - Card winningCard
        - ArrayList<Card> trickCards
        - Player winningPlayer
        + Trick(ArrayList<Card> trickCards)
        + Card winnerOfTrick()
        + Card winnerOfEuchreTrick()
        + Card cardCompareEuchre(String leadingSuit, ArrayList<Card> trickCards)
        + Player getWinningPlayer()
        + Card cardCompareSpades(String leadingSuit, ArrayList<Card> trickCards)
    }
```

#### Flowchart

```mermaid
---
title: Deck'd Out Program Flowchart
---
graph TD;
    Start([Start]) --> Input_Data[/Input Data/];
    Input_Data --> Process_Data[Process Data];
    Process_Data --> Validate_Data{Validate Data};
    Validate_Data -->|Valid| Process_Valid_Data[Process Valid Data];
    Validate_Data -->|Invalid| Error_Message[/Error Message/];
    Process_Valid_Data --> Analyze_Data[Analyze Data];
    Analyze_Data --> Generate_Output[Generate Output];
    Generate_Output --> Display_Output[/Display Output/];
    Display_Output --> End([End]);
    Error_Message --> End;
```
```mermaid
---
title: Deck'd Out Program Flowchart
---
graph TD;
    Start([Start]) --> |Login| Login_Data[/Input Login Data/]
    Start --> |Register| Register[/Input Registration Info/]
    Login_Data --> Process_Valid_Data[Process Valid Data]
    Register --> Process_Valid_Data
    Process_Valid_Data --> Select_Game{Select Game}
    Select_Game --> |Spades| Spades_UI
    Select_Game --> |Euchre| Euchre_UI
    Spades_UI --> Play_Spades[Play Spades]
    Euchre_UI --> Play_Euchre[Play Euchre]
    Play_Spades --> End([End])
    Play_Euchre --> End
```

#### Behavior

```mermaid
---
title: Sample State Diagram For Coffee Application
---
stateDiagram
    [*] --> Ready
    Ready --> Brewing : Start Brewing
    Brewing --> Ready : Brew Complete
    Brewing --> WaterLowError : Water Low
    WaterLowError --> Ready : Refill Water
    Brewing --> BeansLowError : Beans Low
    BeansLowError --> Ready : Refill Beans
```

#### Sequence Diagram

```mermaid
sequenceDiagram

participant ReactFrontend
participant SpringBootBackend
participant MySQLDatabase

ReactFrontend ->> SpringBootBackend: HTTP Request (e.g., GET /api/card)
activate SpringBootBackend

SpringBootBackend ->> MySQLDatabase: Query (e.g., SELECT * FROM card)
activate MySQLDatabase

MySQLDatabase -->> SpringBootBackend: Result Set
deactivate MySQLDatabase

SpringBootBackend -->> ReactFrontend: JSON Response
deactivate SpringBootBackend
```

#### System Architecture Diagram

<!-- May need to actually draw this using something like mermaid for the README-->

![System Architecture Diagram](Images/SystemArchDiagram.jpg)

### Standards & Conventions

<!--Here you can document your coding standards and conventions. This includes decisions about naming, style guides, etc.-->

Coding Standards Document
This document serves as the complete definition of L3-33’s coding standards for source code in the Java programming language.
External Resource: Oracle’s Javadoc 
Heavily references: Java Coding Standard
—
Identifier Naming and Capitalization
Use descriptive names for all variables, function names, constants, and other identifiers.
Use single letter identifiers only for the counter in loops.
Class names use PascalCase.
Variable names use camelCase.
Variables include parameters, local variables, and data fields.
EXCEPTION: use UPPER_CASE for constants/final variables.
Method names use camelCase.
The source file name consists of the case-sensitive name of the top-level class it contains, plus the .java extension


Comments: Classes
Every class should be preceded with a descriptive comment using the Javadoc notational convention.
The comment should describe the purpose of the class.
Class names start with an uppercase letter (as mentioned above).



Comments: Methods
Every method definition should be preceded with a descriptive comment using the Javadoc notational convention.
The comment should include a description of the method, the name and description of each parameter, a description of the return value, and the name and description of any exceptions thrown within the method using Javadoc keyboards and formatting.




Comments: Public variables
Each public variable should be preceded with a descriptive comment using the Javadoc notational convention.
The comment should describe the purpose for the public variable.


Comments: In-line
In-line comments should be used to explain complicated sections of code, such as loops.
Use the // comment delimiter for in-line comments.
Do not comment on generally known features of the Java language.

Spacing: Between lines
Use two blank lines to separate each method within a class definition.
Use one blank line to separate logical sections of code within a method


Spacing: Within lines
Put a single space before each ‘{‘.
Separate all binary operators, such as ‘+’, ‘-’, ‘*’, ‘/’, ‘%’, etc., with a single space.
EXCEPTION: unary operators such as ‘++’, ‘--’, etc.

Indentation
Open braces do not start a new line.
Close braces do start a new line, and are indented with the code they close.
Comments line up with the block they comment.



Program Modules
Lines of code should be kept short, generally less than 80 or 100 characters wide.
Each public class is contained in a separate file.
Each file has the name of the public class contained within it.
