SRCFILES := $(shell find src -name \*.java)
RESFILES := $(shell (find src -name \*.dtd ; find src -name \*.ttf) | sed s/^src\\///)
PACKAGES := $(shell find src/com/kreative/vexillo -type d \! -path \*/.\* | sed s/^src\\/// | tr / .)

all: clean bin doc vexillo.jar vexillo-src.tgz

eclipseall: eclipseclean vexillo.jar vexillo-src.tgz

clean:
	rm -rf bin
	rm -rf doc
	rm -rf vexillo*.jar
	rm -rf vexillo*.tgz

eclipseclean:
	rm -rf vexillo*.jar
	rm -rf vexillo*.tgz

bin: src
	mkdir -p bin
	javac -sourcepath src $(SRCFILES) -d bin
	$(foreach res,$(RESFILES),cp src/$(res) bin/$(res);)

doc: src
	mkdir -p doc
	javadoc -sourcepath src $(PACKAGES) -d doc

vexillo.jar: bin
	export COPYFILE_DISABLE=true
	find bin -name .DS_Store -delete
	jar cmf dep/MANIFEST.MF vexillo.jar -C bin com/kreative

vexillo-src.tgz: src
	export COPYFILE_DISABLE=true
	find src -name .DS_Store -delete
	tar -czf vexillo-src.tgz src/com/kreative

install: vexillo.jar
	sudo cp -f vexillo.jar /usr/local/lib/
	sudo chmod -f 644 /usr/local/lib/vexillo.jar
	sudo cp -i dep/{ascii85,base64}{en,de}code /usr/local/bin/
	sudo chmod -f 755 /usr/local/bin/{ascii85,base64}{en,de}code
	sudo cp -i dep/rewritesvgpath /usr/local/bin/
	sudo chmod -f 755 /usr/local/bin/rewritesvgpath
	sudo cp -f dep/vex{illo,view,port,moji,info,calc} /usr/local/bin/
	sudo chmod -f 755 /usr/local/bin/vex{illo,view,port,moji,info,calc}

uninstall:
	if [ -f /usr/local/bin/ascii85encode ]; then sudo rm -i /usr/local/bin/ascii85encode; fi
	if [ -f /usr/local/bin/ascii85decode ]; then sudo rm -i /usr/local/bin/ascii85decode; fi
	if [ -f /usr/local/bin/base64encode ]; then sudo rm -i /usr/local/bin/base64encode; fi
	if [ -f /usr/local/bin/base64decode ]; then sudo rm -i /usr/local/bin/base64decode; fi
	if [ -f /usr/local/bin/rewritesvgpath ]; then sudo rm -i /usr/local/bin/rewritesvgpath; fi
	if [ -f /usr/local/bin/vexillo ]; then sudo rm -i /usr/local/bin/vexillo; fi
	if [ -f /usr/local/bin/vexview ]; then sudo rm -i /usr/local/bin/vexview; fi
	if [ -f /usr/local/bin/vexport ]; then sudo rm -i /usr/local/bin/vexport; fi
	if [ -f /usr/local/bin/vexmoji ]; then sudo rm -i /usr/local/bin/vexmoji; fi
	if [ -f /usr/local/bin/vexinfo ]; then sudo rm -i /usr/local/bin/vexinfo; fi
	if [ -f /usr/local/bin/vexcalc ]; then sudo rm -i /usr/local/bin/vexcalc; fi
	if [ -f /usr/local/bin/vexillo.jar ]; then sudo rm -i /usr/local/bin/vexillo.jar; fi
	if [ -f /usr/local/lib/vexillo.jar ]; then sudo rm -i /usr/local/lib/vexillo.jar; fi

.PHONY: all eclipseall clean eclipseclean install uninstall
