package io.github.vikie1.portfolio.projects.learnFromVictor.error;

public class DatabaseWriteError extends Error {
    public DatabaseWriteError(String message) {
        super("Could not write item to database due to : \n" + message);
    }
}
