# Intro

This repository is a collection of drawings, mostly made for the class *CSCI 203 - Introduction to Computational Media*, although a few were made as personal projects. Although the class was held in Python, all of those scripts have been adapted to Java to be able to run as a standalone script.

# Usage

Every file is independently runnable & tested with Java 21. The library used is [Processing](https://processing.org/) version 4.3, a drawing library that supports multiple languages. In order to run the files, the processing jar file must be added to the classpath. This can be done in IntelliJ via:

1. File > Project Structure > Libraries > + (New Project Library) > Java
2. then adding: `/path/to/processing/processing-4.3/core/library/core.jar`

If running 3D files yields the error `Exception in thread "main" java.lang.NoClassDefFoundError: javax/media/opengl/GLCapabilitiesImmutable` or something similar with opengl, try downloading [jogl](https://jogamp.org/wiki/index.php/Setting_up_a_JogAmp_project_in_your_favorite_IDE#Compile_and_run_your_project_from_the_command_line) & also adding `/path/to/jogamp/jogamp-all-platforms/jar/` to libraries like before.