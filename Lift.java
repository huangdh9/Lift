package Test;
import java.util.*;

/* 单线程电梯（1台电梯运行,10层）模拟：
 *  ArrayList up = new ArrayList;	want=1 向上去的人所在队列
	ArrayList down = new ArrayList;	want=-1 向下去的人所在队列
	Pass 乘客：
		at:所在楼层
		to:目的楼层
		want:1表示向上去，-1表示向下去
		key：乘客编号
 */
public class Lift {
	public static void main(String[]args){
		ArrayList<Pass> up = new ArrayList<Pass>();  // 向上的人的队列
        ArrayList<Pass> down = new ArrayList<Pass>(); // 向下的人的队列
        
        Work work = new Work(up,down,0);  
		        
		for (int i=0;i<20;i++){  
            while(true){  
                int at=(int)(Math.random()*10+1);  
                int to=(int)(Math.random()*10+1);  
                if(at<to&&to!=0&&at!=0){  
                    Pass pass= new Pass(at,to,i,1);  
                    up.add(pass);  
                    break;  
                }else if(at>to&&to!=0&&at!=0){  
                    Pass pass= new Pass(at,to,i,-1);  
                    down.add(pass);                      
                    break;  
                }       
            }  
            
	    }
		 work.run();
	}	
}