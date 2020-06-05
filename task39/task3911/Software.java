package com.javarush.task.task39.task3911;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if(!versionHistoryMap.containsKey(rollbackVersion))
            return false;

        currentVersion = rollbackVersion;
        Map<Integer,String> copy = new LinkedHashMap<>();

        Iterator<Map.Entry<Integer,String>> iterator = versionHistoryMap.entrySet().iterator();
        while(iterator.hasNext()) {
           Integer key = iterator.next().getKey();
           String value = versionHistoryMap.get(key);

           copy.put(key,value);
           if(key==currentVersion)
               break;
        }

        versionHistoryMap = copy;
        return true;
    }
}
