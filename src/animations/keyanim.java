package animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;

import abstractObjects.object;

public abstract class keyanim {
	public object obj;
	public boolean _is_end = false;
	private Runnable OnEnd;
	public float percent = 0;
	private Interpolation inter;
	private float time;
	private float atime;
	public keyanim(Interpolation inter, float time) {
		this.OnEnd = null;
		this.inter = inter == null ? new Interpolation.Pow(1) : inter;
		this.time = time;
		atime = 0.0f;
	}
	public keyanim set(Runnable end) {
		this.OnEnd = end;
		return this;
	}
	public void end() {
		if(OnEnd != null) OnEnd.run();
		_is_end = true;
	}
	public void update() {
	    if(!_is_end) {
		  if(atime > time) {
			  end();
			  return;
		  }
		  atime += Gdx.graphics.getDeltaTime();
		  percent = inter.apply(0, 100, atime / time);
		  upd();
	    }
	}
	public abstract void upd();
}
