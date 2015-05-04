import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.lang.*;


class Nandy_MainField
{
	private String ansline[];
	private int str_count = 0;
	private int seikai_size;

	JLabel last_label;
	
	JPanel pane;
	JTextArea textArea;

	Nandy_MainField(int char_num, int ans_times)
	{
		System.out.println("nandy field new");
		pane = new JPanel();
		pane.setLayout(new GridLayout(ans_times+1,1));
		seikai_size = char_num;
	}

	void Add_AnsLine(String in){
		str_count++; //ラベルの位置を更新
		// ラベルのインスタンスを生成
		last_label = new JLabel(in,SwingConstants.LEFT);
		last_label.setFont(new Font("Arial", Font.PLAIN, 24));
		//label.setBounds(10+(40*str_count), 10, 200, 50);//ラベルの配置を決定
		//label.setVerticalAlignment(JLabel.BOTTOM);
		System.out.println(str_count);
		pane.add(last_label);
	}

	void Chg_AnsLine(String in){
		System.out.println("cccheck");
		System.out.println(in);
		// ラベルの表示変更
		last_label.setText(in + "\n");
	}

	void ALLCLR_AnsLine(String in){
	}

}







