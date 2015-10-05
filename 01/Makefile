all: simple simple.s

simple: simple.c
	clang -o simple simple.c

simple.s: simple.c
	clang -O0 -S simple.c

clean:
	rm -f simple simple.s
