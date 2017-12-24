package myTank;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class MyTank extends JFrame
{

    MyPanel mp = null;

    public static void main(String[] args)
    {
        MyTank mt = new MyTank();
    }

    
    public MyTank()
    {
        mp = new MyPanel();
        Thread t = new Thread(mp);
        t.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}


class MyPanel extends JPanel implements KeyListener,Runnable
{
    UserTank usertank = null;

    public MyPanel()
    {
        usertank = new UserTank(0,0);

    }

    public void paint( Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,400,300);
        this.drawTank(usertank.getX(),usertank.getY(),g,usertank.getDirect(),0);
    }


    public void drawTank(int x,int y,Graphics g,int direct,int type)
    {
        switch(type)
        {
            case 0:
                g.setColor(Color.yellow);
                break;
            case 1:
                g.setColor(Color.blue);
                break;
          
        }
        switch(direct)
        {
            case 0:
            	//向上
                g.fill3DRect(x,y,5,30,false);
                g.fill3DRect(x+15,y,5,30,false);
                g.fill3DRect(x+5,y+5,10,20,false);
                g.fillOval(x+5,y+10,10,10);
                g.drawLine(x+10,y+15,x+10,y);
                break;
            case 1:
            	//向右
                g.fill3DRect(x,y,30,5,false);
                g.fill3DRect(x,y+15,30,5,false);
                g.fill3DRect(x+5,y+5,20,10,false);
                g.fillOval(x+10,y+5,10,10);
                g.drawLine(x+15,y+10,x+30,y+10);
                break;
            case 2:
            	//向下
                g.fill3DRect(x,y,5,30,false);
                g.fill3DRect(x+15,y,5,30,false);
                g.fill3DRect(x+5,y+5,10,20,false);
                g.fillOval(x+5,y+10,10,10);
                g.drawLine(x+10,y+15,x+10,y+30);
                break; 
            case 3:
            	//向
                g.fill3DRect(x,y,30,5,false);
                g.fill3DRect(x,y+15,30,5,false);
                g.fill3DRect(x+5,y+5,20,10,false);
                g.fillOval(x+10,y+5,10,10);
                g.drawLine(x+15,y+10,x,y+10);
                break;
            }
    }
 
	@Override
    public void keyPressed(KeyEvent arg0) 
    {
        if(arg0.getKeyCode() == KeyEvent.VK_W)
        {
            this.usertank.setDirect(0);
            this.usertank.moveUp();
        }
        else if(arg0.getKeyCode() == KeyEvent.VK_D)
        {
            this.usertank.setDirect(1);
            this.usertank.moveRight();
        }
        else if(arg0.getKeyCode() == KeyEvent.VK_S)
        {
            this.usertank.setDirect(2);
            this.usertank.moveDown();
        }
        else if(arg0.getKeyCode() == KeyEvent.VK_A)
        {
            this.usertank.setDirect(3);
            this.usertank.moveLeft();
        }
       
        this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		
	}

	@Override
	public void run() 
	{
        try 
        {
            Thread.sleep(100);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        this.repaint();
	}
}

//鍩烘湰鍧﹀厠
class Tank
{
    public int x;
    public int y;
    public int speed = 1;
    public int direct;
    
    
    
    public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}


	

    public int getX() 
    {
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}


    public Tank(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

//鐢ㄦ埛鍧﹀厠 
class UserTank extends Tank
{
    public UserTank(int x,int  y)
    {
        super(x,y);
    }

    //鍧﹀厠涓婁笅宸﹀彸绉诲姩
    public void moveUp()
    {
        this.y -= this.speed;
    }

    public void moveDown()
    {
        this.y += this.speed;
    }

    public void moveRight()
    {
        this.x += this.speed;
    }
    public void moveLeft()
    {
        this.x -= this.speed;
    }

}

class EnemyTank extends Tank
{
    public EnemyTank(int x,int y)
    {
        super(x,y);
    }
}