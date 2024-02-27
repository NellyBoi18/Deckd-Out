# Requirements and Specification Document

## TeamName

Deck’d Out

### Project Abstract

<!--A one paragraph summary of what the software will do.-->

This application will be a graphical user interface that will act as a hub for the user to access each of the card games that we choose to develop, with the options being Cribbage, Euchre, Spades, and Sheepshead. Our application will allow the user to play the different card games while keeping track of the score. There will also be user profiles, which will track user high scores and will be able to rank the users against each other. 

### Customer

<!--A brief description of the customer for this software, both in general (the population who might eventually use such a system) and specifically for this document (the customer(s) who informed this document). Every project will have a customer from the CS506 instructional staff. Requirements should not be derived simply from discussion among team members. Ideally your customer should not only talk to you about requirements but also be excited later in the semester to use the system.-->

In terms of the population who might eventually our system, I would say that for the most part it would be used by younger or middle-aged working men and women who enjoy card games, but are not intense enough to play at weekly in-person meetings. Then again, those intense individuals could also use our app and compete with others via the ranking system. I feel that much older and younger individuals will likely either not understand or have access to the required technology to run our application, though technology like this is becoming more accessible every day.

### User Requirements

<!--This section lists the behavior that the users see. This information needs to be presented in a logical, organized fashion. It is most helpful if this section is organized in outline form: a bullet list of major topics (e.g., one for each kind of user, or each major piece of system functionality) each with some number of subtopics.-->

| ID   | Description                                                  | Priority | Status |
| ---- | ------------------------------------------------------------ | -------- | ------ |
| R11  | Users should be able to sign into the application with an account and access their high scores. | Med      | Open   |
| R12  | Users should be able to play the specified card games against other players. | High     | Open   |
| R13  | There should be a ranking system that compares the user's scores to other player's scores. | Med     | Open   |
| R14  | The user should be able to access a hub that will allow them to pick the card game that they want to play. | High      | Open   |
| R15  | The logic of each card game should work properly, and allow for a winner and a loser, as well as correct scoring. | Med     | Open   |
| R16  | Application UI should be as accessible and clear, with no confusing buttons or settings. | High     | Open   |

### Use Cases & User Stories

<!--Use cases and user stories that support the user requirements in the previous section. The use cases should be based off user stories. Every major scenario should be represented by a use case, and every use case should say something not already illustrated by the other use cases. Diagrams (such as sequence charts) are encouraged. Ask the customer what are the most important use cases to implement by the deadline. You can have a total ordering, or mark use cases with “must have,” “useful,” or “optional.” For each use case you may list one or more concrete acceptance tests (concrete scenarios that the customer will try to see if the use case is implemented).-->

Here is a sample user story from [Clean Agile](https://learning-oreilly-com.ezproxy.library.wisc.edu/library/view/clean-agile-back/9780135782002/ch03.xhtml#ch03lev1sec1) using a markdown block quote:

> As the driver of a car, in order to increase my velocity, I will press my foot harder on the accelerator pedal.

### User Interface Requirements

<!--Describes any customer user interface requirements including graphical user interface requirements as well as data exchange format requirements. This also should include necessary reporting and other forms of human readable input and output. This should focus on how the feature or product and user interact to create the desired workflow. Describing your intended interface as “easy” or “intuitive” will get you nowhere unless it is accompanied by details.-->

<!--NOTE: Please include illustrations or screenshots of what your user interface would look like -- even if they’re rough -- and interleave it with your description.-->

Images can be included with `![alt_text](image_path)`

### Security Requirements

<!--Discuss what security requirements are necessary and why. Are there privacy or confidentiality issues? Is your system vulnerable to denial-of-service attacks?-->

### System Requirements

<!--List here all of the external entities, other than users, on which your system will depend. For example, if your system inter-operates with sendmail, or if you will depend on Apache for the web server, or if you must target both Unix and Windows, list those requirements here. List also memory requirements, performance/speed requirements, data capacity requirements, if applicable.-->

| You    |    can    |    also |
| ------ | :-------: | ------: |
| change |    how    | columns |
| are    | justified |         |

### Specification

<!--A detailed specification of the system. UML, or other diagrams, such as finite automata, or other appropriate specification formalisms, are encouraged over natural language.-->

<!--Include sections, for example, illustrating the database architecture (with, for example, an ERD).-->

<!--Included below are some sample diagrams, including some example tech stack diagrams.-->

You can make headings at different levels by writing `# Heading` with the number of `#` corresponding to the heading level (e.g. `## h2`).

#### Technology Stack

User Interface Frontend:
- Technologies: React.js, javascript, HTML, CSS
- Purpose: This layer handles the presentation and interactivity with the
user, delivering a responsive and accessible experience.

Backend:
- Technologies: JAVA, Node.js
- Purpose: The backend serves as the bridge between the frontend and the
game engine, handling requests, and processing the game logic.

Game Engine:
- Technologies: Java or Unity Engine if it's a graphical game
- Purpose: The core of the game's operation, managing game state,
enforcing rules, and running the main game loop.

Game Logic:
- Technologies: Java and javascript
- Purpose: Implements the specific rules and mechanics of each game
(Cribbage, Euchre, Spades, Sheepshead), including scoring calculations
and decision-making.

Networking:
- Technologies: Java sockets for network communication, and Java RMI
(Remote Method Invocation) for distributed object applications.
- Purpose: To handle multiplayer interactions, synchronization of game
state across clients, and to facilitate communication with the backend for
authentication and database interactions.

User Authentication:
- Technologies: JSON Web Tokens (JWT)
- Purpose: To securely identify users and manage sessions, ensuring that
users can securely log in and interact with the system.

Database:
- Technologies: SQL Database ( MySQL or NoSQL)
- Purpose: To store user information, game states, scores, and potentially
complex game-related data structures.

Score Calculation (Specific to Each Game):
- Technologies: Java methods and classes specifically tailored to handle
the scoring systems of Cribbage, Euchre, Spades, and Sheepshead.
- Purpose: To calculate and maintain scores based on the rules of Cribbage,
Euchre, Spades, and Sheepshead, respectively.





#### Database

```mermaid
---
title: Sample Database ERD for an Order System
---
erDiagram
    Customer ||--o{ Order : "placed by"
    Order ||--o{ OrderItem : "contains"
    Product ||--o{ OrderItem : "included in"

    Customer {
        int customer_id PK
        string name
        string email
        string phone
    }

    Order {
        int order_id PK
        int customer_id FK
        string order_date
        string status
    }

    Product {
        int product_id PK
        string name
        string description
        decimal price
    }

    OrderItem {
        int order_item_id PK
        int order_id FK
        int product_id FK
        int quantity
    }
```

#### Class Diagram

```mermaid
---
title: Sample Class Diagram for Animal Program
---
classDiagram
    class Animal {
        - String name
        + Animal(String name)
        + void setName(String name)
        + String getName()
        + void makeSound()
    }
    class Dog {
        + Dog(String name)
        + void makeSound()
    }
    class Cat {
        + Cat(String name)
        + void makeSound()
    }
    class Bird {
        + Bird(String name)
        + void makeSound()
    }
    Animal <|-- Dog
    Animal <|-- Cat
    Animal <|-- Bird
```

#### Flowchart

```mermaid
---
title: Sample Program Flowchart
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
participant DjangoBackend
participant MySQLDatabase

ReactFrontend ->> DjangoBackend: HTTP Request (e.g., GET /api/data)
activate DjangoBackend

DjangoBackend ->> MySQLDatabase: Query (e.g., SELECT * FROM data_table)
activate MySQLDatabase

MySQLDatabase -->> DjangoBackend: Result Set
deactivate MySQLDatabase

DjangoBackend -->> ReactFrontend: JSON Response
deactivate DjangoBackend
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
