package comp3170.week4;

import static org.lwjgl.opengl.GL15.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL15.glClear;
import static org.lwjgl.opengl.GL15.glClearColor;
import static org.lwjgl.opengl.GL15.glViewport;

import java.io.File;
import java.io.IOException;

import comp3170.IWindowListener;
import comp3170.OpenGLException;
import comp3170.ShaderLibrary;
import comp3170.Window;

public class Week4 implements IWindowListener { 

	final private File DIRECTORY = new File("src/comp3170/week4/shaders");
	
	private Window window;

	private int screenWidth = 800;
	private int screenHeight = 800;
	
	private Scene scene;
	
	public Week4() throws OpenGLException {
		window = new Window("Solar System", screenWidth, screenHeight, this);
		window.setResizable(true);
		window.run();
	}
	
	public void init() {
		new ShaderLibrary(DIRECTORY);
	
		scene = new Scene();
		
		glClearColor(0.00f, 0.05f, 0.15f, 1.0f); // Galactic Blue
	}		
	
	public void draw() {
		glClear(GL_COLOR_BUFFER_BIT);
		
		scene.draw();

	}
	@Override
	public void resize(int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		
		glViewport(0,0, width, height);
	}

	@Override
	public void close() {
		
	}
	
	public static void main(String[] args) throws IOException, OpenGLException {
		new Week4();
	}

}