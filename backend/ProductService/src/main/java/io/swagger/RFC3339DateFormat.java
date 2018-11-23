package io.swagger;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.text.FieldPosition;
import java.util.Date;


public class RFC3339DateFormat extends StdDateFormat {

  private static final long serialVersionUID = 1L;

  // Same as ISO8601DateFormat but serializing milliseconds.
  @Override
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    StdDateFormat stdDateFormat = new StdDateFormat();
    String value = stdDateFormat.format(date);
    toAppendTo.append(value);
    return toAppendTo;
  }

}