import com.piperpal.api.HTTPHandler;
public class Test {
    public static void main(String args[]) {
	HTTPHandler sh = new HTTPHandler();
	// Making a request to url and getting response
	String url = "https://www.piperpal.com/app/android";
	String jsonStr = sh.makeServiceCall(url, HTTPHandler.GET);
	System.out.print(jsonStr);
    }
}
