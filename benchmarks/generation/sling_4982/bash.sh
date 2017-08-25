mkdir src
cd src
mkdir main
mkdir main/java
mkdir main/java/org

mkdir test
mkdir test/java

mv org main/java/org
mv ../test test/java
cd ..
if [ ! -f pom.xml ]; then
    cp ../math-1115/pom.xml .
fi
mvn test
