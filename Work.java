package Test;

import java.util.ArrayList;


public class Work { 
	int work;// ��ʾ����״̬��1Ϊ���ϣ�-1Ϊ����
	int stay;// ��ǰ¥��
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
	        if (work==0){// ����״̬ 
                 System.out.println("������"+stay+"¥");                         
	             if (upyouren(stay)||upyouren1(stay)){  
	                  work=1; 
	             }else if (downyouren(stay)||downyouren1(stay)){  
	                  work=-1; 
	             }else{  
	                 sleep();  
	             }                 
	         }else if(work==1){// ���Ϲ���״̬   
	             sleep();
	        	 System.out.println("������"+stay+"¥--[��]");
	             up_out(stay);// ÿ����һ�����Ƿ����˳�
	             if (goUp(stay)||upyouren(stay)){  
	                  up_in(stay);// ÿ����һ�����Ƿ����˽�
	                  stay++;
	             }else{
	                 work=0;
	             }
	             if(stay>10){  
	                    work=-1;  
	                    stay=10;  
	             }     
	             }else if(work==-1){// ���¹���״̬   
	                 sleep();
	            	 System.out.println("������"+stay+"¥--[��]");  
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
   public void up_out(int s){// ���ϵ���Ҫ��
	   for (int i=0;i<up.size();i++){
		Pass temp=up.get(i);
	    if(temp.get_to()==s){
		    System.out.println("���˳�����");
		    opendoor();
		    up.remove(i);
		    closedoor();
		    break;
	     }else{ }
       }
    }
   
    public void up_in(int s){// ���ϵ���Ҫ��
    	for(int i=0;i<up.size();i++){
    		Pass temp=up.get(i);
    		if(temp.get_at()==s){
    			System.out.println("���˽�����");
    			opendoor();
    			checkWeightSensors();
    			closedoor();
    			break;
    		}else{ }
    	 }
	
    }
    
	public boolean upyouren(int s){// ¥��������
		for(int i=0;i<up.size();i++){
			Pass temp=up.get(i);
	      if(temp.get_at()>s){  
                return true; 
            } 
		}
            return false;  
	}
	public boolean upyouren1(int s){// ¥��������
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
	      if(temp.get_at()>s){  
                return true; 
            } 
		}
            return false;  
	}
	public void down_in(int s){// ���µ���Ҫ��
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
    		if(temp.get_at()==s){
    			System.out.println("���˽�����");                      
    			opendoor();
    			checkWeightSensors();
    			closedoor();
    			break;
    		}else{ }
    	 }
		
	}
	
	public void down_out(int s){// ���µ���Ҫ��
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
    		if(temp.get_to()==s){
    			System.out.println("���˳�����");
    			opendoor();
    			down.remove(i);
    			closedoor();
    			break;
    		}else{ }
    	 }
		
	}
	
	public boolean downyouren(int s){// ¥��������
		for(int i=0;i<down.size();i++){
			Pass temp=down.get(i);
	      if(temp.get_at()<s){  
                return true; 
            }
		}
            return false;  	
	}
	public boolean downyouren1(int s){// ¥��������
		for(int i=0;i<up.size();i++){
			Pass temp=up.get(i);
	      if(temp.get_at()<s){  
                return true; 
            }
		}
            return false;  	
	}
	public boolean goUp(int s){// ����Ҫ��
		for(int i=0;i<up.size();i++){
			Pass temp=up.get(i);
	        if(temp.get_to()>s){
	        	return true;
	        }
		}
		return false;
  }
	
	public boolean goDown(int s){// ����Ҫ��
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
	       System.out.println("���أ��Ų��ܹأ�");
	     }
	 }    
	        
	 private void checkWeightSensors(){ // ����Ƿ���  
	   int weight=(int)(Math.random()*1500);       
	  }   
  }  



