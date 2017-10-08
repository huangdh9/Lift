package Test;

public class Pass {// 乘客
	int at;// 所在的楼层
	int to;// 要去的楼层
	int key;// 乘客编号
	int want;// 1表示上，-1表示下
	public Pass(int at, int to, int key, int want)
	{
		this.at=at;
		this.to=to;
		this.key=key;
		this.want=want;
	}
	public int get_to(){
		return to;
	}
	public int get_at(){
		return at;
	}
}


