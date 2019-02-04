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

Use my Diamond program in command line as following.
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
My Diamond program works for uppercase letters as for lowercase letters. For example, the diamond printed for 'c':
<pre>
  a
 b b
c   c
 b b
  a
</pre>

Also use it as a Java library with Maven.
```
<dependency>
    <groupId>com.github.xapn</groupId>
    <artifactId>diamond-kata</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```
And get any diamond you want like that.
```java
import diamond.Diamond;

class Example {
    public static void main(String[] args) {
        String diamond = Diamond.of("X");
    }
}
```

## License

The *Diamond* program is distributed under the GNU GPLv3 license. The GPLv3 license is included in the LICENSE.txt file. More information about this license is available at [GNU.org](http://www.gnu.org).
