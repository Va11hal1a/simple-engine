package animations;

import com.badlogic.gdx.math.Interpolation;

public class angle extends keyanim{
	int bangle;
	float stepAngle;
	public angle(Interpolation inter, float time, float bAngle, float tAngle) {
		super(inter, time);
		stepAngle = (tAngle - bAngle) / 100;
	}

	@Override
	public void upd() {
		obj.angle = (int) (bangle + stepAngle * percent);
	}

}
