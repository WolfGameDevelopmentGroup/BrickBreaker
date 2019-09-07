/*
	 Bricks.java (Java)
	 
	 Objetivo: Definir a classe Bricks do jogo Brick Breaker.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 06/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package BrickBreaker;

import java.awt.Color;
import java.util.Random;

public class Bricks extends BrickBreakerObject{

	public boolean itWasRemoved = false;
	private Color color = Color.WHITE;

	public Bricks(int WIDTH, int HEIGHT, int x, int y){
		this.setSize(WIDTH,HEIGHT);
		this.setPosition(x,y);
	}

	public Color getBrickColor(){
		return this.color;
	}

	public Color setBrickColor(int n){
		switch(n){
		case 0:
			color = Color.GREEN;
		break;
		case 1:
			color = Color.BLUE;
		break;
		case 2:
			color = Color.ORANGE;
		break;
		case 3:
			color = Color.PINK;
		break;
		case 4:
			color = Color.RED;
		break;
		case 5:
			color = Color.MAGENTA;
		break;
		case 6:
			color = Color.CYAN;
		break;
		case 7:
			color = Color.YELLOW;
		break;
		case 8:
			color = Color.GRAY;
		break;
		default:
			color = Color.WHITE;
		break;
		}

		return color;
	}

}
