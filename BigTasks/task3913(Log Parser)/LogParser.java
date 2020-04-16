package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private List<File> logFiles;
    private List<LogEntry> logEntries;

    public LogParser(Path logDir) {
        this.logFiles = getLogFiles(logDir);
        this.logEntries = getLogEntries(this.logFiles);
    }

    private static List<File> getLogFiles(Path logDir){
        List<File> files = new ArrayList<>();

        try(Stream<Path> paths = Files.list(logDir)){
            paths.filter(Files::isRegularFile)
                    .filter(e -> e.toString().endsWith(".log"))
                    .forEach(e -> files.add(e.toFile()));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return files;
    }

    private List<LogEntry> getLogEntries(List<File> logs){
        List<LogEntry> list = new ArrayList<>();

        for(File log:logs) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(log)))) {
                List<String> allCurrentLogEntries = reader.lines().collect(Collectors.toList());

                for(String currentLine: allCurrentLogEntries){
                    String[] lineData = currentLine.split("\t");
                    list.add(new LogEntry(lineData));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public List<LogEntry> getLogEntriesInGivenPeriodOfTime(Date after,Date before){
        Long longAfter = getAfterLongDate(after);
        Long longBefore = getBeforeLongDate(before);

        return logEntries.stream().filter(e -> e.getDate() >= longAfter && e.getDate() <= longBefore)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);
    }

    private static Long getAfterLongDate(Date after){
        return after == null ? Long.MIN_VALUE : after.getTime();
    }

    private static Long getBeforeLongDate(Date before){
        return before == null ? Long.MAX_VALUE : before.getTime();
    }

    //Реализация IPQuery

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after,before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getIp()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .filter(e -> e.getUser().equals(user))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getIp()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .filter(e -> e.getEvent().equals(event))
                .collect(
                        HashSet::new,
                        (set, item) -> set.add(item.getIp()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .filter(e -> e.getStatus().equals(status))
                .collect(
                        HashSet::new,
                        (set, item) -> set.add(item.getIp()),
                        HashSet::addAll
                );
    }

    //Реализация UserQuery

    @Override
    public Set<String> getAllUsers() {
        return getLogEntries()
                .stream()
                .collect(
                        HashSet::new,
                        (set, item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                )
                .size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getEvent()),
                        HashSet::addAll
                )
                .size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getIp().equals(ip))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.LOGIN))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .collect(
                        HashSet::new,
                        (set, item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.WRITE_MESSAGE))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.SOLVE_TASK))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.SOLVE_TASK) && e.getTaskNumber().equals(task))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DONE_TASK))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DONE_TASK) && e.getTaskNumber().equals(task))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getUser()),
                        HashSet::addAll
                );
    }

    //Реализация DateQuery

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {

        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user) && e.getEvent().equals(event))
                .collect(
                        HashSet::new,
                        (set, item) -> set.add(new Date(item.getDate())),
                        HashSet::addAll
                );
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getStatus().equals(Status.FAILED))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(new Date(item.getDate())),
                        HashSet::addAll
                );
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getStatus().equals(Status.ERROR))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(new Date(item.getDate())),
                        HashSet::addAll
                );
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<Long> dates = getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user) && e.getEvent().equals(Event.LOGIN))
                .collect(
                        ArrayList::new,
                        (list,item) -> list.add(item.getDate()),
                        ArrayList::addAll
                );
        Collections.sort(dates);
        return dates.size()>0 ? new Date(dates.get(0)) : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<Long> dates = getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user) && e.getEvent().equals(Event.SOLVE_TASK) && e.getTaskNumber().equals(task))
                .collect(
                        ArrayList::new,
                        (list, item) -> list.add(item.getDate()),
                        ArrayList::addAll
                );
        Collections.sort(dates);
        return dates.size()>0 ? new Date(dates.get(0)) : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<Long> dates = getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user) && e.getEvent().equals(Event.DONE_TASK) && e.getTaskNumber().equals(task))
                .collect(
                        ArrayList::new,
                        (list, item) -> list.add(item.getDate()),
                        ArrayList::addAll
                );
        Collections.sort(dates);
        return dates.size()>0 ? new Date(dates.get(0)) : null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user) && e.getEvent().equals(Event.WRITE_MESSAGE))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(new Date(item.getDate())),
                        HashSet::addAll
                );
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user) && e.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(new Date(item.getDate())),
                        HashSet::addAll
                );
    }

    //реализация EventQuery

    public int getNumberOfAttemptToDoneTask(int task, Date after, Date before){
        return (int) getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DONE_TASK) && e.getTaskNumber().equals(task)).count();
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getEvent()),
                        HashSet::addAll
                ).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getEvent()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getIp().equals(ip))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getEvent()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getUser().equals(user))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getEvent()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e-> e.getStatus().equals(Status.FAILED))
                .collect(
                        HashSet::new,
                        (set,item) -> set.add(item.getEvent()),
                        HashSet::addAll
                );
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getStatus().equals(Status.ERROR))
                .collect(
                        HashSet::new,
                        (set,item)-> set.add(item.getEvent()),
                        HashSet::addAll
                );
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e-> e.getEvent().equals(Event.SOLVE_TASK) && e.getTaskNumber().equals(task))
                .collect(
                        HashSet::new,
                        HashSet::add,
                        HashSet::addAll
                ).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after,before)
                .stream()
                .filter(e->e.getEvent().equals(Event.DONE_TASK) && e.getTaskNumber().equals(task))
                .collect(
                        HashSet::new,
                        HashSet::add,
                        HashSet::addAll
                ).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.SOLVE_TASK))
                .collect(
                        HashMap::new,
                        (map,item) -> map.put(item.getTaskNumber(),getNumberOfAttemptToSolveTask(item.getTaskNumber(),after,before)),
                        HashMap::putAll
                );
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getLogEntriesInGivenPeriodOfTime(after, before)
                .stream()
                .filter(e -> e.getEvent().equals(Event.DONE_TASK))
                .collect(
                        HashMap::new,
                        (map,item) -> map.put(item.getTaskNumber(),getNumberOfAttemptToDoneTask(item.getTaskNumber(),after,before)),
                        HashMap::putAll
                );
    }

    //реализация QLQuery

    private Set<Object> getSetForAllUsers(String field) {
        HashSet<Object> resultSet = new HashSet<>();

        switch(field){
            case "ip" : resultSet.addAll(getUniqueIPs(null,null)); break;
            case "user" : resultSet.addAll(getAllUsers()); break;
            case "date" : resultSet.addAll(
                    getLogEntries()
                    .stream()
                    .collect(
                            HashSet::new,
                            (set, item) -> set.add(new Date(item.getDate())),
                            HashSet::addAll
                    )
            ); break;
            case "event" : resultSet.addAll(getAllEvents(null,null)); break;
            case "status" : resultSet.addAll(
                    getLogEntries()
                    .stream()
                    .collect(
                            HashSet::new,
                            (set,item) -> set.add(item.getStatus()),
                            HashSet::addAll
                    )
            ); break;
        }

        return resultSet;
    }

    private Object getValueByField(LogEntry entry, String field){
        switch (field){
            case "ip": return entry.getIp();
            case "user": return entry.getUser();
            case "date": return new Date(entry.getDate());
            case "event": return entry.getEvent();
            case "status": return entry.getStatus();
        }
        return null;
    }

    @Override
    public Set<Object> execute(String query) {
        String[] queryWords = query.split(" ",6);
        Set<Object> resultSet = new HashSet<>();
        String field1, field2, value1, stringAfter, stringBefore;


        if(queryWords.length == 2 || queryWords[2]==null)
            resultSet.addAll(getSetForAllUsers(queryWords[1]));
        else if(!queryWords[5].contains("and date between")) {
            queryWords = query.split(" ",6);
            if (queryWords.length > 2) {
                field1 = queryWords[1];
                field2 = queryWords[3];
                value1 = queryWords[5].substring(1, queryWords[5].length() - 1); // обрезаем кавычки

                if (field1.equals(field2))
                    return resultSet;

                for (LogEntry logEntry : getLogEntries()) {
                    switch (field2) {
                        case "ip":
                            if (logEntry.getIp().equals(value1))
                                resultSet.add(getValueByField(logEntry, field1));
                            break;
                        case "user":
                            if (logEntry.getUser().equals(value1))
                                resultSet.add(getValueByField(logEntry, field1));
                            break;
                        case "date":
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
                            Date date = null;

                            try {
                                date = dateFormat.parse(value1);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            if (date!=null && logEntry.getDate().equals(date.getTime()))
                                resultSet.add(getValueByField(logEntry, field1));
                            break;
                        case "event":
                            Event event = null;
                            switch (value1) {
                                case "LOGIN":
                                    event = Event.LOGIN;
                                    break;
                                case "DOWNLOAD_PLUGIN":
                                    event = Event.DOWNLOAD_PLUGIN;
                                    break;
                                case "WRITE_MESSAGE":
                                    event = Event.WRITE_MESSAGE;
                                    break;
                                case "SOLVE_TASK":
                                    event = Event.SOLVE_TASK;
                                    break;
                                case "DONE_TASK":
                                    event = Event.DONE_TASK;
                                    break;
                            }
                            if (logEntry.getEvent().equals(event))
                                resultSet.add(getValueByField(logEntry, field1));
                            break;
                        case "status":
                            Status status = null;
                            switch (value1) {
                                case "OK":
                                    status = Status.OK;
                                    break;
                                case "FAILED":
                                    status = Status.FAILED;
                                    break;
                                case "ERROR":
                                    status = Status.ERROR;
                                    break;
                            }
                            if (logEntry.getStatus().equals(status))
                                resultSet.add(getValueByField(logEntry, field1));
                            break;
                    }
                }
            }
        }
        else {
            queryWords = query.split(" ",6);
            field1 = queryWords[1];
            field2 = queryWords[3];
            value1 = queryWords[5].substring(1, queryWords[5].indexOf("and date between")-2);
            stringAfter = queryWords[5].substring(queryWords[5].lastIndexOf("between")+9,
                                                    queryWords[5].lastIndexOf("and")-2);
            stringBefore = queryWords[5].substring(queryWords[5].lastIndexOf("and")+5,
                                                        queryWords[5].length()-1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            Date after = null;
            Date before = null;

            try {
                after = dateFormat.parse(stringAfter);
                before = dateFormat.parse(stringBefore);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (field1.equals(field2))
                return resultSet;

            for (LogEntry logEntry : getLogEntriesInGivenPeriodOfTime(after,before)) {
                if(logEntry.getDate().equals(after.getTime()) || logEntry.getDate().equals(before.getTime()))
                    continue;
                switch (field2) {
                    case "ip":
                        if (logEntry.getIp().equals(value1))
                            resultSet.add(getValueByField(logEntry, field1));
                        break;
                    case "user":
                        if (logEntry.getUser().equals(value1))
                            resultSet.add(getValueByField(logEntry, field1));
                        break;
                    case "date":
                        Date date = null;

                        try {
                            date = dateFormat.parse(value1);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date!=null && logEntry.getDate().equals(date.getTime()))
                            resultSet.add(getValueByField(logEntry, field1));
                        break;
                    case "event":
                        Event event = null;
                        switch (value1) {
                            case "LOGIN":
                                event = Event.LOGIN;
                                break;
                            case "DOWNLOAD_PLUGIN":
                                event = Event.DOWNLOAD_PLUGIN;
                                break;
                            case "WRITE_MESSAGE":
                                event = Event.WRITE_MESSAGE;
                                break;
                            case "SOLVE_TASK":
                                event = Event.SOLVE_TASK;
                                break;
                            case "DONE_TASK":
                                event = Event.DONE_TASK;
                                break;
                        }
                        if (logEntry.getEvent().equals(event))
                            resultSet.add(getValueByField(logEntry, field1));
                        break;
                    case "status":
                        Status status = null;
                        switch (value1) {
                            case "OK":
                                status = Status.OK;
                                break;
                            case "FAILED":
                                status = Status.FAILED;
                                break;
                            case "ERROR":
                                status = Status.ERROR;
                                break;
                        }
                        if (logEntry.getStatus().equals(status))
                            resultSet.add(getValueByField(logEntry, field1));
                        break;
                }
            }
        }
        return resultSet;
    }

    private class LogEntry {
        String ip;
        String user;
        Long date;
        Event event;
        Integer taskNumber;
        Status status;

        public LogEntry(String ip, String user, String date, String event, String status) {
            this.ip = ip;
            this.user = user;
            this.date = parseDate(date);
            this.event = parseEvent(event);
            this.status = parseStatus(status);
        }

        public LogEntry(String[] data) {
            this(data[0], data[1], data[2], data[3], data[4]);
        }

        private Long parseDate(String string) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            Date date = null;

            try {
                date = dateFormat.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return date != null ? date.getTime() : -1L;
        }

        private Event parseEvent(String string) {
            if (string.contains("LOGIN")) {
                return Event.LOGIN;
            }

            if (string.contains("DOWNLOAD_PLUGIN")) {
                return Event.DOWNLOAD_PLUGIN;
            }

            if (string.contains("WRITE_MESSAGE")) {
                return Event.WRITE_MESSAGE;
            }

            if (string.contains("SOLVE_TASK")) {
                this.taskNumber = getTaskNumber(string);
                return Event.SOLVE_TASK;
            }

            if (string.contains("DONE_TASK")) {
                this.taskNumber = getTaskNumber(string);
                return Event.DONE_TASK;
            }

            return null;
        }

        private Integer getTaskNumber(String event) {
            Integer result = null;

            String[] array = event.split(" ");

            if (array.length > 1) {
                result = Integer.parseInt(array[1]);
            }

            return result;
        }

        private Status parseStatus(String string) {
            switch (string) {
                case "OK":
                    return Status.OK;
                case "FAILED":
                    return Status.FAILED;
                case "ERROR":
                    return Status.ERROR;
            }

            return null;
        }

        public String getIp() {
            return ip;
        }

        public String getUser() {
            return user;
        }

        public Long getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public Integer getTaskNumber() {
            return taskNumber;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "ip='" + ip + '\'' +
                    ", user='" + user + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", status=" + status +
                    '}';
        }

    }

    public List<File> getLogFiles() {
        return logFiles;
    }

    public List<LogEntry> getLogEntries() {
        return logEntries;
    }
}