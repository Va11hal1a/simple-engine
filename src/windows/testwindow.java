package windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import cyber_utani_engine.AssetLoader;
import cyber_utani_engine.window;
import utils.timer;
import utils.timer.task_type;

public class testwindow extends window{
	TextButton btn;
	@Override
	public void onStart() {
		btn = new TextButton("Exit", AssetLoader.skinUI);
		btn.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("click");
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
			}
		});
		timer.add(4, () -> quit = true, task_type.toend, 0);
	}

	@Override
	public void onUpdate(SpriteBatch batch) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		btn.act(0.1f);
		batch.begin();
		btn.draw(batch, 0.3f);
		batch.end();
	}

	public void onDispose() {
		// TODO Auto-generated method stub
		
	}
	
}
