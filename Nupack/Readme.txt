Start unit tests:

# Set classpath
# You may need to add the path to the hamcrest jar if you are using jUnit > 4.9
export CLASSPATH=/path/to/junit.jar:./bin

# Build (code was built with java7)
cd path/to/the/project/nupack/Nupack
mkdir bin
javac -d bin -sourcepath src src/com/nulogy/nupack/test/NuPackTestSuite.java

#run the tests
java org.junit.runner.JUnitCore com.nulogy.nupack.test.NuPackTestSuite






-------------------------------------
Naming conventions:
input parameters: iName
class attributes: _attribute
local variables: aLocalVar
static variables: STATIC_VARIABLE
-------------------------------------

