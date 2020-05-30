/*
	 BrickBreakerObject.java (Java)
	 
	 Objetivo: Superclasse para as classes Player, Bricks e Ball.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 06/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/

package BrickBreaker;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class BrickBreakerObject{

	protected int width;
	protected int height;
	protected int x;
	protected int y;
	public boolean moveRight=false;
	public boolean moveLeft=false;
	protected double speed=2;
	protected Rectangle bounds;

	public void setSize(int WIDTH,int HEIGHT){
		this.width=WIDTH;
		this.height=HEIGHT;
	}

	public void setPosition(int X,int Y){
		this.x = X;
		this.y = Y;
	}

	public void draw(Graphics g){
		g.fillRect(this.x,this.y,this.width,this.height);
	}

	public Rectangle getBoundsRectangle(){
		return this.bounds = new Rectangle(this.x,this.y,this.width,this.height); 
	}

	public void update(){}

}







