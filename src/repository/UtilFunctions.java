package repository;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author nixrajput
 */
public class UtilFunctions {

    public static ImageIcon resizeImage(String photopath, byte[] photo, javax.swing.JLabel photoLabel) {
        ImageIcon myPhoto = null;
        if (photopath != null) {
            myPhoto = new ImageIcon(photopath);
        } else {
            myPhoto = new ImageIcon(photo);
        }
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ph = new ImageIcon(img1);
        return ph;
    }
}
