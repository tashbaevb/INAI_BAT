package com.example.inai_bat.config;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicPlayer {
    private static final String DEFAULT_MUSIC = "src/main/resources/com/example/inai_bat/music/mainMusic.mp3";
    private static final String MAP1_MUSIC = "src/main/resources/com/example/inai_bat/music/firstMap.mp3";
    private static final String MAP2_MUSIC = "src/main/resources/com/example/inai_bat/music/secondMap.mp3";
    private static final String MAP3_MUSIC = "src/main/resources/com/example/inai_bat/music/thirdMap.mp3";
    private static final String DOOR_OPEN_SOUND = "src/main/resources/com/example/inai_bat/music/doorOpen.mp3";

    private static MediaPlayer mediaPlayer;
    private static MediaPlayer doorOpenSound;

    public static void playDefaultMusic() {
        playMusic(DEFAULT_MUSIC, true);
    }

    public static void playMap1Music() {
        playMusic(MAP1_MUSIC, true);
    }

    public static void playMap2Music() {
        playMusic(MAP2_MUSIC, true);
    }

    public static void playMap3Music() {
        playMusic(MAP3_MUSIC, true);
    }

    public static void playDoorOpenSound() {
        playSound(DOOR_OPEN_SOUND);
    }

    public static void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private static void playMusic(String musicFile, boolean loop) {
        stopMusic();  // Stop the current music before playing a new one
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);

        if (loop) {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Set to loop indefinitely
        }

        mediaPlayer.setOnEndOfMedia(() -> {
            // When the media ends, rewind and play it again
            mediaPlayer.seek(mediaPlayer.getStartTime());
        });

        mediaPlayer.play();
    }

    private static void playSound(String soundFile) {
        stopDoorOpenSound();
        Media sound = new Media(new File(soundFile).toURI().toString());
        doorOpenSound = new MediaPlayer(sound);
        doorOpenSound.play();
    }

    private static void stopDoorOpenSound() {
        if (doorOpenSound != null) {
            doorOpenSound.stop();
        }
    }
}
