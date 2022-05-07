package tPC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//start()方法会使得该线程开始  java虚拟机会去调用该线程的run()方法
public class Start extends Application {

    public static void main(String[] args) {
/*
 * launch是javafx.application.Application中的静态方法有 空参数 和 String[]参数 和Class<? extends Application>,String[]
 * 两个参数 共三种，你说的这种是使用args作为参数调用ClientSocketFrmApp中的start方法
 * */
        launch(args);
    }

	@Override
//  start()方法会使得该线程开始  java虚拟机会去调用该线程的run()方法
	public void start(Stage primaryStage) throws Exception {
//		FXMLLoader.load(url) 获取此文件路径
		Parent root = FXMLLoader.load(this.getClass().getResource("/MyChatRoom.fxml"));
		
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("世界首富交流群");
		primaryStage.show();
	}
}
