package utils;

import abstractObjects.object;

public class RadiusChecker extends checker{
	int x, y;
	float radius;
	object target;
	public RadiusChecker(Runnable run) {
		super(run);
	}

	public boolean check() {
		float dist = (float) Math.sqrt(Math.pow(x - target.x, 2) + Math.pow(y - target.y, 2));
		return dist <= radius;
	}

}
