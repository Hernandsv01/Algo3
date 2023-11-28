package org.fiuba.algotres.utils;

import javafx.scene.image.Image;
import org.fiuba.algotres.utils.enums.DefaultImageType;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;

public class ImageLoader {

    public static Image getJavafxImage(String url, DefaultImageType defaultImage){
        InputStream imageStream = ImageLoader.class.getResourceAsStream(url);
        if(imageStream == null){
            return new Image(Objects.requireNonNull(ImageLoader.class.getResourceAsStream(defaultImage.getDefaultURL())));
        }
        return new Image(imageStream);
    }
}
