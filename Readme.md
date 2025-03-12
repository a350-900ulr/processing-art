# Intro

This repository is a collection of artworks, mostly made for the class *CSCI 203 - Introduction to Computational Media*, although a few were made as personal projects. Although the class was held in Python, all of those scripts have been adapted to Java to be able to run as a standalone script.

The library used is [Processing](https://processing.org/) , a sketchbook library that supports multiple languages. Processing provides the ability to easily draw visual elements, animations, & interactive elements. 

# Usage

Every file was independently tested with Java 21 & Processsing 4.3.  In order to run the files, the Processing jar file must be added to the classpath. This can be done in IntelliJ via:

1. File > Project Structure > Libraries > + (New Project Library) > Java
2. then adding: `/path/to/processing/processing-4.3/core/library/core.jar`

If running 3D files yields the error `Exception in thread "main" java.lang.NoClassDefFoundError: javax/media/opengl/GLCapabilitiesImmutable` or something similar with opengl, try downloading [jogl](https://jogamp.org/wiki/index.php/Setting_up_a_JogAmp_project_in_your_favorite_IDE#Compile_and_run_your_project_from_the_command_line) & also adding `/path/to/jogamp/jogamp-all-platforms/jar/` to libraries like before.

# Example screenshots

`flatland`

![flatland screenshot](/images/Flatland 2025-03-12 13-14-41.png)

`Boat`

![boat screenshot](/images/Boat_2025-03-12_13-09-56.png)

`HauntedHouse`

![haunted house screenshot](/images/Haunted House 2025-03-12 13-11-20.png)

`Space`

![space screenshot](/images/Space 2025-03-12 13-12-18.png)