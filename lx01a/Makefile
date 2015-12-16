all: simple simple.s Simple.class

simple: simple.c
	clang -o simple simple.c

simple.s: simple.c
	clang -O0 -S simple.c

Simple.class: simple.scala
	scalac simple.scala

clean:
	rm -f simple simple.s *.class
