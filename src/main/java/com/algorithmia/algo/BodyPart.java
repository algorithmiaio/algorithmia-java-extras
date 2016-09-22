package com.algorithmia.algo;

import com.algorithmia.TypeToken;
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

    private transient final Gson gson = new Gson();
    private transient final Type byteType = new TypeToken<byte[]>(){}.getType();

    public BodyPart() {
        name = "";
        filename = null;
        data = "";
        content_type = ContentType.Void;
        mime_type = "";
    }

    public String getData() { return data;}
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

    @SuppressWarnings("unchecked")
    public <T> T as(TypeToken type_token) throws UnsupportedOperationException {
      Type typ = type_token.getType();
      if(content_type == ContentType.Void) {
          return null;
      } else if(content_type == ContentType.Text) {
          return gson.fromJson(new JsonPrimitive(data), typ);
      } else if(content_type == ContentType.Json) {
          return gson.fromJson(data, typ);
      } else if(content_type == ContentType.Binary) {
          if(byteType.equals(typ)) {
              return (T)Base64.decodeBase64(data);
          } else {
              throw new UnsupportedOperationException("Only support returning as byte[] for Binary data");
          }
      }
      return null;
    }

}
