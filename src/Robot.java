public class Robot {
    private static final int PARTS_NEEDED = 6;
    private int partsCollected = 0;

    // Метод для добавления части к роботу
    public synchronized void addPart() {
        partsCollected++;
    }

    // Метод, проверяющий, собран ли робот
    public synchronized boolean isComplete() {
        return partsCollected == PARTS_NEEDED;
    }

    // Метод для сброса счетчика частей при сборке робота
    public synchronized void resetPartsCollected() {
        partsCollected = 0;
    }
}

