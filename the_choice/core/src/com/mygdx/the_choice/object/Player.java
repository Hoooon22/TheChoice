package com.mygdx.the_choice.object;

public class Player {
    private int playerX; // 플레이어의 x 좌표
    private int playerY; // 플레이어의 y 좌표



    public Player(int playerX, int playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
    }

    //getter
    public int getPlayerX() {
        return playerX;
    }
    public int getPlayerY() {
        return playerY;
    }

    //setter
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }
}
