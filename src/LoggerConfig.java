import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerConfig {
    public static void configureLogging() {
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();

        // Удаляем существующие обработчики, чтобы избежать дублирования
        for (Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }

        // Добавляем новый обработчик с необходимым уровнем
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO); // Установите необходимый уровень
        rootLogger.addHandler(consoleHandler);

        // Устанавливаем общий уровень логирования
        rootLogger.setLevel(Level.INFO);
    }
}
