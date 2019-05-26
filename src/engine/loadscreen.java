package engine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import abstractObjects.text;
import animations.fadein;
import animations.fadeout;
import objects.singletest;
import utils.timer;

public class loadscreen extends ScreenAdapter{
	SpriteBatch batch;
	singletest logo;
	text text;
	text x;
	scene cur;
	public loadscreen(Game gm) {
		AssetLoader.init();
		timer.init();
		batch = new SpriteBatch();
		x = new text(batch, "test", 100, 100);
		logo = new singletest(0, 0, "logo.jpg");
		logo.batch = batch;
		logo.w = Gdx.graphics.getWidth();
		logo.h = Gdx.graphics.getHeight();
		text = new text(batch, "presents", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		text.visible = false;
		logo.add(new fadeout(null, 2f).set(()
				-> logo.add(new fadein(null, 2f).set(
						() -> {text.visible = true; text.add(new fadeout(null, 2f).set(
								()-> text.add(new fadein(null, 2f)).set(
										() -> System.out.print("aa"))));}))));
		}
	public void setscene(scene scn) {
		this.cur = scn;
		this.cur.update();
	}
	public void render(float delta) {
		Gdx.gl20.glClearColor(1, 1, 1, 1);
		Gdx.gl20.glClear(GL20.GL_ALPHA_BITS);
		timer.update();
		batch.begin();
		logo.update();
		text.update();
		batch.end();
	}
}
