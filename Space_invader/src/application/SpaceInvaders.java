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
    static final Image EXPLOSION_IMG = new Image("file:C:/Users/Hanif/OneDrive/Pictures/Space Invader/Image.Explosion.png");
    
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
		public Shot shoot() {
			return new Shot(posX+size / 2 - Shot.size / 2, posY - Shot.size);
		}
		
		public void update() {
			if(exploding) explosionStep++;
			destroyed = explosionStep > EXPLOSION_STEPS;
		}
		
		public void draw() {
			if (exploding) {
				gc.drawImage(EXPLOSION_IMG, explosionStep % EXPLOSION_COL * EXPLOSION_W,
						(explosionStep / EXPLOSION_ROWS)* EXPLOSION_H + 1, EXPLOSION_W, EXPLOSION_H, posX, posY, size, size);
			}
			else {
				gc.drawImage(img, posX, posY, size, size);
			}
		}
		
		public boolean colide(Rocket other) {
			int d = distance(this.posX + size / 2, this.posY + size / 2,
					other.posX + other.size / 2, other.posY + other.size / 2);
			return d < other.size / 2 + this.size / 2;
		}
		public void explode() {
			exploding = true;
			explosionStep = -1;
		}
	}
	
	//computer player
	public class Alien extends Rocket{
		
		int SPEED = (score/5)+2;
		
		public Alien(int posX, int posY, int size, Image image) {
			super(posX, posY, size, image);
		}
		
		public void update() {
			super.update();
			if(!exploding && !destroyed) posY += SPEED;
			if(posY > HEIGHT) destroyed = true;
		}
	}
	
	//bullets
	public class Shot{
		
		public boolean toRemove;
		
		int posX, posY, speed = 10;
		static final int size = 6;
		
		public Shot(int posX, int posY) {
			this.posX = posX;
			this.posY = posY;
		}
		
		public void update() {
			posY -= speed;
		}
		
		public void draw() {
			gc.setFill(Color.RED);
			if (score >= 50 && score <= 70 || score >= 120) {
				gc.setFill(Color.YELLOWGREEN);
				speed = 50;
				gc.fillRect(posX-5, posX-10, size+10, size+30);
			}else {
				gc.fillOval(posX, posY, size, size);
			}
		}
		
		public boolean colide(Rocket Rocket) {
			int distance = distance(this.posX + size / 2, this.posY + size / 2,
					Rocket.posX + Rocket.size / 2, Rocket.posY + Rocket.size / 2);
			return distance < Rocket.size / 2 + size / 2;
		}
		
	}
		
	

	
	
	
	
	
	
	
	
}
