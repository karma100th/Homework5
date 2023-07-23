import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Robot {
    private static final int PARTS_NEEDED = 6;
    private Set<RobotPart> partsCollected = new HashSet<>();

    public Set<RobotPart> getPartsCollected() {
        return partsCollected;
    }

    // Метод для добавления части к роботу
    public synchronized void addPart(RobotPart robotPart) {
        partsCollected.add(robotPart);
    }

    // Метод, проверяющий, собран ли робот
    public synchronized boolean isComplete() {
        return partsCollected.size() == PARTS_NEEDED;
    }

    // Метод для сброса счетчика частей при сборке робота
    public synchronized void resetPartsCollected() {
        partsCollected.removeAll(Arrays.asList(RobotPart.values()));
    }
}

