/* 
This file contains the SQL code for creating cascade's in the database so that
tables with foreign keys automatically delete data when the associated User in
the Users table is deleted..
*/

/* Adds an ON DELETE CASCADE to the Spades table USER_ID foreign key that 
automatically deletes associated rows from the Spades table when a user is 
deleted from the Users table
*/
ALTER TABLE `Spades`
ADD CONSTRAINT `fk_user_spades`
FOREIGN KEY (`USER_ID`)
REFERENCES `Users` (`ID`)
ON DELETE CASCADE;

/* Adds an ON DELETE CASCADE to the Euchre table USER_ID foreign key that 
automatically deletes associated rows from the Spades table when a user is 
deleted from the Users table
*/
ALTER TABLE `Euchre`
ADD CONSTRAINT `fk_user_spades`
FOREIGN KEY (`USER_ID`)
REFERENCES `Users` (`ID`)
ON DELETE CASCADE;