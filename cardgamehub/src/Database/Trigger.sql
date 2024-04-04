/* 
This file contains the SQL code for creating triggers in the database so that
game table rows are initialized for each user when a new user is created.
*/

-- Trigger to insert a new row into the Spades table when a new user is created
CREATE TRIGGER AfterUserInsertSpades
AFTER INSERT
ON Users FOR EACH ROW
INSERT INTO Spades set USER_ID = NEW.ID;

-- Trigger to insert a new row into the Euchre table when a new user is created
CREATE TRIGGER AfterUserInsertEuchre
AFTER INSERT
ON Users FOR EACH ROW
INSERT INTO Euchre set USER_ID = NEW.ID;