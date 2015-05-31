Start unit tests:

#build
cd path/to/the/project 
javac -d bin -sourcepath src src/com/nulogy/nupack/test/NuPackTestSuite.java

#Set classpath (the last jar is used by junit)
export CLASSPATH=/path/to/junit.jar:./bin:/path/to/org.hamcrest.core_1.3.0.v201303031735.jar

#run the tests
java org.junit.runner.JUnitCore com.nulogy.nupack.test.NuPackTestSuite






-------------------------------------
Naming conventions:
input parameters: iName
class attributes: _attribute
local variables: aLocalVar
static variables: STATIC_VARIABLE