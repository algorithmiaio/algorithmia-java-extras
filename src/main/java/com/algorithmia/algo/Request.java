package com.algorithmia.algo;

import java.util.List;
import java.util.ArrayList;

public final class Request {

    protected List<BodyPart> body;

    public Request() {
        body = new ArrayList<BodyPart>();
    }

    public List<BodyPart> getBody() {
        return body;
    }

}
