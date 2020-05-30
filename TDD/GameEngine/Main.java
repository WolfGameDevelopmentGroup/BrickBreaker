/*
	 Main.java (Java)
	 
	 Objetivo: Teste da game engine do jogo Brick Breaker.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 05/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

import BrickBreaker.Game;

public class Main{

	static int i;
	static int ratio;
	static int frame0;
	static Game game;
	static double media;

	public static void main(String[] args){

		game = new Game();

		frame0 = game.getActualFrameNumber();

		game.startGame();

		// Verifique se a renderização está acontecendo na taxa correta
		// de 60 frames por segundo.
		for(i=0;i<5;i++){
			try{
			    Thread.sleep(1000);
			    calculateFrameRatio(game);
			}catch(InterruptedException e){
			    e.printStackTrace();
			}
		}

		media = media/5;

		game.isRunning = false;
		System.out.println("Média de renderização em Frames/segundo: "+media);

		if(media >= 65 || media <= 55){
			System.out.println("Teste falhou! A média de renderização não está correta");
		}else{
			System.out.println("Ok");
		}

	}

	public static void calculateFrameRatio(Game game){
		ratio = (int)((game.getActualFrameNumber()-frame0));
		media += ratio;
		frame0 = game.getActualFrameNumber();
		System.out.println("Frames/segundo: "+ratio);
	}


}

