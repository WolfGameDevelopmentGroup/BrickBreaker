/*
	 Player.java (Java)
	 
	 Objetivo: Jogador no jogo Brick Breaker.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 06/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package BrickBreaker;

public class Player extends BrickBreakerObject{

	private int life = 1;

	public Player(int WIDTH, int HEIGHT, int x, int y){

		this.setSize(WIDTH,HEIGHT);
		this.setPosition(x,y);
	}

	public int getPlayerLife(){
		return this.life;
	}

	public void descPlayerLife(){
		this.life--;
	}

	public void update(int SCREEN_WIDTH){
	
		if(this.moveRight){
			if(this.width+this.x+this.speed <= SCREEN_WIDTH){
				this.x+=this.speed;
			}
		}else if(this.moveLeft){
			if(this.x >= 0){
				this.x-=this.speed;
			}
		}
	}

}
