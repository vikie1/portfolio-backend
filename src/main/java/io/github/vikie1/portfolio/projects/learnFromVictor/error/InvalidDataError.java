package io.github.vikie1.portfolio.projects.learnFromVictor.error;

public class InvalidDataError extends Error{
    public InvalidDataError(String message){
        super("An error occurred, here is the description : \n" + message);
    }
}
