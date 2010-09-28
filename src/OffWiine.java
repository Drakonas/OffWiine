/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OffWiine.java
 *
 * Created on Sep 20, 2010, 12:49:57 AM
 */

/**
 *
 * @author Drakonas
 */

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EmptyStackException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

/** This program is for downloading all current types of Wii game covers.
 * This project was made mainly for those who don't have Wii's connected to the
 * Internet. Clearly, the easiest way to get covers for USB Loaders,
 * in general, is by downloading them directly to the SD card using those
 * respected loaders; hence, I created this program.
 *
 * <p> This is my first program release, and I want it to be a useful one.
 * Because there were no WBFS managers out there that supported full,
 * high quality covers, I decided to take it into my own hands and
 * create the program myself.
 *
 * <p>I chose Java mainly because it is the first language I have grown
 * accustomed to (and the only one I have taken classes for, in college.
 * Of course, it is also because I wanted to make it cross-platform supportive,
 * and I thought the easiest way to do that was to create it in Java.
 *
 * <p>I hope you like the program, and I hope that people will take the source,
 * and put it to good use. Before I even started I knew I was going to make it
 * open-source, simply because I believe it's not giving to the community,
 * unless you give the community the tools to build upon what you have given
 * them.
 *
 * <p>Thanks,
 * <p>&nbsp;&nbsp;Drakonas

 @author Drakonas
 */
public class OffWiine extends javax.swing.JFrame {
    private String[] failStrings = new String[]{"HQ full cover not found","Standard full cover not found","Front cover not found","3D cover not found","Original disc not found","Alternate/custom disc not found"};
    private File currentDir = null;
    Image appIcon = createImageIcon("images/icon.png", "This is the application icon.").getImage();

    /** Creates new form OffWiine */
    public OffWiine() {
	// Set Nimbus L&F
	try {
	    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	}
	catch (javax.swing.UnsupportedLookAndFeelException e) {
	    // Continue...
	}
	catch (java.lang.ClassNotFoundException e) {
	    // Continue...
	}
	catch (java.lang.InstantiationException e) {
	    // Continue...
	}
	catch (java.lang.IllegalAccessException e) {
	    // Continue...
	}
	// Check if integrating with OS functions is supported
	if (Desktop.isDesktopSupported())
	    Desktop.getDesktop();
        initComponents();
	currentDir = new File(getCurrentDirectory());
	textFileBrowser.setCurrentDirectory(currentDir);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coverRadioGroup = new javax.swing.ButtonGroup();
        fileBrowserFrame = new javax.swing.JFrame();
        textFileBrowser = new javax.swing.JFileChooser();
        dialogFrame = new javax.swing.JFrame();
        inputTypeRadioGroup = new javax.swing.ButtonGroup();
        chooseGameFrame = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        gameIDTextfield = new javax.swing.JTextField();
        gameIDLabel = new javax.swing.JLabel();
        coverTypeLabel = new javax.swing.JLabel();
        coverRadio1 = new javax.swing.JRadioButton();
        coverRadio2 = new javax.swing.JRadioButton();
        coverRadio3 = new javax.swing.JRadioButton();
        coverRadio4 = new javax.swing.JRadioButton();
        coverRadio5 = new javax.swing.JRadioButton();
        coverRadio6 = new javax.swing.JRadioButton();
        statusLabel = new javax.swing.JLabel();
        downloadButton = new javax.swing.JButton();
        gameIDRadio = new javax.swing.JRadioButton();
        textFileRadio = new javax.swing.JRadioButton();
        textFileField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        imageLabel1 = new javax.swing.JLabel();
        gameChooseButton = new javax.swing.JButton();

        fileBrowserFrame.setTitle("Open file...");
        fileBrowserFrame.setResizable(false);

        javax.swing.GroupLayout fileBrowserFrameLayout = new javax.swing.GroupLayout(fileBrowserFrame.getContentPane());
        fileBrowserFrame.getContentPane().setLayout(fileBrowserFrameLayout);
        fileBrowserFrameLayout.setHorizontalGroup(
            fileBrowserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileBrowserFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFileBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fileBrowserFrameLayout.setVerticalGroup(
            fileBrowserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileBrowserFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFileBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dialogFrame.setResizable(false);

        javax.swing.GroupLayout dialogFrameLayout = new javax.swing.GroupLayout(dialogFrame.getContentPane());
        dialogFrame.getContentPane().setLayout(dialogFrameLayout);
        dialogFrameLayout.setHorizontalGroup(
            dialogFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        dialogFrameLayout.setVerticalGroup(
            dialogFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        chooseGameFrame.setTitle("Choose Game(s)");

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Download Covers");

        jButton2.setText("Cancel");

        javax.swing.GroupLayout chooseGameFrameLayout = new javax.swing.GroupLayout(chooseGameFrame.getContentPane());
        chooseGameFrame.getContentPane().setLayout(chooseGameFrameLayout);
        chooseGameFrameLayout.setHorizontalGroup(
            chooseGameFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseGameFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chooseGameFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseGameFrameLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        chooseGameFrameLayout.setVerticalGroup(
            chooseGameFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseGameFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(chooseGameFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OffWiine");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(appIcon);
        setResizable(false);

        gameIDTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameIDTextfieldMouseClicked(evt);
            }
        });
        gameIDTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameIDTextfieldActionPerformed(evt);
            }
        });

        gameIDLabel.setText("Game ID");

        coverTypeLabel.setText("Cover Type:");

        coverRadioGroup.add(coverRadio1);
        coverRadio1.setSelected(true);
        coverRadio1.setText("HQ Full Cover");

        coverRadioGroup.add(coverRadio2);
        coverRadio2.setText("Standard Full Cover");

        coverRadioGroup.add(coverRadio3);
        coverRadio3.setText("Front Cover");

        coverRadioGroup.add(coverRadio4);
        coverRadio4.setText("3D Cover");

        coverRadioGroup.add(coverRadio5);
        coverRadio5.setText("Original Disc Image");

        coverRadioGroup.add(coverRadio6);
        coverRadio6.setText("Alternate Disc Image");

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText(" ");

        downloadButton.setText("Download");
        downloadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });

        inputTypeRadioGroup.add(gameIDRadio);
        gameIDRadio.setSelected(true);

        inputTypeRadioGroup.add(textFileRadio);
        textFileRadio.setText("Text File:");

        textFileField.setToolTipText(textFileField.getText());
        textFileField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFileFieldKeyReleased(evt);
            }
        });

        browseButton.setText("Open...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        imageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dl-not.png"))); // NOI18N
        imageLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imageLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imageLabel1.setMaximumSize(new java.awt.Dimension(160, 224));
        imageLabel1.setMinimumSize(new java.awt.Dimension(160, 224));
        imageLabel1.setPreferredSize(new java.awt.Dimension(160, 224));

        gameChooseButton.setText("Choose Games...");
        gameChooseButton.setEnabled(false);
        gameChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameChooseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gameIDRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gameIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gameIDLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFileField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFileRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gameChooseButton)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coverTypeLabel)
                            .addComponent(coverRadio1)
                            .addComponent(coverRadio3)
                            .addComponent(coverRadio4)
                            .addComponent(coverRadio5)
                            .addComponent(coverRadio6)
                            .addComponent(coverRadio2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(downloadButton)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gameIDLabel)
                            .addComponent(gameIDRadio)
                            .addComponent(gameIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(coverTypeLabel)
                        .addGap(1, 1, 1)
                        .addComponent(coverRadio1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coverRadio2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coverRadio3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coverRadio4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coverRadio5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coverRadio6)
                        .addGap(27, 27, 27)
                        .addComponent(downloadButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFileRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton)
                    .addComponent(gameChooseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(statusLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gameIDTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameIDTextfieldActionPerformed
	setCursor(new Cursor(Cursor.WAIT_CURSOR));
	downloadCover();
	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_gameIDTextfieldActionPerformed

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
	setCursor(new Cursor(Cursor.WAIT_CURSOR));
	downloadCover();
	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_downloadButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
	// Check if open button was pressed.
	if (evt.getSource() == browseButton) {
	    int buttonClicked = textFileBrowser.showOpenDialog(OffWiine.this);
	    if (buttonClicked == JFileChooser.APPROVE_OPTION) {
		File textFile = textFileBrowser.getSelectedFile();
		textFileField.setText(textFile.getPath());
		textFileField.setToolTipText(textFile.getPath());
		statusLabel.setText("Opened: " + textFile.getName() + ".");
		textFileRadio.setSelected(true);
		gameChooseButton.setEnabled(true);
	    } else {
		statusLabel.setText("Open command cancelled by user.");
	    }
	}
    }//GEN-LAST:event_browseButtonActionPerformed

    private void gameIDTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameIDTextfieldMouseClicked
	gameIDRadio.setSelected(true);
    }//GEN-LAST:event_gameIDTextfieldMouseClicked

    private void textFileFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFileFieldKeyReleased
	if (textFileField.getText().equals(""))
	    gameChooseButton.setEnabled(false);
	else
	    gameChooseButton.setEnabled(true);
	textFileField.setToolTipText(textFileField.getText());
    }//GEN-LAST:event_textFileFieldKeyReleased

    private void gameChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameChooseButtonActionPerformed
	//parseFile();
    }//GEN-LAST:event_gameChooseButtonActionPerformed

    /** Starts the interface.
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OffWiine().setVisible(true);
            }
        });
    }

    /** Downloads a cover using WiiCovers.saveCover() method, and
     * tells the user success or the various failures,
     * by ways of changing the label, statusLabel.
     * <h4>First download trial</h4>
     * <p>Tries to save the specified cover to its related folder.&nbsp;
     * If EmptyStackException is caught, the cover was not found.&nbsp;
     * Although, if EmptyStackException is caught and the coverType is 0 or
     * 4, it asks the user, using a Confirm Dialog, if they want to download
     * an alternate image.&nbsp;(Standard full cover or custom disc image)
     */
    public void downloadCover() {
	log("Preparing to download...");
	String gameID = gameIDTextfield.getText();
	// Check to make sure game ID is not empty
	if (gameID.equals("")) {
	    log("Error: Game ID not specified");
	    statusLabel.setText("Error: Game ID not specified");
	    return;
	}
	// Check to make sure game ID is not incorrectly stated
	if (!WiiCovers.checkID(gameID)) {
	    log("Error: Game ID format incorrect");
	    statusLabel.setText("Error: Game ID format incorrect");
	    return;
	}
	// Obtain the coverType from its respective radio
	int coverType = 0;
	if (coverRadio1.isSelected())
	    coverType = 0;
	else if (coverRadio2.isSelected())
	    coverType = 1;
	else if (coverRadio3.isSelected())
	    coverType = 2;
	else if (coverRadio4.isSelected())
	    coverType = 3;
	else if (coverRadio5.isSelected())
	    coverType = 4;
	else if (coverRadio6.isSelected())
	    coverType = 5;
	// Initialize returnString, so later success will display nothing
	String returnString = " ";

	// First trial
	try {
	    WiiCovers.saveCover(gameID, coverType);
	    
	} catch (EmptyStackException coverNotFoundException) {
	    returnString = failStrings[coverType];
	    int coverNotFound = 1;
	    if (coverType == 0) {
		coverNotFound = JOptionPane.showConfirmDialog(
		dialogFrame,
		"Error: HQ full cover not found. Try downloading standard full cover?",
		"Cover not found",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.ERROR_MESSAGE);
	    }
	    else if(coverType == 4) {
		coverNotFound = JOptionPane.showConfirmDialog(
		dialogFrame,
		"Error: Disc image not found. Try downloading alternate disc image?",
		"Disc image not found",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.ERROR_MESSAGE);
	    }
	    // Second, optional trial
	    if (coverNotFound == 0) {
		coverType++;
		try {
		    WiiCovers.saveCover(gameID, coverType);
		} catch (EmptyStackException coverNotFoundException2) {
		    returnString = failStrings[coverType];
		}
	    }

	    // Display output
	    statusLabel.setText(returnString);
	    log(returnString);
	    return;
	}
	// Check if the game's cover/disc image is already downloaded
	boolean exists = (new File(WiiCovers.coverFolders[2] + gameID + ".png")).exists();
	if (exists) {
	    log(gameID + ".png exists. Reading from file...");
	    imageLabel1.setIcon(new ImageIcon(WiiCovers.coverFolders[2] + gameID + ".png"));
	} else {
	    log("Buffering image to display from URL...");
	    URL url = null;
	    // Try to get the URL
	    try {
		url = new URL(WiiCovers.getCoverURL(gameID, 2));
		imageLabel1.setIcon(new ImageIcon(url));
	    } catch (MalformedURLException ex) {
		// Failed to find image, sets the image displayed to the default
		log("Error: Front cover not found, displaying main image");
		imageLabel1.setIcon(new ImageIcon(getClass().getResource("images/dl-not.png")));
		return;
	    }
	    // Displays the success in statusLabel and the prompt
	    returnString = "Saved to " + WiiCovers.coverFolders[coverType] + gameID + ".png";
	    statusLabel.setText(returnString);
	    log(returnString);
	}
    }

    /**
     *
     */
    public void parseText() {

    }

    /** Displays a string or value as a line in prompt
     *
     * @param aObject The string/value to display
     */
    private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
    }

    /** Gets the current directory and returns it
     @return	The current directory
     */
    public String getCurrentDirectory() {
	File dir = new File (".");
	try {
	    return dir.getCanonicalPath();
	} catch (IOException ex) {
	    log("Error getting current directory");
	}
	return ".";
    }

    /** Creates an ImageIcon from a resource within the source packages
     
     * @param url   the path to the image, within the source packages
     * @param description   a description for the image
     * @return	an IconImage representing the given image file in the url
     * parameter.&nbsp; If no image is found, returns null
     */
    public ImageIcon createImageIcon(String url, String description) {
	URL imageUrl = getClass().getResource(url);
	if (imageUrl == null) {
	    System.out.println("No image found at " + imageUrl);
	    return null;
	} else {
	    return new ImageIcon(imageUrl, description);
}
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JFrame chooseGameFrame;
    private javax.swing.JRadioButton coverRadio1;
    private javax.swing.JRadioButton coverRadio2;
    private javax.swing.JRadioButton coverRadio3;
    private javax.swing.JRadioButton coverRadio4;
    private javax.swing.JRadioButton coverRadio5;
    private javax.swing.JRadioButton coverRadio6;
    private javax.swing.ButtonGroup coverRadioGroup;
    private javax.swing.JLabel coverTypeLabel;
    private javax.swing.JFrame dialogFrame;
    private javax.swing.JButton downloadButton;
    private javax.swing.JFrame fileBrowserFrame;
    private javax.swing.JButton gameChooseButton;
    private javax.swing.JLabel gameIDLabel;
    private javax.swing.JRadioButton gameIDRadio;
    private javax.swing.JTextField gameIDTextfield;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.ButtonGroup inputTypeRadioGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JFileChooser textFileBrowser;
    private javax.swing.JTextField textFileField;
    private javax.swing.JRadioButton textFileRadio;
    // End of variables declaration//GEN-END:variables
}