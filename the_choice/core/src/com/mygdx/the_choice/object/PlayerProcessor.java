package com.mygdx.the_choice.object;

import com.badlogic.gdx.InputProcessor;

public class PlayerProcessor implements InputProcessor {
    private int[][] infoMap;
    private Player player;

    public PlayerProcessor(int[][] infoMap) {
        this.infoMap = infoMap;
        int[] playerLocation = checkMapToPlayer(infoMap);
        this.player = new Player(playerLocation[0],playerLocation[1]);
    }

    public int[] checkMapToPlayer(int[][] infoMap){
        int[] playerLocation = new int[2];
        for(int i = 0; i < infoMap.length; i++) {
            for (int j = 0; j < infoMap[i].length; j++) {
                if (this.infoMap[i][j] == 0) {
                    playerLocation[0] = i;
                    playerLocation[1] = j;
                    return playerLocation;
                }
            }
        }
        playerLocation = new int[]{infoMap.length, infoMap[0].length};
        return playerLocation;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case 19:
                if(player.getPlayerX()<9&&infoMap[player.getPlayerX()+1][player.getPlayerY()]==0){
                    player.setPlayerX(player.getPlayerX()+1);
                }
                break;
            case 20:
                if(player.getPlayerX()>0&&infoMap[player.getPlayerX()-1][player.getPlayerY()]==0){
                    player.setPlayerX(player.getPlayerX()-1);
                }
                break;
            case 21:
                if(player.getPlayerY()>0&&infoMap[player.getPlayerX()][player.getPlayerY()-1]==0){
                    player.setPlayerY(player.getPlayerY()-1);
                }
                break;
            case 22:
                if(player.getPlayerY()<9&&infoMap[player.getPlayerX()][player.getPlayerY()+1]==0){
                    player.setPlayerY(player.getPlayerY()+1);
                }
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
