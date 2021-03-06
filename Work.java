package Test;

import java.util.ArrayList;


public class Work { 
	int work;// 表示工作状态，1为向上，-1为向下
	int stay;// 当前楼层
	boolean dooropen;
	int weight;
	ArrayList<Pass> up;  
    ArrayList<Pass> down;
	public Work(ArrayList<Pass> u,ArrayList<Pass> d, int w){    
        up=u;  
        down=d;  
        work=w;  
        stay=1;  
    }  
	
	 
	public void run(){  
	    while(true){  
	        if (work==0){// 无人状态 
                 System.out.println("电梯在"+stay+"楼");                         
	             if (upyouren(stay)||upyouren1(stay)){  
	                  work=1; 
	             }else if (downyouren(stay)||downyouren1(stay)){  
	                  work=-1; 
	             }else{  
	                 sleep();  
	             }                 
	         }else if(work==1){// 向上工作状态   
	             sleep();
	        	 System.out.println("电梯在"+stay+"楼--[上]");
	             up_out(stay);// 每到达一层检查是否有人出
	             if (goUp(stay)||upyouren(stay)){  
	                  up_in(stay);// 每到达一层检查是否有人进
	                  stay++;
	             }else{
	                 work=0;
	             }
	             if(stay>10){  
	                    work=-1;  
	                    stay=10;  
	             }     
	             }else if(work==-1){// 向下工作状态   
	                 sleep();
	            	 System.out.println("电梯在"+stay+"楼--[下]");  
	                 down_out(stay);
	               
	              if(goDown(stay)||downyouren(stay)){  
	                	down_in(stay); 
	                    stay--;
	               }else{
	                	work=0;
	               }  
	               if(stay<1){  
	                    work=1;  
	                    stay=1;  
	               }  
	            }   
	        }  
	    }  
   public void up_out(int s){// 向上的人要出
	   for (int i=0;i<up.size();i++){
		Pass temp=up.get(i);
	    if(temp.get_to()==s){
		    System.out.println("有人出电梯");
		    opendoor();
		    up.remove(i);
		    closedoor();
		    break;
	     }else{ }
       }
    }
   
    public void up_in(int s){// 向上的人要进
    	for(int i=0;i<up.size();i++){
    		Pass temp=up.get(i);
    		if(temp.get_at()==s){
    			System.out.println("有人进电梯");
    			opendoor();
    			checkWeightSensors();
    			closedoor();
    			break;
    		}else{ }
    	 }
	
    }
    
	public boolean upyouren(int s){// 楼上有人上
		for(int i=0;i<up.size();i++){
			Pass temp=up.get(i);
	      if(temp.get_at()>s){  
                return true; 
            } 
		}
            return false;  
	}
	public boolean upyouren1(int s){// 楼上有人下
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
	      if(temp.get_at()>s){  
                return true; 
            } 
		}
            return false;  
	}
	public void down_in(int s){// 向下的人要进
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
    		if(temp.get_at()==s){
    			System.out.println("有人进电梯");                      
    			opendoor();
    			checkWeightSensors();
    			closedoor();
    			break;
    		}else{ }
    	 }
		
	}
	
	public void down_out(int s){// 向下的人要出
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
    		if(temp.get_to()==s){
    			System.out.println("有人出电梯");
    			opendoor();
    			down.remove(i);
    			closedoor();
    			break;
    		}else{ }
    	 }
		
	}
	
	public boolean downyouren(int s){// 楼下有人下
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
	      if(temp.get_at()<s){  
                return true; 
            }
		}
            return false;  	
	}
	public boolean downyouren1(int s){// 楼下有人上
		for(int i=0;i<up.size();i++){
			Pass temp=up.get(i);
	      if(temp.get_at()<s){  
                return true; 
            }
		}
            return false;  	
	}
	public boolean goUp(int s){// 有人要上
		for(int i=0;i<up.size();i++){
			Pass temp=up.get(i);
	        if(temp.get_to()>s){
	        	return true;
	        }
		}
		return false;
  }
	
	public boolean goDown(int s){// 有人要下
		for (int i=0;i<down.size();i++){
			Pass temp=down.get(i);
	        if(temp.get_to()<s){
	        	return true; 
	        }  
		}
		return false;
  }
	
	public void sleep(){  
        try {  
            Thread.sleep(500);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
           }  
     } 
	
	public void opendoor(){
		boolean dooropen=true;
	}
	
	public void closedoor(){    
	    checkWeightSensors();    
	     if (weight<=1000){    
	        boolean dooropen=false;
	     }else{   
	       System.out.println("超重，门不能关！");
	     }
	 }    
	        
	 private void checkWeightSensors(){ // 检查是否超重  
	   int weight=(int)(Math.random()*1500);       
	  }   
  }  



