package com.hackhalo2.rendering.interfaces.sound;

public interface ISoundObject {
	
	public void play();
	public void playInBackground();
	public void playInBackground(boolean looped);
	public boolean isPlaying();
	
	public void pause();
	
	public void mute();
	public void unmute();
	public boolean isMuted();
	
	public void stop();
	
	public void setVolume(int volume);
	public int getVolume();
	
	public String getName();
	public boolean isLooping();
	
	public void load();
	public void setupStream(boolean priority, boolean looped, int attenuation, float distOrRoll);
	
}