import java.util.Random;

public class Die {
    private Random random;

    public Die() {
        this.random = new Random();
    }

    // Roll the die once (1-6)
    public int roll() {
        return random.nextInt(6) + 1;
    }
}