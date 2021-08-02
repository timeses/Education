import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\USER\\Downloads\\IdeaProjects\\ImageResizer\\src_";
        String dstFolder = "C:\\Users\\USER\\Downloads\\IdeaProjects\\ImageResizer\\dst_";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        File[] files1 = new File[files.length / 8 + 1];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
        resizer1.start();

        File[] files2 = new File[files.length / 8 + 1];
        System.arraycopy(files, files1.length, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        resizer2.start();

        File[] files3 = new File[files.length / 8 + 1];
        System.arraycopy(files, files1.length * 2, files3, 0, files3.length);
        ImageResizer resizer3 = new ImageResizer(files3, newWidth, dstFolder, start);
        resizer3.start();

        File[] files4 = new File[files.length / 8 + 1];
        System.arraycopy(files, files1.length * 3, files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, newWidth, dstFolder, start);
        resizer4.start();

        File[] files5 = new File[files.length / 8 + 1];
        System.arraycopy(files, files1.length * 4, files5, 0, files5.length);
        ImageResizer resizer5 = new ImageResizer(files5, newWidth, dstFolder, start);
        resizer5.start();

        File[] files6 = new File[files.length / 8 + 1];
        System.arraycopy(files, files1.length * 5, files6, 0, files6.length);
        ImageResizer resizer6 = new ImageResizer(files6, newWidth, dstFolder, start);
        resizer6.start();

        File[] files7 = new File[files.length / 8 + 1];
        System.arraycopy(files, files1.length * 6, files7, 0, files7.length);
        ImageResizer resizer7 = new ImageResizer(files7, newWidth, dstFolder, start);
        resizer7.start();

        File[] files8 = new File[files.length - (files1.length * 7)];
        System.arraycopy(files, files1.length * 7, files8, 0, files8.length);
        ImageResizer resizer8 = new ImageResizer(files8, newWidth, dstFolder, start);
        resizer8.start();

    }
}
