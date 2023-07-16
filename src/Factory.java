import java.util.Random;

public class Factory {
    private final Random random;
    private final RobotPart[] availableParts;

    public Factory(RobotPart[] availableParts) {
        this.random = new Random();
        this.availableParts = availableParts;
    }

    public synchronized RobotPart takeRandomPart() {
        if (availableParts.length > 0) {
            int index = random.nextInt(availableParts.length);
            RobotPart part = availableParts[index];
            availableParts[index] = null;
            return part;
        }
        return null;
    }
}
