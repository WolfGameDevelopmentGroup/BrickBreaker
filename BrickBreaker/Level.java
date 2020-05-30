/*
	 Level.java (Java)
	 
	 Objetivo: Define as fases do Game.
	 
	 Site: http://www.dirackslounge.online
	 
	 Versão 1.0
	 
	 Programador: Rodolfo Dirack 08/09/2019
	 
	 Email: rodolfo_profissional@hotmail.com
	 
	 Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.
*/
package BrickBreaker;

import java.awt.Graphics;
import java.util.*;
import java.awt.Color;
import BrickBreaker.Bricks;

public class Level{

	public void drawBricksAcordingToLevel(ArrayList<Bricks> brick, Graphics g,int levelNum){
		int n = brick.size();
		int i;
		boolean style = true;

		switch(levelNum){
		case 1:
			for(i=0;i<n;i++){
				if(!(brick.get(i).itWasRemoved)){
					g.setColor(brick.get(i).getBrickColor());
					g.fill3DRect(brick.get(i).x,brick.get(i).y,brick.get(i).width,brick.get(i).width,style);
				}
			}
		break;
		case 2:
			style = false;
			for(i=0;i<n;i++){
				if(!(brick.get(i).itWasRemoved)){
					g.setColor(brick.get(i).getBrickColor());					g.draw3DRect(brick.get(i).x,brick.get(i).y,brick.get(i).width,brick.get(i).width,style);
				}
			}

		break;

		case 3:
			g.setColor(Color.WHITE);
			style = false;
			for(i=0;i<n;i++){
				if(!(brick.get(i).itWasRemoved)){					g.fill3DRect(brick.get(i).x,brick.get(i).y,brick.get(i).width,brick.get(i).width,style);
				}
			}

		break;

		default:
			g.setColor(Color.PINK);
			style = false;
			for(i=0;i<n;i++){
				if(!(brick.get(i).itWasRemoved)){					g.fill3DRect(brick.get(i).x,brick.get(i).y,brick.get(i).width,brick.get(i).width,style);
				}
			}

		break;

		}
	}

}















