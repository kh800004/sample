
class AnsLine{
	
	private int[] data = new int[10];
	private int data_size;
	private int hit = 99;
	private int blow= 99;

	int Get_datasize(){
		return data_size;
	}
	int Get_hit(){
		return hit;
	}

	void SetLine(int in_a1,int in_a2,int in_a3){
		data[0]=in_a1;
		data[1]=in_a2;
		data[2]=in_a3;
		data_size = 3;
	}
	
	void ClearLine(){
		for(int i=0;i<10;i++) data[i] = 0;
		hit = blow = 99;
	}

	void SetData(int indata,int offset){
		data[offset] = indata;
		if(offset + 1 >= data_size){
			data_size = offset + 1;
		}
		
	}

	boolean check_duplicate(){
		for(int i=0;i<data_size-1;i++){
			for(int j=i+1;j<data_size;j++){
				if(data[i] == data[j]) return false;
			}
		}
		return true;
	}

	void set_hit_and_blow(AnsLine indata){
		int hit_count=0;
		int blow_count=0;
		
		for(int i=0;i<data_size;i++){
			for(int j=0;j<data_size;j++){
				if(indata.data[i]==data[j]){
					if(i==j) hit_count++;
					else     blow_count++;
				}
			}
		}
		hit  = hit_count;
		blow = blow_count;
	}

	String AnsLineToStr(){
		
		String ret = new String("      ");
		for(int i=0;i<data_size;i++){
			ret = ret + data[i] + " " ;
		}
		if(hit != 99 && blow != 99){
			ret = ret + "     H:" + hit + "  B:" + blow ;
		}
		
		return ret;
	}

}






