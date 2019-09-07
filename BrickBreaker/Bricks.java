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
	public Color color;

	public Bricks(int WIDTH, int HEIGHT, int x, int y){
		this.setSize(WIDTH,HEIGHT);
		this.setPosition(x,y);
		this.color = this.getARandomColor();
	}

	private Color getARandomColor(){
		Color color = Color.GREEN;
		int n = new Random().nextInt(5);
		switch(n){
		case 0:
			color = Color.WHITE;
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
		}

		return color;
	}

}
