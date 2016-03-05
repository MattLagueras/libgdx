package com.badlogic.gdx.scenes.scene3d;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage.TouchFocus;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Stage3d implements InputProcessor, GestureListener
{
	/**
	 * InputMultiplexer im = new InputMultiplexer();
        GestureDetector gd = new GestureDetector(this);
        im.addProcessor(gd);
        im.addProcessor(this);
	 */
	
	private Group3d root;
	private ModelBatch modelBatch;
	private boolean ownsBatch;
	private Environment lights;
	private PerspectiveCamera camera;
	private InputMultiplexer multiplexer;
	private final Actor3d[] pointerOverActors = new Actor3d[20];
	private final boolean[] pointerTouched = new boolean[20];
	
	/*
	 * Touch events in a 3d world still only have an x and y component, the camera's look at vector
	 * will get used to ultimately determine if the touch hits an actor           
	 */
	
	private final int[] pointerScreenX = new int[20]; 
	private final int[] pointerScreenY = new int[20];
	private int mouseScreenX, mouseScreenY;
	private Actor3d mouseOverActor;
	private Actor3d keyboardFocus, scrollFocus;
	private final SnapshotArray<TouchFocus> touchFocuses = new SnapshotArray(true, 4, TouchFocus.class);
	
	public Stage3d(){
		this(new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), new ModelBatch());
		ownsBatch = true;
		camera.position.set(0f, 0f, 0f);
		camera.lookAt(0, 0, 0);
		camera.update();
	}
	
	public Stage3d(PerspectiveCamera camera){
		this(camera, new ModelBatch());
		ownsBatch = true;
	}
	
	public Stage3d(PerspectiveCamera camera, ModelBatch batch){
		this.camera = camera;
		this.modelBatch = batch;
		multiplexer = new InputMultiplexer(new GestureDetector(this), new CameraInputController(camera));
		lights = new Environment();
		
	}
	
	public InputMultiplexer getMultiplexer(){
		return multiplexer;
	}
	
	
	// GESTURES
	
	@Override
	public boolean touchDown (float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean tap (float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean longPress (float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean fling (float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean pan (float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean panStop (float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean zoom (float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean pinch (Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	// BASIC INPUT
	
	@Override
	public boolean keyDown (int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp (int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped (char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown (int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp (int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged (int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved (int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled (int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public static final class TouchFocus implements Poolable {
		EventListener listener;
		Actor3d listenerActor, target;
		int pointer, button;

		public void reset () {
			listenerActor = null;
			listener = null;
			target = null;
		}
	}
	


}
