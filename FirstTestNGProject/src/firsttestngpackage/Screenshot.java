package firsttestngpackage;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Test
public class Screenshot {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

    public void robo() throws Exception
    {
        Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File("C:\\AutoScreenshots\\"+formatter.format(now.getTime())+".jpg"));
        System.out.println(formatter.format(now.getTime()));
    }
}