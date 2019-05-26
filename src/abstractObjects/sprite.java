package abstractObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public abstract class sprite extends object{
	private Texture drawable;
	public sprite(SpriteBatch batch, int x, int y, Texture texture) {
		super(batch, x, y);
		this.drawable = texture;
		w = drawable.getWidth();
		h = drawable.getHeight();
		setCol(w, h);
	}
	
	public abstract void OnStart();
	public void onStart() {
		OnStart();
	}
	
	public abstract void OnUpdate();
	public void onUpdate() {
		if(colorable) batch.setColor(r, g, b, a);
		batch.draw(drawable, x, y, w / 2, h / 2, w, h, 1f, 1f, angle, 0, 0, w, h, false, false);
		if(colorable) batch.setColor(1f, 1f, 1f, 1f);
	}
	public void OnDispose() {
		drawable.dispose();
	}

}
