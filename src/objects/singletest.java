package objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import abstractObjects.sprite;

public class singletest extends sprite{
	public singletest(int x, int y, Texture texture) {
		super(null, x, y, texture);
	}
	public singletest(int x, int y, String path) {
		super(null, x, y, new Texture(Gdx.files.internal(path)));
	}
	@Override
	public void OnStart() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void OnUpdate() {
		
	}

}
