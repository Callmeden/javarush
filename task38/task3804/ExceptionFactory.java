package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getNeededException(Enum e){
        Throwable exception= new IllegalArgumentException();

        if(e instanceof ApplicationExceptionMessage){
            if (ApplicationExceptionMessage.SOCKET_IS_CLOSED.equals(e))
                exception = new Exception("Socket is closed");
             else if (ApplicationExceptionMessage.UNHANDLED_EXCEPTION.equals(e))
                exception = new Exception("Unhandled exception");
        }

        else if(e instanceof DatabaseExceptionMessage){
            if (DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT.equals(e))
                exception = new RuntimeException("No result due to timeout");
            else if(DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS.equals(e))
                exception = new RuntimeException("Not enough connections");
        }

        else if(e instanceof UserExceptionMessage){
            if(UserExceptionMessage.USER_DOES_NOT_EXIST.equals(e))
                exception = new Error("User does not exist");
            else if(UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS.equals(e))
                exception = new Error("User does not have permissions");
        }

        return exception;
    }
}
