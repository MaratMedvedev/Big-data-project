// ORM class for table 'property_details'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Apr 16 20:55:33 MSK 2024
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

public class property_details extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.id = (Integer)value;
      }
    });
    setters.put("posted_by", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.posted_by = (String)value;
      }
    });
    setters.put("under_construction", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.under_construction = (Boolean)value;
      }
    });
    setters.put("rera", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.rera = (Boolean)value;
      }
    });
    setters.put("bhk_no", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.bhk_no = (Integer)value;
      }
    });
    setters.put("bhk_or_rk", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.bhk_or_rk = (String)value;
      }
    });
    setters.put("square_ft", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.square_ft = (java.math.BigDecimal)value;
      }
    });
    setters.put("ready_to_move", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.ready_to_move = (Boolean)value;
      }
    });
    setters.put("resale", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.resale = (Boolean)value;
      }
    });
    setters.put("address", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.address = (String)value;
      }
    });
    setters.put("longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.longitude = (java.math.BigDecimal)value;
      }
    });
    setters.put("latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        property_details.this.latitude = (java.math.BigDecimal)value;
      }
    });
  }
  public property_details() {
    init0();
  }
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public property_details with_id(Integer id) {
    this.id = id;
    return this;
  }
  private String posted_by;
  public String get_posted_by() {
    return posted_by;
  }
  public void set_posted_by(String posted_by) {
    this.posted_by = posted_by;
  }
  public property_details with_posted_by(String posted_by) {
    this.posted_by = posted_by;
    return this;
  }
  private Boolean under_construction;
  public Boolean get_under_construction() {
    return under_construction;
  }
  public void set_under_construction(Boolean under_construction) {
    this.under_construction = under_construction;
  }
  public property_details with_under_construction(Boolean under_construction) {
    this.under_construction = under_construction;
    return this;
  }
  private Boolean rera;
  public Boolean get_rera() {
    return rera;
  }
  public void set_rera(Boolean rera) {
    this.rera = rera;
  }
  public property_details with_rera(Boolean rera) {
    this.rera = rera;
    return this;
  }
  private Integer bhk_no;
  public Integer get_bhk_no() {
    return bhk_no;
  }
  public void set_bhk_no(Integer bhk_no) {
    this.bhk_no = bhk_no;
  }
  public property_details with_bhk_no(Integer bhk_no) {
    this.bhk_no = bhk_no;
    return this;
  }
  private String bhk_or_rk;
  public String get_bhk_or_rk() {
    return bhk_or_rk;
  }
  public void set_bhk_or_rk(String bhk_or_rk) {
    this.bhk_or_rk = bhk_or_rk;
  }
  public property_details with_bhk_or_rk(String bhk_or_rk) {
    this.bhk_or_rk = bhk_or_rk;
    return this;
  }
  private java.math.BigDecimal square_ft;
  public java.math.BigDecimal get_square_ft() {
    return square_ft;
  }
  public void set_square_ft(java.math.BigDecimal square_ft) {
    this.square_ft = square_ft;
  }
  public property_details with_square_ft(java.math.BigDecimal square_ft) {
    this.square_ft = square_ft;
    return this;
  }
  private Boolean ready_to_move;
  public Boolean get_ready_to_move() {
    return ready_to_move;
  }
  public void set_ready_to_move(Boolean ready_to_move) {
    this.ready_to_move = ready_to_move;
  }
  public property_details with_ready_to_move(Boolean ready_to_move) {
    this.ready_to_move = ready_to_move;
    return this;
  }
  private Boolean resale;
  public Boolean get_resale() {
    return resale;
  }
  public void set_resale(Boolean resale) {
    this.resale = resale;
  }
  public property_details with_resale(Boolean resale) {
    this.resale = resale;
    return this;
  }
  private String address;
  public String get_address() {
    return address;
  }
  public void set_address(String address) {
    this.address = address;
  }
  public property_details with_address(String address) {
    this.address = address;
    return this;
  }
  private java.math.BigDecimal longitude;
  public java.math.BigDecimal get_longitude() {
    return longitude;
  }
  public void set_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
  }
  public property_details with_longitude(java.math.BigDecimal longitude) {
    this.longitude = longitude;
    return this;
  }
  private java.math.BigDecimal latitude;
  public java.math.BigDecimal get_latitude() {
    return latitude;
  }
  public void set_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
  }
  public property_details with_latitude(java.math.BigDecimal latitude) {
    this.latitude = latitude;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof property_details)) {
      return false;
    }
    property_details that = (property_details) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.posted_by == null ? that.posted_by == null : this.posted_by.equals(that.posted_by));
    equal = equal && (this.under_construction == null ? that.under_construction == null : this.under_construction.equals(that.under_construction));
    equal = equal && (this.rera == null ? that.rera == null : this.rera.equals(that.rera));
    equal = equal && (this.bhk_no == null ? that.bhk_no == null : this.bhk_no.equals(that.bhk_no));
    equal = equal && (this.bhk_or_rk == null ? that.bhk_or_rk == null : this.bhk_or_rk.equals(that.bhk_or_rk));
    equal = equal && (this.square_ft == null ? that.square_ft == null : this.square_ft.equals(that.square_ft));
    equal = equal && (this.ready_to_move == null ? that.ready_to_move == null : this.ready_to_move.equals(that.ready_to_move));
    equal = equal && (this.resale == null ? that.resale == null : this.resale.equals(that.resale));
    equal = equal && (this.address == null ? that.address == null : this.address.equals(that.address));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof property_details)) {
      return false;
    }
    property_details that = (property_details) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.posted_by == null ? that.posted_by == null : this.posted_by.equals(that.posted_by));
    equal = equal && (this.under_construction == null ? that.under_construction == null : this.under_construction.equals(that.under_construction));
    equal = equal && (this.rera == null ? that.rera == null : this.rera.equals(that.rera));
    equal = equal && (this.bhk_no == null ? that.bhk_no == null : this.bhk_no.equals(that.bhk_no));
    equal = equal && (this.bhk_or_rk == null ? that.bhk_or_rk == null : this.bhk_or_rk.equals(that.bhk_or_rk));
    equal = equal && (this.square_ft == null ? that.square_ft == null : this.square_ft.equals(that.square_ft));
    equal = equal && (this.ready_to_move == null ? that.ready_to_move == null : this.ready_to_move.equals(that.ready_to_move));
    equal = equal && (this.resale == null ? that.resale == null : this.resale.equals(that.resale));
    equal = equal && (this.address == null ? that.address == null : this.address.equals(that.address));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.posted_by = JdbcWritableBridge.readString(2, __dbResults);
    this.under_construction = JdbcWritableBridge.readBoolean(3, __dbResults);
    this.rera = JdbcWritableBridge.readBoolean(4, __dbResults);
    this.bhk_no = JdbcWritableBridge.readInteger(5, __dbResults);
    this.bhk_or_rk = JdbcWritableBridge.readString(6, __dbResults);
    this.square_ft = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.ready_to_move = JdbcWritableBridge.readBoolean(8, __dbResults);
    this.resale = JdbcWritableBridge.readBoolean(9, __dbResults);
    this.address = JdbcWritableBridge.readString(10, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(12, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.posted_by = JdbcWritableBridge.readString(2, __dbResults);
    this.under_construction = JdbcWritableBridge.readBoolean(3, __dbResults);
    this.rera = JdbcWritableBridge.readBoolean(4, __dbResults);
    this.bhk_no = JdbcWritableBridge.readInteger(5, __dbResults);
    this.bhk_or_rk = JdbcWritableBridge.readString(6, __dbResults);
    this.square_ft = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.ready_to_move = JdbcWritableBridge.readBoolean(8, __dbResults);
    this.resale = JdbcWritableBridge.readBoolean(9, __dbResults);
    this.address = JdbcWritableBridge.readString(10, __dbResults);
    this.longitude = JdbcWritableBridge.readBigDecimal(11, __dbResults);
    this.latitude = JdbcWritableBridge.readBigDecimal(12, __dbResults);
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
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(posted_by, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(under_construction, 3 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(rera, 4 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(bhk_no, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(bhk_or_rk, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(square_ft, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBoolean(ready_to_move, 8 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(resale, 9 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(address, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 12 + __off, 2, __dbStmt);
    return 12;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(posted_by, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBoolean(under_construction, 3 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(rera, 4 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeInteger(bhk_no, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(bhk_or_rk, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(square_ft, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBoolean(ready_to_move, 8 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeBoolean(resale, 9 + __off, -7, __dbStmt);
    JdbcWritableBridge.writeString(address, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(longitude, 11 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(latitude, 12 + __off, 2, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.posted_by = null;
    } else {
    this.posted_by = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.under_construction = null;
    } else {
    this.under_construction = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.rera = null;
    } else {
    this.rera = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.bhk_no = null;
    } else {
    this.bhk_no = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.bhk_or_rk = null;
    } else {
    this.bhk_or_rk = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.square_ft = null;
    } else {
    this.square_ft = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ready_to_move = null;
    } else {
    this.ready_to_move = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.resale = null;
    } else {
    this.resale = Boolean.valueOf(__dataIn.readBoolean());
    }
    if (__dataIn.readBoolean()) { 
        this.address = null;
    } else {
    this.address = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.longitude = null;
    } else {
    this.longitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.latitude = null;
    } else {
    this.latitude = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.posted_by) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, posted_by);
    }
    if (null == this.under_construction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.under_construction);
    }
    if (null == this.rera) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.rera);
    }
    if (null == this.bhk_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.bhk_no);
    }
    if (null == this.bhk_or_rk) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, bhk_or_rk);
    }
    if (null == this.square_ft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.square_ft, __dataOut);
    }
    if (null == this.ready_to_move) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.ready_to_move);
    }
    if (null == this.resale) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.resale);
    }
    if (null == this.address) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, address);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.posted_by) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, posted_by);
    }
    if (null == this.under_construction) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.under_construction);
    }
    if (null == this.rera) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.rera);
    }
    if (null == this.bhk_no) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.bhk_no);
    }
    if (null == this.bhk_or_rk) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, bhk_or_rk);
    }
    if (null == this.square_ft) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.square_ft, __dataOut);
    }
    if (null == this.ready_to_move) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.ready_to_move);
    }
    if (null == this.resale) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeBoolean(this.resale);
    }
    if (null == this.address) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, address);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.longitude, __dataOut);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.latitude, __dataOut);
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
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(posted_by==null?"null":posted_by, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(under_construction==null?"null":"" + under_construction, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rera==null?"null":"" + rera, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bhk_no==null?"null":"" + bhk_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bhk_or_rk==null?"null":bhk_or_rk, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(square_ft==null?"null":square_ft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ready_to_move==null?"null":"" + ready_to_move, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(resale==null?"null":"" + resale, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(address==null?"null":address, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(posted_by==null?"null":posted_by, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(under_construction==null?"null":"" + under_construction, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rera==null?"null":"" + rera, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bhk_no==null?"null":"" + bhk_no, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(bhk_or_rk==null?"null":bhk_or_rk, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(square_ft==null?"null":square_ft.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ready_to_move==null?"null":"" + ready_to_move, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(resale==null?"null":"" + resale, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(address==null?"null":address, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude.toPlainString(), delimiters));
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.posted_by = null; } else {
      this.posted_by = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.under_construction = null; } else {
      this.under_construction = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rera = null; } else {
      this.rera = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bhk_no = null; } else {
      this.bhk_no = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.bhk_or_rk = null; } else {
      this.bhk_or_rk = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.square_ft = null; } else {
      this.square_ft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ready_to_move = null; } else {
      this.ready_to_move = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.resale = null; } else {
      this.resale = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.address = null; } else {
      this.address = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.posted_by = null; } else {
      this.posted_by = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.under_construction = null; } else {
      this.under_construction = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rera = null; } else {
      this.rera = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.bhk_no = null; } else {
      this.bhk_no = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.bhk_or_rk = null; } else {
      this.bhk_or_rk = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.square_ft = null; } else {
      this.square_ft = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ready_to_move = null; } else {
      this.ready_to_move = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.resale = null; } else {
      this.resale = BooleanParser.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.address = null; } else {
      this.address = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.longitude = null; } else {
      this.longitude = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.latitude = null; } else {
      this.latitude = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    property_details o = (property_details) super.clone();
    return o;
  }

  public void clone0(property_details o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("posted_by", this.posted_by);
    __sqoop$field_map.put("under_construction", this.under_construction);
    __sqoop$field_map.put("rera", this.rera);
    __sqoop$field_map.put("bhk_no", this.bhk_no);
    __sqoop$field_map.put("bhk_or_rk", this.bhk_or_rk);
    __sqoop$field_map.put("square_ft", this.square_ft);
    __sqoop$field_map.put("ready_to_move", this.ready_to_move);
    __sqoop$field_map.put("resale", this.resale);
    __sqoop$field_map.put("address", this.address);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("latitude", this.latitude);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("posted_by", this.posted_by);
    __sqoop$field_map.put("under_construction", this.under_construction);
    __sqoop$field_map.put("rera", this.rera);
    __sqoop$field_map.put("bhk_no", this.bhk_no);
    __sqoop$field_map.put("bhk_or_rk", this.bhk_or_rk);
    __sqoop$field_map.put("square_ft", this.square_ft);
    __sqoop$field_map.put("ready_to_move", this.ready_to_move);
    __sqoop$field_map.put("resale", this.resale);
    __sqoop$field_map.put("address", this.address);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("latitude", this.latitude);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
