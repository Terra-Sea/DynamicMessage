package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IndexController {
	@FXML
	private TextField message_textField;

	@FXML
	private Button showMessage_button;

	//入力されたメッセージを入れる
	private String msg;

	@FXML
	public void showMessage_button_onClick(Event event) {
		msg = message_textField.getText();
		/*
		 * message_textFieldの入力内容チェック
		 * 何も入力されていない場合、再度入力を要求するメッセージを表示させる。
		 *
		 * 「MessageController.java」のsetterに対して
		 * MessageController.setMsg();の引数としてメッセージをセットする
		 */
		if(msg.equals("")) {
			MessageController.setMsg("入力してください");
			showMessage(event);
		}else {
			MessageController.setMsg(msg);
			showMessage(event);
		}

		//表示されたら入力したメッセージを初期化
		message_textField.setText("");
	}

	/*
	 * Message.fxmlを生成するメソッド
	 */
	private void showMessage(Event event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("Message.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setTitle("メッセージ");
			stage.setScene(scene);
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
