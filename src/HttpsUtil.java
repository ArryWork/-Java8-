import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
public class HttpsUtil {
    private static class TrustAnyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * post方式请求服务器(https协议)
     *
     * @param url
     *            请求地址
     * @param content
     *            参数
     * @param charset
     *            编码
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static byte[] post(String url, String content, String charset)
            throws NoSuchAlgorithmException, KeyManagementException,
            IOException {
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
                new java.security.SecureRandom());

        URL console = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
        conn.setSSLSocketFactory(sc. getSocketFactory());
        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
        conn.setDoOutput(true);
        conn.connect();
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.write(content.getBytes(charset));
        // 刷新、关闭
        out.flush();
        out.close();
        InputStream is = conn.getInputStream();
        if (is != null) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            return outStream.toByteArray();
        }
        return null;
    }

    private static String doPost2String(String url, String content, String charset) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        return new String(post(url, content, charset), "utf-8");
    }

    public static String postData(String url, String data, String charset) {
        String resp = null;
        try {
            resp = HttpsUtil.doPost2String(url, data, charset);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public static void main(String[] args) {
        String data = "{'ACCOUNT_AC_NAME':'张三','ACCOUNT_AC_NO':'621754785487544','ACCOUNT_CAP_TYP':'0','ACCOUNT_CRED_CARD':'','ACCOUNT_CRED_ID':'385458199012457854','ACCOUNT_CRED_NM':'张三','ACCOUNT_CRED_TEL':'','ACCOUNT_CRED_TYP':'1','ACCOUNT_LBNK_NO':'001141006438','ACCOUNT_OPN_BNK_ADDR':'兴隆县兴隆镇葛新桥北','ACCOUNT_OPN_BNK_NM':'中国人民银行兴隆县支行','ACCOUNT_TEL':'18865842222','BASE_BRANCHNM':'易通支付有限公司','BASE_BRANCH_ADDR':'新泺大街888号','BASE_BRANCH_CITY':'4510','BASE_BRANCH_PROV':'4500','BASE_BRANCH_TOWN':'4519','BASE_MERC_TYP':'1','BASE_REMARK':'','BASE_WECHAT_OPENID':'','BRANCHID':'000001964','BUSINFO_BUS_AREA':'','BUSINFO_BUS_END_HOUR':'','BUSINFO_BUS_STR_HOUR':'','BUSINFO_BUS_ULD_ATTR':'','BUSINFO_BUS_ZIP':'','BUSINFO_CRP_NM':'张三','BUSINFO_CRP_TEL':'18865842222','BUSINFO_HOL_BUS_FLG':'','BUSINFO_MCC_CD':'7854','BUSINFO_MERC_TYP':'0','BUSINFO_ORG_COD':'10101022222','BUSINFO_REG_NM':'易通支付','CHANNEL_NO':'ECTON','FEE_RATES':'0.30#0.32&0.50','MER_ORDER':'00000198620171215141407000000000','NOTIFY_URL':'https://s.etonepay.com','PRODUCTS':'OLN0001&OML0002','SIGN':'16B431891596DD030952725AD80D79C9','USER_BRANCHID':'000001966','USER_USERID':'fengchengyw01'}";
        String url = "https://ceshi.sdykt.com.cn/c123bd53c87b83f/internetAdd";
        String resp = HttpsUtil.postData(url,data,"utf-8");
        System.out.println(resp);

        String s = "0000";
        System.out.println(s+10);
    }
}
