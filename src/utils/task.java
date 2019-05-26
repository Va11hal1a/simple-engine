package utils;

import com.badlogic.gdx.Gdx;

import utils.timer.task_type;

public class task {
	float time;
	float interval;
	Runnable run;
	boolean _done = false;
	int count = 0; // default - 0
	int i = 0;
	task_type type;
	public task(float tm, task_type type, int count) {
		this.interval = tm;
		this.run = run;
		this.type = type;
		time = 0.0f;
		this.count = count;
	}
	public void update() {
		time += Gdx.graphics.getDeltaTime();
		if(type == task_type.toend) {
			if(time >= interval) {
				run.run();
				_done = true;
			}
		}
		else if(type == task_type.repeat) {
			if(time >= interval) {
				if(i < count) {
				  i++;
				  run.run();
				}
				else _done = true;
			}
		}
	}
}
