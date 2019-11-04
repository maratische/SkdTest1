package maratische.kotlin.sdktest1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;


public class FixmeJokerTest {

    @Test
    public void test1_whoisTheOutsider() {
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
    public void test2_howAboutALittleBitOfLeftBitShifting() {
        int leftShift = 0x80000000;
        leftShift = leftShift <<1;
        Assert.assertEquals(0x00000000, leftShift);
    }

    @Test
    public void test3_whatStringIsConstructed() {
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
    public void test4_howDiamonProblemIsSolvedInJava() {
        Assert.assertEquals("moo-oo", new Minotaur().sound());
    }


    @Test
    public void test5_methodPreferences() {
        class WiseMan {
            String whoAmI(int i) {
                return "int";
            }
            String whoAmI(Integer i) {
                return "Integer";
            }
            String whoAmI(Object i) {
                return "Object";
            }
        }

        WiseMan wiseMan = new WiseMan();

        Assert.assertEquals("int", wiseMan.whoAmI(1));
        Assert.assertEquals("Integer", wiseMan.whoAmI(Integer.valueOf(1)));
        long l = 1;
        Assert.assertEquals("Object", wiseMan.whoAmI(l));
        Long L = 1L;
        Assert.assertEquals("Object", wiseMan.whoAmI(L));
        byte b = 1;
        Assert.assertEquals("int", wiseMan.whoAmI(b));
        Double d = 1D;
        Assert.assertEquals("Object", wiseMan.whoAmI(d));
    }
}
