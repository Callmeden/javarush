package com.javarush.task.task34.task3410.model;


public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        boolean result = false;
        int moveSize = Model.FIELD_CELL_SIZE;
        switch(direction){
            case UP: if(gameObject.y == y-moveSize && gameObject.x == x) result = true; break;
            case DOWN: if(gameObject.y == y+moveSize    && gameObject.x == x) result = true; break;
            case LEFT: if(gameObject.y == y && gameObject.x == x-moveSize) result = true; break;
            case RIGHT: if(gameObject.y == y && gameObject.x == x+moveSize) result = true; break;
        }
        return result;
    }


}
