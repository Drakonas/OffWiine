/** OffWiine - Text Parser
 * Copyright (C) 2010  Nathan Dick
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *

@author Drakonas
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
    private File fFile;

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
	gameIDs = new ArrayList<String>();
	gameNames = new ArrayList<String>();
    }

  /** Template method that calls {@link #processLine(String)}. 
   * <p>Every time a line is processed, the game ID and game name is added to
   * the private variables, gameIDs and gameNames, respectively.
   *
   @throws java.io.FileNotFoundException
   */
    public final void processLineByLine() throws FileNotFoundException {
	Scanner scanner = null;
	try {
	    scanner = new Scanner(fFile);
	} catch (IOException ex) {
	    log("Error: IOException");
	    throw new java.util.EmptyStackException();
	}
	try {
	    // Use a Scanner to get each line, reading the returned array's
	    // values and placing them in gameIDs and gameNames, separately
	    String[] returnArray = null;
	    int count = -1;
		while ( scanner.hasNextLine() ) {
		    count++;
		    returnArray = processLine( scanner.nextLine() );
		    if (returnArray[0].equals(" ") && returnArray[1].equals(" ")) {
			// Continue
		    }
		    else {
		    gameIDs.add(returnArray[0]);
		    gameNames.add(returnArray[1]);
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
      if (gameID.length() == 8)
	  gameID = gameID.substring(1);
      log("ID: " + gameID.trim() + ", Game: " + name.trim());
      returnArray = new String[] {gameID.trim(),name.trim()};
    }
    else {
      log("Empty or invalid line. Unable to process.");
      returnArray = new String[] {" "};
    }
    //(no need for finally here, since String is source)
    scanner.close();
    return returnArray;
  }
  
  

  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }

  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
}