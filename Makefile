ALL=$(wildcard *.java)

build:
	javac -Xlint:all $(ALL)
clean:
	rm -rf *.class
