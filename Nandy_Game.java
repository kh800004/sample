import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Nandy_Game
{
	private int char_num  = 3;
	private int char_kind = 6;
	private int ans_times = 5;
	
	private AnsLine seikai = new AnsLine();
	private AnsLine kaitou = new AnsLine();

	private int input_offset = 0;
	private int ans_time_count = 0;
	private boolean new_ans_line_flag = true;

	//private JButton[] btn = new JButton[10];    //MAX
	JFrame frame; //フレーム
	Nandy_MainField MainField;
	Nandy_BtnField  BtnField;

	Nandy_Game(){
		System.out.println("nandy game start");
		MainField = new Nandy_MainField(char_num, ans_times);
		BtnField  = new Nandy_BtnField(char_kind,this);
		SetFrame();
		//正解のセット
		Random rnd = new Random();
		do{
			seikai.ClearLine();
			for(int i=0;i<char_num;i++){
				seikai.SetData( rnd.nextInt(char_kind)+1, i );
			}
			//seikai.SetLine(rnd.nextInt(char_kind)+1,rnd.nextInt(char_kind)+1,rnd.nextInt(char_kind)+1);
		}while(false == seikai.check_duplicate());
		System.out.println(seikai.AnsLineToStr());
	}

	void SetFrame()
	{
		//フレーム作成
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//右上の「閉じる」ボタンでアプリケーションが終了します。
		frame.setBounds(100, 100, 500, 400);
		//frame.setVisible(true);
		//パネル作成
		JPanel pane = new JPanel();
		//パネル貼り付け
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North",BtnField.pane);
		contentPane.add("Center",MainField.pane);
		frame.setVisible(true);//見せる 
	}

	void InputFunc(int input){
		System.out.println("input "+input);
		
		if(kaitou.Get_hit() == char_num || ans_times == ans_time_count){
			return;//正解済みまたは回数終了のとき
		}

		switch (input){
		case 99:
			if(false == kaitou.check_duplicate()){
				//errmsg
				JOptionPane.showMessageDialog(frame, "入力しなおして下さい");
				System.out.println("input err");
			}
			else{
				kaitou.set_hit_and_blow(seikai);
				//MainField.Add_AnsLine(kaitou.AnsLineToStr());
				MainField.Chg_AnsLine(kaitou.AnsLineToStr());
				frame.setVisible(true);//見せる 
				ans_time_count++;
				if(kaitou.Get_hit() == char_num){
					//正解のメッセージ
					JOptionPane.showMessageDialog(frame, "正解です！");
					System.out.println("ok!!!");
				}
				else if(ans_times == ans_time_count){
					//ゲームオーバーのメッセージ
					JOptionPane.showMessageDialog(frame, "ゲームオーバー");
					System.out.println("gameover!");
				}
				else{
					JOptionPane.showMessageDialog(frame, "次");
					//次の行へ
					new_ans_line_flag = true;
					kaitou.ClearLine();
				}
			}
			break;
		default:
			if(input_offset == char_num){
				input_offset=0;
			}
			kaitou.SetData(input,input_offset);
			if(new_ans_line_flag){
				MainField.Add_AnsLine(kaitou.AnsLineToStr());
				new_ans_line_flag = false;
			}
			else{
				MainField.Chg_AnsLine(kaitou.AnsLineToStr());
			}
			frame.setVisible(true);//見せる 
			input_offset++;
		}

	}


}



