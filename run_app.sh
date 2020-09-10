# This code is a test to replace a makefile, while building a JAVAFX app
# It contains : export env variable, compilation, execution

export PATH_TO_FX=/Users/sinatrablue/Documents/javafx-sdk-15/lib
echo "PATH_TO_FX env variable set to : "
echo $PATH_TO_FX

echo "Deleting old <class> files..."
rm -fv $.class
echo "Done."

echo "Compiling App ..."
javac --module-path $PATH_TO_FX --add-modules javafx.controls test_fx.java
echo "Compilation terminated."
echo "..."
echo "Now executing the app ..."
java --module-path $PATH_TO_FX --add-modules javafx.controls test_fx