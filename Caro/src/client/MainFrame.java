package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import common.Mess;
import common.Player;

/**
* The MainFrame class inheriting the JFrame displays all player and room and show top player
*/
@SuppressWarnings("serial")
public class MainFrame extends JFrame implements inReceiveMessage{
	ListenServer listenServer;
	ArrayList<Player> listPlayer = new ArrayList<Player>();
	ArrayList<String> listRoom = new ArrayList<String>();
	/**
	* Create a new MainFrame
	* @param listenServer ListenServer
 	*/
	public MainFrame(ListenServer listenServer){
		initComponents();
		this.listenServer = listenServer;
		listenServer.receive = this;
		try {
			listenServer.SendMessage(2, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setTitle(listenServer.player.getName());
		setVisible(true);
		setLocationRelativeTo(null);
	}
	private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();// ComboBox nhung nguoi choi dang online
        jButton1 = new javax.swing.JButton(); // Nut bam de gui loi moi choi game
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();// ComboBox nhung phong game dang choi
        jButton2 = new javax.swing.JButton(); // Nut bam de chon lam khan gia
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton("   Quit   "); 
        jPanel1.setBorder(BorderFactory.createTitledBorder("Top Player:  "));
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Play Game with: ");

        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });


        jButton1.setText("   OK   ");

        jLabel1.setText("Stream Game: ");

        //jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("   OK   ");

        jLabel2.setText("Top 1: ");

        jLabel3.setText("Player");

        jLabel5.setText("Null");

        jLabel6.setText("Top 2: ");

        jLabel7.setText("Top 3: ");

        jLabel8.setText("Null");

        jLabel9.setText("Null");
        jLabel10.setText("Win");
        jLabel11.setText("Lose");
        jLabel12.setText("-1");
        jLabel13.setText("-1");
        jLabel14.setText("-1");
        jLabel15.setText("-1");
        jLabel16.setText("-1");
        jLabel17.setText("-1");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton3.setText("Quit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2)
                                .addComponent(jButton1)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>                        
	/**
	* This method handling event player click OK to invite other player play game
	*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {  
    	try {
			listenServer.SendMessage(4, (String)this.jComboBox1.getSelectedItem());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }                                          
    /**
	* This method handling event player choose to be a watcher, watch a caro's room
	*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	try {
			listenServer.SendMessage(8,(String)this.jComboBox2.getSelectedItem());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }    
    /**
	* This method handling event player click Quit button
	*/ 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	try {
			listenServer.SendMessage(13,null);
			listenServer.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	this.dispose();
    }
    /**
	* This method add a room to ListRoom
	*/
    private void addRoom(String room){
    	boolean add = true;
    	for(String room1 : this.listRoom){
    		if(room1.compareToIgnoreCase(room)==0)
    			add = false;
    	}
    	if( add == true) listRoom.add(room);
    }
    /**
    * This method add a player to ListPlayer
    */
    private void addPlayer(Player player){
    	Player player2 = null;
    	for(Player player1 : this.listPlayer){
    		if(player1.getName().compareToIgnoreCase(player.getName())==0)
    			 player2 = player1;
    	}
    	listPlayer.add(player);
    	if(player2 != null) listPlayer.remove(player2);
    }
    /**
    * This method update all player to comboBox1
    */
    private void updateListPlayer(){
    	this.jComboBox1.removeAllItems();
    	for(Player player1 : this.listPlayer){
    		if(player1.getName().compareToIgnoreCase(listenServer.player.getName())!=0)
    			this.jComboBox1.addItem(player1.getName());
    	}
    	repaint();
    }
    /**
    * This method update all room to comboBox2
    */
    public void updateListRoom(){
    	this.jComboBox2.removeAllItems();
    	for(String nameRoom : listRoom){
    		this.jComboBox2.addItem(nameRoom);
    	}
    	repaint();
    }
    /**
    * This method set top player to panel TopPlayer
    */
    public void setTopPlayer(){
    	Player top1 = new Player("Null",-1,-1);
    	Player top2 = new Player("Null",-1,-1);
    	Player top3 = new Player("Null",-1,-1);
    	for(Player player1 : this.listPlayer){
    		if((player1.getWin()-player1.getLose())>=(top1.getWin()-top1.getLose())){
    			top3 = top2;
    			top2 = top1;
    			top1 = player1;
    		} else if((player1.getWin()-player1.getLose())>(top2.getWin()-top2.getLose())){
    			top3 = top2;
    			top2 = player1;
    		} else if((player1.getWin()-player1.getLose())>(top3.getWin()-top3.getLose()))
    			top3 = player1;
    	}
    	jLabel5.setText(top1.getName());
    	jLabel12.setText(" "+top1.getWin());
    	jLabel13.setText(" "+top1.getLose());
    	jLabel8.setText(top2.getName());
    	jLabel14.setText(" "+top2.getWin());
    	jLabel15.setText(" "+top2.getLose());
    	jLabel9.setText(top3.getName());
    	jLabel16.setText(" "+top3.getWin());
    	jLabel17.setText(" "+top3.getLose());
    	
    	repaint();
    }
    public void ReceiveMessage(Mess mess) throws IOException{
    	switch (mess.getType()) {
        case 2: { //Nhan 1 player va cap nhat lai comboBox va top player
            StringTokenizer str = new StringTokenizer((String)mess.getContent(),"|");
            String name = str.nextToken();
            addPlayer(new Player(name,Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken())));
            updateListPlayer();
            setTopPlayer();
            break;
        }
        case 3: {
        	addRoom((String)mess.getContent());
        	updateListRoom();
        	break;
        }
        case 5: {
        	final String name = (String)mess.getContent();
        	//System.out.println(name);
        	java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ConfirmFrame(listenServer, name).setVisible(true);
                }
            });
        	break;
        }
        case 7: {
        	if(mess.getContent()!=null){
        		final String name1 = (String)mess.getContent();
        		java.awt.EventQueue.invokeLater(new Runnable() {
                	public void run() {
                    	new CaroFrame(name1,listenServer,false,true).setVisible(true);
                	}
            	});
        	}
        	break;	
    	}
        case 15: {
        	boolean remove = false;
        	for(String nameRoom : listRoom){
        		if(nameRoom.compareToIgnoreCase((String)mess.getContent())==0)
        			remove = true;
        	}
        	if(remove == true) listRoom.remove((String)mess.getContent());
        	updateListRoom();
        	break;
        }
        case 13: {
        	Player player2 = null;
        	for(Player player1 : this.listPlayer){
        		if(player1.getName().compareToIgnoreCase((String)mess.getContent())==0)
        			player2 = player1;
        	}
        	if(player2!=null) this.listPlayer.remove(player2);
        	updateListPlayer();
        	setTopPlayer();
        	break;
        }
        case 16: {
        	System.out.println("fafjkafa  jafjkdaf "); 
        	StringTokenizer str = new StringTokenizer((String)mess.getContent(),"|");
        	System.out.println(str);      
        	String name = str.nextToken();
        	for(Player player1 : this.listPlayer){
        		if(player1.getName().compareToIgnoreCase(name)==0){
        			player1.setWin(Integer.parseInt(str.nextToken()));
            		player1.setLose(Integer.parseInt(str.nextToken()));
            		break;
        		}
        	}
        	setTopPlayer();
        	break;
        }
        case 9:  {
        	final int[][] board1 = (int[][]) mess.getContent();
         	java.awt.EventQueue.invokeLater(new Runnable() {
            	public void run() {
                	new CaroFrame(listenServer,(String) jComboBox2.getSelectedItem(),false,false,board1).setVisible(true);
            	}
        	});
         	break;
        }
        
    }
    }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   

}
