package com.javarush.task.task35.task3513;

import java.util.*;


public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int maxTile;
    int score;

    private Stack<Tile[][]> previousStates=new Stack<>();
    private Stack<Integer> previousScores=new Stack<>();
    private boolean isSaveNeeded=true;


    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        maxTile = 0;
        score = 0;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }

    public boolean canMove() {
        if ( ! getEmptyTiles().isEmpty() )
            return true;

        for (int row = 0; row < gameTiles.length - 1; row++) {
            for (int column = 0; column < gameTiles.length - 1; column++) {
                int currentTileValue = gameTiles[row][column].value;

                if (currentTileValue == 0
                        || currentTileValue == gameTiles[row][column + 1].value
                        || currentTileValue == gameTiles[row + 1][column].value) {
                    return true;
                }
            }
        }

        for (int column = 0; column < gameTiles.length - 1; column++) {
            int currentTileValue = gameTiles[gameTiles.length - 1][column].value;

            if (currentTileValue == 0 || currentTileValue == gameTiles[gameTiles.length - 1][column + 1].value)
                return true;
        }

        for (int row = 0; row < gameTiles.length - 1; row++) {
            int currentTileValue = gameTiles[row][gameTiles.length - 1].value;

            if (currentTileValue == 0 || currentTileValue == gameTiles[row + 1][gameTiles.length - 1].value)
                return true;
        }

        return false;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();

        for (Tile[] tiles : gameTiles) {
            for (Tile tile : tiles) {
                if (tile.isEmpty()) {
                    emptyTiles.add(tile);
                }
            }
        }

        return emptyTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            emptyTiles.get((int) (Math.random() * emptyTiles.size())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles){
        List<Tile> emptyTiles = new ArrayList<>();
        List<Tile> nonEmptyTiles = new ArrayList<>();

        boolean isChanged = false;

        for (Tile tile : tiles) {
            if (tile.isEmpty()) {
                emptyTiles.add(tile);
            } else {
                nonEmptyTiles.add(tile);
            }
        }

        Tile[] newTiles = new Tile[tiles.length];

        for (int i = 0; i < nonEmptyTiles.size(); i++) {
            newTiles[i] = nonEmptyTiles.get(i);
        }

        for (int i = 0; i < emptyTiles.size(); i++) {
            newTiles[i + nonEmptyTiles.size()] = emptyTiles.get(i);
        }

        for (int i = 0; i < tiles.length; i++) {
            if (newTiles[i] != tiles[i]) {
                isChanged = true;
                break;
            }
        }

        for (int i = 0; i < newTiles.length; i++) {
            tiles[i] = newTiles[i];
        }

        return isChanged;    }

    private boolean mergeTiles(Tile[] tiles){
        boolean isChanged = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value > 0) {
                isChanged = true;

                tiles[i].value *= 2;
                tiles[i + 1].value = 0;

                score += tiles[i].value;

                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
            }
        }
        compressTiles(tiles);
        return isChanged;
    }

    private void rotate(){
        int length = getGameTiles().length;
        Tile[][] tilesAfterRotate = new Tile[length][length];
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
                tilesAfterRotate[i][j]= getGameTiles()[j][length-i-1];
        gameTiles= tilesAfterRotate;
    }

    void left() {
        boolean hasChanged=false;
        if(isSaveNeeded)
            saveState(gameTiles);
        for (Tile[] tiles : getGameTiles())
            if(compressTiles(tiles)||mergeTiles(tiles))
                hasChanged=true;
        if(hasChanged) addTile();
        isSaveNeeded=true;
    }

    void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    void down(){
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    void up(){
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    private void saveState(Tile[][] tiles){
        int size=tiles.length;

        Tile[][] copy= new Tile[size][size];
        for(int row=0;row<size;row++)
            for(int column=0;column<size;column++) {
                Tile tileCopy = new Tile(tiles[row][column].value);
                copy[row][column]=tileCopy;
            }

        previousScores.push(score);
        previousStates.push(copy);
        isSaveNeeded=false;
    }

    public void rollback(){
        if(!previousScores.isEmpty()&&!previousStates.isEmpty()) {
            score=previousScores.pop();
            gameTiles=previousStates.pop();
        }
    }

    public void randomMove(){
        int n=((int)(Math.random()*100))%4;

        switch(n){
            case 0: left();break;
            case 1: right();break;
            case 2: up();break;
            case 3: down();break;
        }
    }

    public boolean hasBoardChanged(){
        Tile[][] prevGameTiles = previousStates.peek();
        Tile[][] currentGameTiles = gameTiles;

        for (int row = 0; row < gameTiles.length; row++) {
            for (int column = 0; column < gameTiles.length; column++) {
                if (prevGameTiles[row][column].value != currentGameTiles[row][column].value)
                    return true;
            }
        }

        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();

        if (!hasBoardChanged())
            return new MoveEfficiency(-1, 0, move);

        MoveEfficiency result =  new MoveEfficiency(getEmptyTiles().size(), score, move);
        rollback();

        return result;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency>  priorityQueue=
                new PriorityQueue<>(4,Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(this::left));
        priorityQueue.add(getMoveEfficiency(this::right));
        priorityQueue.add(getMoveEfficiency(this::up));
        priorityQueue.add(getMoveEfficiency(this::down));

        priorityQueue.peek().getMove().move();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

}
