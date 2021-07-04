package game_client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import game_server.GameProtocol;

public class KeyController implements KeyListener {

	private GameProtocol handler;
	private PlayerEvents event_handler;

	public KeyController(GameProtocol handler, PlayerEvents event_handler) {
		this.handler = handler;
		this.event_handler = event_handler;
	}

	@Override
	public synchronized void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_W:
			event_handler.UpLeftPressed(null);
			break;
		case KeyEvent.VK_X:
			event_handler.UpRightPressed(null);
			break;
		case KeyEvent.VK_SPACE:
			event_handler.UpPressed(null);
			break;
		case KeyEvent.VK_S:
			event_handler.DownPressed(null);
			break;
		case KeyEvent.VK_D:
			event_handler.RightPressed(null);
			break;
		case KeyEvent.VK_Q:
			event_handler.LeftPressed(null);
			break;
		case KeyEvent.VK_E:
			event_handler.BlockPressed(null);
			break;
		default:
			event_handler.None();
			break;
		}

	}

	@Override
	public synchronized void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_W:
			event_handler.None();
			break;
		case KeyEvent.VK_X:
			event_handler.None();
			break;
		case KeyEvent.VK_Z:
			event_handler.None();
			break;
		case KeyEvent.VK_SPACE:
			event_handler.None();
			break;
		case KeyEvent.VK_S:
			event_handler.None();
			break;
		case KeyEvent.VK_D:
			event_handler.None();
			break;
		case KeyEvent.VK_Q:
			event_handler.None();
			break;
		default:
			event_handler.None();
			break;
		}

	}

	@Override
	public synchronized void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
