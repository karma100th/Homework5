import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Создаем страны и задаем, какие части им нужны
        RobotPart[] country1Parts = {
                RobotPart.LEFT_ARM, RobotPart.RIGHT_ARM,
                RobotPart.LEFT_LEG, RobotPart.RIGHT_LEG,
                RobotPart.BODY, RobotPart.HEAD
        };
        ThreadCountry country1 = new ThreadCountry("Страна 1", country1Parts);

        RobotPart[] country2Parts = {
                RobotPart.LEFT_ARM, RobotPart.RIGHT_ARM,
                RobotPart.LEFT_LEG, RobotPart.RIGHT_LEG,
                RobotPart.BODY, RobotPart.HEAD
        };
        ThreadCountry country2 = new ThreadCountry("Страна 2", country2Parts);

        // Запускаем страны на выполнение в отдельных потоках
        executor.submit(country1);
        executor.submit(country2);

        // Задаем время ожидания пока одна из стран не победит
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

