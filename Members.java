package myTank;


//基本坦克
class Tank
{
    //位置信息
    public int x;
	public int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
    //是否生存
    boolean isLive = true;
    //速度
    public int speed = 1;
    public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
    //方向
    public int direct = 0;
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
 

    //颜色
	public int color;
    public int getColor() 
    {
        return color;
    }

    public void setColor(int color)
    {
	    this.color = color;
    }
    

    
    
    



	


    //初始函数
    public Tank(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

//用户坦克 
class UserTank extends Tank
{
    public UserTank(int x,int  y)
    {
        super(x,y);
    }

    //坦克上下左右移动
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

