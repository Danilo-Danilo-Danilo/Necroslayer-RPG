package com.nilo.necroslayer;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.nilo.necroslayer.model.Bloco;
import com.nilo.necroslayer.model.CodeBlock;
import com.nilo.necroslayer.model.Dialogue;
import com.nilo.necroslayer.model.Player;
import com.nilo.necroslayer.screens.Level;
import com.nilo.necroslayer.screens.TitleScreen;
public class Necroslayer extends Game implements ApplicationListener{
	public OrthogonalTiledMapRenderer tMR;
	public TiledMap tiledMap;
	public SpriteBatch batch;
	public Texture texture;
	public Sprite sprite, caixaDialogo;
	public TextureAtlas textureAtlas;
	public Dialogue dialogo;
	private CodeBlock bloco;
	public float elapsedTime = 0;
	float unitScale = 1 / 16f;
	public final int GAME_WORLD_HEIGHT = 576;
	public final int GAME_WORLD_WIDTH = 1024;
	public FitViewport viewport;
	public Player player;
	private ArrayList<Level> levels = new ArrayList<Level>();
	public Level level_1;
	public Bloco[][] blocos;
	
    public OrthographicCamera camera;
	// Debug Info
    

	@Override
	public void create () {
		dialogo = new Dialogue();
		bloco = new CodeBlock();
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("player.atlas"));
		tiledMap = new TmxMapLoader().load("castelo_1.tmx");
		tMR = new OrthogonalTiledMapRenderer(tiledMap, 4);
		camera = new OrthographicCamera();
		camera.update();
		viewport = new FitViewport(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT, camera);
		viewport.apply();
		setScreen(new TitleScreen(this));
	}
	@Override
	public void resize (int width, int height) {
		viewport.update(width, height);
		camera.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_HEIGHT/2, 0);
	}
	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		
	}
	public ArrayList<Level> getLevels() {
		return levels;
	}
	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}
	public CodeBlock getCodeBlock() {
		return bloco;
	}
	public void setCodeBlock(CodeBlock bloco) {
		this.bloco = bloco;
	}
	
}