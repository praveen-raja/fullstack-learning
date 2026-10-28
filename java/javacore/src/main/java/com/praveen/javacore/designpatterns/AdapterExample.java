package com.praveen.javacore.designpatterns;

/*
 * ============================================================================
 * PATTERN: Adapter (structural)
 * ----------------------------------------------------------------------------
 * Lets two INCOMPATIBLE interfaces work together by wrapping one so it looks
 * like the other.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (a travel plug adapter)
 * ----------------------------------------------------------------------------
 * Your app expects a MediaPlayer.play(type, file). The existing
 * AdvancedAudioPlayer only has playVlc()/playMp4() - wrong shape. AudioAdapter
 * IMPLEMENTS MediaPlayer and, inside play(), translates the call into the right
 * playVlc()/playMp4() on the advanced player. The adapter is the plug converter
 * between the socket you have and the plug you need.
 *
 * Roles:
 *   MediaPlayer         -> target interface the client wants
 *   AdvancedAudioPlayer -> adaptee with an incompatible API
 *   AudioAdapter        -> translates target calls into adaptee calls
 * ============================================================================
 */

// 1. The Target Interface (What our modern app expects)
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// 2. The Legacy/Advanced Library (Incompatible interface)
class AdvancedAudioPlayer {
    public void playVlc(String fileName) { System.out.println("Playing vlc file: " + fileName); }
    public void playMp4(String fileName) { System.out.println("Playing mp4 file: " + fileName); }
}

// 3. The Adapter (The bridge)
class AudioAdapter implements MediaPlayer {
    AdvancedAudioPlayer advancedPlayer = new AdvancedAudioPlayer();

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        }
    }
}

// 4. The Concrete Class
class AudioPlayer implements MediaPlayer {
    AudioAdapter adapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } 
        // Use the adapter for other formats
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            adapter = new AudioAdapter();
            adapter.play(audioType, fileName);
        }
    }
}

// Usage
public class AdapterExample {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "beyond_the_horizon.mp3");
        player.play("mp4", "alone.mp4");
        player.play("vlc", "far_far_away.vlc");
    }
}