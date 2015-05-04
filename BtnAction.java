import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;


class BtnAction extends AbstractAction {

	int btnnumber;
	Nandy_Game maingame;

	BtnAction(int number,Nandy_Game maingame_inst) {
		super( String.valueOf(number)+"\n" );//ボタンの名前を設定します。「putValue(Action.NAME, "ボタン");」でも設定できます。
		btnnumber = number;
		maingame  = maingame_inst;
	}
	
	BtnAction(String name,Nandy_Game maingame_inst) {
		super( name );//ボタンの名前を設定します。「putValue(Action.NAME, "ボタン");」でも設定できます。
		btnnumber = 99;
		maingame  = maingame_inst;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//ボタンが押された時の処理をここに記述します。
		//JOptionPane.showMessageDialog(null, String.valueOf(btnnumber)+"ボタンが押されました。");
		maingame.InputFunc(btnnumber);
	}

}



