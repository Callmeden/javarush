package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/
public class Solution {
        public static final class Constants {
            public final static ServerNotAccessibleException SERVER_IS_CURRENTLY_NOT_ACCESSIBLE=new ServerNotAccessibleException();
            public final static UnauthorizedUserException  USER_IS_NOT_AUTHORIZED= new UnauthorizedUserException();
            public final static BannedUserException USER_IS_BANNED= new BannedUserException();
            public final static RestrictionException ACCESS_IS_DENIED= new RestrictionException();
        }

        public static class ServerNotAccessibleException extends Exception {
            public ServerNotAccessibleException() {
                super("The server is currently not accessible.");
            }

            public ServerNotAccessibleException(Throwable cause) {
                super("The server is currently not accessible.", cause);
            }
        }

        public static class UnauthorizedUserException extends Exception {
            public UnauthorizedUserException() {
                super("The user is not authorized.");
            }

            public UnauthorizedUserException(Throwable cause) {
                super("The user is not authorized.", cause);
            }
        }

        public static class BannedUserException extends Exception {
            public BannedUserException() {
                super("The user is banned.");
            }

            public BannedUserException(Throwable cause) {
                super("The user is banned.", cause);
            }
        }

        public static class RestrictionException extends Exception {
            public RestrictionException() {
                super("Access is denied.");
            }

            public RestrictionException(Throwable cause) {
                super("Access is denied.", cause);
            }
        }
    public static void main(String[] args) {

    }
}
