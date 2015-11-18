package client;
import common.Mess;
import java.io.IOException;

/**
* The inReceiveMessage interface described the receipt and handling a message from server
*/
public interface inReceiveMessage {
    /**
     * Receive a message from server and handling it
     * @param msg A message from server
     * @throws IOException
     */
    public void ReceiveMessage(Mess msg) throws IOException;
}