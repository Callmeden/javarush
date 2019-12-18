package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public List<User> getUsers(){
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                User user = new User();
                user.setDescription("SELECT * FROM USER");
                return String.format("%s",user.getDescription());
            }
        }.execute();
    }

    public List<Location> getLocations(){
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                Location location = new Location();
                location.setDescription("SELECT * FROM LOCATION");
                return String.format("%s",location.getDescription());
            }
        }.execute();
    }

    public List<Server> getServers(){
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                Server server = new Server();
                server.setDescription("SELECT * FROM SERVER");
                return String.format("%s",server.getDescription());
            }
        }.execute();
    }

    public List<Subject> getSubjects(){
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                Subject subject = new Subject();
                subject.setDescription("SELECT * FROM SUBJECT");
                return String.format("%s",subject.getDescription());
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions(){
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                Subscription subscription = new Subscription();
                subscription.setDescription("SELECT * FROM SUBSCRIPTION");
                return String.format("%s",subscription.getDescription());
            }
        }.execute();
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
