package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    public final AdvertisementStorage storage=AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> availableAdvertisements = new ArrayList<>();

        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0)
                availableAdvertisements.add(advertisement);
        }

        if (availableAdvertisements.isEmpty())
            throw new NoVideoAvailableException();

        List<Advertisement> videosToShow = createVideosListForDisplaying(availableAdvertisements);
        videosAmountSorting(videosToShow);

        createStatistic(videosToShow);

        displayingVideos(videosToShow);
    }

    private void createStatistic(List<Advertisement> videosToShow) {
        long amount = 0;
        int totalDuration = 0;

        for (Advertisement advertisement : videosToShow) {
            amount += advertisement.getAmountPerOneDisplaying();
            totalDuration += advertisement.getDuration();
        }

        StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(new VideoSelectedEventDataRow(videosToShow, amount, totalDuration));
    }

    private List<Advertisement> createVideosListForDisplaying(List<Advertisement> availableAdvertisements) {
        List<List<Advertisement>> videosLists = createAllVideosSets(availableAdvertisements);

        videosLists = removeTooLongVideosSets(videosLists);
        videosLists = toChooseTheExpensiveSets(videosLists);
        videosLists = toChooseSetsLongestByTime(videosLists);

        if (videosLists.size() > 1)
            videosLists = toChooseSmallestSet(videosLists);

        if (videosLists.size() > 0) {
            return videosLists.get(0);
        } else {
            return new ArrayList<>();
        }
    }
    private List<List<Advertisement>> createAllVideosSets(List<Advertisement> availableAdvertisements) {
        List<List<Advertisement>> videosLists = new ArrayList<>();

        for (int i = 0; i < availableAdvertisements.size(); i++) {
            createVideosSetsHelper(videosLists, availableAdvertisements, new ArrayList<>(), i);
        }

        return videosLists;
    }

    private void createVideosSetsHelper(List<List<Advertisement>> videosLists,
                                        List<Advertisement> availableAdvertisements,
                                        List<Advertisement> prevVideosList, int index) {
        List<Advertisement> currentVideosList = new ArrayList<>();

        currentVideosList.addAll(prevVideosList);

        currentVideosList.add(availableAdvertisements.get(index));
        videosLists.add(currentVideosList);

        for(int i = index + 1; i < availableAdvertisements.size(); i++) {
            createVideosSetsHelper(videosLists, availableAdvertisements, currentVideosList, i);
        }
    }

    private List<List<Advertisement>> removeTooLongVideosSets(List<List<Advertisement>> videosLists) {
        List<List<Advertisement>> resultVideosLists = new ArrayList<>();

        for (List<Advertisement> currentVideosList : videosLists) {
            int currentOrderTime = 0;

            for (Advertisement advertisement : currentVideosList) {
                currentOrderTime += advertisement.getDuration();
            }

            if (currentOrderTime <= timeSeconds) {
                resultVideosLists.add(currentVideosList);
            }
        }

        return resultVideosLists;
    }

    private List<List<Advertisement>> toChooseTheExpensiveSets(List<List<Advertisement>> videosLists) {
        long maxProfit = 0;

        for (List<Advertisement> currentVideosList : videosLists) {
            long currentProfit = 0;

            for (Advertisement advertisement : currentVideosList) {
                currentProfit += advertisement.getAmountPerOneDisplaying();
            }

            if (currentProfit > maxProfit)
                maxProfit = currentProfit;
        }

        List<List<Advertisement>> maxProfitLists = new ArrayList<>();

        for (List<Advertisement> currentVideosList : videosLists) {
            long currentProfit = 0;

            for (Advertisement advertisement : currentVideosList) {
                currentProfit += advertisement.getAmountPerOneDisplaying();
            }

            if (currentProfit == maxProfit)
                maxProfitLists.add(currentVideosList);
        }

        return maxProfitLists;
    }

    private List<List<Advertisement>> toChooseSetsLongestByTime(List<List<Advertisement>> videosLists) {
        int maxDuration = 0;

        for (List<Advertisement> currentVideosList : videosLists) {
            int currentDuration = 0;

            for (Advertisement advertisement : currentVideosList) {
                currentDuration += advertisement.getDuration();
            }

            if (currentDuration > maxDuration) {
                maxDuration = currentDuration;
            }
        }

        List<List<Advertisement>> maxDurationLists = new ArrayList<>();

        for (List<Advertisement> currentVideosList : videosLists) {
            int currentDuration = 0;

            for (Advertisement advertisement : currentVideosList) {
                currentDuration += advertisement.getDuration();
            }

            if (currentDuration == maxDuration) {
                maxDurationLists.add(currentVideosList);
            }
        }

        return maxDurationLists;
    }

    private List<List<Advertisement>> toChooseSmallestSet(List<List<Advertisement>> videosLists) {
        int minVideosCount = Integer.MAX_VALUE;

        for (List<Advertisement> currentVideosList : videosLists) {
            if (currentVideosList.size() < minVideosCount)
                minVideosCount = currentVideosList.size();
        }

        List<List<Advertisement>> smallestLists = new ArrayList<>();

        for (List<Advertisement> currentVideosList : videosLists) {
            if (currentVideosList.size() == minVideosCount)
                smallestLists.add(currentVideosList);
        }

        return smallestLists;
    }

    private void videosAmountSorting(List<Advertisement> videos) {
        Comparator<Advertisement> comparatorPerOneSecond = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long cost1 = o1.getAmountPerOneSecond();
                long cost2 = o2.getAmountPerOneSecond();

                if (cost1 == cost2)
                    return 0;

                if (cost1 > cost2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Comparator<Advertisement> comparatorPerOneDisplaying = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long cost1 = o1.getAmountPerOneDisplaying();
                long cost2 = o2.getAmountPerOneDisplaying();

                if (cost1 == cost2)
                    return comparatorPerOneSecond.compare(o1, o2);

                if (cost1 > cost2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Collections.sort(videos, comparatorPerOneDisplaying);
    }

    private void displayingVideos(List<Advertisement> videos) {
        for (Advertisement video : videos) {
            ConsoleHelper.writeMessage(video.toString());
            video.revalidate();
        }
    }


    /* public void processVideos(){
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();
        List<Advertisement> video= new ArrayList<>();
        for(Object video1:storage.list()){
            Advertisement adv = (Advertisement) video1;
            video.add(adv);
        }
        Collections.sort(video, (Comparator.comparingInt(Advertisement::getDuration)));
        Collections.sort(video,((o1, o2) -> (int)(o1.getAmountPerOneDisplaying()-o2.getAmountPerOneDisplaying())));
        Collections.reverse(video);
        int freeTime = timeSeconds;
      long amount = 0;
      int totalDuration = 0;
      for(Advertisement vid:video){
          amount+=vid.getAmountPerOneDisplaying();
          totalDuration+=vid.getDuration();
      }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(video,amount,totalDuration));
        for(Advertisement vid:video)
            if(vid.getDuration()<=freeTime && vid.getAmountPerOneDisplaying()>0){
                System.out.println(vid.getName()+" is displaying... "+vid.getAmountPerOneDisplaying()
                        +", "+vid.getAmountPerOneDisplaying()*1000/vid.getDuration());
                vid.revalidate();
                freeTime-=vid.getDuration();
            }

    }*/

}
