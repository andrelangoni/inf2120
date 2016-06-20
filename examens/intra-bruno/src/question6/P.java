package question6;

import java.util.Stack;

public class P {
  public static void main(String[] args) {
    Stack<Integer> pile = new Stack<>();
    int i = 0;
    while (i < 7) {
      pile.push(i);
      ++i;
      pile.push(i);
      ++i;
      pile.pop();
    }
    while (!pile.empty()) {
      System.out.println(pile.peek());
      pile.pop();
    }
  }
}
