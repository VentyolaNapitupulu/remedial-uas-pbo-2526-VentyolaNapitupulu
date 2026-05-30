@echo off
echo area-add#Area GD722#10#motorcycle > test.txt
echo area-add#Area Rektorat#5#car >> test.txt
echo vehicle-add#BK1234AB#Chandro Pardede#car >> test.txt
echo vehicle-add#BB9988XY#Budi Santoso#motorcycle >> test.txt
echo vehicle-add#B123CD#Andi Wijaya#car >> test.txt
echo park#BK1234AB#Area Rektorat >> test.txt
echo park#B123CD#Area Rektorat >> test.txt
echo park#BB9988XY#Area GD722 >> test.txt
echo display-all >> test.txt
mvn -q exec:java -Dexec.mainClass="pbo.f01.App" < test.txt