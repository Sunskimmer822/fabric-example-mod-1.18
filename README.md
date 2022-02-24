# Configure workspace
First: 

Make sure you have JDK 17 installed
then
./gradlew genSources

Second:

configure for your IDE
idk about other IDEs but for vscode:
on linux run ./gradlew vscode
on windows run .\gradlew vscode

# Build

Finally, build it with
linux: ./gradlew build
windows: .\gradlew build

the resulting file will be located at [cloned folder]/build/libs/mod-VERSION.jar