package io.github.vikie1.portfolio.projects.betterdevs.error;

public class DatabaseWriteError extends Error {
    public DatabaseWriteError(String message) {
        super("Could not write item to database due to : \n" + message);
    }
}
