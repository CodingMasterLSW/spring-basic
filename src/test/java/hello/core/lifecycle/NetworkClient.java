package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }
    public void setUrl(String url){
        this.url = url;
    }

    private void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void disconnect(){
        System.out.println("close: " + url);
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }
}
