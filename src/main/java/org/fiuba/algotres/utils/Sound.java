package org.fiuba.algotres.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    private AudioInputStream audioInputStream;
    private Clip clip;
    private final String audioFilePath;

    public Sound(String audioFilePath){
        this.audioFilePath = audioFilePath;
    }

    public void playSound(boolean isLoop, float decibels){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(decibels);

            if(isLoop){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            clip.start();

        }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }
    
    public void stopSound(){
        clip.close();
    }
}
