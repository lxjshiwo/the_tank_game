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
    //初始化用户坦克 敌人坦克
    UserTank usertank = null;
    Vector<EnemyTank> ets = new Vector<EnemyTank>();
    //敌人坦克数目
    int enSize = 3;
    

    public MyPanel()
    {
        usertank = new UserTank(0,0);
        for(int i =0;i < enSize;i++)
        {
            //配置敌人坦克
            EnemyTank et = new EnemyTank((i+1)*50,0);
            et.setColor(1);
            et.setDirect(2);
            ets.add(et);

        }

    }

    public void paint( Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,400,300);
        this.drawTank(usertank.getX(),usertank.getY(),g,usertank.getDirect(),0);

        for(int i = 0;i < ets.size();i++)
        {
            EnemyTank et = ets.get(i);
            if(et.isLive)
            {
            	System.out.println(et.getX());
            	System.out.println(et.getY());
                this.drawTank(et.getX(),et.getY(),g,et.getDirect(),et.getColor());
            }
            

        }
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
            	//向右
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



