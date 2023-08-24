package com.mygdx.the_choice;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.the_choice.map.MapGenerator;
import com.badlogic.gdx.Gdx;
import com.mygdx.the_choice.object.Player;
import com.mygdx.the_choice.object.PlayerProcessor;


public class TheChoice extends ApplicationAdapter {
	private ShapeRenderer shapeRenderer; // ShapeRenderer 객체 추가
	private MapGenerator mapGenerator; // MapGenerator 객체 추가
	private PlayerProcessor playerProcessor; // playerProcessor 객체 추가
	
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer(); // ShapeRenderer 객체 생성
		mapGenerator = new MapGenerator(); // MapGenerator 객체 생성
		playerProcessor = new PlayerProcessor(mapGenerator.getMapTiles()); // PlayerProcessor 객체 생성
		Gdx.input.setInputProcessor(playerProcessor);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		// Player 위치 가져오기
		Player player = playerProcessor.getPlayer();
		int playerX = player.getPlayerX();
		int playerY = player.getPlayerY();

		// Map Generator
		// 화면을 빨간색으로 지우기
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// ShapeRenderer로 지도 타일 그리기
		int[][] mapTiles = mapGenerator.getMapTiles();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.GREEN); // 0인 타일은 녹색으로 그리기
		for (int row = 0; row < mapTiles.length; row++) {
			for (int col = 0; col < mapTiles[0].length; col++) {
				int weightX_1 = Gdx.graphics.getWidth()/4 - (mapGenerator.getTileSize()*mapTiles[0].length/2);
				int weightX_2 = Gdx.graphics.getWidth()/4*3 - (mapGenerator.getTileSize()*mapTiles[0].length/2);
				int weightY = Gdx.graphics.getHeight()/2 - (mapGenerator.getTileSize()*mapTiles[0].length/2);

				if(row==playerX&&col==playerY){
					shapeRenderer.setColor(Color.BLUE);
				} else if (mapTiles[row][col] == 0) { // 0인 타일은 녹색으로 그리기
					shapeRenderer.setColor(Color.GREEN);
				} else { // 1인 타일은 검은색으로 그리기
					shapeRenderer.setColor(Color.BLACK);
				}

				shapeRenderer.rect(col * mapGenerator.getTileSize() + weightX_1, row * mapGenerator.getTileSize() + weightY, mapGenerator.getTileSize(), mapGenerator.getTileSize());
				shapeRenderer.rect(col * mapGenerator.getTileSize() + weightX_2, row * mapGenerator.getTileSize() + weightY, mapGenerator.getTileSize(), mapGenerator.getTileSize());
			}
		}
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}
}
