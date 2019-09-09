/*
	 Ball.java (Java)
	 
	 Objetivo: Define a bola do Jogo Brick Breaker.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 06/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package BrickBreaker;

import java.util.Random;
import java.awt.Rectangle;
import java.util.*;

public class Ball extends BrickBreakerObject{

	public double v0=3.5;
	private double dx;
	private double dy;
	private int hitWall=0;

	public Ball(int WIDTH, int HEIGHT, int x, int y){

		this.speed=this.v0;
		this.giveBallAnStartingAngle();
		this.setSize(WIDTH,HEIGHT);
		this.setPosition(x,y);
	}

	public void giveBallAnStartingAngle(){

		int numAleatorio = new Random().nextInt(11);
		int angle = 30;

		if(numAleatorio <= 5){
			angle = 210;
		}

		int dangle = new Random().nextInt(120);
		angle = angle+dangle;

		numAleatorio = new Random().nextInt(11);

		this.dx = Math.cos(Math.toRadians((double)angle));
		this.dy = Math.sin(Math.toRadians((double)angle));

	}

	public int getBallXPosition(){
		return (int)this.x;
	}

	public int getBallYPosition(){
		return (int)this.y;
	}

	private void giveBallRandomColisionAngle(){			
			this.dx = Math.cos(Math.toRadians(new Random().nextInt(80)));
			this.dy = Math.sin(Math.toRadians(new Random().nextInt(80)));
	}

	public void update(Player player, Screen screen, ArrayList<Bricks> brick){

		this.verifyBallColisionWithWall(screen.getScreenWidth()*screen.getScreenScale());
		this.verifyBallColisionWithPlayer(player,screen.getScreenScale());
		this.verifyBallColisionWithBrick(brick,player);
		this.x += Math.round(this.dx * this.speed);
		this.y += Math.round(this.dy * this.speed);
		if(this.hitWall >= 2){
				this.hitWall = 0;
				this.update();
				this.verifyBallColisionWithWall(screen.getScreenWidth()*screen.getScreenScale());
		}
	}

	private void verifyBallColisionWithPlayer(Player player, int SCALE){

		this.bounds = new Rectangle((int)(this.x),(int)(this.y),this.width,this.height);

		int playerCenter = (int)(player.x+player.width)/2;

		if(this.bounds.intersects(player.getBoundsRectangle())){
			if(this.x >= player.x+player.width-(6*SCALE) || this.x <= player.x+(6*SCALE)){
				this.dx *= -1;
				this.dy *= -1;
			}else{
				this.dy *= -1;
			}
			Sound.ballColision.play();

			if(this.hitWall > 0)
				this.hitWall--;
		}


	}

	private void verifyBallColisionWithWall(int SCREEN_WIDTH){

		if(this.x+this.width > SCREEN_WIDTH){
			this.dx *= -1.0;
			this.hitWall++;
		}else if(this.x <= 0){
			this.dx *= -1.0;
			this.hitWall++;
		}else if(this.y <= 0.1){
			this.dy *= -1.0;
		}

	}

	private void verifyBallColisionWithBrick(ArrayList<Bricks> brick, Player player){

		int n = brick.size();
		int i;

		for(i=0;i<n;i++){
			
			if(!(brick.get(i).itWasRemoved) && this.bounds.intersects(brick.get(i).bounds)){
				this.giveBallRandomColisionAngle();
				if(this.dy < 0)		
					this.dy *= -1;
				if(this.y == 0){
					this.dy = Math.sin(Math.toRadians(new Random().nextInt(80)));
				}

				brick.get(i).itWasRemoved = true;
				player.score++;
				Sound.brickBreak.play();
			}
	
		}

	}

}
