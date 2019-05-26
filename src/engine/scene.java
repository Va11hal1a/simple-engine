package engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

import Iobjects.collisionable;
import abstractObjects.object;
import animations.keyanim;

public abstract class scene {
	public Array<object> objects;
	SpriteBatch batch;
	Camera cam;
	private boolean _debug = true;
	private ShapeRenderer render;
	public window current;
	public boolean pause = false, visible = true;
	public scene(SpriteBatch batch) {
		objects = new Array<object>();
		this.batch = batch;
		cam = new Camera(batch);
		render = new ShapeRenderer();
		onStart();
	}
	public void add(object obj) {
		object temp = obj;
		temp.batch = batch;
		objects.add(temp);
	}
	public void debug() {
		if(_debug) {
			 render.begin(ShapeType.Line);
			for(int i = 0; i < objects.size; i++) {

			  render.setColor(1, 0, 0, 0.5f);
			  render.rect(objects.get(i).x, objects.get(i).y, objects.get(i).colW, objects.get(i).colH);
			}
			 render.end();
		}
	}

	public void update() {
		if(!pause) {
		  if(visible) {
		   Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		   batch.begin();
		   for(int i = 0; i < objects.size; i++) {
		      objects.get(i).update();
		   }
		   batch.end();
		   }
		  onUpdate();
		  debug();
		}
		else if(current != null) {
			if(current.quit) {
				current = null;
				unpause();
			}
			else {
				current.onUpdate(batch);
			}
		}
	}
	public void setWindow(window win) {
		pause();
		this.current = win;
		win.onStart();
	}
	public void pause() {
		pause = true;
	}
	public void unpause() {
		pause = false;
	}
	public void add(int index, keyanim anim) {
		object temp = objects.get(index);
		temp.add(anim);
		objects.set(index, temp);
	}
	public void add(int index, collisionable a) {
		object temp = objects.get(index);
		temp.add(a);
		objects.set(index, temp);
	}
	public object get(int index) {
		return objects.get(index);
	}
	public void rem(int index) {
		objects.removeIndex(index);
	}
	public abstract void onStart();
	public abstract void onUpdate();
	
}
