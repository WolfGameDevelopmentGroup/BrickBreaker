/*
	 Game.java (Java)
	 
	 Objetivo: Estabelecer a inicialização e renderização do Jogo.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 05/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package BrickBreaker;

public class Game implements Runnable{

	public boolean isRunning=false;
	private int frame=0;

	public void updateGame(){
		this.frame++;
	}

	public void renderizeGame(){
		System.out.println(this.frame);
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

}
