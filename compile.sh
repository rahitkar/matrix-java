rm -rf out/*
javac -cp lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar -d out $(find . -name '*.java')