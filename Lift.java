package Test;
import java.util.*;

/* ���̵߳��ݣ�1̨��������,10�㣩ģ�⣺
 *  ArrayList up = new ArrayList;	want=1 ����ȥ�������ڶ���
	ArrayList down = new ArrayList;	want=-1 ����ȥ�������ڶ���
	Pass �˿ͣ�
		at:����¥��
		to:Ŀ��¥��
		want:1��ʾ����ȥ��-1��ʾ����ȥ
		key���˿ͱ��
 */
public class Lift {
	public static void main(String[]args){
		ArrayList<Pass> up = new ArrayList<Pass>();  // ���ϵ��˵Ķ���
        ArrayList<Pass> down = new ArrayList<Pass>(); // ���µ��˵Ķ���
        
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