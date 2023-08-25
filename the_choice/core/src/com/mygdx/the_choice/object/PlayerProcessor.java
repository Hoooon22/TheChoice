package com.mygdx.the_choice.object;

import com.badlogic.gdx.InputProcessor;

public class PlayerProcessor implements InputProcessor {
    private int[][] infoMap;
    private Player player;
    private int pressKeyFrame = 0;
    private boolean leftMove;
    private boolean rightMove;
    private boolean upMove;
    private boolean downMove;
    private final int moveDelay = 6; // 몇 frame마다 플레이어를 이동을 할지
    private int countRender = 0;

    public PlayerProcessor(int[][] infoMap) {
        this.infoMap = infoMap;
        int[] playerLocation = checkMapToPlayer(infoMap);
        this.player = new Player(playerLocation[0],playerLocation[1]);
    }

    //플레이어의 초기 위치를 정해주는 함수
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

    //getter
    public Player getPlayer() {
        return player;
    }

    public void updateMotion(){
        if(leftMove){
            countRender++;
            if(countRender<moveDelay){
                return;
            }
            if(player.getPlayerY()<=0){
                return;
            }
            if(infoMap[player.getPlayerX()][player.getPlayerY()-1]!=0){
                return;
            }
            player.setPlayerY(player.getPlayerY()-1);
            countRender=0;
        }
        if(rightMove){
            countRender++;
            if(countRender<moveDelay){
                return;
            }
            if(player.getPlayerY()>=infoMap[0].length-1){
                return;
            }
            if(infoMap[player.getPlayerX()][player.getPlayerY()+1]!=0){
                return;
            }
            player.setPlayerY(player.getPlayerY()+1);
            countRender=0;
        }
        if(upMove){
            countRender++;
            if(countRender<moveDelay){
                return;
            }
            if(player.getPlayerX()>=infoMap.length-1){
                return;
            }
            if(infoMap[player.getPlayerX()+1][player.getPlayerY()]!=0){
                return;
            }
            player.setPlayerX(player.getPlayerX()+1);
            countRender=0;
        }
        if(downMove){
            countRender++;
            if(countRender<moveDelay){
                return;
            }
            if(player.getPlayerX()<=0){
                return;
            }
            if(infoMap[player.getPlayerX()-1][player.getPlayerY()]!=0){
                return;
            }
            player.setPlayerX(player.getPlayerX()-1);
            countRender=0;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case 19:
                upMove = true;
                break;
            case 20:
                downMove = true;
                break;
            case 21:
                leftMove = true;
                break;
            case 22:
                rightMove = true;
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case 19:
                upMove = false;
                break;
            case 20:
                downMove = false;
                break;
            case 21:
                leftMove = false;
                break;
            case 22:
                rightMove = false;
                break;
        }
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
