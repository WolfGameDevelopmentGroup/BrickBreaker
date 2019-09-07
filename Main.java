/*
	 Main.java (Java)
	 
	 Objetivo: Projeto do curso de desenvolvimento de Games da Danki code, Jogo Brick Breaker.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo A C Neves (Dirack) 05/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

import BrickBreaker.Game;

public class Main{

	public static void main(String[] args){

		String TITLE = "BrickBreaker #1";
		int WIDTH = 200;
		int HEIGHT = 200;
		int SCALE = 2;

		Game game = new Game(TITLE,WIDTH,HEIGHT,SCALE);
		
		game.startGame();
	}

}
