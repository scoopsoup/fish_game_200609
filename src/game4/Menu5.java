package game4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import java.io.File;

public class Menu5 extends Thread{
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Menu5(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Menu5.class.getResource("../Music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() {
		if(player == null) {
			return 0;
		}
		else {
			return player.getPosition();
		}
	}
	
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	public void resumeSong(){
		isLoop = true;
		this.notify();
	}
	
	public void pause(){
		isLoop = false;
	}
	
	@Override
	public void run() {
		try {
			while(isLoop) {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


}



