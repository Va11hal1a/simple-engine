package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

import Iobjects.collisionable;
import animations.moveTowards;
import cyber_utani_engine.scene;
import objects.singletest;
import windows.testwindow;

public class testscene extends scene{
	public testscene(SpriteBatch batch) {
		super(batch);
	}

	public void onStart() {
		add(new singletest(0, 0, "droid.png"));
		addAnimation(0, new moveTowards(null, new Interpolation.Pow(1), 2f, 0, 0, 500, 0));
		add(new singletest(500, 0, "droid.png"));
		add(0, new collisionable(() -> setWindow(new testwindow()), null, null, get(0), get(1)));
	}

	public void onUpdate() {
		
	}

}
