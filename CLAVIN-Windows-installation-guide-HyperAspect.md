# How to install and build CLAVIN for Windows:
Main source: https://clavin.bericotechnologies.com/clavin-core/tutorials/installation.html
-------------------------------------------

1. Select a CLAVIN directory (for example D:\Libraries\CLAVIN), go to that directory,
 and Git Bash

2. Check out a copy of the source code:
	> `git clone https://github.com/Berico-Technologies/CLAVIN.git`

3. Move into the newly-created CLAVIN directory, or in the address bar type cmd + ENTER,
 opening the C:\Windows\System32/cmd.exe Console Window:
	> `cd CLAVIN`

4. 3. Download the latest version of allCountries.zip gazetteer file from GeoNames.org
by pasting in the Console Window:
	> `curl -O http://download.geonames.org/export/dump/allCountries.zip`

5. Unzip the GeoNames gazetteer file allCountries.zip, making sure that the zipped txt file
allCountries.txt, 1.5 Gb stays in the CLAVIN directory.

6. Download Maven (from https://maven.apache.org/download.cgi, pick for example Binary zip archive,
link apache-maven-3.6.1-bin.zip

7. Unzip the apache-maven-3.6.1-bin.zip file and copy the path to the bin directory of maven
(for example D:\tools\apache-maven-3.6.1-bin\apache-maven-3.6.1\bin)

8. Prepare your paths. Open Control Panel -> System. From the left panel pick Advanced System Settings.
From the Advanced tab pick Environment Variables:
* 8.1 Set Maven Path:
	-> for Windows 10:
		- from the System variables list, find the Path variable, and click on Edit...
			- click on New and paste the copied path from step 7
	-> for Windows 7:
		- from the System variables list, find the PATH variable, and click on Edit...
			- go to the end of the line, type ";" and paste the copied path from step 7
* 8.2 From the System variables click New...
	- Variable Name: JAVA_HOME
	- Variable Value: the path to your jdk, situated usually in C:\Program Files\Java
	 (for example C:\Program Files\Java\jdk-11.0.1)
* 8.3 From the System variables click New...
	- Variable Name: M2_HOME
	- Variable Value: the path to the root maven directory (step 7, but not in bin directory)
	 (for example D:\tools\apache-maven-3.6.1-bin\apache-maven-3.6.1)
* 8.4 From the System variables click New...
	- Variable Name: MAVEN_HOME
	- Variable Value: the path to the root maven directory (step 7, but not in bin directory)
	 (for example D:\tools\apache-maven-3.6.1-bin\apache-maven-3.6.1)
	 
9. Close all Command Windowses and open new cmd in CLAVIN directory. Compile the source code
by typing the command:
	> `mvn compile`

10. Setting the RAM memory usage of Maven Open Control Panel -> System. From the left panel
pick Advanced System Settings. From the Advanced tab pick Environment Variables.
 From the System variables click New...
	- Variable Name: MAVEN_OPTS
	- Variable Value: -Xmx4g
NOTE: CLAVIN states that this should work with -Xmx3g if your heap fills and you don't have 
enough RAM, but I tried with -Xmx8g and the process doesn't work. So it is better to close 
as many RAM-consuming applications as possible during the next step and leave this parameter
to -Xmx4g

11. Create the Lucene Index (this one-time process will take quite a minutes: between 12 and 30)
For that close all Command Windowses and open new cmd in CLAVIN directory, typing:
	> `mvn exec:java -Dexec.mainClass="com.bericotech.clavin.index.IndexDirectoryBuilder"`

12. Setting the RAM memory usage of Maven Open Control Panel back to normal -> System.
From the left panel pick Advanced System Settings. From the Advanced tab pick
Environment Variables. From the System variables click New...
	- Variable Name: MAVEN_OPTS
	- Variable Value: -Xmx2048M

13. Run the example program. For that close all Command Windowses and open new cmd in CLAVIN
directory, typing::
	> `MAVEN_OPTS="-Xmx2g" mvn exec:java -Dexec.mainClass="com.bericotech.clavin.WorkflowDemo"`
	
	If you encounter an error that looks like this:
	> `... InvocationTargetException: Java heap space ...`
	
set the appropriate environmental variable controlling Maven's memory usage,
and increase the size with `export MAVEN_OPTS=-Xmx4g` or similar.