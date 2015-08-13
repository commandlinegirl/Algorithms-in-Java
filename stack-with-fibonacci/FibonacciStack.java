package StackFibonacci;

import java.util.Stack;

public class FibonacciStack {
	
	private static int fibonacciIterative(int n)  {	
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <= n; i++) {
			if (i == 0 ) {
				stack.push(0);
				continue;
			}
			if (i == 1) {
				stack.push(1);
				continue;
			}
			Integer pop_1 = stack.pop();
			Integer pop_2 = stack.pop();
			int sum = pop_1 + pop_2;
			stack.push(pop_1);
			stack.push(sum);
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fibonacciIterative(n));
	}
}
