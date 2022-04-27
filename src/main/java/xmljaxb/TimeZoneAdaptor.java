package xmljaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
//import javax.xml.bind.annotation.adapters.XmlAdapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneAdaptor extends XmlAdapter<String, ZonedDateTime> {

  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

  @Override
  public ZonedDateTime unmarshal(String v) throws Exception {
      ZonedDateTime parse = ZonedDateTime.parse(v, dateTimeFormatter);
      return parse;
  }

  @Override
  public String marshal(ZonedDateTime v) throws Exception {
      return dateTimeFormatter.format(v);
  }
}