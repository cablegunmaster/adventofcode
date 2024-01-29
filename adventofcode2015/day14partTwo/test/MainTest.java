import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MainTest {

    @Test(expected = RuntimeException.class)
    public void expectRuntimeException() throws IOException {
        Main.main(null);
    }

    @Test(expected = RuntimeException.class)
    public void expectRuntimeExceptionWithArgs() throws IOException {
        String input[] = {"100","apple"};
        Main.main(input);
    }

    @Test
    public void SetPathTest(){
        String path = "ImaginationPath";
        Main m = new Main();
        m.setPath(path);

        Assert.assertEquals(path,m.getPath());
    }

    @Test
    public void getPathTest(){
        Main m = new Main();
        Assert.assertEquals("F:\\development\\adventofcode\\src\\adventofcode2015\\day14partTwo\\input.txt",m.getPath());
    }
}
