package common;

import java.io.Serializable;

/**
 * The Mess class describes a message
 *
 */
@SuppressWarnings("serial")
public class Mess implements Serializable {
	private int type;
	private Object content;
	/**
	 * The constructor with parameters
	 * @param aType type of message (a number)
	 * @param anObject message content (an object)
	 */
	public Mess(int aType, Object anObject){
		this.type = aType;
		this.content = anObject;
	}
	/**
	 * The setType methods setting the type for message
	 * @param aType type of message
	 */
	public void setType(int aType){
		this.type = aType;
	}
	/**
	 * The setContent methods setting content of the message
	 * @param anObject message content
	 */
	public void setContent(Object anObject){
		this.content = anObject;
	}
	/**
	 * The getType methods getting the type of message
	 * @return type of message
	 */
	public int getType(){
		return this.type;
	}
	/**
	 * The getContent methods getting content of the message
	 * @return message content
	 */
	public Object getContent(){
		return this.content;
	}
}
