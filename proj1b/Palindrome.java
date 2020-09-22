public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c: word.toCharArray()) {
            deque.addLast(c);
        }

        return deque;
    }
}
