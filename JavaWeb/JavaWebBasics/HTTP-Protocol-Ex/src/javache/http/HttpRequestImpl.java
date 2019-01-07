package javache.http;

import javache.constants.NonSpecificConstants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestImpl implements HttpRequest {

    private String method;
    private String requestUrl;
    private Map<String, String> headers;
    private Map<String, String> bodyParameters;

    public HttpRequestImpl(String requestContent) {
        this.headers = new HashMap<>();
        this.bodyParameters = new HashMap<>();
        this.parseRequestContent(requestContent);
    }

    @Override
    public HashMap<String, String> getHeaders() {
        //TODO
        return null;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        //TODO
        return null;
    }

    @Override
    public String getMethod() {
        //TODO
        return null;
    }

    @Override
    public void setMethod(String method) {
        //TODO

    }

    @Override
    public String getRequestUrl() {
        //TODO
        return null;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        //TODO
    }

    @Override
    public void addHeader(String header, String value) {
        //TODO
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        //TODO
    }

    @Override
    public boolean isResource() {
        //TODO
        return false;
    }

    private void parseRequestContent(String requestContent) {
        String[] lines = requestContent.split("\r\n");

        this.parseRequestFirstLine(lines[0]);
        String[] remainLines = Arrays.stream(lines)
                .skip(1)
                .toArray(String[]::new);
        String bodyParameters = this.parseRequestHeaders(remainLines);
        if (!NonSpecificConstants.EMPTY_STRING.equals(bodyParameters)){
            this.parseBodyParameters(bodyParameters);
        }
    }

    private void parseRequestFirstLine(String requestLine) {
        String[] requestLineTokens = requestLine.split("\\s+");
        String method = requestLineTokens[0];
        String url = requestLineTokens[1];

        this.setMethod(method);
        this.setRequestUrl(url);
    }

    private String parseRequestHeaders(String[] remainLines) {
        int endHeaderIndex = 0;
        for (int i = 0; i < remainLines.length; i++) {
            if (NonSpecificConstants.EMPTY_STRING.equals(remainLines[i].trim())){
                endHeaderIndex = i;
                break;
            }
            String[] headerTokens = remainLines[i].split(":\\s");
            this.addHeader(headerTokens[0], headerTokens[1]);
        }
        if (endHeaderIndex + 1 < remainLines.length){
            this.parseBodyParameters(remainLines[endHeaderIndex + 1]);
        }
        return "";
    }

    private void parseBodyParameters(String bodyParameters) {
        //TODO
    }
}
