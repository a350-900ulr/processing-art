# Intro

This repository is a collection of drawings made for the class *CSCI 203 - Introduction to Computational Media*. Although this class was held in Python, all of these scripts have been adapted to Java for self containment & expansion of possible features. The conversion of these is documented in `conversion.txt`, although this only exists for my own personal reference & is not needed to run any files.

# Usage

Every file is independently runnable & tested with Java 21. The library used is [Processing](https://processing.org/) version 4.3, a drawing library that supports multiple languages. In order to run the files, the processing jar file must be added to the classpath. This can be done in IntelliJ via:

File > Project Structure > Libraries > + (New Project Library) > Java

then adding: `/path/to/processing/processing-4.3/core/library/core.jar`