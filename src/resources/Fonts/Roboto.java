package resources.Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Roboto {



    File font_file = new File("src/resources/Fonts/Roboto-Regular.ttf");
    Font font;

    {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
