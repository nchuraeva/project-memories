package ru.rest.server.bean;

public class Response<T> {
    private T body;
    private String error;

    public Response() {
    }

    public Response(T body) {
        this.body = body;
    }

    public Response(T body, String error) {
        this.body = body;
        this.error = error;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
