import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.lang.*;
import java.awt.*;

import java.lang.*;







class Nandy_BtnField
{
	private JButton[] btn = new JButton[20];
	private int seikai_size;
	JPanel pane;

	Nandy_BtnField(int char_num,Nandy_Game maingame_inst)
	{
		System.out.println("nandy Btnfield new");
		pane = new JPanel();
		//���̓{�^���쐬
		for(int i=0; i<char_num; i++){
			btn[i] = Nandy_BtnSet(i,maingame_inst);
		}
		JButton btn2 = new JButton(new BtnAction("GO",maingame_inst));//�{�^���쐬;
		btn2.setBounds(10, 10+90+(40*char_num), 40, 70);//�{�^���̔z�u������
		pane.add(btn2);//�{�^���z�u

	}

	JButton Nandy_BtnSet(int offset,Nandy_Game maingame_inst){
		JButton btn1 = new JButton(new BtnAction(offset+1,maingame_inst));//�{�^���쐬;
		btn1.setBounds(10, 10+(40*offset), 40, 40);//�{�^���̔z�u������
		pane.add(btn1);//�{�^���z�u
		return btn1;
	}

}

