package com.badlogic.gdx.scenes.scene3d;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.collision.BoundingBox;

public class Actor3d
{
	
	private Stage3d stage;
	private Group3d parent;
	
	private BoundingBox boundingBox;
	private Matrix4 localTransform;
	
	private boolean visible = true;
	private Object userData;

	
}
