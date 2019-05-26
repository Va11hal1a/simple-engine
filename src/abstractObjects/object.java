package abstractObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import Iobjects.collisionable;
import animations.keyanim;

public abstract class object {
	public int x, y;
	public int angle;
	public int w, h;
	public float r,g,b,a;
	public SpriteBatch batch;
	public Array<keyanim> anims;
	public Array<collisionable> colls;
	public int colW, colH; //квадратная область для обработки столкновений
	public boolean user_pause, anim_pause;
	public boolean trigger = false,   //при значении true, объект может быть перехвачен интерфейсом onCollision
			       solid = false,
			       colorable = true, //при значении false, цвет объекта игнорируется
	               Isenter = false,
	               visible = true;
	public int ID = -1;
	public object(SpriteBatch batch, int x, int y) {
		this.batch = batch;
		this.x = x;
		this.y = y;
		solid = false;
		r = g = b = a = 1f;
		anims = new Array<keyanim>();
		onStart();
		colls = new Array<collisionable>();
	}
	public void add(collisionable a) {
		colls.add(a);
	}
	public void setCol(int w, int h) {
		colW = w;
		colH = h;
	}
	public abstract void onStart();
	public void update() {
		if(!anim_pause) {
		  if(anims.size > 0) {
			  for(int i = 0; i < anims.size; i++) {
				  anims.get(i).update();
				  if(anims.get(i)._is_end == true)
					  anims.removeIndex(i);
			  }
		  }
		}
		if(visible)onUpdate();
		for(int i = 0; i < colls.size; i++) {
			colls.get(i).update();
		}
	}
	public static boolean IsCollision(object a, object b) {
		Rectangle recta = new Rectangle(a.x, a.y, a.colW, a.colH);
		Rectangle rectb = new Rectangle(b.x, b.y, b.colW, b.colH);
		return recta.overlaps(rectb);
	}
	public boolean IsCollision(object b) {
		Rectangle recta = new Rectangle(x, y, colW, colH);
		Rectangle rectb = new Rectangle(b.x, b.y, b.colW, b.colH);
		return recta.overlaps(rectb);
	}
	public abstract void onUpdate();
	public void add(keyanim anim) {
		keyanim temp = anim;
		temp.obj = this;
		anims.add(temp);
}
	public void dispose() {
		OnDispose();
	}
	public abstract void OnDispose();
}
