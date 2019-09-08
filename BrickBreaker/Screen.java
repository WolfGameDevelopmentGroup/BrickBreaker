/*
	 Screen.java (Java)
	 
	 Objetivo: Gerar a tela do jogo.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 06/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package BrickBreaker;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.*;

public class Screen extends Canvas{

	public static JFrame jframe;
	public static Canvas canvas;
	private String jframeTitle;
	private int WIDTH;
	private int HEIGHT;
	private int SCALE;
	private BufferStrategy bs;
	private BufferedImage layer;
	private Color bgColor = Color.WHITE;
	private Graphics g;

	public Screen(String jframeTitle, int WIDTH, int HEIGHT, int SCALE){
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.SCALE = SCALE;

		this.canvas = new Canvas();
		this.canvas.setPreferredSize(new Dimension(this.WIDTH*this.SCALE, this.HEIGHT*this.SCALE));	

		this.jframeTitle = jframeTitle;
		this.jframe = new JFrame(this.jframeTitle);
		this.jframe.setPreferredSize(new Dimension(this.WIDTH*this.SCALE, this.HEIGHT*this.SCALE));

		this.jframe.add(this.canvas);
		this.jframe.setResizable(false);
		this.jframe.pack();
		this.jframe.setLocationRelativeTo(null);
		this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		this.canvas.createBufferStrategy(3);
		this.bs = this.canvas.getBufferStrategy();
		this.layer = new BufferedImage(this.WIDTH*this.SCALE,this.HEIGHT*this.SCALE,BufferedImage.TYPE_INT_RGB);
		this.g = this.layer.getGraphics();
		this.g.setColor(this.bgColor);
		this.showScreen();
		this.canvas.requestFocus();
	}

	public void showScreen(){
		this.jframe.setVisible(true);
	}

	private void drawBackground(){
		this.g.setColor(this.bgColor);
		this.g.fillRect(0,0,this.WIDTH*this.SCALE, this.HEIGHT*this.SCALE);
	}

	public void drawPlayer(Player player){
		this.g.setColor(Color.white);
		this.g.fillRect(player.x,player.y,player.width, player.height);
	}
	public void drawBall(Ball ball){
		this.g.setColor(Color.white);
		this.g.fillRect(ball.getBallXPosition(),ball.getBallYPosition(),ball.width, ball.height);
	}

	public void drawPlayerLife(int playerLife){
		this.g.setColor(Color.white);
		int x = (int)this.SCALE*(this.WIDTH/2);
		int y = (int)this.SCALE*(this.HEIGHT/2);
		this.g.drawString(""+playerLife,x,y);
	}

	public void drawBrick(ArrayList<Bricks> brick){
		int n = brick.size();
		int i;
		for(i=0;i<n;i++){
			if(!(brick.get(i).itWasRemoved)){
				this.g.setColor(brick.get(i).getBrickColor());
				this.g.fillRect(brick.get(i).x,brick.get(i).y,brick.get(i).width,brick.get(i).height);
			}
		}
	}

	public void drawFrame(Player player, Ball ball, ArrayList<Bricks> brick){
		this.g = this.layer.getGraphics();
		this.drawBackground();
		this.drawPlayer(player);
		this.drawBall(ball);
		this.drawBrick(brick);
		this.drawPlayerLife(3);//player.getPlayerLife());
		this.g = this.bs.getDrawGraphics();
		this.g.drawImage(this.layer, 0, 0, this.WIDTH*this.SCALE,this.HEIGHT*this.SCALE,null);
		this.bs.show();
	}

	public void setBackgroungColor(Color bgColor){
		this.bgColor = bgColor;
		this.g.setColor(this.bgColor);
	}

}
