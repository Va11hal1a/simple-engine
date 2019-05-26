package utils;

import abstractObjects.object;

public abstract class checker {
	public Runnable run;
	public boolean _is_end = false;
	public checker(Runnable run) {
		this.run = run;
	}
	public abstract boolean check();
	public void update() {
		if(!_is_end && check()) {
			run.run();
			_is_end = true;
		}
	}
}
