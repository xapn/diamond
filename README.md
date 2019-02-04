# Diamond

A letter for a diamond!

## Kata instructions

Given a single letter, print a diamond starting with 'A' with the supplied letter at the widest point. This kata like many others is intended to be solved by applying Test-Driven Development (TDD).

Example for 'A':
<pre>
A
</pre>
Example for 'B':
<pre>
 A
B B
 A
</pre>
Example for 'C':
<pre>
  A
 B B
C   C
 B B
  A
</pre>

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
