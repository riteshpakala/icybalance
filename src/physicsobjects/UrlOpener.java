/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physicsobjects;

import java.net.*;
/**
 *
 * @author Ritesh
 */

public class UrlOpener{
    public static void openURL(String url) throws Exception{
        java.awt.Desktop.getDesktop().browse(new URI(url));
    }
}
