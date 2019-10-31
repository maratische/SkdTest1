package maratische.kotlin.sdktest1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class FixmeJokerTest {

    @Test
    public void _1_whoisTheOutsider() {
        class RaceHorse {
            private final int speed;
            private final int age;
            private final String name;

            public RaceHorse(int speed, int age, String name) {
                this.speed = speed;
                this.age = age;
                this.name = name;
            }
        }

        RaceHorse lindy = new RaceHorse(5, 3, "lindy");
        RaceHorse lightning = new RaceHorse(4, 3, "lightning");
        RaceHorse slowy = new RaceHorse(6, 5, "slowy");

        RaceHorse[] horses = {lindy, lightning, slowy};

        Arrays.sort(horses, Comparator.comparingInt(o -> o.speed/o.age));

        Assert.assertEquals("lindy", horses[0].name);
    }

    @Test
    public void _2_howAboutALittleBitOfLeftBitShifting() {
        int leftShift = 0x80000000;
        leftShift = leftShift <<1;
        Assert.assertEquals(0x00000000, leftShift);
    }

    @Test
    public void _3_whatStringIsConstructed() {
        class A {
            String someString = "pi";

            A() {
                someString += "pu";
            }
        }
        class B extends A {
            private B() {
                someString += "pa";
            }
        }

        Assert.assertEquals("pipupa", new B().someString);
    }

    interface Human {
        default String sound() {
            return "Hello-oo!";
        }
    }

    interface Bull {
        default String sound() {
            return "Moo-oo";
        }
    }

    class Minotaur implements Human, Bull {
        @Override
        public String sound() {
            return Bull.super.sound().toLowerCase();
        }
    }

    @Test
    public void _4_howDiamonProblemIsSolvedInJava() {
        Assert.assertEquals("moo-oo", new Minotaur().sound());
    }
}
