/*
	 Game.java (Java)
	 
	 Objetivo: Estabelecer a inicialização e renderização do Jogo Brick Breaker.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 05/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package BrickBreaker;
import BrickBreaker.Player;
import BrickBreaker.Screen;
import BrickBreaker.Ball;
import BrickBreaker.Bricks;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.Rectangle;
import BrickBreaker.Sound;

public class Game implements Runnable, KeyListener{

	public boolean isRunning=false;
	private boolean pausedGame = false;
	private int frame=0;
	private String TITLE;
	private int SCREEN_WIDTH;
	private int SCREEN_HEIGHT;
	private int SCALE=1;
	private Screen screen;
	private Player player;
	private Ball ball;
	private ArrayList<Bricks> brick = new ArrayList<Bricks>();
	private int levelNum = 0;

	public Game(String TITLE, int WIDTH, int HEIGHT, int SCALE){
		this.TITLE = TITLE;
		this.SCREEN_WIDTH = WIDTH*SCALE;
		this.SCREEN_HEIGHT = HEIGHT*SCALE;
		this.SCALE = SCALE;
		this.screen = new Screen(TITLE, WIDTH, HEIGHT, SCALE);
		this.player = new Player(30*SCALE,10*SCALE,this.SCREEN_WIDTH/2,this.SCREEN_HEIGHT-5);
		this.ball = new Ball(5*SCALE,5*SCALE,this.player.x+this.player.width/2,this.player.y-this.player.height);
		this.buildBricks();
		this.screen.setBackgroungColor(Color.BLACK);
		this.screen.canvas.addKeyListener(this);
	}

	public void buildBricks(){
		
		int brickWidth = 20*this.SCALE;
		int positionInRow;
		int row;
		int i;
		int totalBricksPerRow = (int)(this.SCREEN_WIDTH)/(brickWidth);

		for(row=0;row<3;row++){
			for(positionInRow=0;positionInRow<totalBricksPerRow;positionInRow++){
				i = positionInRow + row*(totalBricksPerRow);
				int n = new Random().nextInt(5);
				this.brick.add(new Bricks(brickWidth,brickWidth,(positionInRow*brickWidth),(row*brickWidth)+brickWidth));
				this.brick.get(i).bounds = new Rectangle((int)(this.brick.get(i).x),(int)(this.brick.get(i).y),this.brick.get(i).width,this.brick.get(i).height);
				this.brick.get(i).setBrickColor(n);
			}
		}
	}

	public int getActualFrameNumber(){
		return this.frame;
	}

	private void restart(){
		this.ball.setPosition(this.player.x+this.player.width/2,this.player.y-this.player.height/2);
		this.ball.giveBallAnStartingAngle();
		this.ball.speed = this.ball.v0;
		Sound.playerLoseAPoint.play();
	}

	public void updateGame(){
		this.frame++;
		if(player.getPlayerLife() <= 0){
			this.pausedGame = true;
			return;
		}else if(levelNum == 0){
			return;
		}else if(this.player.score == (this.levelNum*this.brick.size())){
			this.levelNum++;
			this.player.setPlayerLife(3);
		}

		if(this.ball.y >= this.SCREEN_HEIGHT){
			this.restart();
			this.player.descPlayerLife();
		}else if(!(pausedGame)){
			this.ball.update(this.player,this.screen,this.brick);
			this.player.update(this.SCREEN_WIDTH);
		}
	}

	public void renderizeGame(){

		this.screen.drawFrame(this.player,this.ball,this.brick,this.levelNum,this.pausedGame);
	}

	public synchronized void startGame(){
		this.isRunning = true;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run(){

		while(isRunning){
			updateGame();
			renderizeGame();
			try{
				Thread.sleep(1000/60);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}

	private void startNewGame(){
		this.levelNum = 0;
		this.player.setPlayerLife(3);
		this.player.score = 0;
		this.pausedGame=false;
		this.brick.clear();
		this.buildBricks();
	}

	public void keyPressed(KeyEvent e){
		if(!(this.pausedGame) && e.getKeyCode() == KeyEvent.VK_RIGHT){
			player.moveRight=true;
		}else if(!(this.pausedGame) && e.getKeyCode()==KeyEvent.VK_LEFT){
			player.moveLeft=true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(player.getPlayerLife() <= 0){
				this.startNewGame();
				return;
			}else if(levelNum == 0){
				this.levelNum++;
				this.pausedGame = false;
			}

			if(!(this.pausedGame)){
				this.pausedGame=true;
			}else{
				this.pausedGame=false;
			}
		}
	}

	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			player.moveRight=false;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			player.moveLeft=false;
		}
	}

	public void keyTyped(KeyEvent e){}

}
