#!bin/bash

# TOPLEVEL="."
STARTDIR="`pwd`"

BUILDFOLDER="/build/"
BUILDDIR=$STARTDIR$BUILDFOLDER

APIFOLDER="/src/api/"
APIDIR=$STARTDIR$APIFOLDER

TESTFOLDER="/src/tests/"
TESTDIR=$STARTDIR$TESTFOLDER

LIBFOLDER="/src/lib/"
LIBDIR=$STARTDIR$LIBFOLDER

# clean all class and java files to clear old versions
REMCLASS="rm -f $BUILDDIR*.class"
$REMCLASS

REMJAVA="rm -f $BUILDDIR*.java"
$REMJAVA

# move API to build folder
for i in $(find $APIDIR*.java)
do
	MOVEFILE="cp $i $BUILDDIR"
	$MOVEFILE
done

# move libraries to build folder
for i in $(find $LIBDIR*.java)
do
	MOVEFILE="cp $i $BUILDDIR"
	$MOVEFILE
done

# move tests to build folder
for i in $(find $TESTDIR*.java)
do
	MOVEFILE="cp $i $BUILDDIR"
	$MOVEFILE
done

# build all classes
COMPILEBUILD="javac $BUILDDIR*.java"
$COMPILEBUILD

# execute test classes
for i in $(find $BUILDDIR -name '*Test.java')
do
	if [ "$i" != "UnitTestHarness.java" ]; then
    	LONGNAME=${i//$BUILDDIR/}
    	SHORTNAME=${LONGNAME//.java/}
    	EXECTEST="java -cp $BUILDDIR $SHORTNAME hide"
    	$EXECTEST
    fi
done
