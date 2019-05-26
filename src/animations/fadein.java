package animations;

import com.badlogic.gdx.math.Interpolation;

public class fadein extends keyanim{
	public fadein(Interpolation inter, float time) {
		super(inter, time);
		// TODO Auto-generated constructor stub
	}

	public void upd() {
		obj.r = obj.g = obj.b = 1 -  percent / 100;
	}

}
