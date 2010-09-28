

/**
@author Drakonas
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.io.File;

public class WiiCovers {

    private static String[] coverTypes = {"coverfullHQ", "coverfull", "cover", "cover3D", "disc", "disccustom"};
    public static String[] coverFolders = {"boxcovers/", "boxcovers/", "covers/", "covers3D/", "discs/", "discs/"};
    private static Scanner keyboard = new Scanner(System.in);

    /** Creates a directory, if not already created
     * <p>Original script written by S.&nbsp;Dileep Kumar
     * <p>Edited to take a parameter

    @param	directory	the directory to create
     *

     */
    public static void mkDir(String directory) {
	File f = new File(directory);
	boolean exists = true;

	try {
	    f = f.getCanonicalFile();
	    exists = f.exists();
	    if (!exists) {
		f.mkdir();
		log("Directory " + f + " Created");
	    }
	    else
	    System.out.println("Directory " + f + " Found");
	} catch (IOException e) {
	    log("IO Error: Directory not reachable");
	}
	return;
    }

    public static boolean checkID(String gameid) {
	if (gameid.matches("[a-zA-Z_0-9][a-zA-Z_0-9][a-zA-Z_0-9][EJKTPR][a-zA-Z_0-9][a-zA-Z_0-9]") || gameid.matches("[a-zA-Z_0-9][a-zA-Z_0-9][a-zA-Z_0-9][EJKTPRA]")) {
	    return true;
	}
	return false;
    }

    /**
     * Obtains and saves the PNG image for the specified game and image type
     * <p>If the high quality full cover does not exist, the user will be asked if they wish to try downloading the standard full cover.
     * <p>Likewise, if the disc image does not exist, the user will be asked if they wish to try downloading the alternate disc image.
     * <p>
     * <p>This is also a re-write of the simple image-saving method, originally written by Deron Eriksson.

    @param	gameid	the 6 or 4 digit ID of the game/channel
     * <p>Example 1: SMNE01
     * <p>Example 2: HAPE

    @param	type	the type of cover to download
     * <p>Example: 0 (High quality full cover)
     * <p>
     * <p>Cover types:
     * <p>0: HQ Full Cover
     * <p>1: Standard Full Cover
     * <p>2: Front Cover
     * <p>3: 3D Cover
     * <p>4: Disc
     * <p>5: Custom/Alternate Disc

     */
    public static void saveCover(String gameid, int type) {
	URL url = null;
	InputStream is = null;
	int typeTest = type;
	log(getCoverURL(gameid, type));
	try {
	    url = new URL(getCoverURL(gameid, type));
	    is = url.openStream();
	} catch (java.io.FileNotFoundException coverNotFoundError) {
	    throw new EmptyStackException();
//	    if (type == 0)
//		return "0";
//	    else if (type == 1) {
//		throw new EmptyStackException(); //"Error: Standard cover not found. Perhaps the game doesn't exist yet?";
//	    }
//	    else if (type > 1 && type < 4)
//		return "Error: Cover not found. Perhaps it doesnt exist yet?";
//	    else if (type == 4)
//		return "4";
//	    else if (type == 5)
//		return "Error: Disc image not found. Perhaps it doesnt exist yet?";
//	    else
//		return "IO Error: Cover type format incorrect";
	} catch (java.net.MalformedURLException e) {
	    log("Error: MalformedURLException");
	} catch (java.io.IOException e) {
	    log("Error: IOException");
	}
	mkDir(coverFolders[type]);

	// Save stream to file
	OutputStream os = null;
	try {
	os = new FileOutputStream(coverFolders[type] + gameid + ".png");
	} catch (java.io.FileNotFoundException e) {
	    log("Error: FileNotFoundException");
	}

	byte[] b = new byte[2048];
	int length;

	try {
	    while ((length = is.read(b)) != -1) {
		os.write(b, 0, length);
	    }

	    is.close();
	    os.close();
	} catch (java.io.IOException e) {
	    log("Error: IOException");
	}

	// return "Saved to " + coverFolders[type] + gameid + ".png";
    }

    /**
     * Generates the image URL for the requested game/channel ID
     * Reads the 2 character country code straight from the gameID
     * For use with WiiTDB URLs only

    @param	gameid	the 6 or 4 digit ID of the game/channel
     * Example 1: SMNE01
     * Example 2: HAPE

    @param	coverType	the type of cover to download
     * <p>Example: 0 (High quality full cover)
     * <p>
     * <p>Cover types:
     * <p>0: HQ Full Cover
     * <p>1: Standard Full Cover
     * <p>2: Front Cover
     * <p>3: 3D Cover
     * <p>4: Disc
     * <p>5: Custom/Alternate Disc

    @return	the cover URL
     * <p>Returns in the format of http://wiitdb.com/wiitdb/artwork/-COVER_TYPE-/-COUNTRY_CODE-/-GAME_ID-.png

     */
    public static String getCoverURL(String gameid, int coverType) {
	String langs = "EJKTPRAI";
	String langs2 = "USJAKOZHENRUENEN";
	int langTest = langs.indexOf(gameid.charAt(3)) * 2;
	return "http://wiitdb.com/wiitdb/artwork/" + coverTypes[coverType] + "/" + langs2.substring(langTest, langTest + 2) + "/" + gameid + ".png";
    }

    private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
    }

    // Objects to throw
//    public static Throwable coverNotFound0() {
//	return new Throwable("Exception: High quality cover not found");
//    }
//
//    public static Throwable coverNotFound1() {
//	return new Throwable("Exception: High quality cover not found");
//    }
//
//    public static Throwable coverNotFound2() {
//	return new Throwable("Exception: High quality cover not found");
//    }
//
//    public static Throwable coverNotFound3() {
//	return new Throwable("Exception: High quality cover not found");
//    }
//
//    public static Throwable coverNotFound4() {
//	return new Throwable("Exception: High quality cover not found");
//    }
//
//    public static Throwable coverNotFound5() {
//	return new Throwable("Exception: High quality cover not found");
//    }

}