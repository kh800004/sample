import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;


class BtnAction extends AbstractAction {

	int btnnumber;
	Nandy_Game maingame;

	BtnAction(int number,Nandy_Game maingame_inst) {
		super( String.valueOf(number)+"\n" );//�{�^���̖��O��ݒ肵�܂��B�uputValue(Action.NAME, "�{�^��");�v�ł��ݒ�ł��܂��B
		btnnumber = number;
		maingame  = maingame_inst;
	}
	
	BtnAction(String name,Nandy_Game maingame_inst) {
		super( name );//�{�^���̖��O��ݒ肵�܂��B�uputValue(Action.NAME, "�{�^��");�v�ł��ݒ�ł��܂��B
		btnnumber = 99;
		maingame  = maingame_inst;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�{�^���������ꂽ���̏����������ɋL�q���܂��B
		//JOptionPane.showMessageDialog(null, String.valueOf(btnnumber)+"�{�^����������܂����B");
		maingame.InputFunc(btnnumber);
	}

}



