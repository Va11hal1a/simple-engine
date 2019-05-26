package engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class main_menu extends ScreenAdapter{
	SpriteBatch batch;
	TextButton btnPlay;
	TextButton btnOptions;
	TextButton btnExit;
	Stage stg;
	public main_menu() {
		btnPlay = new TextButton("Play", AssetLoader.skinUI);
		btnPlay.setPosition(50, 100);
		btnOptions = new TextButton("Options", AssetLoader.skinUI);
		btnOptions.setPosition(50, 70);
		btnExit = new TextButton("Exit", AssetLoader.skinUI);
		btnExit.setPosition(50, 40);
		stg.addActor(btnPlay);
		stg.addActor(btnOptions);
		stg.addActor(btnExit);
		batch = new SpriteBatch();
		stg = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
	}
	public void render(float delta) {
		batch.begin();
		stg.draw();
		batch.end();
	}
}
