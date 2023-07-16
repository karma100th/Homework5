public class ThreadCountry extends Thread {
    private String name;
    private RobotPart[] partsNeeded;
    private Robot robot;
    private static volatile int totalRobots = 0;
    private static volatile boolean winnerFound = false;

    public ThreadCountry(String name, RobotPart[] partsNeeded) {
        this.name = name;
        this.partsNeeded = partsNeeded;
        this.robot = new Robot(); // Создаем отдельного робота для каждой страны
    }

    @Override
    public void run() {
        try {
            while (!winnerFound) {
                Thread.sleep(500); // Имитируем время производства части
                synchronized (robot) {
                    if (!winnerFound) {
                        RobotPart currentPart = getRandomPart();
                        System.out.println(name + " получила часть: " + currentPart);
                        robot.addPart();
                        if (robot.isComplete()) {
                            totalRobots++;
                            System.out.println(name + " собрала робота " + totalRobots);
                            robot.resetPartsCollected(); // Сбрасываем счетчик частей для сборки следующего робота
                        }
                        if (totalRobots >= 20) {
                            winnerFound = true;
                            System.out.println(name + " собрала армию и победила!");
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения случайной части
    private RobotPart getRandomPart() {
        int randomIndex = (int) (Math.random() * partsNeeded.length);
        return partsNeeded[randomIndex];
    }
}
