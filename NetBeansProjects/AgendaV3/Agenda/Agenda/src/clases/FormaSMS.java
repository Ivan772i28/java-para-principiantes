package clases;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;

import javax.microedition.io.Connector;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public class FormaSMS extends Form implements CommandListener {

	TextField mensaje;
	Command atras, enviar;
	String destinatario;

	public FormaSMS(String dest) {
		super("Mensaje a "+dest);
		destinatario=dest;
		mensaje = new TextField("Mensaje", "", 140, TextField.ANY);
		mensaje.setPreferredSize(getWidth()-10,getHeight()-10);
		append(mensaje);
		atras = new Command("Atras", Command.EXIT, 0);
		enviar = new Command("Enviar", Command.OK, 1);
		addCommand(atras);
		addCommand(enviar);
		setCommandListener(this);
	}

	public void commandAction(Command arg0, Displayable arg1) {
		if (arg0.equals(atras)) {
			
		} else {
			enviarSMS();
		}
	}

	public void enviarSMS() {
		MessageConnection conn = null;
		TextMessage msg = null;
		try {
			conn = (MessageConnection) Connector.open("sms://"
					+ destinatario);
			msg = (TextMessage) conn.newMessage(MessageConnection.TEXT_MESSAGE);
			msg.setPayloadText(mensaje.getString());
			conn.send(msg);
			conn.close();
		} catch (InterruptedIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}