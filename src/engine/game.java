package engine;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class game extends Game{
	public void create() {
		setScreen(new loadscreen(this));
	}
	public void SetMainScreen() {
		setScreen(new main_menu());
	}
}