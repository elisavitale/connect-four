## **About the project**
This project implements a command line version of the Connect Four game. There are two gameplay modes, summarized below.
-	*Connect Four*, which is the traditional gameplay. The first player starts by dropping one of their yellow discs into the center column of an empty game board. The size of the board is 6 rows x 7 columns. The two players then alternate turns dropping one of their discs at a time into an unfilled column, until the second player, with red discs, achieves a diagonal four in a row, and wins the game. If the board fills up before either player achieves four in a row, then the game is a draw. 
-	*Pop Out* starts the same as traditional gameplay, with an empty board and players alternating turns placing their own colored discs into the board. During each turn, a player can either add another disc from the top or, if one has any discs of his or her own color on the bottom row, remove (or "pop out") a disc of one's own color from the bottom. Popping a disc out from the bottom drops every disc above it down one space, changing their relationship with the rest of the board and changing the possibilities for a connection. The first player to connect four of their discs horizontally, vertically, or diagonally wins the game. 

Source: [Wikipedia](https://en.wikipedia.org/wiki/Connect_Four)

## **About the code**
The board, whose size is 6 rows by 7 columns, has rows and columns numbered as follows:
-	Rows from 1 to 6, going from top to bottom. 
-	Columns from 1 to 7, going from left to right.

At the beginning of the game, the layout of the (empty) board is the following:

>`.1 2 3 4 5 6 7 ` \
`| | | | | | | |` \
`| | | | | | | |` \
`| | | | | | | |` \
`| | | | | | | |` \
`| | | | | | | |` \
`| | | | | | | |` 

*Diagonals* go from top left to bottom right (&#8600;), whereas *antidiagonals* go from bottom left to top right (&#8599;).\
During gameplay, the red and yellow discs are replaced by letters: R for red, Y for yellow. 
