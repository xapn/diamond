# Diamond

## Get started

Use the Diamond program in command line as following.
```bash
mvn clean package -Pstandalone # to build it once
java -jar target/diamond-kata-0.1.0-SNAPSHOT-shaded.jar F # to run it as many times as you want
```
You will get this result.
<pre>
     A
    B B
   C   C
  D     D
 E       E
F         F
 E       E
  D     D
   C   C
    B B
     A
</pre>
The Diamond program works for uppercase letters as for lowercase letters. For example, the diamond printed for 'c':
<pre>
  a
 b b
c   c
 b b
  a
</pre>