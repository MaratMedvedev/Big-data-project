// ORM class for table 'target_price_prediction'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Apr 16 20:55:48 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class target_price_prediction extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("property_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        target_price_prediction.this.property_id = (Integer)value;
      }
    });
    setters.put("price_in_lacs", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        target_price_prediction.this.price_in_lacs = (java.math.BigDecimal)value;
      }
    });
  }
  public target_price_prediction() {
    init0();
  }
  private Integer property_id;
  public Integer get_property_id() {
    return property_id;
  }
  public void set_property_id(Integer property_id) {
    this.property_id = property_id;
  }
  public target_price_prediction with_property_id(Integer property_id) {
    this.property_id = property_id;
    return this;
  }
  private java.math.BigDecimal price_in_lacs;
  public java.math.BigDecimal get_price_in_lacs() {
    return price_in_lacs;
  }
  public void set_price_in_lacs(java.math.BigDecimal price_in_lacs) {
    this.price_in_lacs = price_in_lacs;
  }
  public target_price_prediction with_price_in_lacs(java.math.BigDecimal price_in_lacs) {
    this.price_in_lacs = price_in_lacs;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof target_price_prediction)) {
      return false;
    }
    target_price_prediction that = (target_price_prediction) o;
    boolean equal = true;
    equal = equal && (this.property_id == null ? that.property_id == null : this.property_id.equals(that.property_id));
    equal = equal && (this.price_in_lacs == null ? that.price_in_lacs == null : this.price_in_lacs.equals(that.price_in_lacs));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof target_price_prediction)) {
      return false;
    }
    target_price_prediction that = (target_price_prediction) o;
    boolean equal = true;
    equal = equal && (this.property_id == null ? that.property_id == null : this.property_id.equals(that.property_id));
    equal = equal && (this.price_in_lacs == null ? that.price_in_lacs == null : this.price_in_lacs.equals(that.price_in_lacs));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.property_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.price_in_lacs = JdbcWritableBridge.readBigDecimal(2, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.property_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.price_in_lacs = JdbcWritableBridge.readBigDecimal(2, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(property_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(price_in_lacs, 2 + __off, 2, __dbStmt);
    return 2;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(property_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(price_in_lacs, 2 + __off, 2, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.property_id = null;
    } else {
    this.property_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.price_in_lacs = null;
    } else {
    this.price_in_lacs = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.property_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.property_id);
    }
    if (null == this.price_in_lacs) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.price_in_lacs, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.property_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.property_id);
    }
    if (null == this.price_in_lacs) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.price_in_lacs, __dataOut);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(property_id==null?"null":"" + property_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price_in_lacs==null?"null":price_in_lacs.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(property_id==null?"null":"" + property_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price_in_lacs==null?"null":price_in_lacs.toPlainString(), delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.property_id = null; } else {
      this.property_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price_in_lacs = null; } else {
      this.price_in_lacs = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.property_id = null; } else {
      this.property_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price_in_lacs = null; } else {
      this.price_in_lacs = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    target_price_prediction o = (target_price_prediction) super.clone();
    return o;
  }

  public void clone0(target_price_prediction o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("property_id", this.property_id);
    __sqoop$field_map.put("price_in_lacs", this.price_in_lacs);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("property_id", this.property_id);
    __sqoop$field_map.put("price_in_lacs", this.price_in_lacs);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
