# COMP3170 - Week 4: Scene Graph

In this exercise we are going to make a solar system simulation to better understand Scene Graphs.

This project contains a base implementation of a scene graph, using the `SceneObject` class provided to you in the lwjgl package. This class takes care of a lot of the under-the-hood scene graph functionality, and you will be expected to understand and utilise this in your assignments. You do not, however, need to write your own SceneObject class.

## Framework
In the eclipse project you will find the classes:
* `Week4` – Driver class.
* `Scene` – A simple scene class that extends SceneObject.
* `Circle` – A simple example of an object that extends SceneObject.

## The Scene Graph
Take a look at the SceneObject class in the comp3170 package and how it works. It is a simple implementation of a tree. Each object is a node in the tree, connected to its parent and children.

We construct a scene graph by connecting SceneObjects together using the `setParent()` method. 

Each object in the tree has a coordinate frame matrix that converts from the object’s local coordinate frame to the parent’s coordinate frame. You can access this matrix using the `getMatrix()` method.

When we draw a scene, we recursively descend the scene graph, calculating the world matrix as we go. This is done in the `draw()` method.

The default `drawSelf()` method does nothing. We can override this method on subclasses in order to draw specific shapes. Take a look at how the `Circle` class extends `SceneObject` to implement this method.

You will also be using this `SceneObject` class in Assignment 1, so this is a good opportunity to familiarise yourself with how it works, and how to use it in your code.

### Creating a Scene Graph
We now want to start creating a scene graph so we can attach objects to each other and define transformations between them. The initial scene graph looks like this:

![An image of a basic scene graph, with a root object and the sun.](images/basicscenegraph.png)

The code to set this up is in the `Scene` class. Have a look and make sure you understand what is happening.

Notice the root is just the Scene itself, a basic SceneObject, acting as a sort of container for attaching children. Every object in your scene should be a descendant of the root object.

Have a look at the `draw()` method in `Week4`:

```
public void draw() {
	glClear(GL_COLOR_BUFFER_BIT);		
	scene.draw(); // Draw the scene, which will draw all of its children.
}
```

`scene.draw()` will recursively draw the entire scene (working through the scene graph and applying matricies).

### Transformations
If you run the code, you will see the sun fills the screen:

![An image of the sun taking up the entire screen space.](images/thesun.png)

We are working in NDC coordinates without a view matrix, so a circle with radius 1 will be as big as the window. We could fix this by adding a camera but for simplicity’s sake we will keep working in NDC and scale everything appropriately.

You can apply transformations to scene objects by calling `getMatrix()` to access its matrix and then using appropriate methods from JOML’s `Matrix4f` class to apply transformations to the coordinate frame. Make sure to read the documentation for more info: https://joml-ci.github.io/JOML/apidocs/org/joml/Matrix4f.html.

If you are stuck, think back to last week's work for scaling down the spaceship.

## Task 1: Adding objects
Scale the Sun down to a reasonable size. You then want to add the Earth and Moon. First, draw this out in your scene graph. You may want to work with the person next to you and share ideas.

Once you've added the earth and moon to the scene graph (make sure you have actually drawn it somewhere!), position and scale everything to look something like this:

![A scene with a sun, the earth and a moon.](images/sunandmoon.png)

When you've got everything in position, try re-scaling the size of the Sun. How are the Earth and Moon affected? Why is this happening?

## Task 2: Adding animation
Add an `update()` method as shown in the lectures. Add code to make the Earth rotate at a fixed speed (remember to take the `deltaTime` into account).

What happens? Why? Stop and think about this. Try to work out the answer before continuing. Make some notes in your workbook. Your instructor will coordinate sharing these answers. Then, when you're ready, click below to be taken to part 2 and the answer...

[Part 2 of today's prac!](part2.md)