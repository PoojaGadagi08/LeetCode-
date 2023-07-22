
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.

 

Example 1:

Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Example 2:

Input: n = 1, k = 0, row = 0, column = 0
Output: 1.00000
 













from functools import cache

class Solution:
    def __init__(self):
        # Initialize variables to store chessboard size and number of moves
        self.n = 0
        self.k = 0
        # Define the eight possible knight moves as relative coordinates
        self.states = [(1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1), (-2, -1), (-1, -2)]

    # Helper function to check if given coordinates (x, y) are within chessboard boundaries
    @cache
    def is_valid(self, x, y):
        if 0 <= x < self.n and 0 <= y < self.n:
            return True
        return False

    # Function to calculate the probability of knight staying on the board after k moves
    @cache
    def solve(self, x, y, k):
        # Base case: If k is 0, knight is guaranteed to stay on the board
        if k == 0:
            return 1
        rate = 0
        # Loop through all eight possible knight moves
        for dx, dy in self.states:
            n_x, n_y = x + dx, y + dy
            # Check if the new coordinates are valid (within chessboard boundaries)
            if not self.is_valid(n_x, n_y):
                continue
            # Calculate the probability for the current move and add it to the rate
            rate += 0.125 * self.solve(n_x, n_y, k - 1)
        return rate

    # Main function to solve the knight probability problem
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        # Update the chessboard size and number of moves
        self.n = n
        self.k = k
        # Edge case: If k is 0, simply check if the initial position is valid on the board
        if k == 0:
            return float(self.is_valid(row, column))
        # Otherwise, call the solve function with the starting position and k
        return self.solve(row, column, k)
