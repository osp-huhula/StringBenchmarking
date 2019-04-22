@ECHO OFF
SETLOCAL
  FOR /F "tokens=1,2,3,4 delims=/ "          %%A in ('date /t') DO (
  	SET _D1=%%A
  	SET _D2=%%B
  	SET _D3=%%C
  	SET _D4=%%D
  	SET V_DATE=%%C%%B%%A
  )
  FOR /F "tokens=1-3     delims=1234567890 " %%A in ("%time%") DO SET "delims=%%A%%B%%C"
  FOR /F "tokens=1-4     delims=%delims%"    %%A in ("%time%") DO (
    SET _hh=%%A
    SET _min=%%B
    SET _ss=%%C
    SET _ms=%%D
  )

IF %_hh% LSS 10 set _hh=0%_hh%
IF %_min% LSS 10 set _hh=0%_min%

SET V_TIME=%_hh%%_min% 
SET V_TIME=%V_TIME%
::if "%V_TIME:~3,1%"=="_" set V_TIME=0%V_TIME%
::set V_TIME=%t:~0,4%

SET "TIMESTAMP=%V_DATE%.%V_TIME%"
SET TIMESTAMP=%TIMESTAMP: =%

ECHO "TIMESTAMP: " %TIMESTAMP% 

::CMD /C mvn clean install -DskipTests

copy target\string-benchmarking-J6u45.1.1.jar c:\.tmp\JMH\%TIMESTAMP%.jar

::START CMD /C "java -jar c:\.tmp\JMH\%TIMESTAMP%.jar > C:\.rep\git\P\StringBenchmarking\src\test\resources\result\%TIMESTAMP%.log"
java -jar c:\.tmp\JMH\%TIMESTAMP%.jar -rf json -o JMH-ouput-%TIMESTAMP% -rff JMH-result-%TIMESTAMP%.json


ENDLOCAL