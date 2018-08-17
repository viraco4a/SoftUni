import java.util.Scanner;

public class URLparser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String url = scan.nextLine();

        String protocol = "";
        String server = "";
        String resource = "";
        if (url.contains("://")){
            String[] array = url.split("://");
            protocol = array[0];

            if (array[1].contains("/")){
                server = array[1].substring(0, array[1].indexOf("/"));
                resource = array[1].substring(array[1].indexOf("/") + 1);
            } else {
                server = array[1];
            }
        } else {
            if (url.contains("/")){
                server = url.substring(0, url.indexOf("/"));
                resource = url.substring(url.indexOf("/") + 1);
            } else {
                server = url;
            }
        }
        System.out.println("[protocol] = \"" + protocol + "\"");
        System.out.println("[server] = \"" + server + "\"");
        System.out.println("[resource] = \"" + resource + "\"");
    }
}
