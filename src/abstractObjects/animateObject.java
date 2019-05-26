package abstractObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;

public abstract class animateObject extends object{
	public Array<Animation<TextureRegion>> anims;
	public Array<TextureRegion> staticimg;
	int currentstate = 0;
	int iframe;
	boolean animate = true;
	private float time = 0.0f;
	protected int w;
	protected int h;
	public animateObject(SpriteBatch batch, int x, int y) {
		super(batch, x, y);
		staticimg = new Array<TextureRegion>();
		anims = new Array<Animation<TextureRegion>>();
		currentstate = 0;
		iframe = 0;
		onStart();
	}
	public void add(TextureRegion[] regs, float time, PlayMode mode) {
		Animation<TextureRegion> temp = new Animation<TextureRegion>(time, regs);
		temp.setPlayMode(mode);
		anims.add(temp);
	}
	public void set(int index) {
		if(!(index >= 0 && index < anims.size)) {
			return;
		}
		currentstate = index;
		animate = true;
		time = 0.0f;
	}
	public void setstatic(int index) {
		if(!(index >= 0 && index < staticimg.size)) {
			return;
		}
		currentstate = index;
		animate = false;
	}
	public abstract void OnStart();
	public void onStart() {
		OnStart();
	}
	public abstract void OnUpdate();
	public void onUpdate() {
		TextureRegion cur;
		if(animate) {
		   time += Gdx.graphics.getDeltaTime();
		   cur = anims.get(currentstate).getKeyFrame(time);
		}
		else {
			cur = staticimg.get(currentstate);
		}

		batch.draw(cur, x, y, w /2, h /2, w, h, 1, 1, angle);
		OnUpdate();
	}
	
	public void OnDispose() {
	}
}
