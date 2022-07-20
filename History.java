import java.util.Arrays;

enum Arrow {
    Up,
    Down
}

public class History {
    protected String value = "";
    protected int lastRequested = 0;

    void addToHistory(String str) {
        this.value += "~" + str;
    }

    String getValue(Arrow btn) {
        String[] wordss = value.split("~");
        String[] words = Arrays.copyOfRange(wordss, 1, wordss.length);

        String top = "";
        if (btn == Arrow.Up) {
            updateLastRequested(Arrow.Up, words.length);
            top = words[lastRequested];

        }
        if (btn == Arrow.Down) {
            updateLastRequested(Arrow.Down, words.length);
            System.out.println(lastRequested);
            top = words[lastRequested];
        }
        return top;
    }

    private void updateLastRequested(Arrow btn, int wordslen) {
        if (btn == Arrow.Up) {
            if (lastRequested == 0) {
                lastRequested = wordslen - 1;
            } else {
                lastRequested -= 1;
            }
        }
        if (btn == Arrow.Down) {
            if (lastRequested == wordslen - 1) {
                lastRequested = 0;
            } else {
                lastRequested += 1;
            }
        }
    }
}
