package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("D:\\JavaRush tasks\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restart();
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(Wall wall:getGameObjects().getWalls())
            if(gameObject.isCollision(wall,direction))
                return true;
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction){
        for(Box box:getGameObjects().getBoxes())
            if(getGameObjects().getPlayer().isCollision(box,direction)) {
                for (Box nextBox : getGameObjects().getBoxes())
                    if(box.isCollision(nextBox,direction))
                        return true;
                if(checkWallCollision(box,direction))
                        return true;
                switch (direction){
                    case UP: box.move(0,-FIELD_CELL_SIZE); break;
                    case DOWN: box.move(0,FIELD_CELL_SIZE); break;
                    case RIGHT: box.move(FIELD_CELL_SIZE,0); break;
                    case LEFT: box.move(-FIELD_CELL_SIZE,0); break;
                }
            }
        return false;
    }

    public void checkCompletion(){
        boolean isLvlCompleted = true;
        for(Box box : getGameObjects().getBoxes()) {
            boolean isBoxOnPlace = false;
            for (Home home : getGameObjects().getHomes())
                if(home.getX()==box.getX() && home.getY()==box.getY()) {
                    isBoxOnPlace = true;
                    break;
                }
            if(!isBoxOnPlace){
                isLvlCompleted = false;
                break;
            }
        }
        if(isLvlCompleted)
            eventListener.levelCompleted(currentLevel);
    }

    public void move(Direction direction) {
        if(checkWallCollision(getGameObjects().getPlayer(),direction))
            return;
        if(checkBoxCollisionAndMoveIfAvailable(direction))
            return;
        Player player = getGameObjects().getPlayer();
        switch(direction){
            case UP: player.move(0,-FIELD_CELL_SIZE); break;
            case DOWN: player.move(0,FIELD_CELL_SIZE);break;
            case RIGHT: player.move(FIELD_CELL_SIZE,0);break;
            case LEFT: player.move(-FIELD_CELL_SIZE,0);break;
        }
        checkCompletion();
    }

}
