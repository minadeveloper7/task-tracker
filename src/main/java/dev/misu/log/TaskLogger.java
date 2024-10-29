package dev.misu.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TaskLogger {

    private static Logger logger = Logger.getLogger(TaskLogger.class.getName());

    static {
        try {
            Logger rootLogger = Logger.getLogger("");
            for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
                rootLogger.removeHandler(handler);
            }

            FileHandler fileHandler = new FileHandler("task_manager.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }

}
