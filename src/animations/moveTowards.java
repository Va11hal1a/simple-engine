package animations;

import com.badlogic.gdx.math.Interpolation;

public class moveTowards extends keyanim{
	float stepX;
	float stepY;
	int bx, by;
	public moveTowards(Interpolation inter, float time, int fx, int fy, int tx, int ty) {
		super(inter, time);
		stepX = (tx - fx) / 100;
		stepY = (ty - fy) / 100;
		this.bx = fx;
		this.by = fy;
	}

	public void upd() {
		obj.x = (int) (bx + (stepX *percent));
		obj.y = (int) (by + (stepY *percent));
	}
}
