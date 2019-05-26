package animations;

import com.badlogic.gdx.math.Interpolation;

public class fadeout extends keyanim{
	public fadeout(Interpolation inter, float time) {
		super(inter, time);
		// TODO Auto-generated constructor stub
	}

	public void upd() {
		obj.r = obj.g = obj.b = percent / 100;
	}

}
