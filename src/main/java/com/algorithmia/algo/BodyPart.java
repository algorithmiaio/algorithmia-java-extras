package com.algorithmia.algo;

import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;

import org.apache.commons.codec.binary.Base64;

public final class BodyPart {

    protected String name;

    protected String filename;// Optional
    protected String data;
    protected ContentType content_type;
    protected String mime_type;

    private final Gson gson = new Gson();

    public BodyPart() {
        name = "";
        filename = null;
        data = "";
        content_type = ContentType.Void;
        mime_type = "";
    }

    public String getName() {
        return name;
    }
    public String getFilename() {
        return filename;
    }
    public Boolean hasFilename() {
      return filename != null;
    }
    public ContentType getContentType() {
        return content_type;
    }
    public String getMimeType() {
        return mime_type;
    }
    public Object as(Type type) {
      if(content_type == ContentType.Void) {
          return null;
      } else if(content_type == ContentType.Text) {
          return gson.fromJson(new JsonPrimitive(data), type);
      } else if(content_type == ContentType.Json) {
          return gson.fromJson(data, type);
      } else if(content_type == ContentType.Binary) {
          return Base64.decodeBase64(data);
      }
      return null;
    }

}
