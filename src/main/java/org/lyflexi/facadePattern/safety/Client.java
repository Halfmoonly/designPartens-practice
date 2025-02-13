package org.lyflexi.facadePattern.safety;

/**
 * @Description:
 * @Author: hmly
 * @project: designPartens-practice
 * @Date: 2025/2/13 12:46
 */
public class Client {
    /**
     * 输出：通过SonFacade作为参数传递，保证了应用程序的安全性
     *
     * hello ...
     * hello ...
     * saySecret ...
     * ----
     * Exception in thread "main" java.lang.ClassCastException: class org.lyflexi.facadePattern.safety.SonFacade cannot be cast to class org.lyflexi.facadePattern.safety.Son1 (org.lyflexi.facadePattern.safety.SonFacade and org.lyflexi.facadePattern.safety.Son1 are in unnamed module of loader 'app')
     * 	at org.lyflexi.facadePattern.safety.ClientProcessor.process(ClientProcessor.java:11)
     * 	at org.lyflexi.facadePattern.safety.Client.main(Client.java:16)
     *
     * Process finished with exit code 1
     * @param args
     */
    public static void main(String[] args) {
        Son1 son = new Son1();
        ClientProcessor clientProcessor = new ClientProcessor();
        clientProcessor.process(son);
        System.out.println("----");
        SonFacade sonFacade = new SonFacade(son);
        clientProcessor.process(sonFacade);
    }
}
