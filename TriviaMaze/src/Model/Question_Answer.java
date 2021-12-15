package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

import sql.SQLtest;

public class Question_Answer {

	static class position {
		int Row;
		int Col;

		public position(int row, int col) {
			this.Row = row;
			this.Col = col;
		}
	}

	public  boolean checkWay(int row, int col, char[][] graph) {
		boolean[][] isCheck = new boolean[graph.length][graph[0].length];
		Stack<position> stack = new Stack<>();
		stack.add(new position(row, col));
		isCheck[row][col] = true;
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		while (!stack.isEmpty()) {
			position p = stack.pop();
			for (int i = 0; i < dx.length; i++) {
				int newRow = row + dx[i];
				int newCol = col + dy[i];
				if (newRow >= 0 && newRow < graph.length && newCol >= 0 && newCol < graph[0].length) {
					if (graph[newRow][newCol] == 'E') {
						return true;
					}
					if ((graph[newRow][newCol] != '#' || graph[newRow][newCol] != '|') && !isCheck[newRow][newRow]) {
						stack.add(new position(newRow, newCol));
					}
				}

			}

		}

		return false;
	}

	// function to get question in SQL/ SQlite
	public static ArrayList<String> getQuestion() throws SQLException {
		// SQLtest sql = new SQLtest();
		// ArrayList<String> myQuestion = null;
		return SQLtest.randomQuestion();
	}

	// let question is answer .
	public void questionAnswer(ArrayList<String> question) {
	}

	public Boolean isCorrectAnswer(String answer, String input) {
		if (input == answer) {
			return true;
		}
		return false;
	}

}