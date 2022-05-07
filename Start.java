package tPC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//start()������ʹ�ø��߳̿�ʼ  java�������ȥ���ø��̵߳�run()����
public class Start extends Application {

    public static void main(String[] args) {
/*
 * launch��javafx.application.Application�еľ�̬������ �ղ��� �� String[]���� ��Class<? extends Application>,String[]
 * �������� �����֣���˵��������ʹ��args��Ϊ��������ClientSocketFrmApp�е�start����
 * */
        launch(args);
    }

	@Override
//  start()������ʹ�ø��߳̿�ʼ  java�������ȥ���ø��̵߳�run()����
	public void start(Stage primaryStage) throws Exception {
//		FXMLLoader.load(url) ��ȡ���ļ�·��
		Parent root = FXMLLoader.load(this.getClass().getResource("/MyChatRoom.fxml"));
		
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("�����׸�����Ⱥ");
		primaryStage.show();
	}
}
