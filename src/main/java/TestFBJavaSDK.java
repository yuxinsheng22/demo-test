import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;

public class TestFBJavaSDK {
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String name=java.net.URLEncoder.encode("测试", "UTF-8");
//        System.out.println(name);
//    }

    public static void main(String[] args) {
        String str = "544229";
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        long c = crc32.getValue();
        System.out.println(c);
    }

}
