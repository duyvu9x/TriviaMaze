package model;

import java.util.ArrayList;
import model.Player;

public enum Room {

	OPEN,

	CLOSE;

	public Room advance() {
		Room status = Room.OPEN;
		switch (this) {
		case OPEN:
			status = OPEN;
			break;

		case CLOSE:
			status = CLOSE;
			break;

		default:
		}
		return status;

	}

}
