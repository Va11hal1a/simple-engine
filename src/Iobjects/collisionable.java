package Iobjects;

import abstractObjects.object;

public class collisionable {
	Runnable onEnter;
	Runnable onCollision;
	Runnable onExit;
	object a, b;
	boolean collis = false;
	public collisionable(Runnable onEnter, Runnable onCollision, Runnable onExit, object a, object b) {
		this.onEnter = onEnter;
		this.onCollision = onCollision;
		this.onExit = onExit;
		this.a = a;
		this.b = b;
	}
	public void update() {
		if(a.IsCollision(b) && !collis) {
			if(onEnter != null)onEnter.run();
			collis = true;
		}
		else if(a.IsCollision(b) && collis) {
			if(onCollision != null)onCollision.run();
		}
		else if(!a.IsCollision(b) && collis) {
			if(onExit != null)onExit.run();
			collis = false;
		}
	}
}
