
JAVAC = javac
JAVA  = java
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

all: $(classes)

clean :
	# rm -f *.class

%.class : %.java
	$(JAVAC) IDataObserver.java
	$(JAVAC) Data.java
	$(JAVAC) GraphPanel.java
	$(JAVAC) UI.java
	$(JAVAC) Graph.java
	$(JAVA) Graph