package abstractObjects;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import engine.AssetLoader;

public class text extends object{
	String source;
	BitmapFont font;
	public text(SpriteBatch batch, String source, int x, int y) {
		super(batch, x, y);
		font = AssetLoader.font;
		if(source == null) return;
		this.source = source;
	}

	public void onStart() {

	}

	public void onUpdate() {
		if(colorable) AssetLoader.font.setColor(r,g,b,a);
		AssetLoader.font.draw(batch, source, x, y);
		if(colorable) AssetLoader.font.setColor(1,1,1,1);
	}

	public void OnDispose() {
		
	}
}
