package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    private StatisticManager statisticManager=StatisticManager.getInstance();
    private StatisticAdvertisementManager statisticAdvertisementManager=StatisticAdvertisementManager.getInstance();


    public void printAdvertisementProfit() {
        Map<Date, Long> allAdvertisementStatistic = statisticManager.getAdvertisementStatistic();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        long totalAmount = 0;

        for (Map.Entry<Date, Long> entry : allAdvertisementStatistic.entrySet()) {
            long amount = entry.getValue();
            totalAmount += amount;

            String stringAmount = String.valueOf(amount);
            String amountInOrderCurrency = stringAmount.substring(0, stringAmount.length() - 2);
            String amountInCoins = stringAmount.substring(stringAmount.length() - 2);

            String currentDate = dateFormat.format(entry.getKey());

            ConsoleHelper.writeMessage(String.format("%s - %s.%s", currentDate, amountInOrderCurrency, amountInCoins));
        }

        String stringAmount = String.valueOf(totalAmount);
        String totalAmountInOrderCurrency = stringAmount.substring(0, stringAmount.length() - 2);
        String totalAmountInCoins = stringAmount.substring(stringAmount.length() - 2);

        ConsoleHelper.writeMessage(String.format("Total - %s.%s", totalAmountInOrderCurrency, totalAmountInCoins));
    }


    public void printCookWorkloading() {
        Map<Date,Map<String,Integer>> allCooksStatistic = statisticManager.getCooksStatistic();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);

        for(Map.Entry<Date,Map<String,Integer>> entry:allCooksStatistic.entrySet()){
            Date currentDate = entry.getKey();
            ConsoleHelper.writeMessage(dateFormat.format(currentDate));

            Map<String,Integer> cooksMap=entry.getValue();

            for(Map.Entry<String,Integer> cookEntry:cooksMap.entrySet()){
                if(cookEntry.getValue()==0) continue;

                String cookName = cookEntry.getKey();
                int workTimeInMinutes=(cookEntry.getValue()%60==0)?
                        cookEntry.getValue()/60:
                        cookEntry.getValue()/60 + 1;
                ConsoleHelper.writeMessage(cookName+" - "+workTimeInMinutes+" min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    void printActiveVideoSet() {
        List<Advertisement> videoList = statisticAdvertisementManager.getActiveVideoSet();
        videoSorting(videoList);

        for (Advertisement video : videoList) {
            ConsoleHelper.writeMessage(video.getName() + " - " + video.getHits());
        }
    }

    void printArchivedVideoSet() {
        List<Advertisement> videoList = statisticAdvertisementManager.getArchivedVideoSet();
        videoSorting(videoList);

        for (Advertisement video : videoList) {
            ConsoleHelper.writeMessage(video.getName());
        }
    }

    private void videoSorting(List<Advertisement> videosList) {
        Comparator<Advertisement> advertisementComparator = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };

        Collections.sort(videosList, advertisementComparator);
    }
}
