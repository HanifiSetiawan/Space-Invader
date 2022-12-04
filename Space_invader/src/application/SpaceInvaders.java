package application;

import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SpaceInvaders extends Application{
	
	//variables
    private static final Random RAND = new Random();
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 60;
    
    static final Image PLAYER_IMG = new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Player.png");
    static final Image EXPLOSION_IMG = new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Explosion.png");
    
    static final int EXPLOSION_W = 128;
    static final int EXPLOSION_ROWS = 3;
    static final int EXPLOSION_COL = 3;
    static final int EXPLOSION_H = 128;
    static final int EXPLOSION_STEPS = 14;
    
    static final Image ALIENS_IMG[] = {
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien1.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien2.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien3.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien4.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien5.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien6.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien7.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien8.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien9.png"),
    		new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Alien10.png"),
    };
    
    final int MAX_ALIENS = 10, MAX_SHOTS = MAX_ALIENS * 2;
    boolean gameOver = false;
    private GraphicsContext gc;
    
    Rocket player;
    List<Shot> shots;
    List<Universe> univ;
    List<Alien> Aliens;
    
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//player
	public class Rocket{
		
		int posX, posY, size;
		boolean exploding, destroyed;
		Image img;
		int explosionsStep = 0;
		
		//cons
		public Rocket(int posX, int posY, int size, Image image) {
			this.posX = posX;
			this.posY = posY;
			this.size = size;
			img = image;
		}
		
		
	}

	
	
	
	
	
	
	
	
}
