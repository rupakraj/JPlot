JPlot
=====

plotting graph using java, this program is the demostration of the observer pattern in java.

**Pattern Used**

*Observer* - it is the Behavioral Pattern


**What is Observer Pattern?**

The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods. It is mainly used to implement distributed event handling systems.

Src: http://en.wikipedia.org/wiki/Observer_pattern

More Resource: 
  - http://javadesign-patterns.blogspot.com/p/page22.html
  - http://www.oodesign.com/observer-pattern.html



**Requirements to run**
  - JRE
  - JDK
  
The program is compiled with OpenJDK 7

```
$java -version
 
 java version "1.7.0_51" 
 OpenJDK Runtime Environment (IcedTea 2.4.4) (7u51-2.4.4-0ubuntu0.13.10.1) 
 OpenJDK 64-Bit Server VM (build 24.45-b08, mixed mode)
```

**Uses**

  - Java Swing components - JTextField, JButton, JFrame, JTable, etc.
  - JPanel is used as a graph

``GraphPanel`` is the observer class which plot the points in panel

``TablePanel`` is the observer class which show tht data in tabular format

**Run**

``$ make``


Enjoy

