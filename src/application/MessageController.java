package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;

public class MessageController implements Initializable{
	@FXML
	private Label message_textField;

	@FXML
	private Button ok_button;

	//入力されたメッセージを入れる
	private static String msg;

	//message_textFieldに入力されるメッセージのsetter
	public static void setMsg(String msg) {
		MessageController.msg = msg;
	}

	/*
	 * 「Message.fxml」の初期化処理
	 * 「IndexController.java」からsetterに対して渡されたメッセージをTextFieldにセットする
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		message_textField.setText(msg);
	}

	//okボタンが押されたらウィンドウを閉じる
	@FXML
	public void ok_button_onClick(Event eve) {
		Scene s = ((Node)eve.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();
	}
}
