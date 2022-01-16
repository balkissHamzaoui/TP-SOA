package operations;

import operations.UserService;

import javax.xml.ws.Endpoint;
public class Server {

    static final String URL="http://localhost:9000/";

    public static void main(String[] args){
        System.out.println("Running on server"+URL);
        Endpoint.publish(URL,new UserService());
    }
}
