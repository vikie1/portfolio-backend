package io.github.vikie1.portfolio.projects.betterdevs.error;

public class InvalidDataError extends Error{
    public InvalidDataError(String message){
        super("An error occurred, here is the description : \n" + message);
    }
}
