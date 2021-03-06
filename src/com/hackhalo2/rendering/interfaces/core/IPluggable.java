package com.hackhalo2.rendering.interfaces.core;
import com.hackhalo2.rendering.RenderEngine.PlugMode;
import com.hackhalo2.rendering.RenderUtils.RefreshReason;

public interface IPluggable {
	
	public void preLogic(IChassis chassis);
	public void preRender(IChassis chassis);
	public void render(IChassis chassis);
	public void postRender(IChassis chassis);
	public void postLogic(IChassis chassis);
	public void idleRender(IChassis chassis);
	
	public void refresh(IChassis chassis, RefreshReason reason);
	public String getName();
	
	public PlugMode.Priority getPriority();
	
	public void setEnabled(boolean flag);
	public boolean isEnabled();
	
}
