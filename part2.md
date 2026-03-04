# COMP3170 - Week 4 Scene Graph (Part 2)

If you are reading this, make sure you've completed [Part 1](README.md) (including trying to work out the problem). If you don't, you're only cheating yourself.

## Task 3: Empty Objects
The issue is that the Moon is attached to the Earth in the scene graph, so inherits its coordinate frame. When the Earth is rotated, the Moon moves with it. In this case, this is not the behaviour that we want. We can solve this with a more complicated scene graph:

![A more complicated scene graph that includes a "Pivot" object for the Moon and Earth.](images/complicatedscenegraph.png)

Rather than attaching the Moon to the Earth, we attach both objects to an invisible `Pivot` object. The Earth can then be rotated about the pivot without affecting the position of the Moon. Generally speaking, we want to use meaningful naming here. ßThe important thing here is readability and consistency.

## Task 4: Complete the scene
### Earth and moon
Add more animation code so that:
* The Sun does not rotate.
* The Earth rotates on its axis once per ‘day’.
* The Earth goes around the Sun once per ‘year’.
* The Moon goes around the Earth once per ‘month’.
* You can decide what appropriate periods for a ‘day’, ‘month’ and ‘year’ might be.

To do this you will need to add more pivot points to your scene graph. Draw the scene graph you are using in your workbook.

### Mars and its moons
Add Mars, and its two moons Phobos and Deimos to your scene graph.
Draw the scene graph you are using in your workbook.

## Task 5: A bigger solar system
Consider all the different planets, moons and other satellites or astronomical objects you could add to your solar system (it's okay to just represent things with circles at the moment, but you might wish to add other shape primitives).

You can even try using vertex shading, the `mix()` method, or other tools shown in class so far to get the satellites looking a bit more distinct. 

When there's ~15 minutes left to go, the instructor will ask you all to show off what you've created. Don't be afraid to work in teams, and remember to draw out your scene graph to help you plan appropriately!

## Challenge: Moving the Camera
We will be diving into cameras next week, but if you want to get a headstart, review the lecture videos and try to add a camera that follows the Earth.

Recall that the view matrix is the inverse of the camera’s world matrix, i.e. it maps from (global) world coordinates to (local) camera coordinates.

We can achieve our "Earth cam" via the following steps:

* Add code for view matrix and projection matrices to the shader (this will require new uniforms).
* Create a ‘camera’ scene object.
* Attach it as a child of the Earth in the scene-graph.
* Add a method to the camera to access its model matrix.
* How can you split this into TR and S components? (This is tricky)
* Use the `Matrix4f.invert()` method to invert this matrix to give you the view and projection matrices
* Pass these values into the shader.

Try changing the camera’s parent in the scene graph and see what results you get.