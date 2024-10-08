import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageCode {

    static String[] strs = { "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "m", "n", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z",
            "2", "3", "4", "5", "6", "7", "8", "9" };

    public static void main(String[] args) throws Exception {

        // 定義圖片長寬
        //
        int w = 150;
        int h = 50;

        /*
            圖片類型 圖片組成方式 GDB 三原色
            int imagetype = BufferedImage.TYPE_INT_RGB;
            int imagetype = 1;
            以下直接 new 一個新的生成圖片物件 JDK 提供畫板 ctrl+p 快捷鍵查看參數值
         */

        // 1 .製造底 默認顏色黑色
        BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

        Graphics g  = image.getGraphics();
        // 2. 顏色優先：製造顏色矩陣覆蓋上去
        g.setColor(Color.yellow);

        // 3. 再將有顏色的圖像拿去填充矩陣
        g.fillRect(0,0,w,h);

        int x = 25;
        int y = 30;

        Random r = new Random();
        // 4. 循環四次隨機尋找四個字符並添加到圖片上
        for (int i = 0; i < 4; i++) {

            // 再所有字符編碼中隨機生成一個數字
            int num = r.nextInt(strs.length);

            // 將此數字轉成 string
            String chr = strs[num];

            int red = r.nextInt(256);  // 0-255 的隨機值
            int green = r.nextInt(256);
            int blue = r.nextInt(256);

            Color randomColor = new Color(red, green, blue);  // 隨機顏色
            g.setColor(randomColor);  // 設置當前字符的顏色

            // 設置字體樣式、大小和風格
            Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
            g.setFont(font);

            // 每獲取一個 chr 就畫上去
            g.drawString(chr,x,y);

            // 修正字母位置
            x += 35;
            y += 4;
        }


        // 定義三個顏色
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        // 創建隨機數生成器
        Random random = new Random();
        // 5. 畫上線
        for (int i = 0; i < 8; i++) {

            int x1 = r.nextInt(30);
            int y1 = r.nextInt(60);
            int x2 = r.nextInt(30)+120;
            int y2 = r.nextInt(30);

            // 生成 0 到 2 的隨機數
            int randomIndex = random.nextInt(3);
            // 設置顏色為隨機選擇的顏色
            g.setColor(colors[randomIndex]);
            g.drawLine(x1,y1,x2,y2);

        }

        g.dispose();

        // 把 image 生成後寫入本地路徑
        ImageIO.write(image,"jpg",new File("D:\\Idea\\CaptchaServiceSystem\\test.jpg"));
    }

}
