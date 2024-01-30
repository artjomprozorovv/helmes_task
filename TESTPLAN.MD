**Tennis Game Test Plan**
1. Introduction
   The purpose of this test plan is to ensure the quality and reliability of the Tennis Game command line application. The testing will cover various aspects of the game.

**Test Scope**
   The testing will cover the following areas:

   Game functionality (scoring, player input, incorrect input data, single game rules, set of minimum 6 games, saving game data to file).

**Test Environment**
   The tests will be conducted in the following environments:
   Operating Systems: Windows 10, macOS

**Test Cases**
   Functionality Testing:


- Confirm that both players given their names and sufficient logs printed out.
- Confirm that the scoring for players updates accurately.
- Confirm that score resets after each game in a set.
- Confirm status of the match when both player have 4 points (Deuce / Advantage / Game)
- Confirm that player input validators work as expected
- Confirm that valid exceptions thrown on errors
- Confirm that file is created when there is no file created yet (Game data for each round)
- Confirm that file is saved to specific location. (src/java/resources)
