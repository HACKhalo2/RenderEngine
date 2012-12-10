package com.hackhalo2.rendering;

import com.hackhalo2.rendering.RenderEngine.PlugMode;
import com.hackhalo2.rendering.core.MIDISoundSystem;
import com.hackhalo2.rendering.interfaces.IChassis;
import com.hackhalo2.rendering.interfaces.IEntityManager;
import com.hackhalo2.rendering.interfaces.INetworkManager;
import com.hackhalo2.rendering.interfaces.ISettingsManager;
import com.hackhalo2.rendering.interfaces.ISoundSystem;

public class Chassis implements IChassis {
	
	//The Chassis systems
	private ISoundSystem soundSystem = null;
	private IEntityManager entityManager = null;
	private INetworkManager networkManager = null;
	private ISettingsManager settingsManager = null;
	private RenderEngine renderEngine = null;
	private CameraManager cameraManager = null;
	private KeyboardBuffer keyboardBuffer = null;
	
	//the finalized boolean
	private boolean finalized = false;

	public Chassis() {
		this.cameraManager = new CameraManager();
		this.keyboardBuffer = new KeyboardBuffer();
	}

	@Override
	public void setSoundSystem(ISoundSystem soundSystem) {
		if(!this.finalized) this.soundSystem = soundSystem;
		else throw new UnsupportedOperationException("The Chassis has been finalized, you cannot swap systems now");
	}

	@Override
	public ISoundSystem getSoundSystem() {
		return this.soundSystem;
	}

	@Override
	public void setEntityManager(IEntityManager entityManager) {
		if(!this.finalized) this.entityManager = entityManager;
		else throw new UnsupportedOperationException("The Chassis has been finalized, you cannot swap systems now");
	}

	@Override
	public IEntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public RenderEngine getRenderEngine() {
		return this.renderEngine;
	}

	@Override
	public CameraManager getCameraManager() {
		return this.cameraManager;
	}

	@Override
	public KeyboardBuffer getKeyboardBuffer() {
		return this.keyboardBuffer;
	}

	@Override
	public void setNetworkManager(INetworkManager networkManager) {
		if(!this.finalized) this.networkManager = networkManager;
		else throw new UnsupportedOperationException("The Chassis has been finalized, you cannot swap systems now");
	}

	@Override
	public INetworkManager getNetworkManager() {
		return this.networkManager;
	}

	@Override
	public void setSettingsManager(ISettingsManager settingsManager) {
		if(!this.finalized) this.settingsManager = settingsManager;
		else throw new UnsupportedOperationException("The Chassis has been finalized, you cannot swap systems now");
	}

	@Override
	public ISettingsManager getSettingsManager() {
		return this.settingsManager;
	}

	@Override
	public void initialize() {
		//Finalize the Chassis
		this.finalized = true;
		//TODO initialize any null objects here with built in implementations
		
		//Initialize the SoundSystem
		if(this.soundSystem == null) this.soundSystem = new MIDISoundSystem(); //Fallback if no SoundSystem was supplied
		this.soundSystem.initialize();
		
		//Instance the RenderEngine
		this.renderEngine = new RenderEngine(this);
		
		//Register things with the RenderEngine
		this.renderEngine.register(this.cameraManager, PlugMode.ALL);
		this.renderEngine.register(this.keyboardBuffer, PlugMode.ALL);
	}

	@Override
	public void cleanup() {
		// TODO Add cleanup methods to all the underlying interfaces and call it here
		this.soundSystem.cleanup(); //Cleanup the SoundSystem
		
	}

}
