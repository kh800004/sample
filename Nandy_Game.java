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
	JFrame frame; //�t���[��
	Nandy_MainField MainField;
	Nandy_BtnField  BtnField;

	Nandy_Game(){
		System.out.println("nandy game start");
		MainField = new Nandy_MainField(char_num, ans_times);
		BtnField  = new Nandy_BtnField(char_kind,this);
		SetFrame();
		//�����̃Z�b�g
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
		//�t���[���쐬
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�E��́u����v�{�^���ŃA�v���P�[�V�������I�����܂��B
		frame.setBounds(100, 100, 500, 400);
		//frame.setVisible(true);
		//�p�l���쐬
		JPanel pane = new JPanel();
		//�p�l���\��t��
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North",BtnField.pane);
		contentPane.add("Center",MainField.pane);
		frame.setVisible(true);//������ 
	}

	void InputFunc(int input){
		System.out.println("input "+input);
		
		if(kaitou.Get_hit() == char_num || ans_times == ans_time_count){
			return;//�����ς݂܂��͉񐔏I���̂Ƃ�
		}

		switch (input){
		case 99:
			if(false == kaitou.check_duplicate()){
				//errmsg
				JOptionPane.showMessageDialog(frame, "���͂��Ȃ����ĉ�����");
				System.out.println("input err");
			}
			else{
				kaitou.set_hit_and_blow(seikai);
				//MainField.Add_AnsLine(kaitou.AnsLineToStr());
				MainField.Chg_AnsLine(kaitou.AnsLineToStr());
				frame.setVisible(true);//������ 
				ans_time_count++;
				if(kaitou.Get_hit() == char_num){
					//�����̃��b�Z�[�W
					JOptionPane.showMessageDialog(frame, "�����ł��I");
					System.out.println("ok!!!");
				}
				else if(ans_times == ans_time_count){
					//�Q�[���I�[�o�[�̃��b�Z�[�W
					JOptionPane.showMessageDialog(frame, "�Q�[���I�[�o�[");
					System.out.println("gameover!");
				}
				else{
					JOptionPane.showMessageDialog(frame, "��");
					//���̍s��
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
			frame.setVisible(true);//������ 
			input_offset++;
		}

	}


}



