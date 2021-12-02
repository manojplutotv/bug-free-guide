package model.utils;

import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;

public class AvroCommonTypes {

  /** "type": "null" */
  private static final Schema NULL = Schema.create(Schema.Type.NULL);

  /** "type":{"type":"string","avro.java.string":"String"} */
  public static final Schema STRING = Schema.create(Schema.Type.STRING);

  /**
   * {"type":"map","values":{"type":"string","avro.java.string":"String"},"avro.java.string":"String"},
   */
  public static final Schema MAP_OF_STRING = Schema.createMap(STRING);

  /**
   * "type":["null",{"type":"map","values":{"type":"string","avro.java.string":"String"},"avro.java.string":"String"}],
   */
  public static final Schema OPTIONAL_MAP_OF_STRING = Schema.createUnion(NULL, MAP_OF_STRING);

  static {
    STRING.addProp("avro.java.string", "String");
    MAP_OF_STRING.addProp("avro.java.string", "String");
  }

  /** "type": ["null", "string"] */
  public static final Schema OPTIONAL_STRING = Schema.createUnion(NULL, STRING);

  /** "type": "int" */
  public static final Schema INTEGER = Schema.create(Schema.Type.INT);

  /** "type": ["null", "int"] */
  public static final Schema OPTIONAL_INTEGER = Schema.createUnion(NULL, INTEGER);

  /** "type": "float" */
  public static final Schema FLOAT = Schema.create(Schema.Type.FLOAT);

  /** "type": ["null", "float"] */
  public static final Schema OPTIONAL_FLOAT = Schema.createUnion(NULL, FLOAT);

  /** "type": "double" */
  public static final Schema DOUBLE = Schema.create(Schema.Type.DOUBLE);

  /** "type": ["null", "double"] */
  public static final Schema OPTIONAL_DOUBLE = Schema.createUnion(NULL, DOUBLE);

  /** "type": "long" */
  public static final Schema LONG = Schema.create(Schema.Type.LONG);

  /** "type": ["null", "long"] */
  public static final Schema OPTIONAL_LONG = Schema.createUnion(NULL, LONG);

  /** "type": {"type": "long", "logicalType": "timestamp-millis"} */
  public static final Schema TIMESTAMP_MILLIS =
      LogicalTypes.timestampMillis().addToSchema(Schema.create(Schema.Type.LONG));

  /** "type": ["null", {"type" : "long", "logicalType" : "timestamp-millis"}] */
  public static final Schema OPTIONAL_TIMESTAMP_MILLIS = Schema.createUnion(NULL, TIMESTAMP_MILLIS);

  /** "type": "boolean" */
  public static final Schema BOOLEAN = Schema.create(Schema.Type.BOOLEAN);

  /** "type": ["null", "boolean"] */
  public static final Schema OPTIONAL_BOOLEAN = Schema.createUnion(NULL, BOOLEAN);
}
