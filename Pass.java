package Test;

public class Pass {// �˿�
	int at;// ���ڵ�¥��
	int to;// Ҫȥ��¥��
	int key;// �˿ͱ��
	int want;// 1��ʾ�ϣ�-1��ʾ��
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


