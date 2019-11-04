package maratische.kotlin.sdktest1;

import org.junit.Test;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.util.Base64;

public class DeserialisableTest {

//    @Test
    public void helloSecurityOfficer() throws Exception {
        Evil evil = new Evil();
        evil.name = "aaa";
        byte[] name = toString(evil);
        evil = (Evil) fromString(name);
        org.junit.Assert.assertEquals("aaa", evil.name);
    }


//    @Test
    public void helloSecurityOfficer2() throws Exception {
        Evil evil = new Evil();
        evil.name = "aaa";
        byte[] data = SerializationUtils.serialize(evil);
        evil = (Evil) SerializationUtils.deserialize(data);
        org.junit.Assert.assertEquals("aaa", evil.name);
    }

    public static byte[] toString(Object o) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return baos.toByteArray();
    }

    public static Object fromString(byte[] b) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(b);
        ObjectInputStream si = new ObjectInputStream(bi);
        return si.readObject();
    }
}
