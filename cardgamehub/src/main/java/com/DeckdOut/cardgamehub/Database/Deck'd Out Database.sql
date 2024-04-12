CREATE TABLE `user` (
  `id` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` varchar(255) UNIQUE NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  'spadesNumGames' integer DEFAULT 0,
  'spadesGamesWon' integer DEFAULT 0,
  'eucreNumGames' integer DEFAULT 0,
  'eucreGamesWon' integer DEFAULT 0
);

-- Depreciated code below. No longer within the scope of the project.

-- CREATE TABLE `Spades` (
--   `USER_ID` integer NOT NULL,
--   `highScore` integer DEFAULT 0,
--   `numGames` integer DEFAULT 0,
--   `gamesWon` integer DEFAULT 0
-- );

-- CREATE TABLE `UserSpadesGames` (
--   `USER_ID` integer NOT NULL,
--   `GAME_ID` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT
-- );

-- CREATE TABLE `SpadesGameHistoryTemplate` (
--   `GAME_ID` integer NOT NULL,
--   `time` timestamp,
--   `move` varchar(255)
-- );

-- CREATE TABLE `Euchre` (
--   `USER_ID` integer NOT NULL,
--   `highScore` integer DEFAULT 0,
--   `numGames` integer DEFAULT 0,
--   `gamesWon` integer DEFAULT 0
-- );

-- CREATE TABLE `UserEuchreGames` (
--   `USER_ID` integer NOT NULL,
--   `GAME_ID` integer UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT
-- );

-- CREATE TABLE `EuchreGameHistoryTemplate` (
--   `GAME_ID` integer NOT NULL,
--   `time` timestamp,
--   `move` varchar(255)
-- );

-- ALTER TABLE `Spades` ADD FOREIGN KEY (`USER_ID`) REFERENCES `Users` (`ID`);

-- ALTER TABLE `UserSpadesGames` ADD FOREIGN KEY (`USER_ID`) REFERENCES `Spades` (`USER_ID`);

-- ALTER TABLE `SpadesGameHistoryTemplate` ADD FOREIGN KEY (`GAME_ID`) REFERENCES `UserSpadesGames` (`GAME_ID`);

-- ALTER TABLE `Euchre` ADD FOREIGN KEY (`USER_ID`) REFERENCES `Users` (`ID`);

-- ALTER TABLE `UserEuchreGames` ADD FOREIGN KEY (`USER_ID`) REFERENCES `Euchre` (`USER_ID`);

-- ALTER TABLE `EuchreGameHistoryTemplate` ADD FOREIGN KEY (`GAME_ID`) REFERENCES `UserEuchreGames` (`GAME_ID`);
