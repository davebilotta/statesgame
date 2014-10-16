package com.davebilotta.statesgame.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.davebilotta.statesgame.StatesGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new StatesGame(), config);
		
		//config.width = 800;
        //config.height = 600;
   
		//config.width = 1280;
		//config.height = 800;
		
        // Nexus 5
		config.width = 1080;
        config.height = 1980;
        
	}
}
