public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        x = Character.toLowerCase(x);
        y = Character.toLowerCase(y);

        return x - y == n || y - x == n;
    }
}
