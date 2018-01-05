import weibo4j.Timeline;
import weibo4j.http.ImageItem;
import weibo4j.model.Status;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by caiting on 2017/12/22.
 */
public class Share {
    public static void main(String args[]) {
        try {
            try {
//				byte[] content = readFileImage("C:\\Users\\Lenovo\\Desktop\\1.png");
                byte[] content = getImageFromURL("https://ofjn5tuqf.qnssl.com/f8d74f12a7d65f2ba68db797fb9808ef.jpg?imageView2/2/w/224/h/224");
                System.out.println("content length:" + content.length);
                ImageItem pic = new ImageItem("pic", content);
                String s = java.net.URLEncoder.encode("￥26 山金牌碗碗香 陕北米脂黄小米 2500g http://www.abigpush.com/detail/42396", "utf-8");
                String access_token = "2.00nVslXBVtevSE561a2f2f623JSaWE";
                Timeline tm = new Timeline(access_token);
                Status status = tm.shareStatus(s, pic);

                System.out.println("Successfully upload the status to ["
                        + status.getText() + "].");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception ioe) {
            System.out.println("Failed to read the system input.");
        }
    }

    public static byte[] readFileImage(String filename) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(filename));
        int len = bufferedInputStream.available();
        byte[] bytes = new byte[len];
        int r = bufferedInputStream.read(bytes);
        if (len != r) {
            bytes = null;
            throw new IOException("读取文件不正确");
        }
        bufferedInputStream.close();
        return bytes;
    }

    public static byte[] getImageFromURL(String urlPath) {
        byte[] data = null;
        InputStream is = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            // conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6000);
            is = conn.getInputStream();
            if (conn.getResponseCode() == 200) {
                data = readInputStream(is);
            } else{
                data=null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            conn.disconnect();
        }
        return data;
    }

    public static byte[] readInputStream(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = -1;
        try {
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = baos.toByteArray();
        try {
            is.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
