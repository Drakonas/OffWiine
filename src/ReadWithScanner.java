/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @(#)ReadWithScanner.java
 *
 *  application
 *
 * @author Drakonas
 * @version 1.00 Sep 20, 2010
 */

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/** A class used for parsing text files line by line, reading game IDs and
 * game names from each line.
 *
 * @author Drakonas
 */
public final class ReadWithScanner {
    /** An {@link ArrayList} used by {@link #processLineByLine()} to contain
     * game IDs. (later used in OffWiine.chooseGameFrame)
     */
    public ArrayList<String> gameIDs = null;
    /** An {@link ArrayList} used by {@link #processLineByLine()} to contain
     * game names. (later used in OffWiine.chooseGameFrame)
     */
    public ArrayList<String> gameNames = null;

  /** Constructor
  * @param aFileName full name of an existing, readable file.
  */
    public ReadWithScanner(String aFileName){
	fFile = new File(aFileName);
	gameIDs = new ArrayList<String>(gameIDs);
	gameNames = new ArrayList<String>(gameNames);
    }

  /** Template method that calls {@link #processLine(String)}. 
   * <p>Every time a line is processed, the game ID and game name is added to
   * the private variables, gameIDs and gameNames, respectively.
   *
   @throws java.io.FileNotFoundException
   */
    public final void processLineByLine() throws FileNotFoundException {
	Scanner scanner = new Scanner(fFile);
	try {
	    // Use a Scanner to get each line, reading the returned array's
	    // values and placing them in gameIDs and gameNames, separately
	    String[] returnArray = null;
	    int count = -1;
		while ( scanner.hasNextLine() ) {
		    count++;
		    returnArray = processLine( scanner.nextLine() );
		    if (returnArray[1].equals(" ") && returnArray[2].equals(" ")) {
			// Continue
		    }
		    else {
		    gameIDs.add(returnArray[1]);
		    gameNames.add(returnArray[2]);
		    }
		}
	}
	finally {
	    // Ensure the underlying stream is always closed
	    scanner.close();
	}
    }

  /**
   * Method for processing line of input (used in {@link #processLineByLine()}).
   *
   * <P>This method processes a {@link Scanner} object, expecting simple
   * gameID-gameName pairs, separated by an '=' sign. Examples of valid input:
   * <p>RSBE01 = SSBB</tt>
   * <p>Note: The name of the game does not matter. This is what is displayed
   * to a user when the OffWiine.chooseGameFrame frame is displayed
   */
  private String[] processLine(String aLine) {
    //use a second Scanner to parse the content of each line
    Scanner scanner = new Scanner(aLine);
    scanner.useDelimiter("=");
    String[] returnArray = null;
    if ( scanner.hasNext() ){
      String gameID = scanner.next();
      String name = scanner.next();
      log("ID: '" + quote(gameID.trim()) + "', Game: " + quote(gameID.trim()) );
      returnArray = new String[] {quote(gameID.trim()),quote(name.trim())};
    }
    else {
      log("Empty or invalid line. Unable to process.");
      returnArray = new String[] {" "," "};
    }
    //(no need for finally here, since String is source)
    scanner.close();
    return returnArray;
  }

  // PRIVATE //
  private final File fFile;

  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }

  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
}